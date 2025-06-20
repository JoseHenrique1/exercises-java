package jogador;

import apetitefinanceiro.ApetiteFinanceiro;
import clube.Clube;

import java.math.BigDecimal;

public class MeioCampo extends Jogador {
    public MeioCampo(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
    }

    public BigDecimal getValorDeCompra (){
        BigDecimal valorDeCompra = super.getValorDeCompra();
        if (this.getIdade()>30) {
            return valorDeCompra.subtract(valorDeCompra.multiply(BigDecimal.valueOf(0.3)));
        }
        return valorDeCompra;
    }

    public boolean interesseEmTransferencia(Clube clubeInteressado) {
        return clubeInteressado.getReputacaoHistorica() <= (getReputacaoHistorica()-2);
    }
}
