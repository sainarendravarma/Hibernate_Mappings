package com.aaslin.mappings;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer1
{
	public Answer1() {
		super();
	}
	public Answer1(int answerid, String answer) {
		super();
		this.answerid = answerid;
		this.answer = answer;
	}
	@Id
	private int answerid;
	private String answer;	
	@ManyToOne
	private Question1 question;	
	public Question1 getQuestion() {
		return question;
	}
	public void setQuestion(Question1 question) {
		this.question = question;
	}
	public int getAnswerid() {
		return answerid;
	}
	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}
	public String getAnswer() {
			return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
