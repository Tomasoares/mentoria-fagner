package com.aubay.codigopostal.service;

import com.aubay.codigopostal.api.ViaCepApiClient;
import com.aubay.codigopostal.dto.CepResponse;
import com.aubay.codigopostal.repository.CepRepository;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CodigoPostalService {

    private ViaCepApiClient client;

    private CepRepository repository;

    private static final Logger LOG = LoggerFactory.getLogger(CodigoPostalService.class);

    public CodigoPostalService(ViaCepApiClient client, CepRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    public CepResponse getCodigoPostal(String cep) {
        if (Strings.isBlank(cep)) {
            throw new IllegalArgumentException("passa um cep aí!");
        }

        LOG.info("Getting CEP from Cache: {}", cep);
        CepResponse fromCache = repository.findByCep(cep);
        LOG.info("Retrieved CEP: {}", fromCache);

        if (fromCache == null) {
            CepResponse viaCep = this.client.getViaCep(cep);
            repository.save(viaCep);
            fromCache = viaCep;
        }

        return fromCache;
    }

}
