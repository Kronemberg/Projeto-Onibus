package Checking;

import java.util.ArrayList;
import java.util.List;

public class Marcar {
	
	public static List<Integer> assentosLinha1 = new ArrayList<>();
	public static List<Integer> assentosLinha2 = new ArrayList<>();
	
	public static void marcarAssento1(int assento){
		assentosLinha1.add(assento);
	}
	
	public static void marcarAssento2(int assento){
		assentosLinha2.add(assento);
	}
	
	public static List<Integer> getAssentosLinha(int linha){
		if(linha == 1) {
			return assentosLinha1;
		}
		else if(linha == 4) {
			return assentosLinha2;
		}
		return null;
	}
	
	public List<Integer> getAssentosLinha2(){
		return assentosLinha2;
	}
	
	public static void carregarAssentos() {
		for(Bilhete a : Bilhete.bilhetes) {
			int assento = a.getAssento();
			String idLinha = a.getLinha().getId();
			if(idLinha.equals("1")) {
				marcarAssento1(assento);
			}
			else if (idLinha.equals("4")) {
				marcarAssento2(assento);
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}
