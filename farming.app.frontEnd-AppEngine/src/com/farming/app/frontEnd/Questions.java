
package com.farming.app.frontEnd;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Blob;


@Entity
public class Questions {

	@Id
	private String id;
	private String question;
	private String facebookName;
	private String facebookId;
	private String isAnswered;
	private String topic;
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getFacebookName() {
		return facebookName;
	}
	public void setFacebookName(String facebookName) {
		this.facebookName = facebookName;
	}
	public String getFacebookId() {
		return facebookId;
	}
	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
	public String getIsAnswered() {
		return isAnswered;
	}
	public void setIsAnswered(String isAnswered) {
		this.isAnswered = isAnswered;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	
}
