package prozeduraleImplementierung;
/**
 * Bei einer prozeduralen Implementierung wird der aktuelle Zustand in einer Variable gehalten. 
 * Mit Hilfe einer switch-case-Konstruktion wird beim eintreffen eines Events eine entsprechende Event-Verarbeitung 
 * eingeleitet die den aktuellen Zustand ggf. verändert.
 *
 */
public class FSM2 {

	//überprüft ob sich der Automat nach einer Ereignisfolge z.B.aba in einem gültigen Endzustand befindet.
	public static boolean checkTransitions(String sequenz){
	
		String eventSequenz = sequenz; 
		String state = "S"; //Startszustand
		boolean istGueltigerEndzustand = false;
	
		int index = 0;
		while (index < eventSequenz.length()) { 
			char event = eventSequenz.charAt(index); 
			
			
			switch (state) { 
			case "S": switch (event) {
				case 'a': state = "Q1"; 
				break; 
				case 'b': state = "R1"; 
				break; 
				default: System.err.println("Falsches Event"); 
				}//innerSwitch
			break;
			
			case "Q1": switch (event) {
				case 'a': state = "Q1"; 
				break; 
				case 'b': state = "Q2"; 
				break; 
				default: System.err.println("Falsches Event"); 
				}//innerSwitch
			break;
	
			case "Q2": switch (event) {
				case 'a': state = "Q1"; 
				break; 
				case 'b': state = "Q2"; 
				break; 
				default: System.err.println("Falsches Event"); 
			}//innerSwitch
			break;
			
			case "R1": switch (event) {
				case 'a': state = "R2"; 
				break; 
				case 'b': state = "R1"; 
				break; 
				default: System.err.println("Falsches Event"); 
				}//innerSwitch
			break;
			
			
			case "R2": switch (event) {
				case 'a': state = "R2"; 
				break; 
				case 'b': state = "R1"; 
				break; 
				default: System.err.println("Falsches Event"); 
				}//innerSwitch
			break;
			
			
			default: System.err.println("Falscher Zustand"); 
			}//switch
			index++; 
		}//while
	
		//prüfen auf gültigen Endzustand (Q1 oder R1)
				if ( state.equals("Q1") || state.equals("R1") ){
					istGueltigerEndzustand = true;
					
				} else{
					System.out.println("Ungültiger Endzustand! (" + state + ")");
				}
				
				return istGueltigerEndzustand;
		
	
	}
	
		
		
	
}//class
