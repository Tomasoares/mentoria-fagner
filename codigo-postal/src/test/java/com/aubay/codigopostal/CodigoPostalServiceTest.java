package com.aubay.codigopostal;

import com.aubay.codigopostal.api.ViaCepApiClient;
import com.aubay.codigopostal.dto.CepResponse;
import com.aubay.codigopostal.service.CodigoPostalService;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CodigoPostalServiceTest {

    @InjectMocks //nossa referencia pai, as dependencias serao mockadas
    private CodigoPostalService service;

    @Mock //dependencia a ser mockada
    private ViaCepApiClient api;

    @Test
    void deveLancarExcecaoSeCEPForInvalido() {
        when(service.getCodigoPostal(" "))
                .thenThrow(IllegalArgumentException.class);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.getCodigoPostal(" ");
        });
    }

    @Test
    void deveVirObjetoPreenchido() {
        when(api.getViaCep(any()))
                .thenReturn(new CepResponse("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"));

        CepResponse response = service.getCodigoPostal("19283721");

        Assertions.assertNotNull(response);
    }

}
