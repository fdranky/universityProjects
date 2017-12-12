package controllers;
 
import models.Member;

import org.junit.Before;

import play.mvc.Controller;
import play.mvc.With;
 
@With(Secure.class)
public class Admin extends Controller {
    
    @Before
    static void setConnectedUser() {
        if(Security.isConnected()) {
            Member member = Member.find("byEmailaddress", Security.connected()).first();
            renderArgs.put("email", member.emailAddress);
        }
    }
 
    public static void index() {
        render();
    }
    
}