package statePatternFSM1;

public class Q2 implements Zustand{

	@Override
	public Zustand processEvent0(){
		return new Q1();
	}
	
	@Override
	public Zustand processEvent1(){
		return this;
	}
	
}
