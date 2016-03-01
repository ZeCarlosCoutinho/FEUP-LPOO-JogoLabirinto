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
			posy -= 1;
			break;
		case 1: //Este
			posx += 1;
			break;
		case 2: //Sul 
			posy += 1;
			break;
		case 3: //Oeste
			posx -= 1;
			break;
		default:
			break;
		}
		
		return;
	}
	
}
