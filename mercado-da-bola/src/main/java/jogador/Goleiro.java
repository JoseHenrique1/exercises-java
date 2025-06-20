package jogador;

import apetitefinanceiro.ApetiteFinanceiro;
import clube.Clube;

import java.math.BigDecimal;

public class Goleiro extends Jogador {
    private  int quantidadeDePenaltisDefendidos;

    public Goleiro(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco, int quantidadeDePenaltisDefendidos) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.quantidadeDePenaltisDefendidos = quantidadeDePenaltisDefendidos;
    }

    public BigDecimal getValorDeCompra (){
        BigDecimal valorDeCompra = super.getValorDeCompra();
        BigDecimal porcentagemBonusPorPenaltiDefendido = new BigDecimal(4 * this.quantidadeDePenaltisDefendidos);
        BigDecimal bonus = valorDeCompra.divide(new BigDecimal(100)).multiply(porcentagemBonusPorPenaltiDefendido);
        return  valorDeCompra.add(bonus);
    }

}
