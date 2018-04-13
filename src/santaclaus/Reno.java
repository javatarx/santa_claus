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

    @Override
    public void run() {
        System.out.println("Reno creado");
        try {
            while (true) {
                if (Main.modelListaRenos.size() == Main.TOTAL_RENOS) {
                    Main.semRenos.acquire();
                    SantaClaus.viajarConRenos();
                }
                Thread.sleep(100);
            }
        } catch (Exception e) {
        }
    }

}
