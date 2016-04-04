package maze.logic;

public class SerInanimado extends Elemento {
	protected SerAnimado porCima;

	/**
	 * @brief Devolve o ser que fica por cima caso dois elementos estejam sobrepostos
	 * @return boolean
	 */
	public SerAnimado getPorcima() {
		return porCima;
	}

	/**
	 * @brief Altera o atributo por cima de modo a devolver o ser, neste caso animado, que fica por cima (vai ser desenhado) 
	 * caso haja sobreposiçao de elementos
	 * @param porcima
	 */
	public void setPorcima(SerAnimado porcima) {
		this.porCima = porcima;
	}

	/**
	 * @brief Reinicia o atributo por cima como vazio (nenhum elemento está por cima de outro)
	 */
	public void resetPorcima() {
		this.porCima = null;
	}
}
