import java.util.Scanner;

public class NPC 
{
	private String name;
	private String dialogue;
	
	public NPC(String named, String says)
	{
		name = named;
		dialogue = says;
	}
	
	public String interact()
	{
		return "["+name+"]: "+dialogue;
	}
	
	
}