package org.aubay;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.aubay.integracao.CodigoPostalService;
import org.aubay.model.EnderecoResponse;
import org.aubay.model.Pessoa;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pessoas")
public class PessoaResource {

    @Inject
    @RestClient
    CodigoPostalService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> getPessoa() {
        return Pessoa.listAll();
    }

    @POST
    @Transactional
    public Pessoa savePessoa(Pessoa p) {
        EnderecoResponse cep = service.getCep(p.endereco.cep);
        p.endereco.bairro = cep.getBairro();
        Pessoa.persist(p);

        return p;
    }

}