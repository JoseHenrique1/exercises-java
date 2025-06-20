package mapa;

public class PersonagemNaoEncontradoNoMapaException extends RuntimeException{
    public PersonagemNaoEncontradoNoMapaException() {
        super("Personagem nao encontrado no mapa");
    }
}
