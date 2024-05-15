package Checking;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFrame;

import Checking.gui.ProcurarBilhete;
import Checking.gui.TelaInicialA;

public class Principal {
	public static void main(String[] args) throws SQLException, ParseException {
		JFrame inicial = TelaInicialA.getTelaInicial();
		inicial.setVisible(true);
		Bilhete a = new Bilhete();
		a.pegaPassageiro();
		a.pegaLinha();
		a.getBilhetes();
		
	}
}
