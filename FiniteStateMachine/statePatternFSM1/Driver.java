package statePatternFSM1;
/**Eine mögliche objektorientierte Umsetzungen bietet das State Pattern.
 * 
 * Dabei werden die Methoden zur Event-Verarbeitung durch ein Interface sichergestellt.
 * Alle möglichen Zustände werden als eigene Klassen implementiert und müssen
 * diese Methoden Zustandsspezifisch definieren.
 * 
 * @author Anatoli Schäfer
 *
 */
public class Driver {

	public static void main(String[] args) {
		Zustand state = new Q1();
		
		state = state.processEvent0(); //bleib bei Q1
		System.out.println(state.getClass().getSimpleName());
		
		state = state.processEvent1(); //gehe zu Q2
		System.out.println(state.getClass().getSimpleName());

		
		state = state.processEvent1();// bleib bei Q2
		System.out.println(state.getClass().getSimpleName());
	
		state = state.processEvent0(); // gehe zu Q1
		System.out.println(state.getClass().getSimpleName());
	
	
	
	}

}
