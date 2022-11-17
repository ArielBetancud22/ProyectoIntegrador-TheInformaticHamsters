/*
Proyecto Integrador:       
    PARKING 2.0

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

package dominio;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Program {
    public static Scanner entrada = new Scanner(System.in);
    //Diccionario "Base de Datos"
    public static HashMap<Integer, String> listaClientesAbonados = new HashMap<Integer, String>();
    //Contadores de ingresos para arqueo de caja
    public static int ingresoCNR;
    public static int ingresoAbonado;   
    
    
    // MAIN
     public static void main(String[] args) {
        limpiarPantallaConsola();
        String nombreCompleto;
        int dni;
        String ordenCompra;
        int opcion;
        Scanner ca = new Scanner(System.in);
        // Clientes previamente registrados en "Base de Datos"
        listaClientesAbonados.put(34898489, "Nicolas Segovia");
        listaClientesAbonados.put(33333333, "Pepe Grillo");
        listaClientesAbonados.put(22222222, "Pikachu Pokemon");
        
        // Menu principal, donde registraremos Usuario en la Matriz, Ingresaremos a un sub menu para dar ingreso al servicio 
        //de parking a los distintos Cleintes, Podremos listar el Registro de Usuario y solicitar el Arqueo de Caja.
        tituloATC();
        System.out.println("		MENU: ");
        System.out.println("");
        System.out.println("		1. Ingresar Usuario");
        System.out.println("		2. Registrar un nuevo Abonado");
        System.out.println("		3. Clientes con Abono Vigente");
        System.out.println("		4. Arqueo de caja");
        System.out.println("");
        System.out.print("		Ingrese una opción deseada: ");
        opcion = Integer.parseInt(entrada.nextLine());
        limpiarPantallaConsola();
        tituloATC();       
        switch (opcion) { 
            //Registrar usuarios como Cliente Abonado, los mismos se iran guardando un diccionario, con su DNI como Key
            case 1:
                //ingresar al parking
                //Desde este menu podemos gestionar los Distintos tipos de Clientes, Abonados, con Orden de Compra y CNR.
                limpiarPantallaConsola();
                tituloATC();
                System.out.println("		MENU: ");
                System.out.println("");
                System.out.println("		1. Cliente Abonado");
                System.out.println("		2. Cliente con Orden de Compra");
                System.out.println("		3. Cliente No Registrado");
                System.out.println("		4. MENU PRINCIPAL");
                System.out.println("");
                System.out.print("		Ingrese una opción deseada: " );
                opcion = Integer.parseInt(entrada.nextLine());
                limpiarPantallaConsola();
                switch(opcion) {
                    case 1:
                        tituloATC();
                        System.out.print("Introduce el DNI del Cliente: ");
                        String dniString = entrada.next();
                        dni = Integer.parseInt(dniString);
                        //Boolean dcBool = listaClientesAbonados.containsKey(dniCliente);
                        System.out.println("");
                        if (listaClientesAbonados.containsKey(dni)){
                            String clienteAbonado = listaClientesAbonados.get(dni).toString();
                            System.out.println("");
                            System.out.print("Se encuentra un Usuario Vigente: ");
                            System.out.println(clienteAbonado);
                            System.out.println("");
                            System.out.println("");
                            System.out.println("                                                                        [ Abrir Barrera ]");
                            System.out.println(""); 
                            pressAnyKeyToContinue(); 
                            seAbreBarrera();
                        }
                        else {
                            
                            // FALTA NO SE ENCUENTRA UN USUARIO VIGENTE CON ESE DNI, AGREGARLO?
                            System.out.print("Introduce el nombre completo del Cliente: ");
                            nombreCompleto = ca.next();
                            listaClientesAbonados.put(dni, nombreCompleto);  
                            ingresoAbonado++;
                            esperar(4);
                            animacionVerificacionDeDatos();
                            limpiarPantallaConsola();
                            tituloATC();
                            System.out.println("¡Cliente Registrado Exitosamente!");
                            System.out.println("");
                            System.out.println("");
                            System.out.println("                                                                        [ Abrir Barrera ]");
                            System.out.println(""); 
                            pressAnyKeyToContinue(); 
                            seAbreBarrera();
                        }
                        break;
                    case 2: 
                        // Creamos un lista de Ordenes de Compra, para validar vs el ingresado por el usuario
                        List<String> ordenes = new ArrayList<String>(){
                            {
                            add("1111");
                            add("2222");
                            add("3333");
                            add("4444");
                            add("5555");
                            }
                        };
                        limpiarPantallaConsola();
                        tituloATC();
                        System.out.print("		Digite el número de Orden de Compra: " );
                        ordenCompra = entrada.nextLine();
                        while (ordenCompra.length() != 4) {
                            limpiarPantallaConsola();
                            tituloATC();
                            System.out.println("		El numero de compra debe tener 4 digitos " );
                            System.out.println("" );
                            System.out.print("		Digite nuevamente el número de Orden de Compra: " );
                            ordenCompra = entrada.nextLine();
                            animacionVerificacionDeDatos();
                        }
                        // Verificamos si la OC ingresada existe en la lista
                        if (ordenes.contains(ordenCompra)){
                            limpiarPantallaConsola();
                            tituloATC();
                            System.out.println("");
                            System.out.println("                                                                       * Orden Validada *");
                            System.out.println("		                                               Usuario registrado por nuestra WEB!");
                            System.out.println("");
                            System.out.println("");
                            System.out.println("		                                                       [ Abrir Barrera ]");
                            System.out.println("");
                            pressAnyKeyToContinue();    
                        } 
                        else {
                            do{
                                limpiarPantallaConsola();
                                tituloATC();
                                System.out.println("		El numero de compra es inexistente " );
                                System.out.println("" );
                                System.out.print("		Digite nuevamente el número de Orden de Compra: " );
                                ordenCompra = entrada.nextLine();
                                } while (ordenes.contains(ordenCompra));
                        }
                        esperar(7);
                        seAbreBarrera();
                        break;
                    case 3:
                        menuCRN(); 
                        ingresoCNR++;
                        break;
                    case 4:
                        Parking.main(null);
                        break;
                }
                break;
            case 2: 
                limpiarPantallaConsola();
                tituloATC();
                System.out.print("Introduce el DNI del Cliente: ");
                dni = ca.nextInt();
                animacionVerificacionDeDatos();
                if (listaClientesAbonados.containsKey(dni)) {
                    tituloATC();
                    System.out.println("No se puedo registrar el usuario. El DNI ya se encuentra registrado.");
                    continuarConOtroCliente();
                } 
                else {
                    tituloATC();
                    System.out.print("Introduce el nombre completo del Cliente: ");
                    nombreCompleto = ca.next();
                    listaClientesAbonados.put(dni, nombreCompleto);  
                }
                esperar(4);
                animacionVerificacionDeDatos();
                limpiarPantallaConsola();
                tituloATC();
                System.out.println("                                                       ¡Cliente Registrado Exitosamente!");
                System.out.println("");
                continuarConOtroCliente();
                break;
            case 3: 
                mostrarClientesAbonados(listaClientesAbonados);
                continuarConOtroCliente();
                break;
            case 4: 
                // En este menu podemos ir registrando el mongo en nuestro arqueo de caja, se suman los CNR y dan conteo, clientes Abonados (registrados)
                // con exepcion de clientes que ingresan con OC.
                limpiarPantallaConsola();
                tituloATC();
                
                System.out.println(""); 
                System.out.println("		                                                   RECAUDACIÓN DEL DÍA: ");
                System.out.println("");
                System.out.println("");
                System.out.println("		                                                   De "+ingresoCNR+" CNR ingresados.");
                System.out.println("		                                                            Se recaudó $"+ingresoCNR * 150);
                System.out.println("");
                System.out.println("		                                                   De "+ingresoAbonado+" abonados.");
                System.out.println("		                                                            Se recaudó $"+ingresoAbonado * 3000);
                System.out.println("");
                System.out.println("                                                                  ============================");
                System.out.println("                                                                    Recaudación TOTAL: $"+((ingresoCNR * 150)+(ingresoAbonado * 3000)));
                System.out.println("                                                                  ============================");
                continuarConOtroCliente();
                break;
            default:
                limpiarPantallaConsola();
                tituloATC();
                System.out.println("		MENU: ");
                System.out.println("");
                System.out.println("		1. Ingresar Usuario");
                System.out.println("		2. Registrar Nuevo Usuario");
                System.out.println("		3. Registro de Usuarios");
                System.out.println("		4. Arqueo de caja");
                opcionInvalidaParaMenu();
                opcion = Integer.parseInt(entrada.nextLine());
                limpiarPantallaConsola();
                break;
        }

    } // Fin Main
    
    // ABRIR o CERRAR BARRERA**********************************************************************************************************************************************
    
    
    // ATC - 1ra PARTE - 2da PARTE ****************************************************************************************************************************************
    
    // Menu verificador de ticket de cliente.*****************************************************************************************************
    
    // Menu Cobro********************************************************************************************************************************
    
    // GUARDIA********************************************************************************************************************************
    
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
