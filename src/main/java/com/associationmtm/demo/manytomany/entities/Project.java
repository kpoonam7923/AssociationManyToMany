package com.associationmtm.demo.manytomany.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	//This means that this is the inverse of the relationship which is already defined inside this particular entity programmer.
	//i.e., within Programmer class we have defined "private Set<Project> projects"
	@ManyToMany(mappedBy= "projects")
	private Set<Programmer> programmer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Programmer> getProgrammer() {
		return programmer;
	}
	public void setProgrammer(Set<Programmer> programmer) {
		this.programmer = programmer;
	}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
