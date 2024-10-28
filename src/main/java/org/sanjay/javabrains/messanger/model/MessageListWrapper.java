package org.sanjay.javabrains.messanger.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessageListWrapper {
	private List<Message> messages;

    public MessageListWrapper() {
    }

    public MessageListWrapper(List<Message> messages) {
        this.messages = messages;
    }

    @XmlElement(name = "message")
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}
