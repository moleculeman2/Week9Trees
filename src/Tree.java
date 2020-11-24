

/**
 * Uses Nodes from the node class to create a binary search tree, and has methods for inserting,
 *  searching, counting, and printing. These methods are recursive.
 * 
 * @author Mason Wickersham
 *
 */
public class Tree 
{
	int count = 0;
	int found = 0;
	Node root;
	
	/**
	 * creates root node or sends arguments into recursive insert method
	 * 
	 * @param octet	int of last three digits of IP address to insert
	 * @param username	String of username to insert
	 */
	public void insert(int octet, String username) {
		//creates root if none exists
		if (root == null) {
			root = new Node(octet, username);
		}
		recursiveInsert(root, octet, username);
		
	}
	
	/**
	 * 	recursively checks then creates node into binary search tree
	 * 
	 * @param temp		A Node, used to recursively add nodes to the tree
	 * @param octet	int of last three digits of IP address to insert
	 * @param username	String of username to insert
	 */
	public void recursiveInsert(Node temp, int octet, String username) {
		
		//moves right if no null right node 
		if (octet > temp.octet && temp.right != null) {
			recursiveInsert(temp.right, octet, username);
		}
		//creates new node in null right node
		else if (octet > temp.octet) {
			temp.right = new Node(octet, username);
		}
		//moves left if no null left node 
		if (octet < temp.octet && temp.left != null) {
			recursiveInsert(temp.left, octet, username);
		}
		//creates new node in null left node
		else if (octet < temp.octet){
			temp.left = new Node(octet, username);
		}
	}
	
	/**
	 *  sends params to recursive traversal method and prints various pieces of information
	 * 
	 * @param type		An enum that dictates what the traversal method will do
	 * @param octet	int of last three digits of IP address to search for/print
	 * @param username	String of username to search for/print
	 */
	public void traversal(TraversalType type, int octet, String username){
		recursiveTraversal(root, type, octet, username);
		if (this.found == 0 && type == TraversalType.IP_SEARCH) System.out.println("IP 10.0.0." + octet + " not found.");
		if (this.found == 0 && type == TraversalType.NAME_SEARCH) System.out.println("User " + username + " not found."); 
		if (count != 0) System.out.println("Number of items in tree: " + count);
		this.found = 0;
		this.count = 0;
	}
	
	/**
	 * 	Can either search for IP or name, print tree, or count tree. Does so recursively.
	 * 
	 * @param temp		A node, starts with root, then recursively traverses tree until criteria is met
	 * @param type		An enum that dictates what the traversal method will do
	 * @param octet	int of last three digits of IP address to search for/print
	 * @param username	String of username to search for/print
	 */
	public void recursiveTraversal(Node temp, TraversalType type, int octet, String username) {
		
		if (temp != null) {
			
			recursiveTraversal(temp.left, type, octet, username);
			
			switch(type) {
				case IP_SEARCH:
					//finds IP
					if (temp.octet == octet) {
						temp.printFound();
						this.found = 1;
					}
					break;
				case NAME_SEARCH:
					//finds name
					if (temp.username.equals(username)) {
						temp.printFound();
						this.found = 1;
					}
					break;
				case COUNT:
					//counts all nodes of tree
					this.count++;
					break;
				case PRINT:
					//prints all nodes of tree
					temp.print();
					break;
			}
			
			recursiveTraversal(temp.right, type, octet, username);
		}
		
	}
}
