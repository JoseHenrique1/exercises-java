package militar;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EspecialistaTerrestre extends Militar implements LicencaTanque, LicencaCaminhao{
    private final LocalDate validadeLicencaTanque;
    private final LocalDate validadeLicencaCaminhao;

    public EspecialistaTerrestre(BigDecimal salario, LocalDate validadeLicencaTanque, LocalDate validadeLicencaCaminhao) {
        super(salario);
        this.validadeLicencaTanque = validadeLicencaTanque;
        this.validadeLicencaCaminhao = validadeLicencaCaminhao;
    }

    @Override
    public LocalDate getValidadeLicencaTanque() {
        return validadeLicencaTanque;
    }

    @Override
    public LocalDate getValidadeLicencaCaminhao() {
        return validadeLicencaCaminhao;
    }
}
