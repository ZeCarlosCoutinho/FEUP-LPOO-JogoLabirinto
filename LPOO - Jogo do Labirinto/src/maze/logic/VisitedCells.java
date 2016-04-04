package maze.logic;

import java.util.Arrays;

public class VisitedCells {
	private char[][] grid;
	private int tam;
	
	/**
	 * @return array 2D com as celulas visitadas 
	 */
	public char[][] getGrid() {
		return grid;
	}
	
	/**
	 * @brief define um novo grid
	 * @param grid
	 */
	public void setGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * @return tamanho de um dos lados do grid
	 */
	public int getTam() {
		return tam;
	}
	
	/**
	 * @brief muda o tamanho do grid
	 * @param tam
	 */
	public void setTam(int tam) {
		this.tam = tam;
	}
	
	/**
	 * @brief coloca a celula (x,y) da visitedCells como + (visitada)
	 * @param x
	 * @param y
	 * @return false se estiver fora dos limites, true se for bem sucedido
	 */
	public boolean setCell(int x, int y)
	{
		if(x < 0 || x >= tam || y < 0 || y >= tam)
			return false;
		else
		{
			grid[x][y] = '+';
			return true;
		}
	}
	
	/**
	 * @brief coloca a celula (x,y) com um . (nao visitada)
	 * @param x
	 * @param y
	 * @return false se estiver fora dos limites, true se for bem sucedido
	 */
	public boolean resetCell(int x, int y)
	{
		if(x < 0 || x >= tam || y < 0 || y >= tam)
			return false;
		else
		{
			grid[x][y] = '.';
			return true;
		}
	}
	
	/**
	 * @param x
	 * @param y
	 * @return retorna o char da celula de coordenadas (x,y) na visitedCells
	 * @throws Exception
	 */
	public char getCell(int x, int y) throws Exception
	{
		if(x < 0 || x >= tam || y < 0 || y >= tam)
			throw new IllegalArgumentException();
		else
			return grid[x][y];
	}
	
	/**
	 * @brief construtor do visitedCells
	 * @param tam
	 */
	public VisitedCells(int tam)
	{
		this.tam = tam;
		this.grid = new char[tam][tam];
		for(int i = 0; i < tam; i++)
		{
			for(int j = 0; j < tam; j++)
				this.grid[i][j] = '.';
		}
	}
}
