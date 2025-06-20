public enum TipoJogador {
    GOLEIRO(1), ZAGUEIRO(2), LATERAL(3), MEIA(10), ATACANTE(9);

    public int jogador;

    TipoJogador(int jogador) {
        this.jogador = jogador;
    }

    public int getJogador() {
        return jogador;
    }
}
