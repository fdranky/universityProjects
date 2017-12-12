package controllers;

import java.util.List;

import models.Gallery;
import play.mvc.Controller;

public class GalleryOverview extends Controller {

    public static void showGalleryOverview() {
    	List<Gallery> galleries = Gallery.findAll();
        render(galleries);
    }

}
