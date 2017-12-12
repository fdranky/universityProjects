package controllers;

import models.Topic;
import play.mvc.With;

@Check("admin")
@With(Secure.class)
@CRUD.For(Topic.class)
public class AdminTopics extends CRUD {
   
}
