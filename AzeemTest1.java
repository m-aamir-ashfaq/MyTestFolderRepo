
// *********************************************************************************************
//
// Automatically Generated Load Test Program
// -----------------------------------------
//
// Source: AzeemTest1.java
// Date  : 24 Aug 2016 22:55:18 ECT
// Author: Apica ZebraTester V5.4-I / automatically generated
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
public class AzeemTest1 extends HttpLoadTest implements Runnable, ThreadStepInterface, SetThreadStepInterface, SSLSessionCacheStatisticInterface, VaryingLoadInterface, VaryingTestDurationInterface, SuspendResumeInterface, GetRealTimeUserInputFieldsInterface
{
	public static final String prxVersion = "V5.4-I";
	public static final int    prxCharEncoding = 2;                         // 1 = OS Default, 2 = ISO-8859-1, 3 = UTF-8
	public static final String testDescription = "";

	public static String USER_AGENT_1 = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:47.0) Gecko/20100101 Firefox/47.0";

	private static final boolean CONTAINS_PARALLEL_EXECUTED_URLS = false;
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
	private static final String EXTERNAL_PARAM_FILE = "AzeemTest1ExtParams.dat";            // input file name for very large parameter values
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
	
	private volatile UserTransactionRuntimeHandler transactionHandler = new UserTransactionRuntimeHandler();		// re-used, support to manage user-defined transactions


	/**
	 * constructor: called from load test plug-ins (scope = global).
	 */
	public AzeemTest1()
	{
		super();
	}


	/**
	 * constructor: called when a user is created (per user).
	 */
	public AzeemTest1(int maxLoops, int requestTimeout, int threadNumber)
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
		if (!synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 1 failed
		
		// page 1 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [54] ---
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
		log();
		log("# title: Home Page");
		String requestProt0001 = "http";
		String requestHost0001 = "cldemo.apicasystem.com";
		int    requestPort0001 = 80;
		String requestFile0001 = "/";
		String requestHeader0001 = "GET " + requestFile0001 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 3757
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "function __doPostBack(eventTarget, eventArgument) {");		// Test [1] <- Index 1
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
		String requestProt0002 = "http";
		String requestHost0002 = "cldemo.apicasystem.com";
		int    requestPort0002 = 80;
		String requestFile0002 = "/Styles/stylesheet.css";
		String requestHeader0002 = "GET " + requestFile0002 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1996
		// content test algorithm: check size +/- 5%, defined content size = 1996
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 1996, 5);		// Test [2] <- Index 2
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0003 = "http";
		String requestHost0003 = "cldemo.apicasystem.com";
		int    requestPort0003 = 80;
		String requestFile0003 = "/Scripts/GoogleAnalytics.js";
		String requestHeader0003 = "GET " + requestFile0003 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 425
		// content test algorithm: check size +/- 5%, defined content size = 425
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 425, 5);		// Test [3] <- Index 3
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0004 = "http";
		String requestHost0004 = "cldemo.apicasystem.com";
		int    requestPort0004 = 80;
		String requestFile0004 = "/WebResource.axd" +
				"?d=SwCcMWJbC5HPR0GyMZBQBtBVcjnGUcMopW87tvl8Uit8R50NU80PEVSNB0QE3yO4B2yncMJIGpp_qLe8p71gNcCZXqg1" +
				"&t=635195493660000000";
		String requestHeader0004 = "GET " + requestFile0004 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
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
		String requestProt0005 = "http";
		String requestHost0005 = "cldemo.apicasystem.com";
		int    requestPort0005 = 80;
		String requestFile0005 = "/ScriptResource.axd" +
				"?d=mwTtg_Wai1zwdfVS8DMhG-CJF2EzezlMj6L_5JBaZ6e-vyB4Cowk489gZUKy1uUAINFHmtetDB3NkPofcY8cnG9wlosjKQWLl25xPeuoAl3_k4GiQqqE7HWnKsEcfYH2oW0whNQWHpmGFaTpCg9pJ27SMqxfbOF-RXd1Evl97j2k10k_XL0MxeLe6XJ_eOBsrXqRGQ2" +
				"&t=ca758f3";
		String requestHeader0005 = "GET " + requestFile0005 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 15436
		// content test algorithm: check size +/- 5%, defined content size = 15436
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 15436, 5);		// Test [5] <- Index 5
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0006 = "http";
		String requestHost0006 = "cldemo.apicasystem.com";
		int    requestPort0006 = 80;
		String requestFile0006 = "/Scripts/ApicaEUX.js";
		String requestHeader0006 = "GET " + requestFile0006 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 25372
		// content test algorithm: check size +/- 5%, defined content size = 25372
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 25372, 5);		// Test [6] <- Index 6
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0007 = "http";
		String requestHost0007 = "cldemo.apicasystem.com";
		int    requestPort0007 = 80;
		String requestFile0007 = "/ScriptResource.axd" +
				"?d=KUQ5QzCPc39yQrRqZ09wCtGl2hL_GgfGJ-PRbaHD0ZPg5Y7wt82h9bzxqPdyNS3Kdj6jTkxso_Xb5_mi_Ec-5Zgwzzl2vfDVEVGJ9ijYcDOjY_2BFY1J-emomwl_N8Gdwq_nDltG-WGvBrg50-IYDOnTbN6Wd-jGxg-4uANHXU-hS4ow0" +
				"&t=ca758f3";
		String requestHeader0007 = "GET " + requestFile0007 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 47754
		// content test algorithm: check size +/- 5%, defined content size = 47754
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 47754, 5);		// Test [7] <- Index 7
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0008 = "http";
		String requestHost0008 = "cldemo.apicasystem.com";
		int    requestPort0008 = 80;
		String requestFile0008 = "/Images/Banners/Lamp.jpg";
		String requestHeader0008 = "GET " + requestFile0008 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 870
		// content test algorithm: check size +/- 5%, defined content size = 870
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 870, 5);		// Test [8] <- Index 8
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0009 = "http";
		String requestHost0009 = "cldemo.apicasystem.com";
		int    requestPort0009 = 80;
		String requestFile0009 = "/Images/Banners/Amazon.jpg";
		String requestHeader0009 = "GET " + requestFile0009 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 918
		// content test algorithm: check size +/- 5%, defined content size = 918
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 918, 5);		// Test [9] <- Index 9
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0010 = "http";
		String requestHost0010 = "cldemo.apicasystem.com";
		int    requestPort0010 = 80;
		String requestFile0010 = "/Images/Banners/WindowsAzure.jpg";
		String requestHeader0010 = "GET " + requestFile0010 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 1238
		// content test algorithm: check size +/- 5%, defined content size = 1238
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 1238, 5);		// Test [10] <- Index 10
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0011 = "http";
		String requestHost0011 = "cldemo.apicasystem.com";
		int    requestPort0011 = 80;
		String requestFile0011 = "/Images/Logos/azure.png";
		String requestHeader0011 = "GET " + requestFile0011 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 4964
		// content test algorithm: check size +/- 5%, defined content size = 4964
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 4964, 5);		// Test [11] <- Index 11
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0012 = "http";
		String requestHost0012 = "cldemo.apicasystem.com";
		int    requestPort0012 = 80;
		String requestFile0012 = "/Images/Banners/WindowsServer.jpg";
		String requestHeader0012 = "GET " + requestFile0012 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 1408
		// content test algorithm: check size +/- 5%, defined content size = 1408
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 1408, 5);		// Test [12] <- Index 12
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0013 = "http";
		String requestHost0013 = "cldemo.apicasystem.com";
		int    requestPort0013 = 80;
		String requestFile0013 = "/Images/logo.png";
		String requestHeader0013 = "GET " + requestFile0013 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 6391
		// content test algorithm: check size +/- 5%, defined content size = 6391
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 6391, 5);		// Test [13] <- Index 13
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0014 = "http";
		String requestHost0014 = "cldemo.apicasystem.com";
		int    requestPort0014 = 80;
		String requestFile0014 = "/Images/cart.png";
		String requestHeader0014 = "GET " + requestFile0014 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 423
		// content test algorithm: check size +/- 5%, defined content size = 423
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 423, 5);		// Test [14] <- Index 14
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0015 = "http";
		String requestHost0015 = "cldemo.apicasystem.com";
		int    requestPort0015 = 80;
		String requestFile0015 = "/images/bg.jpg";
		String requestHeader0015 = "GET " + requestFile0015 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 130542
		// content test algorithm: check size +/- 5%, defined content size = 130542
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 130542, 5);		// Test [15] <- Index 15
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0016 = "http";
		String requestHost0016 = "cldemo.apicasystem.com";
		int    requestPort0016 = 80;
		String requestFile0016 = "/Images/Banners/Bullet.png";
		String requestHeader0016 = "GET " + requestFile0016 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 405
		// content test algorithm: check size +/- 5%, defined content size = 405
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 405, 5);		// Test [16] <- Index 16
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0017 = "http";
		String requestHost0017 = "cldemo.apicasystem.com";
		int    requestPort0017 = 80;
		String requestFile0017 = "/Images/ChLeagueFour.JPG";
		String requestHeader0017 = "GET " + requestFile0017 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 60220
		// content test algorithm: check size +/- 5%, defined content size = 60220
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 60220, 5);		// Test [17] <- Index 17
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0018 = "http";
		String requestHost0018 = "cldemo.apicasystem.com";
		int    requestPort0018 = 80;
		String requestFile0018 = "/Images/img.jpg";
		String requestHeader0018 = "GET " + requestFile0018 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0018, requestHost0018, requestPort0018, requestHeader0018, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0018 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 46192
		// content test algorithm: check size +/- 5%, defined content size = 46192
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 46192, 5);		// Test [18] <- Index 18
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0019 = "http";
		String requestHost0019 = "cldemo.apicasystem.com";
		int    requestPort0019 = 80;
		String requestFile0019 = "/font/myriadpro-regular_4-webfont.ttf";
		String requestHeader0019 = "GET " + requestFile0019 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/OCTET-STREAM", header text fragment = [verification disabled], recorded content size = 49392
		// content test algorithm: check size +/- 5%, defined content size = 49392
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/OCTET-STREAM", null, 49392, 5);		// Test [19] <- Index 19
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
		String requestProt0020 = "http";
		String requestHost0020 = "cldemo.apicasystem.com";
		int    requestPort0020 = 80;
		String requestFile0020 = "/images/navright.png";
		String requestHeader0020 = "GET " + requestFile0020 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 192
		// content test algorithm: check size +/- 5%, defined content size = 192
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 192, 5);		// Test [20] <- Index 20
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		// ... continuing page #1 (fragment 2 of 3)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [21] <- WEB ADMIN Index 21 ---
		String requestProt0021 = "http";
		String requestHost0021 = "cldemo.apicasystem.com";
		int    requestPort0021 = 80;
		String requestFile0021 = "/images/navleft.png";
		String requestHeader0021 = "GET " + requestFile0021 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 271
		// content test algorithm: check size +/- 5%, defined content size = 271
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 271, 5);		// Test [21] <- Index 21
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0022 = "http";
		String requestHost0022 = "cldemo.apicasystem.com";
		int    requestPort0022 = 80;
		String requestFile0022 = "/images/headbg.png";
		String requestHeader0022 = "GET " + requestFile0022 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 234
		// content test algorithm: check size +/- 5%, defined content size = 234
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 234, 5);		// Test [22] <- Index 22
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0023 = "http";
		String requestHost0023 = "cldemo.apicasystem.com";
		int    requestPort0023 = 80;
		String requestFile0023 = "/images/navleft_h.png";
		String requestHeader0023 = "GET " + requestFile0023 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 254
		// content test algorithm: check size +/- 5%, defined content size = 254
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 254, 5);		// Test [23] <- Index 23
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0024 = "http";
		String requestHost0024 = "cldemo.apicasystem.com";
		int    requestPort0024 = 80;
		String requestFile0024 = "/images/navright_h.png";
		String requestHeader0024 = "GET " + requestFile0024 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 183
		// content test algorithm: check size +/- 5%, defined content size = 183
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 183, 5);		// Test [24] <- Index 24
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0025 = "http";
		String requestHost0025 = "cldemo.apicasystem.com";
		int    requestPort0025 = 80;
		String requestFile0025 = "/font/myriadpro-semibold_6-webfont.ttf";
		String requestHeader0025 = "GET " + requestFile0025 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/OCTET-STREAM", header text fragment = [verification disabled], recorded content size = 48268
		// content test algorithm: check size +/- 5%, defined content size = 48268
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/OCTET-STREAM", null, 48268, 5);		// Test [25] <- Index 25
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
		String requestProt0026 = "http";
		String requestHost0026 = "cldemo.apicasystem.com";
		int    requestPort0026 = 80;
		String requestFile0026 = "/images/header_right.png";
		String requestHeader0026 = "GET " + requestFile0026 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 272
		// content test algorithm: check size +/- 5%, defined content size = 272
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 272, 5);		// Test [26] <- Index 26
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0027 = "http";
		String requestHost0027 = "cldemo.apicasystem.com";
		int    requestPort0027 = 80;
		String requestFile0027 = "/images/right_banner.jpg";
		String requestHeader0027 = "GET " + requestFile0027 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 8180
		// content test algorithm: check size +/- 5%, defined content size = 8180
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 8180, 5);		// Test [27] <- Index 27
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0028 = "http";
		String requestHost0028 = "cldemo.apicasystem.com";
		int    requestPort0028 = 80;
		String requestFile0028 = "/images/footer_left.png";
		String requestHeader0028 = "GET " + requestFile0028 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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
		String requestProt0029 = "http";
		String requestHost0029 = "cldemo.apicasystem.com";
		int    requestPort0029 = 80;
		String requestFile0029 = "/images/footer_mid.png";
		String requestHeader0029 = "GET " + requestFile0029 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 212
		// content test algorithm: check size +/- 5%, defined content size = 212
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 212, 5);		// Test [29] <- Index 29
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0030 = "http";
		String requestHost0030 = "cldemo.apicasystem.com";
		int    requestPort0030 = 80;
		String requestFile0030 = "/Images/white_banner_900x25.png";
		String requestHeader0030 = "GET " + requestFile0030 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1446
		// content test algorithm: check size +/- 5%, defined content size = 1446
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1446, 5);		// Test [30] <- Index 30
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0031 = "http";
		String requestHost0031 = "cldemo.apicasystem.com";
		int    requestPort0031 = 80;
		String requestFile0031 = "/images/footer_right.png";
		String requestHeader0031 = "GET " + requestFile0031 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 427
		// content test algorithm: check size +/- 5%, defined content size = 427
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 427, 5);		// Test [31] <- Index 31
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0032 = "http";
		String requestHost0032 = "cldemo.apicasystem.com";
		int    requestPort0032 = 80;
		String requestFile0032 = "/images/header_left.png";
		String requestHeader0032 = "GET " + requestFile0032 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 346
		// content test algorithm: check size +/- 5%, defined content size = 346
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 346, 5);		// Test [32] <- Index 32
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0033 = "www.google-analytics.com";
		int    requestPort0033 = 443;
		String requestFile0033 = "/ga.js";
		String requestHeader0033 = "GET " + requestFile0033 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.google-analytics.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 16022
		// content test algorithm: check size +/- 5%, defined content size = 16022
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, 16022, 5);		// Test [33] <- Index 33
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0034 = "www.google-analytics.com";
		int    requestPort0034 = 443;
		String requestFile0034 = "/r/__utm.gif" +
				"?utmwv=5.6.7" +
				"&utms=1" +
				"&utmn=324095473" +
				"&utmhn=cldemo.apicasystem.com" +
				"&utmcs=UTF-8" +
				"&utmsr=1680x1050" +
				"&utmvp=960x876" +
				"&utmsc=24-bit" +
				"&utmul=en-gb" +
				"&utmje=1" +
				"&utmfl=22.0%20r0" +
				"&utmdt=Home%20Page" +
				"&utmhid=1499197977" +
				"&utmr=-" +
				"&utmp=%2F" +
				"&utmht=1472071845837" +
				"&utmac=UA-48859361-1" +
				"&utmcc=__utma%3D27385454.343109540.1471356895.1472071846.1472071846.1%3B%2B__utmz%3D27385454.1472071846.1.1.utmcsr%3D(direct)%7Cutmccn%3D(direct)%7Cutmcmd%3D(none)%3B" +
				"&utmjid=2046825163" +
				"&utmredir=1" +
				"&utmu=qAAAAAAAAAAAAAAAAAABAAAE~";
		String requestHeader0034 = "GET " + requestFile0034 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.google-analytics.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 35
		// content test algorithm: check size +/- 5%, defined content size = 35
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 35, 5);		// Test [34] <- Index 34
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		log();
		log("# title: 404 - File or directory not found.");
		String requestProt0035 = "http";
		String requestHost0035 = "cldemo.apicasystem.com";
		int    requestPort0035 = 80;
		String requestFile0035 = "/favicon.ico";
		String requestHeader0035 = "GET " + requestFile0035 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
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

		// verify response: status code = 404, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 1245
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {404}, null, null, null);		// Test [35] <- Index 35
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
		String requestProt0036 = "http";
		String requestHost0036 = "cldemo.apicasystem.com";
		int    requestPort0036 = 80;
		String requestFile0036 = "/AllTickets.aspx";
		String requestHeader0036 = "GET " + requestFile0036 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 6323
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
		String requestProt0037 = "http";
		String requestHost0037 = "cldemo.apicasystem.com";
		int    requestPort0037 = 80;
		String requestFile0037 = "/Images/Wait/spining_wheel_notrans.gif";
		String requestHeader0037 = "GET " + requestFile0037 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
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





		// --- HTTP REQUEST: Test [38] <- WEB ADMIN Index 38 ---
		String requestProt0038 = "http";
		String requestHost0038 = "cldemo.apicasystem.com";
		int    requestPort0038 = 80;
		String requestFile0038 = "/images/green_button.gif";
		String requestHeader0038 = "GET " + requestFile0038 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 154
		// content test algorithm: check size +/- 5%, defined content size = 154
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 154, 5);		// Test [38] <- Index 38
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0039 = "www.google-analytics.com";
		int    requestPort0039 = 443;
		String requestFile0039 = "/__utm.gif" +
				"?utmwv=5.6.7" +
				"&utms=2" +
				"&utmn=249450841" +
				"&utmhn=cldemo.apicasystem.com" +
				"&utmcs=UTF-8" +
				"&utmsr=1680x1050" +
				"&utmvp=960x876" +
				"&utmsc=24-bit" +
				"&utmul=en-gb" +
				"&utmje=1" +
				"&utmfl=22.0%20r0" +
				"&utmdt=All%20tickets" +
				"&utmhid=1924348435" +
				"&utmr=0" +
				"&utmp=%2FAllTickets.aspx" +
				"&utmht=1472071852418" +
				"&utmac=UA-48859361-1" +
				"&utmcc=__utma%3D27385454.343109540.1471356895.1472071846.1472071846.1%3B%2B__utmz%3D27385454.1472071846.1.1.utmcsr%3D(direct)%7Cutmccn%3D(direct)%7Cutmcmd%3D(none)%3B" +
				"&utmjid=" +
				"&utmu=qAAAAAAAAAAAAAAAAAAAAAAE~";
		String requestHeader0039 = "GET " + requestFile0039 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.google-analytics.com\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 35
		// content test algorithm: check size +/- 5%, defined content size = 35
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 35, 5);		// Test [39] <- Index 39
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0040 = "http";
		String requestHost0040 = "cldemo.apicasystem.com";
		int    requestPort0040 = 80;
		String requestFile0040 = "/AllTickets.aspx";
		String requestContent0040 = 
				"ctl00%24ScriptManager1=ctl00%24ScriptManager1%7Cctl00%24MainContent%24CheckGamesButton" +
				"&__EVENTTARGET=" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=LYReK4o5OHJ0EeuH%2BeXFfmKo8dUN61%2FfrCvw8d60Eh2FRyohB5IOW2y7TKiQVI0HirYJpdq7GyKNRgFx8IBbrVEbLSq8bet9W79xqaHWUpQ35drUCl3DvbHZv0PIACMqjBm5IfXQMdWQ7Z93htx8zqQ2UhI2egKXTBAPhyyYOOwvNZwmAF8MJ1fuml0DGQ1MAfzG8MVwe%2FgaKP5v6jRl5Nsg8QIWLCbwGzu5FySeVjyR0QlCHk98%2FwgVB4pf9d3qI2ICfjd%2Bg4k5GwGyXa55Gi95szK2tvrsEZyrw%2BBbG78IDpc0jINd8HVPvF9%2FnS9%2BzlXOUMNOaFN%2B2ya8%2FmiW902wxvAs%2Bk7F6bsp%2BIMQjrTMOLD563yBWFaZUkQTWaFxjMfqzafYXp2ZX0%2FpPl0FRKjIikMcAV10DYa5%2FHnxW72gn52pjzvZdKu4kofSt0Z5VxvaIba9cNVgw51os667tTfPiT0wjxS0tzIISEaV3ErDiOnnr0d%2FqnC5JxpVDcp0qeXlZQymjKiTIBjNOZRz1w7gDZTuJsVEekolh153kbvKll8bycg0SC1mzSP470UO0vYjuaigyySjHWV5P0NUOffgEs06uoJcAkjYpfzBVgoBctYrYmMePn%2FVP%2FsH7UhLJy6juX3UAM4ftQKk3BirNQfLKQEltpm4a%2F7WzB69xiiU75RIZl7WKtEmtChue6Kd7Ri20O2LttxnKnwWXqGJp3VAsAqVm%2F092jWuDH9bn%2BESB0WrqLAiHkTbcjCdvzsl6Ye7YTBnZwiCYSqU10R4p%2BzvseA9tmclMRV5bv4LJNM0rHLX9SXyUv62kiEQx7ySR6qerLwByJxuYums04p%2BwhoJkk%2FrYr8t354qMmdbjF9EYas8MzwquN9V8P67JaC0jcht%2FMVSrvTyKl%2BWIjxd4qeqrbdjepsRyMfk1c0j8vJGqz8eAllJAsH59CJUDlvVSwgqaNeo3d67NtEK4BSg2a41xZ8Z5tDxbBVJC4m62o2%2Fni%2BluONPfWGKBlhmxpFzacxocO1NDXA2PpOtFADz1vF89LeXviJBavE3Fc0mFtKdyEVxFnNdoeFtQPNSc3y7nnUvXzTIcdNadoVLOA78U0vXplMpUUU3EJy3JvltaE5DiVhtm993CS4nSo5cyAuWtxkhPm0gcsHPgiFMBbeNU9yNv5BuZ4Cs5RbjEPohmhAzlIwFWBDhA9ATcBBKnxZrhyR6%2FVjjXio9WMzdaAKr40x31pFcalDfKm9qC5NuAhyQJVFbo4vV1Cy1BrLWAoGdkfVHB7vP43D7mALkc2wc5IbATWkYnjYAQ7ayqI8v3pBs3y0lcawi7BYTdYBYY3lWPerYet2b9jnvbWQlkxNt3wNyf6nEKSsGsTEvRrjvn4TG6zWQ7Nvk7kJLeLMKUCzLZ%2BfAvVcgIpD71bniMTtulGuRgxeFhu4IgAQxX25lHRCvDbqF4Pn%2BMynqA1l5hGnxEA02fA7fIY4Je2D4xcVHaxQ%2BgnVEOj6Y4FWPGuD5qvU8SoR%2Bqq%2FCYY6r4H09zSqCfXHStVk%2BG0GlnpwnQ61DNSlJe6PsBd4IqbnQxa2IUbyk98eTtfH7m2%2BB%2FHHNa0aT858JcvM1%2F0jT05YHGb8gZzm%2B%2FEQkjJ0KK7oXGi5tAlM0AM6ERlnNJcXIIuNh9HOBvNFUufXA9nKf0%2Fvd9bsY6yf7vp%2F5Lux%2FW%2BjRq1a7x0yoxW%2BkPEFKu1p5GvIK%2F4B9nVlsX8pqGM6rTWt0jznw%2BAA2APBz%2F%2Fr7VpAsVhgNrDe9WSGwFvK1hqL2HlFdQAhgTd79VrNRJl0uiSbpzjsRmTsQUto2JEXOUHpojejuHkS0aVBAKydGQaAb3dsBOw1NkaA0i3IAEaAEtlEE26j1wcGNMZ0%3D" +
				"&__VIEWSTATEENCRYPTED=" +
				"&__PREVIOUSPAGE=ZLR5YJNgG_28z3wT_GJVe5VIuhNO4AuAkO5rVgyrhVAbfEkZAmZsfgGhmkjyFFgJp_-2Gi9syvmlGt14SlVDfS6S4XQ4ds_n1K_mI_0jsbSSOGHC0" +
				"&ctl00%24MainContent%24TeamNamesDropDownList=AFC%20Ajax" +
				"&__ASYNCPOST=true" +
				"&ctl00%24MainContent%24CheckGamesButton=Check%20Games";
		byte[] requestContentBinary0040 = requestContent0040.getBytes("UTF-8");
		String requestHeader0040 = "POST " + requestFile0040 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"X-MicrosoftAjax: Delta=true\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=utf-8\r\n" + 
				"Content-Length: " + requestContentBinary0040.length + "\r\n" + 		// Content-Length: 2389
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0040, requestHost0040, requestPort0040, requestHeader0040, requestContentBinary0040, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
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
		requestHeader0040 = null;		// support garbage collector to reduce memory
		requestContent0040 = null;		// support garbage collector to reduce memory
		requestContentBinary0040 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 5112
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, "|83|updatePanel|MainContent_UpdatePanel2|");		// Test [40] <- Index 40
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
		// ... continuing page #1 (fragment 3 of 3)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [41] <- WEB ADMIN Index 41 ---
		String requestProt0041 = "http";
		String requestHost0041 = "cldemo.apicasystem.com";
		int    requestPort0041 = 80;
		String requestFile0041 = "/Images/gr_button.gif";
		String requestHeader0041 = "GET " + requestFile0041 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 1179
		// content test algorithm: check size +/- 5%, defined content size = 1179
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 1179, 5);		// Test [41] <- Index 41
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestProt0042 = "http";
		String requestHost0042 = "cldemo.apicasystem.com";
		int    requestPort0042 = 80;
		String requestFile0042 = "/AllTickets.aspx";
		String requestContent0042 = 
				"ctl00%24ScriptManager1=ctl00%24MainContent%24UpdatePanel1%7Cctl00%24MainContent%24GamesGridView" +
				"&__PREVIOUSPAGE=ZLR5YJNgG_28z3wT_GJVe5VIuhNO4AuAkO5rVgyrhVAbfEkZAmZsfgGhmkjyFFgJp_-2Gi9syvmlGt14SlVDfS6S4XQ4ds_n1K_mI_0jsbSSOGHC0" +
				"&ctl00%24MainContent%24TeamNamesDropDownList=AFC%20Ajax" +
				"&__EVENTTARGET=ctl00%24MainContent%24GamesGridView" +
				"&__EVENTARGUMENT=Select%242" +
				"&__VIEWSTATE=%2F%2ByYIHu6AVXRqepOrCxiI3P7Xt26uRpAyYiz3QUq7DgcuaNAzrwiAypMt9Qtjv%2FGYCkq88fOgZyuQclwlT5h2Cga0JQauGdWqNtfjKPTZ0X93hlXXsBfO4q5wy0LWpfWgS7TJeblZT8LCevtChEbKOg1wW0pk6KgMw2CKwklpFGexIyuOfIurXN%2FbgVvN5EYqr%2B0YY%2B5Z0MvkpPNUGV4g%2FSpwTy3kXfScrTdnIrpSnOGJtQrICgDbvYz1Ku08HKUk0yBHBW97Luyhv6o1TklcGXnyH2%2BlYWkMpgJ6IScr%2BYiyY%2FRC2IVj8WhtapG1dC0llduLJpC%2BfSVF%2F8M1zvHI7TjHmrSe%2Bdhdtc0Fh9BSn9oSiNXXcTjL%2FkOGggv8q%2F8jS18SiRoYkK9yVZwRidwjUP5mRb3PU0fRt4Uu85v0TBunMx2bZNi8RGADkUk7%2BvrBasH2ZBpvUVZWo2K82WdszFA%2Btl3f9QAuLpNU%2BVyUBaMEY9lKnQft6fEtPH9M%2FK2ngmk6XtQDmHK%2B9a6QlaNb60IlcZB18%2BATApMhrrF7QzjThNdAazsSyQhBd%2BjL0entC5cw5T7f%2B9j0%2BbbZiF1bIAcgWOxKKqgQTC7wh5Oe5zWMkHlEU59oOvvt7Z%2FFioFNdpUFs1nekVDNF4Le8MRMzuBt76OkP870p5MDZnGaoPnhSWuPB34e2gWjLfmhQ1lcLU2SMDVTX4VRc6ocq7VvEdH16%2B2QaQOe%2BAtVmXQ9CMyz%2BlFW39JoEzNmoyJZavj%2FuAqJuixjTonh%2B2xncxwv128c5j7xS8wC96LpJ4Ab81FfH2qhq4kLWINykvBr8cOwjuqh%2BiNGJWy7sklD1NTSDu9ryu90CjOicFuOAeWJzRBn%2BLFpCEsDGfYeu5Jsn%2BX%2FfjJ2NZujJRwAQGfRHZmumQhKzwnz8a7oFkxzz9auNauu5PjKrYgMuth4e5rRY7G6ABxKBpbetZiXJBIOqsYUuz2Urc%2B3YH%2Bpf7KES03%2FXW8Q79ao8JxNzgyHJHmr8GzhV22VyVdpvg72d4q8Txw9vYygRBjTf%2FArnI7ZPc1C%2BI86P96B%2B%2Bopsk0%2FJdJDvaNVqIcAsSc9b42KcJO3tArGpfJIq3ygDJsd9TZp5J6STTIbQ0ukzmfv7sFGuEqirMuWdv3bDwInBkHbs%2FnWRopJzWBBzpXgJaj00rl7in0B%2BbZ1fU4c2Im8%2BGaFFSoc0mYklECAuIh7rYzzwn%2FinSbHAjevnAogBMK9BKYx%2BKG2JgoI3xTBttZo9tyJUX%2FTbf%2BDq3Bt715eT21NT5M2d5MvlPPwh%2BoLlY4VlJCOd3o7bz0gk6IVphbJTkSzBR0FhjBPkeyLFlxuOVmj8AsxeSVHDqsiqf06PfOBjWO4yL8nF4e9%2BzvM31M9EOg2FYuVM5ARawuj342TtuYsiReGtn7QngZ4dEPOy%2BkuQGURYTVLAvQ69rCBi%2BGuK%2F66Veuhza2LgiwVGlFxaiWw3UBHEwUxT%2FKPX1QysNRD0wYt2m1H2DsmqYjxqTUcqTN6ifB6Ikvr6UvM4mrIR2G9ntyZURDL7J19FXHjadEaG0ImteMxPD8dI1ALb30K52CscM2MinT3sdIaw1cH%2BaYB1whmxmQ2C%2BnGbZNOdcXIdmXyZET%2B2MB4mz4VaDbaRCUISChJpLkjS4SaRVmg48YEp2LXTqNiGRKA31OMlIiAESgAA3jVZ6zvFAKBYQsRG4ieJ6%2Fii9Yf7044hK7STE1hLaZhPe5%2BVz0v51UgMumdvv51SNbTRhPr16Z1xgHEvzIMlvmDDmua7jvI73uEL43HzSCMvcMS64WczujCS%2ByxBOS9AheT7NmUIM%2BK9NwGj4D8g64oB7HuYHpPD1SYfbMic0%2BuOHQ%2Bh9%2FRIyq334XiBuxK5AlhtUUnKu%2FLS%2BseL87T3qeOgkUTdkjW1WI%2Fyl%2Bi5OwKeSD6feCziuvnM3Qeg4ISXjAD1pjWpzGGL3DeYnO7PsDOxtFnlMm63%2FJVgu%2BE6yUU2X%2BbqZRcwB6lVstfT0zbCFMnDFVqhazaRJcA%2BsXatJ9g1EwYbQpDjPQnjZaDC98uXsJy5ECx3PHy6f8bo%2BIT0DrVJpYJboDlPv80vltP9tmwQMj8vOqiwd1Z7d0auTW2OzJuXpUZyvEyQJ4XdGv6WFPSgM9yrieIMpNEzilKzZE2GCeHiDhrALdSbAluDRZ4JhAM%2Ba%2B%2BQUnKjSbo8CvZQBXwb%2BaQbQtuMMp7oqTlgwM3eNyeS6oRi%2Fc63S8UpADibr2sX9dlac%2Fw1Y7bQN6cP6QXrCHOqaWEXfbHVN3Q4eHxmxOsRZMATl%2FynAooqXoNMX9p31A9qV8fp3N0FVkN2WDz6E5zUzZEKtBzIQ3wU0HK20l1vLj6Ko1DzH%2FFKpnUvsil708j%2FEtMplvBTS3IYbs50EHBZTygub9tAbgtQ92QA41HLbWu9Bm7ZQC72hP88G9tPUtWEyU%2BtK6lmkFbAu1KbzbQRAdmrWcLRXEJigLQrNLPw6pogKfTJV4bBkZIG%2FQfttifYWvpIc3ThB8bAeKe253y%2B5RVY9nB6rXb9l0gIGXbvkjlsbjcUSiWLyTHvDVfgX2SLX8yBdm7KYT8MS%2FcX2RY4wuBh%2BxM8s1CpnLHRkI5Pf9JZoq0VXWqQPv3Souay5QQmj5evwxGRfnv4KM%2FgwQ%2BiITkKcZ%2F0dBXpVbpVf7oUINgqOl9uNhlSe2iSPP3ZpxsPtmP2mNtrzIAL74hVzZJXX9KhMUTyF8i1zIPZS6yt%2FoD14vaoYefp%2Fhgov4ViIJJ6hZq2nn8dzexSxxJoYh4Bjz%2B1iyh5CRSFPe21ooAbFK6VCTssk4E3c9xndnv5fLiINYPAT6ewZPsMKu45y1MCui1QNII%2FKE0kFRo7ql88wwcK6solg61o0VCvBWpdZFJyCxmxb%2Br2NWg5DX39R1sYzAe783t2Q4p9NTXsD8jbF%2FPZvd18kMVVGgFJcWbPcTJtbicd3MUgz2Os5JKS1VUQ3OXDKuGyByqN6rVfeceLIgeDzwCUyC1Ez5k%2FHGmqiyhUrVoQFOqDEHxhnvbe4oqRY9wCzjEBP6El8jNzR0Wa9YJPGXBKyFJSqMdKRPwHfy63ekTgv8zCyObQkOOFSU%2FpycqMr0xI%2BO5VEy5DOB%2BjJIkjmiKKGsXJ5hR9CEvuRaPXjUjRfjousj6S%2FsLergM0gM43SsGbP0Ap4BABtcwgkqHmxry%2BJ4RLshNmTpdCvOfVO1ODUVOCTKxrhz1EXDdlSi2vzQtRPfdPiwd%2FlSq%2BVx4eXNTrg6mZi09k%2FuxRvcmK4%2BItxz2VN%2FJK04G%2Bt3eKPQRy8EcJvT3GA7z6ZDYLolec9hIt2I%2BtmnKelSKmStPzMxtjHPuq%2FhV7MgIheV%2BVVP2CwBzkIFgQVcJdPQA%2FobECCaVqsgUwHEyKbRxxJpMUJ63U04GSrzApXDeDeEaU%2BJd%2FviOBANlAvIakqxSVcOqZxOf0J3Nolw3X4QBr69WJpi9Nxguebb80UU8Y9wbUfLhoT1oYdeUKOK%2FVwYOf20sXhXyN47y6PLnGw3he7Wx0LRZSlUXbH5v20ae4colW4jTqu1edsyN5IF6pH7YSkES3op0rOg7mwMJi3rGZaaqG1UiqIGLQ5r6jivPDML4Fxs" +
				"&__VIEWSTATEENCRYPTED=" +
				"&__ASYNCPOST=true";
		byte[] requestContentBinary0042 = requestContent0042.getBytes("UTF-8");
		String requestHeader0042 = "POST " + requestFile0042 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"X-MicrosoftAjax: Delta=true\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=utf-8\r\n" + 
				"Content-Length: " + requestContentBinary0042.length + "\r\n" + 		// Content-Length: 4273
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0042, requestHost0042, requestPort0042, requestHeader0042, requestContentBinary0042, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
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
		requestHeader0042 = null;		// support garbage collector to reduce memory
		requestContent0042 = null;		// support garbage collector to reduce memory
		requestContentBinary0042 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 6148
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, "span id=\"MainContent_SecondaryAvailabilityLabel\"");		// Test [42] <- Index 42
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
		String requestProt0043 = "http";
		String requestHost0043 = "cldemo.apicasystem.com";
		int    requestPort0043 = 80;
		String requestFile0043 = "/AllTickets.aspx";
		String requestContent0043 = 
				"ctl00%24ScriptManager1=ctl00%24MainContent%24UpdatePanel2%7Cctl00%24MainContent%24AddToCartButton" +
				"&__PREVIOUSPAGE=ZLR5YJNgG_28z3wT_GJVe5VIuhNO4AuAkO5rVgyrhVAbfEkZAmZsfgGhmkjyFFgJp_-2Gi9syvmlGt14SlVDfS6S4XQ4ds_n1K_mI_0jsbSSOGHC0" +
				"&ctl00%24MainContent%24TeamNamesDropDownList=AFC%20Ajax" +
				"&ctl00%24MainContent%24WipAmountTextBox=2" +
				"&ctl00%24MainContent%24PrimaryAmountTextBox=" +
				"&ctl00%24MainContent%24SecondaryAmountTextBox=" +
				"&__EVENTTARGET=" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=Oe3ys3L%2Fy0AEeXXFAIwmWwfcDVjC%2BQ7TGPbUJh4v2xccpXpQfaBZva7kgqO6Hq1CPVDtiI9pR3cEAwr%2B6JhYtrNLbz2aA6mHGh5C40pURuggt0aKb5E6Iy8Dev1xnQiVvR%2Brp3CedSnQTkmSZAOhCZFyKQmEYAAOixJxHz739Cafh9T9dydlHDNW5aaXDB%2BFmMQQZVpwums98MFWXg62ww47rWJioTMDC96qqmHg%2BC%2FCrKMpwJnX%2FZ7OZgMNm9lI8z3WvUJ3k%2BeR%2B3KUhl20p40ESYaXn1Od3xhL1w%2B5T2Ayn4zH7dW8grnzvnpLIZAWU5rVIAsgQF9HFWLeHjv%2FCjMcj%2B8%2F2XnvL%2B5QPieU0001LlNqp52VdsskRAxBahjEn9jxCK2prQeyvgMeLB6epPoOMNZiYsx%2FyswLWVtTYjkxXwZseqsM1lNtrusN3mU%2BTZ4tCEtqgxkWvYETM%2FYfShOqEjs%2FzzcVREsTSIBp0kLZyfBNP9UMO2aDoj1d8Ehg2nImLAe7v8MtoJ42njvFHBRIYetHt%2FTlDn5vX07qWGMDYFrt4bEZkZ3XYSEqeCcltzUjLi2sSW9QlraexCGXHe6TA02%2F0XGUNxcMwgvK%2F0xhHW3D3jgoBrcAbQpUpXQC4cmxqLZgg2CorVonlpQKq1mi4REPUds1jk61agE2%2Bo5YTCBfWKQeIPAZrJmDCiCsCfdxzyZg%2FBl8J1SRUpdbGlCy6IsuHy%2FLAJCogIj3Nl9rJShc4%2BjhmVTfZyxRZXkPLTXpAVnmKeb7hX4371xXt%2FjSJGUSCeD9gUeVmmXDeuI0HDRy338RrftojBe1igvapCQRyjo8%2BIoZbGZurKdTcRRDRERofV3ITdr0rtqhUF62tORiadif9x%2FsxQrGaV%2FmFmnwYOOZQecfk8iigRD8nX%2FryZEt2sIhoKmndIGyzGQhNCwa311LX9C9XbL%2FMqet6YvTJ3%2BTbbiSG1kIU4vyaIQFthyYF%2B3%2BrKNmcUwotBUmaaRX8h2mbcWa83eJVReTP17lQJHLCZYzpNVP%2BJWqmM%2FvKWlp%2FjyC6d%2FNcTDbIqP8VelJlKuh9w6CiViEUSibFQSdBhXDp9vLFRil6ZjnCtXWwcn0qJfFyTq9p6hQ5jovd27W%2FOceHSl5Tc7465UjeUmIDqpe8RFTwbu7MAq3nBqtxYysvO4ArL8N3iZ4135EMe2eHHue7%2B56x6Eu6g9Icjq%2BTpo1zasrsozL3jeXA2AyZ9fBgbFNX7nGT1L%2BxdK3wA8eVLdLlLbHA8iY4F7%2FhhZMRl7MY1eI37vBwaVy4ChjixwBJSXcjWsu2FDJYd7SPA1OE0Biiedebd7kjqUFMaOoDFxUHDqKgqcUy2SupKT5DsnoX6t4JaQthRy4mlQtMnwKtJ57MHWqbSrpN56nrQtKrjkWpCMfx1bpFK5KHedum%2B3RfO8O7ZHTTVYM7R1qtzCp6OX6dNgOYhyyUvjyzuUJ9k1qNPIHqDDV03N6wQ1Or2Gyp2ZhZjTqlKRlhZNM%2BPnKERaauFXqk9eVdIwfNN3jcvGPbOsskol%2BfpL%2Bljv8gFGril9yPgT1Y2WtHu7agW2Ka%2BpDLNMsmDChIao7ms%2FUrdL%2Bgdc29mGm3gWimwBclCS4GsqXJBrzEo61wtHymVwf2bAXixtXBbDgsPJhcS%2FfTzovplQbooXu4M3uSnYPyljiDQZ1cSEG%2Bu%2FhFm2%2FVKLbKz9v3RiMz%2FsMguCvQwBroP7aHXcVWtqPC%2FOYbvfTYKVJlOR5gjK6qbpGjhqCGdL1D8nxRbetcfCDSWm4zMIfiHeNq3Fy5a1JXdwO3ou3aEjlvfav34vA2EvDZVKcd7IGEP5i7Lcf5a2pNsjxTD1ICiIucgQ%2Fv2CHt%2BGxHJC4LmokhbJZkS93gPY4SuksHoMFKtdBOFk0bEpfm9idim1r4SQKA%2BN4NttCmHEmGqGnPVGPQLUHlZFPlFyWpmiJTy9Kmf2y3kvtmoLzR%2BEv86bbdbbfXpOWpR%2FT2FhrP6QNVyZ2VME7j23FA5Z3I5%2B7VbX8%2F3IkaFsdCrHSbrb3Ii80J%2BUSQX7FCPaqFDa0us1LNHHACtlsiBk82N8LZGmRICpBfESx01wX36TFUcQuPnsgnLGIBVZHHAm7f5hNUcUUOUnhuxdan82ThdrRceHNInbomLS8D9WTK3SrsGM7aKxlXj45Oq9Xu8P5jIPRo%2Bnv7x4n1Onx9snBDI3852IwBiBc3S%2Bk%2FKZM5rdCQAoWaOR55INem%2Fma66gfrmBL9AWoEx04fVAhaYgA8Oc%2Bv3GQ7kV1G13F%2BjKNcHs3g9BS8a3dT3t%2BkhZUfXi%2BQGece%2FZhCoPcsujiAJjkG2ASiLLNEGvdbvbI7snTuXmm18%2BxjwY0f4i3uXmt%2FjgMhne0yyXbLBwzhmbFPpREkMcgipLEeiJHZRUlwCgaqvZ0YGnGkWHtAGbaz2TIrRVltKq%2FF2SOCPEqq7%2BfZIxk8ILRnV4CFJJ8zMMdPHKO%2BK4lhffR77g5%2FGb8fERA0%2FmeQnTpECZ%2FzF6U%2BMvTBL4kaP4iLWbDH%2BqTzftjRYxzSUyJul0oIPkIGms6e%2FCFMffXU6eYf9I4PeQ5uXu2LSLRmpxll%2BzIpWKlKQOII3JPQ2dQzrZGrds6YFs8J4NzLXo%2FiYFdHcTpYoOwFFYUjBehf%2BhL0sFiPMS0H7N6mJmN5m3jtLJbrkwU41BAS1JYbPtyk6%2BEAz8KR92WgxF%2BnrM31JnxZh7MIArB7vDKY5t4j0kVX36%2BswRBzoxSO0M9xt51eScoZfKhH0TDyK1I9u8SuwIdDylclABCRTiD%2Fpk%2FQbFjmOVlJO%2B%2BzD%2FJjFh4uPm9CuZhILTitaRZcVWrX9J%2Fk%2FpqqHUXPTH4rNRsTY8gUMP55hl8NmYXvJr07FKccjWQz%2Fp8tox4fX7dG1KEKUAoXiMGJ0M51MQJjiga2Bu9NibjL2iXUoYXtlD1zuRsHJlQGqYQ5jZ%2BnUxgNYK%2F4zMBZBdW6UMvojdoD8mmTWmAip8x39H6P9je3WVUyOqINHxeRY0wt7ueo7oBZI%2FT4ldreKwQJNuAOr2LyMrf5K2nHUMSwjAS1fU0EoFn7MA5Ptt8hDe6hQqrTmMsmn1uAskiWfI1wYOB3fxd1WO3uPb5hYDXBut2ZPc6KQI4voumxixAQwT58KA4M8%2BbKoUudSNnh%2Fmj3%2BViDuVy6Z8oOO4QKaNXNeWaNLDDJBlhUCqOoF5%2BD39AN2O6JhFaU2lrgnN%2B7%2FsPCHLpLtMS4o51j5MeWyMC9idSNRyhVFXEXgFOrfumMSNl2rVCf7R5CufwBLMBDSObtb8Bf2VUctaADQTt2VSUNvWJRMFypJcVd1Ore0ArwzMKpacmAM2DvJ2%2Fyfz8T2FWOfF9MUhCbSfSYEwn8eQP%2FAkeeMGNBdVgvKQEgM6S5C2odl1GRxLOwuTDXjDVVmWQbzHQ4YgMFtFgtBI6O7KpU%2F5F%2Bg8bXqo1ZkDudjORL%2Be5%2Bbyx0hzuirawbM%2Fm9%2F47%2Bg2jd2oRRmYaogrh9I%2BgXGgxnW%2FnruK8BXltw77OoH3YzezZ%2FgR%2FvxmMY7i0DPn%2FGocEUguQAt4TSaqgqq5LZNQoZzLQ19DA570b0P8zpm0xWk4bN1CK87yWMCNXzUvIdVtHbezfEdG2GXVKZ1h20sgo4zwBq4vmg9bwTs2fcbSFkJ%2BLsBqkklSgrJTnCJB1oQqvxzMu%2BQfLdbEJpA8wkUYxepKoq6I6%2BHWnl1nx9sUbHvnMpZTLW4eBedg8y4%2FTXRc3iYcuZzUR9ERv5PmdJRHC1uQyOFzZ%2FlGNiLZD3yA%2Ffq8ojWzPuRyVGdpt1v5OhcV5FCccf%2FXtoBZHbwhRPcuk8hdBUKKQi%2BiBV8DlDEGYcniIqu5SvDIDA2x8DZEZMbBQkadZA0rKjJV6OZWaRzKrGyUGhA%3D%3D" +
				"&__VIEWSTATEENCRYPTED=" +
				"&__ASYNCPOST=true" +
				"&ctl00%24MainContent%24AddToCartButton=Add%20to%20shopping%20cart";
		byte[] requestContentBinary0043 = requestContent0043.getBytes("UTF-8");
		String requestHeader0043 = "POST " + requestFile0043 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"X-MicrosoftAjax: Delta=true\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=utf-8\r\n" + 
				"Content-Length: " + requestContentBinary0043.length + "\r\n" + 		// Content-Length: 4737
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0043, requestHost0043, requestPort0043, requestHeader0043, requestContentBinary0043, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
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
		requestHeader0043 = null;		// support garbage collector to reduce memory
		requestContent0043 = null;		// support garbage collector to reduce memory
		requestContentBinary0043 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 5810
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, "span id=\"MainContent_SecondaryAvailabilityLabel\"");		// Test [43] <- Index 43
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
		log();
		log("# title: View my shopping cart");
		String requestProt0044 = "http";
		String requestHost0044 = "cldemo.apicasystem.com";
		int    requestPort0044 = 80;
		String requestFile0044 = "/Checkout/MyShoppingCart.aspx";
		String requestHeader0044 = "GET " + requestFile0044 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0044, requestHost0044, requestPort0044, requestHeader0044, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0044 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 5582
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "span id=\"MainContent_ShoppingCartLabel\"");		// Test [44] <- Index 44
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
		String requestProt0045 = "http";
		String requestHost0045 = "cldemo.apicasystem.com";
		int    requestPort0045 = 80;
		String requestFile0045 = "/Images/select_item.gif";
		String requestHeader0045 = "GET " + requestFile0045 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 1096
		// content test algorithm: check size +/- 5%, defined content size = 1096
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 1096, 5);		// Test [45] <- Index 45
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0046 = "www.google-analytics.com";
		int    requestPort0046 = 443;
		String requestFile0046 = "/__utm.gif" +
				"?utmwv=5.6.7" +
				"&utms=3" +
				"&utmn=2085664389" +
				"&utmhn=cldemo.apicasystem.com" +
				"&utmcs=UTF-8" +
				"&utmsr=1680x1050" +
				"&utmvp=960x876" +
				"&utmsc=24-bit" +
				"&utmul=en-gb" +
				"&utmje=1" +
				"&utmfl=22.0%20r0" +
				"&utmdt=View%20my%20shopping%20cart" +
				"&utmhid=750001906" +
				"&utmr=0" +
				"&utmp=%2FCheckout%2FMyShoppingCart.aspx" +
				"&utmht=1472071877348" +
				"&utmac=UA-48859361-1" +
				"&utmcc=__utma%3D27385454.343109540.1471356895.1472071846.1472071846.1%3B%2B__utmz%3D27385454.1472071846.1.1.utmcsr%3D(direct)%7Cutmccn%3D(direct)%7Cutmcmd%3D(none)%3B" +
				"&utmjid=" +
				"&utmu=qAAAAAAAAAAAAAAAAAAAAAAE~";
		String requestHeader0046 = "GET " + requestFile0046 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.google-analytics.com\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 35
		// content test algorithm: check size +/- 5%, defined content size = 35
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 35, 5);		// Test [46] <- Index 46
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		log();
		log("# title: Pay and check out");
		String requestProt0047 = "http";
		String requestHost0047 = "cldemo.apicasystem.com";
		int    requestPort0047 = 80;
		String requestFile0047 = "/Checkout/PayAndCheckout.aspx";
		String requestContent0047 = 
				"__EVENTTARGET=ctl00%24MainContent%24CheckoutLinkButton" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=28PzpDYw%2BDlNT17ET4obXKuUcjEymiufMLwMp4o4J5ItMThAIBmFY8OHqHEm2ijNcJRrOG7XnOtJBp%2Fyma1za2Joje28zYKhc8kaUCPXPmu1TgDtzMCxTPh1ceO4nA6l55%2F%2FTZOX0QB2B3OpQO5sg2pebYxCEBB4HnmvZ8wlN2UbqxO0OK7fykGjweQGw8rugSf9oLSJgB6GjGpZhUW0p179w%2BsFZL5FrVRFepdBaDMNYC1AgX8TI9GEok1R7y7Ms5J7YiLITfM3aX7mNXzOXWlTU3XwlhrhCLGdUt2XyuFXqt5yIaglD2NjCzD0FFdVh1xRL%2BurDP%2BL62wlyf%2FSV8sqk6dGJERp7WNhEv7JFGpjUokraOnnM68noqLiyC1H0cf9J7FY6hAspF2zcT7ysP7cfwXMuI%2FIl3kpngyO8so0KxLXNCJtES9x9UOLUY38IniS6e3baNwOT1u7DZs83yb5DSOV0X%2BaUuHL8M6pJ2WN1c5kTYyS0wCt0auULLoci2tfG3QpVuFXnF6omEnBY7T5KwAUnGUOOjRkIk4fMhiXc5Z%2FKDOf%2BcYx6jHjYXi8Cpr4nE2FLxZiLGkcnSKMrDw41S6fouV2u44rkjYmxVnVxWKTJxppxfUDvDSv4qJHLh4mN94pGC6Rznug267WIBeNioL7chnvXbGwav3e2czItnQMytdink2O0%2F%2FdKtR9zarX%2BkEkH6KwikyziLx87KslzU8JBqIiEy32NH5Qjvwjv34QzqCEq8C%2ByQAyXJAnVzgyDmjj1hBzkH8ZVuadBz1RA%2BDMmIEjBZpu5WplPBl%2Bj44MOkqyfQD%2Fe%2BGOV4lJK7r371%2Bmp2Q70iPe0g9MSBj%2FWpOiIQK25gouMLYk7TEo%2F%2FZmGymJzAm4TKDO0Y7s6BQVENHaZa02jLqOCOd3OJl0CZGsNA9fIXFI%2BwnwnkARQr3KeTD8r2j7kGJxXsZ%2FDq6ydDV7avLYBoH9w8bhKnid1Qn7I02qEIM0gr89A7Cq4gPiRCq7zGYxNQyGY0rDNbOGRw2YXjzBYDD89uKkMnZ5n6xWaBABLiY0ErjXwucf0nQYJpSHtzrBOG7jB2WX3vzPm63dSa%2FPPwN8rzySA9XwCN4gjr6WCnuaWdtibOYAmn4ojV%2BsG1OXGvz4lLCYykDKo%2BLpkmA8sXOWf7W7JLarEbZeW89Zgvz7QwP5JdtcdOtUB8zLUROq9hdSiyfYwp%2B5MbyCjeI3bOAcOUAa1Kc7VVjzUC0vP9T1Z7HT1VEQgfibgxf8nT8Uf3hz1moc%2BAQ%2BuQ%3D%3D" +
				"&__VIEWSTATEENCRYPTED=" +
				"&__PREVIOUSPAGE=P16v5iwpdO9VmkX2uuAKCPHkYWdOCvd0snFxvl9RIog7U-ACGOK9-nCIb8IbZuFDMAjKMWaXDqBmG9go-4NhGm-oHm0pDyim9P81C-ueN6txPdBj0" +
				"&__EVENTVALIDATION=vBTjd4bwo5jugzU0wouodduwlY9gyiXSxyaiax4fcMfFzmJn7mughLpFFX56zs8TR25vdipzqPLka7ukAbxe3TylzZSjUziysABSwEeqMvCooczp66BDEse9rz05LlPXAQz1k6jAg23KJCaM94t2RoMEn%2FZOaWwiqiiq8AwG2IvU0oOSARAFdq63DxilIh1YZYghzMBXhJ1%2F6jndh%2FJeFflUN2s%3D";
		String requestHeader0047 = "POST " + requestFile0047 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0047.length() + "\r\n" + 		// Content-Length: 1838
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0047, requestHost0047, requestPort0047, requestHeader0047, requestContent0047.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
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
		requestHeader0047 = null;		// support garbage collector to reduce memory
		requestContent0047 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 14965
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Please provide 16 digits with or without dashes");		// Test [47] <- Index 47
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
		String requestProt0048 = "http";
		String requestHost0048 = "cldemo.apicasystem.com";
		int    requestPort0048 = 80;
		String requestFile0048 = "/ScriptResource.axd" +
				"?d=jOGxQGN59jALlw_Z1PRxPfmS-Xppvs8izQfuNMHYj35_zT6Zd3JCd5GnuBy_KVgc3vcdXbkfuK0SsSvYck6nRpmvO8TXLM9OC4xICzx9PeHHLdOSU5QqsTI9r7E0Th_QhpDzrlKE2Xt8LScmVEPDBF4RJyg1" +
				"&t=362a7238";
		String requestHeader0048 = "GET " + requestFile0048 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5479
		// content test algorithm: check size +/- 5%, defined content size = 5479
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, 5479, 5);		// Test [48] <- Index 48
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0049 = "www.google-analytics.com";
		int    requestPort0049 = 443;
		String requestFile0049 = "/__utm.gif" +
				"?utmwv=5.6.7" +
				"&utms=5" +
				"&utmn=472279404" +
				"&utmhn=cldemo.apicasystem.com" +
				"&utmt=tran" +
				"&utmtid=952125" +
				"&utmtst=CLDemo" +
				"&utmtto=2600" +
				"&utmttx=1" +
				"&utmtsp=3" +
				"&utmtci=Santa%20Monica" +
				"&utmtrg=California" +
				"&utmtco=USA" +
				"&utmcs=UTF-8" +
				"&utmsr=1680x1050" +
				"&utmvp=960x876" +
				"&utmsc=24-bit" +
				"&utmul=en-gb" +
				"&utmje=1" +
				"&utmfl=22.0%20r0" +
				"&utmdt=Pay%20and%20check%20out" +
				"&utmhid=8065912" +
				"&utmr=0" +
				"&utmp=%2FCheckout%2FPayAndCheckout.aspx" +
				"&utmht=1472071883734" +
				"&utmac=UA-48859361-1" +
				"&utmcc=__utma%3D27385454.343109540.1471356895.1472071846.1472071846.1%3B%2B__utmz%3D27385454.1472071846.1.1.utmcsr%3D(direct)%7Cutmccn%3D(direct)%7Cutmcmd%3D(none)%3B" +
				"&utmjid=" +
				"&utmu=qAALAAAAAAAAAAAAAAAAAAAE~";
		String requestHeader0049 = "GET " + requestFile0049 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.google-analytics.com\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 35
		// content test algorithm: check size +/- 5%, defined content size = 35
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 35, 5);		// Test [49] <- Index 49
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0050 = "www.google-analytics.com";
		int    requestPort0050 = 443;
		String requestFile0050 = "/__utm.gif" +
				"?utmwv=5.6.7" +
				"&utms=4" +
				"&utmn=1523990152" +
				"&utmhn=cldemo.apicasystem.com" +
				"&utmcs=UTF-8" +
				"&utmsr=1680x1050" +
				"&utmvp=960x876" +
				"&utmsc=24-bit" +
				"&utmul=en-gb" +
				"&utmje=1" +
				"&utmfl=22.0%20r0" +
				"&utmdt=Pay%20and%20check%20out" +
				"&utmhid=8065912" +
				"&utmr=0" +
				"&utmp=%2FCheckout%2FPayAndCheckout.aspx" +
				"&utmht=1472071883729" +
				"&utmac=UA-48859361-1" +
				"&utmcc=__utma%3D27385454.343109540.1471356895.1472071846.1472071846.1%3B%2B__utmz%3D27385454.1472071846.1.1.utmcsr%3D(direct)%7Cutmccn%3D(direct)%7Cutmcmd%3D(none)%3B" +
				"&utmjid=" +
				"&utmu=qAAAAAAAAAAAAAAAAAAAAAAE~";
		String requestHeader0050 = "GET " + requestFile0050 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.google-analytics.com\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 35
		// content test algorithm: check size +/- 5%, defined content size = 35
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 35, 5);		// Test [50] <- Index 50
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0051 = "www.google-analytics.com";
		int    requestPort0051 = 443;
		String requestFile0051 = "/__utm.gif" +
				"?utmwv=5.6.7" +
				"&utms=6" +
				"&utmn=114728826" +
				"&utmhn=cldemo.apicasystem.com" +
				"&utmt=item" +
				"&utmtid=952125" +
				"&utmipc=TICK1337" +
				"&utmipn=Football%20Ticket" +
				"&utmiva=Tickets" +
				"&utmipr=400" +
				"&utmiqt=2" +
				"&utmcs=UTF-8" +
				"&utmsr=1680x1050" +
				"&utmvp=960x876" +
				"&utmsc=24-bit" +
				"&utmul=en-gb" +
				"&utmje=1" +
				"&utmfl=22.0%20r0" +
				"&utmdt=Pay%20and%20check%20out" +
				"&utmhid=8065912" +
				"&utmr=0" +
				"&utmp=%2FCheckout%2FPayAndCheckout.aspx" +
				"&utmht=1472071883735" +
				"&utmac=UA-48859361-1" +
				"&utmcc=__utma%3D27385454.343109540.1471356895.1472071846.1472071846.1%3B%2B__utmz%3D27385454.1472071846.1.1.utmcsr%3D(direct)%7Cutmccn%3D(direct)%7Cutmcmd%3D(none)%3B" +
				"&utmjid=" +
				"&utmu=qAALAAAAAAAAAAAAAAAAAAAE~";
		String requestHeader0051 = "GET " + requestFile0051 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.google-analytics.com\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 35
		// content test algorithm: check size +/- 5%, defined content size = 35
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 35, 5);		// Test [51] <- Index 51
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		log();
		log("# title: Pay and check out");
		String requestProt0052 = "http";
		String requestHost0052 = "cldemo.apicasystem.com";
		int    requestPort0052 = 80;
		String requestFile0052 = "/Checkout/PayAndCheckout.aspx";
		String requestContent0052 = 
				"__EVENTTARGET=" +
				"&__EVENTARGUMENT=" +
				"&__VIEWSTATE=%2FwEPDwULLTE1OTMxMDgyMzAPZBYCZg9kFgICAw9kFgYCDQ9kFgJmD2QWAgIBDxYCHgRUZXh0BQkyIHRpY2tldHNkAhQPZBYCAgEPZBYCAgEPZBYCAgEPZBYEZg9kFgJmDw8WAh8ABQEyZGQCAQ9kFgJmDw8WAh8ABQQyNjAwZGQCGQ8WAh4LXyFJdGVtQ291bnQCARYCZg9kFgICAQ8WAh4Dc3JjBRh%2BL0ltYWdlcy9Mb2dvcy9henVyZS5wbmdkZPQObD%2FsXptGww0FKc%2FWbuaX94oj" +
				"&__PREVIOUSPAGE=X1D7lKVFLKxnD6o_HB8q5Ns9XEjJFfkeGqyX9qfSrRiknf_6dIU2GcQBEZJC2_2s5c4fb8f25Wy4fcw19HArtH0QotjOiPpKlQEmmXaEa9FDBZ8n0" +
				"&__EVENTVALIDATION=%2FwEdAPsBDDHRo9334Li9wMIiaDXlml27k2ajaruFLYNWQx%2BHeFEqkvdsY5v6fLjty194vGALawGdIoTjiIP%2FmjgfIrjPlV5Sb0ZChIHd9vGj1hUh9M3%2FgsEAZuvsLqaPpX0pvQML21va6msjUtv5NBLKYe6%2BTaJ1rv5LEWnAXC%2BPmtfuXCti7f2%2BS7SHP2lzGb4vmbrKOCvh07sBdB61tBsSK4yj%2BAyrKeKT%2FoXfjFf%2Bhhsuu4uFT37wxzasB84iHCmiEpyZXRKJ%2FDwFN7kEwhWY3OtiJ6lqisFRkeX20lx6Gj%2BU2qGl3F%2FLwkaiu1cRQp5EeSILjDRtyBlReffBp62AZYAw0NH83NukK7iHnZGsAvhnZcKYYxLAcqSZORcDiM%2B%2BVvyhihIdBkP1EztC20ruX17qf5jfM8UJ28BMMxm65K%2BKUhmKbniTWKs800KspMJCvB6zQn2RlQD%2BG%2FiKPNo6P4wlQEFr0Ra3Prs0Ad8XFN9jqJ7bTfQWqjsJjVB%2Fh7%2FmNYzFbg%2B66eT9892HQisI7w%2FYHdITx8%2FEVstLnNM%2BjL5laSKku4n6ap5A39csaW1i61dT0SqQExWxGmMmcGkadyMBJ0RO5c1n8wD4L8T%2FCUiAVNKhmW1n25fGtes6ak1WLANCsVyReWdqZsISC8BuyPxSNRBSRgBFWHYOBc%2Bjeq79L9IVsBJSqAAmekQ5tzZG2ahJyv%2FpUDKGBMd5PGZZIFFysNsy1YISWFDEOMNEO6CFa3bUCLmChYsbslMeMbYgyW3%2FrSvG2pOBx%2FN%2F3C50QEZURvybVjlyh9eYEzAkb14ZpJM2eIc3gao0dnKuZp4HLwxvzwgF%2FNMLLStVEJy5dBTyJ0taaX1XUftEfQycovHyT0HWrGADC8s%2B8XrlZX3Qu1vBoITfUkXQLYgB5rE5qT5uSfvglNZeepFIagXSq86NfD0glZxEj58Vs4UCC0q4pRXb6lv2epqa6So8EHmdSxtx%2Bin452T8EkbBkUnoOCGQdH91gVfIPdpGll9BpBj5A5SDt14ItYQOe778bVlrp5jrXezwz4kK8%2BeVOnGExuaY0N3R1xAUYc1zzJDC4qLDx7nyTBejS%2Btnxs%2BxKJ7Riq5D9p6Qx%2FkeetqSABwLmhZ4gG0FC5h%2BvFi2%2BMT90ONtRJy9RLK8Lx4z0AXyU%2BNwW5K9yEqPXcKXv0Gtw2EHXttkuSkj6pvHsY0D8DMWikicjKr6pB2QB8ZSwFwNvyitijkisMb%2FWxSSruKYA74Jf7dsGSuPDpjRy7%2BD%2BzvyQia7cs0BPPnqyNy1MB%2FjwjyidXXG%2BWcEkVyRfjnUjVMJqyMIS0VoecFbQrylwvUcuQ%2FzSCxrl%2BJEsEjJ%2Br62yPM7Xhm%2FcwyA0OZBRtznHpGMg4WgcTrhHBWJwD3F%2FnSmHUatvmyRv%2FLL4MJJr5ZA47340kXH4WgNRLA2JG9CRdXW0jgtmQ%2FwEncP65uDMQJ1TU9XaiQ3osXpCYzh3PcJNCvmNqb%2F0SgcNvPvHsRdQRPUSCU33Ld34YqQfxSmWz7Q7%2BajpKoNViE2aanpCQG6%2FDXjQBnvcwOBsGw%2B7wumXbImX5%2BV22re%2F5QlxBHBJrjIJpUi%2BsVlEX5kVReXovDxk0szLcV41TPynqtV3Fg585uP42zQBxv3ZVQR2U8sPw%2B5otyF9Uzz7OEsf%2Fm99vwPaPA3w6cjLS5ap1kebN0yhsfaHyPtFalhJy%2BTB%2BAP5CuhUaXY0oEwhZ9xQsSm5HCIqaxQtUXtGvXH1E7LbQ%2BfDbJP%2F36JlC832rcsKFo8Nl3e3%2BaEvyY3APfCFovvDfa2Y%2B2BYDVQ6HsTEy9fo6fbCGaQER6Fqu6VnY2G6u7H2gb%2FnGoIIk%2FHUDX47D8oeV3oJC9YOQqjHHxDGi3WpGUpXwa01EHeEBud83zfVq8Xc8zgTZPvsAPgyktVR%2BsW%2BisPGo51t%2FUYYhrodJ8XjlSJHp2zM1AmwYPeQLcBw1gSpBvYRlvpt94HcgA6XRVaJkCmdxsGRF6EQKDHNz7GoUTXt%2Br8OQOCDScFHz14DNR2MZPNo9vjGslh1d7A9%2FnxkSb3%2BsyI3h0lzN2nbqaecfyKOqC3qOqxFkAwUnFZVlEfzaHMqqAjdQskKculpwBHvktJbAlz2crROwSkfV3UcHBkMQcjaK72EwkzRMjGCBgA0G2iJf5GmccFBQ4Ll9WSqsq7clmJgEABPdwrfyhRcF%2BPBTomHsD6ocQj3EX3aoaC2BPRnlvuw1dzaGCnqAc6Du%2B6Thn09zMF5z%2FwDX6Mrc%2FmBu9ONrswrsJurXlQjzTOnLY37%2FOPd8LN6J5kLtetQEKOoF1IkN%2FGHPxXaw3YwOaQMHBPme%2FNNB4vRxXK%2Fx6IY4AoTdaOGm2G1EXyqM4bWWs4tabIa9ZfhSoJOlbWKGl2VgdqH07NgeyuQpRxTURPcxHwTgKcjDJl2QkBizI76S%2FyeOqSIs0TdhrcHE5Jirqwo492F4LoAM5HHeym9c2dzjcCVm37p7ByzyytPcUeWmTm860YZZf82oFxBX2Eygg8JTl8TEiy5zML8q6L932wFHRZIgzRavNBHRX5VPJk%2Bct72nY6Kb%2BJ4hLFDmCHfP9uyy728aUbDCwqwXlf37OyeS0uEDEL7faMuOKgwSSOpx8FxXIuS3WvQD7zDF6CAtVMykapVDoxsBS8snofaIj4agGLVrAdU6nsiEr3FF0gQJK%2BF26SWBGglljkmoomet2TPpbbZQw1ZkrnyzL5qw%2B5p5weE3WEkGakSh7ck6%2BnoU1FkkMwja7ELFo%2F3cZ%2BLhYojAl4leQHCVIUoVRuzuEF%2B3WOWbrwohl9KSDSaBwrBvpSOAxgYOlhtUFomre4Wq3QrBfuNJjQorhsX5Jz8tugihW3Zc4vuVhtSuJXMNH5xT5QFFq2EE%2FyBEtbaeTdz%2BRtQ51hW2YMNlGOBNCBAUkysLZduwhJ3YTwGHu7S%2BbUj3Slv1XVrpIECBWvh%2FEjsCR02o8Jk2AhB7MCFjpCD5aDeyq8hPaRb8BOlC7J9YcRP0mkVg09GtjszfuveFN98twCjTHry1IDXBgRGgGCZpJ8Iv2ZGRc%2FhTJhB76NGOa9HR9gLauIE6ZdLGZr94QGhu%2BUby4LEQzgedtjwUXcyTWH5tlfsEcOMrFyOPLDfzB3W0jJ5JMNds2pJF5OFd3TbS7c%2F147lt1igBzskSZGkGnN7GHTbqm70PhHamo8PPNIcfIT962iyj4nic5Q12xHW7%2BKku0C5EdrkhlIhn1c9Ak%2Bo9GhekeOM%2F1A3J9Znd6j5BMCfAfvZLQNryky4UY09flQVPlxR5asRH%2Fd7zNJfxtaOv1wCoqwrxfSTSS6n1Wxkbxc2xqkZYkPk3yNjTigaloY0qOcUcO8XSEsurkR32UhaQDEitrlRXtIRwjv%2BixoFDAxrFDIg4cwUS1q7P1KRtm4Ph%2F8e4RoP%2FZEjPHmsBbQkbpP%2BjU0HV65dmZ8ubKZRSdDJNzjxYqB0FNNk%2FdJ5diZrjfJIsPuh4NAhlT%2BCi6PcDmt4TrarRwxM6%2FocLxPNfRiwXKK6XHapB26AQxd3CYo3HKpJwrSy6iekUCU1pljh7zQMAEFsJrIv3aONqis3a317lxEo0cwC%2BwhVQG%2BL8aE9kPmD4AGlfrJZCt7YZ%2Fq5J%2FArJ5IirewQzLyYAAtLPHqt%2BZ57roqC0182vvbnonpDsU6O8xomzpJxRPZDvpQhu2%2BmDhrVnAqwOMKY8I6JMO5%2BwQBshZjyfqfU6Hw0c9tgp4PoWoNslAvI08mr2M3APWt3sf0Yy2Xzq40vx2K7h4XQAzDCKbNWRCO%2BRkJRdVPaCnJPmcHtPkl0%2BqBTTFgshhFowgfjwQXKU8Tn9iNrO3lLkPUbwN3VD2ayX%2BTCFLsjtowkWnHnKeQhgIEIrGJbB1PCpY7mMSXZhRCeBcKKQ5VKKgLPRTjpSbyPf6dCMIiduKr8t93xQrKHxCbCeeZY%2FiMsGFjiuh4s3pNSvVuZOVkAy7aGByNsRMUXZ%2BP0BcvLVfmmHK10HXlu7alfDKIjlYP%2BjdVhXCrv8ILdRRqwXCfEzONto2UUBCYdYQQUts%2FKj48y11asDbZ8NnebvSmqGs6nF4YCBp8Xb5dcAsetyRu%2B7PYQaOzYv%2F7i%2FxELEBOkDAsymU1zmrGMHMqyEd%2FueAdd30aoFuVxfR7MnB0vLjJjCBEviy8VuAckM9K6F8ePynuE7J0JKMvhwnf3D2w6EZyncPmwxEcKWkgcLh3Hx2ReDdnobTp77rWPAnSh%2FUEvc1tyOALbe3W0SFes8X7kfFCGgwRsAu37wAaLxoelv1l8BqV9l5pLEIpARc5eaZihUlyJCR5ALcdJ3m4uUN1DF4bynLKBFSSv%2FSpo%2FegAeEDCpPcG%2BtI1wkTwhGNN%2FSeQhA9UKPBUo%2FDifB9OEuSPTmr5rW7UdNFohcF569802%2FDR3xm714nVDNZzc0up%2Fvn7DPOXZxWM%2FBqfnZDnDRKawKPYvBNA2JKxvOtYlqUVrrHUbF5f4npOUlgwK7J%2Fb8UQgYkK%2B1%2BrZcyEZtjt1FdT%2FmGti2p%2Fp4H9xLOCFqcjSarh4GtyDLjWxz2v5KS7R87%2F8syWzaFJwwJdHf2pYOaqVN4MfdhoL340VcHih4SjfxlEZJkVO4Zqnjl3mYAizkYB0YDycbmuSAxT62zq%2BrNOxo%2FGwx3h0%2Bf9DwxkJhXLmG4f3h8V%2BVdt7WLTygVgpAVeo6ygS1PdtG65fCBPd8W2k0CSr%2B36bcrAqbsgNGWJ3ftQjx3LadnhU7Ydyj9ypR5q1ofxfEAfJZMkcs8VH0ftCPMgv9OoLgkndEf8Wb2giA9gjDq05IAuHogbjhBm1U4ILX0kUs1bcSfNY5wZDEkZqULVE15eSNDTmpv4Q7nb6R0%2BcLCtq0OEk5TctA0XaPpaQsTYh2nl%2F%2B%2Bsm9GEjWDvnt2%2F8FPtB5fexD1ML%2F1le7PJyDmzQuN0WGHK1awmq14KroxeLfq7Jo9W0Ev09Z0GlBFyGrZVXjyn3Pjy4XlWZoVZhwE21mzeaOwbCchj%2Fz7pKnCDTHGL%2BuJLcVYGPmjIK5HNhhiqzDV0mWMF0tmKOD27%2FBZeNqnbDLYgQ7GjtUL6BbKRiF%2Fi7yaLW%2FYas8qs2Ka5aNt6MaRhGY01CaRrem5xggcuLFTl7HWDNdyauouityFTBgWxid7EpoMvh7CSJ0CVg8%2BWgMH%2BwbiWVhTUziNO8fHhOygI3rb9yliYqezr45EI0otr2NHRxEAGR7WxERtfHUqjHKau%2BQN7l3Ac86tbp4w8klyBcggKU6zhPHotxY3T3a2f9ij%2FIPXgCHOYsCEAZwa9rOxvhzzYRpWf11X%2F2Vv3G0UZO%2Fd1Dv61Nm9xfklcqY855WPGyeUgHR54WUYcj3d5it6OTVu5g%3D%3D" +
				"&ctl00%24MainContent%24FirstNameTextBox=Amir" +
				"&ctl00%24MainContent%24LastNameTextBox=Ashfaq" +
				"&ctl00%24MainContent%24AddressLineOneTextBox=wff" +
				"&ctl00%24MainContent%24AddressLineTwoTextBox=" +
				"&ctl00%24MainContent%24PostalCodeTextBox=3456" +
				"&ctl00%24MainContent%24CountryDropDownList=AF" +
				"&ctl00%24MainContent%24CardTypeRadioButtonList=MasterCard" +
				"&ctl00%24MainContent%24CardNumberTextBox=8976543209876543" +
				"&ctl00%24MainContent%24SubmitButton=Submit";
		String requestHeader0052 = "POST " + requestFile0052 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: cldemo.apicasystem.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Type: application/x-www-form-urlencoded\r\n" + 
				"Content-Length: " + requestContent0052.length() + "\r\n" + 		// Content-Length: 6638
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0052, requestHost0052, requestPort0052, requestHeader0052, requestContent0052.getBytes(), requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
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
		requestHeader0052 = null;		// support garbage collector to reduce memory
		requestContent0052 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 4226
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Thanks a lot for your order. Here is your receipt.");		// Test [52] <- Index 52
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





		// --- HTTP REQUEST: Test [53] <- WEB ADMIN Index 53 ---
		String requestProt0053 = "https";
		String requestHost0053 = "www.google-analytics.com";
		int    requestPort0053 = 443;
		String requestFile0053 = "/__utm.gif" +
				"?utmwv=5.6.7" +
				"&utms=7" +
				"&utmn=396361648" +
				"&utmhn=cldemo.apicasystem.com" +
				"&utmcs=UTF-8" +
				"&utmsr=1680x1050" +
				"&utmvp=960x876" +
				"&utmsc=24-bit" +
				"&utmul=en-gb" +
				"&utmje=1" +
				"&utmfl=22.0%20r0" +
				"&utmdt=Pay%20and%20check%20out" +
				"&utmhid=1662651357" +
				"&utmr=0" +
				"&utmp=%2FCheckout%2FPayAndCheckout.aspx" +
				"&utmht=1472071919412" +
				"&utmac=UA-48859361-1" +
				"&utmcc=__utma%3D27385454.343109540.1471356895.1472071846.1472071846.1%3B%2B__utmz%3D27385454.1472071846.1.1.utmcsr%3D(direct)%7Cutmccn%3D(direct)%7Cutmcmd%3D(none)%3B" +
				"&utmjid=" +
				"&utmu=qAAAAAAAAAAAAAAAAAAAAAAE~";
		String requestHeader0053 = "GET " + requestFile0053 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.google-analytics.com\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 35
		// content test algorithm: check size +/- 5%, defined content size = 35
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 35, 5);		// Test [53] <- Index 53
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
	 * Recorded http requests of page #2.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// # Page #2: Done
		// # -------------



		// --- HTTP REQUEST: Test [55] <- WEB ADMIN Index 55 ---
		String requestProt0055 = "https";
		String requestHost0055 = "aus5.mozilla.org";
		int    requestPort0055 = 443;
		String requestFile0055 = "/update/3/Firefox/47.0.1/20160623154057/Darwin_x86_64-gcc3-u-i386-x86_64/en-GB/release/Darwin%2015.6.0/default/default/update.xml";
		String requestHeader0055 = "GET " + requestFile0055 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: aus5.mozilla.org\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0055, requestHost0055, requestPort0055, requestHeader0055, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0055 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/XML", header text fragment = [verification disabled], recorded content size = 553
		// content test algorithm: check size +/- 5%, defined content size = 553
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/XML", null, 553, 5);		// Test [55] <- Index 55
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





		// --- HTTP REQUEST: Test [56] <- WEB ADMIN Index 56 ---
		String requestProt0056 = "http";
		String requestHost0056 = "download.mozilla.org";
		int    requestPort0056 = 80;
		String requestFile0056 = "/" +
				"?product=firefox-48.0.2-complete" +
				"&os=osx" +
				"&lang=en-GB";
		String requestHeader0056 = "GET " + requestFile0056 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: download.mozilla.org\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Range: bytes=0-299999\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0056, requestHost0056, requestPort0056, requestHeader0056, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0056 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 127
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [56] <- Index 56
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





		// --- HTTP REQUEST: Test [57] <- WEB ADMIN Index 57 ---
		String requestProt0057 = "http";
		String requestHost0057 = "download.cdn.mozilla.net";
		int    requestPort0057 = 80;
		String requestFile0057 = "/pub/firefox/releases/48.0.2/update/mac/en-GB/firefox-48.0.2.complete.mar";
		String requestHeader0057 = "GET " + requestFile0057 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: download.cdn.mozilla.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Range: bytes=0-299999\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0057, requestHost0057, requestPort0057, requestHeader0057, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0057 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 206, content type = "APPLICATION/OCTET-STREAM", header text fragment = [verification disabled], recorded content size = 300000
		// content test algorithm: check size +/- 5%, defined content size = 300000
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {206}, "APPLICATION/OCTET-STREAM", null, 300000, 5);		// Test [57] <- Index 57
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
		
		String genericFileName = PerformanceData.proposeFileName("AzeemTest1", concurrentUsers);
		
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
		if (debugLoops || debugFailedLoops)
		{
		}
		System.out.println();
		
		
		
		// --------------------------
		// *** start of load test ***
		// --------------------------
		
		
		// initialize performance data
		// ---------------------------
		final int PAGE_BREAKS = 2;  // number of page breaks in execute()  - modify this value if you add or delete some page breaks
		final int MAX_THREAD_STEPS = 56;  // number of URL requests in execute() - modify this value if you add or delete some requests
		performanceData = new PerformanceData(PAGE_BREAKS, MAX_THREAD_STEPS, concurrentUsers, -1, plannedTestDuration, maxPlannedLoops, httpProtocolVersion, plannedStartupDelay, plannedRequestTimeout, samplingInterval, percentilePageSampling, percentileUrlSampling, percentileUrlSamplingAddOption);
		performanceData.setInfoText("AzeemTest1");
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
				
				AzeemTest1 simulatedUser = new AzeemTest1(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
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
				
				AzeemTest1 simulatedUser = new AzeemTest1(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
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




}	// end of class

