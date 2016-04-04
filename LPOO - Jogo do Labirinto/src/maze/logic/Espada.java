package maze.logic;

public class Espada extends SerInanimado {
	private boolean naMao;

	/**
	 * @brief Retorna true se o herói estiver armado
	 * @return true se espada está a ser utilizada
	 */
	public boolean isNaMao() {
		return naMao;
	}


	/**
	 * @brief Coloca espada a ser utilizada
	 * @param na_mao
	 */
	public void setNaMao(boolean na_mao) {
		this.naMao = na_mao;
	}


	/**
	 * @brief Constrói espada na posição (1, 8)
	 */
	public Espada() {
		posX = 1;
		posY = 8;
		naMao = false;
		porCima = null;
	}
	

	/**
	 * @brief Constrói espada na posição (x, y)
	 * @param x abcissa da célula
	 * @param y ordenada da célula
	 */
	public Espada(int x, int y) {
		posX = x;
		posY = y;
		naMao = false;
		porCima = null;
	}
	

	/**
	 * @brief Constrói espada na posição da célula
	 * @param cell célula onde vai construir a espada
	 */
	public Espada(Celula cell) {
		posX = cell.x;
		posY = cell.y;
		naMao = false;
		porCima = null;
	}
}
