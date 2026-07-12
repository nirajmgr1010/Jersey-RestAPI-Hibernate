package com.niraj.resource;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Kulshingh {
   
	private String name;
	private int id;
	private int point;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Kulshingh [name=" + name + ", id=" + id + ", point=" + point + "]";
	}
	
	
}
