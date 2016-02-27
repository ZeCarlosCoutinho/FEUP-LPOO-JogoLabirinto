
public class Labirinto {
	private int tamx = 10;
	private int tamy = 10;
	private Heroi hero;
	private Dragao dragon;
	private Saida exit;
	private Espada sword;
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