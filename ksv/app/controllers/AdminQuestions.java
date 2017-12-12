package controllers;

import models.Question;
import play.mvc.With;

@Check("admin")
@With(Secure.class)
@CRUD.For(Question.class)
public class AdminQuestions extends CRUD {
   
}
