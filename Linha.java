package Checking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Linha {
	private String id;
	private String origem;
	private String destino;
	private LocalTime horaDePartida;
	private LocalTime horaDeEmbarque;
	
	private static List<Linha> linhas = new ArrayList<>();
	
	static final String LISTAR_LINHAS = "select * from linha";
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public LocalTime getHoraDePartida() {
		return horaDePartida;
	}
	public void setHoraDePartida(LocalTime horaDePartida) {
		this.horaDePartida = horaDePartida;
	}
	public LocalTime getHoraDeEmbarque() {
		return horaDeEmbarque;
	}
	public void setHoraDeEmbarque(LocalTime horaDeEmbarque) {
		this.horaDeEmbarque = horaDeEmbarque;
	}
	@Override
	public String toString() {
		return "Linha [id=" + id + ", origem=" + origem + ", destino=" + destino + ", horaDePartida=" + horaDePartida
				+ ", horaDeEmbarque=" + horaDeEmbarque + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linha other = (Linha) obj;
		return Objects.equals(id, other.id);
	}
	
	public void getLinha() throws SQLException, ParseException{
		Connection conexao = Conexao.getConnection();
		PreparedStatement comandoSQL = conexao.prepareStatement(LISTAR_LINHAS);
		comandoSQL.execute();
		
		ResultSet dados = comandoSQL.getResultSet();
		while (dados.next()) {
			Linha a = new Linha();
			String id = dados.getString(1);
			a.setId(id);
			
			String origem = dados.getString(2);
			a.setOrigem(origem);
			
			String destino = dados.getString(3);
			a.setDestino(destino);
			
			String horaEmbarque = dados.getString(4);
			
			if(horaEmbarque != null) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalTime embarque = LocalTime.parse(horaEmbarque,dtf);
				a.setHoraDeEmbarque(embarque);
			}
			
			String horaPartida = dados.getString(5);
			
			if(horaPartida != null) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalTime partida = LocalTime.parse(horaPartida,dtf);
				a.setHoraDePartida(partida);
			}
			
			linhas.add(a);
				
		}
	}
	
	public static List<Linha> getListaLinha(){
		return linhas;
	}
}		