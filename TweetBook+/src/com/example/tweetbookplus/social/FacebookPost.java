package com.example.tweetbookplus.social;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class FacebookPost {
	
	private String ID;
	private JSONObject from;
	private JSONArray to;
	private String message;
	private ArrayList<FacebookTag> message_tags;
	private String picture;
	private String link;
	private String name;
	private String caption;
	private String description;
	private String source;
	private JSONArray properties;
	private String icon;
	private JSONArray actions;
	private JSONObject privacy;
	private String type;
	private JSONObject place;
	private String story;
	private ArrayList<FacebookTag> story_tags;
	private JSONArray with_tags;
	private JSONArray comments;
	private long object_id;
	private JSONObject application;
	private String created_time;
	private String updated_time;
	private long shares;
	private boolean isHidden;
	private String status_type;
	
	////////////////////////////////////////////
	//             Constructors               //
	////////////////////////////////////////////
	
	protected FacebookPost(JSONObject json){
		ID = json.optString("id");
		from = json.optJSONObject("from");
		JSONObject temp = json.optJSONObject("to");
		if (temp == null)
			to = null;
		else
			to = temp.optJSONArray("data");
		message = json.optString("message");
		message_tags = new ArrayList<FacebookTag>();
		try{
			JSONObject tags = json.optJSONObject("message_tags");
			if (tags != null){
				int i = 0;
				int j = 0;
				while (i < message.length() && j < tags.length()){
					if (!tags.isNull("" + i)){
						message_tags.add(new FacebookTag(tags.getJSONArray("" + i).getJSONObject(0)));
						j++;
					}
					i++;
				}
			}
		} catch (Exception e){}
		picture = json.optString("picture");
		link = json.optString("link");
		name = json.optString("name");
		caption = json.optString("caption");
		description = json.optString("description");
		source = json.optString("source");
		properties = json.optJSONArray("properties");
		icon = json.optString("icon");
		actions = json.optJSONArray("actions");
		privacy = json.optJSONObject("privacy");
		type = json.optString("type");
		place = json.optJSONObject("place");
		story = json.optString("story");
		story_tags = new ArrayList<FacebookTag>();
		try{
			JSONObject tags = json.optJSONObject("story_tags");
			if (tags != null){
				int i = 0;
				int j = 0;
				while (i < message.length() && j < tags.length()){
					if (!tags.isNull("" + i)){
						story_tags.add(new FacebookTag(tags.getJSONArray("" + i).getJSONObject(0)));
						j++;
					}
					i++;
				}
			}
		} catch (Exception e){}
		temp = json.optJSONObject("with_tags");
		if (temp == null)
			with_tags = null;
		else
			with_tags = temp.optJSONArray("data");
		temp = json.optJSONObject("comments");
		if (temp == null)
			comments = null;
		else
			comments = temp.optJSONArray("data");
		object_id = json.optLong("object_id");
		application = json.optJSONObject("application");
		created_time = json.optString("created_time");
		updated_time = json.optString("updated_time");
		shares = json.optLong("shares");
		isHidden = json.optBoolean("is_hidden");
		status_type = json.optString("status_type");		
	}
	
	////////////////////////////////////////////
	//               Getters                  //
	////////////////////////////////////////////
	
	public String getID(){
		return ID;
	}
	
	public String getFromName(){
		if (from == null)
			return null;
		return from.optString("name");
	}
	
	public String getFromID(){
		if (from == null)
			return null;
		return from.optString("id");
	}
	
	public String getToName(int index){
		if (to == null)
			return null;
		String str = "";
		try{
			str = to.getJSONObject(index).optString("name");
		} catch (Exception e){}
		return str;
	}
	
	public String getToID(int index){
		if (to == null)
			return null;
		String str = "";
		try{
			str = to.getJSONObject(index).optString("id");
		} catch (Exception e){}
		return str;
	}
	
	public String getMessage(){
		return message;
	}
	
	public String getMessageTagId(int index){
		if (message_tags.isEmpty())
			return null;
		return message_tags.get(index).getId();
	}
	
	public String getMessageTagName(int index){
		if (message_tags.isEmpty())
			return null;
		return message_tags.get(index).getName();
	}
	
	public int getMessageTagOffset(int index){
		if (message_tags.isEmpty())
			return -1;
		return message_tags.get(index).getOffset();
	}
	
	public int getMessageTagLength(int index){
		if (message_tags.isEmpty())
			return -1;
		return message_tags.get(index).getLength();
	}
	
	public int getMessageTagsCount(){
		return message_tags.size();
	}

	public String getPicture(){
		return picture;
	}
	
	public String getLink(){
		return link;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCaption() {
		return caption;
	}

	public String getDescription() {
		return description;
	}

	public String getSource() {
		return source;
	}
	
	public String getPropertyName(int index){
		if (properties == null)
			return null;
		String str = "";
		try{
			str = properties.getJSONObject(index).optString("name");
		} catch (Exception e){}
		return str;
	}
	
	public String getPropertyText(int index){
		if (properties == null)
			return null;
		String str = "";
		try{
			str = properties.getJSONObject(index).optString("text");
		} catch (Exception e){}
		return str;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public String getActionName(int index){
		if (actions == null)
			return null;
		String str = "";
		try{
			str = actions.getJSONObject(index).optString("name");
		} catch (Exception e){}
		return str;
	}
	
	public String getActionLink(int index){
		if (actions == null)
			return null;
		String str = "";
		try{
			str = actions.getJSONObject(index).optString("link");
		} catch (Exception e){}
		return str;
	}
	
	public String getPrivacyValue(){
		if (privacy == null)
			return null;
		return privacy.optString("value");
	}
	
	public String getPrivacyAllow(){
		if (privacy == null)
			return null;
		return privacy.optString("allow");
	}
	
	public String getPrivacyDeny(){
		if (privacy == null)
			return null;
		return privacy.optString("deny");
	}
	
	public String getType() {
		return type;
	}
	
	public String getPlaceID(){
		if (place == null)
			return null;
		return place.optString("id");
	}
	
	public String getPlaceName(){
		if (place == null)
			return null;
		return place.optString("name");
	}
	
	public String getPlaceLocationLatitude(){
		if (place == null)
			return null;
		String str = "";
		try{
			str = place.getJSONObject("location").optString("latitude");
		} catch (Exception e){}
		return str;
	}
	
	public String getPlaceLocationLongitude(){
		if (place == null)
			return null;
		String str = "";
		try{
			str = place.getJSONObject("location").optString("longitude");
		} catch (Exception e){}
		return str;
	}
	
	public String getPlaceLocationCountry(){
		if (place == null)
			return null;
		String str = "";
		try{
			str = place.getJSONObject("location").optString("country");
		} catch (Exception e){}
		return str;
	}
	
	public String getStory() {
		return story;
	}
	
	public String getStoryTagId(int index){
		if (story_tags.isEmpty())
			return null;
		return story_tags.get(index).getId();
	}
	
	public String getStoryTagName(int index){
		if (story_tags.isEmpty())
			return null;
		return story_tags.get(index).getName();
	}
	
	public int getStoryTagOffset(int index){
		if (story_tags.isEmpty())
			return -1;
		return story_tags.get(index).getOffset();
	}
	
	public int getStoryTagLength(int index){
		if (story_tags.isEmpty())
			return -1;
		return story_tags.get(index).getLength();
	}
	
	public int getStoryTagsCount(){
		return story_tags.size();
	}
	
	public String getWithTagID(int index){
		if (with_tags == null)
			return null;
		String str = "";
		try{
			str = with_tags.getJSONObject(index).optString("id");
		} catch (Exception e){}
		return str;
	}
	
	public String getWithTagName(int index){
		if (with_tags == null)
			return null;
		String str = "";
		try{
			str = with_tags.getJSONObject(index).optString("name");
		} catch (Exception e){}
		return str;
	}
	
	public String getCommentID(int index){
		if (comments == null)
			return null;
		String str = "";
		try{
			str = comments.getJSONObject(index).optString("id");
		} catch (Exception e){}
		return str;
	}
	
	public String getCommentFrom(int index){
		if (comments == null)
			return null;
		String str = "";
		try{
			str = comments.getJSONObject(index).optString("from");
		} catch (Exception e){}
		return str;
	}
	
	public String getCommentMessage(int index){
		if (comments == null)
			return null;
		String str = "";
		try{
			str = comments.getJSONObject(index).optString("message");
		} catch (Exception e){}
		return str;
	}
	
	public String getCommentCreatedTime(int index){
		if (comments == null)
			return null;
		String str = "";
		try{
			str = comments.getJSONObject(index).optString("created_time");
		} catch (Exception e){}
		return str;
	}
	
	public long getCommentsCount(){
		if (comments == null)
			return 0;
		return comments.length();
	}
	
	public long getObjectID(){
		return object_id;
	}
	
	public String getApplicationName(){
		if (application == null)
			return null;
		return application.optString("name");
	}
	
	public String getApplicationID(){
		if (application == null)
			return null;
		return application.optString("id");
	}
	
	public String getCreatedTime(){
		return created_time;
	}
	
	public String getUpdatedTime(){
		return updated_time;
	}
	
	public long getSharesCount(){
		return shares;
	}
	
	public boolean isHidden() {
		return isHidden;
	}
	
	public String getStatusType(){
		return status_type;
	}
	
}
