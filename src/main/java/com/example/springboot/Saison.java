package com.example.springboot;

public class Saison {
	private String name;
	private boolean current;

	public Saison(String name, boolean current) {
		this.name = name;
		this.current = current;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isCurrent() {
		return current;
	}
	public void setCurrent(boolean current) {
		this.current = current;
	}
}