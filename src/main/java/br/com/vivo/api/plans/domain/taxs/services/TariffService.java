package br.com.vivo.api.plans.domain.taxs.services;

import br.com.vivo.api.plans.domain.taxs.DDDType;
import org.springframework.stereotype.Component;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
@Component
public class TariffService {

    public double findTaxForPlans(final DDDType origin, final DDDType destiny) {
        final var tariff = new Tariff(origin, destiny);
        return tariff.getTax();
    }

}
