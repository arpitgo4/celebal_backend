package com.eze.ai.dds;

import org.springframework.web.client.RestTemplate;

import com.eze.ai.api.models.Article;

public class ServiceCallTest {

	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		Article data = restTemplate.getForObject("http://localhost:8090/user/article/5", Article.class);

		System.out.println(data);

		Article article = new Article();
		article.setCategory("MachineLearning");
		article.setTitle("AI");
		Article postArticle=restTemplate.postForObject("http://localhost:8090/user/article", article, Article.class);

		System.out.println(postArticle);
	}

}
