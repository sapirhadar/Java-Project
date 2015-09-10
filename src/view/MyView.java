package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controller.Controller;

public class MyView implements View 
{
	Controller c;
	CLI cli;
	public MyView(Controller c) 
	{
		this.c=c;
		this.cli=new CLI(new BufferedReader(new InputStreamReader(System.in)),new PrintWriter(System.out));
	}
	@Override
	public void start()
	{
		cli.start();
	}
}
