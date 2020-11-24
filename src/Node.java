
/**
 * Nodes for the tree class, stores username and IP address octet.
 * 
 * @author Mason Wickersham
 *
 */
public class Node 
{

	Node left;
	Node right;
	
	int octet;
	String username;
	
	/**
	 * @param octet	last three digits of IP stored as int
	 * @param username	username stored as String
	 */
	public Node(int octet, String username)
	{
		this.octet = octet;
		this.username = username;
	}

	/**
	 * 	Prints a statement with the node's info, and that it was found.
	 */
	public void printFound() {
		System.out.println("Found: 10.0.0." + octet + " " + username);
	}
	
	/**
	 * 	Prints a statement with the node's info.
	 */
	public void print() {
		System.out.println("IP: 10.0.0." + octet + ", Username: " + username +".");
	}
}
