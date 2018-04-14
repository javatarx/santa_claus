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

    public static void despertar() {
        System.out.println("Santa despierto");
        Main.semSanta.release();
        if (Main.modelListaElfos.size() == Main.CANT_ELFOS_ATENCION) {
            ayudarElfos();
        } else if (Main.modelListaRenos.size() == Main.ULTIMO_RENO) {
            prepararTrineo();
        } else {
            System.out.println("Me despertaron en vano :S");
        }
    }

    public static void prepararTrineo(){
        System.out.println("Preparando el trineo");
        Main.semRenos.release(9);
        repartirRegalos();
    }
    
    public static synchronized void repartirRegalos() {
        System.out.println("Viajando con renos");
    }

    public static synchronized void ayudarElfos() {
        System.out.println("Ayudando a un elfo");
    }
}
