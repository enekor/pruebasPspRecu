package observer;

import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Observador> observers = List.of(new Observador(),new Observador(),new Observador(),new Observador());
        Observado observado = new Observado(observers);

        observado.generarNumeros();
    }
}
