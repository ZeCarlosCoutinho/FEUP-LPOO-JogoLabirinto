package logic;

public class Saida extends SerInanimado{
	private boolean chegou_heroi;
	
	public boolean isChegou_heroi() {
		return chegou_heroi;
	}

	public void setChegou_heroi(boolean chegou_heroi) {
		this.chegou_heroi = chegou_heroi;
	}

	public Saida(){
		posX=9;
		posY=5;	
		chegou_heroi = false;
		porCima = null;
	}
}
