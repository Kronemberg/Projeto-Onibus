package Checking.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Checking.Bilhete;
import Checking.gui.Imagem.AlterarImagem;

public class MudarInfo extends JDialog{
	
	public AlterarImagem painel;
	private JTextField cpfTxt;
	private JTextField nomeTxt;
	static InfoBilhete infoBilhete;
	public List<Bilhete> bilhetes = Bilhete.getListaBilhetes();
	
	public MudarInfo(Bilhete change) {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(500,180);
		setTitle("Atualizar Dados Pessoais");
		setLocationRelativeTo(null);
			
		
		painel = new AlterarImagem();
		painel.setLayout(null);
		
		JLabel nome = new JLabel("Nome: ");
		nome.setBounds(50, 45, 100, 30);
		painel.add(nome);
		
		nomeTxt = new JTextField(20);
		nomeTxt.setBounds(100, 45, 170, 30);
		painel.add(nomeTxt);
		
		JLabel Cpf = new JLabel("CPF: ");
		Cpf.setBounds(50, 85, 100, 30);
		painel.add(Cpf);
		
		cpfTxt = new JTextField(20);
		cpfTxt.setBounds(100, 85, 170, 30);
		painel.add(cpfTxt);
		
		
		JButton salvar = new JButton("Salvar Alterações");
		salvar.setBounds(300, 45, 140, 30);
		painel.add(salvar);
		
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeChange = nomeTxt.getText();
				String cpfChange = cpfTxt.getText();

				change.getPassageiro().setNome(nomeChange);
				change.getPassageiro().setCpf(cpfChange);
				change.removerBilhete(change);
				change.adicionarBilhete(change);
				infoBilhete = new InfoBilhete(change.getCodigo());
				infoBilhete.setVisible(true);
				ProcurarBilhete.telaBilhete.setVisible(false);
				setVisible(false);
			}
		});
		
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(300, 85, 140, 30);
		painel.add(voltar);
		
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		
		
		add(painel);
	}
}
