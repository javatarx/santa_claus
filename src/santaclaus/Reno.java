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
                if (Main.modelListaRenos.size() == Main.ULTIMO_RENO) {
                    Main.semSanta.acquire();
                    SantaClaus.despertar();
                }
                Main.semRenos.acquire();
                repartirRegalos();
                Thread.sleep(100);
            }
        } catch (Exception e) {
        }
    }

    private void repartirRegalos() {
        System.out.println("El " + toString() + " salio a repartir regalos");
    }

    @Override
    public String toString() {
        return "Reno " + (num + 1);
    }

}
