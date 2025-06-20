package personagem;

import sociedade.Sociedade;

abstract public class Mago extends Personagem {
    public Mago(int constituicao, int inteligencia, int agilidade, int forca, Sociedade sociedade) {
        super(constituicao, inteligencia, agilidade, forca, sociedade);
    }

    @Override
    public void atacar(Personagem[] mapa, int posicao) {
        for (Personagem personagemAtual: mapa) {
            if (personagemAtual != null && personagemAtual.getSociedade() != this.getSociedade()) {
                int ataque = this.getInteligencia();
                personagemAtual.diminuirConstituicao(ataque);
            }
        }
    }

    @Override
    public void mover(Personagem[] mapa, int posicao) {
        int direcao = mapa[posicao].getSociedade().direcao;
        Personagem mago = mapa[posicao];
        boolean magoPodeAvancar = true;

        for (Personagem personagemAtual: mapa) {
            if (personagemAtual != null && personagemAtual != mago) {
                magoPodeAvancar = false;
                break;
            }
        }

        int novaPosicao = posicao + direcao;
        if (magoPodeAvancar && mapa[novaPosicao] == null) {
            mapa[novaPosicao] = mago;
            mapa[posicao] = null;
        }
    }
}
