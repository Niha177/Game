import java.util.ArrayList;

public class Keys 
{
	private String name;
	private int keyNum;
	
	//this is where we make each of our items allow in the inventory
	//the constructor us to make many key/ inventory objects with different names
	public Keys(String n)
	{
		name=n;
		
	}
	public String getName()
	{
		return name;
	}
	public int order()
	{
		return keyNum;
	}
	
	
	
}