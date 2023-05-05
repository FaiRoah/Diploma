package com.fairoah.diploma_stuff.service;

import java.util.List;
import java.util.Random;

import org.apache.tomcat.util.threads.TaskQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fairoah.diploma_stuff.repo.TaskQueueRepo;
import com.fairoah.diploma_stuff.repo.models.Task;
import com.fairoah.lib.DataBaseAccess;

@Service
public class TaskQueueService implements DataBaseAccess{

	@Autowired
	TaskQueueRepo TQRepo;

	public List<Task> findAll() {
		return TQRepo.findAll();
	}
	
	public void deleteFirstTask() {
		try {
			TQRepo.deleteFirst1();
			System.out.println("Task deleted successfully.");
		}
		catch (Exception ex) {
			System.out.println("Error occured while deleting task:");
			ex.getMessage();
		}
	}
	
	public void addTask(String handler, String param) {
		try {
			TQRepo.save(new Task(handler, param));
			System.out.println("Task saved successfully.");
		}
		catch (Exception ex) {
			System.out.println("Error occured while saving task:");
			ex.getMessage();
		}
	}
	
	public boolean executeFirstTask() {
		Random rand = new Random();
		int chance = rand.nextInt(100) + 1; 
		Task task = TQRepo.findFirst();
		if (chance < 30) {//emulated error executing the task
			Task taskToEnd = new Task(task.getHandler(),task.getParam());
			TQRepo.save(taskToEnd);
			TQRepo.deleteFirst1();
			return false;
		}
		else {	//task can be executed
			TQRepo.deleteFirst1();
			return true;
		}
	}

	public Task findFirst() {
		return TQRepo.findFirst();
	}

	@Override
	public Task getTask(String handler) {
		return TQRepo.findTask(handler);
	}

	@Override
	public List<Task> getAllTasks() {
		return TQRepo.findAll();
		
	}
	
	
}
