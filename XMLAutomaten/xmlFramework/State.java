package xmlFramework;

import java.util.HashMap;




public final class State {
	
	private final HashMap<String, Transition> transitions = new HashMap<>();
	private final String name;
//	private String entryAction;
//	private String exitAction;
	
	
	
	public State(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addTransition(Event event, Transition transition){
		this.transitions.put(event.getEventName(), transition);
	}
	
	public State processEvent(Event event){
		Transition transition = this.transitions.get(event.getEventName());
		
		if (transition != null){
			
			return transition.getEndState();
		} else {
			
			return this;
		}
	}

/* optionale Erweiterung!
 * 
 * 	public String getEntryAction() {
		return entryAction;
	}

	public void setEntryAction(String entryAction) {
		this.entryAction = entryAction;
	}

	public String getExitAction() {
		return exitAction;
	}

	public void setExitAction(String exitAction) {
		this.exitAction = exitAction;
	}
*/
	
	
	
}
