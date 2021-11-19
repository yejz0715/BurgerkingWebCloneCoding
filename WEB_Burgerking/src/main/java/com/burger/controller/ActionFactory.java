package com.burger.controller;

import com.burger.controller.action.Action;
import com.burger.controller.action.IndexAction;
import com.burger.controller.action.LegalAction;
import com.burger.controller.action.PrivacyAction;
import com.burger.controller.action.TermsAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory ist = new ActionFactory();
	public static ActionFactory getInstance() {	 return ist;	 }
	
	public Action getAction(String command) {
		Action ac = null;
		
		if (command.equals("index")) ac = new IndexAction();
		else if(command.equals("terms")) ac = new TermsAction();
		else if(command.equals("privacy")) ac = new PrivacyAction();
		else if(command.equals("legal")) ac = new LegalAction();
		
		return ac;
	}
}
