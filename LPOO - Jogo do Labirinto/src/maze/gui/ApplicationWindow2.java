package maze.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exceptions.TooManyDragonsException;
import maze.cli.CommandLine;
import maze.logic.*;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JSlider;
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
		
		JLabel lblTamanhoTabuleiro = new JLabel("Tamanho do Tabuleiro:");
		lblTamanhoTabuleiro.setBounds(10, 66, 118, 14);
		frmJogoDoLabirinto.getContentPane().add(lblTamanhoTabuleiro);
		
		txtEscolhaAsDefinies = new JTextField();
		txtEscolhaAsDefinies.setBackground(Color.LIGHT_GRAY);
		txtEscolhaAsDefinies.setFont(new Font("Diavlo Bold", Font.PLAIN, 16));
		txtEscolhaAsDefinies.setEditable(false);
		txtEscolhaAsDefinies.setText("Escolha as defini\u00E7\u00F5es de jogo:");
		txtEscolhaAsDefinies.setBounds(10, 11, 229, 28);
		frmJogoDoLabirinto.getContentPane().add(txtEscolhaAsDefinies);
		txtEscolhaAsDefinies.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(11, 7, 99, 2));
		spinner.setBounds(123, 63, 39, 20);
		frmJogoDoLabirinto.getContentPane().add(spinner);
		
		JLabel lblNmeroDrages = new JLabel("N\u00FAmero Drag\u00F5es:");
		lblNmeroDrages.setBounds(10, 105, 105, 14);
		frmJogoDoLabirinto.getContentPane().add(lblNmeroDrages);
		
		JSlider slider = new JSlider();
		slider.setFont(new Font("Tahoma", Font.PLAIN, 8));
		slider.setMajorTickSpacing(2);
		slider.setPaintLabels(true);
		slider.setToolTipText("");
		slider.setMinorTickSpacing(1);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMinimum(1);
		slider.setBounds(10, 127, 428, 36);
		frmJogoDoLabirinto.getContentPane().add(slider);
	}
}
