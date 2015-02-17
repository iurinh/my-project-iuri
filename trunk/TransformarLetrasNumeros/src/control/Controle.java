package control;

import java.util.HashMap;

import entity.Mapinha;

public class Controle {

	public String trocarLetraNumeros(String palavrinha){
		String[] vetorPalavrinha = palavrinha.split("");
		palavrinha = magicaAconteceAqui(vetorPalavrinha);
		return palavrinha;
	}

	private String magicaAconteceAqui(String[] vetorPalavrinha) {
		Mapinha entidadeMapinha = new Mapinha();
		HashMap<String, String> mapinha = entidadeMapinha.getMapinha();
		String palavrinha = "=>";
		
		for (String letrinha : vetorPalavrinha) {
			letrinha = substituirLetrinhas(letrinha, mapinha);
			palavrinha = palavrinha.concat(letrinha);
		}

		return palavrinha;
	}

	private String substituirLetrinhas(String letrinha, HashMap<String, String> mapinha) {
		
		String retornoLetrinha = mapinha.get(letrinha.toLowerCase());
		
		if (retornoLetrinha == null) return letrinha;
		return retornoLetrinha;
	}

}
