import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {	

//______________________________________________________________________________________________________________________________________
	//box design
	// prints first and last lines using length of String (plus 2 for sides) as parameter
	public static void firstAndLast(int length)
	{
		for (int i = 0; i < length + 39; i++)
		{
			System.out.print("~");
		}
	}

	// prints second and fourth lines using length of String (plus 2 for sides) as parameter
	public static void secondAndFourth(int length)
	{
		System.out.println();
		System.out.print("|");
		for (int i = 0; i < length; i++)
		{
			System.out.print(" ");
		}
		System.out.print("|");
		for (int i = 0; i < 8; i++)
		{
			System.out.print(" ");
		}
		System.out.print("|");
		
		for (int i = 0; i < 15; i++)
		{
			System.out.print(" ");
		}
		System.out.print("|");
		
		for (int i = 0; i < 11; i++)
		{
			System.out.print(" ");
		}
		System.out.println("|");
	}

	public static void main(String[] aargs) 
	{
		Scanner fin = null;
		Scanner input = null;

		try 
		{

			fin = new Scanner(new File("demoWeatherAPI.txt"));
			input= new Scanner(System.in); 
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Couldn't load file demoWeatherAPI.txt");
		}
		
		
		
		//start of game
		
		ArrayList<String> seeds = new ArrayList<String>();
		seeds.add("tomato");
		seeds.add("carrot");
		seeds.add("strawberry");
		
		
		System.out.println("Hello! Please enter your name: " );
		String name = input.nextLine();
		
		System.out.println("Welcome to Garden Game Planner " + name +
				"! \nHere, you can plan your garden on your computer "
				+ "with real weather conditions of your area, or any "
				+ "area you'd like to siimulate on your garden. \nThis is "
				+ "also a game, so make sure to keep up with all of your points!" );

		System.out.println("Would you like to start gardening? Enter Yes/No " );
		String answer = input.nextLine();
		if (answer.contains("no") || (answer.contains("No")))
		{
			System.out.println("Have a good day!");
			System.exit(0);
		}else
		{
			System.out.println("Pick your seed from the stock: ");
			System.out.println("-------Stock----------");
			for(String seed : seeds) 
				System.out.print(seed + "	\n");		
			String plant = input.nextLine();
			for(int i = 0; i < seeds.size(); i++)
				if(seeds.get(i).equals(plant))
					seeds.remove(i);
			
			
			System.out.println("-------Updated Stock----------");
			for(String seed : seeds) 
				System.out.println(seed);
			System.out.println("\nYou have selected " + plant + ". Press Enter your desired location to continue");
		}
		
		input.nextLine();
		
		System.out.println();		
		int n = fin.nextInt();
		fin.nextLine();		
	

		for(int i = 0; i < n; i++)
		{
			String location = fin.nextLine();
			int length = location.length() + 2;

			firstAndLast(length);
			secondAndFourth(length);

			//start of third row
			System.out.print("| ");
			System.out.print(location);
			
			String temp = fin.nextLine();
			System.out.print(" | ");
			System.out.print(temp);
			System.out.print(" | ");
			
			String humid = fin.nextLine();
			System.out.print(humid);
			System.out.print(" | ");
			
			String conditions = fin.nextLine();
			System.out.print(conditions);
			System.out.print(" |");
			//end of third row

			secondAndFourth(length);
			firstAndLast(length);

			System.out.println(" ");
			
			//end of box design
//______________________________________________________________________________________________________________________________________

			
			
			
			int XP = 0;
			
			System.out.print("INITIAL ASSESSMENT: ");
			if(temp.compareTo(" 90 *F") == 0)
			{
				System.out.print("can grow most types of produce. Enter any key ");
				String ok = input.nextLine(); 
			}
				
			else if((temp.compareTo(" 90 *F") > 0))
			{
				System.out.println("transfer your garden indoors to earn 10 XP");				
				
				
				System.out.print("Do you want to transfer your garden in doors? (ENTER Y/N): ");
				
				String transfer = input.nextLine(); 
				if (answer.contains("yes") || (answer.contains("Yes")))
				{
					XP +=10;
				}
					
					
			}
				
			
			System.out.print("WATER: ");
			if(humid.compareTo("Humidity: 10%") == 0)
			{
				System.out.print("Water your plant to earn 10 XP. Enter the word \"water\" to continue: ");				
				String water = input.nextLine(); //reads string.
				if (answer.contains("water") || (answer.contains("Water")))
					XP +=10;
			}
			
			if(humid.compareTo("Humidity: 10%") > 0) {
				System.out.println("none needed at the moment");
			}
			
			int chance = (int) (Math.random()*2);
			
			int x = (int) (Math.random()*3);					
			System.out.print("RANDOM ENCOUNTER: ");		

			
			if(chance == 0) {
				
				String[] disasters = new String[3];
				
				disasters[0] = "pests";
				disasters[1] = "a dinosaur uprising";
				disasters[2] = "your cat, Zipper, who went on a walk on your garden";
				
				System.out.println("You lost 10 XP because of " + disasters[x] +". press enter.");	
				XP -=10;

			}else {

				String[] goodStuff = new String[3];
				
				goodStuff[0] = "your neighbor gave you free compost";
				goodStuff[1] = "your local hardware store gave you free plant food";
				goodStuff[2] = "your cat, Zipper, who did not take a walk on your garden";
				
				System.out.print("You gained 10 XP because of " + goodStuff[x]);	
				System.out.print(" Press Enter ");
				String random = input.nextLine();

				
				XP +=10;

			}
			
			System.out.println("TOTAL XP: " + XP);
			XP = 0;
			System.out.println(" ");
			
			System.out.print(" Enter next ");
			String random = input.nextLine();

		}


		fin.close();
		}
	

}
