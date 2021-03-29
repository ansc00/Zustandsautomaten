package statePatternFSM2;

public class R2 implements Zustand{

	@Override
	public Zustand processEventA(){
		return this;
	}
	
	@Override
	public Zustand processEventB(){
		return new R1();
	}
}
