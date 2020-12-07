package br.com.vivo.api.plans.domain.plans;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
@FunctionalInterface
public interface Calculator {

    double calculate(final int minute, final double value);
}
