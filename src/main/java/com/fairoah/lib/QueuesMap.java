package com.fairoah.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.fairoah.diploma_stuff.repo.models.Task;

public class QueuesMap<T>{

	private static HashMap<String, TaskQueue> queuesMap = new HashMap<String, TaskQueue>();

	public static <T> HashMap<String, TaskQueue> init(/* T dataBase, */ ArrayList<Task> tasks) { // нужен ли dataBase -
																									// вопрос
		// DataBaseAccess<?> DB = (DataBaseAccess<?>) dataBase; //TODO: not sure if it's right

		for (Task task : tasks) {	
			String queueID = task.getHandler(); // queue name(queueID) is the same as task handler name
			if (!queuesMap.containsKey(queueID)) { // there's no existing queue for that type of task, so create it
				queuesMap.put(queueID, new TaskQueue(task));
			} else { // otherwise add task to existing queue
				queuesMap.get(task.getHandler()).add(task);
			}
		}
		return queuesMap;
	}

	

}
