package data;

import java.util.HashMap;

import algorithms.search.AStar;
import algorithms.search.BFS;
import algorithms.search.Searcher;

public class AlgorithmsFactory
{
	private HashMap<String, AlgorithmCreator> algorithms;
	public AlgorithmsFactory()
	{
		this.algorithms = new HashMap<String, AlgorithmCreator>();
		algorithms.put("BFS",new BFSCreator());
		algorithms.put("AStar",new AStarCreator());
	}

	public Searcher createCommand(String algorithmParameters)
	{
		String algorithmName=getAlgorithmName(algorithmParameters);
		String algorithmArgs=getAlgorithmArgs(algorithmParameters);
		AlgorithmCreator creator = algorithms.get(algorithmName);
		Searcher algorithm = null;
		if (creator != null) 
		{
			algorithm = creator.create(algorithmName,algorithmArgs);			
		}
		return algorithm;
	}
	private String getAlgorithmName(String algorithmParameters)
	{
		return algorithmParameters.split(" ")[0];
	}
	private String getAlgorithmArgs(String algorithmParameters)
	{
		if(algorithmParameters.split(" ").length==1)
			return "";
		return algorithmParameters.split(" ")[1];
	}

	private interface AlgorithmCreator
	{
		Searcher create(String algorithmName,String algorithmArgs);
	}
	private class BFSCreator implements AlgorithmCreator
	{
		@Override
		public Searcher create(String algorithmName, String algorithmArgs) 
		{
			return new BFS();
		}
	}
	private class AStarCreator implements AlgorithmCreator
	{
		@Override
		public Searcher create(String algorithmName, String algorithmArgs) 
		{
			return new AStar((new HeuristicFactory()).createHeuristic(algorithmArgs));
		}
	}
}
