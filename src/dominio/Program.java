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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Program {
    public static Scanner entrada = new Scanner(System.in);
    public static Scanner entrada2 = new Scanner(System.in);
    //Diccionario "Base de Datos"
    public static HashMap<Integer, String> listaClientesAbonados = new HashMap<>();
    //Contadores de ingresos para arqueo de caja
    public static int ingresoCNR;
    public static int ingresoAbonado;   
    
    
     public static void main(String[] args) {
        
        String nombreCompleto;
        int dni, opcion;
        String ordenCompra;
        Utilidades u = new Utilidades();
        Animaciones a = new Animaciones();
        Scanner ca = new Scanner(System.in);
        // Clientes previamente registrados en "Base de Datos"
        listaClientesAbonados.put(34898489, "Nicolas Segovia");
        listaClientesAbonados.put(33333333, "Pepe Grillo");
        listaClientesAbonados.put(22222222, "Pikachu Pokemon");
        
        // Menu principal, donde registraremos Usuario en la Matriz, Ingresaremos a un sub menu para dar ingreso al servicio 
        //de parking a los distintos Cleintes, Podremos listar el Registro de Usuario y solicitar el Arqueo de Caja.
        u.limpiarPantalla();
        a.tituloATC();
        System.out.println("		MENU: ");
        System.out.println("");
        System.out.println("		1. Ingresar Usuario");
        System.out.println("		2. Registrar un nuevo Abonado");
        System.out.println("		3. Clientes con Abono Vigente");
        System.out.println("		4. Arqueo de caja");
        System.out.println("");
        System.out.print("		Ingrese una opción deseada: ");
        opcion = entrada.nextInt();
        u.limpiarPantalla();
        a.tituloATC();       
        switch (opcion) { 
            //Registrar usuarios como Cliente Abonado, los mismos se iran guardando un diccionario, con su DNI como Key
            case 1:
                //ingresar al parking
                //Desde este menu podemos gestionar los Distintos tipos de Clientes, Abonados, con Orden de Compra y CNR.
                u.limpiarPantalla();
                a.tituloATC();
                System.out.println("		MENU: ");
                System.out.println("");
                System.out.println("		1. Cliente Abonado");
                System.out.println("		2. Cliente con Orden de Compra");
                System.out.println("		3. Cliente No Registrado");
                System.out.println("		4. MENU PRINCIPAL");
                System.out.println("");
                System.out.print("		Ingrese una opción deseada: " );
                opcion = entrada.nextInt();
                u.limpiarPantalla();
                switch(opcion) {
                    case 1:
                        a.tituloATC();
                        System.out.print("Introduce el DNI del Cliente: ");
                        dni = Integer.parseInt(entrada.next());
                        //Boolean dcBool = listaClientesAbonados.containsKey(dniCliente);
                        System.out.println("");
                        if (listaClientesAbonados.containsKey(dni)){
                            String clienteAbonado = listaClientesAbonados.get(dni);
                            System.out.println("");
                            System.out.print("Se encuentra un Usuario Vigente: ");
                            System.out.println(clienteAbonado);
                            System.out.println("");
                            System.out.println("");
                            System.out.println("                                                                        [ Abrir Barrera ]");
                            System.out.println(""); 
                            u.limpiarPantalla();
                            seAbreBarrera();
                        }
                        else {
                            
                            // FALTA NO SE ENCUENTRA UN USUARIO VIGENTE CON ESE DNI, AGREGARLO?
                            System.out.print("Introduce el nombre completo del Cliente: ");
                            nombreCompleto = ca.next();
                            listaClientesAbonados.put(dni, nombreCompleto);  
                            ingresoAbonado++;
                            u.esperar(4);
                            a.animacionVerificacionDeDatos();
                            u.limpiarPantalla();
                            a.tituloATC();
                            System.out.println("¡Cliente Registrado Exitosamente!");
                            System.out.println("");
                            System.out.println("");
                            System.out.println("                                                                        [ Abrir Barrera ]");
                            System.out.println(""); 
                            u.limpiarPantalla();
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
                        u.limpiarPantalla();
                        a.tituloATC();
                        System.out.print("		Digite el número de Orden de Compra: " );
                        ordenCompra = entrada.nextLine();
                        while (ordenCompra.length() != 4) {
                            u.limpiarPantalla();
                            a.tituloATC();
                            System.out.println("		El numero de compra debe tener 4 digitos " );
                            System.out.println("" );
                            System.out.print("		Digite nuevamente el número de Orden de Compra: " );
                            ordenCompra = entrada.nextLine();
                            a.animacionVerificacionDeDatos();
                        }
                        // Verificamos si la OC ingresada existe en la lista
                        if (ordenes.contains(ordenCompra)){
                            u.limpiarPantalla();
                            a.tituloATC();
                            System.out.println("");
                            System.out.println("                                                                       * Orden Validada *");
                            System.out.println("		                                               Usuario registrado por nuestra WEB!");
                            System.out.println("");
                            System.out.println("");
                            System.out.println("		                                                       [ Abrir Barrera ]");
                            System.out.println("");
                            u.pressAnyKeyToContinue();    
                        } 
                        else {
                            do{
                                u.limpiarPantalla();
                                a.tituloATC();
                                System.out.println("		El numero de compra es inexistente " );
                                System.out.println("" );
                                System.out.print("		Digite nuevamente el número de Orden de Compra: " );
                                ordenCompra = entrada.nextLine();
                                } while (ordenes.contains(ordenCompra));
                        }
                        u.esperar(7);
                        seAbreBarrera();
                        break;
                    case 3:
                        menuCRN(); 
                        ingresoCNR++;
                        break;
                    case 4:
                        Program.main(null);
                        break;
                }
                break;
            case 2: 
                u.limpiarPantalla();
                a.tituloATC();
                System.out.print("Introduce el DNI del Cliente: ");
                dni = ca.nextInt();
                a.animacionVerificacionDeDatos();
                if (listaClientesAbonados.containsKey(dni)) {
                    a.tituloATC();
                    System.out.println("No se puedo registrar el usuario. El DNI ya se encuentra registrado.");
                    a.continuarConOtroCliente();
                } 
                else {
                    a.tituloATC();
                    System.out.print("Introduce el nombre completo del Cliente: ");
                    nombreCompleto = ca.next();
                    listaClientesAbonados.put(dni, nombreCompleto);  
                    ingresoAbonado++;  
                }
                u.esperar(4);
                a.animacionVerificacionDeDatos();
                u.limpiarPantalla();
                a.tituloATC();
                System.out.println("                                                              ¡Cliente Registrado Exitosamente!");
                System.out.println("");
                a.continuarConOtroCliente();
                break;
            case 3: 
                mostrarClientesAbonados(listaClientesAbonados);
                a.continuarConOtroCliente();
                break;
            case 4: 
                // En este menu podemos ir registrando el mongo en nuestro arqueo de caja, se suman los CNR y 
                // dan conteo, clientes Abonados (registrados) con exepcion de clientes que ingresan con OC.
                u.limpiarPantalla();
                a.tituloATC();
                
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
                a.continuarConOtroCliente();
                break;
            default:
                u.limpiarPantalla();
                a.tituloATC();
                System.out.println("		MENU: ");
                System.out.println("");
                System.out.println("		1. Ingresar Usuario");
                System.out.println("		2. Registrar Nuevo Usuario");
                System.out.println("		3. Registro de Usuarios");
                System.out.println("		4. Arqueo de caja");
                a.opcionInvalidaParaMenu();
                opcion = entrada.nextInt();
                u.limpiarPantalla();
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
     
    // ABRIR o CERRAR BARRERA***************************************************************************************
    // Metodo encargado de la apertura de la barrera, el mismo es el que decide si
    // la barrera da error o no por medio de Azar.
    // Tambien es el encargado de redirigirnos o a la guardia o directamente a la
    // apertura de la barrera.
    public static void seAbreBarrera() {
        Utilidades u = new Utilidades();
        Animaciones a = new Animaciones();
        Random bool = new Random();
        
        int barreraRota = bool.nextInt(2);

        if (barreraRota == 0) {
            a.animacionSolicitarBarrera();
            
            u.limpiarPantalla();
            a.subAnimacionDespedida();
        } else {
            a.animacionSolicitarBarrera();
            a.animacionDeBarreraRedirigiendoAGuardia();
        }
    } // Fin seAbreBarrrera
    
    
    // ATC *******************************************************************************************************************
    // Menu verificador de ticket de cliente.*******************************************************************************
    public static void menuATC() {
        Utilidades u = new Utilidades();
        Animaciones a = new Animaciones();
        int opcion;
        
        a.tituloATC();
        System.out.print("		Ingrese el número de ticket otorgado al Cliente: ");
        int nroTicket = entrada.nextInt();
        // Validamos que el número de Ticket sea el correcto.
        while (nroTicket != 1234) {
            u.limpiarPantalla();
            a.tituloATC();
            a.animacionVerificacionDeDatos();
            u.limpiarPantalla();
            a.tituloATC();
            System.out.println(
                    "                                                                 ¡Número de ticket incorrecto!");
            System.out.println("");
            System.out.print("		Ingrese nuevamente el número de ticket: ");
            nroTicket = Integer.parseInt(entrada.nextLine());
        }
        u.limpiarPantalla();
        a.tituloATC();
        System.out.println("		MENU: ");
        System.out.println("");
        System.out.println("		1. Efectuar cobro");
        System.out.println("		2. MENU PRINCIPAL");
        System.out.println("");
        System.out.print("		Ingrese una opción deseada: ");
        opcion = entrada.nextInt();
        System.out.println("");
        switch (opcion) {
            case 1:
                // Llama a un procedimiento para realizar el cobro
                a.animacionFormasDePago();
                menuCobro();
                break;
            case 2:
                Program.main(null);
                break;
        }
    } // Fin menuATC

        // Menu Cobro********************************************************************************************************************************
         // Sub Menu para tipo de cobro para cliente CNR, con un Segun de dos opciones,
        // Cobro al contado y Cobro por debito (cobro por tarjeta valida n tarjeta
        // y calve de seguridad.
        public static void menuCobro() {
            
        int efectivo, opcion, clave;
        String numTarjeta;
        Utilidades u = new Utilidades();
        Animaciones a = new Animaciones();
        
        u.limpiarPantalla();
        a.tituloATC();
        System.out.println("		Ingrese un modo de pago: ");
        System.out.println(" ");
        System.out.println("		1. Pago de contado");
        System.out.println("		2. Pago con tarjeta");
        System.out.println("		3. MENU PRINCIPAL");
        System.out.println(" ");
        System.out.print("		Ingrese una opción deseada: ");
        opcion = entrada.nextInt();
        System.out.println(" ");

        do {
            switch (opcion) {
                case 1:
                    u.limpiarPantalla();
                    a.tituloATC();
                    System.out.println("		Valor del TICKET $150");
                    System.out.print("		Ingrese el monto a cobrar: ");
                    efectivo = entrada.nextInt();
                    ingresoCNR++;
                    a.animacionProcesandoPago();
                    System.out.println("");
                    System.out.println("");
                    System.out.println("                                                                        [ Abrir Barrera ]");
                    System.out.println("");
                    u.pressAnyKeyToContinue();
                    seAbreBarrera();
                    break;
                case 2:
                    u.limpiarPantalla();
                    a.tituloATC();
                    // Ingreso de numero de Tarjeta
                    System.out.print("		Ingrese el número de tarjeta (10 dígitos): ");
                    numTarjeta = entrada.nextLine();

                    // Parseo el int en string para utilizar metodo length y así validar la cantidad
                    // de caracteres.
                    long length = String.valueOf(numTarjeta).length();
                    // Valido cantidad de numeros de la Tarjeta
                    while (length != 10) {
                        System.out.println("");
                        System.out.println("		El número de tarjeta debe tener 10 digitos");
                        System.out.println("");
                        System.out.print("		Ingrese nuevamente el número de tarjeta del cliente ");
                        numTarjeta = entrada.nextLine();
                        length = String.valueOf(numTarjeta).length();
                    }
                    u.limpiarPantalla();
                    a.tituloATC();
                    // Ingreso de Clave de la Tarjeta
                    System.out.println("");
                    System.out.print("		Ingrese la clave de seguridad: ");
                    clave = entrada.nextInt();
                    // Valido cantidad de números de la clave de la Tarjeta
                    length = String.valueOf(clave).length();
                    while (length != 3) {
                        System.out.println("		La clave debe tener 3 digitos");
                        System.out.print("		Ingrese nuevamente la clave de seguridad: ");
                        clave = Integer.parseInt(entrada.nextLine());
                        length = String.valueOf(clave).length();
                    }
                    
                    while (numTarjeta != "1234567890" && clave != 123)  {
                           u.limpiarPantalla();
                           a.tituloATC();
                           System.out.print("		                               ================== "); 
                           System.out.print("		                              || DATOS ERRONEOS || ");
                           System.out.print("		                               ================== "); 
                           System.out.print("");	
                           // Ingreso de numero de Tarjeta
                           System.out.print("		Ingrese nuevamente el número de tarjeta (10 dígitos): ");
                           numTarjeta = entrada.nextLine();
                           // Parseo el int en string para utilizar metodo length y así validar la cantidad
                           // de caracteres.
                           length = String.valueOf(numTarjeta).length();
                           // Valido cantidad de numeros de la Tarjeta
                           while (length != 10) {
                               System.out.println("		El número de tarjeta debe tener 10 digitos");
                               System.out.println("		Ingrese nuevamente el número de tarjeta del cliente ");
                               numTarjeta = entrada.nextLine();
                               length = String.valueOf(numTarjeta).length();
                           }
                           u.limpiarPantalla();
                           a.tituloATC();
                           // Ingreso de Clave de la Tarjeta
                           System.out.println("");
                           System.out.print("		Ingrese nuevamente la clave de seguridad: ");
                           clave = Integer.parseInt(entrada.nextLine());
                           // Valido cantidad de números de la clave de la Tarjeta
                           length = String.valueOf(clave).length();
                           while (length != 3) {
                               u.limpiarPantalla();
                               a.tituloATC();
                               System.out.println("		La clave debe tener 3 digitos");
                               System.out.print("		Ingrese nuevamente la clave de seguridad: ");
                               clave = Integer.parseInt(entrada.nextLine());
                               length = String.valueOf(clave).length();
                           }
                    } 
                    ingresoCNR++;
                    a.animacionProcesandoPago();
                    System.out.println("");
                    System.out.println("");
                    System.out.println("                                                                        [ Abrir Barrera ]");
                    System.out.println("");
                    u.pressAnyKeyToContinue();
                    seAbreBarrera();
                    break;
                case 3: // Salir
                    Program.main(null);
                    break;
                default: // Opcion invalida
                    u.limpiarPantalla();
                    a.tituloATC();
                    System.out.println("		Ingrese un modo de pago: ");
                    System.out.println(" ");
                    System.out.println("		1. Pago de contado");
                    System.out.println("		2. Pago con tarjeta");
                    System.out.println("		3. Salir");
                    System.out.print(" ");
                    System.out.print("		Ingrese una opción deseada: ");
                    a.opcionInvalidaParaMenu();
                    opcion = Integer.parseInt(entrada.nextLine());
                    u.limpiarPantalla();
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
        
        Utilidades u = new Utilidades();
        Animaciones a = new Animaciones();
        a.tituloGuardia();
        System.out.println( "                                                      NOTIFICACIÓN: Se solicita una Verificación de Barrera");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("                                                                        [ Verificar ]");
        System.out.println("");
        u.pressAnyKeyToContinue();
        a.animacionDeBarrera();
    } // Fin Guardia
    
    // MENU CNR*******************************************************************************************************************************
    // Para los Clientes no registrados, desde esta interfaz se les informa el valor
    // de la estadia, y se le otorga un numero para su validacion
    // el mismo numero por el momento solo sera "1234". este mismo numero se
    // validara una vez que el cliente decida "Pagar Ticket", lo
    // cual lo rediririgira hacia "menuATC()". La segunda opcion simplemente
    // finaliza la ejecucion dando una despedida.
    public static void menuCRN() {
        Utilidades u = new Utilidades();
        Animaciones a = new Animaciones();
        int opcion = 0;
         
        a.tituloATC();
        System.out.println(
                "                                                            #########################################");
        System.out.println(
                "                                                            #   El servicio de parking cuesta $150  #");
        System.out.println(
                "                                                            #                                       #");
        System.out.println(
                "                                                            #   Su número de Ticket es el * 1234 *  #");
        System.out.println(
                "                                                            #########################################");
        System.out.println(" ");
        System.out.println("		MENU: ");
        System.out.println(" ");
        System.out.println("		1. ACEPTAR");
        System.out.println("		2. CANCELAR / MENU PRINCIPAL");
        System.out.println(" ");
        System.out.print("		Ingrese una opcion deseada: ");
       
        opcion = entrada2.nextInt();
        do {
            if (opcion == 1) {
                    u.esperar(4);
                    u.limpiarPantalla();
                    menuATC();
           } else if (opcion == 2) {
                    u.limpiarPantalla();
                    u.esperar(4);
                    a.tituloATC();
                    System.out.println(" ");
                    System.out.println("                                           Speach Sugerido:  '' Lamentamos que no pueda quedarse, lo esperamos en otra oportunidad. '' ");
                    // Aqui no utilizamos SubAnimacionDespedida(), porque epara este evento no se
                    // necesitaria abrir barrera.
                    u.esperar(4);
                    System.out.println(" ");
                    a.continuarConOtroCliente();
                    break;
            } else {
                    u.limpiarPantalla();
                    a.tituloATC();
                    System.out.println(
                            "                                                            #########################################");
                    System.out.println(
                            "                                                            #   El servicio de parking cuesta $150  #");
                    System.out.println(
                            "                                                            #                                       #");
                    System.out.println(
                            "                                                            #   El número de Ticket es el * 1234 *  #");
                    System.out.println(
                            "                                                            #########################################");
                    System.out.println(" ");

                    System.out.println("		MENU: ");
                    System.out.println(" ");
                    System.out.println("		1. ACEPTAR");
                    System.out.println("		2. CANCELAR / MENU PRINCIPAL");
                    a.opcionInvalidaParaMenu();
                    opcion = Integer.parseInt(entrada.nextLine());
                    u.limpiarPantalla();
            }
        } while (opcion != 1 || opcion != 2);
    } // Fin CRN
} // Fin Program