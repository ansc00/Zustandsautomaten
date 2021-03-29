package statePatternFSM2;
/**Eine mögliche objektorientierte Umsetzungen bietet das State Pattern an.
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
		
		Zustand state = new S();
		System.out.println(state.getClass().getSimpleName());
		
		state = state.processEventA(); //gehe zu Q1
		System.out.println(state.getClass().getSimpleName());
		
		state = state.processEventA(); //bleibe bei Q1
		System.out.println(state.getClass().getSimpleName());

		
		state = state.processEventB();// gehe zu Q2
		System.out.println(state.getClass().getSimpleName());
	
		state = state.processEventB(); //bleibe bei Q2
		System.out.println(state.getClass().getSimpleName());
		
		state = state.processEventA(); //gehe zu Q1
		System.out.println(state.getClass().getSimpleName());
		
		System.out.println();
		
		Zustand state2 = new S();
		System.out.println(state2.getClass().getSimpleName());
		
		state2 = state2.processEventB(); //gehe zu R1
		System.out.println(state2.getClass().getSimpleName());
		
		state2 = state2.processEventB(); //bleibe bei R1
		System.out.println(state2.getClass().getSimpleName());

		
		state2 = state2.processEventA();// gehe zu R2
		System.out.println(state2.getClass().getSimpleName());
	
		state2 = state2.processEventA(); //bleibe bei R2
		System.out.println(state2.getClass().getSimpleName());
		
		state2 = state2.processEventB(); //gehe zu R1
		System.out.println(state2.getClass().getSimpleName());
		
		
	
	
	
	}

}
