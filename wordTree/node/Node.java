package wordTree.node;

import wordTree.util.MyLogger;

public class Node
{
	public String word;
	public int count = 0;

	public Node left = null;
	public Node right = null;
	

	public Node()
	{
		MyLogger.writeMessage("Node object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
	}
}
