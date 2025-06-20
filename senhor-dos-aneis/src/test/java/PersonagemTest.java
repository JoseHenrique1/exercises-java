import org.junit.Assert;
import org.junit.Test;
import personagem.Aragorn;
import personagem.Boromir;

public class PersonagemTest {
    @Test
    public void personagemDevePerderConstituicaoAoEnvelhecer(){
        Aragorn aragorn = new Aragorn();
        Boromir boromir = new Boromir();

        aragorn.envelhecer();
        boromir.envelhecer();

        boolean condicao = aragorn.getConstituicao() == 59 && boromir.getConstituicao() == 38;

        Assert.assertTrue(condicao);
    }
}
