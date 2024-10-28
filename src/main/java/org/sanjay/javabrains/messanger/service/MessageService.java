package org.sanjay.javabrains.messanger.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.sanjay.javabrains.messanger.database.DataBaseClass;
import org.sanjay.javabrains.messanger.exception.DataNotFoundException;
import org.sanjay.javabrains.messanger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DataBaseClass.getMessages();

	public MessageService() {

	}

	public List<Message> getAllMessages() {

		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesForYear(int year) throws ParseException {
		List<Message> messageForYear = new ArrayList<Message>();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
		for (Message message : messages.values()) {
			// Parse the date string
			Date date = sdf.parse(message.getDate().toString());
			// Extract the year
			SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
			String year1 = yearFormat.format(date);
			if (Integer.parseInt(year1) == year) {
				messageForYear.add(message);
			}
		}
		System.out.println("Length of message yaer ==>" + messageForYear.size());
		return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size) throws ParseException {
		
		List<Message> messagePaginated=new ArrayList<Message>(messages.values());
		System.out.println("Size of the list "+messagePaginated.size());
		if(start+size > messagePaginated.size()) {
			return new ArrayList<Message>();
		}
		
		return messagePaginated.subList(start, start+size);
	}

	public Message getMessage(Long messageId) {
		Message msg = messages.get(messageId);
		if(msg == null) {
			System.out.println("If message is null");
			throw new DataNotFoundException("Message Doesn't Exist For ID : "+messageId);
		}
		return messages.get(messageId);
	}

	public Message addMessage(Message message) {

		message.setId(messages.size() + 1);
		message.setDate(new Date());
		message.setAuthor(message.getAuthor());
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		Message msg = messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(Long id) {

		Message message = messages.remove(id);
		return message;
	}
}
