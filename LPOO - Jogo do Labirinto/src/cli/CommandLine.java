package cli;
import java.util.Scanner;

import logic.Jogo;
import logic.Tabuleiro;

public class CommandLine {
	Scanner scan = new Scanner(System.in);
	Jogo jogar;
	
	//construtor
	public CommandLine(Jogo jogar){
		this.jogar = jogar;
	}
	
	public CommandLine (){
		
	}
	public void display(Tabuleiro tab)
	{
		for(int j = 0; j < tab.getTamy(); j++)
		{
			for(int i = 0; i < tab.getTamx(); i++)
			{
				System.out.print(tab.getChar(i, j)+ " ");
			}
			
			System.out.print("\n");
		}
	}
	
	public char pede_movimentacao()
	{
		System.out.println("Para onde gostaria de mover o herói? (w,a,s,d) ");
		
		return scan.next().charAt(0);
	}
	
	public int pede_modo_jogo()
	{
		System.out.println("Qual o modo de jogo que deseja?");
		System.out.println("Modo 0 - Dragão Estático");
		System.out.println("Modo 1 - Dragão que se move");
		System.out.println("Modo 2 - Dragão Dorminhoco");
		
		return scan.nextInt();
	}
	
	public void heroi_matou_dragao()
	{
		System.out.println("MATASTE O DRAGÃO, SEU BANDIDOLA!");
		return;
	}

	public void fim_jogo(){
		if(jogar.isWin())
			System.out.println("GANHASTE!!!!");
		else
			System.out.println("PERDESTE. NOOB!");
	}
}
