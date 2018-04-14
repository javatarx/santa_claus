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
public class Reno extends Thread {

    private int num;

    public Reno(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("Llego el " + (toString()));
        try {
            while (true) {
                // Si es el 9no reno, este va a despertar a Santa
                if (Main.modelListaRenos.size() == Main.ULTIMO_RENO) {
                    Main.semSanta.acquire();
                    SantaClaus.despertar();
                }
                
                Main.semRenos.acquire();
                repartirRegalos();
            }
        } catch (Exception e) {
        }
    }

    private void repartirRegalos() throws InterruptedException {
        System.out.println("El " + toString() + " salio a repartir regalos");
        Thread.sleep(100);
        Main.modelListaRenos.removeElement(this);
    }

    @Override
    public String toString() {
        return "Reno " + (num + 1);
    }

}
