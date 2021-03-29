package automat2;
/**
 * Liest den Automaten (Automat2) aus einer XML Datei ein und startet einen kleinen Testlauf.
 */
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


import xmlFramework.Event;
import xmlFramework.FiniteStateMachine;
import xmlFramework.State;
import xmlFramework.XMLParser;

public class Driver {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		//Daten einlesen aus xml und Collections befüllen
		String xmlFilename = "./XMLAutomaten/Automat2.xml";
		String xmlSchemaFilePath = "./XMLAutomaten/Automat2.xsd";

		XMLParser xmlParser = new XMLParser(xmlFilename, xmlSchemaFilePath);

		FiniteStateMachine fsm = xmlParser.getFiniteStateMachine();




		System.out.println("startState: " + fsm.getStartState().getName());


		System.out.println("\nAlle gültigen Endzustände: ");
		for (State s: fsm.getEndStates()){
			System.out.println( s.getName() + " ");
		}


		System.out.println("\nAlle vorhandenen Zustände: ");
		for (State s: fsm.getStates()){
			System.out.println( s.getName() +" ");

		}

		System.out.println("\nMoegliche Eingaben (Events): ");
		for (Event e: fsm.getEvents()){
			System.out.println( e.getEventName() + " ");
		}

		
		//start
		System.out.println("\nTestlauf: ");
		System.out.println("Initialzustand: " + fsm.getState().getName());

		fsm.process( new Event("a") ); //gehe zu Q1
		System.out.println("Eingabe: a \t neuer Zustand: " + fsm.getState().getName() );
		
		fsm.process( new Event("a") ); //bleibe bei Q1
		System.out.println("Eingabe: a \t neuer Zustand: " + fsm.getState().getName() );
		
		fsm.process( new Event("b")); //gehe zu Q2
		System.out.println("Eingabe: b \t neuer Zustand: " + fsm.getState().getName() );
		
		fsm.process(new Event("b")); //bleibe bei Q2
		System.out.println("Eingabe: b \t neuer Zustand: " +fsm.getState().getName());
		
		fsm.process(new Event("a")); //gehe zu Q1
		System.out.println("Eingabe: a \t neuer Zustand: " +fsm.getState().getName());
		
		
		fsm.process(new Event("c")); //falsches event (bleibe bei Q1)
		System.out.println("Eingabe: c \t neuer Zustand: " +fsm.getState().getName());
		
		
		
		







	}

}
