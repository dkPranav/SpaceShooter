package spaceshooterpkg.src;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.game.src.classes.EntityA;
import com.game.src.classes.EntityB;

public class Controller {

 private LinkedList<EntityA> ea=new LinkedList<EntityA>();
 private LinkedList<EntityB> eb=new LinkedList<EntityB>();
 
 EntityA enta;
 EntityB entb;
 Random r = new Random();
 
 Bullet TempBullet;
 Enemy TempEnemy;
 
 MainClass game;
 Textures tex;
 
 public Controller(MainClass game,Textures tex) {
	 this.game=game;
	 this.tex=tex;
	 
	// for(int x=0;x<(MainClass.WIDTH*MainClass.SCALE);x+=64)
	 
//	 addEntity(new Enemy(r.nextInt(MainClass.WIDTH*MainClass.SCALE),0,tex));
	 
	 }
 
 public void createEnemy(int e_count) {
	 for(int i=0;i<e_count;i++) {
		 addEntity(new Enemy(r.nextInt(640),-10,tex,this,game));
	 }
 }

 public void tick()
 {
	for(int i=0;i<ea.size();i++) {
		enta=ea.get(i);
		enta.tick();
	}
	for(int i=0;i<eb.size();i++) {
		entb=eb.get(i);
		entb.tick();
	}
}
 public void render(Graphics g) {
	 for(int i=0;i<ea.size();i++) {
			enta=ea.get(i);
			
			enta.render(g);
		}
	 for(int i=0;i<eb.size();i++) {
			entb=eb.get(i);
			
			entb.render(g);
		}
} 
 public void addEntity(EntityA block) {
	 ea.add(block);
	  }
 public void removeEntity(EntityA block) {
	 ea.remove(block);
	  }
 public void addEntity(EntityB block) {
	 eb.add(block);
	  }
 public void removeEntity(EntityB block) {
	 eb.remove(block);
	  }
 public LinkedList<EntityA> getEntityA(){
	 return ea;
 }
 public LinkedList<EntityB> getEntityB(){
	 return eb;
 }
}

/* for(int i=0;i<b.size();i++) {
TempBullet=b.get(i);

if(TempBullet.getY()<0)
	  removeBullet(TempBullet);

TempBullet.tick();
}
for(int i=0;i<e.size();i++) {
TempEnemy=e.get(i);

if(TempEnemy.getY()<0)
 removeEnemy(TempEnemy);


TempEnemy.tick();
}*/


/*	 for(int i=0;i<b.size();i++) {
TempBullet=b.get(i);

TempBullet.render(g);
}
for(int i=0;i<e.size();i++) {
TempEnemy=e.get(i);

TempEnemy.render(g);
}*/


/*public void addBullet(Bullet block) {
b.add(block);
}
public void removeBullet(Bullet block) {
b.remove(block);
}
public void addEnemy(Enemy block) {
e.add(block);
}
public void removeEnemy(Enemy block) {
e.remove(block);
}*/
