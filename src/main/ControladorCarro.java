package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ControladorCarro implements ActionListener{
	// Carros
	JLabel carro1, carro2, carro3, carro4;
		
	// Semáforos Vermelhos
	JLabel semaforoVerm1, semaforoVerm2, semaforoVerm3, semaforoVerm4;
	
	// Semáforos Verdes
	JLabel semaforoVerde1, semaforoVerde2, semaforoVerde3, semaforoVerde4;
	
	// Fundos
	JLabel fundoInicio;
	JButton btnInicio;
	
	private Semaphore semaforo = new Semaphore(1);
	
	public ControladorCarro(JLabel carro1, JLabel carro2, JLabel carro3, JLabel carro4,
							JLabel semaforoVerm1, JLabel semaforoVerm2, JLabel semaforoVerm3,
							JLabel semaforoVerm4, JLabel semaforoVerde1, JLabel semaforoVerde2,
							JLabel semaforoVerde3, JLabel semaforoVerde4, JLabel fundoInicio, 
							JButton btnInicio) {
		
		this.carro1 = carro1;
		this.carro2 = carro2;
		this.carro3 = carro3;
		this.carro4 = carro4;
		
		this.semaforoVerm1 = semaforoVerm1;
		this.semaforoVerm2 = semaforoVerm2;
		this.semaforoVerm3 = semaforoVerm3;
		this.semaforoVerm4 = semaforoVerm4;
		
		this.semaforoVerde1 = semaforoVerde1;
		this.semaforoVerde2 = semaforoVerde2;
		this.semaforoVerde3 = semaforoVerde3;
		this.semaforoVerde4 = semaforoVerde4;
		
		this.fundoInicio = fundoInicio;
		this.btnInicio = btnInicio;
	}
	
	public void actionPerformed(ActionEvent e) {
		fundoInicio.setVisible(false);
		btnInicio.setVisible(false);
		
		Semaforo s1 = new Semaforo(carro1, semaforoVerm1, semaforoVerde1, semaforo, fundoInicio, btnInicio, 1);
		Semaforo s2 = new Semaforo(carro2, semaforoVerm2, semaforoVerde2, semaforo, fundoInicio, btnInicio, 2);
		Semaforo s3 = new Semaforo(carro3, semaforoVerm3, semaforoVerde3, semaforo, fundoInicio, btnInicio, 3);
		Semaforo s4 = new Semaforo(carro4, semaforoVerm4, semaforoVerde4, semaforo, fundoInicio, btnInicio, 4);
		
		s1.start();
		s2.start();
		s3.start();
		s4.start();
	}
	
}
