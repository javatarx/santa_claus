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
                // Si es el 9no reno, este va a despertar a Santa
                if (Main.modelListaElfos.size() / 3 >= 1) {
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
        System.out.println("Santa ayuda al " + toString());
        Main.modelListaElfos.removeElement(this);
    }

    @Override
    public String toString() {
        return "Elfo " + (num + 1);
    }

}
