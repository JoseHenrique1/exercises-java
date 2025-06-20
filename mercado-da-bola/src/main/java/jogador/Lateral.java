package jogador;

import apetitefinanceiro.ApetiteFinanceiro;
import clube.Clube;

import java.math.BigDecimal;

public class Lateral extends Jogador{
    private int quantidadeCruzamentosCertos;

    public Lateral(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco, int quantidadeCruzamentosCertos) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.quantidadeCruzamentosCertos = quantidadeCruzamentosCertos;
    }

    public BigDecimal getValorDeCompra (){
        BigDecimal valorDeCompra = super.getValorDeCompra();
        int porcentagemBonusPorCruzamentoCerto = 2 * this.quantidadeCruzamentosCertos;

        BigDecimal novoValorDeCompra = valorDeCompra.add(valorDeCompra.divide(new BigDecimal(100)).multiply(new BigDecimal(porcentagemBonusPorCruzamentoCerto)));
        if (this.getIdade() > 28) {
            return novoValorDeCompra.subtract(novoValorDeCompra.divide(new BigDecimal(100)).multiply(new BigDecimal(30)));
        }
        return  novoValorDeCompra;
    }

}





