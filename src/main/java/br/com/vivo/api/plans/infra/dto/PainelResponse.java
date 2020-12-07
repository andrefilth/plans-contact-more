package br.com.vivo.api.plans.infra.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PainelResponse {

    @JsonProperty("value_without_plan")
    private final double valueWithoutPlan;

    @JsonProperty("value_with_plan")
    private final double valueWithPlan;


}
