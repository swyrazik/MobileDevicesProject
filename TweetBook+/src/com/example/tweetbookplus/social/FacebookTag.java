package com.example.tweetbookplus.social;

import org.json.JSONObject;

public class FacebookTag {
	
	private String id;
	private String name;
	private int offset;
	private int length;
	
	////////////////////////////////////////////
	//             Constructors               //
	////////////////////////////////////////////
	
	protected FacebookTag(String id, String name, int offset, int length){
		this.id = id;
		this.name = name;
		this.offset = offset;
		this.length = length;
	}
	
	protected FacebookTag(JSONObject json){
		id = json.optString("id");
		name = json.optString("name");
		offset = json.optInt("offset");
		length = json.optInt("length");
	}
	
	////////////////////////////////////////////
	//               Getters                  //
	////////////////////////////////////////////
	
	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public int getOffset(){
		return offset;
	}
	
	public int getLength(){
		return length;
	}
	
}
