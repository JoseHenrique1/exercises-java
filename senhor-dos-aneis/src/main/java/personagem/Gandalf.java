package personagem;

import raca.Maia;
import sociedade.Sociedade;

public class Gandalf extends Mago implements Maia {
    public Gandalf() {
        super(80, 10, 3, 2, Sociedade.ANEL);
    }

    @Override
    public Gandalf ressucitar() {
        if (getConstituicao() == 0) {
            return new Gandalf();
        }
        return null;
    }

    @Override
    public String falar() {
        return "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
    }

    @Override
    public String toString() {
        return "G";
    }
}
