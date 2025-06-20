import militar.*;
import org.junit.Assert;
import org.junit.Test;
import veiculo.Aviao;
import veiculo.Caminhao;
import veiculo.Helicoptero;
import veiculo.Tanque;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VeiculoTest {
    @Test
    public void deveValidarVeiculoCorretamente() {
        PilotoTanque pilotoTanque = new PilotoTanque(BigDecimal.valueOf(300), LocalDate.of(2050,1,1));
        PilotoAviao pilotoAviao = new PilotoAviao(BigDecimal.valueOf(300), LocalDate.of(2050,1,1));
        PilotoCaminhao pilotoCaminhao = new PilotoCaminhao(BigDecimal.valueOf(300), LocalDate.of(2050,1,1));
        PilotoHelicoptero pilotoHelicoptero = new PilotoHelicoptero(BigDecimal.valueOf(300), LocalDate.of(2050,1,1));


        List<Militar> tripulacao = new ArrayList<>();
        tripulacao.add(pilotoTanque);
        tripulacao.add(pilotoAviao);
        tripulacao.add(pilotoCaminhao);
        tripulacao.add(pilotoHelicoptero);
        tripulacao.add(pilotoTanque);
        tripulacao.add(pilotoAviao);
        tripulacao.add(pilotoCaminhao);
        tripulacao.add(pilotoHelicoptero);
        Caminhao caminhao = new Caminhao(pilotoCaminhao, tripulacao, 1, 0);

        Assert.assertTrue(caminhao.tripulacaoValida());
    }

    @Test
    public void deveInvalidarVeiculoCorretamenteQuandoLicencaEstiverVencida() {
        EspecialistaDoAr especialistaDoAr = new EspecialistaDoAr(BigDecimal.valueOf(300), LocalDate.of(2000,1,1), LocalDate.of(2000,1,1));

        PilotoTanque pilotoTanque = new PilotoTanque(BigDecimal.valueOf(300), LocalDate.of(2050,1,1));
        PilotoAviao pilotoAviao = new PilotoAviao(BigDecimal.valueOf(300), LocalDate.of(2050,1,1));
        PilotoCaminhao pilotoCaminhao = new PilotoCaminhao(BigDecimal.valueOf(300), LocalDate.of(2050,1,1));
        PilotoHelicoptero pilotoHelicoptero = new PilotoHelicoptero(BigDecimal.valueOf(300), LocalDate.of(2050,1,1));
        EspecialistaTerrestre especialistaTerrestre = new EspecialistaTerrestre(BigDecimal.valueOf(300), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1));



        List<Militar> tripulacao = new ArrayList<>();
        tripulacao.add(pilotoTanque);
        tripulacao.add(pilotoAviao);
        tripulacao.add(pilotoCaminhao);
        tripulacao.add(pilotoHelicoptero);
        tripulacao.add(especialistaTerrestre);
        tripulacao.add(pilotoAviao);
        tripulacao.add(pilotoCaminhao);
        tripulacao.add(pilotoHelicoptero);
        Helicoptero helicoptero = new Helicoptero(especialistaDoAr, tripulacao, 1, 0);

        Assert.assertFalse(helicoptero.tripulacaoValida());
    }

    @Test
    public void deveInvalidarTanqueComTripulacaoMenorQueTresPessoas() {
        PilotoTanque pilotoTanque = new PilotoTanque(BigDecimal.valueOf(300), LocalDate.of(2050,1,1));
        PilotoAviao pilotoAviao = new PilotoAviao(BigDecimal.valueOf(300), LocalDate.of(2050,1,1));


        List<Militar> tripulacao = new ArrayList<>();
        tripulacao.add(pilotoAviao);
        tripulacao.add(pilotoAviao);

        Tanque tanque = new Tanque(pilotoTanque, tripulacao, 1, 0);

        Assert.assertFalse(tanque.tripulacaoValida());
    }

    @Test
    public void deveInvalidarCaminhaoComTripulacaoMenorQueCincoPessoas() {
        EspecialistaTerrestre especialistaTerrestre = new EspecialistaTerrestre(BigDecimal.valueOf(300), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1));
        PilotoTanque pilotoTanque = new PilotoTanque(BigDecimal.valueOf(300), LocalDate.of(2050,1,1));
        PilotoAviao pilotoAviao = new PilotoAviao(BigDecimal.valueOf(300), LocalDate.of(2050,1,1));


        List<Militar> tripulacao = new ArrayList<>();
        tripulacao.add(pilotoAviao);
        tripulacao.add(pilotoAviao);
        tripulacao.add(pilotoTanque);
        tripulacao.add(pilotoTanque);

        Caminhao caminhao = new Caminhao(especialistaTerrestre, tripulacao, 1, 0);

        Assert.assertFalse(caminhao.tripulacaoValida());
    }

    @Test
    public void deveValidarEliteQueTemTodasLicencaEmDia() {
        Elite elite = new Elite(BigDecimal.valueOf(300), LocalDate.of(2050,1,1), LocalDate.of(2050,1,1),LocalDate.of(2050,1,1), LocalDate.of(2050,1,1));

        List<Militar> tripulacaoAviao = new ArrayList<>();
        tripulacaoAviao.add(elite);
        Aviao aviao = new Aviao(elite, tripulacaoAviao, 1,1);

        List<Militar> tripulacaoTanque = new ArrayList<>();
        tripulacaoTanque.add(elite);
        tripulacaoTanque.add(elite);
        tripulacaoTanque.add(elite);
        Tanque tanque = new Tanque(elite, tripulacaoTanque, 1,1);


        Helicoptero helicoptero = new Helicoptero(elite, tripulacaoTanque, 1,1);

        List<Militar> tripulacaoCaminhao = new ArrayList<>();
        tripulacaoCaminhao.add(elite);
        tripulacaoCaminhao.add(elite);
        tripulacaoCaminhao.add(elite);
        tripulacaoCaminhao.add(elite);
        tripulacaoCaminhao.add(elite);
        Caminhao caminhao = new Caminhao(elite, tripulacaoCaminhao, 1, 0);



        boolean resultado = aviao.tripulacaoValida() && tanque.tripulacaoValida() && caminhao.tripulacaoValida() && helicoptero.tripulacaoValida();
        Assert.assertTrue(resultado);
    }


}
