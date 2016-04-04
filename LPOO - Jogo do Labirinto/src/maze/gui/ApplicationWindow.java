package maze.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import exceptions.TooManyDragonsException;
import maze.logic.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ApplicationWindow {

	private JFrame frmJogoDoLabirinto;
	private JTextField tamanhoTab;
	private JLabel lblNmeroDeDrages;
	private JTextField nrDragoes;
	private JLabel lblTipoDeDrages;
	private JButton btnStartGame;
	private JLabel info;
	private JButton btnCima;
	private JButton btnBaixo;
	private JButton btnEsquerda;
	private JButton btnDireita;
	private JButton btnGerarLabirinto;
	private GPanel panel;

	Jogo jogar = new Jogo();
	Labirinto lab = new Labirinto();

	private char UP = 'w', RIGHT = 'd', LEFT = 'a', DOWN = 's';

	public void click(char direction) {
		jogar.turno(direction);
		atualizaEtiqueta();
	}

	public void atualizaEtiqueta() {

		if (jogar.isWin()) {
			info.setText("PARABÉNS! Fim do jogo. Pode gerar novo labirinto.");
			btnCima.setEnabled(false);
			btnBaixo.setEnabled(false);
			btnDireita.setEnabled(false);
			btnEsquerda.setEnabled(false);
			btnGerarLabirinto.setEnabled(true);
			btnStartGame.setEnabled(true);
		} else if (jogar.isGameOver()) {
			info.setText("Perdeu... Tente outra vez! Pode gerar novo labirinto.");
			btnCima.setEnabled(false);
			btnBaixo.setEnabled(false);
			btnDireita.setEnabled(false);
			btnEsquerda.setEnabled(false);
			btnGerarLabirinto.setEnabled(true);
			btnStartGame.setEnabled(true);
		}
	}

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
		frmJogoDoLabirinto.setBounds(100, 100, 900, 800);
		frmJogoDoLabirinto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJogoDoLabirinto.getContentPane().setLayout(null);

		JLabel lblDimensoDoLabirinto = new JLabel("Dimensão do labirinto");
		lblDimensoDoLabirinto.setBounds(34, 24, 145, 14);
		frmJogoDoLabirinto.getContentPane().add(lblDimensoDoLabirinto);

		tamanhoTab = new JTextField();
		tamanhoTab.setText("11");
		tamanhoTab.setBounds(180, 18, 65, 26);
		frmJogoDoLabirinto.getContentPane().add(tamanhoTab);
		tamanhoTab.setColumns(10);

		lblNmeroDeDrages = new JLabel("Número de dragões");
		lblNmeroDeDrages.setBounds(34, 48, 145, 14);
		frmJogoDoLabirinto.getContentPane().add(lblNmeroDeDrages);

		nrDragoes = new JTextField();
		nrDragoes.setText("1");
		nrDragoes.setColumns(10);
		nrDragoes.setBounds(180, 42, 65, 26);
		frmJogoDoLabirinto.getContentPane().add(nrDragoes);

		lblTipoDeDrages = new JLabel("Tipo de dragões");
		lblTipoDeDrages.setBounds(34, 74, 145, 14);
		frmJogoDoLabirinto.getContentPane().add(lblTipoDeDrages);

		JComboBox modosJogo = new JComboBox();
		modosJogo.setModel(
				new DefaultComboBoxModel(new String[] { "Estáticos", "Aleatórios", "Aleatórios e a dormir" }));
		modosJogo.setSelectedIndex(0);
		modosJogo.setBounds(179, 69, 107, 27);
		frmJogoDoLabirinto.getContentPane().add(modosJogo);

		JButton btnTerminarPrograma = new JButton("Terminar programa");
		btnTerminarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnTerminarPrograma.setBounds(717, 61, 156, 35);
		frmJogoDoLabirinto.getContentPane().add(btnTerminarPrograma);

		/*
		 * textArea = new JTextArea(); textArea.setEditable(false);
		 * textArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		 * textArea.setBounds(34, 117, 631, 593); textArea.setColumns(20);
		 * frmJogoDoLabirinto.getContentPane().add(textArea);
		 */

		btnCima = new JButton("Cima");
		btnCima.setEnabled(false);
		btnCima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(UP);
			}
		});
		btnCima.setBounds(750, 347, 76, 35);
		frmJogoDoLabirinto.getContentPane().add(btnCima);

		btnBaixo = new JButton("Baixo");
		btnBaixo.setEnabled(false);
		btnBaixo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				click(DOWN);
			}
		});
		btnBaixo.setBounds(750, 419, 76, 35);
		frmJogoDoLabirinto.getContentPane().add(btnBaixo);

		btnEsquerda = new JButton("Esquerda");
		btnEsquerda.setEnabled(false);
		btnEsquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(LEFT);
			}
		});
		btnEsquerda.setBounds(700, 383, 86, 35);
		frmJogoDoLabirinto.getContentPane().add(btnEsquerda);

		btnDireita = new JButton("Direita");
		btnDireita.setEnabled(false);
		btnDireita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(RIGHT);
			}
		});
		btnDireita.setBounds(787, 383, 86, 35);
		frmJogoDoLabirinto.getContentPane().add(btnDireita);

		btnGerarLabirinto = new JButton("Gerar novo labirinto");
		btnGerarLabirinto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int nDragoes;
				int dimensao;

				try {
					nDragoes = Integer.parseInt(nrDragoes.getText());

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frmJogoDoLabirinto, "Número de dragões inválido!");
					return;
				}

				try {
					dimensao = Integer.parseInt(tamanhoTab.getText());
					if (dimensao > 39) {
						JOptionPane.showMessageDialog(frmJogoDoLabirinto,
								"Dimensão inválida!\nInserir dimensão menor que 40.");
						return;
					} else if (dimensao % 2 == 0) {
						dimensao++;
						JOptionPane.showMessageDialog(frmJogoDoLabirinto,
								"Dimensão par!\nGerou labirinto com dimensão " + dimensao + ".");
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frmJogoDoLabirinto, "Dimensão inválida!");
					return;
				}

				if (panel == null)
					panel = new GPanel();

				panel.setBounds(34, 117, 631, 593);
				frmJogoDoLabirinto.getContentPane().add(panel);

				panel.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						panel.requestFocus();
					}
				});

				panel.setVisible(true);
				panel.requestFocus();
				panel.repaint();

				int gameMode = modosJogo.getSelectedIndex();
				jogar.setGameMode(gameMode);

				try {
					jogar.criaLabirintoAleatorio(dimensao, nDragoes);
				} catch (TooManyDragonsException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frmJogoDoLabirinto, "Número de dragões inválido!");
					return;
				}

				panel.setLabirinto(jogar.getLab());
				btnStartGame.setEnabled(true);
			}
		});
		btnGerarLabirinto.setBounds(717, 18, 156, 35);
		frmJogoDoLabirinto.getContentPane().add(btnGerarLabirinto);

		btnStartGame = new JButton("Come\u00E7ar Jogo");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCima.setEnabled(true);
				btnBaixo.setEnabled(true);
				btnDireita.setEnabled(true);
				btnEsquerda.setEnabled(true);
				btnGerarLabirinto.setEnabled(false);
				info.setText("Pode mover o herói... ");
				btnStartGame.setEnabled(false);

				panel.addKeyListener(new KeyListener() {

					@Override
					public void keyTyped(KeyEvent e) {

					}

					@Override
					public void keyPressed(KeyEvent e) {
						switch (e.getKeyCode()) {
						case KeyEvent.VK_LEFT:
							click(LEFT);
							break;

						case KeyEvent.VK_RIGHT:
							click(RIGHT);
							break;

						case KeyEvent.VK_UP:
							click(UP);
							break;

						case KeyEvent.VK_DOWN:
							click(DOWN);
							break;
						default:
							break;
						}

						if (jogar.isWin() || jogar.isGameOver())
							panel.removeKeyListener(this);
					}

					@Override
					public void keyReleased(KeyEvent e) {

					}
				});
			}
		});
		btnStartGame.setEnabled(false);
		btnStartGame.setBounds(717, 107, 156, 35);
		frmJogoDoLabirinto.getContentPane().add(btnStartGame);

		info = new JLabel("Pode gerar novo labirinto!");
		info.setBounds(37, 722, 489, 14);
		frmJogoDoLabirinto.getContentPane().add(info);
	}
}
