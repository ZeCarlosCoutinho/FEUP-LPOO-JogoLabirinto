import java.util.Scanner;
import java.lang.*;

public class Jogo {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Labirinto tab = new Labirinto();
		
		tab.display();
		return;
	}
	
	public void turno(Scanner scan)
	{
		System.out.print("Em que direção quer mover o herói? (w,a,s,d)");
		
		char direcao = Character.toLowerCase(scan.next().charAt(0));		//recebe a char do teclado
		
		switch(direcao) //Ação consoante o input
		{
		case 'w': //POR COMPLETAR
			break;
		}
		return;
	}
}
