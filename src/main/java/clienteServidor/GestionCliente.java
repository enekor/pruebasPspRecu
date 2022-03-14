package clienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GestionCliente extends Thread{

    private Socket cliente;
    private DataOutputStream output;
    private DataInputStream input;
    private boolean parar = false;

    GestionCliente(Socket s) throws IOException {
        cliente = s;
        output = new DataOutputStream(cliente.getOutputStream());
        input = new DataInputStream(cliente.getInputStream());
    }

    @Override
    public void run() {
        while (!parar){
            int i = (int)(Math.random()*10)+1;
            try {
                output.writeInt(i);

                parar = input.readBoolean();

                if(parar) {
                    System.out.println("parando");
                    cliente.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
