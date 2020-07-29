package spaceshooterpkg.src;

import java.awt.image.BufferedImage;

public class Textures {
public BufferedImage[] player=new BufferedImage[3];
public BufferedImage[] missile=new BufferedImage[3];
public BufferedImage[] enemy=new BufferedImage[3];
   private SpriteSheet ss;
   
   public Textures(MainClass game) {
	 ss=new SpriteSheet(game.getSpriteSheet());
	 getTextures();
   }
   private void getTextures()  {
	   player[0] = ss.grabImage(1,3,32,32);
	   player[1] = ss.grabImage(1,4,32,32);
	   player[2] = ss.grabImage(1,5,32,32);
	   
	   
	   missile[0] = ss.grabImage(3,3,32,32);
	   missile[1] = ss.grabImage(3,4,32,32);
	   missile[2] = ss.grabImage(3,5,32,32);
	   
	   
	   enemy[0]=ss.grabImage(2, 3, 32, 32);
	   enemy[1]=ss.grabImage(2, 4, 32, 32);
	   enemy[2]=ss.grabImage(2, 5, 32, 32);
   }
}
