package _driver;
/**
 * Bei einem eintretenden Event (A, B, C, D, <, >) muss eine entsprechende Event-Verarbeitung angestoßen und ggf. 
 * der Zustand eines Automaten geändert werden.
 * 
 * Der Automat der für die Uhrzeit zuständig ist kann mithilfe der Events A, B und C in die jeweiligen anderen Zustände übergehen,
 * um so z.B. die Uhrzeit einzustellen. 
 * Ein Zustandsübergang kann dabei nur erfolgen, wenn der Automat sich vorher in dem dafür vorgesehenen Zustand befand und das entsprechende 
 * Event ausgelöst wurde. Somit wird gewährleistet das der Automat "Uhr" in dem Zustand "zeigeZeit" bei einem 
 * eingetretenen Event "C" in den Unterzustand "UhrMinute" übergeht und in keinen anderen Fehlzustand.

 * Der Wecker hingegen besitzt nur zwei Zustände und startet in dem  Zustand "Still". 
 * Dieser wird bei erreichen der eingestellten Weckzeit in den Zustand "Piepen" überführt. 
 * Danach kann ein Zustandswechsel und die Abschaltung des Wecktons nur über den D-Button erfolgen.
 */

import javax.swing.SwingUtilities;

import automat.uhr.UhrEvent;
import automat.wecker.WeckerEvent;
import fsm.watch.gui.WatchButtonListener;
import fsm.watch.gui.WatchDisplay;
import fsm.watch.model.Watch;


public class Driver
{   
	private static class ButtonEventHandler implements WatchButtonListener
	{
		private WatchDisplay display;

		public ButtonEventHandler(WatchDisplay display)
		{
			this.display = display;
		}

		@Override
		public void event(String event)
		{

			//Aktuelle Zustand der UhrzeitFSM
			String currentStateUhrzeitFSM = display.getWatch().getUhrFSM().getState().getName();

			//Kontrollausgabe
			System.out.println("Event:\t\t" + event );
			switch( event )
			{
			case "A":
				if (currentStateUhrzeitFSM.equals("showUhrzeit")){
					display.showWeckzeit();
				}

				display.getWatch().getUhrFSM().process(UhrEvent.A);
				break;
			case "B":
				switch(currentStateUhrzeitFSM){
					case "weckerMinute":
					case "weckerStunde": display.showWeckzeit(); break;
					default: display.showUhrzeit(); break;
				}

				display.getWatch().getUhrFSM().process(UhrEvent.B);
				break;

			case "C":
				display.getWatch().getUhrFSM().process(UhrEvent.C);
				break;

			case "D":
				String weckerFSM = display.getWatch().getWeckerFSM().getState().getName();
				
				if (weckerFSM.equals("piepen")){
					display.getWatch().stopBeep();				
				}
				display.getWatch().getWeckerFSM().process(WeckerEvent.D);
				break;
				
			case ">":

				switch(currentStateUhrzeitFSM){

				case "uhrMinute": display.getWatch().increaseUhrMinute(); break;
				case "uhrStunde": display.getWatch().increaseUhrStunde();	break;
				case "weckerStunde": display.getWatch().increaseWeckerStunde(); break;
				case "weckerMinute" : display.getWatch().increaseWeckerMinute(); break;
				}

				break;

			case "<": 

				switch(currentStateUhrzeitFSM){

				case "uhrMinute": display.getWatch().decreaseUhrMinute(); break;
				case "uhrStunde": display.getWatch().decreaseUhrStunde();	break;
				case "weckerStunde": display.getWatch().decreaseWeckerStunde(); break;
				case "weckerMinute" : display.getWatch().decreaseWeckerMinute(); break;
				}
				break;
			default:  
				break;
			}     
			
			//Kontrollausgabe
			System.out.println("Zustand:\t"+display.getWatch().getUhrFSM().getState().getName() +"\n---------------------------");
		}

	}


	public static void main(String[] args)
	{
		Watch watch = new Watch();
		watch.startUhr();

		// Zeige GUI
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				WatchDisplay display = new WatchDisplay(watch);
				display.setLocationRelativeTo(null);
				display.registerWatchButtonListener( new ButtonEventHandler(display)  );
			}
		});

	}

}

