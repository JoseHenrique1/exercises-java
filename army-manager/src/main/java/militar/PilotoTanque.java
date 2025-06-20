package militar;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PilotoTanque extends Militar implements LicencaTanque{
    private final LocalDate validadeLicencaTanque;

    public PilotoTanque(BigDecimal salario, LocalDate validadeLicencaTanque) {
        super(salario);
        this.validadeLicencaTanque = validadeLicencaTanque;
    }

    @Override
    public LocalDate getValidadeLicencaTanque() {
        return validadeLicencaTanque;
    }
}
