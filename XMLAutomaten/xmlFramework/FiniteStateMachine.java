package xmlFramework;



import java.util.HashSet;

public final class FiniteStateMachine {

	private HashSet<State> states;
	private State state;
	private State startState;
	private HashSet<State> endStates;
	private HashSet<Event> events;
	
	
	
	
	
	public HashSet<State> getStates() {
		return states;
	}



	public void setStates(HashSet<State> states) {
		this.states = states;
	}



	public State getStartState() {
		return startState;
	}

	public void setStartState(State startState) {
		this.startState = startState;
	}

	public HashSet<State> getEndStates() {
		return endStates;
	}

	public void setEndStates(HashSet<State> endStates) {
		this.endStates = endStates;
	}

	public HashSet<Event> getEvents() {
		return events;
	}

	public void setEvents(HashSet<Event> events) {
		this.events = events;
	}

	public void setState(State state) {
		this.state = state;
	}

	
	
	public State getState(){
		return this.state;
	}
	
	public void process(Event event){
		State tmp = state.processEvent(event);
		if (tmp != null)
			this.state = tmp;
		
	}
	
	
}
