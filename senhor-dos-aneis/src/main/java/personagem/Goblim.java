package personagem;

import raca.Monstro;
import sociedade.Sociedade;

public class Goblim extends Arqueiro implements Monstro {
    public Goblim() {
        super(20, 1, 6, 3, Sociedade.MAL);
    }

    @Override
    public String grunir() {
        return "Iiisshhhh";
    }

    @Override
    public String toString() {
        return "M";
    }
}
