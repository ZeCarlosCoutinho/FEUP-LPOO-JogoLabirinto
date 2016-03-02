package logic;

public class Elemento {
	protected int posx, posy;
	
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

	public boolean isSobreposto(Elemento elem)
	{
		if(posx == elem.getPosx() && posy == elem.getPosy() && elem != this)
			return true;
		else
			return false;
	}
	public Elemento()
	{
		posx = 0;
		posy = 0;
	}
}