package veiculo;

import militar.LicencaAviao;
import militar.Militar;

import java.time.LocalDate;
import java.util.List;

public class Aviao extends Veiculo{
    private final LicencaAviao piloto;
    public Aviao(LicencaAviao piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
        this.piloto = piloto;
    }

    public boolean tripulacaoValida(){
        if (LocalDate.now().isAfter(piloto.getValidadeLicencaAviao())){
            return false;
        }
        return getTripulacao().size() <= 1;
    }
}
