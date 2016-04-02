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
		
	}
}
