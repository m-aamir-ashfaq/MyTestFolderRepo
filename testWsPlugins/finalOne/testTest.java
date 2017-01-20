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
import dfischer.utils.WebSocketUtilities;
import dfischer.websocket.*;
 
/**
 * Load test add-on module.
 */
public class testTest implements WebSocketPluginInterface
{
	private long loopCounter = -1;		// input parameter #1 - label "dfischer.proxysniffer.ProxySnifferVar@5dd87243"


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
		return "testTest plug-in";
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
		String[] labels = new String[1];
		labels[0] = "loopCounter";
		return labels;
	}
	
	
	public LoadtestPluginFixedUserInputField[] getFixedUserInputFields()
	{
		LoadtestPluginFixedUserInputField[] userInputFields = new LoadtestPluginFixedUserInputField[1];
		userInputFields[0] = null;
		return userInputFields;
	}
	
	
	public int allowOptionalInputParameter()
	{
		return -1;		// all input parameters required
	}
	
	
	public String[] getOutputParameterLabels()
	{
		String[] labels = new String[1];
		labels[0] = "loopCounter";
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
	 *
	 * input parameter #1: (loop counter) loopCounter / default value = 'null' / label "dfischer.proxysniffer.ProxySnifferVar@5dd87243"
	 *
	 * Note: all input parameters are always converted from strings.
	 */
	public void setInputParameter(int parameterNumber, Object parameterValue)
	{
		switch (parameterNumber)
		{
			case 0:
				loopCounter = Long.valueOf((String) parameterValue).longValue();
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
		
		logVector.log("ws_plugin_"+getPluginName()+" after "+wsFrame.getPayloadString());
		
		
		// ^^^ --- sample code --- ^^^
	}
	
	
	/**
	 * Execute is not working here....will remove or?.
	 *
	 */
	public void execute(Object context)
	{
		
		logVector = new LogVector();
try{

	    HttpTestWebsocketContext webSocketContext = (HttpTestWebsocketContext) context;
	  
		LoadtestPluginContext pluginContext = (LoadtestPluginContext) webSocketContext.getPluginContext();
		
		// vvv --- sample code --- vvv
		
		  boolean compress = false;    // specify if compression is needed.
		  int addOffsetMillis = 16000; // this message will be sent '3' second after the web socket connection is established.
		  String payloadString = "New message to the server.";
		  String encoding = "UTF-8";
		  WebSocketUtilities.addFrame(webSocketContext, addOffsetMillis , payloadString , compress, encoding);
}
catch (Exception e)
{
	logVector.log("exp =="+ e);
}
		
		
		
		
		
		// ^^^ --- sample code --- ^^^
	}
	
	
	/**
	 * Return plug-in output parameter. 
	 *
	 * output parameter #1: (loop counter) loopCounter / default value = 'null' / label "dfischer.proxysniffer.ProxySnifferVar@5dd87243"
	 *
	 * Note: all output parameters are always converted to strings.
	 */
	public Object getOutputParameter(int parameterNumber)
	{
		switch (parameterNumber)
		{
			case 0:
				return "" + loopCounter;		// convert to string
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
			//testTest plugin = new testTest();
			//plugin.construct(null);
			//plugin.setInputParameter(0, args[0]);
			//plugin.execute(null);
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
