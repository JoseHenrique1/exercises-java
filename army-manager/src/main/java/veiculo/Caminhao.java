package veiculo;

import militar.LicencaCaminhao;
import militar.Militar;

import java.time.LocalDate;
import java.util.List;

public class Caminhao extends Veiculo{
    private final LicencaCaminhao piloto;
    public Caminhao(LicencaCaminhao piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
        this.piloto = piloto;
    }

    public boolean tripulacaoValida(){
        if (LocalDate.now().isAfter(piloto.getValidadeLicencaCaminhao())){
            return false;
        }
        return getTripulacao().size() <= 30 && getTripulacao().size() >= 5;
    }
}
