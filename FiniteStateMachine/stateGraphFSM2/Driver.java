package stateGraphFSM2;
/** Eine Variante der objektorientierten Umsetzung bietet die Realisierung als Zustandsgraph.
 * 
 * Dabei werden allgemeine Klassen zur Beschreibung von Zuständen und Übergängen definiert.
 * Die Events werden als eigener Datentyp (enum) festgelegt und können bei der FSM als Parameter bei der
 * Methode process() angegeben werden. Dies kann bei einer gültigen Aktion zu einem Zustandswechsel führen.
 */
public class Driver {

	public static void main(String[] args)
	{
		State s = new State("S");
		State q1 = new State("Q1");
		State q2 = new State("Q2");
		State r1 = new State("R1");
		State r2 = new State("R2");
		
		Transition toQ1 = new Transition(q1);
		Transition toQ2 = new Transition(q2);
		Transition toR1 = new Transition(r1);
		Transition toR2 = new Transition(r2);
		
		s.addTransition(Event.A, toQ1 );
		s.addTransition(Event.B, toR1 );
		q1.addTransition(Event.A, toQ1 );
		q1.addTransition(Event.B, toQ2 );
		q2.addTransition(Event.A, toQ1 );
		q2.addTransition(Event.B, toQ2 );
		r1.addTransition(Event.A, toR2);
		r1.addTransition(Event.B, toR1);
		r2.addTransition(Event.A, toR2);
		r2.addTransition(Event.B, toR1);
		
		FinitStateMachine fsm = new FinitStateMachine(s);
		System.out.println("startState: " + fsm.getState().getName() );
		
		fsm.process( Event.A ); //gehe zu Q1
		System.out.println( fsm.getState().getName() );
		
		fsm.process( Event.A ); //bleibe bei Q1
		System.out.println( fsm.getState().getName() );
		
		fsm.process( Event.B); //gehe zu Q2
		System.out.println( fsm.getState().getName() );
		
		fsm.process(Event.B); //bleibe bei Q2
		System.out.println(fsm.getState().getName());
		
		fsm.process(Event.A); //gehe zu Q1
		System.out.println(fsm.getState().getName());
		
		
		
		System.out.println();
		FinitStateMachine fsm2 = new FinitStateMachine(s);
		System.out.println("startState: " + fsm2.getState().getName() );
		
		fsm2.process( Event.B ); //gehe zu R1
		System.out.println( fsm2.getState().getName() );
		
		fsm2.process( Event.B ); //bleibe bei R1
		System.out.println( fsm2.getState().getName() );
		
		fsm2.process( Event.A); //gehe zu R2
		System.out.println( fsm2.getState().getName() );
		
		fsm2.process(Event.A); //bleibe bei R2
		System.out.println(fsm2.getState().getName());
		
		fsm2.process(Event.B); //gehe zu R1
		System.out.println(fsm2.getState().getName());
		
	}
	
}
