package test;
/**
 * Tests zur prozeduralen Implementierung der FSM2
 * 
 *  Bei einer FSM dieser Gr��e ist es m�glich alle Pfade zu durchlaufen. 
 *	In gr��eren Projekten empfiehlt es sich zumindest eine Zweig�berdeckung anzustreben.
 */
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import prozeduraleImplementierung.FSM2;

public class FSM2Test {
	
	  
		//M�glichkeiten aus dem Initialzustand S
		@Test
		public void testUebergangVonSZuQ1(){
			assertTrue("NICHT im g�ltigen Endzustand! (Q1)",FSM2.checkTransitions("a") == true);
		}
		
		@Test
		public void testUebergangVonSZuR1(){
			assertTrue("NICHT im g�ltigen Endzustand! (R1)",FSM2.checkTransitions("b") == true);
		}

		@Test
		public void testFalschesEventBeiS(){
			assertTrue("NICHT im g�ltigen Endzustand! (Q1 oder R1)",FSM2.checkTransitions("c") == false);
		}
		
		
		
		
		
		//linke Seite des Automaten
		@Test
		public void testBleibBeiQ1(){
			assertTrue("NICHT im g�ltigen Endzustand! (Q1)",FSM2.checkTransitions("aa") == true);
		}
		
		@Test
		public void testUebergangVonQ1ZuQ2(){
			assertTrue("NICHT im ung�ltigen Zustand! (Q2)",FSM2.checkTransitions("ab") == false);
		}
		
		@Test
		public void testBleibBeiQ2(){
			assertTrue("NICHT im ung�ltigen Zustand! (Q2)",FSM2.checkTransitions("abb") == false);
		}
		
		@Test
		public void testUebergangVonQ2ZuQ1(){
			assertTrue("NICHT im g�ltigen Endzustand! (Q1)",FSM2.checkTransitions("abba") == true);
		}
		
		@Test
		public void testFalschesEventBeiQ1(){
			assertTrue("NICHT im g�ltigen Endzustand! (Q1)",FSM2.checkTransitions("ac") == true);
		}
		
		@Test
		public void testFalschesEventBeiQ2(){
			assertTrue("NICHT im ung�ltigen Zustand! (Q2)",FSM2.checkTransitions("abc") == false);
		}
		
		
		
		
		
		//rechte Seite des Automaten
		@Test
		public void testBleibBeiR1(){
			assertTrue("NICHT im g�ltigen Endzustand! (R1)",FSM2.checkTransitions("bb") == true);
		}
		
		@Test
		public void testUebergangVonR1ZuR2(){
			assertTrue("NICHT im ung�ltigen Zustand! (R2)",FSM2.checkTransitions("ba") == false);
		}
		
		@Test
		public void testBleibBeiR2(){
			assertTrue("NICHT im ung�ltigen Zustand! (R2)",FSM2.checkTransitions("baa") == false);
		}
		
		@Test
		public void testUebergangVonR2ZuR1(){
			assertTrue("NICHT im g�ltigen Endzustand! (R1)",FSM2.checkTransitions("bab") == true);
		}
		
		@Test
		public void testFalschesEventBeiR1(){
			assertTrue("NICHT im g�ltigen Endzustand! (R1)",FSM2.checkTransitions("bc") == true);
		}
		
		@Test
		public void testFalschesEventBeiR2(){
			assertTrue("NICHT im ung�ltigen Zustand! (R2)",FSM2.checkTransitions("bac") == false);
		}
	
}
