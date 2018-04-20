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
            if (Main.modelListaSalaEspera.size() == Main.CANT_ELFOS_ATENCION) {
                ingresarSalaEspera();
                Main.semSanta.release(1);
            }else{
                Main.semElfos.acquire();
                ingresarSalaEspera();
            }
            
        } catch (Exception e) {
        }
    }

    
    public void ingresarSalaEspera(){
        System.out.println("El "+toString()+" ingreso a la sala de espera");
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
