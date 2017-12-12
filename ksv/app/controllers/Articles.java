package controllers;

import models.Article;
import play.mvc.Controller;

public class Articles extends Controller {

    public static void showArticle(Long articleId) {
    	Article article = Article.findById(articleId);
        render(article);
    }
    
}
