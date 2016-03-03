package logic;

public class Tabuleiro {
	private int tamx, tamy;
	private char board[][];
	
	public Tabuleiro(int tamx, int tamy)
	{
		this.tamx = tamx;
		this.tamy = tamy;
		this.board = new char[tamx][tamy];
	}

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

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}
	
	public char getChar(int x, int y)		//Devolve a char da posição (x,y)
	{
		if (x<0 || x>tamx || y<0 || y>tamy) //Out of bounds
			return 'N';
		else
			return board[x][y];
	}
	
	public void setChar(char c, int x, int y)	//Coloca a char na posição (x,y)
	{
		if (x<0 || x>tamx || y<0 || y>tamy) //Out of bounds
			return;
		else
		{
			board[x][y] = c;
			return;
		}
	}
	
	public void preenche_tabuleiro()
	{
		for(int j = 0; j < tamy; j++)	//Enche tabuleiro de X
		{
			for(int i = 0; i < tamx; i++)
			{
				board[i][j] = 'X';
			}
		}
		
		abre_linha(1, 1, true, 8);
		abre_linha(1, 5, true, 6);
		abre_linha(4, 8, true, 5);
		abre_linha(1, 1, false, 8);
		abre_linha(4, 1, false, 8);
		abre_linha(6, 1, false, 8);
		abre_linha(8, 1, false, 8);
		
	}
	
	public void abre_linha(int x, int y, boolean isHorizontal, int length) //Abre um caminho de espaços brancos. Pode dar jeito se gerarmos um tabuleiro aleatório
	{
		if(x<0 || y <0 || x > tamx || y > tamy) //verificações de modo a que não faça os caminhos fora dos limites
			return;
		if(isHorizontal)
		{
			if(x+length > tamx)
				return;
			else			//Escreve a linha de espaços
			{
				for(int i = 0; i < length; i++)
				{
					setChar(' ', x+i, y);
				}
			}
		}
		else
		{
			if(y+length > tamy)
				return;
			else			//Escreve a linha de espaços
			{
				for(int i = 0; i < length; i++)
				{
					setChar(' ', x, y+i);
				}
			}
		}
				
	}
}
