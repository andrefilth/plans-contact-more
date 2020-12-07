package br.com.vivo.api.plans.domain.plans.objetcValue;

import br.com.vivo.api.plans.domain.plans.PlansType;
import lombok.AllArgsConstructor;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
@AllArgsConstructor
public class ConnectionCostWithoutPlan implements CalculatorFinal {

    private final int time;

    private final double value;

    @Override
    public double calculate() {
        return time * value;
    }

}
