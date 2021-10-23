package com.aubay.codigopostal.controller;

import com.aubay.codigopostal.dto.CepResponse;
import com.aubay.codigopostal.service.CodigoPostalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CodigoPostalController {

    private CodigoPostalService service;

    public CodigoPostalController(CodigoPostalService service) {
        this.service = service;
    }

    @GetMapping("{cep}")
    public ResponseEntity<CepResponse> getCodigoPostal(@PathVariable String cep) {
        return ResponseEntity.ok(service.getCodigoPostal(cep));
    }


}
