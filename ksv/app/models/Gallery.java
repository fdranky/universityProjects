package models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Gallery extends Model{
	public String name;
	public boolean memberPrivate;
	public String address;
	@OneToMany(mappedBy="gallery")
	public Set<Image> images;
	@ManyToOne
	public Event events;
	
	public Gallery(String name, boolean memberPrivate) {
		super();
		this.name = name;
		this.memberPrivate = memberPrivate;
	}
	
}
