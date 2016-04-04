package maze.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

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
		
		JButton btnComear = new JButton("Come\u00E7ar");
		btnComear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnComear.setBackground(Color.BLACK);
		btnComear.setForeground(Color.RED);
		btnComear.setFont(new Font("Diavlo Book", Font.PLAIN, 14));
		btnComear.setBounds(107, 97, 128, 54);
		frmJogoDoLabirinto.getContentPane().add(btnComear);
		
		JLabel lblBemvindoAoJogo = new JLabel("Bem-vindo ao Jogo do labirinto");
		lblBemvindoAoJogo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblBemvindoAoJogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemvindoAoJogo.setBounds(17, 28, 305, 62);
		frmJogoDoLabirinto.getContentPane().add(lblBemvindoAoJogo);
	}
}
