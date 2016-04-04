package maze.logic;

import java.util.Arrays;

public class Labirinto {
	private Heroi hero;
	private Dragao[] dragons;
	private Saida exit;
	private Espada sword;
	private Tabuleiro board;
	private int numDragoes;

	/**
	 * @brief Retorna o numero de dragoes do respetivo labirinto
	 * @return numero de dragoes
	 */
	public int getNumDragoes() {
		return numDragoes;
	}

	/**
	 * @brief Altera o número de dragoes do respetivo labirinto
	 * @param numDragoes
	 */
	public void setNumDragoes(int numDragoes) {
		this.numDragoes = numDragoes;
	}

	/**
	 * @brief Retorna uma estrutura com todos os dragões do respetivo labirinto
	 * @return array de dragões
	 */
	public Dragao[] getDragons() {
		return dragons;
	}

	/**
	 * @brief Altera dragoes do array
	 * @param dragons
	 */
	public void setDragons(Dragao[] dragons) {
		this.dragons = dragons;
	}

	/**
	 * @brief Retorna o tabuleiro do respetivo labirinto
	 * @return 
	 */
	public Tabuleiro getBoard() {
		return board;
	}

	/**
	 * @brief Altera o tabuleiro
	 * @param board
	 */
	public void setBoard(Tabuleiro board) {
		this.board = board;
	}

	/**
	 * @brief Retorna o herói do respetivo labirinto
	 * @return Heroi
	 */
	public Heroi getHero() {
		return hero;
	}

	/**
	 * @brief Altera heroi do respetivo labirinto
	 * @param hero
	 */
	public void setHero(Heroi hero) {
		this.hero = hero;
	}

	/**
	 * @brief Retorna a saida do respetivo labirinto
	 * @return
	 */
	public Saida getExit() {
		return exit;
	}

	/**
	 * @brief Altera a saida do labirinto
	 * @param exit
	 */
	public void setExit(Saida exit) {
		this.exit = exit;
	}

	/**
	 * @brief Retorna espada do respetivo labirinto
	 * @return
	 */
	public Espada getSword() {
		return sword;
	}

	/**
	 * @brief Altera espada do labirinto
	 * @param sword
	 */
	public void setSword(Espada sword) {
		this.sword = sword;
	}

