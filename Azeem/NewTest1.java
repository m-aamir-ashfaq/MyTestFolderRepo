
// *********************************************************************************************
//
// Automatically Generated Load Test Program
// -----------------------------------------
//
// Source: NewTest1.java
// Date  : 03 Mar 2017 15:37:35 ECT
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
public class NewTest1 extends HttpLoadTest implements Runnable, ThreadStepInterface, SetThreadStepInterface, SSLSessionCacheStatisticInterface, VaryingLoadInterface, VaryingTestDurationInterface, SuspendResumeInterface, GetRealTimeUserInputFieldsInterface
{
	public static final String prxVersion = "V5.5-C";
	public static final int    prxCharEncoding = 2;                         // 1 = OS Default, 2 = ISO-8859-1, 3 = UTF-8
	public static final String testDescription = "";

	public static String USER_AGENT_1 = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:51.0) Gecko/20100101 Firefox/51.0";

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
	private static final String EXTERNAL_PARAM_FILE = "NewTest1ExtParams.dat";              // input file name for very large parameter values
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

	private String id = null;                            // var declaration from web admin var handler: scope = per loop
	
	/**
	 * constructor: called from load test plug-ins (scope = global).
	 */
	public NewTest1()
	{
		super();
	}


	/**
	 * constructor: called when a user is created (per user).
	 */
	public NewTest1(int maxLoops, int requestTimeout, int threadNumber)
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
		id = null;
		log();
		log("<<< id = " + id);
		
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



		// --- PAGE BREAK: Test [74] ---
		log();
		log();
		log("# Page #2: Done");
		log("# -------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #2: Done", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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
		String requestProt0001 = "https";
		String requestHost0001 = "dev.dev.playsite.devmpp.com";
		int    requestPort0001 = 443;
		String requestFile0001 = "/";
		String requestHeader0001 = "GET " + requestFile0001 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1961
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "var redirectLocation = window.location.origin;");		// Test [1] <- Index 1
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
			// extract var 'id'
			id = htmlContentParser.getHyperlinkTable().getUniqueHttpCgiHyperlink("/Content/Bundles/bootstrap_and_blockgridBundle.min.css?id").getCgiParameter("id");		// recorded value = 1c599c2b-dda5-41f2-884a-9959ff047df9
			log("<<< id = " + id);
		}
		catch (Exception e) { id = null; log(e); }
		if (id == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'id' from html hyperlink";
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






		// --- HTTP REQUEST: Test [2] <- WEB ADMIN Index 2 ---
		String requestProt0002 = "https";
		String requestHost0002 = "dev.dev.playsite.devmpp.com";
		int    requestPort0002 = 443;
		String requestFile0002 = "/Content/font-awesome.css";
		String requestHeader0002 = "GET " + requestFile0002 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0002, requestHost0002, requestPort0002, requestHeader0002, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0002 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 9011
		// content test algorithm: check size +/- 5%, defined content size = 9011
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 9011, 5);		// Test [2] <- Index 2
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
		String requestHost0003 = "dev.dev.playsite.devmpp.com";
		int    requestPort0003 = 443;
		String requestFile0003 = "/Scripts/jquery-2.2.3.min.js";
		String requestHeader0003 = "GET " + requestFile0003 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0003, requestHost0003, requestPort0003, requestHeader0003, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0003 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 38405
		// content test algorithm: check size +/- 5%, defined content size = 38405
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 38405, 5);		// Test [3] <- Index 3
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
		String requestHost0004 = "dev.dev.playsite.devmpp.com";
		int    requestPort0004 = 443;
		String requestFile0004 = "/Scripts/bundles/initialscriptsBundle.min.js";
		String requestHeader0004 = "GET " + requestFile0004 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 913
		// content test algorithm: check size +/- 5%, defined content size = 913
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 913, 5);		// Test [4] <- Index 4
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
		String requestHost0005 = "dev.dev.playsite.devmpp.com";
		int    requestPort0005 = 443;
		String requestFile0005 = "/Content/Bundles/trionaAddonBundle.min.css" +
				"?id=" + id;		// recorded value = 1c599c2b-dda5-41f2-884a-9959ff047df9
		String requestHeader0005 = "GET " + requestFile0005 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2503
		// content test algorithm: check size +/- 5%, defined content size = 2503
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 2503, 5);		// Test [5] <- Index 5
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
		String requestHost0006 = "dev.dev.playsite.devmpp.com";
		int    requestPort0006 = 443;
		String requestFile0006 = "/Content/Triona/Site.css" +
				"?id=" + id;		// recorded value = 1c599c2b-dda5-41f2-884a-9959ff047df9
		String requestHeader0006 = "GET " + requestFile0006 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 8555
		// content test algorithm: check size +/- 5%, defined content size = 8555
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 8555, 5);		// Test [6] <- Index 6
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
		String requestHost0007 = "dev.dev.playsite.devmpp.com";
		int    requestPort0007 = 443;
		String requestFile0007 = "/Content/Bundles/owlCarouselBundle.min.css" +
				"?id=" + id;		// recorded value = 1c599c2b-dda5-41f2-884a-9959ff047df9
		String requestHeader0007 = "GET " + requestFile0007 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1078
		// content test algorithm: check size +/- 5%, defined content size = 1078
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 1078, 5);		// Test [7] <- Index 7
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
		String requestHost0008 = "dev.dev.playsite.devmpp.com";
		int    requestPort0008 = 443;
		String requestFile0008 = "/Content/Bundles/bootstrap_and_blockgridBundle.min.css" +
				"?id=" + id;		// recorded value = 1c599c2b-dda5-41f2-884a-9959ff047df9
		String requestHeader0008 = "GET " + requestFile0008 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 59093
		// content test algorithm: check size +/- 5%, defined content size = 59093
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 59093, 5);		// Test [8] <- Index 8
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
		String requestHost0009 = "dev.dev.playsite.devmpp.com";
		int    requestPort0009 = 443;
		String requestFile0009 = "/Scripts/angular.min.js" +
				"?id=" + id;		// recorded value = 1c599c2b-dda5-41f2-884a-9959ff047df9
		String requestHeader0009 = "GET " + requestFile0009 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 72256
		// content test algorithm: check size +/- 5%, defined content size = 72256
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 72256, 5);		// Test [9] <- Index 9
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
		String requestHost0010 = "dev.dev.playsite.devmpp.com";
		int    requestPort0010 = 443;
		String requestFile0010 = "/Scripts/bundles/All_ExternalBundle.min.js" +
				"?id=" + id;		// recorded value = 1c599c2b-dda5-41f2-884a-9959ff047df9
		String requestHeader0010 = "GET " + requestFile0010 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 134986
		// content test algorithm: check size +/- 5%, defined content size = 134986
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 134986, 5);		// Test [10] <- Index 10
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
		String requestHost0011 = "dev.dev.playsite.devmpp.com";
		int    requestPort0011 = 443;
		String requestFile0011 = "/Scripts/bundles/cryptoBundle.min.js" +
				"?id=" + id;		// recorded value = 1c599c2b-dda5-41f2-884a-9959ff047df9
		String requestHeader0011 = "GET " + requestFile0011 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 8582
		// content test algorithm: check size +/- 5%, defined content size = 8582
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 8582, 5);		// Test [11] <- Index 11
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
		String requestHost0012 = "dev.dev.playsite.devmpp.com";
		int    requestPort0012 = 443;
		String requestFile0012 = "/Scripts/bundles/Triona-ALLBundle.js" +
				"?id=" + id;		// recorded value = 1c599c2b-dda5-41f2-884a-9959ff047df9
		String requestHeader0012 = "GET " + requestFile0012 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 138347
		// content test algorithm: check size +/- 5%, defined content size = 138347
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 138347, 5);		// Test [12] <- Index 12
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
		String requestHost0013 = "fonts.googleapis.com";
		int    requestPort0013 = 443;
		String requestFile0013 = "/css" +
				"?family=Open+Sans:400,600,700,800,300";
		String requestHeader0013 = "GET " + requestFile0013 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: fonts.googleapis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 955
		// content test algorithm: check size +/- 5%, defined content size = 955
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 955, 5);		// Test [13] <- Index 13
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
		String requestHost0014 = "fonts.gstatic.com";
		int    requestPort0014 = 443;
		String requestFile0014 = "/s/opensans/v13/cJZKeOuBrn4kERxqtaUH3ZBw1xU1rKptJj_0jans920.woff2";
		String requestHeader0014 = "GET " + requestFile0014 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: fonts.gstatic.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Origin: https://dev.dev.playsite.devmpp.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0014, requestHost0014, requestPort0014, requestHeader0014, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0014 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF2", header text fragment = [verification disabled], recorded content size = 10352
		// content test algorithm: check size +/- 5%, defined content size = 10352
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF2", null, 10352, 5);		// Test [14] <- Index 14
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






		// --- HTTP REQUEST: Test [15] <- WEB ADMIN Index 15 ---
		String requestProt0015 = "https";
		String requestHost0015 = "dev.dev.playsite.devmpp.com";
		int    requestPort0015 = 443;
		String requestFile0015 = "/scripts/cldr/main/en-GB/ca-gregorian.json";
		String requestHeader0015 = "GET " + requestFile0015 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 2342
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"0-alt-variant\": \"Before Common Era\",");		// Test [15] <- Index 15
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
		String requestHost0016 = "dev.dev.playsite.devmpp.com";
		int    requestPort0016 = 443;
		String requestFile0016 = "/scripts/cldr/main/en-GB/numbers.json";
		String requestHeader0016 = "GET " + requestFile0016 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 1139
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"scientificFormats-numberSystem-latn\": {");		// Test [16] <- Index 16
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
		String requestHost0017 = "dev.dev.playsite.devmpp.com";
		int    requestPort0017 = 443;
		String requestFile0017 = "/scripts/cldr/supplemental/timeData.json";
		String requestHeader0017 = "GET " + requestFile0017 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 1206
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [17] <- Index 17
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
		String requestProt0018 = "https";
		String requestHost0018 = "dev.dev.playsite.devmpp.com";
		int    requestPort0018 = 443;
		String requestFile0018 = "/scripts/cldr/supplemental/weekData.json";
		String requestHeader0018 = "GET " + requestFile0018 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 1300
		// content test algorithm: check size +/- 5%, defined content size = 1300
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 1300, 5);		// Test [18] <- Index 18
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
		String requestHost0019 = "dev.dev.playsite.devmpp.com";
		int    requestPort0019 = 443;
		String requestFile0019 = "/scripts/cldr/supplemental/likelySubtags.json";
		String requestHeader0019 = "GET " + requestFile0019 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 10650
		// content test algorithm: check size +/- 5%, defined content size = 10650
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 10650, 5);		// Test [19] <- Index 19
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
		String requestHost0020 = "dev.dev.playsite.devmpp.com";
		int    requestPort0020 = 443;
		String requestFile0020 = "/scripts/cldr/supplemental/plurals.json";
		String requestHeader0020 = "GET " + requestFile0020 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0020, requestHost0020, requestPort0020, requestHeader0020, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0020 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 8946
		// content test algorithm: check size +/- 5%, defined content size = 8946
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 8946, 5);		// Test [20] <- Index 20
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
		String requestHost0021 = "dev.dev.playsite.devmpp.com";
		int    requestPort0021 = 443;
		String requestFile0021 = "/api/configuration/site/getconfig";
		String requestHeader0021 = "GET " + requestFile0021 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization:\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0021, requestHost0021, requestPort0021, requestHeader0021, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0021 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 1450
		// content test algorithm: check size +/- 5%, defined content size = 1450
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 1450, 5);		// Test [21] <- Index 21
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






		// --- HTTP REQUEST: Test [22] <- WEB ADMIN Index 22 ---
		String requestProt0022 = "https";
		String requestHost0022 = "dev.dev.playsite.devmpp.com";
		int    requestPort0022 = 443;
		String requestFile0022 = "/SPA/views/defaultView.html";
		String requestHeader0022 = "GET " + requestFile0022 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization:\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0022, requestHost0022, requestPort0022, requestHeader0022, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0022 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 362
		// content test algorithm: check size +/- 5%, defined content size = 362
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, 362, 5);		// Test [22] <- Index 22
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
		String requestHost0023 = "dev.dev.playsite.devmpp.com";
		int    requestPort0023 = 443;
		String requestFile0023 = "/api/configuration/site/gethostagent";
		String requestHeader0023 = "GET " + requestFile0023 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0023, requestHost0023, requestPort0023, requestHeader0023, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0023 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 281
		// content test algorithm: check size +/- 5%, defined content size = 281
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 281, 5);		// Test [23] <- Index 23
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






		// --- HTTP REQUEST: Test [24] <- WEB ADMIN Index 24 ---
		String requestProt0024 = "https";
		String requestHost0024 = "dev.dev.playsite.devmpp.com";
		int    requestPort0024 = 443;
		String requestFile0024 = "/api/authorization/account/login";
		String requestContent0024 = 
				"{\"username\":\"anonymous\",\"email\":\"\",\"password\":\"empty\",\"confirmpassword\":\"\"}";
		byte[] requestContentBinary0024 = requestContent0024.getBytes("UTF-8");
		String requestHeader0024 = "POST " + requestFile0024 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json;charset=utf-8\r\n" + 
				"Authorization: QzdaQ3VkeDhzTDg4TllVTXo0bFJVSkZMUUcxR1VaWFNRS0pIeGtHaDdGdz06YW5vbnltb3VzOjYzNjI0MTQ2ODMzMTI2MDAwMA==\r\n" + 
				"Content-Length: " + requestContentBinary0024.length + "\r\n" + 		// Content-Length: 75
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0024, requestHost0024, requestPort0024, requestHeader0024, requestContentBinary0024, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
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
		requestContentBinary0024 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 341
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, null);		// Test [24] <- Index 24
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
		String requestProt0025 = "https";
		String requestHost0025 = "dev.dev.playsite.devmpp.com";
		int    requestPort0025 = 443;
		String requestFile0025 = "/SPA/views/directives/footer.html";
		String requestHeader0025 = "GET " + requestFile0025 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: TWF2aG9lNC9OQ0NJM0RlNkF3ZE9VNzhnSlo4MnJlbUx6SnB4eFZxaUFLWT06YW5vbnltb3VzOjYzNjI0MTQ2ODMzMjI2MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0025, requestHost0025, requestPort0025, requestHeader0025, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0025 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 484
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "div class=\"footerCopyright container\"");		// Test [25] <- Index 25
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
		String requestProt0026 = "https";
		String requestHost0026 = "dev.dev.playsite.devmpp.com";
		int    requestPort0026 = 443;
		String requestFile0026 = "/SPA/views/topNavigationView.html";
		String requestHeader0026 = "GET " + requestFile0026 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: NjBCcnM2bTExY2VGV2duTGFPbFJMNzNZU3R0amk4MjRNTDFNY2dGOWthMD06YW5vbnltb3VzOjYzNjI0MTQ2ODMzMjMzMDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0026, requestHost0026, requestPort0026, requestHeader0026, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0026 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1953
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "figure ng-show=\"topNavigationCtrl.headerLogoImageSrc\"");		// Test [26] <- Index 26
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
		String requestHost0027 = "dev.dev.playsite.devmpp.com";
		int    requestPort0027 = 443;
		String requestFile0027 = "/SPA/views/eventListView.html";
		String requestHeader0027 = "GET " + requestFile0027 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: V29DQlpkNUVBRVlvejgwQXNNQjR2NzJwQURlOW5qK0EyZk5YSFlQa2M2VT06YW5vbnltb3VzOjYzNjI0MTQ2ODMzMjM1MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0027, requestHost0027, requestPort0027, requestHeader0027, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0027 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 4333
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "div id=\"descriptionContainerSmallInnerToggleButtonContainer\"");		// Test [27] <- Index 27
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






		// --- HTTP REQUEST: Test [28] <- WEB ADMIN Index 28 ---
		String requestProt0028 = "https";
		String requestHost0028 = "fonts.gstatic.com";
		int    requestPort0028 = 443;
		String requestFile0028 = "/s/opensans/v13/MTP_ySUJH_bn48VBG8sNShampu5_7CjHW5spxoeN3Vs.woff2";
		String requestHeader0028 = "GET " + requestFile0028 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: fonts.gstatic.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Origin: https://dev.dev.playsite.devmpp.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0028, requestHost0028, requestPort0028, requestHeader0028, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0028 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF2", header text fragment = [verification disabled], recorded content size = 10328
		// content test algorithm: check size +/- 5%, defined content size = 10328
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF2", null, 10328, 5);		// Test [28] <- Index 28
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






		// --- HTTP REQUEST: Test [29] <- WEB ADMIN Index 29 ---
		String requestProt0029 = "https";
		String requestHost0029 = "dev.dev.playsite.devmpp.com";
		int    requestPort0029 = 443;
		String requestFile0029 = "/SPA/views/searchFieldPartial.html";
		String requestHeader0029 = "GET " + requestFile0029 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: TVRjWGxUcml4Y0RCUk10M0VzUTNvR0h1N2ExR0UyMEJJaXlJQjB1L2IzZz06YW5vbnltb3VzOjYzNjI0MTQ2ODMzNTA1MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0029, requestHost0029, requestPort0029, requestHeader0029, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0029 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 387
		// content test algorithm: check size +/- 5%, defined content size = 387
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, 387, 5);		// Test [29] <- Index 29
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






		// --- HTTP REQUEST: Test [30] <- WEB ADMIN Index 30 ---
		String requestProt0030 = "https";
		String requestHost0030 = "dev.dev.playsite.devmpp.com";
		int    requestPort0030 = 443;
		String requestFile0030 = "/SPA/views/mobileMenuPartial.html";
		String requestHeader0030 = "GET " + requestFile0030 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: TVRjWGxUcml4Y0RCUk10M0VzUTNvR0h1N2ExR0UyMEJJaXlJQjB1L2IzZz06YW5vbnltb3VzOjYzNjI0MTQ2ODMzNTA1MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0030, requestHost0030, requestPort0030, requestHeader0030, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0030 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 2037
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "div class=\"input-group mobileSearchInputGroup\"");		// Test [30] <- Index 30
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






		// --- HTTP REQUEST: Test [31] <- WEB ADMIN Index 31 ---
		String requestProt0031 = "https";
		String requestHost0031 = "fonts.gstatic.com";
		int    requestPort0031 = 443;
		String requestFile0031 = "/s/opensans/v13/DXI1ORHCpsQm3Vp6mXoaTRampu5_7CjHW5spxoeN3Vs.woff2";
		String requestHeader0031 = "GET " + requestFile0031 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: fonts.gstatic.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Origin: https://dev.dev.playsite.devmpp.com\r\n" + 
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

		// verify response: status code = 200, content type = "FONT/WOFF2", header text fragment = [verification disabled], recorded content size = 10200
		// content test algorithm: check size +/- 5%, defined content size = 10200
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF2", null, 10200, 5);		// Test [31] <- Index 31
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
		String requestHost0032 = "dev.dev.playsite.devmpp.com";
		int    requestPort0032 = 443;
		String requestFile0032 = "/fonts/fontawesome-webfont.woff2" +
				"?v=4.7.0";
		String requestHeader0032 = "GET " + requestFile0032 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/FONT-WOFF2", header text fragment = [verification disabled], recorded content size = 77160
		// content test algorithm: check size +/- 5%, defined content size = 77160
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/FONT-WOFF2", null, 77160, 5);		// Test [32] <- Index 32
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
		String requestHost0033 = "dev.dev.playsite.devmpp.com";
		int    requestPort0033 = 443;
		String requestFile0033 = "/SPA/views/directives/SocialSharing.html";
		String requestHeader0033 = "GET " + requestFile0033 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: TmI3UHJVYXBvNStndU9JS25UQUxjNGw5UUtUbWVJdUo2Z2xNOG1wNExuST06YW5vbnltb3VzOjYzNjI0MTQ2ODMzNzUzMDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0033, requestHost0033, requestPort0033, requestHeader0033, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0033 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 304
		// content test algorithm: check size +/- 5%, defined content size = 304
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, 304, 5);		// Test [33] <- Index 33
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






		// --- HTTP REQUEST: Test [34] <- WEB ADMIN Index 34 ---
		String requestProt0034 = "https";
		String requestHost0034 = "dev.dev.playsite.devmpp.com";
		int    requestPort0034 = 443;
		String requestFile0034 = "/api/events/channel/getchannels";
		String requestHeader0034 = "GET " + requestFile0034 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: SG9hSVE1dXZtaHhMeW83ZVAxUnVJdGsyYTJrWnM3NzNxZ2J5bG1ZR0syTT06YW5vbnltb3VzOjYzNjI0MTQ2ODMzNzU0MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0034, requestHost0034, requestPort0034, requestHeader0034, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0034 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 8419
		// content test algorithm: check size +/- 5%, defined content size = 8419
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 8419, 5);		// Test [34] <- Index 34
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






		// --- HTTP REQUEST: Test [35] <- WEB ADMIN Index 35 ---
		String requestProt0035 = "https";
		String requestHost0035 = "dev.dev.playsite.devmpp.com";
		int    requestPort0035 = 443;
		String requestFile0035 = "/api/events/event/getplayingevent";
		String requestHeader0035 = "GET " + requestFile0035 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: Rm5abFRhRHdmU3FvMWNBWVBubjRGK1RUYjdEQmRiamJ4UkY5R0xmbHQzRT06YW5vbnltb3VzOjYzNjI0MTQ2ODMzNzU1MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0035, requestHost0035, requestPort0035, requestHeader0035, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0035 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 688
		// content test algorithm: check size +/- 5%, defined content size = 688
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 688, 5);		// Test [35] <- Index 35
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
		String requestProt0036 = "https";
		String requestHost0036 = "dev.dev.playsite.devmpp.com";
		int    requestPort0036 = 443;
		String requestFile0036 = "/api/events/event/getcategorizedevents";
		String requestHeader0036 = "GET " + requestFile0036 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: Rk1XOGFEMTErUm1GYnRuaE1iK0pwdCtrbWIxYk43YW43SGhURmxuWG5XST06YW5vbnltb3VzOjYzNjI0MTQ2ODMzNzU2MDAwMA==\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 12848
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "A bunch of bug fixes & several minor improvements");		// Test [36] <- Index 36
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
		String requestHost0037 = "dev.dev.playsite.devmpp.com";
		int    requestPort0037 = 443;
		String requestFile0037 = "/api/events/event/getaggregatedevents";
		String requestHeader0037 = "GET " + requestFile0037 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: Rm5abFRhRHdmU3FvMWNBWVBubjRGK1RUYjdEQmRiamJ4UkY5R0xmbHQzRT06YW5vbnltb3VzOjYzNjI0MTQ2ODMzNzU1MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0037, requestHost0037, requestPort0037, requestHeader0037, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0037 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 8488
		// content test algorithm: check size +/- 5%, defined content size = 8488
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 8488, 5);		// Test [37] <- Index 37
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






		// --- HTTP REQUEST: Test [38] <- WEB ADMIN Index 38 ---
		String requestProt0038 = "https";
		String requestHost0038 = "dev.dev.playsite.devmpp.com";
		int    requestPort0038 = 443;
		String requestFile0038 = "/fonts/glyphicons-halflings-regular.woff2";
		String requestHeader0038 = "GET " + requestFile0038 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/FONT-WOFF2", header text fragment = [verification disabled], recorded content size = 18028
		// content test algorithm: check size +/- 5%, defined content size = 18028
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/FONT-WOFF2", null, 18028, 5);		// Test [38] <- Index 38
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
		String requestHost0039 = "dev.dev.playsite.devmpp.com";
		int    requestPort0039 = 443;
		String requestFile0039 = "/SPA/views/directives/DefaultShareButton.html";
		String requestHeader0039 = "GET " + requestFile0039 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: ZTdCcmRDaUdMK3FRTjV3WHJ6U0tjVEpCdHVNUC9ETFV4SFlRNVd5U0VTZz06YW5vbnltb3VzOjYzNjI0MTQ2ODM0MDQ4MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0039, requestHost0039, requestPort0039, requestHeader0039, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0039 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 358
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "button class=\"default-share-button pull-left shareBtnFormatting\"");		// Test [39] <- Index 39
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
		String requestHost0040 = "dev.dev.playsite.devmpp.com";
		int    requestPort0040 = 443;
		String requestFile0040 = "/SPA/views/directives/YammerShareButton.html";
		String requestHeader0040 = "GET " + requestFile0040 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: aUIzOGFkcWtDRlpDdk1TVjhHM2IyVkYvTVZ2MUNsaEY2ck10M1RYRldqRT06YW5vbnltb3VzOjYzNjI0MTQ2ODM0MDQ5MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0040, requestHost0040, requestPort0040, requestHeader0040, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0040 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 670
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "yam.platform.yammerShare(options);");		// Test [40] <- Index 40
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
		String requestHost0041 = "dev.dev.playsite.devmpp.com";
		int    requestPort0041 = 443;
		String requestFile0041 = "/api/events/event/CheckCanPlayEvent/e5cd29ca906b4be48fcddfd11b45561a" +
				"?eventTypeString=Channel" +
				"&eventHolderId=6559faa5cbee47149bbb751afd3cbd13" +
				"&withAutoStart=true";
		String requestHeader0041 = "GET " + requestFile0041 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: eWRyVWV0ekR5b1dSQnB3a3BQTkFhQ2J0WndraDZ6aEZSdDIzN1NQZ0NZQT06YW5vbnltb3VzOjYzNjI0MTQ2ODM0MTUwMDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0041, requestHost0041, requestPort0041, requestHeader0041, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0041 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 313
		// content test algorithm: check size +/- 5%, defined content size = 313
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 313, 5);		// Test [41] <- Index 41
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
		String requestHost0042 = "mediasvcsk8gh98mxvd2r.blob.core.windows.net";
		int    requestPort0042 = 443;
		String requestFile0042 = "/asset-9ed4f95e-8534-481c-9306-b5484dac50b5/Mix_Tape-_Shane_Warne,_Volume_1_1.jpg" +
				"?sv=2012-02-12" +
				"&sr=c" +
				"&si=abdcfcd6-5c33-40b1-b368-2783be8cc318" +
				"&sig=859uj99l5fZIMTFO2atvPbTV41jYQERYriGxyCTJpHY%3D" +
				"&st=2016-10-13T11%3A11%3A12Z" +
				"&se=2026-10-11T11%3A11%3A12Z";
		String requestHeader0042 = "GET " + requestFile0042 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: mediasvcsk8gh98mxvd2r.blob.core.windows.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0042, requestHost0042, requestPort0042, requestHeader0042, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0042 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 403, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 404
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {403}, null, null, null);		// Test [42] <- Index 42
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






		// --- HTTP REQUEST: Test [43] <- WEB ADMIN Index 43 ---
		String requestProt0043 = "https";
		String requestHost0043 = "kumo2stage.blob.core.windows.net";
		int    requestPort0043 = 443;
		String requestFile0043 = "/asset-7cd70796-e388-459d-b289-d669e3b718b5/f1fea1185cc04dabcf83e9662204c3e5_000001.jpg" +
				"?sv=2012-02-12" +
				"&sr=c" +
				"&si=14f48bf5-09d3-45be-aeaf-f3f790c89492" +
				"&sig=h5oFcKhBUr%2FHERlr0%2BkLxQ%2BIy0IVP85%2FeyESwD2woEE%3D" +
				"&st=2017-02-06T10%3A04%3A38Z" +
				"&se=2117-01-13T10%3A04%3A38Z";
		String requestHeader0043 = "GET " + requestFile0043 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: kumo2stage.blob.core.windows.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0043, requestHost0043, requestPort0043, requestHeader0043, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0043 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 403, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 404
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {403}, null, null, null);		// Test [43] <- Index 43
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






		// --- HTTP REQUEST: Test [44] <- WEB ADMIN Index 44 ---
		String requestProt0044 = "https";
		String requestHost0044 = "mediaeuwest.blob.core.windows.net";
		int    requestPort0044 = 443;
		String requestFile0044 = "/asset-34c78545-b80f-4f50-a833-d405de27e4c7/ecec5cd3cf1b4be1b8e2d24fb671d853_000001.jpg" +
				"?sv=2012-02-12" +
				"&sr=c" +
				"&si=a824e5c2-5ddd-4dfb-842e-412036c60161" +
				"&sig=D8wpTQWZA0dMUJQoOU1uqxQWmUY7Dd8TLYUeAj%2BFryk%3D" +
				"&st=2017-03-03T13%3A56%3A16Z" +
				"&se=2117-02-07T13%3A56%3A16Z";
		String requestHeader0044 = "GET " + requestFile0044 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: mediaeuwest.blob.core.windows.net\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 10775
		// content test algorithm: check size +/- 5%, defined content size = 10775
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 10775, 5);		// Test [44] <- Index 44
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
		String requestHost0045 = "cdn.sharepointonline.com";
		int    requestPort0045 = 443;
		String requestFile0045 = "/15772/_layouts/15/fonts/Office365Icons.woff";
		String requestHeader0045 = "GET " + requestFile0045 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cdn.sharepointonline.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Origin: https://dev.dev.playsite.devmpp.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/FONT-WOFF", header text fragment = [verification disabled], recorded content size = 47204
		// content test algorithm: check size +/- 5%, defined content size = 47204
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/FONT-WOFF", null, 47204, 5);		// Test [45] <- Index 45
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
		String requestHost0046 = "dev.dev.playsite.devmpp.com";
		int    requestPort0046 = 443;
		String requestFile0046 = "/SPA/views/loginDialog.html";
		String requestHeader0046 = "GET " + requestFile0046 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: WWJwSmVLTmRWSnc3RFhPajU1dlRYL293KzVocmRwVzYxVzJIZlhHZGNIMD06YW5vbnltb3VzOjYzNjI0MTQ2ODM2MDExMDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0046, requestHost0046, requestPort0046, requestHeader0046, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0046 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 838
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "div ng-cloak class=\"alert alert-danger messageFontStyle\" ng-show=\"hasFormError\"");		// Test [46] <- Index 46
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






		// --- HTTP REQUEST: Test [47] <- WEB ADMIN Index 47 ---
		String requestProt0047 = "https";
		String requestHost0047 = "dev.dev.playsite.devmpp.com";
		int    requestPort0047 = 443;
		String requestFile0047 = "/Account/create/new_account";
		String requestHeader0047 = "GET " + requestFile0047 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0047, requestHost0047, requestPort0047, requestHeader0047, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0047 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1961
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "var redirectLocation = window.location.origin;");		// Test [47] <- Index 47
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






		// --- HTTP REQUEST: Test [48] <- WEB ADMIN Index 48 ---
		String requestProt0048 = "https";
		String requestHost0048 = "dev.dev.playsite.devmpp.com";
		int    requestPort0048 = 443;
		String requestFile0048 = "/api/configuration/site/gethostagent";
		String requestHeader0048 = "GET " + requestFile0048 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0048, requestHost0048, requestPort0048, requestHeader0048, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0048 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 281
		// content test algorithm: check size +/- 5%, defined content size = 281
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 281, 5);		// Test [48] <- Index 48
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






		// --- HTTP REQUEST: Test [49] <- WEB ADMIN Index 50 ---
		String requestProt0049 = "https";
		String requestHost0049 = "dev.dev.playsite.devmpp.com";
		int    requestPort0049 = 443;
		String requestFile0049 = "/api/configuration/site/getconfig";
		String requestHeader0049 = "GET " + requestFile0049 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: cmdQMi9RQk9EcHFESHNVbkFJakRUbUV6cThobTdTeERQM3NXcXdraThicz06YW5vbnltb3VzOjYzNjI0MTQ2ODM4NDc3MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0049, requestHost0049, requestPort0049, requestHeader0049, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0049 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 1450
		// content test algorithm: check size +/- 5%, defined content size = 1450
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 1450, 5);		// Test [49] <- Index 49
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






		// --- HTTP REQUEST: Test [50] <- WEB ADMIN Index 51 ---
		String requestProt0050 = "https";
		String requestHost0050 = "dev.dev.playsite.devmpp.com";
		int    requestPort0050 = 443;
		String requestFile0050 = "/api/authorization/account/isauthenticated";
		String requestHeader0050 = "GET " + requestFile0050 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: Q1orSDhMU1JkUVh1WEZSbC90eG9uRU5nd2x3bUozbS85MkdiclNTVDdLST06YW5vbnltb3VzOjYzNjI0MTQ2ODM4NTk5MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0050, requestHost0050, requestPort0050, requestHeader0050, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0050 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 228
		// content test algorithm: check size +/- 5%, defined content size = 228
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 228, 5);		// Test [50] <- Index 50
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






		// --- HTTP REQUEST: Test [51] <- WEB ADMIN Index 52 ---
		String requestProt0051 = "https";
		String requestHost0051 = "dev.dev.playsite.devmpp.com";
		int    requestPort0051 = 443;
		String requestFile0051 = "/SPA/views/accountView.html";
		String requestHeader0051 = "GET " + requestFile0051 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: eG5zUXh1bFZ0SHlqaUNpb0piM0ZHc3UvdnlYK2xnUFNMSUJ6czBvV1Rwdz06YW5vbnltb3VzOjYzNjI0MTQ2ODM4NzQ3MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0051, requestHost0051, requestPort0051, requestHeader0051, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0051 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 263
		// content test algorithm: check size +/- 5%, defined content size = 263
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, 263, 5);		// Test [51] <- Index 51
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






		// --- HTTP REQUEST: Test [52] <- WEB ADMIN Index 53 ---
		String requestProt0052 = "https";
		String requestHost0052 = "dev.dev.playsite.devmpp.com";
		int    requestPort0052 = 443;
		String requestFile0052 = "/api/authorization/account/getaccountoverview";
		String requestHeader0052 = "GET " + requestFile0052 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: TG5UalRNMkFoVi9rS09sT2thVnFQUGpzNWJ1cmg2Z05HVDhmVnlNT1Q3az06YW5vbnltb3VzOjYzNjI0MTQ2ODM4OTY5MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0052, requestHost0052, requestPort0052, requestHeader0052, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0052 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 213
		// content test algorithm: check size +/- 5%, defined content size = 213
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 213, 5);		// Test [52] <- Index 52
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






		// --- HTTP REQUEST: Test [53] <- WEB ADMIN Index 54 ---
		String requestProt0053 = "https";
		String requestHost0053 = "dev.dev.playsite.devmpp.com";
		int    requestPort0053 = 443;
		String requestFile0053 = "/SPA/views/accountCreateNewView.html";
		String requestHeader0053 = "GET " + requestFile0053 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: ZGNDd3J4OXZ6T2Z2RU1PNXorWXFUaGM0aXdXRmVlTkJXYmZlTHQxQnIrcz06YW5vbnltb3VzOjYzNjI0MTQ2ODM4OTc1MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0053, requestHost0053, requestPort0053, requestHeader0053, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0053 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 556
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "div ng-cloak class=\"alert alert-success message messageFontStyle\" ng-show=\"editSuccess\"");		// Test [53] <- Index 53
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






		// --- HTTP REQUEST: Test [54] <- WEB ADMIN Index 55 ---
		String requestProt0054 = "https";
		String requestHost0054 = "dev.dev.playsite.devmpp.com";
		int    requestPort0054 = 443;
		String requestFile0054 = "/Content/Triona/Forms.css";
		String requestHeader0054 = "GET " + requestFile0054 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1042
		// content test algorithm: check size +/- 5%, defined content size = 1042
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 1042, 5);		// Test [54] <- Index 54
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






		// --- HTTP REQUEST: Test [55] <- WEB ADMIN Index 56 ---
		String requestProt0055 = "https";
		String requestHost0055 = "dev.dev.playsite.devmpp.com";
		int    requestPort0055 = 443;
		String requestFile0055 = "/Content/Triona/Input.css";
		String requestHeader0055 = "GET " + requestFile0055 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1431
		// content test algorithm: check size +/- 5%, defined content size = 1431
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 1431, 5);		// Test [55] <- Index 55
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






		// --- HTTP REQUEST: Test [56] <- WEB ADMIN Index 57 ---
		String requestProt0056 = "https";
		String requestHost0056 = "incoming.telemetry.mozilla.org";
		int    requestPort0056 = 443;
		String requestFile0056 = "/submit/telemetry/d772c399-4e20-544e-acda-518b664f16d8/main/Firefox/51.0.1/release/20170125094131" +
				"?v=4";
		String requestContent0056 = 
				requestFileCache.readFile(getSymmetricEncryptContext(), "NewTest1_RequestContent0056.txt").getFileDataAsString("UTF-8");		// note: consider duplicated definition of this file name near end of the load test program - used for ZIP-dialogue in Project Navigator
		byte[] requestContentBinary0056 = requestContent0056.getBytes("UTF-8");
		String requestHeader0056 = "POST " + requestFile0056 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: incoming.telemetry.mozilla.org\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=UTF-8\r\n" + 
				"Date: Fri, 03 Mar 2017 14:07:18 GMT\r\n" + 
				"Content-Encoding: gzip\r\n" + 
				"Content-Length: " + requestContentBinary0056.length + "\r\n" + 		// Content-Length: 16407
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0056, requestHost0056, requestPort0056, requestHeader0056, requestContentBinary0056, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
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
		requestHeader0056 = null;		// support garbage collector to reduce memory
		requestContent0056 = null;		// support garbage collector to reduce memory
		requestContentBinary0056 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 2
		// content test algorithm: check size +/- 5%, defined content size = 2
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, 2, 5);		// Test [56] <- Index 56
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






		// --- HTTP REQUEST: Test [57] <- WEB ADMIN Index 58 ---
		String requestProt0057 = "https";
		String requestHost0057 = "dev.dev.playsite.devmpp.com";
		int    requestPort0057 = 443;
		String requestFile0057 = "/api/authorization/account/register";
		String requestContent0057 = 
				"{\"email\":\"m.aamir.ashfaq@gmail.com\",\"password\":\"pakistn1106\",\"firstName\":\"Amir\",\"lastName\":\"Ashfaq\"}";
		byte[] requestContentBinary0057 = requestContent0057.getBytes("UTF-8");
		String requestHeader0057 = "POST " + requestFile0057 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json;charset=utf-8\r\n" + 
				"Authorization: cE5HT2JNeG1lM2tNc2FVdEtOdmRkRFNDNGpkSVZ0OWZqaFlsbWN0dG1uTT06YW5vbnltb3VzOjYzNjI0MTQ2ODY5MDkwMDAwMA==\r\n" + 
				"Content-Length: " + requestContentBinary0057.length + "\r\n" + 		// Content-Length: 100
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0057, requestHost0057, requestPort0057, requestHeader0057, requestContentBinary0057, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
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
		requestHeader0057 = null;		// support garbage collector to reduce memory
		requestContent0057 = null;		// support garbage collector to reduce memory
		requestContentBinary0057 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 374
		// content test algorithm: check size +/- 5%, defined content size = 374
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 374, 5);		// Test [57] <- Index 57
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






		// --- HTTP REQUEST: Test [58] <- WEB ADMIN Index 59 ---
		String requestProt0058 = "https";
		String requestHost0058 = "dev.dev.playsite.devmpp.com";
		int    requestPort0058 = 443;
		String requestFile0058 = "/api/configuration/site/gethostagent";
		String requestHeader0058 = "GET " + requestFile0058 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0058, requestHost0058, requestPort0058, requestHeader0058, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0058 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 281
		// content test algorithm: check size +/- 5%, defined content size = 281
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 281, 5);		// Test [58] <- Index 58
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






		// --- HTTP REQUEST: Test [59] <- WEB ADMIN Index 60 ---
		String requestProt0059 = "https";
		String requestHost0059 = "dev.dev.playsite.devmpp.com";
		int    requestPort0059 = 443;
		String requestFile0059 = "/api/authorization/account/login";
		String requestContent0059 = 
				"{\"username\":\"m.aamir.ashfaq@gmail.com\",\"email\":\"\",\"password\":\"pakistn1106\",\"confirmpassword\":\"\"}";
		byte[] requestContentBinary0059 = requestContent0059.getBytes("UTF-8");
		String requestHeader0059 = "POST " + requestFile0059 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json;charset=utf-8\r\n" + 
				"Authorization: M1RpTUN0RFV1ZWJQY29adVppTTk2Qjg5UktQZXVHZ2hzaDdENnh3MHl2UT06bS5hYW1pci5hc2hmYXFAZ21haWwuY29tOjYzNjI0MTQ2ODgwMDgxMDAwMA==\r\n" + 
				"Content-Length: " + requestContentBinary0059.length + "\r\n" + 		// Content-Length: 96
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0059, requestHost0059, requestPort0059, requestHeader0059, requestContentBinary0059, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
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
		requestContentBinary0059 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 362
		// content test algorithm: check size +/- 5%, defined content size = 362
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 362, 5);		// Test [59] <- Index 59
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






		// --- HTTP REQUEST: Test [60] <- WEB ADMIN Index 61 ---
		String requestProt0060 = "https";
		String requestHost0060 = "fonts.gstatic.com";
		int    requestPort0060 = 443;
		String requestFile0060 = "/s/opensans/v13/k3k702ZOKiLJc3WVjuplzBampu5_7CjHW5spxoeN3Vs.woff2";
		String requestHeader0060 = "GET " + requestFile0060 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: fonts.gstatic.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Origin: https://dev.dev.playsite.devmpp.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0060, requestHost0060, requestPort0060, requestHeader0060, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0060 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "FONT/WOFF2", header text fragment = [verification disabled], recorded content size = 10284
		// content test algorithm: check size +/- 5%, defined content size = 10284
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "FONT/WOFF2", null, 10284, 5);		// Test [60] <- Index 60
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



		// --- HTTP REQUEST: Test [61] <- WEB ADMIN Index 62 ---
		String requestProt0061 = "https";
		String requestHost0061 = "dev.dev.playsite.devmpp.com";
		int    requestPort0061 = 443;
		String requestFile0061 = "/api/authorization/account/getaccountoverview";
		String requestHeader0061 = "GET " + requestFile0061 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: Y2NXVG02amk5ZXN3TDJxY2ZVd0hsV0RlNXNGRkQzUFdyRFZKY000WnhjVT06bS5hYW1pci5hc2hmYXFAZ21haWwuY29tOjYzNjI0MTQ2ODgwMjU4MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0061, requestHost0061, requestPort0061, requestHeader0061, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0061 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 6385
		// content test algorithm: check size +/- 5%, defined content size = 6385
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 6385, 5);		// Test [61] <- Index 61
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






		// --- HTTP REQUEST: Test [62] <- WEB ADMIN Index 63 ---
		String requestProt0062 = "https";
		String requestHost0062 = "dev.dev.playsite.devmpp.com";
		int    requestPort0062 = 443;
		String requestFile0062 = "/";
		String requestHeader0062 = "GET " + requestFile0062 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0062, requestHost0062, requestPort0062, requestHeader0062, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0062 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1961
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "var redirectLocation = window.location.origin;");		// Test [62] <- Index 62
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






		// --- HTTP REQUEST: Test [63] <- WEB ADMIN Index 64 ---
		String requestProt0063 = "https";
		String requestHost0063 = "dev.dev.playsite.devmpp.com";
		int    requestPort0063 = 443;
		String requestFile0063 = "/api/configuration/site/gethostagent";
		String requestHeader0063 = "GET " + requestFile0063 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 281
		// content test algorithm: check size +/- 5%, defined content size = 281
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 281, 5);		// Test [63] <- Index 63
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






		// --- HTTP REQUEST: Test [64] <- WEB ADMIN Index 65 ---
		String requestProt0064 = "https";
		String requestHost0064 = "dev.dev.playsite.devmpp.com";
		int    requestPort0064 = 443;
		String requestFile0064 = "/api/configuration/site/getconfig";
		String requestHeader0064 = "GET " + requestFile0064 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: WkNGZUIwZlJtS3FlQnQrdENwdC9zR2JVUkY1MmJWaWwwb290M0pYcFdHST06bS5hYW1pci5hc2hmYXFAZ21haWwuY29tOjYzNjI0MTQ2ODgyNDY3MDAwMA==\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 1450
		// content test algorithm: check size +/- 5%, defined content size = 1450
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 1450, 5);		// Test [64] <- Index 64
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






		// --- HTTP REQUEST: Test [65] <- WEB ADMIN Index 66 ---
		String requestProt0065 = "https";
		String requestHost0065 = "dev.dev.playsite.devmpp.com";
		int    requestPort0065 = 443;
		String requestFile0065 = "/api/authorization/account/isauthenticated";
		String requestHeader0065 = "GET " + requestFile0065 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: NmhCL0FUWUNHUCtOUVNuc3ZiQ1RYTmkwaFNqbmFPQU1RU1M3ZFV2Ly9TST06bS5hYW1pci5hc2hmYXFAZ21haWwuY29tOjYzNjI0MTQ2ODgyNTc5MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0065, requestHost0065, requestPort0065, requestHeader0065, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0065 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 228
		// content test algorithm: check size +/- 5%, defined content size = 228
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 228, 5);		// Test [65] <- Index 65
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






		// --- HTTP REQUEST: Test [66] <- WEB ADMIN Index 67 ---
		String requestProt0066 = "https";
		String requestHost0066 = "dev.dev.playsite.devmpp.com";
		int    requestPort0066 = 443;
		String requestFile0066 = "/api/authorization/account/getaccountoverview";
		String requestHeader0066 = "GET " + requestFile0066 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: Rk5jZ3JKWTAxZmVaS3ZKYXVLcnR2Q2Vlemt1dnVXV0tFL2FDb2VXYTJ3VT06bS5hYW1pci5hc2hmYXFAZ21haWwuY29tOjYzNjI0MTQ2ODgyNjkzMDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0066, requestHost0066, requestPort0066, requestHeader0066, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0066 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 6385
		// content test algorithm: check size +/- 5%, defined content size = 6385
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 6385, 5);		// Test [66] <- Index 66
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






		// --- HTTP REQUEST: Test [67] <- WEB ADMIN Index 68 ---
		String requestProt0067 = "https";
		String requestHost0067 = "dev.dev.playsite.devmpp.com";
		int    requestPort0067 = 443;
		String requestFile0067 = "/api/events/channel/getchannels";
		String requestHeader0067 = "GET " + requestFile0067 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: cko1TGV5ZVVnN0hnaU1Hcjl5SEtPd2s4SDQveEJ1R29QV0NTMjRHUElzbz06bS5hYW1pci5hc2hmYXFAZ21haWwuY29tOjYzNjI0MTQ2ODgzMzE3MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0067, requestHost0067, requestPort0067, requestHeader0067, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0067 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 8419
		// content test algorithm: check size +/- 5%, defined content size = 8419
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 8419, 5);		// Test [67] <- Index 67
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






		// --- HTTP REQUEST: Test [68] <- WEB ADMIN Index 69 ---
		String requestProt0068 = "https";
		String requestHost0068 = "dev.dev.playsite.devmpp.com";
		int    requestPort0068 = 443;
		String requestFile0068 = "/api/events/event/getplayingevent";
		String requestHeader0068 = "GET " + requestFile0068 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: cko1TGV5ZVVnN0hnaU1Hcjl5SEtPd2s4SDQveEJ1R29QV0NTMjRHUElzbz06bS5hYW1pci5hc2hmYXFAZ21haWwuY29tOjYzNjI0MTQ2ODgzMzE3MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0068, requestHost0068, requestPort0068, requestHeader0068, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0068 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 688
		// content test algorithm: check size +/- 5%, defined content size = 688
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 688, 5);		// Test [68] <- Index 68
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






		// --- HTTP REQUEST: Test [69] <- WEB ADMIN Index 70 ---
		String requestProt0069 = "https";
		String requestHost0069 = "dev.dev.playsite.devmpp.com";
		int    requestPort0069 = 443;
		String requestFile0069 = "/api/events/event/getaggregatedevents";
		String requestHeader0069 = "GET " + requestFile0069 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: bmZGK24zRlpVUktQRTNMMVlFNS9KS1NET3VCV01lUG1wTlRVOEV4YklRZz06bS5hYW1pci5hc2hmYXFAZ21haWwuY29tOjYzNjI0MTQ2ODgzMzE4MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0069, requestHost0069, requestPort0069, requestHeader0069, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0069 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 8488
		// content test algorithm: check size +/- 5%, defined content size = 8488
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 8488, 5);		// Test [69] <- Index 69
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






		// --- HTTP REQUEST: Test [70] <- WEB ADMIN Index 71 ---
		String requestProt0070 = "https";
		String requestHost0070 = "dev.dev.playsite.devmpp.com";
		int    requestPort0070 = 443;
		String requestFile0070 = "/api/events/event/getcategorizedevents";
		String requestHeader0070 = "GET " + requestFile0070 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: bmZGK24zRlpVUktQRTNMMVlFNS9KS1NET3VCV01lUG1wTlRVOEV4YklRZz06bS5hYW1pci5hc2hmYXFAZ21haWwuY29tOjYzNjI0MTQ2ODgzMzE4MDAwMA==\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0070, requestHost0070, requestPort0070, requestHeader0070, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0070 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 12848
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "A bunch of bug fixes & several minor improvements");		// Test [70] <- Index 70
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






		// --- HTTP REQUEST: Test [71] <- WEB ADMIN Index 72 ---
		String requestProt0071 = "https";
		String requestHost0071 = "mediasvcsk8gh98mxvd2r.blob.core.windows.net";
		int    requestPort0071 = 443;
		String requestFile0071 = "/asset-9ed4f95e-8534-481c-9306-b5484dac50b5/Mix_Tape-_Shane_Warne,_Volume_1_1.jpg" +
				"?sv=2012-02-12" +
				"&sr=c" +
				"&si=abdcfcd6-5c33-40b1-b368-2783be8cc318" +
				"&sig=859uj99l5fZIMTFO2atvPbTV41jYQERYriGxyCTJpHY%3D" +
				"&st=2016-10-13T11%3A11%3A12Z" +
				"&se=2026-10-11T11%3A11%3A12Z";
		String requestHeader0071 = "GET " + requestFile0071 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: mediasvcsk8gh98mxvd2r.blob.core.windows.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0071, requestHost0071, requestPort0071, requestHeader0071, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0071 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 403, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 404
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {403}, null, null, null);		// Test [71] <- Index 71
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






		// --- HTTP REQUEST: Test [72] <- WEB ADMIN Index 73 ---
		String requestProt0072 = "https";
		String requestHost0072 = "kumo2stage.blob.core.windows.net";
		int    requestPort0072 = 443;
		String requestFile0072 = "/asset-7cd70796-e388-459d-b289-d669e3b718b5/f1fea1185cc04dabcf83e9662204c3e5_000001.jpg" +
				"?sv=2012-02-12" +
				"&sr=c" +
				"&si=14f48bf5-09d3-45be-aeaf-f3f790c89492" +
				"&sig=h5oFcKhBUr%2FHERlr0%2BkLxQ%2BIy0IVP85%2FeyESwD2woEE%3D" +
				"&st=2017-02-06T10%3A04%3A38Z" +
				"&se=2117-01-13T10%3A04%3A38Z";
		String requestHeader0072 = "GET " + requestFile0072 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: kumo2stage.blob.core.windows.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0072, requestHost0072, requestPort0072, requestHeader0072, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0072 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 403, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 404
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {403}, null, null, null);		// Test [72] <- Index 72
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






		// --- HTTP REQUEST: Test [73] <- WEB ADMIN Index 75 ---
		String requestProt0073 = "https";
		String requestHost0073 = "dev.dev.playsite.devmpp.com";
		int    requestPort0073 = 443;
		String requestFile0073 = "/api/events/event/CheckCanPlayEvent/e5cd29ca906b4be48fcddfd11b45561a" +
				"?eventTypeString=Channel" +
				"&eventHolderId=6559faa5cbee47149bbb751afd3cbd13" +
				"&withAutoStart=true";
		String requestHeader0073 = "GET " + requestFile0073 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: dev.dev.playsite.devmpp.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/plain, */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Authorization: RVl1MkpoSjBtZHFlUG1MZWdJdVRTR1lFMGFFc1BwSHJGK2ZRb2N0ODQzZz06bS5hYW1pci5hc2hmYXFAZ21haWwuY29tOjYzNjI0MTQ2ODg0MzE4MDAwMA==\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 313
		// content test algorithm: check size +/- 5%, defined content size = 313
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 313, 5);		// Test [73] <- Index 73
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

		// all http requests of page #2 successful done
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
		
		String genericFileName = PerformanceData.proposeFileName("NewTest1", concurrentUsers);
		
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
		final int MAX_THREAD_STEPS = 73;  // number of URL requests in execute() - modify this value if you add or delete some requests
		performanceData = new PerformanceData(PAGE_BREAKS, MAX_THREAD_STEPS, concurrentUsers, -1, plannedTestDuration, maxPlannedLoops, httpProtocolVersion, plannedStartupDelay, plannedRequestTimeout, samplingInterval, percentilePageSampling, percentileUrlSampling, percentileUrlSamplingAddOption);
		performanceData.setInfoText("NewTest1");
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
			requestFileCache.readFile(getSymmetricEncryptContext(), REQUEST_FILE_CACHE_FILE_1);		// NewTest1_RequestContent0056.txt
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
		LoadtestPluginContext globalPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, new NewTest1());
		
		
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
				
				NewTest1 simulatedUser = new NewTest1(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
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
				
				NewTest1 simulatedUser = new NewTest1(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
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
	public static final String REQUEST_FILE_CACHE_FILE_1 = "NewTest1_RequestContent0056.txt";		// must be zipped together with the compiled class of this load test program
	

}	// end of class

