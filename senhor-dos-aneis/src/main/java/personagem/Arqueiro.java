package personagem;

import sociedade.Sociedade;

abstract public class Arqueiro extends  Personagem{
    public Arqueiro(int constituicao, int inteligencia, int agilidade, int forca, Sociedade sociedade) {
        super(constituicao, inteligencia, agilidade, forca, sociedade);
    }

    @Override
    public void atacar(Personagem[] mapa, int posicao) {
        int direcao = mapa[posicao].getSociedade().direcao;
        int distancia = 1;
        Personagem inimigoDireita = null;

        int tamanhoMapa = mapa.length;
        int posicaoInicial = posicao+direcao;

        if (posicaoInicial < tamanhoMapa) {
            for (int posicaoAtual = posicaoInicial, counter = 0; counter < 3 && posicaoAtual < tamanhoMapa && posicaoAtual >= 0 ; posicaoAtual+=direcao, counter++) {
                Personagem possivelInimigo = mapa[posicaoAtual];
                if (possivelInimigo != null && possivelInimigo.getSociedade() != this.getSociedade()) {
                    inimigoDireita = possivelInimigo;
                    distancia += counter;
                }
            }
        }

        if (inimigoDireita != null) {
            int ataque = this.getAgilidade() * distancia;
            inimigoDireita.diminuirConstituicao(ataque);
        }
    }

    @Override
    public void mover(Personagem[] mapa, int posicao) {
        int direcao = mapa[posicao].getSociedade().direcao;
        Personagem personagem = mapa[posicao];
        int novaPosicao = posicao+direcao;
        if (mapa[novaPosicao] == null) {
            novaPosicao += direcao;
            if (mapa[novaPosicao] == null) {
                mapa[novaPosicao] = personagem;
            }
            else {
                mapa[posicao+direcao] = personagem;
            }
            mapa[posicao] = null;
        }
    }
}
