package logic;

public class Heroi extends SerAnimado{
	private boolean armado;
	
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
		alive = true;
	}
}