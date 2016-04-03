package maze.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

public class MenuInicial extends JPanel{

	private JFrame frmJogoDoLabirinto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial window = new MenuInicial();
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
	public MenuInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJogoDoLabirinto = new JFrame();
		frmJogoDoLabirinto.setTitle("Jogo do labirinto");
		frmJogoDoLabirinto.setBounds(100, 100, 339, 203);
		frmJogoDoLabirinto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJogoDoLabirinto.getContentPane().setLayout(null);
		
		JTextPane txtpnAsd = new JTextPane();
		txtpnAsd.setBackground(Color.ORANGE);
		txtpnAsd.setFont(new Font("Diavlo Black", Font.PLAIN, 30));
		txtpnAsd.setText("Bem vindo ao Jogo do Labirinto");
		txtpnAsd.setBounds(10, 11, 291, 77);
		frmJogoDoLabirinto.getContentPane().add(txtpnAsd);
		
		JButton btnComear = new JButton("Come\u00E7ar");
		btnComear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnComear.setBackground(Color.BLACK);
		btnComear.setForeground(Color.RED);
		btnComear.setFont(new Font("Diavlo Book", Font.PLAIN, 14));
		btnComear.setBounds(93, 99, 128, 54);
		frmJogoDoLabirinto.getContentPane().add(btnComear);
		frmJogoDoLabirinto.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtpnAsd, btnComear}));
	}
}
