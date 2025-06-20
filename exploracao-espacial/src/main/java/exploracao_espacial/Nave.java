package exploracao_espacial;

import java.util.ArrayList;
import java.util.List;

public class Nave {
    private  int quantidadeDeCombustivel;
    private int posicao;

    public Nave(int quantidadeDeCombustivel) {
        this.quantidadeDeCombustivel = quantidadeDeCombustivel;
        this.posicao = 0;
    }

    public int getQuantidadeDeCombustivel() {
        return this.quantidadeDeCombustivel;
    }

    public int getPosicao() {
        return posicao;
    }

    public List<Recurso> explorar(Planeta planeta){
        List<Recurso> recursosExplorados = new ArrayList<>();
        int distanciaQueNavePodePercorrer = this.quantidadeDeCombustivel /3;
        int distanciaTotalDoTrajeto = planeta.getPosicao() * 2;

        // Verifica se a nave consegue ir e voltar
        if (distanciaQueNavePodePercorrer >= distanciaTotalDoTrajeto) {
            this.quantidadeDeCombustivel -= distanciaTotalDoTrajeto*3;
            recursosExplorados.addAll(planeta.getRecursos());
            return recursosExplorados;
        }

        // Verifica se a nave vai ficar a deriva na ida
        if (distanciaQueNavePodePercorrer <= planeta.getPosicao() ) {
            this.posicao = distanciaQueNavePodePercorrer;
            this.quantidadeDeCombustivel -= distanciaQueNavePodePercorrer * 3;
            return recursosExplorados;
        }

        // A nave ficou a deriva na volta
        int diferenca = distanciaQueNavePodePercorrer - planeta.getPosicao();
        this.posicao = planeta.getPosicao() - diferenca;
        this.quantidadeDeCombustivel -= distanciaQueNavePodePercorrer * 3;

        return recursosExplorados;
    }

    // Prioridade padrao, ou seja, a posicao
    public List<Recurso> explorar(List<Planeta> planetas){
        List<Recurso> recursosExplorados = new ArrayList<>();

        List<Planeta> listaDePlanetas = new ArrayList<>(planetas);

        while (this.quantidadeDeCombustivel >= 3) {
            this.quantidadeDeCombustivel -= 3;
            this.posicao++;

            Planeta planetaEncontrado = null;
            for (Planeta planeta: listaDePlanetas) {

                if (planeta.getPosicao() == this.posicao) {
                    recursosExplorados.addAll(planeta.getRecursos());
                    planetaEncontrado = planeta;
                }
            }

            if (planetaEncontrado != null) {
                listaDePlanetas.remove(planetaEncontrado);
            }

            if (listaDePlanetas.isEmpty()) {
                //Significa que estou na posicao do ultimo planeta
                int quantidadeDePosicoesQueANaveAindaPodeAndar = quantidadeDeCombustivel / 3;

                //Entao posso simplemente ver se posso voltar a posicao 0
                if (quantidadeDePosicoesQueANaveAindaPodeAndar >= this.posicao) {
                    this.quantidadeDeCombustivel -= this.posicao * 3;
                    this.posicao = 0;
                    break;
                }
                // Ou calcular a posicao que a nave vai ficar a deriva
                else {
                    this.quantidadeDeCombustivel -= quantidadeDePosicoesQueANaveAindaPodeAndar * 3;
                    this.posicao -=quantidadeDePosicoesQueANaveAindaPodeAndar;
                }
            }
        }

        //Retorno o array de recurso caso a nave volte ao ponto 0
        if (this.posicao == 0) {return recursosExplorados;}

        //Retorno um array vazio caso a nave nao volte ao ponto 0
        return new ArrayList<>();
    }

    public List<Recurso> explorar(List<Planeta> planetas, String prioridade){
        if (this.quantidadeDeCombustivel < 3) {
            return new ArrayList<>();
        }

        List<Recurso> recursosExplorados = new ArrayList<>();
        List<Planeta> listaPlanetas = new ArrayList<>(planetas);


        if (prioridade.equals("valorTotal")) {
            Planeta planetaComMaioValor = null;
            do {
                int diferenca = 0;
                // encontrar o planeta com maior valor
                if (planetaComMaioValor == null) {
                    int maiorValorTotalEncontrado = 0;
                    for (Planeta planeta: listaPlanetas) {
                        if (planeta.valorTotalRecurso() > maiorValorTotalEncontrado) {
                            maiorValorTotalEncontrado = planeta.valorTotalRecurso();
                            planetaComMaioValor = planeta;
                            diferenca = this.posicao - planetaComMaioValor.getPosicao();
                        }
                    }
                }



                if (diferenca > 0) {
                    this.posicao--;
                    this.quantidadeDeCombustivel -=3;
                }
                else if (diferenca < 0) {
                    this.posicao++;
                    this.quantidadeDeCombustivel -=3;
                }

                else  {
                    if (planetaComMaioValor != null && planetaComMaioValor.getRecursos() != null) {
                        recursosExplorados.addAll(planetaComMaioValor.getRecursos());
                    }
                    listaPlanetas.remove(planetaComMaioValor);
                    planetaComMaioValor = null;
                    while (listaPlanetas.isEmpty()) {
                        if (this.quantidadeDeCombustivel >=3) {
                            this.quantidadeDeCombustivel -=3;
                            this.posicao--;
                        }
                        else { break; }
                    }
                }
            } while (this.quantidadeDeCombustivel >=3 && this.posicao !=0);
        }

        if (prioridade.equals("valorPorPeso")) {
            Planeta planetaComMaioValorPorPeso = null;
            do {
                int diferenca = 0;
                // encontrar o planeta com maior valor
                if (planetaComMaioValorPorPeso == null) {
                    int maiorValorPorPesoEncontrado = 0;
                    for (Planeta planeta: listaPlanetas) {
                        if (planeta.valorTotalRecurso() > maiorValorPorPesoEncontrado) {
                            maiorValorPorPesoEncontrado = planeta.valorTotalRecurso();
                            planetaComMaioValorPorPeso = planeta;
                            diferenca =  this.posicao - planetaComMaioValorPorPeso.getPosicao();
                        }
                    }
                }




                if (diferenca > 0) {
                    this.posicao--;
                    this.quantidadeDeCombustivel -=3;
                }
                else if (diferenca < 0) {
                    this.posicao++;
                    this.quantidadeDeCombustivel -=3;
                }

                else  {
                    if (planetaComMaioValorPorPeso != null && planetaComMaioValorPorPeso.getRecursos() != null) {
                        recursosExplorados.addAll(planetaComMaioValorPorPeso.getRecursos());
                    }
                    listaPlanetas.remove(planetaComMaioValorPorPeso);
                    planetaComMaioValorPorPeso = null;
                    while (listaPlanetas.isEmpty()) {
                        if (this.quantidadeDeCombustivel >=3) {
                            this.quantidadeDeCombustivel -=3;
                            this.posicao--;
                        }
                        else { break; }
                    }
                }
            } while (this.quantidadeDeCombustivel >=3 && this.posicao !=0);
        }

        if (this.posicao == 0) {
            return recursosExplorados;
        }

        return new ArrayList<>();
    }
}
