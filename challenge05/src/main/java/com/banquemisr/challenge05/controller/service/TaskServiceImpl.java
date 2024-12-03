package com.banquemisr.challenge05.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.banquemisr.challenge05.controller.exception.TaskNotFoundException;
import com.banquemisr.challenge05.controller.model.Task;
import com.banquemisr.challenge05.controller.repository.TaskRepository;
import com.banquemisr.challenge05.resource.inbound.PageInfo;
import com.banquemisr.challenge05.resource.inbound.TaskCreateRequest;
import com.banquemisr.challenge05.resource.inbound.TaskQueryParameters;
import com.banquemisr.challenge05.resource.inbound.TaskUpdateRequest;
import com.banquemisr.challenge05.resource.outbound.TaskDetailsResponse;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public TaskDetailsResponse createTask(TaskCreateRequest taskCreateRequest) {
		
		// create the task model from the request
		Task task = new Task();
		task.setTitle(taskCreateRequest.getTitle());
		task.setDescription(taskCreateRequest.getDescription());
		task.setStatus("TODO");
		task.setPriority(taskCreateRequest.getPriority());
		task.setDueDate(taskCreateRequest.getDueDate());
		
		// save the task
		Task savedTask = taskRepository.save(task);
			
		return buildTaskDetailsResponse(savedTask);
	}

	@Override
	public TaskDetailsResponse updateTask(Long id, TaskUpdateRequest taskUpdateRequest) {
		Task savedTask = getTaskByIdFromRepo(id);
		
		
		// don't override null fields
		if(taskUpdateRequest.getTitle() != null && !taskUpdateRequest.getTitle().isBlank()) {
			savedTask.setTitle(taskUpdateRequest.getTitle());
		}
		
		if(taskUpdateRequest.getDescription() != null && !taskUpdateRequest.getDescription().isBlank()) {
			savedTask.setDescription(taskUpdateRequest.getDescription());
		}
		
		if(taskUpdateRequest.getStatus() != null && !taskUpdateRequest.getStatus().isBlank()) {
			savedTask.setStatus(taskUpdateRequest.getStatus());
		}
		
		if(taskUpdateRequest.getPriority() != null && !taskUpdateRequest.getPriority().isBlank()) {
			savedTask.setPriority(taskUpdateRequest.getPriority());
		}
		
		if(taskUpdateRequest.getDueDate() != null) {
			savedTask.setDueDate(taskUpdateRequest.getDueDate());
		}
				
		savedTask = taskRepository.save(savedTask);
		
		return buildTaskDetailsResponse(savedTask);
	}
	
	@Override
	public TaskDetailsResponse getTaskById(Long id) {
		Task savedTask = getTaskByIdFromRepo(id);
		return buildTaskDetailsResponse(savedTask);
	}

	@Override
	public List<TaskDetailsResponse> getAllTasks(PageInfo pageInfo) {
		Pageable paging = PageRequest.of(pageInfo.getOffset() == null ? 0 : pageInfo.getOffset(), pageInfo.getPageSize() == null ? 10 : pageInfo.getPageSize());
		List<Task> tasks = taskRepository.findAll(paging).toList();	
		return buildTaskDetailsResponse(tasks);
	}
	
	
	@Override
	public List<TaskDetailsResponse> search(TaskQueryParameters taskQueryParameters) {
		Pageable paging = PageRequest.of(taskQueryParameters.getOffset() == null ? 0 : taskQueryParameters.getOffset(), 
				taskQueryParameters.getPageSize() == null ? 10 : taskQueryParameters.getPageSize());
		List<Task> tasks = taskRepository.searchTasks(taskQueryParameters.getTitle(), taskQueryParameters.getDescription(), taskQueryParameters.getPriority(), taskQueryParameters.getStatus(), paging).toList();	
		return buildTaskDetailsResponse(tasks);
	}

	@Override
	public void deleteTask(Long id) {
		Task savedTask = getTaskByIdFromRepo(id);
		taskRepository.delete(savedTask);
	}
	
		
	private Task getTaskByIdFromRepo(Long id) {
		return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not exist with ids" + id));
	}
	
	
	private TaskDetailsResponse buildTaskDetailsResponse(Task task) {
		TaskDetailsResponse taskDetailsResponse = new TaskDetailsResponse();
		taskDetailsResponse.setId(task.getId());
		taskDetailsResponse.setTitle(task.getTitle());
		taskDetailsResponse.setDescription(task.getDescription());
		taskDetailsResponse.setStatus(task.getStatus());
		taskDetailsResponse.setPriority(task.getPriority());
		taskDetailsResponse.setDueDate(task.getDueDate());
		return taskDetailsResponse;			
	}
	
	private List<TaskDetailsResponse> buildTaskDetailsResponse(List<Task> tasks) {
		List<TaskDetailsResponse> taskDetailsResponseList = new ArrayList<>();		
		for(Task task : tasks) {
			taskDetailsResponseList.add(buildTaskDetailsResponse(task));
		}		
		return taskDetailsResponseList;		
	}
}
