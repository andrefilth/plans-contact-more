package br.com.vivo.api.plans.domain.plans;

import lombok.AllArgsConstructor;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */

public class ConnectionCostWithoutPlan extends Connection {


    public ConnectionCostWithoutPlan(int time, double value) {
        super(time, value);
    }

    @Override
    public double calculate() {
        return time * value;
    }

}
