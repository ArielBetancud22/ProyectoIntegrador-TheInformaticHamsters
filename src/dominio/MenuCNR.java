package dominio;

import java.util.Random;
import java.util.Scanner;

/*
MENU CNR***********************************************************************************************************
Para los Clientes no registrados, desde esta interfaz se les informa el valor de la estadia, y se le otorga un
numero para su validacion el mismo numero por el momento solo sera "1234". este mismo numero se 
validara una vez que el cliente decida "Pagar Ticket", lo cual lo rediririgira hacia "menuATC()". 
La segunda opcion simplementefinaliza la ejecucion dando una despedida.
    */
public class MenuCNR extends Animaciones {

        private static final Scanner entrada = new Scanner(System.in);
        private static int opcion = 0;

        public static void menuCNR() {

                Random tktRandom = new Random();

                numeroTicket = tktRandom.nextInt(9999);

                tituloATC();
                if (tipoCliente == 1) {

                        System.out.println(
                                        "                                                            #########################################");
                        System.out.println(
                                        "                                                            #   El servicio de parking cuesta $"
                                                        + getVALOR_TICKET() + "  #");
                        System.out.println(
                                        "                                                            #                                       #");
                        System.out.println(
                                        "                                                            #   Su número de Ticket es el * "
                                                        + numeroTicket + " *  #");
                        System.out.println(
                                        "                                                            #########################################");
                } else {
                        esperar(4);
                        System.out.println(
                                        "                                                        ################################################");
                        System.out.println(
                                        "                                                        #   El servicio de abono mensual cuesta $"
                                                        + getVALOR_ABONO() + "  #");
                        System.out.println(
                                        "                                                        #                                              #");
                        System.out.println(
                                        "                                                        ################################################");
                }

                System.out.println(" ");
                System.out.println("		                                                MENU: ");
                System.out.println(" ");
                System.out.println("		                                                1. ACEPTAR");
                System.out.println(
                                "		                                                2. CANCELAR / MENU PRINCIPAL");
                System.out.println(" ");
                System.out.print("		                                                Ingrese una opción deseada: ");

                opcion = entrada.nextInt();
                do {
                        if (opcion == 1) {
                                Utilidades.esperar(4);
                                Utilidades.limpiarPantalla();
                                MenuATC.menuATC();
                        } else if (opcion == 2) {
                                Utilidades.limpiarPantalla();
                                Utilidades.esperar(4);
                                Animaciones.tituloATC();
                                System.out.println(" ");
                                System.out.println(
                                                "                                           Speach Sugerido:  '' Lamentamos que no pueda quedarse, lo esperamos en otra oportunidad. '' ");
                                // Aqui no utilizamos SubAnimacionDespedida(), porque epara este evento no se
                                // necesitaria abrir barrera.
                                Utilidades.esperar(4);
                                System.out.println(" ");
                                Animaciones.continuarConOtroCliente();
                                break;
                        } else {
                                Utilidades.limpiarPantalla();
                                Animaciones.tituloATC();
                                if (tipoCliente == 1) {
                                        System.out.println(
                                                        "                                                            #########################################");
                                        System.out.println(
                                                        "                                                            #   El servicio de parking cuesta $"
                                                                        + getVALOR_TICKET() + "  #");
                                        System.out.println(
                                                        "                                                            #                                       #");
                                        System.out.println(
                                                        "                                                            #   Su número de Ticket es el * "
                                                                        + numeroTicket + " *  #");
                                        System.out.println(
                                                        "                                                            #########################################");
                                } else {
                                        System.out.println(
                                                        "                                                            ############################################");
                                        System.out.println(
                                                        "                                                            #   El servicio de abono mensual cuesta $"
                                                                        + getVALOR_ABONO() + "      #");
                                        System.out.println(
                                                        "                                                            #                                       #");
                                        System.out.println(
                                                        "                                                            ############################################");
                                }
                                System.out.println(" ");
                                System.out.println("		                                                MENU: ");
                                System.out.println(" ");
                                System.out.println(
                                                "		                                                1. ACEPTAR");
                                System.out.println(
                                                "		                                                2. CANCELAR / MENU PRINCIPAL");
                                opcionInvalidaParaMenu();
                                opcion = Integer.parseInt(entrada.nextLine());
                                limpiarPantalla();
                        }
                } while (opcion != 1 || opcion != 2);
        } // Fin CRN
}
