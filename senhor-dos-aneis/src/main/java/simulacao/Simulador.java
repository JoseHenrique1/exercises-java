package simulacao;

import mapa.Mapa;
import mapa.SauronDominaOMundoException;
import personagem.Personagem;
import sociedade.Sociedade;


public class Simulador {
    private final Mapa mapa;

    public Simulador(Mapa mapa) {
        this.mapa = mapa;
    }

    public void simular(){
        int mapaPosicaoAtaul = 0;
        do {
            System.out.println(this.mapa.exibir());
            Personagem personagem = this.mapa.buscarCasa(mapaPosicaoAtaul);

            if (personagem != null) {
                personagem.atacar(this.mapa.getMapa(), mapaPosicaoAtaul);
                this.mapa.removerPersonagensComConstituicaoIgualZero();

                personagem.mover(this.mapa.getMapa(), mapaPosicaoAtaul);
                if (personagem.getSociedade() == Sociedade.ANEL) {
                    mapaPosicaoAtaul = this.mapa.buscarPosicao(personagem);
                }
            }

            mapaPosicaoAtaul++;
            if (mapaPosicaoAtaul == this.mapa.getMapa().length) {
                mapaPosicaoAtaul = 0;
            }
            //Condicoes de vitoria
            Personagem personagemAnelUltimaCasa  = this.mapa.buscarCasa(this.mapa.getMapa().length - 1);
            if (personagemAnelUltimaCasa != null && personagemAnelUltimaCasa.getSociedade() == Sociedade.ANEL) {
                System.out.println("Vitoria da Sociedade do Anel");
                break;
            }

            boolean existePeloMenosUmPersonagemAnel = false;
            for (Personagem personagemAtual: this.mapa.getMapa()) {
                if (personagemAtual != null && personagemAtual.getSociedade() == Sociedade.ANEL) {
                    existePeloMenosUmPersonagemAnel = true;
                    break;
                }
            }

            if (!existePeloMenosUmPersonagemAnel) {
                System.out.println("excecao");
                throw new SauronDominaOMundoException();
            }


        }while (true);
    }
}
