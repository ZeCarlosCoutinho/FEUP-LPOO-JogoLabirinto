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
		dragon = new Dragao();
		exit = new Saida();
		sword = new Espada();
		board = new Tabuleiro(10, 10);
		
		check_list(); //Faz uma série de verificações
		
		preenche_tab_default();
	}
	
	//Coloca os seres no tabuleiro
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
	
	public char posCharacter(Elemento elem)	//Retorna o char na posição do Elemento
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
		case 'D':	//Andar para o dragão (não faz muito sentido)
			if(npc == hero)	//Herói
			{
				if(hero.isArmado())
				{
					dragon.setAlive(false);
					apaga_npc(dragon);
					check_list();
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
		case 'd':
			if(npc == hero)
			{
				if(hero.isArmado())
				{
					dragon.setAlive(false);
					apaga_npc(dragon);
					check_list();
					return true;
				}
				else
					return false;
					
			}
			else if (npc == dragon)
				return false;
			else
				return false;
		case ' ':	//Andar para um espaço em branco
			check_list();
			preenche_espada(sword); //Volta a imprimir a espada (so imprime se o player não a tiver apanhado)
			if(verifica_presenca_dragao(hero)) //Batalha entre Herói e Dragão
			{
				if(hero.isArmado())
				{
					dragon.setAlive(false);
					apaga_npc(dragon);
					check_list();
					return true;
				}
				else
				{
					if(dragon.isSleeping()) //Se o dragão estiver a dormir, ele não mata o jogador
						return false;
					else
					{
						hero.setAlive(false);
						return true;
					}
				}
			}
			return true;
		case 'E':	//Andar para a espada
			if(npc == hero)
			{
				hero.setArmado(true);
				sword.setNa_mao(true);
				sword.setPorcima(hero);
				if(verifica_presenca_dragao(hero))//Batalha entre Herói e Dragão
				{
					if(hero.isArmado())
					{
						dragon.setAlive(false);
						apaga_npc(dragon);
						check_list();
						return true;
					}
					else
					{
						if(dragon.isSleeping()) //Se o dragão estiver a dormir, ele não mata o jogador
							return false;
						else
						{
							hero.setAlive(false);
							return true;
						}
					}
				}
				return true;
			}
			else if(npc == dragon)
			{
				sword.setPorcima(dragon);
				if(verifica_presenca_dragao(hero)) //Batalha entre Herói e Dragão
				{
					if(hero.isArmado())
					{
						dragon.setAlive(false);
						apaga_npc(dragon);
						check_list();
						return true;
					}
					else
					{
						if(dragon.isSleeping()) //Se o dragão estiver a dormir, ele não mata o jogador
							return false;
						else
						{
							hero.setAlive(false);
							return true;
						}
					}
				}
				return true;
			}
		case 'S':	//Andar para a saída
			if(!(dragon.isAlive()))
			{
				exit.setChegou_heroi(true);
				exit.setPorcima(hero);
				check_list();
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
		case 'f':
			//Sim, eu sei que bastava ter um return false em vez disto tudo
			//No entanto, se for preciso meter alguma feature nova, é mais fácil se estiver assim
			if(npc == hero)
				return false;
			else if(npc == dragon)
				return false;
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
			{
				if(d.isSleeping())
					board.setChar('f', d.getPosx(), d.getPosy());
				else
					board.setChar('F', d.getPosx(), d.getPosy());
			}
			else
			{
				if(d.isSleeping())
					board.setChar('d', d.getPosx(), d.getPosy());
				else
					board.setChar('D', d.getPosx(), d.getPosy());
			}
		}
	}
	
	public void preenche_espada(Espada e)
	{
		if(!(e.isNa_mao()) && e.getPorcima() == null) //Se o herói ainda não tiver apanhado, e nao tiver nada por cima
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
			preenche_dragao(dragon);			//DUVIDA: SE PASSARMOS elem COMO ARGUMENTO (e elem for um dragão)
												//O PROGRAMA VAI USAR OS DADOS DE DRAGAO? OU VAI DESCARTA-LOS E ASSUMIR
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
	
	public void preenche_all()
	{
		preenche_saida(exit);
		preenche_espada(sword);
		preenche_heroi(hero);
		preenche_dragao(dragon);
		return;
	}
	public void apaga_all()
	{
		apaga_npc(exit);
		apaga_npc(sword);
		apaga_npc(hero);
		apaga_npc(dragon);
		return;
	}
	
	public void apaga_npc(Elemento elem)
	{
		board.setChar(' ', elem.getPosx(), elem.getPosy());
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
			//Estão adjacentes
			return true;
		}
		else if(Math.abs(elem1.getPosy()-elem2.getPosy()) == 1 && elem1.getPosx() == elem2.getPosx())
			return true;
		else
			return false;
	}
	
	public SerAnimado verifica_sobreposicao(SerInanimado elem)
	{
		if(elem.isSobreposto(hero) && hero.isAlive())
			return hero;
		else if (elem.isSobreposto(dragon) && dragon.isAlive())
			return dragon;
		else
			return null;
	}
	
	public void check_list()		//Função que verifica tudo o que é necessário antes do turno começaar, fazendo as alterações necessárias
	{
		sword.setPorcima(verifica_sobreposicao(sword)); //Verifica se está algo por cima da espada
		if(sword.getPorcima() == hero)	//Verifica se o heroi apanhou a espada
			hero.setArmado(true);
		if(verifica_presenca_dragao(hero)&& !(dragon.isSleeping()))	//Verifica se o heroi é morto pelo dragão, ou vice versa, caso estejam à distância de combate
		{
			if(hero.isArmado())
				dragon.setAlive(false);
			else
				hero.setAlive(false);
		}
		
		//AINDA NÃO SEI SE VALE A PENA INCLUIR A VERIFICAÇÃO SE ESTÁ NA SAÍDA OU NÃO
		return;
	}
	public void move_SerAnimado(SerAnimado npc, int direcao)
	{
		if(!(npc.isAlive()))	//Se tiver morto não se mexe
			return;
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