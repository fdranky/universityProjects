package controllers;

import models.Gallery;
import play.mvc.Controller;

public class Galleries extends Controller {

	private CRUDBehavior cb = null;
	public Galleries() {
		cb = new CRUDBehavior();
	}
	
    public static void showGallery(Long galleryId) {
    	Gallery gallery = Gallery.findById(galleryId);
        render(gallery);
    }

    public class CRUDBehavior extends CRUD {

	}
}
