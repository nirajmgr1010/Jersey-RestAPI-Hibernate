package com.Repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.enitites.Student;
import com.hibernate.util.*;


public class StudentRepos {
	
	   SessionFactory factory = hibernateutil.getSessionFactory();
	   
	   
	   public void create(Student s) {
		   Session Sess = factory.openSession();
		   Transaction tr = null;
		    try {
		    	tr = Sess.beginTransaction();
		    	Sess.persist(s);
		    	tr.commit();
		    }catch(Exception e) {
		    	
		    	if(tr != null) {
		    		tr.rollback();
		    	}
		    	e.printStackTrace();
		    }finally {
		    	Sess.close();
		    }
	   }
	 
	   public List<Student> getStudents(){
		   Session Sess = factory.openSession();
		   
		     try {
		    	 String hql = "from Student";
		    	 
		    	 Query<Student> query = Sess.createQuery(hql,Student.class);
		    	 List<Student> list = query.getResultList();
		    	 
		    	 return list;
		    	 
		     }catch(Exception e) {
		    	 
		    	 e.printStackTrace();
		     }finally {
		    	 Sess.close();
		     }

			   return null;
	   }
	   
	   public Student getStudent(int id){
		   Session Sess = factory.openSession();
		   
		     Student s = Sess.find(Student.class, id);
		     Sess.close();
		     return s;
	   }
	   
	   public void Update(Student s) {
		   Session session = factory.openSession();
		   Transaction tr = null;
		   try {
			   tr = session.beginTransaction();
			   session.merge(s);
			   tr.commit();
		   }catch(Exception e) {
			   if(tr != null) {
				   tr.rollback();
			   }
			   e.printStackTrace();
		   }finally {
			   session.close();
		   }
	   }
	   
	   public void Delete(int id) {
		   Session session = factory.openSession();
		   Transaction tr = null;
		   
		   try {
			   
			   tr = session.beginTransaction();
			   String hql = "delete from Student where id =:id";
			   
			   MutationQuery query = session.createMutationQuery(hql);
			   query.setParameter("id", id);
			   query.executeUpdate();
			   tr.commit();
			 
		   }catch(Exception e) {
			   if(tr != null) {
				   tr.rollback();
			   }
			   e.printStackTrace();
		   }finally {
			   session.close();
		   }
	   }
	   
	   
	   
	   
	   
	   
}
