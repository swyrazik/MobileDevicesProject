package com.example.tweetbookplus.social;

import org.json.JSONObject;

public class FacebookUser {
	
	private String id;
	private String link;
	private String firstName;
	private String middleName;
	private String lastName;
	private String name;
	private String username;
	private String quotes;
//	private JSONObject hometown;
	private String bio;
	private String religion;
	private String about;
	private boolean verified;
	private String gender;
	private String relationshipStatus;
	private String locale;
	private String political;
	private String nameFormat;
//	private JSONObject significantOther;
	private String website;
//	private JSONObject location;
	
	////////////////////////////////////////////
	//             Constructors               //
	////////////////////////////////////////////
	
	protected FacebookUser(JSONObject json){
		id = json.optString("id");
		link = json.optString("link");
		firstName = json.optString("first_name");
		middleName = json.optString("middle_name");
		lastName = json.optString("last_name");
		name = json.optString("name");
		username = json.optString("username");
		quotes = json.optString("quotes");
//		hometown = 
		bio = json.optString("bio");
		religion = json.optString("religion");
		about = json.optString("about");
		verified = json.optBoolean("verified");
		gender = json.optString("gender");
		relationshipStatus = json.optString("relationship_status");
		locale = json.optString("locale");
		political = json.optString("political");
		nameFormat = json.optString("name_format");
//		significantOther = 
		website = json.optString("website");
//		location = 
	}
	
	////////////////////////////////////////////
	//               Getters                  //
	////////////////////////////////////////////
	
	public String getId(){
		return id;
	}
	
	public String getLink(){
		return link;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getMiddleName(){
		return middleName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getName(){
		return name;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getQuotes(){
		return quotes;
	}
	
	public String getBio(){
		return bio;
	}
	
	public String getReligion(){
		return religion;
	}
	
	public String getAbout(){
		return about;
	}
	
	public boolean isVerified(){
		return verified;
	}
	
	public String getGender(){
		return gender;
	}
	
	public String getRelationshipStatus(){
		return relationshipStatus;
	}
	
	public String getLocale(){
		return locale;
	}
	
	public String getPolitical(){
		return political;
	}
	
	public String getNameFormat(){
		return nameFormat;
	}
	
	public String getWebsite(){
		return website;
	}
	
}
