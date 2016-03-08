package logic;
import java.util.*;

//Algoritmo da autoria de Henrique Ferrolho
public class MazeGenerator {
	private Tabuleiro maze;
	private Saida exit;
	private char[][] visitedCells;
	private Celula guideCell;
	private Stack lastCells;
	private Random generator;
	
	public MazeGenerator(int size)
	{
		this.generator = new Random();
		
		this.maze = new Tabuleiro(size);
		this.maze.make_quadriculado();
		
		this.visitedCells = new char[(size-1)/2][(size-1)/2];
		for(int i = 0; i < (size-1)/2; i++)
		{
			for(int j = 0; j < (size-1)/2; j++)
				this.visitedCells[i][j] = '.';
		}
		
		//Coloca a celula guide numa casa aleatoria
		this.guideCell = iniciar_guideCell();
		
		this.exit = iniciar_saida(guideCell);
		
		this.lastCells = new Stack();
		
	}
	
	public Celula iniciar_guideCell() //Cria uma guideCell para colocar em visitedCells
	{
		Celula cell = new Celula(0,0);
		int tipo_iniciar = generator.nextInt(4);
		switch(tipo_iniciar)
		{
		case 0: //Junto a Coluna da esquerda
			cell.y = generator.nextInt((maze.getTamy()+1)/2);
			break;
		case 1: //Junto a Linha de cima
			cell.x = generator.nextInt((maze.getTamy()+1)/2);
			break;
		case 2: //Junto a Linha de baixo
			cell.x = generator.nextInt((maze.getTamy()+1)/2);
			cell.y = (maze.getTamy()+1)/2 -1;
			break;
		case 3: //Junto a Coluna da direita
			cell.x = (maze.getTamy()+1)/2 -1;
			cell.y = generator.nextInt((maze.getTamy()+1)/2);
			break;
		default:
			break;
		}
		
		return cell;
	}
	
	public Saida iniciar_saida(Celula cell)
	{
		Saida s;
		//ENCOSTADO COLUNA ESQUERDA
		if(cell.x == 0)
		{
			if(cell.y == 0) //Tambem encostado a Linha Cima
			{
				if(generator.nextBoolean())
				{
					s = new Saida(0, 1);
				}
				else
				{
					s = new Saida(1, 0);
				}
				return s;
			}
			else if(cell.y == converter_MazeToVis(maze.getTamy())) //Tambem encostado a Linha Baixo
			{
				if(generator.nextBoolean())
				{
					s = new Saida(0, maze.getTamy()-2);
				}
				else
				{
					s = new Saida(1, maze.getTamy()-1);
				}
				return s;
			}
			else
			{
				s = new Saida(0, converter_VisToMaze(cell.y));
				return s;
			}
		}
		//ENCOSTADO COLUNA DIREITA
		else if(cell.x == converter_MazeToVis(maze.getTamx()))
		{
			if(cell.y == 0) //Tambem encostado a Linha Cima
			{
				if(generator.nextBoolean())
				{
					s = new Saida(maze.getTamx()-1, 1);
				}
				else
				{
					s = new Saida(maze.getTamx()-2, 0);
				}
				return s;
			}
			else if(cell.y == converter_MazeToVis(maze.getTamy())) //Tambem encostado a Linha Baixo
			{
				if(generator.nextBoolean())
				{
					s = new Saida(maze.getTamx()-1, maze.getTamy()-2);
				}
				else
				{
					s = new Saida(maze.getTamx()-2, maze.getTamy()-1);
				}
				return s;
			}
			else
			{
				s = new Saida(maze.getTamx()-1, converter_VisToMaze(cell.y));
				return s;
			}
		}
		//ENCOSTADO LINHA CIMA
		else if(cell.y == 0)
		{
			s = new Saida(converter_VisToMaze(cell.x), 1);
			return s;
		}
		//ENCOSTADO LINHA BAIXO
		else if(cell.y == converter_MazeToVis(maze.getTamy()))
		{
			s = new Saida(converter_VisToMaze(cell.x), maze.getTamy()-1);
			return s;
		}
		else
		{
			//excepTion //VAMOS TER DE CRIAR EXCEPCAO, MAS NAO POR ENQUANTO
			s = new Saida(1, 0); //CODIGO PROVISORIO
			return s;
		}
	}
	
	public int converter_VisToMaze(int num)
	{
		return (num*2)+1;
	}
	
	public int converter_MazeToVis(int num)
	{
		return (num-1)/2;
	}
}