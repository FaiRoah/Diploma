package com.fairoah.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.fairoah.diploma_stuff.repo.models.Task;

public class Lib {

	private static ConfigurableApplicationContext appContext;

	private static ArrayList<Task> taskList;
	private static ArrayList<Handler> handlerList;
	private static HashMap<String, TaskQueue> queueMap;

	public static <T> void init(ConfigurableApplicationContext apc, T dataBase) {
		setAppContext(apc);
		setHandlerList(HandlersList.init(apc));
		setTaskList(TasksList.init(dataBase));
		setQueueMap(QueuesMap.init(taskList));
//		apc.addApplicationListener(null);
		ExecutorService executorService = Executors.newFixedThreadPool(handlerList.size());		//create a thread for each handler
		for (Handler h : handlerList) {
			executorService.execute(new HandlerThread(h.getId()));
			
		}
		
		executorService.shutdown();
	}

	public static ConfigurableApplicationContext getAppContext() {
		return appContext;
	}

	public static void setAppContext(ConfigurableApplicationContext appContext) {
		Lib.appContext = appContext;
	}

	public static ArrayList<Task> getTaskList() {
		return taskList;
	}

	public static void setTaskList(ArrayList<Task> taskList) {
		Lib.taskList = taskList;
	}

	public static ArrayList<Handler> getHandlerList() {
		return handlerList;
	}

	public static void setHandlerList(ArrayList<Handler> handlerList) {
		Lib.handlerList = handlerList;
	}

	public static void setQueueMap(HashMap<String, TaskQueue> queueMap) {
		Lib.queueMap = queueMap;
	}

	public static HashMap<String, TaskQueue> getQueueMap() {
		return queueMap;
	}

}

class HandlerThread extends Thread {
	String handlerId;
	
	public HandlerThread(String name) {
		this.handlerId = name;
	}
	
	public void run() {
		System.out.println("Handler " + handlerId + " is processing the task" );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Handler " + handlerId + " has processed the task" );
	}
}

