/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santaclaus;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author developer
 */
public class SantaClaus extends Thread{

    @Override
    public void run() {
        System.out.println("Santa esta durmiendo");
        while (true) {            
            try {
                Main.semSanta.acquire();
                despertar();
            } catch (InterruptedException ex) {
                Logger.getLogger(SantaClaus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    
    
    public static void despertar() {
        System.out.println("Santa despierto");
        Main.despertarSanta();
        if (Main.modelListaSalaEspera.size() == Main.CANT_ELFOS_ATENCION) {
            ayudarElfos();
        } else if (Main.modelListaRenos.size() == Main.ULTIMO_RENO) {
            prepararTrineo();
        } else {
            System.out.println("Me despertaron en vano :S");
        }
    }
    
    public static synchronized void prepararTrineo() {
        System.out.println("Preparando el trineo");
        Main.semRenos.release(9);
        repartirRegalos();
    }
    
    public static synchronized void repartirRegalos() {
        System.out.println("Viajando con renos");
    }
    
    public static synchronized void ayudarElfos() {
        
        System.out.println("Ayudando a elfos");
        
        for (int i = 0; i < Main.CANT_ELFOS_ATENCION; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Ayudando a " + Main.modelListaSalaEspera.get(0));
                Main.modelListaSalaEspera.remove(0);
            } catch (InterruptedException ex) {
                Logger.getLogger(SantaClaus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Main.dormirSanta();
        Main.semElfos.release(3);
        Main.semSanta.release(0);
    }

}
