package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
    public static void main(String[] args)
    {
        try
        {
            Socket socketCliente = new Socket("localhost", 8899);
            PrintWriter printWriter = new PrintWriter(socketCliente.getOutputStream());
            printWriter.println("Hola desde la app del cliente");
            printWriter.flush();

            InputStreamReader input = new InputStreamReader(socketCliente.getInputStream());
            BufferedReader buffer = new BufferedReader(input);
            String msjServidor = buffer.readLine();
            System.out.println("El servidor dice "+msjServidor);

        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
