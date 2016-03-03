package logic;
import java.util.Random; //Mover o Dragão random


public class Jogo {

	private Labirinto tab;
	private boolean game_over;
	private boolean win;
	private int game_mode; //0 - dragão parado; 1 - dragão move-se; 2- dragão adormece
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

	public int getGame_mode() {
		return game_mode;
	}

	public void setGame_mode(int game_mode) {
		if(Math.abs(game_mode) <= 2)
			this.game_mode = game_mode;
		else
			this.game_mode = 0;
	}
	
	public Jogo()
	{
		tab = new Labirinto();
		game_over = false;
		win = false;
		generator = new Random();
	}
	
	public void turno(char direcao)//direção é fornecida pela interface com o jogador
	{	
		int direcao_int = direcao_chartoint(direcao); //Converte direção para um int
		
		
		
		//Move o Heroi
		tab.move_SerAnimado(tab.getHero(), direcao_int);
		
		
		
		if(tab.getExit().getPorcima() == tab.getHero()) //Se o herói estiver na saída depois de matar o dragao
		{
			setGame_over(true);
			setWin(true);
			return;
		}
		if(!(tab.getHero().isAlive())) //Se o herói estiver morto
		{
			setGame_over(true);
			setWin(false);
			return;
		}
		
		//Move o Dragão
		if(game_mode == 1) //Modo jogo 1, simplesmente move o dragão
			tab.move_SerAnimado(tab.getDragon(), generator.nextInt(4));
		else if(game_mode == 2)
		{
			if(!modificar_estado_dragao(tab.getDragon())) //Modo jogo 2, move e pode mudá-lo de estado
			{
				if(!(tab.getDragon().isSleeping()))
					tab.move_SerAnimado(tab.getDragon(), generator.nextInt(4));
			}
		}
		
		
		if(tab.getExit().getPorcima() == tab.getHero()) //Se o herói estiver na saida depois de matar o dragao
		{
			setGame_over(true);
			setWin(true);
			return;
		}
		if(!(tab.getHero().isAlive())) //Se o herói estiver morto
		{
			setGame_over(true);
			setWin(false);
			return;
		}
		
		tab.apaga_all();
		tab.preenche_all();
		return;
	}
	
	public boolean modificar_estado_dragao(Dragao dragon) //modifica aleatoriamente o estado do dragão
	{
		if(generator.nextBoolean()) //Se decidir modificar
		{
			if(dragon.isSleeping())
				dragon.setSleeping(false); //Acorda o dragão
			else
				dragon.setSleeping(true); // Adormece o dragão
			
			return true; //Mudou o estado do dragão
		}
		else
			return false; //Não mudou o estado do dragão
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
