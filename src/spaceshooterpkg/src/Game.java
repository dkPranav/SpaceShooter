package spaceshooterpkg.src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Game {
	Player p;
	Controller c;
	MainClass game;
	
	public Game(MainClass game,Player p,Controller c) {
		this.game=game;
		this.p=p;
		this.c=c;
		
	}
	
	public void render(Graphics g,BufferedImage background) {
		
		
		String scr=String.valueOf(MainClass.SCORE);
		
		
		
		 
		g.drawImage(background,0,0,null);
		p.render(g);
		c.render(g);
		
		g.setColor(Color.gray);
		g.fillRect(5, 5, 200, 20);
		
		
	if(MainClass.Health>=40) {	
		g.setColor(Color.green);
		g.fillRect(5, 5, MainClass.Health, 20);
	}else if(MainClass.Health<40) {	
		g.setColor(Color.red);
		g.fillRect(5, 5, MainClass.Health, 20);
	}
		g.setColor(Color.white);
		g.drawRect(5, 5, 200, 20);
		
		Font fnt0 = new Font("arial",Font.BOLD,10);
		g.setFont(fnt0);
		g.setColor(Color.white);
/* d  /* dfd* */ */		g.drawString("Score: "+scr , 5, 40);
	}
	
}

