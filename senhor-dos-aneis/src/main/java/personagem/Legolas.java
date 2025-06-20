package personagem;

import raca.Elfo;
import sociedade.Sociedade;

public class Legolas extends Arqueiro implements Elfo {
    public Legolas() {
        super(80, 6, 10, 5, Sociedade.ANEL);
    }

    @Override
    public String falarElfico() {
        return "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";
    }

    @Override
    public String falar() {
        return "They're taking the Hobbits to Isengard!";
    }


    @Override
    public String toString() {
        return "L";
    }
}
