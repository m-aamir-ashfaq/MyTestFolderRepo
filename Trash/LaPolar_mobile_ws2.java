
// *********************************************************************************************
//
// Automatically Generated Load Test Program
// -----------------------------------------
//
// Source: LaPolar_mobile_ws2.java
// Date  : 16 May 2017 13:32:44 ECT
// Author: Apica ZebraTester V5.5-D / automatically generated
//
// Procedure Copyright by Ingenieurbuero David Fischer AG  |  A Company of the Apica Group
// All Rights Reserved
//
// http://www.apicasystem.com                                         http://www.zebratester.com
// *********************************************************************************************


import java.io.*;
import java.nio.charset.Charset;
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
import dfischer.utils.JSONHtmlBasedExtractor;
import dfischer.utils.JSONPathBasedExtractor;
import dfischer.utils.JSONPathBasedExtractorItem;
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
import dfischer.utils.SymmetricEncrypt;
import dfischer.utils.SymmetricEncryptContext;
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
public class LaPolar_mobile_ws2 extends HttpLoadTest implements Runnable, ThreadStepInterface, SetThreadStepInterface, SSLSessionCacheStatisticInterface, VaryingLoadInterface, VaryingTestDurationInterface, SuspendResumeInterface, GetRealTimeUserInputFieldsInterface
{
	public static final String prxVersion = "V5.5-D";
	public static final int    prxCharEncoding = 3;                         // 1 = OS Default, 2 = ISO-8859-1, 3 = UTF-8
	public static final String testDescription = "";

	public static String USER_AGENT_1 = "Mozilla/5.0 (Linux; U; Android 4.4.4; Nexus 5 Build/KTU84P) AppleWebkit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";

	private static final boolean CONTAINS_PARALLEL_EXECUTED_URLS = false;
	private static final int MAX_PARALLEL_THREADS_PER_USER = 6;                       // default value for max. parallel executed URLs per user
	private static int maxParallelThreadsPerUser = MAX_PARALLEL_THREADS_PER_USER;     // configured value for max. parallel executed URLs per user

	private static final boolean CONTAINS_EXTERNAL_RESOURCES = false;       // note: external resources are typically additional Java library files (*.jar files) invoked by self-developed plug-ins. Consider that Input Files and the Main Class of Plug-Ins are NOT external resources in this context because ZebraTester knows already their declarations.

	// --- WebSocket Object ---
	WebSocketData webSocketData = null;                                     // WebSocket Object that contains data of recorded WebSocket frames.
	WebSocketPluginInterface[] webSocketPluginsForURL = null;               // all assiciated web socket plugins for specific URL.

	// --- proxy configuration ---
	private static boolean proxyEnabled = false;                             // if false: do not use a proxy server
	private static boolean proxyCacheDisabled = true;
	private static String  proxyHttpHost = "";
	private static int     proxyHttpPort = -1;
	private static String  proxyHttpsHost = "";
	private static int     proxyHttpsPort = -1;
	private static String  noProxyFor = "";
	private static String  proxyAuthorization = null;
	private static NextProxyConfig commonNextProxyConfig = null;
	private NextProxyConfig userNextProxyConfig = null;
	
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
	private static final String EXTERNAL_PARAM_FILE = "LaPolar_mobile_ws2ExtParams.dat";    // input file name for very large parameter values
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
	private JSONHtmlBasedExtractor jsonHtmlBasedExtractor = null; // re-used, scratch, used to extract vars from http response
	private DynamicProtobufContentParser protobufContentParser = null;  // re-used, scratch, used to extract vars from http response
	private TextLineTokenExtractor textLineTokenExtractor = null; // re-used, scratch, used to extract vars from http response
	private ContentTokenExtractor contentTokenExtractor = null;   // re-used, scratch, used to extract vars from http response
	private BoundaryBasedExtractor boundaryBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	private RegExpBasedExtractor regExpBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	private XpathBasedExtractor xpathBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	private JSONPathBasedExtractor jsonPathBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	
	private volatile UserTransactionRuntimeHandler transactionHandler = new UserTransactionRuntimeHandler();		// re-used, support to manage user-defined transactions

	private String updateChannel_Server = "null";                         // var declaration from web admin var handler: scope = per user

	private Object wsplugin01 = null;                      // plug-in #1: "WebSocket_mod_2" - definition from web admin var handler: construction scope = per user
	private static String wsplugin01WebSocket_mod_2 = null;       // internal - not used in this load test program, but used by the GUI - reflective information

	/**
	 * constructor: called from load test plug-ins (scope = global).
	 */
	public LaPolar_mobile_ws2()
	{
		super();
	}


	/**
	 * constructor: called when a user is created (per user).
	 */
	public LaPolar_mobile_ws2(int maxLoops, int requestTimeout, int threadNumber)
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
		
		applyNextProxySettingsFromFileIfExists();
		
		if (commonNextProxyConfig != null)
			// set proxy configuration data per user 
			userNextProxyConfig = new NextProxyConfig(commonNextProxyConfig);
		
