package personagem;

import raca.Humano;
import raca.Monstro;
import sociedade.Sociedade;

public class Urukhai extends Guerreiro implements Monstro, Humano {
    public Urukhai() {
        super(45, 3, 6, 8, Sociedade.MAL);
    }

    @Override
    public String toString() {
        return "U";
    }

    @Override
    public void envelhecer() {
        this.setConstituicao(this.getConstituicao()-2);

    }

    @Override
    public String grunir() {
        return "Uuurrrrrr";
    }


    @Override
    public String falar() {
        return "Looks like meat's back on the menu boys!";
    }
}
