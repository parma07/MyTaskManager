package com.cts.taskmanagerservice.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cts.taskmanagerservice.model.Task;


public interface TaskManagerService {

	String ping();
	Task saveTask(Task task) throws DataAccessException;
	List<Task> getTasks() throws DataAccessException;
	Task getTask(Integer taskId);
	void updateTaskEditEnabled(Task task);
}
