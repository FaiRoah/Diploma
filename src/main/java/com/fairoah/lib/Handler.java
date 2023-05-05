package com.fairoah.lib;

public class Handler {
	private String id;
	Handler(String id){this.id = id;}
	
	@Override
	public String toString() {
		return "[Handler: " + id + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
