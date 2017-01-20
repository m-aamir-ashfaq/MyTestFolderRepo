
// *********************************************************************************************
//
// Automatically Generated Load Test Program
// -----------------------------------------
//
// Source: Apica_Https_test.java
// Date  : 24 Oct 2016 13:14:58 ECT
// Author: Apica ZebraTester V5.4-R / automatically generated
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
import dfischer.utils.LoadtestPluginClassLoader;
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
import dfischer.utils.WebSocketPluginInterface;
import dfischer.utils.BoundaryBasedExtractor;
import dfischer.utils.BoundaryBasedExtractorItem;
import dfischer.utils.RegExpBasedExtractor;
import dfischer.utils.RegExpBasedExtractorItem;
import dfischer.utils.XpathBasedExtractor;
import dfischer.utils.XpathBasedExtractorItem;
import dfischer.proxysniffer.WebSocketData;
import dfischer.utils.HttpTestWebsocketContext;
import dfischer.websocket.*;


/**
 * Automatically generated load test program.
 */
public class Apica_Https_test extends HttpLoadTest implements Runnable, ThreadStepInterface, SetThreadStepInterface, SSLSessionCacheStatisticInterface, VaryingLoadInterface, VaryingTestDurationInterface, SuspendResumeInterface, GetRealTimeUserInputFieldsInterface
{
	public static final String prxVersion = "V5.4-R";
	public static final int    prxCharEncoding = 2;                         // 1 = OS Default, 2 = ISO-8859-1, 3 = UTF-8
	public static final String testDescription = "";

