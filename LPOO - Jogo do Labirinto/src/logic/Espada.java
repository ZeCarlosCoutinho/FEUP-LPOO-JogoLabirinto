package logic;

public class Espada extends SerInanimado{
	private boolean naMao;
	
	public boolean isNaMao() {
		return naMao;
	}
	public void setNaMao(boolean na_mao) {
		this.naMao = na_mao;
	}
	
	public Espada(){
		posx=1;
		posy=8;
		naMao=false;
		porCima = null;
	}
}
