package statePatternFSM2;

public class Q2 implements Zustand{

	@Override
	public Zustand processEventA(){
		return new Q1();
	}
	
	@Override
	public Zustand processEventB(){
		return this;
	}
	
}
