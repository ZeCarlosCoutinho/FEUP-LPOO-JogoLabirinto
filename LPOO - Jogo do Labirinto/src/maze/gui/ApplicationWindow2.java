package maze.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ApplicationWindow2 {

	private JFrame frmJogoDoLabirinto;
	private JTextField txtEscolhaAsDefinies;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow2 window = new ApplicationWindow2();
					window.frmJogoDoLabirinto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJogoDoLabirinto = new JFrame();
		frmJogoDoLabirinto.setTitle("Jogo do labirinto");
		frmJogoDoLabirinto.setBounds(100, 100, 464, 307);
		frmJogoDoLabirinto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJogoDoLabirinto.getContentPane().setLayout(null);
		
		JLabel lblTamanhoTabuleiro = new JLabel("Tamanho do tabuleiro:");
		lblTamanhoTabuleiro.setBounds(19, 66, 145, 14);
		frmJogoDoLabirinto.getContentPane().add(lblTamanhoTabuleiro);
		
		txtEscolhaAsDefinies = new JTextField();
		txtEscolhaAsDefinies.setBackground(Color.LIGHT_GRAY);
		txtEscolhaAsDefinies.setFont(new Font("Diavlo Bold", Font.PLAIN, 16));
		txtEscolhaAsDefinies.setEditable(false);
		txtEscolhaAsDefinies.setText("Escolha as defini\u00E7\u00F5es de jogo:");
		txtEscolhaAsDefinies.setBounds(10, 11, 248, 28);
		frmJogoDoLabirinto.getContentPane().add(txtEscolhaAsDefinies);
		txtEscolhaAsDefinies.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(11, 7, 99, 2));
		spinner.setBounds(172, 63, 39, 20);
		frmJogoDoLabirinto.getContentPane().add(spinner);
		
		JLabel lblNmeroDrages = new JLabel("Número dragões:");
		lblNmeroDrages.setBounds(19, 105, 118, 14);
		frmJogoDoLabirinto.getContentPane().add(lblNmeroDrages);
		
		JLabel lblModoDeJogo = new JLabel("Modo de jogo:");
		lblModoDeJogo.setBounds(19, 149, 118, 14);
		frmJogoDoLabirinto.getContentPane().add(lblModoDeJogo);
	}
}
