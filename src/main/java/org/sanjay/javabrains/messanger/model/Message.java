package org.sanjay.javabrains.messanger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;


@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date date;
	private String author;
	private Map<Long, Comment> comments = new HashMap<Long, Comment>();
	
	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(int id, String message, Date date, String author) {
		this.id = id;
		this.author = author;
		this.date = date;
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Author : " + author + ", Date : " + date + ", Message :" + message;
	}
}
