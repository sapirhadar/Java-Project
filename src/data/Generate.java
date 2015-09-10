package data;

import controller.Command;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;

public class Generate implements Command 
{
	private String name;
	private int x,y,z;
	private Maze3d maze;

	public Generate(String args)
	{
		String[] splited=args.split(" ");
		this.name=splited[0];
		this.x=Integer.parseInt(splited[1]);
		this.y=Integer.parseInt(splited[2]);
		this.z=Integer.parseInt(splited[3]);
	}
	public Generate(String name, int x, int y, int z) 
	{
		this.name = name;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public void doCommand() 
	{
		MyMaze3dGenerator mmg=new MyMaze3dGenerator();
		this.maze=mmg.generate(x, y, z);
		MazeStock.getInstance().addMaze(name, this.maze);
		System.out.println("the maze was generated");
	}
	public Maze3d getMaze()
	{
		return this.maze;
	}
} 