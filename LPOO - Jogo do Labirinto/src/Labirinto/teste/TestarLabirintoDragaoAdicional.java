package Labirinto.teste;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;
import logic.*;

public class TestarLabirintoDragaoAdicional {

	@Test(timeout = 1000)
	public void testMoveDragon() {
		/*
		 * Labirinto lab = new Labirinto(); int oldX =
		 * lab.getDragon().getPosX(); int oldY = lab.getDragon().getPosY();
		 * Random generator = new Random();
		 * 
		 * lab.move_SerAnimado(lab.getDragon(), generator.nextInt(4));
		 * assertTrue("Error on x move!", lab.getDragon().getPosX() <= oldX+1 &&
		 * lab.getDragon().getPosX() >= oldX-1); assertTrue("Error on y move!",
		 * lab.getDragon().getPosY() <= oldY+1 && lab.getDragon().getPosY() >=
		 * oldY-1);
		 */

		Labirinto lab = new Labirinto();
		Dragao dragon = new Dragao(5, 5);
		lab.setDragon(dragon);
		Random generator = new Random();

		boolean xMovement = false, yMovement = false, noMove = false;
		int initialX = dragon.getPosX(), initialY = dragon.getPosY();

		while (xMovement == false || yMovement == false || noMove == false) {
			lab.moveSerAnimado(lab.getDragon(), generator.nextInt(4));
			if (dragon.getPosX() != initialX)
				xMovement = true;
			else if (dragon.getPosY() != initialY)
				yMovement = true;
			else if (dragon.getPosX() == initialX || dragon.getPosY() == initialY)
				noMove = true;
			else
				fail("Error!");
		}
	}

	@Test(timeout = 1000)
	public void testSleepingDragon() {
		Labirinto lab = new Labirinto();
		Jogo game = new Jogo();

		boolean changeState = false;
		lab.getDragon().setSleeping(false);

		while (changeState == false) {
			game.modificarEstadoDragao(lab.getDragon());
			if (lab.getDragon().isSleeping())
				changeState = true;
			else if (!(lab.getDragon().isSleeping()))
				changeState = false;
			else
				fail("Error!");
		}
	}
	
	@Test(timeout = 1000)
	public void testNextPosition() {
		Labirinto lab = new Labirinto();
		Jogo game = new Jogo();
		Random generator = new Random();

		lab.getDragon().setSleeping(false);
		boolean checkMove = false;
		int posInitialX = lab.getDragon().getPosX();
		int posInitialY = lab.getDragon().getPosY();
		
		while (checkMove == false){
			game.modificarEstadoDragao(lab.getDragon());
			lab.moveSerAnimado(lab.getDragon(), generator.nextInt(4));
			if (lab.getDragon().isSleeping()){
				if (lab.getDragon().getPosX() == posInitialX || lab.getDragon().getPosX() == posInitialY)
					checkMove = true;
				else
					fail();
			}
			else if (lab.getDragon().getPosX() == posInitialX + 1 || lab.getDragon().getPosX() == posInitialY + 1 ||
					lab.getDragon().getPosX() == posInitialX - 1 || lab.getDragon().getPosX() == posInitialY - 1 ||
					lab.getDragon().getPosX() == posInitialX || lab.getDragon().getPosX() == posInitialY)
					checkMove = true;
			else
				fail();
		}
	}
	
	@Test(timeout=1000)
	public void overlapElem() {
		Labirinto lab = new Labirinto();
		Heroi hero = new Heroi(1, 7);
		Espada sword = new Espada(1, 6);
		Dragao dragon = new Dragao(1, 5);
		lab.setHero(hero);
		lab.setSword(sword);
		lab.setDragon(dragon);
		
		lab.moveSerAnimado(lab.getHero(), 0);
		assertEquals(true, sword.isSobreposto(hero));
		lab.moveSerAnimado(lab.getHero(), 0);
		assertEquals(true, dragon.isSobreposto(hero));
	}
}

