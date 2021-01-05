package br.com.vivo.api.plans.restapi;

import br.com.vivo.api.plans.BaseIntegrationTest;
import br.com.vivo.api.plans.infra.dto.PainelRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.com.vivo.api.plans.domain.plans.PlansType.TALK_MORE_120;
import static br.com.vivo.api.plans.restapi.PainelControllerIntegrationEndpointTest.requestCalculation;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/01/2021
 */
@ExtendWith(SpringExtension.class)
public class BeanValidationIntegrationIntegrationTest extends BaseIntegrationTest {

    @Test
    public void given_120_minute_plan_when_origin_018_and_destination_011_then_45_minutes_value_is(){

        final PainelRequest build = createPainelRequest(77, null, null, TALK_MORE_120);
        requestCalculation(build).log().all()
            .statusCode(400)
            .body("message", is("Dados enviados inválidos, verificar campos"))
            .body("code", is("request_fields_error"))
            .body("short_message", is("Requisição com campos inválidos"))

            .body("errors.message", hasSize(2))
            .body("errors.message", hasItem("Para o cálculo, é necessário informar o DDD de destino"))
            .body("errors.field", hasItem("destiny"))
            .body("errors.short_message", hasItem("class error: painelRequest"))

            .body("errors.message", hasItem("Para o cálculo, é necessário informar o DDD de origem"))
            .body("errors.field", hasItem("origin"))
            .body("errors.short_message", hasItem("class error: painelRequest"))
        ;
    }

}
