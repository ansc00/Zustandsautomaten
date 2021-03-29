package xmlFramework;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * Ein Zustandsautomat der mit XML beschrieben ist, kann mithilfe des XMLParser auf Gültigkeit geprüft und anschließend erstellt werden.
 * 
 * Der Zustandsautomat wird hierbei vollständig erstellt und in der Variable fsm gehalten.
 * @author Anatoli Schäfer
 *
 */

public class XMLParser {


	private String xmlFilename = "";
	private String xmlSchemaFilePath = "";
	private FiniteStateMachine fsm = new FiniteStateMachine();
	private HashSet<State> states = new HashSet<State>();
	private HashSet<Event> events = new  HashSet<Event>();
	private HashSet<State> endStates = new HashSet<State>();


	/** XMLParser
	 * Der Konstruktor bekommt als Parameter die XML-Datei (z.B. "./XMLAutomaten/Automat1.xml") als String sowie 
	 * das XML-Schema übergeben.
	 *
	 */
	public XMLParser(String xmlFilename,String xmlSchemaFilePath) throws ParserConfigurationException, SAXException, IOException{
		this.xmlFilename = xmlFilename;
		this.xmlSchemaFilePath = xmlSchemaFilePath;
		readXMLDocument();

	}

	/**
	 * 
	 * @return liefert die erzeugte FSM zurück.
	 */
	public FiniteStateMachine getFiniteStateMachine(){
		return fsm;
	}


	/**
	 *  Hilfsmethode zur Überprüfung ob ein Event bereits in der Collection vorhanden ist.
	 * @param str, bekommt das zu prüfende Event als String übergeben.
	 * @return liefert im Erfolgsfall true zurück.
	 */
	private boolean isEventAlreadyInEventsAvailable(String str){

		for (Event e: events){
			if (e.getEventName().equals(str)){
				return true;
			}
		}
		return false;
	}

	/** XMLParser
	 * Zunächst wird eine XML-Datei eingelesen und auf Gültigkeit mit dem angegeben XML-Schema überprüft.
	 * Anschließend wird der Automat erzeugt.
	 * 
	 */
	public void readXMLDocument() throws ParserConfigurationException, SAXException, IOException{

		// XML-Datei einlesen 
		DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = parser.parse( new File (xmlFilename));
		document.getDocumentElement().normalize();


		// Validate XML - File
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI );
		Source schemaFile = new StreamSource (new File (xmlSchemaFilePath));
		Schema schema = factory . newSchema (schemaFile);
		Validator validator = schema . newValidator ();
		validator.validate(new DOMSource (document));


		// Read States
		NodeList stateList = document.getElementsByTagName("state");
		for (int tmp = 0; tmp < stateList.getLength(); tmp ++)
		{
			Node nNode = stateList .item (tmp);
			if ( nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element) nNode;
				String name = eElement.getAttribute("name");
//				String entryAction = eElement.getAttribute("entryaction");
//				String exitAction = eElement.getAttribute("exitaction");
				State state = new State(name);

//				if (entryAction != null){
//					state.setEntryAction(entryAction);
//				}
//				if (exitAction != null){
//					state.setExitAction(exitAction);
//				}

				states.add(state);
			}
		}

		
		// Read Events
		NodeList EventList = document.getElementsByTagName("transition");

		for (int tmp = 0; tmp < EventList.getLength(); tmp ++)
		{
			Node nNode = EventList .item (tmp);
			if ( nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element) nNode;
				String eventString = eElement.getAttribute("event");

				Event event = new Event (eventString);

				if (!isEventAlreadyInEventsAvailable(eventString)){
					events.add(event);
				}
			}
		}


		// Read Transitions 
		// Dabei müssen die Transitions entsprechend an den vorher eingelesenen States angefügt werden
		NodeList transitionList = document.getElementsByTagName("transition");
		for (int tmp = 0; tmp < transitionList.getLength(); tmp ++)
		{
			Node nNode = transitionList.item (tmp);
			if ( nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element) nNode;
				String source= eElement.getAttribute("source");
				String target = eElement.getAttribute("target");
				String eventString = eElement.getAttribute("event");
//				String action = eElement.getAttribute("action");

				Event event = new Event(eventString);

				//Die Transitions an die bereits vorhandenen States anfügen.
				for (State s: states){
					for (State targetState: states){
						if (source.equals(s.getName()) && targetState.getName().equals(target)){
							Transition transition = new Transition(targetState);
							s.addTransition(event, transition);
						}
					}
				}
			}
		}

		// Read startState
		NodeList startStateL = document.getElementsByTagName("startState");
		{
			Node nNode = startStateL.item(0);
			if ( nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element) nNode;
				String name = eElement.getAttribute("name");

				for (State s: states){
					if (name.equals(s.getName())){

						//startState + aktuellenState der fsm setzen
						fsm.setState(s);
						fsm.setStartState(s);

					}
				}
			}
		}


		// Read EndStates
		NodeList endStateList = document.getElementsByTagName("endState");
		for (int tmp = 0; tmp < endStateList.getLength(); tmp ++)
		{
			Node nNode = endStateList .item (tmp);
			if ( nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element) nNode;
				String name = eElement.getAttribute("name");

				for (State s: states){
					if (name.equals(s.getName()))

						endStates.add(s);
				}
			}
		}

		//Collection der fsm befüllen
		fsm.setStates(states);
		fsm.setEndStates(endStates);
		fsm.setEvents(events);

	}
}
