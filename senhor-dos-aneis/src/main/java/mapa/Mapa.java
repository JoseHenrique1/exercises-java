package mapa;
import personagem.Personagem;


public class Mapa {
    private final Personagem[] mapa;

    public Mapa() {
        this.mapa = new Personagem[10];
    }

    public String exibir() {
        String mapaString = "";
        for (Personagem personagem: mapa) {
            if (personagem == null) {
                mapaString = mapaString.concat("| ");
            }
            else {
                mapaString = mapaString.concat("|"+personagem);
            }

        }
        mapaString = mapaString.concat("|");
        return mapaString;
    }

    public void inserir(int posicao, Personagem personagem) {
        boolean existsPersonagem = (mapa[posicao] != null);
        if (existsPersonagem) {
            throw new PosicaoOcupadaException();
        }

        for (Personagem personagemAtual: this.mapa) {
            if (personagemAtual != null && personagemAtual.toString().equals(personagem.toString())) {
                throw new PersonagemJaEstaNoMapaException();
            }
        }

        mapa[posicao] = personagem;
    }

    public int buscarPosicao(Personagem personagem) {
        for (int i = 0; i < this.mapa.length; i++) {
            if (this.mapa[i] == personagem) {
                return i;
            }
        }
        throw new PersonagemNaoEncontradoNoMapaException();
    }

    public Personagem buscarCasa(int posicao) {
        return this.mapa[posicao];
    }

    public void removerPersonagensComConstituicaoIgualZero() {
        int counter = 0;
        while (counter < this.mapa.length) {
            Personagem personagem = this.mapa[counter];
            if (personagem != null &&  personagem.getConstituicao() == 0) {
                System.out.println(personagem + " morrreu <--- !");
                this.mapa[counter] = null;
            }
            counter++;
        }
    }


    public Personagem[] getMapa() {
        return mapa;
    }
}
