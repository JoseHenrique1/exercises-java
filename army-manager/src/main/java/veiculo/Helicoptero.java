package veiculo;

import militar.LicencaHelicoptero;
import militar.Militar;

import java.time.LocalDate;
import java.util.List;

public class Helicoptero extends Veiculo{
    private final LicencaHelicoptero piloto;
    public Helicoptero(LicencaHelicoptero piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
        this.piloto = piloto;
    }

    public boolean tripulacaoValida(){
        if (LocalDate.now().isAfter(piloto.getValidadeLicencaHelicoptero())){
            return false;
        }
        return getTripulacao().size() <= 10;
    }
}
