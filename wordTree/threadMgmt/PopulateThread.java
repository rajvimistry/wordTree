package wordTree.threadMgmt;

import wordTree.util.FileProcessor;
import wordTree.tree.Tree;
import wordTree.util.MyLogger;

public class PopulateThread implements Runnable
{

	private FileProcessor fileprocessor;
	private Tree tr;	

	public PopulateThread(FileProcessor fp, Tree tree)
	{
		this.fileprocessor = fp;
		this.tr = tree;
		MyLogger.writeMessage("PopulateThread object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void run()
	{
		String s1 = null;

		MyLogger.writeMessage("Run Method is called",MyLogger.DebugLevel.THREAD_RUN);

		while((s1 = fileprocessor.readLine()) != null)
		{
			if(s1.isEmpty())
			{continue;}
			String[] temp = s1.split("\\s+");
			for(int i=0;i<temp.length;i++)
			{
				tr.insert(temp[i]);
			}
		}
	}
}
