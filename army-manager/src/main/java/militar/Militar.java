package militar;

import java.math.BigDecimal;

public class Militar implements Piloto{
    private final BigDecimal salario;

    public Militar(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getSalario() {
        return salario;
    }
}
