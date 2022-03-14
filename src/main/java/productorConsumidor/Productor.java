package productorConsumidor;

public class Productor extends Thread{

    private Cargamento cargamento;

    public Productor(Cargamento c){
        this.cargamento = c;
    }

    @Override
    public void run() {
        while(true){
            int i = (int)(Math.random()*10)+1;
            cargamento.addProducto(i);
            System.out.println("sumados "+i+" productos");

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
