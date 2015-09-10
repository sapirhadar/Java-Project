package data;

import java.util.HashMap;

import controller.Command;

public class CommandsFactory
{
	private HashMap<String, CommandCreator> commands;
	public CommandsFactory()
	{
		commands = new HashMap<String, CommandCreator>();
		commands.put("dir",new DirCreator());
		commands.put("generate",new GenerateCreator());
		commands.put("display",new DisplayCreator());
		commands.put("display solution",new DisplaySolutionCreator());
		commands.put("display cross section by X",new DisplayCrossSectionByXCreator());
		commands.put("display cross section by Y",new DisplayCrossSectionByYCreator());
		commands.put("display cross section by Z",new DisplayCrossSectionByZCreator());
		commands.put("save",new SaveMazeCreator());
		commands.put("load",new LoadMazeCreator());
		commands.put("maze",new MazeSizeCreator());
		commands.put("file",new FileSizeCreator());
		commands.put("solve",new SolveCreator());
		commands.put("exit",new ExitCreator());
	}

	public Command createCommand(String commandsParameters)
	{
		String commandName=getCommandName(commandsParameters);
		String commandArgs=getCommandArgs(commandsParameters);
		CommandCreator creator = commands.get(commandName);
		Command command = null;
		if (creator != null) 
		{
			command = creator.create(commandName,commandArgs);			
		}
		return command;
	}
	private String getCommandName(String commandsParameters)
	{
		String[] splited=commandsParameters.split(" ");
		if(splited[0].equals("dir"))
			return "dir";
		if(splited[0].equals("generate"))
			return "generate";
		if(splited[0].equals("display"))
		{
			if(splited.length==2)
				return "display";
			else
			{
				if(splited.length==3)	
					return "display solution";
				else
					return splited[0]+" "+splited[1]+" "+splited[2]+" "+splited[3]+" "+splited[4];
			}
		}
		if(splited[0].equals("save"))
			return "save";
		if(splited[0].equals("load"))
			return "load";
		if(splited[0].equals("maze"))
			return "maze";
		if(splited[0].equals("file"))
			return "file";
		if(splited[0].equals("solve"))
			return "solve";
		return "exit";
	}
	private String getCommandArgs(String commandsParameters)
	{
		String[] splited=commandsParameters.split(" ");
		if(splited[0].equals("dir"))
			return splited[1];
		if(splited[0].equals("generate"))
			return splited[3]+" "+splited[4]+" "+splited[5]+" "+splited[6];
		if(splited[0].equals("display"))
		{
			if(splited.length==2)
				return splited[1];
			else
			{
				if(splited.length==3)	
					return splited[2];
				else
					return splited[5]+" "+splited[7];
			}
		}
		if(splited[0].equals("save"))
			return splited[2]+" "+splited[3];
		if(splited[0].equals("load"))
			return splited[2]+" "+splited[3];
		if(splited[0].equals("maze"))
			return splited[2];
		if(splited[0].equals("file"))
			return splited[2];
		if(splited[0].equals("solve"))
		{
			String temp="";
			for (int i = 1; i < splited.length; i++) 
			{
				temp += splited[i] + " ";
			}
			return temp;
		}
		return "";
	}

	private interface CommandCreator
	{
		Command create(String commandName,String commandArgs);
	}
	private class DirCreator implements CommandCreator
	{
		@Override
		public Command create(String commandName, String commandArgs)
		{
			return new Dir(commandArgs);
		}
	}
	private class DisplayCreator implements CommandCreator
	{
		@Override
		public Command create(String commandName, String commandArgs) 
		{
			return new Display(commandArgs);
		}	
	}
	private class DisplayCrossSectionByXCreator implements CommandCreator
	{
		@Override
		public Command create(String commandName, String commandArgs) 
		{
			return new DisplayCrossSectionByX(commandArgs);
		}
	}
	private class DisplayCrossSectionByYCreator implements CommandCreator
	{
		@Override
		public Command create(String commandName, String commandArgs) 
		{
			return new DisplayCrossSectionByY(commandArgs);
		}
	}
	private class DisplayCrossSectionByZCreator implements CommandCreator
	{
		@Override
		public Command create(String commandName, String commandArgs) 
		{
			return new DisplayCrossSectionByZ(commandArgs);
		}
	}
	private class DisplaySolutionCreator implements CommandCreator
	{
		@Override
		public Command create(String commandName, String commandArgs) 
		{
			return new DisplaySolution(commandArgs);
		}
	}
	private class ExitCreator implements CommandCreator
	{
		@Override
		public Command create(String commandName, String commandArgs) 
		{
			return new Exit();
		}
	}
	private class FileSizeCreator implements CommandCreator
	{
		@Override
		public Command create(String commandName, String commandArgs)
		{
			return new FileSize(commandArgs);
		}		
	}
	private class GenerateCreator implements CommandCreator
	{
		@Override
		public Command create(String commandName, String commandArgs) 
		{
			return new Generate(commandArgs);
		}
	}
	private class LoadMazeCreator implements CommandCreator
	{
		@Override
		public Command create(String commandName, String commandArgs) 
		{
			return new LoadMaze(commandArgs);
		}
	}
	private class MazeSizeCreator implements CommandCreator
	{
		@Override
		public Command create(String commandName, String commandArgs) 
		{
			return new MazeSize(commandArgs);
		}
	}
	private class SaveMazeCreator implements CommandCreator
	{
		@Override
		public Command create(String commandName, String commandArgs) 
		{
			return new SaveMaze(commandArgs);
		}
	}
	private class SolveCreator implements CommandCreator
	{
		@Override
		public Command create(String commandName, String commandArgs) 
		{
			return new Solve(commandArgs);
		}
	}
	public boolean IsContains(String command)
	{
		if(!command.split(" ")[0].equals("display"))
			return commands.containsKey(getCommandName(command));
		if(command.split(" ")[1].equals("solution"))
			return true;
		if(command.split(" ")[1].equals("cross"))
			if(command.split(" ")[2].equals("section"))
				if(command.split(" ")[3].equals("by"))
				{
					switch (command.split(" ")[4]) 
					{
					case "X":
					case "Y":
					case "Z": return true;
					}
				}
		return command.split(" ").length == 2;
	}

}
