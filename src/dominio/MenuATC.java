package dominio;

import dominio.MenuCNR.*;
import java.util.Scanner;

// ATC *******************************************************************************************************************
// Menu verificador de ticket de cliente.*******************************************************************************
public class MenuATC extends Animaciones {
    private static final Scanner entrada = new Scanner(System.in);
    private static int opcion;

    public static void menuATC() {
        if (tipoCliente == 1) {
            Animaciones.tituloATC();
            System.out.print("		                               Ingrese el número de ticket otorgado al Cliente (nro tkt " + numeroTicket + "): ");
            int nroTicket = entrada.nextInt();
            // Validamos que el número de Ticket sea el correcto.
            while (nroTicket != numeroTicket) {
                limpiarPantalla();
                tituloATC();
                animacionVerificacionDeDatos();
                limpiarPantalla();
                tituloATC();
                System.out.println(
                        "                                                                 ¡Número de ticket incorrecto!");
                System.out.println("");
                System.out.print("		Ingrese nuevamente el número de ticket otorgado al Cliente (nro tkt " + numeroTicket
                        + "): ");
                nroTicket = entrada.nextInt();
            }
        }

        limpiarPantalla();
        tituloATC();
        System.out.println("		                                                      MENU: ");
        System.out.println("");
        System.out.println("		                                                      1. Efectuar cobro");
        System.out.println("		                                                      2. MENU PRINCIPAL");
        System.out.println("");
        System.out.print("		                                                      Ingrese una opción deseada: ");
        opcion = entrada.nextInt();
        System.out.println("");
        switch (opcion) {
            case 1:
                // Llama a un procedimiento para realizar el cobro
                animacionFormasDePago();
                MenuCobro.menuCobro();
                break;
            case 2:
                Program.main(null);
                break;
        }
    } // Fin menuATC
}
