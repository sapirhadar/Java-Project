package data;

import controller.Command;


public class Display implements Command 
{
	private String name;
	public Display(String name) 
	{
		this.name=name;
	}
	@Override
	public void doCommand() 
	{
		System.out.println(MazeStock.getInstance().getMaze(name));
	}
}
