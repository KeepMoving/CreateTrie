import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Trie {
	private Node root;
	
	public Trie()
	{
		root = new Node(' ');
	}
	
	public void insert(String s)
	{
		Node current = root;
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			Node child = current.subNode(s.charAt(i));
			if(child != null){
				current = child;//如果子节点中有该元素，则进入下层节点
			}else{
				//如果子节点中无该元素，则在当前节点中插入值为该元素的子节点
				current.child.add(new Node(s.charAt(i)));
				//把current指针指向该元素的节点
				current = current.subNode(s.charAt(i));
				count++;
			}
		}
		current.marker = true;
	}

	
	public boolean search(String s) {
		Node current = root;
		while (current != null) {
			for (int i = 0; i < s.length(); i++) {
				if (current.subNode(s.charAt(i)) == null)
					return false;
				else
					current = current.subNode(s.charAt(i));
			}
			/*
			* This means that a string exists, but make sure its a word by
			* checking its 'marker' flag
			*/
			if (current.marker == true)
				return true;
			else
				return false;
		}
		return false;
	}
	
	public List<String> searchPrefix(String s) {
		Node current = root;
		if (current == null) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		Node endNode = null;
		StringBuilder endSB = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (current.subNode(s.charAt(i)) == null) {
				endNode = current;//表示没有符合要求的字符串
				break;
			} else {
//				System.out.println("subchar:"+s.charAt(i));
				//如果有符合要求的字符串，则继续便利
				current = current.subNode(s.charAt(i));
				endNode = current;
				endSB.append(endNode.content);
			}
		}
		if (endNode == null) {
			return null;
		}
		if (endNode.marker == true) {//  found as a word
			list.add(endSB.toString());
		}else{
			System.out.println("输出标记为false");
		}
		// depth-first search the sub branch
//		Stack<Node> stack = new Stack<Node>();
//		stack.push(endNode);
//		while (!stack.isEmpty()) {
//			Node cur = stack.peek();
//			int needCount = cur.child.size();
//			for (Node node : cur.child) {
//				if (!node.visited) {
//					node.visited = true;
//					stack.push(node);
//					endSB.append(node.content);
//					if (node.marker) {
//						list.add(endSB.toString());
//					}
//					break;
//				} else {
//					needCount--;
//				}
//			}
//			if (needCount == 0) {
//				stack.pop();
//				endSB.deleteCharAt(endSB.length()-1);
//			}
//		}
		return list;
	}
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("ball");
		trie.insert("bat");
		trie.insert("dead");
		trie.insert("do");
		trie.insert("doll");
		trie.insert("dork");
		trie.insert("dorm");
		trie.insert("send");
		trie.insert("sense");
		List<String> list = trie.searchPrefix("dorm");
		for (String s : list) {
			System.out.println(s);
		}
	}

}
