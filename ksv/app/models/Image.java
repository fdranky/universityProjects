package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Image extends Model {
	public String name;
	public String fileName;
	public long date;
	public String comment;
	
	@ManyToOne
	public Gallery gallery;

	public Image(String name, long date, String comment,
			Member member, Gallery gallery) {
		super();
		this.name = name;
		this.date = date;
		this.comment = comment;
		this.gallery = gallery;
	}
}
