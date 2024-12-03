package com.banquemisr.challenge05.controller.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banquemisr.challenge05.controller.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	
	
	
	@Query("SELECT t FROM Task t WHERE (:title IS NULL OR t.title LIKE %:title%) AND "
			+ "	 (:description IS NULL OR t.description LIKE  %:description%) AND "
			+ "(:priority IS NULL OR t.priority = :priority)  AND "
			+ "(:status IS NULL OR t.status = :status) ")
	Page<Task> searchTasks(String title, String description, String priority, String status, Pageable pageable );  
	
}

