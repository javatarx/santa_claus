/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santaclaus;

/**
 *
 * @author developer
 */
public class SantaClaus {
//    private static Main m = new Main();

    public static void despertar() {
        System.out.println("Santa despierto");
        if (Main.modelListaElfos.size() == Main.CANT_ELFOS_ATENCION) {
            ayudarElfos();
        } else if (Main.modelListaRenos.size() == Main.ULTIMO_RENO) {
            prepararTrineo();
        } else {
            System.out.println("Me despertaron en vano :S");
        }
    }

    public static void prepararTrineo() {
        System.out.println("Preparando el trineo");
        Main.semRenos.release(9);
        repartirRegalos();
        Main.semSanta.release();
    }

    public static synchronized void repartirRegalos() {
        System.out.println("Viajando con renos");
    }

    public static synchronized void ayudarElfos() {

        System.out.println("Ayudando a elfos");
        Main.semElfos.release(3);
        Main.semSanta.release();
    }

//    public static void updateView() {
//        m.updateLabelsSize();
//    }
}
