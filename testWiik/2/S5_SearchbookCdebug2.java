
// *********************************************************************************************
//
// Automatically Generated Load Test Program
// -----------------------------------------
//
// Source: S5_SearchbookCdebug2.java
// Date  : 11 May 2016 14:04:20 ECT
// Author: Apica ZebraTester V5.4-K / automatically generated
//
// Procedure Copyright by Ingenieurbuero David Fischer AG  |  A Company of the Apica Group
// All Rights Reserved
//
// http://www.apicasystem.com                                         http://www.zebratester.com
// *********************************************************************************************


import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import dfischer.utils.AbstractInputFileReader;
import dfischer.utils.Base64Decoder;
import dfischer.utils.Base64Encoder;
import dfischer.utils.ConvertToDoubleNumber;
import dfischer.utils.ContentTokenExtractor;
import dfischer.utils.ContentTokenExtractorItem;
import dfischer.utils.Cookie;
import dfischer.utils.CookieHandler;
import dfischer.utils.DigestAuthContext;
import dfischer.utils.DNSCache;
import dfischer.utils.DNSTranslationTable;
import dfischer.utils.DynamicProtobufContentParser;
import dfischer.utils.ExternalParamFile;
import dfischer.utils.FileCache;
import dfischer.utils.GenericPluginInterface;
import dfischer.utils.GetRealTimeUserInputFieldsInterface;
import dfischer.utils.HtmlContentParser;
import dfischer.utils.HtmlHeaderCookieExtractor;
import dfischer.utils.HttpLoadTest;
import dfischer.utils.HttpLoadTestIncrementUserThread;
import dfischer.utils.HttpLoadTestUserContext;
import dfischer.utils.HttpSocketPool;
import dfischer.utils.HttpTestURL;
import dfischer.utils.HttpTestURLDNSContext;
import dfischer.utils.HttpTestURLThreadHandler;
import dfischer.utils.InlineScriptExecutionException;
import dfischer.utils.InlineScriptExecutor;
import dfischer.utils.InnerLoopContext;
import dfischer.utils.Lib;
import dfischer.utils.LoadtestInlineScriptContext;
import dfischer.utils.LoadtestInlineScriptVar;
import dfischer.utils.LoadtestPluginContext;
import dfischer.utils.NextProxyConfig;
import dfischer.utils.ParseArgs;
import dfischer.utils.ParseUrl;
import dfischer.utils.PerformanceData;
import dfischer.utils.PerformanceDataTickExtension;
import dfischer.utils.ProtobufFieldAndValueElement;
import dfischer.utils.ProtobufLib;
import dfischer.utils.RealTimeUserInputField;
import dfischer.utils.ScreenshotImage;
import dfischer.utils.SetThreadStepInterface;
import dfischer.utils.SSLInit;
import dfischer.utils.SSLSessionCacheStatistic;
import dfischer.utils.SSLSessionCacheStatisticInterface;
import dfischer.utils.SuspendResumeInterface;
import dfischer.utils.TextLineTokenExtractor;
import dfischer.utils.TextLineTokenExtractorItem;
import dfischer.utils.ThreadStepInterface;
import dfischer.utils.UserInputField;
import dfischer.utils.UserTransactionContext;
import dfischer.utils.UserTransactionRuntimeHandler;
import dfischer.utils.VarInputFileReader;
import dfischer.utils.VarRandomInputFileReader;
import dfischer.utils.VaryingLoadInterface;
import dfischer.utils.VaryingTestDurationInterface;
import dfischer.utils.XmlContentParser;
import dfischer.utils.XmlDoctypeCommentParser;
import dfischer.utils.ZoneTime;
import dfischer.proxysniffer.ProxySnifferVarSourceInlineScript;


/**
 * Automatically generated load test program.
 */
public class S5_SearchbookCdebug2 extends HttpLoadTest implements Runnable, ThreadStepInterface, SetThreadStepInterface, SSLSessionCacheStatisticInterface, VaryingLoadInterface, VaryingTestDurationInterface, SuspendResumeInterface, GetRealTimeUserInputFieldsInterface
{
	public static final String prxVersion = "V5.4-K";
	public static final int    prxCharEncoding = 2;                         // 1 = OS Default, 2 = ISO-8859-1, 3 = UTF-8
	public static final String testDescription = "";

