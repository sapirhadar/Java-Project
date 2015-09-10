package data;

import java.util.HashMap;

import algorithms.search.Heuristic;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattanDistance;

public class HeuristicFactory
{
	private HashMap<String, HeuristicCreator> heuristics;
	public HeuristicFactory()
	{
		this.heuristics = new HashMap<String, HeuristicCreator>();
		heuristics.put("MazeAirDistance",new MazeAirDistanceCreator());
		heuristics.put("MazeManhattanDistance",new MazeManhattanDistanceCreator());
	}
	public Heuristic createHeuristic(String heuristicName)
	{
System.out.println("HeuFac - createHeauristic = " + heuristicName);
		HeuristicCreator creator = heuristics.get(heuristicName);
		Heuristic heuristic = null;
		if (creator != null) 
		{
			heuristic = creator.create(heuristicName);			
		}
		return heuristic;
	}
	private interface HeuristicCreator
	{
		Heuristic create(String heuristicName);
	}
	private class MazeAirDistanceCreator implements HeuristicCreator
	{
		@Override
		public Heuristic create(String heuristicName) 
		{
			return new MazeAirDistance();
		}
	}
	private class MazeManhattanDistanceCreator implements HeuristicCreator
	{
		@Override
		public Heuristic create(String heuristicName) 
		{
			return new MazeManhattanDistance();
		}
	}
}
