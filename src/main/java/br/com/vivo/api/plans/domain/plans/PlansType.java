package br.com.vivo.api.plans.domain.plans;

import lombok.AllArgsConstructor;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
@AllArgsConstructor
public enum PlansType  {

    TALK_MORE_30(30){
        @Override
        public double calculate(final int minute, final double value) {
            if (minute <= TALK_MORE_30.time){
                return 0;
            }
            return (minute - TALK_MORE_30.time) * value * 0.10;
        }
    },
    TALK_MORE_60(60){
        @Override
        public double calculate(final int minute, final double value) {
            if (minute <= TALK_MORE_60.time){
                return 0;
            }
            return  (minute - TALK_MORE_60.time) * value * 0.10;
        }
    },
    TALK_MORE_120(120){
        @Override
        public double calculate(final int minute, final double value) {
            if (minute <= TALK_MORE_120.time){
                return 0;
            }
            return  (minute - TALK_MORE_60.time) * value * 0.10;
        }


    };

    public int time;

    public abstract double calculate(final int minute, final double value);


}
