package maze.logic;

public class Dragao extends SerAnimado {
	private boolean sleeping;
	private static int nDragoes;
	private static int nDragoesVivos;

	/**
	 * Retorna número de dragões
	 * @return número de dragões
	 */
	public static int getnDragoes() {
		return nDragoes;
	}

	/**
	 * Altera número de dragões
	 * @param nDragoes
	 */
	public static void setnDragoes(int nDragoes) {
		Dragao.nDragoes = nDragoes;
	}

	/**
	 * Retorna número de dragões vivos
	 * @return número de dragões vivos
	 */
	public static int getnDragoesVivos() {
		return nDragoesVivos;
	}

	/**
	 * Altera número de dragões vivos
	 * @param nDragoesVivos
	 */
	public static void setnDragoesVivos(int nDragoesVivos) {
		Dragao.nDragoesVivos = nDragoesVivos;
	}

	/**
	 * Verificação do estado do dragão
	 * @return true se o dragão estiver a dormir e false se estiver acordado
	 */
	public boolean isSleeping() {
		return sleeping;
	}
	
	/**
	 * Coloca o dragão a dormir (true) ou acorda-o (false)
	 * @param sleeping
	 */
	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}

	/**
	 * Constrói um dragão na posição (1,3)
	 */
	public Dragao() {
		posX = 1;
		posY = 3;
		alive = true;
		sleeping = false;
		nDragoes++;
		nDragoesVivos++;
	}

	/**
	 * Constrói um dragão na posição (x, y)
	 * @param x
	 * @param y
	 */
	public Dragao(int x, int y) {
		posX = x;
		posY = y;
		alive = true;
		sleeping = false;
		nDragoes++;
		nDragoesVivos++;
	}
	
	/**
	 * Constrói um dragão na posição da célula que recebe
	 * @param cell
	 */
	public Dragao(Celula cell) {
		posX = cell.x;
		posY = cell.y;
		alive = true;
		sleeping = false;
		nDragoes++;
		nDragoesVivos++;
	}
}
