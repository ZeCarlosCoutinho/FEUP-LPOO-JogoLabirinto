package logic;

public class Espada extends SerInanimado {
	private boolean naMao;

	public boolean isNaMao() {
		return naMao;
	}

	public void setNaMao(boolean na_mao) {
		this.naMao = na_mao;
	}

	public Espada() {
		posX = 1;
		posY = 8;
		naMao = false;
		porCima = null;
	}
	
	public Espada(int x, int y) {
		posX = x;
		posY = y;
		naMao = false;
		porCima = null;
	}
	
	public Espada(Celula cell) {
		posX = cell.x;
		posY = cell.y;
		naMao = false;
		porCima = null;
	}
}
