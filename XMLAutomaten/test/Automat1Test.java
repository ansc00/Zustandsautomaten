package test;
/**
 * JUnit Tests zu dem Automat1
 * 
 * Anmerkung: Der Automat muss immer wieder "neu" geladen werden (@Before) bei der setUp() Methode,
 * da die Tests NICHT in Ihrer Reihenfolge durchgeführt werden!
 * Der Test "geheZuQ2" wird VOR dem Test "Initialzustand" durchgeführt, somit wird der zweite Test falsch bewertet!
 */
import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import xmlFramework.Event;
import xmlFramework.FiniteStateMachine;
import xmlFramework.XMLParser;

public class Automat1Test {

	 FiniteStateMachine fsm ;

	 
	@Before 
	public void setUp() throws ParserConfigurationException, SAXException, IOException{ 
		
		//Daten einlesen aus xml und Collections befüllen
		String xmlFilename = "./XMLAutomaten/Automat1.xml";
		String xmlSchemaFilePath = "./XMLAutomaten/Automat1.xsd";

		XMLParser xmlParser = new XMLParser(xmlFilename, xmlSchemaFilePath);

		fsm = xmlParser.getFiniteStateMachine();

	}

	@Test
	public void testInitialzustand(){
		assertTrue("Zustandsautomat ist NICHT im Initialzustand(Q1)",fsm.getState().getName().equals("Q1")); 
	}

	@Test
	public void testBleibBeiQ1(){
		fsm.process( new Event("0") ); 
		assertTrue("Zustand NICHT Q1", fsm.getState().getName().equals("Q1"));
	}
	
	@Test
	public void testGeheZuQ2(){
		fsm.process( new Event("1") ); 
		assertTrue("Zustand NICHT Q2", fsm.getState().getName().equals("Q2"));
	}
	
	@Test
	public void testBleibBeiQ2(){
		fsm.process( new Event("1") ); 
		assertTrue("Zustand NICHT Q2", fsm.getState().getName().equals("Q2"));
	}
	
	@Test
	public void testGeheZuQ1(){
		fsm.process( new Event("0") ); 
		assertTrue("Zustand NICHT Q1", fsm.getState().getName().equals("Q1"));
	}
	
	
	//falsche Events;
	@Test
	public void testFalschesEventBeiQ1(){
		fsm.process( new Event("5") ); 
		assertTrue("Zustand NICHT Q1", fsm.getState().getName().equals("Q1"));
	}
	
	@Test
	public void testFalschesEventBeiQ2(){
		fsm.process(new Event("1"));
		assertTrue("Zustand NICHT Q2", fsm.getState().getName().equals("Q2"));
		fsm.process( new Event("5") ); 
		assertTrue("Zustand NICHT Q2", fsm.getState().getName().equals("Q2"));
	}
}
