package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Cruzamento {

	public static void main(String[] args) {
		
		int permisao = 1;
		Semaphore semaforo = new Semaphore(permisao);
		
			
				for(int idCarro=0;idCarro<4; idCarro++){
				Thread cruzamento01= new ThreadCarro(idCarro, semaforo);
				cruzamento01.start();
				}
				
			
		
	}

}
