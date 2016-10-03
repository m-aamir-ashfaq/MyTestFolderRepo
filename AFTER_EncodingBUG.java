
// *********************************************************************************************
//
// Automatically Generated Load Test Program
// -----------------------------------------
//
// Source: AFTER_EncodingBUG.java
// Date  : 16 Aug 2016 09:23:10 ECT
// Author: Apica ZebraTester V5.4-O / automatically generated
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
import dfischer.utils.BoundaryBasedExtractor;
import dfischer.utils.BoundaryBasedExtractorItem;
import dfischer.utils.RegExpBasedExtractor;
import dfischer.utils.RegExpBasedExtractorItem;
import dfischer.proxysniffer.WebSocketData;
import dfischer.utils.HttpTestWebsocketContext;
import dfischer.websocket.*;


/**
 * Automatically generated load test program.
 */
public class AFTER_EncodingBUG extends HttpLoadTest implements Runnable, ThreadStepInterface, SetThreadStepInterface, SSLSessionCacheStatisticInterface, VaryingLoadInterface, VaryingTestDurationInterface, SuspendResumeInterface, GetRealTimeUserInputFieldsInterface
{
	public static final String prxVersion = "V5.4-O";
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
	private static final String EXTERNAL_PARAM_FILE = "AFTER_EncodingBUGExtParams.dat";     // input file name for very large parameter values
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
	
	private volatile UserTransactionRuntimeHandler transactionHandler = new UserTransactionRuntimeHandler();		// re-used, support to manage user-defined transactions


	/**
	 * constructor: called from load test plug-ins (scope = global).
	 */
	public AFTER_EncodingBUG()
	{
		super();
	}


	/**
	 * constructor: called when a user is created (per user).
	 */
	public AFTER_EncodingBUG(int maxLoops, int requestTimeout, int threadNumber)
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



		// --- PAGE BREAK: Test [11] ---
		log();
		log();
		log("# Page #2: done");
		log("# -------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #2: done", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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



		// --- PAGE BREAK: Test [13] ---
		log();
		log();
		log("# Page #3: bye");
		log("# ------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #3: bye", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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
		// # Page #1: Start Page
		// # -------------------



		// --- HTTP REQUEST: Test [1] <- WEB ADMIN Index 9 ---
		String requestProt0001 = "https";
		String requestHost0001 = "demo2.kaazing.com";
		int    requestPort0001 = 443;
		String requestFile0001 = "/jms" +
				"?.kl=Y";
		String requestHeader0001 = "GET " + requestFile0001 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: demo2.kaazing.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Sec-WebSocket-Version: 13\r\n" + 
				"Origin: http://demo2.kaazing.com\r\n" + 
				"Sec-WebSocket-Protocol: x-kaazing-handshake, x-kaazing-bump\r\n" + 
				"Sec-WebSocket-Extensions: permessage-deflate\r\n" + 
				"Sec-WebSocket-Key: kJykHAKzirgyXsjYFk0sqw==\r\n" + 
				"Connection: Keep-Alive, Upgrade\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Upgrade: websocket\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0001, requestHost0001, requestPort0001, requestHeader0001, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);

		webSocketData = getWebSocketData_1471283304940();

		testURL.setWebSocketContext(new HttpTestWebsocketContext(webSocketData));

		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0001 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 101, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: check size +/- 5%, defined content size = 0
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {101}, null, null, 0, 5);		// Test [1] <- Index 1
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





		// --- HTTP REQUEST: Test [2] <- WEB ADMIN Index 11 ---
		log();
		log("# title: websocket.org Echo Test - Powered by Kaazing");
		String requestProt0002 = "http";
		String requestHost0002 = "www.websocket.org";
		int    requestPort0002 = 80;
		String requestFile0002 = "/echo.html";
		String requestHeader0002 = "GET " + requestFile0002 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.websocket.org\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 15477
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "The following link lists the browsers that support WebSocket:");		// Test [2] <- Index 2
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





		// --- HTTP REQUEST: Test [3] <- WEB ADMIN Index 12 ---
		String requestProt0003 = "https";
		String requestHost0003 = "demo2.kaazing.com";
		int    requestPort0003 = 443;
		String requestFile0003 = "/jms" +
				"?.kl=Y";
		String requestHeader0003 = "GET " + requestFile0003 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: demo2.kaazing.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Sec-WebSocket-Version: 13\r\n" + 
				"Origin: http://demo2.kaazing.com\r\n" + 
				"Sec-WebSocket-Protocol: x-kaazing-handshake, x-kaazing-bump\r\n" + 
				"Sec-WebSocket-Extensions: permessage-deflate\r\n" + 
				"Sec-WebSocket-Key: vPpPZJj8dTMJQfkqYS3Udg==\r\n" + 
				"Connection: Keep-Alive, Upgrade\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Upgrade: websocket\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0003, requestHost0003, requestPort0003, requestHeader0003, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);

		webSocketData = getWebSocketData_1471283315738();

