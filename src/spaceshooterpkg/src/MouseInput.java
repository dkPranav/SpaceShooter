package spaceshooterpkg.src;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mousePressed(MouseEvent e) {
		int mx=e.getX();
		int my=e.getY();
		// TODO Auto-generated method stub
		/*public Rectangle playButton=new Rectangle(MainClass.WIDTH/2+120,150,100,50);
		public Rectangle helpButton=new Rectangle(MainClass.WIDTH/2+120,250,100,50);
		public Rectangle quitButton=new Rectangle(MainClass.WIDTH/2+120,350,100,50);*/
	//Play
		if(mx >= MainClass.WIDTH /2 +120 && mx <=MainClass.WIDTH/2+220)
		{
			if(my >=150 && my<= 200)
			{
				MainClass.state = MainClass.STATE.GAME;
				
			}
		}
		//Quit
				if(mx >= MainClass.WIDTH /2 +120 && mx <=MainClass.WIDTH/2+220)
				{
					if(my >=350 && my<= 400)
					{
						System.exit(1);
					}
				}	
	
	
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
