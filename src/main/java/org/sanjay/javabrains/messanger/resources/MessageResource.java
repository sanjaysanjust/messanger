package org.sanjay.javabrains.messanger.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import org.sanjay.javabrains.messanger.model.Message;
import org.sanjay.javabrains.messanger.model.MessageListWrapper;
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
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/messages")
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService ms = new MessageService();

	/*
	 * @GET public List<Message> getAllMessages(@BeanParam MessageFillterBean
	 * messageFileterBean) throws ParseException { if (messageFileterBean.getYear()
	 * > 0) { return ms.getAllMessagesForYear(messageFileterBean.getYear()); } if
	 * (messageFileterBean.getStart() >= 0 && messageFileterBean.getSize() > 0) {
	 * return ms.getAllMessagesPaginated(messageFileterBean.getStart(),
	 * messageFileterBean.getSize()); } return ms.getAllMessages(); }
	 */

	@GET
	public Response getAllMessagesRespnseExample(@BeanParam MessageFillterBean messageFileterBean)
			throws ParseException {
		System.out.println("Inside controller");
		if (messageFileterBean.getYear() > 0) {
			// return ms.getAllMessagesForYear(messageFileterBean.getYear());
			return Response.ok().entity(messageFileterBean)
					.entity(ms.getAllMessagesForYear(messageFileterBean.getYear())).build();
		}
		if (messageFileterBean.getStart() >= 0 && messageFileterBean.getSize() > 0) {
			// return ms.getAllMessagesPaginated(messageFileterBean.getStart(),
			// messageFileterBean.getSize());

			return Response.ok()
					.entity(ms.getAllMessagesPaginated(messageFileterBean.getStart(), messageFileterBean.getSize()))
					.build();
			// messageFileterBean.getSize()))
		}
		System.out.println("Output ==>" + ms.getAllMessages());
		List<Message> ml = ms.getAllMessages();
		MessageListWrapper listWrapper = new MessageListWrapper(ml);
		Response rsp = Response.ok().entity(listWrapper).build();
		return rsp;
	}

	/*
	 * @GET
	 * 
	 * @Path("/{messageId}") public Message getMessage(@PathParam("messageId") long
	 * messageId) {
	 * 
	 * return ms.getMessage(messageId); }
	 */

	@GET
	@Path("/{messageId}")
	public Response getMessageResponseExample(@PathParam("messageId") long messageId) {

		// return ms.getMessage(messageId);
		Message m = ms.getMessage(messageId);
		return Response.ok().entity(m).build();
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
	public Response updateResource(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		//return ms.updateMessage(message);
		return Response.ok().entity(ms.updateMessage(message)).build();
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
