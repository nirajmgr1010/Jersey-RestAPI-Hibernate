package com.niraj.resource;

import java.util.List;

import com.Repos.StudentRepos;
import com.enitites.Student;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("student")
public class StudentResource {

	StudentRepos Repo = new StudentRepos();
	
	@POST
	@Path("student")
 @Consumes(MediaType.APPLICATION_JSON)
	public void Create(Student s) {
		
		Repo.create(s);
	}
	
	@GET
	@Path("student")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudent(){
		  return Repo.getStudents();
	}
	
	@GET
	@Path("student/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentByid(@PathParam("id") int id){
		  return Repo.getStudent(id);
	}
	
	@PUT
	@Path("student")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Student Update(Student s) {
		Repo.Update(s);
		return s;
	}
	
	@DELETE
	@Path("student/{id}")
	  @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Student DeleteById(@PathParam("id") int id){
		  Student s = Repo.getStudent(id);
		  
		  if(s.getId() != 0) {
			  Repo.Delete(id);
		  }
		  
		  return s;
	}
}
