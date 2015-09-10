package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import data.CommandsFactory;

public class CLI  
{
	private BufferedReader in;
	private PrintWriter out;
	private CommandsFactory factory;
	public CLI(BufferedReader in, PrintWriter out)
	{
		this.in = in;
		this.out = out;
		this.factory=new CommandsFactory();
	}
	public void start()
	{
		new Thread(new Runnable()
		{
			@Override
			public void run() 
			{
				showInstructions();
				String str="";
				try 
				{
					System.out.print("command=");
					str = in.readLine();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				while(!str.equals("exit"))
				{
					if(str.equals("ins")||str.equals("instructions"))
					{
						showInstructions();
						try 
						{
							System.out.print("command=");
							str = in.readLine();
						}
						catch (IOException e) 
						{
							e.printStackTrace();
						}
						continue;
					}
					if (factory.IsContains(str))
					{
						factory.createCommand(str).doCommand();
					}
					else
						out.write("error");
					try 
					{
						System.out.print("command=");
						str=in.readLine();
					}
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
				factory.createCommand(str).doCommand();
				System.out.println("exit was done");
			}
		}).start();
	}
	private void showInstructions()
	{
		System.out.println("dir <path> - shows all files in the folder");
		System.out.println("generate 3d maze <name> <other params> - generates maze by the parameters");
		System.out.println("display <name> - displays the maze by the name");
		System.out.println("display cross section by {X,Y,Z} <index> for <name>");
		System.out.println("save maze <name> <file name>");
		System.out.println("load maze <file name> <name>");
		System.out.println("maze size <name>");
		System.out.println("file size <name>");
		System.out.println("solve <name> <algorithm>");
		System.out.println("display solution <name>");
		System.out.println("exit");
		System.out.println("ins - shows the instructions");
	}
}
