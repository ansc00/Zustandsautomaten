package automat.wecker;

import java.util.HashMap;




public final class State {
	
	private final HashMap<WeckerEvent, Transition> transitions = new HashMap<>();
	private final String name;
	
	public State(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addTransition(WeckerEvent event, Transition transition){
		this.transitions.put(event, transition);
	}
	
	public State processEvent(WeckerEvent event){
		Transition transition = this.transitions.get(event);
		if (transition != null){
			return transition.getEndState();
		} else {
			return this;
		}
	}

	
	
}
