package com.burger.controller;

import com.burger.controller.action.Action;
import com.burger.controller.action.IndexAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory ist = new ActionFactory();
	public static ActionFactory getInstance() {	 return ist;	 }
	
	public Action getAction(String command) {
		Action ac = null;
		
		if (command.equals("index")) ac = new IndexAction();
		
		return ac;
	}
}
