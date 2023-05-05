package com.fairoah.diploma_stuff.repo.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Task {
	@Id
	private long taskID;
	@Column
	private String handler;
	@Column
	private String param;

	protected Task() {
	}
	
	public Task(String handler, String param) {
		this.handler = handler;
		this.param = param;
	}

	@Override
	public String toString() {
		return String.format("Task[taskID=%d,"
				+ " handler='%s',"
				+ " param='%s']",
				taskID, handler, param);
	}

	public long getTaskID() {
		return taskID;
	}

	public void setTaskID(long taskID) {
		this.taskID = taskID;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}


}
