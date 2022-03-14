package clienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private ServerSocket server;
    private Socket cliente;
    private int puerto = 5555;
    private DataInputStream input;
    private DataOutputStream output;

    Servidor() throws IOException {
        server = new ServerSocket(puerto);

        do{
            System.out.println("esperando cliente");
            cliente = server.accept();
            new GestionCliente(cliente).start();
        }while(true);
    }

    public static void main(String[] args) {
        try {
            new Servidor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
