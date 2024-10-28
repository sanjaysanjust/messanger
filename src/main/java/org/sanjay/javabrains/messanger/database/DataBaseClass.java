package org.sanjay.javabrains.messanger.database;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.sanjay.javabrains.messanger.model.Message;

public class DataBaseClass {
	private static Map<Long, Message> messages = new HashMap<Long, Message>();

	public static void putmeassgae() {

		Message msg = new Message();
		msg.setAuthor("Sanjay");
		//msg.setComments(null);
		msg.setDate(new Date());
		msg.setId(1);
		messages.put((long) 1, msg);
	}

	public static Map<Long, Message> getMessages() {
		//putmeassgae();
		return messages;
	}
}
