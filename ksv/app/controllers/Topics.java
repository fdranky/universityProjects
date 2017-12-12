package controllers;

import java.util.List;

import models.Article;
import models.Topic;
import play.mvc.Controller;

public class Topics extends Controller {

	  public static void showTopic(String topic) {
		Topic thisTopic = Topic.find("byTopic", topic).first();
	    List<Article> articles = Article.find("byTopic", thisTopic).fetch();
	    if(!articles.isEmpty())
	    	render(articles);
	  }

}
