import java.util.Scanner;
import java.lang.Character;

public class Jogo {

	private Scanner scan;
	private Labirinto tab;
	public Jogo()
	{
		scan = new Scanner(System.in);
		tab = new Labirinto();
	}
	
	public void turno()
	{
		tab.display();
		System.out.print("Em que direção quer mover o herói? (w,a,s,d)");
		
		char direcao = Character.toLowerCase(scan.next().charAt(0));		//recebe a char do teclado
		
		switch(direcao) //Ação consoante o input
		{
		case 'w':
			if(tab.verifica_casa_heroi(tab.retorna_casa(tab.getHero().getPosx(), tab.getHero().getPosy()-1)))
				tab.getHero().move_heroi('w');
			break;
		case 'a':
			if(tab.verifica_casa_heroi(tab.retorna_casa(tab.getHero().getPosx()-1, tab.getHero().getPosy())))
				tab.getHero().move_heroi('a');
			break;
		case 's':
			if(tab.verifica_casa_heroi(tab.retorna_casa(tab.getHero().getPosx(), tab.getHero().getPosy()+1)))
				tab.getHero().move_heroi('s');
			break;
		case 'd':
			if(tab.verifica_casa_heroi(tab.retorna_casa(tab.getHero().getPosx()+1, tab.getHero().getPosy())))
				tab.getHero().move_heroi('d');
			break;
		}
		
		System.out.print("\n");
		
		return;
	}
	
	public void jogar()
	{
		while(!(tab.getHero().isMorto()) && !(tab.getExit().isChegou_heroi()))
			turno();
		if(tab.getHero().isMorto())
			System.out.println("TAS MORTO. NOOB \n");
		else if(tab.getExit().isChegou_heroi())
			System.out.println("GANHASTE!! HURRAY");
		else
			System.out.println("Oops, erro");
		return;
	}
}
