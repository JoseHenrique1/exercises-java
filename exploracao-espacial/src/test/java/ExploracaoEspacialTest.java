import exploracao_espacial.Nave;
import exploracao_espacial.Planeta;
import exploracao_espacial.Recurso;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExploracaoEspacialTest {
    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta() {
        int posicaoEsperada = 3;
        int combustivelEsperado = 1;
        Nave milleniumFalcon = new Nave(10);
        Planeta tatooine = new Planeta(4, new ArrayList<>());

        List<Recurso> recursos = milleniumFalcon.explorar(tatooine);
        int posicaoResultante = milleniumFalcon.getPosicao();
        int combustivelFinal = milleniumFalcon.getQuantidadeDeCombustivel();

        Assert.assertTrue(recursos.isEmpty());
        Assert.assertEquals(combustivelEsperado, combustivelFinal);
        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void deveTerValorTotalZeradoQuandoNaoExistirNenhumRecurso() {
        Planeta terra = new Planeta(4, new ArrayList<>());

        int valorEsperado = 0;

        Assert.assertEquals(valorEsperado, terra.valorTotalRecurso());
    }

    @Test
    public void deveTerValorTotalQuandoExistirRecursosNoPlaneta() {
        Recurso recurso = new Recurso(10, 1);
        List<Recurso> listaRecursos = new ArrayList<>();
        listaRecursos.add(recurso);
        listaRecursos.add(recurso);
        listaRecursos.add(recurso);

        Planeta terra = new Planeta(4, listaRecursos);

        int valorEsperado = 30;

        Assert.assertEquals(valorEsperado, terra.valorTotalRecurso());

    }

    @Test
    public void deveTerValorPorPesoZeradoQuandoNaoExistirNenhumRecurso() {
        Planeta terra = new Planeta(4, new ArrayList<>());

        double valorEsperado = 0;

        Assert.assertEquals(valorEsperado, terra.valorPorPesoRecurso(), 0);
    }

    @Test
    public void deveTerValorPorPesoQuandoExistirRecursosNoPlaneta() {
        Recurso recurso = new Recurso(10, 5);
        List<Recurso> listaRecursos = new ArrayList<>();
        listaRecursos.add(recurso);
        listaRecursos.add(recurso);
        listaRecursos.add(recurso);

        Planeta terra = new Planeta(4, listaRecursos);

        double valorEsperado = 6;

        Assert.assertEquals(valorEsperado, terra.valorPorPesoRecurso(), 0);
    }



    /*
         recurso     posicao
    p1 - 20/1;         1
    p2 - 30/1;         2
    p3 - 10/1;         3

    exploracao por total
    p2 - p1 - p3 - 0   8passos

    exploracao por posicao
    p1 - p2 - p3 - 0 6 passos
    */

    @Test
    public void deveSobrarMaisCombustivelQuandoAPrioridadeForPosicaoEmRelacaoAValorTotal () {
        Recurso recurso1 = new Recurso(20, 1);
        Recurso recurso2 = new Recurso(30, 1);
        Recurso recurso3 = new Recurso(10, 1);

        List<Recurso> listaRecursos1 = new ArrayList<>();
        List<Recurso> listaRecursos2 = new ArrayList<>();
        List<Recurso> listaRecursos3 = new ArrayList<>();

        listaRecursos1.add(recurso1);
        listaRecursos2.add(recurso2);
        listaRecursos3.add(recurso3);

        Planeta planeta1 = new Planeta(1, listaRecursos1);
        Planeta planeta2 = new Planeta(2, listaRecursos2);
        Planeta planeta3 = new Planeta(3, listaRecursos3);

        List<Planeta> listaPlanetas = new ArrayList<Planeta>();
        listaPlanetas.add(planeta1);
        listaPlanetas.add(planeta2);
        listaPlanetas.add(planeta3);

        Nave nave1 = new Nave(100);
        Nave nave2 = new Nave(100);


        nave1.explorar(listaPlanetas);
        nave2.explorar(listaPlanetas, "valorTotal");

        boolean nave1TemMaisCombustivel = nave1.getQuantidadeDeCombustivel() > nave2.getQuantidadeDeCombustivel();

        Assert.assertTrue(nave1TemMaisCombustivel);
    }

    @Test
    public void deveSobrarMaisCombustivelQuandoAPrioridadeForPosicaoEmRelacaoAValorPorPeso () {
        Recurso recurso1 = new Recurso(20, 1);
        Recurso recurso2 = new Recurso(30, 1);
        Recurso recurso3 = new Recurso(10, 1);

        List<Recurso> listaRecursos1 = new ArrayList<>();
        List<Recurso> listaRecursos2 = new ArrayList<>();
        List<Recurso> listaRecursos3 = new ArrayList<>();

        listaRecursos1.add(recurso1);
        listaRecursos2.add(recurso2);
        listaRecursos3.add(recurso3);

        Planeta planeta1 = new Planeta(1, listaRecursos1);
        Planeta planeta2 = new Planeta(2, listaRecursos2);
        Planeta planeta3 = new Planeta(3, listaRecursos3);

        List<Planeta> listaPlanetas = new ArrayList<Planeta>();
        listaPlanetas.add(planeta1);
        listaPlanetas.add(planeta2);
        listaPlanetas.add(planeta3);

        Nave nave1 = new Nave(100);
        Nave nave2 = new Nave(100);


        nave1.explorar(listaPlanetas);
        nave2.explorar(listaPlanetas, "valorPorPeso");

        boolean nave1TemMaisCombustivel = nave1.getQuantidadeDeCombustivel() > nave2.getQuantidadeDeCombustivel();

        Assert.assertTrue(nave1TemMaisCombustivel);

    }

    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlanetaComPrioridadeValorTotal() {
        int posicaoEsperada = 0;
        Nave milleniumFalcon = new Nave(1);
        Planeta tatooine = new Planeta(4, new ArrayList<>());
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(tatooine);

        List<Recurso> recursos = milleniumFalcon.explorar(planetas, "valorTotal");
        int posicaoResultante = milleniumFalcon.getPosicao();

        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

}
