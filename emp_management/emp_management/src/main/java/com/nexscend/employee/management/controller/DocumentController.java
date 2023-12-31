package com.nexscend.employee.management.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nexscend.employee.management.model.ResponseBean;
import com.nexscend.employee.management.service.DocumentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/document")
@CrossOrigin("*")
public class DocumentController {

	private static final long MAX_TOTAL_FILES_SIZE = DataSize.ofMegabytes(10).toBytes(); // Maximum total size allowed (in bytes)
	private static final long MAX_TOTAL_FILE_SIZE = DataSize.ofMegabytes(2).toBytes(); // Maximum total size allowed (in bytes)

	@Autowired
	DocumentService documentService;
	

	@PostMapping("file/upload")
	public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file, @RequestParam("id") String id) {

		if (file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new HashMap<>().put("response", "File is not found"));
		}

		Map<String, String> saveResume = documentService.saveDocument(file, id);

		return ResponseEntity.status(HttpStatus.CREATED).body(saveResume);

	}

	@PostMapping("addFiles")
	public ResponseEntity<Object> upload(@RequestParam("files") List<MultipartFile> files) {

		long totalSize = 0;

		// Saved File Names saved in this list 
		List<String> filesNames = new ArrayList<>();
		
		// The files which size is exceed the file size limit.
		List<String> exceedFilesNames = new ArrayList<>();
		
		if (files.isEmpty() || files == null || (files.size() == 1 && files.get(0).getSize() == 0)) {
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("response", "No file hasbeen chosen or chosen file has no content");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
		}
		
		
		for (MultipartFile multipartFile : files) {
			if (multipartFile.getSize() <= MAX_TOTAL_FILE_SIZE) {
				totalSize += multipartFile.getSize();
				documentService.saveDocument(multipartFile);
				filesNames.add(multipartFile.getOriginalFilename());
			} else {
//				totalSize += multipartFile.getSize();
				exceedFilesNames.add(multipartFile.getOriginalFilename());
			}
		}
		
		if(totalSize > MAX_TOTAL_FILES_SIZE) {
			// Total size exceeds the maximum limit
			String message = "Total file size exceeds the allowed limit of " + DataSize.ofBytes(MAX_TOTAL_FILES_SIZE).toMegabytes() + " MB.";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		}else if (!exceedFilesNames.isEmpty()) {
			// Individual file size exceeds the maximum limit
			String message = "The following files exceed the maximum size limit: " + String.join(", ", exceedFilesNames);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		}
		
//		files.stream().forEach(file -> {
//			documentService.saveDocument(file);
//			fileNames.add(file.getOriginalFilename());
//		});

		return ResponseEntity.status(HttpStatus.CREATED).body("Uploaded the files successfully:"+filesNames);

	}
	
	@PostMapping("addFile")
	public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file) {

		if (file.isEmpty()) {
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("response", "No file hasbeen chosen or chosen file has no content");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
		}

		Object saveResume = documentService.saveDocument(file);

		return ResponseEntity.status(HttpStatus.CREATED).body(saveResume);

	}

//	@PostMapping("addMultipleFile")
//	public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file){
//		
//		if (file.isEmpty()) {
//			Map<String, String> responseMap= new HashMap<String,String>();
//			responseMap.put("response", "No file hasbeen chosen or chosen file has no content");
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
//		}
//		
//		Object saveResume = fileService.saveFile(file);
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body(saveResume);
//		
//	}
	
	
	@PostMapping("/upload")
	public ResponseEntity<Object> uploadFile(HttpServletRequest request) throws IOException {
		Map<String, String> responseMap = null;
		if (request == null) {
			responseMap = new HashMap<String, String>();
			responseMap.put("response", "No file hasbeen chosen or chosen file has no content");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
		}
		
		try {
			InputStream inputStream = request.getPart("files").getInputStream();
			String contentType = request.getContentType();
			int contentLength = request.getContentLength();

			responseMap = documentService.saveDocument(request.getPart("files"), inputStream, contentType, contentLength);
			
		} catch (IOException | ServletException e) {
			System.err.println(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
	}
	
	@PostMapping("/upload1")
	public ResponseEntity<Object> uploadFile(@RequestBody byte[] fileBytes) {
		if (fileBytes == null || fileBytes.length == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
		}
		Map<String, String> saveDocument = documentService.saveDocument(fileBytes);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveDocument);
	}
	
	
	@GetMapping("/files/{id}")
	public ResponseBean getFile(@PathVariable Integer id) {
		ResponseBean fileDB = documentService.getFile(id);
		return fileDB;
	}
	
	
	
}