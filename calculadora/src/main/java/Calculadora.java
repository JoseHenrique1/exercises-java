public class Calculadora {
    public double soma(double primeiroNumero, double segundoNumero) {
        return primeiroNumero + segundoNumero;
    }

    public double subtracao(double primeiroNumero, double segundoNumero) {
        return primeiroNumero - segundoNumero;
    }

    public double multiplicacao(double primeiroNumero, double segundoNumero) {
        return primeiroNumero * segundoNumero;
    }

    public double divisao(double primeiroNumero, double segundoNumero) {
        return primeiroNumero / segundoNumero;
    }

    public double raizQuadrada(double primeiroNumero) {
        return Math.sqrt(primeiroNumero);
    }

    public double exponenciacao(double base, double expoente) {
        return Math.pow(base, expoente);
    }

    public double  bhaskara(double a, double b, double c) {
        double raizQuadradaDeDelta = Math.sqrt((b*b)-4*a*c);
        double primeiroX = (-b + raizQuadradaDeDelta)/(2*a);
        double segundooX = (-b - raizQuadradaDeDelta)/(2*a);
        return primeiroX + segundooX;
    }

}
