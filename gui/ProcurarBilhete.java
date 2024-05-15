package Checking.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Checking.Bilhete;
import Checking.Linha;
import Checking.gui.Imagem.ProcurarImagem;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;

public class ProcurarBilhete extends JDialog {
	
	ProcurarImagem p;
	private JTextField txtProcurar;
	public List<Bilhete> bilhetes = Bilhete.getListaBilhetes();
	static InfoBilhete telaBilhete;
		
	public String acharBilhete(){
		String falso = "falso";
		String codA = this.txtProcurar.getText();
		for (Bilhete codComp : bilhetes) {
			String cod = codComp.getCodigo();
			if(codA.equals(cod)) {
				falso = codA;
			}		
	}
		return falso;
}
	
	public ProcurarBilhete(){
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(370,200);
		setTitle("Procurar Bilete");
		setLocationRelativeTo(null);
	
		p = new ProcurarImagem();
		
		p.setBackground(Color.WHITE);
		p.setLayout(null);
		JLabel Procurar = new JLabel("Procurar Bilete:");
		Procurar.setBounds(30,20,100,30);
		p.add(Procurar);
		
		txtProcurar = new JTextField(20);
		txtProcurar.setBounds(130,20,200,30);
		p.add(txtProcurar);
		
		JButton btnProximo = new JButton("Proximo");
		btnProximo.setBounds(130,80,100,30);
		p.add(btnProximo);
		
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = acharBilhete();
				if(codigo.equals("falso")){
					JOptionPane.showMessageDialog(null, "Bilhete Não Encontrado","Bilhete", JOptionPane.ERROR_MESSAGE);
					setVisible(false);
				}else{
					setVisible(false);
					telaBilhete = new InfoBilhete(codigo);
					telaBilhete.setVisible(true);
					JFrame inicial = TelaInicialA.getTelaInicial();
					inicial.setVisible(false);
				}
				
			}
		});
		
		add(p);
		
	}
}
