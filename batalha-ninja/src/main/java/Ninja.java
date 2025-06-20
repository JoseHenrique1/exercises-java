public class Ninja {
    private String nome;
    private int chakra;
    private Jutsu jutsu;

    public Ninja(String nome, Jutsu jutsu) {
        this.nome = nome;
        this.chakra = 100;
        this.jutsu = jutsu;
    }

    public  void atacar(Ninja ninjaOponente) {
        ninjaOponente.receberGolpe(this.jutsu.getDano());
        this.chakra -= this.jutsu.getQuantidadeDeChakra();
    }

    public  void receberGolpe(int danoRecebido) {
        this.chakra -= danoRecebido;
    }

    public int getChakra() {
        return chakra;
    }

    public String getNome() {
        return nome;
    }

}
