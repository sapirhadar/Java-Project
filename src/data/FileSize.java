package data;

import controller.Command;



public class FileSize implements Command
{
	private String name;
	public FileSize() {
		// TODO Auto-generated constructor stub
	}
	public FileSize(String name) 
	{
		this.name=name;
	}
	@Override
	public void doCommand() // we need to fix the size that will be by the real one
	{
		System.out.println(MazeStock.getInstance().getMaze(name).toByteArray().length);
	}
}
