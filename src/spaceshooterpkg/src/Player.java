package spaceshooterpkg.src;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.classes.EntityA;
import com.game.src.classes.EntityB;
import com.game.src.libs.Animation;

public class Player extends GameObject implements EntityA {

 
 private double velX=0;
 private double velY=0;
		 
 
 private BufferedImage player;
 private Textures tex;
 
 MainClass game;
 Animation anim;
 Controller c;
 
 
  public Player(double x, double y,Textures tex,MainClass game, Controller c) {
	  super(x,y);
	  this.tex=tex;
	  this.game=game;
	  this.c=c;
	 // SpriteSheet ss=new SpriteSheet(game.getSpriteSheet());
	  
	//  player=ss.grabImage(1, 1, 32, 32);
	  anim = new Animation(5,tex.player[0],tex.player[1],tex.player[2]);
	  
  }
  
  public void tick() {
	 x+=velX;
	 y+=velY;
	 
	 if(x<=0)
		  x=0;
	 if(x>=640-32)
		  x=640-32;
	 if(y<=0)
		  y=0;
	 if(y>=470-32)
		  y=470-32;
	 
	 for(int i=0;i<game.eb.size();i++)
	 {
		 EntityB tempEnt = game.eb.get(i);
		 
		 if(Physics.Collision(this,tempEnt))
		 {
			 MainClass.SCORE+=50;
			 if(MainClass.Health>30) {
			 c.removeEntity(tempEnt);
			 MainClass.Health-=40;
			 game.setE_killed(game.getE_killed()+1);
			 }
			 else {
				
				 c.removeEntity(tempEnt);
				 MainClass.Health-=30;
				 game.setE_killed(0);
				 game.setE_count(5);
			 }
		 }
	 }
	 
	 anim.runAnimation();
  }
  
  public void render(Graphics g) {
	 anim.drawAnimation(g, x, y,0);
	 // g.drawImage(tex.player[0],(int)x,(int)y,null);
  }


public double getX() {
	return x;
	}
public double getY() {	
	return y;
	}
public void setX(double x) {
	this.x=x;
	}
public void setY(double y) {
	this.y=y;
	}
public void setVelX(double velX) {
	this.velX=velX;
}
public void setVelY(double velY) {
	this.velY=velY;
}
public Rectangle getBounds() {
	return new Rectangle((int)x,(int)y,32,32);
}

}