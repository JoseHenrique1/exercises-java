package personagem;

import raca.Humano;
import sociedade.Sociedade;

public class Boromir extends Guerreiro implements Humano {
    public Boromir() {
        super(40, 3, 6, 7, Sociedade.ANEL);
    }

    @Override
    public void envelhecer() {
        this.setConstituicao(this.getConstituicao()-2);

    }

    @Override
    public String falar() {
        return "";
    }


    @Override
    public String toString() {
        return "B";
    }
}
