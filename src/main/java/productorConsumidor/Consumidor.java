package productorConsumidor;

public class Consumidor extends  Thread{

    private Cargamento cargamento;

    public Consumidor(Cargamento c){
        this.cargamento = c;
    }

    @Override
    public void run() {

        while (true){
            int i = (int)(Math.random()*10)+1;
            cargamento.consumir(i);
            System.out.println("Extraidos "+i+" productos");

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
