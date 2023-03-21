public class Main {
    public static void main(String[] args) {
        Polinomio polinomio1 = new Polinomio();
        Polinomio polinomio2 = new Polinomio();
        Polinomio polinomio3 = new Polinomio();
        Polinomio polinomio4 = new Polinomio();


        polinomio1.agregarTermino(1, 2);
        polinomio1.agregarTermino(0, 1);

        polinomio2.agregarTermino(3, 2);
        polinomio2.agregarTermino(1, 1);
        polinomio2.agregarTermino(0, 1);

        polinomio3.sumar(polinomio1, polinomio2);
        polinomio4.multiplicar(polinomio1, polinomio2);

    }
}