/*
 * @(#)NotValidExceptionToErroRespondeExtractor.java 1.0 31/10/2020
 *
 * Copyright (c) 2020, PicPay S.A. All rights reserved.
 * PicPay S.A. proprietary/confidential. Use is subject to license terms.
 */

package br.com.vivo.api.plans.infra.extractor;

import br.com.vivo.api.plans.infra.handler.model.ErrorModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 06/10/2020
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class NotValidExceptionToErroRespondeExtractor implements Extractor<MethodArgumentNotValidException, ErrorModel> {

    private final FiedToErroRespondeExtractor fiedToErroRespondeExtractor;

    @Override
    public ErrorModel extract(final MethodArgumentNotValidException exception) {
        final Set<ErrorModel> collect = exception
            .getBindingResult()
            .getFieldErrors()
            .stream()
            .map(fiedToErroRespondeExtractor::extract)
            .collect(Collectors.toSet());
        final ErrorModel errorResponse = ErrorModel
            .builder()
            .message("Dados enviados inválidos, verificar campos")
            .code("request_fields_error")
            .shortMessage("Requisição com campos inválidos")
            .errors(collect)
            .build();
        log.info("Error response: {} ", errorResponse);
        return errorResponse;
    }

}
