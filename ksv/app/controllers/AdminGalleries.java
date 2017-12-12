package controllers;

import models.Gallery;
import play.mvc.With;

@Check("admin")
@With(Secure.class)
@CRUD.For(Gallery.class)
public class AdminGalleries extends CRUD {

}