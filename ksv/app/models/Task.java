package models;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Task extends Model {

	public String name;
	public String description;
	public boolean enoughHelpers;
	public int helpersNeeded;
	@ManyToOne
	public Event event;
	@ManyToMany
	public Set<Member> members;

	public List<Member> getMembersNotHelping() {
		List<Member> allMembers = Member.findAll();
		allMembers.removeAll(members);
		return allMembers;
	} 

	public Task(String name, String description, boolean enoughHelpers,
			int helpersNeeded, Event event) {
		super();
		this.name = name;
		this.description = description;
		this.enoughHelpers = enoughHelpers;
		this.helpersNeeded = helpersNeeded;
		this.event = event;
	}

}
