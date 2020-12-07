package br.com.vivo.api.plans.domain.plans.objetcValue;

import br.com.vivo.api.plans.domain.plans.PlansType;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
public class ConnectionCostWithPlan implements CalculatorFinal {

    private final int time;

    private final double value;

    private final PlansType type;


    /**
     * Instantiates a new Connection cost with plan.
     *
     * @param time the time
     * @param value the value
     * @param type the type
     */
    public ConnectionCostWithPlan(final int time, final double value, final PlansType type) {
        this.time = time;
        this.value = value;
        this.type = type;
    }


    @Override
    public double calculate() {

        return type.calculate(time, value);
    }

}
