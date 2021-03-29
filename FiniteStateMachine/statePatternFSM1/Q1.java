package statePatternFSM1;

public class Q1 implements Zustand{

	@Override
	public Zustand processEvent0(){
		return this;
	}
	
	@Override
	public Zustand processEvent1(){
		return new Q2();
	}
}
