package personagem;

import sociedade.Sociedade;

public abstract class Personagem {
    private final int forca;
    private final int agilidade;
    private final int inteligencia;
    private int constituicao;
    private final Sociedade sociedade;

    public Personagem( int constituicao, int inteligencia, int agilidade, int forca, Sociedade sociedade) {

        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.agilidade = agilidade;
        this.forca = forca;
        this.sociedade = sociedade;
    }

    public abstract void atacar(Personagem[] mapa, int posicao);
    public abstract void mover(Personagem[] mapa, int posicao);

    public int getForca() {
        return forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public void diminuirConstituicao(int quantidade) {
        this.constituicao -= quantidade;
        if (this.constituicao < 0) {
            this.constituicao = 0;
        }
    }

    public Sociedade getSociedade() {
        return sociedade;
    }

    public abstract String toString();
}