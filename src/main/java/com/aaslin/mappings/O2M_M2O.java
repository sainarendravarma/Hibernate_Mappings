package com.aaslin.mappings;
	/*2.Similar program using one to many relation ship*/
	/*3.Similar program using many to one relation ship*/
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class O2M_M2O 
{
	public static void main(String[] args) 
	{
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sf=config.buildSessionFactory();
			
		Question1 q1=new Question1();
		q1.setQuestionid(1);
		q1.setQuestion("what is java?");
			
		Answer1 a=new Answer1();
		a.setAnswerid(01);
		a.setAnswer("Java is a partial object oriented programming language");
		a.setQuestion(q1);
			
		Answer1 a1=new Answer1();
		a1.setAnswerid(02);
		a1.setAnswer("java is used for creating softwares");
		a1.setQuestion(q1);
			
		List<Answer1>list=new ArrayList<>();
		list.add(a);
		list.add(a1);
		q1.setAnswers(list);
			
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.save(q1);
		s.save(a);
		s.save(a1);
		tx.commit();
			
		//fetching the data
		Question1 q=(Question1)s.get(Question1.class,1);
		System.out.println(q.getQuestion());
		for(Answer1 a2:q.getAnswers())
		{
			System.out.println(a2.getAnswer());
		}
			
	}
}
