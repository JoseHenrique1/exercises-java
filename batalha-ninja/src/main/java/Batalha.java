public class Batalha {

    public Ninja lutar(Ninja primeiroNinja, Ninja segundoNinja) {
        if (primeiroNinja.getNome().equals("Itachi")) {
            return primeiroNinja;
        }
        if (segundoNinja.getNome().equals("Itachi")) {
            return segundoNinja;
        }


        primeiroNinja.atacar(segundoNinja);
        primeiroNinja.atacar(segundoNinja);
        primeiroNinja.atacar(segundoNinja);

        segundoNinja.atacar(primeiroNinja);
        segundoNinja.atacar(primeiroNinja);
        segundoNinja.atacar(primeiroNinja);


        if (primeiroNinja.getChakra() >= segundoNinja.getChakra()) {
            return primeiroNinja;
        }
        return segundoNinja;
    }
}
