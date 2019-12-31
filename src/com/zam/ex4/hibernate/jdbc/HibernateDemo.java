package com.zam.ex4.hibernate.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zam.ex4.hibernate.entity.Student;

public class HibernateDemo {
	
	public static void main(String args[]) {
	
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//Step 1 : Insert a Record
			/*
			//a. Create a student entity object
			Student st1 = new Student("Zameer1", "Shaik", "test1@gmail.com");
			
			//b. Begin Transaction
			session.beginTransaction();
			
			//c. Save the entity object
			session.save(st1);
			
			//d. Commit the transaction
			session.getTransaction().commit();
			*/
			
			//Step 2 : Retrieve data from database
			/*
			//a. Get Current Session
			session = sessionFactory.getCurrentSession();
			
			//b. Begin Transaction
			session.beginTransaction();
			
			//c. Using the id from the above saved object get the student from the database
			Student newStudent = session.get(Student.class, 1);
			
			//d. Print student
			System.out.println(newStudent);
			
			//e. Commit the transaction
			session.getTransaction().commit();
			*/
			
			//Step 3: HQL example
			//Fetching all the records from the students table and displaying
			
			//a. Get Session
			session = sessionFactory.getCurrentSession();
			
			//b. Begin Transaction
			session.beginTransaction();
			
			//c. Fetch Results
			//String query = "from Student s";  							//Plain Query
			//String query = "from Student s where s.email like '%2%'";		//Single Condition
			String query = "from Student s where s.email like '%2%' OR s.firstName like '%4%'"; //Multiple Conditions
			List<Student> studentsList = session.createQuery(query).getResultList();
			
			//d. Iterate over the results
			for(Student student : studentsList) {
				System.out.println(student);
			}
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sessionFactory.close();
		}
	}
}
