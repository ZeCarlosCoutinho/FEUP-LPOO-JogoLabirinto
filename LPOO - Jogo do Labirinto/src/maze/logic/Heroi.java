package maze.logic;

public class Heroi extends SerAnimado {
	public static final String SerAnimado = null;
	private boolean armado;

	public boolean isArmado() {
		return armado;
	}

	public void setArmado(boolean armado) {
		this.armado = armado;
	}

	public Heroi() {
		posX = 1;
		posY = 1;
		armado = false;
		alive = true;
	}

	public Heroi(int x, int y) {
		posX = x;
		posY = y;
		armado = false;
		alive = true;

	}
	
	public Heroi(Celula cell) {
		posX = cell.x;
		posY = cell.y;
		armado = false;
		alive = true;

	}
}