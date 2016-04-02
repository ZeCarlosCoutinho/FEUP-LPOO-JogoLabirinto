package maze.logic;

public class SerAnimado extends Elemento {
	protected boolean alive;
	protected boolean userWarned;

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean isUserWarned() {
		return userWarned;
	}

	public void setUserWarned(boolean userWarned) {
		this.userWarned = userWarned;
	}

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
