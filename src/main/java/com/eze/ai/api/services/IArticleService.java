package com.eze.ai.api.services;

import java.util.List;

import com.eze.ai.api.models.Article;

public interface IArticleService {
     List<Article> getAllArticles();
     Article getArticleById(int articleId);
     boolean addArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(int articleId);
}
