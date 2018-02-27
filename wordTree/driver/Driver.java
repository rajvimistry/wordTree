package wordTree.driver;

import wordTree.util.FileProcessor;
import wordTree.threadMgmt.CreateWorkers;
import wordTree.tree.Tree;
import wordTree.computeResult.ComputeResult;
import wordTree.store.Results;
import wordTree.util.MyLogger;

public class Driver{

	public static void main(String args[])
	{

		if(args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}") || args[4].equals("${arg4}") || Integer.parseInt(args[4])<0 || Integer.parseInt(args[4]) > 4)
		{
			System.err.println("Invalid Number of Arguments!!");
			System.exit(0);
		}

		String[] deleteWords = args[3].split("\\s+");
		if(deleteWords.length != Integer.parseInt(args[2]))
		{
			System.err.println("Delete Words and Number of Threads should be same");
			System.exit(0);
		}

		MyLogger.setDebugValue(Integer.parseInt(args[4]));

		FileProcessor fp1 = new FileProcessor(args[0]);
		Tree tr = new Tree();
		ComputeResult compute = new ComputeResult();
		Results rs = new Results();
		CreateWorkers workers = new CreateWorkers(fp1,tr);
		workers.startPopulateWorkers(args[2]);
		workers.startDeleteWorkers(args[2],deleteWords);
		compute.compute(tr,rs);
		rs.writeToFile(args[1]);

		if(Integer.parseInt(args[4]) == 1)
		{
			rs.writeToStdout();
		}
	}
}
