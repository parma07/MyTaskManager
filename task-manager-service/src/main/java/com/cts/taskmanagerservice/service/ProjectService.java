package com.cts.taskmanagerservice.service;

import java.util.List;

import com.cts.taskmanagerservice.model.Project;

public interface ProjectService {
	public Project saveProject(Project project);
	public List<Project> getProjects();
}
