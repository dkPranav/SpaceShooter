package spaceshooterpkg.src;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.classes.EntityA;
import com.game.src.libs.Animation;


public class Bullet extends GameObject implements EntityA{

	
	
	//BufferedImage image;
	private Textures tex;
	private MainClass game;
	Animation anim;
	public Bullet(double x,double y,Textures tex,MainClass game) {
		super(x,y);
		this.tex=tex;
		this.game=game;
		
		anim=new Animation(5,tex.missile[0],tex.missile[1],tex.missile[2]);
		
		}
	public void tick() {
		y-=5;
		
	/*	if(Physics.Collision(this, game.eb))
		{
			
			System.out.println("Collision Detected");
		}*/
		
		anim.runAnimation();
	}
	public void render(Graphics g) {
		anim.drawAnimation(g, x, y,0);
		//g.drawImage(tex.missile[0],(int)x,(int)y,null);
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
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}
}
