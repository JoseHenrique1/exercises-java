import org.junit.Assert;
import org.junit.Test;

public class BatalhaTest {
    @Test
    public void deveRetornarNinjaComJutsuMaisForteSeOsDoisGastamOMesmoChakra() {
        //Arrange
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Naruto", jutsuNinjaUm);
        Jutsu jutsuNinjaDois = new Jutsu(5, 8);
        Ninja ninjaDois = new Ninja("Gaara", jutsuNinjaDois);

        Batalha batalha = new Batalha();

        //Act
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        //Assert
        Assert.assertSame(ninjaUm, ninjaVencedor);
    }

    @Test
    public void deveAtualizarOChakraDoOponenteDeAcordoComODanoDoJutsoQuandoAtacar() {
        //Arrange
        Jutsu jutsuNinjaAtacante = new Jutsu(5, 10);
        Ninja ninjaAtacante = new Ninja("Naruto", jutsuNinjaAtacante);
        Jutsu jutsuNinjaOponente = new Jutsu(5, 8);
        Ninja ninjaOponente = new Ninja("Gaara", jutsuNinjaOponente);

        int nivelChakraEsperado = 90;

        //Act
        ninjaAtacante.atacar(ninjaOponente);

        //Assert
        Assert.assertEquals(nivelChakraEsperado, ninjaOponente.getChakra());
    }

    @Test
    public  void deveRetornarPrimeiroNinjaComoVencedorQuandoONomeForItachi() {
        //Arrange
        Jutsu jutsuNinjaAtacante = new Jutsu(5, 10);
        Ninja itachi = new Ninja("Itachi", jutsuNinjaAtacante);
        Jutsu jutsuNinjaOponente = new Jutsu(5, 8);
        Ninja gaara = new Ninja("Gaara", jutsuNinjaOponente);

        Batalha batalha = new Batalha();

        Ninja ninjaEsperado = itachi;

        //Act
        Ninja ninjaVencedor = batalha.lutar(itachi, gaara);

        //Assert
        Assert.assertSame(ninjaEsperado, ninjaVencedor);
    }


    @Test
    public  void deveRetornarSegundoNinjaComoVencedorQuandoONomeForItachi() {
        //Arrange
        Jutsu jutsuNinjaAtacante = new Jutsu(5, 10);
        Ninja itachi = new Ninja("Itachi", jutsuNinjaAtacante);
        Jutsu jutsuNinjaOponente = new Jutsu(5, 8);
        Ninja gaara = new Ninja("Gaara", jutsuNinjaOponente);

        Batalha batalha = new Batalha();

        Ninja ninjaEsperado = itachi;

        //Act
        Ninja ninjaVencedor = batalha.lutar(gaara, itachi);

        //Assert
        Assert.assertSame(ninjaEsperado, ninjaVencedor);
    }

    @Test
    public  void deveRetornarPrimeiroNinjaComoVencedorQuandoEmpatar() {
        //Arrange
        Jutsu jutsu = new Jutsu(5, 10);

        Ninja primeiroNinja = new Ninja("Naruto", jutsu);
        Ninja segundoNinja = new Ninja("Gaara", jutsu);

        Batalha batalha = new Batalha();

        Ninja ninjaEsperado = primeiroNinja;

        //Act
        Ninja ninjaVencedor = batalha.lutar(primeiroNinja, segundoNinja);

        //Assert
        Assert.assertSame(ninjaEsperado, ninjaVencedor);
    }

}
