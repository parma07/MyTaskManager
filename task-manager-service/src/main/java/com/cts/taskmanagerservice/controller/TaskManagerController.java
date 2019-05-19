package com.cts.taskmanagerservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.taskmanagerservice.model.Responce;
import com.cts.taskmanagerservice.model.Task;
import com.cts.taskmanagerservice.service.TaskManagerService;

@RestController
@RequestMapping(path="/api/taskmanager")
public class TaskManagerController {

	Logger LOGGER=LoggerFactory.getLogger(TaskManagerController.class);
	@Autowired
	private TaskManagerService taskManagerService;

	@GetMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
	public String ping() {		
		return taskManagerService.ping();
	}
	
	@RequestMapping(path="/saveTask",method =RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Responce<String> saveTask(@RequestBody Task task) throws Exception{
		LOGGER.info("saveTask Entry ", task.getTaskName());
		Responce<String> response;
		try {
			task=taskManagerService.saveTask(task);
			response= new Responce<String>(task.getTaskId().toString(),"SUCCESS", "0");
		}catch(Exception e) {
			//LOGGER.error("Error while persisting task data", e);
			response= new Responce<String>(null,"FAILURE", "1");
		}
		return response;
	}
	
	@RequestMapping(path="/getTasks",method =RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Responce<List<Task>> getTasks() throws Exception{
		LOGGER.info("inside getTasks");
		Responce<List<Task>> response;
		List<Task> list;
		try {
			list=taskManagerService.getTasks();
			System.out.println("lit:"+list);
			LOGGER.info("saveTask Entry ", list);
			response= new Responce<List<Task>>(list,"SUCCESS", "0");
		}catch(Exception e) {
			LOGGER.error("Error while persisting task data", e);
			response= new Responce<List<Task>>(null,"FAILURE", "2");
		}
		return response;
	}
	
	@RequestMapping(path="/getTask",method =RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Responce<Task> getTask(@RequestBody Task task) throws Exception{
		Responce<Task> response;
		try {
			task=taskManagerService.getTask(task.getTaskId());
			LOGGER.error(" getTask ==----------------------->", task);
			response= new Responce<Task>(task,"SUCCESS", "0");
		}catch(Exception e) {
			LOGGER.error("Error while persisting task data", e.toString());
			e.printStackTrace();
			response= new Responce<Task>(null,"FAILURE", "2");
		}
		return response;
	}
	@RequestMapping(path="/updateTaskEditEnabled",method =RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Responce<String> updateTaskEditEnabled(@RequestBody Task task)throws Exception{
		LOGGER.debug("saveTask Entry ", task.getTaskName());
		Responce<String> response;
		try {
			taskManagerService.updateTaskEditEnabled(task);;
			response= new Responce<String>(task.getTaskId().toString(),"SUCCESS", "0");
		}catch(Exception e) {
			LOGGER.error("Error while persisting task data", e);
			response= new Responce<String>(null,"FAILURE", "1");
		}
		return response;
	}
	
}
