package logic;

public class Tabuleiro {
	private int tamx, tamy;
	private char board[][] = {{'X','X','X','X','X','X','X','X','X','X'},
							{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
							{'X',' ','X','X',' ','X',' ','X',' ','X'},
							{'X',' ','X','X',' ','X',' ','X',' ','X'},
							{'X',' ','X','X',' ','X',' ','X',' ','X'},
							{'X',' ',' ',' ',' ',' ',' ','X',' ','X'},
							{'X',' ','X','X',' ','X',' ','X',' ','X'},
							{'X',' ','X','X',' ','X',' ','X',' ','X'},
							{'X',' ','X','X',' ',' ',' ',' ',' ','X'},
							{'X','X','X','X','X','X','X','X','X','X'}};
	
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
}
