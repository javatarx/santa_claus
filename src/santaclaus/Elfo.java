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
public class Elfo extends Thread {

    private int num;

    public Elfo(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(toString() + " solicita ayuda.");
        try {
            while (true) {
                if (Main.modelListaElfos.size() / Main.CANT_ELFOS_ATENCION >= 1) {
                    Main.semSanta.acquire();
                    SantaClaus.despertar();
                }

                Main.semElfos.acquire();
                solicitarAyuda();
            }
        } catch (Exception e) {
        }
    }

    public void solicitarAyuda() {
        try {
            System.out.println("Santa ayuda al " + toString());
            Thread.sleep(1500);
            System.out.println("Santa termino de ayudar al " + toString());
            Main.modelListaElfos.removeElement(this);
            Main.updateLabelElfos();
        } catch (InterruptedException ex) {
            Logger.getLogger(Elfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "Elfo " + (num + 1);
    }

}
