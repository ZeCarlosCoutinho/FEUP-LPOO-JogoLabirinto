package maze.logic;
	
import java.util.Random; //Mover o DragÃ£o random

import exceptions.TooManyDragonsException;

public class Jogo {

	private Labirinto lab;
	private boolean gameOver;
	private boolean win;
	private int gameMode; // 0 - dragÃ£o parado; 1 - dragÃ£o move-se; 2- dragÃ£o
							// adormece
	private MazeGenerator mazeGenerator;
	private Random generator;

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public Labirinto getLab() {
		return lab;
	}

	public void setLab(Labirinto lab) {
		this.lab = lab;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public int getGameMode() {
		return gameMode;
	}

	public void setGameMode(int gameMode) {
		if (Math.abs(gameMode) <= 2)
			this.gameMode = gameMode;
		else
			this.gameMode = 0;
	}

	public Jogo() {
		lab = new Labirinto();
		gameOver = false;
		win = false;
		mazeGenerator = new MazeGenerator();
		generator = new Random();
	}

	public void turno(char direcao)// direÃ§Ã£o Ã© fornecida pela interface com o
									// jogador
	{
		int direcaoInt = direcaoCharToInt(direcao); // Converte direÃ§Ã£o para
													// um int

		// Move o Heroi
		lab.moveSerAnimado(lab.getHero(), direcaoInt);

		if (lab.getExit().getPorcima() == lab.getHero()) // Se o herÃ³i estiver
															// na saÃ­da depois
															// de matar o dragao
		{
			setGameOver(true);
			setWin(true);
			return;
		}
		if (!(lab.getHero().isAlive())) // Se o herÃ³i estiver morto
		{
			setGameOver(true);
			setWin(false);
			return;
		}

for (int i = 0; i < lab.getDragons().length; i++) {
			// Move o DragÃ£o
			if (gameMode == 1) // Modo jogo 1, simplesmente move o dragÃ£o
			{
				// enquanto o dragao se move para uma parede, gera uma nova
				// direÃ§ao
				while (lab.getDragons()[i].isAlive()
						&& !lab.moveSerAnimado(lab.getDragons()[i], generator.nextInt(5))) {

				}
			}

			else if (gameMode == 2) {
				if (!modificarEstadoDragao(lab.getDragons()[i])) // Modo jogo 2,
																	// move
																	// e pode
																	// mudÃ¡-lo
																	// de
																	// estado
				{
					if (!(lab.getDragons()[i].isSleeping()))
						// enquanto o dragao se move para uma parede, gera uma
						// nova direÃ§ao
						while (lab.getDragons()[i].isAlive()
								&& !lab.moveSerAnimado(lab.getDragons()[i], generator.nextInt(4))) {

						}
				}
			}

			if (lab.getExit().getPorcima() == lab.getHero()) // Se o herÃ³i
																// estiver
																// na saida
																// depois
																// de matar o
																// dragao
			{
				setGameOver(true);
				setWin(true);
			}
			if (!(lab.getHero().isAlive())) // Se o herÃ³i estiver morto
			{
				setGameOver(true);
				setWin(false);
			}

			lab.apaga_all();
			lab.preenche_all();
		}
	}

	public boolean modificarEstadoDragao(Dragao dragon) // modifica
														// aleatoriamente o
														// estado do dragÃ£o
	{
		if (generator.nextBoolean()) // Se decidir modificar
		{
			if (dragon.isSleeping())
				dragon.setSleeping(false); // Acorda o dragÃ£o
			else
				dragon.setSleeping(true); // Adormece o dragÃ£o

			return true; // Mudou o estado do dragÃ£o
		} else
			return false; // NÃ£o mudou o estado do dragÃ£o
	}

	public int direcaoCharToInt(char direcao) {
		direcao = Character.toLowerCase(direcao);
		switch (direcao) {
		case 'w':
			return 0;
		case 'd':
			return 1;
		case 's':
			return 2;
		case 'a':
			return 3;
		default:
			return 4; // PODE SER NECESSÃ�RIO UM THROW
		}
	}
	
	public void criaLabirintoAleatorio(int size, int numDragoes) throws TooManyDragonsException
	{
		this.mazeGenerator.buildMaze(size, numDragoes);
		Labirinto labirinto = new Labirinto(numDragoes);
		labirinto.setHero(this.mazeGenerator.getHero());
		labirinto.setDragons(this.mazeGenerator.getDragons());
		labirinto.setExit(this.mazeGenerator.getExit());
		labirinto.setSword(this.mazeGenerator.getSword());
		labirinto.setBoard(this.mazeGenerator.getMaze());
		Dragao.setnDragoes(labirinto.getNumDragoes());
		Dragao.setnDragoesVivos(labirinto.getNumDragoes());
		
		this.lab = labirinto;
	}
}
