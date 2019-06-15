package com.cts.taskmanagerservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.taskmanagerservice.model.Project;
import com.cts.taskmanagerservice.model.Responce;
import com.cts.taskmanagerservice.service.ProjectService;

@RestController
@RequestMapping("/api/taskmanager/project")
public class ProjectController {
	
	Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(path="/addProject", method = RequestMethod.POST )
	public Responce<String> saveProject(@RequestBody Project project){
		Responce<String> responce = null;
		try{
			project=projectService.saveProject(project);
			responce = new Responce<String>(project.getProject().toString(), "Success", "200");
		}catch(Exception e){
			LOGGER.error("Error occured while saving Project Details");
			responce = new Responce<String>(null, "FAIL", "000");
		}
		return responce;	
	}
	
	@RequestMapping(path="/getProjects", method = RequestMethod.POST)
	public Responce<List<Project>> getProjects(){
		Responce<List<Project>> responce = null;
		try{
			List<Project> projectList = projectService.getProjects();
			responce = new Responce<List<Project>>(projectList, "SUCCESS", "200");
		}catch(Exception e){
			e.printStackTrace();
			responce = new Responce<List<Project>>(null, "FAIL", "000");
		}
		return responce;
	}
}
