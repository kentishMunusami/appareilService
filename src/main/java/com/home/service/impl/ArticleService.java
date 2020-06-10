package com.home.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.home.bean.Article;
import com.home.service.IArticleService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Service permettant de récupérer les news via un web service
 *
 */
@Service
public class ArticleService implements IArticleService {

	@Override
	public List<Article> getArticles() {
		// Create Client
		Client client = Client.create();

		//appel du web service via l'url
		WebResource webResource = client
				.resource("http://newsapi.org/v2/top-headlines?country=fr&apiKey=5630b7fcef13446494efa85fdb53d700");

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		// Status 200 is successful.
		if (response.getStatus() != 200) {
			System.out.println("Failed with HTTP Error code: " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
		}

		String output = response.getEntity(String.class);

		JSONObject json = new JSONObject(output);
		Gson gson = new Gson();
		List<Article> articles = new ArrayList<Article>();
		//conversion du json récupéré en un tableau d'objet article
		Article[] articleTab = gson.fromJson(json.get("articles").toString(), Article[].class);
		for (Article article : articleTab) {
			articles.add(article);
		}
		return articles;
	}

}
