
public class Heroi {
	private int posx, posy;
	private boolean armado;
	private boolean morto;
	
	public boolean isMorto() {
		return morto;
	}

	public void setMorto(boolean morto) {
		this.morto = morto;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public boolean isArmado() {
		return armado;
	}

	public void setArmado(boolean armado) {
		this.armado = armado;
	}
	
	public Heroi()
	{
		posx=1;
		posy=1;
		armado=false;
		morto = false;
	}
	
	public void move_heroi(char direcao){
		// W - N, A - E, S - S, D - O
		
		switch(direcao)
		{
		case 'w':
			posy=posy-1;
			break;
		case 'a': 
			posx=posx+1;
			break;
		case 's':
			posy=posy+1;
			break;
		case 'd': 
			posx=posx-1;
			break;
		default :
			break;
		}
	}
}