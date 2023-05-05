package com.fairoah.lib;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.fairoah.diploma_stuff.repo.models.Task;
import com.fairoah.diploma_stuff.service.TaskQueueService;



public class TasksList {
	
	private static ArrayList<Task> tasksList;
	
	
	public static <T> ArrayList<Task> init(T dataBase) {	
		DataBaseAccess<?> DB = (DataBaseAccess<?>) dataBase;	//TODO: not sure if it's right
		
		return (ArrayList<Task>) DB.getAllTasks();
		
	}
}