	/**
	 * @brief Constrói labirinto com elementos e dimensão já definidos
	 */
	public Labirinto() {
		hero = new Heroi(1, 7);
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
	
	/**
	 * @brief Constrói labirinto com elementos e dimensão já definidos mas recebe numero de dragoes a criar no array de dragoes 
	 */
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

	/**
	 * @brief Faz display do tabuleiro e dos elementos
	 */
	public void preenche_tab_default() {
		board.preenche_tabuleiro();
		preenche_heroi(hero);
		preenche_dragao(dragons);
		preenche_saida(exit);
		preenche_espada(sword);

		return;
	}

	/**
	 * @brief Retorna o Elemento que está na casa (x, y)
	 * @param x abcissa 
	 * @param y ordenada
	 * @return char elemento
	 */
	public char retornaCasa(int x, int y) {
		return board.getChar(x, y);
	}

	/**
	 * @brief Retorna o char que representa o elemento que está na casa (x, y)
	 * @param elem
	 * @return char elemento
	 */
	public char retornaCasa(Elemento elem) 
	{
		return retornaCasa(elem.getPosX(), elem.getPosY());
	}

	/**
	 * @brief Retorna o char do elemento que recebe na casa seguinte consoante a direcao que recebe, pode manter a posicao
	 * @param elem
	 * @param direcao
	 * @return char elemento
	 */
	public char posCharacter(Elemento elem, int direcao) 
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

	/**
	 * @brief Desenha saída no tabuleiro
	 * @param s
	 */
	public void preenche_saida(Saida s) {
		board.setChar('S', s.getPosX(), s.getPosY());
		return;
	}

	/**
	 * @brief Desenha heroi no tabuleiro
	 * @param h
	 */
	public void preenche_heroi(Heroi h) {
		if (h.isArmado())
			board.setChar('A', h.getPosX(), h.getPosY());
		else if (h.isAlive()) {
			board.setChar('H', h.getPosX(), h.getPosY());
		}

	}

	/**
	 * @brief Desenha dragoes no tabuleiro
	 * @param d
	 */
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

	/**
	 * @brief Desenha espada se o heroi nao a tiver apanhado nem que um dragao esteja por cima, no tabuleiro
	 * @param e
	 */
	public void preenche_espada(Espada e) {
		if (!(e.isNaMao()) && e.getPorcima() == null) 
			board.setChar('E', e.getPosX(), e.getPosY());
	}

	/**
	 * @brief Desenha o elemento que é passado como parametro no tabuleiro
	 * @param elem
	 */
	public void preenche_npc(Elemento elem) 
	{
		if (elem == hero) {
			preenche_heroi(hero);
			return;
		} else if (elem instanceof Dragao) {
			preenche_dragao(dragons);
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

	/**
	 * @brief Desenha os elementos todos no tabuleiro
	 */
	public void preenche_all() {
		preenche_saida(exit);
		preenche_espada(sword);
		preenche_heroi(hero);
		preenche_dragao(dragons);
		return;
	}

	/**
	 * @brief Apaga todos os elementos do tabuleiro
	 */
	public void apaga_all() {
		apaga_npc(exit);
		apaga_npc(sword);
		apaga_npc(hero);
		for (int i = 0; i < dragons.length; i++)
			apaga_npc(dragons[i]);
		return;
	}

	/**
	 * @brief Apaga o elemento que é passado como parametro do tabuleiro
	 * @param elem
	 */
	public void apaga_npc(Elemento elem) {
		board.setChar(' ', elem.getPosX(), elem.getPosY());
		return;
	}

	/**
	 * @brief Apaga a posicao anterior do elemento que é passado como parametro 
	 * @param elem
	 * @param direcao 
	 */
	public void clean_track(Elemento elem, int direcao) 
	{
		switch (direcao) {
		case 0:// Norte
			board.setChar(' ', elem.getPosX(), elem.getPosY() + 1);
			break;
		case 1:// Oeste
			board.setChar(' ', elem.getPosX() - 1, elem.getPosY());
			break;
		case 2:// Sul
			board.setChar(' ', elem.getPosX(), elem.getPosY() - 1);
			break;
		case 3:// Este
			board.setChar(' ', elem.getPosX() + 1, elem.getPosY());
			break;
		default:
			break;
		}
	}
	
	/**
	 * @brief Verifica se algum dos dragoes e o heroi estão em posicoes adjacentes, se se verificar retorna -1
	 * @param elem
	 */
	public int verificaPresencaDragao(Elemento elem) 
	{
		for (int i = 0; i < dragons.length; i++) {
			if (dragons[i].isAlive() && verifica_adjacencia(elem, dragons[i])) 
				return i;
		}
		return -1;
	}

	/**
	 * @brief Verifica se o dragão e o heroi estão em posicoes adjacentes, se se verificar retorna true
	 * @param elem1
	 * @param elem2
	 * @return boolean 
	 */
	public boolean verifica_adjacencia(Elemento elem1, Elemento elem2) {
		if (Math.abs(elem1.getPosX() - elem2.getPosX()) == 1 && elem1.getPosY() == elem2.getPosY()) {
			return true;
		} else if (Math.abs(elem1.getPosY() - elem2.getPosY()) == 1 && elem1.getPosX() == elem2.getPosX())
			return true;
		else
			return false;
	}

	/**
	 * @brief Verifica se a espada ou a saída (seres inanimados) estão sobrepostos com outro elemento
	 * @param elem
	 * @return
	 */
	public SerAnimado verificaSobreposicao(SerInanimado elem) {
		for (int i = 0; i < dragons.length; i++) {
			if (elem.isSobreposto(hero) && hero.isAlive())
				return hero;
			else if (elem.isSobreposto(dragons[i]) && dragons[i].isAlive())
				return dragons[i];
		}
		return null;
	}

	/**
	 * @brief Verifica todas as condiçoes necessarias antes de pedir a proxima direçao ao 
	 * utilizador e modifica, se necessário, estados dos elementos 
	 */
	public void checkList() {
		for (int i = 0; i < dragons.length; i++) {
			sword.setPorcima(verificaSobreposicao(sword));
			// por cima da espada
			if (sword.getPorcima() == hero) // Verifica se o heroi apanhou a
											// espada
				hero.setArmado(true);
		}

		return;
	}

	/**
	 * @brief Retorna a celula para que o ser animado se move consoante a diração que recebe como parametro
	 * @param npc
	 * @param direcao
	 * @return celula
	 */
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

	/**
	 * @brief Retorna verdadeiro ou falso consoante se o ser animado se pode mover para a celula indicada pela direcao
	 * @param npc
	 * @param direcao
	 * @return boolean
	 */
	public boolean verificaPosicao(SerAnimado npc, int direcao) {

		Celula c = getNewPosition(npc, direcao);
		char casa = retornaCasa(c.x, c.y);

		switch (casa) {
		case 'X':
			return false;
		case 'S':
			if (npc instanceof Heroi && Dragao.getnDragoesVivos() > 0)
				return false;
			else if (npc instanceof Dragao)
				return false;
		}
		

		return true;
	}

	/**
	 * @brief Desenha o tabuleiro apos chamar a funçao que move e altera as flags do ser animado 
	 * @param npc
	 * @param direcao
	 * @return boolean
	 */
	public boolean moveSerAnimado(SerAnimado npc, int direcao) {
		if (!(npc.isAlive())) // Se tiver morto não se mexe
			return false;

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

	/**
	 * @brief Move o ser animado consoante o que se encontra na celula para que se moveu
	 * @param npc
	 * @param direcao
	 * @return boolean
	 */
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