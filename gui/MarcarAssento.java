package Checking.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Checking.gui.Imagem.MarcarImagem;
import Checking.Bilhete;
import Checking.Conexao;
import Checking.Marcar;
import Checking.Situacao;

class PainelMarcarAssento extends JPanel {
	
	private List <JButton> botoes = new ArrayList<>();
	public List<Bilhete> bilhetes = Bilhete.getListaBilhetes();
	
	private Integer assentoSelecionado = null;
	public Integer getAssentoSelecionado() {
		return this.assentoSelecionado;
	}
	
	private ActionListener cliqueBotao = (e) -> {
		if(assentoSelecionado != null) {
			this.setAssento(this.assentoSelecionado, Situacao.LIVRE);
		}
		this.assentoSelecionado = botoes.indexOf(e.getSource()) + 1;
		this.setAssento(assentoSelecionado,Situacao.SELECIONADO);
		
	};
	
	public PainelMarcarAssento(int assentos, Bilhete marcados){
		int colunas = assentos/2;
		GridLayout layout = new GridLayout(2,colunas);
		layout.setVgap(10);
		setLayout(layout);
		setBackground(Color.WHITE);
		
		for (int i = 0; i < assentos; i++) {
			JButton b = new JButton("" + (i+1));
			b.addActionListener(this.cliqueBotao);
			add(b);
			botoes.add(b);
			this.setAssento(i + 1 , Situacao.LIVRE);
		}
		Marcar.carregarAssentos();
		int linha = Integer.parseInt(marcados.getLinha().getId());
		
		List<Integer> assentosMarcados = Marcar.getAssentosLinha(linha);
		
		for(int i = 0 ; i < assentosMarcados.size(); i++) {
			int assento = assentosMarcados.get(i);
			if(assento != 0 && assento<=20) {
				this.setAssento(assento,Situacao.OCUPADO);
			}
		}
				
	}
	
	public void setAssento(int assento, Situacao situacao) {
		if (situacao == Situacao.OCUPADO) {
			JButton b = botoes.get(assento - 1);
			b.setBackground(Color.RED);
			b.setEnabled(false);
		}
		else if (situacao == Situacao.LIVRE) {
			JButton b = botoes.get(assento - 1);
			b.setBackground(Color.GREEN);
			b.setEnabled(true);
		}
		else if (situacao == Situacao.SELECIONADO) {
			JButton b = botoes.get(assento - 1);
			b.setBackground(Color.WHITE);
			b.setEnabled(true);
		}
	}

}


public class MarcarAssento extends JFrame {
	

	static final String MARCAR_ASSENTO = "UPDATE bilhete SET assento= (?) WHERE codigo= (?)";

	private MarcarImagem painel;
	
	public MarcarAssento(Bilhete bilheteMarcar){
		setSize(600,350);
		setLocationRelativeTo(null);
		setLayout(null);
		
		painel = new MarcarImagem();
		painel.setLayout(null);
		setContentPane(painel);
		
		
		PainelMarcarAssento assentos = new PainelMarcarAssento(20, bilheteMarcar);
	
		JButton proximo = new JButton("Proximo");
		proximo.setBounds(465, 260, 100, 30);
		painel.add(proximo);
		
		proximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bilheteMarcar.getAssento() == 0) {
					if(bilheteMarcar.getLinha().getId().equals("1")) {
						Marcar.marcarAssento1(assentos.getAssentoSelecionado());
					}
					else if (bilheteMarcar.getLinha().getId().equals("4")) {
						Marcar.marcarAssento2(assentos.getAssentoSelecionado());
					}
					bilheteMarcar.setAssento(assentos.getAssentoSelecionado());
					bilheteMarcar.removerBilhete(bilheteMarcar);
					bilheteMarcar.adicionarBilhete(bilheteMarcar);
					Connection conexao;
					try {
						conexao = Conexao.getConnection();
					
						PreparedStatement comandoSQL = conexao.prepareStatement(MARCAR_ASSENTO);
						comandoSQL.setInt(1, assentos.getAssentoSelecionado());
						comandoSQL.setString(2, bilheteMarcar.getCodigo());
						comandoSQL.execute();
	
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "Checking Realizado com Sucesso","Checking", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao Realizar o Checking","Checking", JOptionPane.ERROR_MESSAGE);
				}
				InfoBilhete.marcar.setVisible(false);
				JFrame inicial = TelaInicialA.getTelaInicial();
				inicial.setVisible(true);
			}
		});
		
		assentos.setBounds(15, 130, 550, 100);
		
		painel.add(assentos);
		
	}

}
