package prozeduraleImplementierung;
/**
 * Bei einer prozeduralen Implementierung wird der aktuelle Zustand in einer Variable gehalten. 
 * Mit Hilfe einer switch-case-Konstruktion wird beim eintreffen eines Events eine entsprechende Event-Verarbeitung 
 * eingeleitet die den aktuellen Zustand ggf. ver�ndert.
 *
 */
public class FSM1 {

	//�berpr�ft ob sich der Automat nach einer Ereignisfolge z.B. 010 in einem g�ltigen Endzustand befindet.
	public static boolean checkTransitions(String sequenz){

		String eventSequenz = sequenz;
		String state = "Q1"; //Startszustand
		boolean istGueltigerEndzustand = false;


		int index = 0;
		while (index < eventSequenz.length()) { 
			char event = eventSequenz.charAt(index); 
			switch (state) { 
				case "Q1": switch (event) {
					case '0': state = "Q1"; 
					break; 
					case '1': state = "Q2"; 
					break; 
					default: System.err.println("Falsches Event"); 
					}//innerSwitch
			break;

				case "Q2": switch (event) {
					case '0': state = "Q1"; 
					break; 
					case '1': state = "Q2"; 
					break; 
					default: System.err.println("Falsches Event"); 
					}//innerSwitch
				break;
			default: System.err.println("Falscher Zustand"); 
			}//switch
			index++; 
		}//while

		//pr�fen auf g�ltigen Endzustand (Q1)
		if (state.equals("Q1")){
			istGueltigerEndzustand = true;
		} else{
			System.out.println("Ung�ltiger Endzustand! (Q2)");
		}

		return istGueltigerEndzustand;
	}





}//class
