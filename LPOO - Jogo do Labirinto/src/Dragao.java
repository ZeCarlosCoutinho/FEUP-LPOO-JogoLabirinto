//dragaom
public class Dragao {
	private int posx, posy;
	private boolean morto;
	
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
	public boolean isMorto() {
		return morto;
	}
	public void setMorto(boolean morto) {
		this.morto = morto;
	}
	
	public Dragao(){
		posx=1;
		posy=3;	
		morto=false;
	}
}
