
package client;
import java.io.*;
import java.net.*;

public class EchoClient {
    //definimos el Stub del cliente
    private static EchoObjectStub ss;
    
    public static void main(String[] args) 
    {
        // revisamos que los argumentos para ejecutar el programa son correctos
        String c_a_pagar="";
        String tarjeta="";
        String cvv="";
        int ver = 0;
        if (args.length<2) {
            System.out.println("Para ejecutar , hazlo en este formato: Echo <nombre o IP del Equipo> <numero de puerto>");
            System.exit(1);
        }
        //instanciamos el STUB
        ss = new EchoObjectStub();
    // le asignamos al STUB el puerto y nombre del equipo HOST (el nombre del servidor) 
        ss.setHostAndPort(args[0],Integer.parseInt(args[1]));
        String input,output;
        try {  
                    //construyo un bucle infinito:

            while(true){
                //preparo "apuntador" que es el lector de flujo para el teclado
                BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));
                // asigno a una variable y leo una linea del lector de flujo que leyo del teclado
                c_a_pagar=in.readLine();
                tarjeta =in.readLine();
                cvv =in.readLine();
               // Invocar el stub con el metodo remoto echo e Imprimir .. 
                //por pantalla lo que regreso el metodo remoto echo
//                System.out.println(ss.echo(cadena));
		ver = ss.pago(c_a_pagar,tarjeta,cvv);
		if (ver==0){
			System.out.println("la transacción no fue exitosa intente otro metodo de pago");
		}
		else {System.out.println("la transacción fue exitosa, se confirma su compra y su pedido está en camino");}
            }
        } 
        //catch (UnknownHostException e) {
            //System.err.println("Don't know about host: "+ args[0]);
        //} 
        catch (IOException e) {
            System.err.println("Falla conexion de E/S con el host:"+args[0]);
        }
    }
}
