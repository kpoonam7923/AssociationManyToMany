package com.associationmtm.demo.manytomany.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Programmer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int salary;
	
	//will have a cascading effect. That is we can create programmers on projects at the same time 
	//we can delete them at the same time if required
	// for Enabling Eager fetching :- 
	//@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	
	//By default Lazy fetching
	@ManyToMany(cascade = CascadeType.ALL)
	//Joined table
	// Joined Table
	// The INVERSE JOIN columns specify about the join columns from the other table in the many to many relationship, here id from Project table
	@JoinTable(name = "programmer_project",
	joinColumns = @JoinColumn(name="programmer_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="project_id", referencedColumnName = "id") )
	private Set<Project> projects;
	
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
	@Override
	public String toString() {
		return "Programmer [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
}
