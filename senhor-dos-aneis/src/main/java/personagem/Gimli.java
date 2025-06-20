package personagem;

import raca.Anao;
import sociedade.Sociedade;

public class Gimli extends Arqueiro implements Anao {
    private int quantidadeQueBebeu;

    public Gimli() {
        super(60, 4, 2, 9, Sociedade.ANEL);
        this.quantidadeQueBebeu = 0;
    }

    @Override
    public void beber() {
        this.quantidadeQueBebeu++;
    }

    @Override
    public String falar() {
        if (quantidadeQueBebeu >= 3) {
            return "What did I say? He can't hold his liquor!";
        }
        return "Let them come. There is one Dwarf yet in Moria who still draws breath.";
    }

    @Override
    public String toString() {
        return "I";
    }
}
