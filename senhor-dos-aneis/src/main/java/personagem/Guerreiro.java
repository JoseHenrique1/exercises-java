package personagem;

import sociedade.Sociedade;

abstract public class Guerreiro extends Personagem{
    public Guerreiro(int constituicao, int inteligencia, int agilidade, int forca, Sociedade sociedade) {
        super(constituicao, inteligencia, agilidade, forca, sociedade);
    }

    @Override
    public void atacar(Personagem[] mapa, int posicao) {
        int direcao = mapa[posicao].getSociedade().direcao;
        int novaPosicao = posicao+direcao;
        Personagem personagemAFrente = mapa[novaPosicao];
        if (personagemAFrente != null && personagemAFrente.getSociedade() != this.getSociedade()) {
            int ataque = this.getForca() * 2;
            personagemAFrente.diminuirConstituicao(ataque);
        }
    }

    @Override
    public void mover(Personagem[] mapa, int posicao) {
        int direcao = mapa[posicao].getSociedade().direcao;
        int novaPosicao = posicao+direcao;
        Personagem personagemAFrente = mapa[novaPosicao];
        if (personagemAFrente == null) {
            mapa[novaPosicao] = mapa[posicao];
            mapa[posicao] = null;
        }
    }
}
