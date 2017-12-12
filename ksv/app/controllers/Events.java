package controllers;

import java.util.List;

import models.Event;
import play.mvc.Controller;

public class Events extends Controller {

	public static void showAllEvents() {
		List<Event> events = Event.findAll();
		render(events);
	}

	public static void showEvent(Long id) {
		Event event = Event.findById(id);
		render(event);
	}

}
