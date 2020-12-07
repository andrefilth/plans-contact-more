package br.com.vivo.api.plans.infra.handler.exception.badrequest;

import br.com.vivo.api.plans.infra.handler.exception.ApiException;
import org.springframework.http.HttpStatus;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
public class BadRequestException extends ApiException {

    private static final String CODE = HttpStatus.BAD_REQUEST.toString();
    private static final String shortMessage = "código não existe";

    /**
     * Instantiates a new Api exception.
     *
     * @param msg the msg
     */
    protected BadRequestException(final String msg) {
        super(msg, CODE, shortMessage);
    }

    /**
     * Instantiates a new Api exception.
     *
     * @param msg the msg
     * @param code the code
     * @param shortMessage the short message
     * @param data the data
     */
    protected BadRequestException(final String msg, final String code, final String shortMessage, final Object data) {
        super(msg, code, shortMessage, data);
    }

}
