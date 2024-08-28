package org.sanjay.javabrains.messanger.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("demoparams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InjectDemoResource {
	
	@GET
	@Path("/annotations")
	public String showHeaderValues(@HeaderParam("key1") String key1,@CookieParam("testcookie") String testcookie) {
		//This is to show how we can pass header and cookie values
		return "Show Headers ==>"+key1+ "Show Cookie ===>"+testcookie;
	}
	
	//@context annotation is a special type of annotation which will be used to get only few type of params example UriInfo, HttpHeaders cookies etc
	@GET
	@Path("/contextannoattion")
	public String getParamsUsingContext(@Context UriInfo uriinfo,@Context HttpHeaders httpHeader) {
		
		String path = uriinfo.getAbsolutePath().toString();
		
		String headers = httpHeader.getHeaderString("key1");
		 
		return "Context Annotation Example"+path+" Headers ===>"+headers;
	}

}
