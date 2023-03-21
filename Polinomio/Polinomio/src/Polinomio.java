
public class Polinomio implements Nodo, Dato_Polinomio {
    private Nodo termino_mayor;
    private int grado;

    public Polinomio() {
        this.termino_mayor = null;
        this.grado = -1;
    }

    public void agregarTermino(int termino, int valor) {
        Nodo nuevo = getSig();
        if (this.termino_mayor == null) {
            this.termino_mayor = nuevo;
        } else {
            Nodo actual = this.termino_mayor;

            while (actual.getSig() != null && termino < actual.getSig().getInfo().getTermino()) {
                actual = actual.getSig();
            }

            if (actual.getSig() == null) {
                actual.setSig(nuevo);
            } else {
                nuevo.setSig(actual.getSig());
                actual.setSig(nuevo);
            }
        }

        if (termino > this.grado) {
            this.grado = termino;
        }
    }

    public void modificarTermino(int termino, int valor) {
        Nodo actual = this.termino_mayor;

        while (actual != null && termino != actual.getInfo().getTermino()) {
            actual = actual.getSig();
        }

        if (actual != null) {
            actual.getInfo().setValor(valor);
        }
    }

    public void obtenerValor(int termino) {
        Nodo actual = this.termino_mayor;

        while (actual != null && termino != actual.getInfo().getTermino()) {
            actual = actual.getSig();
        }

        if (actual != null) {
            System.out.println("El valor del termino " + termino + " es " + actual.getInfo().getValor());
        } else {
            System.out.println("El termino " + termino + " no existe");
        }
    }

    public void mostrarPolinomio() {
        Nodo actual = this.termino_mayor;

        while (actual != null) {
            System.out.print(actual.getInfo().getValor() + "x^" + actual.getInfo().getTermino() + " + ");
            actual = actual.getSig();
        }

        System.out.println();
    }

    public void sumar(Polinomio polinomio1, Polinomio polinomio2) {
        Nodo actual1 = polinomio1.termino_mayor;
        Nodo actual2 = polinomio2.termino_mayor;

        while (actual1 != null && actual2 != null) {
            if (actual1.getInfo().getTermino() == actual2.getInfo().getTermino()) {
                this.agregarTermino(actual1.getInfo().getTermino(), actual1.getInfo().getValor() + actual2.getInfo().getValor());
                actual1 = actual1.getSig();
                actual2 = actual2.getSig();
            } else if (actual1.getInfo().getTermino() > actual2.getInfo().getTermino()) {
                this.agregarTermino(actual1.getInfo().getTermino(), actual1.getInfo().getValor());
                actual1 = actual1.getSig();
            } else {
                this.agregarTermino(actual2.getInfo().getTermino(), actual2.getInfo().getValor());
                actual2 = actual2.getSig();
            }
        }

        while (actual1 != null) {
            this.agregarTermino(actual1.getInfo().getTermino(), actual1.getInfo().getValor());
            actual1 = actual1.getSig();
        }

        while (actual2 != null) {
            this.agregarTermino(actual2.getInfo().getTermino(), actual2.getInfo().getValor());
            actual2 = actual2.getSig();
        }

        this.mostrarPolinomio();
    }

    public void multiplicar(Polinomio polinomio1, Polinomio polinomio2) {
        Nodo actual1 = polinomio1.termino_mayor;
        Nodo actual2 = polinomio2.termino_mayor;

        while (actual1 != null) {
            while (actual2 != null) {
                this.agregarTermino(actual1.getInfo().getTermino() + actual2.getInfo().getTermino(), actual1.getInfo().getValor() * actual2.getInfo().getValor());
                actual2 = actual2.getSig();
            }

            actual1 = actual1.getSig();
            actual2 = polinomio2.termino_mayor;
        }

        this.mostrarPolinomio();
    }

    @Override
    public int getTermino() {
        return 0;
    }

    @Override
    public int getValor() {
        return 0;
    }

    @Override
    public void setTermino(int termino) {

    }

    @Override
    public void setValor(int valor) {

    }

    @Override
    public void setInfo(Dato_Polinomio dato) {

    }

    @Override
    public Dato_Polinomio getInfo() {
        return null;
    }

    @Override
    public void setSig(Nodo sig) {

    }

    @Override
    public Nodo getSig() {
        return null;
    }
}