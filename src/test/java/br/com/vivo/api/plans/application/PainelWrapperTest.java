package br.com.vivo.api.plans.application;

import br.com.vivo.api.plans.domain.plans.PlansType;
import br.com.vivo.api.plans.domain.taxs.DDDType;
import br.com.vivo.api.plans.domain.taxs.services.TariffService;
import br.com.vivo.api.plans.infra.dto.PainelRequest;
import br.com.vivo.api.plans.infra.dto.PainelResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 04/01/2021
 */
@ExtendWith(SpringExtension.class)
class PainelWrapperTest {

    PainelWrapper wrapper;

    @MockBean
    TariffService tariffEnabled;

    @BeforeEach
    void setUp() {
        wrapper = new PainelWrapper(tariffEnabled);
    }

    @DisplayName("Uma ligação de origem 011 e destino 016 por 30 minutos, apresenta os valores")
    @Test
    public void test_ddd_011_to_016(){
        final PainelRequest request = PainelRequest
            .builder()
            .minutes(30)
            .origin("011")
            .destiny("016")
            .type(PlansType.TALK_MORE_30)
            .build();
        final DDDType origin = DDDType.getTypeByDescrition(request.getOrigin());
        final DDDType destiny = DDDType.getTypeByDescrition(request.getDestiny());
        Mockito.when(tariffEnabled.findTaxForPlans(origin, destiny)).thenReturn(1.9);

        final PainelResponse response = wrapper.calculate(request);
        assertThat(response.getValueWithoutPlan()).isEqualTo(57.0);
        assertThat(response.getValueWithPlan()).isEqualTo(0.0);
    }
    @DisplayName("Uma ligação de origem 011 e destino 016 por 80 minutos, apresenta os valores")
    @Test
    public void test_ddd_011_to_016_80_minutes(){
        final PainelRequest request = PainelRequest
            .builder()
            .minutes(80)
            .origin("011")
            .destiny("016")
            .type(PlansType.TALK_MORE_30)
            .build();
        final DDDType origin = DDDType.getTypeByDescrition(request.getOrigin());
        final DDDType destiny = DDDType.getTypeByDescrition(request.getDestiny());
        Mockito.when(tariffEnabled.findTaxForPlans(origin, destiny)).thenReturn(1.9);

        final PainelResponse response = wrapper.calculate(request);
        assertThat(response.getValueWithoutPlan()).isEqualTo(152);
        assertThat(response.getValueWithPlan()).isEqualTo(9.5);
    }
    @DisplayName("Uma ligação de origem 017 e destino 011 por 80 minutos, apresenta os valores para planos 120")
    @Test
    public void test_ddd_017_to_011_80_minutes(){
        final PainelRequest request = PainelRequest
            .builder()
            .minutes(80)
            .origin("017")
            .destiny("011")
            .type(PlansType.TALK_MORE_120)
            .build();
        final DDDType origin = DDDType.getTypeByDescrition(request.getOrigin());
        final DDDType destiny = DDDType.getTypeByDescrition(request.getDestiny());
        Mockito.when(tariffEnabled.findTaxForPlans(origin, destiny)).thenReturn(1.7);

        final PainelResponse response = wrapper.calculate(request);
        assertThat(response.getValueWithoutPlan()).isEqualTo(136);
        assertThat(response.getValueWithPlan()).isEqualTo(0);
    }

}