	public static String USER_AGENT_1 = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:47.0) Gecko/20100101 Firefox/47.0";

	private static final boolean CONTAINS_PARALLEL_EXECUTED_URLS = false;
	private static final int MAX_PARALLEL_THREADS_PER_USER = 6;                       // default value for max. parallel executed URLs per user
	private static int maxParallelThreadsPerUser = MAX_PARALLEL_THREADS_PER_USER;     // configured value for max. parallel executed URLs per user

	private static final boolean CONTAINS_EXTERNAL_RESOURCES = false;       // note: external resources are typically additional Java library files (*.jar files) invoked by self-developed plug-ins. Consider that Input Files and the Main Class of Plug-Ins are NOT external resources in this context because ZebraTester knows already their declarations.

	// --- WebSocket Object ---
	WebSocketData webSocketData = null;                                     // WebSocket Object that contains data of recorded WebSocket frames.
	private static int plannedStartupDelay = 200;                           // startup delay between concurrent users in milliseconds, see main argument "-sdelay"
	private static int plannedTestDuration = -1;                            // planned load test duration in seconds, 0 = unlimited, see main argument "-d"
	private static int maxPlannedLoops = 0;  								   // maximum planned loops per user, 0 = unlimited, see main argument "-maxloops"
	private static int plannedRequestTimeout = 0;                           // planned request timeout in seconds, see main argument "-t"
	private static int plannedConnectTimeout = 0;                           // planned TCP/IP socket connect timeout in seconds (default = use plannedRequestTimeout), see main argument "-tconnect"
	
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
	private static final String EXTERNAL_PARAM_FILE = "Apica_Https_testExtParams.dat";      // input file name for very large parameter values
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
	private BoundaryBasedExtractor boundaryBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	private RegExpBasedExtractor regExpBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	private XpathBasedExtractor xpathBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	
	private volatile UserTransactionRuntimeHandler transactionHandler = new UserTransactionRuntimeHandler();		// re-used, support to manage user-defined transactions

	private String var__PREVIOUSPAGE_1 = null;           // var declaration from web admin var handler: scope = per loop
	private String var__PREVIOUSPAGE = null;             // var declaration from web admin var handler: scope = per loop
	private String var__CorrelationParameter_3 = null;   // var declaration from web admin var handler: scope = per loop
	private String var__CorrelationParameter_2 = null;   // var declaration from web admin var handler: scope = per loop
	private String var__CorrelationParameter_1 = null;   // var declaration from web admin var handler: scope = per loop
	private String var__EVENTVALIDATION_3 = null;        // var declaration from web admin var handler: scope = per loop
	private String var__EVENTVALIDATION_2 = null;        // var declaration from web admin var handler: scope = per loop
	private String var__EVENTVALIDATION_1 = null;        // var declaration from web admin var handler: scope = per loop
	private String var__EVENTVALIDATION = null;          // var declaration from web admin var handler: scope = per loop
	private String var__CorrelationParameter = null;     // var declaration from web admin var handler: scope = per loop
	

	/**
	 * constructor: called from load test plug-ins (scope = global).
	 */
	public Apica_Https_test()
	{
		super();
	}


	/**
	 * constructor: called when a user is created (per user).
	 */
	public Apica_Https_test(int maxLoops, int requestTimeout, int threadNumber)
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
		if (plannedConnectTimeout > 0)
			socketPool.setConnectTimeout(plannedConnectTimeout);
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
		var__PREVIOUSPAGE_1 = null;
		var__PREVIOUSPAGE = null;
		var__CorrelationParameter_3 = null;
		var__CorrelationParameter_2 = null;
		var__CorrelationParameter_1 = null;
		var__EVENTVALIDATION_3 = null;
		var__EVENTVALIDATION_2 = null;
		var__EVENTVALIDATION_1 = null;
		var__EVENTVALIDATION = null;
		var__CorrelationParameter = null;
		log();
		log("<<< var__PREVIOUSPAGE_1 = " + var__PREVIOUSPAGE_1);
		log("<<< var__PREVIOUSPAGE = " + var__PREVIOUSPAGE);
		log("<<< var__CorrelationParameter_3 = " + var__CorrelationParameter_3);
		log("<<< var__CorrelationParameter_2 = " + var__CorrelationParameter_2);
		log("<<< var__CorrelationParameter_1 = " + var__CorrelationParameter_1);
		log("<<< var__EVENTVALIDATION_3 = " + var__EVENTVALIDATION_3);
		log("<<< var__EVENTVALIDATION_2 = " + var__EVENTVALIDATION_2);
		log("<<< var__EVENTVALIDATION_1 = " + var__EVENTVALIDATION_1);
		log("<<< var__EVENTVALIDATION = " + var__EVENTVALIDATION);
		log("<<< var__CorrelationParameter = " + var__CorrelationParameter);
		
		// initialize context for plug-ins which are executed per loop
		LoadtestPluginContext loopPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, this, threadNumber, socketPool, cookieHandler);
		



		// --- VIRTUAL PAGE #0 ---
		if (!executePage_0(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;



		// --- PAGE BREAK: Test [0] ---
		log();
		log();
		log("# Page #1: l - Page1");
		log("# ------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #1: l - Page1", 1000, 15, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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
		if (!synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 1 failed
		
		// page 1 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [34] ---
		log();
		log();
		log("# Page #2: rappor - Page2");
		log("# -----------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #2: rappor - Page2", 4000, 15, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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



		// --- PAGE BREAK: Test [38] ---
		log();
		log();
		log("# Page #3: AllTickets.aspx_2 - Page3");
		log("# ----------------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #3: AllTickets.aspx_2 - Page3", 8000, 15, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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



		// --- PAGE BREAK: Test [43] ---
		log();
		log();
		log("# Page #4: AllTickets.aspx_4 - Page4");
		log("# ----------------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #4: AllTickets.aspx_4 - Page4", 5000, 15, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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



		// --- PAGE BREAK: Test [47] ---
		log();
		log();
		log("# Page #5: MyShoppingCart.aspx_2 - Page5");
		log("# --------------------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #5: MyShoppingCart.aspx_2 - Page5", 5000, 15, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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



		// --- PAGE BREAK: Test [50] ---
		log();
		log();
		log("# Page #6: MyShoppingCart.aspx_4 - Page6");
		log("# --------------------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #6: MyShoppingCart.aspx_4 - Page6", 7000, 15, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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



		// --- PAGE BREAK: Test [52] ---
		log();
		log();
		log("# Page #7: PayAndCheckout.aspx - Page7");
		log("# ------------------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #7: PayAndCheckout.aspx - Page7", 5000, 15, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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



		// --- PAGE BREAK: Test [57] ---
		log();
		log();
		log("# Page #8: PayAndCheckout.aspx_2 - Page8");
		log("# --------------------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #8: PayAndCheckout.aspx_2 - Page8", 4000, 15, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_8(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 8 failed
			synchResponsesParallelRequestsPage_8(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_8(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 8 failed
		
		// page 8 successfully executed
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
		// # Page #1: l - Page1
		// # ------------------



		// --- HTTP REQUEST: Test [1] <- WEB ADMIN Index 1 ---
		String requestProt0001 = "https";
		String requestHost0001 = "translate.googleapis.com";
		int    requestPort0001 = 443;
		String requestFile0001 = "/translate_a/l" +
				"?client=chrome" +
				"&hl=sv" +
				"&key=AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw" +
				"&alpha=1";
		String requestHeader0001 = "GET " + requestFile0001 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: translate.googleapis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 825
		// content test algorithm: check size +/- 5%, defined content size = 825
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 825, 5);		// Test [1] <- Index 1
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
		String requestHost0002 = "clients4.google.com";
		int    requestPort0002 = 443;
		String requestFile0002 = "/chrome-variations/seed" +
				"?osname=win";
		String requestHeader0002 = "GET " + requestFile0002 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: clients4.google.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0002, requestHost0002, requestPort0002, requestHeader0002, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0002 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/OCTET-STREAM", header text fragment = [verification disabled], recorded content size = 127988
		// content test algorithm: check size +/- 5%, defined content size = 127988
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/OCTET-STREAM", null, 127988, 5);		// Test [2] <- Index 2
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





		// --- HTTP REQUEST: Test [3] <- WEB ADMIN Index 3 ---
		log();
		log("# title: Home Page");
		String requestProt0003 = "https";
		String requestHost0003 = "cldemo.apicasystem.com";
		int    requestPort0003 = 443;
		String requestFile0003 = "/";
		String requestHeader0003 = "GET " + requestFile0003 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0003, requestHost0003, requestPort0003, requestHeader0003, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0003 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 3757
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "function __doPostBack(eventTarget, eventArgument) {");		// Test [3] <- Index 3
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





		// --- HTTP REQUEST: Test [4] <- WEB ADMIN Index 4 ---
		String requestProt0004 = "https";
		String requestHost0004 = "cldemo.apicasystem.com";
		int    requestPort0004 = 443;
		String requestFile0004 = "/WebResource.axd" +
				"?d=SwCcMWJbC5HPR0GyMZBQBtBVcjnGUcMopW87tvl8Uit8R50NU80PEVSNB0QE3yO4B2yncMJIGpp_qLe8p71gNcCZXqg1" +
				"&t=635195493660000000";
		String requestHeader0004 = "GET " + requestFile0004 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0004, requestHost0004, requestPort0004, requestHeader0004, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0004 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5770
		// content test algorithm: check size +/- 5%, defined content size = 5770
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 5770, 5);		// Test [4] <- Index 4
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





		// --- HTTP REQUEST: Test [5] <- WEB ADMIN Index 5 ---
		String requestProt0005 = "https";
		String requestHost0005 = "cldemo.apicasystem.com";
		int    requestPort0005 = 443;
		String requestFile0005 = "/ScriptResource.axd" +
				"?d=KUQ5QzCPc39yQrRqZ09wCtGl2hL_GgfGJ-PRbaHD0ZPg5Y7wt82h9bzxqPdyNS3Kdj6jTkxso_Xb5_mi_Ec-5Zgwzzl2vfDVEVGJ9ijYcDOjY_2BFY1J-emomwl_N8Gdwq_nDltG-WGvBrg50-IYDOnTbN6Wd-jGxg-4uANHXU-hS4ow0" +
				"&t=ca758f3";
		String requestHeader0005 = "GET " + requestFile0005 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0005, requestHost0005, requestPort0005, requestHeader0005, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0005 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 47754
		// content test algorithm: check size +/- 5%, defined content size = 47754
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 47754, 5);		// Test [5] <- Index 5
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





		// --- HTTP REQUEST: Test [6] <- WEB ADMIN Index 6 ---
		String requestProt0006 = "https";
		String requestHost0006 = "cldemo.apicasystem.com";
		int    requestPort0006 = 443;
		String requestFile0006 = "/ScriptResource.axd" +
				"?d=mwTtg_Wai1zwdfVS8DMhG-CJF2EzezlMj6L_5JBaZ6e-vyB4Cowk489gZUKy1uUAINFHmtetDB3NkPofcY8cnG9wlosjKQWLl25xPeuoAl3_k4GiQqqE7HWnKsEcfYH2oW0whNQWHpmGFaTpCg9pJ27SMqxfbOF-RXd1Evl97j2k10k_XL0MxeLe6XJ_eOBsrXqRGQ2" +
				"&t=ca758f3";
		String requestHeader0006 = "GET " + requestFile0006 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0006, requestHost0006, requestPort0006, requestHeader0006, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0006 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 15436
		// content test algorithm: check size +/- 5%, defined content size = 15436
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 15436, 5);		// Test [6] <- Index 6
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





		// --- HTTP REQUEST: Test [7] <- WEB ADMIN Index 7 ---
		String requestProt0007 = "https";
		String requestHost0007 = "cldemo.apicasystem.com";
		int    requestPort0007 = 443;
		String requestFile0007 = "/Images/Banners/WindowsAzure.jpg";
		String requestHeader0007 = "GET " + requestFile0007 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0007, requestHost0007, requestPort0007, requestHeader0007, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0007 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 1238
		// content test algorithm: check size +/- 5%, defined content size = 1238
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 1238, 5);		// Test [7] <- Index 7
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





		// --- HTTP REQUEST: Test [8] <- WEB ADMIN Index 8 ---
		String requestProt0008 = "https";
		String requestHost0008 = "cldemo.apicasystem.com";
		int    requestPort0008 = 443;
		String requestFile0008 = "/Images/Banners/Amazon.jpg";
		String requestHeader0008 = "GET " + requestFile0008 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0008, requestHost0008, requestPort0008, requestHeader0008, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0008 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 918
		// content test algorithm: check size +/- 5%, defined content size = 918
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 918, 5);		// Test [8] <- Index 8
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





		// --- HTTP REQUEST: Test [9] <- WEB ADMIN Index 9 ---
		String requestProt0009 = "https";
		String requestHost0009 = "cldemo.apicasystem.com";
		int    requestPort0009 = 443;
		String requestFile0009 = "/Images/Banners/Lamp.jpg";
		String requestHeader0009 = "GET " + requestFile0009 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0009, requestHost0009, requestPort0009, requestHeader0009, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0009 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 870
		// content test algorithm: check size +/- 5%, defined content size = 870
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 870, 5);		// Test [9] <- Index 9
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





		// --- HTTP REQUEST: Test [10] <- WEB ADMIN Index 10 ---
		String requestProt0010 = "https";
		String requestHost0010 = "cldemo.apicasystem.com";
		int    requestPort0010 = 443;
		String requestFile0010 = "/Images/Banners/Bullet.png";
		String requestHeader0010 = "GET " + requestFile0010 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0010, requestHost0010, requestPort0010, requestHeader0010, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0010 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 405
		// content test algorithm: check size +/- 5%, defined content size = 405
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 405, 5);		// Test [10] <- Index 10
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





		// --- HTTP REQUEST: Test [11] <- WEB ADMIN Index 11 ---
		String requestProt0011 = "https";
		String requestHost0011 = "cldemo.apicasystem.com";
		int    requestPort0011 = 443;
		String requestFile0011 = "/images/bg.jpg";
		String requestHeader0011 = "GET " + requestFile0011 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0011, requestHost0011, requestPort0011, requestHeader0011, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0011 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 130542
		// content test algorithm: check size +/- 5%, defined content size = 130542
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 130542, 5);		// Test [11] <- Index 11
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





		// --- HTTP REQUEST: Test [12] <- WEB ADMIN Index 12 ---
		String requestProt0012 = "https";
		String requestHost0012 = "cldemo.apicasystem.com";
		int    requestPort0012 = 443;
		String requestFile0012 = "/Images/logo.png";
		String requestHeader0012 = "GET " + requestFile0012 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0012, requestHost0012, requestPort0012, requestHeader0012, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0012 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 6391
		// content test algorithm: check size +/- 5%, defined content size = 6391
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 6391, 5);		// Test [12] <- Index 12
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





		// --- HTTP REQUEST: Test [13] <- WEB ADMIN Index 13 ---
		String requestProt0013 = "https";
		String requestHost0013 = "cldemo.apicasystem.com";
		int    requestPort0013 = 443;
		String requestFile0013 = "/Images/img.jpg";
		String requestHeader0013 = "GET " + requestFile0013 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0013, requestHost0013, requestPort0013, requestHeader0013, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0013 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 46192
		// content test algorithm: check size +/- 5%, defined content size = 46192
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 46192, 5);		// Test [13] <- Index 13
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





		// --- HTTP REQUEST: Test [14] <- WEB ADMIN Index 14 ---
		String requestProt0014 = "https";
		String requestHost0014 = "cldemo.apicasystem.com";
		int    requestPort0014 = 443;
		String requestFile0014 = "/Images/Banners/WindowsServer.jpg";
		String requestHeader0014 = "GET " + requestFile0014 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0014, requestHost0014, requestPort0014, requestHeader0014, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0014 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 1408
		// content test algorithm: check size +/- 5%, defined content size = 1408
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 1408, 5);		// Test [14] <- Index 14
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





		// --- HTTP REQUEST: Test [15] <- WEB ADMIN Index 15 ---
		String requestProt0015 = "https";
		String requestHost0015 = "cldemo.apicasystem.com";
		int    requestPort0015 = 443;
		String requestFile0015 = "/Images/cart.png";
		String requestHeader0015 = "GET " + requestFile0015 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0015, requestHost0015, requestPort0015, requestHeader0015, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0015 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 423
		// content test algorithm: check size +/- 5%, defined content size = 423
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 423, 5);		// Test [15] <- Index 15
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





		// --- HTTP REQUEST: Test [16] <- WEB ADMIN Index 16 ---
		String requestProt0016 = "https";
		String requestHost0016 = "cldemo.apicasystem.com";
		int    requestPort0016 = 443;
		String requestFile0016 = "/Images/white_banner_900x25.png";
		String requestHeader0016 = "GET " + requestFile0016 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0016, requestHost0016, requestPort0016, requestHeader0016, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0016 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1446
		// content test algorithm: check size +/- 5%, defined content size = 1446
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1446, 5);		// Test [16] <- Index 16
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





		// --- HTTP REQUEST: Test [17] <- WEB ADMIN Index 17 ---
		String requestProt0017 = "https";
		String requestHost0017 = "cldemo.apicasystem.com";
		int    requestPort0017 = 443;
		String requestFile0017 = "/images/header_left.png";
		String requestHeader0017 = "GET " + requestFile0017 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0017, requestHost0017, requestPort0017, requestHeader0017, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0017 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 346
		// content test algorithm: check size +/- 5%, defined content size = 346
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 346, 5);		// Test [17] <- Index 17
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





		// --- HTTP REQUEST: Test [18] <- WEB ADMIN Index 18 ---
		String requestProt0018 = "https";
		String requestHost0018 = "cldemo.apicasystem.com";
		int    requestPort0018 = 443;
		String requestFile0018 = "/font/myriadpro-regular_4-webfont.ttf";
		String requestHeader0018 = "GET " + requestFile0018 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0018, requestHost0018, requestPort0018, requestHeader0018, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0018 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/OCTET-STREAM", header text fragment = [verification disabled], recorded content size = 49392
		// content test algorithm: check size +/- 5%, defined content size = 49392
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/OCTET-STREAM", null, 49392, 5);		// Test [18] <- Index 18
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





		// --- HTTP REQUEST: Test [19] <- WEB ADMIN Index 19 ---
		String requestProt0019 = "https";
		String requestHost0019 = "cldemo.apicasystem.com";
		int    requestPort0019 = 443;
		String requestFile0019 = "/font/myriadpro-semibold_6-webfont.ttf";
		String requestHeader0019 = "GET " + requestFile0019 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0019, requestHost0019, requestPort0019, requestHeader0019, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0019 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/OCTET-STREAM", header text fragment = [verification disabled], recorded content size = 48268
		// content test algorithm: check size +/- 5%, defined content size = 48268
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/OCTET-STREAM", null, 48268, 5);		// Test [19] <- Index 19
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





		// --- HTTP REQUEST: Test [20] <- WEB ADMIN Index 20 ---
		String requestProt0020 = "https";
		String requestHost0020 = "cldemo.apicasystem.com";
		int    requestPort0020 = 443;
		String requestFile0020 = "/images/headbg.png";
		String requestHeader0020 = "GET " + requestFile0020 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0020, requestHost0020, requestPort0020, requestHeader0020, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0020 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 234
		// content test algorithm: check size +/- 5%, defined content size = 234
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 234, 5);		// Test [20] <- Index 20
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
		// ... continuing page #1 (fragment 2 of 2)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [21] <- WEB ADMIN Index 21 ---
		String requestProt0021 = "https";
		String requestHost0021 = "cldemo.apicasystem.com";
		int    requestPort0021 = 443;
		String requestFile0021 = "/images/navright_h.png";
		String requestHeader0021 = "GET " + requestFile0021 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0021, requestHost0021, requestPort0021, requestHeader0021, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0021 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 183
		// content test algorithm: check size +/- 5%, defined content size = 183
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 183, 5);		// Test [21] <- Index 21
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





		// --- HTTP REQUEST: Test [22] <- WEB ADMIN Index 22 ---
		String requestProt0022 = "https";
		String requestHost0022 = "cldemo.apicasystem.com";
		int    requestPort0022 = 443;
		String requestFile0022 = "/images/navleft_h.png";
		String requestHeader0022 = "GET " + requestFile0022 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0022, requestHost0022, requestPort0022, requestHeader0022, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0022 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 254
		// content test algorithm: check size +/- 5%, defined content size = 254
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 254, 5);		// Test [22] <- Index 22
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





		// --- HTTP REQUEST: Test [23] <- WEB ADMIN Index 23 ---
		String requestProt0023 = "https";
		String requestHost0023 = "cldemo.apicasystem.com";
		int    requestPort0023 = 443;
		String requestFile0023 = "/images/navleft.png";
		String requestHeader0023 = "GET " + requestFile0023 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0023, requestHost0023, requestPort0023, requestHeader0023, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0023 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 271
		// content test algorithm: check size +/- 5%, defined content size = 271
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 271, 5);		// Test [23] <- Index 23
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





		// --- HTTP REQUEST: Test [24] <- WEB ADMIN Index 24 ---
		String requestProt0024 = "https";
		String requestHost0024 = "cldemo.apicasystem.com";
		int    requestPort0024 = 443;
		String requestFile0024 = "/images/navright.png";
		String requestHeader0024 = "GET " + requestFile0024 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0024, requestHost0024, requestPort0024, requestHeader0024, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0024 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 192
		// content test algorithm: check size +/- 5%, defined content size = 192
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 192, 5);		// Test [24] <- Index 24
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





		// --- HTTP REQUEST: Test [25] <- WEB ADMIN Index 25 ---
		String requestProt0025 = "https";
		String requestHost0025 = "cldemo.apicasystem.com";
		int    requestPort0025 = 443;
		String requestFile0025 = "/images/header_right.png";
		String requestHeader0025 = "GET " + requestFile0025 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0025, requestHost0025, requestPort0025, requestHeader0025, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0025 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 272
		// content test algorithm: check size +/- 5%, defined content size = 272
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 272, 5);		// Test [25] <- Index 25
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





		// --- HTTP REQUEST: Test [26] <- WEB ADMIN Index 26 ---
		String requestProt0026 = "https";
		String requestHost0026 = "cldemo.apicasystem.com";
		int    requestPort0026 = 443;
		String requestFile0026 = "/images/right_banner.jpg";
		String requestHeader0026 = "GET " + requestFile0026 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0026, requestHost0026, requestPort0026, requestHeader0026, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0026 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 8180
		// content test algorithm: check size +/- 5%, defined content size = 8180
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 8180, 5);		// Test [26] <- Index 26
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





		// --- HTTP REQUEST: Test [27] <- WEB ADMIN Index 27 ---
		String requestProt0027 = "https";
		String requestHost0027 = "cldemo.apicasystem.com";
		int    requestPort0027 = 443;
		String requestFile0027 = "/images/footer_mid.png";
		String requestHeader0027 = "GET " + requestFile0027 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0027, requestHost0027, requestPort0027, requestHeader0027, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0027 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 212
		// content test algorithm: check size +/- 5%, defined content size = 212
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 212, 5);		// Test [27] <- Index 27
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





		// --- HTTP REQUEST: Test [28] <- WEB ADMIN Index 28 ---
		String requestProt0028 = "https";
		String requestHost0028 = "cldemo.apicasystem.com";
		int    requestPort0028 = 443;
		String requestFile0028 = "/images/footer_left.png";
		String requestHeader0028 = "GET " + requestFile0028 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0028, requestHost0028, requestPort0028, requestHeader0028, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0028 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 445
		// content test algorithm: check size +/- 5%, defined content size = 445
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 445, 5);		// Test [28] <- Index 28
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





		// --- HTTP REQUEST: Test [29] <- WEB ADMIN Index 29 ---
		String requestProt0029 = "https";
		String requestHost0029 = "cldemo.apicasystem.com";
		int    requestPort0029 = 443;
		String requestFile0029 = "/images/footer_right.png";
		String requestHeader0029 = "GET " + requestFile0029 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0029, requestHost0029, requestPort0029, requestHeader0029, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0029 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 427
		// content test algorithm: check size +/- 5%, defined content size = 427
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 427, 5);		// Test [29] <- Index 29
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





		// --- HTTP REQUEST: Test [30] <- WEB ADMIN Index 30 ---
		String requestProt0030 = "https";
		String requestHost0030 = "www.google-analytics.com";
		int    requestPort0030 = 443;
		String requestFile0030 = "/ga.js";
		String requestHeader0030 = "GET " + requestFile0030 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.google-analytics.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0030, requestHost0030, requestPort0030, requestHeader0030, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0030 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 16022
		// content test algorithm: check size +/- 5%, defined content size = 16022
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, 16022, 5);		// Test [30] <- Index 30
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





		// --- HTTP REQUEST: Test [31] <- WEB ADMIN Index 31 ---
		String requestProt0031 = "https";
		String requestHost0031 = "ssl.gstatic.com";
		int    requestPort0031 = 443;
		String requestFile0031 = "/safebrowsing/csd/client_model_v5_variation_0.pb";
		String requestHeader0031 = "GET " + requestFile0031 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: ssl.gstatic.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0031, requestHost0031, requestPort0031, requestHeader0031, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0031 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/OCTET-STREAM", header text fragment = [verification disabled], recorded content size = 69547
		// content test algorithm: check size +/- 5%, defined content size = 69547
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/OCTET-STREAM", null, 69547, 5);		// Test [31] <- Index 31
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





		// --- HTTP REQUEST: Test [32] <- WEB ADMIN Index 32 ---
		String requestProt0032 = "https";
		String requestHost0032 = "ssl.gstatic.com";
		int    requestPort0032 = 443;
		String requestFile0032 = "/safebrowsing/csd/client_model_v5_ext_variation_0.pb";
		String requestHeader0032 = "GET " + requestFile0032 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: ssl.gstatic.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0032, requestHost0032, requestPort0032, requestHeader0032, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0032 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/OCTET-STREAM", header text fragment = [verification disabled], recorded content size = 69547
		// content test algorithm: check size +/- 5%, defined content size = 69547
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/OCTET-STREAM", null, 69547, 5);		// Test [32] <- Index 32
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





		// --- HTTP REQUEST: Test [33] <- WEB ADMIN Index 33 ---
		String requestProt0033 = "https";
		String requestHost0033 = "cldemo.apicasystem.com";
		int    requestPort0033 = 443;
		String requestFile0033 = "/images/green_button.gif";
		String requestHeader0033 = "GET " + requestFile0033 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0033, requestHost0033, requestPort0033, requestHeader0033, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0033 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 154
		// content test algorithm: check size +/- 5%, defined content size = 154
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 154, 5);		// Test [33] <- Index 33
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



		// all http requests of page #1_1 successful done
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
		// # Page #2: rappor - Page2
		// # -----------------------



		// --- HTTP REQUEST: Test [35] <- WEB ADMIN Index 35 ---
		log();
		log("# title: Error 400 (Bad Request)!!1");
		String requestProt0035 = "https";
		String requestHost0035 = "clients4.google.com";
		int    requestPort0035 = 443;
		String requestFile0035 = "/rappor";
		String requestHeader0035 = "POST " + requestFile0035 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: clients4.google.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Type: application/vnd.chrome.rappor\r\n" + 
				"Content-Length: 0\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0035, requestHost0035, requestPort0035, requestHeader0035, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0035 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 400, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 1555
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {400}, null, null, null);		// Test [35] <- Index 35
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





		// --- HTTP REQUEST: Test [36] <- WEB ADMIN Index 36 ---
		log();
		log("# title: All tickets");
		String requestProt0036 = "https";
		String requestHost0036 = "cldemo.apicasystem.com";
		int    requestPort0036 = 443;
		String requestFile0036 = "/AllTickets.aspx";
		String requestHeader0036 = "GET " + requestFile0036 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0036, requestHost0036, requestPort0036, requestHeader0036, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0036 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 6329
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "option value=\"FC Internazionale Milano\"");		// Test [36] <- Index 36
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





		// --- HTTP REQUEST: Test [37] <- WEB ADMIN Index 37 ---
		String requestProt0037 = "https";
		String requestHost0037 = "cldemo.apicasystem.com";
		int    requestPort0037 = 443;
		String requestFile0037 = "/Images/Wait/spining_wheel_notrans.gif";
		String requestHeader0037 = "GET " + requestFile0037 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0037, requestHost0037, requestPort0037, requestHeader0037, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0037 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 6337
		// content test algorithm: check size +/- 5%, defined content size = 6337
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 6337, 5);		// Test [37] <- Index 37
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
		// # Page #3: AllTickets.aspx_2 - Page3
		// # ----------------------------------



		// --- HTTP REQUEST: Test [39] <- WEB ADMIN Index 39 ---
		String requestProt0039 = "https";
		String requestHost0039 = "cldemo.apicasystem.com";
		int    requestPort0039 = 443;
		String requestFile0039 = "/AllTickets.aspx";
		String requestContent0039 = 
				"ctl00%24ScriptManager1=ctl00%24ScriptManager1%7Cctl00%24MainContent%24CheckGamesButton" +
				"&__EVENTTARGET=" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=eF%2Br2G3J6%2FjSI4pJyb%2BXvTzKIzJUy8eY04Cui0MZzq%2FlrSKkK%2BNhUQk%2F5%2BRX0w9Fz1zBcOCmm47EDpLVkjVJKeTi%2BnhDSRrZnS8XUqzcrPNmapRCA9gzWWFRqP9cqmlYlv5H0iHMEBzsL70yhE1bDEq%2BiAKTNvEJ5KC0HwqO5Jzyh5IIuDD5%2FTULNa9w9VyiisXfMRU3OKnVweZo5zC5VzgZrFkEy9VEfZKSjHHihbjQ%2BRsJZvNpyc9KicpInqkg9zslHCsYggBz70Nzv6wn%2BFnnUSRgFWlkvJkxxxCXx0hj8Hmit3ecgZYSXps4zbM%2FShchoOk6Jq6q3zBDbcJTIxbiPHZMvEcjGDlyEhKcS1RAj6bKej9qE%2BnJ457vW1riroZ5MqCPuDFC5DSi6Bf3WCtiJ4FcgskiBdhIO8He1e3%2BRIzj4vRFnl%2FaNBq936EmyciYa1fZcNuw7Gx4y9BNH9Dj%2BGHOzEMd63oBdI3FFZuWlA4eIpB%2FfbOdk92p%2F%2BKG%2FyPk065TxDjbEdDqLVYhrxNsfctN18G80jp7oawfnnGcDTjvkkTqqoAC%2B5pJQybXTIwoiNYl3AkcotA%2FYq%2B%2B0ePpKX%2FFgIhiPaBjmiNPG%2FxnBzYdIm1GyFDMPtxBkyb%2FWGpZXxuSqf0ZdjIAewA5sHJZ%2FML%2BSugNnw2cYyqaBJvyPSaviA3G6VxAI4%2FgnO0t%2BHchi6vJzGjZR6W7fxYevXAUyVKvmzbH1BB5kwqnlgYHyj61shrPkUaAzWR5D%2FZx6vxlokkyTTX4mnojm6SSqVIoeT0PCsqMxnlEWLleu1eGUTBhi7QVTCF8oUbpZ6r0wqnxx6c81tAiNukGwKy1k5TobImryJu8EU1SEsL4W%2FivnTGsxVZJIe0hSvmgJWqrqmTHsDmov4%2BKfvgF%2BZ8rhERPEnVMysQQsp%2B0M1%2FTlHkrqo7PZK%2Ffq%2Bw4uGOZ8%2FDWRmjJWN7b358lvLsDUu5mpWOCUqb4MVd13byfMiufso%2FgCeDtLOmLZDgaTcvBWyW9fyaM6W6wx9zHC5sqUf6RlPCyyYek%2BiBkJ0UBvV2Bcdlc8oqwPTrZVhGskbp8mx8PuHiXeyFlJOWlk%2Br5ugLc7oGt5YntGKrxLtKwFllmHJ87xGIjn202LjKCmufBBykXxtl1PcQQREH5xs%2Bls4ZJnUg3IZhDGSB%2BYUEhg2bBVQySGV7mX2PSwTeKWENCS24RhtTGlcw9yZzUjx0q5SkfPms0JiE90AybU%2Fr%2Ftsi4F4GqG5ZJOL99hSkmlJzqM%2BbyoGfUtkieoWn8V2xfMxvAOOWzHnxPNCgWI%2BfV41oWykUvGld6Ol4sWN8qc%2Fx5EzRxCsMSOK6kcMKTBsy%2FHF4Oj2T0nPadSoYWidNboHOHR1PXwc4ollkZc%2FJxVKwWJXWWwfWat%2BqPyESmM%2BU4CaxosTMwgyFjL6D96vXmPaeJFUgWtlGw0MGkCnJzw2IUqICOKbXd%2FpJsK9pFoQevmMObww0q%2FCrdhtMb%2FW5Z2ls%2BuI4vGb3xf%2FJ9oOjBXAi7%2F2m1%2FjI%2FihCuD0RFNf0N3N%2FM923Irz6cDpE5CGDM4neJccJxJkzE9YhKkv%2FHKE4Ry7Xbv0FeW3YIMDMVFOPxk9WLFdVOfOHLrjT8MfCJ6Fg8zlX%2FBHbIgsEjgNPGy78dQYdDLQxVR7AwQ%2BwXaLJqfjlsex2IWDy68SazrMptVBk5oE0rm64008kdcGVwGunhCB4DjkD4Q3%2BPxhV26ApWN57tqqxk34MLwvkM9xdjdg81K2fyjjlxvHS%2BO0%2BcTSgHqDI3PtatTt%2FE%2FYv34KLPuLaxuHiVbWD3yGz4qW6yaVYcJqU1jqnIoWfr8EYtdhmLajXhy2ahSnkLxfMsQztoDylL9TYxaXM%3D" +
				"&__VIEWSTATEENCRYPTED=" +
				"&__PREVIOUSPAGE=ZLR5YJNgG_28z3wT_GJVe5VIuhNO4AuAkO5rVgyrhVAbfEkZAmZsfgGhmkjyFFgJp_-2Gi9syvmlGt14SlVDfS6S4XQ4ds_n1K_mI_0jsbSSOGHC0" +
				"&ctl00%24MainContent%24TeamNamesDropDownList=Arsenal%20FC" +
				"&__ASYNCPOST=true" +
				"&ctl00%24MainContent%24CheckGamesButton=Check%20Games";
		byte[] requestContentBinary0039 = requestContent0039.getBytes("UTF-8");
		String requestHeader0039 = "POST " + requestFile0039 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0039.length + "\r\n" + 		// Content-Length: 2439
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0039, requestHost0039, requestPort0039, requestHeader0039, requestContentBinary0039, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0039 = null;		// support garbage collector to reduce memory
		requestContent0039 = null;		// support garbage collector to reduce memory
		requestContentBinary0039 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 5143
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, "|83|updatePanel|MainContent_UpdatePanel2|");		// Test [39] <- Index 39
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





		// --- HTTP REQUEST: Test [40] <- WEB ADMIN Index 40 ---
		String requestProt0040 = "https";
		String requestHost0040 = "cldemo.apicasystem.com";
		int    requestPort0040 = 443;
		String requestFile0040 = "/Images/gr_button.gif";
		String requestHeader0040 = "GET " + requestFile0040 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0040, requestHost0040, requestPort0040, requestHeader0040, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0040 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 1179
		// content test algorithm: check size +/- 5%, defined content size = 1179
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 1179, 5);		// Test [40] <- Index 40
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





		// --- HTTP REQUEST: Test [41] <- WEB ADMIN Index 41 ---
		String requestProt0041 = "https";
		String requestHost0041 = "cldemo.apicasystem.com";
		int    requestPort0041 = 443;
		String requestFile0041 = "/AllTickets.aspx";
		String requestContent0041 = 
				"ctl00%24ScriptManager1=ctl00%24MainContent%24UpdatePanel1%7Cctl00%24MainContent%24GamesGridView" +
				"&__PREVIOUSPAGE=ZLR5YJNgG_28z3wT_GJVe5VIuhNO4AuAkO5rVgyrhVAbfEkZAmZsfgGhmkjyFFgJp_-2Gi9syvmlGt14SlVDfS6S4XQ4ds_n1K_mI_0jsbSSOGHC0" +
				"&ctl00%24MainContent%24TeamNamesDropDownList=Arsenal%20FC" +
				"&__EVENTTARGET=ctl00%24MainContent%24GamesGridView" +
				"&__EVENTARGUMENT=Select%242" +
				"&__VIEWSTATE=UlAlnkVlcyLPjdFRpN0Z%2FjKO6O9qX81guzgeYo2sQGtXIEwyD6RH6TPXCsxBeHjS%2BoqLU1D%2FBtY9Zi9l1fwJ0Q4g7vNShWv%2FpA4%2FGgcmyMQ7JMQCkTIGC8RlvXkFFTgzkfeScOEbCFmcp3ZoX83poKa%2B1HJg3DXGFZgdjlZEsvztOf7w4uAjW4WKShNpwDWQiq3HPR8mViAQxTHbHdZI8132w4BG3RsypzBkHAX0J3Htsu%2Fr24e4EEQNv19XFqCP8nLxLdfE4wp6PvCpUFi2iX0cNt2suFqwZJDWcSyRLLXPQQe7Z4sTvr5xil8zXCOSPytdWPl%2F7Px01B0DUTsUxx6SiIgEY3oYRnsEfXoEv1oGjEqXAi6hM41cacyC8WtIJXI4i%2B8ndNt30cVTWz1kr%2FvSc5c%2B95Tkx9isucH2tpy%2FEmyC9J89GtgXSHNwZJsYdvq8J1grXxri%2FAx40AZhR1lCZPSeZMC5f8moPbieLKHgKFVTSzbC%2BcVhoy9B0KrS8L8U25edZZq%2FlmCys2%2FqwqRjdb%2FfD25OT%2Fpf5Ii%2BW1MyoYOR7LgiUVqyrocgg2Gld1rpWG%2B1c0i8OwgLlL04iGbaruDEiZc6BABjiD5ix2yJdo1apC%2BxenHDygnZEx224MKPUFZ6yUHKSQs%2FLGJbPjT2u6FAmgVv%2FwqrMdChvL4%2FZ5Nm%2B4BkbIwZL6NKFZM%2Bytz5ATLENxqjKY8ZsZaiYxF2bGXfly3o1nsj6rd4eaJiwvnetOLnI21kt5RrtWsZOLInQpKqu9sDFybgiw2yuC71EV%2F8BFISu0PxOkvdjhRUpWtz34O16aTt7Hjc7JSRRiChAIuZ%2FVE582museFSpiYuys0iERkWqvB%2BpQ8OMvKIi%2FLdfB268CRzZCmwba03ySa1g%2BVtqbfUd9tRkGhqL9ZWHaPeJFebwRQqQdPu70Vy3k0obCKpwav3FruLwJF8bPkRvSF0u9Raia3WMPs1n3QCCiViEyJSeNLmTZFf5kEwtEydMWm%2BjeDgz6WagOZZ7qcFVDXO%2F9c2LxQmJfE5yA4DQvO6WH500umLNfVnf%2BM95U0ry1BGhMW%2B%2BYZaH4pIuyr%2BjwW2SkCeNm9SFTGcq4oWjxE7AWGP7a9EKepdwPttTwCBArvMzQaV9HGNYZX4NMbraaA7jtgUvBPgdumFMRWJjIls6HmNG6F%2BeO5c%2FI0XxS6qUijOq4HFoxmiOKRt4y9PJLK9lJWEf8JML4cjrknI7nDE%2B8KaZIF9ym5Qz62bwkushvNHadDyWqTJSw9EDHOiCXzRsq6yQnB6hIxGCGZXyiLBJCOPPivs77h1vd3T%2FrEL9NWRUqx%2FyeqfY4qJmprzFurHxcd%2FXJnGXOi7HSXVZ%2FTakjgo6a214ju1hMq7OjobrKb4MMiy8O9u%2BW9YrZ6euOovK2lJDxPDf4WXUGboLPa4P7F4%2BKiQpCXNYL6hQ5eyuMDwmeKfPnolCbya6Wk2t2EllWYDkohkaq3pr%2FdhM9c%2Bowih6S7LqJK5fNInuS89Sqe%2FpC3eMe2MxI6ytZ%2B81Q4eLedgpT0PVhCTWlI2bo0kwV1CjbPZ3FTNYbIl9jivj4dCtCDQTGmDJ7%2FT6E70DJ8vHqa1ZUmWvhL7QrJDxYnekalZErIwVCQY7MWVvTgdJaR7Qofih72GSCPQzG8oRgk1%2BxJlHaveWHRqyMS4wftNn4R%2FUV4qT06gXvvALT2lwAdqhW91PoOkrleL%2F3NxHf8XLBWHEnw7wu6%2Fc%2ByNmSeg4cdAywZoFanZro74OBaYBBezxocWqfYj3%2FzBq8ecwNYW5Ao1UHGqmULjYg%2FYLDxjuCKslZ%2BUnHPpRzbJO9%2F1BP1hrPD82OcJz5PwJlwv1rUubJ0wa%2BWkme1%2FpZgQlYYORU79vOdtIgoZW5aAd8htYh4CicRsfbPSeG4uixhXRjW35rgeX39N6qtAREygk4IUyf%2BpuHGhJjaCQITbvx1p3ZomzVSiy3URdGy3VgsESVQFzhQJ66F8iSjuYlL19s7YkoR11qkaVJRHod%2FCDvAlfUs4v0wIB4XWQdvQGjKsoUmO5m78EalY8l7vBa5%2FAXXsKiZrrdmJQ28VV98yx2eh%2FSjdW1OqbXLQVnmSQRgJ4VedLAZM6m083ZzlkzdphKA4eYYaaOpK7b57ca9znDHY93hx4BItHvqCUx9Q02BZaZlJmhfqtsNKvs%2FYYfzJLfNOaMjwKVWzmQwRRaVjX0LrvqPvMS9lJj7oEr0Oi7MWauWM3sGqN48i3fomzewFGYZNcWgZnUfPZLVVpvp0EhOX58%2BXCiZDNMVogfbSc66RKGZqItVS3nMp9Owlj21AOy6f%2BCoBGpsRLXmkGT4yJoZHbnGNxfkr9lBe08cv8huR%2FGxQzBeT65WDvhOCiYlhU54XwC49gaenV9UjnY09%2BsYALslRCeyMJEGXP03bTdnpdBb5nID%2FMDWf%2Bv%2BLi6XBGMHBWQnNXR7dnJqr3%2BmkZGhAsByMRiyYdEtgGA1d3DiRgeRlPyIMsYSVUu11hltQt9%2BTHGhMfP8E8rC2pW0lkhjFfN9a2klE3t%2BH1%2B%2F%2FTikrzGgujNVBiceW3wr9OgiOQs2oQAK9uGTYscVJ1ulbWqg%2Bf%2ByFb4zGvgUfdKYHg4zUqKzoEOb%2FxfetO0JdHgY%2FJ8Dp5bFvO6zLJeYO3ljuxx8OwQN1n2W%2FMX9wbsqhwv4NPydislmW8ic%2FgwLHII50gGjecfuXusXwOBA94QcJPo19PEOes0JNl1EAnipjWhwW1YtOsvSLglJsa8Ky5SgH%2FdGgAz9YagBI41VmBTe57xcboWH24%2F6a0FZZR5TEjEmKabG0lTWzUiMzoOhknpW2nDWWJUeYC0C1TI%2F4u8PZuM50Gcx85vvpqiaJ6Is6J6X96V%2FolTxkOfu6y8fscaYKdoSZlzomSI8yj%2BqZnuo1RSAEWfOfonRXoskBkgipL6SE1rDe65eizDVf00RUMhHRJ9hbXC6XlJcqDjHVBF9T8UwoOSCHbjHmmmpU9geDt5p0n0Zx%2Fme7vq08DkLLk89G59F5CLw8GWtc4p44DrzwCJxs8%2BY2alJntH%2FlK3Rc8JOdVIpDI0xj5yATGbNEWaYfKpkpsHkAYfH0cAxX%2FPmbpTBQoB3fdPk3yoDY5NV2SU%2FOFFkE6S4tFl%2B9KMbzUuFKlAWX1pnod0LJZHByVse0f8Wbh%2FwVNHGEefByhx1ypqNQAM146cyOWLPcT9gTtDjTvpeD1JBo4%2Bv0bOrZHGq8Elz7NH93WfFwgrSdA1GkK2VQi%2F2hglXXSSY5XtJRSNrkWEDbIQCNx%2FjEKkWdtgTa1voJM%2FXr0s%2BrrJZ1SLuJ47fejUCVe%2Fdi4bb0Y27GqlqVqB9s3Atyvx0eEm0bDM7c45TY3BegWall1wshF3tJKhxqtBuYVpukbSQKrqdteAG1W5P5SP31AAGRKGRvPvH9eqpJ7MKwMKCsDx9WF%2BeeaFwHlGruVQz%2FDfi3h%2FnzNGgW7Fr0EHi%2FJLbYJUGzysG7jg49eXKw3y1B1xXC73ftA3rc2URfYG%2FONjzsLeHFvYcpgpSDYroXU%2BzQpGlkhscOkqr6k6OkGPZQ51RbdWdo%2F3bn6dLgx%2BStGKC0QEmMhoFeIhjIZ%2BrCxDoIMPDS21ddsVvb1xLdF5duHOfFsPKFLSkRNNgat%2B58e4c68oDsH6xVJNA%3D" +
				"&__VIEWSTATEENCRYPTED=" +
				"&__ASYNCPOST=true";
		byte[] requestContentBinary0041 = requestContent0041.getBytes("UTF-8");
		String requestHeader0041 = "POST " + requestFile0041 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0041.length + "\r\n" + 		// Content-Length: 4317
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0041, requestHost0041, requestPort0041, requestHeader0041, requestContentBinary0041, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0041 = null;		// support garbage collector to reduce memory
		requestContent0041 = null;		// support garbage collector to reduce memory
		requestContentBinary0041 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 6198
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, "span id=\"MainContent_SecondaryAvailabilityLabel\"");		// Test [41] <- Index 41
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





		// --- HTTP REQUEST: Test [42] <- WEB ADMIN Index 42 ---
		log();
		log("# title: Error 400 (Bad Request)!!1");
		String requestProt0042 = "https";
		String requestHost0042 = "clients1.google.com";
		int    requestPort0042 = 443;
		String requestFile0042 = "/tbproxy/af/query" +
				"?client=Google%20Chrome";
		String requestHeader0042 = "POST " + requestFile0042 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: clients1.google.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Type: text/proto\r\n" + 
				"Content-Length: 0\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0042, requestHost0042, requestPort0042, requestHeader0042, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0042 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 400, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 1555
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {400}, null, null, null);		// Test [42] <- Index 42
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
		// # Page #4: AllTickets.aspx_4 - Page4
		// # ----------------------------------



		// --- HTTP REQUEST: Test [44] <- WEB ADMIN Index 44 ---
		String requestProt0044 = "https";
		String requestHost0044 = "cldemo.apicasystem.com";
		int    requestPort0044 = 443;
		String requestFile0044 = "/AllTickets.aspx";
		String requestContent0044 = 
				"ctl00%24ScriptManager1=ctl00%24MainContent%24UpdatePanel2%7Cctl00%24MainContent%24AddToCartButton" +
				"&__PREVIOUSPAGE=ZLR5YJNgG_28z3wT_GJVe5VIuhNO4AuAkO5rVgyrhVAbfEkZAmZsfgGhmkjyFFgJp_-2Gi9syvmlGt14SlVDfS6S4XQ4ds_n1K_mI_0jsbSSOGHC0" +
				"&ctl00%24MainContent%24TeamNamesDropDownList=Arsenal%20FC" +
				"&ctl00%24MainContent%24WipAmountTextBox=" +
				"&ctl00%24MainContent%24PrimaryAmountTextBox=" +
				"&ctl00%24MainContent%24SecondaryAmountTextBox=4" +
				"&__EVENTTARGET=" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=RRi%2B%2FG8fLKP%2BFYnqXvUt5lnQmgkFCCQnuUBzt8AvkGv3rL3lPMSrqJGo3kfrGXF78AF6GtRO4CAh3zVuE7%2Fbg3hlkFZzuU8GncCBxU%2BNxJGly0bSEg4UsgTJlhYD90VuGlJ4PXHS9wTKW3sCIM%2BZPkH0igGqk9BstVyrGmFZIU5npMUoVhLY%2FOfkvwaqb6fx2eezPkVGrFmsv7kE%2BjZJlcgU%2B%2FJlbWD7ihdULDsPrRO%2Fw2tYWFYt0kjNkct0xRBlu%2BFw39I1xPNQywZN7dRxWTkJn9Fzo1E8WunVtWZQLLO8LPOBCOdbe9MzwFEfwYkRRtmU2yk04Oun4v%2BRIZ6g6cHVq1IKAXszXXDlS9cpzbLfwumysUodltMHi0N%2Bae1%2FF2hXPbtjZwaXq8r33GW8pHwv3yskEqJRo1f8SjrKgPT7U%2BofpX2%2BFix7oLiz%2F87s48VcN8U5Z8Wy7VuhI1WJDsB5wlOyiVInmzKuToxGcjXfZM23oWsBI98V7qAbGYtnEF1K5j75r6oqMj923qww5vA9LqOP3xiPy%2FoifziD%2FnR2mlwJgZkWQWMDQZrwwMzW2rQyI2DldbnIeNgp1w8DGzxBHefgQpA7WofRCdw9y5tv%2ByNIW4XcL4AvUX2f7gq2Kr6gMif9jyfmCZcsc81urOXVlRdYr%2BVg0GVzwkQCugUhyPmF8T6KDY31tLelWPglsC4GMiP7WoIzBTWytPv2SK0Re5twfLEsEIwh8o4l5AHWBJtkh8Cl6XqtJZJUFuccfgcy9lmqvCkBSoVJP6rxZ0qDULlPid0An1ckgQrbT28j4mWKD3Jjg4BUEbSjLM7NFTor18P0VWFJqxNBnzcI%2Bi9pX93W3%2BzaPxKFC9ngk2sbodjnj8xxF3yarjDndDWmPO8B5vsmTqegUAZ%2FonZV5EqE46WQNcgUQ%2BtkmBJqCAVop5T2O5jhbQe4Z64PRmafh01F170rWiJF3MNYiQ3FLw21unyAfz5vfN4QeaS1Uy%2FfLdKJiAfNs3FqXZeo9GWbwy0FaFGdgr%2FSCx4IbMwxkYovsF7gSNP%2Fuf0mn1y1eS8t6VU0TpEGJlbbjg%2B0s1Lo2U3lBss3PS8BmDmkdmwo0FNdVlZXmdLBcpYH9iKAHzVixe94fXuetztoTbWcwnqnH65nVjtGKECWK5HK5%2BZ%2FhgCHfGJBkmrHZhUS7NkyblLEx5f%2FyYO3Xm4XaZzUwNtNyeGDoH9q%2FGHlgITaa7TH76DUFrzm9noiL20S8%2FhqY6vcLbbmsA5yYBDPfHKt9k9gRtUo3Hs8nIJ3cvjfCs9OakqYovwDC2ThVQChtZvEmB%2BKXLo%2Bqz7IvM%2B%2FJeHBzJa3eiWdkNxq52QGPJ6iV8dE9eV%2BQ5KGnvL4SestIMV3Ic8gWVeXWMCpWNfhEgmBwdoCbF38k3rQELotKZ0yhpDIa720DLnld3WrfIrD8teuvy5Xcgb4Ma6Q%2B%2FsUE10vd%2FBOHs2D4HZacbuRhgOhvjzeqkLvcOYeiLohdri9jkh52HippEN6B0%2FRdQ1ee8znlZfdWShq4yLNeOBWPIWVd8QSvvtqtM8MxbNl8Vh5aQLIeNtsev8I5%2F59v7wxe6QKbHzWu1fPG9kO5wNwGnysLvd5CaSDQaX14OBjwQq3I1gcrrp8BXqKpBLuBM9y95AjhbmaMhIi2CKisTCTEiQSSWpKWBIXk0zjzH%2FtywiBoa0ZnNL91Dq6auJgHo%2FvCYI%2Fp44ctD0qMZ7puCHPxzf37afnQKSKNhzDhPWNOARXjYGpld81ipA8FOwlrlfKT75EyUKaZqtONKnjM7fmVkyNz%2F%2FzWaMoxbPGt5CbPXe3d%2FYaGvnspittDSu6dcW%2FVDOpbKgBvo8p1MlMd4hCTEDaRJOiBLl7yevf5tG42BYV5rgZwpUUKGuFq2lnsVCzpoDi8qFb2YVFsCwC6tKoXbW%2BVHx56qsKuLetNFy9qoxVHk0UWPMzJoAuZ%2Fi02BV2HVZECB%2BSWDSS4d%2FPVxkk9VGjpl0XbwpRUM5rurgnzw%2BMKWRTQBl6VILiLG39CK0KhpdzxntSAZChMQRU6O%2BRlVcyRPBN6SsSUdos%2Byk9G%2Bp44drb4FNYfNMaJO6Td6rAeRhvyWrb74JTvf4VUoLbITgOqxwAflcHKH49Tew3eMFxmz8fkl18w6brQX3WxjlxOK7J%2F7lajP1J89XsHlPxV7896bFDaAlDHiVqKC2hWErcvgokd3VixJdrjvASsaQGylQY15of1SmdL6KHKS2%2B6%2BQ2I%2Fy78JnG5mMXJ3kEE1jgHSQmOfY%2BPzubftxQHoyUwf5KlNoAVDfntPwtiGKJU4BCtgrJJBVPIaDgvSu%2FUvlvH3aainflb1M27n6LyVaxqds%2F%2FmRkx1yeEsb1yvIpL3h%2BmThJUWU5ESn%2FjoNo%2FMZ%2BKGlmUvPG5yjv9UCxkOJ3ZwDc1Ng5sZG9T81eOIfftTSlWUrbRpTGbqpyyxGldpxYr%2BA4nQtznGlCJaThXZUiTKH%2BdlpVVRIftdzYzxAoZvmPJt4JiHBWe35PkPMuCAlayBlVgkEtpvKrEYgCFz7hASEF1mDg0EvdaN3PdmQb285NhqSDW3%2FUDTQdSnIcRBsBlmqkOlGhUm3esdNcNfbY3jBjCOka6xEId3YPwrBBsHPY09io1pt4NhvJHJBvOS0R1M1yzRI4VfhZK5HkSaIF5Q%2FvGKAkAgjyzmXwqdJFzNWZWIakrlIMRwkxOYPmWQm1ztGv37uO4e6woWMvS6y5zSjDD5X%2FL3t7FrUF7yF%2FMdJf7l4aATO37Ttptk0SIQNPQkcByVDMFQdwub6uiZkWCeLydLjWSEB6X5kDZGw6coZewVXk7yrtAIHmpRlLm%2B1vkTEClWnK43HFkcJmLSfgYj3YTGtjLFGxzEkkLFnLKZMDeTsRvWxTAYoljD7sHdr%2FXMXBC%2BQdJLs%2FrKVxLFDTn5ko3T4Lg8iUcNknyILlo0n6SgJpYYPDd0Wv20u5kbXocJK504KHVwyqrXE0RabLiyzll%2Bc2QRzXzsXWS8SgjUVoZxpssgmvD7v3B60obqdUFPUp2KkhfkG3PawPbFulAUL5iaYHmV4DLCOZRE3r%2F7iO5Uk6Y5TrqzgS7%2F6gswknQt2oRh7iK68vF9j18tZnMkslyLfdA3m5Pc2SVWKhL7bb5up2rkwfNosQEfKtLebUAwwDz98yspsGvheiLr9bYa1moMAznKilMfc9kIcqi2WgkXBYO7W2ppNreeBFcHBw%2Byuv7OeICj6I2TcE%2BybygEHGXlIfBRB0lVFigPDCpNdYLGaSauH2cuAVazh%2FOy4wUGLNhOQPYKHoC4SsatfWRifJQtsDuFK2spOpR6qj7Q3Zec9rOYceirw6c2xZ%2Fa7ULXcXWm0RJaKl%2BbEV8L3nN2mkozBAWmjH%2BeKDbrJs98yPEYi3wUpI5dOW9FzerAdEdTjhWVgv4zU5tc4RsUNJgdkJHIpRhs5CN6pNEARLs5p5c2Xj6GvdnGWxViqrIxth81Mh9%2Fg98lBMZKPG5yX2PS1Yfp4TXiv4dyGNQNqhMtEcdRbfmeMbHSLZLgPC5xWPO1be7caWZr%2FWHhOTzZSlxrjPD%2B760qqGE47UPBSYmceIfyj3oYcFSax80RSazRt7UREJU6yX1tecoW0dFQdZKN9scOV4Oo8ACdJTU8L0ecm269qfgsudVfC9q6k9Y73iXUaRURL33%2FNmT7eXPAnwUyJQ%2B3t8V3t6g%2BEpjKSVnJPVd70ox5W%2FhlCHzmn6sOkHZ5LFcXg7lB60FNx4DQyb3jYvN%2BYjbKRowbEZAWrzfgq8kwX7NZyK9i789J9qLdFwQD4wtltpXPjzWX4D3pH%2BZsVH5nzCKeJChEJqdNhuB8i7plhmmRcq8vw7EiF4DPmOPW%2Bl4hKmD6oFIW14lexzsBcFE8zB15wfQcTvhpnj1MzuBi%2Ff%2B7hvHwA%3D" +
				"&__VIEWSTATEENCRYPTED=" +
				"&__ASYNCPOST=true" +
				"&ctl00%24MainContent%24AddToCartButton=Add%20to%20shopping%20cart";
		byte[] requestContentBinary0044 = requestContent0044.getBytes("UTF-8");
		String requestHeader0044 = "POST " + requestFile0044 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0044.length + "\r\n" + 		// Content-Length: 4703
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0044, requestHost0044, requestPort0044, requestHeader0044, requestContentBinary0044, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0044 = null;		// support garbage collector to reduce memory
		requestContent0044 = null;		// support garbage collector to reduce memory
		requestContentBinary0044 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 5846
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, "span id=\"MainContent_SecondaryAvailabilityLabel\"");		// Test [44] <- Index 44
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





		// --- HTTP REQUEST: Test [45] <- WEB ADMIN Index 45 ---
		log();
		log("# title: View my shopping cart");
		String requestProt0045 = "https";
		String requestHost0045 = "cldemo.apicasystem.com";
		int    requestPort0045 = 443;
		String requestFile0045 = "/Checkout/MyShoppingCart.aspx";
		String requestHeader0045 = "GET " + requestFile0045 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0045, requestHost0045, requestPort0045, requestHeader0045, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0045 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 5547
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "span id=\"MainContent_ShoppingCartLabel\"");		// Test [45] <- Index 45
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
		regExpBasedExtractor = new RegExpBasedExtractor(testURL.getContentString());

		// setup var extractor for 'var__PREVIOUSPAGE'
		RegExpBasedExtractorItem regExpBasedContentExtractorItem0045_1 = new RegExpBasedExtractorItem( "id=\"__PREVIOUSPAGE\" value=\"(.*?)\"" ,1,1,false);
		regExpBasedExtractor.addRegExpBasedExtractorItem(regExpBasedContentExtractorItem0045_1);

		// setup var extractor for 'var__EVENTVALIDATION'
		RegExpBasedExtractorItem regExpBasedContentExtractorItem0045_2 = new RegExpBasedExtractorItem( "id=\"__EVENTVALIDATION\" value=\"(.*?)\"" ,1,1,false);
		regExpBasedExtractor.addRegExpBasedExtractorItem(regExpBasedContentExtractorItem0045_2);

		// setup var extractor for 'var__CorrelationParameter'
		RegExpBasedExtractorItem regExpBasedContentExtractorItem0045_3 = new RegExpBasedExtractorItem( "id=\"__VIEWSTATE\" value=\"(.*?)\"" ,1,1,false);
		regExpBasedExtractor.addRegExpBasedExtractorItem(regExpBasedContentExtractorItem0045_3);

		regExpBasedExtractor.extractText();
		regExpBasedExtractor = new RegExpBasedExtractor(testURL.getHeaderString());

		regExpBasedExtractor.extractText();
		try
		{
			// extract var 'var__PREVIOUSPAGE'
			var__PREVIOUSPAGE = regExpBasedContentExtractorItem0045_1.getResultText();
			log("<<< var__PREVIOUSPAGE = " + var__PREVIOUSPAGE);
		}
		catch (Exception e) { var__PREVIOUSPAGE = null; log(e); }
		if (var__PREVIOUSPAGE == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'var__PREVIOUSPAGE' from regexp based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'var__EVENTVALIDATION'
			var__EVENTVALIDATION = regExpBasedContentExtractorItem0045_2.getResultText();
			log("<<< var__EVENTVALIDATION = " + var__EVENTVALIDATION);
		}
		catch (Exception e) { var__EVENTVALIDATION = null; log(e); }
		if (var__EVENTVALIDATION == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'var__EVENTVALIDATION' from regexp based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'var__CorrelationParameter'
			var__CorrelationParameter = regExpBasedContentExtractorItem0045_3.getResultText();
			log("<<< var__CorrelationParameter = " + var__CorrelationParameter);
		}
		catch (Exception e) { var__CorrelationParameter = null; log(e); }
		if (var__CorrelationParameter == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'var__CorrelationParameter' from regexp based pattern";
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





		// --- HTTP REQUEST: Test [46] <- WEB ADMIN Index 46 ---
		String requestProt0046 = "https";
		String requestHost0046 = "cldemo.apicasystem.com";
		int    requestPort0046 = 443;
		String requestFile0046 = "/Images/select_item.gif";
		String requestHeader0046 = "GET " + requestFile0046 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0046, requestHost0046, requestPort0046, requestHeader0046, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0046 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 1096
		// content test algorithm: check size +/- 5%, defined content size = 1096
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 1096, 5);		// Test [46] <- Index 46
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
		// # Page #5: MyShoppingCart.aspx_2 - Page5
		// # --------------------------------------



		// --- HTTP REQUEST: Test [48] <- WEB ADMIN Index 48 ---
		log();
		log("# title: View my shopping cart");
		String requestProt0048 = "https";
		String requestHost0048 = "cldemo.apicasystem.com";
		int    requestPort0048 = 443;
		String requestFile0048 = "/Checkout/MyShoppingCart.aspx";
		String requestContent0048 = 
				"__EVENTTARGET=ctl00%24MainContent%24ShoppingCartGridView" +
				"&__EVENTARGUMENT=Select%240" +
				"&__VIEWSTATE=4DgIRVKuq4tDwMO%2FW9ToRSOyUlwAEos3Yr%2FXXi0wC6Xr8UNW15gE%2FHGCA06ZJ8bx8FjbYEBogK2iLFZoPAJO%2F6gn%2FMYUeA%2BvE1ZDmedu4o4pAVFeHNy5kELc%2FTQXQiSD%2BMe%2BGwzzoU%2BNGrm%2B6LKSewOOcSCmJGq80pe%2F6XyX8iJLvaEueQc5FlYKz1k1cVVncl4FQZWl2mnoEah5UzNK9GBgdneHWvs3FFlYrlJ%2B1tAJSfziGmzFMdzVdZ%2FaKBI3jLXLql4w9B4tliKtE24j7JvipD%2FwQQo5pSGiHUzlTxaY22jrsl60OfT4VKZBEOwurgSb4ozuNHORMlwK8pYj9mVTh4HI%2FYwVXss5QNqMVEb8MnRiLyB9j1Fw4YFUU9hxTpp%2B2bYCeyoabgMmsP3rRu%2FIqVjMQq7ClLxkjtTMRXfs1kSAnxHaX57k750iRkAjMk0AKLTM%2Fg2eFSgckw3VIEpCEjqUW71N3HjZ%2FN%2Fyp1lviZL7powX7Cl10jeI4DXh5mmzjAcwI8qmss2F2HRlUSefxZfWWNnyceI0gSO3W%2F%2FYgdowL3l6f%2BKWScFVd0b0mZmzNukfAp9Ae8SkSuCVBovWNsTg7n2DC5cEh81RF3bTvRrbRl0qZdKSMAQPW2GkArDtgXulDLOGmkjj83ynxDdfe8HE1R1pvosznTQY%2BKztyIr%2Fh8ld%2Beq%2FMSrjOUInlIrX%2FC637qcW44smHxE5qQHs3mk2B9n0BRbpSFV8%2FKtR6FwAMSUlxNfGuhnVyzq%2B5amgDH4kX4%2Bj2tEpx2jXfGneDGQAqubKqBTZSGeFHf18mgjCpzGkfCQTl6uFqWVPs%2FcFmhJu6fWCJq%2FZa%2F7PNJauIL4g%2BiCr5%2FfKOTUcjSrSWeJniBsPX5R1RgCap2kP0IqdO9AHS70F%2BSX7jmXkcxVrbSEqAo39MtQUqQfAuwfh0NB5Jhm1%2BRJvyYxWOEEw0Eb%2BnzEwDyV5FlkHk4Dy81a3ui0P9T9iacqntddmqvf0lZ1lbAyQOiB8Lr5W5KkABYoOM85zwuCMVGymTMIfy0uM1GUGtfBrXmykc7RPnnzWBPjln%2FXj4G64fry69IpI3FUVnj6cNZvLx4ahQBn76dfENhrxX1k1KGjcS4bRdqQjxYRl0pG2S%2BOyCCl3B%2BQoqVeXjgsO6jmH023%2BtqgebpYwO7T1jsJ%2FewnDCAoqNE64%2BEjmBujBi4x%2BOWfgwjjH5FPAsm2rjTxpHZICqGqhK0mnmIzsb%2F%2FwJh57YsmApEqkP4N0" +
				"&__VIEWSTATEENCRYPTED=" +
				"&__PREVIOUSPAGE=P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0" +
				"&__EVENTVALIDATION=WByb9%2Brj1Y7bxu%2BnsPxet9TVx%2BJ%2BRCMqXuSfh994JQXRFa3XrdMo7f%2F0Kfy38fWKuopiDK7NzT6a0UmfeDWE2lu7X3mEb8lGig6dmQ0fQO6HNXy3Tea2dDRPjlC8jyGFBF8rHsIt%2BvzsxVAqpLhas07eUiW7tJ2EWwWkFd81Tmc2eeoEJaXCa9V8FPhfBSQl37TFh7ys%2FZjpgpXr2jWQm2T8z%2B8%3D";
		byte[] binarySearchPattern0048_0 = Base64Decoder.decodeToBytes("V0J5YjklMkJyajFZN2J4dSUyQm5zUHhldDlUVnglMkJKJTJCUkNNcVh1U2ZoOTk0SlFYUkZhM1hyZE1vN2YlMkYwS2Z5MzhmV0t1b3BpREs3TnpUNmEwVW1mZURXRTJsdTdYM21FYjhsR2lnNmRtUTBmUU82SE5YeTNUZWEyZERSUGpsQzhqeUdGQkY4ckhzSXQlMkJ2enN4VkFxcExoYXMwN2VVaVc3dEoyRVd3V2tGZDgxVG1jMmVlb0VKYVhDYTlWOEZQaGZCU1FsMzdURmg3eXMlMkZaanBncFhyMmpXUW0yVDh6JTJCOCUzRA==");		// note: the search pattern value is base 64 encoded. decoded value = WByb9%2Brj1Y7bxu%2BnsPxet9TVx%2BJ%2BRCMqXuSfh994JQXRFa3XrdMo7f%2F0Kfy38fWKuopiDK7NzT6a0UmfeDWE2lu7X3mEb8lGig6dmQ0fQO6HNXy3Tea2dDRPjlC8jyGFBF8rHsIt%2BvzsxVAqpLhas07eUiW7tJ2EWwWkFd81Tmc2eeoEJaXCa9V8FPhfBSQl37TFh7ys%2FZjpgpXr2jWQm2T8z%2B8%3D
		requestContent0048 = new String(Lib.binaryReplace(requestContent0048.getBytes(), binarySearchPattern0048_0, java.net.URLEncoder.encode(var__EVENTVALIDATION).getBytes(), 0));		// search within the request content for a binary pattern and replace it with a variable value
		byte[] binarySearchPattern0048_1 = Base64Decoder.decodeToBytes("NERnSVJWS3VxNHREd01PJTJGVzlUb1JTT3lVbHdBRW9zM1lyJTJGWFhpMHdDNlhyOFVOVzE1Z0UlMkZIR0NBMDZaSjhieDhGamJZRUJvZ0syaUxGWm9QQUpPJTJGNmduJTJGTVlVZUElMkJ2RTFaRG1lZHU0bzRwQVZGZUhOeTVrRUxjJTJGVFFYUWlTRCUyQk1lJTJCR3d6em9VJTJCTkdybSUyQjZMS1Nld09PY1NDbUpHcTgwcGUlMkY2WHlYOGlKTHZhRXVlUWM1RmxZS3oxazFjVlZuY2w0RlFaV2wybW5vRWFoNVV6Tks5R0JnZG5lSFd2czNGRmxZcmxKJTJCMXRBSlNmemlHbXpGTWR6VmRaJTJGYUtCSTNqTFhMcWw0dzlCNHRsaUt0RTI0ajdKdmlwRCUyRndRUW81cFNHaUhVemxUeGFZMjJqcnNsNjBPZlQ0VktaQkVPd3VyZ1NiNG96dU5IT1JNbHdLOHBZajltVlRoNEhJJTJGWXdWWHNzNVFOcU1WRWI4TW5SaUx5QjlqMUZ3NFlGVVU5aHhUcHAlMkIyYllDZXlvYWJnTW1zUDNyUnUlMkZJcVZqTVFxN0NsTHhranRUTVJYZnMxa1NBbnhIYVg1N2s3NTBpUmtBak1rMEFLTFRNJTJGZzJlRlNnY2t3M1ZJRXBDRWpxVVc3MU4zSGpaJTJGTiUyRnlwMWx2aVpMN3Bvd1g3Q2wxMGplSTREWGg1bW16akFjd0k4cW1zczJGMkhSbFVTZWZ4WmZXV05ueWNlSTBnU08zVyUyRiUyRllnZG93TDNsNmYlMkJLV1NjRlZkMGIwbVptek51a2ZBcDlBZThTa1N1Q1ZCb3ZXTnNUZzduMkRDNWNFaDgxUkYzYlR2UnJiUmwwcVpkS1NNQVFQVzJHa0FyRHRnWHVsRExPR21ramo4M3lueERkZmU4SEUxUjFwdm9zem5UUVklMkJLenR5SXIlMkZoOGxkJTJCZXElMkZNU3JqT1VJbmxJclglMkZDNjM3cWNXNDRzbUh4RTVxUUhzM21rMkI5bjBCUmJwU0ZWOCUyRkt0UjZGd0FNU1VseE5mR3VoblZ5enElMkI1YW1nREg0a1g0JTJCajJ0RXB4MmpYZkduZURHUUFxdWJLcUJUWlNHZUZIZjE4bWdqQ3B6R2tmQ1FUbDZ1RnFXVlBzJTJGY0ZtaEp1NmZXQ0pxJTJGWmElMkY3UE5KYXVJTDRnJTJCaUNyNSUyRmZLT1RVY2pTclNXZUpuaUJzUFg1UjFSZ0NhcDJrUDBJcWRPOUFIUzcwRiUyQlNYN2ptWGtjeFZyYlNFcUFvMzlNdFFVcVFmQXV3ZmgwTkI1SmhtMSUyQlJKdnlZeFdPRUV3MEViJTJCbnpFd0R5VjVGbGtIazREeTgxYTN1aTBQOVQ5aWFjcW50ZGRtcXZmMGxaMWxiQXlRT2lCOExyNVc1S2tBQllvT004NXp3dUNNVkd5bVRNSWZ5MHVNMUdVR3RmQnJYbXlrYzdSUG5ueldCUGpsbiUyRlhqNEc2NGZyeTY5SXBJM0ZVVm5qNmNOWnZMeDRhaFFCbjc2ZGZFTmhyeFgxazFLR2pjUzRiUmRxUWp4WVJsMHBHMlMlMkJPeUNDbDNCJTJCUW9xVmVYamdzTzZqbUgwMjMlMkJ0cWdlYnBZd083VDFqc0olMkZld25EQ0FvcU5FNjQlMkJFam1CdWpCaTR4JTJCT1dmZ3dqakg1RlBBc20ycmpUeHBIWklDcUdxaEswbW5tSXpzYiUyRiUyRndKaDU3WXNtQXBFcWtQNE4w");		// note: the search pattern value is base 64 encoded. decoded value = 4DgIRVKuq4tDwMO%2FW9ToRSOyUlwAEos3Yr%2FXXi0wC6Xr8UNW15gE%2FHGCA06ZJ8bx8FjbYEBogK2iLFZoPAJO%2F6gn%2FMYUeA%2BvE1ZDmedu4o4pAVFeHNy5kELc%2FTQXQiSD%2BMe%2BGwzzoU%2BNGrm%2B6LKSewOOcSCmJGq80pe%2F6XyX8iJLvaEueQc5FlYKz1k1cVVncl4FQZWl2mnoEah5UzNK9GBgdneHWvs3FFlYrlJ%2B1tAJSfziGmzFMdzVdZ%2FaKBI3jLXLql4w9B4tliKtE24j7JvipD%2FwQQo5pSGiHUzlTxaY22jrsl60OfT4VKZBEOwurgSb4ozuNHORMlwK8pYj9mVTh4HI%2FYwVXss5QNqMVEb8MnRiLyB9j1Fw4YFUU9hxTpp%2B2bYCeyoabgMmsP3rRu%2FIqVjMQq7ClLxkjtTMRXfs1kSAnxHaX57k750iRkAjMk0AKLTM%2Fg2eFSgckw3VIEpCEjqUW71N3HjZ%2FN%2Fyp1lviZL7powX7Cl10jeI4DXh5mmzjAcwI8qmss2F2HRlUSefxZfWWNnyceI0gSO3W%2F%2FYgdowL3l6f%2BKWScFVd0b0mZmzNukfAp9Ae8SkSuCVBovWNsTg7n2DC5cEh81RF3bTvRrbRl0qZdKSMAQPW2GkArDtgXulDLOGmkjj83ynxDdfe8HE1R1pvosznTQY%2BKztyIr%2Fh8ld%2Beq%2FMSrjOUInlIrX%2FC637qcW44smHxE5qQHs3mk2B9n0BRbpSFV8%2FKtR6FwAMSUlxNfGuhnVyzq%2B5amgDH4kX4%2Bj2tEpx2jXfGneDGQAqubKqBTZSGeFHf18mgjCpzGkfCQTl6uFqWVPs%2FcFmhJu6fWCJq%2FZa%2F7PNJauIL4g%2BiCr5%2FfKOTUcjSrSWeJniBsPX5R1RgCap2kP0IqdO9AHS70F%2BSX7jmXkcxVrbSEqAo39MtQUqQfAuwfh0NB5Jhm1%2BRJvyYxWOEEw0Eb%2BnzEwDyV5FlkHk4Dy81a3ui0P9T9iacqntddmqvf0lZ1lbAyQOiB8Lr5W5KkABYoOM85zwuCMVGymTMIfy0uM1GUGtfBrXmykc7RPnnzWBPjln%2FXj4G64fry69IpI3FUVnj6cNZvLx4ahQBn76dfENhrxX1k1KGjcS4bRdqQjxYRl0pG2S%2BOyCCl3B%2BQoqVeXjgsO6jmH023%2BtqgebpYwO7T1jsJ%2FewnDCAoqNE64%2BEjmBujBi4x%2BOWfgwjjH5FPAsm2rjTxpHZICqGqhK0mnmIzsb%2F%2FwJh57YsmApEqkP4N0
		requestContent0048 = new String(Lib.binaryReplace(requestContent0048.getBytes(), binarySearchPattern0048_1, java.net.URLEncoder.encode(var__CorrelationParameter).getBytes(), 0));		// search within the request content for a binary pattern and replace it with a variable value
		requestContent0048 = Lib.replaceTextPattern(requestContent0048, "P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0", var__PREVIOUSPAGE, 0);		// search and replace content fragment "P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0" with variable 'var__PREVIOUSPAGE' on all occurrences

		String requestHeader0048 = "POST " + requestFile0048 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0048.length() + "\r\n" + 		// Content-Length: 1866
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0048, requestHost0048, requestPort0048, requestHeader0048, requestContent0048.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0048 = null;		// support garbage collector to reduce memory
		requestContent0048 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 5949
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "span id=\"MainContent_ShoppingCartLabel\"");		// Test [48] <- Index 48
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
		regExpBasedExtractor = new RegExpBasedExtractor(testURL.getContentString());

		// setup var extractor for 'var__CorrelationParameter_1'
		RegExpBasedExtractorItem regExpBasedContentExtractorItem0048_1 = new RegExpBasedExtractorItem( "id=\"__VIEWSTATE\" value=\"(.*?)\"" ,1,1,false);
		regExpBasedExtractor.addRegExpBasedExtractorItem(regExpBasedContentExtractorItem0048_1);

		// setup var extractor for 'var__EVENTVALIDATION_1'
		RegExpBasedExtractorItem regExpBasedContentExtractorItem0048_2 = new RegExpBasedExtractorItem( "id=\"__EVENTVALIDATION\" value=\"(.*?)\"" ,1,1,false);
		regExpBasedExtractor.addRegExpBasedExtractorItem(regExpBasedContentExtractorItem0048_2);

		regExpBasedExtractor.extractText();
		regExpBasedExtractor = new RegExpBasedExtractor(testURL.getHeaderString());

		regExpBasedExtractor.extractText();
		try
		{
			// extract var 'var__CorrelationParameter_1'
			var__CorrelationParameter_1 = regExpBasedContentExtractorItem0048_1.getResultText();
			log("<<< var__CorrelationParameter_1 = " + var__CorrelationParameter_1);
		}
		catch (Exception e) { var__CorrelationParameter_1 = null; log(e); }
		if (var__CorrelationParameter_1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'var__CorrelationParameter_1' from regexp based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'var__EVENTVALIDATION_1'
			var__EVENTVALIDATION_1 = regExpBasedContentExtractorItem0048_2.getResultText();
			log("<<< var__EVENTVALIDATION_1 = " + var__EVENTVALIDATION_1);
		}
		catch (Exception e) { var__EVENTVALIDATION_1 = null; log(e); }
		if (var__EVENTVALIDATION_1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'var__EVENTVALIDATION_1' from regexp based pattern";
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





		// --- HTTP REQUEST: Test [49] <- WEB ADMIN Index 49 ---
		log();
		log("# title: View my shopping cart");
		String requestProt0049 = "https";
		String requestHost0049 = "cldemo.apicasystem.com";
		int    requestPort0049 = 443;
		String requestFile0049 = "/Checkout/MyShoppingCart.aspx";
		String requestContent0049 = 
				"__EVENTTARGET=" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=tgnO6hRBM3aR1MMb2GZhWNdr62NL2YS2GxtMDVMZneFrK48qAatynkyrXxNCc0kRS0zItYnI9CIaHm%2B4h5n2thwQruw4e0azqiS%2Bh86LLRPyE2e5iJ%2BCKGn9IOoz4tFq3xUqdt4ybhUf4rJrHbK9%2BOc%2BWLxrD4sneB9593svUV4ywRAUctBG42qqDbLW5jF9FycqhC6zT1txSpk3yfX5%2Fw5%2F22HM6kYVESy4DEaRHZjH5qhoVU1ARqGLNiBXynZHtkrcybzxj1pJBRlwjyjuA0NEMV5LjyrOtA4GgGj1ap2QoVXcyQZgTGtmDfjSicmi3IOfMxp7HHGn7cDhTWfpu%2F1jIUD%2FGidFpfeAuf7FokKLTNbg37oi0LBf6MxA1aTgScHDydpfhQWiXjPcvcvNbzIvHuKvMaeb0TBGms%2BvUYDr5OtT3xHet7l%2F7Ql1r4BR3dhw98h25qI7DZTZfEuT9lki72npHRgvx%2Bty3eBL%2Bl5x1CI6fN0nPm8505FoC%2BityG1uzx0zoj%2B7YGjaOmypHhlxRFstGBSjtSGPM2tQXkvAyQR4M3VQLuBt1FGfB2vHmiYhnVHKZ4pazIXDMZUKzcUkDa72CVYBc7SjmJG3wL7cs2CWQak6qcfCQE1V6jWbb%2BBsZ%2Fp5c5kSY62xfTw1mXgnhCF0Al97WntXWRBI59PUH9Jy19mQx%2BtZ4cfc0e3zRaLFaQKlpwC2wUq3AYx14hHeH1K6C2cip1InMH1aAabWePyzUMQaBcDu0ob2qUHJ4y5gvI8P7FUM2kSzKLKoMubfP71DPSJnvquqneeIyCImMxvqfXcfBlEnNpVNMmJt%2FnfE0sbszXL37El9DcYS5neBc95yBzmjPbt8JbEX16vsC2nqBQzCBmYd%2BFBkJWxZNJ7tItnTvZXSW5dYBW6mQoloXUwsDDuSWstCpFlTlh%2Bo4BftIxWfdvPhUwofnenbdPRVVE4bzOMDHw6zFTIa%2FoEIRvyGit3%2FFDWElVt29uIAsrz93jqGzlUdeQ2bnBXBP3GzF9FrysGKAb79ubFrXxBOJv5U8wGTq7wIMsOKr32GM8m4bkGtLvxEG6O7v%2F5bXrGLhc3%2FHMW8d%2FWPapA7Rk2E%2BdOhA%2BUVnsv4LM8DI8WdKOe6HmOQ1W3%2Bsai1H6pQ1srCMg7afoYviTceYmbjgxa6nBc5%2FOQ4C8jQYLL1cnvdT%2BWxIzpr7WvQmfaI3LNVEorZmVhdqQYbTHVUslDh8d5E9TDshuuBBYfyraMaFQvHKRG%2FVEeD8NGvSXQiN1lJGqpqVJSZCxRuwoIeQTEJR9qkH724rGFI1pKaVrsnIXUxRfw3BhWJpj4CMOAvfTO2VXiR8l7BJqqBfFx1qllO0Na%2BFXB04akoiTCK8Q8s6%2FtaudBx4nOrC8nDf3QlmlmV14eQ4GGxSxFJXXog%2FNSHZaCVl8QOxQQ8UwCFiQMfsZEsHeIcYVJ3Z0IsgdGSPvi1sYuCP0q1yPMJ4SH0EYKDDLli7ESw19bJi4H6oLTSGtdeTxacSXPpdjqRtY3lpYk62zwKczguIIUmCD1U8DZv4HfyMjJ%2B1NJoi3BmcA6pqgbnnCiql6HjA%2FRyXN2Y1u6Br0gnpzz9QkAVfcPDgz7VFF8Qcs%2F3PZtptj6V6r0jaeId1YD0" +
				"&__VIEWSTATEENCRYPTED=" +
				"&__PREVIOUSPAGE=P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0" +
				"&__EVENTVALIDATION=aY5HANv4MrrPLoBiJM32Fqjc3wKRERZa4dFjaJf3AfE9kjA10G3XD5oNhnJ3iCv2GaypxnXNJgFXUV5KaeoAuhwlUX6aPPtlE6dQzuZgweY8LSnp0eX7M0fXIU211HWSzJRJReV1wfcWainUTbdW7MthIGMP6wE405%2BAQtO4jhIZYRkeYSie%2F6oGH5fLscj39Kd1G0zwdtVDS1lK7i8D0%2FGKopg%3D" +
				"&ctl00%24MainContent%24UpdateRowButton=Update+selected+row";
		byte[] binarySearchPattern0049_0 = Base64Decoder.decodeToBytes("dGduTzZoUkJNM2FSMU1NYjJHWmhXTmRyNjJOTDJZUzJHeHRNRFZNWm5lRnJLNDhxQWF0eW5reXJYeE5DYzBrUlMwekl0WW5JOUNJYUhtJTJCNGg1bjJ0aHdRcnV3NGUwYXpxaVMlMkJoODZMTFJQeUUyZTVpSiUyQkNLR245SU9vejR0RnEzeFVxZHQ0eWJoVWY0ckpySGJLOSUyQk9jJTJCV0x4ckQ0c25lQjk1OTNzdlVWNHl3UkFVY3RCRzQycXFEYkxXNWpGOUZ5Y3FoQzZ6VDF0eFNwazN5Zlg1JTJGdzUlMkYyMkhNNmtZVkVTeTRERWFSSFpqSDVxaG9WVTFBUnFHTE5pQlh5blpIdGtyY3lienhqMXBKQlJsd2p5anVBME5FTVY1TGp5ck90QTRHZ0dqMWFwMlFvVlhjeVFaZ1RHdG1EZmpTaWNtaTNJT2ZNeHA3SEhHbjdjRGhUV2ZwdSUyRjFqSVVEJTJGR2lkRnBmZUF1ZjdGb2tLTFROYmczN29pMExCZjZNeEExYVRnU2NIRHlkcGZoUVdpWGpQY3Zjdk5iekl2SHVLdk1hZWIwVEJHbXMlMkJ2VVlEcjVPdFQzeEhldDdsJTJGN1FsMXI0QlIzZGh3OThoMjVxSTdEWlRaZkV1VDlsa2k3Mm5wSFJndnglMkJ0eTNlQkwlMkJsNXgxQ0k2Zk4wblBtODUwNUZvQyUyQml0eUcxdXp4MHpvaiUyQjdZR2phT215cEhobHhSRnN0R0JTanRTR1BNMnRRWGt2QXlRUjRNM1ZRTHVCdDFGR2ZCMnZIbWlZaG5WSEtaNHBheklYRE1aVUt6Y1VrRGE3MkNWWUJjN1NqbUpHM3dMN2NzMkNXUWFrNnFjZkNRRTFWNmpXYmIlMkJCc1olMkZwNWM1a1NZNjJ4ZlR3MW1YZ25oQ0YwQWw5N1dudFhXUkJJNTlQVUg5SnkxOW1ReCUyQnRaNGNmYzBlM3pSYUxGYVFLbHB3QzJ3VXEzQVl4MTRoSGVIMUs2QzJjaXAxSW5NSDFhQWFiV2VQeXpVTVFhQmNEdTBvYjJxVUhKNHk1Z3ZJOFA3RlVNMmtTektMS29NdWJmUDcxRFBTSm52cXVxbmVlSXlDSW1NeHZxZlhjZkJsRW5OcFZOTW1KdCUyRm5mRTBzYnN6WEwzN0VsOURjWVM1bmVCYzk1eUJ6bWpQYnQ4SmJFWDE2dnNDMm5xQlF6Q0JtWWQlMkJGQmtKV3haTko3dEl0blR2WlhTVzVkWUJXNm1Rb2xvWFV3c0REdVNXc3RDcEZsVGxoJTJCbzRCZnRJeFdmZHZQaFV3b2ZuZW5iZFBSVlZFNGJ6T01ESHc2ekZUSWElMkZvRUlSdnlHaXQzJTJGRkRXRWxWdDI5dUlBc3J6OTNqcUd6bFVkZVEyYm5CWEJQM0d6RjlGcnlzR0tBYjc5dWJGclh4Qk9KdjVVOHdHVHE3d0lNc09LcjMyR004bTRia0d0THZ4RUc2Tzd2JTJGNWJYckdMaGMzJTJGSE1XOGQlMkZXUGFwQTdSazJFJTJCZE9oQSUyQlVWbnN2NExNOERJOFdkS09lNkhtT1ExVzMlMkJzYWkxSDZwUTFzckNNZzdhZm9ZdmlUY2VZbWJqZ3hhNm5CYzUlMkZPUTRDOGpRWUxMMWNudmRUJTJCV3hJenByN1d2UW1mYUkzTE5WRW9yWm1WaGRxUVliVEhWVXNsRGg4ZDVFOVREc2h1dUJCWWZ5cmFNYUZRdkhLUkclMkZWRWVEOE5HdlNYUWlOMWxKR3FwcVZKU1pDeFJ1d29JZVFURUpSOXFrSDcyNHJHRkkxcEthVnJzbklYVXhSZnczQmhXSnBqNENNT0F2ZlRPMlZYaVI4bDdCSnFxQmZGeDFxbGxPME5hJTJCRlhCMDRha29pVENLOFE4czYlMkZ0YXVkQng0bk9yQzhuRGYzUWxtbG1WMTRlUTRHR3hTeEZKWFhvZyUyRk5TSFphQ1ZsOFFPeFFROFV3Q0ZpUU1mc1pFc0hlSWNZVkozWjBJc2dkR1NQdmkxc1l1Q1AwcTF5UE1KNFNIMEVZS0RETGxpN0VTdzE5YkppNEg2b0xUU0d0ZGVUeGFjU1hQcGRqcVJ0WTNscFlrNjJ6d0tjemd1SUlVbUNEMVU4RFp2NEhmeU1qSiUyQjFOSm9pM0JtY0E2cHFnYm5uQ2lxbDZIakElMkZSeVhOMlkxdTZCcjBnbnB6ejlRa0FWZmNQRGd6N1ZGRjhRY3MlMkYzUFp0cHRqNlY2cjBqYWVJZDFZRDA=");		// note: the search pattern value is base 64 encoded. decoded value = tgnO6hRBM3aR1MMb2GZhWNdr62NL2YS2GxtMDVMZneFrK48qAatynkyrXxNCc0kRS0zItYnI9CIaHm%2B4h5n2thwQruw4e0azqiS%2Bh86LLRPyE2e5iJ%2BCKGn9IOoz4tFq3xUqdt4ybhUf4rJrHbK9%2BOc%2BWLxrD4sneB9593svUV4ywRAUctBG42qqDbLW5jF9FycqhC6zT1txSpk3yfX5%2Fw5%2F22HM6kYVESy4DEaRHZjH5qhoVU1ARqGLNiBXynZHtkrcybzxj1pJBRlwjyjuA0NEMV5LjyrOtA4GgGj1ap2QoVXcyQZgTGtmDfjSicmi3IOfMxp7HHGn7cDhTWfpu%2F1jIUD%2FGidFpfeAuf7FokKLTNbg37oi0LBf6MxA1aTgScHDydpfhQWiXjPcvcvNbzIvHuKvMaeb0TBGms%2BvUYDr5OtT3xHet7l%2F7Ql1r4BR3dhw98h25qI7DZTZfEuT9lki72npHRgvx%2Bty3eBL%2Bl5x1CI6fN0nPm8505FoC%2BityG1uzx0zoj%2B7YGjaOmypHhlxRFstGBSjtSGPM2tQXkvAyQR4M3VQLuBt1FGfB2vHmiYhnVHKZ4pazIXDMZUKzcUkDa72CVYBc7SjmJG3wL7cs2CWQak6qcfCQE1V6jWbb%2BBsZ%2Fp5c5kSY62xfTw1mXgnhCF0Al97WntXWRBI59PUH9Jy19mQx%2BtZ4cfc0e3zRaLFaQKlpwC2wUq3AYx14hHeH1K6C2cip1InMH1aAabWePyzUMQaBcDu0ob2qUHJ4y5gvI8P7FUM2kSzKLKoMubfP71DPSJnvquqneeIyCImMxvqfXcfBlEnNpVNMmJt%2FnfE0sbszXL37El9DcYS5neBc95yBzmjPbt8JbEX16vsC2nqBQzCBmYd%2BFBkJWxZNJ7tItnTvZXSW5dYBW6mQoloXUwsDDuSWstCpFlTlh%2Bo4BftIxWfdvPhUwofnenbdPRVVE4bzOMDHw6zFTIa%2FoEIRvyGit3%2FFDWElVt29uIAsrz93jqGzlUdeQ2bnBXBP3GzF9FrysGKAb79ubFrXxBOJv5U8wGTq7wIMsOKr32GM8m4bkGtLvxEG6O7v%2F5bXrGLhc3%2FHMW8d%2FWPapA7Rk2E%2BdOhA%2BUVnsv4LM8DI8WdKOe6HmOQ1W3%2Bsai1H6pQ1srCMg7afoYviTceYmbjgxa6nBc5%2FOQ4C8jQYLL1cnvdT%2BWxIzpr7WvQmfaI3LNVEorZmVhdqQYbTHVUslDh8d5E9TDshuuBBYfyraMaFQvHKRG%2FVEeD8NGvSXQiN1lJGqpqVJSZCxRuwoIeQTEJR9qkH724rGFI1pKaVrsnIXUxRfw3BhWJpj4CMOAvfTO2VXiR8l7BJqqBfFx1qllO0Na%2BFXB04akoiTCK8Q8s6%2FtaudBx4nOrC8nDf3QlmlmV14eQ4GGxSxFJXXog%2FNSHZaCVl8QOxQQ8UwCFiQMfsZEsHeIcYVJ3Z0IsgdGSPvi1sYuCP0q1yPMJ4SH0EYKDDLli7ESw19bJi4H6oLTSGtdeTxacSXPpdjqRtY3lpYk62zwKczguIIUmCD1U8DZv4HfyMjJ%2B1NJoi3BmcA6pqgbnnCiql6HjA%2FRyXN2Y1u6Br0gnpzz9QkAVfcPDgz7VFF8Qcs%2F3PZtptj6V6r0jaeId1YD0
		requestContent0049 = new String(Lib.binaryReplace(requestContent0049.getBytes(), binarySearchPattern0049_0, java.net.URLEncoder.encode(var__CorrelationParameter_1).getBytes(), 0));		// search within the request content for a binary pattern and replace it with a variable value
		byte[] binarySearchPattern0049_1 = Base64Decoder.decodeToBytes("YVk1SEFOdjRNcnJQTG9CaUpNMzJGcWpjM3dLUkVSWmE0ZEZqYUpmM0FmRTlrakExMEczWEQ1b05obkozaUN2MkdheXB4blhOSmdGWFVWNUthZW9BdWh3bFVYNmFQUHRsRTZkUXp1Wmd3ZVk4TFNucDBlWDdNMGZYSVUyMTFIV1N6SlJKUmVWMXdmY1dhaW5VVGJkVzdNdGhJR01QNndFNDA1JTJCQVF0TzRqaElaWVJrZVlTaWUlMkY2b0dINWZMc2NqMzlLZDFHMHp3ZHRWRFMxbEs3aThEMCUyRkdLb3BnJTNE");		// note: the search pattern value is base 64 encoded. decoded value = aY5HANv4MrrPLoBiJM32Fqjc3wKRERZa4dFjaJf3AfE9kjA10G3XD5oNhnJ3iCv2GaypxnXNJgFXUV5KaeoAuhwlUX6aPPtlE6dQzuZgweY8LSnp0eX7M0fXIU211HWSzJRJReV1wfcWainUTbdW7MthIGMP6wE405%2BAQtO4jhIZYRkeYSie%2F6oGH5fLscj39Kd1G0zwdtVDS1lK7i8D0%2FGKopg%3D
		requestContent0049 = new String(Lib.binaryReplace(requestContent0049.getBytes(), binarySearchPattern0049_1, java.net.URLEncoder.encode(var__EVENTVALIDATION_1).getBytes(), 0));		// search within the request content for a binary pattern and replace it with a variable value
		requestContent0049 = Lib.replaceTextPattern(requestContent0049, "P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0", var__PREVIOUSPAGE, 0);		// search and replace content fragment "P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0" with variable 'var__PREVIOUSPAGE' on all occurrences

		String requestHeader0049 = "POST " + requestFile0049 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0049.length() + "\r\n" + 		// Content-Length: 2224
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0049, requestHost0049, requestPort0049, requestHeader0049, requestContent0049.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0049 = null;		// support garbage collector to reduce memory
		requestContent0049 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 6485
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "span id=\"MainContent_RemainingSecondaryLabel\"");		// Test [49] <- Index 49
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
		regExpBasedExtractor = new RegExpBasedExtractor(testURL.getContentString());

		// setup var extractor for 'var__CorrelationParameter_2'
		RegExpBasedExtractorItem regExpBasedContentExtractorItem0049_1 = new RegExpBasedExtractorItem( "id=\"__VIEWSTATE\" value=\"(.*?)\"" ,1,1,false);
		regExpBasedExtractor.addRegExpBasedExtractorItem(regExpBasedContentExtractorItem0049_1);

		// setup var extractor for 'var__EVENTVALIDATION_2'
		RegExpBasedExtractorItem regExpBasedContentExtractorItem0049_2 = new RegExpBasedExtractorItem( "id=\"__EVENTVALIDATION\" value=\"(.*?)\"" ,1,1,false);
		regExpBasedExtractor.addRegExpBasedExtractorItem(regExpBasedContentExtractorItem0049_2);

		regExpBasedExtractor.extractText();
		regExpBasedExtractor = new RegExpBasedExtractor(testURL.getHeaderString());

		regExpBasedExtractor.extractText();
		try
		{
			// extract var 'var__CorrelationParameter_2'
			var__CorrelationParameter_2 = regExpBasedContentExtractorItem0049_1.getResultText();
			log("<<< var__CorrelationParameter_2 = " + var__CorrelationParameter_2);
		}
		catch (Exception e) { var__CorrelationParameter_2 = null; log(e); }
		if (var__CorrelationParameter_2 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'var__CorrelationParameter_2' from regexp based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'var__EVENTVALIDATION_2'
			var__EVENTVALIDATION_2 = regExpBasedContentExtractorItem0049_2.getResultText();
			log("<<< var__EVENTVALIDATION_2 = " + var__EVENTVALIDATION_2);
		}
		catch (Exception e) { var__EVENTVALIDATION_2 = null; log(e); }
		if (var__EVENTVALIDATION_2 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'var__EVENTVALIDATION_2' from regexp based pattern";
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
		// # Page #6: MyShoppingCart.aspx_4 - Page6
		// # --------------------------------------



		// --- HTTP REQUEST: Test [51] <- WEB ADMIN Index 51 ---
		log();
		log("# title: View my shopping cart");
		String requestProt0051 = "https";
		String requestHost0051 = "cldemo.apicasystem.com";
		int    requestPort0051 = 443;
		String requestFile0051 = "/Checkout/MyShoppingCart.aspx";
		String requestContent0051 = 
				"__EVENTTARGET=" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=kiD0ulfuh4MJmQXDs5oe1i9vIlCKZIYk%2BbEzKen1ZZ3e2eMNh3F1m6KoR9ZjTo4rLCZf99zagMA14cS2PotfxoKFJ2X%2BIdbLpOSM2Gz3ec2s2gTV5EwsmlAZv1o8tfUxZV6Y7g%2FInPZ%2FnpdXvOUUZpj2H7JIw6rJCjU69dMu16MroNiSwb%2Bkixl7nxGfsnrQFg2IJK4b17Vc1AghN3hFrY3nKG474kcSHniunqGe1gxGPL5cehlBI%2B0Dsy42id7mQO0N%2BZfGNIrM8oLtu1v8HpqCIuOUzn9KxYloFI2QHT5%2BbW25mGq3K%2BeeQW3AYVoh5qt3R0gRwuZV8hRglXhxdhC1y%2FzZyI5zmV20Bja46Qi7IE%2Bng7hZlcs4CKGS%2Ba8NGva7GfVN3L9aENZxYaH9FAmy29wXkyjMSOHMmgk52YcykXERPlrZTYo7sjqReMHfSyT1Ex31jTA%2BUDbIguEhEKWJyjwj%2FnaHCgzyTqiNrfPESBJeW0%2BWXABYNSag64mUSMcjqaZYvPY9XXgDKRXeLePhnUUGoHI0Ja18jn20YEP3kc9KpkIizvqk9D5f4fuFc%2BqmBPshR71Ec32y1K%2F0c8%2Bh9Gp7hz5%2FH%2BWofl7jW49h4YmEu5KQG7vYk8bszpt7iM%2BtR4i0AdDwSDXZt6DpYNnZe2GfJLLeO%2F7E%2BQ8jdNw3p7eg8PklcsW7%2FUxeggRLxZv1aqlBwUQyVQCzE7QG%2BIUGjUBZAP9WqCaPcsI%2BRcyKf7UduBp7QSe3pRRxt2IEgt4ivPxHULOg1Ljkxb5uyDk7tniGC9WwBblwnex9a%2BNQoNVgEiCpRe80KSrgy1GQaTGFffkYD6B03qAjtaRAFgVGAZQ9Bf0QIMwOb9FM1IfSeyNZ0DHZqfwi4QDgQoSM4QFp6TTrc225N%2B%2Fll3wEvp2qH4GPxk%2FAPmvwthDsBTDNEEqGXsq3o4R2YL4VHjviBvw6rJsXnSFLIkUX%2BhmhdamnQ%2BuoGb3vWCQLar%2BHQSIEEhS%2Ff9vr1I8ExKzRAb5xyUs%2FwLxh17QXbeCh5j9%2B5ydaBaaW6yxVQuNgu%2BG0FO%2FYM%2FJGx6L0YZwtmIqbmHWC3yJMNJ35s5htiiumgjuVXJtFZsP1aO0a1h0WlOewR08Q0%2BUcwixKaA2zfqeajQN23%2BE4koh%2Fz%2B43f%2BAw6tVvaLYVetbOZHnA3RdDHOgI896mPpaVNFOZN9C91%2FbXrCUSTpNnH0UnQCMenp%2BcRQeSsDxLZtLHjQ8N0Yg3H%2FGnyjmeBO1TVvL23KEyx%2Bj5Llt%2BSpDatpk3CFvKr4HpykCZkvmx07WmbeKjCv53n1zGwT75wvm2BLTQnLHPVwVIFVeLIK25wQwS6C7YSEMz%2Bdz6ENra02IkRi%2F7p4l%2BaQKP9b0WyNW0b8PRSM%2FTN%2BoeQbSQgVtIOpTDaw7WJWMnZuNZX1HRW29aUgfi4VSNCLn27Tulxd7WdWqxvKwM71m0eUurzO5hS6%2BGxVXv9ixgLZ2nbSvLKD3iP7flap2kCeSPWgUJvsWNuZxsuxSOqxXX2phdbpsflB11lxf9o0tZs6yDu4s76EAfQBuRKghHrhUY3rhcTp8687qA5wQk6GyJBkOdk5morkIz45sKkITNYyM4gTa%2FZf0z8UZFKsaMBqWGnqzRIw%2Ff5Di4tgmJnI%2FVrB474FSNHw%3D%3D" +
				"&__VIEWSTATEENCRYPTED=" +
				"&__PREVIOUSPAGE=P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0" +
				"&__EVENTVALIDATION=za%2B9oVsUVrf%2FeGhS7pFYwEbxxHphLQOC3blxIMPquyVN3jsj2uILQGwRZWCGwTiO5YwwzV%2FPUiVPg6zQ1RF5XeC2K9r91iIXU%2FDz4xAkaIWW5Z4UecZfr3iqqaBlGyBYfRBQM8ep61Cdh92HP40vlNn5FkpBDc%2BoUjRz6%2B4k08iH5j%2F%2FpIY6WaP7IJ7h5O8DWFAboynjojnRTP2hMuUEC3MO3J9NfIcfV6ItUHxBshqg6ifSOdM1xxT4C0Zu0Oa%2BSAK9GryMIsiqAr5aL1nN1uT%2Bh5lQryqeWIZjKk5a4XxqlcYE" +
				"&ctl00%24MainContent%24WipAmountTextBox=0" +
				"&ctl00%24MainContent%24PrimaryAmountTextBox=0" +
				"&ctl00%24MainContent%24SecondaryAmountTextBox=3" +
				"&ctl00%24MainContent%24UpdateCartButton=Update+shopping+cart";
		byte[] binarySearchPattern0051_0 = Base64Decoder.decodeToBytes("a2lEMHVsZnVoNE1KbVFYRHM1b2UxaTl2SWxDS1pJWWslMkJiRXpLZW4xWlozZTJlTU5oM0YxbTZLb1I5WmpUbzRyTENaZjk5emFnTUExNGNTMlBvdGZ4b0tGSjJYJTJCSWRiTHBPU00yR3ozZWMyczJnVFY1RXdzbWxBWnYxbzh0ZlV4WlY2WTdnJTJGSW5QWiUyRm5wZFh2T1VVWnBqMkg3Skl3NnJKQ2pVNjlkTXUxNk1yb05pU3diJTJCa2l4bDdueEdmc25yUUZnMklKSzRiMTdWYzFBZ2hOM2hGclkzbktHNDc0a2NTSG5pdW5xR2UxZ3hHUEw1Y2VobEJJJTJCMERzeTQyaWQ3bVFPME4lMkJaZkdOSXJNOG9MdHUxdjhIcHFDSXVPVXpuOUt4WWxvRkkyUUhUNSUyQmJXMjVtR3EzSyUyQmVlUVczQVlWb2g1cXQzUjBnUnd1WlY4aFJnbFhoeGRoQzF5JTJGelp5STV6bVYyMEJqYTQ2UWk3SUUlMkJuZzdoWmxjczRDS0dTJTJCYThOR3ZhN0dmVk4zTDlhRU5aeFlhSDlGQW15Mjl3WGt5ak1TT0hNbWdrNTJZY3lrWEVSUGxyWlRZbzdzanFSZU1IZlN5VDFFeDMxalRBJTJCVURiSWd1RWhFS1dKeWp3aiUyRm5hSENnenlUcWlOcmZQRVNCSmVXMCUyQldYQUJZTlNhZzY0bVVTTWNqcWFaWXZQWTlYWGdES1JYZUxlUGhuVVVHb0hJMEphMThqbjIwWUVQM2tjOUtwa0lpenZxazlENWY0ZnVGYyUyQnFtQlBzaFI3MUVjMzJ5MUslMkYwYzglMkJoOUdwN2h6NSUyRkglMkJXb2ZsN2pXNDloNFltRXU1S1FHN3ZZazhic3pwdDdpTSUyQnRSNGkwQWREd1NEWFp0NkRwWU5uWmUyR2ZKTExlTyUyRjdFJTJCUThqZE53M3A3ZWc4UGtsY3NXNyUyRlV4ZWdnUkx4WnYxYXFsQndVUXlWUUN6RTdRRyUyQklVR2pVQlpBUDlXcUNhUGNzSSUyQlJjeUtmN1VkdUJwN1FTZTNwUlJ4dDJJRWd0NGl2UHhIVUxPZzFMamt4YjV1eURrN3RuaUdDOVd3QmJsd25leDlhJTJCTlFvTlZnRWlDcFJlODBLU3JneTFHUWFUR0ZmZmtZRDZCMDNxQWp0YVJBRmdWR0FaUTlCZjBRSU13T2I5Rk0xSWZTZXlOWjBESFpxZndpNFFEZ1FvU000UUZwNlRUcmMyMjVOJTJCJTJGbGwzd0V2cDJxSDRHUHhrJTJGQVBtdnd0aERzQlRETkVFcUdYc3EzbzRSMllMNFZIanZpQnZ3NnJKc1huU0ZMSWtVWCUyQmhtaGRhbW5RJTJCdW9HYjN2V0NRTGFyJTJCSFFTSUVFaFMlMkZmOXZyMUk4RXhLelJBYjV4eVVzJTJGd0x4aDE3UVhiZUNoNWo5JTJCNXlkYUJhYVc2eXhWUXVOZ3UlMkJHMEZPJTJGWU0lMkZKR3g2TDBZWnd0bUlxYm1IV0MzeUpNTkozNXM1aHRpaXVtZ2p1VlhKdEZac1AxYU8wYTFoMFdsT2V3UjA4UTAlMkJVY3dpeEthQTJ6ZnFlYWpRTjIzJTJCRTRrb2glMkZ6JTJCNDNmJTJCQXc2dFZ2YUxZVmV0Yk9aSG5BM1JkREhPZ0k4OTZtUHBhVk5GT1pOOUM5MSUyRmJYckNVU1RwTm5IMFVuUUNNZW5wJTJCY1JRZVNzRHhMWnRMSGpROE4wWWczSCUyRkdueWptZUJPMVRWdkwyM0tFeXglMkJqNUxsdCUyQlNwRGF0cGszQ0Z2S3I0SHB5a0Naa3ZteDA3V21iZUtqQ3Y1M24xekd3VDc1d3ZtMkJMVFFuTEhQVndWSUZWZUxJSzI1d1F3UzZDN1lTRU16JTJCZHo2RU5yYTAySWtSaSUyRjdwNGwlMkJhUUtQOWIwV3lOVzBiOFBSU00lMkZUTiUyQm9lUWJTUWdWdElPcFREYXc3V0pXTW5adU5aWDFIUlcyOWFVZ2ZpNFZTTkNMbjI3VHVseGQ3V2RXcXh2S3dNNzFtMGVVdXJ6TzVoUzYlMkJHeFZYdjlpeGdMWjJuYlN2TEtEM2lQN2ZsYXAya0NlU1BXZ1VKdnNXTnVaeHN1eFNPcXhYWDJwaGRicHNmbEIxMWx4ZjlvMHRaczZ5RHU0czc2RUFmUUJ1UktnaEhyaFVZM3JoY1RwODY4N3FBNXdRazZHeUpCa09kazVtb3JrSXo0NXNLa0lUTll5TTRnVGElMkZaZjB6OFVaRktzYU1CcVdHbnF6Ukl3JTJGZjVEaTR0Z21KbkklMkZWckI0NzRGU05IdyUzRCUzRA==");		// note: the search pattern value is base 64 encoded. decoded value = kiD0ulfuh4MJmQXDs5oe1i9vIlCKZIYk%2BbEzKen1ZZ3e2eMNh3F1m6KoR9ZjTo4rLCZf99zagMA14cS2PotfxoKFJ2X%2BIdbLpOSM2Gz3ec2s2gTV5EwsmlAZv1o8tfUxZV6Y7g%2FInPZ%2FnpdXvOUUZpj2H7JIw6rJCjU69dMu16MroNiSwb%2Bkixl7nxGfsnrQFg2IJK4b17Vc1AghN3hFrY3nKG474kcSHniunqGe1gxGPL5cehlBI%2B0Dsy42id7mQO0N%2BZfGNIrM8oLtu1v8HpqCIuOUzn9KxYloFI2QHT5%2BbW25mGq3K%2BeeQW3AYVoh5qt3R0gRwuZV8hRglXhxdhC1y%2FzZyI5zmV20Bja46Qi7IE%2Bng7hZlcs4CKGS%2Ba8NGva7GfVN3L9aENZxYaH9FAmy29wXkyjMSOHMmgk52YcykXERPlrZTYo7sjqReMHfSyT1Ex31jTA%2BUDbIguEhEKWJyjwj%2FnaHCgzyTqiNrfPESBJeW0%2BWXABYNSag64mUSMcjqaZYvPY9XXgDKRXeLePhnUUGoHI0Ja18jn20YEP3kc9KpkIizvqk9D5f4fuFc%2BqmBPshR71Ec32y1K%2F0c8%2Bh9Gp7hz5%2FH%2BWofl7jW49h4YmEu5KQG7vYk8bszpt7iM%2BtR4i0AdDwSDXZt6DpYNnZe2GfJLLeO%2F7E%2BQ8jdNw3p7eg8PklcsW7%2FUxeggRLxZv1aqlBwUQyVQCzE7QG%2BIUGjUBZAP9WqCaPcsI%2BRcyKf7UduBp7QSe3pRRxt2IEgt4ivPxHULOg1Ljkxb5uyDk7tniGC9WwBblwnex9a%2BNQoNVgEiCpRe80KSrgy1GQaTGFffkYD6B03qAjtaRAFgVGAZQ9Bf0QIMwOb9FM1IfSeyNZ0DHZqfwi4QDgQoSM4QFp6TTrc225N%2B%2Fll3wEvp2qH4GPxk%2FAPmvwthDsBTDNEEqGXsq3o4R2YL4VHjviBvw6rJsXnSFLIkUX%2BhmhdamnQ%2BuoGb3vWCQLar%2BHQSIEEhS%2Ff9vr1I8ExKzRAb5xyUs%2FwLxh17QXbeCh5j9%2B5ydaBaaW6yxVQuNgu%2BG0FO%2FYM%2FJGx6L0YZwtmIqbmHWC3yJMNJ35s5htiiumgjuVXJtFZsP1aO0a1h0WlOewR08Q0%2BUcwixKaA2zfqeajQN23%2BE4koh%2Fz%2B43f%2BAw6tVvaLYVetbOZHnA3RdDHOgI896mPpaVNFOZN9C91%2FbXrCUSTpNnH0UnQCMenp%2BcRQeSsDxLZtLHjQ8N0Yg3H%2FGnyjmeBO1TVvL23KEyx%2Bj5Llt%2BSpDatpk3CFvKr4HpykCZkvmx07WmbeKjCv53n1zGwT75wvm2BLTQnLHPVwVIFVeLIK25wQwS6C7YSEMz%2Bdz6ENra02IkRi%2F7p4l%2BaQKP9b0WyNW0b8PRSM%2FTN%2BoeQbSQgVtIOpTDaw7WJWMnZuNZX1HRW29aUgfi4VSNCLn27Tulxd7WdWqxvKwM71m0eUurzO5hS6%2BGxVXv9ixgLZ2nbSvLKD3iP7flap2kCeSPWgUJvsWNuZxsuxSOqxXX2phdbpsflB11lxf9o0tZs6yDu4s76EAfQBuRKghHrhUY3rhcTp8687qA5wQk6GyJBkOdk5morkIz45sKkITNYyM4gTa%2FZf0z8UZFKsaMBqWGnqzRIw%2Ff5Di4tgmJnI%2FVrB474FSNHw%3D%3D
		requestContent0051 = new String(Lib.binaryReplace(requestContent0051.getBytes(), binarySearchPattern0051_0, java.net.URLEncoder.encode(var__CorrelationParameter_2).getBytes(), 0));		// search within the request content for a binary pattern and replace it with a variable value
		byte[] binarySearchPattern0051_1 = Base64Decoder.decodeToBytes("emElMkI5b1ZzVVZyZiUyRmVHaFM3cEZZd0VieHhIcGhMUU9DM2JseElNUHF1eVZOM2pzajJ1SUxRR3dSWldDR3dUaU81WXd3elYlMkZQVWlWUGc2elExUkY1WGVDMks5cjkxaUlYVSUyRkR6NHhBa2FJV1c1WjRVZWNaZnIzaXFxYUJsR3lCWWZSQlFNOGVwNjFDZGg5MkhQNDB2bE5uNUZrcEJEYyUyQm9ValJ6NiUyQjRrMDhpSDVqJTJGJTJGcElZNldhUDdJSjdoNU84RFdGQWJveW5qb2puUlRQMmhNdVVFQzNNTzNKOU5mSWNmVjZJdFVIeEJzaHFnNmlmU09kTTF4eFQ0QzBadTBPYSUyQlNBSzlHcnlNSXNpcUFyNWFMMW5OMXVUJTJCaDVsUXJ5cWVXSVpqS2s1YTRYeHFsY1lF");		// note: the search pattern value is base 64 encoded. decoded value = za%2B9oVsUVrf%2FeGhS7pFYwEbxxHphLQOC3blxIMPquyVN3jsj2uILQGwRZWCGwTiO5YwwzV%2FPUiVPg6zQ1RF5XeC2K9r91iIXU%2FDz4xAkaIWW5Z4UecZfr3iqqaBlGyBYfRBQM8ep61Cdh92HP40vlNn5FkpBDc%2BoUjRz6%2B4k08iH5j%2F%2FpIY6WaP7IJ7h5O8DWFAboynjojnRTP2hMuUEC3MO3J9NfIcfV6ItUHxBshqg6ifSOdM1xxT4C0Zu0Oa%2BSAK9GryMIsiqAr5aL1nN1uT%2Bh5lQryqeWIZjKk5a4XxqlcYE
		requestContent0051 = new String(Lib.binaryReplace(requestContent0051.getBytes(), binarySearchPattern0051_1, java.net.URLEncoder.encode(var__EVENTVALIDATION_2).getBytes(), 0));		// search within the request content for a binary pattern and replace it with a variable value
		requestContent0051 = Lib.replaceTextPattern(requestContent0051, "P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0", var__PREVIOUSPAGE, 0);		// search and replace content fragment "P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0" with variable 'var__PREVIOUSPAGE' on all occurrences

		String requestHeader0051 = "POST " + requestFile0051 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0051.length() + "\r\n" + 		// Content-Length: 2523
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0051, requestHost0051, requestPort0051, requestHeader0051, requestContent0051.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0051 = null;		// support garbage collector to reduce memory
		requestContent0051 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 6494
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "span id=\"MainContent_RemainingSecondaryLabel\"");		// Test [51] <- Index 51
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
		regExpBasedExtractor = new RegExpBasedExtractor(testURL.getContentString());

		// setup var extractor for 'var__CorrelationParameter_3'
		RegExpBasedExtractorItem regExpBasedContentExtractorItem0051_1 = new RegExpBasedExtractorItem( "id=\"__VIEWSTATE\" value=\"(.*?)\"" ,1,1,false);
		regExpBasedExtractor.addRegExpBasedExtractorItem(regExpBasedContentExtractorItem0051_1);

		// setup var extractor for 'var__EVENTVALIDATION_3'
		RegExpBasedExtractorItem regExpBasedContentExtractorItem0051_2 = new RegExpBasedExtractorItem( "id=\"__EVENTVALIDATION\" value=\"(.*?)\"" ,1,1,false);
		regExpBasedExtractor.addRegExpBasedExtractorItem(regExpBasedContentExtractorItem0051_2);

		regExpBasedExtractor.extractText();
		regExpBasedExtractor = new RegExpBasedExtractor(testURL.getHeaderString());

		regExpBasedExtractor.extractText();
		try
		{
			// extract var 'var__CorrelationParameter_3'
			var__CorrelationParameter_3 = regExpBasedContentExtractorItem0051_1.getResultText();
			log("<<< var__CorrelationParameter_3 = " + var__CorrelationParameter_3);
		}
		catch (Exception e) { var__CorrelationParameter_3 = null; log(e); }
		if (var__CorrelationParameter_3 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'var__CorrelationParameter_3' from regexp based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'var__EVENTVALIDATION_3'
			var__EVENTVALIDATION_3 = regExpBasedContentExtractorItem0051_2.getResultText();
			log("<<< var__EVENTVALIDATION_3 = " + var__EVENTVALIDATION_3);
		}
		catch (Exception e) { var__EVENTVALIDATION_3 = null; log(e); }
		if (var__EVENTVALIDATION_3 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'var__EVENTVALIDATION_3' from regexp based pattern";
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
		// # Page #7: PayAndCheckout.aspx - Page7
		// # ------------------------------------



		// --- HTTP REQUEST: Test [53] <- WEB ADMIN Index 53 ---
		log();
		log("# title: Pay and check out");
		String requestProt0053 = "https";
		String requestHost0053 = "cldemo.apicasystem.com";
		int    requestPort0053 = 443;
		String requestFile0053 = "/Checkout/PayAndCheckout.aspx";
		String requestContent0053 = 
				"__EVENTTARGET=ctl00%24MainContent%24CheckoutLinkButton" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=g2bOFCLZv27uTAn%2BffOXF%2BZe2rGXARKG0T5JPm5lnuw8HgndhGsVnYJiW9dtdykidrGlA%2BPHcF9z9CQdbxqSOJoHJiVQHcV53Jg56hSoOFN9IPsv9p%2By%2BZGWZtWbdSbn1DW%2FBqbABEg%2F6H7Re6sjJGjmuKfE8YorwEqCrBreAqSe2DP4rVd9QA6G8LFM2s60MBx8fvAHFwhtDYinOjbJw5z%2BM2kVPw16LMMDBvc8FlhhwvWesfvBURyrGQw3z7RBuv%2BAGlDOubus6DKOCbxDdZnL8TfO6iOjnQ9XjvWUvXMq7j%2FzWGucSDQnRSHCi%2BKwf2JJocu9U6VZmIxk0ATZKBMEncTpSS90MQwX6Xuf34UN%2BZJg6neZwVG3TmaIgMrEtdJFCTXQNTtrc1JsHc%2B6r5JY%2BmwVbUJBH4WATVrY6J57tgHYwNN5RvDS92PsYnWS5sDpN88XxUY9CRLTDa%2FyO%2FthW5LZobIimunGMoJHdhNV0yRSUgskMDSYqAcPpec0nqErj3gdJjaMxypPr3X0N%2ByKksh7Du%2BocNm2aP6biCMqhUERZNCgu00ceEAW9VKSmILUkCfGbFTyxlVQR8TVypsluvvyCXNglM583TXaQf5KxPm8z%2BmftEvnERQamWaUTRimkeUPETnx%2FjMqKdKFGNk45MFspHap3gnPfKtmL9Mmi8u7gz3ttdXQx%2BSGK%2FT1F58tiA%2F%2F0rXqJi7jv0iVkrRSIG025BYZDFx15%2BqCFVnQ8FINn401vjlPaInmDTzQF%2FbdCjh9hCSxXWHQwolecSjYt%2BOS1SkvGsro%2B%2FN3daAgWgGYiTSSDCe7Om6A5lj8fNSGxeG9YNsqY7n9Bp5yc6mdyX8PUrtg5KCv57%2F%2BajW3gjK1rCVLkT5R1QgnB7bEaf1bwpzNCvSIIEOC7qDKsJ5DWHAj8498t%2BGXeYork4WFyWMcqp4bPh3sScANRnq88SQH3BijwL5umDxVaa8tuLG%2BfNm4bx7hyN6QqQRvWnx6g7ROejqBvzRR5Arqik2JzsEW1VQXKi2QdM8iGy5m%2Bomnr4NmW6N6pDyIlY5BPQTNS0QpNgXVT3podnZahYPLKQAWjkrJDaPCOphBM%2BhNwty2uJsvIkkt4k0j7wwPbYyACQoRD0wXUbYxlY0yxoc7hv%2FBwF128YqyGBsOX02R%2Bh2Aa5%2BZ617nIgYRcIqLwk62XX3opcLF5gB6JjbLOP%2FqWra4YniERvrikvqehACL2eZUEmbG3PZt6iDTC3y3ziyV2vms7xJ0R3gCVLoU5bB1j496RQMPErFn%2FP4niwE3%2FB63JMnK43c%2FK9cBciWAUMOfJBRAR75OFhnmAEnsp%2B2qPHrFevvkTHf5XefXDSxTXfiV3kHbaPyaiRabLKRb7OTIxyJhTm1%2BdJ7X2TIglxq2jyghkEUnNn5o3qzZhfltCfgub3EvSwW5OToRCkQQEjRphYudwKPlvuS2BOo9XCc75b7t%2Fc%2BaQfdhtvLKiBNYiqcqeI7FIe3WJ3Rh9o%2BaQ31pGvGM5XQJpSxSeWwM7JruI60lG%2FGHWggLsrP8lQxg1H0r2Rt%2Bl%2FElAWgGaw%2FwfDVj1LzjHllvNuavj8Av1A5wTS3C9rU0B9ud62ROHLABM6YS%2Fnst8PCzYIGcdWhGUolxJr3lQ5n%2FrM%2F3a9xZBWI5CAvCvX%2BObc%2BMPzKNZaqI9AOSde0%3D" +
				"&__VIEWSTATEENCRYPTED=" +
				"&__PREVIOUSPAGE=P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0" +
				"&__EVENTVALIDATION=Q%2FaMkBPGPqR%2BUPAI1wrecie%2FokWhiC2mKHlNEDpedvtWLPF%2BHvbMv62zLK54WiVL85n3y0JoxAwI3ChLm88HcyHMKdyR6J%2Fi8esLBdl6YuZGl6RPjX894e29eU4PgBRNmk5vrySlM3I6pd4JyKyhJ3znGg2zPSNg7UYLQb%2BT7730PozATawvB7HJ1pnnz9yzwEIV%2BlbHvPiVCp%2F0fIreUQMQrfvj0VWgcX06FcR090inSY8JEh%2FPwK%2FrHK3h5kbOIQkrvM2GYpIVH4wZaZkObTNS5vlUSFwGcpWs5Lr6yOM5H8pN" +
				"&ctl00%24MainContent%24WipAmountTextBox=0" +
				"&ctl00%24MainContent%24PrimaryAmountTextBox=0" +
				"&ctl00%24MainContent%24SecondaryAmountTextBox=3";
		byte[] binarySearchPattern0053_0 = Base64Decoder.decodeToBytes("ZzJiT0ZDTFp2Mjd1VEFuJTJCZmZPWEYlMkJaZTJyR1hBUktHMFQ1SlBtNWxudXc4SGduZGhHc1ZuWUppVzlkdGR5a2lkckdsQSUyQlBIY0Y5ejlDUWRieHFTT0pvSEppVlFIY1Y1M0pnNTZoU29PRk45SVBzdjlwJTJCeSUyQlpHV1p0V2JkU2JuMURXJTJGQnFiQUJFZyUyRjZIN1JlNnNqSkdqbXVLZkU4WW9yd0VxQ3JCcmVBcVNlMkRQNHJWZDlRQTZHOExGTTJzNjBNQng4ZnZBSEZ3aHREWWluT2piSnc1eiUyQk0ya1ZQdzE2TE1NREJ2YzhGbGhod3ZXZXNmdkJVUnlyR1F3M3o3UkJ1diUyQkFHbERPdWJ1czZES09DYnhEZFpuTDhUZk82aU9qblE5WGp2V1V2WE1xN2olMkZ6V0d1Y1NEUW5SU0hDaSUyQkt3ZjJKSm9jdTlVNlZabUl4azBBVFpLQk1FbmNUcFNTOTBNUXdYNlh1ZjM0VU4lMkJaSmc2bmVad1ZHM1RtYUlnTXJFdGRKRkNUWFFOVHRyYzFKc0hjJTJCNnI1SlklMkJtd1ZiVUpCSDRXQVRWclk2SjU3dGdIWXdOTjVSdkRTOTJQc1luV1M1c0RwTjg4WHhVWTlDUkxURGElMkZ5TyUyRnRoVzVMWm9iSWltdW5HTW9KSGRoTlYweVJTVWdza01EU1lxQWNQcGVjMG5xRXJqM2dkSmphTXh5cFByM1gwTiUyQnlLa3NoN0R1JTJCb2NObTJhUDZiaUNNcWhVRVJaTkNndTAwY2VFQVc5VktTbUlMVWtDZkdiRlR5eGxWUVI4VFZ5cHNsdXZ2eUNYTmdsTTU4M1RYYVFmNUt4UG04eiUyQm1mdEV2bkVSUWFtV2FVVFJpbWtlVVBFVG54JTJGak1xS2RLRkdOazQ1TUZzcEhhcDNnblBmS3RtTDlNbWk4dTdnejN0dGRYUXglMkJTR0slMkZUMUY1OHRpQSUyRiUyRjByWHFKaTdqdjBpVmtyUlNJRzAyNUJZWkRGeDE1JTJCcUNGVm5ROEZJTm40MDF2amxQYUlubURUelFGJTJGYmRDamg5aENTeFhXSFF3b2xlY1NqWXQlMkJPUzFTa3ZHc3JvJTJCJTJGTjNkYUFnV2dHWWlUU1NEQ2U3T202QTVsajhmTlNHeGVHOVlOc3FZN245QnA1eWM2bWR5WDhQVXJ0ZzVLQ3Y1NyUyRiUyQmFqVzNnaksxckNWTGtUNVIxUWduQjdiRWFmMWJ3cHpOQ3ZTSUlFT0M3cURLc0o1RFdIQWo4NDk4dCUyQkdYZVlvcms0V0Z5V01jcXA0YlBoM3NTY0FOUm5xODhTUUgzQmlqd0w1dW1EeFZhYTh0dUxHJTJCZk5tNGJ4N2h5TjZRcVFSdldueDZnN1JPZWpxQnZ6UlI1QXJxaWsySnpzRVcxVlFYS2kyUWRNOGlHeTVtJTJCb21ucjRObVc2TjZwRHlJbFk1QlBRVE5TMFFwTmdYVlQzcG9kblphaFlQTEtRQVdqa3JKRGFQQ09waEJNJTJCaE53dHkydUpzdklra3Q0azBqN3d3UGJZeUFDUW9SRDB3WFViWXhsWTB5eG9jN2h2JTJGQndGMTI4WXF5R0JzT1gwMlIlMkJoMkFhNSUyQlo2MTduSWdZUmNJcUx3azYyWFgzb3BjTEY1Z0I2SmpiTE9QJTJGcVdyYTRZbmlFUnZyaWt2cWVoQUNMMmVaVUVtYkczUFp0NmlEVEMzeTN6aXlWMnZtczd4SjBSM2dDVkxvVTViQjFqNDk2UlFNUEVyRm4lMkZQNG5pd0UzJTJGQjYzSk1uSzQzYyUyRks5Y0JjaVdBVU1PZkpCUkFSNzVPRmhubUFFbnNwJTJCMnFQSHJGZXZ2a1RIZjVYZWZYRFN4VFhmaVYza0hiYVB5YWlSYWJMS1JiN09USXh5SmhUbTElMkJkSjdYMlRJZ2x4cTJqeWdoa0VVbk5uNW8zcXpaaGZsdENmZ3ViM0V2U3dXNU9Ub1JDa1FRRWpScGhZdWR3S1BsdnVTMkJPbzlYQ2M3NWI3dCUyRmMlMkJhUWZkaHR2TEtpQk5ZaXFjcWVJN0ZJZTNXSjNSaDlvJTJCYVEzMXBHdkdNNVhRSnBTeFNlV3dNN0pydUk2MGxHJTJGR0hXZ2dMc3JQOGxReGcxSDByMlJ0JTJCbCUyRkVsQVdnR2F3JTJGd2ZEVmoxTHpqSGxsdk51YXZqOEF2MUE1d1RTM0M5clUwQjl1ZDYyUk9ITEFCTTZZUyUyRm5zdDhQQ3pZSUdjZFdoR1VvbHhKcjNsUTVuJTJGck0lMkYzYTl4WkJXSTVDQXZDdlglMkJPYmMlMkJNUHpLTlphcUk5QU9TZGUwJTNE");		// note: the search pattern value is base 64 encoded. decoded value = g2bOFCLZv27uTAn%2BffOXF%2BZe2rGXARKG0T5JPm5lnuw8HgndhGsVnYJiW9dtdykidrGlA%2BPHcF9z9CQdbxqSOJoHJiVQHcV53Jg56hSoOFN9IPsv9p%2By%2BZGWZtWbdSbn1DW%2FBqbABEg%2F6H7Re6sjJGjmuKfE8YorwEqCrBreAqSe2DP4rVd9QA6G8LFM2s60MBx8fvAHFwhtDYinOjbJw5z%2BM2kVPw16LMMDBvc8FlhhwvWesfvBURyrGQw3z7RBuv%2BAGlDOubus6DKOCbxDdZnL8TfO6iOjnQ9XjvWUvXMq7j%2FzWGucSDQnRSHCi%2BKwf2JJocu9U6VZmIxk0ATZKBMEncTpSS90MQwX6Xuf34UN%2BZJg6neZwVG3TmaIgMrEtdJFCTXQNTtrc1JsHc%2B6r5JY%2BmwVbUJBH4WATVrY6J57tgHYwNN5RvDS92PsYnWS5sDpN88XxUY9CRLTDa%2FyO%2FthW5LZobIimunGMoJHdhNV0yRSUgskMDSYqAcPpec0nqErj3gdJjaMxypPr3X0N%2ByKksh7Du%2BocNm2aP6biCMqhUERZNCgu00ceEAW9VKSmILUkCfGbFTyxlVQR8TVypsluvvyCXNglM583TXaQf5KxPm8z%2BmftEvnERQamWaUTRimkeUPETnx%2FjMqKdKFGNk45MFspHap3gnPfKtmL9Mmi8u7gz3ttdXQx%2BSGK%2FT1F58tiA%2F%2F0rXqJi7jv0iVkrRSIG025BYZDFx15%2BqCFVnQ8FINn401vjlPaInmDTzQF%2FbdCjh9hCSxXWHQwolecSjYt%2BOS1SkvGsro%2B%2FN3daAgWgGYiTSSDCe7Om6A5lj8fNSGxeG9YNsqY7n9Bp5yc6mdyX8PUrtg5KCv57%2F%2BajW3gjK1rCVLkT5R1QgnB7bEaf1bwpzNCvSIIEOC7qDKsJ5DWHAj8498t%2BGXeYork4WFyWMcqp4bPh3sScANRnq88SQH3BijwL5umDxVaa8tuLG%2BfNm4bx7hyN6QqQRvWnx6g7ROejqBvzRR5Arqik2JzsEW1VQXKi2QdM8iGy5m%2Bomnr4NmW6N6pDyIlY5BPQTNS0QpNgXVT3podnZahYPLKQAWjkrJDaPCOphBM%2BhNwty2uJsvIkkt4k0j7wwPbYyACQoRD0wXUbYxlY0yxoc7hv%2FBwF128YqyGBsOX02R%2Bh2Aa5%2BZ617nIgYRcIqLwk62XX3opcLF5gB6JjbLOP%2FqWra4YniERvrikvqehACL2eZUEmbG3PZt6iDTC3y3ziyV2vms7xJ0R3gCVLoU5bB1j496RQMPErFn%2FP4niwE3%2FB63JMnK43c%2FK9cBciWAUMOfJBRAR75OFhnmAEnsp%2B2qPHrFevvkTHf5XefXDSxTXfiV3kHbaPyaiRabLKRb7OTIxyJhTm1%2BdJ7X2TIglxq2jyghkEUnNn5o3qzZhfltCfgub3EvSwW5OToRCkQQEjRphYudwKPlvuS2BOo9XCc75b7t%2Fc%2BaQfdhtvLKiBNYiqcqeI7FIe3WJ3Rh9o%2BaQ31pGvGM5XQJpSxSeWwM7JruI60lG%2FGHWggLsrP8lQxg1H0r2Rt%2Bl%2FElAWgGaw%2FwfDVj1LzjHllvNuavj8Av1A5wTS3C9rU0B9ud62ROHLABM6YS%2Fnst8PCzYIGcdWhGUolxJr3lQ5n%2FrM%2F3a9xZBWI5CAvCvX%2BObc%2BMPzKNZaqI9AOSde0%3D
		requestContent0053 = new String(Lib.binaryReplace(requestContent0053.getBytes(), binarySearchPattern0053_0, java.net.URLEncoder.encode(var__CorrelationParameter_3).getBytes(), 0));		// search within the request content for a binary pattern and replace it with a variable value
		byte[] binarySearchPattern0053_1 = Base64Decoder.decodeToBytes("USUyRmFNa0JQR1BxUiUyQlVQQUkxd3JlY2llJTJGb2tXaGlDMm1LSGxORURwZWR2dFdMUEYlMkJIdmJNdjYyekxLNTRXaVZMODVuM3kwSm94QXdJM0NoTG04OEhjeUhNS2R5UjZKJTJGaThlc0xCZGw2WXVaR2w2UlBqWDg5NGUyOWVVNFBnQlJObWs1dnJ5U2xNM0k2cGQ0SnlLeWhKM3puR2cyelBTTmc3VVlMUWIlMkJUNzczMFBvekFUYXd2QjdISjFwbm56OXl6d0VJViUyQmxiSHZQaVZDcCUyRjBmSXJlVVFNUXJmdmowVldnY1gwNkZjUjA5MGluU1k4SkVoJTJGUHdLJTJGckhLM2g1a2JPSVFrcnZNMkdZcElWSDR3WmFaa09iVE5TNXZsVVNGd0djcFdzNUxyNnlPTTVIOHBO");		// note: the search pattern value is base 64 encoded. decoded value = Q%2FaMkBPGPqR%2BUPAI1wrecie%2FokWhiC2mKHlNEDpedvtWLPF%2BHvbMv62zLK54WiVL85n3y0JoxAwI3ChLm88HcyHMKdyR6J%2Fi8esLBdl6YuZGl6RPjX894e29eU4PgBRNmk5vrySlM3I6pd4JyKyhJ3znGg2zPSNg7UYLQb%2BT7730PozATawvB7HJ1pnnz9yzwEIV%2BlbHvPiVCp%2F0fIreUQMQrfvj0VWgcX06FcR090inSY8JEh%2FPwK%2FrHK3h5kbOIQkrvM2GYpIVH4wZaZkObTNS5vlUSFwGcpWs5Lr6yOM5H8pN
		requestContent0053 = new String(Lib.binaryReplace(requestContent0053.getBytes(), binarySearchPattern0053_1, java.net.URLEncoder.encode(var__EVENTVALIDATION_3).getBytes(), 0));		// search within the request content for a binary pattern and replace it with a variable value
		requestContent0053 = Lib.replaceTextPattern(requestContent0053, "P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0", var__PREVIOUSPAGE, 0);		// search and replace content fragment "P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0" with variable 'var__PREVIOUSPAGE' on all occurrences

		String requestHeader0053 = "POST " + requestFile0053 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0053.length() + "\r\n" + 		// Content-Length: 2517
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0053, requestHost0053, requestPort0053, requestHeader0053, requestContent0053.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0053 = null;		// support garbage collector to reduce memory
		requestContent0053 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 14968
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Please provide 16 digits with or without dashes");		// Test [53] <- Index 53
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
		regExpBasedExtractor = new RegExpBasedExtractor(testURL.getContentString());

		// setup var extractor for 'var__PREVIOUSPAGE_1'
		RegExpBasedExtractorItem regExpBasedContentExtractorItem0053_1 = new RegExpBasedExtractorItem( "id=\"__PREVIOUSPAGE\" value=\"(.*?)\"" ,1,1,false);
		regExpBasedExtractor.addRegExpBasedExtractorItem(regExpBasedContentExtractorItem0053_1);

		regExpBasedExtractor.extractText();
		regExpBasedExtractor = new RegExpBasedExtractor(testURL.getHeaderString());

		regExpBasedExtractor.extractText();
		try
		{
			// extract var 'var__PREVIOUSPAGE_1'
			var__PREVIOUSPAGE_1 = regExpBasedContentExtractorItem0053_1.getResultText();
			log("<<< var__PREVIOUSPAGE_1 = " + var__PREVIOUSPAGE_1);
		}
		catch (Exception e) { var__PREVIOUSPAGE_1 = null; log(e); }
		if (var__PREVIOUSPAGE_1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'var__PREVIOUSPAGE_1' from regexp based pattern";
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





		// --- HTTP REQUEST: Test [54] <- WEB ADMIN Index 54 ---
		String requestProt0054 = "https";
		String requestHost0054 = "cldemo.apicasystem.com";
		int    requestPort0054 = 443;
		String requestFile0054 = "/ScriptResource.axd" +
				"?d=jOGxQGN59jALlw_Z1PRxPfmS-Xppvs8izQfuNMHYj35_zT6Zd3JCd5GnuBy_KVgc3vcdXbkfuK0SsSvYck6nRpmvO8TXLM9OC4xICzx9PeHHLdOSU5QqsTI9r7E0Th_QhpDzrlKE2Xt8LScmVEPDBF4RJyg1" +
				"&t=362a7238";
		String requestHeader0054 = "GET " + requestFile0054 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0054, requestHost0054, requestPort0054, requestHeader0054, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0054 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5479
		// content test algorithm: check size +/- 5%, defined content size = 5479
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 5479, 5);		// Test [54] <- Index 54
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





		// --- HTTP REQUEST: Test [55] <- WEB ADMIN Index 55 ---
		String requestProt0055 = "https";
		String requestHost0055 = "www.google-analytics.com";
		int    requestPort0055 = 443;
		String requestFile0055 = "/__utm.gif" +
				"?utmwv=5.6.7" +
				"&utms=10" +
				"&utmn=630670621" +
				"&utmhn=cldemo.apicasystem.com" +
				"&utmcs=UTF-8" +
				"&utmsr=1707x1067" +
				"&utmvp=1707x966" +
				"&utmsc=24-bit" +
				"&utmul=sv" +
				"&utmje=0" +
				"&utmfl=22.0%20r0" +
				"&utmdt=Pay%20and%20check%20out" +
				"&utmhid=74667400" +
				"&utmr=0" +
				"&utmp=%2FCheckout%2FPayAndCheckout.aspx" +
				"&utmht=1470148948101" +
				"&utmac=UA-48859361-1" +
				"&utmcc=__utma%3D27385454.1964353227.1470148861.1470148861.1470148861.1%3B%2B__utmz%3D27385454.1470148861.1.1.utmcsr%3D(direct)%7Cutmccn%3D(direct)%7Cutmcmd%3D(none)%3B" +
				"&utmjid=" +
				"&utmu=qAAAAAAAAAAAAAAAAAAAAAAE~";
		String requestHeader0055 = "GET " + requestFile0055 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.google-analytics.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0055, requestHost0055, requestPort0055, requestHeader0055, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0055 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 35
		// content test algorithm: check size +/- 5%, defined content size = 35
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 35, 5);		// Test [55] <- Index 55
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





		// --- HTTP REQUEST: Test [56] <- WEB ADMIN Index 56 ---
		log();
		log("# title: Error 400 (Bad Request)!!1");
		String requestProt0056 = "https";
		String requestHost0056 = "clients4.google.com";
		int    requestPort0056 = 443;
		String requestFile0056 = "/uma/v2";
		String requestHeader0056 = "POST " + requestFile0056 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: clients4.google.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Type: application/vnd.chrome.uma\r\n" + 
				"Content-Length: 0\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0056, requestHost0056, requestPort0056, requestHeader0056, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0056 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 400, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 1555
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {400}, null, null, null);		// Test [56] <- Index 56
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



		// all http requests of page #7 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #8.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_8(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// # Page #8: PayAndCheckout.aspx_2 - Page8
		// # --------------------------------------



		// --- HTTP REQUEST: Test [58] <- WEB ADMIN Index 58 ---
		log();
		log("# title: Pay and check out");
		String requestProt0058 = "https";
		String requestHost0058 = "cldemo.apicasystem.com";
		int    requestPort0058 = 443;
		String requestFile0058 = "/Checkout/PayAndCheckout.aspx";
		String requestContent0058 = 
				"__EVENTTARGET=" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=%2FwEPDwULLTE1OTMxMDgyMzAPZBYCZg9kFgICAw9kFgYCDQ9kFgJmD2QWAgIBDxYCHgRUZXh0BQkzIHRpY2tldHNkAhQPZBYCAgEPZBYCAgEPZBYCAgEPZBYEZg9kFgJmDw8WAh8ABQEzZGQCAQ9kFgJmDw8WAh8ABQM5MDBkZAIZDxYCHgtfIUl0ZW1Db3VudAIBFgJmD2QWAgIBDxYCHgNzcmMFGH4vSW1hZ2VzL0xvZ29zL2F6dXJlLnBuZ2Rk%2BXlMjYpQwPp4wA%2Fobx0c0rpGF30%3D" +
				"&__PREVIOUSPAGE=X1D7lKVFLKxnD6o_HB8q5Ns9XEjJFfkeGqyX9qfSrRiknf_6dIU2GcQBEZJC2_2s5c4fb8f25Wy4fcw19HArtH0QotjOiPpKlQEmmXaEa9FDBZ8n0" +
				"&__EVENTVALIDATION=%2FwEdAPsBIYKpLSmwcNZ5R1m7X0wbm127k2ajaruFLYNWQx%2BHeFEqkvdsY5v6fLjty194vGALawGdIoTjiIP%2FmjgfIrjPlV5Sb0ZChIHd9vGj1hUh9M3%2FgsEAZuvsLqaPpX0pvQML21va6msjUtv5NBLKYe6%2BTaJ1rv5LEWnAXC%2BPmtfuXCti7f2%2BS7SHP2lzGb4vmbrKOCvh07sBdB61tBsSK4yj%2BAyrKeKT%2FoXfjFf%2Bhhsuu4uFT37wxzasB84iHCmiEpyZXRKJ%2FDwFN7kEwhWY3OtiJ6lqisFRkeX20lx6Gj%2BU2qGl3F%2FLwkaiu1cRQp5EeSILjDRtyBlReffBp62AZYAw0NH83NukK7iHnZGsAvhnZcKYYxLAcqSZORcDiM%2B%2BVvyhihIdBkP1EztC20ruX17qf5jfM8UJ28BMMxm65K%2BKUhmKbniTWKs800KspMJCvB6zQn2RlQD%2BG%2FiKPNo6P4wlQEFr0Ra3Prs0Ad8XFN9jqJ7bTfQWqjsJjVB%2Fh7%2FmNYzFbg%2B66eT9892HQisI7w%2FYHdITx8%2FEVstLnNM%2BjL5laSKku4n6ap5A39csaW1i61dT0SqQExWxGmMmcGkadyMBJ0RO5c1n8wD4L8T%2FCUiAVNKhmW1n25fGtes6ak1WLANCsVyReWdqZsISC8BuyPxSNRBSRgBFWHYOBc%2Bjeq79L9IVsBJSqAAmekQ5tzZG2ahJyv%2FpUDKGBMd5PGZZIFFysNsy1YISWFDEOMNEO6CFa3bUCLmChYsbslMeMbYgyW3%2FrSvG2pOBx%2FN%2F3C50QEZURvybVjlyh9eYEzAkb14ZpJM2eIc3gao0dnKuZp4HLwxvzwgF%2FNMLLStVEJy5dBTyJ0taaX1XUftEfQycovHyT0HWrGADC8s%2B8XrlZX3Qu1vBoITfUkXQLYgB5rE5qT5uSfvglNZeepFIagXSq86NfD0glZxEj58Vs4UCC0q4pRXb6lv2epqa6So8EHmdSxtx%2Bin452T8EkbBkUnoOCGQdH91gVfIP%0D%0A%09%09dpGll9BpBj5A5SDt14ItYQOe778bVlrp5jrXezwz4kK8%2BeVOnGExuaY0N3R1xAUYc1zzJDC4qLDx7nyTBejS%2Btnxs%2BxKJ7Riq5D9p6Qx%2FkeetqSABwLmhZ4gG0FC5h%2BvFi2%2BMT90ONtRJy9RLK8Lx4z0AXyU%2BNwW5K9yEqPXcKXv0Gtw2EHXttkuSkj6pvHsY0D8DMWikicjKr6pB2QB8ZSwFwNvyitijkisMb%2FWxSSruKYA74Jf7dsGSuPDpjRy7%2BD%2BzvyQia7cs0BPPnqyNy1MB%2FjwjyidXXG%2BWcEkVyRfjnUjVMJqyMIS0VoecFbQrylwvUcuQ%2FzSCxrl%2BJEsEjJ%2Br62yPM7Xhm%2FcwyA0OZBRtznHpGMg4WgcTrhHBWJwD3F%2FnSmHUatvmyRv%2FLL4MJJr5ZA47340kXH4WgNRLA2JG9CRdXW0jgtmQ%2FwEncP65uDMQJ1TU9XaiQ3osXpCYzh3PcJNCvmNqb%2F0SgcNvPvHsRdQRPUSCU33Ld34YqQfxSmWz7Q7%2BajpKoNViE2aanpCQG6%2FDXjQBnvcwOBsGw%2B7wumXbImX5%2BV22re%2F5QlxBHBJrjIJpUi%2BsVlEX5kVReXovDxk0szLcV41TPynqtV3Fg585uP42zQBxv3ZVQR2U8sPw%2B5otyF9Uzz7OEsf%2Fm99vwPaPA3w6cjLS5ap1kebN0yhsfaHyPtFalhJy%2BTB%2BAP5CuhUaXY0oEwhZ9xQsSm5HCIqaxQtUXtGvXH1E7LbQ%2BfDbJP%2F36JlC832rcsKFo8Nl3e3%2BaEvyY3APfCFovvDfa2Y%2B2BYDVQ6HsTEy9fo6fbCGaQER6Fqu6VnY2G6u7H2gb%2FnGoIIk%2FHUDX47D8oeV3oJC9YOQqjHHxDGi3WpGUpXwa01EHeEBud83zfVq8Xc8zgTZPvsAPgyktVR%2BsW%2BisPGo51t%2FUYYhrodJ8XjlSJHp2zM1AmwYPeQLcBw1gSpBvYRlvpt94HcgA6XRVaJkCmdxsGRF6EQKDHNz7GoUTXt%2Br8OQOCDScFHz1%0D%0A%09%094DNR2MZPNo9vjGslh1d7A9%2FnxkSb3%2BsyI3h0lzN2nbqaecfyKOqC3qOqxFkAwUnFZVlEfzaHMqqAjdQskKculpwBHvktJbAlz2crROwSkfV3UcHBkMQcjaK72EwkzRMjGCBgA0G2iJf5GmccFBQ4Ll9WSqsq7clmJgEABPdwrfyhRcF%2BPBTomHsD6ocQj3EX3aoaC2BPRnlvuw1dzaGCnqAc6Du%2B6Thn09zMF5z%2FwDX6Mrc%2FmBu9ONrswrsJurXlQjzTOnLY37%2FOPd8LN6J5kLtetQEKOoF1IkN%2FGHPxXaw3YwOaQMHBPme%2FNNB4vRxXK%2Fx6IY4AoTdaOGm2G1EXyqM4bWWs4tabIa9ZfhSoJOlbWKGl2VgdqH07NgeyuQpRxTURPcxHwTgKcjDJl2QkBizI76S%2FyeOqSIs0TdhrcHE5Jirqwo492F4LoAM5HHeym9c2dzjcCVm37p7ByzyytPcUeWmTm860YZZf82oFxBX2Eygg8JTl8TEiy5zML8q6L932wFHRZIgzRavNBHRX5VPJk%2Bct72nY6Kb%2BJ4hLFDmCHfP9uyy728aUbDCwqwXlf37OyeS0uEDEL7faMuOKgwSSOpx8FxXIuS3WvQD7zDF6CAtVMykapVDoxsBS8snofaIj4agGLVrAdU6nsiEr3FF0gQJK%2BF26SWBGglljkmoomet2TPpbbZQw1ZkrnyzL5qw%2B5p5weE3WEkGakSh7ck6%2BnoU1FkkMwja7ELFo%2F3cZ%2BLhYojAl4leQHCVIUoVRuzuEF%2B3WOWbrwohl9KSDSaBwrBvpSOAxgYOlhtUFomre4Wq3QrBfuNJjQorhsX5Jz8tugihW3Zc4vuVhtSuJXMNH5xT5QFFq2EE%2FyBEtbaeTdz%2BRtQ51hW2YMNlGOBNCBAUkysLZduwhJ3YTwGHu7S%2BbUj3Slv1XVrpIECBWvh%2FEjsCR02o8Jk2AhB7MCFjpCD5aDeyq8hPaRb8BOlC7J9YcRP0mkVg09GtjszfuveFN98twCjTHry1IDXBgRG%0D%0A%09%09gGCZpJ8Iv2ZGRc%2FhTJhB76NGOa9HR9gLauIE6ZdLGZr94QGhu%2BUby4LEQzgedtjwUXcyTWH5tlfsEcOMrFyOPLDfzB3W0jJ5JMNds2pJF5OFd3TbS7c%2F147lt1igBzskSZGkGnN7GHTbqm70PhHamo8PPNIcfIT962iyj4nic5Q12xHW7%2BKku0C5EdrkhlIhn1c9Ak%2Bo9GhekeOM%2F1A3J9Znd6j5BMCfAfvZLQNryky4UY09flQVPlxR5asRH%2Fd7zNJfxtaOv1wCoqwrxfSTSS6n1Wxkbxc2xqkZYkPk3yNjTigaloY0qOcUcO8XSEsurkR32UhaQDEitrlRXtIRwjv%2BixoFDAxrFDIg4cwUS1q7P1KRtm4Ph%2F8e4RoP%2FZEjPHmsBbQkbpP%2BjU0HV65dmZ8ubKZRSdDJNzjxYqB0FNNk%2FdJ5diZrjfJIsPuh4NAhlT%2BCi6PcDmt4TrarRwxM6%2FocLxPNfRiwXKK6XHapB26AQxd3CYo3HKpJwrSy6iekUCU1pljh7zQMAEFsJrIv3aONqis3a317lxEo0cwC%2BwhVQG%2BL8aE9kPmD4AGlfrJZCt7YZ%2Fq5J%2FArJ5IirewQzLyYAAtLPHqt%2BZ57roqC0182vvbnonpDsU6O8xomzpJxRPZDvpQhu2%2BmDhrVnAqwOMKY8I6JMO5%2BwQBshZjyfqfU6Hw0c9tgp4PoWoNslAvI08mr2M3APWt3sf0Yy2Xzq40vx2K7h4XQAzDCKbNWRCO%2BRkJRdVPaCnJPmcHtPkl0%2BqBTTFgshhFowgfjwQXKU8Tn9iNrO3lLkPUbwN3VD2ayX%2BTCFLsjtowkWnHnKeQhgIEIrGJbB1PCpY7mMSXZhRCeBcKKQ5VKKgLPRTjpSbyPf6dCMIiduKr8t93xQrKHxCbCeeZY%2FiMsGFjiuh4s3pNSvVuZOVkAy7aGByNsRMUXZ%2BP0BcvLVfmmHK10HXlu7alfDKIjlYP%2BjdVhXCrv8ILdRRqwXCfEzONto2UUBCYdYQQUts%2FKj48y11asDb%0D%0A%09%09Z8NnebvSmqGs6nF4YCBp8Xb5dcAsetyRu%2B7PYQaOzYv%2F7i%2FxELEBOkDAsymU1zmrGMHMqyEd%2FueAdd30aoFuVxfR7MnB0vLjJjCBEviy8VuAckM9K6F8ePynuE7J0JKMvhwnf3D2w6EZyncPmwxEcKWkgcLh3Hx2ReDdnobTp77rWPAnSh%2FUEvc1tyOALbe3W0SFes8X7kfFCGgwRsAu37wAaLxoelv1l8BqV9l5pLEIpARc5eaZihUlyJCR5ALcdJ3m4uUN1DF4bynLKBFSSv%2FSpo%2FegAeEDCpPcG%2BtI1wkTwhGNN%2FSeQhA9UKPBUo%2FDifB9OEuSPTmr5rW7UdNFohcF569802%2FDR3xm714nVDNZzc0up%2Fvn7DPOXZxWM%2FBqfnZDnDRKawKPYvBNA2JKxvOtYlqUVrrHUbF5f4npOUlgwK7J%2Fb8UQgYkK%2B1%2BrZcyEZtjt1FdT%2FmGti2p%2Fp4H9xLOCFqcjSarh4GtyDLjWxz2v5KS7R87%2F8syWzaFJwwJdHf2pYOaqVN4MfdhoL340VcHih4SjfxlEZJkVO4Zqnjl3mYAizkYB0YDycbmuSAxT62zq%2BrNOxo%2FGwx3h0%2Bf9DwxkJhXLmG4f3h8V%2BVdt7WLTygVgpAVeo6ygS1PdtG65fCBPd8W2k0CSr%2B36bcrAqbsgNGWJ3ftQjx3LadnhU7Ydyj9ypR5q1ofxfEAfJZMkcs8VH0ftCPMgv9OoLgkndEf8Wb2giA9gjDq05IAuHogbjhBm1U4ILX0kUs1bcSfNY5wZDEkZqULVE15eSNDTmpv4Q7nb6R0%2BcLCtq0OEk5TctA0XaPpaQsTYh2nl%2F%2B%2Bsm9GEjWDvnt2%2F8FPtB5fexD1ML%2F1le7PJyDmzQuN0WGHK1awmq14KroxeLfq7Jo9W0Ev09Z0GlBFyGrZVXjyn3Pjy4XlWZoVZhwE21mzeaOwbCchj%2Fz7pKnCDTHGL%2BuJLcVYGPmjIK5HNhhiqzDV0mWMF0tmKOD27%2FBZeNqnbDLYgQ7GjtUL6BbKRiF%2Fi%0D%0A%09%097yaLW%2FYas8qs2Ka5aNt6MaRhGY01CaRrem5xggcuLFTl7HWDNdyauouityFTBgWxid7EpoMvh7CSJ0CVg8%2BWgMH%2BwbiWVhTUziNO8fHhOygI3rb9yliYqezr45EI0otr2NHRxEAGR7WxERtfHUqjHKau%2BQN7l3Ac86tbp4w8klyBcggKU6zhPHotxY3T3a2f9ij%2FIPXgCHOYsCEAZwa9rOxvhzzYRpWf11X%2F2Vv3G0UZO%2Fd1Dv61Nm9xfklcqY855Wzcn8r8kk5dC6IShW0gPzewMkszQ%3D%3D" +
				"&ctl00%24MainContent%24FirstNameTextBox=Sreejith" +
				"&ctl00%24MainContent%24LastNameTextBox=Sreenivasan" +
				"&ctl00%24MainContent%24AddressLineOneTextBox=Romossevagen+11" +
				"&ctl00%24MainContent%24AddressLineTwoTextBox=" +
				"&ctl00%24MainContent%24PostalCodeTextBox=14631" +
				"&ctl00%24MainContent%24CountryDropDownList=SE" +
				"&ctl00%24MainContent%24CardTypeRadioButtonList=Visa" +
				"&ctl00%24MainContent%24CardNumberTextBox=1234567890123456" +
				"&ctl00%24MainContent%24SubmitButton=Submit";
		requestContent0058 = Lib.replaceTextPattern(requestContent0058, "X1D7lKVFLKxnD6o_HB8q5Ns9XEjJFfkeGqyX9qfSrRiknf_6dIU2GcQBEZJC2_2s5c4fb8f25Wy4fcw19HArtH0QotjOiPpKlQEmmXaEa9FDBZ8n0", var__PREVIOUSPAGE_1, 0);		// search and replace content fragment "X1D7lKVFLKxnD6o_HB8q5Ns9XEjJFfkeGqyX9qfSrRiknf_6dIU2GcQBEZJC2_2s5c4fb8f25Wy4fcw19HArtH0QotjOiPpKlQEmmXaEa9FDBZ8n0" with variable 'var__PREVIOUSPAGE_1' on all occurrences

		String requestHeader0058 = "POST " + requestFile0058 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0058.length() + "\r\n" + 		// Content-Length: 6714
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0058, requestHost0058, requestPort0058, requestHeader0058, requestContent0058.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0058 = null;		// support garbage collector to reduce memory
		requestContent0058 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 4311
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Thanks a lot for your order. Here is your receipt.");		// Test [58] <- Index 58
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





		// --- HTTP REQUEST: Test [59] <- WEB ADMIN Index 59 ---
		log();
		log("# title: Error 400 (Bad Request)!!1");
		String requestProt0059 = "https";
		String requestHost0059 = "safebrowsing.google.com";
		int    requestPort0059 = 443;
		String requestFile0059 = "/safebrowsing/downloads" +
				"?client=googlechrome" +
				"&appver=51.0.2704.103" +
				"&pver=3.0" +
				"&key=AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw" +
				"&ext=1";
		String requestContent0059 = 
				requestFileCache.readFile(getSymmetricEncryptContext(), "Apica_Https_test_RequestContent0059.txt").getFileDataAsString();		// note: consider duplicated definition of this file name near end of the load test program - used for ZIP-dialogue in Project Navigator
		String requestHeader0059 = "POST " + requestFile0059 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: safebrowsing.google.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Type: text/plain\r\n" + 
				"Content-Length: " + requestContent0059.length() + "\r\n" + 		// Content-Length: 11157
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0059, requestHost0059, requestPort0059, requestHeader0059, requestContent0059.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		testURL.execute(performanceData);
		requestHeader0059 = null;		// support garbage collector to reduce memory
		requestContent0059 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 400, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 1555
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {400}, null, null, null);		// Test [59] <- Index 59
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



		// all http requests of page #8 successful done
		return true;
	}



	boolean synchResponsesParallelRequestsPage_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 1 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_1(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_1 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 2 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_2(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_2 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_3(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 3 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_3(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_3 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_4(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 4 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_4(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_4 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_5(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 5 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_5(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_5 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_6(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 6 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_6(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_6 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_7(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 7 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_7(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_7 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_8(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 8 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_8(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_8 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
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
			System.out.println("-tconnect <seconds>      ->> TCP/IP socket connect timeout in seconds (default: use value of -t <seconds>)");
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
			System.out.println("-iaikLast                ->> adds the IAIK security provider at the last position (instead of default: IAIK at first position)");
			System.out.println();
			System.out.println("-dnssrv <IP-1>[,IP-N])   ->> use specific DNS server(s) to resolve DNS host names (default: use OS to resolve host names)");
			System.out.println("-dnshosts <filename>     ->> use specific DNS hosts file (default: use OS to resolve host names)");
			System.out.println("-dnstranslation <filename> ->> use a DNS translation file that converts DNS names. It might be needed to disable TLS SNI if this option is used");
			System.out.println("-dnsenattl               ->> enable consideration of DNS TTL by using the received TTL-values from the DNS Server(s) (default: TTL disabled)");
			System.out.println("-dnsfixttl <seconds>     ->> enable DNS TTL by using a fixed TTL-value of seconds for all DNS resolves");
			System.out.println("-dnsperloop              ->> perform new DNS resolves for each executed loop. All resolves are stable within the same loop (no consideration of DNS TTL within a loop)");
			System.out.println("-dnsstatistic            ->> collect statistical data about DNS resolutions. Note: use this option only if not any other, more specific DNS option is enabled");
			System.out.println("-dnsdebug                ->> debug DNS resolves and the DNS cache");
			System.out.println("-enableIPv6 <networkinterface-name>  ->> enable only IPv6 support for recording, also can provide the IPv6 network interface of the load generator");
			System.out.println("-enableIPv6v4 <networkinterface-name> ->> enable both IPv6 and IPv4 (first will try with IPv6 ,if fails will try with IPv4 support for recording),also can provide the IPv6 network interface of the load generator");
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
		SSLInit.execute(!ParseArgs.hasOption(args, "-iaikLast"), true);
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
		
		// parse optional -tconnect argument (TCP/IP socket connect timeout in seconds)
		i = ParseArgs.getInteger(args, "-tconnect");
		if (i != null)
			plannedConnectTimeout = i.intValue();
		
		String genericFileName = PerformanceData.proposeFileName("Apica_Https_test", concurrentUsers);
		
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
		
		// display common arguments at console output
		System.out.println();
		System.out.println("# concurrent users = " + concurrentUsers);
		System.out.println("# max. parallel threads per user = [serial execution order for all URLs]");
		System.out.print("# planned test duration = ");
		if (plannedTestDuration == 0)
			System.out.println("unlimited");
		else
			System.out.println("" + plannedTestDuration + " seconds");
		System.out.println("# http request timeout = " + plannedRequestTimeout + " seconds");
		if (plannedConnectTimeout != 0)
			System.out.println("# tcp/ip socket connect timeout = " + plannedConnectTimeout + " seconds");
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
		
		
		// ----------------------------
		// *** initialize load test ***
		// ----------------------------
		
		
		// initialize performance data
		// ---------------------------
		final int PAGE_BREAKS = 8;  // number of page breaks in execute()  - modify this value if you add or delete some page breaks
		final int MAX_THREAD_STEPS = 52;  // number of URL requests in execute() - modify this value if you add or delete some requests
		performanceData = new PerformanceData(PAGE_BREAKS, MAX_THREAD_STEPS, concurrentUsers, -1, plannedTestDuration, maxPlannedLoops, httpProtocolVersion, plannedStartupDelay, plannedRequestTimeout, samplingInterval, percentilePageSampling, percentileUrlSampling, percentileUrlSamplingAddOption);
		performanceData.setInfoText("Apica_Https_test");
		performanceData.setExecutorsAnnotation(testRunAnnotation);
		performanceData.setResultFileName(resultFile);
		performanceData.setDumpStream(System.out, "# ");
		performanceData.setMaxErrorSnapshots(maxErrorSnapshots);		// 0 = unlimited
		if (maxErrorSnapshotMemory >= 0)
			performanceData.setMaxErrorSnapshotsMemory(maxErrorSnapshotMemory * 1048576l);		// value in bytes
		
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
		
		// ... and init plug-in class loader ...
		try
		{
			if (getPluginClassLoader() == null)
				setPluginClassLoader(new LoadtestPluginClassLoader(getSymmetricEncryptContext(), getEncryptedClasspathList()));
		}
		catch (Throwable pluginClassLoaderThrowable)
		{
			System.out.println("*** ERROR: Unable to load encrypted files ***");
			pluginClassLoaderThrowable.printStackTrace();
			System.exit(-1);
		}
		
		// ... and check multihomed option ...
		initMultihomed(args);
		
		// ... and add dynaTrace session ID to load test result - if available ...
		initDynaTrace();
		
		
		// use test-specific DNS hosts file (optional) ?
		String dnsHostsFile = ParseArgs.getIgnoreCaseString(args, "-dnshosts");
		if (dnsHostsFile != null)
		{
			try
			{
				dnsCache = new DNSCache(getSymmetricEncryptContext(), dnsHostsFile);
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
				DNSTranslationTable dnsTranslationTable = new DNSTranslationTable(getSymmetricEncryptContext(), new File(dnsTranslationTableFile));
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
		
		// enable IPv6 
		if (ParseArgs.hasIgnoreCaseOption(args, "-enableIPv6"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.setEnableIPv6(true);
			String networkInterfaceName = ParseArgs.getString(args, "-enableIPv6");
			if(null != networkInterfaceName && !networkInterfaceName.startsWith("-"))
				dnsCache.setNetworkInterfaceName(networkInterfaceName);
		}
		
		// enable IPv6 and V4 
		if (ParseArgs.hasIgnoreCaseOption(args, "-enableIPv6v4"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.setEnableIPv6v4(true);
			String networkInterfaceName = ParseArgs.getString(args, "-enableIPv6v4");
			if(null != networkInterfaceName && !networkInterfaceName.startsWith("-"))
				dnsCache.setNetworkInterfaceName(networkInterfaceName);
		}
		
		if (dnsCache != null)
		{
			// update performance data with DNS settings
			performanceData.addDNSCacheStatistic(dnsCache.getCacheStatistic());
			performanceData.addTestDescription("*** Warning: OS-independent DNS access enabled. " + dnsCache.getConfigInfoText() + " ***");
			if (dnsPerLoop)
				performanceData.addTestDescription("*** Warning: DNS option -dnsperloop enabled ***");
			
			// log DNS settings
			System.out.println("# OS-independent DNS access enabled. " + dnsCache.getConfigInfoText());
			if (dnsPerLoop)
				System.out.println("# DNS option -dnsperloop enabled");
		}
		
		// initialize file cache for large XML, SOAP and ASCII requests
		try
		{
			requestFileCache.readFile(getSymmetricEncryptContext(), REQUEST_FILE_CACHE_FILE_1);		// Apica_Https_test_RequestContent0059.txt
		}
		catch (IOException ie)
		{
			System.out.println("*** ERROR: UNABLE TO OPEN DATA FILE FOR LARGE ASCII OR XML REQUEST ***");
			ie.printStackTrace();
			System.exit(-2);
		}
		
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
		
		
		// update performance data
		// -----------------------
		testDurationStart = System.currentTimeMillis();
		performanceData.setStartDate();
		performanceData.addSnapshot(getCpuUsagePercent());
		performanceData.setSnapshotsTimeshift(samplingTimeshift);
		performanceData.setEndDate();
		
		// initialize global context for plug-ins  
		LoadtestPluginContext globalPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, new Apica_Https_test());
		
		
		// --------------------------
		// *** start of load test ***
		// ---------------------------
		
		
		// start virtual users as threads
		// ------------------------------
		for (int x = 0; x < concurrentUsers; x++)
		{
			// start load test thread
			// ----------------------
			Thread t = null;
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				Apica_Https_test simulatedUser = new Apica_Https_test(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
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
						try { performanceData.writeObjectToFile(getSymmetricEncryptContext(), resultFile); } catch (IOException ie) { ie.printStackTrace(); }
					
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
			try { performanceData.writeObjectToFile(getSymmetricEncryptContext(), resultFile); } catch (IOException ie) { ie.printStackTrace(); }
		
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
				
				Apica_Https_test simulatedUser = new Apica_Https_test(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
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



	// definition for external files used to support large XML, SOAP and ASCII requests
	// --------------------------------------------------------------------------------
	public static final String REQUEST_FILE_CACHE_FILE_1 = "Apica_Https_test_RequestContent0059.txt";		// must be zipped together with the compiled class of this load test program
	

}	// end of class

