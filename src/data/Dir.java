package data;

import java.io.File;

import controller.Command;

public class Dir implements Command 
{
	private String path;
	public Dir()
	{
	}
	public Dir(String path) 
	{
		this.path=path;
	}
	@Override
	public void doCommand() 
	{
		File f=new File(this.path);
		System.out.println(f.list());
	}

}
