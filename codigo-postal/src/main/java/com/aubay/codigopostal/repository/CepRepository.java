package com.aubay.codigopostal.repository;

import com.aubay.codigopostal.dto.CepResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CepRepository extends MongoRepository<CepResponse, String> {

    CepResponse findByCep(String cep);

}
