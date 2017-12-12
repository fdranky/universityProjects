package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Answer extends Model{
	
	public String answer;
	public boolean correctAnswer;	
	public boolean checked;
	@ManyToOne
	public Question question;
	
	public Answer(String answer, boolean correctAnswer) {
		this.answer = answer;
		this.correctAnswer = correctAnswer;
	}
	
}
