package semaforos1;

import java.util.concurrent.Semaphore;

public class Escritor extends Thread{

    private Semaphore semaforo;
    private int id;
    private int contador;

    public Escritor(Semaphore semaforo, int id){
        this.semaforo = semaforo;
        this.id = id;
    }

    @Override
    public void run() {
        while(contador<5){
            try{
                semaforo.acquire();
                System.out.println("El escritor "+id+" tiene el semaforo");
                Thread.sleep((int)(Math.random()*1000)+1000);
                System.out.println("El escritor "+id+" suelta el semaforo");
                contador++;
                semaforo.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
