package data;

import model.MyThreadPool;
import controller.Command;


public class Exit implements Command
{
	@Override
	public void doCommand() 
	{
		MyThreadPool.getInstance().shutDown();
	}
}
