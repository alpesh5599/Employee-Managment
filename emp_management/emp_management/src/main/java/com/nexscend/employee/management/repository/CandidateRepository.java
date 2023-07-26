package com.nexscend.employee.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nexscend.employee.management.entity.Candidate;
import com.nexscend.employee.management.model.CandidatewithFileModel;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

	@Query(nativeQuery = true, value = "SELECT c.id as id, c.position as position, c.first_name as firstName, c.last_name as lastName, "
			+ "c.email as email, c.contect as contect, c.joining as joining, c.skills as skills, c.comments as comments , d.file_data as fileData, d.name as name, d.type as type FROM Candidate c LEFT JOIN emp_management.document_details d ON c.id = d.candidate_id ")
	List<CandidatewithFileModel> findCandidateModel();

}