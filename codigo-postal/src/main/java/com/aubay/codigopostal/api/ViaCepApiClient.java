package com.aubay.codigopostal.api;

import com.aubay.codigopostal.dto.CepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "viacep.com.br/ws/")
public interface ViaCepApiClient {

    @GetMapping(value = "{cep}/json", produces = "application/json")
    CepResponse getViaCep(@PathVariable("cep") String cep);

}
