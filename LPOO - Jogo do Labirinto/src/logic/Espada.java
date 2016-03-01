package logic;

public class Espada extends SerInanimado{
	private boolean na_mao;
	
	public boolean isNa_mao() {
		return na_mao;
	}
	public void setNa_mao(boolean na_mao) {
		this.na_mao = na_mao;
	}
	
	public Espada(){
		posx=1;
		posy=8;
		na_mao=false;
		porcima = null;
	}
}
