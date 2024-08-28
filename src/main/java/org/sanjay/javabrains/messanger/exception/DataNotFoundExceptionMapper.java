package org.sanjay.javabrains.messanger.exception;

import org.sanjay.javabrains.messanger.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage errMessage = new ErrorMessage(exception.getMessage(), 404, "www.google.com");
		return Response.status(Status.NOT_FOUND).entity(errMessage).build();
	}

}
