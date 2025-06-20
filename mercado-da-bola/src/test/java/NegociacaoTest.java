import apetitefinanceiro.Conservador;
import apetitefinanceiro.Indiferente;
import apetitefinanceiro.Mercenario;
import clube.Clube;
import jogador.*;
import negociacao.Negociacao;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NegociacaoTest {
    @Test
    public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa() {

        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Grêmio", 10, BigDecimal.valueOf(100000000));
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, new Indiferente(), BigDecimal.valueOf(800500), 12);

        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

        Assert.assertTrue(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua() {

        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 3, BigDecimal.valueOf(100000000));
        Atacante atacante = new Atacante("Cristiano Ronaldo", 35, null, 10, new Conservador(), BigDecimal.valueOf(800500), 20);

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public  void naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel() {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 3, BigDecimal.valueOf(0));
        Atacante atacante = new Atacante("Cristiano Ronaldo", 35, null, 10, new Conservador(), BigDecimal.valueOf(800500), 20);

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        Assert.assertFalse(foiPossivelNegociar);


    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos() {
        Jogador meioCampo = new MeioCampo("Cristiano Ronaldo", 29, null, 10, new Conservador(), BigDecimal.valueOf(100));
        BigDecimal precoEsperado = new BigDecimal(140);

        Assert.assertEquals(precoEsperado, meioCampo.getValorDeCompra());
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos() {
        Jogador meioCampo = new MeioCampo("Cristiano Ronaldo", 39, null, 10, new Conservador(), new BigDecimal("100"));
        BigDecimal precoEsperado = new BigDecimal("98").setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(precoEsperado, meioCampo.getValorDeCompra().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDeLateralMercenario () {
        Jogador lateral = new Lateral("Rodinei", 18, null, 1, new Mercenario(), new BigDecimal(100), 5);
        BigDecimal precoEsperado = new BigDecimal("198").setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(precoEsperado, lateral.getValorDeCompra().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDeZagueiroMercenario () {
        Jogador lateral = new Zagueiro("Rodinei", 38, null, 1, new Indiferente(), new BigDecimal(100));
        BigDecimal precoEsperado = new BigDecimal("80").setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(precoEsperado, lateral.getValorDeCompra().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    public void deveRetornarCorretamenteONomeLateralComClube () {
        Clube clube = new Clube("Internacional", 3, BigDecimal.valueOf(0));
        Jogador lateral = new Zagueiro("Rodinei", 38, clube, 1, new Indiferente(), new BigDecimal(100));

        String nomeClubeEsperado = clube.getNome();

        Assert.assertSame(nomeClubeEsperado, lateral.getClubeAtual().getNome());
    }

}
