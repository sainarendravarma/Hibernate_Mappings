package com.aaslin.mappings;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Question1 
{
	@Id
	private int questionid;
	private String question;		
	@OneToMany(mappedBy="question")
	private List<Answer1> answers;		
	public Question1(int questionid, String question, List<Answer1> answers) {
		super();
		this.questionid = questionid;
		this.question = question;
		this.answers = answers;
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Question1() {
		super();
	}
	public List<Answer1> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer1> list) {
			this.answers = list;
	}
}
