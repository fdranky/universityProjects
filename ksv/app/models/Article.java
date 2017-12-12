package models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import net.sf.oval.constraint.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Article extends Model{
	public String title;
	
	@Lob
	@Required
	@MaxSize(10000)
	public String summary;
	
	@ManyToOne
	public Topic topic;
	
	@Lob
	@Required
	@MaxSize(10000)
	public String content;
	
	public Event event;
	
	public Article(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	//Problem with CRUD not displaying several columns in the interface.
	public String toString() {
	      return title + " " + topic;
	}
}
