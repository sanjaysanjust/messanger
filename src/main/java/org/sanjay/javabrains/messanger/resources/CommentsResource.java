package org.sanjay.javabrains.messanger.resources;

import java.util.List;

import org.sanjay.javabrains.messanger.model.Comment;
import org.sanjay.javabrains.messanger.model.CommentListWrapper;
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
import jakarta.ws.rs.core.Response;

@Path("/")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class CommentsResource {
	@GET
	@Path("/{commentId}")
	public Response getComment(@PathParam("commentId") long commentId, @PathParam("messageId") long messageId) {
		System.out.println("Inside get comment ====>");
		//return new CommentService().getComment(messageId, commentId);
		return Response.ok().entity(new CommentService().getComment(messageId, commentId)).build();
	}

	@GET
	public Response getAllComment(@PathParam("messageId") long messageId) {
		System.out.println("INside get all comments");
		//return new CommentService().getAllComments(messageId);
		List<Comment> commentLst = new CommentService().getAllComments(messageId);
		CommentListWrapper commentWrapper = new CommentListWrapper();
		commentWrapper.setComment(commentLst);
		return Response.ok().entity(commentWrapper).build();
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
