package br.com.vivo.api.plans.infra.dto;

import br.com.vivo.api.plans.domain.plans.PlansType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
@JsonPropertyOrder({"minutes", "origin", "destiny", "type"})
@Builder
@Getter
public class PainelRequest {

    @ApiModelProperty(
        example = "30",
        required = true
    )
    private final int minutes;

    @ApiModelProperty(
        example = "011",
        required = true
    )
    @NotBlank(message = "Para o cálculo, é necessário informar o DDD de origem")
    private final String origin;

    @ApiModelProperty(
        example = "016",
        required = true
    )
    @NotBlank(message = "Para o cálculo, é necessário informar o DDD de destino")
    private final String destiny;

    private final PlansType type;


}
