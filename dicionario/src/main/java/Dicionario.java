import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private final Map<String, String> dicionarioPortugues;
    private final Map<String, String> dicionarioIngles;

    public Dicionario() {
        this.dicionarioPortugues = new HashMap<>();
        this.dicionarioIngles = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String traducao, TipoDicionario dicionario) {
        String palavraConvertidaMinuscula = palavra.toLowerCase();
        if (dicionario.equals(TipoDicionario.PORTUGUES)) {
            this.dicionarioPortugues.put(palavraConvertidaMinuscula, traducao);
        } else {
            this.dicionarioIngles.put(palavraConvertidaMinuscula, traducao);
        }
    }

    public String traduzir(String palavra, TipoDicionario dicionarioDeBusca) {
        String palavraConvertidaMinuscula = palavra.toLowerCase();

        if (dicionarioDeBusca.equals(TipoDicionario.PORTUGUES) && this.dicionarioPortugues.containsKey(palavraConvertidaMinuscula)) {
            return this.dicionarioPortugues.get(palavraConvertidaMinuscula);
        }
        if (dicionarioDeBusca.equals(TipoDicionario.INGLES) && this.dicionarioIngles.containsKey(palavraConvertidaMinuscula)) {
            return this.dicionarioIngles.get(palavraConvertidaMinuscula);
        }
        throw new PalavraNaoEncontradaException();

    }
}
