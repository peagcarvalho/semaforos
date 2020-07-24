package main;

import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.Semaphore;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Semaforo extends Thread {
	
	public Semaphore semaforo;
	private int op;
	private static int aux;
	private JLabel carro, semaforoVerm, semaforoVerde, fundoInicio;
	private JButton btnInicio;
	
	public Semaforo(JLabel carro, JLabel semaforoVerm, JLabel semaforoVerde,
			  		Semaphore semaforo, JLabel fundoInicio, JButton btnInicio, int op) {
		
		this.carro = carro;
		this.semaforoVerm = semaforoVerm;
		this.semaforoVerde = semaforoVerde;
		this.semaforo = semaforo;
		this.fundoInicio = fundoInicio;
		this.btnInicio = btnInicio;
		this.op = op;
	}
	
	public synchronized void up() {
		semaforo.release();
	}
	
	public synchronized void down() {
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		executar();
		
		if(aux == 4) {
			fundoInicio.setVisible(true);
			btnInicio.setVisible(true);
			aux = 0;
		}
	}
	
	public void executar() {
		try {
			down();
			acionarCarro();
			
		}  catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			up();
		}
		
		aux++;
	}
	
	public void acionarCarro() {
		Rectangle posicao = carro.getBounds();
		int aux = 0;
		Random random = new Random();
		
		switch (op) {
			case 1:
				semaforoVerm.setVisible(false);
				semaforoVerde.setVisible(true);
				while(aux < 2) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {}
					
					if(aux == 1) {
						posicao.y = (posicao.y) + (random.nextInt(2));
						if(posicao.y >= 46) {
							aux = 2;
						}
					}
					
					posicao.y = (posicao.y) + (random.nextInt(5));
					carro.setBounds(posicao);
					if(posicao.y >= 800) {
						posicao.y = -100;
						aux = 1;
					}
					
				}
				
				semaforoVerm.setVisible(true);
				semaforoVerde.setVisible(false);
				
				break;
			case 2:
				semaforoVerm.setVisible(false);
				semaforoVerde.setVisible(true);
				
				while(aux < 2) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {}
					
					if(aux == 1) {
						posicao.x = (posicao.x)-(random.nextInt(2));
						if(posicao.x <= 560) {
							aux = 2;
						}
					}
					
					posicao.x = (posicao.x)-(random.nextInt(5));
					carro.setBounds(posicao);
					if(posicao.x <= -100) {
						posicao.x = 800;
						aux = 1;
					}
					
				}
				
				semaforoVerm.setVisible(true);
				semaforoVerde.setVisible(false);
				
				break;
			case 3:
				semaforoVerm.setVisible(false);
				semaforoVerde.setVisible(true);
				
				while(aux < 2) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {}
					
					if(aux == 1) {
						posicao.y = (posicao.y) - (random.nextInt(2));
						if(posicao.y <= 549) {
							aux = 2;
						}
					}
					
					posicao.y = (posicao.y) - (random.nextInt(5));
					carro.setBounds(posicao);
					if(posicao.y <= -100) {
						posicao.y = 800;
						aux = 1;
					}
					
				}
				
				semaforoVerm.setVisible(true);
				semaforoVerde.setVisible(false);
				
				break;
			case 4:
				semaforoVerm.setVisible(false);
				semaforoVerde.setVisible(true);
				
				while(aux < 2) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {}
					
					if(aux == 1) {
						posicao.x = (posicao.x) + (random.nextInt(2));
						if(posicao.x >= 48) {
							aux = 2;
						}
					}
					
					posicao.x = (posicao.x) + (random.nextInt(5));
					carro.setBounds(posicao);
					if(posicao.x >= 800) {
						posicao.x = -100;
						aux = 1;
					}
					
				}
				
				semaforoVerm.setVisible(true);
				semaforoVerde.setVisible(false);
				
				break;
		}
	}
	
}
