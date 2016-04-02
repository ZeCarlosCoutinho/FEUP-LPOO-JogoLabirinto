package maze.test;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;

import maze.logic.*;

public class TestarLabirintoDragaoAdicional {

	@Test(timeout = 1000)
	public void testGoodMoveDragon() {
		/*
		 * Labirinto lab = new Labirinto(); int oldX =
		 * lab.getDragon().getPosX(); int oldY = lab.getDragon().getPosY();
		 * Random generator = new Random();
		 * 
		 * lab.moveSerAnimado(lab.getDragon(), generator.nextInt(4));
		 * assertTrue("Error on x move!", lab.getDragon().getPosX() <= oldX+1 &&
		 * lab.getDragon().getPosX() >= oldX-1); assertTrue("Error on y move!",
		 * lab.getDragon().getPosY() <= oldY+1 && lab.getDragon().getPosY() >=
		 * oldY-1);
		 */

		Labirinto lab = new Labirinto();
		for (int i = 0; i < lab.getDragons().length; i++) {
			Dragao[] dragons = new Dragao[1];
			dragons[0] = new Dragao(5, 5);
			lab.setDragons(dragons);
			Random generator = new Random();

			boolean xMovement = false, yMovement = false, noMove = false;
			int initialX = dragons[i].getPosX(), initialY = dragons[i].getPosY();

			while (xMovement == false || yMovement == false || noMove == false) {
				lab.moveSerAnimado(lab.getDragons()[i], generator.nextInt(4));
				if (dragons[i].getPosX() != initialX)
					xMovement = true;
				else if (dragons[i].getPosY() != initialY)
					yMovement = true;
				else if (dragons[i].getPosX() == initialX || dragons[i].getPosY() == initialY)
					noMove = true;
				else
					fail("Error!");
			}
		}
	}

	@Test(timeout = 1000)
	public void testBadMoveDragon() {
		Labirinto lab = new Labirinto();
		for (int i = 0; i < lab.getDragons().length; i++) {
			Dragao[] dragons = new Dragao[1];
			dragons[0] = new Dragao(1, 1);
			lab.setDragons(dragons);
			Random generator = new Random();

			boolean xMovement = false, yMovement = false, noMove = false;
			int initialX = dragons[i].getPosX(), initialY = dragons[i].getPosY();

			while (xMovement == false || yMovement == false || noMove == false) {
				lab.moveSerAnimado(lab.getDragons()[i], generator.nextInt(4));
				if (dragons[i].getPosX() != initialX)
					xMovement = true;
				else if (dragons[i].getPosY() != initialY)
					yMovement = true;
				else if (dragons[i].getPosX() == initialX || dragons[i].getPosY() == initialY)
					noMove = true;
				else
					fail("Error!");
			}
		}
	}

	@Test(timeout = 1000)
	public void testSleepingDragon() {
		Labirinto lab = new Labirinto();
		Jogo game = new Jogo();

		for (int i = 0; i < lab.getDragons().length; i++) {
			Dragao[] dragons = new Dragao[1];
			dragons[0] = new Dragao(5, 5);
			boolean changeState = false;
			lab.getDragons()[i].setSleeping(false);

			while (changeState == false) {
				game.modificarEstadoDragao(lab.getDragons()[i]);
				if (lab.getDragons()[i].isSleeping())
					changeState = true;
				else if (!(lab.getDragons()[i].isSleeping()))
					changeState = false;
				else
					fail("Error!");
			}
		}
	}

	@Test(timeout = 1000)
	public void testNextPosition() {
		Labirinto lab = new Labirinto();
		Jogo game = new Jogo();
		Random generator = new Random();

		for (int i = 0; i < lab.getDragons().length; i++) {
			Dragao[] dragons = new Dragao[1];
			dragons[0] = new Dragao(5, 5);
			lab.getDragons()[i].setSleeping(false);
			boolean checkMove = false;
			int posInitialX = lab.getDragons()[i].getPosX();
			int posInitialY = lab.getDragons()[i].getPosY();

			while (checkMove == false) {
				game.modificarEstadoDragao(lab.getDragons()[i]);
				lab.moveSerAnimado(lab.getDragons()[i], generator.nextInt(4));
				if (lab.getDragons()[i].isSleeping()) {
					if (lab.getDragons()[i].getPosX() == posInitialX || lab.getDragons()[i].getPosX() == posInitialY)
						checkMove = true;
					else
						fail();
				} else if (lab.getDragons()[i].getPosX() == posInitialX + 1
						|| lab.getDragons()[i].getPosX() == posInitialY + 1
						|| lab.getDragons()[i].getPosX() == posInitialX - 1
						|| lab.getDragons()[i].getPosX() == posInitialY - 1
						|| lab.getDragons()[i].getPosX() == posInitialX || lab.getDragons()[i].getPosX() == posInitialY)
					checkMove = true;
				else
					fail();
			}
		}
	}

	@Test
	public void testOverlapElem() {
		Labirinto lab = new Labirinto();
		Heroi hero = new Heroi(1, 7);
		Espada sword = new Espada(1, 6);

		for (int i = 0; i < lab.getDragons().length; i++) {
			Dragao[] dragons = new Dragao[1];
			dragons[0] = new Dragao(1, 5);
			lab.setHero(hero);
			lab.setSword(sword);
			lab.setDragons(dragons);

			lab.moveSerAnimado(lab.getHero(), 0);
			assertEquals(true, sword.isSobreposto(hero));
			lab.moveSerAnimado(lab.getHero(), 0);
			assertEquals(true, dragons[i].isSobreposto(hero));
		}
	}

	@Test
	public void testDirection() {
		Jogo game = new Jogo();

		assertEquals(1, game.direcaoCharToInt('d'));
		assertEquals(0, game.direcaoCharToInt('w'));
		assertEquals(3, game.direcaoCharToInt('a'));
		assertEquals(2, game.direcaoCharToInt('s'));
	}
}
