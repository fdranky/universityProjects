package controllers;

import java.util.Date;

import models.Event;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
    	long nowDate = (new Date()).getTime();
    	Event newestEvent = Event.find("select e from Event e where e.start > ? order by start", nowDate).first();
    	render(newestEvent);
    }

}