package logic;

public class Labirinto {
	private Heroi hero;
	private Dragao dragon;
	private Saida exit;
	private Espada sword;
	private Tabuleiro board;

	public Tabuleiro getBoard() {
		return board;
	}

	public void setBoard(Tabuleiro board) {
		this.board = board;
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
		
	// construtor
	public Labirinto()
	{
		hero = new Heroi();
		dragon = new Dragao(1, 7);
		exit = new Saida();
		sword = new Espada();
		board = new Tabuleiro(10, 10);
		
		preenche_tab_default();
	}
	
	//Coloca os Seres no tabuleiro
	public void preenche_tab_default()
	{	
		board.preenche_tabuleiro();
		preenche_heroi(hero);
		preenche_dragao(dragon);
		preenche_saida(exit);
		preenche_espada(sword);
		
		return;
	}
	
	public char retorna_casa(int x, int y)
	{
		return board.getChar(x, y);
	}
	
	public char posCharacter(Elemento elem)	//Retorna o char na posicao do Elemento
	{
		return retorna_casa(elem.getPosx(), elem.getPosy());
	}
	
	public char posCharacter(Elemento elem, int direcao) //Retorna o char na casa seguinte consoante a direção e posição do Elemento
	{
		switch(direcao)
		{
		case 0:
			return retorna_casa(elem.getPosx(), elem.getPosy()-1);
		case 1:
			return retorna_casa(elem.getPosx()+1, elem.getPosy());
		case 2:
			return retorna_casa(elem.getPosx(), elem.getPosy()+1);
		case 3:
			return retorna_casa(elem.getPosx()-1, elem.getPosy());
		default:
			return retorna_casa(elem.getPosx(), elem.getPosy());
		}
	}
	
	public boolean move_para_casa(char casa, SerAnimado npc)
	{		
		switch(casa)
		{
		case 'X':	//Andar para uma parede
			return false;
		case 'D':	//Andar para o dragao (não faz muito sentido)
			if(npc == hero)	//Heroi
			{
				if(hero.isArmado())
				{
					dragon.setAlive(false);
					sword.resetPorcima(); //Retira o SerAnimado de cima
					return true;
				}
				else
				{
					hero.setAlive(false);
					return true;
				}
			}
			else if(npc == dragon)//NPC é o Dragao
			{
				return false;
			}
			else
				return false;
		case ' ':	//Andar para um espaço em branco
			sword.resetPorcima(); //Retira o SerAnimado de cima
			preenche_espada(sword); //Volta a imprimir a espada (so imprime se o player nao a tiver apanhado)
			if(verifica_presenca_dragao(hero)) //Batalha entre Heroi e Dragao
			{
				if(hero.isArmado())
				{
					dragon.setAlive(false);
					return true;
				}
				else
				{
					hero.setAlive(false);
					return true;
				}
			}
			return true;
		case 'E':	//Andar para a espada
			if(npc == hero)
			{
				hero.setArmado(true);
				sword.setNa_mao(true);
				sword.setPorcima(hero);
				if(verifica_presenca_dragao(hero))//Batalha entre Heroi e Dragao
				{
					if(hero.isArmado())
					{
						dragon.setAlive(false);
						return true;
					}
					else
					{
						hero.setAlive(false);
						return true;
					}
				}
				return true;
			}
			else if(npc == dragon)
			{
				sword.setPorcima(dragon);
				if(verifica_presenca_dragao(hero)) //Batalha entre Heroi e Dragao
				{
					if(hero.isArmado())
					{
						dragon.setAlive(false);
						return true;
					}
					else
					{
						hero.setAlive(false);
						return true;
					}
				}
				return true;
			}
		case 'S':	//Andar para a saida
			if(!(dragon.isAlive()))
			{
				exit.setChegou_heroi(true);
				exit.setPorcima(hero);
				sword.resetPorcima(); //Retira o SerAnimado de cima
				return true;
			}
			else
				return false;
		case 'F':
			if(npc == hero)
			{
				hero.setAlive(false);
				return true;
			}
			else if(npc == dragon)
			{
				preenche_dragao(dragon);
				return false;
			}
			else
				return false;
		default:
			return false;
				
		}
	}
	
	public void preenche_saida(Saida s)
	{
		board.setChar('S', s.getPosx(), s.getPosy());
		return;
	}
	
	public void preenche_heroi(Heroi h)
	{
		if(h.isArmado())
			board.setChar('A', h.getPosx(), h.getPosy());
		else
			board.setChar('H', h.getPosx(), h.getPosy());
	}
	
	public void preenche_dragao(Dragao d)
	{
		if(d.isAlive())
		{
			if(sword.getPorcima() == d)
				board.setChar('F', d.getPosx(), d.getPosy());
			else
				board.setChar('D', d.getPosx(), d.getPosy());
		}
	}
	
	public void preenche_espada(Espada e)
	{
		if(!(e.isNa_mao()) && e.getPorcima() == null) //Se o heroi ainda nao tiver apanhado, e nao tiver nada por cima
			board.setChar('E', e.getPosx(), e.getPosy());
	}
	
	public void preenche_npc(Elemento elem)		//função que escreve um Elemento no board
	{
		if(elem == hero)
		{
			preenche_heroi(hero);
			return;
		}
		else if(elem == dragon)
		{
			preenche_dragao(dragon);			//DUVIDA: SE PASSARMOS elem COMO ARGUMENTO (e elem for um dragao)
												//O PROGRAMA VAI USAR OS DADOS DE DRAGAO? OU VAI DESCARTALOS E ASSUMIR
												//elem COM APENAS OS ATRIBUTOS DE elemento?
			return;
		}
		else if(elem == sword)
		{
			preenche_espada(sword);
			return;
		}
		else if(elem == exit)
		{
			preenche_saida(exit);
			return;
		}
		else
			return;
	}
	
	public void clean_track(Elemento elem, int direcao) //limpa o rasto deixado pelo SerAnimado
	{
		switch(direcao)
		{
		case 0://Norte
			board.setChar(' ', elem.getPosx(), elem.getPosy()+1);//O rasto ficou 1 casa abaixo
			break;
		case 1://Oeste
			board.setChar(' ', elem.getPosx()-1, elem.getPosy());//O rasto ficou 1 casa à esquerda
			break;
		case 2://Sul
			board.setChar(' ', elem.getPosx(), elem.getPosy()-1);//O rasto ficou 1 casa acima
			break;
		case 3://Este
			board.setChar(' ', elem.getPosx()+1, elem.getPosy());//O rasto ficou 1 casa à direita
			break;
		default:
			break;
		}
	}
	
	public boolean verifica_presenca_dragao(Elemento elem) //Verifica se está um dragão na casa adjacente a ELEM
	{
		if(verifica_adjacencia(elem, dragon))	//Se eles estiverem adjacentes
			return true;
		else
			return false;
	}
	
	public boolean verifica_adjacencia(Elemento elem1, Elemento elem2)
	{
		if(Math.abs(elem1.getPosx()-elem2.getPosx()) == 1 && elem1.getPosy() == elem2.getPosy())
		{
			//Estao adjacentes
			return true;
		}
		else if(Math.abs(elem1.getPosy()-elem2.getPosy()) == 1 && elem1.getPosx() == elem2.getPosx())
			return true;
		else
			return false;
	}
	public void move_SerAnimado(SerAnimado npc, int direcao)
	{
		npc.move(direcao);	//altera a posição do npc
		if(move_para_casa(posCharacter(npc), npc)) //Se o npc se puder mover
		{
			clean_track(npc, direcao); //limpa o rasto
			preenche_espada(sword);
			preenche_npc(npc);
		}
		else
		{
			switch(direcao)	//Desfaz o movimento do Elemento
			{
			case 0:
				direcao = 2;
				break;
			case 1:
				direcao = 3;
				break;
			case 2:
				direcao = 0;
				break;
			case 3:
				direcao = 1;
				break;
			default:
				break;
			}
			
			npc.move(direcao);
		}
		return;
	}
}