package logic;
import java.util.*;

//Algoritmo da autoria de Henrique Ferrolho
public class MazeGenerator {
	private Tabuleiro maze;
	private char[][] visitedCells;
	private Celula guideCell;
	private Stack lastCells;
	
	public MazeGenerator(int size)
	{
		this.maze = new Tabuleiro(size, size);
		
	}
}