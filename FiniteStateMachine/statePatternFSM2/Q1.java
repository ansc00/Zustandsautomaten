package statePatternFSM2;

public class Q1 implements Zustand{

	@Override
	public Zustand processEventA(){
		return this;
	}
	
	@Override
	public Zustand processEventB(){
		return new Q2();
	}
}
