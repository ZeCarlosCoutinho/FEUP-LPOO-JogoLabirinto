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
	
	public int pedeMazeAleatorio()
	{
		System.out.println("Qual o tamanho do labirinto?");
		
		int tamanho = scan.nextInt();
		
		if(tamanho < 7)
		{
			clearConsole();
			System.out.println("Tamanho inválido. Tente novamente.");
			return pedeMazeAleatorio();
		}
		if(tamanho > 100)
		{
			clearConsole();
			System.out.println("Tamanho demasiado grande. Tente novamente.");
			return pedeMazeAleatorio();
		}
		return tamanho;
	}
	
	public int pedeNumDragoes()
	{
		System.out.println("Qual o número de dragões?");
		int numero = scan.nextInt();
		
		if(numero < 1)
		{
			clearConsole();
			System.out.println("Número de dragões inválido. Tente novamente");
			return pedeNumDragoes();
		}
		
		return numero;
	}
	public void instrucoes(){
		System.out.println("\nPara mover o herói utilize as teclas w, a, s, d.\nPode mover o herói?");
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
	
	public void demasiadosDragoesException()
	{
		System.out.println("Demasiados dragões");
		System.out.println("TERMINANDO O PROGRAMA...");
		return;
	}
}
