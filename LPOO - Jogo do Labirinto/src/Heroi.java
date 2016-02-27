
public class Heroi {
	private int posx, posy;
	private boolean armado;
	
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
	}
	
	public void move_heroi(int direcao){
		// 0 - N, 1 - E, 2 - S, 3 - O
		
		switch(direcao)
		{
		case 0 :
			posy=posy-1;
			break;
		case 1 : 
			posx=posx+1;
			break;
		case 2 :
			posy=posy+1;
			break;
		case 3 : 
			posx=posx-1;
			break;
		default :
			break;
		}
	}
}
