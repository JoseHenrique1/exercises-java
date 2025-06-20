package sociedade;

public enum Sociedade {
    ANEL(1), MAL(-1);

    final public int direcao;

    Sociedade(int direcao) {
        this.direcao = direcao;
    }
}
