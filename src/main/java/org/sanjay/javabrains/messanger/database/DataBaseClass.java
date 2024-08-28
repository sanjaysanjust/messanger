package org.sanjay.javabrains.messanger.database;

import java.util.HashMap;
import java.util.Map;

import org.sanjay.javabrains.messanger.model.Message;

public class DataBaseClass {
	private static Map<Long, Message> messages = new HashMap<Long, Message>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}
}
