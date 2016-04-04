package maze.logic;

public class Espada extends SerInanimado {
	private boolean naMao;

	/**
	 * Retorna true se o heróiestiver armado
	 * @return
	 */
	public boolean isNaMao() {
		return naMao;
	}


	/**
	 * Coloca espada a ser utilizada
	 * @param na_mao
	 */
	public void setNaMao(boolean na_mao) {
		this.naMao = na_mao;
	}


	/**
	 * Constrói espada na posição (1, 8)
	 */
	public Espada() {
		posX = 1;
		posY = 8;
		naMao = false;
		porCima = null;
	}
	

	/**
	 * Constrói espada na posição (x, y)
	 * @param x
	 * @param y
	 */
	public Espada(int x, int y) {
		posX = x;
		posY = y;
		naMao = false;
		porCima = null;
	}
	

	/**
	 * Constrói espada na posição da célula
	 * @param cell
	 */
	public Espada(Celula cell) {
		posX = cell.x;
		posY = cell.y;
		naMao = false;
		porCima = null;
	}
}
