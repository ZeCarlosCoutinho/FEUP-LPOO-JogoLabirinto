package maze.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import maze.logic.*;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicationWindow {

	private JFrame frmJogoDoLabirinto;
	private JTextField tamanhoTab;
	private JLabel lblNmeroDeDrages;
	private JTextField nrDragoes;
	private JLabel lblTipoDeDrages;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
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
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJogoDoLabirinto = new JFrame();
		frmJogoDoLabirinto.setTitle("Jogo do labirinto");
		frmJogoDoLabirinto.setBounds(100, 100, 480, 361);
		frmJogoDoLabirinto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJogoDoLabirinto.getContentPane().setLayout(null);
		
		JLabel lblDimensoDoLabirinto = new JLabel("Dimensão do labirinto");
		lblDimensoDoLabirinto.setBounds(18, 24, 145, 14);
		frmJogoDoLabirinto.getContentPane().add(lblDimensoDoLabirinto);
		
		tamanhoTab = new JTextField();
		tamanhoTab.setText("11");
		tamanhoTab.setBounds(164, 18, 65, 26);
		frmJogoDoLabirinto.getContentPane().add(tamanhoTab);
		tamanhoTab.setColumns(10);
		
		lblNmeroDeDrages = new JLabel("Número de dragões");
		lblNmeroDeDrages.setBounds(18, 48, 145, 14);
		frmJogoDoLabirinto.getContentPane().add(lblNmeroDeDrages);
		
		nrDragoes = new JTextField();
		nrDragoes.setText("1");
		nrDragoes.setColumns(10);
		nrDragoes.setBounds(164, 42, 65, 26);
		frmJogoDoLabirinto.getContentPane().add(nrDragoes);
		
		lblTipoDeDrages = new JLabel("Tipo de dragões");
		lblTipoDeDrages.setBounds(18, 74, 145, 14);
		frmJogoDoLabirinto.getContentPane().add(lblTipoDeDrages);
		
		JComboBox modosJogo = new JComboBox();
		modosJogo.setModel(new DefaultComboBoxModel(new String[] {"Estáticos", "Móveis", "Móveis/Dorminhocos"}));
		modosJogo.setSelectedIndex(0);
		modosJogo.setBounds(163, 69, 111, 27);
		frmJogoDoLabirinto.getContentPane().add(modosJogo);
		
		
		JButton btnTerminarPrograma = new JButton("Terminar programa");
		btnTerminarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnTerminarPrograma.setBounds(306, 61, 156, 35);
		frmJogoDoLabirinto.getContentPane().add(btnTerminarPrograma);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(16, 109, 247, 185);
		frmJogoDoLabirinto.getContentPane().add(textArea);
		
		JButton btnCima = new JButton("Cima");
		btnCima.setEnabled(false);
		btnCima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCima.setBounds(339, 141, 76, 35);
		frmJogoDoLabirinto.getContentPane().add(btnCima);
		
		JButton btnBaixo = new JButton("Baixo");
		btnBaixo.setEnabled(false);
		btnBaixo.setBounds(339, 218, 76, 35);
		frmJogoDoLabirinto.getContentPane().add(btnBaixo);
		
		JButton btnEsquerda = new JButton("Esquerda");
		btnEsquerda.setEnabled(false);
		btnEsquerda.setBounds(286, 180, 86, 35);
		frmJogoDoLabirinto.getContentPane().add(btnEsquerda);
		
		JButton btnDireita = new JButton("Direita");
		btnDireita.setEnabled(false);
		btnDireita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDireita.setBounds(376, 180, 86, 35);
		frmJogoDoLabirinto.getContentPane().add(btnDireita);
		
		JButton btnNewButton = new JButton("Gerar novo labirinto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDireita.setEnabled(true);
				btnEsquerda.setEnabled(true);
				btnCima.setEnabled(true);
				btnBaixo.setEnabled(true);
			}
		});
		btnNewButton.setBounds(306, 18, 156, 35);
		frmJogoDoLabirinto.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Pode gerar novo labirinto!");
		lblNewLabel.setBounds(18, 306, 239, 16);
		frmJogoDoLabirinto.getContentPane().add(lblNewLabel);
	}
}
