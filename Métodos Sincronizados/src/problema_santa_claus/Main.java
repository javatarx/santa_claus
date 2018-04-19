/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema_santa_claus;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args){
      	
	// Santa
	SantaClaus santa = new SantaClaus();
	santa.start();
		
	// Elfos
        for(int i = 1; i <= 10; i++){
            Elfo elfo = new Elfo(santa, i);
	    elfo.start();
	}
		
	// Renos
        ArrayList<String> NombresRenos = new ArrayList<String>(
                Arrays.asList("Vondín","Danzarín","Chiqui","Juguetón","Cometa",
                        "Cupido","Trueno","Relámpago","Rodolfo"));
                
	for(int i = 1; i <= 9; i++){
            Reno reno = new Reno(santa,NombresRenos.get(i-1));
	    reno.start();
	}
		
    }    
}
