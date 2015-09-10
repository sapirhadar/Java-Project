package model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool
{
	private static MyThreadPool myThreadPool = null;
	private static ExecutorService pool;
	private MyThreadPool()
	{
		pool=Executors.newSingleThreadExecutor();
	}
	public static MyThreadPool getInstance()
	{
		if(myThreadPool==null)
			myThreadPool=new MyThreadPool();
		return myThreadPool;
	}
	public void addRunnable(Runnable r)
	{
		pool.execute(r);
	}
	public void shutDown()
	{
		pool.shutdown();
	}
}
