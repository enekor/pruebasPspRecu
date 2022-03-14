package productorConsumidor;

import lombok.Data;

@Data
public class Cargamento {

    private int productos = 0;
    private boolean vacio = true;
    private boolean lleno = false;

    public synchronized void addProducto(int i){
        while(lleno){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        productos+=i;
        System.out.println("productos: "+productos);
        vacio = false;

        if(productos>=100){
            lleno = true;
        }

        notifyAll();
    }

    public synchronized void consumir(int i){
        while(vacio){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        productos-=i;
        System.out.println("productos: "+productos);
        lleno = false;

        if(productos<=0){
            vacio = true;
        }

        notifyAll();
    }
}
