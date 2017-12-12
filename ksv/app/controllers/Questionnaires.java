package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Answer;
import models.Event;
import models.Participant;
import models.Question;
import models.Questionnaire;
import play.cache.Cache;
import play.data.validation.Email;
import play.data.validation.Required;
import play.libs.Codec;
import play.libs.Images;
import play.mvc.Controller;

public class Questionnaires extends Controller {

	public static void showQuestionnaire(
			List<Boolean> questionsAnsweredCorrectly,
			Map<Long, Answer> questionsAnswered, List<Boolean> answersChecked, String emailAddress) {
		List<Event> newestEvents = Event.find("select e from Event e order by start")
				.fetch();
		Event newestEvent = null;
		for (Event event : newestEvents) {
			if(!event.questionnaires.isEmpty()){
				newestEvent = event;
			}
		}
		Questionnaire newestQuestionnaire = Questionnaire
				.find("select distinct q from Questionnaire q join q.events as e where e.id = ?",
						newestEvent.id).first();
		List<Question> questions = Question
				.find("select distinct q from Question q join q.questionnaires as qaire where qaire.id = ?",
						newestQuestionnaire.id).fetch();
		Questionnaire questionnaire = Questionnaire
				.findById(newestQuestionnaire.id);
		// get values from cache or fill with default values
		questionsAnsweredCorrectly = (List<Boolean>) Cache.get(session.getId()+"questionsAnsweredCorrectly");
		answersChecked = (List<Boolean>) Cache.get(session.getId()+"answersChecked");
		questionsAnswered = (Map<Long, Answer>) Cache.get(session.getId()+"questionsAnswered");
		// fill null values with default values
		if (questionsAnsweredCorrectly == null) {
			questionsAnsweredCorrectly = Arrays
					.asList(new Boolean[questionnaire.questions.size()]);
			Collections.fill(questionsAnsweredCorrectly, true);
		}
		if (answersChecked == null) {
			answersChecked = new ArrayList<Boolean>();
			for (Question question : questions) {
				List<Boolean> fillThis = Arrays
						.asList(new Boolean[question.answers.size()]);
				Collections.fill(fillThis, false);
				answersChecked.addAll(fillThis);
			}
		}
		String randomID = Codec.UUID();
		if (questionsAnswered == null)
			questionsAnswered = new HashMap<Long, Answer>();
		render(questions, questionnaire, questionsAnsweredCorrectly, randomID,
				questionsAnswered, answersChecked, emailAddress, newestEvent);
	}

	
	
	
	// TODO: Save checkox and Email-Adress for wrong entries
	public static void enterQuestionnaire(Long questionnaireId,
			List<Long> answersGiven, @Email@Required String emailAddress,
			@Required String code,
			String randomID) {
		// setup
		Questionnaire questionnaire = Questionnaire.findById(questionnaireId);
		Map<Long, Answer> questionsAnswered = new HashMap<Long, Answer>();
		// check for no answers
		boolean allWrong = false;
		if (answersGiven == null)
			allWrong = true;
		
		// put answers in Map
		if (!allWrong) {
			for (Long answerId : answersGiven) {
				Answer answer = Answer.findById(answerId);
				if (answer.correctAnswer)
					questionsAnswered.put(answer.question.id, answer);
			}
		}
		// get all Questions from this questionnaire
		List<Question> questions = Question
				.find("select distinct q from Question q join q.questionnaires as qaire where qaire.id = ?",
						questionnaire.id).fetch();

		// check which answers have been checked and which questions have been answered correctly
		List<Boolean> answersChecked = new ArrayList<Boolean>();
		List<Boolean> questionsAnsweredCorrectly = new ArrayList<Boolean>();
		boolean mistake = allWrong ? true : false;
		for (Question question : questions) {
			boolean isAnswerCorrect = allWrong ? false: true;
			for (Answer answer : question.answers) { 
				if (!allWrong && answersGiven.contains(answer.id)){
					answersChecked.add(true);
					if (!answer.correctAnswer)
						isAnswerCorrect = false;
				}
				else{
					answersChecked.add(false);
					if (!allWrong && answer.correctAnswer){
						isAnswerCorrect = false;
						mistake = true;
					}
				}
			}
			questionsAnsweredCorrectly.add(isAnswerCorrect);
		}
		validation.equals(code, Cache.get(randomID)).message(
				"Invalid code. Please type it again");

		Event newestEvent = Event.find("select e from Event e order by start")
				.first();
		Cache.add(session.getId()+"questionsAnsweredCorrectly", questionsAnsweredCorrectly, "5mn");
		Cache.add(session.getId()+"questionsAnswered", questionsAnswered, "5mn");
		Cache.add(session.getId()+"answersChecked", answersChecked, "5mn");
		if (validation.hasErrors() || mistake) {
			render("Questionnaires/showQuestionnaire.html", questions,
					questionsAnsweredCorrectly, questionnaire, randomID,
					questionsAnswered, answersChecked, emailAddress, newestEvent);
		} else {
			Participant participant = new Participant(emailAddress, questionnaire);
			participant.save();
			render(emailAddress);
		}
	}

	public static void captcha(String id) {
		Images.Captcha captcha = Images.captcha();
		String code = captcha.getText("#294D00");
		Cache.set(id, code, "10mn");
		renderBinary(captcha);
	}

}
	