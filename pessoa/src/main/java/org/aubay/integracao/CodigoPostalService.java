package org.aubay.integracao;

import org.aubay.model.EnderecoResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/v1/")
@RegisterRestClient
public interface CodigoPostalService {

    @GET
    @Path("{cep}")
    EnderecoResponse getCep(@PathParam String cep);

}
