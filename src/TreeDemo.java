import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;

/**
 * Creates a tree from a CSV file and allows the user to search for IP addresses and usernames.
 * Also lets the user count the entries and print the entire tree
 * 
 * @author Mason Wickersham
 *
 */
public class TreeDemo
{

	public static void main(String[] args) throws IOException
	{
		boolean built = false;
		Tree tree = new Tree();
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		String dataFile = "C:\\Stuff\\Users.csv";
		BufferedReader reader = new BufferedReader(new FileReader(dataFile));
		String csvSplitBy = ",";
		String line = "";
	
		while (input != 6) {
			printMenu();
			//catches non-numerical entries
			try
			{
				input = scanner.nextInt();
			} catch (Exception e)
			{
				input = 0;
				scanner.next();
			}
			System.out.println();
			
			
			switch (input) {
				case 1:
					while (!built && (line = reader.readLine()) != null) {
						String[] temp = line.split(csvSplitBy);
						tree.insert(Integer.parseInt(temp[0]), temp[1]);
					}
					if (built) System.out.println("Tree already built.");
					else System.out.println("Tree built succesfully.");
					built = true;
					reader.close();
					break;
				case 2:
					System.out.print("Please enter the last three digits of the IP address: ");
				//catches non-numerical entries
				try
				{
					tree.traversal(TraversalType.IP_SEARCH, scanner.nextInt(), "");
					break;
				} catch (Exception e)
				{
					System.out.println("Invalid entry");
					input = 0;
					scanner.next();
					break;
				}	
				case 3:
					System.out.print("Please enter the username: ");
					tree.traversal(TraversalType.NAME_SEARCH, 0, scanner.next());
					break;
				case 4:
					tree.traversal(TraversalType.COUNT, 0, "");
					break;
				case 5:
					tree.traversal(TraversalType.PRINT, 0, "");
					break;
				case 6:
					System.out.println("Exiting program");
					break;
				default:
					System.out.println("Invalid entry");
			}
		}
		scanner.close();
		
	}
	
	
	/**
	 * 	Prints the text menu for the user
	 */
	public static void printMenu() {
		System.out.println("-------------------------");
		System.out.println("1 Build Users Tree");
		System.out.println("2 Find by IP Address");
		System.out.println("3 Find by Username");
		System.out.println("4 Report Number of Nodes");
		System.out.println("5 Print Entire Tree");
		System.out.println("6 Exit");
		System.out.println("-------------------------");
		System.out.print("Enter 1, 2, 3, 4, 5 or 6: ");
	}

}

