package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Event;
import models.EventType;
import play.mvc.Controller;

public class EventTypes extends Controller {

	public static void showEventType(String eventType) {
		EventType thisEventType = EventType.find("byType", eventType).first();
		Long nowDate = (new Date()).getTime();
		List<Event> events = Event.find("select e from Event e where e.eventType = ? and e.start > ? order by start", thisEventType, nowDate).fetch();
		render(events);
	}

	public static void showAllEventTypes() {
		List<EventType> eventTypes = EventType.findAll();
		List<Event> events = new ArrayList<Event>();
		Long nowDate = (new Date()).getTime();
		for (EventType eventType : eventTypes) {
			events.addAll(Event.find("select e from Event e where e.eventType = ? and e.start > ? order by start", eventType, nowDate).<Event>fetch());
		}
		render(events);
	}

}
