package models;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.data.validation.Email;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Member extends Model {

	@Required
	@MinSize(10)
	public String name;

	@Required
	@Email
	public String emailAddress;

	@Required
	public String password;

	@ManyToMany(mappedBy = "members")
	public Set<Task> tasks;

	public boolean isAdmin;
	public boolean isMember;
	
	public Member(String emailAddress) {
		super();
		this.emailAddress = emailAddress;
	}
	
	public static Member connect(String email, String password) {
	    return find("byEmailaddressAndPassword",email, password).first();
	}

	public String toString() {
		return emailAddress;
	}
	
	public boolean isMemberHelping(long taskId){
		Task task = Task.findById(taskId);
		return tasks.contains(task);
	}

}
