package negociacao;

import clube.Clube;
import jogador.Jogador;

public class Negociacao {
    public boolean negociar(Clube clubeInteressado, Jogador jogadorDeInteresse) {
        boolean interesseDoJogador =  jogadorDeInteresse.interesseEmTransferencia(clubeInteressado);
        boolean clubeConseguePagar = clubeInteressado.getSaldo().compareTo(jogadorDeInteresse.getValorDeCompra()) > 0;

        if (interesseDoJogador && clubeConseguePagar) {
            jogadorDeInteresse.transferenciaClube(clubeInteressado);
            clubeInteressado.setSaldo(clubeInteressado.getSaldo().subtract(jogadorDeInteresse.getValorDeCompra()));
            return true;
        }

        return false;
    }
}
