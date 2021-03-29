package automat.uhr;
/**
 * Sobald die statische Methode getUhrFSMInstance() aufgerufen wird,
 * erfolgt eine Instanziierung des UhrFSM Automaten und wird dann zurückgegeben.
 * 
 * Hierbei wird auf das Singleton-Pattern gesetzt.
 * Diese Implementierung ist nicht thread-safe und darf somit in keiner multi-threaded Anwendung
 * verwendet werden.
 */
import java.util.HashSet;

public final class UhrFSM {

	private static UhrFSM fsm;
	
	private State state;
	private HashSet<State> allAvailableStates;
	
	
	private UhrFSM(State state){
		this.state = state;
		allAvailableStates = new HashSet<State>();
	}
	
	//singleton
	public static UhrFSM getUhrFSMInstance(){
		
		if (fsm == null){
		
		//States
		State showUhrzeit = new State("showUhrzeit");
		State uhrMinute = new State("uhrMinute");
		State uhrStunde = new State("uhrStunde");
		
		State showWeckzeit = new State("showWeckzeit");
		State weckerMinute = new State("weckerMinute");
		State weckerStunde = new State("weckerStunde");
		
		
		//Transitions
		Transition geheZuUhrMinute = new Transition(uhrMinute);
		Transition geheZuUhrStunde = new Transition(uhrStunde);
		Transition geheZuShowUhrzeit = new Transition(showUhrzeit);
		
		Transition geheZuWeckerMinute = new Transition(weckerMinute);
		Transition geheZuWeckerStunde = new Transition(weckerStunde);
		Transition geheZuShowWeckzeit = new Transition(showWeckzeit);
		
		
		//Transitions und Events an die States dranhängen
		showUhrzeit.addTransition(UhrEvent.C, geheZuUhrMinute);
		uhrMinute.addTransition(UhrEvent.C, geheZuUhrStunde);
		uhrStunde.addTransition(UhrEvent.C, geheZuShowUhrzeit);
		
		showUhrzeit.addTransition(UhrEvent.A, geheZuShowWeckzeit);
		showWeckzeit.addTransition(UhrEvent.B, geheZuShowUhrzeit);
		
		showWeckzeit.addTransition(UhrEvent.C,geheZuWeckerMinute);
		weckerMinute.addTransition(UhrEvent.C, geheZuWeckerStunde);
		weckerStunde.addTransition(UhrEvent.C, geheZuShowWeckzeit);
		
		//B
		uhrMinute.addTransition(UhrEvent.B, geheZuShowUhrzeit);
		uhrStunde.addTransition(UhrEvent.B, geheZuShowUhrzeit);
		
		weckerMinute.addTransition(UhrEvent.B, geheZuShowWeckzeit);
		weckerStunde.addTransition(UhrEvent.B, geheZuShowWeckzeit);
		
		
		fsm = new UhrFSM(showUhrzeit);
	
		
		fsm.addState(showUhrzeit);
		fsm.addState(uhrMinute);
		fsm.addState(uhrStunde);
		
		fsm.addState(showWeckzeit);
		fsm.addState(weckerMinute);
		fsm.addState(weckerStunde);
		
		}
		return fsm;
	}
	
	
	
	public State getState(){
		return this.state;
	}
	
	public void process(UhrEvent event){
		State tmp = state.processEvent(event);
		if (tmp != null)
			this.state = tmp;
	}


	public void addState(State state) {
		allAvailableStates.add(state);
	}

	
	
	
}
