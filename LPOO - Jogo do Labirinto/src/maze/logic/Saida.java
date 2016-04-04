package maze.logic;

public class Saida extends SerInanimado {
	private boolean chegou_heroi;

	/**
	 * @brief Retorna verdadeiro se o herói chegar à celula da saida com arma e tiver morto todos os dragoes
	 * @return boolean
	 */
	public boolean isChegou_heroi() {
		return chegou_heroi;
	}

	/**
	 * @brief Altera o atributo chegou_heroi de modo a que se for verdadeiro ele está na saida, caso contrario nao está
	 * @param chegou_heroi
	 */
	public void setChegou_heroi(boolean chegou_heroi) {
		this.chegou_heroi = chegou_heroi;
	}

	/**
	 * @brief Constroi Saida na posiçao (9,5)
	 */
	public Saida() {
		posX = 9;
		posY = 5;
		chegou_heroi = false;
		porCima = null;
	}
	
	/**
	 * @brief Constroi Saida na posiçao (x,y)
	 * @param x abcissa onde é criada a saida
	 * @param y ordenada onde é criada a saida
	 */
	public Saida(int x, int y) {
		posX = x;
		posY = y;
		chegou_heroi = false;
		porCima = null;
	}
}
