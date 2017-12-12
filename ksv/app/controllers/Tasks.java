package controllers;

import java.util.List;

import models.Event;
import models.Member;
import models.Task;
import play.mvc.Controller;

public class Tasks extends Controller {

	public static void showAllTasks() {
		List<Event> events = Event.findAll();
		Member member = Member.findById(Long.parseLong(session.get("userid")));
		render(events, member);
	}

	public static void showTasks(long eventId) {
		List<Task> tasks = Task.find("byEvent", eventId).first();
	
		render(tasks);
	}

	public static void enlistForTask(long memberId, long taskId) {
		Member member = models.Member.findById(memberId);
		Task task = Task.findById(taskId);

		member.tasks.add(task);
		task.members.add(member);
		task.helpersNeeded--;
		if (task.helpersNeeded <= 0)
			task.enoughHelpers = true;

		member.save();
		task.save();
		showAllTasks();
	}

	public static void withdrawFromTask(long memberId, long taskId) {
		Member member = models.Member.findById(memberId);
		Task task = Task.findById(taskId);

		member.tasks.remove(task);
		task.members.remove(member);
		task.helpersNeeded++;
		if (task.helpersNeeded > 0)
			task.enoughHelpers = false;

		member.save();
		task.save();
		showAllTasks();
	}
	
}
