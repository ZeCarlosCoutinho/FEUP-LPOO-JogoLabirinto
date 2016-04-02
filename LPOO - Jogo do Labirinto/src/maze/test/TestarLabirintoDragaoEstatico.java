package maze.test;

import static org.junit.Assert.*;
import org.junit.Test;

import maze.logic.*;

public class TestarLabirintoDragaoEstatico {

	@Test
	public void test2a() {
		Labirinto lab = new Labirinto();
		lab.getHero();

		lab.moveSerAnimado(lab.getHero(), 1);
		assertEquals(2, lab.getHero().getPosX());
		System.out.println(lab.getHero().getPosX());
		assertEquals(1, lab.getHero().getPosY());
	}

	@Test
	public void test2b() {
		Labirinto lab = new Labirinto();

		lab.moveSerAnimado(lab.getHero(), 0);
		assertEquals(1, lab.getHero().getPosX());
		assertEquals(1, lab.getHero().getPosY());
	}

	@Test
	public void test2c() {
		Labirinto lab = new Labirinto();
		Heroi hero = new Heroi(1, 7);
		lab.setHero(hero);

		lab.moveSerAnimado(lab.getHero(), 2);
		assertEquals(true, lab.getHero().isArmado());
		assertEquals(true, lab.getSword().isNaMao());
	}

	@Test
	public void test2d() {
		Labirinto lab = new Labirinto();
		lab.getHero();

		lab.moveSerAnimado(lab.getHero(), 2);
		assertEquals(false, lab.getHero().isArmado());
		assertEquals(false, lab.getHero().isAlive());
	}

	@Test
	public void test2e() {
		Labirinto lab = new Labirinto();
		Heroi hero = new Heroi(1, 5);
		hero.setArmado(true);
		lab.setHero(hero);

		lab.moveSerAnimado(lab.getHero(), 0);
		assertEquals(true, lab.getHero().isArmado());
		/*
		 * lab.move_SerAnimado(lab.getHero(), 0);
		 * lab.move_SerAnimado(lab.getHero(), 0);
		 * lab.move_SerAnimado(lab.getHero(), 0);
		 * lab.move_SerAnimado(lab.getHero(), 0);
		 */
		for (int i = 0; i < lab.getDragons().length; i++)
			assertEquals(false, lab.getDragons()[i].isAlive());
	}

	@Test
	public void test2f() {
		Labirinto lab = new Labirinto();
		for (int i = 0; i < lab.getDragons().length; i++) {
			Heroi hero = new Heroi(8, 5);
			hero.setArmado(true);
			lab.getDragons()[i].setAlive(false);
			lab.setHero(hero);

			lab.moveSerAnimado(lab.getHero(), 1);
			assertEquals(true, lab.getHero().isArmado());
			/*
			 * lab.move_SerAnimado(lab.getHero(), 0);
			 * lab.move_SerAnimado(lab.getHero(), 0);
			 * lab.move_SerAnimado(lab.getHero(), 0);
			 * lab.move_SerAnimado(lab.getHero(), 0);
			 */
			assertEquals(false, lab.getDragons()[i].isAlive());
			/*
			 * lab.move_SerAnimado(lab.getHero(), 2);
			 * lab.move_SerAnimado(lab.getHero(), 1);
			 * lab.move_SerAnimado(lab.getHero(), 1);
			 * lab.move_SerAnimado(lab.getHero(), 1);
			 * lab.move_SerAnimado(lab.getHero(), 1);
			 * lab.move_SerAnimado(lab.getHero(), 1);
			 * lab.move_SerAnimado(lab.getHero(), 2);
			 * lab.move_SerAnimado(lab.getHero(), 2);
			 * lab.move_SerAnimado(lab.getHero(), 2);
			 * lab.move_SerAnimado(lab.getHero(), 1);
			 * lab.move_SerAnimado(lab.getHero(), 1);
			 * lab.move_SerAnimado(lab.getHero(), 0);
			 * lab.move_SerAnimado(lab.getHero(), 0);
			 * lab.move_SerAnimado(lab.getHero(), 0);
			 * lab.move_SerAnimado(lab.getHero(), 1);
			 */
			assertEquals(true, lab.getExit().isChegou_heroi());
		}
	}

	@Test
	public void test2g() {
		Labirinto lab = new Labirinto();
		Heroi hero = new Heroi(8, 5);
		lab.setHero(hero);

		lab.moveSerAnimado(lab.getHero(), 1);
		assertEquals(false, lab.getHero().isArmado());
		assertEquals(false, lab.getExit().isChegou_heroi());
	}

	@Test
	public void test2h() {
		Labirinto lab = new Labirinto();
		Heroi hero = new Heroi(8, 5);
		hero.setArmado(true);
		lab.setHero(hero);

		lab.moveSerAnimado(lab.getHero(), 1);
		assertEquals(true, lab.getHero().isArmado());
		assertEquals(false, lab.getExit().isChegou_heroi());
	}
}
