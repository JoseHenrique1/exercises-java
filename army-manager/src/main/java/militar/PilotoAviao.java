package militar;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PilotoAviao extends Militar implements LicencaAviao{
    private final LocalDate validadeLicencaAviao;

    public PilotoAviao(BigDecimal salario, LocalDate validadeLicencaAviao) {
        super(salario);
        this.validadeLicencaAviao = validadeLicencaAviao;
    }

    @Override
    public LocalDate getValidadeLicencaAviao() {
        return validadeLicencaAviao;
    }
}
