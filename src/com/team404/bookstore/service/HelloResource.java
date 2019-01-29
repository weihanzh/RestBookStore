package com.team404.bookstore.service;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource
{
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello World!" ;
    }
    @GET
    @Path("/{uname}")
    @Produces("text/plain;charset=UTF-8")
    public String sayHelloToUTF8(@PathParam("uname") String username) {
        return "Hello " + username;
    }
}
