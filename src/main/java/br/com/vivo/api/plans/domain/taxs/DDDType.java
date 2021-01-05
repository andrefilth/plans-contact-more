package br.com.vivo.api.plans.domain.taxs;

import br.com.vivo.api.plans.infra.handler.exception.badRequest.UndefinedDDDTypeException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Stream;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
@AllArgsConstructor
public enum DDDType {

    ONZE("011"), DEZESSEIS("016"), DEZESSETE("017"), DEZOITO("018");


    @Getter
    private final String descrition;

    public static List<String> getDescritions(){
        return DDDType.getDescritions();
    }

    public static DDDType getTypeByDescrition(final String descrition) {
        return Stream.of(values())
            .filter(type -> descrition.equals(type.getDescrition()))
            .findFirst()
            .orElseThrow(() -> new UndefinedDDDTypeException(descrition));
    }

}
