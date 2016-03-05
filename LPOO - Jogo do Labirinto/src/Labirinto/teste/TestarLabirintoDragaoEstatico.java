package Labirinto.teste;
import static org.junit.Assert.*;
import org.junit.Test;
import logic.*;

public class TestarLabirintoDragaoEstatico {

	@Test
	public void test2a() {
		Labirinto lab = new Labirinto();
		Heroi hero = new Heroi();
		
		lab.move_SerAnimado(hero, 1);
		assertEquals(2, hero.getPosx());
		assertEquals(1, hero.getPosy());	
	}
	
	@Test
	public void test2b() {
		Labirinto lab = new Labirinto();
		Heroi hero = new Heroi();
		
		lab.move_SerAnimado(hero, 0);
		assertEquals(1, hero.getPosx());
		assertEquals(1, hero.getPosy());
	}
	
	//@Test
	public void test2c() {
		Labirinto lab = new Labirinto();
		Heroi hero = new Heroi(1, 7);
		Espada sword = new Espada();

		lab.move_SerAnimado(hero, 1);
		System.out.println(hero.getPosy());
		assertEquals(true, hero.isArmado());
		assertEquals(true, sword.isNa_mao());
	}

}
