package automat1;
/**
 * Liest den Automaten (Automat1) aus einer XML Datei ein und startet einen kleinen Testlauf.
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
		String xmlFilename = "./XMLAutomaten/Automat1.xml";
		String xmlSchemaFilePath = "./XMLAutomaten/Automat1.xsd";

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

		fsm.process( new Event("0") ); //bleibe bei Q1
		System.out.println("Eingabe: 0 \t neuer Zustand: " + fsm.getState().getName() );

		fsm.process( new Event("1")); //gehe zu Q2
		System.out.println("Eingabe: 1 \t neuer Zustand: " + fsm.getState().getName() );

		fsm.process( new Event("1")); //gehe zu Q2
		System.out.println("Eingabe: 1 \t neuer Zustand: " + fsm.getState().getName() );


		fsm.process( new Event("0")); //gehe zu Q2
		System.out.println("Eingabe: 0 \t neuer Zustand: " + fsm.getState().getName() );


		//falsches Event
		fsm.process( new Event("3")); //bleibe bei Q1
		System.out.println("Eingabe: 3 \t neuer Zustand: " + fsm.getState().getName() );







	}
}
