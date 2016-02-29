
public class Saida {
	private int posx, posy;
	private boolean chegou_heroi;
	
	public boolean isChegou_heroi() {
		return chegou_heroi;
	}

	public void setChegou_heroi(boolean chegou_heroi) {
		this.chegou_heroi = chegou_heroi;
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

	public Saida(){
		posx=9;
		posy=5;	
		chegou_heroi = false;
	}
}
