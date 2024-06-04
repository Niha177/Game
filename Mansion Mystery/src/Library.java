import java.util.Scanner;

public class Library extends Room
{
	private String[] library ={"Get","Away", "Magic", "Games", "With", "Knife","From", "Hatchet", "Mansion","The", "Mystery"};
	private boolean achievment;
	
	public Library()
	{
		super("You are now inside a huge library and you spot a librarian");
	}
	public void showBook()
	{
		for(int x =0; x<library.length;x++)
		{
			System.out.println("Book "+ x + ":" + library[x]);
		}
	}
	public boolean getAchieve()
	{
		return achievment;
	}
	public void librarySpace()
	{
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("look, I see a bunch of books... and four spots");
		System.out.println();
		showBook();
		System.out.println();
		System.out.println("maybe I can arrange a couple of books to reveal something");
		System.out.println();
		System.out.println("type the correct four books to reveal a secret");
		
		System.out.println("Place the first book");
		System.out.println();
		
		//maybe we should limit the amount of tries they get???? maybe they only get 4 tries
		int dangerCount=0;
		String input = scanner.nextLine();
		Library l= new Library();
		boolean achieve = false;
		boolean achieve2 = false;
		boolean achieve3 = false;
		boolean achieve4 = false;
		
		while(achieve==false&&getLock()==false)
		{
			if(input.equalsIgnoreCase("get"))
			{
				achieve=true;
			}
			else
			{
				dangerCount++;
				if(dangerCount>=4)
				{
					achieve = true;
					break;
				}
				System.out.print("WRONG try again, you have ");
				System.out.print(4-dangerCount);
				System.out.print(" tries left");
				input = scanner.nextLine();

			}
		}
		if(achieve==true&&getLock()==false);
		{
			if(dangerCount>=4)//change to 4
			{
				System.out.println("[YOU]:why is there lava seeping out????");
				System.out.println("[BOOKSHELF]: you got the code wrong, I guess you are not supposed to be here");
				System.out.println("[BOOKSHELF]: this is the end for you");
				System.out.println("[YOU]: NOOOOO!!!!");
				
				
				gameOver();
			}
			if(getLock()==false)
			{
				System.out.println("Place the second book");
				input = scanner.nextLine();
			}
			while(achieve2==false)
			{
				if(input.equalsIgnoreCase("away"))
				{
					achieve2=true;
				}
				else
				{
					dangerCount++;
					if(dangerCount>=4)
					{
						achieve2 = true;
						break;
					}
					System.out.print("WRONG try again, you have ");
					System.out.print(4-dangerCount);
					System.out.print(" tries left");
					input = scanner.nextLine();
					
				}
			}
		}
		if(achieve2==true&&getLock()==false)
		{
			if(dangerCount>=4)
			{
				System.out.println("[YOU]:why is there lava seeping out????");
				System.out.println("[BOOKSHELF]: you got the code wrong, I guess you are not supposed to be here");
				System.out.println("[BOOKSHELF]: this is the end for you");
				System.out.println("[YOU]: NOOOOO!!!!");
				gameOver();
			}
			if(getLock()==false)
			{
				System.out.println("Place the third book");
				input = scanner.nextLine();
			}
			
			
			while(achieve3==false)
			{
				if(input.equalsIgnoreCase("with"))
				{
					achieve3=true;
				}
				else
				{
					dangerCount++;
					if(dangerCount>=4)
					{
						achieve3 = true;
						break;
					}
					System.out.print("WRONG try again, you have ");
					System.out.print(4-dangerCount);
					System.out.print(" tries left");
					input = scanner.nextLine();
				}
			}
		}
		if(achieve3==true&&getLock()==false)
		{
			if(dangerCount>=4)
			{
				System.out.println("[YOU]:why is there lava seeping out????");
				System.out.println("[BOOKSHELF]: you got the code wrong, I guess you are not supposed to be here");
				System.out.println("[BOOKSHELF]: this is the end for you");
				System.out.println("[YOU]: NOOOOO!!!!");
				gameOver();
			}
			if(getLock()==false)
			{
				System.out.println("Place the fourth book");
				input = scanner.nextLine();
			}
			while(achieve4==false)
			{
				if(input.equalsIgnoreCase("magic"))
				{
					achieve4=true;
				}
				else
				{
					dangerCount++;
					if(dangerCount>=4)
					{
						achieve4 = true;
						break;
					}
					System.out.print("WRONG try again, you have ");
					System.out.print(4-dangerCount);
					System.out.print(" tries left");
					input = scanner.nextLine();
				}
			}
		}
		if(achieve4==true&&getLock()==false)
		{
			if(dangerCount>=4)
			{
				System.out.println("[YOU]:why is there lava seeping out????");
				System.out.println("[BOOKSHELF]: you got the code wrong, I guess you are not supposed to be here");
				System.out.println("[BOOKSHELF]: this is the end for you");
				System.out.println("[YOU]: NOOOOO!!!!");
				gameOver();
			}
			achievment=true;
			System.out.println("What is happening, something seems to be opening!");
			System.out.println("*hidden door opens*");
			System.out.println();
			System.out.println("wow! that looks like a key!");
			
			
			
		}
	}
	
}