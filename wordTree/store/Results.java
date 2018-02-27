package wordTree.store;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import wordTree.util.FileDisplayInterface;
import wordTree.util.StdoutDisplayInterface;
import wordTree.util.MyLogger;

public class Results implements FileDisplayInterface,StdoutDisplayInterface{

	ArrayList<String> result;
	FileWriter fw = null;
	BufferedWriter bw = null;

	public Results()
	{
		result = new ArrayList<String> ();
		MyLogger.writeMessage("Result object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void storeNewResult(String s)
	{
		result.add(s);
	}


	//@Override
	public void writeToStdout()
	{
		for(int i=0;i<result.size();i++)
		{
			System.out.println(result.get(i));
		}
	}

	//@Override
	public void writeToFile(String s1)
	{
		try
		{
			fw = new FileWriter(s1);
			bw = new BufferedWriter(fw);
			MyLogger.writeMessage("FIle Open to Write",MyLogger.DebugLevel.FILE_OPEN);
			for(int i=0;i<result.size();i++)
			{
					bw.write(result.get(i));
					bw.write("\n");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bw.close();
				fw.close();
			}
			catch(IOException e)
			{e.printStackTrace();}
		}
	}
}
