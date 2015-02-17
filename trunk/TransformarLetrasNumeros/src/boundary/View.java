package boundary;

import javax.swing.JOptionPane;

import control.Controle;

public class View {

	public static void main(String[] args) {
		new View();
	}

	public View() {
		String palavrinha = JOptionPane.showInputDialog(null, "Escreva uma frase... AGORA!!!!");
		Controle ctrl = new Controle();
		System.out.println(ctrl.trocarLetraNumeros(palavrinha));
	}
}
