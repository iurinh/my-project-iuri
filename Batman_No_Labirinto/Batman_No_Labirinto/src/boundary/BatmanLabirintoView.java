package boundary;

import java.io.IOException;

import javax.swing.JOptionPane;

import control.BatmanLabirintoControl;

public class BatmanLabirintoView {

	private String APRESENTACAO = "Esse é o jogo do Labirinto do Batman" +
			"\nEsperamos que se divirta!";
	
	private String SOLICITACAO_PERCURSO = "Digite:\n" +
			"S -> Andar para o Sul\n" +
			"N -> Andar para o Norte\n" +
			"W -> Andar para o Oeste\n" +
			"E -> Andar para o Leste;\n\n" +
			"Lembre-se: seu percurso deve estar entre 1 e 1000 passos.\n\n" +
			"Boa sorte!";
	
	public BatmanLabirintoView() {
		run();
	}

	public void run(){
		JOptionPane.showMessageDialog(null, APRESENTACAO);
		String percurso = solicitarPercurso();

		BatmanLabirintoControl ctrl = new BatmanLabirintoControl();
		
		try {
			ctrl.executarJogada(percurso);
			ctrl.escreverResultado();
		} catch (Exception e) {
			try {
				ctrl.escreverResultado();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, e.getMessage() + "Erro para escrever o percurso do Batman.");
			}
			JOptionPane.showMessageDialog(null, e.getMessage() + "\n\n Verifique o percurso em:\n"
					+ "./labirintos/resultado.txt...\n\n GAME OVER!");
		}
	}
	
	private String solicitarPercurso() {
		return JOptionPane.showInputDialog(SOLICITACAO_PERCURSO);
	}
}
