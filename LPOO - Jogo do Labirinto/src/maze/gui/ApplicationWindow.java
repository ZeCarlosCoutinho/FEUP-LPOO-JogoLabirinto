package maze.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import maze.logic.Tabuleiro;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicationWindow {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNmeroDeDrages;
	private JTextField textField_1;
	private JLabel lblTipoDeDrages;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDimensoDoLabirinto = new JLabel("Dimensão do labirinto");
		lblDimensoDoLabirinto.setBounds(18, 24, 145, 14);
		frame.getContentPane().add(lblDimensoDoLabirinto);
		
		textField = new JTextField();
		textField.setText("11");
		textField.setBounds(164, 18, 65, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNmeroDeDrages = new JLabel("Número de dragões");
		lblNmeroDeDrages.setBounds(18, 48, 145, 14);
		frame.getContentPane().add(lblNmeroDeDrages);
		
		textField_1 = new JTextField();
		textField_1.setText("1");
		textField_1.setColumns(10);
		textField_1.setBounds(164, 42, 65, 26);
		frame.getContentPane().add(textField_1);
		
		lblTipoDeDrages = new JLabel("Tipo de dragões");
		lblTipoDeDrages.setBounds(18, 74, 145, 14);
		frame.getContentPane().add(lblTipoDeDrages);
		
		JComboBox modosJogo = new JComboBox();
		modosJogo.setModel(new DefaultComboBoxModel(new String[] {"Estáticos", "Móveis", "Móveis/Dorminhocos"}));
		modosJogo.setSelectedIndex(0);
		modosJogo.setBounds(163, 69, 111, 27);
		frame.getContentPane().add(modosJogo);
		
		JButton btnNewButton = new JButton("Gerar novo labirinto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(306, 18, 156, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnTerminarPrograma = new JButton("Terminar programa");
		btnTerminarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnTerminarPrograma.setBounds(306, 61, 156, 35);
		frame.getContentPane().add(btnTerminarPrograma);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(16, 109, 247, 185);
		frame.getContentPane().add(textArea);
		
		JButton btnCima = new JButton("Cima");
		btnCima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCima.setBounds(339, 141, 76, 35);
		frame.getContentPane().add(btnCima);
		
		JButton btnBaixo = new JButton("Baixo");
		btnBaixo.setBounds(339, 218, 76, 35);
		frame.getContentPane().add(btnBaixo);
		
		JButton btnEsquerda = new JButton("Esquerda");
		btnEsquerda.setBounds(286, 180, 86, 35);
		frame.getContentPane().add(btnEsquerda);
		
		JButton btnDireita = new JButton("Direita");
		btnDireita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDireita.setBounds(376, 180, 86, 35);
		frame.getContentPane().add(btnDireita);
		
		JLabel lblNewLabel = new JLabel("Pode gerar novo labirinto!");
		lblNewLabel.setBounds(26, 306, 239, 16);
		frame.getContentPane().add(lblNewLabel);
	}
}
