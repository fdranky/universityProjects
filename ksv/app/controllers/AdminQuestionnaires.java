package controllers;

import models.Questionnaire;
import play.mvc.With;

@Check("admin")
@With(Secure.class)
@CRUD.For(Questionnaire.class)
public class AdminQuestionnaires extends CRUD {
   
}
