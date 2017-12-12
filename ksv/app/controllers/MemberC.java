package controllers;

import models.Member;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class MemberC extends Controller {
   
   @Before
   static void setConnectedUser() {
       if(Security.isConnected()) {
           Member member = Member.find("byEmailaddress", Security.connected()).first();
           renderArgs.put("member", member.emailAddress);
       }
   }

   public static void index() {
       render();
   }
   
}