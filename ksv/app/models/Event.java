package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Event extends Model {
	public long start;
	public long end;
	public String place;
	public String title;
	@OneToMany(mappedBy="event", cascade = CascadeType.ALL)
	public Set<Task> tasks;
	@ManyToMany
	public Set<Participant> participants;
	@OneToOne
	public Gallery gallery;
	@ManyToMany
	public Set<Questionnaire> questionnaires;
	@ManyToOne
	public EventType eventType;
	@OneToOne
	public Article article;
	
	public Event(long start, long end, String title) {
		super();
		this.start = start;
		this.end = end;
		this.title = title;
	}

	public String getStartDateAsString(){
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date startDate = new Date(start);
		return sdfDate.format(startDate);
	}
	public String getEndDateAsString(){
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date startDate = new Date(end);
		return sdfDate.format(startDate);
	}
}
