package stateGraphFSM2;

public final class FinitStateMachine {

	private State state;
	
	public FinitStateMachine(State state){
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
