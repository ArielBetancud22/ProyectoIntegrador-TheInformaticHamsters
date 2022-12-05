package dominio;

public class Guardia extends Animaciones {
    /*
     * Guardia recibe a modo de notificacion un solicitud para la verificacion de un
     * error en la barrera, la misma la
     * redirige la funcion Azar que se enuentra en el metodo "SeAbreBarrera()". Una
     * vez que se da ok a verificar,
     * esta simula una verificacion y reconexion por medio la animacion de
     * "animacionDeBarrera()", luego la cual,
     * finaliza el ejecucion del programa.
     */
    public static void guardia() {
        tituloGuardia();
        System.out.println(
                "                                                      NOTIFICACIÓN: Se solicita una Verificación de Barrera");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("                                                                        [ Verificar ]");
        System.out.println("");
        pressAnyKeyToContinue();
        animacionDeBarrera();
    } // Fin Guardia
}
