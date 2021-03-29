package test;
/**
 * Tests zur prozeduralen Implementierung der FSM1
 */
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import prozeduraleImplementierung.FSM1;

public class FSM1Test {
	

	//Pr�fen aller Zustands�berg�nge
	@Test
	public void testBleibBeiQ1(){
		assertTrue("NICHT im g�ltigen Endzustand! (Q1)",FSM1.checkTransitions("0") == true);
	}
	
	@Test
	public void testUebergangVonQ1ZuQ2(){
		assertTrue("NICHT im ung�ltigen Zustand! (Q2)",FSM1.checkTransitions("1") == false);
	}
	
	@Test
	public void testBleibBeiQ2(){
		assertTrue("NICHT im ung�ltigen Zustand! (Q2)",FSM1.checkTransitions("11") == false);
	}
	
	@Test
	public void testUebergangVonQ2ZuQ1(){
		assertTrue("NICHT im g�ltigen Endzustand! (Q1)",FSM1.checkTransitions("10") == true);
	}
	
	
	
	
	//Pr�fen falscher Eventeingaben
	@Test
	public void testFalschesEventBeiQ1(){
		assertTrue("NICHT im g�ltigen Endzustand! (Q1)",FSM1.checkTransitions("5") == true);
	}
	
	@Test
	public void testFalschesEvent2BeiQ2(){
		assertTrue("NICHT im ung�ltigen Zustand! (Q2)",FSM1.checkTransitions("15") == false);
	}
	
}
