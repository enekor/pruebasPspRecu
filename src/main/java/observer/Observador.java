package observer;

public class Observador implements Observer{

    @Override
    public void recibirNotificacion() {
        System.out.println("Alguien me ha llamado?");
    }
}
