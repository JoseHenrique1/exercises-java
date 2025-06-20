import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {

    @Test
    public void deveSomarCorretamenteQuandoOsValoresForemInteiros() {
        //Arrange
        int primeiroNumero = 2;
        int segundoNumero = 2;
        double resultadoEsperado = 4;
        Calculadora calculadora = new Calculadora();

        //Act
        double resultadoAtual = calculadora.soma(primeiroNumero, segundoNumero);

        //Assert
        Assert.assertEquals(resultadoEsperado, resultadoAtual, 0);
    }

    @Test
    public void deveDividirCorretamenteQuandoNumerosForemInteiros() {
        //Arrange
        int primeiroNumero = 6;
        int segundoNumero = 2;
        double resultadoEsperado = 3;
        Calculadora calculadora = new Calculadora();

        //Act
        double resultadoAtual = calculadora.divisao(primeiroNumero, segundoNumero);

        //Assert
        Assert.assertEquals(resultadoEsperado, resultadoAtual, 0);
    }

    @Test
    public void deveMultiplicarCorretamenteQuandoNumerosForemInteiros() {
        //Arrange
        int primeiroNumero = 2;
        int segundoNumero = 5;
        double resultadoEsperado = 10;
        Calculadora calculadora = new Calculadora();

        //Act
        double resultadoAtual = calculadora.multiplicacao(primeiroNumero, segundoNumero);

        //Assert
        Assert.assertEquals(resultadoEsperado, resultadoAtual, 0);
    }

    @Test
    public void deveDividirCorretamenteQuandoNumerosPossuemPontosFlutuantes() {
        //Arrange
        double primeiroNumero = 10;
        double segundoNumero = 5;
        double resultadoEsperado = 2;
        Calculadora calculadora = new Calculadora();

        //Act
        double resultadoAtual = calculadora.divisao(primeiroNumero, segundoNumero);

        //Assert
        Assert.assertEquals(resultadoEsperado, resultadoAtual, 0);
    }

    @Test
    public void deveRealizarRaizQuadradaCorretamenteQuandoNumerosForemInteiros(){
        //Arrange
        int numero = 100;
        double resultadoEsperado = 10;
        Calculadora calculadora = new Calculadora();

        //Act
        double resultadoAtual = calculadora.raizQuadrada(numero);

        //Assert
        Assert.assertEquals(resultadoEsperado, resultadoAtual, 0);
    }

    @Test
    public void deveExponenciarCorretamenteQuandoNumerosForemInteiros(){
        //Arrange
        int base = 10;
        int expoente = 2;
        double resultadoEsperado = 100;
        Calculadora calculadora = new Calculadora();

        //Act
        double resultadoAtual = calculadora.exponenciacao(base, expoente);

        //Assert
        Assert.assertEquals(resultadoEsperado, resultadoAtual, 0);
    }

    @Test
    public void deveRealizarBhaskaraCorretamenteQuandoNumerosForemInteiros(){
        //Arrange
        int a = 2;
        int b = -4;
        int c = -6;
        double resultadoEsperado = 2;
        Calculadora calculadora = new Calculadora();

        //Act
        double resultadoAtual = calculadora.bhaskara(a, b, c);

        //Assert
        Assert.assertEquals(resultadoEsperado, resultadoAtual, 0);
    }
}
