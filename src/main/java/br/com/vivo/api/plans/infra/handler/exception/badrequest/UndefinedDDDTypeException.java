package br.com.vivo.api.plans.infra.handler.exception.badrequest;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
public class UndefinedDDDTypeException extends BadRequestException {


    /**
     * Instantiates a new Api exception.
     *
     * @param msg the msg
     */
    public UndefinedDDDTypeException(final String msg) {
        super(msg);
    }

}
