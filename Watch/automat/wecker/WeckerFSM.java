package automat.wecker;
/**
 * Sobald die statische Methode getWeckerFSMInstance() aufgerufen wird,
 * wird der WeckerFSM Automat Instanziiert und zurückgegeben.
 * 
 * Hierbei wird auf das Singleton-Pattern gesetzt.
 * Diese Implementierung ist nicht thread-safe und darf somit in keiner multi-threaded Anwendung
 * verwendet werden.
 */
import java.util.HashSet;

public final class WeckerFSM {
	
	private static WeckerFSM fsm;
	
	private State state;
	private HashSet<State> allAvailableStates;
	
	private WeckerFSM(State state){
		this.state = state;
		allAvailableStates = new HashSet<State>();
	}
	
	//singleton
	public static  WeckerFSM getWeckerFSMInstance(){
		
		if (fsm == null){
		
		State piepen = new State("piepen");
		State still = new State("still");
		
		
		Transition geheZuPiepen = new Transition(piepen);
		Transition geheZuStill = new Transition(still);
		
		
	
		piepen.addTransition(WeckerEvent.D, geheZuStill);
		still.addTransition(WeckerEvent.WECKZEIT_ERREICHT, geheZuPiepen);
		
		
		
		fsm = new WeckerFSM(still);
		
		fsm.addState(still);
		fsm.addState(piepen);
		
		}
		return fsm;
	}
	
	public State getState(){
		return this.state;
	}
	
	public void process(WeckerEvent event){
		State tmp = state.processEvent(event);
		if (tmp != null)
			this.state = tmp;
	}


	public void addState(State state) {
		allAvailableStates.add(state);
	}
	
}