		// initialize context for plug-ins which are executed per user
		userPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, this, threadNumber);
		
		// initialize all per user constructed  web socket plug-ins
		try
		{
			// define object for web socket plug-in #1 and call web socket plug-in constructor
			Class wspluginClass0 = getPluginClassLoader().getPluginClass("WebSocket_mod_2");
			wsplugin01 = wspluginClass0.newInstance();
			((GenericPluginInterface) wsplugin01).construct(userPluginContext);
		}
		catch (Exception classException)
		{
			System.out.println("*** ERROR: UNABLE TO LOAD CLASS FOR WEB SOCKET PLUG-IN ***");
			classException.printStackTrace();
			System.exit(-2);
		}
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
		
		// customised vars from web admin var handler: scope = per user
		log();
		log("<<< updateChannel_Server = " + updateChannel_Server);
		
		// customised vars from web admin var handler: scope = per loop
		htmlContentParser = null;
		xmlContentParser = null;
		jsonHtmlBasedExtractor = null;
		protobufContentParser = null;
		
		// initialize context for plug-ins which are executed per loop
		LoadtestPluginContext loopPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, this, threadNumber, socketPool, cookieHandler);
		



		// --- VIRTUAL PAGE #0 ---
		if (!executePage_0(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;



		// --- PAGE BREAK: Test [0] ---
		log();
		log();
		log("# Page #1: home");
		log("# -------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #1: home", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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
		if (!executePage_1_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 1 failed
		
		// page 1 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [87] ---
		log();
		log();
		log("# Page #2: dormitorio");
		log("# -------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #2: dormitorio", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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



		// --- PAGE BREAK: Test [104] ---
		log();
		log();
		log("# Page #3: celta atlantis");
		log("# -----------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #3: celta atlantis", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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
		// # Page #1: home
		// # -------------



		// --- HTTP REQUEST: Test [1] <- WEB ADMIN Index 1 ---
		log();
		log("# title: LaPolar - Mobile");
		String requestProt0001 = "https";
		String requestHost0001 = "m.lapolar.cl";
		int    requestPort0001 = 443;
		String requestFile0001 = "/";
		String requestHeader0001 = "GET " + requestFile0001 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0001, requestHost0001, requestPort0001, requestHeader0001, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0001 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 7834
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "INGRESE TU EMAIL Y RECIBA NUESTRAS OFERTAS");		// Test [1] <- Index 1
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
		String requestHost0002 = "m.lapolar.cl";
		int    requestPort0002 = 443;
		String requestFile0002 = "/css/style.css";
		String requestHeader0002 = "GET " + requestFile0002 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0002, requestHost0002, requestPort0002, requestHeader0002, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0002 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 62452
		// content test algorithm: check size +/- 5%, defined content size = 62452
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 62452, 5);		// Test [2] <- Index 2
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






		// --- HTTP REQUEST: Test [3] <- WEB ADMIN Index 3 ---
		String requestProt0003 = "https";
		String requestHost0003 = "m.lapolar.cl";
		int    requestPort0003 = 443;
		String requestFile0003 = "/js/jquery.cookie.js";
		String requestHeader0003 = "GET " + requestFile0003 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0003, requestHost0003, requestPort0003, requestHeader0003, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0003 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 3121
		// content test algorithm: check size +/- 5%, defined content size = 3121
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 3121, 5);		// Test [3] <- Index 3
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






		// --- HTTP REQUEST: Test [4] <- WEB ADMIN Index 4 ---
		String requestProt0004 = "https";
		String requestHost0004 = "m.lapolar.cl";
		int    requestPort0004 = 443;
		String requestFile0004 = "/js/swiper.min.js";
		String requestHeader0004 = "GET " + requestFile0004 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0004, requestHost0004, requestPort0004, requestHeader0004, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0004 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 96843
		// content test algorithm: check size +/- 5%, defined content size = 96843
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 96843, 5);		// Test [4] <- Index 4
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
		String requestHost0005 = "m.lapolar.cl";
		int    requestPort0005 = 443;
		String requestFile0005 = "/css/swiper.min.css";
		String requestHeader0005 = "GET " + requestFile0005 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0005, requestHost0005, requestPort0005, requestHeader0005, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0005 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 17776
		// content test algorithm: check size +/- 5%, defined content size = 17776
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 17776, 5);		// Test [5] <- Index 5
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
		String requestHost0006 = "m.lapolar.cl";
		int    requestPort0006 = 443;
		String requestFile0006 = "/js/jquery.min.js";
		String requestHeader0006 = "GET " + requestFile0006 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0006, requestHost0006, requestPort0006, requestHeader0006, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0006 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 93868
		// content test algorithm: check size +/- 5%, defined content size = 93868
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 93868, 5);		// Test [6] <- Index 6
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
		String requestHost0007 = "m.lapolar.cl";
		int    requestPort0007 = 443;
		String requestFile0007 = "/js/script.js";
		String requestHeader0007 = "GET " + requestFile0007 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0007, requestHost0007, requestPort0007, requestHeader0007, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0007 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 205505
		// content test algorithm: check size +/- 5%, defined content size = 205505
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 205505, 5);		// Test [7] <- Index 7
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
		String requestHost0008 = "m.lapolar.cl";
		int    requestPort0008 = 443;
		String requestFile0008 = "/js/image.map.resizer.min.js";
		String requestHeader0008 = "GET " + requestFile0008 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0008, requestHost0008, requestPort0008, requestHeader0008, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0008 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1957
		// content test algorithm: check size +/- 5%, defined content size = 1957
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 1957, 5);		// Test [8] <- Index 8
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
		String requestHost0009 = "m.lapolar.cl";
		int    requestPort0009 = 443;
		String requestFile0009 = "/media/img/logo.jpg";
		String requestHeader0009 = "GET " + requestFile0009 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0009, requestHost0009, requestPort0009, requestHeader0009, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0009 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 11493
		// content test algorithm: check size +/- 5%, defined content size = 11493
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 11493, 5);		// Test [9] <- Index 9
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
		String requestHost0010 = "m.lapolar.cl";
		int    requestPort0010 = 443;
		String requestFile0010 = "/media/img/cargador-laPolar-footer.png";
		String requestHeader0010 = "GET " + requestFile0010 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0010, requestHost0010, requestPort0010, requestHeader0010, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0010 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 29727
		// content test algorithm: check size +/- 5%, defined content size = 29727
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 29727, 5);		// Test [10] <- Index 10
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
		String requestHost0011 = "m.lapolar.cl";
		int    requestPort0011 = 443;
		String requestFile0011 = "/css/Montserrat-Regular.ttf";
		String requestHeader0011 = "GET " + requestFile0011 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0011, requestHost0011, requestPort0011, requestHeader0011, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0011 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-FONT-TTF", header text fragment = [verification disabled], recorded content size = 29016
		// content test algorithm: check size +/- 5%, defined content size = 29016
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-FONT-TTF", null, 29016, 5);		// Test [11] <- Index 11
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






		// --- HTTP REQUEST: Test [12] <- WEB ADMIN Index 12 ---
		String requestProt0012 = "https";
		String requestHost0012 = "m.lapolar.cl";
		int    requestPort0012 = 443;
		String requestFile0012 = "/media/img/buttons/menu_buttons_bag.png";
		String requestHeader0012 = "GET " + requestFile0012 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0012, requestHost0012, requestPort0012, requestHeader0012, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0012 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1461
		// content test algorithm: check size +/- 5%, defined content size = 1461
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1461, 5);		// Test [12] <- Index 12
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
		String requestHost0013 = "m.lapolar.cl";
		int    requestPort0013 = 443;
		String requestFile0013 = "/media/img/buttons/search-icon-white.png";
		String requestHeader0013 = "GET " + requestFile0013 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0013, requestHost0013, requestPort0013, requestHeader0013, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0013 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 2328
		// content test algorithm: check size +/- 5%, defined content size = 2328
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 2328, 5);		// Test [13] <- Index 13
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
		String requestHost0014 = "m.lapolar.cl";
		int    requestPort0014 = 443;
		String requestFile0014 = "/media/img/buttons/loader.gif";
		String requestHeader0014 = "GET " + requestFile0014 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0014, requestHost0014, requestPort0014, requestHeader0014, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0014 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 10901
		// content test algorithm: check size +/- 5%, defined content size = 10901
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 10901, 5);		// Test [14] <- Index 14
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
		String requestHost0015 = "m.lapolar.cl";
		int    requestPort0015 = 443;
		String requestFile0015 = "/media/img/buttons/menu_buttons_profile.png";
		String requestHeader0015 = "GET " + requestFile0015 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0015, requestHost0015, requestPort0015, requestHeader0015, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0015 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 2431
		// content test algorithm: check size +/- 5%, defined content size = 2431
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 2431, 5);		// Test [15] <- Index 15
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
		String requestHost0016 = "m.lapolar.cl";
		int    requestPort0016 = 443;
		String requestFile0016 = "/media/img/buttons/CloseWindow_white.png";
		String requestHeader0016 = "GET " + requestFile0016 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0016, requestHost0016, requestPort0016, requestHeader0016, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0016 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 892
		// content test algorithm: check size +/- 5%, defined content size = 892
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 892, 5);		// Test [16] <- Index 16
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
		String requestHost0017 = "m.lapolar.cl";
		int    requestPort0017 = 443;
		String requestFile0017 = "/media/img/buttons/stars.png";
		String requestHeader0017 = "GET " + requestFile0017 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0017, requestHost0017, requestPort0017, requestHeader0017, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0017 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 3092
		// content test algorithm: check size +/- 5%, defined content size = 3092
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 3092, 5);		// Test [17] <- Index 17
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
		String requestHost0018 = "m.lapolar.cl";
		int    requestPort0018 = 443;
		String requestFile0018 = "/media/img/buttons/menu_buttons_menu.png";
		String requestHeader0018 = "GET " + requestFile0018 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0018, requestHost0018, requestPort0018, requestHeader0018, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0018 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 656
		// content test algorithm: check size +/- 5%, defined content size = 656
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 656, 5);		// Test [18] <- Index 18
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






		// --- HTTP REQUEST: Test [19] <- WEB ADMIN Index 19 ---
		String requestProt0019 = "https";
		String requestHost0019 = "m.lapolar.cl";
		int    requestPort0019 = 443;
		String requestFile0019 = "/media/img/cargador-laPolar.png";
		String requestHeader0019 = "GET " + requestFile0019 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0019, requestHost0019, requestPort0019, requestHeader0019, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0019 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1094
		// content test algorithm: check size +/- 5%, defined content size = 1094
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1094, 5);		// Test [19] <- Index 19
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






		// --- HTTP REQUEST: Test [20] <- WEB ADMIN Index 20 ---
		String requestProt0020 = "https";
		String requestHost0020 = "m.lapolar.cl";
		int    requestPort0020 = 443;
		String requestFile0020 = "/media/img/buttons/paper_airplane.png";
		String requestHeader0020 = "GET " + requestFile0020 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0020, requestHost0020, requestPort0020, requestHeader0020, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0020 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1242
		// content test algorithm: check size +/- 5%, defined content size = 1242
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1242, 5);		// Test [20] <- Index 20
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
		// ... continuing page #1 (fragment 2 of 5)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [21] <- WEB ADMIN Index 21 ---
		String requestProt0021 = "https";
		String requestHost0021 = "m.lapolar.cl";
		int    requestPort0021 = 443;
		String requestFile0021 = "/websocket";
		String requestHeader0021 = "GET " + requestFile0021 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Sec-WebSocket-Version: 13\r\n" + 
				"Origin: https://m.lapolar.cl\r\n" + 
				"Sec-WebSocket-Extensions: permessage-deflate\r\n" + 
				"Sec-WebSocket-Key: 5I6qZJyhYhzLkyCIFDJQLw==\r\n" + 
				"Connection: Keep-Alive, Upgrade\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Upgrade: websocket\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0021, requestHost0021, requestPort0021, requestHeader0021, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		
		LoadtestPluginContext urlPluginBeforeCallContext0021 = new LoadtestPluginContext(prxVersion, prxCharEncoding, this, threadNumber, socketPool, cookieHandler, testURL, threadStep);

		webSocketData = getWebSocketData_1494528961421();

		webSocketPluginsForURL = new WebSocketPluginInterface[1];

		((GenericPluginInterface) wsplugin01).setInputParameter(0, updateChannel_Server);			// set plug-in input parameter
		webSocketPluginsForURL[0] = (WebSocketPluginInterface) wsplugin01;

		testURL.setWebSocketContext(new HttpTestWebsocketContext(webSocketData, webSocketPluginsForURL, urlPluginBeforeCallContext0021));


		testURL.execute(performanceData);
		requestHeader0021 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 101, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: check size +/- 5%, defined content size = 0
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {101}, null, null, 0, 5);		// Test [21] <- Index 21
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		updateChannel_Server = (String) ((GenericPluginInterface) wsplugin01).getOutputParameter(0);		// get web socket plug-in output parameter
		log("<<< updateChannel_Server = " + updateChannel_Server);

		// extract variable(s) from response
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'updateChannel_Server'
			updateChannel_Server = Lib.extractTextToken( testURL.getWebSocketContext().getWebSocketRecordedData().getWebSocketFramesWithoutPingPong().get(1).getPayloadString(), 5, "< >'=&\":{}");		// recorded value = -801643916
			log("<<< updateChannel_Server = " + updateChannel_Server);
		}
		catch (Exception e) { updateChannel_Server = null; log(e); }
		if (updateChannel_Server == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'updateChannel_Server' from websocket frame pattern";
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






		// --- HTTP REQUEST: Test [22] <- WEB ADMIN Index 22 ---
		log();
		log("# title: LaPolar - Mobile");
		String requestProt0022 = "https";
		String requestHost0022 = "m.lapolar.cl";
		int    requestPort0022 = 443;
		String requestFile0022 = "/";
		String requestHeader0022 = "GET " + requestFile0022 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0022, requestHost0022, requestPort0022, requestHeader0022, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0022 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 7834
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "INGRESE TU EMAIL Y RECIBA NUESTRAS OFERTAS");		// Test [22] <- Index 22
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






		// --- HTTP REQUEST: Test [23] <- WEB ADMIN Index 23 ---
		String requestProt0023 = "https";
		String requestHost0023 = "m.lapolar.cl";
		int    requestPort0023 = 443;
		String requestFile0023 = "/js/jquery.cookie.js";
		String requestHeader0023 = "GET " + requestFile0023 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0023, requestHost0023, requestPort0023, requestHeader0023, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0023 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 3121
		// content test algorithm: check size +/- 5%, defined content size = 3121
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 3121, 5);		// Test [23] <- Index 23
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
		String requestHost0024 = "m.lapolar.cl";
		int    requestPort0024 = 443;
		String requestFile0024 = "/js/image.map.resizer.min.js";
		String requestHeader0024 = "GET " + requestFile0024 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0024, requestHost0024, requestPort0024, requestHeader0024, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0024 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1957
		// content test algorithm: check size +/- 5%, defined content size = 1957
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 1957, 5);		// Test [24] <- Index 24
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
		String requestHost0025 = "m.lapolar.cl";
		int    requestPort0025 = 443;
		String requestFile0025 = "/js/jquery.min.js";
		String requestHeader0025 = "GET " + requestFile0025 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0025, requestHost0025, requestPort0025, requestHeader0025, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0025 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 93868
		// content test algorithm: check size +/- 5%, defined content size = 93868
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 93868, 5);		// Test [25] <- Index 25
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
		String requestHost0026 = "m.lapolar.cl";
		int    requestPort0026 = 443;
		String requestFile0026 = "/js/swiper.min.js";
		String requestHeader0026 = "GET " + requestFile0026 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0026, requestHost0026, requestPort0026, requestHeader0026, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0026 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 96843
		// content test algorithm: check size +/- 5%, defined content size = 96843
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 96843, 5);		// Test [26] <- Index 26
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
		String requestHost0027 = "m.lapolar.cl";
		int    requestPort0027 = 443;
		String requestFile0027 = "/css/style.css";
		String requestHeader0027 = "GET " + requestFile0027 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0027, requestHost0027, requestPort0027, requestHeader0027, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0027 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 62452
		// content test algorithm: check size +/- 5%, defined content size = 62452
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 62452, 5);		// Test [27] <- Index 27
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
		String requestHost0028 = "m.lapolar.cl";
		int    requestPort0028 = 443;
		String requestFile0028 = "/css/swiper.min.css";
		String requestHeader0028 = "GET " + requestFile0028 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0028, requestHost0028, requestPort0028, requestHeader0028, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0028 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 17776
		// content test algorithm: check size +/- 5%, defined content size = 17776
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 17776, 5);		// Test [28] <- Index 28
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
		String requestHost0029 = "m.lapolar.cl";
		int    requestPort0029 = 443;
		String requestFile0029 = "/js/script.js";
		String requestHeader0029 = "GET " + requestFile0029 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0029, requestHost0029, requestPort0029, requestHeader0029, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0029 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 205505
		// content test algorithm: check size +/- 5%, defined content size = 205505
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 205505, 5);		// Test [29] <- Index 29
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
		String requestHost0030 = "m.lapolar.cl";
		int    requestPort0030 = 443;
		String requestFile0030 = "/media/img/buttons/menu_buttons_profile.png";
		String requestHeader0030 = "GET " + requestFile0030 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0030, requestHost0030, requestPort0030, requestHeader0030, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0030 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 2431
		// content test algorithm: check size +/- 5%, defined content size = 2431
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 2431, 5);		// Test [30] <- Index 30
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
		String requestHost0031 = "m.lapolar.cl";
		int    requestPort0031 = 443;
		String requestFile0031 = "/media/img/cargador-laPolar.png";
		String requestHeader0031 = "GET " + requestFile0031 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0031, requestHost0031, requestPort0031, requestHeader0031, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0031 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1094
		// content test algorithm: check size +/- 5%, defined content size = 1094
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1094, 5);		// Test [31] <- Index 31
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






		// --- HTTP REQUEST: Test [32] <- WEB ADMIN Index 32 ---
		String requestProt0032 = "https";
		String requestHost0032 = "m.lapolar.cl";
		int    requestPort0032 = 443;
		String requestFile0032 = "/media/img/cargador-laPolar-footer.png";
		String requestHeader0032 = "GET " + requestFile0032 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0032, requestHost0032, requestPort0032, requestHeader0032, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0032 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 29727
		// content test algorithm: check size +/- 5%, defined content size = 29727
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 29727, 5);		// Test [32] <- Index 32
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






		// --- HTTP REQUEST: Test [33] <- WEB ADMIN Index 33 ---
		String requestProt0033 = "https";
		String requestHost0033 = "m.lapolar.cl";
		int    requestPort0033 = 443;
		String requestFile0033 = "/media/img/buttons/search-icon-white.png";
		String requestHeader0033 = "GET " + requestFile0033 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0033, requestHost0033, requestPort0033, requestHeader0033, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0033 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 2328
		// content test algorithm: check size +/- 5%, defined content size = 2328
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 2328, 5);		// Test [33] <- Index 33
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






		// --- HTTP REQUEST: Test [34] <- WEB ADMIN Index 34 ---
		String requestProt0034 = "https";
		String requestHost0034 = "m.lapolar.cl";
		int    requestPort0034 = 443;
		String requestFile0034 = "/media/img/buttons/menu_buttons_menu.png";
		String requestHeader0034 = "GET " + requestFile0034 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0034, requestHost0034, requestPort0034, requestHeader0034, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0034 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 656
		// content test algorithm: check size +/- 5%, defined content size = 656
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 656, 5);		// Test [34] <- Index 34
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






		// --- HTTP REQUEST: Test [35] <- WEB ADMIN Index 35 ---
		String requestProt0035 = "https";
		String requestHost0035 = "m.lapolar.cl";
		int    requestPort0035 = 443;
		String requestFile0035 = "/media/img/buttons/CloseWindow_white.png";
		String requestHeader0035 = "GET " + requestFile0035 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0035, requestHost0035, requestPort0035, requestHeader0035, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0035 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 892
		// content test algorithm: check size +/- 5%, defined content size = 892
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 892, 5);		// Test [35] <- Index 35
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






		// --- HTTP REQUEST: Test [36] <- WEB ADMIN Index 36 ---
		String requestProt0036 = "https";
		String requestHost0036 = "m.lapolar.cl";
		int    requestPort0036 = 443;
		String requestFile0036 = "/media/img/buttons/paper_airplane.png";
		String requestHeader0036 = "GET " + requestFile0036 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0036, requestHost0036, requestPort0036, requestHeader0036, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0036 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1242
		// content test algorithm: check size +/- 5%, defined content size = 1242
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1242, 5);		// Test [36] <- Index 36
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






		// --- HTTP REQUEST: Test [37] <- WEB ADMIN Index 37 ---
		String requestProt0037 = "https";
		String requestHost0037 = "m.lapolar.cl";
		int    requestPort0037 = 443;
		String requestFile0037 = "/media/img/buttons/stars.png";
		String requestHeader0037 = "GET " + requestFile0037 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0037, requestHost0037, requestPort0037, requestHeader0037, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0037 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 3092
		// content test algorithm: check size +/- 5%, defined content size = 3092
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 3092, 5);		// Test [37] <- Index 37
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






		// --- HTTP REQUEST: Test [38] <- WEB ADMIN Index 38 ---
		String requestProt0038 = "https";
		String requestHost0038 = "m.lapolar.cl";
		int    requestPort0038 = 443;
		String requestFile0038 = "/media/img/logo.jpg";
		String requestHeader0038 = "GET " + requestFile0038 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0038, requestHost0038, requestPort0038, requestHeader0038, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0038 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 11493
		// content test algorithm: check size +/- 5%, defined content size = 11493
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 11493, 5);		// Test [38] <- Index 38
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






		// --- HTTP REQUEST: Test [39] <- WEB ADMIN Index 39 ---
		String requestProt0039 = "https";
		String requestHost0039 = "m.lapolar.cl";
		int    requestPort0039 = 443;
		String requestFile0039 = "/media/img/buttons/loader.gif";
		String requestHeader0039 = "GET " + requestFile0039 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0039, requestHost0039, requestPort0039, requestHeader0039, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0039 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 10901
		// content test algorithm: check size +/- 5%, defined content size = 10901
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 10901, 5);		// Test [39] <- Index 39
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






		// --- HTTP REQUEST: Test [40] <- WEB ADMIN Index 40 ---
		String requestProt0040 = "https";
		String requestHost0040 = "m.lapolar.cl";
		int    requestPort0040 = 443;
		String requestFile0040 = "/media/img/buttons/menu_buttons_bag.png";
		String requestHeader0040 = "GET " + requestFile0040 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0040, requestHost0040, requestPort0040, requestHeader0040, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0040 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1461
		// content test algorithm: check size +/- 5%, defined content size = 1461
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1461, 5);		// Test [40] <- Index 40
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
	 * Recorded http requests of page #1_2.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #1 (fragment 3 of 5)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [41] <- WEB ADMIN Index 41 ---
		String requestProt0041 = "https";
		String requestHost0041 = "m.lapolar.cl";
		int    requestPort0041 = 443;
		String requestFile0041 = "/websocket";
		String requestHeader0041 = "GET " + requestFile0041 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Sec-WebSocket-Version: 13\r\n" + 
				"Origin: https://m.lapolar.cl\r\n" + 
				"Sec-WebSocket-Extensions: permessage-deflate\r\n" + 
				"Sec-WebSocket-Key: BSjigZq/2j2XBIVHWQ8Ogg==\r\n" + 
				"Connection: Keep-Alive, Upgrade\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Upgrade: websocket\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0041, requestHost0041, requestPort0041, requestHeader0041, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		webSocketData = getWebSocketData_1494529087182();
		testURL.setWebSocketContext(new HttpTestWebsocketContext(webSocketData, null, null));


		testURL.execute(performanceData);
		requestHeader0041 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 101, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: check size +/- 5%, defined content size = 0
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {101}, null, null, 0, 5);		// Test [41] <- Index 41
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
		String requestProt0042 = "https";
		String requestHost0042 = "m.lapolar.cl";
		int    requestPort0042 = 443;
		String requestFile0042 = "/media/img/buttons/webpayCreditCards.png";
		String requestHeader0042 = "GET " + requestFile0042 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0042, requestHost0042, requestPort0042, requestHeader0042, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0042 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 11956
		// content test algorithm: check size +/- 5%, defined content size = 11956
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 11956, 5);		// Test [42] <- Index 42
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






		// --- HTTP REQUEST: Test [43] <- WEB ADMIN Index 43 ---
		String requestProt0043 = "https";
		String requestHost0043 = "m.lapolar.cl";
		int    requestPort0043 = 443;
		String requestFile0043 = "/media/img/buttons/webpayDebitCard.png";
		String requestHeader0043 = "GET " + requestFile0043 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0043, requestHost0043, requestPort0043, requestHeader0043, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0043 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 7087
		// content test algorithm: check size +/- 5%, defined content size = 7087
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 7087, 5);		// Test [43] <- Index 43
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






		// --- HTTP REQUEST: Test [44] <- WEB ADMIN Index 44 ---
		String requestProt0044 = "https";
		String requestHost0044 = "m.lapolar.cl";
		int    requestPort0044 = 443;
		String requestFile0044 = "/media/img/buttons/end-sale.png";
		String requestHeader0044 = "GET " + requestFile0044 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0044, requestHost0044, requestPort0044, requestHeader0044, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0044 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 6970
		// content test algorithm: check size +/- 5%, defined content size = 6970
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 6970, 5);		// Test [44] <- Index 44
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






		// --- HTTP REQUEST: Test [45] <- WEB ADMIN Index 45 ---
		String requestProt0045 = "https";
		String requestHost0045 = "m.lapolar.cl";
		int    requestPort0045 = 443;
		String requestFile0045 = "/media/img/buttons/cardTlp.png";
		String requestHeader0045 = "GET " + requestFile0045 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0045, requestHost0045, requestPort0045, requestHeader0045, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0045 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 5369
		// content test algorithm: check size +/- 5%, defined content size = 5369
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 5369, 5);		// Test [45] <- Index 45
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






		// --- HTTP REQUEST: Test [46] <- WEB ADMIN Index 46 ---
		String requestProt0046 = "https";
		String requestHost0046 = "m.lapolar.cl";
		int    requestPort0046 = 443;
		String requestFile0046 = "/media/img/buttons/webpayCards.png";
		String requestHeader0046 = "GET " + requestFile0046 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0046, requestHost0046, requestPort0046, requestHeader0046, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("-801643916", updateChannel_Server);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0046 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 19459
		// content test algorithm: check size +/- 5%, defined content size = 19459
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 19459, 5);		// Test [46] <- Index 46
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






		// --- HTTP REQUEST: Test [47] <- WEB ADMIN Index 47 ---
		String requestProt0047 = "https";
		String requestHost0047 = "m.lapolar.cl";
		int    requestPort0047 = 443;
		String requestFile0047 = "/media/img/categories_new/electronica.jpg";
		String requestHeader0047 = "GET " + requestFile0047 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0047, requestHost0047, requestPort0047, requestHeader0047, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0047 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 29716
		// content test algorithm: check size +/- 5%, defined content size = 29716
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 29716, 5);		// Test [47] <- Index 47
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






		// --- HTTP REQUEST: Test [48] <- WEB ADMIN Index 48 ---
		String requestProt0048 = "https";
		String requestHost0048 = "www.lapolar.cl";
		int    requestPort0048 = 443;
		String requestFile0048 = "/img/html/mvl/mvl_logo_1487777055.jpg";
		String requestHeader0048 = "GET " + requestFile0048 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0048, requestHost0048, requestPort0048, requestHeader0048, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0048 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 9623
		// content test algorithm: check size +/- 5%, defined content size = 9623
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 9623, 5);		// Test [48] <- Index 48
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






		// --- HTTP REQUEST: Test [49] <- WEB ADMIN Index 49 ---
		String requestProt0049 = "https";
		String requestHost0049 = "www.lapolar.cl";
		int    requestPort0049 = 443;
		String requestFile0049 = "/img/html/lite/BPL_AT_1494420199.jpg";
		String requestHeader0049 = "GET " + requestFile0049 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0049, requestHost0049, requestPort0049, requestHeader0049, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0049 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 113478
		// content test algorithm: check size +/- 5%, defined content size = 113478
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 113478, 5);		// Test [49] <- Index 49
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






		// --- HTTP REQUEST: Test [50] <- WEB ADMIN Index 50 ---
		String requestProt0050 = "https";
		String requestHost0050 = "m.lapolar.cl";
		int    requestPort0050 = 443;
		String requestFile0050 = "/media/img/categories_new/decohogar.jpg";
		String requestHeader0050 = "GET " + requestFile0050 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0050, requestHost0050, requestPort0050, requestHeader0050, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0050 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 44884
		// content test algorithm: check size +/- 5%, defined content size = 44884
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 44884, 5);		// Test [50] <- Index 50
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






		// --- HTTP REQUEST: Test [51] <- WEB ADMIN Index 51 ---
		String requestProt0051 = "https";
		String requestHost0051 = "m.lapolar.cl";
		int    requestPort0051 = 443;
		String requestFile0051 = "/media/img/categories_new/computacion.jpg";
		String requestHeader0051 = "GET " + requestFile0051 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0051, requestHost0051, requestPort0051, requestHeader0051, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0051 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 31088
		// content test algorithm: check size +/- 5%, defined content size = 31088
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 31088, 5);		// Test [51] <- Index 51
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






		// --- HTTP REQUEST: Test [52] <- WEB ADMIN Index 52 ---
		String requestProt0052 = "https";
		String requestHost0052 = "m.lapolar.cl";
		int    requestPort0052 = 443;
		String requestFile0052 = "/media/img/categories_new/muebles.jpg";
		String requestHeader0052 = "GET " + requestFile0052 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0052, requestHost0052, requestPort0052, requestHeader0052, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0052 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 19225
		// content test algorithm: check size +/- 5%, defined content size = 19225
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 19225, 5);		// Test [52] <- Index 52
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






		// --- HTTP REQUEST: Test [53] <- WEB ADMIN Index 53 ---
		String requestProt0053 = "https";
		String requestHost0053 = "m.lapolar.cl";
		int    requestPort0053 = 443;
		String requestFile0053 = "/media/img/categories_new/infantil.jpg";
		String requestHeader0053 = "GET " + requestFile0053 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0053, requestHost0053, requestPort0053, requestHeader0053, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0053 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 29902
		// content test algorithm: check size +/- 5%, defined content size = 29902
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 29902, 5);		// Test [53] <- Index 53
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






		// --- HTTP REQUEST: Test [54] <- WEB ADMIN Index 54 ---
		String requestProt0054 = "https";
		String requestHost0054 = "www.lapolar.cl";
		int    requestPort0054 = 443;
		String requestFile0054 = "/img/html/lite/BPL_AT_1494279279.jpg";
		String requestHeader0054 = "GET " + requestFile0054 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0054, requestHost0054, requestPort0054, requestHeader0054, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0054 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 107781
		// content test algorithm: check size +/- 5%, defined content size = 107781
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 107781, 5);		// Test [54] <- Index 54
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
		String requestHost0055 = "www.lapolar.cl";
		int    requestPort0055 = 443;
		String requestFile0055 = "/img/html/lite/BPL_AT_1494361937.jpg";
		String requestHeader0055 = "GET " + requestFile0055 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0055, requestHost0055, requestPort0055, requestHeader0055, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0055 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 88129
		// content test algorithm: check size +/- 5%, defined content size = 88129
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 88129, 5);		// Test [55] <- Index 55
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
		String requestProt0056 = "https";
		String requestHost0056 = "www.lapolar.cl";
		int    requestPort0056 = 443;
		String requestFile0056 = "/img/html/lite/BPL_AT_1494362304.jpg";
		String requestHeader0056 = "GET " + requestFile0056 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0056, requestHost0056, requestPort0056, requestHeader0056, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0056 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 94519
		// content test algorithm: check size +/- 5%, defined content size = 94519
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 94519, 5);		// Test [56] <- Index 56
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






		// --- HTTP REQUEST: Test [57] <- WEB ADMIN Index 57 ---
		String requestProt0057 = "https";
		String requestHost0057 = "www.lapolar.cl";
		int    requestPort0057 = 443;
		String requestFile0057 = "/img/html/lite/BPL_AT_1494508189.jpg";
		String requestHeader0057 = "GET " + requestFile0057 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0057, requestHost0057, requestPort0057, requestHeader0057, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0057 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 133142
		// content test algorithm: check size +/- 5%, defined content size = 133142
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 133142, 5);		// Test [57] <- Index 57
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






		// --- HTTP REQUEST: Test [58] <- WEB ADMIN Index 58 ---
		String requestProt0058 = "https";
		String requestHost0058 = "www.lapolar.cl";
		int    requestPort0058 = 443;
		String requestFile0058 = "/img/html/lite/BPL_AT_1494516680.jpg";
		String requestHeader0058 = "GET " + requestFile0058 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0058, requestHost0058, requestPort0058, requestHeader0058, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0058 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 84532
		// content test algorithm: check size +/- 5%, defined content size = 84532
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 84532, 5);		// Test [58] <- Index 58
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






		// --- HTTP REQUEST: Test [59] <- WEB ADMIN Index 59 ---
		String requestProt0059 = "https";
		String requestHost0059 = "www.lapolar.cl";
		int    requestPort0059 = 443;
		String requestFile0059 = "/img/store/lista120/18173190.jpg";
		String requestHeader0059 = "GET " + requestFile0059 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0059, requestHost0059, requestPort0059, requestHeader0059, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0059 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3450
		// content test algorithm: check size +/- 5%, defined content size = 3450
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3450, 5);		// Test [59] <- Index 59
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






		// --- HTTP REQUEST: Test [60] <- WEB ADMIN Index 60 ---
		String requestProt0060 = "https";
		String requestHost0060 = "www.lapolar.cl";
		int    requestPort0060 = 443;
		String requestFile0060 = "/img/store/lista120/19218350.jpg";
		String requestHeader0060 = "GET " + requestFile0060 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0060, requestHost0060, requestPort0060, requestHeader0060, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0060 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 6315
		// content test algorithm: check size +/- 5%, defined content size = 6315
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 6315, 5);		// Test [60] <- Index 60
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
		// ... continuing page #1 (fragment 4 of 5)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [61] <- WEB ADMIN Index 61 ---
		String requestProt0061 = "https";
		String requestHost0061 = "www.lapolar.cl";
		int    requestPort0061 = 443;
		String requestFile0061 = "/img/store/lista120/18899388.jpg";
		String requestHeader0061 = "GET " + requestFile0061 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0061, requestHost0061, requestPort0061, requestHeader0061, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0061 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3546
		// content test algorithm: check size +/- 5%, defined content size = 3546
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3546, 5);		// Test [61] <- Index 61
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






		// --- HTTP REQUEST: Test [62] <- WEB ADMIN Index 62 ---
		String requestProt0062 = "https";
		String requestHost0062 = "m.lapolar.cl";
		int    requestPort0062 = 443;
		String requestFile0062 = "/media/img/categories_new/belleza.jpg";
		String requestHeader0062 = "GET " + requestFile0062 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0062, requestHost0062, requestPort0062, requestHeader0062, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0062 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 16877
		// content test algorithm: check size +/- 5%, defined content size = 16877
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 16877, 5);		// Test [62] <- Index 62
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






		// --- HTTP REQUEST: Test [63] <- WEB ADMIN Index 63 ---
		String requestProt0063 = "https";
		String requestHost0063 = "m.lapolar.cl";
		int    requestPort0063 = 443;
		String requestFile0063 = "/media/img/categories_new/electrohogar.jpg";
		String requestHeader0063 = "GET " + requestFile0063 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0063, requestHost0063, requestPort0063, requestHeader0063, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0063 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 25555
		// content test algorithm: check size +/- 5%, defined content size = 25555
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 25555, 5);		// Test [63] <- Index 63
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






		// --- HTTP REQUEST: Test [64] <- WEB ADMIN Index 64 ---
		String requestProt0064 = "https";
		String requestHost0064 = "www.lapolar.cl";
		int    requestPort0064 = 443;
		String requestFile0064 = "/img/store/lista120/19031233.jpg";
		String requestHeader0064 = "GET " + requestFile0064 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0064, requestHost0064, requestPort0064, requestHeader0064, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0064 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3372
		// content test algorithm: check size +/- 5%, defined content size = 3372
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3372, 5);		// Test [64] <- Index 64
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






		// --- HTTP REQUEST: Test [65] <- WEB ADMIN Index 65 ---
		String requestProt0065 = "https";
		String requestHost0065 = "m.lapolar.cl";
		int    requestPort0065 = 443;
		String requestFile0065 = "/media/img/categories_new/moda.jpg";
		String requestHeader0065 = "GET " + requestFile0065 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0065, requestHost0065, requestPort0065, requestHeader0065, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0065 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 36087
		// content test algorithm: check size +/- 5%, defined content size = 36087
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 36087, 5);		// Test [65] <- Index 65
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






		// --- HTTP REQUEST: Test [66] <- WEB ADMIN Index 66 ---
		String requestProt0066 = "https";
		String requestHost0066 = "m.lapolar.cl";
		int    requestPort0066 = 443;
		String requestFile0066 = "/media/img/categories_new/dormitorio.jpg";
		String requestHeader0066 = "GET " + requestFile0066 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0066, requestHost0066, requestPort0066, requestHeader0066, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0066 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 34608
		// content test algorithm: check size +/- 5%, defined content size = 34608
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 34608, 5);		// Test [66] <- Index 66
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






		// --- HTTP REQUEST: Test [67] <- WEB ADMIN Index 67 ---
		String requestProt0067 = "https";
		String requestHost0067 = "www.lapolar.cl";
		int    requestPort0067 = 443;
		String requestFile0067 = "/img/store/lista120/19284611.jpg";
		String requestHeader0067 = "GET " + requestFile0067 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0067, requestHost0067, requestPort0067, requestHeader0067, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0067 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 5480
		// content test algorithm: check size +/- 5%, defined content size = 5480
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 5480, 5);		// Test [67] <- Index 67
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






		// --- HTTP REQUEST: Test [68] <- WEB ADMIN Index 68 ---
		String requestProt0068 = "https";
		String requestHost0068 = "www.lapolar.cl";
		int    requestPort0068 = 443;
		String requestFile0068 = "/img/store/lista120/18081245.jpg";
		String requestHeader0068 = "GET " + requestFile0068 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0068, requestHost0068, requestPort0068, requestHeader0068, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0068 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 2724
		// content test algorithm: check size +/- 5%, defined content size = 2724
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 2724, 5);		// Test [68] <- Index 68
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






		// --- HTTP REQUEST: Test [69] <- WEB ADMIN Index 69 ---
		String requestProt0069 = "https";
		String requestHost0069 = "www.lapolar.cl";
		int    requestPort0069 = 443;
		String requestFile0069 = "/img/store/lista120/19310280.jpg";
		String requestHeader0069 = "GET " + requestFile0069 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0069, requestHost0069, requestPort0069, requestHeader0069, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0069 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3590
		// content test algorithm: check size +/- 5%, defined content size = 3590
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3590, 5);		// Test [69] <- Index 69
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






		// --- HTTP REQUEST: Test [70] <- WEB ADMIN Index 70 ---
		String requestProt0070 = "https";
		String requestHost0070 = "www.lapolar.cl";
		int    requestPort0070 = 443;
		String requestFile0070 = "/img/html/lite/BPL_AT_1494517541.jpg";
		String requestHeader0070 = "GET " + requestFile0070 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0070, requestHost0070, requestPort0070, requestHeader0070, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0070 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 103976
		// content test algorithm: check size +/- 5%, defined content size = 103976
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 103976, 5);		// Test [70] <- Index 70
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






		// --- HTTP REQUEST: Test [71] <- WEB ADMIN Index 71 ---
		String requestProt0071 = "https";
		String requestHost0071 = "www.lapolar.cl";
		int    requestPort0071 = 443;
		String requestFile0071 = "/img/store/lista120/17855573.jpg";
		String requestHeader0071 = "GET " + requestFile0071 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0071, requestHost0071, requestPort0071, requestHeader0071, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0071 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 2442
		// content test algorithm: check size +/- 5%, defined content size = 2442
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 2442, 5);		// Test [71] <- Index 71
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






		// --- HTTP REQUEST: Test [72] <- WEB ADMIN Index 72 ---
		String requestProt0072 = "https";
		String requestHost0072 = "www.lapolar.cl";
		int    requestPort0072 = 443;
		String requestFile0072 = "/img/html/lite/BPL_AT_1494447136.jpg";
		String requestHeader0072 = "GET " + requestFile0072 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0072, requestHost0072, requestPort0072, requestHeader0072, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0072 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 116407
		// content test algorithm: check size +/- 5%, defined content size = 116407
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 116407, 5);		// Test [72] <- Index 72
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






		// --- HTTP REQUEST: Test [73] <- WEB ADMIN Index 73 ---
		String requestProt0073 = "https";
		String requestHost0073 = "www.lapolar.cl";
		int    requestPort0073 = 443;
		String requestFile0073 = "/img/store/lista120/15611863.jpg";
		String requestHeader0073 = "GET " + requestFile0073 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0073, requestHost0073, requestPort0073, requestHeader0073, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0073 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3563
		// content test algorithm: check size +/- 5%, defined content size = 3563
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3563, 5);		// Test [73] <- Index 73
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






		// --- HTTP REQUEST: Test [74] <- WEB ADMIN Index 74 ---
		String requestProt0074 = "https";
		String requestHost0074 = "www.lapolar.cl";
		int    requestPort0074 = 443;
		String requestFile0074 = "/img/store/lista120/19306674.jpg";
		String requestHeader0074 = "GET " + requestFile0074 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0074, requestHost0074, requestPort0074, requestHeader0074, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0074 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 4803
		// content test algorithm: check size +/- 5%, defined content size = 4803
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 4803, 5);		// Test [74] <- Index 74
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
		String requestHost0075 = "www.lapolar.cl";
		int    requestPort0075 = 443;
		String requestFile0075 = "/img/store/lista120/19551989.jpg";
		String requestHeader0075 = "GET " + requestFile0075 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0075, requestHost0075, requestPort0075, requestHeader0075, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0075 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3915
		// content test algorithm: check size +/- 5%, defined content size = 3915
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3915, 5);		// Test [75] <- Index 75
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






		// --- HTTP REQUEST: Test [76] <- WEB ADMIN Index 76 ---
		String requestProt0076 = "https";
		String requestHost0076 = "www.lapolar.cl";
		int    requestPort0076 = 443;
		String requestFile0076 = "/img/store/lista120/18918463.jpg";
		String requestHeader0076 = "GET " + requestFile0076 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0076, requestHost0076, requestPort0076, requestHeader0076, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0076 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3003
		// content test algorithm: check size +/- 5%, defined content size = 3003
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3003, 5);		// Test [76] <- Index 76
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






		// --- HTTP REQUEST: Test [77] <- WEB ADMIN Index 77 ---
		String requestProt0077 = "https";
		String requestHost0077 = "www.lapolar.cl";
		int    requestPort0077 = 443;
		String requestFile0077 = "/img/store/lista120/19296563.jpg";
		String requestHeader0077 = "GET " + requestFile0077 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0077, requestHost0077, requestPort0077, requestHeader0077, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0077 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 5887
		// content test algorithm: check size +/- 5%, defined content size = 5887
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 5887, 5);		// Test [77] <- Index 77
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






		// --- HTTP REQUEST: Test [78] <- WEB ADMIN Index 78 ---
		String requestProt0078 = "https";
		String requestHost0078 = "www.lapolar.cl";
		int    requestPort0078 = 443;
		String requestFile0078 = "/img/store/lista120/13321850.jpg";
		String requestHeader0078 = "GET " + requestFile0078 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0078, requestHost0078, requestPort0078, requestHeader0078, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0078 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 4338
		// content test algorithm: check size +/- 5%, defined content size = 4338
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 4338, 5);		// Test [78] <- Index 78
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






		// --- HTTP REQUEST: Test [79] <- WEB ADMIN Index 79 ---
		String requestProt0079 = "https";
		String requestHost0079 = "www.lapolar.cl";
		int    requestPort0079 = 443;
		String requestFile0079 = "/img/store/lista120/17883089.jpg";
		String requestHeader0079 = "GET " + requestFile0079 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0079, requestHost0079, requestPort0079, requestHeader0079, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0079 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 2912
		// content test algorithm: check size +/- 5%, defined content size = 2912
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 2912, 5);		// Test [79] <- Index 79
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






		// --- HTTP REQUEST: Test [80] <- WEB ADMIN Index 80 ---
		String requestProt0080 = "https";
		String requestHost0080 = "m.lapolar.cl";
		int    requestPort0080 = 443;
		String requestFile0080 = "/media/img/buttons/cardOff.jpg";
		String requestHeader0080 = "GET " + requestFile0080 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0080, requestHost0080, requestPort0080, requestHeader0080, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0080 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3439
		// content test algorithm: check size +/- 5%, defined content size = 3439
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3439, 5);		// Test [80] <- Index 80
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




		// all http requests of page #1_3 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1_4.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1_4(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #1 (fragment 5 of 5)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [81] <- WEB ADMIN Index 81 ---
		String requestProt0081 = "https";
		String requestHost0081 = "www.lapolar.cl";
		int    requestPort0081 = 443;
		String requestFile0081 = "/img/store/lista120/19308928.jpg";
		String requestHeader0081 = "GET " + requestFile0081 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0081, requestHost0081, requestPort0081, requestHeader0081, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0081 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3002
		// content test algorithm: check size +/- 5%, defined content size = 3002
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3002, 5);		// Test [81] <- Index 81
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






		// --- HTTP REQUEST: Test [82] <- WEB ADMIN Index 82 ---
		String requestProt0082 = "https";
		String requestHost0082 = "www.lapolar.cl";
		int    requestPort0082 = 443;
		String requestFile0082 = "/img/store/lista120/17479741.jpg";
		String requestHeader0082 = "GET " + requestFile0082 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0082, requestHost0082, requestPort0082, requestHeader0082, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0082 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 4676
		// content test algorithm: check size +/- 5%, defined content size = 4676
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 4676, 5);		// Test [82] <- Index 82
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






		// --- HTTP REQUEST: Test [83] <- WEB ADMIN Index 83 ---
		String requestProt0083 = "https";
		String requestHost0083 = "www.lapolar.cl";
		int    requestPort0083 = 443;
		String requestFile0083 = "/img/store/lista120/16250660.jpg";
		String requestHeader0083 = "GET " + requestFile0083 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0083, requestHost0083, requestPort0083, requestHeader0083, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0083 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3027
		// content test algorithm: check size +/- 5%, defined content size = 3027
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3027, 5);		// Test [83] <- Index 83
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






		// --- HTTP REQUEST: Test [84] <- WEB ADMIN Index 84 ---
		String requestProt0084 = "https";
		String requestHost0084 = "www.lapolar.cl";
		int    requestPort0084 = 443;
		String requestFile0084 = "/img/store/lista120/19297624.jpg";
		String requestHeader0084 = "GET " + requestFile0084 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0084, requestHost0084, requestPort0084, requestHeader0084, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0084 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 6326
		// content test algorithm: check size +/- 5%, defined content size = 6326
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 6326, 5);		// Test [84] <- Index 84
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






		// --- HTTP REQUEST: Test [85] <- WEB ADMIN Index 85 ---
		String requestProt0085 = "https";
		String requestHost0085 = "www.lapolar.cl";
		int    requestPort0085 = 443;
		String requestFile0085 = "/img/store/lista120/12141823.jpg";
		String requestHeader0085 = "GET " + requestFile0085 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0085, requestHost0085, requestPort0085, requestHeader0085, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0085 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 4137
		// content test algorithm: check size +/- 5%, defined content size = 4137
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 4137, 5);		// Test [85] <- Index 85
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






		// --- HTTP REQUEST: Test [86] <- WEB ADMIN Index 86 ---
		String requestProt0086 = "https";
		String requestHost0086 = "m.lapolar.cl";
		int    requestPort0086 = 443;
		String requestFile0086 = "/media/img/categories_new/deportes.jpg";
		String requestHeader0086 = "GET " + requestFile0086 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0086, requestHost0086, requestPort0086, requestHeader0086, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0086 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 22807
		// content test algorithm: check size +/- 5%, defined content size = 22807
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 22807, 5);		// Test [86] <- Index 86
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




		// all http requests of page #1_4 successful done
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
		// # Page #2: dormitorio
		// # -------------------



		// --- HTTP REQUEST: Test [88] <- WEB ADMIN Index 88 ---
		String requestProt0088 = "https";
		String requestHost0088 = "m.lapolar.cl";
		int    requestPort0088 = 443;
		String requestFile0088 = "/media/img/buttons/menu_buttons_menu_close.png";
		String requestHeader0088 = "GET " + requestFile0088 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0088, requestHost0088, requestPort0088, requestHeader0088, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0088 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 899
		// content test algorithm: check size +/- 5%, defined content size = 899
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 899, 5);		// Test [88] <- Index 88
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






		// --- HTTP REQUEST: Test [89] <- WEB ADMIN Index 89 ---
		String requestProt0089 = "https";
		String requestHost0089 = "www.lapolar.cl";
		int    requestPort0089 = 443;
		String requestFile0089 = "/img/store/lista120/17928961.jpg";
		String requestHeader0089 = "GET " + requestFile0089 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0089, requestHost0089, requestPort0089, requestHeader0089, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0089 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3252
		// content test algorithm: check size +/- 5%, defined content size = 3252
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3252, 5);		// Test [89] <- Index 89
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






		// --- HTTP REQUEST: Test [90] <- WEB ADMIN Index 90 ---
		String requestProt0090 = "https";
		String requestHost0090 = "www.lapolar.cl";
		int    requestPort0090 = 443;
		String requestFile0090 = "/img/store/lista120/18469561.jpg";
		String requestHeader0090 = "GET " + requestFile0090 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0090, requestHost0090, requestPort0090, requestHeader0090, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0090 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3143
		// content test algorithm: check size +/- 5%, defined content size = 3143
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3143, 5);		// Test [90] <- Index 90
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






		// --- HTTP REQUEST: Test [91] <- WEB ADMIN Index 91 ---
		String requestProt0091 = "https";
		String requestHost0091 = "www.lapolar.cl";
		int    requestPort0091 = 443;
		String requestFile0091 = "/img/store/lista120/17189409.jpg";
		String requestHeader0091 = "GET " + requestFile0091 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0091, requestHost0091, requestPort0091, requestHeader0091, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0091 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3054
		// content test algorithm: check size +/- 5%, defined content size = 3054
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3054, 5);		// Test [91] <- Index 91
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






		// --- HTTP REQUEST: Test [92] <- WEB ADMIN Index 92 ---
		String requestProt0092 = "https";
		String requestHost0092 = "www.lapolar.cl";
		int    requestPort0092 = 443;
		String requestFile0092 = "/img/store/lista120/16919691.jpg";
		String requestHeader0092 = "GET " + requestFile0092 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0092, requestHost0092, requestPort0092, requestHeader0092, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0092 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3177
		// content test algorithm: check size +/- 5%, defined content size = 3177
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3177, 5);		// Test [92] <- Index 92
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






		// --- HTTP REQUEST: Test [93] <- WEB ADMIN Index 93 ---
		String requestProt0093 = "https";
		String requestHost0093 = "m.lapolar.cl";
		int    requestPort0093 = 443;
		String requestFile0093 = "/css/Montserrat-Bold.ttf";
		String requestHeader0093 = "GET " + requestFile0093 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0093, requestHost0093, requestPort0093, requestHeader0093, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0093 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-FONT-TTF", header text fragment = [verification disabled], recorded content size = 29560
		// content test algorithm: check size +/- 5%, defined content size = 29560
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-FONT-TTF", null, 29560, 5);		// Test [93] <- Index 93
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
		String requestHost0094 = "www.lapolar.cl";
		int    requestPort0094 = 443;
		String requestFile0094 = "/img/store/lista120/19537587.jpg";
		String requestHeader0094 = "GET " + requestFile0094 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0094, requestHost0094, requestPort0094, requestHeader0094, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0094 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3719
		// content test algorithm: check size +/- 5%, defined content size = 3719
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3719, 5);		// Test [94] <- Index 94
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






		// --- HTTP REQUEST: Test [95] <- WEB ADMIN Index 95 ---
		String requestProt0095 = "https";
		String requestHost0095 = "www.lapolar.cl";
		int    requestPort0095 = 443;
		String requestFile0095 = "/img/store/lista120/16919578.jpg";
		String requestHeader0095 = "GET " + requestFile0095 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0095, requestHost0095, requestPort0095, requestHeader0095, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0095 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3177
		// content test algorithm: check size +/- 5%, defined content size = 3177
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3177, 5);		// Test [95] <- Index 95
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






		// --- HTTP REQUEST: Test [96] <- WEB ADMIN Index 96 ---
		String requestProt0096 = "https";
		String requestHost0096 = "www.lapolar.cl";
		int    requestPort0096 = 443;
		String requestFile0096 = "/img/store/lista120/18727595.jpg";
		String requestHeader0096 = "GET " + requestFile0096 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0096, requestHost0096, requestPort0096, requestHeader0096, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0096 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3719
		// content test algorithm: check size +/- 5%, defined content size = 3719
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3719, 5);		// Test [96] <- Index 96
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






		// --- HTTP REQUEST: Test [97] <- WEB ADMIN Index 97 ---
		String requestProt0097 = "https";
		String requestHost0097 = "www.lapolar.cl";
		int    requestPort0097 = 443;
		String requestFile0097 = "/img/store/lista120/12695039.jpg";
		String requestHeader0097 = "GET " + requestFile0097 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0097, requestHost0097, requestPort0097, requestHeader0097, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0097 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 2516
		// content test algorithm: check size +/- 5%, defined content size = 2516
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 2516, 5);		// Test [97] <- Index 97
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






		// --- HTTP REQUEST: Test [98] <- WEB ADMIN Index 98 ---
		String requestProt0098 = "https";
		String requestHost0098 = "www.lapolar.cl";
		int    requestPort0098 = 443;
		String requestFile0098 = "/img/store/lista120/17928970.jpg";
		String requestHeader0098 = "GET " + requestFile0098 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0098, requestHost0098, requestPort0098, requestHeader0098, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0098 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3924
		// content test algorithm: check size +/- 5%, defined content size = 3924
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3924, 5);		// Test [98] <- Index 98
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






		// --- HTTP REQUEST: Test [99] <- WEB ADMIN Index 99 ---
		String requestProt0099 = "https";
		String requestHost0099 = "www.lapolar.cl";
		int    requestPort0099 = 443;
		String requestFile0099 = "/img/store/lista120/18897474.jpg";
		String requestHeader0099 = "GET " + requestFile0099 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0099, requestHost0099, requestPort0099, requestHeader0099, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0099 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3125
		// content test algorithm: check size +/- 5%, defined content size = 3125
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3125, 5);		// Test [99] <- Index 99
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






		// --- HTTP REQUEST: Test [100] <- WEB ADMIN Index 100 ---
		String requestProt0100 = "https";
		String requestHost0100 = "www.lapolar.cl";
		int    requestPort0100 = 443;
		String requestFile0100 = "/img/store/lista120/19543706.jpg";
		String requestHeader0100 = "GET " + requestFile0100 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0100, requestHost0100, requestPort0100, requestHeader0100, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0100 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 5464
		// content test algorithm: check size +/- 5%, defined content size = 5464
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 5464, 5);		// Test [100] <- Index 100
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






		// --- HTTP REQUEST: Test [101] <- WEB ADMIN Index 101 ---
		String requestProt0101 = "https";
		String requestHost0101 = "www.lapolar.cl";
		int    requestPort0101 = 443;
		String requestFile0101 = "/img/store/lista120/16919594.jpg";
		String requestHeader0101 = "GET " + requestFile0101 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0101, requestHost0101, requestPort0101, requestHeader0101, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0101 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3203
		// content test algorithm: check size +/- 5%, defined content size = 3203
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3203, 5);		// Test [101] <- Index 101
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






		// --- HTTP REQUEST: Test [102] <- WEB ADMIN Index 102 ---
		String requestProt0102 = "https";
		String requestHost0102 = "www.lapolar.cl";
		int    requestPort0102 = 443;
		String requestFile0102 = "/img/store/lista120/18377624.jpg";
		String requestHeader0102 = "GET " + requestFile0102 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0102, requestHost0102, requestPort0102, requestHeader0102, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0102 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3366
		// content test algorithm: check size +/- 5%, defined content size = 3366
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3366, 5);		// Test [102] <- Index 102
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






		// --- HTTP REQUEST: Test [103] <- WEB ADMIN Index 103 ---
		String requestProt0103 = "https";
		String requestHost0103 = "www.lapolar.cl";
		int    requestPort0103 = 443;
		String requestFile0103 = "/img/store/lista120/18902451.jpg";
		String requestHeader0103 = "GET " + requestFile0103 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0103, requestHost0103, requestPort0103, requestHeader0103, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0103 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3298
		// content test algorithm: check size +/- 5%, defined content size = 3298
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3298, 5);		// Test [103] <- Index 103
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
		// # Page #3: celta atlantis
		// # -----------------------



		// --- HTTP REQUEST: Test [105] <- WEB ADMIN Index 105 ---
		String requestProt0105 = "https";
		String requestHost0105 = "m.lapolar.cl";
		int    requestPort0105 = 443;
		String requestFile0105 = "/websocket";
		String requestHeader0105 = "GET " + requestFile0105 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Sec-WebSocket-Version: 13\r\n" + 
				"Origin: https://m.lapolar.cl\r\n" + 
				"Sec-WebSocket-Extensions: permessage-deflate\r\n" + 
				"Sec-WebSocket-Key: q4sLBSzI2UkUhN281uqQFA==\r\n" + 
				"Connection: Keep-Alive, Upgrade\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Upgrade: websocket\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0105, requestHost0105, requestPort0105, requestHeader0105, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		webSocketData = getWebSocketData_1494529130337();
		testURL.setWebSocketContext(new HttpTestWebsocketContext(webSocketData, null, null));


		testURL.execute(performanceData);
		requestHeader0105 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 101, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: check size +/- 5%, defined content size = 0
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {101}, null, null, 0, 5);		// Test [105] <- Index 105
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






		// --- HTTP REQUEST: Test [106] <- WEB ADMIN Index 106 ---
		String requestProt0106 = "https";
		String requestHost0106 = "www.lapolar.cl";
		int    requestPort0106 = 443;
		String requestFile0106 = "/img/store/big/16919594.jpg";
		String requestHeader0106 = "GET " + requestFile0106 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0106, requestHost0106, requestPort0106, requestHeader0106, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0106 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 24302
		// content test algorithm: check size +/- 5%, defined content size = 24302
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 24302, 5);		// Test [106] <- Index 106
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






		// --- HTTP REQUEST: Test [107] <- WEB ADMIN Index 107 ---
		String requestProt0107 = "https";
		String requestHost0107 = "m.lapolar.cl";
		int    requestPort0107 = 443;
		String requestFile0107 = "/media/img/buttons/arrow_drop_down_white.png";
		String requestHeader0107 = "GET " + requestFile0107 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0107, requestHost0107, requestPort0107, requestHeader0107, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0107 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 210
		// content test algorithm: check size +/- 5%, defined content size = 210
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 210, 5);		// Test [107] <- Index 107
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






		// --- HTTP REQUEST: Test [108] <- WEB ADMIN Index 108 ---
		String requestProt0108 = "https";
		String requestHost0108 = "m.lapolar.cl";
		int    requestPort0108 = 443;
		String requestFile0108 = "/media/img/buttons/twitter_icon.png";
		String requestHeader0108 = "GET " + requestFile0108 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0108, requestHost0108, requestPort0108, requestHeader0108, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0108 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 5907
		// content test algorithm: check size +/- 5%, defined content size = 5907
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 5907, 5);		// Test [108] <- Index 108
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






		// --- HTTP REQUEST: Test [109] <- WEB ADMIN Index 109 ---
		String requestProt0109 = "https";
		String requestHost0109 = "www.lapolar.cl";
		int    requestPort0109 = 443;
		String requestFile0109 = "/img/store/perpectives/p16919594/3BC16919594.jpg";
		String requestHeader0109 = "GET " + requestFile0109 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0109, requestHost0109, requestPort0109, requestHeader0109, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0109 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 39184
		// content test algorithm: check size +/- 5%, defined content size = 39184
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 39184, 5);		// Test [109] <- Index 109
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






		// --- HTTP REQUEST: Test [110] <- WEB ADMIN Index 110 ---
		String requestProt0110 = "https";
		String requestHost0110 = "www.lapolar.cl";
		int    requestPort0110 = 443;
		String requestFile0110 = "/img/store/perpectives/p16919594/2BC16919594.jpg";
		String requestHeader0110 = "GET " + requestFile0110 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0110, requestHost0110, requestPort0110, requestHeader0110, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0110 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 48841
		// content test algorithm: check size +/- 5%, defined content size = 48841
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 48841, 5);		// Test [110] <- Index 110
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






		// --- HTTP REQUEST: Test [111] <- WEB ADMIN Index 111 ---
		String requestProt0111 = "https";
		String requestHost0111 = "www.lapolar.cl";
		int    requestPort0111 = 443;
		String requestFile0111 = "/img/store/perpectives/p16919594/1BC16919594.jpg";
		String requestHeader0111 = "GET " + requestFile0111 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0111, requestHost0111, requestPort0111, requestHeader0111, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0111 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 54836
		// content test algorithm: check size +/- 5%, defined content size = 54836
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 54836, 5);		// Test [111] <- Index 111
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






		// --- HTTP REQUEST: Test [112] <- WEB ADMIN Index 112 ---
		String requestProt0112 = "https";
		String requestHost0112 = "m.lapolar.cl";
		int    requestPort0112 = 443;
		String requestFile0112 = "/media/img/buttons/arrow_drop_down.png";
		String requestHeader0112 = "GET " + requestFile0112 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0112, requestHost0112, requestPort0112, requestHeader0112, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0112 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 185
		// content test algorithm: check size +/- 5%, defined content size = 185
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 185, 5);		// Test [112] <- Index 112
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






		// --- HTTP REQUEST: Test [113] <- WEB ADMIN Index 113 ---
		String requestProt0113 = "https";
		String requestHost0113 = "m.lapolar.cl";
		int    requestPort0113 = 443;
		String requestFile0113 = "/media/img/buttons/facebook_icon.png";
		String requestHeader0113 = "GET " + requestFile0113 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0113, requestHost0113, requestPort0113, requestHeader0113, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0113 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 6368
		// content test algorithm: check size +/- 5%, defined content size = 6368
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 6368, 5);		// Test [113] <- Index 113
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






		// --- HTTP REQUEST: Test [114] <- WEB ADMIN Index 114 ---
		String requestProt0114 = "https";
		String requestHost0114 = "m.lapolar.cl";
		int    requestPort0114 = 443;
		String requestFile0114 = "/media/img/buttons/menu_buttons_bag_active.png";
		String requestHeader0114 = "GET " + requestFile0114 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0114, requestHost0114, requestPort0114, requestHeader0114, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0114 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1201
		// content test algorithm: check size +/- 5%, defined content size = 1201
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1201, 5);		// Test [114] <- Index 114
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






		// --- HTTP REQUEST: Test [115] <- WEB ADMIN Index 115 ---
		String requestProt0115 = "https";
		String requestHost0115 = "m.lapolar.cl";
		int    requestPort0115 = 443;
		String requestFile0115 = "/media/img/buttons/CloseWindow_red.png";
		String requestHeader0115 = "GET " + requestFile0115 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: m.lapolar.cl\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0115, requestHost0115, requestPort0115, requestHeader0115, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0115 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 3280
		// content test algorithm: check size +/- 5%, defined content size = 3280
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 3280, 5);		// Test [115] <- Index 115
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
				if (decrementEndOfLoopFlag && (getOwnLoadTestUserContext().getDecrementEndOfLoopPointInTime() <= System.currentTimeMillis()))
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
		
		// deconstruct all per user constructed web socket plug-ins
		((GenericPluginInterface) wsplugin01).deconstruct(userPluginContext);
		
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
		
		
		if (commonNextProxyConfig != null)
		{
			System.out.println();
			System.out.println("*** Warning: Loadtest over HTTP(S) Proxy ***");
		}
		
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
		
		String genericFileName = PerformanceData.proposeFileName("LaPolar_mobile_ws2", concurrentUsers, ParseArgs.getString(args, "-executionPlan"));
		
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
		final int PAGE_BREAKS = 3;  // number of page breaks in execute()  - modify this value if you add or delete some page breaks
		final int MAX_THREAD_STEPS = 113;  // number of URL requests in execute() - modify this value if you add or delete some requests
		performanceData = new PerformanceData(PAGE_BREAKS, MAX_THREAD_STEPS, concurrentUsers, -1, plannedTestDuration, maxPlannedLoops, httpProtocolVersion, plannedStartupDelay, plannedRequestTimeout, samplingInterval, percentilePageSampling, percentileUrlSampling, percentileUrlSamplingAddOption);
		performanceData.setInfoText("LaPolar_mobile_ws2");
		performanceData.setExecutorsAnnotation(testRunAnnotation);
		if (commonNextProxyConfig != null)
		{
			performanceData.setProxyInfo(proxyHttpHost, proxyHttpPort, proxyHttpsHost, proxyHttpsPort);
			performanceData.addTestDescription("*** Warning: Load test executed via outbound proxy ***");
		}
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
		LoadtestPluginContext globalPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, new LaPolar_mobile_ws2());
		
		
		// --------------------------
		// *** start of load test ***
		// ---------------------------
		
		
		// special case for execution plans - start test with zero virtual users
		// ---------------------------------------------------------------------
		if (hasExecutionPlan())
		{
			if (concurrentUsers != 0)
			{
				System.out.println("*** Fatal Error: Load test with execution plan must start with zero number of virtual users - Load test program aborted ***");
				System.exit(1);
			}
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				LaPolar_mobile_ws2 simulatedUser = new LaPolar_mobile_ws2(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
				
				HttpLoadTestUserContext userContext = new HttpLoadTestUserContext(simulatedUser, null);
				userContext.setLoadTestUserExecutionPlanPlaceholder();
				getUserContextTable().getUserContextList().add(userContext);
				simulatedUser.setOwnLoadTestUserContext(userContext);
			}
			finally
			{
				getUserContextTable().getWriteLock().unlock();
			}
		}
		
		
		// start virtual users as threads (normal case)
		// --------------------------------------------
		usersToBeIncreasedAtStartupOffset.set(concurrentUsers);
		for (int x = 0; x < concurrentUsers; x++)
		{
			if (cancelIncrementDecrementUser)
			{
				usersToBeIncreasedAtStartupOffset.set(0);
				break;
			}
			
			// start load test thread
			// ----------------------
			Thread t = null;
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				LaPolar_mobile_ws2 simulatedUser = new LaPolar_mobile_ws2(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
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
			usersToBeIncreasedAtStartupOffset.decrementAndGet();
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
		usersToBeIncreasedAtStartupOffset.set(0);	// just in case that a thread is not started for any reason
		
		
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
			if (!hasExecutionPlan())
				allDone = isTestDone();
			else
			{
				if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				{
					performanceData.addTestDescription("*** Warning: Load test aborted. Execution plan time limit exceeded after " + plannedTestDuration + " seconds ***");
					triggerAbort();
				}
			}
			
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
				
				LaPolar_mobile_ws2 simulatedUser = new LaPolar_mobile_ws2(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
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


	/**
	 * Internal method used to load and apply next proxy settings from ZBAProxySettings.properties file.
	 * Settings are applied only if file exists and nextProxyIsActive is set to true in the file.
	 * Note that settings stored with the session, will be ineffective.
	 *
	 * @since V5.5-D
	 */
	private void applyNextProxySettingsFromFileIfExists()
	{
		
		String filename = "ZBAProxySettings.properties";
		BufferedReader bin = null;
		SymmetricEncryptContext decryptContext = getSymmetricEncryptContext();
		File file = new File(filename);
		
		if (file.exists())
		// open input file
		try
		{
			if (decryptContext == null)
			{
				bin = new BufferedReader(new InputStreamReader(new FileInputStream(filename), Charset.forName("UTF-8")));
			}
			else
			{
				// create a reader stream that decrypts the data on the fly
				bin = new BufferedReader(new InputStreamReader(SymmetricEncrypt.getCipherInputStream(new FileInputStream(filename), decryptContext), Charset.forName("UTF-8")));
			}
			
			if (bin != null)
			{
				Properties nextProxyConfigProperties = new Properties();
				nextProxyConfigProperties.load(bin);
				NextProxyConfig nextProxyConfig = new NextProxyConfig();
				nextProxyConfig.setActive(Boolean.valueOf(nextProxyConfigProperties.getProperty("nextProxyIsActive")));
				proxyEnabled = nextProxyConfig.isActive();                             // if false: do not use a proxy server
				
				if (proxyEnabled)
				{
					nextProxyConfig.disableHttpProxyCache(Boolean.valueOf(nextProxyConfigProperties.getProperty("nextProxyHttpCacheDisabled")));
					proxyCacheDisabled = nextProxyConfig.isDisabledHttpProxyCache();
					nextProxyConfig.setHttpHost(nextProxyConfigProperties.getProperty("nextProxyHttpHost"));
					proxyHttpHost = nextProxyConfig.getHttpHost();
					nextProxyConfig.setHttpPort(Integer.valueOf(nextProxyConfigProperties.getProperty("nextProxyHttpPort")));
					proxyHttpPort = nextProxyConfig.getHttpPort();
					nextProxyConfig.setHttpsHost(nextProxyConfigProperties.getProperty("nextProxyHttpsHost"));
					proxyHttpsHost = nextProxyConfig.getHttpsHost();
					nextProxyConfig.setHttpsPort(Integer.valueOf(nextProxyConfigProperties.getProperty("nextProxyHttpsPort")));
					proxyHttpsPort = nextProxyConfig.getHttpsPort();
					nextProxyConfig.setAuthUsername(nextProxyConfigProperties.getProperty("nextProxyAuthUsername"));
					nextProxyConfig.setAuthPassword(nextProxyConfigProperties.getProperty("nextProxyAuthPassword"));
					nextProxyConfig.setNoNextProxy(nextProxyConfigProperties.getProperty("noNextProxy"));
					noProxyFor = nextProxyConfig.getNoNextProxy();
					
					String proxyAuth = "";
					
					if (nextProxyConfig.getAuthUsername() != null)
					{
						proxyAuth = nextProxyConfig.getAuthUsername() + ":";
						if (nextProxyConfig.getAuthPassword() != null)
							proxyAuth = proxyAuth + nextProxyConfig.getAuthPassword();
					}
					
					String  proxyAuthorization = null;
					
					if (proxyAuth.length() > 1)
						proxyAuthorization = Base64Encoder.encode(proxyAuth);		// Base 64 encoded - used for basic authentication only
					
					commonNextProxyConfig = new NextProxyConfig(proxyEnabled, proxyCacheDisabled, proxyHttpHost, proxyHttpPort, proxyHttpsHost, proxyHttpsPort, proxyAuthorization, noProxyFor);
					
					log("*** Warning: Applying proxy configuration from file " + filename + " ***");
				}
				
			}
		}
		catch (Throwable tr)
		{
			log("*** Unable to load proxy configuration from properties file " + filename + " ***");
			tr.printStackTrace();
		}
		finally
		{
			if (bin != null)
			{
				try { bin.close(); } catch (Exception e) {}
			}
		}
		
	}
		
	
	// source code getting the webSocket context.
	public WebSocketData getWebSocketData_1494528961421()
	{

		WebSocketData webSocketData = new WebSocketData();
		webSocketData.setConnectionStartMillis(1494528961443L);
		webSocketData.setConnectionStopMillis(1494528991446L);
		webSocketData.setSecProtocol("plain");
		String payLoad_0 = "{\"topic\":\"updateChannel\"}";
		String payLoad_2 = "{\"topic\":\"loadShoppingCartBackground\"}";
		String payLoad_3 = "{\"topic\":\"loadMenu\",\"data\":\"\"}";
		String payLoad_4 = "{\"topic\":\"loadConfigurations\",\"data\":\"\"}";
		String payLoad_5 = "{\"topic\":\"loadHighlightProducts\",\"data\":\"\"}";
		String payLoad_6 = "{\"topic\":\"loadLocations\",\"data\":\"\"}";
		String payLoad_7 = "{\"topic\":\"loadSystemHourServer\",\"data\":{}}";
		String payLoad_8 = "{\"topic\":\"loadShoppingStatus\",\"data\":{\"SERVICE\":\"GET_ESTADOS_VENTA\",\"PARAMS\":{\"estadovta\":0}}}";
		String payLoad_9 = "{\"topic\":\"getCurrentSystemIP\",\"data\":{}}";
		String payLoad_10 = "{\"topic\":\"loadHtmlBackground\",\"data\":\"profile.html\",\"container\":\"profileContent\"}";
		String payLoad_11 = "{\"topic\":\"loadHtmlBackground\",\"data\":\"product.html\",\"container\":\"productContent\"}";
		String payLoad_12 = "{\"topic\":\"loadHtmlBackground\",\"data\":\"cart.html\",\"container\":\"cartContent\"}";
		String payLoad_13 = "{\"topic\":\"loadHtmlBackground\",\"data\":\"termsAndConditions.html\",\"container\":\"termsAndConditionsBody\"}";


		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494528961461L,1494528961464L  , payLoad_0, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494528961807L,1494528961809L  , payLoad_2, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494528961814L,1494528961817L  , payLoad_3, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494528961818L,1494528961821L  , payLoad_4, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494528961821L,1494528961823L  , payLoad_5, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494528961823L,1494528961825L  , payLoad_6, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494528961825L,1494528961826L  , payLoad_7, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494528961826L,1494528961829L  , payLoad_8, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494528961829L,1494528961831L  , payLoad_9, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494528961831L,1494528961832L  , payLoad_10, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494528961832L,1494528961834L  , payLoad_11, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494528961834L,1494528961836L  , payLoad_12, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494528961836L,1494528961838L  , payLoad_13, WebSocketFrame.PLAIN  ));
	
		return webSocketData;
	}
	
	// source code getting the webSocket context.
	public WebSocketData getWebSocketData_1494529087182()
	{

		WebSocketData webSocketData = new WebSocketData();
		webSocketData.setConnectionStartMillis(1494529088134L);
		webSocketData.setConnectionStopMillis(1494529118145L);
		webSocketData.setSecProtocol("plain");
		String payLoad_0 = "{\"topic\":\"loadHtmlBackground\",\"data\":\"product.html\",\"container\":\"productContent\"}";
		String payLoad_1 = "{\"topic\":\"loadHtmlBackground\",\"data\":\"cart.html\",\"container\":\"cartContent\"}";
		String payLoad_2 = "{\"topic\":\"loadHtmlBackground\",\"data\":\"termsAndConditions.html\",\"container\":\"termsAndConditionsBody\"}";
		String payLoad_3 = "{\"topic\":\"loadShoppingCartBackground\",\"channel\":\"-801643916\"}";
		String payLoad_4 = "{\"topic\":\"updateChannel\",\"channelId\":\"-801643916\"}";
		String payLoad_5 = "{\"topic\":\"loadMenu\",\"data\":\"\"}";
		String payLoad_6 = "{\"topic\":\"loadConfigurations\",\"data\":\"\"}";
		String payLoad_7 = "{\"topic\":\"loadHighlightProducts\",\"data\":\"\"}";
		String payLoad_8 = "{\"topic\":\"loadLocations\",\"data\":\"\"}";
		String payLoad_9 = "{\"topic\":\"loadSystemHourServer\",\"data\":{}}";
		String payLoad_10 = "{\"topic\":\"loadShoppingStatus\",\"data\":{\"SERVICE\":\"GET_ESTADOS_VENTA\",\"PARAMS\":{\"estadovta\":0}}}";
		String payLoad_11 = "{\"topic\":\"getCurrentSystemIP\",\"data\":{}}";
		String payLoad_12 = "{\"topic\":\"loadHtmlBackground\",\"data\":\"profile.html\",\"container\":\"profileContent\"}";
		String payLoad_26 = "{\"topic\":\"searchResultsCategories\",\"data\":{\"SERVICE\":\"CONS_LISTCOMB\",\"PARAMS\":{\"categoria\":\"3468\"}}}";


		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529088142L,1494529088149L  , payLoad_0, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529088150L,1494529088155L  , payLoad_1, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529088155L,1494529088159L  , payLoad_2, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529088159L,1494529088162L  , payLoad_3, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529088162L,1494529088165L  , payLoad_4, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529088165L,1494529088167L  , payLoad_5, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529088167L,1494529088169L  , payLoad_6, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529088170L,1494529088172L  , payLoad_7, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529088172L,1494529088173L  , payLoad_8, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529088173L,1494529088174L  , payLoad_9, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529088174L,1494529088176L  , payLoad_10, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529088176L,1494529088177L  , payLoad_11, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529088177L,1494529088179L  , payLoad_12, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529114674L,1494529114674L  , payLoad_26, WebSocketFrame.PLAIN  ));
	
		return webSocketData;
	}
	
	// source code getting the webSocket context.
	public WebSocketData getWebSocketData_1494529130337()
	{

		WebSocketData webSocketData = new WebSocketData();
		webSocketData.setConnectionStartMillis(1494529131269L);
		webSocketData.setConnectionStopMillis(1494529161270L);
		webSocketData.setSecProtocol("plain");
		String payLoad_0 = "{\"topic\":\"showProduct\",\"data\":{\"SERVICE\":\"FICHA_PROD\",\"PARAMS\":{\"plu\":16919594}}}";
		String payLoad_2 = "{\"topic\":\"loadProductImages\",\"data\":{\"SERVICE\":\"GETFOTOS\",\"PARAMS\":{\"plu\":16919594,\"articulo\":223157}}}";
		String payLoad_3 = "{\"topic\":\"loadProductPromos\",\"data\":{\"SERVICE\":\"FICHA_PROMOCIONES\",\"PARAMS\":{\"plu\":\"16919594\"}}}";
		String payLoad_4 = "{\"topic\":\"loadSizeAndColors\",\"data\":{\"SERVICE\":\"MATRIZ_PLU\",\"PARAMS\":{\"articulo\":223157}}}";
		String payLoad_5 = "{\"topic\":\"loadRelatedProducts\",\"data\":{\"SERVICE\":\"PROD_RELAC\",\"PARAMS\":{\"subprenda\":\"cama_americana_2_plazas\"}}}";
		String payLoad_6 = "{\"topic\":\"productVotes\",\"data\":{\"SERVICE\":\"GET_PROD_RANKING\",\"PARAMS\":{\"plu\":16919594}}}";
		String payLoad_7 = "{\"topic\":\"productComments\",\"data\":{\"SERVICE\":\"COMENT_PROD\",\"PARAMS\":{\"plu\":16919594}}}";
		String payLoad_8 = "{\"topic\":\"warrantyResponse\",\"data\":{\"SERVICE\":\"CONSULTA_EXT_GTIA\",\"PARAMS\":{\"V_COD\":200016919598,\"V_PRECIO\":169990}}}";
		String payLoad_16 = "{\"topic\":\"warrantyFindData\",\"data\":{\"SERVICE\":\"GET_DATOS_CBARRA\",\"PARAMS\":{\"codbarra\":\"00200002700445\"}}}";
		String payLoad_17 = "{\"topic\":\"warrantyFindData\",\"data\":{\"SERVICE\":\"GET_DATOS_CBARRA\",\"PARAMS\":{\"codbarra\":\"00200002728326\"}}}";
		String payLoad_20 = "{\"topic\":\"addToShoppingCart\",\"data\":[{\"lnplu\":null,\"artamano\":\"2\",\"prdescuento\":\"0\",\"prprecnor\":\"169990\",\"arsubprenda\":\"6440\",\"prid\":\"16919594\",\"rutasec\":\"\",\"prexisten\":\"-5\",\"arprenda\":\"2955\",\"prlinea\":2,\"rutapol\":\"\",\"pratrib05\":\":S/ATRIB\",\"pratrib04\":\":S/ATRIB\",\"lnarts\":null,\"profercuota\":\"f\",\"pratrib03\":\":S/ATRIB\",\"pratrib02\":\":S/ATRIB\",\"d_forzar\":\"t\",\"ararea\":\"69\",\"armodelo\":\"ATLANTIS_\",\"pratrib06\":\":S/ATRIB\",\"pridarticul\":\"223157\",\"prdescrip\":\"Cama Americana 2 Plazas Base Dividida Celta Atlantis\",\"pratrib01\":\"TALLA:0\",\"prprecint\":\"169990\",\"prurltec\":\"NO\",\"prcodibar\":\"00200016919598\",\"procvalcuo\":\"0\",\"archivopol\":\"\",\"prprectlp\":\"0\",\"proccuotas\":\"0\",\"prprecven\":\"169990\",\"rutaeficiencia\":\"\",\"prexistenv\":\"500\",\"mnombre\":\"CELTA\",\"imgpol\":\"\",\"prexistent\":\"0\",\"prrutaurl\":\"/internet/catalogo/detalles/dormitorio/camas_americanas/cama_americana_2_plazas/16919594\",\"prdescripc\":\"CAMA_AMERI CELTA Gris ATLANTIS_ 2PZA B-D 0\",\"nompol\":\"\",\"comments\":[],\"quantity\":1,\"type\":\"product\",\"promo\":\"\"}],\"channel\":\"448934291\"}";
		String payLoad_21 = "{\"topic\":\"loadShoppingCart\",\"channel\":\"448934291\"}";
		String payLoad_23 = "{\"topic\":\"loadShoppingCartBackground\",\"channel\":\"448934291\"}";
		String payLoad_26 = "{\"topic\":\"loadSystemHourServer\",\"data\":{}}";


		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529131300L,1494529131300L  , payLoad_0, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529131792L,1494529131792L  , payLoad_2, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529131792L,1494529131792L  , payLoad_3, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529131792L,1494529131792L  , payLoad_4, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529131792L,1494529131792L  , payLoad_5, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529131792L,1494529131792L  , payLoad_6, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529131792L,1494529131808L  , payLoad_7, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529131808L,1494529131808L  , payLoad_8, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529132894L,1494529132897L  , payLoad_16, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529132898L,1494529132899L  , payLoad_17, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529141605L,1494529141605L  , payLoad_20, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529142622L,1494529142622L  , payLoad_21, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529143625L,1494529143625L  , payLoad_23, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1494529146732L,1494529146747L  , payLoad_26, WebSocketFrame.PLAIN  ));
	
		return webSocketData;
	}

}	// end of class

