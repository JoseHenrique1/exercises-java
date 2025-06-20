package militar;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PilotoHelicoptero extends Militar implements LicencaHelicoptero{
    private final LocalDate validadeLicencaHelicoptero;

    public PilotoHelicoptero(BigDecimal salario, LocalDate validadeLicencaHelicoptero) {
        super(salario);
        this.validadeLicencaHelicoptero = validadeLicencaHelicoptero;
    }

    @Override
    public LocalDate getValidadeLicencaHelicoptero() {
        return validadeLicencaHelicoptero;
    }
}
