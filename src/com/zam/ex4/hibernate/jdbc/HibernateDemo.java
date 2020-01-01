package com.zam.ex4.hibernate.jdbc;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zam.ex4.hibernate.entity.Student;
import com.zam.utils.DateUtils;

public class HibernateDemo {
	
	public static void main(String args[]) {
	
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			//Hibernate CRUD Examples
			
			// C -> CREATE 
			// R -> READ
			// U -> UPDATE
			// D -> DELETE
			
			//Example 1 : CREATE example: Insert a Record
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
			
			//Example 2 : READ example: Retrieve Single Record from database using Entities Primary Key Id
				/*
				//a. Get Current Session
				session = sessionFactory.getCurrentSession();
				
				//b. Begin Transaction
				session.beginTransaction();
				
				//c. Using the id from the above saved object get the student from the database
				Student newStudent = session.get(Student.class, st1.getId());
				
				//d. Print student
				System.out.println(newStudent);
				
				//e. Commit the transaction
				session.getTransaction().commit();
				*/
			
			//Example 3: READ example: Fetching Multiple Records using HQL(Hibernate Query Language) 
				/*
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
				displayStudents(studentsList);
				
				session.getTransaction().commit();
				*/
			
			//Example 4: UPDATE example: Updating single record
				//As the hibernate entities are persistent object so we need not explicitly save it.
				// commit() will automatically save the state of the object
				/*
				session = sessionFactory.getCurrentSession();
				
				session.beginTransaction();
				
				Student toUpdateStudent = session.get(Student.class, 1);
				
				toUpdateStudent.setEmail("testing@oracle.com");
				
				session.getTransaction().commit();
				*/
			
			//Example 5: UPDATE example : Updating multiple records using HQL
				/*
				session = sessionFactory.getCurrentSession();
				
				session.beginTransaction();
				
				session.createQuery("update Student s set s.email = ? where s.firstName like ?")
				.setParameter(0, "newEmail5@gmail.com")
				.setParameter(1, "Zameer5")
				.executeUpdate();
				
				session.getTransaction().commit();
				*/
			
			//Example 6: DELETE example: Deleting Single Record
				/*
				session = sessionFactory.getCurrentSession();
				
				session.beginTransaction();
				
				Student newStudent = session.get(Student.class, 1);
				
				session.delete(newStudent);
				
				session.getTransaction().commit();
				*/
			//Example 7: DELETE example: Deleting Multiple Records
				/*
				session = sessionFactory.getCurrentSession();
				
				session.beginTransaction();
				
				session.createQuery("delete from Student where firstName=?")
				.setParameter(0, "Zameer1")
				.executeUpdate();
				
				session.getTransaction().commit();
				*/
			
			//Example 8: WORKING WITH DATE
			
				session = sessionFactory.getCurrentSession();
				
				session.beginTransaction();
				
				String dob1 = "1/04/1984";
				Date parsedDate = DateUtils.parseDate(dob1);
				
				Student st1 = new Student("Zameer D", "Shaik", parsedDate, "zameer123@gmail.com");
				
				session.save(st1);
				
				session.getTransaction().commit();
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sessionFactory.close();
		}
	}

	private static void displayStudents(List<Student> studentsList) {
		for(Student student : studentsList) {
			System.out.println(student);
		}
	}
}
