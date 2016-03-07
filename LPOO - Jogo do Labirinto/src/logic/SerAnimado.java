package logic;


public class SerAnimado extends Elemento{
	protected boolean alive;
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public void move(int direcao)
	{
		switch(direcao)
		{
		case 0: //Norte
			posY -= 1;
			break;
		case 1: //Este
			posX += 1;
			break;
		case 2: //Sul 
			posY += 1;
			break;
		case 3: //Oeste
			posX -= 1;
			break;
		default:
			break;
		}
		
		return;
	}
	
}
