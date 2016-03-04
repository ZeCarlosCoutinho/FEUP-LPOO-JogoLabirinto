package logic;

public class Heroi extends SerAnimado{
	public static final String SerAnimado = null;
	private boolean armado;
	
	public boolean isArmado() {
		return armado;
	}

	public void setArmado(boolean armado) {
		this.armado = armado;
	}
	
	public Heroi()
	{
		posx = 1;
		posy = 1;
		armado = false;
		alive = true;
	}
	
	public Heroi(int x, int y)
	{
		posx = x;
		posy = y;
		armado = false;
		alive = true;
		
	}
}