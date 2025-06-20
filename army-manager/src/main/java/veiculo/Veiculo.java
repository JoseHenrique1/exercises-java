package veiculo;


import militar.Militar;
import militar.Piloto;

import java.util.List;

public abstract class Veiculo {

    private final Piloto piloto;
    private final List<Militar> tripulacao;
    private final double quilometragemPorLitro;
    private final double precoPorLitroCombustivel;

    protected Veiculo(Piloto piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        this.piloto = piloto;
        this.tripulacao = tripulacao;
        this.quilometragemPorLitro = quilometragemPorLitro;
        this.precoPorLitroCombustivel = precoPorLitroCombustivel;
    }

    public abstract boolean tripulacaoValida();

    public List<Militar> getTripulacao() {
        return tripulacao;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public double getQuilometragemPorLitro() {
        return quilometragemPorLitro;
    }

    public double getPrecoPorLitroCombustivel() {
        return precoPorLitroCombustivel;
    }
}
