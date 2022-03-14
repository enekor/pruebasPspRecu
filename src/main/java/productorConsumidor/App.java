package productorConsumidor;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Cargamento cargamento = new Cargamento();
        List<Consumidor> consumidores = List.of(new Consumidor(cargamento));
        List<Productor> productores = List.of(new Productor(cargamento));

        consumidores.forEach(Thread::start);
        productores.forEach(Thread::start);
    }
}
