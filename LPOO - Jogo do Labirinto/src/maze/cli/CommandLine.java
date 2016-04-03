package maze.cli;

import java.util.Scanner;

import maze.logic.Jogo;
import maze.logic.Tabuleiro;

public class CommandLine {
	Scanner scan = new Scanner(System.in);
	Jogo jogar;

	// construtor
	public CommandLine(Jogo jogar) {
		this.jogar = jogar;
	}

	public CommandLine() {

	}

	public void display(Tabuleiro tab) {
		for (int j = 0; j < tab.getTamy(); j++) {
			for (int i = 0; i < tab.getTamx(); i++) {
				System.out.print(tab.getChar(i, j) + " ");
			}

			System.out.print("\n");
		}
	}

	public char pede_movimentacao() {
		//System.out.println("Para onde gostaria de mover o herói? (w,a,s,d) ");

		return scan.next().charAt(0);
	}

	public int pede_modo_jogo() {
		System.out.println("Qual o modo de jogo que deseja?");
		System.out.println("Modo 0 - Dragão Estático");
		System.out.println("Modo 1 - Dragão que se move");
		System.out.println("Modo 2 - Dragão Dorminhoco");

		int modo = scan.nextInt();
		if(modo < 0 || modo > 2)
		{
			clearConsole();
			return pede_modo_jogo();
		}
		return modo;
	}
	
	public int pede_maze_aleatorio()
	{
		System.out.println("Qual o tamanho do labirinto?");
		
		int tamanho = scan.nextInt();
		
		if(tamanho < 7)
		{
			clearConsole();
			System.out.println("Tamanho invalido. Tente novamente");
			return pede_maze_aleatorio();
		}
		if(tamanho > 100)
		{
			clearConsole();
			System.out.println("Tamanho demasiado grande. Tente novamente");
			return pede_maze_aleatorio();
		}
		return tamanho;
	}
	
	public int pede_num_dragoes()
	{
		System.out.println("Qual o numero de dragoes?");
		int numero = scan.nextInt();
		
		if(numero < 1)
		{
			clearConsole();
			System.out.println("Numero de dragoes invalido. Tente novamente");
			return pede_num_dragoes();
		}
		
		return numero;
	}
	public void instrucoes(){
		System.out.println("\nPara mover o herói utilize as teclas w, a, s, d.\nPara onde gostaria de mover o herói?");
	}

	public void heroi_matou_dragao() {
		System.out.println("MATASTE O DRAGÃO!");
		return;
	}

	public void fim_jogo() {
		if (jogar.isWin())
			System.out.println("GANHASTE!!!!");
		else
			System.out.println("PERDESTE.");
	}
	
	public void clearConsole()
	{
	    try
	    {
	    	for(int clear = 0; clear < 50; clear++) {
	    	    System.out.println("\b") ;
	    	}
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
}
