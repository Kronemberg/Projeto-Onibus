package Checking.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Checking.Bilhete;
import Checking.Linha;

public class InfoBilhete extends JFrame {
	
	public Imagem painel;
	public List<Bilhete> bilhetes = Bilhete.getListaBilhetes();
	static MarcarAssento marcar;
	
	public Bilhete mudarInfo(String bilhete){ 
		for (Bilhete Comp : bilhetes) {
			String codig = Comp.getCodigo();
			if(codig.equals(bilhete)) {
				return Comp;
			}
		}
		return null;
	}
	
	public InfoBilhete(String bilhete){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setTitle("Bilete");
		setLocationRelativeTo(null);
		
		Bilhete Info = mudarInfo(bilhete);
		
		JPanel painel = new JPanel();
		painel = new Imagem();
		painel.setLayout(null);
		
		JLabel nome = new JLabel("Nome:");
		nome.setBounds(50, 70, 100, 50);
		painel.add(nome);	
		
		String nomeI = Info.getPassageiro().getNome();
		JLabel nomeField = new JLabel(nomeI);
		nomeField.setBounds(100, 70, 150, 50);
		painel.add(nomeField);
		
		ImageIcon nIcon = new ImageIcon(getClass().getResource("image/icone nome.png"));
		JLabel nomeIcon = new JLabel(nIcon);
		nomeIcon.setBounds(10, 80, 30, 30);
		painel.add(nomeIcon);
		
		
		JLabel cpf = new JLabel("CPF:");
		cpf.setBounds(50, 110, 100, 50);
		painel.add(cpf);
		
		String cpfI = Info.getPassageiro().getCpf();
		JLabel cpfField = new JLabel(cpfI);
		cpfField.setBounds(100, 110, 150, 50);
		painel.add(cpfField);
		
		ImageIcon cIcon = new ImageIcon(getClass().getResource("image/icone cpf.png"));
		JLabel cpfIcon = new JLabel(cIcon);
		cpfIcon.setBounds(10, 120, 30, 30);
		painel.add(cpfIcon);
		
		JButton botao = new JButton("Atualizar Dados Pessoais");
		botao.setBounds(100, 170, 180, 30);
		painel.add(botao);
		
		JButton proximo = new JButton("Proximo");
		proximo.setBounds(290, 170, 100, 30);
		painel.add(proximo);
		
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				MudarInfo mudar = new MudarInfo(Info);
				mudar.setVisible(true);
			}
		});
		
		proximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				marcar = new MarcarAssento(Info);
				marcar.setVisible(true);
				ProcurarBilhete.telaBilhete.setVisible(false);
				
			}
		});
		
		JLabel origem = new JLabel("Origem:");
		origem.setBounds(50, 270, 150, 50);
		painel.add(origem);
		
		String origemI = Info.getLinha().getOrigem();
		JLabel origemField = new JLabel(origemI);
		origemField.setBounds(100, 270, 150, 50);
		painel.add(origemField);
		
		ImageIcon oIcon = new ImageIcon(getClass().getResource("image/icone origem.png"));
		JLabel origemIcon = new JLabel(oIcon);
		origemIcon.setBounds(10, 280, 30, 30);
		painel.add(origemIcon);
		
		JLabel destino = new JLabel("Destino:");
		destino.setBounds(300, 270, 150, 50);
		painel.add(destino);
		
		String destinoI = Info.getLinha().getDestino();
		JLabel destinoField = new JLabel(destinoI);
		destinoField.setBounds(350, 270, 150, 50);
		painel.add(destinoField);
		
		ImageIcon dIcon = new ImageIcon(getClass().getResource("image/icone destino.png"));
		JLabel destinoIcon = new JLabel(dIcon);
		destinoIcon.setBounds(265, 280, 30, 30);
		painel.add(destinoIcon);
		
		JLabel horaEmbarque = new JLabel("Embarque:");
		horaEmbarque.setBounds(50, 320, 150, 50);
		painel.add(horaEmbarque);
		
		LocalTime embarqueTime = Info.getLinha().getHoraDeEmbarque();
		String embarqueString = embarqueTime.toString();
		JLabel embarqueField = new JLabel(embarqueString);
		embarqueField.setBounds(115, 320, 150, 50);
		painel.add(embarqueField);
		
		ImageIcon eIcon = new ImageIcon(getClass().getResource("image/icone embarque.png"));
		JLabel embarqueIcon = new JLabel(eIcon);
		embarqueIcon.setBounds(10, 330, 30, 30);
		painel.add(embarqueIcon);
		
		JLabel horaPartida = new JLabel("Partida:");
		horaPartida.setBounds(300, 320, 150, 50);
		painel.add(horaPartida);
		
		LocalTime partidaTime = Info.getLinha().getHoraDePartida();
		String partidaString = partidaTime.toString();
		JLabel partidaField = new JLabel(partidaString);
		partidaField.setBounds(350, 320, 150, 50);
		painel.add(partidaField);
		
		ImageIcon pIcon = new ImageIcon(getClass().getResource("image/icone partida.png"));
		JLabel partidaIcon = new JLabel(pIcon);
		partidaIcon.setBounds(265, 330, 30, 30);
		painel.add(partidaIcon);
		
		JLabel horaAtual = new JLabel("Atual:");
		horaAtual.setBounds(190, 370, 150, 50);
		painel.add(horaAtual);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		String agora = dtf.format(LocalTime.now());
		JLabel atualField = new JLabel(agora);
		atualField.setBounds(230, 370, 150, 50);
		painel.add(atualField);
		
		ImageIcon aIcon = new ImageIcon(getClass().getResource("image/icone atual.png"));
		JLabel atualIcon = new JLabel(aIcon);
		atualIcon.setBounds(155, 380, 30, 30);
		painel.add(atualIcon);
		
		add(painel);
	}
}
