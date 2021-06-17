package com.associationmtm.demo;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.associationmtm.demo.manytomany.entities.Programmer;
import com.associationmtm.demo.manytomany.entities.Project;
import com.associationmtm.demo.manytomany.repository.ProgrammerRepo;

@SpringBootTest
class AssociationManyToManyApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ProgrammerRepo repo;
	
	@Test
	public void testMtMCreateProgrammer() {
		
		Programmer programmer1 = new Programmer();
		programmer1.setName("Poonam");
		programmer1.setSalary(44000);
		
		HashSet<Project> project1 = new HashSet<Project>();
		Project p = new Project();
		p.setName("IBM");
		
		project1.add(p);
		
		programmer1.setProjects(project1);
		
		repo.save(programmer1);
		
		// secound entry in table
		Programmer programmer2 = new Programmer();
		programmer2.setName("Pooja");
		programmer2.setSalary(100000);
		
		HashSet<Project> project2 = new HashSet<Project>();
		Project p2 = new Project();
		p2.setName("Barclays");
		
		project2.add(p2);
		
		programmer2.setProjects(project2);
		
		repo.save(programmer2);
		
	}
	
	//Load data : will write a method to load the program and his project data back from the database
	
	@Test
	@Transactional
	public void testMtMLoad() {
		
		Programmer p1 = repo.findById(1).get();
		System.out.println(p1);
		//it is only selecting the programmer details it's not retrieving the project 
		//details because by default on a many to many association it is lazy loading the associated data will be lazily loaded.
		//below code is when hibernate will Load the projects but with lazy loading.
		System.out.println(p1.getProjects());

	}
}
