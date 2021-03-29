package stateGraphFSM1;




public final class FiniteStateMachine {

	private State state;
	
	public FiniteStateMachine(State state){
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
