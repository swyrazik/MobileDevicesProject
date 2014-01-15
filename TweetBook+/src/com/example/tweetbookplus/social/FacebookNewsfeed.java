package com.example.tweetbookplus.social;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class FacebookNewsfeed {
	
	private ArrayList<FacebookPost> posts;
	
	////////////////////////////////////////////
	//             Constructors               //
	////////////////////////////////////////////
	
	protected FacebookNewsfeed(){
		posts = new ArrayList<FacebookPost>();
	}
	
	////////////////////////////////////////////
	//               Getters                  //
	////////////////////////////////////////////
	
	public FacebookPost[] getPosts(){
		if (posts.isEmpty())
			return null;
		FacebookPost[] temp = new FacebookPost[1];
		return posts.toArray(temp);
	}
	
	public FacebookPost getPost(int index){
		if (posts.isEmpty())
			return null;
		return posts.get(index);
	}
	
	public int getPostCount(){
		return posts.size();
	}
	
	////////////////////////////////////////////
	//             Other Methods              //
	////////////////////////////////////////////
	
	public void update(JSONObject data){
		//TODO add new posts to the list, if any
		//should first check if a post already exists in the list
				
		JSONArray postData = data.optJSONArray("data");
		if (postData == null)
			return;
				
		if (posts.isEmpty()){
			for (int i = 0; i < postData.length(); i++){
				posts.add(new FacebookPost(postData.optJSONObject(i)));
			}
			return;
		}
	}
	
}
