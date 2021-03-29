package statePatternFSM1;
/**Eine m�gliche objektorientierte Umsetzungen bietet das State Pattern.
 * 
 * Dabei werden die Methoden zur Event-Verarbeitung durch ein Interface sichergestellt.
 * Alle m�glichen Zust�nde werden als eigene Klassen implementiert und m�ssen
 * diese Methoden Zustandsspezifisch definieren.
 * 
 * @author Anatoli Sch�fer
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
