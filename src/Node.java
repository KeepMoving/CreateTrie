import java.util.Collection;
import java.util.LinkedList;

public class Node
{
	char content;
	boolean marker;
	Collection<Node> child;
	boolean visited;
	/*
	 * 构造节点
	 */
	public Node(char c)
	{
		child = new LinkedList<Node>();
		marker = false;
		content = c;
		visited = false;
	}
	
	/*
	 * 
	 */
	public Node subNode(char c)
	{
		if(child != null)
		{
			for(Node eachChild:child)
			{
				if(eachChild.content == c)
				{
					return eachChild;
				}
			}
		}
		return null;
	}
}