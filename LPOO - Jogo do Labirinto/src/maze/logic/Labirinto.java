package maze.logic;

import java.util.Arrays;

public class Labirinto {
	private Heroi hero;
	private Dragao[] dragons;
	private Saida exit;
	private Espada sword;
	private Tabuleiro board;
	private int numDragoes;

	public int getNumDragoes() {
		return numDragoes;
	}

	public void setNumDragoes(int numDragoes) {
		this.numDragoes = numDragoes;
	}

	public Dragao[] getDragons() {
		return dragons;
	}

	public void setDragons(Dragao[] dragons) {
		this.dragons = dragons;
	}

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
	public Labirinto() {
		hero = new Heroi(1, 1);
		numDragoes = 4;
		dragons = new Dragao[numDragoes];
		dragons[0] =  new Dragao(8, 1);
		dragons[1] =  new Dragao(8, 2);
		dragons[2] =  new Dragao(1, 2);
		dragons[3] =  new Dragao(5, 1);
		
		exit = new Saida();
		sword = new Espada();
		board = new Tabuleiro(10, 10);

		checkList(); // Faz uma série de verificações

		preenche_tab_default();
	}
	
	public Labirinto(int numDragoes) {
		hero = new Heroi(1, 7);
		this.numDragoes = numDragoes;
		dragons = new Dragao[numDragoes];
		Arrays.fill(dragons, new Dragao());
		
		exit = new Saida();
		sword = new Espada();
		board = new Tabuleiro(10, 10);

		checkList(); // Faz uma série de verificações

		preenche_tab_default();
	}

	// Coloca os seres no tabuleiro
	public void preenche_tab_default() {
		board.preenche_tabuleiro();
		preenche_heroi(hero);
		preenche_dragao(dragons);
		preenche_saida(exit);
		preenche_espada(sword);

		return;
	}

	public char retornaCasa(int x, int y) {
		return board.getChar(x, y);
	}

	public char retornaCasa(Elemento elem) // Retorna o char na posição do
											// Elemento
	{
		return retornaCasa(elem.getPosX(), elem.getPosY());
	}

	public char posCharacter(Elemento elem, int direcao) // Retorna o char na
															// casa seguinte
															// consoante a
															// direção e posição
															// do Elemento
	{
		switch (direcao) {
		case 0:
			return retornaCasa(elem.getPosX(), elem.getPosY() - 1);
		case 1:
			return retornaCasa(elem.getPosX() + 1, elem.getPosY());
		case 2:
			return retornaCasa(elem.getPosX(), elem.getPosY() + 1);
		case 3:
			return retornaCasa(elem.getPosX() - 1, elem.getPosY());
		default:
			return retornaCasa(elem.getPosX(), elem.getPosY());
		}
	}

	public void preenche_saida(Saida s) {
		board.setChar('S', s.getPosX(), s.getPosY());
		return;
	}

	public void preenche_heroi(Heroi h) {
		if (h.isArmado())
			board.setChar('A', h.getPosX(), h.getPosY());
		else if (h.isAlive()) {
			board.setChar('H', h.getPosX(), h.getPosY());
		}

	}

	public void preenche_dragao(Dragao[] d) {
		for (int i = 0; i < d.length; i++) {
			if (d[i].isAlive()) {
				if (sword.getPorcima() == d[i]) {
					if (d[i].isSleeping())
						board.setChar('f', d[i].getPosX(), d[i].getPosY());
					else
						board.setChar('F', d[i].getPosX(), d[i].getPosY());
				} else {
					if (d[i].isSleeping())
						board.setChar('d', d[i].getPosX(), d[i].getPosY());
					else
						board.setChar('D', d[i].getPosX(), d[i].getPosY());
				}
			}
		}
	}

	public void preenche_espada(Espada e) {
		if (!(e.isNaMao()) && e.getPorcima() == null) // Se o herói ainda não
														// tiver apanhado, e nao
														// tiver nada por cima
			board.setChar('E', e.getPosX(), e.getPosY());
	}

	public void preenche_npc(Elemento elem) // função que escreve um Elemento no
											// board
	{
		if (elem == hero) {
			preenche_heroi(hero);
			return;
		} else if (elem instanceof Dragao) {
			preenche_dragao(dragons); // DUVIDA: SE PASSARMOS elem COMO
										// ARGUMENTO
										// (e elem for um dragão)
										// O PROGRAMA VAI USAR OS DADOS DE
										// DRAGAO? OU VAI DESCARTA-LOS E ASSUMIR
										// elem COM APENAS OS ATRIBUTOS DE
										// elemento?
			return;
		} else if (elem == sword) {
			preenche_espada(sword);
			return;
		} else if (elem == exit) {
			preenche_saida(exit);
			return;
		} else
			return;
	}

	public void preenche_all() {
		preenche_saida(exit);
		preenche_espada(sword);
		preenche_heroi(hero);
		preenche_dragao(dragons);
		return;
	}

	public void apaga_all() {
		apaga_npc(exit);
		apaga_npc(sword);
		apaga_npc(hero);
		for (int i = 0; i < dragons.length; i++)
			apaga_npc(dragons[i]);
		return;
	}

	public void apaga_npc(Elemento elem) {
		board.setChar(' ', elem.getPosX(), elem.getPosY());
		return;
	}

