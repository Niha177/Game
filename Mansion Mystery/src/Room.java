public class Room 
{
	//this is our room class that each specific rooms inherit from
	private String myDescription;
	private Object item;
	private static boolean lock;
	//these are our getters and setters
	
	public Room(String description)
	{
		myDescription=description;
	}
	public boolean getLock()
	{
		return lock;
	}
	public void setLock(boolean state)
	{
		lock = state;
	}
	public String getDescription()
	{
		return myDescription;
	}
	//this is our game over method when a player fails a puzzle
	public void gameOver()
	{
		//this makes sure that the player does not move on to any after part beyond this point
		setLock(true);
		
			
		System.out.println("  ____   ____  ___ ___    ___       ___   __ __    ___  ____  \r\n"
				+ " /    | /    ||   |   |  /  _]     /   \\ |  |  |  /  _]|    \\ \r\n"
				+ "|   __||  o  || _   _ | /  [_     |     ||  |  | /  [_ |  D  )\r\n"
				+ "|  |  ||     ||  \\_/  ||    _]    |  O  ||  |  ||    _]|    / \r\n"
				+ "|  |_ ||  _  ||   |   ||   [_     |     ||  :  ||   [_ |    \\ \r\n"
				+ "|     ||  |  ||   |   ||     |    |     | \\   / |     ||  .  \\\r\n"
				+ "|___,_||__|__||___|___||_____|     \\___/   \\_/  |_____||__|\\_|\r\n"
				+ "                                                              ");
		
	}
}