package br.com.vivo.api.plans.domain.plans;

public abstract class Connection implements CalculatorFinal {

    protected int time;

    protected double value;

    protected PlansType type;


    protected Connection(final int time, final double value, final PlansType type) {
        this.time = time;
        this.value = value;
        this.type = type;
    }

    protected Connection(final int time, final double value){
        this.time = time;
        this.value = value;

    }

}
