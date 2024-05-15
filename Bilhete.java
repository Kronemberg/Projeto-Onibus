package Checking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Bilhete  {
	private String codigo;
	private int assento;
	private Passageiro passageiro;
	private Linha linha;
	private LocalDate assento_marcado_em;
	
	static final String LISTAR_BILHETES = "select * from bilhete";
	
	public static List<Bilhete> bilhetes = new ArrayList<>();
	public List<Passageiro> passageiros = Passageiro.getListaPassageiro();
	public List<Linha> linhas = Linha.getListaLinha();
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getAssento() {
		return assento;
	}
	public void setAssento(int assento) {
		this.assento = assento;
	}
	public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	public Linha getLinha() {
		return linha;
	}
	public void setLinha(Linha linha) {
		this.linha = linha;
	}
	public LocalDate getAssento_marcado_em() {
		return assento_marcado_em;
	}
	public void setAssento_marcado_em(LocalDate assento_marcado_em) {
		this.assento_marcado_em = assento_marcado_em;
	}
	
	@Override
	public String toString() {
		return "Billhete [codigo=" + codigo + ", assento=" + assento + ", id_passageiro=" + passageiro
				+ ", id_linha=" + linha + ", assento_marcado_em=" + assento_marcado_em + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bilhete other = (Bilhete) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	public void getBilhetes() throws SQLException{
		Connection conexao = Conexao.getConnection();
		
		PreparedStatement comandoSQL = conexao.prepareStatement(LISTAR_BILHETES);
		comandoSQL.execute();
		
		ResultSet dadosBilhete = comandoSQL.getResultSet();
		
		while (dadosBilhete.next()) {
			Bilhete a = new Bilhete();
			String Bilhete = dadosBilhete.getString(1);
			a.setCodigo(Bilhete);
			
			int assento = dadosBilhete.getInt(2);
			a.setAssento(assento);
			
			String idPass = dadosBilhete.getString(3);;
			
			String idLinha = dadosBilhete.getString(4);
			
			
			for (Passageiro passageiroComp : passageiros) {
				String idP = passageiroComp.getId();
				if(idPass.equals(idP) && idPass != null) {
					a.setPassageiro(passageiroComp);
				}
			}
			
			for (Linha linhaComp : linhas) {
				String idL = linhaComp.getId();
				if(idLinha.equals(idL)) {
					a.setLinha(linhaComp);
				}
			}
			
			bilhetes.add(a);
						
		}
	}
	
	public static List<Bilhete> getListaBilhetes(){
		return bilhetes;
	}
	
	public void pegaPassageiro() throws SQLException{
		Passageiro a = new Passageiro();
		a.getPassageiro();
	}
	
	public void pegaLinha() throws SQLException, ParseException {
		Linha a = new Linha();
		a.getLinha();
	}
	
	public void imprimirPassageiros() {
		for (Passageiro a : passageiros) {
			String nome = a.getNome();
			System.out.println(nome);	
		}
	}
	
	public void imprimirLinhas() {
		for (Linha a : linhas) {
			String linha = a.getId();
			System.out.println(linha);	
		}
	}
	
	public void removerBilhete(Bilhete a){
		bilhetes.remove(a);
	}
	
	public void adicionarBilhete(Bilhete a){
		bilhetes.add(a);
	}
	
	public void marcarAssento(int assento) {
		
	}
}
