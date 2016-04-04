package maze.logic;

public class Heroi extends SerAnimado {
	public static final String SerAnimado = null;
	private boolean armado;


	/**
	 * Retorna verdadeiro se o herói estiver armado
	 * @return
	 */
	public boolean isArmado() {
		return armado;
	}


	/**
	 * Altera estado do herói para armado (true) ou desarmado (false)
	 * @param armado
	 */
	public void setArmado(boolean armado) {
		this.armado = armado;
	}


	/**
	 * Constrói herói na posição (1,1)
	 */
	public Heroi() {
		posX = 1;
		posY = 1;
		armado = false;
		alive = true;
	}


	/**
	 * Constrói herói na posição (x,y)
	 * @param x
	 * @param y
	 */
	public Heroi(int x, int y) {
		posX = x;
		posY = y;
		armado = false;
		alive = true;

	}
	

	/**
	 * Constrói herói na posição da célula que é passada como parâmetro
	 * @param cell
	 */
	public Heroi(Celula cell) {
		posX = cell.x;
		posY = cell.y;
		armado = false;
		alive = true;

	}
}