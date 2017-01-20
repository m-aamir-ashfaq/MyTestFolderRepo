// Some parts of this code have been automatically generated - copyright for generic plug-in procedure reserved by Ingenieurbuero David Fischer AG, Switzerland.
// Copyright for manual written code belongs to <your name>, <your company>, <your country>
import dfischer.utils.GenericPluginInterface;
import dfischer.utils.WebSocketPluginInterface;
import dfischer.utils.LoadtestPluginFixedUserInputField;
import dfischer.utils.LogVector;
import dfischer.utils.LoadtestPluginContext;
import dfischer.utils.HttpTestWebsocketContext;
import dfischer.utils.HttpLoadTest;
import dfischer.utils.PerformanceData;
import dfischer.utils.CookieHandler;
import dfischer.utils.HttpTestURL;
import dfischer.proxysniffer.WebSocketData;
import dfischer.websocket.*;
 
/**
 * Load test add-on module.
 */
public class newPlugin implements WebSocketPluginInterface
{
	private String cId = "kkj";		// input parameter #1 - label "dfischer.proxysniffer.ProxySnifferVar@6a37f729"
	private String payload = "This is a collaborative process, so dig in and try to help out! There's tons of details missing, just waiting for you to add them! So send us a pull request, please!";		// input parameter #2 - label "dfischer.proxysniffer.ProxySnifferVar@43db3a"


	private LogVector logVector = null;		// internal log vector - use logVector.log(<String>) to write log data
	
	
	// ----------------------------------------------------------------------------
	// PART 1: var handler GUI definition and load test integration
	//
	// Note: automatically generated - no manual programming required for this part
	// ----------------------------------------------------------------------------
	
	
	public int getPluginType()
	{
		return GenericPluginInterface.TYPE_LOADTEST_EXEC;
	}
	
	
	public String getPluginName()
	{
		return "newPlugin plug-in";
	}
	
	
	public String getPluginDescription()
	{
		return "A high-performance and robust Java stack on the server side with Spring Boot\n\n";
	}
	
	
	public int getAllowedConstructScope()
	{
		return WebSocketPluginInterface.CONSTRUCT_SCOPE_LOOP;
	}
	
	
	
	public boolean allowMultipleUsage()
	{
		return true;
	}
	
	
	public String[] getInputParameterLabels()
	{
		String[] labels = new String[2];
		labels[0] = "cId";
		labels[1] = "payload";
		return labels;
	}
	
	
	public LoadtestPluginFixedUserInputField[] getFixedUserInputFields()
	{
		LoadtestPluginFixedUserInputField[] userInputFields = new LoadtestPluginFixedUserInputField[2];
		userInputFields[0] = null;
		userInputFields[1] = null;
		return userInputFields;
	}
	
	
	public int allowOptionalInputParameter()
	{
		return -1;		// all input parameters required
	}
	
	
	public String[] getOutputParameterLabels()
	{
		String[] labels = new String[2];
		labels[0] = "cId";
		labels[1] = "payload";
		return labels;
	}
	
	
	public int allowOptionalOutputParameter()
	{
		return -1;		// all output parameters required
	}
	
	
	public LogVector getLogVector()
	{
		return logVector;
	}
	
	
	
