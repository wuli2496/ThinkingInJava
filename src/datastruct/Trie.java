package datastruct;

import java.util.HashMap;
import java.util.Map;

public class Trie 
{
	private final int childNodes;
	private Map<Character, Integer> chMap;
	private TrieNode root;
	
	public Trie(int nodes)
	{
		childNodes = nodes;
		chMap = new HashMap<Character, Integer>();
		root = new TrieNode();
	}
	
	class TrieNode
	{
		private TrieNode[] childs;
		private boolean isEnd;
		
		public TrieNode()
		{
			childs = new TrieNode[childNodes];
		}
		
		public boolean containsKey(int index)
		{
			return childs[index] != null;
		}
		
		public void put(int index, TrieNode node)
		{
			childs[index] = node;
			return;
		}
		
		public TrieNode get(int index)
		{
			return childs[index];
		}
		
		public boolean getEnd()
		{
			return isEnd;
		}
		
		public void setEnd()
		{
			isEnd = true;
		}
	}
	
	public void initMap()
	{
		for (char ch = 'a'; ch <= 'z'; ++ch)
		{
			chMap.put(ch, ch - 'a');
		}
	}
	
	public void insert(String word)
	{
		TrieNode node = root;
		for (int i = 0; i < word.length(); ++i)
		{
			char ch = word.charAt(i);
			int index = chMap.get(ch);
			if (!node.containsKey(index))
			{
				node.put(index, new TrieNode());
			}
			
			node = node.get(index);
		}
		
		node.setEnd();
	}
	
	public boolean search(String word)
	{
		TrieNode node = root;
		for (int i = 0; i < word.length(); ++i)
		{
			char ch = word.charAt(i);
			int index = chMap.get(ch);
			if (!node.containsKey(index))
			{
				return false;
			}
			
			node = node.get(index);
		}
		
		return node.getEnd();
	}
}
