public class Jutsu {

    private int quantidadeDeChakra; // 5 eh o maximo
    private  int dano; // 10 eh o maximo

    public Jutsu(int quantidadeDeChakra, int dano) {
        this.quantidadeDeChakra = quantidadeDeChakra;
        this.dano = dano;
    }

    public int getQuantidadeDeChakra() {
        return quantidadeDeChakra;
    }

    public int getDano() {
        return dano;
    }
}
