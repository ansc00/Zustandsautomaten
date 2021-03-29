package statePatternFSM2;

public class R1 implements Zustand{

	@Override
	public Zustand processEventA(){
		return new R2();
	}
	
	@Override
	public Zustand processEventB(){
		return this;
	}
	
}
