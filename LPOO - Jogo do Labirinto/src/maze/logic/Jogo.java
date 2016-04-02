package maze.logic;

import java.util.Random; //Mover o Dragão random

public class Jogo {

	private Labirinto lab;
	private boolean gameOver;
	private boolean win;
	private int gameMode; // 0 - dragão parado; 1 - dragão move-se; 2- dragão
							// adormece
	private Random generator;

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public Labirinto getTab() {
		return lab;
	}

	public void setTab(Labirinto tab) {
		this.lab = tab;
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
		generator = new Random();
	}

	public void turno(char direcao)// direção é fornecida pela interface com o
									// jogador
	{
		int direcaoInt = direcaoCharToInt(direcao); // Converte direção para
													// um int

		// Move o Heroi
		lab.moveSerAnimado(lab.getHero(), direcaoInt);

		if (lab.getExit().getPorcima() == lab.getHero()) // Se o herói estiver
															// na saída depois
															// de matar o dragao
		{
			setGameOver(true);
			setWin(true);
			return;
		}
		if (!(lab.getHero().isAlive())) // Se o herói estiver morto
		{
			setGameOver(true);
			setWin(false);
			return;
		}

for (int i = 0; i < lab.getDragons().length; i++) {
			// Move o Dragão
			if (gameMode == 1) // Modo jogo 1, simplesmente move o dragão
			{
				// enquanto o dragao se move para uma parede, gera uma nova
				// direçao
				while (lab.getDragons()[i].isAlive()
						&& !lab.moveSerAnimado(lab.getDragons()[i], generator.nextInt(5))) {

				}
			}

			else if (gameMode == 2) {
				if (!modificarEstadoDragao(lab.getDragons()[i])) // Modo jogo 2,
																	// move
																	// e pode
																	// mudá-lo
																	// de
																	// estado
				{
					if (!(lab.getDragons()[i].isSleeping()))
						// enquanto o dragao se move para uma parede, gera uma
						// nova direçao
						while (lab.getDragons()[i].isAlive()
								&& !lab.moveSerAnimado(lab.getDragons()[i], generator.nextInt(4))) {

						}
				}
			}

			if (lab.getExit().getPorcima() == lab.getHero()) // Se o herói
																// estiver
																// na saida
																// depois
																// de matar o
																// dragao
			{
				setGameOver(true);
				setWin(true);
			}
			if (!(lab.getHero().isAlive())) // Se o herói estiver morto
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
														// estado do dragão
	{
		if (generator.nextBoolean()) // Se decidir modificar
		{
			if (dragon.isSleeping())
				dragon.setSleeping(false); // Acorda o dragão
			else
				dragon.setSleeping(true); // Adormece o dragão

			return true; // Mudou o estado do dragão
		} else
			return false; // Não mudou o estado do dragão
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
			return 4; // PODE SER NECESSÁRIO UM THROW
		}
	}
}
