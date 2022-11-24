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
import java.util.List;
import java.util.Scanner;

public class Program {
    
    //Diccionario "Base de Datos"
    public static HashMap<Integer, String> listaClientesAbonados = new HashMap<>();
    //Contadores de ingresos para arqueo de caja
    public static int ingresoCNR;
    public static int ingresoAbonado;   
    
    
     public static void main(String[] args) {
        
        String nombreCompleto;
        int dni, opcion;
        String ordenCompra;
        Scanner ca = new Scanner(System.in);
        // Clientes previamente registrados en "Base de Datos"
        listaClientesAbonados.put(43777070, "ACOSTA, Nadia Yanella");
        listaClientesAbonados.put(38647183, "DEALBERA ETCHECHOURY, Giuliana");
        listaClientesAbonados.put(31646497, "DIAZ LUNA, Giuliana Paola");
        listaClientesAbonados.put(27208272, "NOLAN, Juan Pablo");
        listaClientesAbonados.put(34091492, "QUIQUINTO, Romina Ayelén");
        listaClientesAbonados.put(29293724, "QUISPE, RODRIGUEZ SAQUILAN, Miguel");
        listaClientesAbonados.put(18889456, "RODRIGUEZ SAQUILAN, Miguel");
        listaClientesAbonados.put(34898489, "SEGOVIA, Jorge Nicolás");
        
        // Menu principal, donde registraremos Usuario en la Matriz, Ingresaremos a un sub menu para dar ingreso al servicio 
        //de parking a los distintos Cleintes, Podremos listar el Registro de Usuario y solicitar el Arqueo de Caja.
        Utilidades.limpiarPantalla();
        Animaciones.tituloATC();
        System.out.println("		MENU: ");
        System.out.println("");
        System.out.println("		1. Ingresar Usuario");
        System.out.println("		2. Registrar un nuevo Abonado");
        System.out.println("		3. Clientes con Abono Vigente");
        System.out.println("		4. Arqueo de caja");
        System.out.println("");
        System.out.print("		Ingrese una opción deseada: ");
        opcion = Utilidades.entrada.nextInt();
        Utilidades.limpiarPantalla();
        Animaciones.tituloATC();       
        switch (opcion) { 
            //Registrar usuarios como Cliente Abonado, los mismos se iran guardando un diccionario, con su DNI como Key
            case 1:
                //ingresar al parking
                //Desde este menu podemos gestionar los Distintos tipos de Clientes, Abonados, con Orden de Compra y CNR.
                Utilidades.limpiarPantalla();
                Animaciones.tituloATC();
                System.out.println("		MENU: ");
                System.out.println("");
                System.out.println("		1. Cliente Abonado");
                System.out.println("		2. Cliente con Orden de Compra");
                System.out.println("		3. Cliente No Registrado");
                System.out.println("		4. MENU PRINCIPAL");
                System.out.println("");
                System.out.print("		Ingrese una opción deseada: " );
                opcion = Utilidades.entrada.nextInt();
                Utilidades.limpiarPantalla();
                switch(opcion) {
                    case 1:
                        Animaciones.tituloATC();
                        System.out.print("Introduce el DNI del Cliente: ");
                        dni = Integer.parseInt(Utilidades.entrada.next());
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
                            Utilidades.limpiarPantalla();
                            Utilidades.seAbreBarrera();
                        }
                        else {
                            
                            // FALTA NO SE ENCUENTRA UN USUARIO VIGENTE CON ESE DNI, AGREGARLO?
                            System.out.print("Introduce el nombre completo del Cliente: ");
                            nombreCompleto = ca.next();
                            listaClientesAbonados.put(dni, nombreCompleto);  
                            ingresoAbonado++;
                            Utilidades.esperar(4);
                            Animaciones.animacionVerificacionDeDatos();
                            Utilidades.limpiarPantalla();
                            Animaciones.tituloATC();
                            System.out.println("¡Cliente Registrado Exitosamente!");
                            System.out.println("");
                            System.out.println("");
                            System.out.println("                                                                        [ Abrir Barrera ]");
                            System.out.println(""); 
                            Utilidades.limpiarPantalla();
                            Utilidades.seAbreBarrera();
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
                        Utilidades.limpiarPantalla();
                        Animaciones.tituloATC();
                        System.out.print("		Digite el número de Orden de Compra: " );
                        ordenCompra = Utilidades.entrada.nextLine();
                        while (ordenCompra.length() != 4) {
                            Utilidades.limpiarPantalla();
                            Animaciones.tituloATC();
                            System.out.println("		El numero de compra debe tener 4 digitos " );
                            System.out.println("" );
                            System.out.print("		Digite nuevamente el número de Orden de Compra: " );
                            ordenCompra = Utilidades.entrada.nextLine();
                            Animaciones.animacionVerificacionDeDatos();
                        }
                        // Verificamos si la OC ingresada existe en la lista
                        if (ordenes.contains(ordenCompra)){
                            Utilidades.limpiarPantalla();
                            Animaciones.tituloATC();
                            System.out.println("");
                            System.out.println("                                                                       * Orden Validada *");
                            System.out.println("		                                               Usuario registrado por nuestra WEB!");
                            System.out.println("");
                            System.out.println("");
                            System.out.println("		                                                       [ Abrir Barrera ]");
                            System.out.println("");
                            Utilidades.pressAnyKeyToContinue();    
                        } 
                        else {
                            do{
                                Utilidades.limpiarPantalla();
                                Animaciones.tituloATC();
                                System.out.println("		El numero de compra es inexistente " );
                                System.out.println("" );
                                System.out.print("		Digite nuevamente el número de Orden de Compra: " );
                                ordenCompra = Utilidades.entrada.nextLine();
                                } while (ordenes.contains(ordenCompra));
                        }
                        Utilidades.esperar(7);
                        Utilidades.seAbreBarrera();
                        break;
                    case 3:
                        MenuCNR.menuCNR(); 
                        ingresoCNR++;
                        break;
                    case 4:
                        Program.main(null);
                        break;
                }
                break;
            case 2: 
                Utilidades.limpiarPantalla();
                Animaciones.tituloATC();
                System.out.print("Introduce el DNI del Cliente: ");
                dni = ca.nextInt();
                Animaciones.animacionVerificacionDeDatos();
                if (listaClientesAbonados.containsKey(dni)) {
                    Animaciones.tituloATC();
                    System.out.println("No se puedo registrar el usuario. El DNI ya se encuentra registrado.");
                    Animaciones.continuarConOtroCliente();
                } 
                else {
                    Animaciones.tituloATC();
                    System.out.print("Introduce el nombre completo del Cliente: ");
                    nombreCompleto = ca.next();
                    listaClientesAbonados.put(dni, nombreCompleto);  
                    ingresoAbonado++;  
                }
                Utilidades.esperar(4);
                Animaciones.animacionVerificacionDeDatos();
                Utilidades.limpiarPantalla();
                Animaciones.tituloATC();
                System.out.println("                                                              ¡Cliente Registrado Exitosamente!");
                System.out.println("");
                Animaciones.continuarConOtroCliente();
                break;
            case 3: 
                Utilidades.mostrarClientesAbonados(listaClientesAbonados);
                Animaciones.continuarConOtroCliente();
                break;
            case 4: 
                // En este menu podemos ir registrando el mongo en nuestro arqueo de caja, se suman los CNR y 
                // dan conteo, clientes Abonados (registrados) con exepcion de clientes que ingresan con OC.
                Utilidades.limpiarPantalla();
                Animaciones.tituloATC();
                
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
                Animaciones.continuarConOtroCliente();
                break;
            default:
                Utilidades.limpiarPantalla();
                Animaciones.tituloATC();
                System.out.println("		MENU: ");
                System.out.println("");
                System.out.println("		1. Ingresar Usuario");
                System.out.println("		2. Registrar Nuevo Usuario");
                System.out.println("		3. Registro de Usuarios");
                System.out.println("		4. Arqueo de caja");
                Animaciones.opcionInvalidaParaMenu();
                opcion = Utilidades.entrada.nextInt();
                Utilidades.limpiarPantalla();
                break;
        }
    } // Fin Main
} // Fin Program