	public void clean_track(Elemento elem, int direcao) // limpa o rasto deixado
														// pelo SerAnimado
	{
		switch (direcao) {
		case 0:// Norte
			board.setChar(' ', elem.getPosX(), elem.getPosY() + 1);// O rasto
																	// ficou 1
																	// casa
																	// abaixo
			break;
		case 1:// Oeste
			board.setChar(' ', elem.getPosX() - 1, elem.getPosY());// O rasto
																	// ficou 1
																	// casa à
																	// esquerda
			break;
		case 2:// Sul
			board.setChar(' ', elem.getPosX(), elem.getPosY() - 1);// O rasto
																	// ficou 1
																	// casa
																	// acima
			break;
		case 3:// Este
			board.setChar(' ', elem.getPosX() + 1, elem.getPosY());// O rasto
																	// ficou 1
																	// casa à
																	// direita
			break;
		default:
			break;
		}
	}

	public int verificaPresencaDragao(Elemento elem) // Verifica se está um
														// dragão na casa
														// adjacente a ELEM
	{
		for (int i = 0; i < dragons.length; i++) {
			if (dragons[i].isAlive() && verifica_adjacencia(elem, dragons[i])) // Se eles estiverem
														// adjacentes
				return i;
		}
		return -1;
	}

	public boolean verifica_adjacencia(Elemento elem1, Elemento elem2) {
		if (Math.abs(elem1.getPosX() - elem2.getPosX()) == 1 && elem1.getPosY() == elem2.getPosY()) {
			// Estão adjacentes
			return true;
		} else if (Math.abs(elem1.getPosY() - elem2.getPosY()) == 1 && elem1.getPosX() == elem2.getPosX())
			return true;
		else
			return false;
	}

	public SerAnimado verificaSobreposicao(SerInanimado elem) {
		for (int i = 0; i < dragons.length; i++) {
			if (elem.isSobreposto(hero) && hero.isAlive())
				return hero;
			else if (elem.isSobreposto(dragons[i]) && dragons[i].isAlive())
				return dragons[i];
		}
		return null;
	}

	public void checkList() { /*
								 * Função que verifica tudo o que é necessário
								 * antes do turno começaar, fazendo as
								 * alterações necessárias
								 */
		for (int i = 0; i < dragons.length; i++) {
			sword.setPorcima(verificaSobreposicao(sword)); // Verifica se está
															// algo
			// por cima da espada
			if (sword.getPorcima() == hero) // Verifica se o heroi apanhou a
											// espada
				hero.setArmado(true);
		}

		return;
	}

	public Celula getNewPosition(SerAnimado npc, int direcao) {
		Celula c = new Celula();

		switch (direcao) {
		case 0: // Norte
			c.y = npc.getPosY() - 1;
			c.x = npc.getPosX();
			break;
		case 1: // Este
			c.y = npc.getPosY();
			c.x = npc.getPosX() + 1;
			break;
		case 2: // Sul
			c.y = npc.getPosY() + 1;
			c.x = npc.getPosX();
			break;
		case 3: // Oeste
			c.y = npc.getPosY();
			c.x = npc.getPosX() - 1;
			break;
		}
		return c;
	}

	public boolean verificaPosicao(SerAnimado npc, int direcao) {

		Celula c = getNewPosition(npc, direcao);
		char casa = retornaCasa(c.x, c.y);

		switch (casa) {
		case 'X': // Andar para uma parede
			return false;
		case 'S':
			if (npc instanceof Heroi && Dragao.getnDragoesVivos() > 0)
				return false;
			else if (npc instanceof Dragao)
				return false;
		}

		return true;
	}

	public boolean moveSerAnimado(SerAnimado npc, int direcao) {
		if (!(npc.isAlive())) // Se tiver morto não se mexe
			return false;
		
		if(npc instanceof Dragao)
		{
			if(((Dragao) npc).isSleeping())
				return false;
		}
		
		if (!verificaPosicao(npc, direcao))
			return false;

		moveParaCasa(npc, direcao);
		clean_track(npc, direcao); // limpa o rasto
		preenche_espada(sword);
		preenche_npc(npc);

		int indice = verificaPresencaDragao(hero);
		if (indice != -1) // Batalha entre Herói e dragao
		{
			if (hero.isArmado()) {
				dragons[indice].setAlive(false);
				Dragao.setnDragoesVivos(Dragao.getnDragoesVivos()-1);
				System.out.print(Dragao.getnDragoesVivos());
				apaga_npc(dragons[indice]);
				checkList();
			} else if (!dragons[indice].isSleeping())
				hero.setAlive(false);
		}
		return true;
	}

	public boolean moveParaCasa(SerAnimado npc, int direcao) {

		npc.move(direcao);
		char casa = retornaCasa(npc.getPosX(), npc.getPosY());

		switch (casa) {
		case ' ': // Andar para um espaço em branco
			checkList();
			preenche_espada(sword); // Volta a imprimir a espada (so imprime se
									// o player não a tiver apanhado)
			return true;
		case 'E': // Andar para a espada
			if (npc == hero) {
				hero.setArmado(true);
				sword.setNaMao(true);
				sword.setPorcima(hero);

				return true;
			} else if (npc instanceof Dragao) {
				sword.setPorcima(npc);
				return true;
			}
		case 'S': // Andar para a saída
			if (Dragao.getnDragoesVivos() == 0) {
				exit.setChegou_heroi(true);
				exit.setPorcima(hero);
				checkList();
				return true;
			} else
				return false;
		case 'F':
			if (npc == hero) {
				hero.setAlive(false);
				return true;
			} else if (npc instanceof Dragao) {
				preenche_dragao(dragons);
				return false;
			} else
				return false;
		case 'f':
			if (npc == hero)
				return false;
			else if (npc instanceof Dragao)
				return false;
			else
				return false;
		}

		return false;
	}
}