package logic;

public class Dragao extends SerAnimado{
	private boolean sleeping;
	
	public boolean isSleeping() {
		return sleeping;
	}

	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}

	
	public Dragao(){
		posx = 1;
		posy = 3;	
		alive = true;
		sleeping = false;
	}
	
	public Dragao(int x, int y)
	{
		posx = x;
		posy = y;
		alive = true;
		sleeping = false;
	}
}
