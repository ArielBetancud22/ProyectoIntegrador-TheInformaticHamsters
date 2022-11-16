
package dominio;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
Poryecto Integrador:       
    " PARKING 2.0 "

Grupo: 
    The Informatic Hamsters
  
Integrantes: 
    - Acosta, Nadia Yanella
    - Dealbera Etchechoury, Giuliana
    - Diaz Luna, Giuliana Paola
    - Nolan, Juan Pablo
    - Rodriguez Saquilan, Miguel
    - Quispe, Marcelo Alejandro
    - Quiquinto Romina Ayelen
    - Segovia, Jorge Nicolas

 */
public class Program {
    public static Scanner entrada = new Scanner(System.in);
    //Diccionario "Base de Datos"
    public static HashMap<Integer, String> listaClientesAbonados = new HashMap<Integer, String>();
    //Contadores de ingresos para arqueo de caja
    public static int ingresoCNR;
    public static int ingresoAbonado;   
    
    
    // MAIN
    
    // ABRIR o CERRAR BARRERA**********************************************************************************************************************************************
    
    
    // ATC - 1ra PARTE - 2da PARTE
    // ****************************************************************************************************************************************
    
    // Menu verificador de ticket de cliente.*****************************************************************************************************
    
    // Menu Cobro********************************************************************************************************************************
    
    //// GUARDIA********************************************************************************************************************************
    
    // MENU CNR*******************************************************************************************************************************
    
    // UTILIDADES******************************************************************************************************************************

    // Limpiar pantalla (Consola)
    public static void limpiarPantallaConsola() {
        try {
            // System.out.println("Presione Enter para continuar...");
            // new java.util.Scanner(System.in).nextLine();

            String sistemaOperativo = System.getProperty("os.name");
            ArrayList<String> comando = new ArrayList<String>();
            if (sistemaOperativo.contains("Windows")) {
                comando.add("cmd");
                comando.add("/c");
                comando.add("cls");
            } else {
                comando.add("clear"); // UNIX => MAC, LINUX
            }
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process iniciarProceso = pb.inheritIO().start();
            iniciarProceso.waitFor();
        } catch (Exception e) {
            System.err.println("Error al limpiar la pantalla" + e.getMessage());
        }
    } // Fin Limpiar pantalla (Consola)

    // Limpiar pantalla (IDE)
    public static void limpiarPantallaIDE() {
        try {
            System.out.println("Presione Enter para continuar...");
            new java.util.Scanner(System.in).nextLine();

            Robot pressbot = new Robot();
            pressbot.keyPress(KeyEvent.VK_CONTROL);
            pressbot.keyPress(KeyEvent.VK_L);
            pressbot.keyRelease(KeyEvent.VK_CONTROL);
            pressbot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
            System.out.println("Error al limpiar la pantalla" + ex.getMessage());
        }
    } // Fin Limpiar pantalla (IDE)

    static public void pressAnyKeyToContinue() {
        String seguir;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Presione cualquier tecla para continuar..");
        try {
            seguir = teclado.nextLine();
        } catch (Exception e) {
        }
    } // Fin pressAnyKeyToContinue

    // Pausa la ejecución durante X segundos.
    // @param segundos El número de segundos que se quiere esperar.
    public static void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos * 100);
        } catch (Exception e) {
            System.out.println(e);
        }
    } // Fin esperar

    // Pausa la ejecucion del programa (sin finalizarlo),hasta que se presione
    // alguna tecla, una vez presionada, se reanudaria la ejecucion.
    public static void pausa() {
        System.out.println(" ");
        Integer.parseInt(entrada.nextLine());
    } // Fin pausa
    
    //ANIMACIONES*************************************************************************************************************************************************************
}
