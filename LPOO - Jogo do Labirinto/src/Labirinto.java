
public class Labirinto {
	private int tamx = 10;
	private int tamy = 10;
	private Heroi hero;
	private Dragao dragon;
	private Saida exit;
	private Espada sword;
	public int getTamx() {
		return tamx;
	}

	public void setTamx(int tamx) {
		this.tamx = tamx;
	}

	public int getTamy() {
		return tamy;
	}

	public void setTamy(int tamy) {
		this.tamy = tamy;
	}

	public Heroi getHero() {
		return hero;
	}

	public void setHero(Heroi hero) {
		this.hero = hero;
	}

	public Dragao getDragon() {
		return dragon;
	}

	public void setDragon(Dragao dragon) {
		this.dragon = dragon;
	}

	public Saida getExit() {
		return exit;
	}

	public void setExit(Saida exit) {
		this.exit = exit;
	}

	public Espada getSword() {
		return sword;
	}

	public void setSword(Espada sword) {
		this.sword = sword;
	}

	public char tabuleiro[][] = new char[tamx][tamy];
		
	// construtor
	public Labirinto()
	{
		hero = new Heroi();
		dragon = new Dragao();
		exit = new Saida();
		sword = new Espada();
		preenche_lab_exp();
		
	}
	
	//contruir labirinto
	public void preenche_lab_exp()
	{
		for (int i=0; i<tamx; i++)
		{
			for (int j=0; j<tamy; j++)
			{
				tabuleiro[i][j]='X';
			}
		}
		for (int i=1; i<tamx-1; i++)
		{
			tabuleiro[i][1]=' ';
		}
		for (int i=1; i<tamy-1; i++)
		{
			tabuleiro[1][i]=' ';
		}
		for (int i=1; i<tamy-1; i++)
		{
			tabuleiro[4][i]=' ';
		}
		for (int i=1; i<tamy-1; i++)
		{
			tabuleiro[6][i]=' ';
		}
		for (int i=1; i<tamy-1; i++)
		{
			tabuleiro[8][i]=' ';
		}
		for (int i=1; i<tamx-3; i++)
		{
			tabuleiro[i][5]=' ';
		}
		for (int i=4; i<tamx-1; i++)
		{
			tabuleiro[i][8]=' ';
		}
		
		//Até agora preencheu o labirinto com paredes
		
		preenche_heroi(hero);
		preenche_dragao(dragon);
		preenche_saida(exit);
		preenche_espada(sword);
		
		return;
	}
	
	public void displayLabirinto()
	{
		for (int j=0; j<tamy; j++)
		{
			for (int i=0; i<tamy; i++)
			{
				System.out.print(tabuleiro[i][j]+" ");
			}
			System.out.print("\n");
		}
		return;
	}
	
	public void display()
	{
		preenche_lab_exp();
		displayLabirinto();
		return;
	}
	public char retorna_casa(int x, int y)
	{
		if (x<0 || x>tamx || y<0 || y>tamy)
			return 'N';
		else
			return tabuleiro[x][y];
	}
	
	
	public boolean verifica_casa_heroi(char casa) //Retorna true se o heroi se mover para dentro da casa
	{
		switch(casa)
		{
		case 'X':	//Andar para uma parede
			return false;
		case 'D':	//Andar para o dragao
			if(hero.isArmado())
			{
				dragon.setMorto(true);
				return true;
			}
			else
			{
				hero.setMorto(true);
				return false;
			}
		case ' ':	//Andar para um espa�o em branco
			return true;
		case 'E':	//Andar para a espada
			hero.setArmado(true);
			sword.setNa_mao(true);
			return true;
		case 'S':	//Andar para a saida
			if(dragon.isMorto())
			{
				exit.setChegou_heroi(true);
				return true;
			}
			else
				return false;
		default:
			return false;
				
		}
	}
	
	public void preenche_saida(Saida s)
	{
		tabuleiro[s.getPosx()][s.getPosy()]='S';
		return;
	}
	
	public void preenche_heroi(Heroi h)
	{
		if(h.isArmado())
			tabuleiro[h.getPosx()][h.getPosy()]='A';
		else
			tabuleiro[h.getPosx()][h.getPosy()]='H';
	}
	
	public void preenche_dragao(Dragao d)
	{
		if(!(d.isMorto()))
			tabuleiro[d.getPosx()][d.getPosy()]='D';
	}
	
	public void preenche_espada(Espada e)
	{
		if(!(e.isNa_mao()))
			tabuleiro[e.getPosx()][e.getPosy()]='E';
	}
}