package controllers;

import models.Member;
import play.mvc.With;

@Check("admin")
@With(Secure.class)
@CRUD.For(Member.class)
public class AdminMembers extends CRUD {
   
}
