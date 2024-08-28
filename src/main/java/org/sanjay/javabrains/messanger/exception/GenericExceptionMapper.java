package org.sanjay.javabrains.messanger.exception;

import org.sanjay.javabrains.messanger.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errMsg = new ErrorMessage(exception.getMessage(), 500, "www.google.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errMsg).build();
	}

}
