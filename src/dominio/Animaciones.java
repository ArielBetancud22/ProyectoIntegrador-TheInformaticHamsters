package dominio;

import static dominio.Program.entrada;
import static dominio.Program.guardia;


public class Animaciones extends Utilidades  {
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

    public void tituloATC() {
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

    public void tituloGuardia() {
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

    public void tituloSistema() {
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
    public void tituloSubAnimacionDeBarrera() {
        System.out.println("		Se ha detectado que el error es debido a un problema de conexión: ");
        System.out.println(" ");
    } // Fin tituloSubAnimacionDeBarrera

    // For en metodo para animar textos en las animaciones de ATC
    public void forDeAnimarAnimacionesATC(int tiempo, String mensaje) {
        for (int i = 0; i <= 2; i = i + 1) {
            limpiarPantalla();
            tituloATC();
            System.out.println("		" + mensaje);
            esperar(tiempo);
            limpiarPantalla();
            tituloATC();
            System.out.println("		" + mensaje + ".");
            esperar(tiempo);
            limpiarPantalla();
            tituloATC();
            System.out.println("		" + mensaje + "..");
            esperar(tiempo);
            limpiarPantalla();
            tituloATC();
            System.out.println("		" + mensaje + "...");
            esperar(tiempo);
            limpiarPantalla();
        }
    } // Fin forDeAnimarAnimacionesATC

    public void animacionFormasDePago() {
        forDeAnimarAnimacionesATC(4, "Cargando formas de pago, aguarde");
        limpiarPantalla();
    } // Fin animacionFormasDePago

    public void opcionInvalidaParaMenu() {
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

    public void animacionProcesandoPago() {
        limpiarPantalla();
        tituloATC();
        esperar(4);
        forDeAnimarAnimacionesATC(4, "Procesando pago, aguarde");
        tituloATC();
        System.out.println("		                                               ¡El pago se realizó correctamente!");
    } // Fin animacionProcesandoPago

    public void animacionVerificacionDeDatos() {
        limpiarPantalla();
        tituloATC();
        esperar(4);
        forDeAnimarAnimacionesATC(4, "Verificando datos, aguarde un momento");
    } // Fin animacionVerificacionDeDatos

    public void animacionSolicitarBarrera() {
        limpiarPantalla();
        tituloATC();
        esperar(4);
        forDeAnimarAnimacionesATC(4, "Solicitando Barrera");
    } // Fin animacionSolicitarBarrera

    // Animacion encargada de dar un informe de sistema de ERROR GRAVE, el cual
    // necesita ser verificado por "Guardia()"
    // posteriormente. Tambien se utilizaria en el momento que Guardia() realiza la
    // verificacion.
    public void subAnimacionError() {
        limpiarPantalla();
        tituloSistema();
        esperar(4);
        limpiarPantalla();
        tituloSistema();
        System.out.println(
                "--------------------------------------------------------------------------ERROR ERROR---------------------------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------------------------ERROR ERROR---------------------------------------------------------------------------");
        esperar(5);
        limpiarPantalla();
        tituloSistema();
        System.out.println(
                "--------------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------------");
        esperar(4);
        limpiarPantalla();
        tituloSistema();
        System.out.println(
                "--------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------");
        esperar(3);
        limpiarPantalla();
        tituloSistema();
        esperar(3);
        System.out.println(
                "--------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------");
        System.out.println(
                "--------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------");
        esperar(3);
        limpiarPantalla();
        tituloSistema();
        esperar(3);
        System.out.println(
                "--------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------");
        System.out.println(
                "--------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------");
        esperar(5);
        limpiarPantalla();
        tituloSistema();
        esperar(3);
        System.out.println(
                "--------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------");
        System.out.println(
                "--------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------");
        esperar(5);
        limpiarPantalla();
        tituloSistema();
        esperar(3);
        System.out.println(
                "--------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------");
        System.out.println(
                "--------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------");
        esperar(6);
        limpiarPantalla();
        tituloSistema();
        esperar(1);
        System.out.println(
                "--------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------");
        System.out.println(
                "--------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------");
        esperar(1);
        limpiarPantalla();
        tituloSistema();
        esperar(1);
        System.out.println(
                "--------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------");
        esperar(1);
        limpiarPantalla();
        tituloSistema();
        esperar(1);
        System.out.println(
                "--------------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------------ERROR ERROR ERROR ERROR ERROR ERROR---------------------------------------------------------------");
        esperar(1);
        limpiarPantalla();
        tituloSistema();
        esperar(1);
        System.out.println(
                "--------------------------------------------------------------------ERROR ERROR ERROR ERROR---------------------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------------------ERROR ERROR ERROR ERROR---------------------------------------------------------------------");
        esperar(1);
        limpiarPantalla();
        tituloSistema();
        esperar(1);
        System.out.println(
                "--------------------------------------------------------------------------ERROR ERROR---------------------------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------------------------ERROR ERROR---------------------------------------------------------------------------");
        esperar(1);
        limpiarPantalla();
        tituloSistema();
        esperar(1);
        System.out.println(
                "-----------------------------------------------------------------------------ERROR------------------------------------------------------------------------------");
        System.out.println(
                "-----------------------------------------------------------------------------ERROR------------------------------------------------------------------------------");
        esperar(1);
        limpiarPantalla();
    }

    // Animacion que se llama desde "SeAbreBarrera()" si se encuentra un error (por
    // medio de Azar), es la encargada
    // de notificar al usuario, y también es la encargada de redireccionar hacia
    // "Guardia()"
    public void animacionDeBarreraRedirigiendoAGuardia() {
        limpiarPantalla();
        subAnimacionError();
        esperar(7);
        for (int i = 0; i <= 2; i = i + 1) {
            limpiarPantalla();
            tituloSistema();
            System.out.println("		Detectamos un ERROR en la solicitud.");
            System.out.println("		Aguarde un momento, un Guardia verificará el inconveninte.");
            System.out.println(" ");
            System.out.println("		Solicitando");
            esperar(6);
            limpiarPantalla();
            tituloSistema();
            System.out.println("		Detectamos un ERROR en la solicitud.");
            System.out.println("		Aguarde un momento, un Guardia verificará el inconveninte.");
            System.out.println(" ");
            System.out.println("		Solicitando.");
            esperar(6);
            limpiarPantalla();
            tituloSistema();
            System.out.println("		Detectamos un ERROR en la solicitud.");
            System.out.println("		Aguarde un momento, un Guardia verificará el inconveninte.");
            System.out.println(" ");
            System.out.println("		Solicitando..");
            esperar(6);
            limpiarPantalla();
            tituloSistema();
            System.out.println("		Detectamos un ERROR en la solicitud.");
            System.out.println("		Aguarde un momento, un Guardia verificará el inconveninte.");
            System.out.println(" ");
            System.out.println("		Solicitando...");
            esperar(6);
        }
        limpiarPantalla();
        guardia();
    } // Fin animacionDeBarreraRedirigiendoAGuardia

    // Animacion para simular reconexion de barrera desde "Guardia()", la misma
    // tambien da cierre el programa.
    public void animacionDeBarrera() {
        esperar(4);
        subAnimacionError();
        esperar(12);
        for (int i = 0; i <= 2; i = i + 1) {
            limpiarPantalla();
            tituloSistema();
            tituloSubAnimacionDeBarrera();
            System.out.println("		Restableciendo conexión");
            esperar(4);
            limpiarPantalla();
            tituloSistema();
            tituloSubAnimacionDeBarrera();
            System.out.println("		Restableciendo conexión");
            esperar(4);
            limpiarPantalla();
            tituloSistema();
            tituloSubAnimacionDeBarrera();
            System.out.println("		Restableciendo conexión..");
            esperar(4);
            limpiarPantalla();
            tituloSistema();
            tituloSubAnimacionDeBarrera();
            System.out.println("		Restableciendo conexión...");
            esperar(4);
        }
        limpiarPantalla();
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
    public void subAnimacionDespedida() {
        for (int i = 0; i <= 2; i = i + 1) {
            limpiarPantalla();
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
            limpiarPantalla();
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
            limpiarPantalla();
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
            limpiarPantalla();
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
    public void continuarConOtroCliente() {
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
            limpiarPantalla();
            // Vuelve a ejecutar el main
            Program.main(null);
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

