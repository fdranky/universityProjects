package models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import net.sf.oval.constraint.MaxSize;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Question extends Model {
	@Lob
	@Required
	@MaxSize(1000)
	public String question;

	@ManyToMany(mappedBy = "questions")
	public Set<Questionnaire> questionnaires;
	@ManyToOne
	public Topic topic;
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	public Set<Answer> answers;
	
	public Question(String question) {
		this.question = question;
	}	
}