	public static String USER_AGENT_1 = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:40.0) Gecko/20100101 Firefox/40.0";

	private static final boolean CONTAINS_PARALLEL_EXECUTED_URLS = true;
	private static final int MAX_PARALLEL_THREADS_PER_USER = 6;                       // default value for max. parallel executed URLs per user
	private static int maxParallelThreadsPerUser = MAX_PARALLEL_THREADS_PER_USER;     // configured value for max. parallel executed URLs per user

	private static final boolean CONTAINS_EXTERNAL_RESOURCES = false;       // note: external resources are typically additional Java library files (*.jar files) invoked by self-developed plug-ins. Consider that Input Files and the Main Class of Plug-Ins are NOT external resources in this context because ZebraTester knows already their declarations.

	private static int plannedStartupDelay = 200;                           // startup delay between concurrent users in milliseconds, see main argument "-sdelay"
	private static int plannedTestDuration = -1;                            // planned load test duration in seconds, 0 = unlimited, see main argument "-d"
	private static int maxPlannedLoops = 0;  								// maximum planned loops per user, 0 = unlimited, see main argument "-maxloops"
	private static int plannedRequestTimeout = 0;                           // planned request timeout in seconds, see main argument "-t"
	
	private static String defaultTimeZone = "ECT";                          // use main argument -tz <timezone> to alter
	private static char defaultNumberGroupingSeparator = '\'';              // use main argument -dgs a|c to alter
	private static String sslProtocolVersion = "all";                       // applied ssl protocol version: "all" = v3/tls/tls11/tls12, use main argument -ssl to set a fixed protocol version
	private static boolean sslcmode = false;                                // support of deficient ssl servers, use main argument -sslcmode to enable
	private static boolean sslECC = false;                                  // elliptic curve cryptography (ECC) is disabled by default, use main argument -ecc to enable
	private static boolean sslSNI = true;                                   // server name indication (SNI) is enabled by default, use main argument -nosni to disable
	private static boolean sslSNICirical = false;                           // the SNI TLS extension is by default set as non-critical, use main argument -snicritical to set as critical
	private static final long loopErrorDelay = 20;                          // error delay (in milliseconds) applied if a loop of a virtual user has failed
	private static final String THREAD_NAME = "T000000";                    // internal
	private static Integer dumpLock = new Integer(0);                       // internal
	private static Integer inputFileLock = new Integer(0);                  // internal
	private volatile int threadStep = ThreadStepInterface.THREAD_NO_STEP;   // internal
	private boolean urlCallPassed = false;                                  // internal
	private String localIpAddress = null;                                   // internal
	private static long downlinkBandwidth = 0;                              // max. downlink bandwidth per user. 0 = unlimited. use main argument -downlink <kbps> to alter
	private static long uplinkBandwidth = 0;                                // max. uplink bandwidth per user. 0 = unlimited. use main argument -uplink <kbps> to alter
	private static boolean dnsPerLoop = false;								// true if main argument "-dnsperloop" is set = perform new DNS resolves for each executed loop. normally false
	private HttpTestURLDNSContext userDNSContext = null;                    // user specific DNS context - normally null when no special DNS servers are used
	
	private static volatile boolean debugFailedLoops = false;               // true if main argument "-dfl" is set
	private static volatile boolean debugLoops = false;                     // true if main argument "-dl" is set
	private static volatile boolean debugHttp = false;                      // true if main argument "-dh" is set
	private static volatile boolean debugContent = false;                   // true if main argument "-dc" is set
	private static volatile boolean debugCookies = false;                   // true if main argument "-dC" is set
	private static volatile boolean debugKeepAlive = false;                 // true if main argument "-dK" is set
	private static volatile boolean debugSsl = false;                       // true if main argument "-dssl" is set
	
	private static String resultFile = null;                                // name of binary test result file or null
	
	private final static String httpProtocolVersion = "1.1";      // applied HTTP protocol version V1.1
	
	private static ExternalParamFile externalParamFile = null;                              // used only for very large parameter values (commonly unused)
	private static final String EXTERNAL_PARAM_FILE = "S5_SearchbookCdebug2ExtParams.dat";  // input file name for very large parameter values
	private static FileCache requestFileCache = new FileCache();  // file cache for large XML, SOAP and ASCII requests
	
	private int requestTimeout = -1;                              // thread input data from constructor, timeout per url request in seconds
	private int remainingLoops = -1;                              // thread input data from constructor, number of loops per thread (optional)
	private boolean checkLoopCount = false;                       // thread input data from constructor, number of loops per thread (optional)
	private int threadNumber = -1;                                // thread input data from constructor, internal thread number
	private int threadLoopCounter = 0;                            // internal loop counter per thread
	private volatile int userResumeStartWaitDelay = 0;            // internal, user specific delay when the load test execution is resumed
	private volatile boolean decrementEndOfLoopFlag = false;	  // internal flag to decrement the simulated user at runtime
	private volatile boolean incrementUserFlag = false;           // internal flag to increment the simulated user at runtime
	private volatile long incrementUserStartTime = -1;            // internal start time when increment the simulated user at runtime
	private static AtomicInteger totalLoopCounter = new AtomicInteger(0);    // internal overall loop counter

	private LoadtestPluginContext userPluginContext = null;       // plug-in context per user
	private LoadtestInlineScriptContext inlineScriptContext = null;          // re-used, scratch, the returned context of an inline script that runs at item or URL exec scope

	private Object sslSessionCache = null;                        // internal ssl session cache per thread
	private SSLSessionCacheStatistic sslStatistic = null;         // internal ssl session cache statistic per thread
	private static int sslSessionCacheTimeout = 300;              // timeout of ssl session cache in seconds, 0 = session cache disabled
	private static int sslHandshakeRandomGeneratorType = -1;      // invalid initial value, use the default secure random generator for SSL handshakes
	private HttpSocketPool socketPool = null;                     // re-used, scratch, internal socket pool per thread and loop
	private CookieHandler cookieHandler = null;                   // re-used, scratch, internal cookie handler per thread and loop

	private HttpTestURL testURL = null;                           // re-used, scratch, http request and response
	private HttpTestURLThreadHandler pageThreadHandler = null;    // re-used, scratch, support for parallel processing of http request within a page
	private int httpStatus = -1;                                  // re-used, scratch, http response status code from webserver
	private HtmlContentParser htmlContentParser = null;           // re-used, scratch, used to extract vars from http response
	private XmlContentParser xmlContentParser = null;             // re-used, scratch, used to extract vars from http response
	private DynamicProtobufContentParser protobufContentParser = null;  // re-used, scratch, used to extract vars from http response
	private TextLineTokenExtractor textLineTokenExtractor = null; // re-used, scratch, used to extract vars from http response
	private ContentTokenExtractor contentTokenExtractor = null;   // re-used, scratch, used to extract vars from http response
	
	private static VarRandomInputFileReader movielinks_txt = null;         // input file movielinks.txt, file scope: new line per loop

	private volatile UserTransactionRuntimeHandler transactionHandler = new UserTransactionRuntimeHandler();		// re-used, support to manage user-defined transactions

	private String movielink = null;                     // var declaration from web admin var handler: scope = per loop
	private String filmID = null;                        // var declaration from web admin var handler: scope = per loop
	private String MainPoster = null;                    // var declaration from web admin var handler: scope = per loop
	

	/**
	 * constructor: called from load test plug-ins (scope = global).
	 */
	public S5_SearchbookCdebug2()
	{
		super();
	}


	/**
	 * constructor: called when a user is created (per user).
	 */
	public S5_SearchbookCdebug2(int maxLoops, int requestTimeout, int threadNumber)
	{
		super();
		this.requestTimeout = requestTimeout;
		this.remainingLoops = maxLoops;
		this.checkLoopCount = (maxLoops > 0);
		this.threadNumber = threadNumber;
		this.sslSessionCache = SSLInit.getNewSslSessionCache(sslSessionCacheTimeout);
		this.sslStatistic = new SSLSessionCacheStatistic();
		if (isMultihomed() && (!ipPerLoop()))
			this.localIpAddress = getNextMultihomedIpAddress();
		if (dnsCache != null)
			userDNSContext = new HttpTestURLDNSContext(dnsCache, threadNumber);
		
		// initialize context for plug-ins which are executed per user
		userPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, this, threadNumber);
	}


	/**
	 * internal method: called when a user starts a loop.
	 * contains the recorded session which is called by users x loops.
	 * 
	 * @param totalLoopCounter total number of loops (0..n-1) counted overall threads. This value is unique per loop.
	 * 
	 * @return  true:  loop successful completed.
	 *          false: loop failed.
	 */
	private boolean execute(int totalLoopCounter) throws Exception
	{
		markStartOfLoop();
		threadStep = 0;                 // internal - start loop at thread step 0
		
		// enable DNS resolves per loop?
		if (dnsPerLoop)
			userDNSContext = new HttpTestURLDNSContext(dnsCache.clone(false), threadNumber);
		
		// debug http headers?
		Object httpLogVectorObject = null;
		if (debugHttp)
			httpLogVectorObject = this;
		
		// create socket pool per loop
		sslSessionCache = SSLInit.getNewSslSessionCache(sslSessionCacheTimeout);		// reset the SSL session cache to get new SSL session IDs for this loop
		socketPool = new HttpSocketPool(this, sslProtocolVersion, sslSessionCache, sslStatistic, sslcmode);
		if (sslHandshakeRandomGeneratorType != -1)
			socketPool.setSslHandshakeRandomGeneratorType(sslHandshakeRandomGeneratorType);
		socketPool.setSupportEllipticCurves(sslECC);
		socketPool.setHintUseSNI(sslSNI);
		socketPool.setSniCritical(sslSNICirical);
		if (debugKeepAlive)
		{
			socketPool.setlogVectorObject(this);
			if (debugSsl)
				socketPool.enableSslLog();
		}
		
		if (downlinkBandwidth > 0)
			socketPool.setDownlinkBandwidth(downlinkBandwidth);
		if (uplinkBandwidth > 0)
			socketPool.setUplinkBandwidth(uplinkBandwidth);
		
		if (isMultihomed())
		{
			if (ipPerLoop())
				localIpAddress = getNextMultihomedIpAddress();
			socketPool.setClientIpAddress(localIpAddress);
			log();
			log("multihomed client ip address = " + localIpAddress);
		}
		
		// setup cookie handler per loop
		cookieHandler = new CookieHandler();
		if (debugCookies)
			cookieHandler.setLogVectorInterface(this);
		
		// customised vars from web admin var handler: scope = per loop
		htmlContentParser = null;
		xmlContentParser = null;
		protobufContentParser = null;
		movielink = null;
		filmID = null;
		MainPoster = null;
		log();
		log("<<< movielink = " + movielink);
		log("<<< filmID = " + filmID);
		log("<<< MainPoster = " + MainPoster);
		
		// read next line from input file: scope = loop
		try
		{
			synchronized (inputFileLock)
			{
				if (!movielinks_txt.getNextLine())
				{
					abortByEofInputFile();
					return true;		// eof of input file - no error from web server
				}
				movielink = new String(movielinks_txt.getLineVar(1));
			}
			log();
			log("<<< movielink = " + movielink);
		}
		catch (IOException ie)
		{
			abortByEofInputFile();
			return true;				// eof of input file - no error from web server
		}
		
		// initialize context for plug-ins which are executed per loop
		LoadtestPluginContext loopPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, this, threadNumber, socketPool, cookieHandler);
		



		// --- VIRTUAL PAGE #0 ---
		if (!executePage_0(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;



		// --- PAGE BREAK: Test [0] ---
		log();
		log();
		log("# Page #1: Start Page");
		log("# -------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #1: Start Page", 0, 0, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_1_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_1_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_1_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 1 failed
		
		// page 1 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [68] ---
		log();
		log();
		log("# Page #2: click search");
		log("# ---------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #2: click search", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 2 failed
			synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 2 failed
		
		// page 2 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [70] ---
		log();
		log();
		log("# Page #3: Type film jungle book");
		log("# ------------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #3: Type film jungle book", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 3 failed
			synchResponsesParallelRequestsPage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 3 failed
		
		// page 3 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [72] ---
		log();
		log();
		log("# Page #4: click result");
		log("# ---------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #4: click result", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 4 failed
			synchResponsesParallelRequestsPage_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 4 failed
		
		// page 4 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [84] ---
		log();
		log();
		log("# Page #5: select cinema");
		log("# ----------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #5: select cinema", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_5(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 5 failed
			synchResponsesParallelRequestsPage_5(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_5(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 5 failed
		
		// page 5 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [92] ---
		log();
		log();
		log("# Page #6: click book");
		log("# -------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #6: click book", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_6(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 6 failed
			synchResponsesParallelRequestsPage_6(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_6(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 6 failed
		
		// page 6 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [95] ---
		log();
		log();
		log("# Page #7: select any time");
		log("# ------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #7: select any time", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_7(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 7 failed
			synchResponsesParallelRequestsPage_7(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_7(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 7 failed
		
		// page 7 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);
		
		
		// loop successful done
		// --------------------
		
		markEndOfPage(performanceData);
		
		endOfExecuteLoop(true, null, -1, loopPluginContext);
		log();
		return true;
	}		// end of execute()
		
		
		
	/**
	 * internal method: called when a user has completed a loop.
	 */
	private void endOfExecuteLoop(boolean loopPassed, HttpTestURL testURL, int threadStep, LoadtestPluginContext loopPluginContext) throws Exception
	{
		// log URL if last call has failed
		if ((!loopPassed) && (testURL != null))
			log(testURL);
		
		// update plugin context
		loopPluginContext.setLoopPassed(loopPassed);
		if ((testURL != null) && (loopPluginContext.getHttpTestURL() == null))
			loopPluginContext.setHttpTestURL(testURL);
		if ((threadStep != -1) && (loopPluginContext.getThreadStep() == -1))
			loopPluginContext.setThreadStep(threadStep);
	}


	/**
	 * Recorded http requests of page #0.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_0(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{

		// all http requests of page #0 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// # Page #1: Start Page
		// # -------------------



		// --- HTTP REQUEST: Test [1] <- WEB ADMIN Index 1 ---
		log();
		log("# title: Vue | Home");
		String requestProt0001 = "https";
		String requestHost0001 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0001 = 443;
		String requestFile0001 = "/";
		String requestHeader0001 = "GET " + requestFile0001 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0001, requestHost0001, requestPort0001, requestHeader0001, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0001 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 12722
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [1] <- Index 1
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [2] <- WEB ADMIN Index 2 ---
		String requestProt0002 = "https";
		String requestHost0002 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0002 = 443;
		String requestFile0002 = "/assets/components/hammerjs/hammer.js";
		String requestHeader0002 = "GET " + requestFile0002 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0002, requestHost0002, requestPort0002, requestHeader0002, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0002 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [3] <- WEB ADMIN Index 3 ---
		String requestProt0003 = "https";
		String requestHost0003 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0003 = 443;
		String requestFile0003 = "/assets/components/skrollr/src/skrollr.js";
		String requestHeader0003 = "GET " + requestFile0003 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0003, requestHost0003, requestPort0003, requestHeader0003, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0003 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [4] <- WEB ADMIN Index 4 ---
		String requestProt0004 = "https";
		String requestHost0004 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0004 = 443;
		String requestFile0004 = "/assets/components/jquery/dist/jquery.min.js";
		String requestHeader0004 = "GET " + requestFile0004 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0004, requestHost0004, requestPort0004, requestHeader0004, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0004 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [5] <- WEB ADMIN Index 5 ---
		String requestProt0005 = "https";
		String requestHost0005 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0005 = 443;
		String requestFile0005 = "/assets/js/head.min.js";
		String requestHeader0005 = "GET " + requestFile0005 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0005, requestHost0005, requestPort0005, requestHeader0005, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0005 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [6] <- WEB ADMIN Index 6 ---
		String requestProt0006 = "https";
		String requestHost0006 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0006 = 443;
		String requestFile0006 = "/assets/js/app.min.js";
		String requestHeader0006 = "GET " + requestFile0006 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0006, requestHost0006, requestPort0006, requestHeader0006, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0006 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [7] <- WEB ADMIN Index 7 ---
		String requestProt0007 = "https";
		String requestHost0007 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0007 = 443;
		String requestFile0007 = "/assets/icons/icons.data.svg.css";
		String requestHeader0007 = "GET " + requestFile0007 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0007, requestHost0007, requestPort0007, requestHeader0007, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0007 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [8] <- WEB ADMIN Index 8 ---
		String requestProt0008 = "https";
		String requestHost0008 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0008 = 443;
		String requestFile0008 = "/assets/images/favicons/favicon-196x196.png";
		String requestHeader0008 = "GET " + requestFile0008 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0008, requestHost0008, requestPort0008, requestHeader0008, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0008 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [9] <- WEB ADMIN Index 9 ---
		String requestProt0009 = "https";
		String requestHost0009 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0009 = 443;
		String requestFile0009 = "/assets/images/favicons/favicon-96x96.png";
		String requestHeader0009 = "GET " + requestFile0009 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0009, requestHost0009, requestPort0009, requestHeader0009, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0009 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [10] <- WEB ADMIN Index 10 ---
		String requestProt0010 = "https";
		String requestHost0010 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0010 = 443;
		String requestFile0010 = "/assets/images/favicons/favicon-32x32.png";
		String requestHeader0010 = "GET " + requestFile0010 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0010, requestHost0010, requestPort0010, requestHeader0010, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0010 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [11] <- WEB ADMIN Index 11 ---
		String requestProt0011 = "https";
		String requestHost0011 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0011 = 443;
		String requestFile0011 = "/assets/images/favicons/favicon-16x16.png";
		String requestHeader0011 = "GET " + requestFile0011 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0011, requestHost0011, requestPort0011, requestHeader0011, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0011 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [12] <- WEB ADMIN Index 12 ---
		String requestProt0012 = "https";
		String requestHost0012 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0012 = 443;
		String requestFile0012 = "/assets/images/favicons/favicon-128.png";
		String requestHeader0012 = "GET " + requestFile0012 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0012, requestHost0012, requestPort0012, requestHeader0012, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0012 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [13] <- WEB ADMIN Index 13 ---
		String requestProt0013 = "https";
		String requestHost0013 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0013 = 443;
		String requestFile0013 = "/assets/components/sightglass/index.js";
		String requestHeader0013 = "GET " + requestFile0013 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0013, requestHost0013, requestPort0013, requestHeader0013, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0013 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [14] <- WEB ADMIN Index 14 ---
		String requestProt0014 = "https";
		String requestHost0014 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0014 = 443;
		String requestFile0014 = "/assets/components/rivets/dist/rivets.js";
		String requestHeader0014 = "GET " + requestFile0014 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0014, requestHost0014, requestPort0014, requestHeader0014, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0014 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [15] <- WEB ADMIN Index 15 ---
		String requestProt0015 = "https";
		String requestHost0015 = "assets.adobedtm.com";
		int    requestPort0015 = 443;
		String requestFile0015 = "/0a66c9a2287360f498d65eefa343f5e222907746/satelliteLib-fd84fd0b477b84df92784f0f15cffc344ca57186.js";
		String requestHeader0015 = "GET " + requestFile0015 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: assets.adobedtm.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0015, requestHost0015, requestPort0015, requestHeader0015, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0015 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [16] <- WEB ADMIN Index 16 ---
		String requestProt0016 = "https";
		String requestHost0016 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0016 = 443;
		String requestFile0016 = "/assets/css/booking.min.css";
		String requestHeader0016 = "GET " + requestFile0016 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0016, requestHost0016, requestPort0016, requestHeader0016, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0016 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [17] <- WEB ADMIN Index 17 ---
		String requestProt0017 = "https";
		String requestHost0017 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0017 = 443;
		String requestFile0017 = "/layouts/system/VisitorIdentification.js";
		String requestHeader0017 = "GET " + requestFile0017 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0017, requestHost0017, requestPort0017, requestHeader0017, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0017 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [18] <- WEB ADMIN Index 18 ---
		String requestProt0018 = "https";
		String requestHost0018 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0018 = 443;
		String requestFile0018 = "/assets/css/site.min.css";
		String requestHeader0018 = "GET " + requestFile0018 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0018, requestHost0018, requestPort0018, requestHeader0018, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0018 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [19] <- WEB ADMIN Index 19 ---
		String requestProt0019 = "https";
		String requestHost0019 = "assets.adobedtm.com";
		int    requestPort0019 = 443;
		String requestFile0019 = "/0a66c9a2287360f498d65eefa343f5e222907746/s-code-contents-c9214291bf3d9ab01a60d721f6cc3e5f1438c78f.js";
		String requestHeader0019 = "GET " + requestFile0019 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: assets.adobedtm.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0019, requestHost0019, requestPort0019, requestHeader0019, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0019 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [20] <- WEB ADMIN Index 20 ---
		String requestProt0020 = "https";
		String requestHost0020 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0020 = 443;
		String requestFile0020 = "/-/media/images/film%20and%20events/may%202016/angrybirdsherom.jpg";
		String requestHeader0020 = "GET " + requestFile0020 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0020, requestHost0020, requestPort0020, requestHeader0020, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0020 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;


		// all http requests of page #1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1_1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #1 (fragment 2 of 4)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [21] <- WEB ADMIN Index 21 ---
		String requestProt0021 = "https";
		String requestHost0021 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0021 = 443;
		String requestFile0021 = "/-/media/images/film%20and%20events/may%202016/captainamericacivilwarherod.jpg";
		String requestHeader0021 = "GET " + requestFile0021 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0021, requestHost0021, requestPort0021, requestHeader0021, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0021 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [22] <- WEB ADMIN Index 22 ---
		String requestProt0022 = "https";
		String requestHost0022 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0022 = 443;
		String requestFile0022 = "/-/media/images/film%20and%20events/may%202016/huntsmanwinterswarherod.jpg";
		String requestHeader0022 = "GET " + requestFile0022 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0022, requestHost0022, requestPort0022, requestHeader0022, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0022 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [23] <- WEB ADMIN Index 23 ---
		String requestProt0023 = "https";
		String requestHost0023 = "delivery.d.switchadhub.com";
		int    requestPort0023 = 443;
		String requestFile0023 = "/adserver/sat.js";
		String requestHeader0023 = "GET " + requestFile0023 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: delivery.d.switchadhub.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0023, requestHost0023, requestPort0023, requestHeader0023, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0023 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [24] <- WEB ADMIN Index 24 ---
		String requestProt0024 = "https";
		String requestHost0024 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0024 = 443;
		String requestFile0024 = "/-/media/images/film%20and%20events/may%202016/badneighbours2herod.jpg";
		String requestHeader0024 = "GET " + requestFile0024 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0024, requestHost0024, requestPort0024, requestHeader0024, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0024 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [25] <- WEB ADMIN Index 25 ---
		String requestProt0025 = "https";
		String requestHost0025 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0025 = 443;
		String requestFile0025 = "/-/media/images/film%20and%20events/may%202016/greenroomherod.jpg";
		String requestHeader0025 = "GET " + requestFile0025 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0025, requestHost0025, requestPort0025, requestHeader0025, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0025 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [26] <- WEB ADMIN Index 26 ---
		String requestProt0026 = "https";
		String requestHost0026 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0026 = 443;
		String requestFile0026 = "/-/media/images/film%20and%20events/may%202016/alicelookingglassherod.jpg";
		String requestHeader0026 = "GET " + requestFile0026 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0026, requestHost0026, requestPort0026, requestHeader0026, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0026 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [27] <- WEB ADMIN Index 27 ---
		String requestProt0027 = "https";
		String requestHost0027 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0027 = 443;
		String requestFile0027 = "/assets/fonts/robotocondensed-regular-webfont.woff2";
		String requestHeader0027 = "GET " + requestFile0027 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0027, requestHost0027, requestPort0027, requestHeader0027, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0027 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [28] <- WEB ADMIN Index 28 ---
		String requestProt0028 = "https";
		String requestHost0028 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0028 = 443;
		String requestFile0028 = "/-/media/images/film%20and%20events/may%202016/huntsmanwinterswarherom.jpg";
		String requestHeader0028 = "GET " + requestFile0028 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0028, requestHost0028, requestPort0028, requestHeader0028, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0028 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [29] <- WEB ADMIN Index 29 ---
		String requestProt0029 = "https";
		String requestHost0029 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0029 = 443;
		String requestFile0029 = "/-/media/images/film%20and%20events/may%202016/ahologramforthekingherod.jpg";
		String requestHeader0029 = "GET " + requestFile0029 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0029, requestHost0029, requestPort0029, requestHeader0029, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0029 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [30] <- WEB ADMIN Index 30 ---
		String requestProt0030 = "https";
		String requestHost0030 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0030 = 443;
		String requestFile0030 = "/-/media/images/film%20and%20events/may%202016/ourkindoftraitorherod.jpg";
		String requestHeader0030 = "GET " + requestFile0030 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0030, requestHost0030, requestPort0030, requestHeader0030, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0030 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [31] <- WEB ADMIN Index 31 ---
		String requestProt0031 = "https";
		String requestHost0031 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0031 = 443;
		String requestFile0031 = "/-/media/images/film%20and%20events/may%202016/ourkindoftraitorherom.jpg";
		String requestHeader0031 = "GET " + requestFile0031 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0031, requestHost0031, requestPort0031, requestHeader0031, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0031 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [32] <- WEB ADMIN Index 32 ---
		String requestProt0032 = "https";
		String requestHost0032 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0032 = 443;
		String requestFile0032 = "/-/media/images/film%20and%20events/may%202016/badneighbours2herom.jpg";
		String requestHeader0032 = "GET " + requestFile0032 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0032, requestHost0032, requestPort0032, requestHeader0032, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0032 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [33] <- WEB ADMIN Index 33 ---
		String requestProt0033 = "https";
		String requestHost0033 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0033 = 443;
		String requestFile0033 = "/assets/fonts/isonorm-regular-webfont.woff2";
		String requestHeader0033 = "GET " + requestFile0033 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0033, requestHost0033, requestPort0033, requestHeader0033, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0033 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [34] <- WEB ADMIN Index 34 ---
		String requestProt0034 = "https";
		String requestHost0034 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0034 = 443;
		String requestFile0034 = "/-/media/images/vue/settings/certificates/12a.png";
		String requestHeader0034 = "GET " + requestFile0034 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0034, requestHost0034, requestPort0034, requestHeader0034, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0034 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [35] <- WEB ADMIN Index 35 ---
		String requestProt0035 = "https";
		String requestHost0035 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0035 = 443;
		String requestFile0035 = "/-/media/images/vue/ent%20carousel/krampus.jpg" +
				"?h=315" +
				"&hash=1782DE000763F07018034E74EAD614F4EFC7525A";
		String requestHeader0035 = "GET " + requestFile0035 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0035, requestHost0035, requestPort0035, requestHeader0035, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0035 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [36] <- WEB ADMIN Index 36 ---
		String requestProt0036 = "https";
		String requestHost0036 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0036 = 443;
		String requestFile0036 = "/-/media/images/vue/film%20posters/mobile/hero_avengers_mobile.png" +
				"?h=315" +
				"&hash=3FD4AB623E0CF6CD3439EA56566630D607B1F50C";
		String requestHeader0036 = "GET " + requestFile0036 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0036, requestHost0036, requestPort0036, requestHeader0036, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0036 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [37] <- WEB ADMIN Index 37 ---
		String requestProt0037 = "https";
		String requestHost0037 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0037 = 443;
		String requestFile0037 = "/-/media/images/vue/settings/certificates/15.png";
		String requestHeader0037 = "GET " + requestFile0037 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0037, requestHost0037, requestPort0037, requestHeader0037, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0037 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [38] <- WEB ADMIN Index 38 ---
		String requestProt0038 = "https";
		String requestHost0038 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0038 = 443;
		String requestFile0038 = "/-/media/images/film%20and%20events/may%202016/alicelookingglassherom.jpg";
		String requestHeader0038 = "GET " + requestFile0038 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0038, requestHost0038, requestPort0038, requestHeader0038, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0038 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [39] <- WEB ADMIN Index 39 ---
		String requestProt0039 = "https";
		String requestHost0039 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0039 = 443;
		String requestFile0039 = "/-/media/images/vue/settings/certificates/18.png";
		String requestHeader0039 = "GET " + requestFile0039 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0039, requestHost0039, requestPort0039, requestHeader0039, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0039 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [40] <- WEB ADMIN Index 40 ---
		String requestProt0040 = "https";
		String requestHost0040 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0040 = 443;
		String requestFile0040 = "/-/media/images/vue/settings/certificates/u.png";
		String requestHeader0040 = "GET " + requestFile0040 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0040, requestHost0040, requestPort0040, requestHeader0040, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0040 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;


		// all http requests of page #1_1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1_2.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #1 (fragment 3 of 4)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [41] <- WEB ADMIN Index 41 ---
		String requestProt0041 = "https";
		String requestHost0041 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0041 = 443;
		String requestFile0041 = "/-/media/images/film%20and%20events/may%202016/captainamericacivilwarherom.jpg";
		String requestHeader0041 = "GET " + requestFile0041 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0041, requestHost0041, requestPort0041, requestHeader0041, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0041 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [42] <- WEB ADMIN Index 42 ---
		String requestProt0042 = "https";
		String requestHost0042 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0042 = 443;
		String requestFile0042 = "/-/media/images/film%20and%20events/may%202016/angrybirdsherod.jpg";
		String requestHeader0042 = "GET " + requestFile0042 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0042, requestHost0042, requestPort0042, requestHeader0042, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0042 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [43] <- WEB ADMIN Index 43 ---
		String requestProt0043 = "https";
		String requestHost0043 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0043 = 443;
		String requestFile0043 = "/-/media/images/vue/settings/certificates/tbc.png";
		String requestHeader0043 = "GET " + requestFile0043 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0043, requestHost0043, requestPort0043, requestHeader0043, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0043 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [44] <- WEB ADMIN Index 44 ---
		String requestProt0044 = "https";
		String requestHost0044 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0044 = 443;
		String requestFile0044 = "/-/media/images/film%20and%20events/may%202016/isawthelightherom.jpg";
		String requestHeader0044 = "GET " + requestFile0044 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0044, requestHost0044, requestPort0044, requestHeader0044, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0044 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [45] <- WEB ADMIN Index 45 ---
		String requestProt0045 = "https";
		String requestHost0045 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0045 = 443;
		String requestFile0045 = "/-/media/images/film%20and%20events/may%202016/greenroomherom.jpg";
		String requestHeader0045 = "GET " + requestFile0045 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0045, requestHost0045, requestPort0045, requestHeader0045, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0045 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [46] <- WEB ADMIN Index 46 ---
		String requestProt0046 = "https";
		String requestHost0046 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0046 = 443;
		String requestFile0046 = "/-/media/images/film%20and%20events/may%202016/isawthelightherod.jpg";
		String requestHeader0046 = "GET " + requestFile0046 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0046, requestHost0046, requestPort0046, requestHeader0046, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0046 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [47] <- WEB ADMIN Index 47 ---
		String requestProt0047 = "https";
		String requestHost0047 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0047 = 443;
		String requestFile0047 = "/-/media/images/film%20and%20events/may%202016/ahologramforthekingherom.jpg";
		String requestHeader0047 = "GET " + requestFile0047 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0047, requestHost0047, requestPort0047, requestHeader0047, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0047 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [48] <- WEB ADMIN Index 48 ---
		String requestProt0048 = "https";
		String requestHost0048 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0048 = 443;
		String requestFile0048 = "/assets/css/images/bg-hamburger-lozenge.png";
		String requestHeader0048 = "GET " + requestFile0048 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0048, requestHost0048, requestPort0048, requestHeader0048, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0048 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [49] <- WEB ADMIN Index 49 ---
		String requestProt0049 = "https";
		String requestHost0049 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0049 = 443;
		String requestFile0049 = "/assets/css/images/vue_bg.png";
		String requestHeader0049 = "GET " + requestFile0049 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0049, requestHost0049, requestPort0049, requestHeader0049, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0049 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [50] <- WEB ADMIN Index 50 ---
		String requestProt0050 = "https";
		String requestHost0050 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0050 = 443;
		String requestFile0050 = "/assets/css/images/logo-header-vue.png";
		String requestHeader0050 = "GET " + requestFile0050 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0050, requestHost0050, requestPort0050, requestHeader0050, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0050 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [51] <- WEB ADMIN Index 51 ---
		String requestProt0051 = "https";
		String requestHost0051 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0051 = 443;
		String requestFile0051 = "/assets/css/images/quickbook-fade.png";
		String requestHeader0051 = "GET " + requestFile0051 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0051, requestHost0051, requestPort0051, requestHeader0051, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0051 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [52] <- WEB ADMIN Index 52 ---
		String requestProt0052 = "https";
		String requestHost0052 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0052 = 443;
		String requestFile0052 = "/assets/css/images/vue_bg_dark.png";
		String requestHeader0052 = "GET " + requestFile0052 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0052, requestHost0052, requestPort0052, requestHeader0052, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0052 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [53] <- WEB ADMIN Index 53 ---
		String requestProt0053 = "https";
		String requestHost0053 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0053 = 443;
		String requestFile0053 = "/assets/css/images/logo-footer-vue.png";
		String requestHeader0053 = "GET " + requestFile0053 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0053, requestHost0053, requestPort0053, requestHeader0053, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0053 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [54] <- WEB ADMIN Index 54 ---
		String requestProt0054 = "https";
		String requestHost0054 = "delivery.d.switchadhub.com";
		int    requestPort0054 = 443;
		String requestFile0054 = "/adserver/meta_web.php" +
				"?zone_id=7899" +
				"&instance_id=0";
		String requestHeader0054 = "GET " + requestFile0054 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: delivery.d.switchadhub.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0054, requestHost0054, requestPort0054, requestHeader0054, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0054 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [55] <- WEB ADMIN Index 55 ---
		String requestProt0055 = "https";
		String requestHost0055 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0055 = 443;
		String requestFile0055 = "/assets/js/webworkers/worker.js";
		String requestHeader0055 = "GET " + requestFile0055 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0055, requestHost0055, requestPort0055, requestHeader0055, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0055 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [56] <- WEB ADMIN Index 56 ---
		String requestProt0056 = "https";
		String requestHost0056 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0056 = 443;
		String requestFile0056 = "/data/search/";
		String requestHeader0056 = "GET " + requestFile0056 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0056, requestHost0056, requestPort0056, requestHeader0056, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0056 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [57] <- WEB ADMIN Index 57 ---
		String requestProt0057 = "https";
		String requestHost0057 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0057 = 443;
		String requestFile0057 = "/data/labels/";
		String requestHeader0057 = "GET " + requestFile0057 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0057, requestHost0057, requestPort0057, requestHeader0057, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0057 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [58] <- WEB ADMIN Index 58 ---
		String requestProt0058 = "https";
		String requestHost0058 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0058 = 443;
		String requestFile0058 = "/partials/GetCinemaFinderContent";
		String requestHeader0058 = "GET " + requestFile0058 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0058, requestHost0058, requestPort0058, requestHeader0058, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0058 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [59] <- WEB ADMIN Index 59 ---
		String requestProt0059 = "https";
		String requestHost0059 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0059 = 443;
		String requestFile0059 = "/assets/css/images/loader.gif";
		String requestHeader0059 = "GET " + requestFile0059 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0059, requestHost0059, requestPort0059, requestHeader0059, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0059 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [60] <- WEB ADMIN Index 60 ---
		String requestProt0060 = "https";
		String requestHost0060 = "delivery.d.switchadhub.com";
		int    requestPort0060 = 443;
		String requestFile0060 = "/adserver/meta_web.php" +
				"?zone_id=7899" +
				"&instance_id=1";
		String requestHeader0060 = "GET " + requestFile0060 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: delivery.d.switchadhub.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0060, requestHost0060, requestPort0060, requestHeader0060, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0060 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;


		// all http requests of page #1_2 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1_3.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1_3(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #1 (fragment 4 of 4)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [61] <- WEB ADMIN Index 61 ---
		String requestProt0061 = "https";
		String requestHost0061 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0061 = 443;
		String requestFile0061 = "/data/locations/";
		String requestHeader0061 = "GET " + requestFile0061 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0061, requestHost0061, requestPort0061, requestHeader0061, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0061 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [62] <- WEB ADMIN Index 62 ---
		log();
		log("# title: Null object cannot be converted to a value type.");
		String requestProt0062 = "https";
		String requestHost0062 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0062 = 443;
		String requestFile0062 = "/data/films/";
		String requestHeader0062 = "GET " + requestFile0062 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0062, requestHost0062, requestPort0062, requestHeader0062, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0062 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [63] <- WEB ADMIN Index 63 ---
		String requestProt0063 = "https";
		String requestHost0063 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0063 = 443;
		String requestFile0063 = "/partials/GetSelectDateContent";
		String requestHeader0063 = "GET " + requestFile0063 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0063, requestHost0063, requestPort0063, requestHeader0063, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0063 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [64] <- WEB ADMIN Index 64 ---
		String requestProt0064 = "https";
		String requestHost0064 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0064 = 443;
		String requestFile0064 = "/partials/GetSelectTimeContent";
		String requestHeader0064 = "GET " + requestFile0064 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0064, requestHost0064, requestPort0064, requestHeader0064, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0064 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [65] <- WEB ADMIN Index 65 ---
		String requestProt0065 = "https";
		String requestHost0065 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0065 = 443;
		String requestFile0065 = "/assets/fonts/robotocondensed-bold-webfont.woff2";
		String requestHeader0065 = "GET " + requestFile0065 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0065, requestHost0065, requestPort0065, requestHeader0065, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0065 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [66] <- WEB ADMIN Index 66 ---
		String requestProt0066 = "https";
		String requestHost0066 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0066 = 443;
		String requestFile0066 = "/data/locations/";
		String requestHeader0066 = "GET " + requestFile0066 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0066, requestHost0066, requestPort0066, requestHeader0066, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0066 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [67] <- WEB ADMIN Index 67 ---
		String requestProt0067 = "https";
		String requestHost0067 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0067 = 443;
		String requestFile0067 = "/partials/GetCinemaFinderContent";
		String requestHeader0067 = "GET " + requestFile0067 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0067, requestHost0067, requestPort0067, requestHeader0067, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0067 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;


		// all http requests of page #1_3 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #2.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// # Page #2: click search
		// # ---------------------



		// --- HTTP REQUEST: Test [69] <- WEB ADMIN Index 69 ---
		String requestProt0069 = "https";
		String requestHost0069 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0069 = 443;
		String requestFile0069 = "/layouts/system/VisitorIdentificationCSS.aspx" +
				"?1462954911011";
		String requestHeader0069 = "GET " + requestFile0069 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0069, requestHost0069, requestPort0069, requestHeader0069, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0069 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 138
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [69] <- Index 69
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated



		// all http requests of page #2 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #3.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_3(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// # Page #3: Type film jungle book
		// # ------------------------------



		// --- HTTP REQUEST: Test [71] <- WEB ADMIN Index 71 ---
		String requestProt0071 = "https";
		String requestHost0071 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0071 = 443;
		String requestFile0071 = "/layouts/system/VIChecker.aspx" +
				"?tstamp=635985516722754732";
		String requestHeader0071 = "GET " + requestFile0071 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0071, requestHost0071, requestPort0071, requestHeader0071, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0071 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 138
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [71] <- Index 71
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated



		// all http requests of page #3 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #4.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_4(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// # Page #4: click result
		// # ---------------------



		// --- HTTP REQUEST: Test [73] <- WEB ADMIN Index 73 ---
		log();
		log("# title: The Jungle Book");
		String requestProt0073 = "https";
		String requestHost0073 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0073 = 443;
		String requestFile0073 = "/film/the-jungle-book";
		requestFile0073 = Lib.replaceTextPattern(requestFile0073, "/film/the-jungle-book", movielink, 0);		// search and replace request file fragment "/film/the-jungle-book" with variable 'movielink' on all occurrences

		String requestHeader0073 = "GET " + requestFile0073 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0073, requestHost0073, requestPort0073, requestHeader0073, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0073 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 11933
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [73] <- Index 73
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		contentTokenExtractor = new ContentTokenExtractor(testURL.getContentString());

		// setup var extractor for 'filmID'
		ContentTokenExtractorItem contentTokenExtractorItem0073_1 = new ContentTokenExtractorItem("data-selected-filmid", "\t\n\r \"(),={}", 1);
		contentTokenExtractor.addTokenExtractorItem(contentTokenExtractorItem0073_1);

		// setup var extractor for 'MainPoster'
		ContentTokenExtractorItem contentTokenExtractorItem0073_2 = new ContentTokenExtractorItem("                <img src", "\t\n\r\"(),={}", 1);
		contentTokenExtractor.addTokenExtractorItem(contentTokenExtractorItem0073_2);

		contentTokenExtractor.extractTokens();
		try
		{
			// extract var 'filmID'
			filmID = contentTokenExtractorItem0073_1.getResultToken();
			log("<<< filmID = " + filmID);
		}
		catch (Exception e) { filmID = null; log(e); }
		if (filmID == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'filmID' from content token pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'MainPoster'
			MainPoster = contentTokenExtractorItem0073_2.getResultToken();
			log("<<< MainPoster = " + MainPoster);
		}
		catch (Exception e) { MainPoster = null; log(e); }
		if (MainPoster == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'MainPoster' from content token pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [74] <- WEB ADMIN Index 74 ---
		String requestProt0074 = "https";
		String requestHost0074 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0074 = 443;
		String requestFile0074 = "/-/media/images/film%20and%20events/may%202016/junglebookherod.jpg";
		requestFile0074 = Lib.replaceTextPattern(requestFile0074, "/-/media/images/film%20and%20events/may%202016/junglebookherod.jpg", MainPoster, 0);		// search and replace request file fragment "/-/media/images/film%20and%20events/may%202016/junglebookherod.jpg" with variable 'MainPoster' on all occurrences

		String requestHeader0074 = "GET " + requestFile0074 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0074, requestHost0074, requestPort0074, requestHeader0074, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		// execute inline script "parsingextractedposter"
		inlineScriptContext = executeInlineScript_1462965012672(testURL, threadStep, totalLoopCounter, innerLoopContext);

		LoadtestInlineScriptVar inputVar1 = new LoadtestInlineScriptVar("MainPoster", Lib.nullToBlank(MainPoster), 1);
		log("after Execution.." + inputVar1.getVarValue());
		if (inlineScriptContext.isScriptAbort())
		{
			// set non-executed URL as failed and abort current loop
			log("*** INLINE SCRIPT \"" + inlineScriptContext.getScriptTitle() + "\" ABORTED / CURRENT LOOP ABORTED ***");
			log("Abort Message = " + inlineScriptContext.getScriptAbortMessage());
			testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			testURL.setStatusType(HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT);
			performanceData.getPerformanceDataRecord(threadStep).modifyFailureActionType(HttpTestURL.FAILURE_ACTION_HANDLE_AS_ERROR);
			performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_ABORTED_BY_INLINE_SCRIPT, inlineScriptContext.getScriptAbortMessage(), testURL, this);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		testURL.execute(performanceData);
		requestHeader0074 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 231785
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [74] <- Index 74
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [75] <- WEB ADMIN Index 75 ---
		String requestProt0075 = "https";
		String requestHost0075 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0075 = 443;
		String requestFile0075 = "/-/media/images/vue/settings/certificates/pg.png";
		String requestHeader0075 = "GET " + requestFile0075 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0075, requestHost0075, requestPort0075, requestHeader0075, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0075 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [76] <- WEB ADMIN Index 76 ---
		String requestProt0076 = "https";
		String requestHost0076 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0076 = 443;
		String requestFile0076 = "/assets/css/images/page-details/hero-fade.png";
		String requestHeader0076 = "GET " + requestFile0076 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0076, requestHost0076, requestPort0076, requestHeader0076, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0076 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [77] <- WEB ADMIN Index 77 ---
		String requestProt0077 = "https";
		String requestHost0077 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0077 = 443;
		String requestFile0077 = "/assets/css/images/page-details/overview-fade.png";
		String requestHeader0077 = "GET " + requestFile0077 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0077, requestHost0077, requestPort0077, requestHeader0077, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0077 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [78] <- WEB ADMIN Index 78 ---
		String requestProt0078 = "https";
		String requestHost0078 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0078 = 443;
		String requestFile0078 = "/assets/css/images/page-details/quicktimes-fade.png";
		String requestHeader0078 = "GET " + requestFile0078 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0078, requestHost0078, requestPort0078, requestHeader0078, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0078 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [79] <- WEB ADMIN Index 79 ---
		String requestProt0079 = "https";
		String requestHost0079 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0079 = 443;
		String requestFile0079 = "/data/search/";
		String requestHeader0079 = "GET " + requestFile0079 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0079, requestHost0079, requestPort0079, requestHeader0079, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0079 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [80] <- WEB ADMIN Index 80 ---
		String requestProt0080 = "https";
		String requestHost0080 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0080 = 443;
		String requestFile0080 = "/data/labels/";
		String requestHeader0080 = "GET " + requestFile0080 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0080, requestHost0080, requestPort0080, requestHeader0080, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0080 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [81] <- WEB ADMIN Index 81 ---
		String requestProt0081 = "https";
		String requestHost0081 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0081 = 443;
		String requestFile0081 = "/partials/GetCinemaFinderContent";
		String requestHeader0081 = "GET " + requestFile0081 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0081, requestHost0081, requestPort0081, requestHeader0081, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0081 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [82] <- WEB ADMIN Index 82 ---
		String requestProt0082 = "https";
		String requestHost0082 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0082 = 443;
		String requestFile0082 = "/partials/GetCinemaFinderContent";
		String requestHeader0082 = "GET " + requestFile0082 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0082, requestHost0082, requestPort0082, requestHeader0082, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0082 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [83] <- WEB ADMIN Index 83 ---
		String requestProt0083 = "https";
		String requestHost0083 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0083 = 443;
		String requestFile0083 = "/data/locations/158182";
		requestFile0083 = Lib.replaceTextPattern(requestFile0083, "158182", filmID, 0);		// search and replace request file fragment "158182" with variable 'filmID' on all occurrences

		String requestHeader0083 = "GET " + requestFile0083 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0083, requestHost0083, requestPort0083, requestHeader0083, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0083 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;


		// all http requests of page #4 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #5.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_5(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// # Page #5: select cinema
		// # ----------------------



		// --- HTTP REQUEST: Test [85] <- WEB ADMIN Index 85 ---
		log();
		log("# title: The Jungle Book");
		String requestProt0085 = "https";
		String requestHost0085 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0085 = 443;
		String requestFile0085 = "/cinema/shepherds-bush/film/the-jungle-book";
		String requestHeader0085 = "GET " + requestFile0085 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0085, requestHost0085, requestPort0085, requestHeader0085, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0085 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 11972
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [85] <- Index 85
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [86] <- WEB ADMIN Index 86 ---
		String requestProt0086 = "https";
		String requestHost0086 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0086 = 443;
		String requestFile0086 = "/data/search/10033";
		String requestHeader0086 = "GET " + requestFile0086 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0086, requestHost0086, requestPort0086, requestHeader0086, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0086 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [87] <- WEB ADMIN Index 87 ---
		String requestProt0087 = "https";
		String requestHost0087 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0087 = 443;
		String requestFile0087 = "/data/labels/";
		String requestHeader0087 = "GET " + requestFile0087 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0087, requestHost0087, requestPort0087, requestHeader0087, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0087 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [88] <- WEB ADMIN Index 88 ---
		String requestProt0088 = "https";
		String requestHost0088 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0088 = 443;
		String requestFile0088 = "/partials/GetCinemaFinderContent";
		String requestHeader0088 = "GET " + requestFile0088 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0088, requestHost0088, requestPort0088, requestHeader0088, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0088 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 757
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [88] <- Index 88
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [89] <- WEB ADMIN Index 89 ---
		String requestProt0089 = "https";
		String requestHost0089 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0089 = 443;
		String requestFile0089 = "/data/showings/158182/10033";
		requestFile0089 = Lib.replaceTextPattern(requestFile0089, "158182", filmID, 0);		// search and replace request file fragment "158182" with variable 'filmID' on all occurrences

		String requestHeader0089 = "GET " + requestFile0089 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0089, requestHost0089, requestPort0089, requestHeader0089, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0089 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [90] <- WEB ADMIN Index 90 ---
		String requestProt0090 = "https";
		String requestHost0090 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0090 = 443;
		String requestFile0090 = "/data/locations/158182";
		requestFile0090 = Lib.replaceTextPattern(requestFile0090, "158182", filmID, 0);		// search and replace request file fragment "158182" with variable 'filmID' on all occurrences

		String requestHeader0090 = "GET " + requestFile0090 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0090, requestHost0090, requestPort0090, requestHeader0090, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0090 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [91] <- WEB ADMIN Index 91 ---
		String requestProt0091 = "https";
		String requestHost0091 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0091 = 443;
		String requestFile0091 = "/partials/GetCinemaFinderContent";
		String requestHeader0091 = "GET " + requestFile0091 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0091, requestHost0091, requestPort0091, requestHeader0091, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0091 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;


		// all http requests of page #5 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #6.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_6(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// # Page #6: click book
		// # -------------------



		// --- HTTP REQUEST: Test [93] <- WEB ADMIN Index 93 ---
		String requestProt0093 = "https";
		String requestHost0093 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0093 = 443;
		String requestFile0093 = "/data/film/158182";
		requestFile0093 = Lib.replaceTextPattern(requestFile0093, "158182", filmID, 0);		// search and replace request file fragment "158182" with variable 'filmID' on all occurrences

		String requestHeader0093 = "GET " + requestFile0093 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0093, requestHost0093, requestPort0093, requestHeader0093, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0093 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 2269
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [93] <- Index 93
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [94] <- WEB ADMIN Index 94 ---
		String requestProt0094 = "https";
		String requestHost0094 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0094 = 443;
		String requestFile0094 = "/data/showings/158182/10033";
		requestFile0094 = Lib.replaceTextPattern(requestFile0094, "158182", filmID, 0);		// search and replace request file fragment "158182" with variable 'filmID' on all occurrences

		String requestHeader0094 = "GET " + requestFile0094 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0094, requestHost0094, requestPort0094, requestHeader0094, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0094 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;


		// all http requests of page #6 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #7.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_7(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// # Page #7: select any time
		// # ------------------------



		// --- HTTP REQUEST: Test [96] <- WEB ADMIN Index 96 ---
		log();
		log("# title: Book Tickets");
		String requestProt0096 = "https";
		String requestHost0096 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0096 = 443;
		String requestFile0096 = "/book-tickets/summary/10033/158182/152485";
		requestFile0096 = Lib.replaceTextPattern(requestFile0096, "158182", filmID, 0);		// search and replace request file fragment "158182" with variable 'filmID' on all occurrences

		String requestHeader0096 = "GET " + requestFile0096 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0096, requestHost0096, requestPort0096, requestHeader0096, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0096 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 404, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 14696
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {404}, null, null, null);		// Test [96] <- Index 96
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [97] <- WEB ADMIN Index 97 ---
		String requestProt0097 = "https";
		String requestHost0097 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0097 = 443;
		String requestFile0097 = "/assets/css/site.css";
		String requestHeader0097 = "GET " + requestFile0097 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0097, requestHost0097, requestPort0097, requestHeader0097, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("158182", filmID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0097 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [98] <- WEB ADMIN Index 98 ---
		String requestProt0098 = "https";
		String requestHost0098 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0098 = 443;
		String requestFile0098 = "/assets/css/booking.css";
		String requestHeader0098 = "GET " + requestFile0098 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0098, requestHost0098, requestPort0098, requestHeader0098, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("158182", filmID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0098 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [99] <- WEB ADMIN Index 99 ---
		String requestProt0099 = "https";
		String requestHost0099 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0099 = 443;
		String requestFile0099 = "/assets/js/app.js";
		String requestHeader0099 = "GET " + requestFile0099 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0099, requestHost0099, requestPort0099, requestHeader0099, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("158182", filmID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0099 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [100] <- WEB ADMIN Index 100 ---
		String requestProt0100 = "https";
		String requestHost0100 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0100 = 443;
		String requestFile0100 = "/sc-assets/css/sc-styles.css";
		String requestHeader0100 = "GET " + requestFile0100 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0100, requestHost0100, requestPort0100, requestHeader0100, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("158182", filmID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0100 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [101] <- WEB ADMIN Index 101 ---
		String requestProt0101 = "https";
		String requestHost0101 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0101 = 443;
		String requestFile0101 = "/assets/js/head.js";
		String requestHeader0101 = "GET " + requestFile0101 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0101, requestHost0101, requestPort0101, requestHeader0101, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("158182", filmID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0101 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [102] <- WEB ADMIN Index 102 ---
		String requestProt0102 = "https";
		String requestHost0102 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0102 = 443;
		String requestFile0102 = "/assets/js/app-booking.js";
		String requestHeader0102 = "GET " + requestFile0102 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0102, requestHost0102, requestPort0102, requestHeader0102, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("158182", filmID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0102 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [103] <- WEB ADMIN Index 103 ---
		String requestProt0103 = "https";
		String requestHost0103 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0103 = 443;
		String requestFile0103 = "/data/search/";
		String requestHeader0103 = "GET " + requestFile0103 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0103, requestHost0103, requestPort0103, requestHeader0103, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("158182", filmID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0103 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;




		// --- HTTP REQUEST: Test [104] <- WEB ADMIN Index 104 ---
		String requestProt0104 = "https";
		String requestHost0104 = "www-uat-uk-whiplash.myvue.com";
		int    requestPort0104 = 443;
		String requestFile0104 = "/data/labels/";
		String requestHeader0104 = "GET " + requestFile0104 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www-uat-uk-whiplash.myvue.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: sv-SE,sv;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0104, requestHost0104, requestPort0104, requestHeader0104, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("158182", filmID);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0104 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;


		// all http requests of page #7 successful done
		return true;
	}



	boolean synchResponsesParallelRequestsPage_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 1 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 21460
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [2] <- Index 2
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 18446
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [3] <- Index 3
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 37757
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [4] <- Index 4
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 11216
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [5] <- Index 5
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 59244
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [6] <- Index 6
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 18699
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [7] <- Index 7
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 16183
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [8] <- Index 8
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 5428
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [9] <- Index 9
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1171
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [10] <- Index 10
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 498
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [11] <- Index 11
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 8287
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [12] <- Index 12
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2198
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [13] <- Index 13
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 12484
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [14] <- Index 14
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 26954
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, null);		// Test [15] <- Index 15
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 27759
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [16] <- Index 16
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 922
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [17] <- Index 17
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 64596
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [18] <- Index 18
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 12277
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, null);		// Test [19] <- Index 19
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 470985
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [20] <- Index 20
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 196416
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [21] <- Index 21
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 189214
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [22] <- Index 22
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 71131
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, null);		// Test [23] <- Index 23
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 226455
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [24] <- Index 24
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 355807
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [25] <- Index 25
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 352872
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [26] <- Index 26
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF2", header text fragment = [verification disabled], recorded content size = 20260
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF2", null, null);		// Test [27] <- Index 27
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 277148
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [28] <- Index 28
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 348908
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [29] <- Index 29
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 298972
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [30] <- Index 30
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 443072
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [31] <- Index 31
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 302042
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [32] <- Index 32
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF2", header text fragment = [verification disabled], recorded content size = 20788
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF2", null, null);		// Test [33] <- Index 33
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 732
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [34] <- Index 34
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 31836
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [35] <- Index 35
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 456609
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [36] <- Index 36
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 880
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [37] <- Index 37
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 525113
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [38] <- Index 38
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 660
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [39] <- Index 39
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 615
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [40] <- Index 40
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 283071
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [41] <- Index 41
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 309592
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [42] <- Index 42
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 643
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [43] <- Index 43
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 354636
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [44] <- Index 44
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 511287
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [45] <- Index 45
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 247876
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [46] <- Index 46
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 491643
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, null);		// Test [47] <- Index 47
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 11223
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [48] <- Index 48
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 59579
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [49] <- Index 49
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 6947
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [50] <- Index 50
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 2035
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [51] <- Index 51
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 14823
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [52] <- Index 52
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 33826
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [53] <- Index 53
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1401
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [54] <- Index 54
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 236
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [55] <- Index 55
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 14808
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [56] <- Index 56
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 7962
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [57] <- Index 57
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 757
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [58] <- Index 58
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 12434
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [59] <- Index 59
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1401
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [60] <- Index 60
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 11282
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [61] <- Index 61
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 12740
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, null, null, null);		// Test [62] <- Index 62
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 430
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [63] <- Index 63
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 451
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [64] <- Index 64
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF2", header text fragment = [verification disabled], recorded content size = 19864
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF2", null, null);		// Test [65] <- Index 65
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 11282
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [66] <- Index 66
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 757
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [67] <- Index 67
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 2 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_3(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 3 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_4(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 4 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 714
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [75] <- Index 75
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1091
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [76] <- Index 76
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 108584
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [77] <- Index 77
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 246
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [78] <- Index 78
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 14808
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [79] <- Index 79
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 7962
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [80] <- Index 80
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 757
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [81] <- Index 81
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 757
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [82] <- Index 82
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 782
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [83] <- Index 83
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_5(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 5 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 15537
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [86] <- Index 86
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 7962
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [87] <- Index 87
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 5845
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [89] <- Index 89
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 936
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [90] <- Index 90
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 757
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, null);		// Test [91] <- Index 91
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_6(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 6 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 5845
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [94] <- Index 94
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_7(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 7 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 104552
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [97] <- Index 97
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 36820
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [98] <- Index 98
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 110140
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [99] <- Index 99
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 774
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [100] <- Index 100
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 14485
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [101] <- Index 101
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 39329
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [102] <- Index 102
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 14808
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [103] <- Index 103
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 7962
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [104] <- Index 104
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}



	/**
	 * implement GetRealTimeUserInputFieldsInterface: get the definition and the value of all real-time user input fields.
	 */
	public ArrayList<RealTimeUserInputField> getRealTimeUserInputFields()
	{
		try
		{
			ArrayList<RealTimeUserInputField> realTimeUserInputFieldList = new ArrayList<RealTimeUserInputField>();
			return realTimeUserInputFieldList;
		}
		catch (Exception e)
		{
			log(e);
			return null;
		}
	}



	/**
	 * implement ThreadStepInterface: get the current execution step (current URL call or page break) of a simulated user.
	 */
	public int getExecutionStep()
	{
		return threadStep;
	}



	/**
	 * implement SetThreadStepInterface: set the current execution step (current URL call or page break) of a simulated user.
	 */
	public void setExecutionStep(int threadStep)
	{
		this.threadStep = threadStep;
	}



	/**
	 * implement SSLSessionCacheStatisticInterface: get statistic data about the SSL session cache behavior of a simulated user.
	 */
	public SSLSessionCacheStatistic getSSLSessionCacheStatistic()
	{
		return sslStatistic;
	}



	/**
	 * implement VaryingTestDurationInterface: support to extend or to reduce the planned test duration.
	 */
	public int getPlannedTestDuration()
	{
		return plannedTestDuration;
	}
	
	public void setExtendTestDuration(int deltaSeconds)
	{
		if (plannedTestDuration == 0)
		{
			plannedTestDuration = deltaSeconds;		// the old planned test duration was unlimited but is now limited
			return;
		}
		if (deltaSeconds == 0)
		{
			plannedTestDuration = 0;		// the new planned test duration is now unlimited
			return;
		}
		plannedTestDuration = plannedTestDuration + deltaSeconds;
	}



	/**
	 * implement SuspendResumeInterface: support to suspend and to resume the test execution.
	 */
	public int getPlannedStartupDelay()
	{
		return plannedStartupDelay;
	}
	
	public void setUserResumeStartWaitDelay(int millis)
	{
		userResumeStartWaitDelay = millis;
	}



	/**
	 * implement VaryingLoadInterface: support to decrement the number of simulated users at runtime.
	 */
	public void setDecrementEndOfLoopFlag(boolean decrementEndOfLoopFlag)
	{
		this.decrementEndOfLoopFlag = decrementEndOfLoopFlag;
	}

	public boolean isDecrementEndOfLoopFlag()
	{
		return decrementEndOfLoopFlag;
	}



	/**
	 * internal method: execute the loops for one simulated user as a thread.
	 * controls the thread and displays the (thread-)log if one loop has been completed.
	 */
	public void run()
	{
		// user terminated by inline script, at start of user ?
		if (isTerminateUser())
		{
			System.out.println("# --- thread " + Thread.currentThread().getName() + " aborted --- " + ZoneTime.dateToShortString() + " ---");
			return;
		}
		try
		{
			while (true)
			{
				threadStep = ThreadStepInterface.THREAD_NO_STEP;
				clearLog();
				
				// execute loop
				log("--- loop started --- " + ZoneTime.dateToShortString() + " ---");
				boolean loopPassed = this.execute(totalLoopCounter.getAndIncrement());
				performanceData.addUserTransactionMeasuredSamples(transactionHandler.getPendingTransactions());
				performanceData.addUserTransactionNotExecutedSamples(transactionHandler.getNotExecutedTransactions());
				transactionHandler.resetTransactions();
				performanceData.addSocktPoolStatistic(socketPool);
				socketPool.closePool();
				performanceData.addSSLCacheStatistic(sslStatistic.getSSLSessionCacheStatisticResult());
				sslStatistic.reset();
				
				// eof of input file ?
				if (abortedByEofInputFile())
					return;		// endOfRun() not called in such a case
				
				// check loop result
				String remainingLoopInfo = "";
				if (checkLoopCount)
					remainingLoopInfo = " [remaining loops = " + (remainingLoops - 1) + "]";
				if (loopPassed)
				{
					performanceData.addPassedLoop();
					log("--- loop passed ---  " + ZoneTime.dateToShortString() + " ---" + remainingLoopInfo);
				}
				else
				{
					performanceData.addFailedLoop();
					log("--- loop failed ---  " + ZoneTime.dateToShortString() + " ---" + remainingLoopInfo);
				}
				threadStep = ThreadStepInterface.THREAD_NO_STEP;
				
				// display thread log to standard output
				if (debugLoops || (debugFailedLoops && (!loopPassed)))
				{
					synchronized (dumpLock)
					{
						dumpLog(System.out);				// full log
					}
				}
				
				// check if max loops reached
				if (checkLoopCount)
				{
					// all done ?
					remainingLoops--;
					if (remainingLoops <= 0)
					{
						endOfRun();
						return;
					}
				}
				
				// check if simulated user must be decremented
				if (decrementEndOfLoopFlag)
				{
					endOfRun();
					decrementEndOfLoopFlag = false; // reset flag for further use
					return;
				}
				
				// check if max test duration reached
				if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				{
					endOfRun();
					return;
				}
				
				// check if this specific user is terminated earlier than planned by a HTTP content verification or by a plug-in
				if (isTerminateUser())
				{
					endOfRun();
					System.out.println("# --- thread " + Thread.currentThread().getName() + " terminate failed user --- " + ZoneTime.dateToShortString() + " ---");
					return;
				}
				
				// check if load test execution is temporary suspended
				boolean wasSuspended = false;
				while (isSuspend())
				{
					wasSuspended = true;
					try { Thread.currentThread().sleep(20); } catch (InterruptedException ie) {}
					if (abortedByRemote() || abortedByEofInputFile())
					{
						endOfRun();
						return;
					}
					
					// check if max test duration reached during suspend
					if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
					{
						endOfRun();
						return;
					}
				}
				// check if load test execution is resumed
				if (wasSuspended)
				{
					try { sleepRemoteInterruptable(userResumeStartWaitDelay); } catch (InterruptedException ie) {}
				}
				
				// wait 20 milliseconds if loop has failed
				if (!loopPassed)
					try { Thread.currentThread().sleep(loopErrorDelay); } catch (InterruptedException ie) {}
				
				// execute next loop
				threadLoopCounter++;
			}	// end: while (true)
		}
		catch (Throwable tex)
		{
			log("*** INTERNAL ERROR / LOAD TEST ABORTED ***");
			log(tex);
			log();
			synchronized (dumpLock)
			{
				dumpLog(System.out);				// full log
				System.err.println("*** INTERNAL ERROR / LOAD TEST ABORTED ***");
				tex.printStackTrace(System.err);
				System.exit(-2);
			}
		}
		finally
		{
			// remove the reference to this load test instance and the reference to the thread that runs this instance
			try
			{
				getUserContextTable().getWriteLock().lock();
				getOwnLoadTestUserContext().setLoadTestUserFinallyEnded();
				getUserContextTable().getWriteLock().unlock();
			}
			catch (Throwable texFinal)
			{
				System.err.println("*** INTERNAL FINALLY ERROR / LOAD TEST ABORTED ***");
				texFinal.printStackTrace(System.err);
				System.exit(-2);
			}
		}
	}



	/**
	 * internal method: called when a user has completed the test-run.
	 */
	public void endOfRun()
	{
		clearLog();
		
		if (debugLoops && (getLog().size() > 0))
		{
			synchronized (dumpLock)
			{
				dumpLog(System.out);		// dump log of inline scripts and load test plug-ins which are executed at end of user
			}
		}
	}



	/**
	 * Main program. Starts the test and waits until all have been done.
	 */
	public static void main(String[] args)
	{
		// check command line argument -h or -help
		if ((ParseArgs.hasOption(args, "-h")) || (ParseArgs.hasOption(args, "-help")))
		{
			System.out.println();
			System.out.println("Help - Proxy Sniffer Load Test Program:");
			System.out.println();
			System.out.println("-u <number>              ->> required argument: number of concurrent users");
			System.out.println("-d <seconds>             ->> required argument: planned test duration in seconds (default: 30, 0 = unlimited)");
			System.out.println("-t <seconds>             ->> required argument: request timeout per url in seconds");
			System.out.println();
			System.out.println("-sdelay <milliseconds>   ->> startup delay time between concurrent users in milliseconds (default: 200)");
			System.out.println("-mtpu <number>           ->> maximum number of parallel threads per user (default: " + MAX_PARALLEL_THREADS_PER_USER + ")");
			System.out.println("-maxloops <number>       ->> maximum number of loops per user (default: 0 = unlimited)");
			System.out.println("-downlink <kbps>         ->> maximum downlink network bandwidth per user in kilobits per second (default: 0 = unlimited)");
			System.out.println("-uplink <kbps>           ->> maximum uplink network bandwidth per user in kilobits per second (default: 0 = unlimited)");
			System.out.println("-multihomed <filename>   ->> use serveral client ip addresses - file format: <addr1>, <addr2>, ... (all on the same line)");
			System.out.println("-sampling <seconds>      ->> statistic sampling interval in seconds (default: 15)");
			System.out.println("-percpage <percent>      ->> additional sampling rate per web page call in percent (default: 100)");
			System.out.println("-percurl <percent>       ->> additional sampling rate per url call in percent (default: 0)");
			System.out.println("-percurlopt <level>      ->> extended sampling level per url call, see application reference manual (default: 0 = disabled)");
			System.out.println("-maxerrsnap <number>     ->> maximum number of error snapshots per url (default: 0 = unlimited)");
			System.out.println("-maxerrmem <megabytes>   ->> maximum size of memory in megabytes which can be used for error snapshots (default: 20, -1 = unlimited)");
			System.out.println("-nosdelayCluster         ->> apply startup delay time between concurrent users per exec agent, but not per cluster job (default: apply per cluster job)");
			System.out.println("-setuseragent \"<text>\"   ->> replace the recorded value of the HTTP request header field User-Agent with a new value");
			System.out.println("-collect <host>[:<port>] ->> collect additional data from external measuring agents (data collectors)");
			System.out.println("-res <filename>          ->> overrides the default name of the binary output file");
			System.out.println("-nores                   ->> disables to create the binary output file");
			System.out.println();
			System.out.println("-ssl <version>           ->> set SSL version: possible options are \"all\" (default), \"v3\", \"tls\", \"tls11\" or \"tls12\"");
			System.out.println("-sslcache <seconds>      ->> timeout of user-related SSL session cache (default: 300, 0 = cache disabled)");
			System.out.println("-sslrandom <type>        ->> set the type of the random generator used for SSL handshakes: possible options are \"fast\", \"iaik\" (default) or \"java\"");
			System.out.println("-sslcmode                ->> apply SSL/HTTPS compatibility workarounds for deficient SSL servers");
			System.out.println("-ecc                     ->> enable support of elliptic curve cryptography (ECC)");
			System.out.println("-nosni                   ->> disable support of server name indication (SNI)");
			System.out.println("-snicritical             ->> set the TLS SNI extension as critical (default: non-critical)");
			System.out.println();
			System.out.println("-dnssrv <IP-1>[,IP-N])   ->> use specific DNS server(s) to resolve DNS host names (default: use OS to resolve host names)");
			System.out.println("-dnshosts <filename>     ->> use specific DNS hosts file (default: use OS to resolve host names)");
			System.out.println("-dnstranslation <filename> ->> use a DNS translation file that converts DNS names. It might be needed to disable TLS SNI if this option is used");
			System.out.println("-dnsenattl               ->> enable consideration of DNS TTL by using the received TTL-values from the DNS Server(s) (default: TTL disabled)");
			System.out.println("-dnsfixttl <seconds>     ->> enable DNS TTL by using a fixed TTL-value of seconds for all DNS resolves");
			System.out.println("-dnsperloop              ->> perform new DNS resolves for each executed loop. All resolves are stable within the same loop (no consideration of DNS TTL within a loop)");
			System.out.println("-dnsstatistic            ->> collect statistical data about DNS resolutions. Note: use this option only if not any other, more specific DNS option is enabled");
			System.out.println("-dnsdebug                ->> debug DNS resolves and the DNS cache");
			System.out.println();
			System.out.println("-dfl                     ->> debug execution steps of all failed loops to standard output");
			System.out.println("-dl                      ->> debug execution steps of all loops to standard output");
			System.out.println("-dh                      ->> debug HTTP protocol headers to standard output, includes the -dl option");
			System.out.println("-dc                      ->> debug HTTP content data to standard output, includes the -dl option");
			System.out.println("-dhc                     ->> debug HTTP protocol headers and HTTP content data to standard output, includes the -dl option");
			System.out.println("-dC                      ->> debug cookies to standard output, includes the -dl option");
			System.out.println("-dK                      ->> debug keep-alive (socket pool) to standard output, includes the -dl option");
			System.out.println("-dssl                    ->> debug SSL handshake (https) to standard output, includes the -dl and the -dK option");
			System.out.println();
			System.out.println("-tz <timezone>           ->> set time zone (see Application Reference Manual: supported time zones)");
			System.out.println("-dgs a|c                 ->> set number format (decimal group separator) a = '  c = ,");
			System.out.println("-annotation <text>       ->> adds an annotation for this test run");
			System.out.println();
			System.out.println("-execAgentHost <ip address or dns name>      ->> set the ip address or the dns name of the exec agent from which the license is used (default: 127.0.0.1)");
			System.out.println("-execAgentPort <port>                        ->> set the tcp/ip port of the exec agent (default: 7993)");
			System.out.println("-execAgentProtocol <plain | http | https>    ->> set the protocol of the exec agent (default: plain)");
			System.out.println("-execAgentUsername <string>                  ->> set the auth. username for the exec agent (default: [no username])");
			System.out.println("-execAgentPassword <string>                  ->> set the auth. password for the exec agent (default: [no password])");
			System.out.println();
			System.out.println("-h                       ->> display this help text");
			System.out.println("-help                    ->> display this help text");
			System.out.println();
			System.exit(-1);
		}
		
		System.out.println("+----------------------------------------------------------------+");
		System.out.println("| Welcome to the ZebraTester Load Test Program.                  |");
		System.out.println("| Additional help available with program argument \"-help\"        |");
		System.out.println("| Procedure Copyright by Ingenieurbuero David Fischer AG,        |");
		System.out.println("| a company of the Apica group. All rights reserved.             |");
		System.out.println("+----------------------------------------------------------------+");
		
		// check command line argument -ecc
		sslECC = (ParseArgs.hasOption(args, "-ecc"));       // enable ssl ecc ?
		
		// initialize ssl/https support
		SSLInit.execute();
		if (sslECC)
			SSLInit.enableECC();
		
		// check command line argument -nosni
		if (ParseArgs.hasOption(args, "-nosni"))            // disable ssl sni ?
			sslSNI = false;
		
		// check command line argument -snicritical
		if (ParseArgs.hasOption(args, "-snicritical"))      // set ssl sni as critical tls extension ?
			sslSNICirical = true;
		
		// set default character set for response content tests
		setCharEncoding(prxCharEncoding);
		
		// check command line argument -tz <timezone>
		String timeZoneString = ParseArgs.getString(args, "-tz");
		if (timeZoneString != null)
			defaultTimeZone = timeZoneString.toUpperCase(); // set time zone?
		ZoneTime.setDefaultTimeZone(defaultTimeZone);
		
		// check command line argument -dgs a|c
		String dgs = ParseArgs.getString(args, "-dgs");
		if (dgs != null)
		{
			if (dgs.equalsIgnoreCase("a"))
				defaultNumberGroupingSeparator = '\'';
			if (dgs.equalsIgnoreCase("c"))
				defaultNumberGroupingSeparator = ',';
		}
		Lib.setDefaultNumberGroupingSeparator(defaultNumberGroupingSeparator);
		
		// check command line argument -annotation <text>
		String testRunAnnotation = ParseArgs.getString(args, "-annotation");
		if (testRunAnnotation != null)
		{
			if (testRunAnnotation.startsWith("\"") && testRunAnnotation.endsWith("\""))
				testRunAnnotation = testRunAnnotation.substring(1, testRunAnnotation.length() - 1);
		}
		
		// check command line argument -ssl
		String newSslProtocolVersion = ParseArgs.getString(args, "-ssl");
		if (newSslProtocolVersion != null)
		{
			if (newSslProtocolVersion.equalsIgnoreCase("v2"))
				sslProtocolVersion = "v2";
			if (newSslProtocolVersion.equalsIgnoreCase("v3"))
				sslProtocolVersion = "v3";
			if (newSslProtocolVersion.equalsIgnoreCase("tls"))
				sslProtocolVersion = "tls";
			if (newSslProtocolVersion.equalsIgnoreCase("tls11"))
				sslProtocolVersion = "tls11";
			if (newSslProtocolVersion.equalsIgnoreCase("tls12"))
				sslProtocolVersion = "tls12";
		}
		
		// check command line argument -sslcache <seconds>
		Integer newSslSessionCacheTimeout = ParseArgs.getInteger(args, "-sslcache");
		if (newSslSessionCacheTimeout != null)
			sslSessionCacheTimeout = newSslSessionCacheTimeout.intValue();
		
		// check command line argument -sslrandom
		String sslHandshakeRandomGeneratorTypeStr = ParseArgs.getString(args, "-sslrandom");
		if (sslHandshakeRandomGeneratorTypeStr != null)
		{
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("java"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_JAVA_DEFAULT;
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("iaik"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_IAIK_DEFAULT;
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("fast"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_FAST;
		}
		
		// check command line argument -sslcmode
		sslcmode = ParseArgs.hasOption(args, "-sslcmode");  // enable ssl/https compatibility workarounds?
		
		// check command line argument -dfl
		debugFailedLoops = ParseArgs.hasOption(args, "-dfl"); // debug failed loops?
		
		// check command line argument -dl
		debugLoops = ParseArgs.hasOption(args, "-dl");      // debug loops?
		
		// check command line argument -dh
		debugHttp = ParseArgs.hasOption(args, "-dh");       // debug http?
		if (debugHttp)
			debugLoops = true;
		
		// check command line argument -dc
		debugContent = ParseArgs.hasOption(args, "-dc");    // debug content?
		if (debugContent)
			debugLoops = true;
		
		// check command line argument -dhc
		if (ParseArgs.hasOption(args, "-dhc"))				// debug http and content
		{
			debugLoops = true;
			debugHttp = true;
			debugContent = true;
		}
		
		// check command line argument -dC
		debugCookies = ParseArgs.hasOption(args, "-dC");    // debug cookies?
		if (debugCookies)
			debugLoops = true;
		
		// check command line argument -dK
		debugKeepAlive = ParseArgs.hasOption(args, "-dK");  // debug keep.alive (socket pool)?
		if (debugKeepAlive)
			debugLoops = true;
		
		// check command line argument -dssl
		debugSsl = ParseArgs.hasOption(args, "-dssl");      // debug keep.alive (socket pool)?
		if (debugSsl)
		{
			debugLoops = true;
			debugKeepAlive = true;
		}
		
		// get startup delay
		Integer newStartupDelay = ParseArgs.getInteger(args, "-sdelay");
		if (newStartupDelay != null)
			plannedStartupDelay = newStartupDelay.intValue();
		
		// get max. parallel threads per user - note: only valid if CONTAINS_PARALLEL_EXECUTED_URLS = true
		Integer newMaxParallelThreadsPerUser = ParseArgs.getInteger(args, "-mtpu");
		if (newMaxParallelThreadsPerUser != null)
		{
			if (newMaxParallelThreadsPerUser.intValue() > 0)
				maxParallelThreadsPerUser = newMaxParallelThreadsPerUser.intValue();
		}
		// get maximum number of loops per user
		maxPlannedLoops = 0;  // maximum loops per user, 0 = unlimited
		Integer newLoops = ParseArgs.getInteger(args, "-maxloops");
		if (newLoops != null)
			maxPlannedLoops = newLoops.intValue();
		
		// get maximum downlink network bandwidth per user (default = unlimited)
		Integer newDownlinkBandwidth = ParseArgs.getInteger(args, "-downlink");
		if (newDownlinkBandwidth != null)
			downlinkBandwidth = newDownlinkBandwidth.intValue();
		
		// get maximum uplink network bandwidth per user (default = unlimited)
		Integer newUplinkBandwidth = ParseArgs.getInteger(args, "-uplink");
		if (newUplinkBandwidth != null)
			uplinkBandwidth = newUplinkBandwidth.intValue();
		
		// use test-specific DNS hosts file (optional) ?
		String dnsHostsFile = ParseArgs.getIgnoreCaseString(args, "-dnshosts");
		if (dnsHostsFile != null)
		{
			try
			{
				dnsCache = new DNSCache(dnsHostsFile);
			}
			catch (IOException ie)
			{
				System.out.println("*** ERROR: unable to read DNS hosts file " + dnsHostsFile + " ***");
				System.out.println("*** Hint: you have to ZIP " + dnsHostsFile + " together with the compiled class of the load test program ***");
				ie.printStackTrace();
				System.exit(-1);
			}
		}
		
		// use test-specific DNS translation table (optional) ?
		String dnsTranslationTableFile = ParseArgs.getIgnoreCaseString(args, "-dnstranslation");
		if (dnsTranslationTableFile != null)
		{
			try
			{
				DNSTranslationTable dnsTranslationTable = new DNSTranslationTable(new File(dnsTranslationTableFile));
				if (dnsCache == null)
					dnsCache = new DNSCache();
				dnsCache.setDNSTranslationTable(dnsTranslationTable);
			}
			catch (IOException ie)
			{
				System.out.println("*** ERROR: unable to read DNS translation table file " + dnsTranslationTableFile + " ***");
				System.out.println("*** Hint: you have to ZIP " + dnsTranslationTableFile + " together with the compiled class of the load test program ***");
				ie.printStackTrace();
				System.exit(-1);
			}
		}
		
		// use test-specific DNS servers (optional) ?
		String dnsSrvStr = ParseArgs.getIgnoreCaseString(args, "-dnssrv");
		if (dnsSrvStr != null)
		{
			ArrayList<String> dnsSrvList = new ArrayList<String>();
			StringTokenizer dnsTok = new StringTokenizer(dnsSrvStr, ",;");
			while (dnsTok.hasMoreTokens())
				dnsSrvList.add(dnsTok.nextToken());
			if (dnsCache == null)
				dnsCache = new DNSCache(dnsSrvList);
			else
				dnsCache.setDnsServers(dnsSrvList);
		}
		
		// enable DNS TTL ?
		if (ParseArgs.hasOption(args, "-dnsenattl"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.enableTTL();
		}
		
		// set fixed DNS TTL ?
		Integer dnsFixTTL = ParseArgs.getInteger(args, "-dnsfixttl");
		{
			if (dnsFixTTL != null)
			{
				if (dnsCache == null)
					dnsCache = new DNSCache();
				dnsCache.setFixedTTL(dnsFixTTL.intValue());
			}
		}
		
		// enable DNS resolves per loop ?
		if (ParseArgs.hasOption(args, "-dnsperloop"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsPerLoop = true;
		}
		
		// enable DNS statistic ?   // note: use this option only if not any other, more specific DNS option is enabled.
		if (ParseArgs.hasOption(args, "-dnsstatistic"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
		}
		
		// debug DNS resolver ?
		if (ParseArgs.hasOption(args, "-dnsdebug"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.setDebugToStdout(true);
		}
		
		// get statistic sampling interval
		int samplingInterval = 15;  // statistic sampling interval in seconds
		Integer newSamplingInterval = ParseArgs.getInteger(args, "-sampling");
		if (newSamplingInterval != null)
			samplingInterval = newSamplingInterval.intValue();
		
		// get additional sampling rate per web page call
		int percentilePageSampling = 100;  // additional sampling rate per web page call in percent
		Integer newPercentilePageSampling = ParseArgs.getInteger(args, "-percpage");
		if (newPercentilePageSampling != null)
			percentilePageSampling = newPercentilePageSampling.intValue();
		
		// get additional sampling rate per url call
		int percentileUrlSampling = 0;  // additional sampling rate per url call in percent
		Integer newPercentileUrlSampling = ParseArgs.getInteger(args, "-percurl");
		if (newPercentileUrlSampling != null)
			percentileUrlSampling = newPercentileUrlSampling.intValue();
		
		// get extended sampling level per url call
		int percentileUrlSamplingAddOption = 0;  // extended sampling level per url call, 0 = disabled
		Integer newPercentileUrlSamplingAddOption = ParseArgs.getInteger(args, "-percurlopt");
		if (newPercentileUrlSamplingAddOption != null)
			percentileUrlSamplingAddOption = newPercentileUrlSamplingAddOption.intValue();
		
		// get maximum number of error snapshots per URL (0 = unlimited)
		int maxErrorSnapshots = 0;
		Integer newMaxErrorSnapshots = ParseArgs.getInteger(args, "-maxerrsnap");
		if (newMaxErrorSnapshots != null)
			maxErrorSnapshots = newMaxErrorSnapshots.intValue();
		
		// get maximum memory in megabytes which can be used for error snapshots (-1 = unlimited, default = 10)
		long maxErrorSnapshotMemory = 20;
		Long newMaxErrorSnapshotMemory = ParseArgs.getLong(args, "-maxerrmem");
		if (newMaxErrorSnapshotMemory != null)
			maxErrorSnapshotMemory = newMaxErrorSnapshotMemory.longValue();
		
		// single user mode ?
		boolean singleUserMode = ParseArgs.hasOption(args, "-singleuser");
		
		// override value for http user agent field ?
		String setUserAgentStr = ParseArgs.getIgnoreCaseString(args, "-setuseragent");
		if (setUserAgentStr != null)
		{
			USER_AGENT_1 = setUserAgentStr;
		}
		// get required input arguments
		int concurrentUsers = 0;     // number of concurrent users
		plannedRequestTimeout = 0;   // request timeout in seconds
		
		System.out.println();
		
		// parse -u argument or ask --> <number of concurrent users>
		Integer i = ParseArgs.getIntegerOrAsk(args, "-u", "Concurrent Users, <RETURN>=1 : ", new Integer(1));
		if (i == null)
			System.exit(-1);
		else
			concurrentUsers = i.intValue();
		
		// parse -d argument or ask --> <test duration in seconds>
		i = ParseArgs.getIntegerOrAsk(args, "-d", "Test Duration in Seconds, <RETURN>=30 : ", new Integer(30));
		if (i == null)
			System.exit(-1);
		else
			plannedTestDuration = i.intValue();
		
		// parse -t argument or ask --> <request timeout in seconds>
		i = ParseArgs.getIntegerOrAsk(args, "-t", "HTTP Request Timeout per URL in Seconds, <RETURN>=60 : ", new Integer(60));
		if (i == null)
			System.exit(-1);
		else
			plannedRequestTimeout = i.intValue();
		
		String genericFileName = PerformanceData.proposeFileName("S5_SearchbookCdebug2", concurrentUsers);
		
		// auto-configure binary result file
		if (!ParseArgs.hasOption(args, "-nores"))
		{
			String newResultFile = ParseArgs.getString(args, "-res");
			if (newResultFile == null)
				resultFile = genericFileName + ".prxres";
			else
				resultFile = newResultFile;
			System.out.println("Result File : " + resultFile);
		}
		
		// initialize input files
		try
		{
			movielinks_txt = new VarRandomInputFileReader("movielinks.txt", "#", ";", AbstractInputFileReader.EOF_REOPEN_FILE, prxCharEncoding);
			movielinks_txt.setTrimValues(true);
		}
		catch (IOException ie)
		{
			System.out.println("*** ERROR: UNABLE TO OPEN INPUT FILE ***");
			ie.printStackTrace();
			System.exit(-2);
		}
		
		// display common arguments at console output
		System.out.println();
		System.out.println("# concurrent users = " + concurrentUsers);
		System.out.println("# max. parallel threads per user = " + maxParallelThreadsPerUser);
		System.out.print("# planned test duration = ");
		if (plannedTestDuration == 0)
			System.out.println("unlimited");
		else
			System.out.println("" + plannedTestDuration + " seconds");
		System.out.println("# http request timeout = " + plannedRequestTimeout + " seconds");
		System.out.println("# startup delay = " + plannedStartupDelay + " milliseconds");
		System.out.println("# statistic sampling interval = " + samplingInterval + " seconds");
		System.out.println("# additional sampling rate per web page call = " + percentilePageSampling + " %");
		System.out.println("# additional sampling rate per url call = " + percentileUrlSampling + " %");
		System.out.println("# extended sampling per url call = " + PerformanceDataTickExtension.extTypeToString(percentileUrlSamplingAddOption).toLowerCase());
		System.out.print("# max loops per user = ");
		if (maxPlannedLoops == 0)
			System.out.println("unlimited");
		else
			System.out.println("" + maxPlannedLoops + " loops");
		if (downlinkBandwidth > 0)
			System.out.println("# max downlink bandwidth per user = " + downlinkBandwidth + " kbps");
		if (uplinkBandwidth > 0)
			System.out.println("# max uplink bandwidth per user = " + uplinkBandwidth + " kbps");
		System.out.println("# http protocol version = v" + httpProtocolVersion);
		System.out.println("# ssl protocol version = " + sslProtocolVersion);
		if (sslSessionCacheTimeout != 0)
			System.out.println("# ssl session cache timeout = " + sslSessionCacheTimeout + " seconds");
		else
			System.out.println("# ssl session cache disabled");
		if (dnsCache != null)
		{
			System.out.println("# OS-independent DNS access enabled. " + dnsCache.getConfigInfoText());
			if (dnsPerLoop)
				System.out.println("# DNS option -dnsperloop enabled");
		}
		if (resultFile != null)
			System.out.println("# result file = " + resultFile);
		else
			System.out.println("# no result file");
		if (debugFailedLoops)
			System.out.println("# debug failed loops");
		if (debugLoops)
			System.out.println("# debug loops");
		if (debugHttp)
			System.out.println("# debug http protocol headers");
		if (debugContent)
			System.out.println("# debug http content data");
		if (debugCookies)
			System.out.println("# debug cookies");
		if (debugKeepAlive)
			System.out.println("# debug keep-alive (socket pool)");
		if (debugSsl)
			System.out.println("# debug ssl (https)");
		System.out.println("# input file = movielinks.txt, file scope = new line per loop");
		if (debugLoops || debugFailedLoops)
		{
		}
		System.out.println();
		
		
		
		// --------------------------
		// *** start of load test ***
		// --------------------------
		
		
		// initialize performance data
		// ---------------------------
		final int PAGE_BREAKS = 7;  // number of page breaks in execute()  - modify this value if you add or delete some page breaks
		final int MAX_THREAD_STEPS = 98;  // number of URL requests in execute() - modify this value if you add or delete some requests
		performanceData = new PerformanceData(PAGE_BREAKS, MAX_THREAD_STEPS, concurrentUsers, maxParallelThreadsPerUser, plannedTestDuration, maxPlannedLoops, httpProtocolVersion, plannedStartupDelay, plannedRequestTimeout, samplingInterval, percentilePageSampling, percentileUrlSampling, percentileUrlSamplingAddOption);
		performanceData.setInfoText("S5_SearchbookCdebug2");
		performanceData.setExecutorsAnnotation(testRunAnnotation);
		performanceData.setResultFileName(resultFile);
		performanceData.setDumpStream(System.out, "# ");
		performanceData.setMaxErrorSnapshots(maxErrorSnapshots);		// 0 = unlimited
		if (maxErrorSnapshotMemory >= 0)
			performanceData.setMaxErrorSnapshotsMemory(maxErrorSnapshotMemory * 1048576l);		// value in bytes
		
		if (dnsCache != null)
		{
			performanceData.addDNSCacheStatistic(dnsCache.getCacheStatistic());
			performanceData.addTestDescription("*** Warning: OS-independent DNS access enabled. " + dnsCache.getConfigInfoText() + " ***");
			if (dnsPerLoop)
				performanceData.addTestDescription("*** Warning: DNS option -dnsperloop enabled ***");
		}
		
		if (sslECC)
			performanceData.addTestDescription("*** Warning: SSL/TLS option -ecc enabled ***");
		
		if ((downlinkBandwidth != 0) || (uplinkBandwidth != 0))
		{
			String downlinkBandwidthStr = "unlimited";
			String uplinkBandwidthStr = "unlimited";
			
			if (downlinkBandwidth != 0)
				downlinkBandwidthStr = "" + downlinkBandwidth + " kbps";
			if (uplinkBandwidth != 0)
				uplinkBandwidthStr = "" + uplinkBandwidth + " kbps";
			
			performanceData.addTestDescription("*** Warning: Max. network bandwidth per user limited. downlink = " + downlinkBandwidthStr + ", uplink = " + uplinkBandwidthStr + " ***");
		}
		
		if ((percentileUrlSamplingAddOption != PerformanceDataTickExtension.EXT_TYPE_NOTYPE) && (percentileUrlSampling > 0))
			performanceData.addTestDescription("*** Warning: Option \"" + PerformanceDataTickExtension.extTypeToString(percentileUrlSamplingAddOption).toLowerCase() + "\" enabled for additional sampling rate per URL call ***");
		if (debugFailedLoops)
			performanceData.addTestDescription("*** Warning: Debug failed loops enabled ***");
		if (debugLoops)
			performanceData.addTestDescription("*** Warning: Debug loops enabled ***");
		if (debugHttp)
			performanceData.addTestDescription("*** Warning: Debug HTTP protocol headers enabled ***");
		if (debugContent)
			performanceData.addTestDescription("*** Warning: Debug HTTP content data enabled ***");
		if (debugCookies)
			performanceData.addTestDescription("*** Warning: Debug cookies enabled ***");
		if (debugKeepAlive)
			performanceData.addTestDescription("*** Warning: Debug keep-alive enabled ***");
		if (debugSsl)
			performanceData.addTestDescription("*** Warning: Debug SSL/TLS enabled ***");
		if (!sslProtocolVersion.equalsIgnoreCase("all"))
			performanceData.addTestDescription("*** Warning: SSL/TLS protocol version fixed to " + sslProtocolVersion.toUpperCase() + " ***");
		if (sslSessionCacheTimeout == 0)
			performanceData.addTestDescription("*** Warning: SSL/TLS session cache disabled ***");
		if (singleUserMode)
		{
			String singleUserModeWarning = "*** Warning: Single user mode enabled ***";
			System.out.println(singleUserModeWarning);
			performanceData.addTestDescription(singleUserModeWarning);
		}
		if (setUserAgentStr != null)
		{
			String overrideUserAgentWarning = "*** Warning: User agent set to \"" + setUserAgentStr + "\" ***";
			System.out.println(overrideUserAgentWarning);
			performanceData.addTestDescription(overrideUserAgentWarning);
		}
		
		
		// ready to start load test...
		initNull(concurrentUsers);
		performanceData.setUserContextTable(getUserContextTable());
		
		// ... but init first remote interface ...
		initRemote(args);
		
		// ... and check multihomed option ...
		initMultihomed(args);
		
		// ... and add dynaTrace session ID to load test result - if available ...
		initDynaTrace();
		
		
		// calculate sampling offset and virtual user startup offset for cluster jobs (time shift per cluster member)
		int samplingTimeshift = 0;	// value in seconds
		if (!ParseArgs.hasOption(args, "-nosdelayCluster"))
		{
			if ((getClusterTotalMemberCount() > 1) && (getClusterMemberLocalId() > 0))
			{
				samplingTimeshift = Math.round(((float) samplingInterval / (float) getClusterTotalMemberCount()) * (float) getClusterMemberLocalId());
				System.out.println("# samplingTimeshift = " + samplingTimeshift + " seconds");
				
				long startupDelayOffset = (plannedStartupDelay / ((long) getClusterTotalMemberCount())) * ((long) getClusterMemberLocalId());
				System.out.println("# startupDelayTimeshift = " + startupDelayOffset + " milliseconds");
				System.out.println();
				if (startupDelayOffset > 0)
				{
					try { sleepRemoteInterruptable(startupDelayOffset); } catch (InterruptedException ie) {}
				}
			}
		}
		
		
		// start virtual users as threads
		// ------------------------------
		testDurationStart = System.currentTimeMillis();
		performanceData.setStartDate();
		performanceData.addSnapshot(getCpuUsagePercent());
		performanceData.setSnapshotsTimeshift(samplingTimeshift);
		performanceData.setEndDate();
		for (int x = 0; x < concurrentUsers; x++)
		{
			// start load test thread
			// ----------------------
			Thread t = null;
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				S5_SearchbookCdebug2 simulatedUser = new S5_SearchbookCdebug2(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
				t = new Thread(simulatedUser);
				String threadName = "" + getUserContextTable().getUserContextList().size();
				threadName = THREAD_NAME.substring(0, 7 - threadName.length()) + threadName;
				t.setName(threadName);
				if (debugLoops && (simulatedUser.getLog().size() > 0))
				{
					synchronized (dumpLock)
					{
						simulatedUser.dumpLog(threadName + " ", System.out);		// dump log of constructor
					}
				}
				HttpLoadTestUserContext userContext = new HttpLoadTestUserContext(simulatedUser, t);
				getUserContextTable().getUserContextList().add(userContext);
				simulatedUser.setOwnLoadTestUserContext(userContext);
			}
			finally
			{
				getUserContextTable().getWriteLock().unlock();
			}
			t.start();
			System.out.println("# --- thread " + t.getName() + " created --- " + ZoneTime.dateToShortString() + " ---");
			
			while (isSuspend())
			{
				try { Thread.currentThread().sleep(100); } catch (InterruptedException ie) { break; }
				if (abortedByRemote() || abortedByEofInputFile())
					break;
				
				// check if max test duration reached during suspend
				if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
					break;
				
				// display and sample temporary performance data all "sampling interval" seconds - also during suspend
				if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
				{
					performanceData.addSnapshot(getCpuUsagePercent());
					performanceData.setEndDate();
				}
			}
			
			if (abortedByRemote() || abortedByEofInputFile())
				break;
			
			if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				break;
			
			// startup delay for next thread
			// -----------------------------
			try
			{
				if (!singleUserMode)   // create concurrent users
				{
					if (plannedStartupDelay <= 3000)
						sleepRemoteInterruptable(plannedStartupDelay);
					else
					{
						long startupDelayStartTime = System.currentTimeMillis();
						while (true)
						{
							if (abortedByRemote() || abortedByEofInputFile())
								break;
							if ((System.currentTimeMillis() - startupDelayStartTime) >= plannedStartupDelay)
								break;
							
							Thread.currentThread().sleep(100);
							
							// display and sample temporary performance data all "sampling interval" seconds
							if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
							{
								performanceData.addSnapshot(getCpuUsagePercent());
								performanceData.setEndDate();
							}
						}
					}
				}
				else
					t.join();   // single user mode
			}
			catch (InterruptedException ie) { break; }
			if (abortedByRemote() || abortedByEofInputFile())
				break;
			
			
			// display and sample temporary performance data all "sampling interval" seconds
			if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
			{
				performanceData.addSnapshot(getCpuUsagePercent());
				performanceData.setEndDate();
				if (!isRemote())
				{
					synchronized (dumpLock)
					{
						performanceData.dump(false);
					}
				}
			}
		}
		
		
		// wait for test-end in a loop
		// ---------------------------
		boolean allDone = false;
		while (!allDone)
		{
			// test aborted ?
			if (abortedByRemote() || abortedByEofInputFile())
			{
				nearRemoteEnd();
				String abort = "";
				if (abortedByRemote())
					abort = "*** test aborted by remote command ***";
				if (abortedByEofInputFile())
				{
					abort = "*** test aborted at eof of input file ***";
					performanceData.addTestDescription(abort);
				}
				synchronized (dumpLock)
				{
					addSSLCacheStatistic();
					performanceData.addSnapshot(getCpuUsagePercent());
					performanceData.setEndDate();
					
					if (!isRemote())
						performanceData.dump(false);
					if (resultFile != null)
						try { performanceData.writeObjectToFile(resultFile); } catch (IOException ie) { ie.printStackTrace(); }
					
					System.out.println();
					System.out.println(abort);
					System.out.println();
					System.out.flush();
					try { Thread.currentThread().sleep(10000); } catch (InterruptedException ie) {}
					System.exit(0);
				}
			}
			
			// display and sample temporary performance data all "sampling interval" seconds
			if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
			{
				performanceData.addSnapshot(getCpuUsagePercent());
				performanceData.setEndDate();
				if (!isRemote())
				{
					synchronized (dumpLock)
					{
						performanceData.dump(false);
					}
				}
			}
			
			// check if test has been done
			allDone = isTestDone();
			
			// if not all is done: sleep one second
			if (!allDone)
				try { sleepRemoteInterruptable(1000); } catch (InterruptedException ie) { break; }
		} // end of wait loop
		
		
		// mark near end of test - only if a remote interface has been used
		nearRemoteEnd();
		
		
		
		// final test result - test completed
		// ----------------------------------
		performanceData.addSnapshot(getCpuUsagePercent());
		performanceData.setEndDate();
		
		// save test result
		performanceData.dump(true);
		if (resultFile != null)
			try { performanceData.writeObjectToFile(resultFile); } catch (IOException ie) { ie.printStackTrace(); }
		
		// all done
		System.out.flush();
		
		// wait for official end of test - only if a remote interface has been used
		waitRemoteEnd();
		
		System.out.println();
		System.out.println("Result File: " + resultFile);
		
		// now dead
		System.exit(0);
	}


	/**
	 * implement VaryingLoadInterface: support to increment the number of simulated users at runtime.
	 */
	public void setIncrementUser(long startTime)
	{
		incrementUserStartTime = startTime;
		incrementUserFlag = true;
	}

	public boolean isIncrementUser()
	{
		return incrementUserFlag;
	}

	public long getIncrementUserStartTime()
	{
		return incrementUserStartTime;
	}

	public void setIncrementUserStartTime(long startTime)
	{
		incrementUserStartTime = startTime;
	}

	public void clearIncrementUser()
	{
		incrementUserFlag = false;
	}

	public int incrementUsers(int numAddUsers, long startupDelay)
	{
		if (startupDelay < 0)
			startupDelay = plannedStartupDelay;
		return incrementUsersImplementation(numAddUsers, startupDelay, this);
	}

	static int incrementUsersImplementation(int numAddUsers, long startupDelay, HttpLoadTest httpLoadTest)
	{
		long startupDelayOffset = 0;
		if ((getClusterTotalMemberCount() > 1) && (getClusterMemberLocalId() > 0))
			startupDelayOffset = (startupDelay / ((long) getClusterTotalMemberCount())) * ((long) getClusterMemberLocalId());
		
		ArrayList<HttpLoadTestUserContext> addUserContextList = new ArrayList<HttpLoadTestUserContext>(numAddUsers);
		for (int x = 0; x < numAddUsers; x++)
		{
			if (abortedByRemote() || abortedByEofInputFile())
				return x;
			
			// initialize load test thread
			// ---------------------------
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				S5_SearchbookCdebug2 simulatedUser = new S5_SearchbookCdebug2(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
				HttpLoadTestUserContext userContext = prepareIncrementUser(simulatedUser, System.currentTimeMillis() + startupDelayOffset + (x * startupDelay));
				addUserContextList.add(userContext);
				simulatedUser.setOwnLoadTestUserContext(userContext);
				if (debugLoops && (simulatedUser.getLog().size() > 0))
				{
					synchronized (dumpLock)
					{
						simulatedUser.dumpLog(userContext.getLoadTestThread().getName() + " ", System.out);		// dump log of constructor
					}
				}
			}
			finally
			{
				getUserContextTable().getWriteLock().unlock();
			}
		}
		
		// start load test threads by a thread
		// -----------------------------------
		HttpLoadTestIncrementUserThread incrementUserThread = new HttpLoadTestIncrementUserThread(httpLoadTest, addUserContextList);
		incrementUserThread.start();
		return numAddUsers;
	}



	
	// source code of inline script "parsingextractedposter"
	public static String getInlineScriptCode_1462965012672()
	{
		return "MainPoster = strReplace(MainPoster,\" \",\"%20\")\r\nprint \"output from script \"+MainPoster";
	}
	
	
	/**
	* Execute the inline script "parsingextractedposter"
	* 
	* @param testURL 	the context of the executed URL call
	* @param threadStep 	the current execution step of the simulated user (page break or URL call)
	* @param totalLoopCounter 	the total number of executed loops - counted overall simulated users
	* @param innerLoopContext 	the context of the current inner loop, or null if the inline script in not executed inside an inner loop
	*
	* @return the context of the inline script
	*/
	public LoadtestInlineScriptContext executeInlineScript_1462965012672(HttpTestURL testURL, int threadStep, int totalLoopCounter, InnerLoopContext innerLoopContext)
	{
		LoadtestInlineScriptContext inlineScriptContext = new LoadtestInlineScriptContext("parsingextractedposter", ProxySnifferVarSourceInlineScript.EXEC_SCOPE_URL_START, "", this, LoadtestInlineScriptContext.RESULT_TYPE_SET_OUTPUT_VARS, 15, threadNumber, threadLoopCounter, socketPool, cookieHandler, testURL, threadStep);
		InlineScriptExecutor inlineScriptExecutor = new InlineScriptExecutor(getInlineScriptCode_1462965012672(), inlineScriptContext);
		log("Executing inline script \"" + inlineScriptContext.getScriptTitle() + "\"");
		LoadtestInlineScriptVar inputVar1 = new LoadtestInlineScriptVar("MainPoster", Lib.nullToBlank(MainPoster), 1);		// note: parameter no. 3 is the scope of the var
		inlineScriptContext.addInputVar(inputVar1);
		LoadtestInlineScriptVar outputVar1 = new LoadtestInlineScriptVar("MainPoster", Lib.nullToBlank(MainPoster), 1);		// note: parameter no. 3 is the scope of the var
		inlineScriptContext.addOutputVar(outputVar1);
		inlineScriptExecutor.execute();		// execute inline script
		MainPoster = inlineScriptContext.getOutputVar("MainPoster").getVarValue();
		log("<<< MainPoster = " + MainPoster);
		for (String stdoutLine : inlineScriptContext.getOutputStreamData())
			log(inlineScriptContext.getScriptTitle() + ": " + stdoutLine);
		for (String stderrLine : inlineScriptContext.getErrorStreamData())
			System.err.println(inlineScriptContext.getScriptTitle() + ": " + stderrLine);
		if (!inlineScriptExecutor.wasSuccessFulExecution())
		{
			if (!inlineScriptContext.isScriptAbort())
				throw new InlineScriptExecutionException("*** Execution of inline script \"" + inlineScriptContext.getScriptTitle() + "\" failed ***");
		}
		log("<<< MainPoster = " + MainPoster);
		return inlineScriptContext;
	}

}	// end of class

