package org.acme;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
	@Path("bad")
    public Response bad() {
		System.out.println("bad: someone called me");
        return Response.status(400).entity("Bad stuff ...\n").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("badjson")
    public Response badjson() {
		String reason = "badjson: someone called me";
		System.out.println(reason);
		ErrorCorreio e = new ErrorCorreio();
		e.setCode(171);
		e.setReason(reason);
        return Response.status(400).entity(e).build();
    }

	public static class ErrorCorreio {

		private int code;
		private String reason;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}
	}
}
