package Labirinto.teste;
import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;
import logic.*;

public class TestarLabirintoDragaoAdicional {
	
	@Test
	public void testMoveDragon() {
		Labirinto lab = new Labirinto();
		int oldX = lab.getDragon().getPosX();
		int oldY = lab.getDragon().getPosY();
		Random generator = new Random();
				
		lab.move_SerAnimado(lab.getDragon(), generator.nextInt(4));
		assertTrue("Error on x move!", lab.getDragon().getPosX() <= oldX+1 && lab.getDragon().getPosX() >= oldX-1);
		assertTrue("Error on y move!", lab.getDragon().getPosY() <= oldY+1 && lab.getDragon().getPosY() >= oldY-1);
	}
	
	//está a adormecer?
	//está a acordar?
	//dragao move-se aleatoriamente para casa adjacente ao heroi e mata-o
	//dragao move-se para posiçao da espada
	
}
