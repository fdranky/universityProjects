package controllers;

import models.EventType;
import play.mvc.With;

@Check("admin")
@With(Secure.class)
@CRUD.For(EventType.class)
public class AdminEventTypes extends CRUD {

}