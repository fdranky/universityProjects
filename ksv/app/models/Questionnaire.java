package models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Questionnaire extends Model {
	public String title;
	@ManyToMany
	public Set<Question> questions;
	@OneToMany(mappedBy="questionnaire", cascade = CascadeType.ALL)
	public Set <Participant> participants;
	@ManyToMany(mappedBy="questionnaires")
	public Set<Event> events;
	
	public Questionnaire(String title, int numberOfQuestions) {
		this.title = title;
	}
}
