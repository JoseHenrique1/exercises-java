package veiculo;

import militar.LicencaTanque;
import militar.Militar;

import java.time.LocalDate;
import java.util.List;

public class Tanque extends Veiculo{
    private final LicencaTanque piloto;
    public Tanque(LicencaTanque piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
        this.piloto = piloto;
    }

    public boolean tripulacaoValida(){
        if (LocalDate.now().isAfter(this.piloto.getValidadeLicencaTanque())){
            return false;
        }
        return getTripulacao().size() == 3;
    }

}
