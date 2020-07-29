package spaceshooterpkg.src;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.game.src.classes.EntityA;
import com.game.src.classes.EntityB;
import com.game.src.libs.Animation;

public class Enemy extends GameObject implements EntityB {
  
  private Textures tex;
  Animation anim;
  private Controller c;
  private MainClass game;
  Random r=new Random();
  
  
  private int speed=r.nextInt(3)+1;
  
  public Enemy(double x, double y, Textures tex,Controller c,MainClass game) {
	  super(x,y);
	  this.tex=tex;
	  this.game=game;
	  this.c=c;
	  
	  anim = new Animation(5,tex.enemy[0],tex.enemy[1],tex.enemy[2]);
  }
  public void tick()  {
	  y+=speed;
	  if(x<=0)
		  x=0;
	 if(x>=640-32)
		  x=640-32;
	 if(y>(MainClass.SCALE*MainClass.HEIGHT))
	 {
		 speed=r.nextInt(10)+1;
		 y=-64;
		 x=r.nextInt(MainClass.SCALE*MainClass.WIDTH);
	 }
	 for(int i=0;i<game.ea.size();i++)
	 {
		 EntityA tempEnt=game.ea.get(i);
		 if(Physics.Collision(this,tempEnt))
			{	
			 	c.removeEntity(tempEnt);
			     MainClass.SCORE+=50;
			     if(MainClass.Health<190)
			        MainClass.Health+=5;
				c.removeEntity(this);
				game.setE_killed(game.getE_killed()+1);
				//System.out.println("Collision Detected");
			}
	 }
	
	 
	 anim.runAnimation();
  }
  
  public void render(Graphics g) {
	  anim.drawAnimation(g,x,y,0);
	//  g.drawImage(tex.enemy[0],(int)x,(int)y,null);
  }
  public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
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
}
