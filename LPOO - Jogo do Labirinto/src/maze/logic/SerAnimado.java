package maze.logic;

public class SerAnimado extends Elemento {
	protected boolean alive;
	protected boolean userWarned;

	/**
	 * @brief Devolve o estado do ser animado (vivo ou morto)
	 * @return bollean true se estiver vivo e false se estiver morto
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * @brief Coloca o ser animado vivo se "alive" for passado como true, e morto se o parametro for passaado com false
	 * @param alive
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * @brief Funçao utilizada para verificar se o utilizador foi avisado (por exemplo: avisar quando mata o dragao)
	 * @return boolean
	 */
	public boolean isUserWarned() {
		return userWarned;
	}

	/**
	 * @brief Coloca o atributo a verdadeiro ou a falsa, para considerar que o utilizador foi avisado ou não, respetivamente
	 * @param userWarned
	 */
	public void setUserWarned(boolean userWarned) {
		this.userWarned = userWarned;
	}

	/**
	 * @brief Função responsável por mover os seres animados (dragao e heroi) 0-Norte, 1-Este, 2-Sul, 3-Oeste, 4-Mantém posicao
	 * @param direcao int
	 */
	public void move(int direcao) {
		switch (direcao) {
		case 0: // Norte
			posY -= 1;
			break;
		case 1: // Este
			posX += 1;
			break;
		case 2: // Sul
			posY += 1;
			break;
		case 3: // Oeste
			posX -= 1;
			break;
		case 4: // Manter
			break;
		default:
			break;
		}

		return;
	}

}
