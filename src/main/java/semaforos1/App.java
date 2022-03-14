package semaforos1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(2);
        List<Escritor> escritores = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            escritores.add(new Escritor(semaforo, i));
        }

        escritores.forEach(v -> v.start());
    }
}
