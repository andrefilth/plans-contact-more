/*
 * @(#)FiedToErroRespondeExtractor.java 1.0 31/10/2020
 *
 * Copyright (c) 2020, PicPay S.A. All rights reserved.
 * PicPay S.A. proprietary/confidential. Use is subject to license terms.
 */

package br.com.vivo.api.plans.infra.extractor;

import br.com.vivo.api.plans.infra.handler.model.ErrorModel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 06/10/2020
 */
@RequiredArgsConstructor
@Component
public class FiedToErroRespondeExtractor implements Extractor<FieldError, ErrorModel> {

    private final MessageSource messageSource;

    @Override
    public ErrorModel extract(final FieldError extract) {
        final String message = messageSource.getMessage(extract, LocaleContextHolder.getLocale());
        final String field = extract.getField();
        final String objectName = extract.getObjectName();
        return ErrorModel
            .builder()
            .message(message)
            .field(field)
            .shortMessage(String.format("class error: %s", objectName))
            .build();
    }

}
