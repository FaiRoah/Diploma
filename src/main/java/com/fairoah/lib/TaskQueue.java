package com.fairoah.lib;

import java.util.ArrayList;

import com.fairoah.diploma_stuff.repo.models.Task;

public class TaskQueue {
	private String taskQueueID;

	private ArrayList<Task> tasksList;

	TaskQueue(String taskHandlerName) {
		this.taskQueueID = taskHandlerName;
	};

	TaskQueue(Task task) {
		tasksList = new ArrayList<Task>();
		this.taskQueueID = task.getHandler();
		this.tasksList.add(task);
	}

	public void add(Task task) {
		tasksList.add(task);
	}

	public ArrayList<Task> getTasksList() {
		return tasksList;
	}

	public void setTasksList(ArrayList<Task> tasksList) {
		this.tasksList = tasksList;
	}

}
