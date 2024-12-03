package com.banquemisr.challenge05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquemisr.challenge05.resource.inbound.PageInfo;
import com.banquemisr.challenge05.resource.inbound.TaskCreateRequest;
import com.banquemisr.challenge05.resource.inbound.TaskQueryParameters;
import com.banquemisr.challenge05.resource.inbound.TaskUpdateRequest;
import com.banquemisr.challenge05.resource.outbound.TaskDetailsResponse;
import com.banquemisr.challenge05.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/tasks")
	public ResponseEntity<List<TaskDetailsResponse>> getAllTasks(PageInfo pageInfo) {
		
		List<TaskDetailsResponse> TaskDetailsResponseList = taskService.getAllTasks(pageInfo);
		return ResponseEntity.ok(TaskDetailsResponseList);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/tasks")
	public ResponseEntity<TaskDetailsResponse> createTask(@RequestBody @Valid TaskCreateRequest taskCreateRequest) {		
		TaskDetailsResponse taskDetailsResponse = taskService.createTask(taskCreateRequest);	
		return ResponseEntity.ok(taskDetailsResponse);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/tasks/search")
	public ResponseEntity<List<TaskDetailsResponse>> searchTasks(@Valid TaskQueryParameters taskQueryParameters) {
		List<TaskDetailsResponse> TaskDetailsResponseList = taskService.search(taskQueryParameters);
		return ResponseEntity.ok(TaskDetailsResponseList);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	@GetMapping("/tasks/{id}")
	public ResponseEntity<TaskDetailsResponse> getTaskById(@PathVariable Long id) {
		TaskDetailsResponse taskDetailsResponse = taskService.getTaskById(id);			
		return ResponseEntity.ok(taskDetailsResponse);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	@PutMapping("/tasks/{id}")
	public ResponseEntity<TaskDetailsResponse> updateTask(@PathVariable Long id,
			@RequestBody @Valid TaskUpdateRequest taskUpdateRequest) {
		TaskDetailsResponse taskDetailsResponse = taskService.updateTask(id, taskUpdateRequest);			
		return ResponseEntity.ok(taskDetailsResponse);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
