package com.zam.ex5.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zam.ex5.hibernate.entity.Course;
import com.zam.ex5.hibernate.entity.Instructor;
import com.zam.ex5.hibernate.entity.InstructorDetail;

public class MappingsDemo {
	
	static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(InstructorDetail.class)
			.addAnnotatedClass(Course.class)
			.buildSessionFactory();
	
	static Session session = factory.getCurrentSession();

	public static void main(String[] args) {
	
		try {
			//Begin Transaction
			System.out.println("Begin Transaction");
			session.beginTransaction();
			
			//Perform the respective Methods
			//performCRUDoperation("delete");
			
			//get the instructor
			Instructor instructor = getInstructor(3);
			Course course1 = new Course("Test Title 1");
			Course course2 = new Course("Test Title 2");
			Course course3 = new Course("Test Title 3");
			
			instructor.addCourse(course1);
			instructor.addCourse(course2);
			instructor.addCourse(course3);
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
			//Commit Transaction
			System.out.println("Commit Transaction");
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("Inside finally, closing all resources");
			session.close();
			factory.close();
		}
	}
	
	private static void performCRUDoperation(String operationType) throws Exception{
		
		switch(operationType) {
			case "create":
				System.out.println("create case invoked");
				Instructor instructor = new Instructor("Name 3", "Shaik", "testing3@gmail.com");			
				InstructorDetail instructorDetail = new InstructorDetail("My Youtube Channel 3","Making Quality Videos 3");
				instructor.setInstructorDetailId(instructorDetail);
				session.save(instructor);
				break;
			case "read":
				System.out.println("read case invoked");
				InstructorDetail instructorDetail2 = session.get(InstructorDetail.class, 2);
				System.out.println("Instructor Detail : " + instructorDetail2);
				System.out.println("Instructor : " + instructorDetail2.getInstructor().toString());
				break;
			case "delete":
				System.out.println("delete case invoked");
				InstructorDetail details1 = session.get(InstructorDetail.class, 2);
				session.delete(details1);
				break;
		}
	}
	/*	
	private static Instructor createInstructor(String firstName, String lastName, String email,
										String youtubeChannel, String hobby) {
		Instructor instructor = new Instructor(firstName, lastName, email);
		InstructorDetail instructorDetail = new InstructorDetail(youtubeChannel, hobby);
		instructor.setInstructorDetailId(instructorDetail);
		session.save(instructor);
		
		return instructor;
	}
	
	private static void deleteInstructor(int id) {
		
	}
	*/
	
	private static Instructor getInstructor(int id) {
		Instructor instructor = session.get(Instructor.class, id);
		return instructor;
	}
	
	public static void createCourse(String title, Instructor instructor) {
		//Instructor instructor = session.get(Instructor.class, 2);
		
		Course newCourse = new Course(title);
		instructor.addCourse(newCourse);
	}
}
