package maze.logic;

public class Elemento {
	protected int posX, posY;

	/**
	 * @brief Retorna posição x do elemento
	 * @return posição x do elemento
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @brief Altera posição x do elemento para posx (passado como parâmetro)
	 */
	public void setPosx(int posx) {
		this.posX = posx;
	}

	/**
	 * @brief Retorna posição y do elemento
	 * @return posição y do elemento
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * @brief Altera posição y do elemento para posy (passado como parâmetro)
	 */
	public void setPosy(int posy) {
		this.posY = posy;
	}

	/**
	 * @brief Verifica se dois elementos estão sobrepostos
	 * @return true caso os elementos estejam na mesma célula
	 */
	public boolean isSobreposto(Elemento elem) {
		if(elem == null)
			return false;
		if (posX == elem.getPosX() && posY == elem.getPosY() && elem != this)
			return true;
		else
			return false;
	}

	/**
	 * @brief Constrói elemento na posição (x, y)
	 */
	public Elemento() {
		posX = 0;
		posY = 0;
	}
}