package logic;

import java.util.Arrays;

public class VisitedCells {
	private char[][] grid;
	private int tam;
	
	public char[][] getGrid() {
		return grid;
	}
	public void setGrid(char[][] grid) {
		this.grid = grid;
	}
	public int getTam() {
		return tam;
	}
	public void setTam(int tam) {
		this.tam = tam;
	}
	
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
	
	public char getCell(int x, int y) throws Exception
	{
		if(x < 0 || x >= tam || y < 0 || y >= tam)
			throw new IllegalArgumentException();
		else
			return grid[x][y];
	}
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
