package br.com.vivo.api.plans.restapi;

import br.com.vivo.api.plans.infra.dto.PainelRequest;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 04/01/2021
 */
public class PainelControllerIntegrationEndpointTest {

    public static ValidatableResponse requestCalculation(final PainelRequest painelRequest) {
        return given()
            .contentType(JSON)
            .body(painelRequest)
            .post("plans/calculation")
            .then()
            ;
    }

}
