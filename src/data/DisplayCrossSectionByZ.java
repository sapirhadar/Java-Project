package data;

import controller.Command;
import algorithms.mazeGenerators.Maze3dState;

public class DisplayCrossSectionByZ implements Command 
{
	private int index;
	private String name;

	public DisplayCrossSectionByZ(String args) 
	{
		String[] splited=args.split(" ");
		this.index=Integer.parseInt(splited[0]);
		this.name=splited[1];
	}
	public DisplayCrossSectionByZ(int index, String name) 
	{
		this.index = index;
		this.name = name;
	}
	@Override
	public void doCommand() 
	{
		Maze3dState[][] arr= MazeStock.getInstance().getMaze(name).getCrossSectionByZ(index);
		String s="";
		for (int i = 0; i < arr.length; i++) 
		{
			for (int j = 0; j < arr[0].length; j++) 
			{
				s += "[" + arr[i][j].getWallValue() + "]";
			}
			s += "\n";
		}
		System.out.println(s);
	}
}
