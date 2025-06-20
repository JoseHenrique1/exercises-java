public class ExceptionsLearnCWI {
    public static void main(String[] args) {
        System.out.println("inicio main");
        metodo1();
        System.out.println("final main");
    }

    static void metodo1() {
        System.out.println("inicio metodo1");
        try {
            metodo2();
        } catch (ArithmeticException e) {
            System.out.println("Error ao dividir");
        }
        System.out.println("final metodo1");
    }

    static void metodo2() {
        System.out.println("inicio metodo2");
        metodo3();
        System.out.println("final metodo2");
    }

    static void metodo3() {
        System.out.println("inicio metodo3");

            int n = 10/0;

        System.out.println("final metodo3");
    }
}
