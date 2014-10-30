package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BatmanLabirintoDAOImpl implements BatmanLabirintoDAO{

	private String PERCURSO_MAZE = "./labirintos/maze.txt";
	private String ENDERECO_RESULTADO = "./labirintos/resultado.txt";
	
	@Override
	public ArrayList<ArrayList<String>> adquirirMaze() throws IOException {
		ArrayList<String> lsMaze = lerArquivo();
		
		return adquirirMatriz(lsMaze);
	}

	private ArrayList<ArrayList<String>> adquirirMatriz(ArrayList<String> lsMaze) {
		ArrayList<ArrayList<String>> matrizMaze = new ArrayList<ArrayList<String>>();
		
		for (int i = 0; i < lsMaze.size(); i++) {
			matrizMaze.add(new ArrayList<String>(Arrays.asList(lsMaze.get(i).split(""))));
		}
		
		return matrizMaze;
	}

	private ArrayList<String> lerArquivo() throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(PERCURSO_MAZE)));
			ArrayList<String> ls = new ArrayList<String>();
			
			while(br.ready()){
				ls.add(br.readLine());
			}
			
			return ls;
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Nao foi possivel encontrar o seguinte arquivo:\n\n" + PERCURSO_MAZE);
		} catch (IOException e) {
			throw new IOException("Ocorreu algum erro ao tentar fazer a leitura do seguinte arquivo:\n\n" + PERCURSO_MAZE);
		}
	}

	@Override
	public void escreverPercurso(ArrayList<ArrayList<String>> matrizMaze) throws IOException {
		
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(ENDERECO_RESULTADO)));

			for (int i = 0; i < matrizMaze.size(); i++) {
				bw.write(matrizMaze.get(i).toString());
				bw.newLine();
			}
			
			bw.close();
			
		}catch(IOException e){
			throw new IOException("Ocorreu um erro ao escrever o percurso do Batman num arquivo:\n" + ENDERECO_RESULTADO);
		}
	}

}
