package controllers;

import models.Member;

public class Security extends Secure.Security {

	// Implement the right DB comparisson
	public static boolean authenticate(String username, String password) {
		return Member.connect(username, password) != null;
	}

	static void onDisconnected() {
		Application.index();
	}

	static void onAuthenticated() {
		Tasks.showAllTasks();
	}
	
	static boolean check(String profile) {
	    if("admin".equals(profile)) {
        	return Member.find("byEmailaddress", connected()).<Member>first().isAdmin;
        }
	    else if ("member".equals(profile)) {
	        return Member.find("byEmailaddress", connected()).<Member>first().isMember;
	    }
	        
	    return false;
	 }
	    
}
