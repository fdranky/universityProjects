package models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class EventType extends Model {
	public String type;
	@OneToMany
	public Set<Event> events;

	public EventType(String type, Set<Event> events) {
		super();
		this.type = type;
		this.events = events;
	}
}
