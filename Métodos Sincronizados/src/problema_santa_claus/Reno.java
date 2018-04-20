/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema_santa_claus;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author LENOVO
 */
public class Reno extends Thread {

    private SantaClaus santa;
    private Random rnd;
    public boolean espera;
    private String name;

    public Reno(SantaClaus santa, String name) {
        this.santa = santa;
        rnd = new Random();
        espera = false;
        this.name = name;
    }

    String getname() {
        return this.name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int pause = rnd.nextInt(20001) + 5000; // 5 - 25s 
                sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Reno " + getname() + " entra al establo");
            // Cuando un reno entra al establo, espera el momento de iniciar el trabajo
            // en este Thread va a esperar el llamado
            santa.entraestablo(this);
            espera = true;
            synchronized (this) {
                while (espera) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Reno " + getname() + " viaja a vacaciones después de un largo día de trabajo");
            descanso();
        }
    }

    public void descanso() {
        try {
            int pause = rnd.nextInt(30001) + 10000; // 10 - 40s
            sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Reno " + name;
    }

}
