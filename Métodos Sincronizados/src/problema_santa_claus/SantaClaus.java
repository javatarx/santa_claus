/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema_santa_claus;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author LENOVO
 */
public class SantaClaus extends Thread {
    
    private static final int NUM_ELFOS = 3;
    private static final int NUM_RENOS = 9;
	
    private Random rnd;
    // Vector para seguridad del Thread
    private Vector<Elfo> ListaElfosEspera; // Lista de Elfos que necesitan ayuda de Santa
    private Vector<Reno> ListaRenosEspera; // Lista de Renos preparados para entregar regalos

    public SantaClaus() {
        rnd = new Random();
	ListaElfosEspera = new Vector<Elfo>();
	ListaRenosEspera = new Vector<Reno>();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                while (ListaElfosEspera.size() < NUM_ELFOS && ListaRenosEspera.size() < NUM_RENOS) {
                    try {
                        wait();
		    } catch (InterruptedException e) {
                        e.printStackTrace();
		    }
		}
	    }
	    if (ListaRenosEspera.size() >= NUM_RENOS) { // La entrega de regalos tiene la mayor prioridad
                System.out.println("Santa despertó para entregar los regalos");
		entregaregalos();
		System.out.println("Santa regresó de entregar los regalos y vuelve a dormir");
	    } else if (ListaElfosEspera.size() >= NUM_ELFOS) {
                System.out.println("Santa despertó para ayudar a los elfos");
		asesorar();
		System.out.println("Santa atendió a los elfos y vuelve a dormir");
	    }
	}
    }

    public void preguntar(Elfo elfo) {
        this.ListaElfosEspera.add(elfo); // (Vector) ya sincronizado
	synchronized (this) {
            this.notify();
	}
    }

    public void entraestablo(Reno reno) {
	this.ListaRenosEspera.add(reno); // (Vector) ya sincronizado
	synchronized (this) {
	    this.notify();
	}
    }

    private void asesorar() {
        for (int i = 0; i < ListaElfosEspera.size();) { // el tamaño de la lista disminuye en cada iteración por eso no se usa "i++"
	    Elfo elfo = ListaElfosEspera.get(0);
	    synchronized (elfo) {
                try {
                    sleep(1000); // Santa dedica un tiempo para asesorar a cada elfo
		} catch (InterruptedException e) {
                    e.printStackTrace();
		}
                System.out.println("Elfo " + elfo.getid() + " fue atendido");
	        elfo.espera = false; // El Elfo-Thread puede continuar
		elfo.notify();
	    }
	    ListaElfosEspera.remove(0); // El elfo que ya fue asesorado se elimina de la lista
	}
    }

    private void entregaregalos() {
    // Distribuye regalos con los renos
	try {
	    int pause = rnd.nextInt(8001) + 7000; // 7 - 15 s
	    sleep(pause);
	} catch (InterruptedException e) {
            e.printStackTrace();
	}
	// Continuar los Reno_Threads (Darle a los renos sus merecidas vacaciones)
	for (int i = 0; i < NUM_RENOS; i++) {
	    Reno reno = ListaRenosEspera.get(0);
	    synchronized (reno) {
		reno.espera = false;
	        reno.notify();
	    }
	    ListaRenosEspera.remove(0);
	}
    }
}
