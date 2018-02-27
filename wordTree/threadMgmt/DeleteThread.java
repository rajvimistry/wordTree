package wordTree.threadMgmt;

import wordTree.util.FileProcessor;
import wordTree.tree.Tree;
import wordTree.tree.Tree;
import wordTree.util.MyLogger;

public class DeleteThread implements Runnable
{

	private Tree tr;
	private String deleteWord;

	public DeleteThread(Tree treeBuilder, String deleteWord)
	{
		this.tr = treeBuilder;
		this.deleteWord = deleteWord;
		MyLogger.writeMessage("DeleteThread object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	public void run()
	{
		MyLogger.writeMessage("Run Method is called",MyLogger.DebugLevel.THREAD_RUN);
		tr.delete(deleteWord);
	}

}
