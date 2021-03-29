package automat.wecker;



public final class Transition {

	private final State state;
	
	public Transition(State endState){
		this.state = endState;
	}
	
	public State getEndState(){
		return this.state;
	}
}
