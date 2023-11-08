/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Martin
 */
public class Conectar extends Thread{
    
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida; 
    private BufferedReader entrada;
    final int puerto = 8000;

    public Conectar(String ip){
        try{
            this.s = new Socket(ip,this.puerto);
            
            //Creacion de entrada de datos para lectura de mensajes
            this.entradaSocket = new InputStreamReader(s.getInputStream());
            this.entrada = new BufferedReader(entradaSocket);
            
            //Creacion de salida de datos para el envio de mensajes
            this.salida = new DataOutputStream(s.getOutputStream());
            this.salida.writeUTF("Conectado... \n\n");
        }catch(IOException e){};
    }
    
    public void run(){
        String texto;
        while(true){
            try{
                texto = entrada.readLine();
                VCliente.jTextArea1.setText(VCliente.jTextArea1.getText()+"\n"+texto);
            }catch(IOException e){};
        }
            
    }
    
    public void enviarMSG(String msg){
        System.out.println("Enviado");
        try{
            this.salida = new DataOutputStream(s.getOutputStream());
            this.salida.writeUTF(msg+"\n");
        }catch(IOException e){
            System.out.println("Problema al enviar");
        };
    }
    
    public String leerMSG(){
        try{
            return entrada.readLine();
        }catch(IOException e){};
        return null;
    }
    
}
