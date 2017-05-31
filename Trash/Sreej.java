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
public class Sreej implements WebSocketPluginInterface
{


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
		return "Sreej plug-in";
	}
	
	
	public String getPluginDescription()
	{
		return "";
	}
	
	
	public int getAllowedConstructScope()
	{
		return WebSocketPluginInterface.CONSTRUCT_SCOPE_GLOBAL;
	}
	
	
	
	public boolean allowMultipleUsage()
	{
		return true;
	}
	
	
	public String[] getInputParameterLabels()
	{
		String[] labels = new String[0];
		return labels;
	}
	
	
	public LoadtestPluginFixedUserInputField[] getFixedUserInputFields()
	{
		return null;
	}
	
	
	public int allowOptionalInputParameter()
	{
		return -1;		// all input parameters required
	}
	
	
	public String[] getOutputParameterLabels()
	{
		String[] labels = new String[0];
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
	 * Initialize plug-in at start of load test.
	 */
	public void construct(Object context)
	{
		// LoadtestPluginContext pluginContext = (LoadtestPluginContext) context;
	}
	
	
	/**
	 * Transfer input parameter before execute() is called.
	 */
	public void setInputParameter(int parameterNumber, Object parameterValue)
	{
		switch (parameterNumber)
		{
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
		
		//  ____________________________________________________________________________________________________________
		//  int frameType = WebSocketFrame.PLAIN;   // specify type of frame.(WebSocketFrame.PLAIN , WebSocketFrame.MQTT)
		//  long offset = 3000; // this message will be sent '3' second after the web socket connection is established.
		//  String payloadText = "New message to the server.";
		//  webSocketContext.addWebSocketFrame( frameType  , payloadText , offset);
		//  ____________________________________________________________________________________________________________
		//  int frameType = WebSocketFrame.MQTT;   // specify type of frame.(WebSocketFrame.PLAIN , WebSocketFrame.MQTT)
		//  long offset = 3000; // this message will be sent '3' second after the web socket connection is established.
		//  MqttMessage message = new MqttMessage();  // set properties of a MqttMessage
		//  String payloadText = message.writeJsonString();
		//  webSocketContext.addWebSocketFrame( frameType  , payloadText , offset);
		//  ____________________________________________________________________________________________________________
		//  String topic = "sampleTopic/#"; // topic to be subscribed.
		//  int qos = 0; // QoS for that topic(0,1 or 2).
		//  long offset = 3000; // this message will be sent '3' second after the web socket connection is established.
		//  webSocketContext.addWebSocketSubscribeFrame( topic , qos , offset);
		//  ____________________________________________________________________________________________________________
		//  String topic = "sampleTopic/#"; // topic to be Un-subscribed.
		//  long offset = 3000; // this message will be sent '3' second after the web socket connection is established.
		//  webSocketContext.addWebSocketUnSubscribeFrame( topic , offset);
		//  ____________________________________________________________________________________________________________
		//  ____________________________________________________________________________________________________________
		//  String topic = "sampleTopic/#"; // topic for publish frame.
		//  int qos = 0; // QoS for the frame(0,1 or 2).
		//  boolean retain = false; // if true the frame will be kept by server and delivered to all new clients subscribing to that topic.
		//  String content = "New message to the server. "; // contents of a frame.
		//  long offset = 3000; // this message will be sent '3' second after the web socket connection is established.
		//  webSocketContext.addWebSocketPublishFrame(topic, qos, retain, content, offset);
		//  ____________________________________________________________________________________________________________
		//  long delay = 3000; // time in millis to be added as a delay.
		//  int offset = 3000; // offset where delay is to be added..(!integer of for that method)
		//  webSocketContext.addWebSocketDelay(delay, offset);
		//  ____________________________________________________________________________________________________________
		
		// ^^^ --- sample code --- ^^^
	}
	
	
	/**
	 * Return plug-in output parameter. 
	 */
	public Object getOutputParameter(int parameterNumber)
	{
		switch (parameterNumber)
		{
			default:
				return null;
		}
	}
	
	
	/**
	 * Finalize plug-in at end of load test.
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
			//Sreej plugin = new Sreej();
			//plugin.construct(null);
			//plugin.setInputParameter(0, args[0]);
			//WebSocketData dummyWSData = new WebSocketData();
			//dummyWSData.setConnectionStartMillis(1478246953094L);
			//dummyWSData.setConnectionStopMillis(1478246967656L);
			//String payLoad_0 = "Dummy frame 0";
			//String payLoad_1 = "Dummy frame 1";
			//dummyWSData.addWebSocketFrame(new WebSocketFrame(true  , true  , false , (byte) 1 , 1478246959263L, 1478246959263L ,  payLoad_0 , WebSocketFrame.PLAIN ));
			//dummyWSData.addWebSocketFrame(new WebSocketFrame(true  , true  , false , (byte) 1 , 1478246959263L, 1478246959263L ,  payLoad_1 , WebSocketFrame.PLAIN ));
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