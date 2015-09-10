package view;
/**
 * a class for runnig the task in a thread
 * @author itay&chen
 *
 */
public class TaskRunnable implements Runnable
{
	private Task t;

	public TaskRunnable(Task t)//constructor
	{
		this.t = t;
	}
	@Override
	public void run() //operate the function doTask() of the task t
	{
		t.doTask();
	}
}
