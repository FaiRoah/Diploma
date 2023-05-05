package com.fairoah.lib;

public interface DataBaseAccess <T>{
	T getTask(String handler);
	T getAllTasks();
	
}
