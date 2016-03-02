package cli;
import java.util.Scanner;

import logic.Tabuleiro;

public class CommandLine {
	Scanner scan = new Scanner(System.in);
	
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
}
