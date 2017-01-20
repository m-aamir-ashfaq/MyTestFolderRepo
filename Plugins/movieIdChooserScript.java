// Some parts of this code have been automatically generated - copyright for generic plug-in procedure reserved by Ingenieurbuero David Fischer AG, Switzerland.
// Copyright for manual written code belongs to <your name>, <your company>, <your country>
import dfischer.utils.GenericPluginInterface;
import dfischer.utils.LoadtestPluginInterface;
import dfischer.utils.LoadtestPluginFixedUserInputField;
import dfischer.utils.LogVector;
import dfischer.utils.LoadtestPluginContext;
import dfischer.utils.HttpLoadTest;
import dfischer.utils.PerformanceData;
import dfischer.utils.CookieHandler;
import dfischer.utils.HttpTestURL;
 
/**
 * Load test add-on module.
 */
public class movieIdChooserScript implements LoadtestPluginInterface
{
	private String env = "";		// input parameter #1 - label "mov"
	private String prod_movie_id = "";		// input parameter #2 - label "prod_movie_id"
	private String staging_movie_id = "";		// input parameter #3 - label "staging_movie_id"
	
	private String movieId = "";		// output parameter #1 - label "movieId"
	
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
		return "movieIdChooserScript";
	}
	
	
	public String getPluginDescription()
	{
		return "movieIdChooserScript\n\n";
	}
	
	
	public int getAllowedConstructScope()
	{
		return LoadtestPluginInterface.CONSTRUCT_SCOPE_LOOP;
	}
	
	
	public int getAllowedExecScope()
	{
		return LoadtestPluginInterface.EXEC_SCOPE_LOOP;
	}
	
	
	public int getAllowedExecOrder()
	{
		return LoadtestPluginInterface.EXEC_ORDER_BEFORE;
	}
	
	
	public boolean allowMultipleUsage()
	{
		return false;
	}
	
	
	public String[] getInputParameterLabels()
	{
		String[] labels = new String[3];
		labels[0] = "env";
		labels[1] = "prod_movie_id";
		labels[2] = "staging_movie_id";
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
		String[] labels = new String[1];
		labels[0] = "movieId";
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
	 * input parameter #1: (String) env / default value = '' / label "mov"
	 * input parameter #2: (String) prod_movie_id / default value = '' / label "prod_movie_id"
	 * input parameter #3: (String) staging_movie_id / default value = '' / label "staging_movie_id"
	 *
	 * Note: all input parameters are always converted from strings.
	 */
	public void setInputParameter(int parameterNumber, Object parameterValue)
	{
		switch (parameterNumber)
		{
			case 0:
				env = (String) parameterValue;
				break;
			case 1:
				prod_movie_id = (String) parameterValue;
				break;
			case 2:
				staging_movie_id = (String) parameterValue;
				break;
			default:
				break;
		}
	}
	
	
	/**
	 * Execute plug-in at start of loop (per loop).
	 *
	 * Intrinsic plug-in implementation.
	 */
	public void execute(Object context)
	{
		logVector = new LogVector();
		LoadtestPluginContext pluginContext = (LoadtestPluginContext) context;
		
		// vvv --- sample code --- vvv
		if("staging".equalsIgnoreCase(env))
		{
			movieId = staging_movie_id;
		}
		else if("production".equalsIgnoreCase(env))
		{
			movieId = prod_movie_id;
		}
		
		
		// ^^^ --- sample code --- ^^^
	}
	
	
	/**
	 * Return plug-in output parameter. 
	 *
	 * output parameter #1: (String) movieId / default value = '' / label "movieId"
	 *
	 * Note: all output parameters are always converted to strings.
	 */
	public Object getOutputParameter(int parameterNumber)
	{
		switch (parameterNumber)
		{
			case 0:
				return movieId;
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
			
			movieIdChooserScript plugin = new movieIdChooserScript();
			plugin.construct(null);
			plugin.setInputParameter(0, args[0]);
			plugin.execute(null);
			System.out.println(plugin.getOutputParameter(0));
			plugin.deconstruct(null);
			
			// ^^^ --- sample code --- ^^^
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	*/
 
 
}	// end of class

