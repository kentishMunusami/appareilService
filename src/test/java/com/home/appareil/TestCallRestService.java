package com.home.appareil;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.home.bean.Article;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestCallRestService {
	
	public static void main(String[] arg) {
		 // Create Client
	     Client client = Client.create();
	 
	     WebResource webResource = client.resource("http://newsapi.org/v2/top-headlines?country=fr&apiKey=5630b7fcef13446494efa85fdb53d700");
	 
	     ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
	 
	     // Status 200 is successful.
	     if (response.getStatus() != 200) {
	         System.out.println("Failed with HTTP Error code: " + response.getStatus());
	         String error= response.getEntity(String.class);
	         System.out.println("Error: "+error);
	         return;
	     }
	 
	     String output = response.getEntity(String.class);
	 
	     System.out.println("Output from Server .... \n");
	     
	     JSONObject json;
		try {
			json = new JSONObject(output);
			Gson gson=new Gson();
			Article[] articles = gson.fromJson(json.getString("articles"), Article[].class);
			for (Article article : articles) {
				System.out.println(article.getTitle());
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
