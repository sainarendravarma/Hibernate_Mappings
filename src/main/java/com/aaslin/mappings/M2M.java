package com.aaslin.mappings;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*Many to many relationship(student and teacher)*/

public class M2M 
{
	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sf=config.buildSessionFactory();
		Student s1=new Student();
		Student s2=new Student();
		s1.setSid(1);
		s1.setSname("Jyothi");	
		s2.setSid(2);
		s2.setSname("rani");
	
		Teacher t1=new Teacher();
		Teacher t2=new Teacher();

		t1.setTid(01);
		t1.setTname("aparanjini");
		t2.setTid(02);
		t2.setTname("padma");
			
		List<Student>l=new ArrayList<>();
		List<Teacher>l1=new ArrayList<>();
			
		l.add(s1);
		l.add(s2);
		l1.add(t1);
		l1.add(t2);
		s1.setTeachers(l1);
		t1.setStudents(l);
			
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.save(s1);
		s.save(s1);
		s.save(t1);
		s.save(t2);
		tx.commit();
	}
}
