package dominio;

import static dominio.MenuPrincipal.*;
import java.util.Scanner;

public class MenuCobro extends Animaciones {
    // Menu
    // Cobro********************************************************************************************************************************
    // Sub Menu para tipo de cobro para cliente CNR, con un Segun de dos opciones,
    // Cobro al contado y Cobro por debito (cobro por tarjeta valida n tarjeta
    // y calve de seguridad.
    private static final Scanner entrada = new Scanner(System.in);
    private static int efectivoIngresado, opcion, clave;
    private static String numTarjeta;

    public static void menuCobro() {

        Utilidades.limpiarPantalla();
        Animaciones.tituloATC();
        System.out.println("		                                                Ingrese un modo de pago: ");
        System.out.println(" ");
        System.out.println("		                                                1. Pago de contado");
        System.out.println("		                                                2. Pago con tarjeta");
        System.out.println("		                                                3. MENU PRINCIPAL");
        System.out.println(" ");
        System.out.print("		                                                Ingrese una opción deseada: ");
        opcion = entrada.nextInt();
        System.out.println(" ");

        do {
            switch (opcion) {
                case 1:
                    efectivoIngresado = 0;
                    if (tipoCliente == 1) {
                        // Validador de monto ingresado
                        while (efectivoIngresado != getVALOR_TICKET()) {
                            Utilidades.limpiarPantalla();
                            Animaciones.tituloATC();
                            System.out.println("		                                                     Valor del TICKET $" + getVALOR_TICKET());
                            System.out.print("		                                                     Ingrese el monto a cobrar: ");
                            efectivoIngresado = entrada.nextInt();

                            if (efectivoIngresado > getVALOR_TICKET()) {
                                System.out.println("");
                                System.out.print("		El valor ingresado es mayor al precio del Ticket ");
                                System.out.print(
                                        "		Dar de vuelto al cliente $" + (efectivoIngresado - getVALOR_TICKET()));
                                pressAnyKeyToContinue();
                                efectivoIngresado = getVALOR_TICKET();
                            } else if (efectivoIngresado < getVALOR_TICKET()) {
                                int sumatoria = getVALOR_TICKET() - efectivoIngresado;
                                System.out.println("");
                                System.out.println("		El valor ingresado es menor al precio del Ticket ");
                                System.out.println("		Solicitar faltante de $" + (sumatoria));
                                System.out.println("");
                                sumatoria = getVALOR_TICKET() - efectivoIngresado;
                                System.out.print("		Ingrese el monto faltante ($" + sumatoria + "): ");
                                efectivoIngresado = entrada.nextInt();
                                while (efectivoIngresado != sumatoria) {
                                    Utilidades.limpiarPantalla();
                                    Animaciones.tituloATC();
                                    System.out.print("		DEBE INGRESAR EL MONTO FALTANTE DE ($" + sumatoria + "): ");
                                    efectivoIngresado = entrada.nextInt();
                                }
                                efectivoIngresado = getVALOR_TICKET();
                            }
                            setIngresoCNR();
                            Animaciones.animacionProcesandoPago();
                            System.out.println("");
                            System.out.println("");
                            System.out.println(
                                    "                                                                        [ Abrir Barrera ]");
                            System.out.println("");
                            Utilidades.pressAnyKeyToContinue();
                            seAbreBarrera();
                        }
                    } else {
                        // Validador de monto ingresado
                        while (efectivoIngresado != getVALOR_ABONO()) {
                            Utilidades.limpiarPantalla();
                            Animaciones.tituloATC();
                            System.out.println("		                                                Valor del ABONO MENSUAL $"
                                    + getVALOR_ABONO());
                            System.out.print(
                                    "		                                                Ingrese el monto a cobrar: ");
                            efectivoIngresado = entrada.nextInt();

                            if (efectivoIngresado > getVALOR_ABONO()) {
                                System.out.println("");
                                System.out.print(
                                        "		                                             El valor ingresado es mayor al precio del Abono ");
                                System.out.print(
                                        "		                                             Dar de vuelto al cliente $"
                                                + (efectivoIngresado - getVALOR_ABONO()));
                                pressAnyKeyToContinue();
                                efectivoIngresado = getVALOR_ABONO();
                            } else if (efectivoIngresado < getVALOR_ABONO()) {
                                int sumatoria = getVALOR_ABONO() - efectivoIngresado;
                                System.out.println("");
                                System.out.println(
                                        "		                                             El valor ingresado es menor al precio del Abono ");
                                System.out.println(
                                        "		                                             Solicitar faltante de $"
                                                + (sumatoria));
                                System.out.println("");
                                sumatoria = getVALOR_ABONO() - efectivoIngresado;
                                System.out.print("		                                             Ingrese el monto faltante ($" + sumatoria + "): ");
                                efectivoIngresado = entrada.nextInt();
                                while (efectivoIngresado != sumatoria) {
                                    Utilidades.limpiarPantalla();
                                    Animaciones.tituloATC();
                                    System.out.print("		                                             DEBE INGRESAR EL MONTO FALTANTE DE ($" + sumatoria + "): ");
                                    efectivoIngresado = entrada.nextInt();
                                }
                                efectivoIngresado = getVALOR_ABONO();
                            }

                            setListaClientesAbonados(dni, nombreCompleto);
                            setIngresoAbonado();
                            Utilidades.esperar(4);
                            Animaciones.animacionVerificacionDeDatos();
                            Utilidades.limpiarPantalla();
                            Animaciones.tituloATC();
                            System.out.println(
                                    "                                                                ¡Cliente Registrado Exitosamente!");
                            System.out.println("");
                            Animaciones.continuarConOtroCliente();
                        }
                        break;
                    }
                case 2:
                    Utilidades.limpiarPantalla();
                    Animaciones.tituloATC();
                    // Ingreso de numero de Tarjeta
                    System.out.print("		                                 Ingrese el número de tarjeta: ");
                    numTarjeta = entrada.nextLine();

                    // Parseo el int en string para utilizar metodo length y así validar la cantidad
                    // de caracteres.
                    long length = String.valueOf(numTarjeta).length();
                    // Valido cantidad de numeros de la Tarjeta
                    while (length != 10) {
                        System.out.println("");
                        System.out.println("		                                 (El número de tarjeta debe tener 10 digitos)");
                        System.out.println("");
                        System.out.print("		                                 Ingrese el número de tarjeta del cliente (el único num registrado es el <1234567890>):  ");
                        numTarjeta = entrada.nextLine();
                        length = String.valueOf(numTarjeta).length();
                    }
                    Utilidades.limpiarPantalla();
                    Animaciones.tituloATC();
                    // Ingreso de Clave de la Tarjeta
                    System.out.println("");
                    System.out.print("		                                 Ingrese la clave de seguridad (la clave es <123>): ");
                    clave = entrada.nextInt();
                    // Valido cantidad de números de la clave de la Tarjeta
                    length = String.valueOf(clave).length();
                    while (length != 3) {
                        System.out.println("		                                 La clave debe tener 3 digitos (la clave es <123>)");
                        System.out.print("		                                 Ingrese nuevamente la clave de seguridad: ");
                        clave = Integer.parseInt(entrada.nextLine());
                        length = String.valueOf(clave).length();
                    }

                    while (numTarjeta != "1234567890" && clave != 123) {
                        Utilidades.limpiarPantalla();
                        Animaciones.tituloATC();
                        System.out.print("		                               ================== ");
                        System.out.print("		                              || DATOS ERRONEOS || ");
                        System.out.print("		                               ================== ");
                        System.out.print("");
                        // Ingreso de numero de Tarjeta
                        System.out.print("		                                 Ingrese nuevamente el número de tarjeta (<1234567890>): ");
                        numTarjeta = entrada.nextLine();
                        // Parseo el int en string para utilizar metodo length y así validar la cantidad
                        // de caracteres.
                        length = String.valueOf(numTarjeta).length();
                        // Valido cantidad de numeros de la Tarjeta
                        while (length != 10) {
                            System.out.println("		                                 El número de tarjeta debe tener 10 digitos");
                            System.out.print(
                                    "		                                 Ingrese nuevamente el número de tarjeta del cliente (<1234567890>):  ");
                            numTarjeta = entrada.nextLine();
                            length = String.valueOf(numTarjeta).length();
                        }
                        Utilidades.limpiarPantalla();
                        Animaciones.tituloATC();
                        // Ingreso de Clave de la Tarjeta
                        System.out.println("");
                        System.out.print("		                                 Ingrese nuevamente la clave de seguridad (<123>): ");
                        clave = Integer.parseInt(entrada.nextLine());
                        // Valido cantidad de números de la clave de la Tarjeta
                        length = String.valueOf(clave).length();
                        while (length != 3) {
                            Utilidades.limpiarPantalla();
                            Animaciones.tituloATC();
                            System.out.println("		                                 La clave debe tener 3 digitos");
                            System.out.print("		                                 Ingrese nuevamente la clave de seguridad (<123>): ");
                            clave = Integer.parseInt(entrada.nextLine());
                            length = String.valueOf(clave).length();
                        }
                    }
                    if (tipoCliente == 1) {
                        setIngresoCNR();
                    } else {
                        setListaClientesAbonados(dni, nombreCompleto);
                        setIngresoAbonado();
                    }

                    Animaciones.animacionProcesandoPago();
                    System.out.println("");
                    System.out.println("");
                    System.out.println(
                            "                                                                        [ Abrir Barrera ]");
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
                    System.out
                            .println("		                                                Ingrese un modo de pago: ");
                    System.out.println(" ");
                    System.out.println("		                                                1. Pago de contado");
                    System.out.println("		                                                2. Pago con tarjeta");
                    System.out.println("		                                                3. Salir");
                    System.out.print(" ");
                    System.out.print(
                            "		                                                Ingrese una opción deseada: ");
                    Animaciones.opcionInvalidaParaMenu();
                    opcion = Integer.parseInt(entrada.nextLine());
                    Utilidades.limpiarPantalla();
            }
        } while (opcion != 1 || opcion != 2 || opcion != 3);
        System.out.println("");
    } // Fin menuCobro
}
