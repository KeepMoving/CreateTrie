import java.util.ArrayList;
import java.util.Collection;


public class CreateTrie {

	public Node createTrie(String data)
	{
		if(data != null && data !="")
		{
			int len = data.length();
			Node node = new Node(data.charAt(0));
			if(len > 1)
			{
				for(int i = 1;i<len;i++)
				{
					node.subNode(data.charAt(i));
				}
			}
			return node;
		}else{
			return null;
		}
	}
	
	public void insertTrie(Node trie,String data)
	{
		
	}
	
	public void printTrie(Collection<Node> nodes)
	{
		for(Node node:nodes)
		{
			System.out.print(node.content+"->");
			printTrie(node.child);
			System.out.println();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String data = "abandon";
		String data1 = "abate";
		String data2 = "abhorrent";
		String data3 = "abide";
		String data4 = "ability";
		String data5 = "abode";
		String data6 = "abolish";
		String data7 = "abound";
		CreateTrie ct = new CreateTrie();
		Node node = ct.createTrie(data);
		Collection<Node> nodes = new ArrayList<Node>();
		nodes.add(node);
		ct.printTrie(nodes);
	}
}
