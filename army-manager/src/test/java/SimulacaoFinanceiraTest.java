import militar.*;
import org.junit.Assert;
import org.junit.Test;
import simulacaofinanceira.SimulacaoFinanceira;
import veiculo.Aviao;
import veiculo.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SimulacaoFinanceiraTest {
    @Test
    public void deveCalcularOCustoTotalDaMissaoCorretamente () {
        Elite elite = new Elite(BigDecimal.valueOf(1000), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1));
        List<Militar> tripulacao = new ArrayList<>();
        tripulacao.add(elite);
        tripulacao.add(elite);
        tripulacao.add(elite);
        Aviao aviao = new Aviao(elite, tripulacao, 1, 1);
        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(aviao);

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1000, veiculos, 1);

        BigDecimal valorEsperado = BigDecimal.valueOf(5000).setScale(2);

        Assert.assertEquals(valorEsperado, simulacao.getCustoTotalMissao().setScale(2));
    }


    @Test
    public void deveCalcularOCustoTotalComCombustivelCorretamente () {
        Elite elite = new Elite(BigDecimal.valueOf(0), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1));
        List<Militar> tripulacao = new ArrayList<>();
        tripulacao.add(elite);
        tripulacao.add(elite);
        tripulacao.add(elite);
        Aviao aviao = new Aviao(elite, tripulacao, 1, 1000);
        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(aviao);

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(70, veiculos, 1);

        BigDecimal valorEsperado = BigDecimal.valueOf(70000).setScale(2);

        Assert.assertEquals(valorEsperado, simulacao.getCustoTotalMissao().setScale(2));
    }

    @Test
    public void deveCalcularOCustoToralComSalariosCorretamente(){
        Elite elite = new Elite(BigDecimal.valueOf(300), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1));
        List<Militar> tripulacao = new ArrayList<>();
        tripulacao.add(elite);
        tripulacao.add(elite);
        tripulacao.add(elite);
        Aviao aviao = new Aviao(elite, tripulacao, 1, 0);
        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(aviao);

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1, veiculos, 1);

        BigDecimal valorEsperado = BigDecimal.valueOf(1200).setScale(2);

        Assert.assertEquals(valorEsperado, simulacao.getCustoTotalMissao().setScale(2));
    }

    @Test
    public void deveValidarTodosVeiculosCorretamente(){
        Elite elite = new Elite(BigDecimal.valueOf(300), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1));
        PilotoTanque pilotoTanque = new PilotoTanque(BigDecimal.valueOf(300), LocalDate.of(2050,1,1));

        List<Militar> tripulacao = new ArrayList<>();
        tripulacao.add(pilotoTanque);
        Aviao aviao = new Aviao(elite, tripulacao, 1, 0);
        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(aviao);

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1, veiculos, 1);

        Assert.assertTrue(simulacao.todasTripulacoesValidas());
    }
}
