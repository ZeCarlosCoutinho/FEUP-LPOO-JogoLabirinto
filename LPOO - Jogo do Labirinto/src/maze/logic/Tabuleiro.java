package maze.logic;

import java.util.Arrays;

public class Tabuleiro {
	private int tamx, tamy;
	private char board[][];

	/**
	 * @brief Constrói tabuleiro com dimensao tamx*tamy 
	 * @param tamx tamanho no eixo x
	 * @param tamy tamanho no eixo y
	 */
	public Tabuleiro(int tamx, int tamy) {
		this.tamx = tamx;
		this.tamy = tamy;
		this.board = new char[tamx][tamy];
	}

	/**
	 * @brief Constrói tabuleiro com dimensao tam*tam 
	 * @param tam tamanho no eixo x e no eixo y; tabuleiro obrigatoriamente quadrado
	 */
	public Tabuleiro(int tam) {
		this.tamx = this.tamy = tam;
		this.board = new char[tamx][tamy];
	}

	/**
	 * @brief Devolve dimensão em x
	 * @return int comprimento em x
	 */
	public int getTamx() {
		return tamx;
	}

	/**
	 * @brief Altera dimensão em x
	 * @param tamx comprimento em x
	 */
	public void setTamx(int tamx) {
		this.tamx = tamx;
	}

	/**
	 * @brief Devolve dimensão em y
	 * @return int comprimento em y
	 */
	public int getTamy() {
		return tamy;
	}

	/**
	 * @brief Altera dimensão em y
	 * @param tamx comprimento em y
	 */
	public void setTamy(int tamy) {
		this.tamy = tamy;
	}

	/**
	 * @brief Retorna o tabuleiro
	 * @return matriz(vetor de vetores) com tabuleiro
	 */
	public char[][] getBoard() {
		return board;
	}

	/**
	 * @brief Altera o tabuleiro
	 * @param board
	 */
	public void setBoard(char[][] board) {
		this.board = board;
	}

	/**
	 * @brief Devolve a char da posição (x,y)
	 * @param x
	 * @param y
	 * @return char
	 */
	public char getChar(int x, int y) 
	{
		if (x < 0 || x >= tamx || y < 0 || y >= tamy) // Out of bounds
			return 'N';
		else
			return board[x][y];
	}

	/**
	 * @brief Devolve a char da célula 'cell' passada como parametro
	 * @param x
	 * @param y
	 * @return char
	 */
	public char getChar(Celula cell) // Devolve a char da posição (x,y)
	{
		if (cell.x < 0 || cell.x >= tamx || cell.y < 0 || cell.y >= tamy) // Out
																			// of
																			// bounds
			return 'N';
		else
			return board[cell.x][cell.y];
	}

	/**
	 * @brief Altera o char da posicao (x, y)
	 * @param c
	 * @param x
	 * @param y
	 */
	public void setChar(char c, int x, int y) // Coloca a char na posição (x,y)
	{
		if (x < 0 || x > tamx || y < 0 || y > tamy) // Out of bounds
			return;
		else {
			board[x][y] = c;
			return;
		}
	}

	/**
	 * @brief Desenha tabuleiro sem elementos (chama a funçao que coloca a matriz toda com 'X' e a que "abre" caminhos)
	 */
	public void preenche_tabuleiro() {
		fill_tabuleiro('X');

		abre_linha(1, 1, true, 8);
		abre_linha(1, 5, true, 6);
		abre_linha(4, 8, true, 5);
		abre_linha(1, 1, false, 8);
		abre_linha(4, 1, false, 8);
		abre_linha(6, 1, false, 8);
		abre_linha(8, 1, false, 8);

	}

	/**
	 * @brief Coloca a matriz tabuleiro toda a 'X'
	 * @param c char 'X'
	 */
	public void fill_tabuleiro(char c) {
		for (int j = 0; j < tamy; j++) // Enche tabuleiro de X
		{
			for (int i = 0; i < tamx; i++) {
				board[i][j] = c;
			}
		}
		return;
	}

	/**
	 * @brief Desenha, colocando posicoes da matriz tabuleiro a branco ' ', caminhos por onde se movem os seres animados
	 * @param x
	 * @param y
	 * @param isHorizontal
	 * @param length
	 */
	public void abre_linha(int x, int y, boolean isHorizontal, int length) 
	{
		if (x < 0 || y < 0 || x > tamx || y > tamy) // verificações de modo a
													// que não faça os caminhos
													// fora dos limites
			return;
		if (isHorizontal) {
			if (x + length > tamx)
				return;
			else // Escreve a linha de espaços
			{
				for (int i = 0; i < length; i++) {
					setChar(' ', x + i, y);
				}
			}
		} else {
			if (y + length > tamy)
				return;
			else // Escreve a linha de espaços
			{
				for (int i = 0; i < length; i++) {
					setChar(' ', x, y + i);
				}
			}
		}

	}

	public void make_linha(char c, int x, int y, boolean isHorizontal, int length) {
		if (x < 0 || y < 0 || x > tamx || y > tamy) 
			return;
		if (isHorizontal) {
			if (x + length > tamx)
				return;
			else // Escreve a linha de espaços
			{
				for (int i = 0; i < length; i++) {
					setChar(c, x + i, y);
				}
			}
		} else {
			if (y + length > tamy)
				return;
			else // Escreve a linha de espaços
			{
				for (int i = 0; i < length; i++) {
					setChar(c, x, y + i);
				}
			}
		}

	}

	public void make_quadriculado() {
		fill_tabuleiro(' ');

		// bordas
		make_linha('X', 0, 0, false, tamx);
		make_linha('X', 1, 0, true, tamx - 1);
		make_linha('X', 1, tamy - 1, true, tamx - 1);
		make_linha('X', tamx - 1, 1, false, tamx - 2);

		// quadriculas
		for (int i = 2; i <= tamx - 2; i = i + 2) {
			make_linha('X', i, 1, false, tamx - 2);
		}

		for (int i = 2; i <= tamy - 2; i = i + 2) {
			make_linha('X', 1, i, true, tamy - 2);
		}

		return;
	}
	
	public String toString()
	{
		String tabuleiroString = "";
		
		for(int j = 0; j < tamy; j++)
		{
			for(int i = 0; i < tamx; i++)
			{
				tabuleiroString += board[i][j] + " ";
			}
			tabuleiroString += "\n";
		}
		
		return tabuleiroString;
	}
}
