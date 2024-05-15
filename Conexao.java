package Checking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Conexao {
	
	private static Connection instancia = null;
	
	static final String LISTAR_BILHETES = "select * from bilhete";
	static final String LISTAR_PASSAGEIROS = "select * from passageiro";
	static final String LISTAR_LINHAS = "select * from linha";
	
	private Conexao() throws SQLException {
	}
	
	public static Connection getConnection() throws SQLException {
		if (instancia == null) {
			instancia = DriverManager.getConnection("jdbc:postgresql://134.209.243.185:5432/vavatur", "vavatur", "gGgLqu");
		}
		return instancia;
	}
}	