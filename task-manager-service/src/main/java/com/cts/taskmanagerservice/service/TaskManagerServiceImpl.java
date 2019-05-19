package com.cts.taskmanagerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cts.taskmanagerservice.model.Task;
import com.cts.taskmanagerservice.repository.TaskRepository;

@Service
public class TaskManagerServiceImpl implements TaskManagerService{

	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public String ping() {
		return "Pinged";
	}

	@Override
	public Task saveTask(Task task) throws DataAccessException {
		task = taskRepository.save(task); 
		return task;
	}

	@Override
	public List<Task> getTasks() throws DataAccessException {
		return taskRepository.findAll();
	}

	@Override
	public Task getTask(Integer taskId) {		
		Optional<Task> task = taskRepository.findById(taskId);
		return task.isPresent()?task.get():null;
	}

	@Override
	public void updateTaskEditEnabled(Task task) {
		taskRepository.updateTaskEditEnabled(task.getEditEnabled(), task.getTaskId());		
	}

	
}
