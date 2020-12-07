package br.com.vivo.api.plans.infra.dto;

import br.com.vivo.api.plans.domain.plans.PlansType;
import br.com.vivo.api.plans.domain.taxs.DDDType;
import com.fasterxml.jackson.annotation.JsonInclude;
import br.com.vivo.api.plans.infra.annotation.NotNullOrNotEmpty;
import lombok.Builder;
import lombok.Getter;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
public class PainelRequest {

    private int minutes;

    @NotNullOrNotEmpty(message = "Para o cálculo, é necessário informar o DDD de origem")
    final String origin;

    @NotNullOrNotEmpty(message = "Para o cálculo, é necessário informar o DDD de destino")
    final String destiny;

    final PlansType type;


}
