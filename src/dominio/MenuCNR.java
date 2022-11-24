package dominio;
    /*
    MENU CNR***********************************************************************************************************
    Para los Clientes no registrados, desde esta interfaz se les informa el valor de la estadia, y se le otorga un
    numero para su validacion el mismo numero por el momento solo sera "1234". este mismo numero se 
    validara una vez que el cliente decida "Pagar Ticket", lo cual lo rediririgira hacia "menuATC()". 
    La segunda opcion simplementefinaliza la ejecucion dando una despedida.
    */
public class MenuCNR extends Animaciones{
  
    public static void menuCNR() {
        int opcion = 0;
         
        Animaciones.tituloATC();
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
                    System.out.println("                                           Speach Sugerido:  '' Lamentamos que no pueda quedarse, lo esperamos en otra oportunidad. '' ");
                    // Aqui no utilizamos SubAnimacionDespedida(), porque epara este evento no se
                    // necesitaria abrir barrera.
                    Utilidades.esperar(4);
                    System.out.println(" ");
                    Animaciones.continuarConOtroCliente();
                    break;
            } else {
                    Utilidades.limpiarPantalla();
                    Animaciones.tituloATC();
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
                    Animaciones.opcionInvalidaParaMenu();
                    opcion = Integer.parseInt(entrada.nextLine());
                    Utilidades.limpiarPantalla();
            }
        } while (opcion != 1 || opcion != 2);
    } // Fin CRN
}
