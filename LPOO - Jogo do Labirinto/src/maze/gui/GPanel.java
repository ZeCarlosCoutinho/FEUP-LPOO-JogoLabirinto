package maze.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import maze.logic.Labirinto;

public class GPanel extends JPanel {
	private Image background, hero, heroArmed, wall, sword, exit, dragon, dragonAsleep, dragonS, dragonAsleepS;
	private int x = 0, y = 0, width = 100, height = 100;

	private Labirinto lab;

	public void setLabirinto(Labirinto lab) {
		this.lab = lab;
	}

	public GPanel() {
		background = new ImageIcon("background.jpg").getImage();
		hero = new ImageIcon("hero.png").getImage();
		hero = hero.getScaledInstance(width, height, 1);
		heroArmed = new ImageIcon("heroArmed.png").getImage();
		heroArmed = heroArmed.getScaledInstance(width, height, 1);
		wall = new ImageIcon("wall.png").getImage();
		wall = wall.getScaledInstance(width, height, 1);
		sword = new ImageIcon("sword.png").getImage();
		sword = sword.getScaledInstance(width, height, 1);
		exit = new ImageIcon("exit.png").getImage();
		exit = exit.getScaledInstance(width, height, 1);
		dragon = new ImageIcon("dragon.png").getImage();
		dragon = dragon.getScaledInstance(width, height, 1);
		dragonAsleep = new ImageIcon("dragonAsleep.png").getImage();
		dragonAsleep = dragonAsleep.getScaledInstance(width, height, 1);
		dragonS = new ImageIcon("dragonS.png").getImage();
		dragonS = dragonS.getScaledInstance(width, height, 1);
		dragonAsleepS = new ImageIcon("dragonAsleepS.png").getImage();
		dragonAsleepS = dragonAsleepS.getScaledInstance(width, height, 1);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ySize = getHeight() / lab.getBoard().getTamy(), xSize = getWidth() / lab.getBoard().getTamx();
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

		for (int j = 0; j < lab.getBoard().getTamy(); j++) {
			for (int i = 0; i < lab.getBoard().getTamx(); i++) {

				if (lab.getBoard().getChar(i, j) == 'D')
					g.drawImage(dragon, i * xSize, j * ySize, xSize, ySize, this);
				if (lab.getBoard().getChar(i, j) == 'd')
					g.drawImage(dragonAsleep, i * xSize, j * ySize, xSize, ySize, this);
				if (lab.getBoard().getChar(i, j) == 'F')
					g.drawImage(dragonS, i * xSize, j * ySize, xSize, ySize, this);
				if (lab.getBoard().getChar(i, j) == 'f')
					g.drawImage(dragonAsleepS, i * xSize, j * ySize, xSize, ySize, this);
				if (lab.getBoard().getChar(i, j) == 'E')
					g.drawImage(sword, i * xSize, j * ySize, xSize, ySize, this);
				if (lab.getBoard().getChar(i, j) == 'S')
					g.drawImage(exit, i * xSize, j * ySize, xSize, ySize, this);
				if (lab.getBoard().getChar(i, j) == 'H')
					g.drawImage(hero, i * xSize, j * ySize, xSize, ySize, this);
				if (lab.getBoard().getChar(i, j) == 'A')
					g.drawImage(heroArmed, i * xSize, j * ySize, xSize, ySize, this);
				if (lab.getBoard().getChar(i, j) == 'X')
					g.drawImage(wall, i * xSize, j * ySize, xSize, ySize, this);
			}
		}

	}
}
