package org.aubay;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.aubay.model.Endereco;
import org.aubay.model.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PessoaResourceTest {

    @Test
    public void testPessoaEndpoint() {
        given()
          .when().get("/pessoa")
          .then()
             .statusCode(200);
    }

    @Test
    public void testPessoaEndpoint2() {
        Pessoa p = new Pessoa();
        p.nome = "12";
        p.endereco = new Endereco();
        p.endereco.cep = "88110690";

        Response response = given()
                .when()
                .header("Content-type", "application/json")
                .body(p)
                .post("/pessoa")
                .then()
                .extract()
                .response();

        Assertions.assertEquals(200, response.getStatusCode());
    }

}