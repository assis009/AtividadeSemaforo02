package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {

	private int id;
	private String sentido;
	private static int controleSentido;
	private Semaphore semaforo;

	public ThreadCarro(int id, Semaphore semaforo) {

		this.id = id;
		this.semaforo = semaforo;
	}

	public void run() {
		
		//fazendo controle do sentido
		controleSentido++;
		switch (controleSentido) {
		case 1:
			sentido="Norte";
			break;
		case 2:
			sentido="Sul";
			break;
		case 3:
			sentido="Leste";
			break;
		case 4:
			sentido="Oeste";
			break;

		default:
			break;
		}

		// ---- Seção critica ----
		try {
			semaforo.acquire();
			Sinal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// ---- Seção critica ----
			semaforo.release();
		}

	}

	public void Sinal() {

		System.out.println("Sinal verde para o sentido " + sentido);
		System.out.println("O carro #" + id + " está atravessando no sentido " + sentido);
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Sinal vermelho para o sentido " + sentido);
		System.out.println("\n");
	}
}