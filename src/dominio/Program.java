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
    
     public static void mostrarClientesAbonados(HashMap<Integer, String> listaClientesAbonados) {
        Integer clave;
        Iterator<Integer> clienteAbonado = listaClientesAbonados.keySet().iterator();
        System.out.println("Clientes con abono vigente:");
        while(clienteAbonado.hasNext()){
            clave = clienteAbonado.next();
            System.out.println(clave + " - " + listaClientesAbonados.get(clave));
        }        
    } 
     
    // ABRIR o CERRAR BARRERA**********************************************************************************************************************************************
    // Metodo encargado de la apertura de la barrera, el mismo es el que decide si
    // la barrera da error o no por medio de Azar.
    // Tambien es el encargado de redirigirnos o a la guardia o directamente a la
    // apertura de la barrera.
    public static void seAbreBarrera() {
        Random bool = new Random();
        int barreraRota = bool.nextInt(2);

        if (barreraRota == 0) {
            animacionSolicitarBarrera();
            
            limpiarPantallaConsola();
            subAnimacionDespedida();
        } else {
            animacionSolicitarBarrera();
            animacionDeBarreraRedirigiendoAGuardia();
        }
    } // Fin seAbreBarrrera
    
    // ATC - 1ra PARTE - 2da PARTE ****************************************************************************************************************************************
    
    // Menu verificador de ticket de cliente.*****************************************************************************************************
    
    // Menu Cobro********************************************************************************************************************************
    // Sub Menu para tipo de cobro para cliente CNR, con un Segun de dos opciones,
    	// Cobro al contado y Cobro por debito (cobro por tarjeta valida n tarjeta
    	// y calve de seguridad.
    	public static void menuCobro() {

        int efectivo, opcion, clave;
        long numTarjeta;
        
        limpiarPantallaConsola();
        tituloATC();
        System.out.println("		Ingrese un modo de pago: ");
        System.out.println(" ");
        System.out.println("		1. Pago de contado");
        System.out.println("		2. Pago con tarjeta");
        System.out.println("		3. MENU PRINCIPAL");
        System.out.println(" ");
        System.out.print("		Ingrese una opción deseada: ");
        opcion = Integer.parseInt(entrada.nextLine());
        System.out.println(" ");

        do {
            switch (opcion) {
                case 1:
                    limpiarPantallaConsola();
                    tituloATC();
                    System.out.println("		Valor del TICKET $150");
                    System.out.print("		Ingrese el monto a cobrar: ");
                    efectivo = Integer.parseInt(entrada.nextLine());
                    ingresoCNR++;
                    animacionProcesandoPago();
                    System.out.println("");
                    System.out.println("");
                    System.out.println("                                                                        [ Abrir Barrera ]");
                    System.out.println("");
                    pressAnyKeyToContinue();
                    seAbreBarrera();
                    break;
                case 2:
                    limpiarPantallaConsola();
                    tituloATC();
                    // Ingreso de numero de Tarjeta
                    System.out.print("		Ingrese el número de tarjeta (10 dígitos): ");
                    numTarjeta = Long.parseLong(entrada.nextLine());

                    // Parseo el int en string para utilizar metodo length y así validar la cantidad
                    // de caracteres.
                    long length = String.valueOf(numTarjeta).length();
                    // Valido cantidad de numeros de la Tarjeta
                    while (length != 10) {
                        System.out.println("");
                        System.out.println("		El número de tarjeta debe tener 10 digitos");
                        System.out.println("");
                        System.out.print("		Ingrese nuevamente el número de tarjeta del cliente ");
                        numTarjeta = Long.parseLong(entrada.nextLine());
                        length = String.valueOf(numTarjeta).length();
                    }
                    limpiarPantallaConsola();
                    tituloATC();
                    // Ingreso de Clave de la Tarjeta
                    System.out.println("");
                    System.out.print("		Ingrese la clave de seguridad: ");
                    clave = Integer.parseInt(entrada.nextLine());
                    // Valido cantidad de números de la clave de la Tarjeta
                    length = String.valueOf(clave).length();
                    while (length != 3) {
                        System.out.println("		La clave debe tener 3 digitos");
                        System.out.print("		Ingrese nuevamente la clave de seguridad: ");
                        clave = Integer.parseInt(entrada.nextLine());
                        length = String.valueOf(clave).length();
                    }
                    
                    while (numTarjeta != 1234567890 && clave != 123)  {
                           limpiarPantallaConsola();
                           tituloATC();
                           System.out.print("		                               ================== "); 
                           System.out.print("		                              || DATOS ERRONEOS || ");
                           System.out.print("		                               ================== "); 
                           System.out.print("");	
                           // Ingreso de numero de Tarjeta
                           System.out.print("		Ingrese nuevamente el número de tarjeta (10 dígitos): ");
                           numTarjeta = Long.parseLong(entrada.nextLine());
                           // Parseo el int en string para utilizar metodo length y así validar la cantidad
                           // de caracteres.
                           length = String.valueOf(numTarjeta).length();
                           // Valido cantidad de numeros de la Tarjeta
                           while (length != 10) {
                               System.out.println("		El número de tarjeta debe tener 10 digitos");
                               System.out.println("		Ingrese nuevamente el número de tarjeta del cliente ");
                               numTarjeta = Long.parseLong(entrada.nextLine());
                               length = String.valueOf(numTarjeta).length();
                           }
                           limpiarPantallaConsola();
                           tituloATC();
                           // Ingreso de Clave de la Tarjeta
                           System.out.println("");
                           System.out.print("		Ingrese nuevamente la clave de seguridad: ");
                           clave = Integer.parseInt(entrada.nextLine());
                           // Valido cantidad de números de la clave de la Tarjeta
                           length = String.valueOf(clave).length();
                           while (length != 3) {
                               limpiarPantallaConsola();
                               tituloATC();
                               System.out.println("		La clave debe tener 3 digitos");
                               System.out.print("		Ingrese nuevamente la clave de seguridad: ");
                               clave = Integer.parseInt(entrada.nextLine());
                               length = String.valueOf(clave).length();
                           }
                    } 
                    ingresoCNR++;
                    animacionProcesandoPago();
                    System.out.println("");
                    System.out.println("");
                    System.out.println("                                                                        [ Abrir Barrera ]");
                    System.out.println("");
                    pressAnyKeyToContinue();
                    seAbreBarrera();
                    break;
                case 3: // Salir
                    Parking.main(null);
                    break;
                default: // Opcion invalida
                    limpiarPantallaConsola();
                    tituloATC();
                    System.out.println("		Ingrese un modo de pago: ");
                    System.out.println(" ");
                    System.out.println("		1. Pago de contado");
                    System.out.println("		2. Pago con tarjeta");
                    System.out.println("		3. Salir");
                    System.out.print(" ");
                    System.out.print("		Ingrese una opción deseada: ");
                    opcionInvalidaParaMenu();
                    opcion = Integer.parseInt(entrada.nextLine());
                    limpiarPantallaConsola();
            }
        } while (opcion != 1 || opcion != 2 || opcion != 3);
        System.out.println("");
    } // Fin menuCobro
    // GUARDIA********************************************************************************************************************************SSS
    // Guardia recibe a modo de notificacion un solicitud para la verificacion de un
    // error en la barrera, la misma la
    // redirige la funcion Azar que se enuentra en el metodo "SeAbreBarrera()". Una
    // vez que se da ok a verificar, esta
    // simula una verificacion y reconexion por medio la animacion de
    // "animacionDeBarrera()", luego la cual,
    // finaliza el ejecucion del programa.

    public static void guardia() {
        tituloGuardia();
        System.out.println( "                                                      NOTIFICACIÓN: Se solicita una Verificación de Barrera");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("                                                                        [ Verificar ]");
        System.out.println("");
        pressAnyKeyToContinue();
        animacionDeBarrera();
    } // Fin Guardia
    
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
    
    //ANIMACIONES-UI********************************************************************************************************************************************************
    /* 
     * Estaran encargadas de darle mas realizmo a la aplicación, también son las
     * encargadas de ahorranos lineas de codigo,
     * ya que por ejemplo los "titulos" los utilizamos una y otra vez, los
     * creariamos una sola vez como un SubProceso y los llamariamos
     * constantemente donde se los requiera.
     * La mayor parte dan un valor visual, otros contendran otras animaciones
     * internarnas y otras serán las encargadas de redirigirnos
     * hacia otros menus o métodos.
     * 
     * Titulos para las diferentes ventanas por las cuales se navegara
     * TituloCreditos(), TituloATC(), TituloGuardia() y TituloSistema()
     * Animacion de tipo visual
     */
    public static void tituloCreditos() {
        System.out.println(
                "-------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------------------------------");
        System.out.println(
                "                                                                    TEAM INFORMATIC HAMSTERS");
        System.out.println(
                "                                                                    ------------------------");
        System.out.println(
                "--------------------------------------------------------<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<--------------------------------------------------------");
        System.out.println("");
    } // Fin tituloCreditos

    public static void tituloATC() {
        System.out.println(
                "-------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------------------------------");
        System.out.println(
                "                                                               ATENCION AL CLIENTE DE HAMSTER MALL");
        System.out.println(
                "                                                               -----------------------------------");
        System.out.println(
                "--------------------------------------------------------<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<--------------------------------------------------------");
        System.out.println("");
    } // Fin tituloATC

    public static void tituloGuardia() {
        System.out.println(
                "-------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------------------------------");
        System.out.println(
                "                                                               SERVICIO DE GUARDIA DE HAMSTER MALL");
        System.out.println(
                "                                                               -----------------------------------");
        System.out.println(
                "--------------------------------------------------------<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<--------------------------------------------------------");
        System.out.println("");
    } // Fin tituloGuardia

    public static void tituloSistema() {
        System.out.println(
                "-------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------------------------------");
        System.out.println(
                "                                                                 ¡¡ INFORMACION DE SISTEMA !!");
        System.out.println(
                "                                                                  ----------------------------");
        System.out.println(
                "--------------------------------------------------------<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<--------------------------------------------------------");
        System.out.println("");
    } // Fin tituloSistema

    // SubAnimacion para ser llamada desde la "animacionDeBarrera()"
    public static void tituloSubAnimacionDeBarrera() {
        System.out.println("		Se ha detectado que el error es debido a un problema de conexión: ");
        System.out.println(" ");
    } // Fin tituloSubAnimacionDeBarrera

    // For en metodo para animar textos en las animaciones de ATC
    public static void forDeAnimarAnimacionesATC(int tiempo, String mensaje) {
        for (int i = 0; i <= 2; i = i + 1) {
            limpiarPantallaConsola();
            tituloATC();
            System.out.println("		" + mensaje);
            esperar(tiempo);
            limpiarPantallaConsola();
            tituloATC();
            System.out.println("		" + mensaje + ".");
            esperar(tiempo);
            limpiarPantallaConsola();
            tituloATC();
            System.out.println("		" + mensaje + "..");
            esperar(tiempo);
            limpiarPantallaConsola();
            tituloATC();
            System.out.println("		" + mensaje + "...");
            esperar(tiempo);
            limpiarPantallaConsola();
        }
    } // Fin forDeAnimarAnimacionesATC

    public static void animacionFormasDePago() {
        forDeAnimarAnimacionesATC(4, "Cargando formas de pago, aguarde");
        limpiarPantallaConsola();
    } // Fin animacionFormasDePago

    public static void opcionInvalidaParaMenu() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(
                "                                                                -----------------------------------");
        System.out.println(
                "                                                                |         Opción inválida         |");
        System.out.println(
                "                                                                -----------------------------------");
        System.out.println(" ");
        System.out.print("		Ingrese nuevamente una opción deseada: ");
    } // Fin opcionInvalidaParaMenu

    public static void animacionProcesandoPago() {
        limpiarPantallaConsola();
        tituloATC();
        esperar(4);
        forDeAnimarAnimacionesATC(4, "Procesando pago, aguarde");
        tituloATC();
        System.out.println("		                                               ¡El pago se realizó correctamente!");
    } // Fin animacionProcesandoPago

    public static void animacionVerificacionDeDatos() {
        limpiarPantallaConsola();
        tituloATC();
        esperar(4);
        forDeAnimarAnimacionesATC(4, "Verificando datos, aguarde un momento");
    } // Fin animacionVerificacionDeDatos

    public static void animacionSolicitarBarrera() {
        limpiarPantallaConsola();
        tituloATC();
        esperar(4);
        forDeAnimarAnimacionesATC(4, "Solicitando Barrera");
    } // Fin animacionSolicitarBarrera

    // Animacion encargada de dar un informe de sistema de ERROR GRAVE, el cual
    // necesita ser verificado por "Guardia()"
    // posteriormente. Tambien se utilizaria en el momento que Guardia() realiza la
    // verificacion.
    public static void subAnimacionError() {
        limpiarPantallaConsola();
        tituloSistema();
        esperar(4);
        limpiarPantallaConsola();
        tituloSistema();
        System.out.println(
                "--------------------------------------------------------------------------ERROR ERROR---------------------------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------------------------ERROR ERROR---------------------------------------------------------------------------");
        esperar(5);
        limpiarPantallaConsola();
        tituloSistema();
        System.out.println(
                "--------------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------------");
        esperar(4);
        limpiarPantallaConsola();
        tituloSistema();
        System.out.println(
                "--------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------");
        esperar(3);
        limpiarPantallaConsola();
        tituloSistema();
        esperar(3);
        System.out.println(
                "--------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------");
        System.out.println(
                "--------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------");
        esperar(3);
        limpiarPantallaConsola();
        tituloSistema();
        esperar(3);
        System.out.println(
                "--------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------");
        System.out.println(
                "--------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------");
        esperar(5);
        limpiarPantallaConsola();
        tituloSistema();
        esperar(3);
        System.out.println(
                "--------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------");
        System.out.println(
                "--------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------");
        esperar(5);
        limpiarPantallaConsola();
        tituloSistema();
        esperar(3);
        System.out.println(
                "--------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------");
        System.out.println(
                "--------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------");
        esperar(6);
        limpiarPantallaConsola();
        tituloSistema();
        esperar(1);
        System.out.println(
                "--------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------");
        System.out.println(
                "--------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------");
        esperar(1);
        limpiarPantallaConsola();
        tituloSistema();
        esperar(1);
        System.out.println(
                "--------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------");
        esperar(1);
        limpiarPantallaConsola();
        tituloSistema();
        esperar(1);
        System.out.println(
                "--------------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------------");
        esperar(1);
        limpiarPantallaConsola();
        tituloSistema();
        esperar(1);
        System.out.println(
                "--------------------------------------------------------------------ERROR ERROR ERROR ERROR---------------------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------------------ERROR ERROR ERROR ERROR---------------------------------------------------------------------");
        esperar(1);
        limpiarPantallaConsola();
        tituloSistema();
        esperar(1);
        System.out.println(
                "--------------------------------------------------------------------------ERROR ERROR---------------------------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------------------------ERROR ERROR---------------------------------------------------------------------------");
        esperar(1);
        limpiarPantallaConsola();
        tituloSistema();
        esperar(1);
        System.out.println(
                "-----------------------------------------------------------------------------ERROR------------------------------------------------------------------------------");
        System.out.println(
                "-----------------------------------------------------------------------------ERROR------------------------------------------------------------------------------");
        esperar(1);
        limpiarPantallaConsola();
    }

    // Animacion que se llama desde "SeAbreBarrera()" si se encuentra un error (por
    // medio de Azar), es la encargada
    // de notificar al usuario, y también es la encargada de redireccionar hacia
    // "Guardia()"
    public static void animacionDeBarreraRedirigiendoAGuardia() {
        limpiarPantallaConsola();
        subAnimacionError();
        esperar(7);
        for (int i = 0; i <= 2; i = i + 1) {
            limpiarPantallaConsola();
            tituloSistema();
            System.out.println("		Detectamos un ERROR en la solicitud.");
            System.out.println("		Aguarde un momento, un Guardia verificará el inconveninte.");
            System.out.println(" ");
            System.out.println("		Solicitando");
            esperar(6);
            limpiarPantallaConsola();
            tituloSistema();
            System.out.println("		Detectamos un ERROR en la solicitud.");
            System.out.println("		Aguarde un momento, un Guardia verificará el inconveninte.");
            System.out.println(" ");
            System.out.println("		Solicitando.");
            esperar(6);
            limpiarPantallaConsola();
            tituloSistema();
            System.out.println("		Detectamos un ERROR en la solicitud.");
            System.out.println("		Aguarde un momento, un Guardia verificará el inconveninte.");
            System.out.println(" ");
            System.out.println("		Solicitando..");
            esperar(6);
            limpiarPantallaConsola();
            tituloSistema();
            System.out.println("		Detectamos un ERROR en la solicitud.");
            System.out.println("		Aguarde un momento, un Guardia verificará el inconveninte.");
            System.out.println(" ");
            System.out.println("		Solicitando...");
            esperar(6);
        }
        limpiarPantallaConsola();
        guardia();
    } // Fin animacionDeBarreraRedirigiendoAGuardia

    // Animacion para simular reconexion de barrera desde "Guardia()", la misma
    // tambien da cierre el programa.
    public static void animacionDeBarrera() {
        esperar(4);
        subAnimacionError();
        esperar(12);
        for (int i = 0; i <= 2; i = i + 1) {
            limpiarPantallaConsola();
            tituloSistema();
            tituloSubAnimacionDeBarrera();
            System.out.println("		Restableciendo conexión");
            esperar(4);
            limpiarPantallaConsola();
            tituloSistema();
            tituloSubAnimacionDeBarrera();
            System.out.println("		Restableciendo conexión");
            esperar(4);
            limpiarPantallaConsola();
            tituloSistema();
            tituloSubAnimacionDeBarrera();
            System.out.println("		Restableciendo conexión..");
            esperar(4);
            limpiarPantallaConsola();
            tituloSistema();
            tituloSubAnimacionDeBarrera();
            System.out.println("		Restableciendo conexión...");
            esperar(4);
        }
        limpiarPantallaConsola();
        tituloSistema();
        esperar(2);
        System.out.println(
                "                                                                  ¡LA BARRERA SE HA ARREGLADO!");
        esperar(2);
        System.out.println("");
        System.out.println("");
        System.out.println("                                                                        [ Abrir Barrera ]");
        System.out.println("");
        pressAnyKeyToContinue();
        subAnimacionDespedida();
    } // Fin animacionDeBarrera

    // Animacion para simulacion de barrera en estado de OK y despedida para
    // clientes.
    public static void subAnimacionDespedida() {
        for (int i = 0; i <= 2; i = i + 1) {
            limpiarPantallaConsola();
            tituloATC();
            System.out.println(
                    "                                                                                                          ");
            System.out.println(
                    "                                                                                                          ");
            System.out.println(
                    "                                                                                                          ");
            System.out.println(
                    "                                                                                                          ");
            System.out.println(
                    "                                                                             ===============              ");
            System.out.println(
                    "                                                                                          / \\            ");
            System.out.println(
                    "                                                                                         ||  ||           ");
            System.out.println(
                    "                                                                 *Se abre la barrera*    ||  ||           ");
            esperar(3);
            limpiarPantallaConsola();
            tituloATC();
            System.out.println(
                    "                                                                                      \\                  ");
            System.out.println(
                    "                                                                                       \\                 ");
            System.out.println(
                    "                                                                                        \\                ");
            System.out.println(
                    "                                                                                         \\               ");
            System.out.println(
                    "                                                                                          \\              ");
            System.out.println(
                    "                                                                                          / \\            ");
            System.out.println(
                    "                                                                                         ||  ||           ");
            System.out.println(
                    "                                                                 *Se abre la barrera*    ||  ||           ");
            esperar(4);
            limpiarPantallaConsola();
            tituloATC();
            System.out.println(
                    "                                                                                                          ");
            System.out.println(
                    "                                                                                                          ");
            System.out.println(
                    "                                                                                                          ");
            System.out.println(
                    "                                                                                                          ");
            System.out.println(
                    "                                                                             ===============              ");
            System.out.println(
                    "                                                                                          / \\            ");
            System.out.println(
                    "                                                                                         ||  ||           ");
            System.out.println(
                    "                                                                 *Se abre la barrera*    ||  ||           ");
            esperar(3);
            limpiarPantallaConsola();
            tituloATC();
            System.out.println(
                    "                                                                                      \\                  ");
            System.out.println(
                    "                                                                                       \\                 ");
            System.out.println(
                    "                                                                                        \\                ");
            System.out.println(
                    "                                                                                         \\               ");
            System.out.println(
                    "                                                                                          \\              ");
            System.out.println(
                    "                                                                                          / \\            ");
            System.out.println(
                    "                                                                                         ||  ||           ");
            System.out.println(
                    "                                                                 *Se abre la barrera*    ||  ||           ");
            esperar(4);
        }
        esperar(2);
        continuarConOtroCliente();
    } // Fin subAnimacionDespedida

    // Continuar con otro Cliente o Salir?
    public static void continuarConOtroCliente() {
        int opcionElegida;
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("		                                                Volver al MENU PRINCIPAL? ");
        System.out.println("		                                                1. MENU PRINCIPAL ");
        System.out.println("		                                                2. Salir");
        System.out.println("");
        System.out.print("		                                                Ingrese una opción deseada: ");
        opcionElegida = Integer.parseInt(entrada.nextLine());
        if (opcionElegida == 1) {
            limpiarPantallaConsola();
            // Vuelve a ejecutar el main
            Parking.main(null);
        } else {
            System.out.println("");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(
                    "                                                              Gracias por su visita en Hamster Mall.");
            esperar(2);
        }
    } // Fin continuarConOtroCliente
} // Fin Clase

