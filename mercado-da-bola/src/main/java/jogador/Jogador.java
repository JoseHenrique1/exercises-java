package jogador;
import apetitefinanceiro.ApetiteFinanceiro;
import clube.Clube;

import java.math.BigDecimal;

public class Jogador {
    public static final String SEM_CLUBE = "Sem clube";

    private String nome;
    private int idade;
    private Clube clubeAtual;
    private int reputacaoHistorica;// 0 - 10
    private ApetiteFinanceiro apetiteFinanceiro;
    private BigDecimal preco;

    public Jogador(String nome, int idade, Clube clubeAtual, int reputacaoHistorica, ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco) {
        this.nome = nome;
        this.idade = idade;
        this.clubeAtual = clubeAtual;
        this.reputacaoHistorica = reputacaoHistorica;
        this.apetiteFinanceiro = apetiteFinanceiro;
        this.preco = preco;
    }

    public String getNomeClubeAtual() {
        if (this.clubeAtual == null) {
            return SEM_CLUBE;
        }
        return clubeAtual.getNome();
    }

    public boolean interesseEmTransferencia(Clube clubeInteressado) {
        return clubeInteressado.getReputacaoHistorica() >= 1;
    }

    public BigDecimal getValorDeCompra (){
        BigDecimal porcentagem = BigDecimal.valueOf(this.apetiteFinanceiro.getPorcentagem());
        BigDecimal bonus = this.preco.divide(BigDecimal.valueOf(100)).multiply(porcentagem);
        return this.preco.add(bonus);
    }

    public void  transferenciaClube(Clube novoClube) {
        this.clubeAtual = novoClube;
    }

    public int getIdade() {
        return idade;
    }

    public int getReputacaoHistorica() {
        return reputacaoHistorica;
    }

    public Clube getClubeAtual() {
        return clubeAtual;
    }
}
