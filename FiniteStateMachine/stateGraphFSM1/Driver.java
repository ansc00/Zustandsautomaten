package stateGraphFSM1;
/** Eine Variante der objektorientierten Umsetzung bietet die Realisierung als Zustandsgraph.
 * 
 * Dabei werden allgemeine Klassen zur Beschreibung von Zust�nden und �berg�ngen definiert.
 * Die Events werden als eigener Datentyp (enum) festgelegt und k�nnen bei der FSM als Parameter bei der
 * Methode process() angegeben werden. Dies kann bei einer g�ltigen Aktion zu einem Zustandswechsel f�hren.
 */
public class Driver {

	public static void main(String[] args)
	{
		
		State q1 = new State("Q1");
		State q2 = new State("Q2");
		
		Transition toQ1 = new Transition(q1);
		Transition toQ2 = new Transition(q2);

		
		q1.addTransition(Event.ZERO, toQ1 );
		q1.addTransition(Event.ONE, toQ2 );
		q2.addTransition(Event.ZERO, toQ1 );
		q2.addTransition(Event.ONE, toQ2 );
		
		
		FiniteStateMachine fsm = new FiniteStateMachine(q1);
		System.out.println("startState: "+  fsm.getState().getName() );
		
		
		fsm.process( Event.ZERO ); //bleibe bei Q1
		System.out.println( fsm.getState().getName() );
		
		fsm.process( Event.ONE); //gehe zu Q2
		System.out.println( fsm.getState().getName() );
		
		fsm.process(Event.ONE); //bleibe bei Q2
		System.out.println(fsm.getState().getName());
		
		fsm.process(Event.ZERO); //gehe zu Q1
		System.out.println(fsm.getState().getName());
		
		
	}
	
}
