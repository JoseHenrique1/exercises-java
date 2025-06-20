package personagem;

import raca.Maia;
import sociedade.Sociedade;

public class Saruman extends Mago implements Maia {
    public Saruman() {
        super(70, 9, 2, 2, Sociedade.MAL);
    }

    @Override
    public Gandalf ressucitar() {
        return null;
    }

    @Override
    public String falar() {
        return "Against the power of Mordor there can be no victory.";
    }

    @Override
    public String toString() {
        return "S";
    }
}
