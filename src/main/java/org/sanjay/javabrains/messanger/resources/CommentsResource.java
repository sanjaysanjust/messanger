package org.sanjay.javabrains.messanger.resources;

import java.util.ArrayList;
import java.util.List;

import org.sanjay.javabrains.messanger.model.Comment;
import org.sanjay.javabrains.messanger.service.CommentService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentsResource {
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("commentId") long commentId, @PathParam("messageId") long messageId) {
		return new CommentService().getComment(messageId, commentId);
	}

	@GET
	public List<Comment> getAllComment(@PathParam("messageId") long messageId) {
		return new CommentService().getAllComments(messageId);
	}

	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return new CommentService().addComment(messageId, comment);
	}

	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId, Comment comment) {
		comment.setId(commentId);
		return new CommentService().updateMessage(messageId, comment);
	}

	@DELETE
	@Path("/{commentId}")
	public Comment deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return new CommentService().removeMessage(messageId, commentId);
	}
}
