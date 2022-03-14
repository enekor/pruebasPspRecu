package clienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Socket server;
    private int puerto = 5555;
    private boolean salir = false;
    private DataInputStream input;
    private DataOutputStream output;
    private List<Integer> numeros = new ArrayList<>();

    Cliente() throws IOException {
        server = new Socket("localhost",puerto);
        output = new DataOutputStream(server.getOutputStream());
        input = new DataInputStream(server.getInputStream());

        while(!salir){

            int numero = input.readInt();

            if(numero==3){
                System.out.println("numero = 3, parando");
                output.writeBoolean(true);
                System.exit(0);
            }else{
                System.out.println("numero != 3, continue");
                output.writeBoolean(false);
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Cliente();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
