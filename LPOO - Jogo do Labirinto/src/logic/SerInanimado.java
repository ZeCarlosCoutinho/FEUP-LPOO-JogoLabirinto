package logic;

public class SerInanimado extends Elemento{
	protected SerAnimado porCima;

	public SerAnimado getPorcima() {
		return porCima;
	}

	public void setPorcima(SerAnimado porcima) {
		this.porCima = porcima;
	}
	
	public void resetPorcima()
	{
		this.porCima = null;
	}
}
