package exploracao_espacial;
import java.util.List;

public class Planeta {
    private final int posicao;
    private final List<Recurso> recursos;

    public Planeta(int posicao, List<Recurso> recursos) {
        this.posicao = posicao;
        this.recursos = recursos;
    }

    public int valorTotalRecurso () {
        int total = 0;
        for(Recurso recurso: recursos){
            total += recurso.getValor();
        }
        return total;
    }

    public double valorPorPesoRecurso () {
        double valorPorPeso = 0;
        for(Recurso recurso: recursos){
            valorPorPeso += (double) recurso.getValor()/recurso.getPeso();
        }
        return valorPorPeso;
    }

    public int getPosicao() {
        return posicao;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }
}
