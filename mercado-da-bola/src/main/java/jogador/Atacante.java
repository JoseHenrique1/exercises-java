package jogador;

import apetitefinanceiro.ApetiteFinanceiro;
import clube.Clube;

import java.math.BigDecimal;

public class Atacante extends  Jogador {
    private int  quantidadeGols;

    public Atacante(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco, int quantidadeGols) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.quantidadeGols = quantidadeGols;
    }

    public BigDecimal getValorDeCompra (){
        BigDecimal valorDeCompra = super.getValorDeCompra();
        int porcentagemBonusPorGol = 4 * this.quantidadeGols;
        BigDecimal novoValorDeCompra = valorDeCompra.divide(new BigDecimal(100)).multiply(new BigDecimal(porcentagemBonusPorGol));
        if (this.getIdade() > 30) {
            return novoValorDeCompra.subtract(novoValorDeCompra.divide(new BigDecimal(100)).multiply(new BigDecimal(25)));
        }
        return  novoValorDeCompra;
    }

    public boolean interesseEmTransferencia(Clube clubeInteressado) {
        return clubeInteressado.getReputacaoHistorica() > this.getReputacaoHistorica();
    }
}

