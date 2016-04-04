package maze.logic;

public class Celula {
	public int x, y;
	
	/**
	 * @brief Constrói célula na posição (x, y)
	 * @param x abcissa da célula
	 * @param y ordenada da célula
	 */
	public Celula(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * @brief Constrói célula
	 * @param c célula a copiar
	 */
	public Celula(Celula c)
	{
		this.x = c.x;
		this.y = c.y;
	}
	
	/**
	 * @brief Constrói célula na posição (0,0)
	 */
	public Celula() {
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * @brief Verificar se determinada célula existe
	 * @param elem objeto de comparação
	 * @return true se já existir uma célula criada na posição do elemento que é passado como parametro
	 */
	public boolean equals(Object elem)
	{
		if(elem == null)
			return false;
		
		if(!(elem instanceof Elemento))
			return false;
		
		return this.x == ((Elemento)elem).getPosX() && this.y == ((Elemento)elem).getPosY();
	}
}
