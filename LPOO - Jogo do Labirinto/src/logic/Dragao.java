package logic;

public class Dragao extends SerAnimado {
	private boolean sleeping;

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
	}

	public Dragao(int x, int y) {
		posX = x;
		posY = y;
		alive = true;
		sleeping = false;
	}
}
