package Checking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Passageiro {
	private String id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	
	private static List<Passageiro> passageiros = new ArrayList<>();
	
	static final String LISTAR_PASSAGEIROS = "select * from passageiro";
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone_contato) {
		this.telefone = telefone_contato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Passageiro [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone_contato=" + telefone
				+ ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passageiro other = (Passageiro) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
	
	public void getPassageiro() throws SQLException{
		Connection conexao = Conexao.getConnection();
		PreparedStatement comandoSQL = conexao.prepareStatement(LISTAR_PASSAGEIROS);
		comandoSQL.execute();
		
		ResultSet dados = comandoSQL.getResultSet();
		while (dados.next()) {
			Passageiro a = new Passageiro();
			String id = dados.getString(1);
			a.setId(id);
			
			String nome = dados.getString(2);
			a.setNome(nome);
			
			String cpf = dados.getString(3);
			a.setCpf(cpf);
			
			String telefone = dados.getString(4);
			a.setTelefone(telefone);
			
			String email = dados.getString(5);
			a.setEmail(email);
			
			passageiros.add(a);
		}
		
	}
	
	public static List<Passageiro> getListaPassageiro(){
		return passageiros;
	}
}