package br.com.vivo.api.plans.infra.handler.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Set;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
@JsonPropertyOrder({"message", "code", "field", "data", "short_message", "errors"})
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Builder
@Getter
public class ErrorModel {

    private static final String DEFAULT_MESSAGE = "Ops! Ocorreu um erro inesperado.";
    @JsonProperty("short_message")
    private String shortMessage;
    private String message;
    private String code;
    private String field;
    private Object data;
    private Set<ErrorModel> errors;


    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
            .append("message", message)
            .append("code", code)
            .append("field", field)
            .append("data", data)
            .append("errors", errors)
            .build();
    }
}
