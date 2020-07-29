package spaceshooterpkg.src;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JFrame;
import com.game.src.classes.EntityA;
import com.game.src.classes.EntityB;

public class MainClass extends Canvas implements Runnable {
	
	public static final long serialVersionUID =1L;
	public static final int WIDTH =320;
	public static final int HEIGHT =WIDTH /12*9;
	public static final int SCALE=2;
	public final String TITLE="Space Game";
	private boolean running=false;
	private Thread thread;
	
	private BufferedImage imageA = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet=null;
	private BufferedImage background=null;
	private BufferedImage background2=null;
	
	private boolean is_shooting=false;
	
	 

	private int e_count =5;
	private int  e_killed=0;
	
	
	private Player p;
	private Controller c;
	private Textures tex;
	private Menu menu;
	private Game gg;
	private Reset re;
	
	public LinkedList<EntityA> ea;
	public LinkedList<EntityB> eb;
	
	public static int Health=100*2;
	public static int SCORE=0;
	
	public static enum STATE {
		MENU,
		GAME
	};
	
	public static STATE state=STATE.MENU;
	//private BufferedImage player;
	
public void init() throws IOException {
	 requestFocus();
	 BufferedImageLoader loader= new BufferedImageLoader();
	 spriteSheet=loader.loadImage("res/spritesheet3.png");
	 background=loader.loadImage("res/bg.png");
	 background2=loader.loadImage("res/bg3.png");
	 
	// SpriteSheet ss=new SpriteSheet(spriteSheet);
	// player=ss.grabImage(1,1,32,32);
	 
	this.addKeyListener(new KeyInput(this));
	this.addMouseListener(new MouseInput());
	//requestFocus();
	tex = new Textures(this);
	
	c= new Controller(this,tex);
	p = new Player(640/2,400,tex,this,c);
	menu=new Menu();
	gg= new Game(this,p,c);
	
	ea=c.getEntityA();
	eb=c.getEntityB();
	
	c.createEnemy(e_count);
}

private synchronized void start() {
		if(running)
			 return;
		
		running=true;
		thread = new Thread(this);
		thread.start();
		
}
	
private synchronized void stop() {
		if(!running)
			return;
		
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
}

public void run() {
	try {
		init();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	long lTime=System.nanoTime();
	final double amountOfTicks=60.0;
	double ns=1000000000 / amountOfTicks;
	double delta=0;
	int updates=0;
	int fps=0;
	long timer = System.currentTimeMillis();
	while(running) {
		long now=System.nanoTime();
		delta +=(now - lTime)/ns;
		lTime=now;
		if(delta >= 1) {
			tick();
			updates++;
			delta--;
			
		}
		render();
		fps++; 
		
		if(System.currentTimeMillis() - timer > 1000) {
			timer+=1000;
			System.out.println(updates + "Ticks, Fps "+fps);
			updates=0;
			fps=0;
		}
	
	}
	stop();
}

private void tick() {
	if(state == STATE.GAME) {
	p.tick();
	c.tick();
	}
	if(e_killed >= e_count)
	{
		e_count +=2;
		e_killed = 0;
		c.createEnemy(e_count);
	}
	if(Health <= 0)
	{
		state=STATE.MENU;
		re= new Reset(this,c);
		c.createEnemy(e_count);
		
	}
	
}


private void render() {
	 BufferStrategy bs=this.getBufferStrategy();
	 
	 if(bs==null) {
		 createBufferStrategy(3);
		 return;
	 }
	Graphics g= bs.getDrawGraphics(); 
	////////////////////////////////////
	
	g.drawImage(imageA, 0, 0, getWidth(), getHeight(), this);
//	g.drawImage(player,100,100,this);
//	g.drawImage(background,0,0,null);
	if(state == STATE.GAME) {
		gg.render(g,background);
	/*	g.drawImage(background,0,0,null);
		p.render(g);
		c.render(g);
		
		g.setColor(Color.gray);
		g.fillRect(5, 5, 200, 20);
		
	if(Health>=40) {	
		g.setColor(Color.green);
		g.fillRect(5, 5, Health, 20);
	}else if(Health<40) {	
		g.setColor(Color.red);
		g.fillRect(5, 5, Health, 20);
	}
		g.setColor(Color.white);
		g.drawRect(5, 5, 200, 20);
	*/
	}else if(state == STATE.MENU) 
	 {
		g.drawImage(background2,0,0,null);
		menu.render(g);
		//g.drawImage(background2,-50,-50,null);
	 }
	////////////////////////////////////
	
	g.dispose();
	bs.show();
	 
	 
}

public void keyPressed(KeyEvent e) {
	int key=e.getKeyCode();
	if(state == STATE.GAME) {
	switch(key)
	{
	case KeyEvent.VK_D : p.setVelX(5);
	    break;
	case KeyEvent.VK_A : p.setVelX(-5);
        break;
	case KeyEvent.VK_S : p.setVelY(5);
        break;
	case KeyEvent.VK_W : p.setVelY(-5);
        break;
    default : break;    
	}
	
	/*
	if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
		p.setVelX(5);
	}if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
		p.setVelX(-5);
	}if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
		p.setVelY(5);
	}if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
		p.setVelY(-5);
	}*/
	if(key == KeyEvent.VK_SPACE && !is_shooting) {
		is_shooting=true;
		c.addEntity(new Bullet(p.getX(),p.getY()-22,tex, this));
	}
	}
}
	   
public void keyReleased(KeyEvent e) {
	int key=e.getKeyCode();
	if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
		p.setVelX(0);
	}else if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
		p.setVelX(0);
	}else if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
		p.setVelY(0);
	}else if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
		p.setVelY(0);
	}else if(key == KeyEvent.VK_SPACE) {
		is_shooting=false;
	}
}
	
 public static void main(String args[]) {
	 MainClass game=new MainClass();
	 //MainClass a2 = new MainClass(120,120);
	 game.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
	 game.setMaximumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
	 game.setMinimumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
	 
	 JFrame frame=new JFrame(game.TITLE);
	 frame.add(game);
	 frame.pack();
	// frame.setSize(640, 480);
	 frame.setResizable(false);
	 frame.setLocationRelativeTo(null);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frame.setVisible(true); 
	 
	 game.start(); 
	 
 }
 
 public BufferedImage getSpriteSheet() {
	 return spriteSheet;
 }
 public int getE_count() {
		return e_count;
	}

	public void setE_count(int e_count) {
		this.e_count = e_count;
	}

	public int getE_killed() {
		return e_killed;
	}

	public void setE_killed(int e_killed) {
		this.e_killed = e_killed;
	}
 

}
