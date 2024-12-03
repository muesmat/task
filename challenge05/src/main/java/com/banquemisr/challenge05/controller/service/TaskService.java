package com.banquemisr.challenge05.controller.service;

import java.util.List;

import com.banquemisr.challenge05.resource.inbound.PageInfo;
import com.banquemisr.challenge05.resource.inbound.TaskCreateRequest;
import com.banquemisr.challenge05.resource.inbound.TaskQueryParameters;
import com.banquemisr.challenge05.resource.inbound.TaskUpdateRequest;
import com.banquemisr.challenge05.resource.outbound.TaskDetailsResponse;

public interface TaskService {
	
	public TaskDetailsResponse createTask(TaskCreateRequest taskCreateRequest);
	public TaskDetailsResponse updateTask(Long id, TaskUpdateRequest taskUpdateRequest);
	public TaskDetailsResponse getTaskById(Long Id);
	public List<TaskDetailsResponse> getAllTasks(PageInfo pageInfo);
	public List<TaskDetailsResponse> search(TaskQueryParameters taskQueryParameters);
	public void deleteTask(Long id);
	
	
	

}
