package statePatternFSM2;

public class S implements Zustand{
	
	@Override
	public Zustand processEventA(){
		return new Q1();
	}
	
	@Override
	public Zustand processEventB(){
		return new R1();
	}

}
