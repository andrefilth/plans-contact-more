package br.com.vivo.api.plans.domain.taxs.services;

import br.com.vivo.api.plans.domain.taxs.DDDType;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
public class Tariff {


    private static final double ONE_NINE = 1.9;
    private static final double ONE_SEVEN = 1.7;
    private static final double TWO_SEVEN = 1.7;
    private static final double TWO_NINE = 2.9;
    private static final double ZERO_NINETY = 0.9;
    private String origin;

    private String destiny;


    /**
     * Instantiates a new Tariff.
     *
     * @param origin the origin
     * @param destiny the destiny
     */
    public Tariff(final DDDType origin, final DDDType destiny) {
        this.origin = origin.getDescrition();
        this.destiny = destiny.getDescrition();
    }

    public double getTax(){
        if(this.origin.equals("011") && this.destiny.equals("016")){
            return ONE_NINE;
        }
        if(this.origin.equals("016") && this.destiny.equals("011")){
            return TWO_NINE;
        }
        if(this.origin.equals("011") && this.destiny.equals("017")){
            return ONE_SEVEN;
        }
        if(this.origin.equals("017") && this.destiny.equals("011")){
            return TWO_SEVEN;
        }
        if(this.origin.equals("011") && this.destiny.equals("018")){
            return ZERO_NINETY;
        }
        if(this.origin.equals("018") && this.destiny.equals("011")){
            return ZERO_NINETY;
        }
        throw new RuntimeException();
    }

}
