package br.com.vivo.api.plans.infra.handler;

import br.com.vivo.api.plans.infra.extractor.NotValidExceptionToErroRespondeExtractor;
import br.com.vivo.api.plans.infra.handler.exception.badrequest.BadRequestException;
import br.com.vivo.api.plans.infra.handler.model.ErrorModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
@RequiredArgsConstructor
@RestControllerAdvice
public class ControllerAdviceHandler {

    private final NotValidExceptionToErroRespondeExtractor fiedToErroRespondeExtractor;

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorModel handler(final MethodArgumentNotValidException exception) {

        return fiedToErroRespondeExtractor.extract(exception);
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(BadRequestException.class)
    public ErrorModel handler(final BadRequestException exception) {
        return exception.getErrorModel();
    }

}
