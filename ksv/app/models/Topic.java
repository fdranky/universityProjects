package models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Topic extends Model{
	public String topic;
	
	@OneToMany(mappedBy="topic", fetch = FetchType.EAGER)
	public Set<Article> articles;

	@OneToMany(mappedBy="topic")
	public Set<Question> question;
	
	public Topic(String topic) {
		this.topic = topic;
	}


	@Override
	public String toString() {
		return topic;
	}


}
