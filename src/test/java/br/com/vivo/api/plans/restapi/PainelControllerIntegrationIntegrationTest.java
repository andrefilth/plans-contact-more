package br.com.vivo.api.plans.restapi;

import br.com.vivo.api.plans.BaseIntegrationTest;
import br.com.vivo.api.plans.infra.dto.PainelRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.com.vivo.api.plans.domain.plans.PlansType.TALK_MORE_120;
import static br.com.vivo.api.plans.domain.plans.PlansType.TALK_MORE_30;
import static br.com.vivo.api.plans.restapi.PainelControllerIntegrationEndpointTest.requestCalculation;
import static org.hamcrest.Matchers.equalTo;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 04/01/2021
 */
@ExtendWith(SpringExtension.class)
class PainelControllerIntegrationIntegrationTest extends BaseIntegrationTest {


    @Test
    public void given_120_minute_plan_when_origin_018_and_destination_011_then_45_minutes_value_is(){

        final PainelRequest build = createPainelRequest(80, "017", "011", TALK_MORE_120);
        requestCalculation(build)
        .statusCode(200)
            .body("value_without_plan", equalTo(136.0f))
            .body("value_with_plan", equalTo(0.0f))
        ;
    }
    @Test
    public void given_30_minute_plan_when_origin_017_and_destination_011_then_45_minutes_value_iss(){

        final PainelRequest build = createPainelRequest(45, "017", "011", TALK_MORE_30);
        requestCalculation(build)
        .statusCode(200)
        .body("value_without_plan", equalTo(76.5f))
        .body("value_with_plan", equalTo(2.550f))
        ;
    }



}