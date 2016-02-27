
public class Espada {
	private int posx, posy;
	private boolean na_mao;
	
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
	}
}
