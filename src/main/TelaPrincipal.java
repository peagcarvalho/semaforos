package main;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	
	public TelaPrincipal() {
		setTitle("Sincronização de Processos - Semáforos");
		setIconImage(Resources.SEMAFORO_ICONE.getImage());
		setBounds(350, 5, 700, 720);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addComponentes();
	}
	
	public void addComponentes() {
		painel = new JPanel();
		painel.setLayout(null);
		setContentPane(painel);
		
		addFundoInicial();
		addSemaforoVerm();
		addSemaforoVerde();
		addCarros();
		addFundo();
		
		ControladorCarro ctrl = new ControladorCarro(carro1, carro2, carro3, carro4, 
								semaforoVerm1, semaforoVerm2, semaforoVerm3, 
								semaforoVerm4, semaforoVerde1, semaforoVerde2, 
								semaforoVerde3, semaforoVerde4, fundoInicio, btnInicio);
		
		btnInicio.addActionListener(ctrl);
	}
	
	public void addFundoInicial() {
		// Fundo inicial
		fundoInicio = new JLabel();
		fundoInicio.setBounds(0, 0, 700, 700);
		fundoInicio.setIcon(Resources.FUNDO_INICIO);
		
		btnInicio = new JButton();
		btnInicio.setBounds(140, 300, 410, 67);
		btnInicio.setBackground(Color.white);
		
		JLabel nomeBotao = new JLabel();
		nomeBotao.setIcon(Resources.START);
		
		btnInicio.add(nomeBotao);
		painel.add(btnInicio);
		painel.add(fundoInicio);
	}
	
	public void addFundo() {
		// Fundo secundário
		fundo = new JLabel();
		fundo.setBounds(0, 0, 700, 700);
		fundo.setIcon(Resources.FUNDO);
		painel.add(fundo);
	}

	public void addSemaforoVerm() {
		semaforoVerm1 = new JLabel();
		semaforoVerm1.setIcon(Resources.SEMAFORO_VERM_1);
		semaforoVerm1.setBounds(235, 185, 128, 43);
		painel.add(semaforoVerm1);
		
		semaforoVerm2 = new JLabel();
		semaforoVerm2.setIcon(Resources.SEMAFORO_VERM_2);
		semaforoVerm2.setBounds(495, 220, 43, 128);
		painel.add(semaforoVerm2);
		
		semaforoVerm3 = new JLabel();
		semaforoVerm3.setIcon(Resources.SEMAFORO_VERM_3);
		semaforoVerm3.setBounds(375, 485, 128, 43);
		painel.add(semaforoVerm3);
		
		semaforoVerm4 = new JLabel();
		semaforoVerm4.setIcon(Resources.SEMAFORO_VERM_4);
		semaforoVerm4.setBounds(195, 360, 43, 128);
		painel.add(semaforoVerm4);
	}
	
	public void addSemaforoVerde() {
		semaforoVerde1 = new JLabel();
		semaforoVerde1.setIcon(Resources.SEMAFORO_VERDE_1);
		semaforoVerde1.setBounds(235, 185, 128, 43);
		semaforoVerde1.setVisible(false);
		painel.add(semaforoVerde1);
		
		semaforoVerde2 = new JLabel();
		semaforoVerde2.setIcon(Resources.SEMAFORO_VERDE_2);
		semaforoVerde2.setBounds(495, 220, 43, 128);
		semaforoVerde2.setVisible(false);
		painel.add(semaforoVerde2);
		
		semaforoVerde3 = new JLabel();
		semaforoVerde3.setIcon(Resources.SEMAFORO_VERDE_3);
		semaforoVerde3.setBounds(375, 485, 128, 43);
		semaforoVerde3.setVisible(false);
		painel.add(semaforoVerde3);
		
		semaforoVerde4 = new JLabel();
		semaforoVerde4.setIcon(Resources.SEMAFORO_VERDE_4);
		semaforoVerde4.setBounds(195, 360, 43, 128);
		semaforoVerde4.setVisible(false);
		painel.add(semaforoVerde4);
	}
	
	public void addCarros() {
		carro1 = new JLabel();
		carro1.setIcon(Resources.CARRO_1);
		carro1.setBounds(283, 51, 64, 115);
		painel.add(carro1);
		
		carro2 = new JLabel();
		carro2.setIcon(Resources.CARRO_2);
		carro2.setBounds(561, 272, 115, 64);
		painel.add(carro2);
		
		carro3 = new JLabel();
		carro3.setIcon(Resources.CARRO_3);
		carro3.setBounds(387, 550, 64, 115);
		painel.add(carro3);
		
		carro4 = new JLabel();
		carro4.setIcon(Resources.CARRO_4);
		carro4.setBounds(54, 381, 115, 64);
		painel.add(carro4);
	}
	
	// Carros
	JLabel carro1, carro2, carro3, carro4;
	
	// Semáforos Vermelhos
	JLabel semaforoVerm1, semaforoVerm2, semaforoVerm3, semaforoVerm4;
	
	// Semáforos Verdes
	JLabel semaforoVerde1, semaforoVerde2, semaforoVerde3, semaforoVerde4;
	
	// Fundos
	JLabel fundoInicio, fundo;
	JButton btnInicio;
	
}
