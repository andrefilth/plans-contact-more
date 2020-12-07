package br.com.vivo.api.plans.restapi;

import br.com.vivo.api.plans.application.PainelWrapper;
import br.com.vivo.api.plans.infra.dto.PainelRequest;
import br.com.vivo.api.plans.infra.dto.PainelResponse;
import br.com.vivo.api.plans.infra.handler.exception.badrequest.UndefinedDDDTypeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
@Api(tags = "Realiza o calculo de uma ligação")
@RestController
@RequestMapping(value = "plans", produces = "application/json; charset=UTF-8")
@RequiredArgsConstructor
public class PainelController {

    private final PainelWrapper wrapper;

    @ApiOperation(value = "Calcula o valor da ligação.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Created", response = PainelResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = UndefinedDDDTypeException.class)
    })
    @ResponseStatus(OK)
    @PostMapping("calculation")
    public PainelResponse createToken(@RequestBody @Valid final PainelRequest request) {

        return wrapper.calculate(request);
    }
}
