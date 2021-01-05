package br.com.vivo.api.plans.application;

import br.com.vivo.api.plans.domain.plans.objetcValue.ConnectionCostWithPlan;
import br.com.vivo.api.plans.domain.plans.objetcValue.ConnectionCostWithoutPlan;
import br.com.vivo.api.plans.domain.taxs.DDDType;
import br.com.vivo.api.plans.domain.taxs.services.TariffService;
import br.com.vivo.api.plans.infra.dto.PainelRequest;
import br.com.vivo.api.plans.infra.dto.PainelResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class PainelWrapper {

    private final TariffService tariffEnabled;

    public PainelResponse calculate(final PainelRequest request) {

        final DDDType origin = DDDType.getTypeByDescrition(request.getOrigin());
        final DDDType destiny = DDDType.getTypeByDescrition(request.getDestiny());
        final double tariffForPlan = tariffEnabled.findTaxForPlans(origin, destiny);

        final var withPlan = new ConnectionCostWithPlan(request.getMinutes(), tariffForPlan, request.getType());
        final var withoutPlan = new ConnectionCostWithoutPlan(request.getMinutes(), tariffForPlan);

        return PainelResponse
            .builder()
            .valueWithPlan(withPlan.calculate())
            .valueWithoutPlan(withoutPlan.calculate())
            .build();
    }

}
