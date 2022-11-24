package dominio;

// ATC *******************************************************************************************************************
// Menu verificador de ticket de cliente.*******************************************************************************
public class MenuATC {
    
    public static void menuATC() {
        int opcion;
        
        Animaciones.tituloATC();
        System.out.print("		Ingrese el número de ticket otorgado al Cliente: ");
        int nroTicket = Utilidades.entrada.nextInt();
        // Validamos que el número de Ticket sea el correcto.
        while (nroTicket != 1234) {
            Utilidades.limpiarPantalla();
            Animaciones.tituloATC();
            Animaciones.animacionVerificacionDeDatos();
            Utilidades.limpiarPantalla();
            Animaciones.tituloATC();
            System.out.println(
                    "                                                                 ¡Número de ticket incorrecto!");
            System.out.println("");
            System.out.print("		Ingrese nuevamente el número de ticket: ");
            nroTicket = Integer.parseInt(Utilidades.entrada.nextLine());
        }
        Utilidades.limpiarPantalla();
        Animaciones.tituloATC();
        System.out.println("		MENU: ");
        System.out.println("");
        System.out.println("		1. Efectuar cobro");
        System.out.println("		2. MENU PRINCIPAL");
        System.out.println("");
        System.out.print("		Ingrese una opción deseada: ");
        opcion = Utilidades.entrada.nextInt();
        System.out.println("");
        switch (opcion) {
            case 1:
                // Llama a un procedimiento para realizar el cobro
                Animaciones.animacionFormasDePago();
                MenuCobro.menuCobro();
                break;
            case 2:
                Program.main(null);
                break;
        }
    } // Fin menuATC
}
