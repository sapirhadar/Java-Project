package data;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;

public class MazeStock 
{
	private static MazeStock stock = null;
	private static HashMap<String, Maze3d> mazes;
	private MazeStock() 
	{
		mazes=new HashMap<>();
	}
	public static MazeStock getInstance()
	{
		if(stock==null)
			stock=new MazeStock();
		return stock;
	}
	public void addMaze(String name,Maze3d m)
	{
		if(mazes.containsKey(name))
			System.out.println("this name is already exists");
		else
			mazes.put(name, m);
	}
	public void removeMaze(String name)
	{
		if(!mazes.containsKey(name))
			System.out.println("this maze is not exists");
		else
			mazes.remove(name);
	}
	public Maze3d getMaze(String name)
	{
		if(!mazes.containsKey(name))
		{
			System.out.println("this maze is not exists-"+name);
			return null;
		}
		return mazes.get(name);
	}
}
