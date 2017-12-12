package controllers;

import models.Article;
import play.mvc.With;

@Check("admin")
@With(Secure.class)
@CRUD.For(Article.class)
public class AdminArticles extends CRUD {

}