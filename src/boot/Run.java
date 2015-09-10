package boot;

import java.io.IOException;

import model.Model;
import model.MyModel;
import view.MyView;
import view.View;
import controller.Controller;
import controller.MyController;


public class Run 
{
	public static void main(String[] args) throws IOException 
	{
		Controller c = new MyController();
		Model m = new MyModel(c);
		View v = new MyView(c);
		c.setModel(m);
		c.setView(v);
		v.start();
	}
}
