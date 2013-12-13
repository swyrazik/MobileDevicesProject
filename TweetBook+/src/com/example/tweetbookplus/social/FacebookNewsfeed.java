package com.example.tweetbookplus.social;

import java.util.ArrayList;

import org.json.JSONArray;

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
	
	public void update(JSONArray data){
		//TODO add new posts to the list, if any
		//should first check if a post already exists in the list
	}
	
}
