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
public class WSPluginAmirModifyWSAll implements WebSocketPluginInterface
{
	private String globalVar = "0";		// input parameter #1 - label "dfischer.proxysniffer.ProxySnifferVar@3f641183"
	private long loopCounter = -1;		// input parameter #2 - label "dfischer.proxysniffer.ProxySnifferVar@42b9cff8"
	private long userCounter = -1;		// input parameter #3 - label "dfischer.proxysniffer.ProxySnifferVar@3504c501"


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
		return "WSPluginAmirModifyWSAll plug-in";
	}
	
	
	public String getPluginDescription()
	{
		return "";
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
		String[] labels = new String[3];
		labels[0] = "globalVar";
		labels[1] = "loopCounter";
		labels[2] = "userCounter";
		return labels;
	}
	
	
	public LoadtestPluginFixedUserInputField[] getFixedUserInputFields()
	{
		LoadtestPluginFixedUserInputField[] userInputFields = new LoadtestPluginFixedUserInputField[3];
		userInputFields[0] = null;
		userInputFields[1] = null;
		userInputFields[2] = null;
		return userInputFields;
	}
	
	
	public int allowOptionalInputParameter()
	{
		return -1;		// all input parameters required
	}
	
	
	public String[] getOutputParameterLabels()
	{
		String[] labels = new String[3];
		labels[0] = "globalVar";
		labels[1] = "loopCounter";
		labels[2] = "userCounter";
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

        globalVar = globalVar + 1 ;
       
	}
	
	
	/**
	 * Transfer input parameter before execute() is called.
	 *
	 * input parameter #1: (text) globalVar / default value = '0' / label "dfischer.proxysniffer.ProxySnifferVar@3f641183"
	 * input parameter #2: (loop counter) loopCounter / default value = 'null' / label "dfischer.proxysniffer.ProxySnifferVar@42b9cff8"
	 * input parameter #3: (current user counter) userCounter / default value = 'null' / label "dfischer.proxysniffer.ProxySnifferVar@3504c501"
	 *
	 * Note: all input parameters are always converted from strings.
	 */
	public void setInputParameter(int parameterNumber, Object parameterValue)
	{
		switch (parameterNumber)
		{
			case 0:
				globalVar = (String) parameterValue;
				break;
			case 1:
				loopCounter = Long.valueOf((String) parameterValue).longValue();
				break;
			case 2:
				userCounter = Long.valueOf((String) parameterValue).longValue();
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
        wsFrame.setPayloadString(wsFrame.getPayloadString()+" AmirKhan" + ", globalVar >"+globalVar + ", loopCounter >"+loopCounter +", userCounter >"+userCounter );
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
	 * output parameter #1: (text) globalVar / default value = '0' / label "dfischer.proxysniffer.ProxySnifferVar@3f641183"
	 * output parameter #2: (loop counter) loopCounter / default value = 'null' / label "dfischer.proxysniffer.ProxySnifferVar@42b9cff8"
	 * output parameter #3: (current user counter) userCounter / default value = 'null' / label "dfischer.proxysniffer.ProxySnifferVar@3504c501"
	 *
	 * Note: all output parameters are always converted to strings.
	 */
	public Object getOutputParameter(int parameterNumber)
	{
		switch (parameterNumber)
		{
			case 0:
				return globalVar;
			case 1:
				return "" + loopCounter;		// convert to string
			case 2:
				return "" + userCounter;		// convert to string
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
			//WSPluginAmirModifyWSAll plugin = new WSPluginAmirModifyWSAll();
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
