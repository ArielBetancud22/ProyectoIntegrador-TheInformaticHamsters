package dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;



public class Utilidades {
    public static Scanner entrada = new Scanner(System.in);
    public static Scanner entrada2 = new Scanner(System.in);
    
    
    public static void mostrarClientesAbonados(HashMap<Integer, String> listaClientesAbonados) {
        Integer clave;
        Iterator<Integer> clienteAbonado = listaClientesAbonados.keySet().iterator();
        System.out.println("Clientes con abono vigente:");
        while(clienteAbonado.hasNext()){
            clave = clienteAbonado.next();
            System.out.println(clave + " - " + listaClientesAbonados.get(clave));
        }        
    } 
    
    /*
    Metodo encargado de la apertura de la barrera, el mismo es el que decide si la barrera da error o no por 
    medio de Azar.
    Tambien es el encargado de redirigirnos o a la guardia o directamente a la apertura de la barrera.
    */
    public static void seAbreBarrera() {
        Random bool = new Random();
        
        int barreraRota = bool.nextInt(2);

        if (barreraRota == 0) {
            Animaciones.animacionSolicitarBarrera();
            
            Utilidades.limpiarPantalla();
            Animaciones.subAnimacionDespedida();
        } else {
            Animaciones.animacionSolicitarBarrera();
            Animaciones.animacionDeBarreraRedirigiendoAGuardia();
        }
    } // Fin seAbreBarrrera
    
    // Limpiar pantalla (Consola)
    public static void limpiarPantalla() {
        try {
            // System.out.println("Presione Enter para continuar...");
            // new java.util.Scanner(System.in).nextLine();

            String sistemaOperativo = System.getProperty("os.name");
            ArrayList<String> comando = new ArrayList<>();
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
//    public void limpiarPantalla() {
//        try {
//            System.out.println("Presione Enter para continuar...");
//            new java.util.Scanner(System.in).nextLine();
//
//            Robot pressbot = new Robot();
//            pressbot.keyPress(KeyEvent.VK_CONTROL);
//            pressbot.keyPress(KeyEvent.VK_L);
//            pressbot.keyRelease(KeyEvent.VK_CONTROL);
//            pressbot.keyRelease(KeyEvent.VK_L);
//        } catch (AWTException ex) {
//            System.out.println("Error al limpiar la pantalla" + ex.getMessage());
//        }
//    } // Fin Limpiar pantalla (IDE)

    public static void pressAnyKeyToContinue() {
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
}
