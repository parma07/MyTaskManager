package com.cts.taskmanagerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.taskmanagerservice.model.ParentTask;

public interface ParentTaskRepository extends JpaRepository<ParentTask, Integer>{

}