	// ----------------------------------------------------------------------------
	// PART 2: runtime behavior / plug-in functionality
	//
	// This part requires manual programming (see sample code section below)
	// ----------------------------------------------------------------------------
	
	
	/**
	 * Initialize plug-in at start of loop (new instance per loop).
	 */
	public void construct(Object context)
	{
		// LoadtestPluginContext pluginContext = (LoadtestPluginContext) context;
	}
	
	
	/**
	 * Transfer input parameter before execute() is called.
	 *
	 * input parameter #1: (text) cId / default value = 'kkj' / label "dfischer.proxysniffer.ProxySnifferVar@6a37f729"
	 * input parameter #2: (text) payload / default value = 'This is a collaborative process, so dig in and try to help out! There's tons of details missing, just waiting for you to add them! So send us a pull request, please!' / label "dfischer.proxysniffer.ProxySnifferVar@43db3a"
	 *
	 * Note: all input parameters are always converted from strings.
	 */
	public void setInputParameter(int parameterNumber, Object parameterValue)
	{
		switch (parameterNumber)
		{
			case 0:
				cId = (String) parameterValue;
				break;
			case 1:
				payload = (String) parameterValue;
				break;
			default:
				break;
		}
	}
	
	
	/**
	 *This method is called before each message is sent after the Web socket session is started.
	 *
	 * Intrinsic plug-in implementation.
	 */
	public WebSocketFrame beforeMessageSent(Object context,WebSocketFrame wsFrame)
	{
		logVector = new LogVector();
		HttpTestWebsocketContext webSocketContext = (HttpTestWebsocketContext) context;
		
		// vvv --- sample code --- vvv
		
		logVector.log("ws_plugin_"+getPluginName()+" before "+wsFrame.getPayloadString());
		
		
		// ^^^ --- sample code --- ^^^
		return wsFrame;
	}
	
	
	/**
	 *This method is called after every new message.
	 *
	 * Intrinsic plug-in implementation.
	 */
	public void afterMessageReceived(Object context,WebSocketFrame wsFrame)
	{
		logVector = new LogVector();
		HttpTestWebsocketContext webSocketContext = (HttpTestWebsocketContext) context;
		
		// vvv --- sample code --- vvv
		
		logVector.log("ws_plugin_"+getPluginName()+" after "+wsFrame.getPayloadString());;
		
		
		// ^^^ --- sample code --- ^^^
	}
	
	
	/**
	 * Execute will be called once after successful web socket connection.
	 *
	 */
	public void execute(Object context)
	{
		logVector = new LogVector();
		HttpTestWebsocketContext webSocketContext = (HttpTestWebsocketContext) context;
		LoadtestPluginContext pluginContext = (LoadtestPluginContext) webSocketContext.getPluginContext();
		
		// vvv --- sample code --- vvv
		
		//  ____________________________________________________________________________________________________________)
		  int frameType = WebSocketFrame.PLAIN;   // specify type of frame.(WebSocketFrame.PLAIN , WebSocketFrame.MQTT)
		 long offset = 3000; // this message will be sent '3' second after the web socket connection is established.
		  String payloadText = "New message to the server.";
		  webSocketContext.addWebSocketFrame( frameType , payloadText , offset);
		//  ____________________________________________________________________________________________________________)
		  int frameType2 = WebSocketFrame.MQTT;   // specify type of frame.(WebSocketFrame.PLAIN , WebSocketFrame.MQTT)
		  long offset2 = 3000; // this message will be sent '3' second after the web socket connection is established.
		  MqttMessage message = new MqttMessage();  // set properties of a MqttMessage
		  String payloadText2 = message.writeJsonString();
		  webSocketContext.addWebSocketFrame(  frameType2  , payloadText2 , offset2);
		//  ____________________________________________________________________________________________________________)
		 String topic3 = "sampleTopic/#"; // topic to be subscribed.
		 int qos3 = 0; // QoS for that topic(0,1 or 2).
		  long offset3 = 3000; // this message will be sent '3' second after the web socket connection is established.
		  webSocketContext.addWebSocketSubscribeFrame( topic3 , qos3 , offset3);
		//  ____________________________________________________________________________________________________________)
		  String topic4 = "sampleTopic/#"; // topic to be Un-subscribed.
		  long offset4 = 3000; // this message will be sent '3' second after the web socket connection is established.
	     webSocketContext.addWebSocketUnSubscribeFrame( topic4 , offset4);
		//  ____________________________________________________________________________________________________________)
		//  ____________________________________________________________________________________________________________)
		  String topic5 = "sampleTopic/#"; // topic for publish frame.
		  int qos5 = 0; // QoS for the frame(0,1 or 2).
		  boolean retain5 = false; // if true the frame will be kept by server and delivered to all new clients subscribing to that topic.
		  String content5 = "New message to the server. "; // contents of a frame.
		  long offset5 = 3000; // this message will be sent '3' second after the web socket connection is established.
		  webSocketContext.addWebSocketPublishFrame(topic5, qos5, retain5, content5, offset5);
		// ____________________________________________________________________________________________________________)
		  long delay6 = 3000; // time in millis to be added as a delay.
		  int index6  = 1; // index of a frame, before which the delay will be added.
		  webSocketContext.addWebSocketDelay(delay6, index6);
		//  ____________________________________________________________________________________________________________)
		
		// ^^^ --- sample code --- ^^^
	}
	
	
	/**
	 * Return plug-in output parameter. 
	 *
	 * output parameter #1: (text) cId / default value = 'kkj' / label "dfischer.proxysniffer.ProxySnifferVar@6a37f729"
	 * output parameter #2: (text) payload / default value = 'This is a collaborative process, so dig in and try to help out! There's tons of details missing, just waiting for you to add them! So send us a pull request, please!' / label "dfischer.proxysniffer.ProxySnifferVar@43db3a"
	 *
	 * Note: all output parameters are always converted to strings.
	 */
	public Object getOutputParameter(int parameterNumber)
	{
		switch (parameterNumber)
		{
			case 0:
				return cId;
			case 1:
				return payload;
			default:
				return null;
		}
	}
	
	
	/**
	 * Finalize plug-in at end of loop.
	 */
	public void deconstruct(Object context)
	{
		// LoadtestPluginContext pluginContext = (LoadtestPluginContext) context;
	}
	
	
	
	// ----------------------------------------------------------------------------
	// PART 3: stand-alone test utility - optional - used for plug-in development
	// ----------------------------------------------------------------------------
	
	/*
	public static void main(String[] args)
	{
		try
		{
			// vvv --- sample code --- vvv
			//
			//newPlugin plugin = new newPlugin();
			//plugin.construct(null);
			//plugin.setInputParameter(0, args[0]);
			//WebSocketData dummyWSData = new WebSocketData();
			//dummyWSData.setConnectionStartMillis(1478246953094L);
			//dummyWSData.setConnectionStopMillis(1478246967656L);
			//String payLoad_0 = "Dummy frame 0";
			//String payLoad_1 = "Dummy frame 1";
			//dummyWSData.addWebSocketFrame(new WebSocketFrame(true  , true  , false , (byte) 1 , 1478246959263L, 1478246959263L , "UTF-8" , payLoad_0 ));
			//dummyWSData.addWebSocketFrame(new WebSocketFrame(true  , true  , false , (byte) 1 , 1478246959263L, 1478246959263L , "UTF-8" , payLoad_1 ));
			//HttpTestWebsocketContext context =  new HttpTestWebsocketContext(dummyWSData, null, null);
			//plugin.execute(context);
			//System.out.println(plugin.getOutputParameter(0));
			//plugin.deconstruct(null);
			//
			// ^^^ --- sample code --- ^^^
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	*/
 
 
}	// end of class
