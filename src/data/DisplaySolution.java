package data;

import controller.Command;


public class DisplaySolution implements Command 
{
	private String name;
	public DisplaySolution(String name) 
	{
		this.name=name;
	}
	@Override
	public void doCommand() 
	{
		System.out.println(SolutionsStock.getInstance().getSolution(name));
	}
}
