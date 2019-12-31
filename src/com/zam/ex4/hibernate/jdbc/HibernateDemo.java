package com.zam.ex4.hibernate.jdbc;

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
			
			Student st1 = new Student("Zameer1", "Shaik", "test1@gmail.com");
			
			session.beginTransaction();
			
			session.save(st1);
			
			session.getTransaction().commit();
			
			session = sessionFactory.getCurrentSession();
			
			session.beginTransaction();
			
			Student newStudent = session.get(Student.class, st1.getId());
			
			System.out.println(newStudent);
			
			session.getTransaction().commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sessionFactory.close();
		}
	}
}
