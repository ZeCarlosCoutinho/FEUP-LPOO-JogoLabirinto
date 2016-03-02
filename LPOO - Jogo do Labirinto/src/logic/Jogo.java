package logic;
import java.util.Random; //Ainda não se usa, mas servirá para mover random o Dragao

public class Jogo {

	private Labirinto tab;
	private boolean game_over;
	private boolean win;
	private Random generator;
	
	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public Labirinto getTab() {
		return tab;
	}

	public void setTab(Labirinto tab) {
		this.tab = tab;
	}

	public boolean isGame_over() {
		return game_over;
	}

	public void setGame_over(boolean game_over) {
		this.game_over = game_over;
	}

	public Jogo()
	{
		tab = new Labirinto();
		game_over = false;
		win = false;
		generator = new Random();
	}
	
	public void turno(char direcao)//direcao é fornecida pela interface com o jogador
	{	
		int direcao_int = direcao_chartoint(direcao); //Converte direcao para um int
		
		//Move o Heroi
		tab.move_SerAnimado(tab.getHero(), direcao_int);
		
		//Move o Dragao
		tab.move_SerAnimado(tab.getDragon(), generator.nextInt(4));
		
		if(tab.getExit().getPorcima() == tab.getHero()) //Se o heroi estiver na saida depois de matar o dragao
		{
			setGame_over(true);
			setWin(true);
			return;
		}
		if(!(tab.getHero().isAlive())) //Se o heroi estiver morto
		{
			setGame_over(true);
			setWin(false);
			return;
		}
		return;
	}
	
	
	public int direcao_chartoint(char direcao)
	{
		direcao = Character.toLowerCase(direcao);
		switch(direcao)
		{
		case 'w':
			return 0;
		case 'd':
			return 1;
		case 's':
			return 2;
		case 'a':
			return 3;
		default:
			return 4; //PODE SER NECESSÁRIO UM THROW
		}
	}
}
