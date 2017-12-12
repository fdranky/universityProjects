package controllers;

import models.Participant;
import play.mvc.With;

@Check("admin")
@With(Secure.class)
@CRUD.For(Participant.class)
public class AdminParticipants extends CRUD {
   
}
