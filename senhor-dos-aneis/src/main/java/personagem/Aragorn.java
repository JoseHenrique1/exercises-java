package personagem;

import raca.Humano;
import sociedade.Sociedade;

public class Aragorn extends Guerreiro implements Humano {
    public Aragorn() {
        super(60, 6, 7, 10, Sociedade.ANEL);
    }

    @Override
    public void envelhecer() {
        this.setConstituicao(getConstituicao()-1);
    }

    @Override
    public String falar() {
        return "A day may come when the courage of men fails… but it is not THIS day.";
    }

    @Override
    public String toString() {
        return "A";
    }
}
