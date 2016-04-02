package maze.logic;

public class Elemento {
	protected int posX, posY;

	public int getPosX() {
		return posX;
	}

	public void setPosx(int posx) {
		this.posX = posx;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosy(int posy) {
		this.posY = posy;
	}

	public boolean isSobreposto(Elemento elem) {
		if (posX == elem.getPosX() && posY == elem.getPosY() && elem != this)
			return true;
		else
			return false;
	}

	public Elemento() {
		posX = 0;
		posY = 0;
	}
}