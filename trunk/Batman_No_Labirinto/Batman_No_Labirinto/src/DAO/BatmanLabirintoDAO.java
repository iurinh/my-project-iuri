package DAO;

import java.io.IOException;
import java.util.ArrayList;

public interface BatmanLabirintoDAO {
	public ArrayList<ArrayList<String>> adquirirMaze() throws IOException ;

	public void escreverPercurso(ArrayList<ArrayList<String>> matrizMaze) throws IOException ;
}
