package maze.gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controlo {
	static CardLayout cardLayout;
	static JFrame janela = new JFrame();
	static JPanel card = new JPanel();
	static MenuInicial menu1 = new MenuInicial(); //Temporario
	
	public static void main(String[] args)
	{
		card.setLayout(cardLayout = new CardLayout());
		card.add("menu1", menu1);
		
		cardLayout.show(card, "menu1");
		
		janela.getContentPane().add(card);
		
		janela.setVisible(true);
		janela.setResizable(true);
		janela.setSize(180, 253);
		janela.setLocation(230,180);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	 
	}
	
	public static void showPanel(String painel, int dimx, int dimy){
		cardLayout.show(card, painel);
		janela.setSize(dimx, dimy);
		/*
		if(painel == "gamePanel")
			gamePanel.setToPanelFocus();
			*/
	}
}
