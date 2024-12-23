package co.kh.dev.mvc.control;

import co.kh.dev.mvc.action.Action;
import co.kh.dev.mvc.action.IndexAction;

// 싱글톤방식
public class ActionFactory {
	private static ActionFactory factory;

	public static synchronized ActionFactory getInstance() {
		if (factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	private ActionFactory() {}

	public Action getAction(String cmd) {
		Action action = null;
		
		if(cmd.equals("index.do")) {
			action = new IndexAction();
		}
		return action;
	}
}
