package logic;

public class Dragao extends SerAnimado {
	private boolean sleeping;
	private static int nDragoes;
	private static int nDragoesVivos;

	public static int getnDragoes() {
		return nDragoes;
	}

	public static void setnDragoes(int nDragoes) {
		Dragao.nDragoes = nDragoes;
	}

	public static int getnDragoesVivos() {
		return nDragoesVivos;
	}

	public static void setnDragoesVivos(int nDragoesVivos) {
		Dragao.nDragoesVivos = nDragoesVivos;
	}

	public boolean isSleeping() {
		return sleeping;
	}

	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}

	public Dragao() {
		posX = 1;
		posY = 3;
		alive = true;
		sleeping = false;
		nDragoes++;
		nDragoesVivos++;
	}

	public Dragao(int x, int y) {
		posX = x;
		posY = y;
		alive = true;
		sleeping = false;
		nDragoes++;
		nDragoesVivos++;
	}
	
	public Dragao(Celula cell) {
		posX = cell.x;
		posY = cell.y;
		alive = true;
		sleeping = false;
		nDragoes++;
		nDragoesVivos++;
	}
}
