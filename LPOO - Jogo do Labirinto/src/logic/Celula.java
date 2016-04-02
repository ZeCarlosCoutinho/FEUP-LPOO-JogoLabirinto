package logic;

public class Celula {
	public int x, y;
	
	public Celula(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public Celula(Celula c)
	{
		this.x = c.x;
		this.y = c.y;
	}
	
	public Celula() {
		this.x = 0;
		this.y = 0;
	}
	
	public boolean equals(Elemento elem)
	{
		if(elem == null)
			return false;
		
		if(this.x == elem.getPosX() && this.y == elem.getPosY())
			return true;
		else
			return false;
	}
}
