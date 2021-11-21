package com.burger.controller;

import com.burger.controller.action.FaqFormAction;
import com.burger.controller.action.Action;
import com.burger.controller.action.AppGuideFormAction;
import com.burger.controller.action.BrandStroyFormAction;
import com.burger.controller.action.DeliveryFormAction;
import com.burger.controller.action.EventListFormAction;
import com.burger.controller.action.IndexAction;
import com.burger.controller.action.LegalAction;
import com.burger.controller.action.LoginFormAction;
import com.burger.controller.action.MenuListFormAction;
import com.burger.controller.action.PrivacyAction;
import com.burger.controller.action.QnaFormAction;
import com.burger.controller.action.TermsAction;
import com.burger.controller.action.VideoPolicyAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory ist = new ActionFactory();
	public static ActionFactory getInstance() {	 return ist;	 }
	
	public Action getAction(String command) {
		Action ac = null;
		
		if (command.equals("index")) ac = new IndexAction();
		else if(command.equals("loginForm")) ac = new LoginFormAction();
		else if(command.equals("terms")) ac = new TermsAction();
		else if(command.equals("privacy")) ac = new PrivacyAction();
		else if(command.equals("legal")) ac = new LegalAction();
		else if(command.equals("videoPolicy")) ac = new VideoPolicyAction();
		else if(command.equals("menuListForm")) ac = new MenuListFormAction();
		else if(command.equals("eventListForm")) ac = new EventListFormAction();
		else if(command.equals("brandStroyForm")) ac = new BrandStroyFormAction();
		else if(command.equals("deliveryForm")) ac = new DeliveryFormAction();
		else if(command.equals("qnaForm")) ac = new QnaFormAction();
		else if(command.equals("faqForm")) ac = new FaqFormAction();
		else if(command.equals("appGuideForm")) ac = new AppGuideFormAction();
		return ac;
	}
}
