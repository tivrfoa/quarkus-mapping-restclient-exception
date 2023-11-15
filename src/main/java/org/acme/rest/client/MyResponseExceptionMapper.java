// https://stackoverflow.com/questions/64213483/quarkus-microprofile-rest-client-responseexceptionmapper-doesnt-catch-errors

package org.acme.rest.client;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import jakarta.ws.rs.core.Response;

public class MyResponseExceptionMapper implements ResponseExceptionMapper<CorreiosException> {

   @Override
   public CorreiosException toThrowable(Response response) {
        System.err.println(response.getEntity());
       return new CorreiosException(response.getStatus() + " - " + response.readEntity(String.class));
   }
}
