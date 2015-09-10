package data;

import io.MyDecompressorInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import controller.Command;
import algorithms.mazeGenerators.Maze3d;

public class LoadMaze implements Command
{
	private String fileName;
	private String name;

	public LoadMaze(String args) 
	{
		String[] splited = args.split(" ");
		this.fileName = splited[0];
		this.name = splited[1];
	}
	public LoadMaze(String fileName, String name) 
	{
		this.fileName = fileName;
		this.name = name;
	}
	@Override
	public void doCommand() 
	{
		byte[] arr=new byte[100];//when you try your best but you don't succeed
		MyDecompressorInputStream mdis = null;//when you get what you want but not what you need
		try 
		{
			mdis = new MyDecompressorInputStream(new FileInputStream(new File(fileName)));
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			mdis.read(arr);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		MazeStock.getInstance().addMaze(name, new Maze3d(arr));
	}
}
