package militar;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Elite extends Militar implements LicencaTanque, LicencaCaminhao, LicencaAviao, LicencaHelicoptero{
    private final LocalDate validadeLicencaTanque;
    private final LocalDate validadeLicencaCaminhao;
    private final LocalDate validadeLicencaAviao;
    private final LocalDate validadeLicencaHelicoptero;

    public Elite(BigDecimal salario, LocalDate validadeLicencaTanque, LocalDate validadeLicencaCaminhao, LocalDate validadeLicencaAviao, LocalDate validadeLicencaHelicoptero) {
        super(salario);
        this.validadeLicencaTanque = validadeLicencaTanque;
        this.validadeLicencaCaminhao = validadeLicencaCaminhao;
        this.validadeLicencaAviao = validadeLicencaAviao;
        this.validadeLicencaHelicoptero = validadeLicencaHelicoptero;
    }

    @Override
    public LocalDate getValidadeLicencaTanque() {
        return validadeLicencaTanque;
    }

    @Override
    public LocalDate getValidadeLicencaCaminhao() {
        return validadeLicencaCaminhao;
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
