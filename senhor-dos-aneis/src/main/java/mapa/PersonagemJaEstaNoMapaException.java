package mapa;

public class PersonagemJaEstaNoMapaException extends RuntimeException{
    public PersonagemJaEstaNoMapaException() {
        super("Personagem ja esta no mapa");
    }
}
