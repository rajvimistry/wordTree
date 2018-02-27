package wordTree.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import wordTree.util.MyLogger;

public class FileProcessor {

	private String s;
	private File file;
	private Scanner sc;

	public FileProcessor(String filename)
	{
		//read from file
		MyLogger.writeMessage("FileProcessor object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
		MyLogger.writeMessage("File Open to Read",MyLogger.DebugLevel.FILE_OPEN);
		s = filename;
		file = new File(s);
		try {
			sc = new Scanner(file);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized String readLine()
	{
		if (sc.hasNextLine())
		{ 
			String s1 = sc.nextLine();
			return s1;
		}
		return null;
	}

	/*@Override
	public String toString()
	{
		return null;
	}*/


}
