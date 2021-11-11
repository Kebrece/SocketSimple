package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args)
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(8899);//Construye un canal de comunicacion para que el cliente se pueda comunicar con nosotros
            Socket socket = serverSocket.accept();//Aca aceptamos la conexion entrante del servidor, osea la aplicacion se va a quedar esperando permanentemente por cualquier conexion que venga
            InputStreamReader input = new InputStreamReader(socket.getInputStream());
            BufferedReader buffer = new BufferedReader(input);
            String msjCliente = buffer.readLine();
            System.out.println("El cliente dice "+msjCliente);

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("Hola desde la app del cliente");
            printWriter.flush();

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
