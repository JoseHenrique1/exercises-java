package simulacaofinanceira;

import militar.Militar;
import veiculo.Veiculo;

import java.math.BigDecimal;
import java.util.List;

public class SimulacaoFinanceira {
    private double distanciaDaViagem;
    private List<Veiculo> veiculosDaMissao;
    private int duracaoDaMissao; 

    public SimulacaoFinanceira(double distanciaDaViagem, List<Veiculo> veiculosDaMissao, int duracaoDaMissao) {
        this.distanciaDaViagem = distanciaDaViagem;
        this.veiculosDaMissao = veiculosDaMissao;
        this.duracaoDaMissao = duracaoDaMissao;
    }

    public BigDecimal getCustoTotalMissao() {
        //somatorio do salario dos pilotos e tripulantes * duracao da missao + gasto total com combustivel de todos os veículos
        BigDecimal salarioTotal = BigDecimal.valueOf(0);
        for (Veiculo veiculo: this.veiculosDaMissao) {
            salarioTotal = salarioTotal.add(veiculo.getPiloto().getSalario());
            for (Militar militar: veiculo.getTripulacao()) {
                salarioTotal = salarioTotal.add(militar.getSalario());
            }
        }

        double gastoComCombustivelTotal = 0;
        for (Veiculo veiculo: this.veiculosDaMissao) {
            double gastoDeUmVeiculo = this.distanciaDaViagem / veiculo.getQuilometragemPorLitro() * veiculo.getPrecoPorLitroCombustivel();
            gastoComCombustivelTotal += gastoDeUmVeiculo;
        }


        return salarioTotal.multiply(BigDecimal.valueOf(duracaoDaMissao)).add(BigDecimal.valueOf(gastoComCombustivelTotal));
    }

    public boolean todasTripulacoesValidas() {
        for (Veiculo veiculo: this.veiculosDaMissao) {
            if (!veiculo.tripulacaoValida()) {
                return false;
            }
        }
        return true;
    }
}
