
// *********************************************************************************************
//
// Automatically Generated Load Test Program
// -----------------------------------------
//
// Source: infrontWebsocket2.java
// Date  : 20 Jan 2017 13:08:58 ECT
// Author: Apica ZebraTester V5.5-C / automatically generated
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
public class infrontWebsocket2 extends HttpLoadTest implements Runnable, ThreadStepInterface, SetThreadStepInterface, SSLSessionCacheStatisticInterface, VaryingLoadInterface, VaryingTestDurationInterface, SuspendResumeInterface, GetRealTimeUserInputFieldsInterface
{
	public static final String prxVersion = "V5.5-C";
	public static final int    prxCharEncoding = 2;                         // 1 = OS Default, 2 = ISO-8859-1, 3 = UTF-8
	public static final String testDescription = "";

	public static String USER_AGENT_1 = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:51.0) Gecko/20100101 Firefox/51.0";

	private static final boolean CONTAINS_PARALLEL_EXECUTED_URLS = false;
	private static final int MAX_PARALLEL_THREADS_PER_USER = 6;                       // default value for max. parallel executed URLs per user
	private static int maxParallelThreadsPerUser = MAX_PARALLEL_THREADS_PER_USER;     // configured value for max. parallel executed URLs per user

	private static final boolean CONTAINS_EXTERNAL_RESOURCES = false;       // note: external resources are typically additional Java library files (*.jar files) invoked by self-developed plug-ins. Consider that Input Files and the Main Class of Plug-Ins are NOT external resources in this context because ZebraTester knows already their declarations.

	// --- WebSocket Object ---
	WebSocketData webSocketData = null;                                     // WebSocket Object that contains data of recorded WebSocket frames.
	WebSocketPluginInterface[] webSocketPluginsForURL = null;               // all assiciated web socket plugins for specific URL.

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
	private static final String EXTERNAL_PARAM_FILE = "infrontWebsocket2ExtParams.dat";     // input file name for very large parameter values
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

	private String vState = null;                        // var declaration from web admin var handler: scope = per loop
	private String loginRedirect = null;                 // var declaration from web admin var handler: scope = per loop
	private String vExpiresin = null;                    // var declaration from web admin var handler: scope = per loop
	private String token = null;                         // var declaration from web admin var handler: scope = per loop
	private String vSessionstate = null;                 // var declaration from web admin var handler: scope = per loop
	private String loginRedirect3 = null;                // var declaration from web admin var handler: scope = per loop
	private String vIdtoken = null;                      // var declaration from web admin var handler: scope = per loop
	private String loginRedirect2 = null;                // var declaration from web admin var handler: scope = per loop
	private String sessionToken = null;                  // var declaration from web admin var handler: scope = per loop
	private String vAccesstoken = null;                  // var declaration from web admin var handler: scope = per loop
	
	/**
	 * constructor: called from load test plug-ins (scope = global).
	 */
	public infrontWebsocket2()
	{
		super();
	}


	/**
	 * constructor: called when a user is created (per user).
	 */
	public infrontWebsocket2(int maxLoops, int requestTimeout, int threadNumber)
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
		vState = null;
		loginRedirect = null;
		vExpiresin = null;
		token = null;
		vSessionstate = null;
		loginRedirect3 = null;
		vIdtoken = null;
		loginRedirect2 = null;
		sessionToken = null;
		vAccesstoken = null;
		log();
		log("<<< vState = " + vState);
		log("<<< loginRedirect = " + loginRedirect);
		log("<<< vExpiresin = " + vExpiresin);
		log("<<< token = " + token);
		log("<<< vSessionstate = " + vSessionstate);
		log("<<< loginRedirect3 = " + loginRedirect3);
		log("<<< vIdtoken = " + vIdtoken);
		log("<<< loginRedirect2 = " + loginRedirect2);
		log("<<< sessionToken = " + sessionToken);
		log("<<< vAccesstoken = " + vAccesstoken);
		
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
		if (!synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 1 failed
		
		// page 1 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [19] ---
		log();
		log();
		log("# Page #2: Login");
		log("# --------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #2: Login", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 2 failed
			synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_2_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 2 failed
			synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_2_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 2 failed
			synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 2 failed
		
		// page 2 successfully executed
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
		log("# title: Object moved");
		String requestProt0001 = "http";
		String requestHost0001 = "trader.infrontfinance.com";
		int    requestPort0001 = 80;
		String requestFile0001 = "/";
		String requestHeader0001 = "GET " + requestFile0001 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0001, requestHost0001, requestPort0001, requestHeader0001, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0001 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 114
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [1] <- Index 1
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
		log();
		log("# title: Object moved");
		String requestProt0002 = "http";
		String requestHost0002 = "trader.infrontfinance.com";
		int    requestPort0002 = 80;
		String requestFile0002 = "/infront/no/Login/IDPLogin";
		String requestHeader0002 = "GET " + requestFile0002 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0002, requestHost0002, requestPort0002, requestHeader0002, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0002 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 628
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [2] <- Index 2
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
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'loginRedirect'
			loginRedirect = new ParseUrl(testURL.getHeaderField("location")).getFile();		// recorded value = /id/connect/authorize?client_id=infront.authorization&redirect_uri=https%3a%2f%2ftrader.infrontfinance.com%2finfront%2fno%2flogin%2fcallback&response_type=id_token+token&response_mode=form_post&scope=exttoken+openid+email+read+write+offline_access&state=D02B55BDF4C275B8A61D485065C243143A369208&nonce=B5BE23AED6BAB104A9AEF7DC6CD8AD6F302EC197&acr_values=post_logout_redirect_uri%3ahttp%3a%2f%2ftrader.infrontfinance.com%2finfront%2fno%2fLogin%2fIDPLogin
			log("<<< loginRedirect = " + loginRedirect);
		}
		catch (Exception e) { loginRedirect = null; log(e); }
		if (loginRedirect == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'loginRedirect' from http redirection";
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





		// --- HTTP REQUEST: Test [3] <- WEB ADMIN Index 3 ---
		String requestProt0003 = "https";
		String requestHost0003 = "api.infrontservices.com";
		int    requestPort0003 = 443;
		String requestFile0003 = "/id/connect/authorize" +
				"?client_id=infront.authorization" +
				"&redirect_uri=https%3a%2f%2ftrader.infrontfinance.com%2finfront%2fno%2flogin%2fcallback" +
				"&response_type=id_token+token" +
				"&response_mode=form_post" +
				"&scope=exttoken+openid+email+read+write+offline_access" +
				"&state=D02B55BDF4C275B8A61D485065C243143A369208" +
				"&nonce=B5BE23AED6BAB104A9AEF7DC6CD8AD6F302EC197" +
				"&acr_values=post_logout_redirect_uri%3ahttp%3a%2f%2ftrader.infrontfinance.com%2finfront%2fno%2fLogin%2fIDPLogin";
		requestFile0003 = Lib.replaceTextPattern(requestFile0003, "/id/connect/authorize?client_id=infront.authorization&redirect_uri=https%3a%2f%2ftrader.infrontfinance.com%2finfront%2fno%2flogin%2fcallback&response_type=id_token+token&response_mode=form_post&scope=exttoken+openid+email+read+write+offline_access&state=D02B55BDF4C275B8A61D485065C243143A369208&nonce=B5BE23AED6BAB104A9AEF7DC6CD8AD6F302EC197&acr_values=post_logout_redirect_uri%3ahttp%3a%2f%2ftrader.infrontfinance.com%2finfront%2fno%2fLogin%2fIDPLogin", loginRedirect, 0);		// search and replace request file fragment "/id/connect/authorize?client_id=infront.authorization&redirect_uri=https%3a%2f%2ftrader.infrontfinance.com%2finfront%2fno%2flogin%2fcallback&response_type=id_token+token&response_mode=form_post&scope=exttoken+openid+email+read+write+offline_access&state=D02B55BDF4C275B8A61D485065C243143A369208&nonce=B5BE23AED6BAB104A9AEF7DC6CD8AD6F302EC197&acr_values=post_logout_redirect_uri%3ahttp%3a%2f%2ftrader.infrontfinance.com%2finfront%2fno%2fLogin%2fIDPLogin" with variable 'loginRedirect' on all occurrences

		String requestHeader0003 = "GET " + requestFile0003 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0003, requestHost0003, requestPort0003, requestHeader0003, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0003 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [3] <- Index 3
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
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'loginRedirect2'
			loginRedirect2 = new ParseUrl(testURL.getHeaderField("location")).getFile();		// recorded value = /id/login?signin=1d85703de7fb8fb96421af07cef312f5
			log("<<< loginRedirect2 = " + loginRedirect2);
		}
		catch (Exception e) { loginRedirect2 = null; log(e); }
		if (loginRedirect2 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'loginRedirect2' from http redirection";
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





		// --- HTTP REQUEST: Test [4] <- WEB ADMIN Index 4 ---
		String requestProt0004 = "https";
		String requestHost0004 = "api.infrontservices.com";
		int    requestPort0004 = 443;
		String requestFile0004 = "/id/login" +
				"?signin=1d85703de7fb8fb96421af07cef312f5";
		requestFile0004 = Lib.replaceTextPattern(requestFile0004, "/id/login?signin=1d85703de7fb8fb96421af07cef312f5", loginRedirect2, 0);		// search and replace request file fragment "/id/login?signin=1d85703de7fb8fb96421af07cef312f5" with variable 'loginRedirect2' on all occurrences

		String requestHeader0004 = "GET " + requestFile0004 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0004, requestHost0004, requestPort0004, requestHeader0004, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0004 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 282
		// content test algorithm: check size +/- 5%, defined content size = 282
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, 282, 5);		// Test [4] <- Index 4
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





		// --- HTTP REQUEST: Test [5] <- WEB ADMIN Index 5 ---
		log();
		log("# title: Infront Identity Server");
		String requestProt0005 = "https";
		String requestHost0005 = "api.infrontservices.com";
		int    requestPort0005 = 443;
		String requestFile0005 = "/id/login" +
				"?signin=1d85703de7fb8fb96421af07cef312f5" +
				"&encclient=aHR0cDovL3RyYWRlci5nb2luZnJvbnQuY29t";
		requestFile0005 = Lib.replaceTextPattern(requestFile0005, "/id/login?signin=1d85703de7fb8fb96421af07cef312f5", loginRedirect2, 0);		// search and replace request file fragment "/id/login?signin=1d85703de7fb8fb96421af07cef312f5" with variable 'loginRedirect2' on all occurrences

		String requestHeader0005 = "GET " + requestFile0005 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0005, requestHost0005, requestPort0005, requestHeader0005, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("/id/login?signin=1d85703de7fb8fb96421af07cef312f5", loginRedirect2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0005 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 7322
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Infront AS, all rights reserved |");		// Test [5] <- Index 5
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

		// setup var extractor for 'token'
		RegExpBasedExtractorItem regExpBasedContentExtractorItem0005_1 = new RegExpBasedExtractorItem( "value&quot;:&quot;([0-9a-zA-Z-_]*)" ,1,1,false,false,0,false);
		regExpBasedExtractor.addRegExpBasedExtractorItem(regExpBasedContentExtractorItem0005_1);

		regExpBasedExtractor.extractText();
		regExpBasedExtractor = new RegExpBasedExtractor(testURL.getHeaderString());

		regExpBasedExtractor.extractText();
		try
		{
			// extract var 'token'
			token = regExpBasedContentExtractorItem0005_1.getResultText();
			log("<<< token = " + token);
		}
		catch (Exception e) { token = null; log(e); }
		if (token == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'token' from regexp based pattern";
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





		// --- HTTP REQUEST: Test [6] <- WEB ADMIN Index 6 ---
		log();
		log("# title: Document Moved");
		String requestProt0006 = "https";
		String requestHost0006 = "api.infrontservices.com";
		int    requestPort0006 = 443;
		String requestFile0006 = "/favicon.ico";
		String requestHeader0006 = "GET " + requestFile0006 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0006, requestHost0006, requestPort0006, requestHeader0006, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0006 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 169
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [6] <- Index 6
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





		// --- HTTP REQUEST: Test [7] <- WEB ADMIN Index 7 ---
		String requestProt0007 = "https";
		String requestHost0007 = "api.infrontservices.com";
		int    requestPort0007 = 443;
		String requestFile0007 = "/id/favicon-16x16.png";
		String requestHeader0007 = "GET " + requestFile0007 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1507
		// content test algorithm: check size +/- 5%, defined content size = 1507
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1507, 5);		// Test [7] <- Index 7
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
		String requestHost0008 = "api.infrontservices.com";
		int    requestPort0008 = 443;
		String requestFile0008 = "/id/assets/scripts.2.5.0.js";
		String requestHeader0008 = "GET " + requestFile0008 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0008, requestHost0008, requestPort0008, requestHeader0008, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("/id/login?signin=1d85703de7fb8fb96421af07cef312f5", loginRedirect2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0008 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 259275
		// content test algorithm: check size +/- 5%, defined content size = 259275
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 259275, 5);		// Test [8] <- Index 8
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
		String requestHost0009 = "fonts.googleapis.com";
		int    requestPort0009 = 443;
		String requestFile0009 = "/css" +
				"?family=Roboto:light,regular,thin,italic,bold";
		String requestHeader0009 = "GET " + requestFile0009 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: fonts.googleapis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1303
		// content test algorithm: check size +/- 5%, defined content size = 1303
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 1303, 5);		// Test [9] <- Index 9
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
		String requestHost0010 = "api.infrontservices.com";
		int    requestPort0010 = 443;
		String requestFile0010 = "/id/assets/styles.min.css";
		String requestHeader0010 = "GET " + requestFile0010 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0010, requestHost0010, requestPort0010, requestHeader0010, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("/id/login?signin=1d85703de7fb8fb96421af07cef312f5", loginRedirect2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0010 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 100790
		// content test algorithm: check size +/- 5%, defined content size = 100790
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 100790, 5);		// Test [10] <- Index 10
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
		String requestHost0011 = "api.infrontservices.com";
		int    requestPort0011 = 443;
		String requestFile0011 = "/id/Content/site.css";
		String requestHeader0011 = "GET " + requestFile0011 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0011, requestHost0011, requestPort0011, requestHeader0011, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("/id/login?signin=1d85703de7fb8fb96421af07cef312f5", loginRedirect2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0011 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1636
		// content test algorithm: check size +/- 5%, defined content size = 1636
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 1636, 5);		// Test [11] <- Index 11
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
		String requestHost0012 = "ajax.googleapis.com";
		int    requestPort0012 = 443;
		String requestFile0012 = "/ajax/libs/jquery/1.10.2/jquery.min.js";
		String requestHeader0012 = "GET " + requestFile0012 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: ajax.googleapis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 32954
		// content test algorithm: check size +/- 5%, defined content size = 32954
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, 32954, 5);		// Test [12] <- Index 12
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
		log();
		log("# title: Refresher");
		String requestProt0013 = "https";
		String requestHost0013 = "api.infrontservices.com";
		int    requestPort0013 = 443;
		String requestFile0013 = "/id/refresher.aspx";
		String requestHeader0013 = "GET " + requestFile0013 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0013, requestHost0013, requestPort0013, requestHeader0013, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("/id/login?signin=1d85703de7fb8fb96421af07cef312f5", loginRedirect2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0013 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 154
		// content test algorithm: check size +/- 5%, defined content size = 154
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, 154, 5);		// Test [13] <- Index 13
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





		// --- HTTP REQUEST: Test [14] <- WEB ADMIN Index 14 ---
		String requestProt0014 = "https";
		String requestHost0014 = "api.infrontservices.com";
		int    requestPort0014 = 443;
		String requestFile0014 = "/id/Content/infront-logo_top_white.png";
		String requestHeader0014 = "GET " + requestFile0014 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1779
		// content test algorithm: check size +/- 5%, defined content size = 1779
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1779, 5);		// Test [14] <- Index 14
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
		String requestHost0015 = "fonts.gstatic.com";
		int    requestPort0015 = 443;
		String requestFile0015 = "/s/roboto/v15/oMMgfZMQthOryQo9n22dcuvvDin1pK8aKteLpeZ5c0A.woff2";
		String requestHeader0015 = "GET " + requestFile0015 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: fonts.gstatic.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Origin: https://api.infrontservices.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0015, requestHost0015, requestPort0015, requestHeader0015, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0015 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF2", header text fragment = [verification disabled], recorded content size = 10292
		// content test algorithm: check size +/- 5%, defined content size = 10292
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF2", null, 10292, 5);		// Test [15] <- Index 15
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





		// --- HTTP REQUEST: Test [16] <- WEB ADMIN Index 16 ---
		String requestProt0016 = "https";
		String requestHost0016 = "fonts.gstatic.com";
		int    requestPort0016 = 443;
		String requestFile0016 = "/s/roboto/v15/Hgo13k-tfSpn0qi1SFdUfZBw1xU1rKptJj_0jans920.woff2";
		String requestHeader0016 = "GET " + requestFile0016 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: fonts.gstatic.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Origin: https://api.infrontservices.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0016, requestHost0016, requestPort0016, requestHeader0016, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0016 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF2", header text fragment = [verification disabled], recorded content size = 10324
		// content test algorithm: check size +/- 5%, defined content size = 10324
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF2", null, 10324, 5);		// Test [16] <- Index 16
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





		// --- HTTP REQUEST: Test [17] <- WEB ADMIN Index 17 ---
		String requestProt0017 = "https";
		String requestHost0017 = "telemetry-experiment.cdn.mozilla.net";
		int    requestPort0017 = 443;
		String requestFile0017 = "/manifest/v1/firefox/51.0/beta";
		String requestHeader0017 = "GET " + requestFile0017 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: telemetry-experiment.cdn.mozilla.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0017, requestHost0017, requestPort0017, requestHeader0017, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0017 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 525
		// content test algorithm: check size +/- 5%, defined content size = 525
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 525, 5);		// Test [17] <- Index 17
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





		// --- HTTP REQUEST: Test [18] <- WEB ADMIN Index 18 ---
		log();
		log("# title: Refresher");
		String requestProt0018 = "https";
		String requestHost0018 = "api.infrontservices.com";
		int    requestPort0018 = 443;
		String requestFile0018 = "/id/refresher.aspx";
		String requestHeader0018 = "GET " + requestFile0018 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0018, requestHost0018, requestPort0018, requestHeader0018, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0018 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 154
		// content test algorithm: check size +/- 5%, defined content size = 154
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, 154, 5);		// Test [18] <- Index 18
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



		// all http requests of page #1 successful done
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
		// # Page #2: Login
		// # --------------



		// --- HTTP REQUEST: Test [20] <- WEB ADMIN Index 20 ---
		String requestProt0020 = "https";
		String requestHost0020 = "api.infrontservices.com";
		int    requestPort0020 = 443;
		String requestFile0020 = "/id/login" +
				"?signin=1d85703de7fb8fb96421af07cef312f5";
		requestFile0020 = Lib.replaceTextPattern(requestFile0020, "/id/login?signin=1d85703de7fb8fb96421af07cef312f5", loginRedirect2, 0);		// search and replace request file fragment "/id/login?signin=1d85703de7fb8fb96421af07cef312f5" with variable 'loginRedirect2' on all occurrences

		String requestContent0020 = 
				"idsrv.xsrf=9JkgAuw-nFNTBU5uE4IYZpGdD6HIyQZjgkaSyoulOAkazJLR_ZTO7LUTtWxn0_oArjctqOSDIApV5U1YVKi-hPxnGneRXEKjjnoUjuB6zfk" +
				"&username=carl.ericsson%40apicasystem.com" +
				"&password=HCgUfm";
		requestContent0020 = Lib.replaceTextPattern(requestContent0020, "9JkgAuw-nFNTBU5uE4IYZpGdD6HIyQZjgkaSyoulOAkazJLR_ZTO7LUTtWxn0_oArjctqOSDIApV5U1YVKi-hPxnGneRXEKjjnoUjuB6zfk", token, 0);		// search and replace content fragment "9JkgAuw-nFNTBU5uE4IYZpGdD6HIyQZjgkaSyoulOAkazJLR_ZTO7LUTtWxn0_oArjctqOSDIApV5U1YVKi-hPxnGneRXEKjjnoUjuB6zfk" with variable 'token' on all occurrences

		String requestHeader0020 = "POST " + requestFile0020 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0020.length() + "\r\n" + 		// Content-Length: 175
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0020, requestHost0020, requestPort0020, requestHeader0020, requestContent0020.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("/id/login?signin=1d85703de7fb8fb96421af07cef312f5", loginRedirect2);		// search within all request header fields a text pattern and replace it with a variable value
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
		requestHeader0020 = null;		// support garbage collector to reduce memory
		requestContent0020 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [20] <- Index 20
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
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'loginRedirect3'
			loginRedirect3 = new ParseUrl(testURL.getHeaderField("location")).getFile();		// recorded value = /id/connect/authorize?client_id=infront.authorization&redirect_uri=https%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2Flogin%2Fcallback&response_type=id_token%20token&response_mode=form_post&scope=exttoken%20openid%20email%20read%20write%20offline_access&state=D02B55BDF4C275B8A61D485065C243143A369208&nonce=B5BE23AED6BAB104A9AEF7DC6CD8AD6F302EC197&acr_values=post_logout_redirect_uri%3Ahttp%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2FLogin%2FIDPLogin
			log("<<< loginRedirect3 = " + loginRedirect3);
		}
		catch (Exception e) { loginRedirect3 = null; log(e); }
		if (loginRedirect3 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'loginRedirect3' from http redirection";
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





		// --- HTTP REQUEST: Test [21] <- WEB ADMIN Index 21 ---
		log();
		log("# title: Infront Identity Server");
		String requestProt0021 = "https";
		String requestHost0021 = "api.infrontservices.com";
		int    requestPort0021 = 443;
		String requestFile0021 = "/id/connect/authorize" +
				"?client_id=infront.authorization" +
				"&redirect_uri=https%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2Flogin%2Fcallback" +
				"&response_type=id_token%20token" +
				"&response_mode=form_post" +
				"&scope=exttoken%20openid%20email%20read%20write%20offline_access" +
				"&state=D02B55BDF4C275B8A61D485065C243143A369208" +
				"&nonce=B5BE23AED6BAB104A9AEF7DC6CD8AD6F302EC197" +
				"&acr_values=post_logout_redirect_uri%3Ahttp%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2FLogin%2FIDPLogin";
		requestFile0021 = Lib.replaceTextPattern(requestFile0021, "/id/connect/authorize?client_id=infront.authorization&redirect_uri=https%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2Flogin%2Fcallback&response_type=id_token%20token&response_mode=form_post&scope=exttoken%20openid%20email%20read%20write%20offline_access&state=D02B55BDF4C275B8A61D485065C243143A369208&nonce=B5BE23AED6BAB104A9AEF7DC6CD8AD6F302EC197&acr_values=post_logout_redirect_uri%3Ahttp%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2FLogin%2FIDPLogin", loginRedirect3, 0);		// search and replace request file fragment "/id/connect/authorize?client_id=infront.authorization&redirect_uri=https%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2Flogin%2Fcallback&response_type=id_token%20token&response_mode=form_post&scope=exttoken%20openid%20email%20read%20write%20offline_access&state=D02B55BDF4C275B8A61D485065C243143A369208&nonce=B5BE23AED6BAB104A9AEF7DC6CD8AD6F302EC197&acr_values=post_logout_redirect_uri%3Ahttp%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2FLogin%2FIDPLogin" with variable 'loginRedirect3' on all occurrences

		String requestHeader0021 = "GET " + requestFile0021 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0021, requestHost0021, requestPort0021, requestHeader0021, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("/id/login?signin=1d85703de7fb8fb96421af07cef312f5", loginRedirect2);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0021 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 6418
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "div class='container page-authorizeresponse' ng-cloak");		// Test [21] <- Index 21
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
		htmlContentParser = new HtmlContentParser(testURL, this);
		try
		{
			// extract var 'vState'
			vState = htmlContentParser.getFormTable().getForm(0).getFormItemValue("state");		// recorded value = D02B55BDF4C275B8A61D485065C243143A369208
			log("<<< vState = " + vState);
		}
		catch (Exception e) { vState = null; log(e); }
		if (vState == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vState' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vExpiresin'
			vExpiresin = htmlContentParser.getFormTable().getForm(0).getFormItemValue("expires_in");		// recorded value = 57600
			log("<<< vExpiresin = " + vExpiresin);
		}
		catch (Exception e) { vExpiresin = null; log(e); }
		if (vExpiresin == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vExpiresin' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vSessionstate'
			vSessionstate = htmlContentParser.getFormTable().getForm(0).getFormItemValue("session_state");		// recorded value = X9Mtv7DftIrFv-or4VTGeLfHm81HjW9u2rMXkUL05FM.f69199a4bca3fc6256669eab99ac7e3a
			log("<<< vSessionstate = " + vSessionstate);
		}
		catch (Exception e) { vSessionstate = null; log(e); }
		if (vSessionstate == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vSessionstate' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vIdtoken'
			vIdtoken = htmlContentParser.getFormTable().getForm(0).getFormItemValue("id_token");		// recorded value = eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyIsImtpZCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyJ9.eyJpc3MiOiJodHRwczovL2FwaS5pbmZyb250c2VydmljZXMuY29tL2lkIiwiYXVkIjoiaW5mcm9udC5hdXRob3JpemF0aW9uIiwiZXhwIjoxNDg0NjM5NDcwLCJuYmYiOjE0ODQ2MzkxNzAsIm5vbmNlIjoiQjVCRTIzQUVENkJBQjEwNEE5QUVGN0RDNkNEOEFENkYzMDJFQzE5NyIsImlhdCI6MTQ4NDYzOTE3MCwiYXRfaGFzaCI6IlRJNjVYTV9Lc1FVbTV4blVXcXI1d0EiLCJzaWQiOiJjZjI4MzYxNzI4ZjFhNWU0NGI4Y2Q3M2IyYmRkZmU0MyIsInN1YiI6IjM3ODg4NzMxMCIsImF1dGhfdGltZSI6MTQ4NDYzOTE3MCwiaWRwIjoiaWRzcnYiLCJ1c3IiOiJjYXJsLmVyaWNzc29uQGFwaWNhc3lzdGVtLmNvbSIsImFtciI6WyJwYXNzd29yZCJdfQ.noIyXFyQ0C5l-USNmyDCBsOms8ZxkUy6rZFUEhS9ie4d5Wr0ck9j17Gk0iUQtAtEEoYakP9wqotIo5fbLW8RMkVaGa619Wm7NVAI0PHnChOvmow0sFkS17migof9cdeHYlWfavIzmHT6f2ZXNst1zdH085WAjuCGwxK43lWTqbH8supbDjXMGuvR4uLyzVd-_ypwHmmBiv0r3BieAJnlfC90aOP9C4sL2EdV10TPRowqK9iSmdq_oHxvHqte468kzfpu5iUDl6qwvRFiOODMHfdldRGtG7Ra-kMpBiyE-6N_yx6e3dCS36Nvu3FKBXkf67Hr-b4dwi_aHly03KtTJQ
			log("<<< vIdtoken = " + vIdtoken);
		}
		catch (Exception e) { vIdtoken = null; log(e); }
		if (vIdtoken == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vIdtoken' from html form parameter";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'vAccesstoken'
			vAccesstoken = htmlContentParser.getFormTable().getForm(0).getFormItemValue("access_token");		// recorded value = eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyIsImtpZCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyJ9.eyJpc3MiOiJodHRwczovL2FwaS5pbmZyb250c2VydmljZXMuY29tL2lkIiwiYXVkIjoiaHR0cHM6Ly9hcGkuaW5mcm9udHNlcnZpY2VzLmNvbS9pZC9yZXNvdXJjZXMiLCJleHAiOjE0ODQ2OTY3NzAsIm5iZiI6MTQ4NDYzOTE3MCwiY2xpZW50X2lkIjoiaW5mcm9udC5hdXRob3JpemF0aW9uIiwic2NvcGUiOlsiZXh0dG9rZW4iLCJvcGVuaWQiLCJlbWFpbCIsInJlYWQiLCJ3cml0ZSIsIm9mZmxpbmVfYWNjZXNzIl0sInN1YiI6IjM3ODg4NzMxMCIsImF1dGhfdGltZSI6MTQ4NDYzOTE3MCwiaWRwIjoiaWRzcnYiLCJ1c3IiOiJjYXJsLmVyaWNzc29uQGFwaWNhc3lzdGVtLmNvbSIsImFtciI6WyJwYXNzd29yZCJdfQ.BAEdPwM8aGzLVO4aXelI0juieqFA7ZMJDOLyg79TijQWjXDBFAKnn7A4dReWRl7SadC4ijbrdrXchf9dMHBTJaRCnjaMARTIhhbO8yf2dwOxQZs9UADH2eMVh4-EnlLNEV3KG3bExa9c3Dku4j_1QM1U9E5AQrMY2qboNWsu-lveaK1wsSW_vcLy8AkE7Iv04O8iYU4I-tsF5ZGu28QxlpwfG3xMYHwTisTaz_30M5TbFR3jpcUjuCgXKQ5B6gnD1ijlY5VYIzQd63q_ytukKvNiLuIDHrwal_M3XykHn8rYGuY1KokYvGVFcIoqYKe-7fjQV24MXdX0UpH2Vk2fXg
			log("<<< vAccesstoken = " + vAccesstoken);
		}
		catch (Exception e) { vAccesstoken = null; log(e); }
		if (vAccesstoken == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'vAccesstoken' from html form parameter";
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
		String requestProt0022 = "https";
		String requestHost0022 = "api.infrontservices.com";
		int    requestPort0022 = 443;
		String requestFile0022 = "/id/scripts/infront.js";
		String requestHeader0022 = "GET " + requestFile0022 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0022, requestHost0022, requestPort0022, requestHeader0022, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("/id/connect/authorize?client_id=infront.authorization&redirect_uri=https%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2Flogin%2Fcallback&response_type=id_token%20token&response_mode=form_post&scope=exttoken%20openid%20email%20read%20write%20offline_access&state=D02B55BDF4C275B8A61D485065C243143A369208&nonce=B5BE23AED6BAB104A9AEF7DC6CD8AD6F302EC197&acr_values=post_logout_redirect_uri%3Ahttp%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2FLogin%2FIDPLogin", loginRedirect3);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0022 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1131
		// content test algorithm: check size +/- 5%, defined content size = 1131
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 1131, 5);		// Test [22] <- Index 22
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
		String requestHost0023 = "api.infrontservices.com";
		int    requestPort0023 = 443;
		String requestFile0023 = "/id/assets/app.FormPostResponse.js";
		String requestHeader0023 = "GET " + requestFile0023 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0023, requestHost0023, requestPort0023, requestHeader0023, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("/id/connect/authorize?client_id=infront.authorization&redirect_uri=https%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2Flogin%2Fcallback&response_type=id_token%20token&response_mode=form_post&scope=exttoken%20openid%20email%20read%20write%20offline_access&state=D02B55BDF4C275B8A61D485065C243143A369208&nonce=B5BE23AED6BAB104A9AEF7DC6CD8AD6F302EC197&acr_values=post_logout_redirect_uri%3Ahttp%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2FLogin%2FIDPLogin", loginRedirect3);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0023 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 155
		// content test algorithm: check size +/- 5%, defined content size = 155
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 155, 5);		// Test [23] <- Index 23
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
		log();
		log("# title: Object moved");
		String requestProt0024 = "https";
		String requestHost0024 = "trader.infrontfinance.com";
		int    requestPort0024 = 443;
		String requestFile0024 = "/infront/no/login/callback";
		String requestContent0024 = 
				"id_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyIsImtpZCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyJ9.eyJpc3MiOiJodHRwczovL2FwaS5pbmZyb250c2VydmljZXMuY29tL2lkIiwiYXVkIjoiaW5mcm9udC5hdXRob3JpemF0aW9uIiwiZXhwIjoxNDg0NjM5NDcwLCJuYmYiOjE0ODQ2MzkxNzAsIm5vbmNlIjoiQjVCRTIzQUVENkJBQjEwNEE5QUVGN0RDNkNEOEFENkYzMDJFQzE5NyIsImlhdCI6MTQ4NDYzOTE3MCwiYXRfaGFzaCI6IlRJNjVYTV9Lc1FVbTV4blVXcXI1d0EiLCJzaWQiOiJjZjI4MzYxNzI4ZjFhNWU0NGI4Y2Q3M2IyYmRkZmU0MyIsInN1YiI6IjM3ODg4NzMxMCIsImF1dGhfdGltZSI6MTQ4NDYzOTE3MCwiaWRwIjoiaWRzcnYiLCJ1c3IiOiJjYXJsLmVyaWNzc29uQGFwaWNhc3lzdGVtLmNvbSIsImFtciI6WyJwYXNzd29yZCJdfQ.noIyXFyQ0C5l-USNmyDCBsOms8ZxkUy6rZFUEhS9ie4d5Wr0ck9j17Gk0iUQtAtEEoYakP9wqotIo5fbLW8RMkVaGa619Wm7NVAI0PHnChOvmow0sFkS17migof9cdeHYlWfavIzmHT6f2ZXNst1zdH085WAjuCGwxK43lWTqbH8supbDjXMGuvR4uLyzVd-_ypwHmmBiv0r3BieAJnlfC90aOP9C4sL2EdV10TPRowqK9iSmdq_oHxvHqte468kzfpu5iUDl6qwvRFiOODMHfdldRGtG7Ra-kMpBiyE-6N_yx6e3dCS36Nvu3FKBXkf67Hr-b4dwi_aHly03KtTJQ" +
				"&access_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyIsImtpZCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyJ9.eyJpc3MiOiJodHRwczovL2FwaS5pbmZyb250c2VydmljZXMuY29tL2lkIiwiYXVkIjoiaHR0cHM6Ly9hcGkuaW5mcm9udHNlcnZpY2VzLmNvbS9pZC9yZXNvdXJjZXMiLCJleHAiOjE0ODQ2OTY3NzAsIm5iZiI6MTQ4NDYzOTE3MCwiY2xpZW50X2lkIjoiaW5mcm9udC5hdXRob3JpemF0aW9uIiwic2NvcGUiOlsiZXh0dG9rZW4iLCJvcGVuaWQiLCJlbWFpbCIsInJlYWQiLCJ3cml0ZSIsIm9mZmxpbmVfYWNjZXNzIl0sInN1YiI6IjM3ODg4NzMxMCIsImF1dGhfdGltZSI6MTQ4NDYzOTE3MCwiaWRwIjoiaWRzcnYiLCJ1c3IiOiJjYXJsLmVyaWNzc29uQGFwaWNhc3lzdGVtLmNvbSIsImFtciI6WyJwYXNzd29yZCJdfQ.BAEdPwM8aGzLVO4aXelI0juieqFA7ZMJDOLyg79TijQWjXDBFAKnn7A4dReWRl7SadC4ijbrdrXchf9dMHBTJaRCnjaMARTIhhbO8yf2dwOxQZs9UADH2eMVh4-EnlLNEV3KG3bExa9c3Dku4j_1QM1U9E5AQrMY2qboNWsu-lveaK1wsSW_vcLy8AkE7Iv04O8iYU4I-tsF5ZGu28QxlpwfG3xMYHwTisTaz_30M5TbFR3jpcUjuCgXKQ5B6gnD1ijlY5VYIzQd63q_ytukKvNiLuIDHrwal_M3XykHn8rYGuY1KokYvGVFcIoqYKe-7fjQV24MXdX0UpH2Vk2fXg" +
				"&token_type=Bearer" +
				"&expires_in=57600" +
				"&scope=exttoken+openid+email+read+write+offline_access" +
				"&state=" + vState +		// recorded value = D02B55BDF4C275B8A61D485065C243143A369208
				"&session_state=X9Mtv7DftIrFv-or4VTGeLfHm81HjW9u2rMXkUL05FM.f69199a4bca3fc6256669eab99ac7e3a";
		requestContent0024 = Lib.replaceTextPattern(requestContent0024, "57600", vExpiresin, 0);		// search and replace content fragment "57600" with variable 'vExpiresin' on all occurrences
		requestContent0024 = Lib.replaceTextPattern(requestContent0024, "X9Mtv7DftIrFv-or4VTGeLfHm81HjW9u2rMXkUL05FM.f69199a4bca3fc6256669eab99ac7e3a", vSessionstate, 0);		// search and replace content fragment "X9Mtv7DftIrFv-or4VTGeLfHm81HjW9u2rMXkUL05FM.f69199a4bca3fc6256669eab99ac7e3a" with variable 'vSessionstate' on all occurrences
		requestContent0024 = Lib.replaceTextPattern(requestContent0024, "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyIsImtpZCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyJ9.eyJpc3MiOiJodHRwczovL2FwaS5pbmZyb250c2VydmljZXMuY29tL2lkIiwiYXVkIjoiaW5mcm9udC5hdXRob3JpemF0aW9uIiwiZXhwIjoxNDg0NjM5NDcwLCJuYmYiOjE0ODQ2MzkxNzAsIm5vbmNlIjoiQjVCRTIzQUVENkJBQjEwNEE5QUVGN0RDNkNEOEFENkYzMDJFQzE5NyIsImlhdCI6MTQ4NDYzOTE3MCwiYXRfaGFzaCI6IlRJNjVYTV9Lc1FVbTV4blVXcXI1d0EiLCJzaWQiOiJjZjI4MzYxNzI4ZjFhNWU0NGI4Y2Q3M2IyYmRkZmU0MyIsInN1YiI6IjM3ODg4NzMxMCIsImF1dGhfdGltZSI6MTQ4NDYzOTE3MCwiaWRwIjoiaWRzcnYiLCJ1c3IiOiJjYXJsLmVyaWNzc29uQGFwaWNhc3lzdGVtLmNvbSIsImFtciI6WyJwYXNzd29yZCJdfQ.noIyXFyQ0C5l-USNmyDCBsOms8ZxkUy6rZFUEhS9ie4d5Wr0ck9j17Gk0iUQtAtEEoYakP9wqotIo5fbLW8RMkVaGa619Wm7NVAI0PHnChOvmow0sFkS17migof9cdeHYlWfavIzmHT6f2ZXNst1zdH085WAjuCGwxK43lWTqbH8supbDjXMGuvR4uLyzVd-_ypwHmmBiv0r3BieAJnlfC90aOP9C4sL2EdV10TPRowqK9iSmdq_oHxvHqte468kzfpu5iUDl6qwvRFiOODMHfdldRGtG7Ra-kMpBiyE-6N_yx6e3dCS36Nvu3FKBXkf67Hr-b4dwi_aHly03KtTJQ", vIdtoken, 0);		// search and replace content fragment "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyIsImtpZCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyJ9.eyJpc3MiOiJodHRwczovL2FwaS5pbmZyb250c2VydmljZXMuY29tL2lkIiwiYXVkIjoiaW5mcm9udC5hdXRob3JpemF0aW9uIiwiZXhwIjoxNDg0NjM5NDcwLCJuYmYiOjE0ODQ2MzkxNzAsIm5vbmNlIjoiQjVCRTIzQUVENkJBQjEwNEE5QUVGN0RDNkNEOEFENkYzMDJFQzE5NyIsImlhdCI6MTQ4NDYzOTE3MCwiYXRfaGFzaCI6IlRJNjVYTV9Lc1FVbTV4blVXcXI1d0EiLCJzaWQiOiJjZjI4MzYxNzI4ZjFhNWU0NGI4Y2Q3M2IyYmRkZmU0MyIsInN1YiI6IjM3ODg4NzMxMCIsImF1dGhfdGltZSI6MTQ4NDYzOTE3MCwiaWRwIjoiaWRzcnYiLCJ1c3IiOiJjYXJsLmVyaWNzc29uQGFwaWNhc3lzdGVtLmNvbSIsImFtciI6WyJwYXNzd29yZCJdfQ.noIyXFyQ0C5l-USNmyDCBsOms8ZxkUy6rZFUEhS9ie4d5Wr0ck9j17Gk0iUQtAtEEoYakP9wqotIo5fbLW8RMkVaGa619Wm7NVAI0PHnChOvmow0sFkS17migof9cdeHYlWfavIzmHT6f2ZXNst1zdH085WAjuCGwxK43lWTqbH8supbDjXMGuvR4uLyzVd-_ypwHmmBiv0r3BieAJnlfC90aOP9C4sL2EdV10TPRowqK9iSmdq_oHxvHqte468kzfpu5iUDl6qwvRFiOODMHfdldRGtG7Ra-kMpBiyE-6N_yx6e3dCS36Nvu3FKBXkf67Hr-b4dwi_aHly03KtTJQ" with variable 'vIdtoken' on all occurrences
		requestContent0024 = Lib.replaceTextPattern(requestContent0024, "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyIsImtpZCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyJ9.eyJpc3MiOiJodHRwczovL2FwaS5pbmZyb250c2VydmljZXMuY29tL2lkIiwiYXVkIjoiaHR0cHM6Ly9hcGkuaW5mcm9udHNlcnZpY2VzLmNvbS9pZC9yZXNvdXJjZXMiLCJleHAiOjE0ODQ2OTY3NzAsIm5iZiI6MTQ4NDYzOTE3MCwiY2xpZW50X2lkIjoiaW5mcm9udC5hdXRob3JpemF0aW9uIiwic2NvcGUiOlsiZXh0dG9rZW4iLCJvcGVuaWQiLCJlbWFpbCIsInJlYWQiLCJ3cml0ZSIsIm9mZmxpbmVfYWNjZXNzIl0sInN1YiI6IjM3ODg4NzMxMCIsImF1dGhfdGltZSI6MTQ4NDYzOTE3MCwiaWRwIjoiaWRzcnYiLCJ1c3IiOiJjYXJsLmVyaWNzc29uQGFwaWNhc3lzdGVtLmNvbSIsImFtciI6WyJwYXNzd29yZCJdfQ.BAEdPwM8aGzLVO4aXelI0juieqFA7ZMJDOLyg79TijQWjXDBFAKnn7A4dReWRl7SadC4ijbrdrXchf9dMHBTJaRCnjaMARTIhhbO8yf2dwOxQZs9UADH2eMVh4-EnlLNEV3KG3bExa9c3Dku4j_1QM1U9E5AQrMY2qboNWsu-lveaK1wsSW_vcLy8AkE7Iv04O8iYU4I-tsF5ZGu28QxlpwfG3xMYHwTisTaz_30M5TbFR3jpcUjuCgXKQ5B6gnD1ijlY5VYIzQd63q_ytukKvNiLuIDHrwal_M3XykHn8rYGuY1KokYvGVFcIoqYKe-7fjQV24MXdX0UpH2Vk2fXg", vAccesstoken, 0);		// search and replace content fragment "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyIsImtpZCI6IlEzTjRuZzc2N19aa2x3WFVTZEZZZFhCYW1EYyJ9.eyJpc3MiOiJodHRwczovL2FwaS5pbmZyb250c2VydmljZXMuY29tL2lkIiwiYXVkIjoiaHR0cHM6Ly9hcGkuaW5mcm9udHNlcnZpY2VzLmNvbS9pZC9yZXNvdXJjZXMiLCJleHAiOjE0ODQ2OTY3NzAsIm5iZiI6MTQ4NDYzOTE3MCwiY2xpZW50X2lkIjoiaW5mcm9udC5hdXRob3JpemF0aW9uIiwic2NvcGUiOlsiZXh0dG9rZW4iLCJvcGVuaWQiLCJlbWFpbCIsInJlYWQiLCJ3cml0ZSIsIm9mZmxpbmVfYWNjZXNzIl0sInN1YiI6IjM3ODg4NzMxMCIsImF1dGhfdGltZSI6MTQ4NDYzOTE3MCwiaWRwIjoiaWRzcnYiLCJ1c3IiOiJjYXJsLmVyaWNzc29uQGFwaWNhc3lzdGVtLmNvbSIsImFtciI6WyJwYXNzd29yZCJdfQ.BAEdPwM8aGzLVO4aXelI0juieqFA7ZMJDOLyg79TijQWjXDBFAKnn7A4dReWRl7SadC4ijbrdrXchf9dMHBTJaRCnjaMARTIhhbO8yf2dwOxQZs9UADH2eMVh4-EnlLNEV3KG3bExa9c3Dku4j_1QM1U9E5AQrMY2qboNWsu-lveaK1wsSW_vcLy8AkE7Iv04O8iYU4I-tsF5ZGu28QxlpwfG3xMYHwTisTaz_30M5TbFR3jpcUjuCgXKQ5B6gnD1ijlY5VYIzQd63q_ytukKvNiLuIDHrwal_M3XykHn8rYGuY1KokYvGVFcIoqYKe-7fjQV24MXdX0UpH2Vk2fXg" with variable 'vAccesstoken' on all occurrences

		String requestHeader0024 = "POST " + requestFile0024 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0024.length() + "\r\n" + 		// Content-Length: 2154
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0024, requestHost0024, requestPort0024, requestHeader0024, requestContent0024.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("/id/connect/authorize?client_id=infront.authorization&redirect_uri=https%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2Flogin%2Fcallback&response_type=id_token%20token&response_mode=form_post&scope=exttoken%20openid%20email%20read%20write%20offline_access&state=D02B55BDF4C275B8A61D485065C243143A369208&nonce=B5BE23AED6BAB104A9AEF7DC6CD8AD6F302EC197&acr_values=post_logout_redirect_uri%3Ahttp%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2FLogin%2FIDPLogin", loginRedirect3);		// search within all request header fields a text pattern and replace it with a variable value
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
		requestHeader0024 = null;		// support garbage collector to reduce memory
		requestContent0024 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 118
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [24] <- Index 24
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





		// --- HTTP REQUEST: Test [25] <- WEB ADMIN Index 25 ---
		log();
		log("# title: Object moved");
		String requestProt0025 = "https";
		String requestHost0025 = "trader.infrontfinance.com";
		int    requestPort0025 = 443;
		String requestFile0025 = "/";
		String requestHeader0025 = "GET " + requestFile0025 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0025, requestHost0025, requestPort0025, requestHeader0025, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("/id/connect/authorize?client_id=infront.authorization&redirect_uri=https%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2Flogin%2Fcallback&response_type=id_token%20token&response_mode=form_post&scope=exttoken%20openid%20email%20read%20write%20offline_access&state=D02B55BDF4C275B8A61D485065C243143A369208&nonce=B5BE23AED6BAB104A9AEF7DC6CD8AD6F302EC197&acr_values=post_logout_redirect_uri%3Ahttp%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2FLogin%2FIDPLogin", loginRedirect3);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0025 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 99
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [25] <- Index 25
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





		// --- HTTP REQUEST: Test [26] <- WEB ADMIN Index 26 ---
		log();
		log("# title: Infront Web");
		String requestProt0026 = "https";
		String requestHost0026 = "trader.infrontfinance.com";
		int    requestPort0026 = 443;
		String requestFile0026 = "/infront/no/";
		String requestHeader0026 = "GET " + requestFile0026 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0026, requestHost0026, requestPort0026, requestHeader0026, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("/id/connect/authorize?client_id=infront.authorization&redirect_uri=https%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2Flogin%2Fcallback&response_type=id_token%20token&response_mode=form_post&scope=exttoken%20openid%20email%20read%20write%20offline_access&state=D02B55BDF4C275B8A61D485065C243143A369208&nonce=B5BE23AED6BAB104A9AEF7DC6CD8AD6F302EC197&acr_values=post_logout_redirect_uri%3Ahttp%3A%2F%2Ftrader.infrontfinance.com%2Finfront%2Fno%2FLogin%2FIDPLogin", loginRedirect3);		// search within all request header fields a text pattern and replace it with a variable value
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0026 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 32051
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Logging out and back in will usually solve this issue.");		// Test [26] <- Index 26
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





		// --- HTTP REQUEST: Test [27] <- WEB ADMIN Index 27 ---
		String requestProt0027 = "https";
		String requestHost0027 = "trader.infrontfinance.com";
		int    requestPort0027 = 443;
		String requestFile0027 = "/content/js/wt-languages.js";
		String requestHeader0027 = "GET " + requestFile0027 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5481
		// content test algorithm: check size +/- 5%, defined content size = 5481
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 5481, 5);		// Test [27] <- Index 27
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
		String requestHost0028 = "wtk.infrontservices.com";
		int    requestPort0028 = 443;
		String requestFile0028 = "/css/InfrontFramework-2.1.12.css";
		String requestHeader0028 = "GET " + requestFile0028 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: wtk.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 12212
		// content test algorithm: check size +/- 5%, defined content size = 12212
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 12212, 5);		// Test [28] <- Index 28
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
		String requestHost0029 = "wtk.infrontservices.com";
		int    requestPort0029 = 443;
		String requestFile0029 = "/js/InfrontUI-2.1.12.min.js";
		String requestHeader0029 = "GET " + requestFile0029 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: wtk.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 189940
		// content test algorithm: check size +/- 5%, defined content size = 189940
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 189940, 5);		// Test [29] <- Index 29
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
		String requestHost0030 = "wtk.infrontservices.com";
		int    requestPort0030 = 443;
		String requestFile0030 = "/languages/da.js";
		String requestHeader0030 = "GET " + requestFile0030 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: wtk.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5019
		// content test algorithm: check size +/- 5%, defined content size = 5019
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 5019, 5);		// Test [30] <- Index 30
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
		String requestHost0031 = "wtk.infrontservices.com";
		int    requestPort0031 = 443;
		String requestFile0031 = "/languages/no.js";
		String requestHeader0031 = "GET " + requestFile0031 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: wtk.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0031, requestHost0031, requestPort0031, requestHeader0031, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0031 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4219
		// content test algorithm: check size +/- 5%, defined content size = 4219
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 4219, 5);		// Test [31] <- Index 31
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
		String requestHost0032 = "wtk.infrontservices.com";
		int    requestPort0032 = 443;
		String requestFile0032 = "/js/CommonFramework-1.2.5.min.js";
		String requestHeader0032 = "GET " + requestFile0032 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: wtk.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0032, requestHost0032, requestPort0032, requestHeader0032, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0032 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 54452
		// content test algorithm: check size +/- 5%, defined content size = 54452
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 54452, 5);		// Test [32] <- Index 32
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
		String requestHost0033 = "trader.infrontfinance.com";
		int    requestPort0033 = 443;
		String requestFile0033 = "/content/css/wt.css" +
				"?v=20170111141504";
		String requestHeader0033 = "GET " + requestFile0033 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 13174
		// content test algorithm: check size +/- 5%, defined content size = 13174
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 13174, 5);		// Test [33] <- Index 33
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
		String requestHost0034 = "wtk.infrontservices.com";
		int    requestPort0034 = 443;
		String requestFile0034 = "/themes/terminal-2.1.12/theme.css";
		String requestHeader0034 = "GET " + requestFile0034 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: wtk.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0034, requestHost0034, requestPort0034, requestHeader0034, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0034 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 10001
		// content test algorithm: check size +/- 5%, defined content size = 10001
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 10001, 5);		// Test [34] <- Index 34
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
		String requestHost0035 = "wtk.infrontservices.com";
		int    requestPort0035 = 443;
		String requestFile0035 = "/languages/sv.js";
		String requestHeader0035 = "GET " + requestFile0035 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: wtk.infrontservices.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0035, requestHost0035, requestPort0035, requestHeader0035, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0035 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5121
		// content test algorithm: check size +/- 5%, defined content size = 5121
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 5121, 5);		// Test [35] <- Index 35
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
		String requestHost0036 = "trader.infrontfinance.com";
		int    requestPort0036 = 443;
		String requestFile0036 = "/Content/gfx/favicons/favicon.ico";
		String requestHeader0036 = "GET " + requestFile0036 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0036, requestHost0036, requestPort0036, requestHeader0036, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0036 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/X-ICON", header text fragment = [verification disabled], recorded content size = 10990
		// content test algorithm: check size +/- 5%, defined content size = 10990
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/X-ICON", null, 10990, 5);		// Test [36] <- Index 36
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
		String requestHost0037 = "code.highcharts.com";
		int    requestPort0037 = 443;
		String requestFile0037 = "/stock/4.2.4/highstock.js";
		String requestHeader0037 = "GET " + requestFile0037 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: code.highcharts.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 79473
		// content test algorithm: check size +/- 5%, defined content size = 79473
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 79473, 5);		// Test [37] <- Index 37
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
		String requestHost0038 = "trader.infrontfinance.com";
		int    requestPort0038 = 443;
		String requestFile0038 = "/content/css/perfect-scrollbar.css" +
				"?v=20170111141504";
		String requestHeader0038 = "GET " + requestFile0038 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0038, requestHost0038, requestPort0038, requestHeader0038, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0038 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1076
		// content test algorithm: check size +/- 5%, defined content size = 1076
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 1076, 5);		// Test [38] <- Index 38
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
		String requestHost0039 = "trader.infrontfinance.com";
		int    requestPort0039 = 443;
		String requestFile0039 = "/content/js/countrycodes.js";
		String requestHeader0039 = "GET " + requestFile0039 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0039, requestHost0039, requestPort0039, requestHeader0039, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0039 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1535
		// content test algorithm: check size +/- 5%, defined content size = 1535
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 1535, 5);		// Test [39] <- Index 39
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
	 * Recorded http requests of page #2_1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #2 (fragment 2 of 3)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [40] <- WEB ADMIN Index 40 ---
		String requestProt0040 = "https";
		String requestHost0040 = "trader.infrontfinance.com";
		int    requestPort0040 = 443;
		String requestFile0040 = "/content/js/perfect-scrollbar.jquery.js";
		String requestHeader0040 = "GET " + requestFile0040 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 12529
		// content test algorithm: check size +/- 5%, defined content size = 12529
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 12529, 5);		// Test [40] <- Index 40
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
		String requestHost0041 = "trader.infrontfinance.com";
		int    requestPort0041 = 443;
		String requestFile0041 = "/content/css/jquery.gridster.css" +
				"?v=20170111141504";
		String requestHeader0041 = "GET " + requestFile0041 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0041, requestHost0041, requestPort0041, requestHeader0041, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0041 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1660
		// content test algorithm: check size +/- 5%, defined content size = 1660
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 1660, 5);		// Test [41] <- Index 41
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





		// --- HTTP REQUEST: Test [42] <- WEB ADMIN Index 42 ---
		String requestProt0042 = "https";
		String requestHost0042 = "trader.infrontfinance.com";
		int    requestPort0042 = 443;
		String requestFile0042 = "/content/js/jquery.gridster.with-extras.js";
		String requestHeader0042 = "GET " + requestFile0042 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0042, requestHost0042, requestPort0042, requestHeader0042, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0042 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 36940
		// content test algorithm: check size +/- 5%, defined content size = 36940
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 36940, 5);		// Test [42] <- Index 42
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
		String requestHost0043 = "trader.infrontfinance.com";
		int    requestPort0043 = 443;
		String requestFile0043 = "/Content/js/charting-TEMP/indicators/indicators.js";
		String requestHeader0043 = "GET " + requestFile0043 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0043, requestHost0043, requestPort0043, requestHeader0043, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0043 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 12478
		// content test algorithm: check size +/- 5%, defined content size = 12478
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 12478, 5);		// Test [43] <- Index 43
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
		String requestHost0044 = "trader.infrontfinance.com";
		int    requestPort0044 = 443;
		String requestFile0044 = "/Content/js/charting-TEMP/indicators/sma.js";
		String requestHeader0044 = "GET " + requestFile0044 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0044, requestHost0044, requestPort0044, requestHeader0044, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0044 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1873
		// content test algorithm: check size +/- 5%, defined content size = 1873
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 1873, 5);		// Test [44] <- Index 44
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
		String requestHost0045 = "trader.infrontfinance.com";
		int    requestPort0045 = 443;
		String requestFile0045 = "/Content/js/charting-TEMP/indicators/ema.js";
		String requestHeader0045 = "GET " + requestFile0045 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0045, requestHost0045, requestPort0045, requestHeader0045, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0045 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1914
		// content test algorithm: check size +/- 5%, defined content size = 1914
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 1914, 5);		// Test [45] <- Index 45
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
		String requestHost0046 = "trader.infrontfinance.com";
		int    requestPort0046 = 443;
		String requestFile0046 = "/Content/js/charting-TEMP/indicators/wma.js";
		String requestHeader0046 = "GET " + requestFile0046 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1981
		// content test algorithm: check size +/- 5%, defined content size = 1981
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 1981, 5);		// Test [46] <- Index 46
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
		String requestHost0047 = "trader.infrontfinance.com";
		int    requestPort0047 = 443;
		String requestFile0047 = "/Content/js/charting-TEMP/indicators/atr.js";
		String requestHeader0047 = "GET " + requestFile0047 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0047, requestHost0047, requestPort0047, requestHeader0047, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0047 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2238
		// content test algorithm: check size +/- 5%, defined content size = 2238
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 2238, 5);		// Test [47] <- Index 47
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
		String requestHost0048 = "trader.infrontfinance.com";
		int    requestPort0048 = 443;
		String requestFile0048 = "/Content/js/charting-TEMP/indicators/rsi.js";
		String requestHeader0048 = "GET " + requestFile0048 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0048, requestHost0048, requestPort0048, requestHeader0048, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0048 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2731
		// content test algorithm: check size +/- 5%, defined content size = 2731
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 2731, 5);		// Test [48] <- Index 48
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
		String requestHost0049 = "trader.infrontfinance.com";
		int    requestPort0049 = 443;
		String requestFile0049 = "/Content/js/charting-TEMP/indicators/macd.js";
		String requestHeader0049 = "GET " + requestFile0049 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0049, requestHost0049, requestPort0049, requestHeader0049, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0049 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 3568
		// content test algorithm: check size +/- 5%, defined content size = 3568
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 3568, 5);		// Test [49] <- Index 49
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
		String requestHost0050 = "trader.infrontfinance.com";
		int    requestPort0050 = 443;
		String requestFile0050 = "/Content/js/charting-TEMP/indicators/bb.js";
		String requestHeader0050 = "GET " + requestFile0050 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0050, requestHost0050, requestPort0050, requestHeader0050, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0050 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2490
		// content test algorithm: check size +/- 5%, defined content size = 2490
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 2490, 5);		// Test [50] <- Index 50
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
		String requestHost0051 = "trader.infrontfinance.com";
		int    requestPort0051 = 443;
		String requestFile0051 = "/Content/js/charting-TEMP/indicators/stochastic.js";
		String requestHeader0051 = "GET " + requestFile0051 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0051, requestHost0051, requestPort0051, requestHeader0051, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0051 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2940
		// content test algorithm: check size +/- 5%, defined content size = 2940
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 2940, 5);		// Test [51] <- Index 51
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
		String requestHost0052 = "trader.infrontfinance.com";
		int    requestPort0052 = 443;
		String requestFile0052 = "/content/js/Storage.js" +
				"?v=20170111141504";
		String requestHeader0052 = "GET " + requestFile0052 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0052, requestHost0052, requestPort0052, requestHeader0052, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0052 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1834
		// content test algorithm: check size +/- 5%, defined content size = 1834
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 1834, 5);		// Test [52] <- Index 52
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
		String requestHost0053 = "trader.infrontfinance.com";
		int    requestPort0053 = 443;
		String requestFile0053 = "/content/js/CustomWorkspaces.js" +
				"?v=20170111141504";
		String requestHeader0053 = "GET " + requestFile0053 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0053, requestHost0053, requestPort0053, requestHeader0053, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0053 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 11024
		// content test algorithm: check size +/- 5%, defined content size = 11024
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 11024, 5);		// Test [53] <- Index 53
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
		String requestHost0054 = "trader.infrontfinance.com";
		int    requestPort0054 = 443;
		String requestFile0054 = "/a/Storage/GetAllWebTraderSettings/-infront-no-";
		String requestHeader0054 = "POST " + requestFile0054 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Length: 0\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0054, requestHost0054, requestPort0054, requestHeader0054, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0054 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 939
		// content test algorithm: check size +/- 5%, defined content size = 939
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 939, 5);		// Test [54] <- Index 54
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
		try
		{
			xmlContentParser = new XmlContentParser(Lib.convertJsonToXml(testURL.getContentString()), this);
		}
		catch (Exception e)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: malformed XML or JSON data - unable to parse received response content";
			log(errorText);
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		try
		{
			// extract var 'sessionToken'
			sessionToken = xmlContentParser.getNodeValue("<JSON><sessionToken>", 1);		// recorded value = d7fc8e80-6080-46c4-a31d-651aa2fadcf9
			log("<<< sessionToken = " + sessionToken);
		}
		catch (Exception e) { sessionToken = null; log(e); }
		if (sessionToken == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'sessionToken' from xml response data";
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





		// --- HTTP REQUEST: Test [55] <- WEB ADMIN Index 55 ---
		String requestProt0055 = "https";
		String requestHost0055 = "trader.infrontfinance.com";
		int    requestPort0055 = 443;
		String requestFile0055 = "/Content/gfx/ic_expand_more_white_24px.svg";
		String requestHeader0055 = "GET " + requestFile0055 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/SVG+XML", header text fragment = [verification disabled], recorded content size = 208
		// content test algorithm: check size +/- 5%, defined content size = 208
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/SVG+XML", null, 208, 5);		// Test [55] <- Index 55
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
		String requestHost0056 = "trader.infrontfinance.com";
		int    requestPort0056 = 443;
		String requestFile0056 = "/content/gfx/infront-logo_top_white.png";
		String requestHeader0056 = "GET " + requestFile0056 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0056, requestHost0056, requestPort0056, requestHeader0056, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0056 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1779
		// content test algorithm: check size +/- 5%, defined content size = 1779
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1779, 5);		// Test [56] <- Index 56
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
		String requestHost0057 = "trader.infrontfinance.com";
		int    requestPort0057 = 443;
		String requestFile0057 = "/Content/gfx/ic_settings_white_18px.svg";
		String requestHeader0057 = "GET " + requestFile0057 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0057, requestHost0057, requestPort0057, requestHeader0057, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0057 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/SVG+XML", header text fragment = [verification disabled], recorded content size = 836
		// content test algorithm: check size +/- 5%, defined content size = 836
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/SVG+XML", null, 836, 5);		// Test [57] <- Index 57
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
		String requestHost0058 = "trader.infrontfinance.com";
		int    requestPort0058 = 443;
		String requestFile0058 = "/Content/gfx/ic_phone_white_18px.svg";
		String requestHeader0058 = "GET " + requestFile0058 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0058, requestHost0058, requestPort0058, requestHeader0058, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0058 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/SVG+XML", header text fragment = [verification disabled], recorded content size = 404
		// content test algorithm: check size +/- 5%, defined content size = 404
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/SVG+XML", null, 404, 5);		// Test [58] <- Index 58
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
		String requestHost0059 = "trader.infrontfinance.com";
		int    requestPort0059 = 443;
		String requestFile0059 = "/Content/gfx/ic_account_box_white_18px.svg";
		String requestHeader0059 = "GET " + requestFile0059 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0059, requestHost0059, requestPort0059, requestHeader0059, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0059 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/SVG+XML", header text fragment = [verification disabled], recorded content size = 340
		// content test algorithm: check size +/- 5%, defined content size = 340
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/SVG+XML", null, 340, 5);		// Test [59] <- Index 59
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



		// all http requests of page #2_1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #2_2.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #2 (fragment 3 of 3)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [60] <- WEB ADMIN Index 60 ---
		String requestProt0060 = "https";
		String requestHost0060 = "trader.infrontfinance.com";
		int    requestPort0060 = 443;
		String requestFile0060 = "/Content/gfx/ic_feedback_white_18px.svg";
		String requestHeader0060 = "GET " + requestFile0060 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0060, requestHost0060, requestPort0060, requestHeader0060, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0060 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/SVG+XML", header text fragment = [verification disabled], recorded content size = 268
		// content test algorithm: check size +/- 5%, defined content size = 268
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/SVG+XML", null, 268, 5);		// Test [60] <- Index 60
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





		// --- HTTP REQUEST: Test [61] <- WEB ADMIN Index 61 ---
		String requestProt0061 = "https";
		String requestHost0061 = "trader.infrontfinance.com";
		int    requestPort0061 = 443;
		String requestFile0061 = "/Content/gfx/ic_exit_to_app_white_18px.svg";
		String requestHeader0061 = "GET " + requestFile0061 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0061, requestHost0061, requestPort0061, requestHeader0061, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0061 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/SVG+XML", header text fragment = [verification disabled], recorded content size = 328
		// content test algorithm: check size +/- 5%, defined content size = 328
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/SVG+XML", null, 328, 5);		// Test [61] <- Index 61
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
		String requestHost0062 = "trader.infrontfinance.com";
		int    requestPort0062 = 443;
		String requestFile0062 = "/content/fonts/roboto-v15-latin-regular.woff2";
		String requestHeader0062 = "GET " + requestFile0062 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0062, requestHost0062, requestPort0062, requestHeader0062, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0062 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF2", header text fragment = [verification disabled], recorded content size = 14584
		// content test algorithm: check size +/- 5%, defined content size = 14584
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF2", null, 14584, 5);		// Test [62] <- Index 62
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





		// --- HTTP REQUEST: Test [63] <- WEB ADMIN Index 63 ---
		String requestProt0063 = "https";
		String requestHost0063 = "trader.infrontfinance.com";
		int    requestPort0063 = 443;
		String requestFile0063 = "/content/fonts/roboto-v15-latin-300.woff2";
		String requestHeader0063 = "GET " + requestFile0063 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0063, requestHost0063, requestPort0063, requestHeader0063, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0063 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF2", header text fragment = [verification disabled], recorded content size = 14524
		// content test algorithm: check size +/- 5%, defined content size = 14524
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF2", null, 14524, 5);		// Test [63] <- Index 63
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





		// --- HTTP REQUEST: Test [64] <- WEB ADMIN Index 64 ---
		String requestProt0064 = "https";
		String requestHost0064 = "trader.infrontfinance.com";
		int    requestPort0064 = 443;
		String requestFile0064 = "/content/fonts/roboto-v15-latin-700.woff2";
		String requestHeader0064 = "GET " + requestFile0064 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0064, requestHost0064, requestPort0064, requestHeader0064, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0064 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF2", header text fragment = [verification disabled], recorded content size = 14552
		// content test algorithm: check size +/- 5%, defined content size = 14552
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF2", null, 14552, 5);		// Test [64] <- Index 64
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





		// --- HTTP REQUEST: Test [65] <- WEB ADMIN Index 65 ---
		String requestProt0065 = "https";
		String requestHost0065 = "trader.infrontfinance.com";
		int    requestPort0065 = 443;
		String requestFile0065 = "/Content/gfx/ic_add_white_18dp_1x.png";
		String requestHeader0065 = "GET " + requestFile0065 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: trader.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0065, requestHost0065, requestPort0065, requestHeader0065, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0065 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 102
		// content test algorithm: check size +/- 5%, defined content size = 102
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 102, 5);		// Test [65] <- Index 65
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
		String requestHost0066 = "mws.infrontfinance.com";
		int    requestPort0066 = 443;
		String requestFile0066 = "/mws";
		String requestHeader0066 = "GET " + requestFile0066 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: mws.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Sec-WebSocket-Version: 13\r\n" + 
				"Origin: https://trader.infrontfinance.com\r\n" + 
				"Sec-WebSocket-Extensions: permessage-deflate\r\n" + 
				"Sec-WebSocket-Key: g+NgtZ23YY27MIwKoz+j8Q==\r\n" + 
				"Connection: Keep-Alive, Upgrade\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Upgrade: websocket\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0066, requestHost0066, requestPort0066, requestHeader0066, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		webSocketData = getWebSocketData_1484639197242();
		testURL.setWebSocketContext(new HttpTestWebsocketContext(webSocketData, null, null));


		testURL.execute(performanceData);
		requestHeader0066 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 101, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: check size +/- 5%, defined content size = 0
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {101}, null, null, 0, 5);		// Test [66] <- Index 66
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





		// --- HTTP REQUEST: Test [67] <- WEB ADMIN Index 67 ---
		String requestProt0067 = "https";
		String requestHost0067 = "mws.infrontfinance.com";
		int    requestPort0067 = 443;
		String requestFile0067 = "/mws";
		String requestHeader0067 = "GET " + requestFile0067 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: mws.infrontfinance.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Sec-WebSocket-Version: 13\r\n" + 
				"Origin: https://trader.infrontfinance.com\r\n" + 
				"Sec-WebSocket-Extensions: permessage-deflate\r\n" + 
				"Sec-WebSocket-Key: mA7hd3husPQpPs14nauSyg==\r\n" + 
				"Connection: Keep-Alive, Upgrade\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Upgrade: websocket\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0067, requestHost0067, requestPort0067, requestHeader0067, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		webSocketData = getWebSocketData_1484639228062();
		testURL.setWebSocketContext(new HttpTestWebsocketContext(webSocketData, null, null));


		testURL.execute(performanceData);
		requestHeader0067 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 101, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: check size +/- 5%, defined content size = 0
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {101}, null, null, 0, 5);		// Test [67] <- Index 67
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



		// all http requests of page #2_2 successful done
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
		
		String genericFileName = PerformanceData.proposeFileName("infrontWebsocket2", concurrentUsers);
		
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
		final int PAGE_BREAKS = 2;  // number of page breaks in execute()  - modify this value if you add or delete some page breaks
		final int MAX_THREAD_STEPS = 66;  // number of URL requests in execute() - modify this value if you add or delete some requests
		performanceData = new PerformanceData(PAGE_BREAKS, MAX_THREAD_STEPS, concurrentUsers, -1, plannedTestDuration, maxPlannedLoops, httpProtocolVersion, plannedStartupDelay, plannedRequestTimeout, samplingInterval, percentilePageSampling, percentileUrlSampling, percentileUrlSamplingAddOption);
		performanceData.setInfoText("infrontWebsocket2");
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
		LoadtestPluginContext globalPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, new infrontWebsocket2());
		
		
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
				
				infrontWebsocket2 simulatedUser = new infrontWebsocket2(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
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
				
				infrontWebsocket2 simulatedUser = new infrontWebsocket2(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
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



	
	// source code getting the webSocket context.
	public WebSocketData getWebSocketData_1484639197242()
	{

		WebSocketData webSocketData = new WebSocketData();
		webSocketData.setConnectionStartMillis(1484639197275L);
		webSocketData.setConnectionStopMillis(1484639227286L);
		webSocketData.setSecProtocol("plain");
		String payLoad_0 = "{\"md_login_request\":{\"client_application\":\"WEB\",\"client_application_version\":\"3.0.1\",\"country_code\":\"no\",\"language_code\":\"en\",\"api_version\":\"1.5.1\"},\"request_data\":\"0\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_2 = "{\"md_subscribe_alerts_request\":{\"update_data\":\"4c8e4c6f-33b4-4e3e-a740-527c0988ee51\"},\"request_data\":\"1\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_3 = "{\"md_get_trades_by_days_request\":{\"instrument\":{\"feed\":2161,\"ticker\":\"SX5E\"},\"days_back\":9,\"fields\":[\"LAST\",\"OPEN\",\"HIGH\",\"LOW\",\"VOLUME\"],\"resolution\":\"MINUTES\",\"step_size\":15},\"request_data\":\"2\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_5 = "{\"md_get_trades_by_days_request\":{\"instrument\":{\"feed\":2098,\"ticker\":\"DAX\"},\"days_back\":9,\"fields\":[\"LAST\",\"OPEN\",\"HIGH\",\"LOW\",\"VOLUME\"],\"resolution\":\"MINUTES\",\"step_size\":15},\"request_data\":\"3\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_6 = "{\"md_get_trades_by_days_request\":{\"instrument\":{\"feed\":2018,\"ticker\":\"UKX\"},\"days_back\":9,\"fields\":[\"LAST\",\"OPEN\",\"HIGH\",\"LOW\",\"VOLUME\"],\"resolution\":\"MINUTES\",\"step_size\":15},\"request_data\":\"4\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_7 = "{\"md_get_trades_by_days_request\":{\"instrument\":{\"feed\":2089,\"ticker\":\"PX1\"},\"days_back\":9,\"fields\":[\"LAST\",\"OPEN\",\"HIGH\",\"LOW\",\"VOLUME\"],\"resolution\":\"MINUTES\",\"step_size\":15},\"request_data\":\"5\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_8 = "{\"md_get_feed_metadata_request\":{\"feed\":2161},\"request_data\":\"6\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_9 = "{\"md_get_market_activity_request\":{\"feed\":2161,\"chain\":\"SX5E\"},\"request_data\":\"7\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_10 = "{\"md_get_feed_metadata_request\":{\"feed\":2098},\"request_data\":\"8\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_11 = "{\"md_get_market_activity_request\":{\"feed\":2098,\"chain\":\"DAX\"},\"request_data\":\"9\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_12 = "{\"md_get_feed_metadata_request\":{\"feed\":2018},\"request_data\":\"10\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_13 = "{\"md_get_market_activity_request\":{\"feed\":2018,\"chain\":\"UKX\"},\"request_data\":\"11\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_14 = "{\"md_get_feed_metadata_request\":{\"feed\":2089},\"request_data\":\"12\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_15 = "{\"md_get_market_activity_request\":{\"feed\":2089,\"chain\":\"PX1\"},\"request_data\":\"13\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_16 = "{\"md_get_chain_request\":{\"chain\":\"web_sidebar_1\",\"feed\":990,\"access\":\"HISTORICAL\"},\"request_data\":\"14\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_17 = "{\"md_get_chain_request\":{\"chain\":\"web_sidebar_2\",\"feed\":990,\"access\":\"HISTORICAL\"},\"request_data\":\"15\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_19 = "{\"md_get_chain_request\":{\"chain\":\"web_sidebar_3\",\"feed\":990,\"access\":\"HISTORICAL\"},\"request_data\":\"16\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_21 = "{\"md_get_chain_request\":{\"chain\":\"web_sidebar_4\",\"feed\":990,\"access\":\"HISTORICAL\"},\"request_data\":\"17\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_22 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2161,\"ticker\":\"SX5E\"}],\"fields\":[\"CHANGE\",\"HIST_PERFORMANCE\",\"LAST\",\"LAST_VALID\",\"PCT_CHANGE\",\"PREVIOUS_CLOSE\",\"TIME\"]},\"request_data\":\"18\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_23 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2098,\"ticker\":\"DAX\"}],\"fields\":[\"CHANGE\",\"HIST_PERFORMANCE\",\"LAST\",\"LAST_VALID\",\"PCT_CHANGE\",\"PREVIOUS_CLOSE\",\"TIME\"]},\"request_data\":\"19\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_24 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2018,\"ticker\":\"UKX\"}],\"fields\":[\"CHANGE\",\"HIST_PERFORMANCE\",\"LAST\",\"LAST_VALID\",\"PCT_CHANGE\",\"PREVIOUS_CLOSE\",\"TIME\"]},\"request_data\":\"20\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_26 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2089,\"ticker\":\"PX1\"}],\"fields\":[\"CHANGE\",\"HIST_PERFORMANCE\",\"LAST\",\"LAST_VALID\",\"PCT_CHANGE\",\"PREVIOUS_CLOSE\",\"TIME\"]},\"request_data\":\"21\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_46 = "{\"md_get_feed_metadata_request\":{\"feed\":12},\"request_data\":\"22\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_50 = "{\"md_get_feed_metadata_request\":{\"feed\":2087},\"request_data\":\"23\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_53 = "{\"md_get_feed_metadata_request\":{\"feed\":18177},\"request_data\":\"24\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_54 = "{\"md_get_feed_metadata_request\":{\"feed\":2159},\"request_data\":\"25\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_55 = "{\"md_get_feed_metadata_request\":{\"feed\":2229},\"request_data\":\"26\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_56 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":12,\"ticker\":\"EURDKK\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"27\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_58 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":12,\"ticker\":\"EURGBP\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"28\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_59 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":12,\"ticker\":\"EURNOK\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"29\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_60 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":12,\"ticker\":\"EURSEK\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"30\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_61 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":12,\"ticker\":\"EURUSD\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"31\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_62 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":12,\"ticker\":\"GBPUSD\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"32\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_63 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":12,\"ticker\":\"USDCHF\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"33\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_64 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":12,\"ticker\":\"USDDKK\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"34\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_65 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":12,\"ticker\":\"USDNOK\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"35\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_66 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":12,\"ticker\":\"USDSEK\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"36\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_69 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2087,\"ticker\":\"OMXC20\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"37\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_71 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2087,\"ticker\":\"OMXH25\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"38\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_74 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2087,\"ticker\":\"OMXN40\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"39\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_76 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2087,\"ticker\":\"OMXS30\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"40\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_78 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":18177,\"ticker\":\"OSEBX\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"41\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_80 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2159,\"ticker\":\"GLDSPOT\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"42\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_81 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2159,\"ticker\":\"SLVSPOT\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"43\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_82 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2229,\"ticker\":\"BRT\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"44\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_85 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2229,\"ticker\":\"WTI\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"45\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_89 = "{\"md_get_feed_metadata_request\":{\"feed\":2088},\"request_data\":\"46\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_91 = "{\"md_get_feed_metadata_request\":{\"feed\":2162},\"request_data\":\"47\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_93 = "{\"md_get_feed_metadata_request\":{\"feed\":2198},\"request_data\":\"48\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_94 = "{\"md_get_feed_metadata_request\":{\"feed\":6150},\"request_data\":\"49\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_95 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2087,\"ticker\":\"NDX\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"50\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_96 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2088,\"ticker\":\"SP500\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"51\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_97 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2162,\"ticker\":\"RTSI\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"52\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_98 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":2198,\"ticker\":\"HSI\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"53\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";
		String payLoad_99 = "{\"md_subscribe_instrument_request\":{\"instruments\":[{\"feed\":6150,\"ticker\":\"N225\"}],\"fields\":[\"HIST_PERFORMANCE\",\"LAST_VALID\",\"LAST_VALID_DATE\",\"PCT_CHANGE\",\"TIME\"]},\"request_data\":\"54\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";

		// search and replace frame payload "d7fc8e80-6080-46c4-a31d-651aa2fadcf9" with variable 'sessionToken' on all occurrences of all frames.
		payLoad_0 = Lib.replaceTextPattern(payLoad_0, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_2 = Lib.replaceTextPattern(payLoad_2, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_3 = Lib.replaceTextPattern(payLoad_3, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_5 = Lib.replaceTextPattern(payLoad_5, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_6 = Lib.replaceTextPattern(payLoad_6, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_7 = Lib.replaceTextPattern(payLoad_7, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_8 = Lib.replaceTextPattern(payLoad_8, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_9 = Lib.replaceTextPattern(payLoad_9, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_10 = Lib.replaceTextPattern(payLoad_10, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_11 = Lib.replaceTextPattern(payLoad_11, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_12 = Lib.replaceTextPattern(payLoad_12, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_13 = Lib.replaceTextPattern(payLoad_13, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_14 = Lib.replaceTextPattern(payLoad_14, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_15 = Lib.replaceTextPattern(payLoad_15, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_16 = Lib.replaceTextPattern(payLoad_16, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_17 = Lib.replaceTextPattern(payLoad_17, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_19 = Lib.replaceTextPattern(payLoad_19, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_21 = Lib.replaceTextPattern(payLoad_21, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_22 = Lib.replaceTextPattern(payLoad_22, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_23 = Lib.replaceTextPattern(payLoad_23, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_24 = Lib.replaceTextPattern(payLoad_24, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_26 = Lib.replaceTextPattern(payLoad_26, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_46 = Lib.replaceTextPattern(payLoad_46, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_50 = Lib.replaceTextPattern(payLoad_50, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_53 = Lib.replaceTextPattern(payLoad_53, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_54 = Lib.replaceTextPattern(payLoad_54, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_55 = Lib.replaceTextPattern(payLoad_55, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_56 = Lib.replaceTextPattern(payLoad_56, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_58 = Lib.replaceTextPattern(payLoad_58, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_59 = Lib.replaceTextPattern(payLoad_59, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_60 = Lib.replaceTextPattern(payLoad_60, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_61 = Lib.replaceTextPattern(payLoad_61, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_62 = Lib.replaceTextPattern(payLoad_62, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_63 = Lib.replaceTextPattern(payLoad_63, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_64 = Lib.replaceTextPattern(payLoad_64, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_65 = Lib.replaceTextPattern(payLoad_65, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_66 = Lib.replaceTextPattern(payLoad_66, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_69 = Lib.replaceTextPattern(payLoad_69, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_71 = Lib.replaceTextPattern(payLoad_71, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_74 = Lib.replaceTextPattern(payLoad_74, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_76 = Lib.replaceTextPattern(payLoad_76, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_78 = Lib.replaceTextPattern(payLoad_78, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_80 = Lib.replaceTextPattern(payLoad_80, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_81 = Lib.replaceTextPattern(payLoad_81, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_82 = Lib.replaceTextPattern(payLoad_82, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_85 = Lib.replaceTextPattern(payLoad_85, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_89 = Lib.replaceTextPattern(payLoad_89, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_91 = Lib.replaceTextPattern(payLoad_91, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_93 = Lib.replaceTextPattern(payLoad_93, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_94 = Lib.replaceTextPattern(payLoad_94, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_95 = Lib.replaceTextPattern(payLoad_95, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_96 = Lib.replaceTextPattern(payLoad_96, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_97 = Lib.replaceTextPattern(payLoad_97, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_98 = Lib.replaceTextPattern(payLoad_98, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);
		payLoad_99 = Lib.replaceTextPattern(payLoad_99, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);


		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197281L,1484639197287L  , payLoad_0, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197325L,1484639197332L  , payLoad_2, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197347L,1484639197354L  , payLoad_3, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197355L,1484639197368L  , payLoad_5, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197368L,1484639197372L  , payLoad_6, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197372L,1484639197377L  , payLoad_7, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197377L,1484639197384L  , payLoad_8, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197385L,1484639197389L  , payLoad_9, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197389L,1484639197395L  , payLoad_10, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197395L,1484639197399L  , payLoad_11, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197399L,1484639197403L  , payLoad_12, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197403L,1484639197408L  , payLoad_13, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197409L,1484639197413L  , payLoad_14, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197413L,1484639197419L  , payLoad_15, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197419L,1484639197425L  , payLoad_16, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197425L,1484639197429L  , payLoad_17, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197430L,1484639197438L  , payLoad_19, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197439L,1484639197452L  , payLoad_21, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197452L,1484639197466L  , payLoad_22, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197466L,1484639197469L  , payLoad_23, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197470L,1484639197474L  , payLoad_24, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197475L,1484639197482L  , payLoad_26, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197794L,1484639197887L  , payLoad_46, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197887L,1484639197925L  , payLoad_50, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197925L,1484639197964L  , payLoad_53, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197965L,1484639197974L  , payLoad_54, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197974L,1484639197984L  , payLoad_55, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197985L,1484639197995L  , payLoad_56, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639197995L,1484639198004L  , payLoad_58, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198005L,1484639198015L  , payLoad_59, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198016L,1484639198025L  , payLoad_60, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198025L,1484639198034L  , payLoad_61, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198034L,1484639198043L  , payLoad_62, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198044L,1484639198052L  , payLoad_63, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198052L,1484639198065L  , payLoad_64, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198065L,1484639198075L  , payLoad_65, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198075L,1484639198083L  , payLoad_66, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198084L,1484639198112L  , payLoad_69, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198113L,1484639198134L  , payLoad_71, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198135L,1484639198156L  , payLoad_74, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198156L,1484639198184L  , payLoad_76, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198184L,1484639198203L  , payLoad_78, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198203L,1484639198217L  , payLoad_80, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198218L,1484639198230L  , payLoad_81, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198230L,1484639198243L  , payLoad_82, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198244L,1484639198274L  , payLoad_85, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198301L,1484639198327L  , payLoad_89, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198328L,1484639198349L  , payLoad_91, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198349L,1484639198375L  , payLoad_93, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198376L,1484639198386L  , payLoad_94, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198386L,1484639198408L  , payLoad_95, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198410L,1484639198427L  , payLoad_96, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198428L,1484639198437L  , payLoad_97, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198438L,1484639198452L  , payLoad_98, WebSocketFrame.PLAIN  ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639198452L,1484639198471L  , payLoad_99, WebSocketFrame.PLAIN  ));
	
		return webSocketData;
	}
	
	// source code getting the webSocket context.
	public WebSocketData getWebSocketData_1484639228062()
	{

		WebSocketData webSocketData = new WebSocketData();
		webSocketData.setConnectionStartMillis(1484639228093L);
		webSocketData.setConnectionStopMillis(1484639258102L);
		webSocketData.setSecProtocol("plain");
		String payLoad_0 = "{\"md_subscribe_alerts_request\":{\"update_data\":\"4c8e4c6f-33b4-4e3e-a740-527c0988ee51\"},\"request_data\":\"55\",\"session_token\":\"d7fc8e80-6080-46c4-a31d-651aa2fadcf9\"}";

		// search and replace frame payload "d7fc8e80-6080-46c4-a31d-651aa2fadcf9" with variable 'sessionToken' on all occurrences of all frames.
		payLoad_0 = Lib.replaceTextPattern(payLoad_0, "d7fc8e80-6080-46c4-a31d-651aa2fadcf9", sessionToken, 0);


		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1484639228096L,1484639228101L  , payLoad_0, WebSocketFrame.PLAIN  ));
	
		return webSocketData;
	}

}	// end of class

