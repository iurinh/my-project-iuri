package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import DAO.BatmanLabirintoDAO;
import DAO.BatmanLabirintoDAOImpl;

public class BatmanLabirintoControl {

	private ArrayList<ArrayList<String>> matrizMaze = new ArrayList<ArrayList<String>>();
	
	public void executarJogada(String percurso) throws Exception {
		BatmanLabirintoDAO dao = new BatmanLabirintoDAOImpl();
		matrizMaze = dao.adquirirMaze();
		
		tratarMatrizMaze();
		
		iniciarJogada(percurso);
	}

	private void tratarMatrizMaze() {

		for (int i = 0; i < matrizMaze.size(); i++) {
			matrizMaze.get(i).remove(0);
		}
		
	}

	private void iniciarJogada(String percurso) throws Exception {
		ArrayList<String> lsPercurso = adquirirPercurso(percurso);
		lsPercurso.remove(0); //por causa do split("");
		validarPercurso(lsPercurso);
		percorrer(lsPercurso);
	}

	private void validarPercurso(ArrayList<String> lsPercurso) throws Exception {
		if(lsPercurso.size() > 1000)
			throw new Exception("Nao foi possivel comecar o jogo,\n porque sabemos que o Batman aguenta\n dar no maximo 1000 passos");
	}

	private void percorrer(ArrayList<String> lsPercurso) throws Exception {
		ArrayList<Integer> lsPos = procurarBatman();
		percorrerLabirinto(lsPos,lsPercurso);
	}

	private void percorrerLabirinto(ArrayList<Integer> lsPos, ArrayList<String> lsPercurso) throws Exception {
		for (int p = 0; p < lsPercurso.size(); p++) {
			System.out.println(lsPercurso.get(p) + "()");
			if("S".equalsIgnoreCase(lsPercurso.get(p)))
					lsPos = verificarSul(lsPos);
			else if("N".equalsIgnoreCase(lsPercurso.get(p)))
					lsPos = verificarNorte(lsPos);
			else if("W".equalsIgnoreCase(lsPercurso.get(p)))
					lsPos = verificarOeste(lsPos);
			else if("E".equalsIgnoreCase(lsPercurso.get(p)))
					lsPos = verificarLeste(lsPos);
			else
				throw new Exception("Nao conseguimos entender qual lado o Batman deve andar...\n" +
						"Verifique se o direcionamento " + lsPercurso.get(p) + " esta correto na posicao.");
		}
	}

	private ArrayList<Integer> verificarLeste(ArrayList<Integer> lsPos) throws Exception {
		try{
			if("#".equals(matrizMaze.get(lsPos.get(0)).get(lsPos.get(1)+1)))
				throw new Exception("O Batman bateu em uma parede");
			else{
				lsPos.set(1, lsPos.get(1)+1);
				verificarChegada(lsPos);
				registrarPercurso(lsPos);
				return lsPos;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			throw new ArrayIndexOutOfBoundsException("Voce fez o Batman fugir de cena!");
		}
	}

	private ArrayList<Integer> verificarOeste(ArrayList<Integer> lsPos) throws Exception {
		try{
			if("#".equals(matrizMaze.get(lsPos.get(0)).get(lsPos.get(1)-1)))
				throw new Exception("O Batman bateu em uma parede");
			else{
				lsPos.set(1, lsPos.get(1)-1);
				verificarChegada(lsPos);
				registrarPercurso(lsPos);
				return lsPos;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			throw new ArrayIndexOutOfBoundsException("Voce fez o Batman fugir de cena!");
		}
	}

	private ArrayList<Integer> verificarNorte(ArrayList<Integer> lsPos) throws Exception {
		try{
			if("#".equals(matrizMaze.get(lsPos.get(0)-1).get(lsPos.get(1))))
				throw new Exception("O Batman bateu em uma parede");
			else{
				lsPos.set(0, lsPos.get(0)-1);
				verificarChegada(lsPos);
				registrarPercurso(lsPos);
				return lsPos;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			throw new ArrayIndexOutOfBoundsException("Voce fez o Batman fugir de cena!");
		}
	}

	private ArrayList<Integer> verificarSul(ArrayList<Integer> lsPos) throws Exception {
		try{
			if("#".equals(matrizMaze.get(lsPos.get(0)+1).get(lsPos.get(1)))){
				BatmanLabirintoDAO dao = new BatmanLabirintoDAOImpl();
				dao.escreverPercurso(matrizMaze);
				throw new Exception("O Batman bateu em uma parede");
			}
			else{
				lsPos.set(0, lsPos.get(0)+1);
				verificarChegada(lsPos);
				registrarPercurso(lsPos);
				return lsPos;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			throw new ArrayIndexOutOfBoundsException("Voce fez o Batman fugir de cena!");
		}
	}

	private void verificarChegada(ArrayList<Integer> lsPos) throws Exception {
		System.out.println(matrizMaze.get(lsPos.get(0)).get(lsPos.get(1)));
		if("O".equalsIgnoreCase(matrizMaze.get(lsPos.get(0)).get(lsPos.get(1)))){
			BatmanLabirintoDAO dao = new BatmanLabirintoDAOImpl();
			dao.escreverPercurso(matrizMaze);
			apresentarConsole();
			throw new Exception("Parabens! O Batman pode salvar o dia gracas a voce!");
		}		
	}

	private void apresentarConsole() {
		for (int i = 0; i < matrizMaze.size(); i++) {
			System.out.println(matrizMaze.get(i));
		}
	}

	private void registrarPercurso(ArrayList<Integer> lsPos) throws Exception {
		matrizMaze.get(lsPos.get(0)).set(lsPos.get(1), substituirValor(lsPos));
	}

	private String substituirValor(ArrayList<Integer> lsPos) throws Exception {
		String valorString = matrizMaze.get(lsPos.get(0)).get(lsPos.get(1));
		int valorInt = 0;
		
		if(" ".equals(valorString) || "B".equals(valorString))
			return "1";
		else if ("O".equals(valorString)){
			verificarChegada(lsPos);
			return "1";
		}
		else{
			valorInt = Integer.parseInt(valorString);
			valorInt++;
			return String.valueOf(valorInt);
		}
		//throw new Exception("Ouve um erro no acrescimo de valores ao passar por um determinado local");
	}

	private ArrayList<Integer> procurarBatman() throws Exception {
		for (int i = 0; i < matrizMaze.get(0).size(); i++) {
			for (int j = 0; j < matrizMaze.size(); j++) {
				if("B".equals(matrizMaze.get(j).get(i))){
					ArrayList<Integer> lsPos = new ArrayList<Integer>();
					lsPos.add(j); //linha
					lsPos.add(i); //coluna
					return lsPos;
				}
			}
		}
		throw new Exception("Nao encontramos o Batman para continuar o jogo");
	}

	private ArrayList<String> adquirirPercurso(String percurso) {
		return new ArrayList<String>(Arrays.asList(percurso.split("")));
	}

	public void escreverResultado() throws IOException {
		BatmanLabirintoDAO dao = new BatmanLabirintoDAOImpl();
		dao.escreverPercurso(matrizMaze);
	}

}
