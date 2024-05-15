package Checking.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Checking.gui.Imagem.InicialImagem;

public class TelaInicialA extends JFrame {
	
	private static InicialImagem a;
	private static JFrame inicial;
	
	public static JFrame getTelaInicial() {
		
		if(inicial == null) {
			inicial = new JFrame();
			inicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			inicial.setSize(400,400);
			inicial.setTitle("Tela Inicial");
			inicial.setLocationRelativeTo(null);
	
			a = new InicialImagem();
			a.setLayout(null);
			a.setBackground(Color.BLACK);
			
			
			JButton Realizar = new JButton("Realizar Checking");
			Realizar.setBounds(120, 150, 150, 50);
			
			Realizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProcurarBilhete procurar = new ProcurarBilhete();
					procurar.setModal(true);
					procurar.setVisible(true);
				}
			});
			
			a.add(Realizar);
			inicial.add(a);		
		}
		return inicial;
	}
}
