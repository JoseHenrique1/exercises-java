package clube;

import java.math.BigDecimal;

public class Clube {
    private String nome;
    private  int reputacaoHistorica; // 0 - 10
    private BigDecimal saldo;

    public Clube(String nome, int reputacaoHistorica, BigDecimal saldo) {
        this.nome = nome;
        this.reputacaoHistorica = reputacaoHistorica;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public int getReputacaoHistorica() {
        return reputacaoHistorica;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
