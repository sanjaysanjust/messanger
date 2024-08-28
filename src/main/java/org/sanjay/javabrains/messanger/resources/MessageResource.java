package org.sanjay.javabrains.messanger.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import org.sanjay.javabrains.messanger.model.Message;
import org.sanjay.javabrains.messanger.resources.bean.MessageFillterBean;
import org.sanjay.javabrains.messanger.service.MessageService;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService ms = new MessageService();

	@GET
	public List<Message> getAllMessages(@BeanParam MessageFillterBean messageFileterBean) throws ParseException {
		
		if(messageFileterBean.getYear() > 0) {
			return ms.getAllMessagesForYear(messageFileterBean.getYear());
		}
		if(messageFileterBean.getStart()>= 0 &&  messageFileterBean.getSize() > 0) {
			return ms.getAllMessagesPaginated(messageFileterBean.getStart(), messageFileterBean.getSize());
		}
		return ms.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId) {

		return ms.getMessage(messageId);
	}
	
	

	@POST
	public Response addResource(Message message, @Context UriInfo uriinfo) {
		Message msg = ms.addMessage(message);
		String newId = String.valueOf(msg.getId());
		URI uri = uriinfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(msg).build();
		
	}

	@PUT
	@Path("/{messageId}")
	public Message updateResource(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return ms.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public Message deleteResource(@PathParam("messageId") long messageId) {
		return ms.removeMessage(messageId);
	}
	
	
	@Path("/{messageId}/comments")
	public CommentsResource comments() {
		return new CommentsResource();
	}
}
