package observer;

import java.util.ArrayList;
import java.util.List;

public class Observado implements Observable{

    private List<Observador> observadores = new ArrayList<>();
    public Observado(List<Observador> o){
        this.observadores = o;
    }

    public void generarNumeros(){
        while(true){
            System.out.println("generando");
            int i = (int)(Math.random()*10)+1;
            if(i==6){
                notificar();
            }
        }
    }
    @Override
    public void notificar() {
        observadores.forEach(Observador::recibirNotificacion);
    }
}
