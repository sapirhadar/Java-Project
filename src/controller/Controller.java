package controller;

import model.Model;
import view.View;

public interface Controller
{
	Model getModel(Model model);
	View getView(View view);
	void setModel(Model model);
	void setView(View view);
}
