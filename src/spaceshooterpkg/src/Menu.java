package spaceshooterpkg.src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	 
	public Rectangle playButton=new Rectangle(MainClass.WIDTH/2+120,150,100,50);
	public Rectangle helpButton=new Rectangle(MainClass.WIDTH/2+120,250,100,50);
	public Rectangle quitButton=new Rectangle(MainClass.WIDTH/2+120,350,100,50);
	
	
	public void render(Graphics g) {
		Graphics2D g2d=(Graphics2D)g;
		
		
		
		Font fnt0 = new Font("arial",Font.BOLD,50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("SpaceImpact", MainClass.WIDTH/2, MainClass.HEIGHT/2);
		
		Font fnt1 = new Font("arial",Font.BOLD,32);
		g.setFont(fnt1);
		g.drawString("Play",playButton.x+20,playButton.y+35);
		g.drawString("Help",helpButton.x+20,helpButton.y+35);
		g.drawString("Quit",quitButton.x+20,quitButton.y+35);
		g2d.draw(playButton);
		g2d.draw(helpButton);
		g2d.draw(quitButton);
	}
}
