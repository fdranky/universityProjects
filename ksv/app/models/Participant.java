package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Participant extends Model {
	public String emailAddress;
	@ManyToOne
	public Questionnaire questionnaire;

	public Participant(String emailAddress, Questionnaire questionnaire) {
		super();
		this.emailAddress = emailAddress;
		this.questionnaire = questionnaire;
	}

}
