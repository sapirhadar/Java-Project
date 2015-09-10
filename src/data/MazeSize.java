package data;

import controller.Command;



public class MazeSize implements Command 
{
	private String name;
	public MazeSize() {
		// TODO Auto-generated constructor stub
	}
	public MazeSize(String name) 
	{
		this.name = name;
	}
	@Override
	public void doCommand() 
	{
		System.out.println(MazeStock.getInstance().getMaze(name).toByteArray().length);
	}
}
