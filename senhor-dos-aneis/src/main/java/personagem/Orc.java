package personagem;

import raca.Monstro;
import sociedade.Sociedade;

public class Orc extends Guerreiro implements Monstro {
    public Orc() {
        super( 30, 1, 4, 7, Sociedade.MAL);
    }

    @Override
    public String grunir() {
        return "Arrrggghhh";
    }

    @Override
    public String toString() {
        return "O";
    }
}
