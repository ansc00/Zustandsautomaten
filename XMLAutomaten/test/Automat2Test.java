package test;
/**
 *  JUnit Tests zu dem Automaten Nr. 2
 */
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import xmlFramework.Event;
import xmlFramework.FiniteStateMachine;
import xmlFramework.XMLParser;

public class Automat2Test {

	FiniteStateMachine fsm ;

	@Before 
	public void setUp() throws ParserConfigurationException, SAXException, IOException{ 
		
		//Daten einlesen aus xml und Collections befüllen
		String xmlFilename = "./XMLAutomaten/Automat2.xml";
		String xmlSchemaFilePath = "./XMLAutomaten/Automat2.xsd";

		XMLParser xmlParser = new XMLParser(xmlFilename, xmlSchemaFilePath);

		fsm = xmlParser.getFiniteStateMachine();
	}

	@Test
	public void testInitialzustand(){
		assertTrue("Zustandsautomat ist NICHT im Initialzustand(S)",fsm.getState().getName().equals("S")); 
	}
	
	
	//linke Seite
	@Test
	public void testUebergangVonSZuQ1(){
		fsm.process( new Event("a") ); 
		assertTrue("Zustand NICHT Q1", fsm.getState().getName().equals("Q1"));
	}
	
	@Test
	public void testBleibeBeiQ1(){
		fsm.process( new Event("a") ); 
		assertTrue("Zustand NICHT Q1", fsm.getState().getName().equals("Q1"));
		fsm.process( new Event("a") ); 
		assertTrue("Zustand NICHT Q1", fsm.getState().getName().equals("Q1"));
	}
	
	@Test
	public void testUebergangVonQ1ZuQ2(){
		fsm.process( new Event("a") ); 
		assertTrue("Zustand NICHT Q1", fsm.getState().getName().equals("Q1"));
		fsm.process( new Event("b") ); 
		assertTrue("Zustand NICHT Q2", fsm.getState().getName().equals("Q2"));
	}
	
	@Test
	public void testBleibeBeiQ2(){
		fsm.process( new Event("a") ); 
		assertTrue("Zustand NICHT Q1", fsm.getState().getName().equals("Q1"));
		fsm.process( new Event("b") ); 
		assertTrue("Zustand NICHT Q2", fsm.getState().getName().equals("Q2"));
		fsm.process( new Event("b") ); 
		assertTrue("Zustand NICHT Q2", fsm.getState().getName().equals("Q2"));
	}
	
	
	
	@Test
	public void testUebergangVonQ2ZuQ1(){
		fsm.process( new Event("a") ); 
		assertTrue("Zustand NICHT Q1", fsm.getState().getName().equals("Q1"));
		fsm.process( new Event("b") ); 
		assertTrue("Zustand NICHT Q2", fsm.getState().getName().equals("Q2"));
		fsm.process( new Event("a") ); 
		assertTrue("Zustand NICHT Q1", fsm.getState().getName().equals("Q1"));
	}
	
	//falsche Events bei Q2
	@Test
	public void testFalschesEventBeiQ2(){
		fsm.process(new Event("a"));
		assertTrue("Zustand NICHT Q1", fsm.getState().getName().equals("Q1"));
		fsm.process( new Event("b") ); 
		assertTrue("Zustand NICHT Q2", fsm.getState().getName().equals("Q2"));
		fsm.process( new Event("c") ); 
		assertTrue("Zustand NICHT Q2", fsm.getState().getName().equals("Q2"));
	}
	
	//falsche Events bei Q1
	@Test
	public void testFalschesEventBeiQ1(){
		fsm.process(new Event("a"));
		assertTrue("Zustand NICHT Q1", fsm.getState().getName().equals("Q1"));
		fsm.process( new Event("c") ); 
		assertTrue("Zustand NICHT Q1", fsm.getState().getName().equals("Q1"));
	}
	
	//falsches Event bei S
	@Test
	public void testFalschesEventBeiS(){
		fsm.process( new Event("c") ); 
		assertTrue("Zustand NICHT S", fsm.getState().getName().equals("S"));
	}
	
	
	
	
	
	//rechte Seite 
	@Test
	public void testUebergangVonSZuR1(){
		fsm.process( new Event("b") ); 
		assertTrue("Zustand NICHT R1", fsm.getState().getName().equals("R1"));
	}
	
	@Test
	public void testBleibeBeiR1(){
		fsm.process( new Event("b") ); 
		assertTrue("Zustand NICHT R1", fsm.getState().getName().equals("R1"));
		fsm.process( new Event("b") ); 
		assertTrue("Zustand NICHT R1", fsm.getState().getName().equals("R1"));
	}
	
	@Test
	public void testUebergangVonR1ZuR2(){
		fsm.process( new Event("b") ); 
		assertTrue("Zustand NICHT R1", fsm.getState().getName().equals("R1"));
		fsm.process( new Event("a") ); 
		assertTrue("Zustand NICHT R2", fsm.getState().getName().equals("R2"));
	}
	
	@Test
	public void testBleibeBeiR2(){
		fsm.process( new Event("b") ); 
		assertTrue("Zustand NICHT R1", fsm.getState().getName().equals("R1"));
		fsm.process( new Event("a") ); 
		assertTrue("Zustand NICHT R2", fsm.getState().getName().equals("R2"));
		fsm.process( new Event("a") ); 
		assertTrue("Zustand NICHT R2", fsm.getState().getName().equals("R2"));
	}
	
	
	
	@Test
	public void testUebergangVonR2ZuR1(){
		fsm.process( new Event("b") ); 
		assertTrue("Zustand NICHT R1", fsm.getState().getName().equals("R1"));
		fsm.process( new Event("a") ); 
		assertTrue("Zustand NICHT R2", fsm.getState().getName().equals("R2"));
		fsm.process( new Event("b") ); 
		assertTrue("Zustand NICHT R1", fsm.getState().getName().equals("R1"));
	}
	
	//falsche Events bei R2
	@Test
	public void testFalschesEventBeiR2(){
		fsm.process(new Event("b"));
		assertTrue("Zustand NICHT R1", fsm.getState().getName().equals("R1"));
		fsm.process( new Event("a") ); 
		assertTrue("Zustand NICHT R2", fsm.getState().getName().equals("R2"));
		fsm.process( new Event("c") ); 
		assertTrue("Zustand NICHT R2", fsm.getState().getName().equals("R2"));
	}
	
	//falsche Events bei R1
	@Test
	public void testFalschesEventBeiR1(){
		fsm.process(new Event("b"));
		assertTrue("Zustand NICHT R1", fsm.getState().getName().equals("R1"));
		fsm.process( new Event("c") ); 
		assertTrue("Zustand NICHT R1", fsm.getState().getName().equals("R1"));
	}
	
}
