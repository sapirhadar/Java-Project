package data;

import java.util.HashMap;

import algorithms.search.Solution;

public class SolutionsStock 
{
	private static SolutionsStock stock = null;
	private static HashMap<String, Solution> solutions;
	private SolutionsStock()
	{
		solutions=new HashMap<>();
	}
	public static SolutionsStock getInstance()
	{
		if(stock==null)
			stock=new SolutionsStock();
		return stock;
	}

	public void addSolution(String name , Solution sol)
	{
		solutions.put(name, sol);
	}
	public Solution getSolution(String ser)
	{
		return solutions.get(ser);
	}
}
