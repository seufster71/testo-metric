package org.testo.metric.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String message;

	public Message() {}
	
	public Message(String message) {
		setMessage(message);
	}
	
	@Column(name = "message")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


}
