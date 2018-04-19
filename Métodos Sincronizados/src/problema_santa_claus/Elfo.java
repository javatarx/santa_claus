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
public class Elfo extends Thread {

    private SantaClaus santa;
    private Random rnd;
    private int id;
    
    public boolean espera;

	
    public Elfo(SantaClaus santa, int id) {
        this.santa = santa;
	rnd = new Random();
	espera = false;
        this.id = id;
    }
        
    int getid (){
        return this.id;
    }

    
    @Override
    public void run(){
        while (true) {
            try {
		int pause = rnd.nextInt(19001) + 1000; // 1 - 20 s
		sleep(pause);
	    } catch (InterruptedException e) {
                e.printStackTrace();
	    }
	    System.out.println("Elfo " + id + " necesita ayuda");
	    // Cuando un elfo necesita ayuda le pregunta a Santa
            // en este Thread va a esperar el llamado
			
	    santa.preguntar(this);
	    espera = true;
	    synchronized(this){
                while(espera){
                    try{
                        wait();
		    }catch(InterruptedException e){
                        e.printStackTrace();
		    }
		}
	    }
	}
    }
}
