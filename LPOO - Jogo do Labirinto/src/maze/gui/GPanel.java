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

public class GPanel extends JPanel {
	private Image background;
	
	public GPanel() {
		background =  new ImageIcon("background.jpg").getImage();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);		
		g.drawImage(background, 10, 10, this);
		
	}	
}