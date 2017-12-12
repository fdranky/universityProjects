package controllers;

import models.Event;
import play.mvc.With;

@Check("admin")
@With(Secure.class)
@CRUD.For(Event.class)
public class AdminEvents extends CRUD {

}