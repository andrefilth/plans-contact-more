package br.com.vivo.api.plans.domain.plans;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
public class ConnectionCostWithPlan  extends Connection {


    public ConnectionCostWithPlan(int time, double value, PlansType type) {
        super(time, value, type);
    }

    @Override
    public double calculate() {
        return type.calculate(time, value);
    }
}

