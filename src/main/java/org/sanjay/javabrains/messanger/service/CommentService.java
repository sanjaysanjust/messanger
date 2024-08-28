package org.sanjay.javabrains.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sanjay.javabrains.messanger.database.DataBaseClass;
import org.sanjay.javabrains.messanger.model.Comment;
import org.sanjay.javabrains.messanger.model.Message;

public class CommentService {
	private Map<Long, Message> messages = DataBaseClass.getMessages();
	
	public CommentService() {

	}

	public List<Comment> getAllComments(long messageId) {
		Message message = messages.get(messageId);
		System.out.println("Message is ==>"+message);
		Map<Long, Comment> comment_map = message.getComments();
		return new ArrayList<Comment>(comment_map.values());
	}
	
	public Comment getComment(Long messageId,Long commentId) {
		
		return messages.get(messageId).getComments().get(commentId);
	}

	public Comment addComment(Long messageId,Comment comment) {
		
		Map<Long,Comment> comment_map= messages.get(messageId).getComments();
		comment.setId(comment_map.size()+1);
		comment_map.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateMessage(Long messageId, Comment comment) {
		Map<Long,Comment> comment_map = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comment_map.put(comment.getId(), comment);
		return comment;
	}

	public Comment removeMessage(Long messageId, Long commentId) {
		Map<Long,Comment> comment_map = messages.get(messageId).getComments();
		
		return comment_map.remove(commentId);
		
	}

}
