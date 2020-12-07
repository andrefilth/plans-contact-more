package br.com.vivo.api.plans.infra.handler.exception;

import br.com.vivo.api.plans.infra.handler.model.ErrorModel;
import lombok.Getter;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
public abstract class ApiException extends RuntimeException {

    @Getter
    private final String code;

    @Getter
    private String shortMessage;

    @Getter
    private Object data;


    /**
     * Instantiates a new Api exception.
     *
     * @param msg the msg
     * @param code the code
     * @param shortMessage the short message
     */
    protected ApiException(String msg, String code, String shortMessage) {
        super(msg);
        this.code = code;
        this.shortMessage = shortMessage;
    }


    /**
     * Instantiates a new Api exception.
     *
     * @param msg the msg
     * @param code the code
     * @param shortMessage the short message
     * @param data the data
     */
    protected ApiException(String msg, String code, String shortMessage, Object data) {
        super(msg);
        this.code = code;
        this.shortMessage = shortMessage;
        this.data = data;
    }

    /**
     * Gets error model.
     *
     * @return the error model
     */
    public ErrorModel getErrorModel() {
        return ErrorModel
            .builder()
            .code(this.code)
            .message(this.getMessage())
            .shortMessage(this.shortMessage)
            .data(this.data).build();
    }

}
