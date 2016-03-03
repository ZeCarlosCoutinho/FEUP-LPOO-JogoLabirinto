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
		System.out.println("Para onde gostaria de mover o her�i? (w,a,s,d) ");
		
		return scan.next().charAt(0);
	}
	
	public int pede_modo_jogo()
	{
		System.out.println("Qual o modo de jogo que deseja?");
		System.out.println("Modo 0 - Drag�o Est�tico");
		System.out.println("Modo 1 - Drag�o que se move");
		System.out.println("Modo 2 - Drag�o Dorminhoco");
		
		return scan.nextInt();
	}
	
	public void heroi_matou_dragao()
	{
		System.out.println("MATASTE O DRAG�O, SEU BANDIDOLA!");
		return;
	}
}
