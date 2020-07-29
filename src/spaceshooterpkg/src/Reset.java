package spaceshooterpkg.src;

public class Reset {
	
	
	public Reset(MainClass game,Controller c) {
		MainClass.Health=200;
		MainClass.SCORE=0;
		
		for(int i=0;i<game.eb.size();i++)
		{
			c.removeEntity(game.eb.get(i));
		}
		game.setE_killed(0);
		game.setE_count(5);
	}
}