		testURL.setWebSocketContext(new HttpTestWebsocketContext(webSocketData));

		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0003 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 101, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: check size +/- 5%, defined content size = 0
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {101}, null, null, 0, 5);		// Test [3] <- Index 3
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





		// --- HTTP REQUEST: Test [4] <- WEB ADMIN Index 42 ---
		String requestProt0004 = "http";
		String requestHost0004 = "www.websocket.org";
		int    requestPort0004 = 80;
		String requestFile0004 = "/img/check.png";
		String requestHeader0004 = "GET " + requestFile0004 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.websocket.org\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 635
		// content test algorithm: check size +/- 5%, defined content size = 635
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 635, 5);		// Test [4] <- Index 4
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [5] <- WEB ADMIN Index 43 ---
		String requestProt0005 = "http";
		String requestHost0005 = "www.websocket.org";
		int    requestPort0005 = 80;
		String requestFile0005 = "/img/websocketlogo-medium.png";
		String requestHeader0005 = "GET " + requestFile0005 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.websocket.org\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 6580
		// content test algorithm: check size +/- 5%, defined content size = 6580
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 6580, 5);		// Test [5] <- Index 5
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [6] <- WEB ADMIN Index 44 ---
		String requestProt0006 = "http";
		String requestHost0006 = "www.websocket.org";
		int    requestPort0006 = 80;
		String requestFile0006 = "/img/cross.png";
		String requestHeader0006 = "GET " + requestFile0006 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.websocket.org\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 670
		// content test algorithm: check size +/- 5%, defined content size = 670
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 670, 5);		// Test [6] <- Index 6
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [7] <- WEB ADMIN Index 45 ---
		String requestProt0007 = "http";
		String requestHost0007 = "www.websocket.org";
		int    requestPort0007 = 80;
		String requestFile0007 = "/img/websocketlogo-medium-white.png";
		String requestHeader0007 = "GET " + requestFile0007 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.websocket.org\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 18496
		// content test algorithm: check size +/- 5%, defined content size = 18496
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 18496, 5);		// Test [7] <- Index 7
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [8] <- WEB ADMIN Index 46 ---
		String requestProt0008 = "http";
		String requestHost0008 = "www.websocket.org";
		int    requestPort0008 = 80;
		String requestFile0008 = "/img/clear.png";
		String requestHeader0008 = "GET " + requestFile0008 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.websocket.org\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 82
		// content test algorithm: check size +/- 5%, defined content size = 82
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 82, 5);		// Test [8] <- Index 8
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [9] <- WEB ADMIN Index 47 ---
		String requestProt0009 = "http";
		String requestHost0009 = "www.websocket.org";
		int    requestPort0009 = 80;
		String requestFile0009 = "/img/favicon.ico";
		String requestHeader0009 = "GET " + requestFile0009 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.websocket.org\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0009, requestHost0009, requestPort0009, requestHeader0009, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0009 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 3638
		// content test algorithm: check size +/- 5%, defined content size = 3638
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, null, null, 3638, 5);		// Test [9] <- Index 9
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





		// --- HTTP REQUEST: Test [10] <- WEB ADMIN Index 64 ---
		String requestProt0010 = "http";
		String requestHost0010 = "echo.websocket.org";
		int    requestPort0010 = 80;
		String requestFile0010 = "/" +
				"?encoding=text";
		String requestHeader0010 = "GET " + requestFile0010 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: echo.websocket.org\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Sec-WebSocket-Version: 13\r\n" + 
				"Origin: http://www.websocket.org\r\n" + 
				"Sec-WebSocket-Extensions: permessage-deflate\r\n" + 
				"Sec-WebSocket-Key: 6IzTEk1KHFW5GP/iEt4RCg==\r\n" + 
				"Connection: Keep-Alive, Upgrade\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Upgrade: websocket\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0010, requestHost0010, requestPort0010, requestHeader0010, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);

		webSocketData = getWebSocketData_1471283321344();

		testURL.setWebSocketContext(new HttpTestWebsocketContext(webSocketData));

		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0010 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 101, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: check size +/- 5%, defined content size = 0
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {101}, null, null, 0, 5);		// Test [10] <- Index 10
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
		// # Page #2: done
		// # -------------



		// --- HTTP REQUEST: Test [12] <- WEB ADMIN Index 71 ---
		log();
		log("# title: Home | Zauq Group");
		String requestProt0012 = "http";
		String requestHost0012 = "www.zauq.com";
		int    requestPort0012 = 80;
		String requestFile0012 = "/";
		String requestHeader0012 = "GET " + requestFile0012 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.zauq.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0012, requestHost0012, requestPort0012, requestHeader0012, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0012 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 5079
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "div class=\"collapse navbar-collapse navbar-right\"");		// Test [12] <- Index 12
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
		
		String genericFileName = PerformanceData.proposeFileName("AFTER_EncodingBUG", concurrentUsers);
		
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
		final int MAX_THREAD_STEPS = 11;  // number of URL requests in execute() - modify this value if you add or delete some requests
		performanceData = new PerformanceData(PAGE_BREAKS, MAX_THREAD_STEPS, concurrentUsers, -1, plannedTestDuration, maxPlannedLoops, httpProtocolVersion, plannedStartupDelay, plannedRequestTimeout, samplingInterval, percentilePageSampling, percentileUrlSampling, percentileUrlSamplingAddOption);
		performanceData.setInfoText("AFTER_EncodingBUG");
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
				
				AFTER_EncodingBUG simulatedUser = new AFTER_EncodingBUG(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
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
				
				AFTER_EncodingBUG simulatedUser = new AFTER_EncodingBUG(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
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
	public WebSocketData getWebSocketData_1471283304940()
	{

		WebSocketData webSocketData = new WebSocketData();
		webSocketData.setConnectionStartMillis(1471283305194L);
		webSocketData.setConnectionStopMillis(1471283315475L);
		String payLoad_0 = "\u00ffN";
		String payLoad_1 = "GET /jms HTTP/1.1\r\nWebSocket-Protocol: \r\nSec-WebSocket-Protocol: x-kaazing-bump\r\nSec-WebSocket-Extensions: x-kaazing-idle-timeout,x-kaazing-ping-pong\r\n\r\n";
		String payLoad_2 = "HTTP/1.1 101 Web Socket Protocol Handshake\r\nAccess-Control-Allow-Credentials: true\r\nAccess-Control-Allow-Headers: content-type\r\nAccess-Control-Allow-Headers: authorization\r\nAccess-Control-Allow-Headers: x-websocket-extensions\r\nAccess-Control-Allow-Headers: x-websocket-version\r\nAccess-Control-Allow-Headers: x-websocket-protocol\r\nAccess-Control-Allow-Origin: http://demo2.kaazing.com\r\nConnection: Upgrade\r\nDate: Mon, 15 Aug 2016 17:48:25 GMT\r\nSec-WebSocket-Accept: LNOFgQXhk3s/ZaHf3g0iPhdCX3s=\r\nSec-WebSocket-Extensions: x-kaazing-idle-timeout; timeout=16000\r\nSec-WebSocket-Extensions: x-kaazing-ping-pong; 01010102\r\nSec-WebSocket-Protocol: x-kaazing-bump\r\nServer: Kaazing Gateway\r\nUpgrade: websocket\r\n\r\n";
		String payLoad_3 = "";
		String payLoad_4 = "\u00ffN";
		String payLoad_5 = "\u000b\u0007\u0001`\u0000\u0000\u0001\u0000\u0000";
		String payLoad_6 = "\f\r\u0001\u0000\u0005\u0000\u0000\u0001\u0000\u0002\u0000\u0003\u0000\u0005\u0000";
		String payLoad_7 = ",%\u00c8\u0003\u0011/queue/q636547011\u0010SUB:q/q636547011";
		String payLoad_8 = ",-\u00c8\u0001\u0015/topic/portfolioStock\u0014SUB:t/portfolioStock";
		String payLoad_9 = "*Ql\u0005\u0005cmd-0\u0017/queue/portfolioCommand\u0005SND:1\u0011/queue/q636547011\u0001\u00b0\u0007command\rget_portfolio\u0000";
		String payLoad_10 = "#\u0013\u00c0\u0010SUB:q/q636547011\u0002";
		String payLoad_11 = "#\u0018\u00c0\u0014SUB:t/portfolioStock\u00c9\u0089";
		String payLoad_12 = " \u00c7\u0094\u0002\u0011/queue/q636547011\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009c\u00a8\u0004\u0005cmd-04ID:demo2.kaazing.com-35242-1467850762420-1:1:1:389:1\u0003\u00bb\u00b0\u0006result\u00c5\u008d3m Co:MMM:150.66:100|AT&T Inc.:T:14.07:0|Boeing Co.:BA:14.48:0|Citigroup, Inc.:C:63.73:0|Hewlett-Packard Co.:HPQ:7.73:0|Intel Corporation:INTC:2.83:0|International Business Machines:IBM:103.20:0|McDonald's Corporation:MCD:31.13:0|Microsoft Corporation:MSFT:25.11:0|Verizon Communications:VZ:115.26:0|Wal-Mart Stores, Inc.:WMT:39.00:0\u0007command\rget_portfolio\u0006status\u0002ok\u0001-";
		String payLoad_13 = "#\u0007\u0080\u0005SND:1";
		String payLoad_14 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009c\u00a8\u0004\u000fstock-335124822:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124822\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:24.86:0";
		String payLoad_15 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009c\u00b2\u0004\u000fstock-335124823:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124823\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.79:0";
		String payLoad_16 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009c\u00bc\u0004\u000fstock-335124824:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124824\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.04:0";
		String payLoad_17 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009c\u00c7\u0004\u000fstock-335124825:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124825\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.49:0";
		String payLoad_18 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009c\u00d1\u0004\u000fstock-335124826:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124826\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.24:0";
		String payLoad_19 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009c\u00db\u0004\u000fstock-335124827:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124827\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:104.23:0";
		String payLoad_20 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009c\u00e5\u0004\u000fstock-335124828:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124828\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.15:0";
		String payLoad_21 = "\u0002}\u00e04ID:demo2.kaazing.com-35242-1467850762420-1:1:1:389:1EACK:q/q636547011;ID:demo2.kaazing.com-35242-1467850762420-1:1:1:389:1\u0002";
		String payLoad_22 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009c\u00ef\u0004\u000fstock-335124829:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124829\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:104.79:0";
		String payLoad_23 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009c\u00f9\u0004\u000fstock-335124830:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124830\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.16:0";
		String payLoad_24 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u0004\u0004\u000fstock-335124831:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124831\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.78:0";
		String payLoad_25 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u000e\u0004\u000fstock-335124832:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124832\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.84:0";
		String payLoad_26 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u0018\u0004\u000fstock-335124833:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124833\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:115.58:0";
		String payLoad_27 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\"\u0004\u000fstock-335124834:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124834\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:150.07:100";
		String payLoad_28 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d,\u0004\u000fstock-335124835:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124835\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.10:0";
		String payLoad_29 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d6\u0004\u000fstock-335124836:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124836\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.98:0";
		String payLoad_30 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009dA\u0004\u000fstock-335124837:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124837\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.74:0";
		String payLoad_31 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009dK\u0004\u000fstock-335124838:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124838\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.82:0";
		String payLoad_32 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009dU\u0004\u000fstock-335124839:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124839\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:115.34:0";
		String payLoad_33 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d_\u0004\u000fstock-335124840:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124840\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.45:0";
		String payLoad_34 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009di\u0004\u000fstock-335124841:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124841\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.83:0";
		String payLoad_35 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009ds\u0004\u000fstock-335124842:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124842\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:116.33:0";
		String payLoad_36 = "#G\u0080EACK:q/q636547011;ID:demo2.kaazing.com-35242-1467850762420-1:1:1:389:1";
		String payLoad_37 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d~\u0004\u000fstock-335124843:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124843\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.08:0";
		String payLoad_38 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u0088\u0004\u000fstock-335124844:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124844\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.39:0";
		String payLoad_39 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u0092\u0004\u000fstock-335124845:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124845\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.06:0";
		String payLoad_40 = "*Ol\u0005\u0005cmd-1\u0017/queue/portfolioCommand\u0005SND:2\u0011/queue/q636547011\u0001\u00b0\u0007command\u000bget_balance\u0000";
		String payLoad_41 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u009c\u0004\u000fstock-335124846:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124846\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.01:0";
		String payLoad_42 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u00a6\u0004\u000fstock-335124847:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124847\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:103.87:0";
		String payLoad_43 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u00b1\u0004\u000fstock-335124848:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124848\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.82:0";
		String payLoad_44 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u00bb\u0004\u000fstock-335124849:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124849\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.38:0";
		String payLoad_45 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u00c5\u0004\u000fstock-335124850:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124850\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:115.20:0";
		String payLoad_46 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u00cf\u0004\u000fstock-335124851:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124851\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.72:0";
		String payLoad_47 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u00d9\u0004\u000fstock-335124852:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124852\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:102.84:0";
		String payLoad_48 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u00e3\u0004\u000fstock-335124853:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124853\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:101.91:0";
		String payLoad_49 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u00ee\u0004\u000fstock-335124854:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124854\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:149.61:100";
		String payLoad_50 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009d\u00f8\u0004\u000fstock-335124855:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124855\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.68:0";
		String payLoad_51 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u0002\u0004\u000fstock-335124856:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124856\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:24.86:0";
		String payLoad_52 = " \u00c2\u008b\u0002\u0011/queue/q636547011\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u0003\u0004\u0005cmd-14ID:demo2.kaazing.com-35242-1467850762420-1:1:1:390:1\u0003k\u00b0\u0005value\u00082629.217\u0007command\u000bget_balance\u0006status\u0002ok\u0001-";
		String payLoad_53 = "#\u0007\u0080\u0005SND:2";
		String payLoad_54 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\f\u0004\u000fstock-335124857:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124857\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.11:0";
		String payLoad_55 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u0016\u0004\u000fstock-335124858:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124858\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.01:0";
		String payLoad_56 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e \u0004\u000fstock-335124859:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124859\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.47:0";
		String payLoad_57 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e+\u0004\u000fstock-335124860:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124860\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.80:0";
		String payLoad_58 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e5\u0004\u000fstock-335124861:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124861\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.78:0";
		String payLoad_59 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e?\u0004\u000fstock-335124862:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124862\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.61:0";
		String payLoad_60 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009eI\u0004\u000fstock-335124863:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124863\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.20:0";
		String payLoad_61 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009eS\u0004\u000fstock-335124864:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124864\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.54:0";
		String payLoad_62 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e^\u0004\u000fstock-335124865:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124865\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.29:0";
		String payLoad_63 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009eh\u0004\u000fstock-335124866:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124866\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.02:0";
		String payLoad_64 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009er\u0004\u000fstock-335124867:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124867\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.10:0";
		String payLoad_65 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e|\u0004\u000fstock-335124868:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124868\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.45:0";
		String payLoad_66 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u0086\u0004\u000fstock-335124869:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124869\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.15:0";
		String payLoad_67 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u0090\u0004\u000fstock-335124870:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124870\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.65:0";
		String payLoad_68 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u009b\u0004\u000fstock-335124871:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124871\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.51:0";
		String payLoad_69 = "\u0002}\u00e04ID:demo2.kaazing.com-35242-1467850762420-1:1:1:390:1EACK:q/q636547011;ID:demo2.kaazing.com-35242-1467850762420-1:1:1:390:1\u0002";
		String payLoad_70 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u00a5\u0004\u000fstock-335124872:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124872\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:101.94:0";
		String payLoad_71 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u00af\u0004\u000fstock-335124873:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124873\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.10:0";
		String payLoad_72 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u00b9\u0004\u000fstock-335124874:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124874\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.21:0";
		String payLoad_73 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u00c3\u0004\u000fstock-335124875:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124875\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.76:0";
		String payLoad_74 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u00cd\u0004\u000fstock-335124876:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124876\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.06:0";
		String payLoad_75 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u00d8\u0004\u000fstock-335124877:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124877\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.98:0";
		String payLoad_76 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u00e2\u0004\u000fstock-335124878:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124878\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:115.46:0";
		String payLoad_77 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u00ec\u0004\u000fstock-335124879:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124879\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.63:0";
		String payLoad_78 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009e\u00f6\u0004\u000fstock-335124880:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124880\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.57:0";
		String payLoad_79 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u0000\u0004\u000fstock-335124881:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124881\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.50:0";
		String payLoad_80 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\n\u0004\u000fstock-335124882:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124882\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.21:0";
		String payLoad_81 = "#G\u0080EACK:q/q636547011;ID:demo2.kaazing.com-35242-1467850762420-1:1:1:390:1";
		String payLoad_82 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u0015\u0004\u000fstock-335124883:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124883\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:101.30:0";
		String payLoad_83 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u001f\u0004\u000fstock-335124884:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124884\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.18:0";
		String payLoad_84 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f)\u0004\u000fstock-335124885:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124885\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.14:0";
		String payLoad_85 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f3\u0004\u000fstock-335124886:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124886\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.56:0";
		String payLoad_86 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f=\u0004\u000fstock-335124887:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124887\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.23:0";
		String payLoad_87 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009fH\u0004\u000fstock-335124888:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124888\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.27:0";
		String payLoad_88 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009fR\u0004\u000fstock-335124889:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124889\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.02:0";
		String payLoad_89 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\\\u0004\u000fstock-335124890:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124890\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.45:0";
		String payLoad_90 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009ff\u0004\u000fstock-335124891:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124891\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:115.48:0";
		String payLoad_91 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009fp\u0004\u000fstock-335124892:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124892\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:115.39:0";
		String payLoad_92 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009fz\u0004\u000fstock-335124893:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124893\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.00:0";
		String payLoad_93 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u0085\u0004\u000fstock-335124894:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124894\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:101.31:0";
		String payLoad_94 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u008f\u0004\u000fstock-335124895:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124895\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.62:0";
		String payLoad_95 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u0099\u0004\u000fstock-335124896:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124896\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.47:0";
		String payLoad_96 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u00a3\u0004\u000fstock-335124897:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124897\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.66:0";
		String payLoad_97 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u00ad\u0004\u000fstock-335124898:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124898\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:116.50:0";
		String payLoad_98 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u00b7\u0004\u000fstock-335124899:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124899\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.77:0";
		String payLoad_99 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u00c2\u0004\u000fstock-335124900:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124900\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.08:0";
		String payLoad_100 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u00cc\u0004\u000fstock-335124901:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124901\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:115.36:0";
		String payLoad_101 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u00d6\u0004\u000fstock-335124902:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124902\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.62:0";
		String payLoad_102 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u00e0\u0004\u000fstock-335124903:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124903\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.75:0";
		String payLoad_103 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u00ea\u0004\u000fstock-335124904:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124904\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.74:0";
		String payLoad_104 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u00f5\u0004\u000fstock-335124905:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124905\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:101.71:0";
		String payLoad_105 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u009f\u00ff\u0004\u000fstock-335124906:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124906\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.05:0";
		String payLoad_106 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\t\u0004\u000fstock-335124907:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124907\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.06:0";
		String payLoad_107 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u0013\u0004\u000fstock-335124908:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124908\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.25:0";
		String payLoad_108 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u001d\u0004\u000fstock-335124909:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124909\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.73:0";
		String payLoad_109 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0(\u0004\u000fstock-335124910:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124910\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.44:0";
		String payLoad_110 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a02\u0004\u000fstock-335124911:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124911\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.07:0";
		String payLoad_111 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0<\u0004\u000fstock-335124912:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124912\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.72:0";
		String payLoad_112 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0F\u0004\u000fstock-335124913:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124913\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.64:0";
		String payLoad_113 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0P\u0004\u000fstock-335124914:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124914\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:148.91:100";
		String payLoad_114 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0Z\u0004\u000fstock-335124915:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124915\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.17:0";
		String payLoad_115 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0e\u0004\u000fstock-335124916:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124916\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:62.98:0";
		String payLoad_116 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0o\u0004\u000fstock-335124917:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124917\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:102.41:0";
		String payLoad_117 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0y\u0004\u000fstock-335124918:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124918\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.28:0";
		String payLoad_118 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u0083\u0004\u000fstock-335124919:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124919\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:150.21:100";
		String payLoad_119 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u008d\u0004\u000fstock-335124920:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124920\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.47:0";
		String payLoad_120 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u0097\u0004\u000fstock-335124921:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124921\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.04:0";
		String payLoad_121 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u00a2\u0004\u000fstock-335124922:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124922\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.47:0";
		String payLoad_122 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u00ac\u0004\u000fstock-335124923:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124923\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.10:0";
		String payLoad_123 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u00b6\u0004\u000fstock-335124924:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124924\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.35:0";
		String payLoad_124 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u00c0\u0004\u000fstock-335124925:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124925\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.37:0";
		String payLoad_125 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u00ca\u0004\u000fstock-335124926:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124926\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.73:0";
		String payLoad_126 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u00d4\u0004\u000fstock-335124927:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124927\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.13:0";
		String payLoad_127 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u00df\u0004\u000fstock-335124928:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124928\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.42:0";
		String payLoad_128 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u00e9\u0004\u000fstock-335124929:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124929\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:150.46:100";
		String payLoad_129 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u00f3\u0004\u000fstock-335124930:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124930\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.07:0";
		String payLoad_130 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a0\u00fd\u0004\u000fstock-335124931:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124931\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.31:0";
		String payLoad_131 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u0007\u0004\u000fstock-335124932:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124932\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.91:0";
		String payLoad_132 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u0011\u0004\u000fstock-335124933:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124933\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.26:0";
		String payLoad_133 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u001c\u0004\u000fstock-335124934:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124934\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.68:0";
		String payLoad_134 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1&\u0004\u000fstock-335124935:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124935\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.05:0";
		String payLoad_135 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a10\u0004\u000fstock-335124936:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124936\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.79:0";
		String payLoad_136 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1:\u0004\u000fstock-335124937:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124937\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.70:0";
		String payLoad_137 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1D\u0004\u000fstock-335124938:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124938\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.73:0";
		String payLoad_138 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1N\u0004\u000fstock-335124939:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124939\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.03:0";
		String payLoad_139 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1Y\u0004\u000fstock-335124940:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124940\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.15:0";
		String payLoad_140 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1c\u0004\u000fstock-335124941:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124941\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.24:0";
		String payLoad_141 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1m\u0004\u000fstock-335124942:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124942\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.30:0";
		String payLoad_142 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1w\u0004\u000fstock-335124943:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124943\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.17:0";
		String payLoad_143 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u0081\u0004\u000fstock-335124944:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124944\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.77:0";
		String payLoad_144 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u008c\u0004\u000fstock-335124945:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124945\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.26:0";
		String payLoad_145 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u0096\u0004\u000fstock-335124946:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124946\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.43:0";
		String payLoad_146 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u00a0\u0004\u000fstock-335124947:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124947\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.72:0";
		String payLoad_147 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u00aa\u0004\u000fstock-335124948:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124948\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.17:0";
		String payLoad_148 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u00b4\u0004\u000fstock-335124949:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124949\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.53:0";
		String payLoad_149 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u00be\u0004\u000fstock-335124950:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124950\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.14:0";
		String payLoad_150 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u00c9\u0004\u000fstock-335124951:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124951\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.25:0";
		String payLoad_151 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u00d3\u0004\u000fstock-335124952:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124952\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.27:0";
		String payLoad_152 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u00dd\u0004\u000fstock-335124953:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124953\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.42:0";
		String payLoad_153 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u00e7\u0004\u000fstock-335124954:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124954\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.77:0";
		String payLoad_154 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u00f1\u0004\u000fstock-335124955:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124955\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:151.06:100";
		String payLoad_155 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a1\u00fb\u0004\u000fstock-335124956:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124956\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.74:0";
		String payLoad_156 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u0006\u0004\u000fstock-335124957:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124957\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.70:0";
		String payLoad_157 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u0010\u0004\u000fstock-335124958:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124958\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.26:0";
		String payLoad_158 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u001a\u0004\u000fstock-335124959:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124959\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.20:0";
		String payLoad_159 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2$\u0004\u000fstock-335124960:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124960\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.84:0";
		String payLoad_160 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2.\u0004\u000fstock-335124961:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124961\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:150.96:100";
		String payLoad_161 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a29\u0004\u000fstock-335124962:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124962\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.90:0";
		String payLoad_162 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2C\u0004\u000fstock-335124963:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124963\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.16:0";
		String payLoad_163 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2M\u0004\u000fstock-335124964:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124964\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.33:0";
		String payLoad_164 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2W\u0004\u000fstock-335124965:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124965\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.73:0";
		String payLoad_165 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2a\u0004\u000fstock-335124966:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124966\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.13:0";
		String payLoad_166 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2k\u0004\u000fstock-335124967:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124967\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.03:0";
		String payLoad_167 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2v\u0004\u000fstock-335124968:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124968\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.02:0";
		String payLoad_168 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u0080\u0004\u000fstock-335124969:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124969\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.89:0";
		String payLoad_169 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u008a\u0004\u000fstock-335124970:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124970\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.96:0";
		String payLoad_170 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u0094\u0004\u000fstock-335124971:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124971\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.76:0";
		String payLoad_171 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u009e\u0004\u000fstock-335124972:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124972\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.39:0";
		String payLoad_172 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u00a9\u0004\u000fstock-335124973:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124973\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.14:0";
		String payLoad_173 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u00b3\u0004\u000fstock-335124974:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124974\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.15:0";
		String payLoad_174 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u00bd\u0004\u000fstock-335124975:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124975\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.63:0";
		String payLoad_175 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u00c7\u0004\u000fstock-335124976:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124976\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.64:0";
		String payLoad_176 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u00d1\u0004\u000fstock-335124977:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124977\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.19:0";
		String payLoad_177 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u00db\u0004\u000fstock-335124978:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124978\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.62:0";
		String payLoad_178 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u00e6\u0004\u000fstock-335124979:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124979\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.74:0";
		String payLoad_179 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u00f0\u0004\u000fstock-335124980:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124980\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.22:0";
		String payLoad_180 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a2\u00fa\u0004\u000fstock-335124981:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124981\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.02:0";
		String payLoad_181 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u0004\u0004\u000fstock-335124982:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124982\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.89:0";
		String payLoad_182 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u000e\u0004\u000fstock-335124983:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124983\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:102.76:0";
		String payLoad_183 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u0019\u0004\u000fstock-335124984:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124984\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:102.73:0";
		String payLoad_184 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3#\u0004\u000fstock-335124985:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124985\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.18:0";
		String payLoad_185 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3-\u0004\u000fstock-335124986:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124986\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.21:0";
		String payLoad_186 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a37\u0004\u000fstock-335124987:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124987\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.72:0";
		String payLoad_187 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3A\u0004\u000fstock-335124988:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124988\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.92:0";
		String payLoad_188 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3K\u0004\u000fstock-335124989:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124989\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.26:0";
		String payLoad_189 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3V\u0004\u000fstock-335124990:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124990\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:103.15:0";
		String payLoad_190 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3`\u0004\u000fstock-335124991:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124991\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:151.48:100";
		String payLoad_191 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3j\u0004\u000fstock-335124992:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124992\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.94:0";
		String payLoad_192 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3t\u0004\u000fstock-335124993:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124993\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.88:0";
		String payLoad_193 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3~\u0004\u000fstock-335124994:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124994\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.34:0";
		String payLoad_194 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u0089\u0004\u000fstock-335124995:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124995\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.34:0";
		String payLoad_195 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u0093\u0004\u000fstock-335124996:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124996\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.10:0";
		String payLoad_196 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u009d\u0004\u000fstock-335124997:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124997\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.29:0";
		String payLoad_197 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u00a7\u0004\u000fstock-335124998:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124998\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.20:0";
		String payLoad_198 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u00b1\u0004\u000fstock-335124999:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335124999\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:152.45:100";
		String payLoad_199 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u00bb\u0004\u000fstock-335125000:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125000\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.96:0";
		String payLoad_200 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u00c6\u0004\u000fstock-335125001:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125001\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.18:0";
		String payLoad_201 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u00d0\u0004\u000fstock-335125002:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125002\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.81:0";
		String payLoad_202 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u00da\u0004\u000fstock-335125003:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125003\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.83:0";
		String payLoad_203 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u00e4\u0004\u000fstock-335125004:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125004\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:151.38:100";
		String payLoad_204 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u00ee\u0004\u000fstock-335125005:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125005\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.32:0";
		String payLoad_205 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a3\u00f9\u0004\u000fstock-335125006:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125006\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.14:0";
		String payLoad_206 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\u0003\u0004\u000fstock-335125007:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125007\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.10:0";
		String payLoad_207 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\r\u0004\u000fstock-335125008:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125008\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.60:0";
		String payLoad_208 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\u0017\u0004\u000fstock-335125009:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125009\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.51:0";
		String payLoad_209 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4!\u0004\u000fstock-335125010:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125010\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:151.78:100";
		String payLoad_210 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4+\u0004\u000fstock-335125011:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125011\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.53:0";
		String payLoad_211 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a46\u0004\u000fstock-335125012:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125012\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.85:0";
		String payLoad_212 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4@\u0004\u000fstock-335125013:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125013\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:150.50:100";
		String payLoad_213 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4J\u0004\u000fstock-335125014:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125014\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.21:0";
		String payLoad_214 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4T\u0004\u000fstock-335125015:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125015\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.40:0";
		String payLoad_215 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4^\u0004\u000fstock-335125016:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125016\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.22:0";
		String payLoad_216 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4h\u0004\u000fstock-335125017:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125017\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.74:0";
		String payLoad_217 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4s\u0004\u000fstock-335125018:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125018\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.70:0";
		String payLoad_218 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4}\u0004\u000fstock-335125019:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125019\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.04:0";
		String payLoad_219 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\u0087\u0004\u000fstock-335125020:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125020\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.58:0";
		String payLoad_220 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\u0091\u0004\u000fstock-335125021:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125021\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.94:0";
		String payLoad_221 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\u009b\u0004\u000fstock-335125022:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125022\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:150.19:100";
		String payLoad_222 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\u00a5\u0004\u000fstock-335125023:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125023\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:151.40:100";
		String payLoad_223 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\u00b0\u0004\u000fstock-335125024:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125024\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.03:0";
		String payLoad_224 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\u00ba\u0004\u000fstock-335125025:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125025\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.03:0";
		String payLoad_225 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\u00c4\u0004\u000fstock-335125026:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125026\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.67:0";
		String payLoad_226 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\u00ce\u0004\u000fstock-335125027:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125027\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.52:0";
		String payLoad_227 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\u00d8\u0004\u000fstock-335125028:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125028\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.11:0";
		String payLoad_228 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\u00e2\u0004\u000fstock-335125029:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125029\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:104.16:0";
		String payLoad_229 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\u00ed\u0004\u000fstock-335125030:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125030\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.73:0";
		String payLoad_230 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a4\u00f7\u0004\u000fstock-335125031:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125031\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.95:0";
		String payLoad_231 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u0001\u0004\u000fstock-335125032:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125032\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.14:0";
		String payLoad_232 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u000b\u0004\u000fstock-335125033:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125033\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.23:0";
		String payLoad_233 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u0015\u0004\u000fstock-335125034:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125034\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:104.30:0";
		String payLoad_234 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5 \u0004\u000fstock-335125035:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125035\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.71:0";
		String payLoad_235 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5*\u0004\u000fstock-335125036:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125036\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:105.27:0";
		String payLoad_236 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a54\u0004\u000fstock-335125037:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125037\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.59:0";
		String payLoad_237 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5>\u0004\u000fstock-335125038:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125038\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:152.36:100";
		String payLoad_238 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5H\u0004\u000fstock-335125039:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125039\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.64:0";
		String payLoad_239 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5R\u0004\u000fstock-335125040:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125040\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.22:0";
		String payLoad_240 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5]\u0004\u000fstock-335125041:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125041\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.70:0";
		String payLoad_241 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5g\u0004\u000fstock-335125042:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125042\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.68:0";
		String payLoad_242 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5q\u0004\u000fstock-335125043:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125043\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.62:0";
		String payLoad_243 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5{\u0004\u000fstock-335125044:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125044\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.72:0";
		String payLoad_244 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u0085\u0004\u000fstock-335125045:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125045\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.74:0";
		String payLoad_245 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u008f\u0004\u000fstock-335125046:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125046\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.98:0";
		String payLoad_246 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u009a\u0004\u000fstock-335125047:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125047\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.36:0";
		String payLoad_247 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u00a4\u0004\u000fstock-335125048:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125048\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.32:0";
		String payLoad_248 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u00ae\u0004\u000fstock-335125049:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125049\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:105.20:0";
		String payLoad_249 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u00b8\u0004\u000fstock-335125050:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125050\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.66:0";
		String payLoad_250 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u00c2\u0004\u000fstock-335125051:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125051\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.33:0";
		String payLoad_251 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u00cc\u0004\u000fstock-335125052:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125052\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.09:0";
		String payLoad_252 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u00d7\u0004\u000fstock-335125053:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125053\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.22:0";
		String payLoad_253 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u00e1\u0004\u000fstock-335125054:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125054\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:152.70:100";
		String payLoad_254 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u00eb\u0004\u000fstock-335125055:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125055\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:153.96:100";
		String payLoad_255 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u00f5\u0004\u000fstock-335125056:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125056\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.15:0";
		String payLoad_256 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a5\u00ff\u0004\u000fstock-335125057:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125057\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.73:0";
		String payLoad_257 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\t\u0004\u000fstock-335125058:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125058\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.10:0";
		String payLoad_258 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u0014\u0004\u000fstock-335125059:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125059\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.70:0";
		String payLoad_259 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u001e\u0004\u000fstock-335125060:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125060\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.74:0";
		String payLoad_260 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6(\u0004\u000fstock-335125061:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125061\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.09:0";
		String payLoad_261 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a62\u0004\u000fstock-335125062:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125062\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:106.09:0";
		String payLoad_262 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6<\u0004\u000fstock-335125063:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125063\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.26:0";
		String payLoad_263 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6G\u0004\u000fstock-335125064:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125064\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.12:0";
		String payLoad_264 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6Q\u0004\u000fstock-335125065:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125065\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.56:0";
		String payLoad_265 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6[\u0004\u000fstock-335125066:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125066\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:105.39:0";
		String payLoad_266 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6e\u0004\u000fstock-335125067:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125067\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.36:0";
		String payLoad_267 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6o\u0004\u000fstock-335125068:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125068\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.98:0";
		String payLoad_268 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6y\u0004\u000fstock-335125069:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125069\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.44:0";
		String payLoad_269 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u0084\u0004\u000fstock-335125070:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125070\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.73:0";
		String payLoad_270 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u008e\u0004\u000fstock-335125071:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125071\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.97:0";
		String payLoad_271 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u0098\u0004\u000fstock-335125072:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125072\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.18:0";
		String payLoad_272 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u00a2\u0004\u000fstock-335125073:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125073\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.39:0";
		String payLoad_273 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u00ac\u0004\u000fstock-335125074:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125074\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.64:0";
		String payLoad_274 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u00b6\u0004\u000fstock-335125075:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125075\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.31:0";
		String payLoad_275 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u00c1\u0004\u000fstock-335125076:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125076\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:104.87:0";
		String payLoad_276 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u00cb\u0004\u000fstock-335125077:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125077\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.89:0";
		String payLoad_277 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u00d5\u0004\u000fstock-335125078:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125078\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.44:0";
		String payLoad_278 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u00df\u0004\u000fstock-335125079:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125079\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.53:0";
		String payLoad_279 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u00e9\u0004\u000fstock-335125080:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125080\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.74:0";
		String payLoad_280 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u00f3\u0004\u000fstock-335125081:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125081\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.60:0";
		String payLoad_281 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a6\u00fe\u0004\u000fstock-335125082:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125082\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.80:0";
		String payLoad_282 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u0008\u0004\u000fstock-335125083:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125083\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.65:0";
		String payLoad_283 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u0012\u0004\u000fstock-335125084:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125084\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.81:0";
		String payLoad_284 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u001c\u0004\u000fstock-335125085:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125085\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.70:0";
		String payLoad_285 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7&\u0004\u000fstock-335125086:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125086\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:104.62:0";
		String payLoad_286 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a71\u0004\u000fstock-335125087:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125087\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:103.70:0";
		String payLoad_287 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7;\u0004\u000fstock-335125088:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125088\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.33:0";
		String payLoad_288 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7E\u0004\u000fstock-335125089:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125089\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:63.88:0";
		String payLoad_289 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7O\u0004\u000fstock-335125090:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125090\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.12:0";
		String payLoad_290 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7Y\u0004\u000fstock-335125091:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125091\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.51:0";
		String payLoad_291 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7c\u0004\u000fstock-335125092:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125092\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.75:0";
		String payLoad_292 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7n\u0004\u000fstock-335125093:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125093\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:103.54:0";
		String payLoad_293 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7x\u0004\u000fstock-335125094:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125094\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:111.88:0";
		String payLoad_294 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u0082\u0004\u000fstock-335125095:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125095\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:14.08:0";
		String payLoad_295 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u008c\u0004\u000fstock-335125096:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125096\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.72:0";
		String payLoad_296 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u0096\u0004\u000fstock-335125097:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125097\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.58:0";
		String payLoad_297 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u00a0\u0004\u000fstock-335125098:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125098\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.96:0";
		String payLoad_298 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u00ab\u0004\u000fstock-335125099:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125099\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:103.84:0";
		String payLoad_299 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u00b5\u0004\u000fstock-335125100:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125100\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:111.00:0";
		String payLoad_300 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u00bf\u0004\u000fstock-335125101:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125101\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:103.80:0";
		String payLoad_301 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u00c9\u0004\u000fstock-335125102:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125102\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:103.79:0";
		String payLoad_302 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u00d3\u0004\u000fstock-335125103:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125103\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.58:0";
		String payLoad_303 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u00dd\u0004\u000fstock-335125104:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125104\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.27:0";
		String payLoad_304 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u00e8\u0004\u000fstock-335125105:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125105\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.72:0";
		String payLoad_305 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u00f2\u0004\u000fstock-335125106:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125106\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.64:0";
		String payLoad_306 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a7\u00fc\u0004\u000fstock-335125107:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125107\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.70:0";
		String payLoad_307 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u0006\u0004\u000fstock-335125108:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125108\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.45:0";
		String payLoad_308 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u0010\u0004\u000fstock-335125109:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125109\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.50:0";
		String payLoad_309 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u001b\u0004\u000fstock-335125110:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125110\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:111.34:0";
		String payLoad_310 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8%\u0004\u000fstock-335125111:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125111\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:111.14:0";
		String payLoad_311 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8/\u0004\u000fstock-335125112:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125112\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.65:0";
		String payLoad_312 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a89\u0004\u000fstock-335125113:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125113\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.67:0";
		String payLoad_313 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8C\u0004\u000fstock-335125114:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125114\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.46:0";
		String payLoad_314 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8M\u0004\u000fstock-335125115:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125115\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.74:0";
		String payLoad_315 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8X\u0004\u000fstock-335125116:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125116\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.52:0";
		String payLoad_316 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8b\u0004\u000fstock-335125117:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125117\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:153.97:100";
		String payLoad_317 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8l\u0004\u000fstock-335125118:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125118\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.64:0";
		String payLoad_318 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8v\u0004\u000fstock-335125119:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125119\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.90:0";
		String payLoad_319 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u0080\u0004\u000fstock-335125120:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125120\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.74:0";
		String payLoad_320 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u008a\u0004\u000fstock-335125121:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125121\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.75:0";
		String payLoad_321 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u0095\u0004\u000fstock-335125122:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125122\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.77:0";
		String payLoad_322 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u009f\u0004\u000fstock-335125123:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125123\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:104.82:0";
		String payLoad_323 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u00a9\u0004\u000fstock-335125124:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125124\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.15:0";
		String payLoad_324 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u00b3\u0004\u000fstock-335125125:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125125\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.95:0";
		String payLoad_325 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u00bd\u0004\u000fstock-335125126:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125126\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.37:0";
		String payLoad_326 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u00c8\u0004\u000fstock-335125127:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125127\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:153.72:100";
		String payLoad_327 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u00d2\u0004\u000fstock-335125128:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125128\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.26:0";
		String payLoad_328 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u00dc\u0004\u000fstock-335125129:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125129\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.56:0";
		String payLoad_329 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u00e6\u0004\u000fstock-335125130:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125130\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.75:0";
		String payLoad_330 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u00f0\u0004\u000fstock-335125131:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125131\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.02:0";
		String payLoad_331 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a8\u00fb\u0004\u000fstock-335125132:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125132\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.55:0";
		String payLoad_332 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u0005\u0004\u000fstock-335125133:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125133\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.89:0";
		String payLoad_333 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u000f\u0004\u000fstock-335125134:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125134\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.88:0";
		String payLoad_334 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u0019\u0004\u000fstock-335125135:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125135\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:104.77:0";
		String payLoad_335 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9#\u0004\u000fstock-335125136:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125136\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.81:0";
		String payLoad_336 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9.\u0004\u000fstock-335125137:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125137\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.03:0";
		String payLoad_337 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a98\u0004\u000fstock-335125138:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125138\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:104.19:0";
		String payLoad_338 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9B\u0004\u000fstock-335125139:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125139\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.48:0";
		String payLoad_339 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9L\u0004\u000fstock-335125140:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125140\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.26:0";
		String payLoad_340 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9V\u0004\u000fstock-335125141:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125141\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.07:0";
		String payLoad_341 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9`\u0004\u000fstock-335125142:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125142\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.02:0";
		String payLoad_342 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9k\u0004\u000fstock-335125143:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125143\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.85:0";
		String payLoad_343 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9u\u0004\u000fstock-335125144:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125144\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.62:0";
		String payLoad_344 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u007f\u0004\u000fstock-335125145:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125145\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.86:0";
		String payLoad_345 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u0089\u0004\u000fstock-335125146:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125146\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.88:0";
		String payLoad_346 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u0093\u0004\u000fstock-335125147:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125147\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.64:0";
		String payLoad_347 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u009e\u0004\u000fstock-335125148:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125148\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.25:0";
		String payLoad_348 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u00a8\u0004\u000fstock-335125149:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125149\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:105.06:0";
		String payLoad_349 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u00b2\u0004\u000fstock-335125150:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125150\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.76:0";
		String payLoad_350 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u00bc\u0004\u000fstock-335125151:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125151\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.68:0";
		String payLoad_351 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u00c6\u0004\u000fstock-335125152:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125152\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.86:0";
		String payLoad_352 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u00d0\u0004\u000fstock-335125153:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125153\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.53:0";
		String payLoad_353 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u00db\u0004\u000fstock-335125154:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125154\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:105.60:0";
		String payLoad_354 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u00e5\u0004\u000fstock-335125155:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125155\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:154.67:100";
		String payLoad_355 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u00ef\u0004\u000fstock-335125156:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125156\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.86:0";
		String payLoad_356 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00a9\u00f9\u0004\u000fstock-335125157:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125157\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.24:0";
		String payLoad_357 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u0003\u0004\u000fstock-335125158:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125158\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:106.49:0";
		String payLoad_358 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u000e\u0004\u000fstock-335125159:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125159\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.85:0";
		String payLoad_359 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u0018\u0004\u000fstock-335125160:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125160\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:154.12:100";
		String payLoad_360 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\"\u0004\u000fstock-335125161:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125161\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.58:0";
		String payLoad_361 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa,\u0004\u000fstock-335125162:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125162\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.86:0";
		String payLoad_362 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa6\u0004\u000fstock-335125163:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125163\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.78:0";
		String payLoad_363 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aaA\u0004\u000fstock-335125164:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125164\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.75:0";
		String payLoad_364 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aaK\u0004\u000fstock-335125165:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125165\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.85:0";
		String payLoad_365 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aaU\u0004\u000fstock-335125166:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125166\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.61:0";
		String payLoad_366 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa_\u0004\u000fstock-335125167:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125167\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.09:0";
		String payLoad_367 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aai\u0004\u000fstock-335125168:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125168\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:105.52:0";
		String payLoad_368 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aas\u0004\u000fstock-335125169:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125169\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.78:0";
		String payLoad_369 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa~\u0004\u000fstock-335125170:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125170\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.86:0";
		String payLoad_370 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u0088\u0004\u000fstock-335125171:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125171\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.71:0";
		String payLoad_371 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u0092\u0004\u000fstock-335125172:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125172\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:111.61:0";
		String payLoad_372 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u009c\u0004\u000fstock-335125173:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125173\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.79:0";
		String payLoad_373 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u00a6\u0004\u000fstock-335125174:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125174\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.74:0";
		String payLoad_374 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u00b0\u0004\u000fstock-335125175:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125175\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:106.31:0";
		String payLoad_375 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u00bb\u0004\u000fstock-335125176:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125176\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:152.89:100";
		String payLoad_376 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u00c5\u0004\u000fstock-335125177:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125177\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.64:0";
		String payLoad_377 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u00d0\u0004\u000fstock-335125178:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125178\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.78:0";
		String payLoad_378 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u00da\u0004\u000fstock-335125179:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125179\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.65:0";
		String payLoad_379 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u00e4\u0004\u000fstock-335125180:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125180\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.84:0";
		String payLoad_380 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u00ee\u0004\u000fstock-335125181:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125181\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.77:0";
		String payLoad_381 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aa\u00f8\u0004\u000fstock-335125182:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125182\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.64:0";
		String payLoad_382 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\u0003\u0004\u000fstock-335125183:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125183\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.71:0";
		String payLoad_383 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\r\u0004\u000fstock-335125184:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125184\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.69:0";
		String payLoad_384 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\u0017\u0004\u000fstock-335125185:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125185\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.95:0";
		String payLoad_385 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab!\u0004\u000fstock-335125186:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125186\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:151.59:100";
		String payLoad_386 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab+\u0004\u000fstock-335125187:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125187\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.69:0";
		String payLoad_387 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab5\u0004\u000fstock-335125188:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125188\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.70:0";
		String payLoad_388 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab@\u0004\u000fstock-335125189:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125189\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.79:0";
		String payLoad_389 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00abJ\u0004\u000fstock-335125190:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125190\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.84:0";
		String payLoad_390 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00abT\u0004\u000fstock-335125191:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125191\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.67:0";
		String payLoad_391 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab^\u0004\u000fstock-335125192:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125192\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:111.87:0";
		String payLoad_392 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00abh\u0004\u000fstock-335125193:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125193\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.09:0";
		String payLoad_393 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00abs\u0004\u000fstock-335125194:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125194\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.59:0";
		String payLoad_394 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab}\u0004\u000fstock-335125195:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125195\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.53:0";
		String payLoad_395 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\u0087\u0004\u000fstock-335125196:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125196\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.81:0";
		String payLoad_396 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\u0091\u0004\u000fstock-335125197:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125197\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.75:0";
		String payLoad_397 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\u009b\u0004\u000fstock-335125198:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125198\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.69:0";
		String payLoad_398 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\u00a5\u0004\u000fstock-335125199:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125199\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:111.96:0";
		String payLoad_399 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\u00b0\u0004\u000fstock-335125200:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125200\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.50:0";
		String payLoad_400 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\u00ba\u0004\u000fstock-335125201:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125201\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:151.09:100";
		String payLoad_401 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\u00c4\u0004\u000fstock-335125202:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125202\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.83:0";
		String payLoad_402 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\u00ce\u0004\u000fstock-335125203:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125203\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.20:0";
		String payLoad_403 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\u00d8\u0004\u000fstock-335125204:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125204\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.93:0";
		String payLoad_404 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\u00e2\u0004\u000fstock-335125205:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125205\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.17:0";
		String payLoad_405 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\u00ed\u0004\u000fstock-335125206:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125206\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.60:0";
		String payLoad_406 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ab\u00f7\u0004\u000fstock-335125207:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125207\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:105.44:0";
		String payLoad_407 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u0001\u0004\u000fstock-335125208:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125208\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.33:0";
		String payLoad_408 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u000b\u0004\u000fstock-335125209:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125209\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.52:0";
		String payLoad_409 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u0015\u0004\u000fstock-335125210:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125210\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.34:0";
		String payLoad_410 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u001f\u0004\u000fstock-335125211:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125211\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.39:0";
		String payLoad_411 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac*\u0004\u000fstock-335125212:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125212\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.60:0";
		String payLoad_412 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac4\u0004\u000fstock-335125213:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125213\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.72:0";
		String payLoad_413 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac>\u0004\u000fstock-335125214:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125214\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.17:0";
		String payLoad_414 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00acH\u0004\u000fstock-335125215:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125215\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.68:0";
		String payLoad_415 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00acR\u0004\u000fstock-335125216:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125216\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.85:0";
		String payLoad_416 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\\\u0004\u000fstock-335125217:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125217\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.89:0";
		String payLoad_417 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00acg\u0004\u000fstock-335125218:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125218\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.42:0";
		String payLoad_418 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00acq\u0004\u000fstock-335125219:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125219\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.41:0";
		String payLoad_419 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac{\u0004\u000fstock-335125220:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125220\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.48:0";
		String payLoad_420 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u0085\u0004\u000fstock-335125221:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125221\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.07:0";
		String payLoad_421 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u008f\u0004\u000fstock-335125222:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125222\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:152.06:100";
		String payLoad_422 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u0099\u0004\u000fstock-335125223:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125223\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.24:0";
		String payLoad_423 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u00a4\u0004\u000fstock-335125224:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125224\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.09:0";
		String payLoad_424 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u00ae\u0004\u000fstock-335125225:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125225\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.48:0";
		String payLoad_425 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u00b8\u0004\u000fstock-335125226:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125226\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.86:0";
		String payLoad_426 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u00c2\u0004\u000fstock-335125227:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125227\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.84:0";
		String payLoad_427 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u00cc\u0004\u000fstock-335125228:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125228\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.76:0";
		String payLoad_428 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u00d7\u0004\u000fstock-335125229:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125229\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.35:0";
		String payLoad_429 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u00e1\u0004\u000fstock-335125230:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125230\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.34:0";
		String payLoad_430 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u00eb\u0004\u000fstock-335125231:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125231\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.02:0";
		String payLoad_431 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u00f5\u0004\u000fstock-335125232:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125232\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.36:0";
		String payLoad_432 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ac\u00ff\u0004\u000fstock-335125233:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125233\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.26:0";
		String payLoad_433 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\t\u0004\u000fstock-335125234:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125234\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.07:0";
		String payLoad_434 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u0013\u0004\u000fstock-335125235:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125235\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.53:0";
		String payLoad_435 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u001e\u0004\u000fstock-335125236:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125236\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.63:0";
		String payLoad_436 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad(\u0004\u000fstock-335125237:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125237\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:105.67:0";
		String payLoad_437 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad2\u0004\u000fstock-335125238:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125238\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.71:0";
		String payLoad_438 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad<\u0004\u000fstock-335125239:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125239\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.82:0";
		String payLoad_439 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00adF\u0004\u000fstock-335125240:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125240\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.31:0";
		String payLoad_440 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00adQ\u0004\u000fstock-335125241:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125241\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:151.60:100";
		String payLoad_441 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad[\u0004\u000fstock-335125242:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125242\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.95:0";
		String payLoad_442 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ade\u0004\u000fstock-335125243:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125243\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.33:0";
		String payLoad_443 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ado\u0004\u000fstock-335125244:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125244\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.30:0";
		String payLoad_444 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ady\u0004\u000fstock-335125245:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125245\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:105.33:0";
		String payLoad_445 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u0083\u0004\u000fstock-335125246:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125246\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.25:0";
		String payLoad_446 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u008e\u0004\u000fstock-335125247:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125247\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.49:0";
		String payLoad_447 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u0098\u0004\u000fstock-335125248:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125248\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.74:0";
		String payLoad_448 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u00a2\u0004\u000fstock-335125249:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125249\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.08:0";
		String payLoad_449 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u00ac\u0004\u000fstock-335125250:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125250\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:150.84:100";
		String payLoad_450 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u00b6\u0004\u000fstock-335125251:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125251\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.80:0";
		String payLoad_451 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u00c0\u0004\u000fstock-335125252:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125252\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.45:0";
		String payLoad_452 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u00cb\u0004\u000fstock-335125253:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125253\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.39:0";
		String payLoad_453 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u00d5\u0004\u000fstock-335125254:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125254\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.79:0";
		String payLoad_454 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u00df\u0004\u000fstock-335125255:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125255\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.34:0";
		String payLoad_455 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u00e9\u0004\u000fstock-335125256:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125256\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.96:0";
		String payLoad_456 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u00f3\u0004\u000fstock-335125257:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125257\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.35:0";
		String payLoad_457 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ad\u00fe\u0004\u000fstock-335125258:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125258\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.75:0";
		String payLoad_458 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u0008\u0004\u000fstock-335125259:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125259\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:150.92:100";
		String payLoad_459 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u0012\u0004\u000fstock-335125260:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125260\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.22:0";
		String payLoad_460 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u001c\u0004\u000fstock-335125261:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125261\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.23:0";
		String payLoad_461 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae&\u0004\u000fstock-335125262:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125262\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.47:0";
		String payLoad_462 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae0\u0004\u000fstock-335125263:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125263\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.62:0";
		String payLoad_463 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae;\u0004\u000fstock-335125264:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125264\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:39.09:0";
		String payLoad_464 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aeE\u0004\u000fstock-335125265:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125265\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.78:0";
		String payLoad_465 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aeO\u0004\u000fstock-335125266:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125266\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:105.30:0";
		String payLoad_466 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aeY\u0004\u000fstock-335125267:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125267\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.80:0";
		String payLoad_467 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aec\u0004\u000fstock-335125268:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125268\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.94:0";
		String payLoad_468 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aem\u0004\u000fstock-335125269:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125269\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.36:0";
		String payLoad_469 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00aex\u0004\u000fstock-335125270:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125270\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:152.35:100";
		String payLoad_470 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u0082\u0004\u000fstock-335125271:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125271\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.41:0";
		String payLoad_471 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u008c\u0004\u000fstock-335125272:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125272\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.42:0";
		String payLoad_472 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u0096\u0004\u000fstock-335125273:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125273\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.48:0";
		String payLoad_473 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u00a0\u0004\u000fstock-335125274:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125274\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:104.37:0";
		String payLoad_474 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u00ab\u0004\u000fstock-335125275:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125275\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.42:0";
		String payLoad_475 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u00b5\u0004\u000fstock-335125276:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125276\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.36:0";
		String payLoad_476 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u00bf\u0004\u000fstock-335125277:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125277\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.97:0";
		String payLoad_477 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u00c9\u0004\u000fstock-335125278:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125278\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.89:0";
		String payLoad_478 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u00d3\u0004\u000fstock-335125279:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125279\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.71:0";
		String payLoad_479 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u00dd\u0004\u000fstock-335125280:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125280\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.79:0";
		String payLoad_480 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u00e8\u0004\u000fstock-335125281:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125281\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.40:0";
		String payLoad_481 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u00f2\u0004\u000fstock-335125282:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125282\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.19:0";
		String payLoad_482 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ae\u00fc\u0004\u000fstock-335125283:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125283\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.11:0";
		String payLoad_483 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u0006\u0004\u000fstock-335125284:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125284\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.46:0";
		String payLoad_484 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u0010\u0004\u000fstock-335125285:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125285\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.81:0";
		String payLoad_485 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u001b\u0004\u000fstock-335125286:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125286\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:153.65:100";
		String payLoad_486 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af%\u0004\u000fstock-335125287:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125287\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.47:0";
		String payLoad_487 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af/\u0004\u000fstock-335125288:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125288\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.41:0";
		String payLoad_488 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af9\u0004\u000fstock-335125289:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125289\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.63:0";
		String payLoad_489 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00afC\u0004\u000fstock-335125290:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125290\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.35:0";
		String payLoad_490 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00afM\u0004\u000fstock-335125291:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125291\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.19:0";
		String payLoad_491 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00afX\u0004\u000fstock-335125292:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125292\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.50:0";
		String payLoad_492 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00afb\u0004\u000fstock-335125293:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125293\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.80:0";
		String payLoad_493 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00afl\u0004\u000fstock-335125294:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125294\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.86:0";
		String payLoad_494 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00afv\u0004\u000fstock-335125295:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125295\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:105.23:0";
		String payLoad_495 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u0080\u0004\u000fstock-335125296:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125296\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.47:0";
		String payLoad_496 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u008a\u0004\u000fstock-335125297:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125297\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.28:0";
		String payLoad_497 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u0095\u0004\u000fstock-335125298:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125298\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.82:0";
		String payLoad_498 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u009f\u0004\u000fstock-335125299:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125299\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.75:0";
		String payLoad_499 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u00a9\u0004\u000fstock-335125300:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125300\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.30:0";
		String payLoad_500 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u00b3\u0004\u000fstock-335125301:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125301\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.44:0";
		String payLoad_501 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u00bd\u0004\u000fstock-335125302:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125302\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.80:0";
		String payLoad_502 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u00c7\u0004\u000fstock-335125303:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125303\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.49:0";
		String payLoad_503 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u00d2\u0004\u000fstock-335125304:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125304\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.38:0";
		String payLoad_504 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u00dc\u0004\u000fstock-335125305:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125305\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:104.23:0";
		String payLoad_505 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u00e6\u0004\u000fstock-335125306:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125306\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.61:0";
		String payLoad_506 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u00f0\u0004\u000fstock-335125307:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125307\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.13:0";
		String payLoad_507 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00af\u00fa\u0004\u000fstock-335125308:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125308\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:104.58:0";
		String payLoad_508 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u0004\u0004\u000fstock-335125309:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125309\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.74:0";
		String payLoad_509 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u000f\u0004\u000fstock-335125310:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125310\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.33:0";
		String payLoad_510 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u0019\u0004\u000fstock-335125311:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125311\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.49:0";
		String payLoad_511 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0#\u0004\u000fstock-335125312:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125312\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:104.49:0";
		String payLoad_512 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0-\u0004\u000fstock-335125313:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125313\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:103.47:0";
		String payLoad_513 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b07\u0004\u000fstock-335125314:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125314\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:152.19:100";
		String payLoad_514 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0A\u0004\u000fstock-335125315:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125315\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.93:0";
		String payLoad_515 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0L\u0004\u000fstock-335125316:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125316\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.88:0";
		String payLoad_516 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0V\u0004\u000fstock-335125317:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125317\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.40:0";
		String payLoad_517 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0`\u0004\u000fstock-335125318:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125318\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.83:0";
		String payLoad_518 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0j\u0004\u000fstock-335125319:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125319\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.74:0";
		String payLoad_519 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0t\u0004\u000fstock-335125320:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125320\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.69:0";
		String payLoad_520 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u007f\u0004\u000fstock-335125321:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125321\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.80:0";
		String payLoad_521 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u0089\u0004\u000fstock-335125322:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125322\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.89:0";
		String payLoad_522 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u0093\u0004\u000fstock-335125323:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125323\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.36:0";
		String payLoad_523 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u009d\u0004\u000fstock-335125324:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125324\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:151.07:100";
		String payLoad_524 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u00a7\u0004\u000fstock-335125325:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125325\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:104.00:0";
		String payLoad_525 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u00b1\u0004\u000fstock-335125326:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125326\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.56:0";
		String payLoad_526 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u00bc\u0004\u000fstock-335125327:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125327\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.82:0";
		String payLoad_527 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u00c6\u0004\u000fstock-335125328:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125328\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.32:0";
		String payLoad_528 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u00d0\u0004\u000fstock-335125329:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125329\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.41:0";
		String payLoad_529 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u00da\u0004\u000fstock-335125330:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125330\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.58:0";
		String payLoad_530 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u00e4\u0004\u000fstock-335125331:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125331\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.22:0";
		String payLoad_531 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u00ee\u0004\u000fstock-335125332:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125332\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:149.67:100";
		String payLoad_532 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b0\u00f9\u0004\u000fstock-335125333:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125333\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.79:0";
		String payLoad_533 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\u0003\u0004\u000fstock-335125334:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125334\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.65:0";
		String payLoad_534 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\r\u0004\u000fstock-335125335:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125335\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.76:0";
		String payLoad_535 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\u0017\u0004\u000fstock-335125336:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125336\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:103.05:0";
		String payLoad_536 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1!\u0004\u000fstock-335125337:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125337\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.81:0";
		String payLoad_537 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1,\u0004\u000fstock-335125338:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125338\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.93:0";
		String payLoad_538 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b16\u0004\u000fstock-335125339:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125339\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.49:0";
		String payLoad_539 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1@\u0004\u000fstock-335125340:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125340\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.72:0";
		String payLoad_540 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1J\u0004\u000fstock-335125341:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125341\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.65:0";
		String payLoad_541 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1T\u0004\u000fstock-335125342:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125342\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.86:0";
		String payLoad_542 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1_\u0004\u000fstock-335125343:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125343\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:102.05:0";
		String payLoad_543 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1i\u0004\u000fstock-335125344:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125344\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.83:0";
		String payLoad_544 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1s\u0004\u000fstock-335125345:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125345\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.56:0";
		String payLoad_545 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1}\u0004\u000fstock-335125346:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125346\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:111.90:0";
		String payLoad_546 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\u0087\u0004\u000fstock-335125347:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125347\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.33:0";
		String payLoad_547 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\u0092\u0004\u000fstock-335125348:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125348\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:101.74:0";
		String payLoad_548 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\u009c\u0004\u000fstock-335125349:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125349\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:150.60:100";
		String payLoad_549 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\u00a6\u0004\u000fstock-335125350:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125350\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.69:0";
		String payLoad_550 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\u00b0\u0004\u000fstock-335125351:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125351\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.73:0";
		String payLoad_551 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\u00ba\u0004\u000fstock-335125352:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125352\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:102.25:0";
		String payLoad_552 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\u00c4\u0004\u000fstock-335125353:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125353\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.42:0";
		String payLoad_553 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\u00cf\u0004\u000fstock-335125354:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125354\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.80:0";
		String payLoad_554 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\u00d9\u0004\u000fstock-335125355:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125355\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.66:0";
		String payLoad_555 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\u00e3\u0004\u000fstock-335125356:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125356\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:150.81:100";
		String payLoad_556 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\u00ed\u0004\u000fstock-335125357:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125357\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.44:0";
		String payLoad_557 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b1\u00f7\u0004\u000fstock-335125358:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125358\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.65:0";
		String payLoad_558 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\u0002\u0004\u000fstock-335125359:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125359\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.36:0";
		String payLoad_559 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\f\u0004\u000fstock-335125360:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125360\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.41:0";
		String payLoad_560 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\u0016\u0004\u000fstock-335125361:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125361\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:151.48:100";
		String payLoad_561 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2 \u0004\u000fstock-335125362:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125362\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.72:0";
		String payLoad_562 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2*\u0004\u000fstock-335125363:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125363\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.75:0";
		String payLoad_563 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b25\u0004\u000fstock-335125364:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125364\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.44:0";
		String payLoad_564 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2?\u0004\u000fstock-335125365:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125365\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.33:0";
		String payLoad_565 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2I\u0004\u000fstock-335125366:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125366\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.82:0";
		String payLoad_566 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2S\u0004\u000fstock-335125367:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125367\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:150.12:100";
		String payLoad_567 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2]\u0004\u000fstock-335125368:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125368\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:149.43:100";
		String payLoad_568 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2g\u0004\u000fstock-335125369:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125369\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.39:0";
		String payLoad_569 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2r\u0004\u000fstock-335125370:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125370\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.72:0";
		String payLoad_570 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2|\u0004\u000fstock-335125371:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125371\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.41:0";
		String payLoad_571 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\u0086\u0004\u000fstock-335125372:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125372\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:102.87:0";
		String payLoad_572 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\u0090\u0004\u000fstock-335125373:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125373\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.86:0";
		String payLoad_573 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\u009a\u0004\u000fstock-335125374:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125374\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:103.61:0";
		String payLoad_574 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\u00a4\u0004\u000fstock-335125375:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125375\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.38:0";
		String payLoad_575 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\u00af\u0004\u000fstock-335125376:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125376\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.91:0";
		String payLoad_576 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\u00b9\u0004\u000fstock-335125377:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125377\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.31:0";
		String payLoad_577 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\u00c3\u0004\u000fstock-335125378:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125378\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.41:0";
		String payLoad_578 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\u00cd\u0004\u000fstock-335125379:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125379\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.71:0";
		String payLoad_579 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\u00d7\u0004\u000fstock-335125380:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125380\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:148.80:100";
		String payLoad_580 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\u00e1\u0004\u000fstock-335125381:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125381\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:147.86:100";
		String payLoad_581 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\u00ec\u0004\u000fstock-335125382:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125382\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:146.85:100";
		String payLoad_582 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b2\u00f6\u0004\u000fstock-335125383:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125383\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.40:0";
		String payLoad_583 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u0000\u0004\u000fstock-335125384:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125384\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.35:0";
		String payLoad_584 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\n\u0004\u000fstock-335125385:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125385\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.09:0";
		String payLoad_585 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u0014\u0004\u000fstock-335125386:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125386\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.25:0";
		String payLoad_586 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u001e\u0004\u000fstock-335125387:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125387\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.76:0";
		String payLoad_587 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3)\u0004\u000fstock-335125388:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125388\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:66.29:0";
		String payLoad_588 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b33\u0004\u000fstock-335125389:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125389\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.17:0";
		String payLoad_589 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3=\u0004\u000fstock-335125390:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125390\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.78:0";
		String payLoad_590 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3G\u0004\u000fstock-335125391:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125391\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:147.39:100";
		String payLoad_591 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3Q\u0004\u000fstock-335125392:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125392\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.83:0";
		String payLoad_592 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\\\u0004\u000fstock-335125393:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125393\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.36:0";
		String payLoad_593 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3f\u0004\u000fstock-335125394:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125394\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.36:0";
		String payLoad_594 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3p\u0004\u000fstock-335125395:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125395\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.34:0";
		String payLoad_595 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3z\u0004\u000fstock-335125396:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125396\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.50:0";
		String payLoad_596 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u0084\u0004\u000fstock-335125397:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125397\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.22:0";
		String payLoad_597 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u008e\u0004\u000fstock-335125398:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125398\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.55:0";
		String payLoad_598 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u0099\u0004\u000fstock-335125399:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125399\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.12:0";
		String payLoad_599 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u00a3\u0004\u000fstock-335125400:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125400\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.96:0";
		String payLoad_600 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u00ad\u0004\u000fstock-335125401:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125401\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.44:0";
		String payLoad_601 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u00b7\u0004\u000fstock-335125402:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125402\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.39:0";
		String payLoad_602 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u00c1\u0004\u000fstock-335125403:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125403\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:103.16:0";
		String payLoad_603 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u00cb\u0004\u000fstock-335125404:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125404\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.26:0";
		String payLoad_604 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u00d6\u0004\u000fstock-335125405:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125405\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.48:0";
		String payLoad_605 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u00e0\u0004\u000fstock-335125406:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125406\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:66.41:0";
		String payLoad_606 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u00ea\u0004\u000fstock-335125407:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125407\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.83:0";
		String payLoad_607 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u00f4\u0004\u000fstock-335125408:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125408\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.11:0";
		String payLoad_608 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b3\u00fe\u0004\u000fstock-335125409:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125409\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.04:0";
		String payLoad_609 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u0008\u0004\u000fstock-335125410:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125410\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:66.19:0";
		String payLoad_610 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u0013\u0004\u000fstock-335125411:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125411\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:102.56:0";
		String payLoad_611 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u001d\u0004\u000fstock-335125412:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125412\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:102.20:0";
		String payLoad_612 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4'\u0004\u000fstock-335125413:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125413\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.99:0";
		String payLoad_613 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b41\u0004\u000fstock-335125414:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125414\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.80:0";
		String payLoad_614 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4;\u0004\u000fstock-335125415:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125415\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:101.58:0";
		String payLoad_615 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4F\u0004\u000fstock-335125416:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125416\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.94:0";
		String payLoad_616 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4P\u0004\u000fstock-335125417:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125417\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.14:0";
		String payLoad_617 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4Z\u0004\u000fstock-335125418:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125418\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.84:0";
		String payLoad_618 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4d\u0004\u000fstock-335125419:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125419\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.64:0";
		String payLoad_619 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4n\u0004\u000fstock-335125420:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125420\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.84:0";
		String payLoad_620 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4x\u0004\u000fstock-335125421:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125421\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.85:0";
		String payLoad_621 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u0083\u0004\u000fstock-335125422:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125422\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:147.26:100";
		String payLoad_622 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u008d\u0004\u000fstock-335125423:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125423\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.91:0";
		String payLoad_623 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u0097\u0004\u000fstock-335125424:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125424\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:101.70:0";
		String payLoad_624 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u00a1\u0004\u000fstock-335125425:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125425\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.61:0";
		String payLoad_625 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u00ab\u0004\u000fstock-335125426:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125426\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.48:0";
		String payLoad_626 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u00b6\u0004\u000fstock-335125427:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125427\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.28:0";
		String payLoad_627 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u00c0\u0004\u000fstock-335125428:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125428\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.84:0";
		String payLoad_628 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u00ca\u0004\u000fstock-335125429:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125429\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.37:0";
		String payLoad_629 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u00d4\u0004\u000fstock-335125430:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125430\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.32:0";
		String payLoad_630 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u00de\u0004\u000fstock-335125431:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125431\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.35:0";
		String payLoad_631 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u00e9\u0004\u000fstock-335125432:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125432\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.21:0";
		String payLoad_632 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u00f3\u0004\u000fstock-335125433:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125433\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.37:0";
		String payLoad_633 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b4\u00fd\u0004\u000fstock-335125434:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125434\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.78:0";
		String payLoad_634 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u0007\u0004\u000fstock-335125435:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125435\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.82:0";
		String payLoad_635 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u0011\u0004\u000fstock-335125436:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125436\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:101.95:0";
		String payLoad_636 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u001c\u0004\u000fstock-335125437:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125437\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:102.54:0";
		String payLoad_637 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5&\u0004\u000fstock-335125438:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125438\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:148.10:100";
		String payLoad_638 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b50\u0004\u000fstock-335125439:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125439\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:146.85:100";
		String payLoad_639 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5:\u0004\u000fstock-335125440:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125440\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.48:0";
		String payLoad_640 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5D\u0004\u000fstock-335125441:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125441\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.43:0";
		String payLoad_641 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5N\u0004\u000fstock-335125442:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125442\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:66.28:0";
		String payLoad_642 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5Y\u0004\u000fstock-335125443:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125443\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:102.27:0";
		String payLoad_643 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5c\u0004\u000fstock-335125444:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125444\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.27:0";
		String payLoad_644 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5m\u0004\u000fstock-335125445:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125445\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.83:0";
		String payLoad_645 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5w\u0004\u000fstock-335125446:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125446\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.30:0";
		String payLoad_646 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u0081\u0004\u000fstock-335125447:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125447\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.88:0";
		String payLoad_647 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u008b\u0004\u000fstock-335125448:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125448\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.79:0";
		String payLoad_648 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u0096\u0004\u000fstock-335125449:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125449\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.43:0";
		String payLoad_649 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u00a0\u0004\u000fstock-335125450:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125450\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:101.75:0";
		String payLoad_650 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u00aa\u0004\u000fstock-335125451:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125451\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:101.76:0";
		String payLoad_651 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u00b4\u0004\u000fstock-335125452:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125452\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.51:0";
		String payLoad_652 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u00be\u0004\u000fstock-335125453:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125453\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.95:0";
		String payLoad_653 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u00c9\u0004\u000fstock-335125454:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125454\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:66.71:0";
		String payLoad_654 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u00d3\u0004\u000fstock-335125455:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125455\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.65:0";
		String payLoad_655 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u00dd\u0004\u000fstock-335125456:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125456\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.37:0";
		String payLoad_656 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u00e7\u0004\u000fstock-335125457:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125457\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:100.76:0";
		String payLoad_657 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u00f1\u0004\u000fstock-335125458:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125458\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:8.02:0";
		String payLoad_658 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b5\u00fb\u0004\u000fstock-335125459:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125459\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.45:0";
		String payLoad_659 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u0006\u0004\u000fstock-335125460:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125460\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:146.46:100";
		String payLoad_660 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u0010\u0004\u000fstock-335125461:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125461\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:100.84:0";
		String payLoad_661 = " \u00c2\u00a8\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u001a\u0004\u000fstock-335125462:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125462\u0001\u00b0\u0006symbol\u0003IBM,International Business Machines:IBM:100.19:0";
		String payLoad_662 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6$\u0004\u000fstock-335125463:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125463\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.17:0";
		String payLoad_663 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6.\u0004\u000fstock-335125464:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125464\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.97:0";
		String payLoad_664 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b68\u0004\u000fstock-335125465:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125465\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.82:0";
		String payLoad_665 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6C\u0004\u000fstock-335125466:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125466\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:66.24:0";
		String payLoad_666 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6M\u0004\u000fstock-335125467:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125467\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:66.16:0";
		String payLoad_667 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6W\u0004\u000fstock-335125468:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125468\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.05:0";
		String payLoad_668 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6a\u0004\u000fstock-335125469:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125469\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.05:0";
		String payLoad_669 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6k\u0004\u000fstock-335125470:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125470\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.56:0";
		String payLoad_670 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6v\u0004\u000fstock-335125471:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125471\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.16:0";
		String payLoad_671 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u0080\u0004\u000fstock-335125472:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125472\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.79:0";
		String payLoad_672 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u008a\u0004\u000fstock-335125473:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125473\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:145.09:100";
		String payLoad_673 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u0094\u0004\u000fstock-335125474:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125474\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.23:0";
		String payLoad_674 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u009e\u0004\u000fstock-335125475:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125475\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.26:0";
		String payLoad_675 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u00a8\u0004\u000fstock-335125476:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125476\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.95:0";
		String payLoad_676 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u00b3\u0004\u000fstock-335125477:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125477\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.15:0";
		String payLoad_677 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u00bd\u0004\u000fstock-335125478:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125478\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.59:0";
		String payLoad_678 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u00c7\u0004\u000fstock-335125479:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125479\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:31.11:0";
		String payLoad_679 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u00d1\u0004\u000fstock-335125480:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125480\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.21:0";
		String payLoad_680 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u00db\u0004\u000fstock-335125481:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125481\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:66.24:0";
		String payLoad_681 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u00e5\u0004\u000fstock-335125482:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125482\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.64:0";
		String payLoad_682 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u00f0\u0004\u000fstock-335125483:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125483\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.69:0";
		String payLoad_683 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b6\u00fa\u0004\u000fstock-335125484:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125484\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.78:0";
		String payLoad_684 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u0004\u0004\u000fstock-335125485:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125485\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.64:0";
		String payLoad_685 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u000e\u0004\u000fstock-335125486:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125486\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.34:0";
		String payLoad_686 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u0018\u0004\u000fstock-335125487:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125487\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:99.52:0";
		String payLoad_687 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7#\u0004\u000fstock-335125488:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125488\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.94:0";
		String payLoad_688 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7-\u0004\u000fstock-335125489:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125489\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:144.01:100";
		String payLoad_689 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b77\u0004\u000fstock-335125490:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125490\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.82:0";
		String payLoad_690 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7A\u0004\u000fstock-335125491:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125491\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:99.55:0";
		String payLoad_691 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7K\u0004\u000fstock-335125492:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125492\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.56:0";
		String payLoad_692 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7V\u0004\u000fstock-335125493:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125493\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:8.00:0";
		String payLoad_693 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7`\u0004\u000fstock-335125494:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125494\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.95:0";
		String payLoad_694 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7j\u0004\u000fstock-335125495:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125495\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.45:0";
		String payLoad_695 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7t\u0004\u000fstock-335125496:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125496\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.27:0";
		String payLoad_696 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7~\u0004\u000fstock-335125497:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125497\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:98.67:0";
		String payLoad_697 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u0088\u0004\u000fstock-335125498:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125498\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:145.34:100";
		String payLoad_698 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u0093\u0004\u000fstock-335125499:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125499\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.04:0";
		String payLoad_699 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u009d\u0004\u000fstock-335125500:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125500\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.54:0";
		String payLoad_700 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u00a7\u0004\u000fstock-335125501:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125501\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:98.51:0";
		String payLoad_701 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u00b1\u0004\u000fstock-335125502:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125502\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.21:0";
		String payLoad_702 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u00bb\u0004\u000fstock-335125503:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125503\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.88:0";
		String payLoad_703 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u00c5\u0004\u000fstock-335125504:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125504\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.24:0";
		String payLoad_704 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u00d0\u0004\u000fstock-335125505:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125505\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.68:0";
		String payLoad_705 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u00da\u0004\u000fstock-335125506:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125506\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.62:0";
		String payLoad_706 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u00e4\u0004\u000fstock-335125507:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125507\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:8.02:0";
		String payLoad_707 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u00ee\u0004\u000fstock-335125508:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125508\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:144.69:100";
		String payLoad_708 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b7\u00f8\u0004\u000fstock-335125509:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125509\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:145.80:100";
		String payLoad_709 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\u0003\u0004\u000fstock-335125510:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125510\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.78:0";
		String payLoad_710 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\r\u0004\u000fstock-335125511:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125511\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:147.01:100";
		String payLoad_711 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\u0017\u0004\u000fstock-335125512:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125512\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.15:0";
		String payLoad_712 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8!\u0004\u000fstock-335125513:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125513\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.65:0";
		String payLoad_713 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8+\u0004\u000fstock-335125514:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125514\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.76:0";
		String payLoad_714 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b85\u0004\u000fstock-335125515:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125515\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.44:0";
		String payLoad_715 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8@\u0004\u000fstock-335125516:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125516\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.40:0";
		String payLoad_716 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8J\u0004\u000fstock-335125517:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125517\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:98.10:0";
		String payLoad_717 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8T\u0004\u000fstock-335125518:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125518\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.85:0";
		String payLoad_718 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8^\u0004\u000fstock-335125519:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125519\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.75:0";
		String payLoad_719 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8h\u0004\u000fstock-335125520:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125520\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.01:0";
		String payLoad_720 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8s\u0004\u000fstock-335125521:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125521\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.50:0";
		String payLoad_721 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8}\u0004\u000fstock-335125522:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125522\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.76:0";
		String payLoad_722 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\u0087\u0004\u000fstock-335125523:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125523\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:66.12:0";
		String payLoad_723 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\u0091\u0004\u000fstock-335125524:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125524\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.16:0";
		String payLoad_724 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\u009b\u0004\u000fstock-335125525:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125525\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.71:0";
		String payLoad_725 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\u00a6\u0004\u000fstock-335125526:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125526\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:146.28:100";
		String payLoad_726 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\u00b0\u0004\u000fstock-335125527:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125527\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.75:0";
		String payLoad_727 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\u00ba\u0004\u000fstock-335125528:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125528\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.38:0";
		String payLoad_728 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\u00c4\u0004\u000fstock-335125529:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125529\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:38.12:0";
		String payLoad_729 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\u00ce\u0004\u000fstock-335125530:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125530\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.60:0";
		String payLoad_730 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\u00d8\u0004\u000fstock-335125531:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125531\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.98:0";
		String payLoad_731 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\u00e3\u0004\u000fstock-335125532:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125532\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.76:0";
		String payLoad_732 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\u00ed\u0004\u000fstock-335125533:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125533\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:145.77:100";
		String payLoad_733 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b8\u00f7\u0004\u000fstock-335125534:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125534\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.48:0";
		String payLoad_734 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u0001\u0004\u000fstock-335125535:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125535\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.21:0";
		String payLoad_735 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u000b\u0004\u000fstock-335125536:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125536\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.30:0";
		String payLoad_736 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u0015\u0004\u000fstock-335125537:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125537\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.32:0";
		String payLoad_737 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9 \u0004\u000fstock-335125538:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125538\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.72:0";
		String payLoad_738 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9*\u0004\u000fstock-335125539:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125539\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.78:0";
		String payLoad_739 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b94\u0004\u000fstock-335125540:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125540\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:144.62:100";
		String payLoad_740 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9>\u0004\u000fstock-335125541:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125541\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.34:0";
		String payLoad_741 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9H\u0004\u000fstock-335125542:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125542\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.36:0";
		String payLoad_742 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9S\u0004\u000fstock-335125543:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125543\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:98.56:0";
		String payLoad_743 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9]\u0004\u000fstock-335125544:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125544\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:8.03:0";
		String payLoad_744 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9g\u0004\u000fstock-335125545:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125545\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.28:0";
		String payLoad_745 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9q\u0004\u000fstock-335125546:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125546\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.76:0";
		String payLoad_746 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9{\u0004\u000fstock-335125547:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125547\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.21:0";
		String payLoad_747 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u0085\u0004\u000fstock-335125548:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125548\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.29:0";
		String payLoad_748 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u0090\u0004\u000fstock-335125549:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125549\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.48:0";
		String payLoad_749 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u009a\u0004\u000fstock-335125550:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125550\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:143.79:100";
		String payLoad_750 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u00a4\u0004\u000fstock-335125551:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125551\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:143.68:100";
		String payLoad_751 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u00ae\u0004\u000fstock-335125552:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125552\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.27:0";
		String payLoad_752 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u00b8\u0004\u000fstock-335125553:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125553\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.13:0";
		String payLoad_753 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u00c3\u0004\u000fstock-335125554:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125554\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.79:0";
		String payLoad_754 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u00cd\u0004\u000fstock-335125555:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125555\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.77:0";
		String payLoad_755 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u00d7\u0004\u000fstock-335125556:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125556\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.27:0";
		String payLoad_756 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u00e1\u0004\u000fstock-335125557:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125557\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.78:0";
		String payLoad_757 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u00eb\u0004\u000fstock-335125558:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125558\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.11:0";
		String payLoad_758 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00b9\u00f5\u0004\u000fstock-335125559:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125559\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:145.00:100";
		String payLoad_759 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u0000\u0004\u000fstock-335125560:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125560\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:98.80:0";
		String payLoad_760 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\n\u0004\u000fstock-335125561:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125561\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.76:0";
		String payLoad_761 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u0014\u0004\u000fstock-335125562:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125562\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.59:0";
		String payLoad_762 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u001e\u0004\u000fstock-335125563:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125563\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.22:0";
		String payLoad_763 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba(\u0004\u000fstock-335125564:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125564\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.77:0";
		String payLoad_764 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba2\u0004\u000fstock-335125565:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125565\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:98.85:0";
		String payLoad_765 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba=\u0004\u000fstock-335125566:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125566\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.32:0";
		String payLoad_766 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00baG\u0004\u000fstock-335125567:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125567\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.28:0";
		String payLoad_767 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00baQ\u0004\u000fstock-335125568:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125568\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:8.08:0";
		String payLoad_768 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba[\u0004\u000fstock-335125569:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125569\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.13:0";
		String payLoad_769 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bae\u0004\u000fstock-335125570:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125570\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:99.40:0";
		String payLoad_770 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bap\u0004\u000fstock-335125571:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125571\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.99:0";
		String payLoad_771 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00baz\u0004\u000fstock-335125572:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125572\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.75:0";
		String payLoad_772 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u0084\u0004\u000fstock-335125573:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125573\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.16:0";
		String payLoad_773 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u008e\u0004\u000fstock-335125574:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125574\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.04:0";
		String payLoad_774 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u0098\u0004\u000fstock-335125575:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125575\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.23:0";
		String payLoad_775 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u00a2\u0004\u000fstock-335125576:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125576\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.67:0";
		String payLoad_776 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u00ad\u0004\u000fstock-335125577:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125577\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:36.93:0";
		String payLoad_777 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u00b7\u0004\u000fstock-335125578:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125578\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.78:0";
		String payLoad_778 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u00c1\u0004\u000fstock-335125579:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125579\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.91:0";
		String payLoad_779 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u00cb\u0004\u000fstock-335125580:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125580\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.24:0";
		String payLoad_780 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u00d5\u0004\u000fstock-335125581:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125581\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:8.02:0";
		String payLoad_781 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u00e0\u0004\u000fstock-335125582:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125582\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.11:0";
		String payLoad_782 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u00eb\u0004\u000fstock-335125583:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125583\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.74:0";
		String payLoad_783 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u00f5\u0004\u000fstock-335125584:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125584\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.72:0";
		String payLoad_784 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00ba\u00ff\u0004\u000fstock-335125585:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125585\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.92:0";
		String payLoad_785 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\t\u0004\u000fstock-335125586:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125586\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.94:0";
		String payLoad_786 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u0013\u0004\u000fstock-335125587:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125587\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.05:0";
		String payLoad_787 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u001d\u0004\u000fstock-335125588:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125588\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:144.63:100";
		String payLoad_788 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb(\u0004\u000fstock-335125589:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125589\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.64:0";
		String payLoad_789 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb2\u0004\u000fstock-335125590:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125590\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.10:0";
		String payLoad_790 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb<\u0004\u000fstock-335125591:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125591\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:143.88:100";
		String payLoad_791 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bbF\u0004\u000fstock-335125592:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125592\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.17:0";
		String payLoad_792 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bbP\u0004\u000fstock-335125593:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125593\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.00:0";
		String payLoad_793 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bbZ\u0004\u000fstock-335125594:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125594\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.96:0";
		String payLoad_794 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bbe\u0004\u000fstock-335125595:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125595\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.03:0";
		String payLoad_795 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bbo\u0004\u000fstock-335125596:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125596\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.05:0";
		String payLoad_796 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bby\u0004\u000fstock-335125597:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125597\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.73:0";
		String payLoad_797 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u0083\u0004\u000fstock-335125598:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125598\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.81:0";
		String payLoad_798 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u008d\u0004\u000fstock-335125599:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125599\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:99.21:0";
		String payLoad_799 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u0098\u0004\u000fstock-335125600:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125600\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.91:0";
		String payLoad_800 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u00a2\u0004\u000fstock-335125601:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125601\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.04:0";
		String payLoad_801 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u00ac\u0004\u000fstock-335125602:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125602\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:66.06:0";
		String payLoad_802 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u00b6\u0004\u000fstock-335125603:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125603\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:25.98:0";
		String payLoad_803 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u00c0\u0004\u000fstock-335125604:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125604\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.52:0";
		String payLoad_804 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u00ca\u0004\u000fstock-335125605:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125605\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.03:0";
		String payLoad_805 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u00d5\u0004\u000fstock-335125606:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125606\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.12:0";
		String payLoad_806 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u00df\u0004\u000fstock-335125607:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125607\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:115.15:0";
		String payLoad_807 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u00e9\u0004\u000fstock-335125608:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125608\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.08:0";
		String payLoad_808 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u00f3\u0004\u000fstock-335125609:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125609\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:143.21:100";
		String payLoad_809 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bb\u00fd\u0004\u000fstock-335125610:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125610\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.02:0";
		String payLoad_810 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u0008\u0004\u000fstock-335125611:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125611\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.53:0";
		String payLoad_811 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u0012\u0004\u000fstock-335125612:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125612\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:98.59:0";
		String payLoad_812 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u001c\u0004\u000fstock-335125613:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125613\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.15:0";
		String payLoad_813 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc&\u0004\u000fstock-335125614:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125614\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.74:0";
		String payLoad_814 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc0\u0004\u000fstock-335125615:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125615\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.00:0";
		String payLoad_815 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc:\u0004\u000fstock-335125616:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125616\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.95:0";
		String payLoad_816 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bcE\u0004\u000fstock-335125617:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125617\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:97.71:0";
		String payLoad_817 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bcO\u0004\u000fstock-335125618:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125618\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:115.47:0";
		String payLoad_818 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bcY\u0004\u000fstock-335125619:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125619\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:97.05:0";
		String payLoad_819 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bcc\u0004\u000fstock-335125620:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125620\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:142.64:100";
		String payLoad_820 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bcm\u0004\u000fstock-335125621:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125621\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.97:0";
		String payLoad_821 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bcw\u0004\u000fstock-335125622:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125622\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:97.55:0";
		String payLoad_822 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u0082\u0004\u000fstock-335125623:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125623\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:66.32:0";
		String payLoad_823 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u008c\u0004\u000fstock-335125624:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125624\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.39:0";
		String payLoad_824 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u0096\u0004\u000fstock-335125625:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125625\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:143.36:100";
		String payLoad_825 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u00a0\u0004\u000fstock-335125626:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125626\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.29:0";
		String payLoad_826 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u00aa\u0004\u000fstock-335125627:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125627\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.21:0";
		String payLoad_827 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u00b4\u0004\u000fstock-335125628:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125628\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.99:0";
		String payLoad_828 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u00bf\u0004\u000fstock-335125629:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125629\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:8.06:0";
		String payLoad_829 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u00c9\u0004\u000fstock-335125630:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125630\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.69:0";
		String payLoad_830 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u00d3\u0004\u000fstock-335125631:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125631\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.23:0";
		String payLoad_831 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u00dd\u0004\u000fstock-335125632:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125632\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:8.05:0";
		String payLoad_832 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u00e7\u0004\u000fstock-335125633:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125633\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.45:0";
		String payLoad_833 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u00f2\u0004\u000fstock-335125634:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125634\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:143.69:100";
		String payLoad_834 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bc\u00fc\u0004\u000fstock-335125635:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125635\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.48:0";
		String payLoad_835 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u0006\u0004\u000fstock-335125636:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125636\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.72:0";
		String payLoad_836 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u0010\u0004\u000fstock-335125637:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125637\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:143.86:100";
		String payLoad_837 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u001a\u0004\u000fstock-335125638:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125638\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:8.03:0";
		String payLoad_838 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd$\u0004\u000fstock-335125639:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125639\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:66.07:0";
		String payLoad_839 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd/\u0004\u000fstock-335125640:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125640\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.36:0";
		String payLoad_840 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd9\u0004\u000fstock-335125641:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125641\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.84:0";
		String payLoad_841 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bdC\u0004\u000fstock-335125642:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125642\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.66:0";
		String payLoad_842 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bdM\u0004\u000fstock-335125643:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125643\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.14:0";
		String payLoad_843 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bdW\u0004\u000fstock-335125644:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125644\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.30:0";
		String payLoad_844 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bda\u0004\u000fstock-335125645:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125645\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.33:0";
		String payLoad_845 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bdl\u0004\u000fstock-335125646:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125646\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.28:0";
		String payLoad_846 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bdv\u0004\u000fstock-335125647:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125647\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.23:0";
		String payLoad_847 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u0080\u0004\u000fstock-335125648:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125648\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.71:0";
		String payLoad_848 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u008a\u0004\u000fstock-335125649:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125649\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:111.64:0";
		String payLoad_849 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u0095\u0004\u000fstock-335125650:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125650\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.03:0";
		String payLoad_850 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u009f\u0004\u000fstock-335125651:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125651\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.98:0";
		String payLoad_851 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u00a9\u0004\u000fstock-335125652:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125652\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.26:0";
		String payLoad_852 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u00b3\u0004\u000fstock-335125653:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125653\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.56:0";
		String payLoad_853 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u00bd\u0004\u000fstock-335125654:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125654\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.25:0";
		String payLoad_854 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u00c7\u0004\u000fstock-335125655:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125655\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:96.66:0";
		String payLoad_855 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u00d2\u0004\u000fstock-335125656:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125656\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.69:0";
		String payLoad_856 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u00dc\u0004\u000fstock-335125657:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125657\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.20:0";
		String payLoad_857 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u00e6\u0004\u000fstock-335125658:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125658\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.05:0";
		String payLoad_858 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u00f0\u0004\u000fstock-335125659:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125659\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.13:0";
		String payLoad_859 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bd\u00fa\u0004\u000fstock-335125660:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125660\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.03:0";
		String payLoad_860 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u0005\u0004\u000fstock-335125661:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125661\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.81:0";
		String payLoad_861 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u000f\u0004\u000fstock-335125662:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125662\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.28:0";
		String payLoad_862 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u0019\u0004\u000fstock-335125663:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125663\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.32:0";
		String payLoad_863 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be#\u0004\u000fstock-335125664:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125664\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.24:0";
		String payLoad_864 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be-\u0004\u000fstock-335125665:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125665\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.34:0";
		String payLoad_865 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be7\u0004\u000fstock-335125666:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125666\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.67:0";
		String payLoad_866 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00beB\u0004\u000fstock-335125667:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125667\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.92:0";
		String payLoad_867 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00beL\u0004\u000fstock-335125668:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125668\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.11:0";
		String payLoad_868 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00beV\u0004\u000fstock-335125669:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125669\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:145.02:100";
		String payLoad_869 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be`\u0004\u000fstock-335125670:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125670\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:97.37:0";
		String payLoad_870 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bej\u0004\u000fstock-335125671:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125671\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.55:0";
		String payLoad_871 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bet\u0004\u000fstock-335125672:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125672\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.16:0";
		String payLoad_872 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u007f\u0004\u000fstock-335125673:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125673\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.25:0";
		String payLoad_873 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u0089\u0004\u000fstock-335125674:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125674\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.88:0";
		String payLoad_874 = "\u0001\u0001\u0001\u0002\t\u0000";
		String payLoad_875 = "\u0001\u0001\u0001\u0002\n\u0000";
		String payLoad_876 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u0093\u0004\u000fstock-335125675:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125675\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.70:0";
		String payLoad_877 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u009d\u0004\u000fstock-335125676:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125676\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.29:0";
		String payLoad_878 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u00a7\u0004\u000fstock-335125677:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125677\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.86:0";
		String payLoad_879 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u00b1\u0004\u000fstock-335125678:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125678\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.72:0";
		String payLoad_880 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u00bb\u0004\u000fstock-335125679:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125679\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:144.73:100";
		String payLoad_881 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u00c6\u0004\u000fstock-335125680:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125680\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:97.41:0";
		String payLoad_882 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u00d0\u0004\u000fstock-335125681:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125681\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.37:0";
		String payLoad_883 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u00da\u0004\u000fstock-335125682:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125682\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.23:0";
		String payLoad_884 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u00e4\u0004\u000fstock-335125683:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125683\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.71:0";
		String payLoad_885 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u00ee\u0004\u000fstock-335125684:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125684\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.70:0";
		String payLoad_886 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00be\u00f9\u0004\u000fstock-335125685:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125685\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.17:0";
		String payLoad_887 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\u0003\u0004\u000fstock-335125686:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125686\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.10:0";
		String payLoad_888 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\r\u0004\u000fstock-335125687:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125687\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.26:0";
		String payLoad_889 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\u0017\u0004\u000fstock-335125688:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125688\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:145.27:100";
		String payLoad_890 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf!\u0004\u000fstock-335125689:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125689\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.11:0";
		String payLoad_891 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf+\u0004\u000fstock-335125690:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125690\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:98.30:0";
		String payLoad_892 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf5\u0004\u000fstock-335125691:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125691\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.88:0";
		String payLoad_893 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf@\u0004\u000fstock-335125692:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125692\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.90:0";
		String payLoad_894 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bfJ\u0004\u000fstock-335125693:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125693\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:112.04:0";
		String payLoad_895 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bfT\u0004\u000fstock-335125694:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125694\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.98:0";
		String payLoad_896 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf^\u0004\u000fstock-335125695:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125695\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.95:0";
		String payLoad_897 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bfh\u0004\u000fstock-335125696:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125696\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.54:0";
		String payLoad_898 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bfr\u0004\u000fstock-335125697:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125697\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.59:0";
		String payLoad_899 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf}\u0004\u000fstock-335125698:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125698\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.18:0";
		String payLoad_900 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\u0087\u0004\u000fstock-335125699:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125699\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.66:0";
		String payLoad_901 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\u0091\u0004\u000fstock-335125700:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125700\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:99.02:0";
		String payLoad_902 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\u009b\u0004\u000fstock-335125701:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125701\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:65.58:0";
		String payLoad_903 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\u00a5\u0004\u000fstock-335125702:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125702\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.83:0";
		String payLoad_904 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\u00b0\u0004\u000fstock-335125703:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125703\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.94:0";
		String payLoad_905 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\u00ba\u0004\u000fstock-335125704:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125704\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.94:0";
		String payLoad_906 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\u00c4\u0004\u000fstock-335125705:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125705\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.56:0";
		String payLoad_907 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\u00ce\u0004\u000fstock-335125706:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125706\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.71:0";
		String payLoad_908 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\u00d8\u0004\u000fstock-335125707:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125707\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.26:0";
		String payLoad_909 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\u00e2\u0004\u000fstock-335125708:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125708\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:145.86:100";
		String payLoad_910 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\u00ed\u0004\u000fstock-335125709:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125709\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.58:0";
		String payLoad_911 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00bf\u00f7\u0004\u000fstock-335125710:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125710\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.32:0";
		String payLoad_912 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u0001\u0004\u000fstock-335125711:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125711\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:146.27:100";
		String payLoad_913 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u000b\u0004\u000fstock-335125712:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125712\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.95:0";
		String payLoad_914 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u0015\u0004\u000fstock-335125713:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125713\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.94:0";
		String payLoad_915 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u001f\u0004\u000fstock-335125714:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125714\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.00:0";
		String payLoad_916 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0*\u0004\u000fstock-335125715:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125715\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.70:0";
		String payLoad_917 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c04\u0004\u000fstock-335125716:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125716\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.53:0";
		String payLoad_918 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0>\u0004\u000fstock-335125717:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125717\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:98.36:0";
		String payLoad_919 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0H\u0004\u000fstock-335125718:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125718\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.70:0";
		String payLoad_920 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0R\u0004\u000fstock-335125719:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125719\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.80:0";
		String payLoad_921 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\\\u0004\u000fstock-335125720:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125720\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.88:0";
		String payLoad_922 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0g\u0004\u000fstock-335125721:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125721\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.36:0";
		String payLoad_923 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0q\u0004\u000fstock-335125722:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125722\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.88:0";
		String payLoad_924 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0{\u0004\u000fstock-335125723:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125723\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.91:0";
		String payLoad_925 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u0085\u0004\u000fstock-335125724:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125724\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:145.29:100";
		String payLoad_926 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u008f\u0004\u000fstock-335125725:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125725\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.24:0";
		String payLoad_927 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u0099\u0004\u000fstock-335125726:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125726\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.21:0";
		String payLoad_928 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u00a4\u0004\u000fstock-335125727:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125727\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.68:0";
		String payLoad_929 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u00ae\u0004\u000fstock-335125728:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125728\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:30.02:0";
		String payLoad_930 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u00b8\u0004\u000fstock-335125729:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125729\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:145.33:100";
		String payLoad_931 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u00c2\u0004\u000fstock-335125730:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125730\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:145.59:100";
		String payLoad_932 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u00cc\u0004\u000fstock-335125731:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125731\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:98.16:0";
		String payLoad_933 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u00d6\u0004\u000fstock-335125732:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125732\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:115.41:0";
		String payLoad_934 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u00e1\u0004\u000fstock-335125733:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125733\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:97.98:0";
		String payLoad_935 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u00eb\u0004\u000fstock-335125734:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125734\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.91:0";
		String payLoad_936 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u00f5\u0004\u000fstock-335125735:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125735\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:15.09:0";
		String payLoad_937 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c0\u00ff\u0004\u000fstock-335125736:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125736\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.74:0";
		String payLoad_938 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\t\u0004\u000fstock-335125737:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125737\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.97:0";
		String payLoad_939 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u0014\u0004\u000fstock-335125738:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125738\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.70:0";
		String payLoad_940 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u001e\u0004\u000fstock-335125739:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125739\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.90:0";
		String payLoad_941 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1(\u0004\u000fstock-335125740:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125740\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.91:0";
		String payLoad_942 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c12\u0004\u000fstock-335125741:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125741\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.96:0";
		String payLoad_943 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1<\u0004\u000fstock-335125742:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125742\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.89:0";
		String payLoad_944 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1F\u0004\u000fstock-335125743:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125743\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.61:0";
		String payLoad_945 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1Q\u0004\u000fstock-335125744:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125744\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.34:0";
		String payLoad_946 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1[\u0004\u000fstock-335125745:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125745\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.69:0";
		String payLoad_947 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1e\u0004\u000fstock-335125746:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125746\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.09:0";
		String payLoad_948 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1o\u0004\u000fstock-335125747:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125747\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.25:0";
		String payLoad_949 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1y\u0004\u000fstock-335125748:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125748\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:97.15:0";
		String payLoad_950 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u0084\u0004\u000fstock-335125749:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125749\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.21:0";
		String payLoad_951 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u008e\u0004\u000fstock-335125750:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125750\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.86:0";
		String payLoad_952 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u0098\u0004\u000fstock-335125751:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125751\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.70:0";
		String payLoad_953 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u00a2\u0004\u000fstock-335125752:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125752\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:145.31:100";
		String payLoad_954 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u00ac\u0004\u000fstock-335125753:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125753\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.23:0";
		String payLoad_955 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u00b6\u0004\u000fstock-335125754:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125754\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.32:0";
		String payLoad_956 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u00c1\u0004\u000fstock-335125755:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125755\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.55:0";
		String payLoad_957 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u00cb\u0004\u000fstock-335125756:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125756\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.49:0";
		String payLoad_958 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u00d5\u0004\u000fstock-335125757:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125757\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.72:0";
		String payLoad_959 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u00df\u0004\u000fstock-335125758:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125758\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:146.08:100";
		String payLoad_960 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u00e9\u0004\u000fstock-335125759:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125759\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.73:0";
		String payLoad_961 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u00f4\u0004\u000fstock-335125760:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125760\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:145.54:100";
		String payLoad_962 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c1\u00fe\u0004\u000fstock-335125761:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125761\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.28:0";
		String payLoad_963 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2\u0008\u0004\u000fstock-335125762:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125762\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.87:0";
		String payLoad_964 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2\u0012\u0004\u000fstock-335125763:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125763\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.70:0";
		String payLoad_965 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2\u001c\u0004\u000fstock-335125764:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125764\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.19:0";
		String payLoad_966 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2&\u0004\u000fstock-335125765:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125765\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.27:0";
		String payLoad_967 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c21\u0004\u000fstock-335125766:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125766\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:113.87:0";
		String payLoad_968 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2;\u0004\u000fstock-335125767:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125767\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.17:0";
		String payLoad_969 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2E\u0004\u000fstock-335125768:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125768\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:146.23:100";
		String payLoad_970 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2O\u0004\u000fstock-335125769:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125769\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.20:0";
		String payLoad_971 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2Y\u0004\u000fstock-335125770:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125770\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.15:0";
		String payLoad_972 = " \u00c2\u009e\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2c\u0004\u000fstock-335125771:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125771\u0001\u00b0\u0006symbol\u0003MCD\"McDonald's Corporation:MCD:29.37:0";
		String payLoad_973 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2n\u0004\u000fstock-335125772:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125772\u0001\u00b0\u0006symbol\u0002BA\u0015Boeing Co.:BA:14.91:0";
		String payLoad_974 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2x\u0004\u000fstock-335125773:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125773\u0001\u00b0\u0006symbol\u0002VZ\"Verizon Communications:VZ:114.89:0";
		String payLoad_975 = "\u0003\u00e9";
		String payLoad_976 = " \u00c2\u009d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2\u0082\u0004\u000fstock-335125774:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125774\u0001\u00b0\u0006symbol\u0003WMT!Wal-Mart Stores, Inc.:WMT:37.57:0";
		String payLoad_977 = " \u00c2\u0090\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2\u008c\u0004\u000fstock-335125775:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125775\u0001\u00b0\u0006symbol\u0003MMM\u00143m Co:MMM:146.56:100";
		String payLoad_978 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2\u0096\u0004\u000fstock-335125776:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125776\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:26.75:0";
		String payLoad_979 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2\u00a0\u0004\u000fstock-335125777:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125777\u0001\u00b0\u0006symbol\u0003HPQ\u001eHewlett-Packard Co.:HPQ:7.88:0";
		String payLoad_980 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2\u00ab\u0004\u000fstock-335125778:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125778\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.19:0";
		String payLoad_981 = " \u00c2\u00a7\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2\u00b5\u0004\u000fstock-335125779:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125779\u0001\u00b0\u0006symbol\u0003IBM+International Business Machines:IBM:97.57:0";
		String payLoad_982 = " \u00c2\u009f\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2\u00bf\u0004\u000fstock-335125780:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125780\u0001\u00b0\u0006symbol\u0004MSFT\"Microsoft Corporation:MSFT:27.01:0";
		String payLoad_983 = " \u00c2\u008d\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2\u00c9\u0004\u000fstock-335125781:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125781\u0001\u00b0\u0006symbol\u0001T\u0013AT&T Inc.:T:13.11:0";
		String payLoad_984 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2\u00d3\u0004\u000fstock-335125782:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125782\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.30:0";
		String payLoad_985 = " \u00c2\u0093\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2\u00dd\u0004\u000fstock-335125783:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125783\u0001\u00b0\u0006symbol\u0001C\u0019Citigroup, Inc.:C:64.09:0";
		String payLoad_986 = " \u00c2\u009a\u00c9\u0089\u0015/topic/portfolioStock\u00b8\u0005\u0000\u0000\u0001V\u008fQ\u00c2\u00e8\u0004\u000fstock-335125784:ID:demo2.kaazing.com-35242-1467850762420-1:1:1:1:335125784\u0001\u00b0\u0006symbol\u0004INTC\u001dIntel Corporation:INTC:2.68:0";
		String payLoad_987 = "\u0003\u00e9";


		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305196L,1471283305196L , "UTF-8" , payLoad_0 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1471283305198L,1471283305198L , "UTF-8" , payLoad_1 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305313L,1471283305314L , "UTF-8" , payLoad_2 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305314L,1471283305314L , "UTF-8" , payLoad_3 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305315L,1471283305315L , "UTF-8" , payLoad_4 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 2 , 1471283305334L,1471283305334L , "UTF-8" , payLoad_5 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305443L,1471283305443L , "UTF-8" , payLoad_6 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 2 , 1471283305461L,1471283305461L , "ISO-8859-1" , payLoad_7 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 2 , 1471283305462L,1471283305463L , "ISO-8859-1" , payLoad_8 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 2 , 1471283305468L,1471283305468L , "ISO-8859-1" , payLoad_9 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305572L,1471283305572L , "ISO-8859-1" , payLoad_10 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305682L,1471283305683L , "ISO-8859-1" , payLoad_11 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305684L,1471283305685L , "ISO-8859-1" , payLoad_12 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305688L,1471283305688L , "ISO-8859-1" , payLoad_13 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305688L,1471283305688L , "ISO-8859-1" , payLoad_14 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305693L,1471283305693L , "ISO-8859-1" , payLoad_15 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305703L,1471283305703L , "ISO-8859-1" , payLoad_16 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305713L,1471283305714L , "ISO-8859-1" , payLoad_17 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305724L,1471283305725L , "ISO-8859-1" , payLoad_18 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305734L,1471283305734L , "ISO-8859-1" , payLoad_19 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305744L,1471283305745L , "ISO-8859-1" , payLoad_20 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 2 , 1471283305785L,1471283305786L , "ISO-8859-1" , payLoad_21 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305790L,1471283305790L , "ISO-8859-1" , payLoad_22 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305791L,1471283305791L , "ISO-8859-1" , payLoad_23 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305791L,1471283305791L , "ISO-8859-1" , payLoad_24 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305791L,1471283305791L , "ISO-8859-1" , payLoad_25 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305795L,1471283305795L , "ISO-8859-1" , payLoad_26 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305810L,1471283305810L , "ISO-8859-1" , payLoad_27 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305815L,1471283305816L , "ISO-8859-1" , payLoad_28 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305825L,1471283305825L , "ISO-8859-1" , payLoad_29 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305835L,1471283305835L , "ISO-8859-1" , payLoad_30 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305845L,1471283305845L , "ISO-8859-1" , payLoad_31 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305855L,1471283305856L , "ISO-8859-1" , payLoad_32 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305866L,1471283305866L , "ISO-8859-1" , payLoad_33 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305876L,1471283305876L , "ISO-8859-1" , payLoad_34 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305887L,1471283305887L , "ISO-8859-1" , payLoad_35 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305896L,1471283305896L , "ISO-8859-1" , payLoad_36 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305897L,1471283305897L , "ISO-8859-1" , payLoad_37 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305908L,1471283305908L , "ISO-8859-1" , payLoad_38 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305916L,1471283305917L , "ISO-8859-1" , payLoad_39 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 2 , 1471283305918L,1471283305918L , "ISO-8859-1" , payLoad_40 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305927L,1471283305927L , "ISO-8859-1" , payLoad_41 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305938L,1471283305938L , "ISO-8859-1" , payLoad_42 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305947L,1471283305947L , "ISO-8859-1" , payLoad_43 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305958L,1471283305960L , "ISO-8859-1" , payLoad_44 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305968L,1471283305968L , "ISO-8859-1" , payLoad_45 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305979L,1471283305980L , "ISO-8859-1" , payLoad_46 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305989L,1471283305990L , "ISO-8859-1" , payLoad_47 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283305999L,1471283305999L , "ISO-8859-1" , payLoad_48 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306008L,1471283306009L , "ISO-8859-1" , payLoad_49 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306021L,1471283306021L , "ISO-8859-1" , payLoad_50 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306028L,1471283306029L , "ISO-8859-1" , payLoad_51 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306030L,1471283306030L , "ISO-8859-1" , payLoad_52 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306030L,1471283306031L , "ISO-8859-1" , payLoad_53 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306040L,1471283306041L , "ISO-8859-1" , payLoad_54 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306049L,1471283306049L , "ISO-8859-1" , payLoad_55 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306118L,1471283306120L , "ISO-8859-1" , payLoad_56 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306122L,1471283306122L , "ISO-8859-1" , payLoad_57 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306123L,1471283306123L , "ISO-8859-1" , payLoad_58 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306125L,1471283306125L , "ISO-8859-1" , payLoad_59 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306126L,1471283306126L , "ISO-8859-1" , payLoad_60 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306127L,1471283306127L , "ISO-8859-1" , payLoad_61 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306127L,1471283306128L , "ISO-8859-1" , payLoad_62 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306154L,1471283306154L , "ISO-8859-1" , payLoad_63 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306155L,1471283306155L , "ISO-8859-1" , payLoad_64 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306155L,1471283306173L , "ISO-8859-1" , payLoad_65 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306174L,1471283306174L , "ISO-8859-1" , payLoad_66 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306175L,1471283306175L , "ISO-8859-1" , payLoad_67 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306181L,1471283306182L , "ISO-8859-1" , payLoad_68 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 2 , 1471283306194L,1471283306194L , "ISO-8859-1" , payLoad_69 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306195L,1471283306195L , "ISO-8859-1" , payLoad_70 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306202L,1471283306202L , "ISO-8859-1" , payLoad_71 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306212L,1471283306212L , "ISO-8859-1" , payLoad_72 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306224L,1471283306224L , "ISO-8859-1" , payLoad_73 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306232L,1471283306232L , "ISO-8859-1" , payLoad_74 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306242L,1471283306242L , "ISO-8859-1" , payLoad_75 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306252L,1471283306252L , "ISO-8859-1" , payLoad_76 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306263L,1471283306263L , "ISO-8859-1" , payLoad_77 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306273L,1471283306274L , "ISO-8859-1" , payLoad_78 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306283L,1471283306284L , "ISO-8859-1" , payLoad_79 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306293L,1471283306293L , "ISO-8859-1" , payLoad_80 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306303L,1471283306303L , "ISO-8859-1" , payLoad_81 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306303L,1471283306303L , "ISO-8859-1" , payLoad_82 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306313L,1471283306313L , "ISO-8859-1" , payLoad_83 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306325L,1471283306325L , "ISO-8859-1" , payLoad_84 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306334L,1471283306335L , "ISO-8859-1" , payLoad_85 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306344L,1471283306344L , "ISO-8859-1" , payLoad_86 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306355L,1471283306355L , "ISO-8859-1" , payLoad_87 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306366L,1471283306366L , "ISO-8859-1" , payLoad_88 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306375L,1471283306375L , "ISO-8859-1" , payLoad_89 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306385L,1471283306387L , "ISO-8859-1" , payLoad_90 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306395L,1471283306396L , "ISO-8859-1" , payLoad_91 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306406L,1471283306406L , "ISO-8859-1" , payLoad_92 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306415L,1471283306415L , "ISO-8859-1" , payLoad_93 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306427L,1471283306428L , "ISO-8859-1" , payLoad_94 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306435L,1471283306436L , "ISO-8859-1" , payLoad_95 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306448L,1471283306448L , "ISO-8859-1" , payLoad_96 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306457L,1471283306458L , "ISO-8859-1" , payLoad_97 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306466L,1471283306466L , "ISO-8859-1" , payLoad_98 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306476L,1471283306476L , "ISO-8859-1" , payLoad_99 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306487L,1471283306488L , "ISO-8859-1" , payLoad_100 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306497L,1471283306497L , "ISO-8859-1" , payLoad_101 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306508L,1471283306508L , "ISO-8859-1" , payLoad_102 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306517L,1471283306517L , "ISO-8859-1" , payLoad_103 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306531L,1471283306532L , "ISO-8859-1" , payLoad_104 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306539L,1471283306539L , "ISO-8859-1" , payLoad_105 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306548L,1471283306548L , "ISO-8859-1" , payLoad_106 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306559L,1471283306559L , "ISO-8859-1" , payLoad_107 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306568L,1471283306569L , "ISO-8859-1" , payLoad_108 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306580L,1471283306581L , "ISO-8859-1" , payLoad_109 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306589L,1471283306589L , "ISO-8859-1" , payLoad_110 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306599L,1471283306599L , "ISO-8859-1" , payLoad_111 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306609L,1471283306610L , "ISO-8859-1" , payLoad_112 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306619L,1471283306620L , "ISO-8859-1" , payLoad_113 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306632L,1471283306632L , "ISO-8859-1" , payLoad_114 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306640L,1471283306641L , "ISO-8859-1" , payLoad_115 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306652L,1471283306652L , "ISO-8859-1" , payLoad_116 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306660L,1471283306660L , "ISO-8859-1" , payLoad_117 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306670L,1471283306671L , "ISO-8859-1" , payLoad_118 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306680L,1471283306681L , "ISO-8859-1" , payLoad_119 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306691L,1471283306691L , "ISO-8859-1" , payLoad_120 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306700L,1471283306700L , "ISO-8859-1" , payLoad_121 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306711L,1471283306711L , "ISO-8859-1" , payLoad_122 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306721L,1471283306721L , "ISO-8859-1" , payLoad_123 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306731L,1471283306731L , "ISO-8859-1" , payLoad_124 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306741L,1471283306742L , "ISO-8859-1" , payLoad_125 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306751L,1471283306752L , "ISO-8859-1" , payLoad_126 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306761L,1471283306761L , "ISO-8859-1" , payLoad_127 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306772L,1471283306772L , "ISO-8859-1" , payLoad_128 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306781L,1471283306782L , "ISO-8859-1" , payLoad_129 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306792L,1471283306792L , "ISO-8859-1" , payLoad_130 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306803L,1471283306804L , "ISO-8859-1" , payLoad_131 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306812L,1471283306813L , "ISO-8859-1" , payLoad_132 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306822L,1471283306823L , "ISO-8859-1" , payLoad_133 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306832L,1471283306833L , "ISO-8859-1" , payLoad_134 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306843L,1471283306843L , "ISO-8859-1" , payLoad_135 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306853L,1471283306853L , "ISO-8859-1" , payLoad_136 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306863L,1471283306863L , "ISO-8859-1" , payLoad_137 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306875L,1471283306875L , "ISO-8859-1" , payLoad_138 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306883L,1471283306884L , "ISO-8859-1" , payLoad_139 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306894L,1471283306894L , "ISO-8859-1" , payLoad_140 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306904L,1471283306905L , "ISO-8859-1" , payLoad_141 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306914L,1471283306914L , "ISO-8859-1" , payLoad_142 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306924L,1471283306924L , "ISO-8859-1" , payLoad_143 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306934L,1471283306934L , "ISO-8859-1" , payLoad_144 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306944L,1471283306944L , "ISO-8859-1" , payLoad_145 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306954L,1471283306955L , "ISO-8859-1" , payLoad_146 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306967L,1471283306967L , "ISO-8859-1" , payLoad_147 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306975L,1471283306975L , "ISO-8859-1" , payLoad_148 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306985L,1471283306986L , "ISO-8859-1" , payLoad_149 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283306995L,1471283306995L , "ISO-8859-1" , payLoad_150 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307007L,1471283307007L , "ISO-8859-1" , payLoad_151 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307016L,1471283307017L , "ISO-8859-1" , payLoad_152 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307028L,1471283307030L , "ISO-8859-1" , payLoad_153 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307036L,1471283307036L , "ISO-8859-1" , payLoad_154 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307046L,1471283307047L , "ISO-8859-1" , payLoad_155 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307056L,1471283307056L , "ISO-8859-1" , payLoad_156 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307066L,1471283307067L , "ISO-8859-1" , payLoad_157 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307080L,1471283307081L , "ISO-8859-1" , payLoad_158 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307087L,1471283307087L , "ISO-8859-1" , payLoad_159 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307104L,1471283307104L , "ISO-8859-1" , payLoad_160 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307108L,1471283307109L , "ISO-8859-1" , payLoad_161 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307119L,1471283307119L , "ISO-8859-1" , payLoad_162 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307128L,1471283307129L , "ISO-8859-1" , payLoad_163 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307138L,1471283307138L , "ISO-8859-1" , payLoad_164 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307148L,1471283307148L , "ISO-8859-1" , payLoad_165 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307158L,1471283307159L , "ISO-8859-1" , payLoad_166 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307169L,1471283307170L , "ISO-8859-1" , payLoad_167 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307178L,1471283307179L , "ISO-8859-1" , payLoad_168 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307189L,1471283307189L , "ISO-8859-1" , payLoad_169 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307200L,1471283307200L , "ISO-8859-1" , payLoad_170 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307210L,1471283307211L , "ISO-8859-1" , payLoad_171 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307219L,1471283307220L , "ISO-8859-1" , payLoad_172 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307230L,1471283307231L , "ISO-8859-1" , payLoad_173 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307240L,1471283307241L , "ISO-8859-1" , payLoad_174 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307251L,1471283307251L , "ISO-8859-1" , payLoad_175 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307260L,1471283307261L , "ISO-8859-1" , payLoad_176 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307270L,1471283307270L , "ISO-8859-1" , payLoad_177 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307282L,1471283307282L , "ISO-8859-1" , payLoad_178 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307290L,1471283307291L , "ISO-8859-1" , payLoad_179 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307302L,1471283307302L , "ISO-8859-1" , payLoad_180 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307311L,1471283307312L , "ISO-8859-1" , payLoad_181 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307321L,1471283307322L , "ISO-8859-1" , payLoad_182 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307331L,1471283307332L , "ISO-8859-1" , payLoad_183 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307341L,1471283307342L , "ISO-8859-1" , payLoad_184 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307354L,1471283307355L , "ISO-8859-1" , payLoad_185 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307362L,1471283307362L , "ISO-8859-1" , payLoad_186 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307373L,1471283307373L , "ISO-8859-1" , payLoad_187 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307382L,1471283307383L , "ISO-8859-1" , payLoad_188 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307393L,1471283307393L , "ISO-8859-1" , payLoad_189 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307403L,1471283307404L , "ISO-8859-1" , payLoad_190 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307413L,1471283307413L , "ISO-8859-1" , payLoad_191 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307423L,1471283307424L , "ISO-8859-1" , payLoad_192 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307434L,1471283307434L , "ISO-8859-1" , payLoad_193 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307446L,1471283307447L , "ISO-8859-1" , payLoad_194 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307455L,1471283307455L , "ISO-8859-1" , payLoad_195 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307463L,1471283307464L , "ISO-8859-1" , payLoad_196 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307474L,1471283307474L , "ISO-8859-1" , payLoad_197 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307484L,1471283307485L , "ISO-8859-1" , payLoad_198 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307496L,1471283307496L , "ISO-8859-1" , payLoad_199 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307504L,1471283307505L , "ISO-8859-1" , payLoad_200 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307515L,1471283307516L , "ISO-8859-1" , payLoad_201 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307527L,1471283307528L , "ISO-8859-1" , payLoad_202 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307538L,1471283307539L , "ISO-8859-1" , payLoad_203 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307545L,1471283307545L , "ISO-8859-1" , payLoad_204 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307556L,1471283307556L , "ISO-8859-1" , payLoad_205 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307566L,1471283307566L , "ISO-8859-1" , payLoad_206 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307575L,1471283307576L , "ISO-8859-1" , payLoad_207 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307585L,1471283307586L , "ISO-8859-1" , payLoad_208 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307596L,1471283307596L , "ISO-8859-1" , payLoad_209 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307606L,1471283307606L , "ISO-8859-1" , payLoad_210 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307617L,1471283307618L , "ISO-8859-1" , payLoad_211 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307628L,1471283307628L , "ISO-8859-1" , payLoad_212 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307638L,1471283307639L , "ISO-8859-1" , payLoad_213 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307647L,1471283307647L , "ISO-8859-1" , payLoad_214 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307661L,1471283307661L , "ISO-8859-1" , payLoad_215 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307670L,1471283307670L , "ISO-8859-1" , payLoad_216 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307677L,1471283307678L , "ISO-8859-1" , payLoad_217 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307689L,1471283307689L , "ISO-8859-1" , payLoad_218 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307697L,1471283307698L , "ISO-8859-1" , payLoad_219 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307708L,1471283307709L , "ISO-8859-1" , payLoad_220 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307718L,1471283307719L , "ISO-8859-1" , payLoad_221 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307730L,1471283307730L , "ISO-8859-1" , payLoad_222 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307739L,1471283307739L , "ISO-8859-1" , payLoad_223 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307749L,1471283307749L , "ISO-8859-1" , payLoad_224 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307760L,1471283307760L , "ISO-8859-1" , payLoad_225 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307768L,1471283307769L , "ISO-8859-1" , payLoad_226 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307780L,1471283307781L , "ISO-8859-1" , payLoad_227 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307789L,1471283307790L , "ISO-8859-1" , payLoad_228 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307799L,1471283307800L , "ISO-8859-1" , payLoad_229 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307810L,1471283307811L , "ISO-8859-1" , payLoad_230 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307820L,1471283307821L , "ISO-8859-1" , payLoad_231 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307833L,1471283307834L , "ISO-8859-1" , payLoad_232 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307841L,1471283307841L , "ISO-8859-1" , payLoad_233 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307850L,1471283307851L , "ISO-8859-1" , payLoad_234 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307862L,1471283307862L , "ISO-8859-1" , payLoad_235 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307870L,1471283307871L , "ISO-8859-1" , payLoad_236 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307881L,1471283307882L , "ISO-8859-1" , payLoad_237 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307894L,1471283307894L , "ISO-8859-1" , payLoad_238 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307902L,1471283307902L , "ISO-8859-1" , payLoad_239 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307911L,1471283307911L , "ISO-8859-1" , payLoad_240 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307922L,1471283307923L , "ISO-8859-1" , payLoad_241 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307932L,1471283307932L , "ISO-8859-1" , payLoad_242 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307944L,1471283307944L , "ISO-8859-1" , payLoad_243 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307952L,1471283307952L , "ISO-8859-1" , payLoad_244 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307964L,1471283307964L , "ISO-8859-1" , payLoad_245 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307973L,1471283307973L , "ISO-8859-1" , payLoad_246 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307983L,1471283307983L , "ISO-8859-1" , payLoad_247 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283307993L,1471283307993L , "ISO-8859-1" , payLoad_248 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308004L,1471283308005L , "ISO-8859-1" , payLoad_249 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308013L,1471283308013L , "ISO-8859-1" , payLoad_250 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308023L,1471283308023L , "ISO-8859-1" , payLoad_251 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308033L,1471283308034L , "ISO-8859-1" , payLoad_252 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308044L,1471283308045L , "ISO-8859-1" , payLoad_253 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308054L,1471283308054L , "ISO-8859-1" , payLoad_254 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308067L,1471283308067L , "ISO-8859-1" , payLoad_255 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308074L,1471283308075L , "ISO-8859-1" , payLoad_256 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308085L,1471283308086L , "ISO-8859-1" , payLoad_257 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308094L,1471283308095L , "ISO-8859-1" , payLoad_258 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308104L,1471283308105L , "ISO-8859-1" , payLoad_259 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308116L,1471283308117L , "ISO-8859-1" , payLoad_260 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308125L,1471283308125L , "ISO-8859-1" , payLoad_261 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308136L,1471283308136L , "ISO-8859-1" , payLoad_262 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308145L,1471283308146L , "ISO-8859-1" , payLoad_263 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308156L,1471283308156L , "ISO-8859-1" , payLoad_264 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308169L,1471283308169L , "ISO-8859-1" , payLoad_265 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308177L,1471283308177L , "ISO-8859-1" , payLoad_266 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308186L,1471283308186L , "ISO-8859-1" , payLoad_267 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308197L,1471283308198L , "ISO-8859-1" , payLoad_268 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308206L,1471283308206L , "ISO-8859-1" , payLoad_269 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308218L,1471283308218L , "ISO-8859-1" , payLoad_270 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308227L,1471283308228L , "ISO-8859-1" , payLoad_271 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308237L,1471283308237L , "ISO-8859-1" , payLoad_272 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308247L,1471283308248L , "ISO-8859-1" , payLoad_273 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308257L,1471283308258L , "ISO-8859-1" , payLoad_274 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308268L,1471283308268L , "ISO-8859-1" , payLoad_275 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308278L,1471283308279L , "ISO-8859-1" , payLoad_276 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308289L,1471283308289L , "ISO-8859-1" , payLoad_277 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308298L,1471283308298L , "ISO-8859-1" , payLoad_278 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308308L,1471283308309L , "ISO-8859-1" , payLoad_279 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308318L,1471283308319L , "ISO-8859-1" , payLoad_280 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308329L,1471283308330L , "ISO-8859-1" , payLoad_281 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308338L,1471283308339L , "ISO-8859-1" , payLoad_282 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308349L,1471283308350L , "ISO-8859-1" , payLoad_283 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308359L,1471283308359L , "ISO-8859-1" , payLoad_284 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308374L,1471283308374L , "ISO-8859-1" , payLoad_285 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308379L,1471283308379L , "ISO-8859-1" , payLoad_286 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308390L,1471283308391L , "ISO-8859-1" , payLoad_287 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308399L,1471283308400L , "ISO-8859-1" , payLoad_288 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308411L,1471283308412L , "ISO-8859-1" , payLoad_289 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308420L,1471283308420L , "ISO-8859-1" , payLoad_290 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308431L,1471283308431L , "ISO-8859-1" , payLoad_291 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308440L,1471283308441L , "ISO-8859-1" , payLoad_292 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308451L,1471283308452L , "ISO-8859-1" , payLoad_293 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308461L,1471283308461L , "ISO-8859-1" , payLoad_294 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308472L,1471283308473L , "ISO-8859-1" , payLoad_295 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308481L,1471283308481L , "ISO-8859-1" , payLoad_296 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308491L,1471283308492L , "ISO-8859-1" , payLoad_297 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308501L,1471283308502L , "ISO-8859-1" , payLoad_298 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308512L,1471283308513L , "ISO-8859-1" , payLoad_299 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308522L,1471283308522L , "ISO-8859-1" , payLoad_300 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308533L,1471283308534L , "ISO-8859-1" , payLoad_301 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308542L,1471283308542L , "ISO-8859-1" , payLoad_302 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308553L,1471283308553L , "ISO-8859-1" , payLoad_303 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308564L,1471283308564L , "ISO-8859-1" , payLoad_304 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308572L,1471283308573L , "ISO-8859-1" , payLoad_305 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308583L,1471283308583L , "ISO-8859-1" , payLoad_306 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308596L,1471283308596L , "ISO-8859-1" , payLoad_307 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308603L,1471283308603L , "ISO-8859-1" , payLoad_308 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308614L,1471283308614L , "ISO-8859-1" , payLoad_309 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308624L,1471283308625L , "ISO-8859-1" , payLoad_310 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308633L,1471283308634L , "ISO-8859-1" , payLoad_311 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308646L,1471283308647L , "ISO-8859-1" , payLoad_312 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308654L,1471283308654L , "ISO-8859-1" , payLoad_313 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308664L,1471283308665L , "ISO-8859-1" , payLoad_314 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308674L,1471283308675L , "ISO-8859-1" , payLoad_315 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308691L,1471283308691L , "ISO-8859-1" , payLoad_316 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308701L,1471283308701L , "ISO-8859-1" , payLoad_317 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308705L,1471283308705L , "ISO-8859-1" , payLoad_318 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308715L,1471283308716L , "ISO-8859-1" , payLoad_319 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308726L,1471283308726L , "ISO-8859-1" , payLoad_320 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308736L,1471283308736L , "ISO-8859-1" , payLoad_321 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308746L,1471283308746L , "ISO-8859-1" , payLoad_322 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308756L,1471283308758L , "ISO-8859-1" , payLoad_323 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308766L,1471283308766L , "ISO-8859-1" , payLoad_324 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308777L,1471283308778L , "ISO-8859-1" , payLoad_325 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308786L,1471283308786L , "ISO-8859-1" , payLoad_326 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308797L,1471283308799L , "ISO-8859-1" , payLoad_327 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308857L,1471283308858L , "ISO-8859-1" , payLoad_328 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308858L,1471283308858L , "ISO-8859-1" , payLoad_329 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308859L,1471283308859L , "ISO-8859-1" , payLoad_330 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308859L,1471283308859L , "ISO-8859-1" , payLoad_331 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308860L,1471283308860L , "ISO-8859-1" , payLoad_332 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308861L,1471283308861L , "ISO-8859-1" , payLoad_333 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308868L,1471283308869L , "ISO-8859-1" , payLoad_334 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308879L,1471283308879L , "ISO-8859-1" , payLoad_335 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308889L,1471283308889L , "ISO-8859-1" , payLoad_336 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308900L,1471283308900L , "ISO-8859-1" , payLoad_337 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308910L,1471283308911L , "ISO-8859-1" , payLoad_338 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308919L,1471283308919L , "ISO-8859-1" , payLoad_339 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308930L,1471283308930L , "ISO-8859-1" , payLoad_340 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308940L,1471283308940L , "ISO-8859-1" , payLoad_341 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308949L,1471283308949L , "ISO-8859-1" , payLoad_342 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308968L,1471283308969L , "ISO-8859-1" , payLoad_343 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308970L,1471283308970L , "ISO-8859-1" , payLoad_344 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308980L,1471283308980L , "ISO-8859-1" , payLoad_345 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283308991L,1471283308991L , "ISO-8859-1" , payLoad_346 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309001L,1471283309001L , "ISO-8859-1" , payLoad_347 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309011L,1471283309012L , "ISO-8859-1" , payLoad_348 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309020L,1471283309021L , "ISO-8859-1" , payLoad_349 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309031L,1471283309032L , "ISO-8859-1" , payLoad_350 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309042L,1471283309042L , "ISO-8859-1" , payLoad_351 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309051L,1471283309051L , "ISO-8859-1" , payLoad_352 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309061L,1471283309061L , "ISO-8859-1" , payLoad_353 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309074L,1471283309076L , "ISO-8859-1" , payLoad_354 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309084L,1471283309084L , "ISO-8859-1" , payLoad_355 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309092L,1471283309094L , "ISO-8859-1" , payLoad_356 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309121L,1471283309124L , "ISO-8859-1" , payLoad_357 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309125L,1471283309125L , "ISO-8859-1" , payLoad_358 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309126L,1471283309126L , "ISO-8859-1" , payLoad_359 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309133L,1471283309133L , "ISO-8859-1" , payLoad_360 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309148L,1471283309148L , "ISO-8859-1" , payLoad_361 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309155L,1471283309156L , "ISO-8859-1" , payLoad_362 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309166L,1471283309166L , "ISO-8859-1" , payLoad_363 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309174L,1471283309174L , "ISO-8859-1" , payLoad_364 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309184L,1471283309185L , "ISO-8859-1" , payLoad_365 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309193L,1471283309194L , "ISO-8859-1" , payLoad_366 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309204L,1471283309204L , "ISO-8859-1" , payLoad_367 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309214L,1471283309214L , "ISO-8859-1" , payLoad_368 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309225L,1471283309225L , "ISO-8859-1" , payLoad_369 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309234L,1471283309234L , "ISO-8859-1" , payLoad_370 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309245L,1471283309245L , "ISO-8859-1" , payLoad_371 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309255L,1471283309255L , "ISO-8859-1" , payLoad_372 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309268L,1471283309268L , "ISO-8859-1" , payLoad_373 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309275L,1471283309276L , "ISO-8859-1" , payLoad_374 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309286L,1471283309286L , "ISO-8859-1" , payLoad_375 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309296L,1471283309296L , "ISO-8859-1" , payLoad_376 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309307L,1471283309308L , "ISO-8859-1" , payLoad_377 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309317L,1471283309317L , "ISO-8859-1" , payLoad_378 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309327L,1471283309327L , "ISO-8859-1" , payLoad_379 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309337L,1471283309338L , "ISO-8859-1" , payLoad_380 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309347L,1471283309347L , "ISO-8859-1" , payLoad_381 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309357L,1471283309357L , "ISO-8859-1" , payLoad_382 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309369L,1471283309369L , "ISO-8859-1" , payLoad_383 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309378L,1471283309378L , "ISO-8859-1" , payLoad_384 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309388L,1471283309389L , "ISO-8859-1" , payLoad_385 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309398L,1471283309399L , "ISO-8859-1" , payLoad_386 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309408L,1471283309409L , "ISO-8859-1" , payLoad_387 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309419L,1471283309419L , "ISO-8859-1" , payLoad_388 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309429L,1471283309429L , "ISO-8859-1" , payLoad_389 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309438L,1471283309439L , "ISO-8859-1" , payLoad_390 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309449L,1471283309450L , "ISO-8859-1" , payLoad_391 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309460L,1471283309460L , "ISO-8859-1" , payLoad_392 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309471L,1471283309471L , "ISO-8859-1" , payLoad_393 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309479L,1471283309479L , "ISO-8859-1" , payLoad_394 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309489L,1471283309490L , "ISO-8859-1" , payLoad_395 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309501L,1471283309501L , "ISO-8859-1" , payLoad_396 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309510L,1471283309510L , "ISO-8859-1" , payLoad_397 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309521L,1471283309522L , "ISO-8859-1" , payLoad_398 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309530L,1471283309531L , "ISO-8859-1" , payLoad_399 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309541L,1471283309554L , "ISO-8859-1" , payLoad_400 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309554L,1471283309555L , "ISO-8859-1" , payLoad_401 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309561L,1471283309562L , "ISO-8859-1" , payLoad_402 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309573L,1471283309574L , "ISO-8859-1" , payLoad_403 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309581L,1471283309582L , "ISO-8859-1" , payLoad_404 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309591L,1471283309592L , "ISO-8859-1" , payLoad_405 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309603L,1471283309604L , "ISO-8859-1" , payLoad_406 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309612L,1471283309612L , "ISO-8859-1" , payLoad_407 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309623L,1471283309623L , "ISO-8859-1" , payLoad_408 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309632L,1471283309632L , "ISO-8859-1" , payLoad_409 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309643L,1471283309644L , "ISO-8859-1" , payLoad_410 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309652L,1471283309652L , "ISO-8859-1" , payLoad_411 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309666L,1471283309667L , "ISO-8859-1" , payLoad_412 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309673L,1471283309674L , "ISO-8859-1" , payLoad_413 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309683L,1471283309684L , "ISO-8859-1" , payLoad_414 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309695L,1471283309695L , "ISO-8859-1" , payLoad_415 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309705L,1471283309705L , "ISO-8859-1" , payLoad_416 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309714L,1471283309715L , "ISO-8859-1" , payLoad_417 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309724L,1471283309724L , "ISO-8859-1" , payLoad_418 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309734L,1471283309734L , "ISO-8859-1" , payLoad_419 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309744L,1471283309744L , "ISO-8859-1" , payLoad_420 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309754L,1471283309754L , "ISO-8859-1" , payLoad_421 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309765L,1471283309766L , "ISO-8859-1" , payLoad_422 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309775L,1471283309775L , "ISO-8859-1" , payLoad_423 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309785L,1471283309786L , "ISO-8859-1" , payLoad_424 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309797L,1471283309797L , "ISO-8859-1" , payLoad_425 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309807L,1471283309808L , "ISO-8859-1" , payLoad_426 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309815L,1471283309816L , "ISO-8859-1" , payLoad_427 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309825L,1471283309825L , "ISO-8859-1" , payLoad_428 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309835L,1471283309836L , "ISO-8859-1" , payLoad_429 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309846L,1471283309846L , "ISO-8859-1" , payLoad_430 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309856L,1471283309857L , "ISO-8859-1" , payLoad_431 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309866L,1471283309866L , "ISO-8859-1" , payLoad_432 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309876L,1471283309877L , "ISO-8859-1" , payLoad_433 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309887L,1471283309888L , "ISO-8859-1" , payLoad_434 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309896L,1471283309897L , "ISO-8859-1" , payLoad_435 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309911L,1471283309912L , "ISO-8859-1" , payLoad_436 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309918L,1471283309918L , "ISO-8859-1" , payLoad_437 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309928L,1471283309928L , "ISO-8859-1" , payLoad_438 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309937L,1471283309937L , "ISO-8859-1" , payLoad_439 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309948L,1471283309948L , "ISO-8859-1" , payLoad_440 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309958L,1471283309958L , "ISO-8859-1" , payLoad_441 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309968L,1471283309968L , "ISO-8859-1" , payLoad_442 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309979L,1471283309980L , "ISO-8859-1" , payLoad_443 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309995L,1471283309995L , "ISO-8859-1" , payLoad_444 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283309998L,1471283309999L , "ISO-8859-1" , payLoad_445 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310008L,1471283310009L , "ISO-8859-1" , payLoad_446 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310021L,1471283310023L , "ISO-8859-1" , payLoad_447 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310030L,1471283310030L , "ISO-8859-1" , payLoad_448 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310039L,1471283310039L , "ISO-8859-1" , payLoad_449 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310049L,1471283310050L , "ISO-8859-1" , payLoad_450 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310060L,1471283310060L , "ISO-8859-1" , payLoad_451 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310070L,1471283310070L , "ISO-8859-1" , payLoad_452 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310080L,1471283310081L , "ISO-8859-1" , payLoad_453 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310090L,1471283310091L , "ISO-8859-1" , payLoad_454 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310101L,1471283310102L , "ISO-8859-1" , payLoad_455 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310110L,1471283310110L , "ISO-8859-1" , payLoad_456 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310121L,1471283310121L , "ISO-8859-1" , payLoad_457 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310131L,1471283310131L , "ISO-8859-1" , payLoad_458 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310141L,1471283310141L , "ISO-8859-1" , payLoad_459 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310151L,1471283310152L , "ISO-8859-1" , payLoad_460 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310161L,1471283310162L , "ISO-8859-1" , payLoad_461 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310172L,1471283310173L , "ISO-8859-1" , payLoad_462 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310182L,1471283310183L , "ISO-8859-1" , payLoad_463 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310191L,1471283310191L , "ISO-8859-1" , payLoad_464 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310202L,1471283310203L , "ISO-8859-1" , payLoad_465 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310212L,1471283310212L , "ISO-8859-1" , payLoad_466 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310222L,1471283310223L , "ISO-8859-1" , payLoad_467 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310232L,1471283310233L , "ISO-8859-1" , payLoad_468 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310243L,1471283310243L , "ISO-8859-1" , payLoad_469 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310252L,1471283310253L , "ISO-8859-1" , payLoad_470 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310262L,1471283310263L , "ISO-8859-1" , payLoad_471 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310273L,1471283310273L , "ISO-8859-1" , payLoad_472 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310283L,1471283310284L , "ISO-8859-1" , payLoad_473 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310294L,1471283310294L , "ISO-8859-1" , payLoad_474 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310303L,1471283310304L , "ISO-8859-1" , payLoad_475 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310313L,1471283310314L , "ISO-8859-1" , payLoad_476 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310324L,1471283310324L , "ISO-8859-1" , payLoad_477 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310334L,1471283310334L , "ISO-8859-1" , payLoad_478 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310345L,1471283310345L , "ISO-8859-1" , payLoad_479 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310355L,1471283310356L , "ISO-8859-1" , payLoad_480 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310365L,1471283310366L , "ISO-8859-1" , payLoad_481 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310375L,1471283310376L , "ISO-8859-1" , payLoad_482 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310385L,1471283310385L , "ISO-8859-1" , payLoad_483 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310396L,1471283310397L , "ISO-8859-1" , payLoad_484 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310405L,1471283310406L , "ISO-8859-1" , payLoad_485 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310416L,1471283310416L , "ISO-8859-1" , payLoad_486 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310427L,1471283310427L , "ISO-8859-1" , payLoad_487 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310436L,1471283310437L , "ISO-8859-1" , payLoad_488 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310446L,1471283310446L , "ISO-8859-1" , payLoad_489 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310457L,1471283310458L , "ISO-8859-1" , payLoad_490 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310466L,1471283310467L , "ISO-8859-1" , payLoad_491 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310477L,1471283310478L , "ISO-8859-1" , payLoad_492 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310487L,1471283310487L , "ISO-8859-1" , payLoad_493 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310497L,1471283310497L , "ISO-8859-1" , payLoad_494 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310507L,1471283310507L , "ISO-8859-1" , payLoad_495 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310517L,1471283310518L , "ISO-8859-1" , payLoad_496 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310529L,1471283310530L , "ISO-8859-1" , payLoad_497 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310538L,1471283310539L , "ISO-8859-1" , payLoad_498 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310548L,1471283310548L , "ISO-8859-1" , payLoad_499 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310558L,1471283310558L , "ISO-8859-1" , payLoad_500 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310568L,1471283310568L , "ISO-8859-1" , payLoad_501 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310579L,1471283310580L , "ISO-8859-1" , payLoad_502 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310589L,1471283310590L , "ISO-8859-1" , payLoad_503 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310598L,1471283310599L , "ISO-8859-1" , payLoad_504 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310609L,1471283310609L , "ISO-8859-1" , payLoad_505 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310619L,1471283310620L , "ISO-8859-1" , payLoad_506 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310630L,1471283310631L , "ISO-8859-1" , payLoad_507 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310639L,1471283310639L , "ISO-8859-1" , payLoad_508 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310650L,1471283310651L , "ISO-8859-1" , payLoad_509 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310659L,1471283310660L , "ISO-8859-1" , payLoad_510 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310670L,1471283310670L , "ISO-8859-1" , payLoad_511 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310680L,1471283310680L , "ISO-8859-1" , payLoad_512 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310690L,1471283310691L , "ISO-8859-1" , payLoad_513 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310700L,1471283310700L , "ISO-8859-1" , payLoad_514 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310710L,1471283310711L , "ISO-8859-1" , payLoad_515 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310721L,1471283310722L , "ISO-8859-1" , payLoad_516 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310731L,1471283310731L , "ISO-8859-1" , payLoad_517 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310741L,1471283310741L , "ISO-8859-1" , payLoad_518 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310751L,1471283310752L , "ISO-8859-1" , payLoad_519 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310761L,1471283310762L , "ISO-8859-1" , payLoad_520 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310771L,1471283310771L , "ISO-8859-1" , payLoad_521 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310783L,1471283310784L , "ISO-8859-1" , payLoad_522 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310792L,1471283310792L , "ISO-8859-1" , payLoad_523 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310806L,1471283310806L , "ISO-8859-1" , payLoad_524 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310813L,1471283310813L , "ISO-8859-1" , payLoad_525 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310822L,1471283310822L , "ISO-8859-1" , payLoad_526 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310834L,1471283310835L , "ISO-8859-1" , payLoad_527 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310842L,1471283310843L , "ISO-8859-1" , payLoad_528 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310853L,1471283310854L , "ISO-8859-1" , payLoad_529 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310863L,1471283310864L , "ISO-8859-1" , payLoad_530 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310874L,1471283310874L , "ISO-8859-1" , payLoad_531 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310884L,1471283310885L , "ISO-8859-1" , payLoad_532 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310893L,1471283310894L , "ISO-8859-1" , payLoad_533 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310905L,1471283310905L , "ISO-8859-1" , payLoad_534 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310914L,1471283310915L , "ISO-8859-1" , payLoad_535 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310924L,1471283310924L , "ISO-8859-1" , payLoad_536 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310935L,1471283310936L , "ISO-8859-1" , payLoad_537 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310944L,1471283310945L , "ISO-8859-1" , payLoad_538 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310955L,1471283310955L , "ISO-8859-1" , payLoad_539 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310965L,1471283310965L , "ISO-8859-1" , payLoad_540 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310976L,1471283310977L , "ISO-8859-1" , payLoad_541 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310986L,1471283310986L , "ISO-8859-1" , payLoad_542 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283310996L,1471283310997L , "ISO-8859-1" , payLoad_543 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311008L,1471283311009L , "ISO-8859-1" , payLoad_544 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311016L,1471283311016L , "ISO-8859-1" , payLoad_545 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311026L,1471283311026L , "ISO-8859-1" , payLoad_546 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311036L,1471283311036L , "ISO-8859-1" , payLoad_547 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311047L,1471283311047L , "ISO-8859-1" , payLoad_548 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311057L,1471283311058L , "ISO-8859-1" , payLoad_549 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311067L,1471283311068L , "ISO-8859-1" , payLoad_550 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311077L,1471283311077L , "ISO-8859-1" , payLoad_551 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311088L,1471283311088L , "ISO-8859-1" , payLoad_552 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311098L,1471283311099L , "ISO-8859-1" , payLoad_553 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311109L,1471283311109L , "ISO-8859-1" , payLoad_554 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311118L,1471283311118L , "ISO-8859-1" , payLoad_555 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311128L,1471283311129L , "ISO-8859-1" , payLoad_556 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311139L,1471283311139L , "ISO-8859-1" , payLoad_557 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311149L,1471283311149L , "ISO-8859-1" , payLoad_558 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311159L,1471283311159L , "ISO-8859-1" , payLoad_559 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311169L,1471283311170L , "ISO-8859-1" , payLoad_560 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311181L,1471283311182L , "ISO-8859-1" , payLoad_561 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311189L,1471283311190L , "ISO-8859-1" , payLoad_562 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311200L,1471283311201L , "ISO-8859-1" , payLoad_563 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311212L,1471283311212L , "ISO-8859-1" , payLoad_564 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311220L,1471283311220L , "ISO-8859-1" , payLoad_565 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311230L,1471283311231L , "ISO-8859-1" , payLoad_566 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311240L,1471283311240L , "ISO-8859-1" , payLoad_567 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311250L,1471283311250L , "ISO-8859-1" , payLoad_568 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311261L,1471283311262L , "ISO-8859-1" , payLoad_569 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311271L,1471283311271L , "ISO-8859-1" , payLoad_570 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311282L,1471283311283L , "ISO-8859-1" , payLoad_571 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311291L,1471283311291L , "ISO-8859-1" , payLoad_572 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311302L,1471283311302L , "ISO-8859-1" , payLoad_573 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311315L,1471283311315L , "ISO-8859-1" , payLoad_574 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311321L,1471283311322L , "ISO-8859-1" , payLoad_575 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311332L,1471283311333L , "ISO-8859-1" , payLoad_576 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311343L,1471283311343L , "ISO-8859-1" , payLoad_577 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311351L,1471283311352L , "ISO-8859-1" , payLoad_578 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311362L,1471283311362L , "ISO-8859-1" , payLoad_579 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311372L,1471283311373L , "ISO-8859-1" , payLoad_580 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311383L,1471283311383L , "ISO-8859-1" , payLoad_581 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311401L,1471283311402L , "ISO-8859-1" , payLoad_582 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311404L,1471283311405L , "ISO-8859-1" , payLoad_583 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311425L,1471283311426L , "ISO-8859-1" , payLoad_584 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311426L,1471283311427L , "ISO-8859-1" , payLoad_585 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311434L,1471283311435L , "ISO-8859-1" , payLoad_586 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311446L,1471283311446L , "ISO-8859-1" , payLoad_587 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311454L,1471283311455L , "ISO-8859-1" , payLoad_588 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311465L,1471283311465L , "ISO-8859-1" , payLoad_589 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311474L,1471283311474L , "ISO-8859-1" , payLoad_590 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311484L,1471283311485L , "ISO-8859-1" , payLoad_591 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311495L,1471283311495L , "ISO-8859-1" , payLoad_592 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311505L,1471283311505L , "ISO-8859-1" , payLoad_593 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311515L,1471283311516L , "ISO-8859-1" , payLoad_594 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311525L,1471283311525L , "ISO-8859-1" , payLoad_595 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311535L,1471283311536L , "ISO-8859-1" , payLoad_596 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311549L,1471283311551L , "ISO-8859-1" , payLoad_597 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311556L,1471283311556L , "ISO-8859-1" , payLoad_598 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311566L,1471283311566L , "ISO-8859-1" , payLoad_599 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311576L,1471283311577L , "ISO-8859-1" , payLoad_600 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311586L,1471283311586L , "ISO-8859-1" , payLoad_601 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311596L,1471283311596L , "ISO-8859-1" , payLoad_602 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311606L,1471283311607L , "ISO-8859-1" , payLoad_603 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311617L,1471283311617L , "ISO-8859-1" , payLoad_604 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311630L,1471283311630L , "ISO-8859-1" , payLoad_605 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311637L,1471283311638L , "ISO-8859-1" , payLoad_606 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311650L,1471283311652L , "ISO-8859-1" , payLoad_607 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311657L,1471283311657L , "ISO-8859-1" , payLoad_608 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311667L,1471283311668L , "ISO-8859-1" , payLoad_609 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311677L,1471283311678L , "ISO-8859-1" , payLoad_610 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311688L,1471283311689L , "ISO-8859-1" , payLoad_611 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311698L,1471283311698L , "ISO-8859-1" , payLoad_612 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311708L,1471283311708L , "ISO-8859-1" , payLoad_613 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311718L,1471283311718L , "ISO-8859-1" , payLoad_614 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311729L,1471283311730L , "ISO-8859-1" , payLoad_615 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311742L,1471283311742L , "ISO-8859-1" , payLoad_616 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311750L,1471283311751L , "ISO-8859-1" , payLoad_617 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311763L,1471283311763L , "ISO-8859-1" , payLoad_618 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311770L,1471283311770L , "ISO-8859-1" , payLoad_619 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311809L,1471283311809L , "ISO-8859-1" , payLoad_620 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311809L,1471283311810L , "ISO-8859-1" , payLoad_621 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311810L,1471283311810L , "ISO-8859-1" , payLoad_622 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311811L,1471283311811L , "ISO-8859-1" , payLoad_623 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311822L,1471283311823L , "ISO-8859-1" , payLoad_624 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311830L,1471283311831L , "ISO-8859-1" , payLoad_625 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311841L,1471283311842L , "ISO-8859-1" , payLoad_626 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311851L,1471283311851L , "ISO-8859-1" , payLoad_627 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311862L,1471283311862L , "ISO-8859-1" , payLoad_628 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311871L,1471283311871L , "ISO-8859-1" , payLoad_629 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311881L,1471283311883L , "ISO-8859-1" , payLoad_630 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311891L,1471283311892L , "ISO-8859-1" , payLoad_631 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311902L,1471283311902L , "ISO-8859-1" , payLoad_632 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311912L,1471283311913L , "ISO-8859-1" , payLoad_633 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311923L,1471283311926L , "ISO-8859-1" , payLoad_634 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311932L,1471283311932L , "ISO-8859-1" , payLoad_635 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311947L,1471283311947L , "ISO-8859-1" , payLoad_636 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311952L,1471283311953L , "ISO-8859-1" , payLoad_637 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311963L,1471283311964L , "ISO-8859-1" , payLoad_638 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311973L,1471283311974L , "ISO-8859-1" , payLoad_639 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311984L,1471283311984L , "ISO-8859-1" , payLoad_640 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283311993L,1471283311993L , "ISO-8859-1" , payLoad_641 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312003L,1471283312004L , "ISO-8859-1" , payLoad_642 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312013L,1471283312013L , "ISO-8859-1" , payLoad_643 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312023L,1471283312024L , "ISO-8859-1" , payLoad_644 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312034L,1471283312034L , "ISO-8859-1" , payLoad_645 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312044L,1471283312044L , "ISO-8859-1" , payLoad_646 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312055L,1471283312055L , "ISO-8859-1" , payLoad_647 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312065L,1471283312065L , "ISO-8859-1" , payLoad_648 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312075L,1471283312076L , "ISO-8859-1" , payLoad_649 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312086L,1471283312086L , "ISO-8859-1" , payLoad_650 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312095L,1471283312096L , "ISO-8859-1" , payLoad_651 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312105L,1471283312106L , "ISO-8859-1" , payLoad_652 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312117L,1471283312117L , "ISO-8859-1" , payLoad_653 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312126L,1471283312126L , "ISO-8859-1" , payLoad_654 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312136L,1471283312136L , "ISO-8859-1" , payLoad_655 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312146L,1471283312147L , "ISO-8859-1" , payLoad_656 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312156L,1471283312156L , "ISO-8859-1" , payLoad_657 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312166L,1471283312167L , "ISO-8859-1" , payLoad_658 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312177L,1471283312177L , "ISO-8859-1" , payLoad_659 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312187L,1471283312187L , "ISO-8859-1" , payLoad_660 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312196L,1471283312197L , "ISO-8859-1" , payLoad_661 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312207L,1471283312208L , "ISO-8859-1" , payLoad_662 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312219L,1471283312219L , "ISO-8859-1" , payLoad_663 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312227L,1471283312228L , "ISO-8859-1" , payLoad_664 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312238L,1471283312238L , "ISO-8859-1" , payLoad_665 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312251L,1471283312252L , "ISO-8859-1" , payLoad_666 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312259L,1471283312260L , "ISO-8859-1" , payLoad_667 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312268L,1471283312268L , "ISO-8859-1" , payLoad_668 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312278L,1471283312279L , "ISO-8859-1" , payLoad_669 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312288L,1471283312289L , "ISO-8859-1" , payLoad_670 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312298L,1471283312299L , "ISO-8859-1" , payLoad_671 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312309L,1471283312309L , "ISO-8859-1" , payLoad_672 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312320L,1471283312321L , "ISO-8859-1" , payLoad_673 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312329L,1471283312329L , "ISO-8859-1" , payLoad_674 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312339L,1471283312340L , "ISO-8859-1" , payLoad_675 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312349L,1471283312350L , "ISO-8859-1" , payLoad_676 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312360L,1471283312361L , "ISO-8859-1" , payLoad_677 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312370L,1471283312371L , "ISO-8859-1" , payLoad_678 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312380L,1471283312381L , "ISO-8859-1" , payLoad_679 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312390L,1471283312390L , "ISO-8859-1" , payLoad_680 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312401L,1471283312401L , "ISO-8859-1" , payLoad_681 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312410L,1471283312410L , "ISO-8859-1" , payLoad_682 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312421L,1471283312422L , "ISO-8859-1" , payLoad_683 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312431L,1471283312432L , "ISO-8859-1" , payLoad_684 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312442L,1471283312443L , "ISO-8859-1" , payLoad_685 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312451L,1471283312452L , "ISO-8859-1" , payLoad_686 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312461L,1471283312462L , "ISO-8859-1" , payLoad_687 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312471L,1471283312472L , "ISO-8859-1" , payLoad_688 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312482L,1471283312484L , "ISO-8859-1" , payLoad_689 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312492L,1471283312492L , "ISO-8859-1" , payLoad_690 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312502L,1471283312503L , "ISO-8859-1" , payLoad_691 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312513L,1471283312513L , "ISO-8859-1" , payLoad_692 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312522L,1471283312522L , "ISO-8859-1" , payLoad_693 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312535L,1471283312535L , "ISO-8859-1" , payLoad_694 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312543L,1471283312544L , "ISO-8859-1" , payLoad_695 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312553L,1471283312553L , "ISO-8859-1" , payLoad_696 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312563L,1471283312563L , "ISO-8859-1" , payLoad_697 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312574L,1471283312574L , "ISO-8859-1" , payLoad_698 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312584L,1471283312585L , "ISO-8859-1" , payLoad_699 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312593L,1471283312594L , "ISO-8859-1" , payLoad_700 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312604L,1471283312605L , "ISO-8859-1" , payLoad_701 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312614L,1471283312615L , "ISO-8859-1" , payLoad_702 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312625L,1471283312625L , "ISO-8859-1" , payLoad_703 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312634L,1471283312634L , "ISO-8859-1" , payLoad_704 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312646L,1471283312647L , "ISO-8859-1" , payLoad_705 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312655L,1471283312655L , "ISO-8859-1" , payLoad_706 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312665L,1471283312666L , "ISO-8859-1" , payLoad_707 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312676L,1471283312676L , "ISO-8859-1" , payLoad_708 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312687L,1471283312688L , "ISO-8859-1" , payLoad_709 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312696L,1471283312697L , "ISO-8859-1" , payLoad_710 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312706L,1471283312706L , "ISO-8859-1" , payLoad_711 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312716L,1471283312717L , "ISO-8859-1" , payLoad_712 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312726L,1471283312726L , "ISO-8859-1" , payLoad_713 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312736L,1471283312736L , "ISO-8859-1" , payLoad_714 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312748L,1471283312748L , "ISO-8859-1" , payLoad_715 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312757L,1471283312757L , "ISO-8859-1" , payLoad_716 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312767L,1471283312767L , "ISO-8859-1" , payLoad_717 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312777L,1471283312778L , "ISO-8859-1" , payLoad_718 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312787L,1471283312787L , "ISO-8859-1" , payLoad_719 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312797L,1471283312798L , "ISO-8859-1" , payLoad_720 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312808L,1471283312808L , "ISO-8859-1" , payLoad_721 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312819L,1471283312820L , "ISO-8859-1" , payLoad_722 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312828L,1471283312828L , "ISO-8859-1" , payLoad_723 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312838L,1471283312839L , "ISO-8859-1" , payLoad_724 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312851L,1471283312851L , "ISO-8859-1" , payLoad_725 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312859L,1471283312859L , "ISO-8859-1" , payLoad_726 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312869L,1471283312869L , "ISO-8859-1" , payLoad_727 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312879L,1471283312880L , "ISO-8859-1" , payLoad_728 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312889L,1471283312889L , "ISO-8859-1" , payLoad_729 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312900L,1471283312901L , "ISO-8859-1" , payLoad_730 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312910L,1471283312911L , "ISO-8859-1" , payLoad_731 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312919L,1471283312919L , "ISO-8859-1" , payLoad_732 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312930L,1471283312930L , "ISO-8859-1" , payLoad_733 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312940L,1471283312941L , "ISO-8859-1" , payLoad_734 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312954L,1471283312954L , "ISO-8859-1" , payLoad_735 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312960L,1471283312960L , "ISO-8859-1" , payLoad_736 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312972L,1471283312973L , "ISO-8859-1" , payLoad_737 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312980L,1471283312980L , "ISO-8859-1" , payLoad_738 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283312991L,1471283312991L , "ISO-8859-1" , payLoad_739 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313001L,1471283313002L , "ISO-8859-1" , payLoad_740 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313011L,1471283313011L , "ISO-8859-1" , payLoad_741 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313021L,1471283313021L , "ISO-8859-1" , payLoad_742 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313032L,1471283313032L , "ISO-8859-1" , payLoad_743 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313043L,1471283313043L , "ISO-8859-1" , payLoad_744 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313052L,1471283313052L , "ISO-8859-1" , payLoad_745 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313062L,1471283313062L , "ISO-8859-1" , payLoad_746 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313072L,1471283313072L , "ISO-8859-1" , payLoad_747 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313084L,1471283313084L , "ISO-8859-1" , payLoad_748 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313093L,1471283313094L , "ISO-8859-1" , payLoad_749 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313105L,1471283313105L , "ISO-8859-1" , payLoad_750 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313116L,1471283313116L , "ISO-8859-1" , payLoad_751 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313124L,1471283313124L , "ISO-8859-1" , payLoad_752 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313134L,1471283313134L , "ISO-8859-1" , payLoad_753 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313143L,1471283313144L , "ISO-8859-1" , payLoad_754 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313154L,1471283313155L , "ISO-8859-1" , payLoad_755 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313165L,1471283313165L , "ISO-8859-1" , payLoad_756 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313175L,1471283313176L , "ISO-8859-1" , payLoad_757 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313184L,1471283313185L , "ISO-8859-1" , payLoad_758 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313194L,1471283313195L , "ISO-8859-1" , payLoad_759 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313205L,1471283313205L , "ISO-8859-1" , payLoad_760 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313215L,1471283313216L , "ISO-8859-1" , payLoad_761 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313225L,1471283313225L , "ISO-8859-1" , payLoad_762 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313235L,1471283313236L , "ISO-8859-1" , payLoad_763 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313245L,1471283313245L , "ISO-8859-1" , payLoad_764 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313256L,1471283313257L , "ISO-8859-1" , payLoad_765 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313266L,1471283313266L , "ISO-8859-1" , payLoad_766 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313276L,1471283313276L , "ISO-8859-1" , payLoad_767 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313286L,1471283313286L , "ISO-8859-1" , payLoad_768 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313296L,1471283313297L , "ISO-8859-1" , payLoad_769 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313306L,1471283313307L , "ISO-8859-1" , payLoad_770 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313317L,1471283313317L , "ISO-8859-1" , payLoad_771 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313326L,1471283313327L , "ISO-8859-1" , payLoad_772 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313356L,1471283313356L , "ISO-8859-1" , payLoad_773 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313356L,1471283313357L , "ISO-8859-1" , payLoad_774 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313357L,1471283313357L , "ISO-8859-1" , payLoad_775 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313368L,1471283313369L , "ISO-8859-1" , payLoad_776 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313377L,1471283313377L , "ISO-8859-1" , payLoad_777 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313389L,1471283313389L , "ISO-8859-1" , payLoad_778 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313398L,1471283313399L , "ISO-8859-1" , payLoad_779 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313408L,1471283313409L , "ISO-8859-1" , payLoad_780 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313419L,1471283313420L , "ISO-8859-1" , payLoad_781 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313429L,1471283313430L , "ISO-8859-1" , payLoad_782 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313440L,1471283313441L , "ISO-8859-1" , payLoad_783 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313451L,1471283313452L , "ISO-8859-1" , payLoad_784 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313460L,1471283313462L , "ISO-8859-1" , payLoad_785 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313471L,1471283313471L , "ISO-8859-1" , payLoad_786 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313481L,1471283313482L , "ISO-8859-1" , payLoad_787 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313490L,1471283313491L , "ISO-8859-1" , payLoad_788 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313502L,1471283313502L , "ISO-8859-1" , payLoad_789 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313511L,1471283313512L , "ISO-8859-1" , payLoad_790 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313521L,1471283313522L , "ISO-8859-1" , payLoad_791 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313533L,1471283313534L , "ISO-8859-1" , payLoad_792 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313542L,1471283313542L , "ISO-8859-1" , payLoad_793 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313551L,1471283313552L , "ISO-8859-1" , payLoad_794 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313561L,1471283313562L , "ISO-8859-1" , payLoad_795 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313571L,1471283313572L , "ISO-8859-1" , payLoad_796 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313582L,1471283313582L , "ISO-8859-1" , payLoad_797 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313592L,1471283313592L , "ISO-8859-1" , payLoad_798 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313602L,1471283313603L , "ISO-8859-1" , payLoad_799 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313613L,1471283313614L , "ISO-8859-1" , payLoad_800 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313623L,1471283313623L , "ISO-8859-1" , payLoad_801 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313633L,1471283313633L , "ISO-8859-1" , payLoad_802 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313644L,1471283313644L , "ISO-8859-1" , payLoad_803 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313653L,1471283313653L , "ISO-8859-1" , payLoad_804 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313664L,1471283313664L , "ISO-8859-1" , payLoad_805 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313674L,1471283313675L , "ISO-8859-1" , payLoad_806 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313684L,1471283313684L , "ISO-8859-1" , payLoad_807 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313694L,1471283313694L , "ISO-8859-1" , payLoad_808 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313705L,1471283313705L , "ISO-8859-1" , payLoad_809 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313714L,1471283313714L , "ISO-8859-1" , payLoad_810 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313725L,1471283313725L , "ISO-8859-1" , payLoad_811 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313735L,1471283313735L , "ISO-8859-1" , payLoad_812 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313745L,1471283313746L , "ISO-8859-1" , payLoad_813 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313755L,1471283313756L , "ISO-8859-1" , payLoad_814 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313765L,1471283313765L , "ISO-8859-1" , payLoad_815 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313775L,1471283313776L , "ISO-8859-1" , payLoad_816 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313786L,1471283313787L , "ISO-8859-1" , payLoad_817 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313796L,1471283313797L , "ISO-8859-1" , payLoad_818 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313818L,1471283313818L , "ISO-8859-1" , payLoad_819 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313819L,1471283313819L , "ISO-8859-1" , payLoad_820 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313826L,1471283313826L , "ISO-8859-1" , payLoad_821 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313842L,1471283313842L , "ISO-8859-1" , payLoad_822 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313862L,1471283313862L , "ISO-8859-1" , payLoad_823 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313887L,1471283313888L , "ISO-8859-1" , payLoad_824 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313897L,1471283313897L , "ISO-8859-1" , payLoad_825 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313898L,1471283313898L , "ISO-8859-1" , payLoad_826 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313903L,1471283313903L , "ISO-8859-1" , payLoad_827 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313904L,1471283313905L , "ISO-8859-1" , payLoad_828 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313911L,1471283313911L , "ISO-8859-1" , payLoad_829 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313918L,1471283313918L , "ISO-8859-1" , payLoad_830 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313929L,1471283313930L , "ISO-8859-1" , payLoad_831 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313938L,1471283313938L , "ISO-8859-1" , payLoad_832 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313950L,1471283313952L , "ISO-8859-1" , payLoad_833 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313959L,1471283313959L , "ISO-8859-1" , payLoad_834 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313970L,1471283313971L , "ISO-8859-1" , payLoad_835 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313981L,1471283313981L , "ISO-8859-1" , payLoad_836 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313989L,1471283313990L , "ISO-8859-1" , payLoad_837 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283313999L,1471283313999L , "ISO-8859-1" , payLoad_838 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314010L,1471283314010L , "ISO-8859-1" , payLoad_839 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314019L,1471283314020L , "ISO-8859-1" , payLoad_840 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314030L,1471283314031L , "ISO-8859-1" , payLoad_841 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314040L,1471283314041L , "ISO-8859-1" , payLoad_842 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314051L,1471283314052L , "ISO-8859-1" , payLoad_843 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314061L,1471283314061L , "ISO-8859-1" , payLoad_844 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314071L,1471283314071L , "ISO-8859-1" , payLoad_845 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314080L,1471283314081L , "ISO-8859-1" , payLoad_846 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314091L,1471283314091L , "ISO-8859-1" , payLoad_847 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314101L,1471283314101L , "ISO-8859-1" , payLoad_848 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314111L,1471283314112L , "ISO-8859-1" , payLoad_849 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314130L,1471283314131L , "ISO-8859-1" , payLoad_850 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314133L,1471283314134L , "ISO-8859-1" , payLoad_851 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314150L,1471283314150L , "ISO-8859-1" , payLoad_852 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314152L,1471283314153L , "ISO-8859-1" , payLoad_853 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314163L,1471283314163L , "ISO-8859-1" , payLoad_854 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314173L,1471283314173L , "ISO-8859-1" , payLoad_855 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314182L,1471283314183L , "ISO-8859-1" , payLoad_856 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314193L,1471283314194L , "ISO-8859-1" , payLoad_857 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314203L,1471283314203L , "ISO-8859-1" , payLoad_858 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314214L,1471283314215L , "ISO-8859-1" , payLoad_859 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314223L,1471283314224L , "ISO-8859-1" , payLoad_860 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314236L,1471283314236L , "ISO-8859-1" , payLoad_861 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314244L,1471283314244L , "ISO-8859-1" , payLoad_862 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314253L,1471283314254L , "ISO-8859-1" , payLoad_863 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314264L,1471283314265L , "ISO-8859-1" , payLoad_864 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314278L,1471283314278L , "ISO-8859-1" , payLoad_865 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314284L,1471283314284L , "ISO-8859-1" , payLoad_866 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314295L,1471283314296L , "ISO-8859-1" , payLoad_867 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314305L,1471283314305L , "ISO-8859-1" , payLoad_868 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314317L,1471283314318L , "ISO-8859-1" , payLoad_869 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314325L,1471283314325L , "ISO-8859-1" , payLoad_870 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314336L,1471283314336L , "ISO-8859-1" , payLoad_871 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314345L,1471283314345L , "ISO-8859-1" , payLoad_872 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314355L,1471283314355L , "ISO-8859-1" , payLoad_873 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 1 , 1471283314359L,1471283314359L , "UTF-8" , payLoad_874 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1471283314362L,1471283314363L , "UTF-8" , payLoad_875 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314366L,1471283314367L , "ISO-8859-1" , payLoad_876 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314376L,1471283314377L , "ISO-8859-1" , payLoad_877 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314386L,1471283314386L , "ISO-8859-1" , payLoad_878 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314396L,1471283314396L , "ISO-8859-1" , payLoad_879 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314408L,1471283314409L , "ISO-8859-1" , payLoad_880 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314416L,1471283314416L , "ISO-8859-1" , payLoad_881 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314427L,1471283314427L , "ISO-8859-1" , payLoad_882 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314437L,1471283314438L , "ISO-8859-1" , payLoad_883 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314447L,1471283314447L , "ISO-8859-1" , payLoad_884 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314457L,1471283314457L , "ISO-8859-1" , payLoad_885 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314467L,1471283314467L , "ISO-8859-1" , payLoad_886 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314477L,1471283314478L , "ISO-8859-1" , payLoad_887 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314488L,1471283314489L , "ISO-8859-1" , payLoad_888 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314498L,1471283314498L , "ISO-8859-1" , payLoad_889 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314508L,1471283314508L , "ISO-8859-1" , payLoad_890 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314520L,1471283314521L , "ISO-8859-1" , payLoad_891 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314528L,1471283314528L , "ISO-8859-1" , payLoad_892 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314538L,1471283314538L , "ISO-8859-1" , payLoad_893 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314549L,1471283314549L , "ISO-8859-1" , payLoad_894 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314560L,1471283314561L , "ISO-8859-1" , payLoad_895 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314569L,1471283314569L , "ISO-8859-1" , payLoad_896 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314579L,1471283314579L , "ISO-8859-1" , payLoad_897 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314591L,1471283314592L , "ISO-8859-1" , payLoad_898 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314600L,1471283314601L , "ISO-8859-1" , payLoad_899 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314610L,1471283314610L , "ISO-8859-1" , payLoad_900 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314624L,1471283314624L , "ISO-8859-1" , payLoad_901 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314630L,1471283314630L , "ISO-8859-1" , payLoad_902 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314640L,1471283314640L , "ISO-8859-1" , payLoad_903 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314651L,1471283314651L , "ISO-8859-1" , payLoad_904 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314660L,1471283314660L , "ISO-8859-1" , payLoad_905 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314671L,1471283314671L , "ISO-8859-1" , payLoad_906 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314680L,1471283314681L , "ISO-8859-1" , payLoad_907 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314693L,1471283314693L , "ISO-8859-1" , payLoad_908 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314701L,1471283314702L , "ISO-8859-1" , payLoad_909 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314711L,1471283314712L , "ISO-8859-1" , payLoad_910 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314723L,1471283314723L , "ISO-8859-1" , payLoad_911 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314732L,1471283314732L , "ISO-8859-1" , payLoad_912 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314741L,1471283314742L , "ISO-8859-1" , payLoad_913 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314752L,1471283314752L , "ISO-8859-1" , payLoad_914 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314762L,1471283314762L , "ISO-8859-1" , payLoad_915 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314773L,1471283314774L , "ISO-8859-1" , payLoad_916 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314783L,1471283314784L , "ISO-8859-1" , payLoad_917 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314793L,1471283314793L , "ISO-8859-1" , payLoad_918 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314803L,1471283314804L , "ISO-8859-1" , payLoad_919 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314813L,1471283314814L , "ISO-8859-1" , payLoad_920 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314825L,1471283314825L , "ISO-8859-1" , payLoad_921 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314835L,1471283314835L , "ISO-8859-1" , payLoad_922 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314843L,1471283314843L , "ISO-8859-1" , payLoad_923 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314853L,1471283314854L , "ISO-8859-1" , payLoad_924 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314864L,1471283314865L , "ISO-8859-1" , payLoad_925 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314874L,1471283314875L , "ISO-8859-1" , payLoad_926 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314884L,1471283314884L , "ISO-8859-1" , payLoad_927 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314894L,1471283314895L , "ISO-8859-1" , payLoad_928 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314905L,1471283314905L , "ISO-8859-1" , payLoad_929 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314915L,1471283314915L , "ISO-8859-1" , payLoad_930 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314928L,1471283314928L , "ISO-8859-1" , payLoad_931 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314935L,1471283314937L , "ISO-8859-1" , payLoad_932 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314946L,1471283314946L , "ISO-8859-1" , payLoad_933 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314956L,1471283314958L , "ISO-8859-1" , payLoad_934 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314966L,1471283314967L , "ISO-8859-1" , payLoad_935 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314976L,1471283314976L , "ISO-8859-1" , payLoad_936 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314986L,1471283314986L , "ISO-8859-1" , payLoad_937 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283314996L,1471283314997L , "ISO-8859-1" , payLoad_938 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315007L,1471283315007L , "ISO-8859-1" , payLoad_939 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315028L,1471283315028L , "ISO-8859-1" , payLoad_940 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315029L,1471283315030L , "ISO-8859-1" , payLoad_941 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315037L,1471283315038L , "ISO-8859-1" , payLoad_942 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315048L,1471283315048L , "ISO-8859-1" , payLoad_943 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315057L,1471283315057L , "ISO-8859-1" , payLoad_944 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315071L,1471283315072L , "ISO-8859-1" , payLoad_945 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315077L,1471283315077L , "ISO-8859-1" , payLoad_946 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315088L,1471283315088L , "ISO-8859-1" , payLoad_947 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315099L,1471283315099L , "ISO-8859-1" , payLoad_948 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315110L,1471283315111L , "ISO-8859-1" , payLoad_949 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315129L,1471283315129L , "ISO-8859-1" , payLoad_950 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315129L,1471283315130L , "ISO-8859-1" , payLoad_951 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315141L,1471283315141L , "ISO-8859-1" , payLoad_952 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315149L,1471283315149L , "ISO-8859-1" , payLoad_953 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315159L,1471283315159L , "ISO-8859-1" , payLoad_954 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315170L,1471283315171L , "ISO-8859-1" , payLoad_955 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315179L,1471283315180L , "ISO-8859-1" , payLoad_956 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315193L,1471283315193L , "ISO-8859-1" , payLoad_957 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315201L,1471283315201L , "ISO-8859-1" , payLoad_958 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315210L,1471283315211L , "ISO-8859-1" , payLoad_959 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315220L,1471283315221L , "ISO-8859-1" , payLoad_960 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315238L,1471283315238L , "ISO-8859-1" , payLoad_961 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315242L,1471283315242L , "ISO-8859-1" , payLoad_962 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315255L,1471283315255L , "ISO-8859-1" , payLoad_963 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315261L,1471283315261L , "ISO-8859-1" , payLoad_964 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315277L,1471283315278L , "ISO-8859-1" , payLoad_965 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315282L,1471283315283L , "ISO-8859-1" , payLoad_966 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315291L,1471283315291L , "ISO-8859-1" , payLoad_967 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315302L,1471283315302L , "ISO-8859-1" , payLoad_968 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315313L,1471283315314L , "ISO-8859-1" , payLoad_969 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315322L,1471283315323L , "ISO-8859-1" , payLoad_970 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315332L,1471283315332L , "ISO-8859-1" , payLoad_971 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315343L,1471283315344L , "ISO-8859-1" , payLoad_972 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315353L,1471283315354L , "ISO-8859-1" , payLoad_973 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315362L,1471283315362L , "ISO-8859-1" , payLoad_974 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 8 , 1471283315367L,1471283315367L , "ISO-8859-1" , payLoad_975 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315374L,1471283315375L , "ISO-8859-1" , payLoad_976 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315383L,1471283315384L , "ISO-8859-1" , payLoad_977 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315393L,1471283315394L , "ISO-8859-1" , payLoad_978 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315403L,1471283315404L , "ISO-8859-1" , payLoad_979 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315414L,1471283315414L , "ISO-8859-1" , payLoad_980 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315424L,1471283315424L , "ISO-8859-1" , payLoad_981 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315434L,1471283315434L , "ISO-8859-1" , payLoad_982 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315444L,1471283315445L , "ISO-8859-1" , payLoad_983 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315454L,1471283315454L , "ISO-8859-1" , payLoad_984 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315464L,1471283315464L , "ISO-8859-1" , payLoad_985 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315474L,1471283315474L , "ISO-8859-1" , payLoad_986 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 8 , 1471283315475L,1471283315475L , "ISO-8859-1" , payLoad_987 ));
		return webSocketData;
	}
	
	// source code getting the webSocket context.
	public WebSocketData getWebSocketData_1471283315738()
	{

		WebSocketData webSocketData = new WebSocketData();
		webSocketData.setConnectionStartMillis(1471283315995L);
		webSocketData.setConnectionStopMillis(1471283332060L);
		String payLoad_0 = "\u00ffN";
		String payLoad_1 = "\u0003\u00e8";


		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 2 , 1471283315997L,1471283315997L , "UTF-8" , payLoad_0 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 8 , 1471283332060L,1471283332060L , "ISO-8859-1" , payLoad_1 ));
		return webSocketData;
	}
	
	// source code getting the webSocket context.
	public WebSocketData getWebSocketData_1471283321344()
	{

		WebSocketData webSocketData = new WebSocketData();
		webSocketData.setConnectionStartMillis(1471283321454L);
		webSocketData.setConnectionStopMillis(1471283373633L);
		String payLoad_0 = "Rock it with HTML5 WebSocket";
		String payLoad_1 = "Rock it with HTML5 WebSocket";
		String payLoad_2 = "after pinpong,,,,or?";
		String payLoad_3 = "after pinpong,,,,or?";
		String payLoad_4 = "Denna webbplats \u00e4r skyddad av upphovsr\u00e4ttslagen (1960-729). Detta omfattar varum\u00e4rken, text, fotografier, teckningar och bilder";
		String payLoad_5 = "Denna webbplats \u00e4r skyddad av upphovsr\u00e4ttslagen (1960-729). Detta omfattar varum\u00e4rken, text, fotografier, teckningar och bilder";
		String payLoad_6 = "";
		String payLoad_7 = "";


		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1471283324642L,1471283324643L , "UTF-8" , payLoad_0 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 1 , 1471283324752L,1471283324752L , "UTF-8" , payLoad_1 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1471283366682L,1471283366682L , "UTF-8" , payLoad_2 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 1 , 1471283366791L,1471283366792L , "UTF-8" , payLoad_3 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 1 , 1471283369295L,1471283369295L , "UTF-8" , payLoad_4 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 1 , 1471283369404L,1471283369404L , "UTF-8" , payLoad_5 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , true  , false , (byte) 8 , 1471283373523L,1471283373523L , "UTF-8" , payLoad_6 ));
		webSocketData.addWebSocketFrame(new WebSocketFrame( true  , false , false , (byte) 8 , 1471283373633L,1471283373633L , "UTF-8" , payLoad_7 ));
		return webSocketData;
	}

}	// end of class

