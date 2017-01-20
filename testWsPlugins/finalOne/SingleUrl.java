// Some parts of this code have been automatically generated - copyright for generic plug-in procedure reserved by Ingenieurbuero David Fischer AG, Switzerland.
// Copyright for manual written code belongs to <your name>, <your company>, <your country>
import dfischer.utils.GenericPluginInterface;
import dfischer.utils.WebSocketPluginInterface;
import dfischer.utils.LoadtestPluginFixedUserInputField;
import dfischer.utils.LogVector;
import dfischer.utils.LoadtestPluginContext;
import dfischer.utils.HttpLoadTest;
import dfischer.utils.PerformanceData;
import dfischer.utils.CookieHandler;
import dfischer.utils.HttpTestURL;
import dfischer.websocket.*;
 
/**
 * Load test add-on module.
 */
public class SingleUrl implements WebSocketPluginInterface
{
	private String globalCounter = "1";		// input parameter #1 - label "dfischer.proxysniffer.ProxySnifferVar@b66b2f6"
	private long loopCounter = -1;		// input parameter #2 - label "dfischer.proxysniffer.ProxySnifferVar@36f3a53"


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
		return "SingleUrl plug-in";
	}
	
	
	public String getPluginDescription()
	{
		return "fdgxcvn\n\n";
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
		String[] labels = new String[2];
		labels[0] = "globalCounter";
		labels[1] = "loopCounter";
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
		labels[0] = "globalCounter";
		labels[1] = "loopCounter";
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
	 * input parameter #1: (text) globalCounter / default value = '1' / label "dfischer.proxysniffer.ProxySnifferVar@b66b2f6"
	 * input parameter #2: (loop counter) loopCounter / default value = 'null' / label "dfischer.proxysniffer.ProxySnifferVar@36f3a53"
	 *
	 * Note: all input parameters are always converted from strings.
	 */
	public void setInputParameter(int parameterNumber, Object parameterValue)
	{
		switch (parameterNumber)
		{
			case 0:
				globalCounter = (String) parameterValue;
				break;
			case 1:
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
		LoadtestPluginContext pluginContext = (LoadtestPluginContext) context;
		
		// vvv --- sample code --- vvv
		
		logVector.log("ws_plugin_"+getPluginName()+" before "+wsFrame.getPayloadString());
		wsFrame.setPayloadString(wsFrame.getPayloadString() + "David");
		
		
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
		LoadtestPluginContext pluginContext = (LoadtestPluginContext) context;
		
		// vvv --- sample code --- vvv
		
		logVector.log("ws_plugin_"+getPluginName()+" after "+wsFrame.getPayloadString());;
		
		
		// ^^^ --- sample code --- ^^^
	}
	
	
	/**
	 * Execute is not working here....will remove or?.
	 *
	 */
	public void execute(Object context)
	{
	}
	
	
	/**
	 * Return plug-in output parameter. 
	 *
	 * output parameter #1: (text) globalCounter / default value = '1' / label "dfischer.proxysniffer.ProxySnifferVar@b66b2f6"
	 * output parameter #2: (loop counter) loopCounter / default value = 'null' / label "dfischer.proxysniffer.ProxySnifferVar@36f3a53"
	 *
	 * Note: all output parameters are always converted to strings.
	 */
	public Object getOutputParameter(int parameterNumber)
	{
		switch (parameterNumber)
		{
			case 0:
				return globalCounter;
			case 1:
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
			//SingleUrl plugin = new SingleUrl();
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
