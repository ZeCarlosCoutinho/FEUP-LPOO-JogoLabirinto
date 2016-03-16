package logic;
import java.util.*;

//Algoritmo da autoria de Henrique Ferrolho
public class MazeGenerator {
	private Tabuleiro maze;
	private Saida exit;
	private char[][] visitedCells;
	private Celula guideCell;
	private Stack<Celula> lastCells;
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
		
		this.lastCells = new Stack<Celula>();
		this.lastCells.push(guideCell);
		
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
	
	public boolean moveGuideCell()
	{
	//Gera uma direcao aleatoria
		int direction = generator.nextInt(4);
		
	//Cria copia da guideCell
		Celula celulaInicial = guideCell;
		
	//Tenta mover a guideCell nas 4 direcoes
		int i = 0;
		while(i < 4)
		{
			if(moveGuideVisitedCells(direction + i))
				break;
			else
				i++;
		}
	//Se nao conseguir mover em nenhuma das direcoes
		if(i == 4)
			return false;
	
	//Apaga a parede no Maze, abrindo um caminho
		abreCaminhoCelulas(celulaInicial, guideCell);
		
	//Coloca a ultima celula visitada na stack
		lastCells.push(guideCell);
		
		return true;
	}
	
	public boolean moveGuideVisitedCells(int direction)
	{
		switch(direction)
		{
		case 0: //Norte
			if(guideCell.y-1 < 0 || visitedCells[guideCell.x][guideCell.y-1] == '+')
				return false;
			else
			{
				guideCell.y -= 1;
				return true;
			}
		case 1: //Este
			if(guideCell.x +1 > (maze.getTamx()-1)/2 || visitedCells[guideCell.x+1][guideCell.y] == '+')
				return false;
			else
			{
				guideCell.x += 1;
				return true;
			}
		case 2: //Sul
			if(guideCell.y + 1 > (maze.getTamy()-1)/2 || visitedCells[guideCell.x][guideCell.y+1] == '+')
				return false;
			else
			{
				guideCell.y += 1;
				return true;
			}
		case 3: //Oeste
			if(guideCell.x-1 < 0 || visitedCells[guideCell.x-1][guideCell.y] == '+')
				return false;
			else
			{
				guideCell.x -= 1;
				return true;
			}
		default:
			return false; //DEVIAMOS INCLUIR UMA EXCECAO
		}
	}
	
	public void escreveGuideVisitedCells()
	{
		visitedCells[guideCell.x][guideCell.y] = '+';
		return;
	}
	
	public void abreCaminhoCelulas(Celula cell1, Celula cell2)
	{
		//Descobre o x e o y da parede que se quer apagar
		int xmedioMaze = (converter_VisToMaze(cell1.x)+ converter_VisToMaze(cell2.x))/2;
		int ymedioMaze = (converter_VisToMaze(cell1.y)+ converter_VisToMaze(cell2.y))/2;
		
		maze.setChar(' ', xmedioMaze, ymedioMaze);	//Apaga a parede entre as duas celulas
		
		return;
	}
	
	public boolean abreCaminhoAteParar()
	{
		while(moveGuideCell())
		{
		}
		
	}
	
	public boolean temNaoVisitadaAdjacente(Celula cell)
	{
		int yNorte = cell.y - 1;
		int ySul = cell.y + 1;
		int xEste = cell.x + 1;
		int xOeste = cell.x - 1;
		if(yNorte > converter_MazeToVis(maze.getTamy()))
			yNorte -= 1;
		//igual para as outras
		
	//Fazer a verificacao para cada uma das casas
		if(visitedCells[cell.x][cell.y] == '.')
	}
	
}