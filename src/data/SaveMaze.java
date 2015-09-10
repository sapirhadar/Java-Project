package data;

import io.MyCompressorOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import controller.Command;

public class SaveMaze implements Command
{
	private String name;
	private String fileName;

	public SaveMaze(String args)
	{
		String[] splited = args.split(" ");
		this.name = splited[0];
		this.fileName = splited[1];
	}
	public SaveMaze(String name, String fileName) 
	{
		this.name = name;
		this.fileName = fileName;
	}
	@Override
	public void doCommand() 
	{
		MyCompressorOutputStream mcos = null;
		try 
		{
			mcos=new MyCompressorOutputStream(new FileOutputStream(new File(fileName)));
			mcos.write(MazeStock.getInstance().getMaze(name).toByteArray());
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				mcos.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
