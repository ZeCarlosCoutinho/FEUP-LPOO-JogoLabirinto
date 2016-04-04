package maze.logic;

public class Heroi extends SerAnimado {
	public static final String SerAnimado = null;
	private boolean armado;


	/**
	 * @brief Retorna verdadeiro se o herói estiver armado
	 * @return true se herói tem a arma; false se estiver desarmado
	 */
	public boolean isArmado() {
		return armado;
	}


	/**
	 * @brief Altera estado do herói para armado (true) ou desarmado (false)
	 * @param armado
	 */
	public void setArmado(boolean armado) {
		this.armado = armado;
	}


	/**
	 * @brief Constrói herói na posição (1,1)
	 */
	public Heroi() {
		posX = 1;
		posY = 1;
		armado = false;
		alive = true;
	}


	/**
	 * @brief Constrói herói na posição (x,y)
	 * @param x abcissa da célula onde é construído o herói
	 * @param y ordenada da célula onde é construído o herói
	 */
	public Heroi(int x, int y) {
		posX = x;
		posY = y;
		armado = false;
		alive = true;

	}
	

	/**
	 * @brief Constrói herói na posição da célula que é passada como parâmetro
	 * @param cell célula onde é construído o herói
	 */
	public Heroi(Celula cell) {
		posX = cell.x;
		posY = cell.y;
		armado = false;
		alive = true;

	}
}