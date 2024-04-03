package com.aaslin.mappings;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*Using one to one relation(hibernate) fetch the from the DB*/
/*
 * author:Jyothi
 */

public class O2O
{
	public static void main(String[] args)
	{
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sf=config.buildSessionFactory();
			
		Question q1=new Question();
		q1.setQuestionid(1);
		q1.setQuestion("what is java?");
			
		Answer a=new Answer();
		a.setAnswerid(111);
		a.setAnswer("Java is a partial object oriented programming language");
		q1.setAnswer(a);
			
		Question q2=new Question();
		q2.setQuestionid(2);
		q2.setQuestion("what is python?");
			
		Answer a1=new Answer();
		a1.setAnswerid(222);
		a1.setAnswer("python is a complete object oriented programming language");
		q2.setAnswer(a1);
		
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.save(q1);
		s.save(q2);
		s.save(a);
		s.save(a1);
		tx.commit();
		//to fetch the data
		Question nq=(Question)s.get(Question.class, 1);
		System.out.println(nq.getQuestion());
		System.out.println(nq.getAnswer().getAnswer());
		}
}
