package dominio;

import static dominio.Program.ingresoCNR;

public class MenuCobro extends Animaciones{
     // Menu Cobro********************************************************************************************************************************
         // Sub Menu para tipo de cobro para cliente CNR, con un Segun de dos opciones,
        // Cobro al contado y Cobro por debito (cobro por tarjeta valida n tarjeta
        // y calve de seguridad.
        public static void menuCobro() {
            
        int efectivo, opcion, clave;
        String numTarjeta;
        
        Utilidades.limpiarPantalla();
        Animaciones.tituloATC();
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
                    Utilidades.limpiarPantalla();
                    Animaciones.tituloATC();
                    System.out.println("		Valor del TICKET $150");
                    System.out.print("		Ingrese el monto a cobrar: ");
                    efectivo = entrada.nextInt();
                    ingresoCNR++;
                    Animaciones.animacionProcesandoPago();
                    System.out.println("");
                    System.out.println("");
                    System.out.println("                                                                        [ Abrir Barrera ]");
                    System.out.println("");
                    Utilidades.pressAnyKeyToContinue();
                    seAbreBarrera();
                    break;
                case 2:
                    Utilidades.limpiarPantalla();
                    Animaciones.tituloATC();
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
                    Utilidades.limpiarPantalla();
                    Animaciones.tituloATC();
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
                           Utilidades.limpiarPantalla();
                           Animaciones.tituloATC();
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
                           Utilidades.limpiarPantalla();
                           Animaciones.tituloATC();
                           // Ingreso de Clave de la Tarjeta
                           System.out.println("");
                           System.out.print("		Ingrese nuevamente la clave de seguridad: ");
                           clave = Integer.parseInt(entrada.nextLine());
                           // Valido cantidad de números de la clave de la Tarjeta
                           length = String.valueOf(clave).length();
                           while (length != 3) {
                               Utilidades.limpiarPantalla();
                               Animaciones.tituloATC();
                               System.out.println("		La clave debe tener 3 digitos");
                               System.out.print("		Ingrese nuevamente la clave de seguridad: ");
                               clave = Integer.parseInt(entrada.nextLine());
                               length = String.valueOf(clave).length();
                           }
                    } 
                    ingresoCNR++;
                    Animaciones.animacionProcesandoPago();
                    System.out.println("");
                    System.out.println("");
                    System.out.println("                                                                        [ Abrir Barrera ]");
                    System.out.println("");
                    Utilidades.pressAnyKeyToContinue();
                    seAbreBarrera();
                    break;
                case 3: // Salir
                    Program.main(null);
                    break;
                default: // Opcion invalida
                    Utilidades.limpiarPantalla();
                    Animaciones.tituloATC();
                    System.out.println("		Ingrese un modo de pago: ");
                    System.out.println(" ");
                    System.out.println("		1. Pago de contado");
                    System.out.println("		2. Pago con tarjeta");
                    System.out.println("		3. Salir");
                    System.out.print(" ");
                    System.out.print("		Ingrese una opción deseada: ");
                    Animaciones.opcionInvalidaParaMenu();
                    opcion = Integer.parseInt(entrada.nextLine());
                    Utilidades.limpiarPantalla();
            }
        } while (opcion != 1 || opcion != 2 || opcion != 3);
        System.out.println("");
    } // Fin menuCobro
}
