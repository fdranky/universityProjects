package controllers;

import models.Task;
import play.mvc.With;

@Check("admin")
@With(Secure.class)
@CRUD.For(Task.class)
public class AdminTasks extends CRUD {
   
}