package data;

import algorithms.search.Searcher;
import algorithms.search.Solution;
import controller.Command;

public class Solve implements Command
{
	private String name;
	private Searcher sear;

	public Solve(String args) 
	{
		String[] splited=args.split(" ");
		this.name=splited[0];
		String searchearArgs="";
		for (int i = 1; i < splited.length; i++) 
		{
			searchearArgs += splited[i] + " ";
		}
		this.sear=(new AlgorithmsFactory()).createCommand(searchearArgs);
	}
	public Solve(String name,Searcher s) 
	{
		this.name=name;
		this.sear=s;
	}
	@Override
	public void doCommand() 
	{
		Runnable r=new Runnable() 
		{
			@Override
			public void run() 
			{
				Solution sol = sear.search(MazeStock.getInstance().getMaze(name));
				SolutionsStock.getInstance().addSolution(name, sol);
			}
		};
		r.run();
		//MyThreadPool.getInstance().addRunnable(r);
	}
}
