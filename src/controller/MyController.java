package controller;

import model.Model;
import model.MyModel;
import view.MyView;
import view.View;

public class MyController implements Controller 
{
	private View v;
	private Model m;

	public MyController() 
	{
		this.m = new MyModel(this);
		this.v = new MyView(this);
	}
	public void start()
	{
		v.start();
	}
	@Override
	public Model getModel(Model model) 
	{
		return this.m;
	}
	@Override
	public View getView(View view) 
	{
		return this.v;
	}
	@Override
	public void setModel(Model model) 
	{
		this.m=model;
	}
	@Override
	public void setView(View view) 
	{
		this.v=view;
	}
}
