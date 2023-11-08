/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cliente;

/**
 *
 * @author Martin
 */
public class Messenger {

    /**
     * @param args the command line arguments
     */
    public static Conectar servidor,cliente;
    public static void main(String[] args) {
        
        VCliente cliente = new VCliente();
        cliente.main();
    }
    
    public static void initCliente(String ip){
        cliente = new Conectar(ip);
        cliente.start();
    }
    
}
