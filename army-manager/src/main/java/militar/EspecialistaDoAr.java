package militar;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EspecialistaDoAr extends Militar implements LicencaAviao, LicencaHelicoptero{
    private final LocalDate validadeLicencaAviao;
    private final LocalDate validadeLicencaHelicoptero;

    public EspecialistaDoAr(BigDecimal salario, LocalDate validadeLicencaAviao, LocalDate validadeLicencaHelicoptero) {
        super(salario);
        this.validadeLicencaAviao = validadeLicencaAviao;
        this.validadeLicencaHelicoptero = validadeLicencaHelicoptero;
    }

    @Override
    public LocalDate getValidadeLicencaAviao() {
        return validadeLicencaAviao;
    }

    @Override
    public LocalDate getValidadeLicencaHelicoptero() {
        return validadeLicencaHelicoptero;
    }
}
