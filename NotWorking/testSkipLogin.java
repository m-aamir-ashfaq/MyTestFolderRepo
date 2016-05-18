
// *********************************************************************************************
//
// Automatically Generated Load Test Program
// -----------------------------------------
//
// Source: testSkipLogin.java
// Date  : 20 Apr 2016 10:20:49 ECT
// Author: Apica ZebraTester V5.4-J / automatically generated
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
public class testSkipLogin extends HttpLoadTest implements Runnable, ThreadStepInterface, SetThreadStepInterface, SSLSessionCacheStatisticInterface, VaryingLoadInterface, VaryingTestDurationInterface, SuspendResumeInterface, GetRealTimeUserInputFieldsInterface
{
	public static final String prxVersion = "V5.4-J";
	public static final int    prxCharEncoding = 2;                         // 1 = OS Default, 2 = ISO-8859-1, 3 = UTF-8
	public static final String testDescription = "";

	public static String USER_AGENT_1 = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:45.0) Gecko/20100101 Firefox/45.0";

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
	private static final String EXTERNAL_PARAM_FILE = "testSkipLoginExtParams.dat";         // input file name for very large parameter values
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
	public testSkipLogin()
	{
		super();
	}


	/**
	 * constructor: called when a user is created (per user).
	 */
	public testSkipLogin(int maxLoops, int requestTimeout, int threadNumber)
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
		log("# Page #1: Start");
		log("# --------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #1: Start", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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



		// --- PAGE BREAK: Test [73] ---
		log();
		log();
		log("# Page #2: afterlogin");
		log("# -------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #2: afterlogin", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
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
		if (!executePage_2_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 2 failed
			synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_2_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 2 failed
			synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_2_5(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
		{
			// execution of page 2 failed
			synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_2_6(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
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
		// # Page #1: Start
		// # --------------



		// --- HTTP REQUEST: Test [1] <- WEB ADMIN Index 1 ---
		String requestProt0001 = "https";
		String requestHost0001 = "www.flickr.com";
		int    requestPort0001 = 443;
		String requestFile0001 = "/";
		String requestHeader0001 = "GET " + requestFile0001 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 48906
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Find beautiful photos shared by a community of amateur and professional photographers.");		// Test [1] <- Index 1
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
		String requestHost0002 = "www.flickr.com";
		int    requestPort0002 = 443;
		String requestFile0002 = "/javascript/rapidworker-1.2.js";
		String requestHeader0002 = "GET " + requestFile0002 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 6868
		// content test algorithm: check size +/- 5%, defined content size = 6868
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, 6868, 5);		// Test [2] <- Index 2
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0003 = "s.yimg.com";
		int    requestPort0003 = 443;
		String requestFile0003 = "/uy/build/images/pxl.gif";
		String requestHeader0003 = "GET " + requestFile0003 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 43
		// content test algorithm: check size +/- 5%, defined content size = 43
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 43, 5);		// Test [3] <- Index 3
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0004 = "s.yimg.com";
		int    requestPort0004 = 443;
		String requestFile0004 = "/zz/combo" +
				"?yui:3.16.0/yui/yui-min.js" +
				"&uy/build/hermes-1.1.452/loader-hermes/loader-hermes-min.js";
		String requestHeader0004 = "GET " + requestFile0004 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 57612
		// content test algorithm: check size +/- 5%, defined content size = 57612
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 57612, 5);		// Test [4] <- Index 4
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0005 = "s.yimg.com";
		int    requestPort0005 = 443;
		String requestFile0005 = "/uy/build/images/sprites/icons-36c2f8d6.png";
		String requestHeader0005 = "GET " + requestFile0005 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 121350
		// content test algorithm: check size +/- 5%, defined content size = 121350
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 121350, 5);		// Test [5] <- Index 5
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0006 = "s.yimg.com";
		int    requestPort0006 = 443;
		String requestFile0006 = "/uy/build/images/sprites/general-d6bcdcb0.png";
		String requestHeader0006 = "GET " + requestFile0006 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1421
		// content test algorithm: check size +/- 5%, defined content size = 1421
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 1421, 5);		// Test [6] <- Index 6
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0007 = "s.yimg.com";
		int    requestPort0007 = 443;
		String requestFile0007 = "/uy/build/images/sohp/hero/persist3.jpg";
		String requestHeader0007 = "GET " + requestFile0007 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 158298
		// content test algorithm: check size +/- 5%, defined content size = 158298
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 158298, 5);		// Test [7] <- Index 7
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0008 = "c4.staticflickr.com";
		int    requestPort0008 = 443;
		String requestFile0008 = "/8/7325/buddyicons/22461382@N00_l.jpg";
		String requestHeader0008 = "GET " + requestFile0008 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c4.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 17004
		// content test algorithm: check size +/- 5%, defined content size = 17004
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 17004, 5);		// Test [8] <- Index 8
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0009 = "s.yimg.com";
		int    requestPort0009 = 443;
		String requestFile0009 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/pure-css/pure-css-min.css" +
				"&uy/build/hermes-1.1.452/loaded-state-css/loaded-state-css-min.css" +
				"&uy/build/hermes-1.1.452/sohp-css/sohp-css-min.css" +
				"&uy/build/hermes-1.1.452/global-nav-css/global-nav-css-min.css" +
				"&uy/build/hermes-1.1.452/util-css/util-css-min.css" +
				"&uy/build/hermes-1.1.452/search-autosuggest-field-css/search-autosuggest-field-css-min.css" +
				"&uy/build/hermes-1.1.452/search-autosuggest-items-list-css/search-autosuggest-items-list-css-min.css" +
				"&uy/build/hermes-1.1.452/autosuggest-css/autosuggest-css-min.css" +
				"&uy/build/hermes-1.1.452/notifications-menu-css/notifications-menu-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-css/fluid-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-animations-css/fluid-animations-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-tables-css/fluid-tables-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-toggles-css/fluid-toggles-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-subnav-css/fluid-subnav-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-chalkboard-css/fluid-chalkboard-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-modal-css/fluid-modal-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-modal-nav-bar-css/fluid-modal-nav-bar-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-balls-css/fluid-balls-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-droparound-css/fluid-droparound-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-util-css/fluid-util-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-dots-css/fluid-dots-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-notification-css/fluid-notification-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-coverphoto-css/fluid-coverphoto-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-overlay-css/fluid-overlay-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-share-css/fluid-share-css-min.css" +
				"&uy/build/hermes-1.1.452/account-menu-css/account-menu-css-min.css" +
				"&uy/build/hermes-1.1.452/flickrui-css/flickrui-css-min.css" +
				"&uy/build/hermes-1.1.452/person-card-css/person-card-css-min.css" +
				"&uy/build/hermes-1.1.452/group-card-css/group-card-css-min.css";
		String requestHeader0009 = "GET " + requestFile0009 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 37941
		// content test algorithm: check size +/- 5%, defined content size = 37941
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 37941, 5);		// Test [9] <- Index 9
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0010 = "s.yimg.com";
		int    requestPort0010 = 443;
		String requestFile0010 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/signup-modal-css/signup-modal-css-min.css" +
				"&uy/build/hermes-1.1.452/signup-interstitial-css/signup-interstitial-css-min.css" +
				"&uy/build/hermes-1.1.452/footer-full-css/footer-full-css-min.css" +
				"&uy/build/hermes-1.1.452/flickrui-dialogs-css/flickrui-dialogs-css-min.css" +
				"&uy/build/hermes-1.1.452/account-menu-card-css/account-menu-card-css-min.css";
		String requestHeader0010 = "GET " + requestFile0010 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 4336
		// content test algorithm: check size +/- 5%, defined content size = 4336
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 4336, 5);		// Test [10] <- Index 10
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0011 = "s.yimg.com";
		int    requestPort0011 = 443;
		String requestFile0011 = "/uy/build/fonts//ProximaNova-Reg-webfont-v2.woff";
		String requestHeader0011 = "GET " + requestFile0011 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/FONT-WOFF", header text fragment = [verification disabled], recorded content size = 22232
		// content test algorithm: check size +/- 5%, defined content size = 22232
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/FONT-WOFF", null, 22232, 5);		// Test [11] <- Index 11
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0012 = "s.yimg.com";
		int    requestPort0012 = 443;
		String requestFile0012 = "/uy/build/fonts//ProximaNova-Sbold-webfont-v2.woff";
		String requestHeader0012 = "GET " + requestFile0012 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/FONT-WOFF", header text fragment = [verification disabled], recorded content size = 22024
		// content test algorithm: check size +/- 5%, defined content size = 22024
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/FONT-WOFF", null, 22024, 5);		// Test [12] <- Index 12
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0013 = "s.yimg.com";
		int    requestPort0013 = 443;
		String requestFile0013 = "/uy/build/fonts//ProximaNova-Light-webfont-v2.woff";
		String requestHeader0013 = "GET " + requestFile0013 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/FONT-WOFF", header text fragment = [verification disabled], recorded content size = 21432
		// content test algorithm: check size +/- 5%, defined content size = 21432
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/FONT-WOFF", null, 21432, 5);		// Test [13] <- Index 13
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0014 = "s.yimg.com";
		int    requestPort0014 = 443;
		String requestFile0014 = "/uy/build/images/appstores/ios-2.svg";
		String requestHeader0014 = "GET " + requestFile0014 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/SVG+XML", header text fragment = [verification disabled], recorded content size = 4627
		// content test algorithm: check size +/- 5%, defined content size = 4627
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/SVG+XML", null, 4627, 5);		// Test [14] <- Index 14
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0015 = "s.yimg.com";
		int    requestPort0015 = 443;
		String requestFile0015 = "/uy/build/images/sprites/sohp-9ae94c37.png";
		String requestHeader0015 = "GET " + requestFile0015 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 13649
		// content test algorithm: check size +/- 5%, defined content size = 13649
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 13649, 5);		// Test [15] <- Index 15
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0016 = "s.yimg.com";
		int    requestPort0016 = 443;
		String requestFile0016 = "/uy/build/images/appstores/google-2.svg";
		String requestHeader0016 = "GET " + requestFile0016 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/SVG+XML", header text fragment = [verification disabled], recorded content size = 3890
		// content test algorithm: check size +/- 5%, defined content size = 3890
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/SVG+XML", null, 3890, 5);		// Test [16] <- Index 16
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0017 = "c4.staticflickr.com";
		int    requestPort0017 = 443;
		String requestFile0017 = "/8/7771/buddyicons/67617854@N04_l.jpg";
		String requestHeader0017 = "GET " + requestFile0017 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c4.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 19339
		// content test algorithm: check size +/- 5%, defined content size = 19339
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 19339, 5);		// Test [17] <- Index 17
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0018 = "s.yimg.com";
		int    requestPort0018 = 443;
		String requestFile0018 = "/zz/combo" +
				"?yui:3.16.0/classnamemanager/classnamemanager-min.js" +
				"&yui:3.16.0/oop/oop-min.js" +
				"&yui:3.16.0/event-custom-base/event-custom-base-min.js" +
				"&yui:3.16.0/event-base/event-base-min.js" +
				"&yui:3.16.0/dom-core/dom-core-min.js" +
				"&yui:3.16.0/dom-base/dom-base-min.js" +
				"&yui:3.16.0/selector-native/selector-native-min.js" +
				"&yui:3.16.0/selector/selector-min.js" +
				"&yui:3.16.0/node-core/node-core-min.js" +
				"&yui:3.16.0/color-base/color-base-min.js" +
				"&yui:3.16.0/dom-style/dom-style-min.js" +
				"&yui:3.16.0/node-base/node-base-min.js" +
				"&yui:3.16.0/event-delegate/event-delegate-min.js" +
				"&yui:3.16.0/node-event-delegate/node-event-delegate-min.js" +
				"&yui:3.16.0/array-extras/array-extras-min.js" +
				"&yui:3.16.0/attribute-core/attribute-core-min.js" +
				"&yui:3.16.0/event-custom-complex/event-custom-complex-min.js" +
				"&yui:3.16.0/attribute-observable/attribute-observable-min.js" +
				"&yui:3.16.0/attribute-extras/attribute-extras-min.js" +
				"&yui:3.16.0/attribute-base/attribute-base-min.js" +
				"&yui:3.16.0/base-core/base-core-min.js" +
				"&yui:3.16.0/base-observable/base-observable-min.js" +
				"&yui:3.16.0/base-base/base-base-min.js" +
				"&yui:3.16.0/base-build/base-build-min.js" +
				"&yui:3.16.0/history-base/history-base-min.js" +
				"&yui:3.16.0/event-synthetic/event-synthetic-min.js" +
				"&yui:3.16.0/history-hash/history-hash-min.js" +
				"&yui:3.16.0/json-parse/json-parse-min.js" +
				"&yui:3.16.0/json-stringify/json-stringify-min.js" +
				"&yui:3.16.0/history-html5/history-html5-min.js" +
				"&yui:3.16.0/querystring-parse/querystring-parse-min.js" +
				"&yui:3.16.0/router/router-min.js" +
				"&uy/build/hermes-1.1.452/pjax-base-patched/pjax-base-patched-min.js" +
				"&yui:3.16.0/view/view-min.js" +
				"&yui:3.16.0/app-base/app-base-min.js" +
				"&yui:3.16.0/querystring-stringify-simple/querystring-stringify-simple-min.js" +
				"&yui:3.16.0/io-base/io-base-min.js" +
				"&yui:3.16.0/pjax-content/pjax-content-min.js" +
				"&yui:3.16.0/app-content/app-content-min.js" +
				"&yui:3.16.0/timers/timers-min.js" +
				"&yui:3.16.0/promise/promise-min.js" +
				"&uy/build/hermes-1.1.452/fletrics/fletrics-min.js" +
				"&uy/build/hermes-1.1.452/flickr-promise/flickr-promise-min.js";
		String requestHeader0018 = "GET " + requestFile0018 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 40061
		// content test algorithm: check size +/- 5%, defined content size = 40061
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 40061, 5);		// Test [18] <- Index 18
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0019 = "s.yimg.com";
		int    requestPort0019 = 443;
		String requestFile0019 = "/uy/build/javascripts/flickr-router-bf89539d.js";
		String requestHeader0019 = "GET " + requestFile0019 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0019, requestHost0019, requestPort0019, requestHeader0019, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0019 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 8449
		// content test algorithm: check size +/- 5%, defined content size = 8449
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 8449, 5);		// Test [19] <- Index 19
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0020 = "c4.staticflickr.com";
		int    requestPort0020 = 443;
		String requestFile0020 = "/8/7622/buddyicons/57513474@N06_l.jpg";
		String requestHeader0020 = "GET " + requestFile0020 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c4.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 6954
		// content test algorithm: check size +/- 5%, defined content size = 6954
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 6954, 5);		// Test [20] <- Index 20
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		// ... continuing page #1 (fragment 2 of 4)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [21] <- WEB ADMIN Index 21 ---
		String requestProt0021 = "https";
		String requestHost0021 = "c2.staticflickr.com";
		int    requestPort0021 = 443;
		String requestFile0021 = "/6/5333/buddyicons/24662369@N07_l.jpg";
		String requestHeader0021 = "GET " + requestFile0021 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 12542
		// content test algorithm: check size +/- 5%, defined content size = 12542
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 12542, 5);		// Test [21] <- Index 21
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0022 = "s.yimg.com";
		int    requestPort0022 = 443;
		String requestFile0022 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/list-proxy/list-proxy-min.js" +
				"&uy/build/hermes-1.1.452/api-helper/api-helper-min.js" +
				"&uy/build/hermes-1.1.452/flickr-api/flickr-api-min.js" +
				"&uy/build/hermes-1.1.452/cycle/cycle-min.js" +
				"&uy/build/hermes-1.1.452/model-import-export/model-import-export-min.js" +
				"&yui:3.16.0/cookie/cookie-min.js" +
				"&uy/build/hermes-1.1.452/better-use/better-use-min.js" +
				"&uy/build/hermes-1.1.452/view-counter/view-counter-min.js" +
				"&uy/build/hermes-1.1.452/flipper/flipper-min.js" +
				"&yui:3.16.0/handlebars-base/handlebars-base-min.js" +
				"&uy/build/hermes-1.1.452/better-handlebars/better-handlebars-min.js" +
				"&uy/build/hermes-1.1.452/url/url-min.js" +
				"&uy/build/hermes-1.1.452/url-helper/url-helper-min.js" +
				"&uy/build/hermes-1.1.452/moment/moment-min.js" +
				"&yui:3.16.0/escape/escape-min.js" +
				"&yui:3.16.0/datatype-number-parse/datatype-number-parse-min.js" +
				"&yui:3.16.0/datatype-number-format/datatype-number-format-min.js" +
				"&uy/build/hermes-1.1.452/intl-messageformat/intl-messageformat-min.js" +
				"&uy/build/hermes-1.1.452/handlebars-helper-intl/handlebars-helper-intl-min.js" +
				"&uy/build/hermes-1.1.452/god-message/god-message-min.js" +
				"&uy/build/hermes-1.1.452/handlebars-helpers/handlebars-helpers-min.js" +
				"&uy/build/hermes-1.1.452/localizable/localizable-min.js" +
				"&uy/build/hermes-1.1.452/experiments-fullscreen/experiments-fullscreen-min.js" +
				"&uy/build/hermes-1.1.452/experiments-opt-out/experiments-opt-out-min.js" +
				"&yui:3.16.0/jsonp/jsonp-min.js" +
				"&uy/build/hermes-1.1.452/murmurhash/murmurhash-min.js" +
				"&uy/build/hermes-1.1.452/moneyball-manager/moneyball-manager-min.js" +
				"&uy/build/hermes-1.1.452/viewport-data/viewport-data-min.js" +
				"&yui:3.16.0/querystring-parse-simple/querystring-parse-simple-min.js" +
				"&uy/build/hermes-1.1.452/browser-support/browser-support-min.js" +
				"&uy/build/hermes-1.1.452/healthjs/healthjs-min.js" +
				"&uy/build/hermes-1.1.452/app-context/app-context-min.js" +
				"&yui:3.16.0/querystring-stringify/querystring-stringify-min.js" +
				"&uy/build/hermes-1.1.452/better-cache/better-cache-min.js" +
				"&yui:3.16.0/datatype-xml-parse/datatype-xml-parse-min.js";
		String requestHeader0022 = "GET " + requestFile0022 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 57242
		// content test algorithm: check size +/- 5%, defined content size = 57242
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 57242, 5);		// Test [22] <- Index 22
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0023 = "s.yimg.com";
		int    requestPort0023 = 443;
		String requestFile0023 = "/zz/combo" +
				"?yui:3.16.0/event-tap/event-tap-min.js" +
				"&uy/build/hermes-1.1.452/better-throttle/better-throttle-min.js" +
				"&uy/build/hermes-1.1.452/global-events/global-events-min.js" +
				"&uy/build/hermes-1.1.452/storage-helper/storage-helper-min.js" +
				"&uy/build/hermes-1.1.452/keyboard-manager/keyboard-manager-min.js" +
				"&uy/build/hermes-1.1.452/overflow-helper/overflow-helper-min.js" +
				"&uy/build/hermes-1.1.452/client-app/client-app-min.js" +
				"&yui:3.16.0/intl/intl-min.js" +
				"&yui:3.16.0/base-pluginhost/base-pluginhost-min.js" +
				"&yui:3.16.0/template-base/template-base-min.js" +
				"&uy/build/hermes-1.1.452/flickr-view/flickr-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sohp/hermes-template-sohp-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-head-meta/hermes-template-head-meta-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-head-link/hermes-template-head-link-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-global-nav/hermes-template-global-nav-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-global-nav-restyle/hermes-template-global-nav-restyle-min.js" +
				"&uy/build/hermes-1.1.452/flutil/flutil-min.js" +
				"&uy/build/hermes-1.1.452/search-helper/search-helper-min.js" +
				"&uy/build/hermes-1.1.452/search-url/search-url-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-search-pill/hermes-template-search-pill-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-search-autosuggest-field/hermes-template-search-autosuggest-field-min.js" +
				"&uy/build/hermes-1.1.452/model-proxy/model-proxy-min.js" +
				"&uy/build/hermes-1.1.452/flickr-collection/flickr-collection-min.js" +
				"&uy/build/hermes-1.1.452/paged-collection/paged-collection-min.js" +
				"&uy/build/hermes-1.1.452/flickr-model-registry/flickr-model-registry-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-autosuggest/hermes-lang-autosuggest-min.js" +
				"&yui:3.16.0/text-data-accentfold/text-data-accentfold-min.js" +
				"&yui:3.16.0/text-accentfold/text-accentfold-min.js" +
				"&uy/build/hermes-1.1.452/autosuggest-context-results-models/autosuggest-context-results-models-min.js";
		String requestHeader0023 = "GET " + requestFile0023 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 38259
		// content test algorithm: check size +/- 5%, defined content size = 38259
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 38259, 5);		// Test [23] <- Index 23
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0024 = "s.yimg.com";
		int    requestPort0024 = 443;
		String requestFile0024 = "/zz/combo" +
				"?yui:3.16.0/io-xdr/io-xdr-min.js" +
				"&uy/build/hermes-1.1.452/page-title-helper/page-title-helper-min.js" +
				"&uy/build/hermes-1.1.452/history-helper/history-helper-min.js" +
				"&uy/build/hermes-1.1.452/flickr-route/flickr-route-min.js" +
				"&uy/build/hermes-1.1.452/mobile-redirect/mobile-redirect-min.js" +
				"&uy/build/hermes-1.1.452/site-key/site-key-min.js" +
				"&uy/build/hermes-1.1.452/csrf-updater/csrf-updater-min.js" +
				"&uy/build/hermes-1.1.452/samplr/samplr-min.js" +
				"&yui:3.16.0/io-form/io-form-min.js" +
				"&yui:3.16.0/io-upload-iframe/io-upload-iframe-min.js" +
				"&yui:3.16.0/queue-promote/queue-promote-min.js" +
				"&yui:3.16.0/io-queue/io-queue-min.js" +
				"&uy/build/hermes-1.1.452/rrd/rrd-min.js" +
				"&uy/build/hermes-1.1.452/flickr-client-metrics/flickr-client-metrics-min.js" +
				"&uy/build/hermes-1.1.452/client-transport/client-transport-min.js" +
				"&uy/build/hermes-1.1.452/flickr-api-metrics/flickr-api-metrics-min.js" +
				"&uy/build/hermes-1.1.452/vendor-wrapper/vendor-wrapper-min.js" +
				"&uy/build/hermes-1.1.452/vendor-lighthouse/vendor-lighthouse-min.js" +
				"&uy/build/hermes-1.1.452/lighthouse/lighthouse-min.js" +
				"&uy/build/hermes-1.1.452/comscore/comscore-min.js" +
				"&uy/build/hermes-1.1.452/loader-bar/loader-bar-min.js" +
				"&yui:3.16.0/pluginhost-base/pluginhost-base-min.js" +
				"&yui:3.16.0/pluginhost-config/pluginhost-config-min.js" +
				"&yui:3.16.0/node-pluginhost/node-pluginhost-min.js" +
				"&yui:3.16.0/dom-screen/dom-screen-min.js" +
				"&yui:3.16.0/node-screen/node-screen-min.js" +
				"&yui:3.16.0/node-style/node-style-min.js" +
				"&uy/build/hermes-1.1.452/rapid/rapid-min.js" +
				"&yui:3.16.0/event-mousewheel/event-mousewheel-min.js" +
				"&yui:3.16.0/event-mouseenter/event-mouseenter-min.js" +
				"&yui:3.16.0/event-key/event-key-min.js" +
				"&yui:3.16.0/event-focus/event-focus-min.js" +
				"&yui:3.16.0/event-resize/event-resize-min.js" +
				"&yui:3.16.0/event-hover/event-hover-min.js" +
				"&yui:3.16.0/event-outside/event-outside-min.js" +
				"&yui:3.16.0/event-touch/event-touch-min.js" +
				"&yui:3.16.0/event-move/event-move-min.js" +
				"&yui:3.16.0/event-flick/event-flick-min.js" +
				"&yui:3.16.0/event-valuechange/event-valuechange-min.js";
		String requestHeader0024 = "GET " + requestFile0024 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 41278
		// content test algorithm: check size +/- 5%, defined content size = 41278
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 41278, 5);		// Test [24] <- Index 24
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0025 = "s.yimg.com";
		int    requestPort0025 = 443;
		String requestFile0025 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/flickr-autosuggest-getContextResults-fetcher/flickr-autosuggest-getContextResults-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-search-autosuggest-list-item/hermes-template-search-autosuggest-list-item-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-search-autosuggest-items-list/hermes-template-search-autosuggest-items-list-min.js" +
				"&uy/build/hermes-1.1.452/autosuggest-data-manager/autosuggest-data-manager-min.js" +
				"&uy/build/hermes-1.1.452/fluid/fluid-min.js" +
				"&uy/build/hermes-1.1.452/search-autosuggest-items-list-view/search-autosuggest-items-list-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-search/hermes-lang-search-min.js" +
				"&uy/build/hermes-1.1.452/search-autosuggest-field-view/search-autosuggest-field-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-common/hermes-lang-common-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-groups/hermes-lang-groups-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-autosuggest-bar/hermes-template-autosuggest-bar-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-autosuggest-item/hermes-template-autosuggest-item-min.js" +
				"&uy/build/hermes-1.1.452/autosuggest-view/autosuggest-view-min.js" +
				"&uy/build/hermes-1.1.452/search-bar-view/search-bar-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-notifications-menu/hermes-template-notifications-menu-min.js" +
				"&uy/build/hermes-1.1.452/notifications-menu-view/notifications-menu-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-notifications-menu/hermes-lang-notifications-menu-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-dialog-tooltip/hermes-template-dialog-tooltip-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-dialog-modal/hermes-template-dialog-modal-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-dialog-alert/hermes-template-dialog-alert-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-dialog-cta/hermes-template-dialog-cta-min.js" +
				"&uy/build/hermes-1.1.452/dialog/dialog-min.js";
		String requestHeader0025 = "GET " + requestFile0025 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 32517
		// content test algorithm: check size +/- 5%, defined content size = 32517
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 32517, 5);		// Test [25] <- Index 25
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0026 = "s.yimg.com";
		int    requestPort0026 = 443;
		String requestFile0026 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/hermes-template-fluid-droparound/hermes-template-fluid-droparound-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-flickr-balls/hermes-template-flickr-balls-min.js" +
				"&uy/build/hermes-1.1.452/attribute-helpers/attribute-helpers-min.js" +
				"&uy/build/hermes-1.1.452/fluid-overlay-manager-view/fluid-overlay-manager-view-min.js" +
				"&uy/build/hermes-1.1.452/fluid-droparound-view/fluid-droparound-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-person-card/hermes-template-person-card-min.js" +
				"&uy/build/hermes-1.1.452/person-card-view/person-card-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-person/hermes-lang-person-min.js" +
				"&uy/build/hermes-1.1.452/person-menu-view/person-menu-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-group-card/hermes-template-group-card-min.js" +
				"&uy/build/hermes-1.1.452/group-card-view/group-card-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-relative-dates/hermes-lang-relative-dates-min.js" +
				"&uy/build/hermes-1.1.452/group-menu-view/group-menu-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-modal/hermes-template-fluid-modal-min.js" +
				"&uy/build/hermes-1.1.452/fluid-modal-view/fluid-modal-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-signup-modal/hermes-template-signup-modal-min.js" +
				"&uy/build/hermes-1.1.452/signup-modal-view/signup-modal-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-signup-interstitial/hermes-template-signup-interstitial-min.js" +
				"&uy/build/hermes-1.1.452/signup-interstitial-view/signup-interstitial-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-growth/hermes-lang-growth-min.js" +
				"&uy/build/hermes-1.1.452/signin-helper/signin-helper-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-mobile-app-upsell/hermes-template-mobile-app-upsell-min.js" +
				"&uy/build/hermes-1.1.452/mobile-app-upsell-view/mobile-app-upsell-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-mobile/hermes-lang-mobile-min.js" +
				"&uy/build/hermes-1.1.452/global-nav-view/global-nav-view-min.js";
		String requestHeader0026 = "GET " + requestFile0026 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 19622
		// content test algorithm: check size +/- 5%, defined content size = 19622
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 19622, 5);		// Test [26] <- Index 26
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0027 = "s.yimg.com";
		int    requestPort0027 = 443;
		String requestFile0027 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/hermes-lang-global-nav/hermes-lang-global-nav-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-darla-script-setup/hermes-template-darla-script-setup-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-footer-full/hermes-template-footer-full-min.js" +
				"&uy/build/hermes-1.1.452/dropdown/dropdown-min.js" +
				"&uy/build/hermes-1.1.452/footer-full-view/footer-full-view-min.js" +
				"&uy/build/hermes-1.1.452/sohp-view/sohp-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-client-app/hermes-lang-client-app-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-sohp/hermes-lang-sohp-min.js";
		String requestHeader0027 = "GET " + requestFile0027 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 10317
		// content test algorithm: check size +/- 5%, defined content size = 10317
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 10317, 5);		// Test [27] <- Index 27
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0028 = "s.yimg.com";
		int    requestPort0028 = 443;
		String requestFile0028 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/hermes-template-account-menu/hermes-template-account-menu-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-account-menu-dialog-greetings/hermes-template-account-menu-dialog-greetings-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-account-menu-dialog/hermes-template-account-menu-dialog-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-greetings/hermes-template-greetings-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-account-menu-dialog-styleguide/hermes-template-account-menu-dialog-styleguide-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-account-menu-card/hermes-template-account-menu-card-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-account-menu-card-get-pro-button/hermes-template-account-menu-card-get-pro-button-min.js" +
				"&uy/build/hermes-1.1.452/products-api-helper/products-api-helper-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-discounts-models/flickr-products-discounts-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-order-items-setQuantity-updater/flickr-products-order-items-setQuantity-updater-min.js" +
				"&uy/build/hermes-1.1.452/products-order-item-models/products-order-item-models-min.js" +
				"&uy/build/hermes-1.1.452/products-order-item-price-models/products-order-item-price-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-orders-removeCoupon-deletor/flickr-products-orders-removeCoupon-deletor-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-coupons-models/flickr-products-coupons-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-orders-create-creator/flickr-products-orders-create-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-subscriptions-orders-create-creator/flickr-products-subscriptions-orders-create-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-editPage-updater/flickr-products-books-editPage-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-favorites-add-updater/flickr-favorites-add-updater-min.js";
		String requestHeader0028 = "GET " + requestFile0028 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 8068
		// content test algorithm: check size +/- 5%, defined content size = 8068
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 8068, 5);		// Test [28] <- Index 28
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0029 = "s.yimg.com";
		int    requestPort0029 = 443;
		String requestFile0029 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/flickr-favorites-remove-updater/flickr-favorites-remove-updater-min.js" +
				"&uy/build/hermes-1.1.452/photo-model-helper/photo-model-helper-min.js" +
				"&uy/build/hermes-1.1.452/flickr-licensing-curation-passOverUser-updater/flickr-licensing-curation-passOverUser-updater-min.js" +
				"&uy/build/hermes-1.1.452/photo-curation-models/photo-curation-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-geo-setLocation-updater/flickr-photos-geo-setLocation-updater-min.js" +
				"&uy/build/hermes-1.1.452/photo-geo-models/photo-geo-models-min.js" +
				"&uy/build/hermes-1.1.452/photo-location-models/photo-location-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-getLocation-fetcher/flickr-photos-getLocation-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-contacts-add-updater/flickr-contacts-add-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-contacts-remove-updater/flickr-contacts-remove-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-contacts-edit-updater/flickr-contacts-edit-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-contacts-block-updater/flickr-contacts-block-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-contacts-unblock-updater/flickr-contacts-unblock-updater-min.js" +
				"&uy/build/hermes-1.1.452/person-relationship-models/person-relationship-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-prefs-setSafeSearch-updater/flickr-prefs-setSafeSearch-updater-min.js" +
				"&uy/build/hermes-1.1.452/person-preferences-models/person-preferences-models-min.js" +
				"&uy/build/hermes-1.1.452/person-profile-models/person-profile-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-join-creator/flickr-groups-join-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-leave-deletor/flickr-groups-leave-deletor-min.js" +
				"&uy/build/hermes-1.1.452/group-info-models/group-info-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-getInfo-fetcher/flickr-groups-getInfo-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/group-models/group-models-min.js";
		String requestHeader0029 = "GET " + requestFile0029 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 6703
		// content test algorithm: check size +/- 5%, defined content size = 6703
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 6703, 5);		// Test [29] <- Index 29
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0030 = "s.yimg.com";
		int    requestPort0030 = 443;
		String requestFile0030 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/photo-engagement-models/photo-engagement-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-setDates-updater/flickr-photos-setDates-updater-min.js" +
				"&uy/build/hermes-1.1.452/moment-timezone/moment-timezone-min.js" +
				"&uy/build/hermes-1.1.452/photo-stats-models/photo-stats-models-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-models/hermes-lang-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-pools-getContext-fetcher/flickr-groups-pools-getContext-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-pools-add-creator/flickr-groups-pools-add-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-pools-remove-deletor/flickr-groups-pools-remove-deletor-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-invite-photo-invite-creator/flickr-groups-invite-photo-invite-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-invite-photo-cancel-deletor/flickr-groups-invite-photo-cancel-deletor-min.js" +
				"&uy/build/hermes-1.1.452/group-pool-by-person-models/group-pool-by-person-models-min.js" +
				"&uy/build/hermes-1.1.452/group-pool-by-tag-models/group-pool-by-tag-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-pools-getPhotos-fetcher/flickr-groups-pools-getPhotos-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/group-contributor-models/group-contributor-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-getTopContributors-fetcher/flickr-groups-getTopContributors-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/group-top-contributors-models/group-top-contributors-models-min.js" +
				"&uy/build/hermes-1.1.452/group-pool-models/group-pool-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-pools-getGroups-fetcher/flickr-groups-pools-getGroups-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-fave-fetcher/flickr-groups-fave-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-unfave-fetcher/flickr-groups-unfave-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-people-getGroupsWithStatus-fetcher/flickr-people-getGroupsWithStatus-fetcher-min.js";
		String requestHeader0030 = "GET " + requestFile0030 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 32236
		// content test algorithm: check size +/- 5%, defined content size = 32236
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 32236, 5);		// Test [30] <- Index 30
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0031 = "s.yimg.com";
		int    requestPort0031 = 443;
		String requestFile0031 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/person-groups-models/person-groups-models-min.js" +
				"&uy/build/hermes-1.1.452/person-curation-models/person-curation-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-getContext-fetcher/flickr-photos-getContext-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-people-getPhotos-fetcher/flickr-people-getPhotos-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/photostream-models/photostream-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-people-getInfo-fetcher/flickr-people-getInfo-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/person-model-helper/person-model-helper-min.js" +
				"&uy/build/hermes-1.1.452/person-models/person-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-getHtmlMeta-fetcher/flickr-photos-getHtmlMeta-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/photo-head-meta-models/photo-head-meta-models-min.js" +
				"&uy/build/hermes-1.1.452/photo-notes-models/photo-notes-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-addNotes-creator/flickr-photos-addNotes-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-editNote-updater/flickr-photos-editNote-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-deleteNote-deletor/flickr-photos-deleteNote-deletor-min.js" +
				"&uy/build/hermes-1.1.452/note-models/note-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-deleteAutotags-deletor/flickr-photos-deleteAutotags-deletor-min.js" +
				"&uy/build/hermes-1.1.452/autotag-models/autotag-models-min.js" +
				"&uy/build/hermes-1.1.452/photo-autotags-models/photo-autotags-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-getInfo-fetcher/flickr-photos-getInfo-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-setPerms-updater/flickr-photos-setPerms-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-setMeta-updater/flickr-photos-setMeta-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-licenses-setLicense-updater/flickr-photos-licenses-setLicense-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-setSafetyLevel-updater/flickr-photos-setSafetyLevel-updater-min.js";
		String requestHeader0031 = "GET " + requestFile0031 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 7900
		// content test algorithm: check size +/- 5%, defined content size = 7900
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 7900, 5);		// Test [31] <- Index 31
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0032 = "s.yimg.com";
		int    requestPort0032 = 443;
		String requestFile0032 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/photo-models/photo-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-getPage-fetcher/flickr-products-books-getPage-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-setPagePhoto-updater/flickr-products-books-setPagePhoto-updater-min.js" +
				"&uy/build/hermes-1.1.452/book-page-photo-models/book-page-photo-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-addPage-creator/flickr-products-books-addPage-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-removePage-deletor/flickr-products-books-removePage-deletor-min.js" +
				"&uy/build/hermes-1.1.452/page-models/page-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-fetcher/flickr-products-books-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-updateBook-updater/flickr-products-books-updateBook-updater-min.js" +
				"&uy/build/hermes-1.1.452/api-products-books-helper/api-products-books-helper-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-editBook-updater/flickr-products-books-editBook-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-creator/flickr-products-books-creator-min.js" +
				"&uy/build/hermes-1.1.452/book-models/book-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-subscriptions-getSubscriptionDetails-fetcher/flickr-products-subscriptions-getSubscriptionDetails-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-shippingType-updater/flickr-products-shippingType-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-orders-getOrder-fetcher/flickr-products-orders-getOrder-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-orders-deletor/flickr-products-orders-deletor-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-orders-models/flickr-products-orders-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-orders-applyCoupon-creator/flickr-products-orders-applyCoupon-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-braintree-createSubscription-creator/flickr-braintree-createSubscription-creator-min.js";
		String requestHeader0032 = "GET " + requestFile0032 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5838
		// content test algorithm: check size +/- 5%, defined content size = 5838
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 5838, 5);		// Test [32] <- Index 32
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0033 = "s.yimg.com";
		int    requestPort0033 = 443;
		String requestFile0033 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/flickr-subscriptions-transferSubscriptions-updater/flickr-subscriptions-transferSubscriptions-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-braintree-paymentDefault-updater/flickr-products-braintree-paymentDefault-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-subscriptions-braintree-deletePaymentMethod-deletor/flickr-subscriptions-braintree-deletePaymentMethod-deletor-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-shipping-fetcher/flickr-products-shipping-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-orders-setShippingAddress-updater/flickr-products-orders-setShippingAddress-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-orders-clearAddress-deletor/flickr-products-orders-clearAddress-deletor-min.js" +
				"&uy/build/hermes-1.1.452/products-address-models/products-address-models-min.js" +
				"&uy/build/hermes-1.1.452/products-credit-card-models/products-credit-card-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-braintree-close-deletor/flickr-braintree-close-deletor-min.js" +
				"&uy/build/hermes-1.1.452/flickr-subscriptions-changePlan-updater/flickr-subscriptions-changePlan-updater-min.js" +
				"&uy/build/hermes-1.1.452/subscription-history-models/subscription-history-models-min.js" +
				"&uy/build/hermes-1.1.452/subscription-history-list-models/subscription-history-list-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-braintree-customerDetails-fetcher/flickr-braintree-customerDetails-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/products-payment-methods-list-models/products-payment-methods-list-models-min.js" +
				"&uy/build/hermes-1.1.452/account-menu-view/account-menu-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-account-menu/hermes-lang-account-menu-min.js";
		String requestHeader0033 = "GET " + requestFile0033 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5908
		// content test algorithm: check size +/- 5%, defined content size = 5908
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 5908, 5);		// Test [33] <- Index 33
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0034 = "s.yimg.com";
		int    requestPort0034 = 443;
		String requestFile0034 = "/uy/build/images/sohp/backgrounds/space4.jpg";
		String requestHeader0034 = "GET " + requestFile0034 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 212628
		// content test algorithm: check size +/- 5%, defined content size = 212628
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 212628, 5);		// Test [34] <- Index 34
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0035 = "s.yimg.com";
		int    requestPort0035 = 443;
		String requestFile0035 = "/uy/build/images/sohp/photo-stack2.png";
		String requestHeader0035 = "GET " + requestFile0035 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 82800
		// content test algorithm: check size +/- 5%, defined content size = 82800
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 82800, 5);		// Test [35] <- Index 35
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0036 = "s.yimg.com";
		int    requestPort0036 = 443;
		String requestFile0036 = "/uy/build/images/sohp/backgrounds/platforms5.jpg";
		String requestHeader0036 = "GET " + requestFile0036 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 43934
		// content test algorithm: check size +/- 5%, defined content size = 43934
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 43934, 5);		// Test [36] <- Index 36
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0037 = "s.yimg.com";
		int    requestPort0037 = 443;
		String requestFile0037 = "/uy/build/images/sohp/inspiration/untitled3.jpg";
		String requestHeader0037 = "GET " + requestFile0037 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 222815
		// content test algorithm: check size +/- 5%, defined content size = 222815
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 222815, 5);		// Test [37] <- Index 37
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0038 = "s.yimg.com";
		int    requestPort0038 = 443;
		String requestFile0038 = "/uy/build/images/sohp/backgrounds/search3.jpg";
		String requestHeader0038 = "GET " + requestFile0038 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 58253
		// content test algorithm: check size +/- 5%, defined content size = 58253
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 58253, 5);		// Test [38] <- Index 38
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0039 = "c4.staticflickr.com";
		int    requestPort0039 = 443;
		String requestFile0039 = "/4/3950/buddyicons/36537682@N06_l.jpg";
		String requestHeader0039 = "GET " + requestFile0039 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c4.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 2972
		// content test algorithm: check size +/- 5%, defined content size = 2972
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 2972, 5);		// Test [39] <- Index 39
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0040 = "s.yimg.com";
		int    requestPort0040 = 443;
		String requestFile0040 = "/uy/build/images/sohp/backgrounds/bottom5.jpg";
		String requestHeader0040 = "GET " + requestFile0040 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 225229
		// content test algorithm: check size +/- 5%, defined content size = 225229
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 225229, 5);		// Test [40] <- Index 40
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		// ... continuing page #1 (fragment 3 of 4)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [41] <- WEB ADMIN Index 41 ---
		String requestProt0041 = "https";
		String requestHost0041 = "sb.scorecardresearch.com";
		int    requestPort0041 = 443;
		String requestFile0041 = "/p" +
				"?c1=2" +
				"&c2=7241469" +
				"&c3=" +
				"&c4=www.flickr.com%252F" +
				"&c5=792600582" +
				"&c6=" +
				"&c15=" +
				"&ns__t=1461135691423" +
				"&ns_c=UTF-8";
		String requestHeader0041 = "GET " + requestFile0041 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: sb.scorecardresearch.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [41] <- Index 41
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
		String requestHost0042 = "s.yimg.com";
		int    requestPort0042 = 443;
		String requestFile0042 = "/uy/build/images/sohp/inspiration/dave3.jpg";
		String requestHeader0042 = "GET " + requestFile0042 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 203712
		// content test algorithm: check size +/- 5%, defined content size = 203712
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 203712, 5);		// Test [42] <- Index 42
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0043 = "sb.scorecardresearch.com";
		int    requestPort0043 = 443;
		String requestFile0043 = "/p2" +
				"?c1=2" +
				"&c2=7241469" +
				"&c3=" +
				"&c4=www.flickr.com%252F" +
				"&c5=792600582" +
				"&c6=" +
				"&c15=" +
				"&ns__t=1461135691423" +
				"&ns_c=UTF-8";
		String requestHeader0043 = "GET " + requestFile0043 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: sb.scorecardresearch.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 43
		// content test algorithm: check size +/- 5%, defined content size = 43
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 43, 5);		// Test [43] <- Index 43
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0044 = "geo.query.yahoo.com";
		int    requestPort0044 = 443;
		String requestFile0044 = "/v1/public/yql" +
				"?yhlVer=2" +
				"&yhlClient=rapid" +
				"&yhlS=792600582" +
				"&yhlCT=2" +
				"&yhlBTMS=1461135691437" +
				"&yhlClientVer=3.35" +
				"&yhlRnd=aD8SE98BMJePrfrz" +
				"&yhlCompressed=0";
		String requestContent0044 = 
				"q=select%20*%20from%20x%20where%20a%20%3D%20'%7B%22bp%22%3A%7B%22_pl%22%3A%221%22%2C%22A_v%22%3A%223.35%22%2C%22_bt%22%3A%22rapid%22%2C%22A_pr%22%3A%22https%22%2C%22A_tzoff%22%3A%222%22%7D%2C%22r%22%3A%5B%7B%22t%22%3A%22pv%22%2C%22s%22%3A%22792600582%22%2C%22pp%22%3A%7B%22A_sid%22%3A%22Jay5V0IRcgB8Lt0F%22%2C%22_w%22%3A%22www.flickr.com%2F%22%2C%22pageType%22%3A%22sohp-view%22%2C%22intl%22%3A%22en-US%22%2C%22bx%22%3A%22bv3heppbheaa9%26b%3D3%26s%3Dfv%22%2C%22buckets%22%3A%22celeb_search%3Aceleb_search%2Cshare_modal_restyle%3Aenabled%2Cphotoscore_rank_in_search%3Aenable_photoscore_rank%2Cbuy_button_tests%3Atoolbar%2Cphoto_list_buy_button_tests%3Acontrol%22%2C%22isStaff%22%3A0%2C%22renderer%22%3A%22s%22%2C%22loggedIn%22%3A0%2C%22slice%22%3A%2241%22%2C%22groupUsr%22%3A0%2C%22density%22%3A%221%22%2C%22dimensns%22%3A%221260x627%22%2C%22isPro%22%3A0%2C%22isbot%22%3Afalse%2C%22isunsptd%22%3Afalse%2C%22photo%22%3A%22%2Fphotos%2Fsend_your_spam%2F13818125963%22%2C%22A_%22%3A%221%22%7D%2C%22_ts%22%3A%221461135691%22%2C%22_ms%22%3A%22427%22%2C%22lv%22%3A%5B%7B%22m%22%3A%22content%22%2C%22l%22%3A%5B%7B%22_p%22%3A1%2C%22slk%22%3A%22gnLogoClick%22%7D%2C%7B%22_p%22%3A2%2C%22slk%22%3A%22gnExploreMainClick%22%7D%2C%7B%22_p%22%3A3%2C%22slk%22%3A%22gnExploreRecentPhotosClick%22%7D%2C%7B%22_p%22%3A4%2C%22slk%22%3A%22gnExploreTagsClick%22%7D%2C%7B%22_p%22%3A5%2C%22slk%22%3A%22gnExploreVRLandingClick%22%7D%2C%7B%22_p%22%3A6%2C%22slk%22%3A%22gnExploreTheCommonsClick%22%7D%2C%7B%22_p%22%3A7%2C%22slk%22%3A%22gnExploreGalleriesClick%22%7D%2C%7B%22_p%22%3A8%2C%22slk%22%3A%22gnExploreWorldMapClick%22%7D%2C%7B%22_p%22%3A9%2C%22slk%22%3A%22gnExploreAppGardenClick%22%7D%2C%7B%22_p%22%3A10%2C%22slk%22%3A%22gnExploreCameraFinderClick%22%7D%2C%7B%22_p%22%3A11%2C%22slk%22%3A%22gnExploreWeeklyFlickrClick%22%7D%2C%7B%22_p%22%3A12%2C%22slk%22%3A%22gnExploreFlickrBlogClick%22%7D%2C%7B%22_p%22%3A13%2C%22slk%22%3A%22gnCreateMainClick%22%7D%2C%7B%22_p%22%3A14%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A15%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A16%2C%22slk%22%3A%22gnUploadIconMain%22%7D%2C%7B%22_p%22%3A17%2C%22slk%22%3A%22gnSignin%22%7D%2C%7B%22_p%22%3A18%2C%22slk%22%3A%22gnSignupClick%22%7D%2C%7B%22_p%22%3A19%2C%22slk%22%3A%22gnExploreMainClick%22%7D%2C%7B%22_p%22%3A20%2C%22slk%22%3A%22gnExploreRecentPhotosClick%22%7D%2C%7B%22_p%22%3A21%2C%22slk%22%3A%22gnExploreTagsClick%22%7D%2C%7B%22_p%22%3A22%2C%22slk%22%3A%22gnExploreTheCommonsClick%22%7D%2C%7B%22_p%22%3A23%2C%22slk%22%3A%22gnExploreGalleriesClick%22%7D%2C%7B%22_p%22%3A24%2C%22slk%22%3A%22gnExploreWeeklyFlickrClick%22%7D%2C%7B%22_p%22%3A25%2C%22slk%22%3A%22gnExploreFlickrBlogClick%22%7D%2C%7B%22_p%22%3A26%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A27%2C%22slk%22%3A%22signup-top%22%7D%2C%7B%22_p%22%3A28%2C%22slk%22%3A%22ios-top%22%7D%2C%7B%22_p%22%3A29%2C%22slk%22%3A%22android-top%22%7D%2C%7B%22_p%22%3A30%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A31%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A32%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A33%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A34%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A35%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A36%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A37%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A38%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A39%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A40%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A41%2C%22slk%22%3A%22inspireme%22%7D%2C%7B%22_p%22%3A42%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A43%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A44%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A45%2C%22slk%22%3A%22signup-bottom%22%7D%2C%7B%22_p%22%3A46%2C%22slk%22%3A%22ios-bottom%22%7D%2C%7B%22_p%22%3A47%2C%22slk%22%3A%22android-bottom%22%7D%2C%7B%22_p%22%3A48%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A49%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A50%2C%22slk%22%3A%22attribution%22%7D%2C%7B%22_p%22%3A51%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A52%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A53%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A54%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A55%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A56%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A57%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A58%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A59%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A60%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A61%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A62%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A63%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A64%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A65%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A66%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A67%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A68%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A69%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A70%2C%22slk%22%3A%22_%22%7D%5D%2C%22ylk%22%3A%7B%7D%7D%5D%7D%5D%2C%22yrid%22%3A%22%22%2C%22optout%22%3A%220%22%2C%22nol%22%3A%220%22%7D'";
		byte[] requestContentBinary0044 = requestContent0044.getBytes("UTF-8");
		String requestHeader0044 = "POST " + requestFile0044 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: geo.query.yahoo.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0044.length + "\r\n" + 		// Content-Length: 4949
				"origin: https://www.flickr.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 299
		// content test algorithm: check size +/- 5%, defined content size = 299
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, 299, 5);		// Test [44] <- Index 44
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
		String requestProt0045 = "https";
		String requestHost0045 = "s.yimg.com";
		int    requestPort0045 = 443;
		String requestFile0045 = "/uy/build/images/sohp/inspiration/bliss3.jpg";
		String requestHeader0045 = "GET " + requestFile0045 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 210434
		// content test algorithm: check size +/- 5%, defined content size = 210434
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 210434, 5);		// Test [45] <- Index 45
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0046 = "s.yimg.com";
		int    requestPort0046 = 443;
		String requestFile0046 = "/uy/build/images/sohp/inspiration/crs43.jpg";
		String requestHeader0046 = "GET " + requestFile0046 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 122976
		// content test algorithm: check size +/- 5%, defined content size = 122976
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 122976, 5);		// Test [46] <- Index 46
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0047 = "s.yimg.com";
		int    requestPort0047 = 443;
		String requestFile0047 = "/uy/build/images/sohp/inspiration/love-rock3.jpg";
		String requestHeader0047 = "GET " + requestFile0047 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 251406
		// content test algorithm: check size +/- 5%, defined content size = 251406
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 251406, 5);		// Test [47] <- Index 47
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0048 = "s.yimg.com";
		int    requestPort0048 = 443;
		String requestFile0048 = "/uy/build/images/sohp/inspiration/lucas-at-pipe3.jpg";
		String requestHeader0048 = "GET " + requestFile0048 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 214785
		// content test algorithm: check size +/- 5%, defined content size = 214785
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 214785, 5);		// Test [48] <- Index 48
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0049 = "s.yimg.com";
		int    requestPort0049 = 443;
		String requestFile0049 = "/uy/build/images/sohp/inspiration/on-top-of-the-world3.jpg";
		String requestHeader0049 = "GET " + requestFile0049 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 221155
		// content test algorithm: check size +/- 5%, defined content size = 221155
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 221155, 5);		// Test [49] <- Index 49
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0050 = "s.yimg.com";
		int    requestPort0050 = 443;
		String requestFile0050 = "/uy/build/images/sohp/inspiration/a-night-on-a-bridge3.jpg";
		String requestHeader0050 = "GET " + requestFile0050 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 166285
		// content test algorithm: check size +/- 5%, defined content size = 166285
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 166285, 5);		// Test [50] <- Index 50
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0051 = "s.yimg.com";
		int    requestPort0051 = 443;
		String requestFile0051 = "/uy/build/images/sohp/inspiration/jumping-for-sand3.jpg";
		String requestHeader0051 = "GET " + requestFile0051 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 123471
		// content test algorithm: check size +/- 5%, defined content size = 123471
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 123471, 5);		// Test [51] <- Index 51
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0052 = "s.yimg.com";
		int    requestPort0052 = 443;
		String requestFile0052 = "/uy/build/images/sohp/inspiration/sage3.jpg";
		String requestHeader0052 = "GET " + requestFile0052 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 388027
		// content test algorithm: check size +/- 5%, defined content size = 388027
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 388027, 5);		// Test [52] <- Index 52
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0053 = "s.yimg.com";
		int    requestPort0053 = 443;
		String requestFile0053 = "/uy/build/images/sohp/inspiration/lake-tahoe3.jpg";
		String requestHeader0053 = "GET " + requestFile0053 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 192319
		// content test algorithm: check size +/- 5%, defined content size = 192319
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 192319, 5);		// Test [53] <- Index 53
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0054 = "s.yimg.com";
		int    requestPort0054 = 443;
		String requestFile0054 = "/uy/build/images/sohp/inspiration/night-sky3.jpg";
		String requestHeader0054 = "GET " + requestFile0054 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 518893
		// content test algorithm: check size +/- 5%, defined content size = 518893
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 518893, 5);		// Test [54] <- Index 54
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0055 = "s.yimg.com";
		int    requestPort0055 = 443;
		String requestFile0055 = "/uy/build/images/sohp/inspiration/solar-storm3.jpg";
		String requestHeader0055 = "GET " + requestFile0055 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 434348
		// content test algorithm: check size +/- 5%, defined content size = 434348
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 434348, 5);		// Test [55] <- Index 55
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0056 = "s.yimg.com";
		int    requestPort0056 = 443;
		String requestFile0056 = "/uy/build/images/sohp/inspiration/sunrise-at-vermillion3.jpg";
		String requestHeader0056 = "GET " + requestFile0056 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 218016
		// content test algorithm: check size +/- 5%, defined content size = 218016
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 218016, 5);		// Test [56] <- Index 56
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0057 = "s.yimg.com";
		int    requestPort0057 = 443;
		String requestFile0057 = "/uy/build/images/sohp/inspiration/getting-the-shot3.jpg";
		String requestHeader0057 = "GET " + requestFile0057 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 276669
		// content test algorithm: check size +/- 5%, defined content size = 276669
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 276669, 5);		// Test [57] <- Index 57
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0058 = "www.flickr.com";
		int    requestPort0058 = 443;
		String requestFile0058 = "/beacon_page_timings.gne" +
				"?timing_pageid=sohp_view_coldstart" +
				"&page_start=1461135689480" +
				"&page_generation=2" +
				"&js_done=1461135691439" +
				"&AFT=" +
				"&window_load=1461135694173" +
				"&dom_ready=1461135690148" +
				"&is_logged_in=0";
		String requestHeader0058 = "GET " + requestFile0058 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 20
		// content test algorithm: check size +/- 5%, defined content size = 20
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, 20, 5);		// Test [58] <- Index 58
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
		String requestProt0059 = "https";
		String requestHost0059 = "api.flickr.com";
		int    requestPort0059 = 443;
		String requestFile0059 = "/services/rest" +
				"?extras=can_addmeta%2Ccan_comment%2Ccan_download%2Ccan_share%2Ccontact%2Ccount_comments%2Ccount_faves%2Ccount_views%2Cdate_taken%2Cdate_upload%2Cdescription%2Cicon_urls_deep%2Cisfavorite%2Cispro%2Clicense%2Cmedia%2Cneeds_interstitial%2Cowner_name%2Cowner_datecreate%2Cpath_alias%2Crealname%2Crotation%2Csafety_level%2Csecret_k%2Csecret_h%2Curl_c%2Curl_f%2Curl_h%2Curl_k%2Curl_l%2Curl_m%2Curl_n%2Curl_o%2Curl_q%2Curl_s%2Curl_sq%2Curl_t%2Curl_z%2Cvisibility%2Cvisibility_source%2Co_dims%2Cis_marketplace_printable%2Cis_marketplace_licensable%2Cpubliceditability" +
				"&context_id=global" +
				"&context_type=global" +
				"&viewerNSID=" +
				"&method=flickr.autosuggest.getContextResults" +
				"&csrf=" +
				"&api_key=f5dfe6a3d0e27250877ed624b6b2048e" +
				"&format=json" +
				"&hermes=1" +
				"&hermesClient=1" +
				"&reqId=278dc1e4" +
				"&nojsoncallback=1";
		String requestHeader0059 = "GET " + requestFile0059 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0059, requestHost0059, requestPort0059, requestHeader0059, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0059 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 46
		// content test algorithm: check size +/- 5%, defined content size = 46
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 46, 5);		// Test [59] <- Index 59
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





		// --- HTTP REQUEST: Test [60] <- WEB ADMIN Index 60 ---
		String requestProt0060 = "https";
		String requestHost0060 = "geo.yahoo.com";
		int    requestPort0060 = 443;
		String requestFile0060 = "/p" +
				"?s=792600582" +
				"&t=Iv0NDS9bJ08XRgHl,0.16137016153197692" +
				"&_I=" +
				"&_AO=0" +
				"&_NOL=0" +
				"&_R=" +
				"&_P=3.35%05_pl%031%04A_v%033.35%04_bt%03rapid%04A_pr%03https%04A_tzoff%032%04A_sid%03Jay5V0IRcgB8Lt0F%04_w%03www.flickr.com%2F%04pageType%03sohp-view%04intl%03en-US%04bx%03bv3heppbheaa9%26b%3D3%26s%3Dfv%04buckets%03celeb_search%3Aceleb_search%2Cshare_modal_restyle%3Aenabled%2Cphotoscore_rank_in_search%3Aenable_photoscore_rank%2Cbuy_button_tests%3Atoolbar%2Cphoto_list_buy_button_tests%3Acontrol%04isStaff%030%04renderer%03s%04loggedIn%030%04slice%0341%04groupUsr%030%04density%031%04dimensns%031260x627%04isPro%030%04isbot%03false%04isunsptd%03false%04photo%03%2Fphotos%2Fsend_your_spam%2F13818125963%04_ts%031461135691%04_ms%03427%04etrg%03backgroundPost%04outcm%03performance%04usergenf%030%04etag%03performance%04_E%03pageperf";
		String requestHeader0060 = "GET " + requestFile0060 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: geo.yahoo.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 43
		// content test algorithm: check size +/- 5%, defined content size = 43
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 43, 5);		// Test [60] <- Index 60
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		// ... continuing page #1 (fragment 4 of 4)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [61] <- WEB ADMIN Index 61 ---
		String requestProt0061 = "https";
		String requestHost0061 = "radar.cedexis.com";
		int    requestPort0061 = 443;
		String requestFile0061 = "/1/18573/radar.js";
		String requestHeader0061 = "GET " + requestFile0061 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: radar.cedexis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 302, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 5
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {302}, null, null, null);		// Test [61] <- Index 61
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





		// --- HTTP REQUEST: Test [62] <- WEB ADMIN Index 62 ---
		String requestProt0062 = "https";
		String requestHost0062 = "radar.cedexis.com";
		int    requestPort0062 = 443;
		String requestFile0062 = "/1/18573/radar/1461097084/TCcgBZ1SMVKHIGbJYOKo5DLalf3iBzZX/handshake.js";
		String requestHeader0062 = "GET " + requestFile0062 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: radar.cedexis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0062, requestHost0062, requestPort0062, requestHeader0062, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0062 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 7970
		// content test algorithm: check size +/- 5%, defined content size = 7970
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 7970, 5);		// Test [62] <- Index 62
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0063 = "www.flickr.com";
		int    requestPort0063 = 443;
		String requestFile0063 = "/beacon_client_api_timings.gne" +
				"?d=flickr.autosuggest.getContextResults%3B3071";
		String requestHeader0063 = "GET " + requestFile0063 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 20
		// content test algorithm: check size +/- 5%, defined content size = 20
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, 20, 5);		// Test [63] <- Index 63
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
		String requestHost0064 = "radar.cedexis.com";
		int    requestPort0064 = 443;
		String requestFile0064 = "/1461097084/radar/main.js" +
				"?a=1" +
				"&b=2" +
				"&l=0" +
				"&n=1" +
				"&p=1" +
				"&t=1" +
				"&r=1" +
				"&imagesok=1";
		String requestHeader0064 = "GET " + requestFile0064 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: radar.cedexis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0064, requestHost0064, requestPort0064, requestHeader0064, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0064 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 8756
		// content test algorithm: check size +/- 5%, defined content size = 8756
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 8756, 5);		// Test [64] <- Index 64
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0065 = "i1-j1-18-23-1-18573-3895810908-s.init.cedexis-radar.net";
		int    requestPort0065 = 443;
		String requestFile0065 = "/i1/1461135701/3895810908/xml" +
				"?seed=i1-j1-18-23-1-18573-3895810908-s";
		String requestHeader0065 = "GET " + requestFile0065 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: i1-j1-18-23-1-18573-3895810908-s.init.cedexis-radar.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/XML", header text fragment = [verification disabled], recorded content size = 300
		// content test algorithm: check size +/- 5%, defined content size = 300
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/XML", null, 300, 5);		// Test [65] <- Index 65
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





		// --- HTTP REQUEST: Test [66] <- WEB ADMIN Index 66 ---
		String requestProt0066 = "https";
		String requestHost0066 = "radar.cedexis.com";
		int    requestPort0066 = 443;
		String requestFile0066 = "/1/18573/radar/1461097084/qqq2NFkh7tjbo0YImTCc/providers.json" +
				"?imagesok=1" +
				"&r=1" +
				"&t=1" +
				"&p=1" +
				"&n=1" +
				"&l=0" +
				"&b=2" +
				"&a=1";
		String requestHeader0066 = "GET " + requestFile0066 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: radar.cedexis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 179
		// content test algorithm: check size +/- 5%, defined content size = 179
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 179, 5);		// Test [66] <- Index 66
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
		String requestHost0067 = "p2.staticflickr.com";
		int    requestPort0067 = 443;
		String requestFile0067 = "/1/281/19065759046_417b057a03_o.gif" +
				"?rnd=1-1-18573-1-18573-31144-3895810908-_CgJqMRASGBciBggBEI2RASjcttXBDjDV0ty4BTjZ0ty4BUDCq98rShEIAxC7ARjrkAMgACjOj4CgBFAAWgoIABAAGAAgACgAYAFqE2J1dHRvbjIubWlhLmh2LnByb2Q";
		String requestHeader0067 = "GET " + requestFile0067 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: p2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0067, requestHost0067, requestPort0067, requestHeader0067, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0067 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 43
		// content test algorithm: check size +/- 5%, defined content size = 43
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 43, 5);		// Test [67] <- Index 67
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0068 = "p2.staticflickr.com";
		int    requestPort0068 = 443;
		String requestFile0068 = "/1/281/19065759046_417b057a03_o.gif" +
				"?rnd=0-1-18573-1-18573-31144-3895810908-_CgJqMRASGBciBggBEI2RASjcttXBDjDV0ty4BTjZ0ty4BUDCq98rShEIAxC7ARjrkAMgACjOj4CgBFAAWgoIABAAGAAgACgAYAFqE2J1dHRvbjIubWlhLmh2LnByb2Q";
		String requestHeader0068 = "GET " + requestFile0068 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: p2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0068, requestHost0068, requestPort0068, requestHeader0068, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0068 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 43
		// content test algorithm: check size +/- 5%, defined content size = 43
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 43, 5);		// Test [68] <- Index 68
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0069 = "p2.staticflickr.com";
		int    requestPort0069 = 443;
		String requestFile0069 = "/1/555/19086257152_e1fe42996a_o.png" +
				"?rnd=14-1-18573-1-18573-31144-3895810908-_CgJqMRASGBciBggBEI2RASjcttXBDjDV0ty4BTjZ0ty4BUDCq98rShEIAxC7ARjrkAMgACjOj4CgBFAAWgoIABAAGAAgACgAYAFqE2J1dHRvbjIubWlhLmh2LnByb2Q";
		String requestHeader0069 = "GET " + requestFile0069 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: p2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 102400
		// content test algorithm: check size +/- 5%, defined content size = 102400
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 102400, 5);		// Test [69] <- Index 69
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0070 = "rpt.cedexis.com";
		int    requestPort0070 = 443;
		String requestFile0070 = "/f1/_CgJqMRASGBciBggBEI2RASjcttXBDjDV0ty4BTjZ0ty4BUDCq98rShEIAxC7ARjrkAMgACjOj4CgBFAAWgoIABAAGAAgACgAYAFqE2J1dHRvbjIubWlhLmh2LnByb2Q/1/18573/31144/1/0/165/0/0";
		String requestHeader0070 = "GET " + requestFile0070 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: rpt.cedexis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0070, requestHost0070, requestPort0070, requestHeader0070, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0070 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 16
		// content test algorithm: check size +/- 5%, defined content size = 16
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 16, 5);		// Test [70] <- Index 70
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0071 = "rpt.cedexis.com";
		int    requestPort0071 = 443;
		String requestFile0071 = "/f1/_CgJqMRASGBciBggBEI2RASjcttXBDjDV0ty4BTjZ0ty4BUDCq98rShEIAxC7ARjrkAMgACjOj4CgBFAAWgoIABAAGAAgACgAYAFqE2J1dHRvbjIubWlhLmh2LnByb2Q/1/18573/31144/0/0/33/0/0";
		String requestHeader0071 = "GET " + requestFile0071 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: rpt.cedexis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
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

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 16
		// content test algorithm: check size +/- 5%, defined content size = 16
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 16, 5);		// Test [71] <- Index 71
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0072 = "rpt.cedexis.com";
		int    requestPort0072 = 443;
		String requestFile0072 = "/f1/_CgJqMRASGBciBggBEI2RASjcttXBDjDV0ty4BTjZ0ty4BUDCq98rShEIAxC7ARjrkAMgACjOj4CgBFAAWgoIABAAGAAgACgAYAFqE2J1dHRvbjIubWlhLmh2LnByb2Q/1/18573/31144/14/0/0/0/0";
		String requestHeader0072 = "GET " + requestFile0072 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: rpt.cedexis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0072, requestHost0072, requestPort0072, requestHeader0072, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0072 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 16
		// content test algorithm: check size +/- 5%, defined content size = 16
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 16, 5);		// Test [72] <- Index 72
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
	 * Recorded http requests of page #2.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// # Page #2: afterlogin
		// # -------------------



		// --- HTTP REQUEST: Test [74] <- WEB ADMIN Index 74 ---
		String requestProt0074 = "https";
		String requestHost0074 = "c2.staticflickr.com";
		int    requestPort0074 = 443;
		String requestFile0074 = "/2/1568/26467663581_4a8f76b1b5_c.jpg";
		String requestHeader0074 = "GET " + requestFile0074 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0074, requestHost0074, requestPort0074, requestHeader0074, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0074 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 168920
		// content test algorithm: check size +/- 5%, defined content size = 168920
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 168920, 5);		// Test [74] <- Index 74
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0075 = "c2.staticflickr.com";
		int    requestPort0075 = 443;
		String requestFile0075 = "/2/1490/26504089526_54e900d45a_c.jpg";
		String requestHeader0075 = "GET " + requestFile0075 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0075, requestHost0075, requestPort0075, requestHeader0075, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0075 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 170973
		// content test algorithm: check size +/- 5%, defined content size = 170973
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 170973, 5);		// Test [75] <- Index 75
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0076 = "c1.staticflickr.com";
		int    requestPort0076 = 443;
		String requestFile0076 = "/1/1/buddyicons/35237096496@N01.jpg" +
				"?1173253839";
		String requestHeader0076 = "GET " + requestFile0076 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c1.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0076, requestHost0076, requestPort0076, requestHeader0076, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0076 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 3932
		// content test algorithm: check size +/- 5%, defined content size = 3932
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 3932, 5);		// Test [76] <- Index 76
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0077 = "c2.staticflickr.com";
		int    requestPort0077 = 443;
		String requestFile0077 = "/4/3716/buddyicons/75432915@N02.jpg" +
				"?1376390514";
		String requestHeader0077 = "GET " + requestFile0077 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0077, requestHost0077, requestPort0077, requestHeader0077, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0077 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 5086
		// content test algorithm: check size +/- 5%, defined content size = 5086
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 5086, 5);		// Test [77] <- Index 77
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0078 = "c2.staticflickr.com";
		int    requestPort0078 = 443;
		String requestFile0078 = "/2/1490/26504089526_54e900d45a_q.jpg";
		String requestHeader0078 = "GET " + requestFile0078 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0078, requestHost0078, requestPort0078, requestHeader0078, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0078 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 17493
		// content test algorithm: check size +/- 5%, defined content size = 17493
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 17493, 5);		// Test [78] <- Index 78
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0079 = "c2.staticflickr.com";
		int    requestPort0079 = 443;
		String requestFile0079 = "/2/1676/26257213000_81842939c0_q.jpg";
		String requestHeader0079 = "GET " + requestFile0079 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0079, requestHost0079, requestPort0079, requestHeader0079, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0079 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 17283
		// content test algorithm: check size +/- 5%, defined content size = 17283
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 17283, 5);		// Test [79] <- Index 79
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0080 = "c2.staticflickr.com";
		int    requestPort0080 = 443;
		String requestFile0080 = "/2/1589/26504095966_d436b33aee_q.jpg";
		String requestHeader0080 = "GET " + requestFile0080 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0080, requestHost0080, requestPort0080, requestHeader0080, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0080 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 19552
		// content test algorithm: check size +/- 5%, defined content size = 19552
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 19552, 5);		// Test [80] <- Index 80
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [81] <- WEB ADMIN Index 81 ---
		String requestProt0081 = "https";
		String requestHost0081 = "c2.staticflickr.com";
		int    requestPort0081 = 443;
		String requestFile0081 = "/2/1498/26437729402_58047f4742_q.jpg";
		String requestHeader0081 = "GET " + requestFile0081 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0081, requestHost0081, requestPort0081, requestHeader0081, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0081 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 14631
		// content test algorithm: check size +/- 5%, defined content size = 14631
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 14631, 5);		// Test [81] <- Index 81
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0082 = "c2.staticflickr.com";
		int    requestPort0082 = 443;
		String requestFile0082 = "/2/1509/26437735342_62414228f1_q.jpg";
		String requestHeader0082 = "GET " + requestFile0082 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0082, requestHost0082, requestPort0082, requestHeader0082, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0082 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 10522
		// content test algorithm: check size +/- 5%, defined content size = 10522
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 10522, 5);		// Test [82] <- Index 82
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0083 = "c2.staticflickr.com";
		int    requestPort0083 = 443;
		String requestFile0083 = "/2/1566/26462489301_00837109e8_b.jpg";
		String requestHeader0083 = "GET " + requestFile0083 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0083, requestHost0083, requestPort0083, requestHeader0083, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0083 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 310512
		// content test algorithm: check size +/- 5%, defined content size = 310512
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 310512, 5);		// Test [83] <- Index 83
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0084 = "c1.staticflickr.com";
		int    requestPort0084 = 443;
		String requestFile0084 = "/3/2346/buddyicons/21166094@N03.jpg" +
				"?1238714887";
		String requestHeader0084 = "GET " + requestFile0084 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c1.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0084, requestHost0084, requestPort0084, requestHeader0084, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0084 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 8088
		// content test algorithm: check size +/- 5%, defined content size = 8088
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 8088, 5);		// Test [84] <- Index 84
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0085 = "c2.staticflickr.com";
		int    requestPort0085 = 443;
		String requestFile0085 = "/2/1566/26462489301_00837109e8_q.jpg";
		String requestHeader0085 = "GET " + requestFile0085 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0085, requestHost0085, requestPort0085, requestHeader0085, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0085 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 20749
		// content test algorithm: check size +/- 5%, defined content size = 20749
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 20749, 5);		// Test [85] <- Index 85
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0086 = "c2.staticflickr.com";
		int    requestPort0086 = 443;
		String requestFile0086 = "/2/1484/25923167234_dd446f20f6_q.jpg";
		String requestHeader0086 = "GET " + requestFile0086 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0086, requestHost0086, requestPort0086, requestHeader0086, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0086 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 14817
		// content test algorithm: check size +/- 5%, defined content size = 14817
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 14817, 5);		// Test [86] <- Index 86
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [87] <- WEB ADMIN Index 87 ---
		String requestProt0087 = "https";
		String requestHost0087 = "api.flickr.com";
		int    requestPort0087 = 443;
		String requestFile0087 = "/services/rest";
		String requestContent0087 = 
				"format=json" +
				"&clientType=yui-3-flickrapi-module" +
				"&api_key=f5dfe6a3d0e27250877ed624b6b2048e" +
				"&auth_hash=335141336d4366657f6c36af16e31494b8f3edc3baf999403495290de6874939" +
				"&auth_token=" +
				"&secret=cbd6de88eadc878b" +
				"&views=%5B%7B%22photo_id%22%3A%2225932648303%22%2C%22async%22%3Atrue%2C%22referrer%22%3A%22https%3A%2F%2Fwww.flickr.com%2F%22%7D%2C%7B%22photo_id%22%3A%2226467663581%22%2C%22async%22%3Atrue%2C%22referrer%22%3A%22https%3A%2F%2Fwww.flickr.com%2F%22%7D%2C%7B%22photo_id%22%3A%2226504089526%22%2C%22async%22%3Atrue%2C%22referrer%22%3A%22https%3A%2F%2Fwww.flickr.com%2F%22%7D%2C%7B%22photo_id%22%3A%2226257213000%22%2C%22async%22%3Atrue%2C%22referrer%22%3A%22https%3A%2F%2Fwww.flickr.com%2F%22%7D%2C%7B%22photo_id%22%3A%2226437735342%22%2C%22async%22%3Atrue%2C%22referrer%22%3A%22https%3A%2F%2Fwww.flickr.com%2F%22%7D%5D" +
				"&method=flickr.photos.addView" +
				"&nojsoncallback=1";
		byte[] requestContentBinary0087 = requestContent0087.getBytes("UTF-8");
		String requestHeader0087 = "POST " + requestFile0087 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0087.length + "\r\n" + 		// Content-Length: 858
				"origin: https://www.flickr.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0087, requestHost0087, requestPort0087, requestHeader0087, requestContentBinary0087, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
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
		requestHeader0087 = null;		// support garbage collector to reduce memory
		requestContent0087 = null;		// support garbage collector to reduce memory
		requestContentBinary0087 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 33
		// content test algorithm: check size +/- 5%, defined content size = 33
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 33, 5);		// Test [87] <- Index 87
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





		// --- HTTP REQUEST: Test [88] <- WEB ADMIN Index 88 ---
		String requestProt0088 = "https";
		String requestHost0088 = "c2.staticflickr.com";
		int    requestPort0088 = 443;
		String requestFile0088 = "/2/1592/25923041684_aa04688964_c.jpg";
		String requestHeader0088 = "GET " + requestFile0088 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0088, requestHost0088, requestPort0088, requestHeader0088, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0088 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 140026
		// content test algorithm: check size +/- 5%, defined content size = 140026
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 140026, 5);		// Test [88] <- Index 88
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0089 = "c2.staticflickr.com";
		int    requestPort0089 = 443;
		String requestFile0089 = "/8/7356/buddyicons/29178312@N06.jpg" +
				"?1370548720";
		String requestHeader0089 = "GET " + requestFile0089 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0089, requestHost0089, requestPort0089, requestHeader0089, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0089 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 5440
		// content test algorithm: check size +/- 5%, defined content size = 5440
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 5440, 5);		// Test [89] <- Index 89
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0090 = "c2.staticflickr.com";
		int    requestPort0090 = 443;
		String requestFile0090 = "/2/1487/26255062880_24e6edff27_c.jpg";
		String requestHeader0090 = "GET " + requestFile0090 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0090, requestHost0090, requestPort0090, requestHeader0090, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0090 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 201437
		// content test algorithm: check size +/- 5%, defined content size = 201437
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 201437, 5);		// Test [90] <- Index 90
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0091 = "api.flickr.com";
		int    requestPort0091 = 443;
		String requestFile0091 = "/services/rest" +
				"?format=json" +
				"&clientType=yui-3-flickrapi-module" +
				"&api_key=f5dfe6a3d0e27250877ed624b6b2048e" +
				"&auth_hash=335141336d4366657f6c36af16e31494b8f3edc3baf999403495290de6874939" +
				"&auth_token=" +
				"&secret=cbd6de88eadc878b" +
				"&lWidth=920" +
				"&page=2" +
				"&per_page=15" +
				"&$id_collection=26510214746%2C25925572923%2C26509809126%2C25932648303%2C26467663581%2C26504089526%2C26462489301%2C25923041684%2C26255062880%2C8056883623%2C134023654%2C51880532%2C134700583%2C130839845%2C8076464060%2C5770032957%2C97203584%2C6177803%2C3353748%2C87931817%2C127207901" +
				"&method=flickr.refresh.activity.getPhotoFeed" +
				"&jsoncallback=YUI.flickrAPITransactions.flapicb2" +
				"&cachebust=1461135891469";
		String requestHeader0091 = "GET " + requestFile0091 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0091, requestHost0091, requestPort0091, requestHeader0091, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0091 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 3292
		// content test algorithm: check size +/- 5%, defined content size = 3292
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/JAVASCRIPT", null, 3292, 5);		// Test [91] <- Index 91
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0092 = "c2.staticflickr.com";
		int    requestPort0092 = 443;
		String requestFile0092 = "/2/1592/25923041684_aa04688964_q.jpg";
		String requestHeader0092 = "GET " + requestFile0092 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0092, requestHost0092, requestPort0092, requestHeader0092, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0092 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 16646
		// content test algorithm: check size +/- 5%, defined content size = 16646
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 16646, 5);		// Test [92] <- Index 92
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0093 = "c2.staticflickr.com";
		int    requestPort0093 = 443;
		String requestFile0093 = "/2/1634/26435633932_e8e17237b3_q.jpg";
		String requestHeader0093 = "GET " + requestFile0093 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0093, requestHost0093, requestPort0093, requestHeader0093, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0093 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 16695
		// content test algorithm: check size +/- 5%, defined content size = 16695
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 16695, 5);		// Test [93] <- Index 93
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		// ... continuing page #2 (fragment 2 of 7)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [94] <- WEB ADMIN Index 94 ---
		String requestProt0094 = "https";
		String requestHost0094 = "s.yimg.com";
		int    requestPort0094 = 443;
		String requestFile0094 = "/pw/images/play_button_triangle.png";
		String requestHeader0094 = "GET " + requestFile0094 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0094, requestHost0094, requestPort0094, requestHeader0094, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0094 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 131
		// content test algorithm: check size +/- 5%, defined content size = 131
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 131, 5);		// Test [94] <- Index 94
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0095 = "y-flickr.yahoo.com";
		int    requestPort0095 = 443;
		String requestFile0095 = "/ad" +
				"?spaceid=792600147" +
				"&position=LDRB2" +
				"&is_secure=1" +
				"&adid=yui_3_11_0_3_1461135789675_932";
		String requestHeader0095 = "GET " + requestFile0095 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: y-flickr.yahoo.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0095, requestHost0095, requestPort0095, requestHeader0095, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0095 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1213
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "body { margin: 0; } .can_ad_slug { display: none !important; }");		// Test [95] <- Index 95
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





		// --- HTTP REQUEST: Test [96] <- WEB ADMIN Index 96 ---
		String requestProt0096 = "https";
		String requestHost0096 = "y-flickr.yahoo.com";
		int    requestPort0096 = 443;
		String requestFile0096 = "/ad" +
				"?spaceid=792600147" +
				"&position=LDRB" +
				"&is_secure=1" +
				"&adid=yui_3_11_0_3_1461135789675_919";
		String requestHeader0096 = "GET " + requestFile0096 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: y-flickr.yahoo.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
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

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1239
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "body { margin: 0; } .can_ad_slug { display: none !important; }");		// Test [96] <- Index 96
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
		String requestHost0097 = "api.flickr.com";
		int    requestPort0097 = 443;
		String requestFile0097 = "/services/rest";
		String requestContent0097 = 
				"format=json" +
				"&clientType=yui-3-flickrapi-module" +
				"&api_key=f5dfe6a3d0e27250877ed624b6b2048e" +
				"&auth_hash=335141336d4366657f6c36af16e31494b8f3edc3baf999403495290de6874939" +
				"&auth_token=" +
				"&secret=cbd6de88eadc878b" +
				"&views=%5B%7B%22photo_id%22%3A%2226459702591%22%2C%22async%22%3Atrue%2C%22referrer%22%3A%22https%3A%2F%2Fwww.flickr.com%2F%22%7D%2C%7B%22photo_id%22%3A%2226435633932%22%2C%22async%22%3Atrue%2C%22referrer%22%3A%22https%3A%2F%2Fwww.flickr.com%2F%22%7D%5D" +
				"&method=flickr.photos.addView" +
				"&nojsoncallback=1";
		byte[] requestContentBinary0097 = requestContent0097.getBytes("UTF-8");
		String requestHeader0097 = "POST " + requestFile0097 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0097.length + "\r\n" + 		// Content-Length: 495
				"origin: https://www.flickr.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0097, requestHost0097, requestPort0097, requestHeader0097, requestContentBinary0097, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
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
		requestHeader0097 = null;		// support garbage collector to reduce memory
		requestContent0097 = null;		// support garbage collector to reduce memory
		requestContentBinary0097 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 33
		// content test algorithm: check size +/- 5%, defined content size = 33
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 33, 5);		// Test [97] <- Index 97
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





		// --- HTTP REQUEST: Test [98] <- WEB ADMIN Index 98 ---
		String requestProt0098 = "https";
		String requestHost0098 = "farm2.staticflickr.com";
		int    requestPort0098 = 443;
		String requestFile0098 = "/1665/26527920195_1de42466e7_b.jpg";
		String requestHeader0098 = "GET " + requestFile0098 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: farm2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0098, requestHost0098, requestPort0098, requestHeader0098, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0098 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 59990
		// content test algorithm: check size +/- 5%, defined content size = 59990
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 59990, 5);		// Test [98] <- Index 98
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0099 = "www.flickr.com";
		int    requestPort0099 = 443;
		String requestFile0099 = "/photos/amirashfaq/";
		String requestHeader0099 = "GET " + requestFile0099 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0099, requestHost0099, requestPort0099, requestHeader0099, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0099 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 50964
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Amir Ashfaq | Flickr - Photo Sharing!");		// Test [99] <- Index 99
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





		// --- HTTP REQUEST: Test [100] <- WEB ADMIN Index 100 ---
		String requestProt0100 = "https";
		String requestHost0100 = "pagead2.googlesyndication.com";
		int    requestPort0100 = 443;
		String requestFile0100 = "/activeview" +
				"?avi=BPsqSyykXV9uBBsy3Ys62uZAHAKPEwfOwAQAAEAE4AcgBCcgDCKAGLsITBhjVoYzaAw" +
				"&cid=5GgkiExL48B_iSC_8fNp0UZpZtk" +
				"&id=osdtos" +
				"&ti=1" +
				"&adk=1661788582" +
				"&p=49,875,299,1175" +
				"&tos=13372,0,0,55888,0" +
				"&mtos=12028,12028,12028,57232,57232" +
				"&rs=1" +
				"&ht=0" +
				"&tfs=13749" +
				"&tls=87017" +
				"&mc=1" +
				"&lte=0" +
				"&bas=0" +
				"&bac=0" +
				"&fp=client%3Dca-pub-5786243031610172%26url%3Dhttps%253A%252F%252Fy-flickr.yahoo.com%252Fad.gne%253Fspaceid%253D792600147%26correlator%3D321556588783%26ifk%3D4238692812%26oid%3D3" +
				"&afp=%26format%3D300x250%26output%3Dhtml%26slotname%3D6115872042%26flash%3D0%26dt%3D1461135807080%26adx%3D0%26ady%3D0%26ifi%3D1" +
				"&r=u" +
				"&bs=1260,586" +
				"&bos=1260,734" +
				"&ps=-12245933,-12245933" +
				"&ss=1920,1080" +
				"&tt=73270" +
				"&pt=13748" +
				"&xde=1" +
				"&deb=1-1-1-26-83-7" +
				"&tvt=73375" +
				"&iframe_loc=https%3A%2F%2Fna.ads.yahoo.com%2Fyax%2Fbanner%3Fve%3D1%26tt%3D3%26si%3D75025551%26megamodal%3D%24%7BMEGAMODAL%7D%26bucket%3D%24%7BY-BUCKET%7D%26asz%3D300x250%26u%3Dhttps%3A%2F%2Fy-flickr.yahoo.com%2Fad.gne%3Fspaceid%3D792600147%26position%3DLREC%26is_secure%3D1%26adid%3Dnone%26gdAdId%3D0EAXtWKLn24-%26gdUuid%3DloetljY2LjEsHpk1VxcpTgaDMTk0LgAAAAAwLZlI%26gdSt%3D1461135797542281%26publisher_blob%3D%24%7BRS%7D%7CloetljY2LjEsHpk1VxcpTgaDMTk0LgAAAAAwLZlI%7C792600147%7CLREC%7C1461135797.483712%7C%24%7BSECURE-DARLA%7D%26pub_redirect%3Dhttps%3A%2F%2Fbeap-bc.yahoo.com%2Fyc%2FYnY9MS4wLjAmYnM9KDE3aHZpZGcwYyhnaWQkbG9ldGxqWTJMakVzSHBrMVZ4Y3BUZ2F" +
				"&is=300,250" +
				"&uc=82" +
				"&tgt=nf" +
				"&cl=0";
		String requestHeader0100 = "GET " + requestFile0100 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: pagead2.googlesyndication.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0100, requestHost0100, requestPort0100, requestHeader0100, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0100 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 42
		// content test algorithm: check size +/- 5%, defined content size = 42
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 42, 5);		// Test [100] <- Index 100
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0101 = "s.yimg.com";
		int    requestPort0101 = 443;
		String requestFile0101 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/fluid-overlay-css/fluid-overlay-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-share-css/fluid-share-css-min.css" +
				"&uy/build/hermes-1.1.452/account-menu-css/account-menu-css-min.css" +
				"&uy/build/hermes-1.1.452/flickrui-css/flickrui-css-min.css" +
				"&uy/build/hermes-1.1.452/person-card-css/person-card-css-min.css" +
				"&uy/build/hermes-1.1.452/group-card-css/group-card-css-min.css" +
				"&uy/build/hermes-1.1.452/signup-modal-css/signup-modal-css-min.css" +
				"&uy/build/hermes-1.1.452/signup-interstitial-css/signup-interstitial-css-min.css" +
				"&uy/build/hermes-1.1.452/mobile-app-upsell-css/mobile-app-upsell-css-min.css" +
				"&uy/build/hermes-1.1.452/footer-full-css/footer-full-css-min.css" +
				"&uy/build/hermes-1.1.452/flickrui-dialogs-css/flickrui-dialogs-css-min.css" +
				"&uy/build/hermes-1.1.452/infinite-scroll-load-more-css/infinite-scroll-load-more-css-min.css" +
				"&uy/build/hermes-1.1.452/photo-list-photo-css/photo-list-photo-css-min.css" +
				"&uy/build/hermes-1.1.452/pagination-view-css/pagination-view-css-min.css" +
				"&uy/build/hermes-1.1.452/follow-css/follow-css-min.css" +
				"&uy/build/hermes-1.1.452/relationship-menu-css/relationship-menu-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-avatar-editor-css/fluid-avatar-editor-css-min.css" +
				"&uy/build/hermes-1.1.452/photo-selector-css/photo-selector-css-min.css" +
				"&uy/build/hermes-1.1.452/photo-list-photo-interaction-css/photo-list-photo-interaction-css-min.css" +
				"&uy/build/hermes-1.1.452/photo-list-album-interaction-css/photo-list-album-interaction-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-share-panel-css/fluid-share-panel-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-share-panel-restyle-css/fluid-share-panel-restyle-css-min.css" +
				"&uy/build/hermes-1.1.452/contact-search-css/contact-search-css-min.css" +
				"&uy/build/hermes-1.1.452/html5-balls-css/html5-balls-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-magic-tools-css/fluid-magic-tools-css-min.css" +
				"&uy/build/hermes-1.1.452/slideshow-css/slideshow-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-magic-search-css/fluid-magic-search-css-min.css";
		String requestHeader0101 = "GET " + requestFile0101 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0101, requestHost0101, requestPort0101, requestHeader0101, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0101 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 37162
		// content test algorithm: check size +/- 5%, defined content size = 37162
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 37162, 5);		// Test [101] <- Index 101
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0102 = "s.yimg.com";
		int    requestPort0102 = 443;
		String requestFile0102 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/account-menu-card-css/account-menu-card-css-min.css" +
				"&uy/build/hermes-1.1.452/layout-scrolling-css/layout-scrolling-css-min.css";
		String requestHeader0102 = "GET " + requestFile0102 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0102, requestHost0102, requestPort0102, requestHeader0102, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0102 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 635
		// content test algorithm: check size +/- 5%, defined content size = 635
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 635, 5);		// Test [102] <- Index 102
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0103 = "s.yimg.com";
		int    requestPort0103 = 443;
		String requestFile0103 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/base-css/base-css-min.css" +
				"&uy/build/hermes-1.1.452/pure-css/pure-css-min.css" +
				"&uy/build/hermes-1.1.452/loaded-state-css/loaded-state-css-min.css" +
				"&uy/build/hermes-1.1.452/photostream-page-css/photostream-page-css-min.css" +
				"&uy/build/hermes-1.1.452/global-nav-css/global-nav-css-min.css" +
				"&uy/build/hermes-1.1.452/util-css/util-css-min.css" +
				"&uy/build/hermes-1.1.452/global-nav-restyle-css/global-nav-restyle-css-min.css" +
				"&uy/build/hermes-1.1.452/search-autosuggest-field-css/search-autosuggest-field-css-min.css" +
				"&uy/build/hermes-1.1.452/search-autosuggest-items-list-css/search-autosuggest-items-list-css-min.css" +
				"&uy/build/hermes-1.1.452/autosuggest-css/autosuggest-css-min.css" +
				"&uy/build/hermes-1.1.452/notifications-menu-css/notifications-menu-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-css/fluid-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-animations-css/fluid-animations-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-avatars-css/fluid-avatars-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-buttons-css/fluid-buttons-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-typography-css/fluid-typography-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-tables-css/fluid-tables-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-toggles-css/fluid-toggles-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-subnav-css/fluid-subnav-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-chalkboard-css/fluid-chalkboard-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-modal-css/fluid-modal-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-modal-nav-bar-css/fluid-modal-nav-bar-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-balls-css/fluid-balls-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-droparound-css/fluid-droparound-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-util-css/fluid-util-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-dots-css/fluid-dots-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-notification-css/fluid-notification-css-min.css" +
				"&uy/build/hermes-1.1.452/fluid-coverphoto-css/fluid-coverphoto-css-min.css";
		String requestHeader0103 = "GET " + requestFile0103 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0103, requestHost0103, requestPort0103, requestHeader0103, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0103 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 22519
		// content test algorithm: check size +/- 5%, defined content size = 22519
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 22519, 5);		// Test [103] <- Index 103
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [104] <- WEB ADMIN Index 104 ---
		String requestProt0104 = "https";
		String requestHost0104 = "s.yimg.com";
		int    requestPort0104 = 443;
		String requestFile0104 = "/pw/images/icon_black_white.svg";
		String requestHeader0104 = "GET " + requestFile0104 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0104, requestHost0104, requestPort0104, requestHeader0104, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0104 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/SVG+XML", header text fragment = [verification disabled], recorded content size = 504
		// content test algorithm: check size +/- 5%, defined content size = 504
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/SVG+XML", null, 504, 5);		// Test [104] <- Index 104
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [105] <- WEB ADMIN Index 105 ---
		String requestProt0105 = "https";
		String requestHost0105 = "c2.staticflickr.com";
		int    requestPort0105 = 443;
		String requestFile0105 = "/3/2905/14729600185_1b5c88efc0.jpg";
		String requestHeader0105 = "GET " + requestFile0105 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0105, requestHost0105, requestPort0105, requestHeader0105, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0105 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 98205
		// content test algorithm: check size +/- 5%, defined content size = 98205
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 98205, 5);		// Test [105] <- Index 105
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
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
		String requestHost0106 = "s.yimg.com";
		int    requestPort0106 = 443;
		String requestFile0106 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/attribute-helpers/attribute-helpers-min.js" +
				"&uy/build/hermes-1.1.452/fluid-overlay-manager-view/fluid-overlay-manager-view-min.js" +
				"&uy/build/hermes-1.1.452/fluid-droparound-view/fluid-droparound-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-person-card/hermes-template-person-card-min.js" +
				"&uy/build/hermes-1.1.452/person-card-view/person-card-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-person/hermes-lang-person-min.js" +
				"&uy/build/hermes-1.1.452/person-menu-view/person-menu-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-group-card/hermes-template-group-card-min.js" +
				"&uy/build/hermes-1.1.452/group-card-view/group-card-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-relative-dates/hermes-lang-relative-dates-min.js" +
				"&uy/build/hermes-1.1.452/group-menu-view/group-menu-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-modal/hermes-template-fluid-modal-min.js" +
				"&uy/build/hermes-1.1.452/fluid-modal-view/fluid-modal-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-signup-modal/hermes-template-signup-modal-min.js" +
				"&uy/build/hermes-1.1.452/signup-modal-view/signup-modal-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-signup-interstitial/hermes-template-signup-interstitial-min.js" +
				"&uy/build/hermes-1.1.452/signup-interstitial-view/signup-interstitial-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-growth/hermes-lang-growth-min.js" +
				"&uy/build/hermes-1.1.452/signin-helper/signin-helper-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-mobile-app-upsell/hermes-template-mobile-app-upsell-min.js" +
				"&uy/build/hermes-1.1.452/mobile-app-upsell-view/mobile-app-upsell-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-mobile/hermes-lang-mobile-min.js" +
				"&uy/build/hermes-1.1.452/global-nav-view/global-nav-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-global-nav/hermes-lang-global-nav-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-darla-script-setup/hermes-template-darla-script-setup-min.js";
		String requestHeader0106 = "GET " + requestFile0106 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0106, requestHost0106, requestPort0106, requestHeader0106, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0106 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 19548
		// content test algorithm: check size +/- 5%, defined content size = 19548
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 19548, 5);		// Test [106] <- Index 106
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0107 = "s.yimg.com";
		int    requestPort0107 = 443;
		String requestFile0107 = "/uy/build/javascripts/flickr-js-sdk-68b1e73a.js";
		String requestHeader0107 = "GET " + requestFile0107 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0107, requestHost0107, requestPort0107, requestHeader0107, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0107 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 132258
		// content test algorithm: check size +/- 5%, defined content size = 132258
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 132258, 5);		// Test [107] <- Index 107
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0108 = "s.yimg.com";
		int    requestPort0108 = 443;
		String requestFile0108 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/flickr-prefs-setSafeSearch-updater/flickr-prefs-setSafeSearch-updater-min.js" +
				"&uy/build/hermes-1.1.452/person-preferences-models/person-preferences-models-min.js" +
				"&uy/build/hermes-1.1.452/person-profile-models/person-profile-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-join-creator/flickr-groups-join-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-leave-deletor/flickr-groups-leave-deletor-min.js" +
				"&uy/build/hermes-1.1.452/group-info-models/group-info-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-getInfo-fetcher/flickr-groups-getInfo-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-favorites-add-updater/flickr-favorites-add-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-favorites-remove-updater/flickr-favorites-remove-updater-min.js" +
				"&uy/build/hermes-1.1.452/photo-model-helper/photo-model-helper-min.js" +
				"&uy/build/hermes-1.1.452/group-models/group-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-licensing-curation-passOverUser-updater/flickr-licensing-curation-passOverUser-updater-min.js" +
				"&uy/build/hermes-1.1.452/photo-curation-models/photo-curation-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-geo-setLocation-updater/flickr-photos-geo-setLocation-updater-min.js" +
				"&uy/build/hermes-1.1.452/photo-geo-models/photo-geo-models-min.js" +
				"&uy/build/hermes-1.1.452/photo-location-models/photo-location-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-getLocation-fetcher/flickr-photos-getLocation-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/photo-engagement-models/photo-engagement-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-setDates-updater/flickr-photos-setDates-updater-min.js" +
				"&uy/build/hermes-1.1.452/moment-timezone/moment-timezone-min.js" +
				"&uy/build/hermes-1.1.452/photo-stats-models/photo-stats-models-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-models/hermes-lang-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-getHtmlMeta-fetcher/flickr-photos-getHtmlMeta-fetcher-min.js";
		String requestHeader0108 = "GET " + requestFile0108 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0108, requestHost0108, requestPort0108, requestHeader0108, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0108 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 34246
		// content test algorithm: check size +/- 5%, defined content size = 34246
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 34246, 5);		// Test [108] <- Index 108
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0109 = "c2.staticflickr.com";
		int    requestPort0109 = 443;
		String requestFile0109 = "/4/3900/14726424241_4c69a717e3.jpg";
		String requestHeader0109 = "GET " + requestFile0109 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0109, requestHost0109, requestPort0109, requestHeader0109, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0109 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 121834
		// content test algorithm: check size +/- 5%, defined content size = 121834
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 121834, 5);		// Test [109] <- Index 109
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0110 = "c2.staticflickr.com";
		int    requestPort0110 = 443;
		String requestFile0110 = "/4/3850/14726421601_9fa28da1ff_n.jpg";
		String requestHeader0110 = "GET " + requestFile0110 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0110, requestHost0110, requestPort0110, requestHeader0110, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0110 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 28582
		// content test algorithm: check size +/- 5%, defined content size = 28582
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 28582, 5);		// Test [110] <- Index 110
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0111 = "c2.staticflickr.com";
		int    requestPort0111 = 443;
		String requestFile0111 = "/6/5572/14726425441_90757eb560.jpg";
		String requestHeader0111 = "GET " + requestFile0111 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0111, requestHost0111, requestPort0111, requestHeader0111, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0111 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 98627
		// content test algorithm: check size +/- 5%, defined content size = 98627
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 98627, 5);		// Test [111] <- Index 111
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0112 = "c2.staticflickr.com";
		int    requestPort0112 = 443;
		String requestFile0112 = "/6/5585/14729615905_91462d85a9_z.jpg";
		String requestHeader0112 = "GET " + requestFile0112 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0112, requestHost0112, requestPort0112, requestHeader0112, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0112 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 120523
		// content test algorithm: check size +/- 5%, defined content size = 120523
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 120523, 5);		// Test [112] <- Index 112
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0113 = "s.yimg.com";
		int    requestPort0113 = 443;
		String requestFile0113 = "/zz/combo" +
				"?yui:3.16.0/event-tap/event-tap-min.js" +
				"&uy/build/hermes-1.1.452/better-throttle/better-throttle-min.js" +
				"&uy/build/hermes-1.1.452/global-events/global-events-min.js" +
				"&uy/build/hermes-1.1.452/storage-helper/storage-helper-min.js" +
				"&uy/build/hermes-1.1.452/keyboard-manager/keyboard-manager-min.js" +
				"&uy/build/hermes-1.1.452/overflow-helper/overflow-helper-min.js" +
				"&uy/build/hermes-1.1.452/client-app/client-app-min.js" +
				"&yui:3.16.0/intl/intl-min.js" +
				"&uy/build/hermes-1.1.452/flutil/flutil-min.js" +
				"&yui:3.16.0/base-pluginhost/base-pluginhost-min.js" +
				"&yui:3.16.0/template-base/template-base-min.js" +
				"&uy/build/hermes-1.1.452/flickr-view/flickr-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photostream-page/hermes-template-photostream-page-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-global-nav/hermes-template-global-nav-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-global-nav-restyle/hermes-template-global-nav-restyle-min.js" +
				"&uy/build/hermes-1.1.452/search-helper/search-helper-min.js" +
				"&uy/build/hermes-1.1.452/search-url/search-url-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-search-pill/hermes-template-search-pill-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-search-autosuggest-field/hermes-template-search-autosuggest-field-min.js" +
				"&uy/build/hermes-1.1.452/model-proxy/model-proxy-min.js" +
				"&uy/build/hermes-1.1.452/flickr-collection/flickr-collection-min.js" +
				"&uy/build/hermes-1.1.452/paged-collection/paged-collection-min.js" +
				"&uy/build/hermes-1.1.452/flickr-model-registry/flickr-model-registry-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-autosuggest/hermes-lang-autosuggest-min.js" +
				"&yui:3.16.0/text-data-accentfold/text-data-accentfold-min.js" +
				"&yui:3.16.0/text-accentfold/text-accentfold-min.js" +
				"&uy/build/hermes-1.1.452/autosuggest-context-results-models/autosuggest-context-results-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-autosuggest-getContextResults-fetcher/flickr-autosuggest-getContextResults-fetcher-min.js";
		String requestHeader0113 = "GET " + requestFile0113 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0113, requestHost0113, requestPort0113, requestHeader0113, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0113 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 36689
		// content test algorithm: check size +/- 5%, defined content size = 36689
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 36689, 5);		// Test [113] <- Index 113
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		// ... continuing page #2 (fragment 3 of 7)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [114] <- WEB ADMIN Index 114 ---
		String requestProt0114 = "https";
		String requestHost0114 = "s.yimg.com";
		int    requestPort0114 = 443;
		String requestFile0114 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/hermes-template-footer-full/hermes-template-footer-full-min.js" +
				"&uy/build/hermes-1.1.452/dropdown/dropdown-min.js" +
				"&uy/build/hermes-1.1.452/footer-full-view/footer-full-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-list-aft/hermes-template-photo-list-aft-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-infinite-scroll-load-more/hermes-template-infinite-scroll-load-more-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-license-detail/hermes-template-license-detail-min.js" +
				"&uy/build/hermes-1.1.452/photo-list-layout-row/photo-list-layout-row-min.js" +
				"&uy/build/hermes-1.1.452/photo-list-layout/photo-list-layout-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-list-photo/hermes-template-photo-list-photo-min.js" +
				"&uy/build/hermes-1.1.452/photo-list-photo-view/photo-list-photo-view-min.js" +
				"&uy/build/hermes-1.1.452/photo-list-view/photo-list-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-pagination-view/hermes-template-pagination-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-head-link/hermes-template-head-link-min.js" +
				"&uy/build/hermes-1.1.452/pagination-view/pagination-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-coverphoto/hermes-template-fluid-coverphoto-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-follow/hermes-template-follow-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-following-dropdown/hermes-template-following-dropdown-min.js" +
				"&uy/build/hermes-1.1.452/relationship-menu-view/relationship-menu-view-min.js" +
				"&uy/build/hermes-1.1.452/flickr-contacts-add-updater/flickr-contacts-add-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-contacts-remove-updater/flickr-contacts-remove-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-contacts-edit-updater/flickr-contacts-edit-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-contacts-block-updater/flickr-contacts-block-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-contacts-unblock-updater/flickr-contacts-unblock-updater-min.js";
		String requestHeader0114 = "GET " + requestFile0114 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0114, requestHost0114, requestPort0114, requestHeader0114, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0114 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 24880
		// content test algorithm: check size +/- 5%, defined content size = 24880
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 24880, 5);		// Test [114] <- Index 114
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
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
		String requestHost0115 = "s.yimg.com";
		int    requestPort0115 = 443;
		String requestFile0115 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/hermes-template-search-autosuggest-list-item/hermes-template-search-autosuggest-list-item-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-search-autosuggest-items-list/hermes-template-search-autosuggest-items-list-min.js" +
				"&uy/build/hermes-1.1.452/autosuggest-data-manager/autosuggest-data-manager-min.js" +
				"&uy/build/hermes-1.1.452/fluid/fluid-min.js" +
				"&uy/build/hermes-1.1.452/search-autosuggest-items-list-view/search-autosuggest-items-list-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-search/hermes-lang-search-min.js" +
				"&uy/build/hermes-1.1.452/search-autosuggest-field-view/search-autosuggest-field-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-common/hermes-lang-common-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-groups/hermes-lang-groups-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-autosuggest-bar/hermes-template-autosuggest-bar-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-autosuggest-item/hermes-template-autosuggest-item-min.js" +
				"&uy/build/hermes-1.1.452/autosuggest-view/autosuggest-view-min.js" +
				"&uy/build/hermes-1.1.452/search-bar-view/search-bar-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-notifications-menu/hermes-template-notifications-menu-min.js" +
				"&uy/build/hermes-1.1.452/notifications-menu-view/notifications-menu-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-notifications-menu/hermes-lang-notifications-menu-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-dialog-tooltip/hermes-template-dialog-tooltip-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-dialog-modal/hermes-template-dialog-modal-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-dialog-alert/hermes-template-dialog-alert-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-dialog-cta/hermes-template-dialog-cta-min.js" +
				"&uy/build/hermes-1.1.452/dialog/dialog-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-droparound/hermes-template-fluid-droparound-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-flickr-balls/hermes-template-flickr-balls-min.js";
		String requestHeader0115 = "GET " + requestFile0115 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0115, requestHost0115, requestPort0115, requestHeader0115, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0115 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 33291
		// content test algorithm: check size +/- 5%, defined content size = 33291
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 33291, 5);		// Test [115] <- Index 115
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [116] <- WEB ADMIN Index 116 ---
		String requestProt0116 = "https";
		String requestHost0116 = "farm9.staticflickr.com";
		int    requestPort0116 = 443;
		String requestFile0116 = "/8120/coverphoto/37001817@N05_h.jpg" +
				"?1401996965";
		String requestHeader0116 = "GET " + requestFile0116 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: farm9.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0116, requestHost0116, requestPort0116, requestHeader0116, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0116 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 293631
		// content test algorithm: check size +/- 5%, defined content size = 293631
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 293631, 5);		// Test [116] <- Index 116
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [117] <- WEB ADMIN Index 117 ---
		String requestProt0117 = "https";
		String requestHost0117 = "c3.staticflickr.com";
		int    requestPort0117 = 443;
		String requestFile0117 = "/6/5594/14729319122_07a1258704_n.jpg";
		String requestHeader0117 = "GET " + requestFile0117 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c3.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0117, requestHost0117, requestPort0117, requestHeader0117, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0117 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 34037
		// content test algorithm: check size +/- 5%, defined content size = 34037
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 34037, 5);		// Test [117] <- Index 117
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [118] <- WEB ADMIN Index 118 ---
		String requestProt0118 = "https";
		String requestHost0118 = "c6.staticflickr.com";
		int    requestPort0118 = 443;
		String requestFile0118 = "/4/3873/14749475013_8f138a22dc.jpg";
		String requestHeader0118 = "GET " + requestFile0118 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c6.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0118, requestHost0118, requestPort0118, requestHeader0118, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0118 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 68448
		// content test algorithm: check size +/- 5%, defined content size = 68448
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 68448, 5);		// Test [118] <- Index 118
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [119] <- WEB ADMIN Index 119 ---
		String requestProt0119 = "https";
		String requestHost0119 = "c4.staticflickr.com";
		int    requestPort0119 = 443;
		String requestFile0119 = "/4/3888/14749476363_50ea9296c7.jpg";
		String requestHeader0119 = "GET " + requestFile0119 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c4.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0119, requestHost0119, requestPort0119, requestHeader0119, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0119 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 99827
		// content test algorithm: check size +/- 5%, defined content size = 99827
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 99827, 5);		// Test [119] <- Index 119
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [120] <- WEB ADMIN Index 120 ---
		String requestProt0120 = "https";
		String requestHost0120 = "c4.staticflickr.com";
		int    requestPort0120 = 443;
		String requestFile0120 = "/3/2924/14729612715_6b73927b23_n.jpg";
		String requestHeader0120 = "GET " + requestFile0120 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c4.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0120, requestHost0120, requestPort0120, requestHeader0120, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0120 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 51554
		// content test algorithm: check size +/- 5%, defined content size = 51554
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 51554, 5);		// Test [120] <- Index 120
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [121] <- WEB ADMIN Index 121 ---
		String requestProt0121 = "https";
		String requestHost0121 = "c4.staticflickr.com";
		int    requestPort0121 = 443;
		String requestFile0121 = "/3/2938/14726418811_e0d95da926.jpg";
		String requestHeader0121 = "GET " + requestFile0121 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c4.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0121, requestHost0121, requestPort0121, requestHeader0121, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0121 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 93199
		// content test algorithm: check size +/- 5%, defined content size = 93199
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 93199, 5);		// Test [121] <- Index 121
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [122] <- WEB ADMIN Index 122 ---
		String requestProt0122 = "https";
		String requestHost0122 = "c4.staticflickr.com";
		int    requestPort0122 = 443;
		String requestFile0122 = "/4/3858/14543162147_68410ec7f9.jpg";
		String requestHeader0122 = "GET " + requestFile0122 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c4.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0122, requestHost0122, requestPort0122, requestHeader0122, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0122 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 103829
		// content test algorithm: check size +/- 5%, defined content size = 103829
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 103829, 5);		// Test [122] <- Index 122
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [123] <- WEB ADMIN Index 123 ---
		String requestProt0123 = "https";
		String requestHost0123 = "c7.staticflickr.com";
		int    requestPort0123 = 443;
		String requestFile0123 = "/6/5594/14727246894_24a46543f8_z.jpg";
		String requestHeader0123 = "GET " + requestFile0123 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c7.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0123, requestHost0123, requestPort0123, requestHeader0123, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0123 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 115490
		// content test algorithm: check size +/- 5%, defined content size = 115490
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 115490, 5);		// Test [123] <- Index 123
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [124] <- WEB ADMIN Index 124 ---
		String requestProt0124 = "https";
		String requestHost0124 = "c8.staticflickr.com";
		int    requestPort0124 = 443;
		String requestFile0124 = "/6/5555/14726423071_03cdc5c419_n.jpg";
		String requestHeader0124 = "GET " + requestFile0124 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c8.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0124, requestHost0124, requestPort0124, requestHeader0124, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0124 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 48192
		// content test algorithm: check size +/- 5%, defined content size = 48192
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 48192, 5);		// Test [124] <- Index 124
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [125] <- WEB ADMIN Index 125 ---
		String requestProt0125 = "https";
		String requestHost0125 = "s.yimg.com";
		int    requestPort0125 = 443;
		String requestFile0125 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/avatar-saver/avatar-saver-min.js" +
				"&uy/build/hermes-1.1.452/fluid-coverphoto-view/fluid-coverphoto-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-context/hermes-lang-context-min.js" +
				"&uy/build/hermes-1.1.452/curator-pass-over-view/curator-pass-over-view-min.js" +
				"&uy/build/hermes-1.1.452/fluid-photostream-coverphoto-view/fluid-photostream-coverphoto-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-subnav/hermes-template-fluid-subnav-min.js" +
				"&uy/build/hermes-1.1.452/animation-manager/animation-manager-min.js" +
				"&uy/build/hermes-1.1.452/fluid-subnav-view/fluid-subnav-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-filter-bar/hermes-lang-filter-bar-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-cameraroll/hermes-lang-cameraroll-min.js" +
				"&uy/build/hermes-1.1.452/fluid-magic-subnav-view/fluid-magic-subnav-view-min.js" +
				"&uy/build/hermes-1.1.452/photolist-aft-helper/photolist-aft-helper-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-dynamic-page-head/hermes-template-dynamic-page-head-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-head-meta/hermes-template-head-meta-min.js" +
				"&uy/build/hermes-1.1.452/photostream-page-view/photostream-page-view-min.js" +
				"&uy/build/hermes-1.1.452/person-contacts-count-models/person-contacts-count-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-people-contacts-getInfo-fetcher/flickr-people-contacts-getInfo-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/contact-models/contact-models-min.js" +
				"&uy/build/hermes-1.1.452/notification-event-fave-models/notification-event-fave-models-min.js" +
				"&uy/build/hermes-1.1.452/notification-event-comment-models/notification-event-comment-models-min.js" +
				"&uy/build/hermes-1.1.452/notification-event-follower-models/notification-event-follower-models-min.js" +
				"&uy/build/hermes-1.1.452/notification-event-added-to-gallery-models/notification-event-added-to-gallery-models-min.js" +
				"&uy/build/hermes-1.1.452/notification-event-people-models/notification-event-people-models-min.js";
		String requestHeader0125 = "GET " + requestFile0125 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0125, requestHost0125, requestPort0125, requestHeader0125, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0125 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 15755
		// content test algorithm: check size +/- 5%, defined content size = 15755
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 15755, 5);		// Test [125] <- Index 125
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [126] <- WEB ADMIN Index 126 ---
		String requestProt0126 = "https";
		String requestHost0126 = "c6.staticflickr.com";
		int    requestPort0126 = 443;
		String requestFile0126 = "/3/2897/14543158077_c6a8b1a83c.jpg";
		String requestHeader0126 = "GET " + requestFile0126 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c6.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0126, requestHost0126, requestPort0126, requestHeader0126, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0126 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 110342
		// content test algorithm: check size +/- 5%, defined content size = 110342
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 110342, 5);		// Test [126] <- Index 126
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [127] <- WEB ADMIN Index 127 ---
		String requestProt0127 = "https";
		String requestHost0127 = "c3.staticflickr.com";
		int    requestPort0127 = 443;
		String requestFile0127 = "/4/3842/14729314442_770ecf609c.jpg";
		String requestHeader0127 = "GET " + requestFile0127 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c3.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0127, requestHost0127, requestPort0127, requestHeader0127, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0127 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 66659
		// content test algorithm: check size +/- 5%, defined content size = 66659
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 66659, 5);		// Test [127] <- Index 127
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [128] <- WEB ADMIN Index 128 ---
		String requestProt0128 = "https";
		String requestHost0128 = "c1.staticflickr.com";
		int    requestPort0128 = 443;
		String requestFile0128 = "/4/3905/14542957848_1a754e365d.jpg";
		String requestHeader0128 = "GET " + requestFile0128 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c1.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0128, requestHost0128, requestPort0128, requestHeader0128, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0128 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 41624
		// content test algorithm: check size +/- 5%, defined content size = 41624
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 41624, 5);		// Test [128] <- Index 128
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [129] <- WEB ADMIN Index 129 ---
		String requestProt0129 = "https";
		String requestHost0129 = "c7.staticflickr.com";
		int    requestPort0129 = 443;
		String requestFile0129 = "/3/2920/14542954638_373c2785f8_z.jpg";
		String requestHeader0129 = "GET " + requestFile0129 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c7.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0129, requestHost0129, requestPort0129, requestHeader0129, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0129 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 141068
		// content test algorithm: check size +/- 5%, defined content size = 141068
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 141068, 5);		// Test [129] <- Index 129
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [130] <- WEB ADMIN Index 130 ---
		String requestProt0130 = "https";
		String requestHost0130 = "s.yimg.com";
		int    requestPort0130 = 443;
		String requestFile0130 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/notification-event-tag-models/notification-event-tag-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-notifications-markread-updater/flickr-notifications-markread-updater-min.js" +
				"&uy/build/hermes-1.1.452/person-notifications-models/person-notifications-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-activity-recentByType-fetcher/flickr-activity-recentByType-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/notification-models/notification-models-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-client-app/hermes-lang-client-app-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-meta/hermes-lang-meta-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-magic-empty-states/hermes-lang-magic-empty-states-min.js";
		String requestHeader0130 = "GET " + requestFile0130 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0130, requestHost0130, requestPort0130, requestHeader0130, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0130 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 3638
		// content test algorithm: check size +/- 5%, defined content size = 3638
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 3638, 5);		// Test [130] <- Index 130
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [131] <- WEB ADMIN Index 131 ---
		String requestProt0131 = "https";
		String requestHost0131 = "s.yimg.com";
		int    requestPort0131 = 443;
		String requestFile0131 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/photo-head-meta-models/photo-head-meta-models-min.js" +
				"&uy/build/hermes-1.1.452/photo-notes-models/photo-notes-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-addNotes-creator/flickr-photos-addNotes-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-editNote-updater/flickr-photos-editNote-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-deleteNote-deletor/flickr-photos-deleteNote-deletor-min.js" +
				"&uy/build/hermes-1.1.452/note-models/note-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-deleteAutotags-deletor/flickr-photos-deleteAutotags-deletor-min.js" +
				"&uy/build/hermes-1.1.452/autotag-models/autotag-models-min.js" +
				"&uy/build/hermes-1.1.452/photo-autotags-models/photo-autotags-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-getInfo-fetcher/flickr-photos-getInfo-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-setPerms-updater/flickr-photos-setPerms-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-setMeta-updater/flickr-photos-setMeta-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-licenses-setLicense-updater/flickr-photos-licenses-setLicense-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-setSafetyLevel-updater/flickr-photos-setSafetyLevel-updater-min.js" +
				"&uy/build/hermes-1.1.452/photo-models/photo-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-pools-getContext-fetcher/flickr-groups-pools-getContext-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-pools-add-creator/flickr-groups-pools-add-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-pools-remove-deletor/flickr-groups-pools-remove-deletor-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-invite-photo-invite-creator/flickr-groups-invite-photo-invite-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-invite-photo-cancel-deletor/flickr-groups-invite-photo-cancel-deletor-min.js" +
				"&uy/build/hermes-1.1.452/group-pool-by-person-models/group-pool-by-person-models-min.js";
		String requestHeader0131 = "GET " + requestFile0131 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0131, requestHost0131, requestPort0131, requestHeader0131, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0131 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 6552
		// content test algorithm: check size +/- 5%, defined content size = 6552
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 6552, 5);		// Test [131] <- Index 131
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [132] <- WEB ADMIN Index 132 ---
		String requestProt0132 = "https";
		String requestHost0132 = "s.yimg.com";
		int    requestPort0132 = 443;
		String requestFile0132 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/html-file-dragdrop/html-file-dragdrop-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-selector/hermes-template-photo-selector-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-list-demo-subview/hermes-template-photo-list-demo-subview-min.js" +
				"&uy/build/hermes-1.1.452/photo-selector-photolist-view/photo-selector-photolist-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-search-photos-single-row/hermes-template-search-photos-single-row-min.js" +
				"&uy/build/hermes-1.1.452/photo-lite-models/photo-lite-models-min.js" +
				"&uy/build/hermes-1.1.452/search-photos-lite-models/search-photos-lite-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-search-fetcher/flickr-photos-search-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/search-photos-models/search-photos-models-min.js" +
				"&uy/build/hermes-1.1.452/photo-selector-limited-rows-photolist-view/photo-selector-limited-rows-photolist-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-selector-photo-list-photo-interaction/hermes-template-photo-selector-photo-list-photo-interaction-min.js" +
				"&uy/build/hermes-1.1.452/photo-selector-photolist-interaction-view/photo-selector-photolist-interaction-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-selector-sets-photolist-set-interaction/hermes-template-photo-selector-sets-photolist-set-interaction-min.js" +
				"&uy/build/hermes-1.1.452/photo-selector-sets-photolist-interaction-view/photo-selector-sets-photolist-interaction-view-min.js" +
				"&uy/build/hermes-1.1.452/photo-selector-view/photo-selector-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-wallart/hermes-lang-wallart-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-modal-nav-bar/hermes-template-fluid-modal-nav-bar-min.js" +
				"&uy/build/hermes-1.1.452/fluid-modal-nav-bar-view/fluid-modal-nav-bar-view-min.js" +
				"&uy/build/hermes-1.1.452/fluid-coverphoto-editor/fluid-coverphoto-editor-min.js" +
				"&uy/build/hermes-1.1.452/coverphoto-saver/coverphoto-saver-min.js";
		String requestHeader0132 = "GET " + requestFile0132 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0132, requestHost0132, requestPort0132, requestHeader0132, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0132 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 16223
		// content test algorithm: check size +/- 5%, defined content size = 16223
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 16223, 5);		// Test [132] <- Index 132
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [133] <- WEB ADMIN Index 133 ---
		String requestProt0133 = "https";
		String requestHost0133 = "s.yimg.com";
		int    requestPort0133 = 443;
		String requestFile0133 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/group-pool-by-tag-models/group-pool-by-tag-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-pools-getPhotos-fetcher/flickr-groups-pools-getPhotos-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/group-contributor-models/group-contributor-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-getTopContributors-fetcher/flickr-groups-getTopContributors-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/group-top-contributors-models/group-top-contributors-models-min.js" +
				"&uy/build/hermes-1.1.452/group-pool-models/group-pool-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-pools-getGroups-fetcher/flickr-groups-pools-getGroups-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-fave-fetcher/flickr-groups-fave-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-unfave-fetcher/flickr-groups-unfave-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-people-getGroupsWithStatus-fetcher/flickr-people-getGroupsWithStatus-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/person-groups-models/person-groups-models-min.js" +
				"&uy/build/hermes-1.1.452/person-curation-models/person-curation-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-getContext-fetcher/flickr-photos-getContext-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-people-getPhotos-fetcher/flickr-people-getPhotos-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/photostream-models/photostream-models-min.js" +
				"&uy/build/hermes-1.1.452/person-model-helper/person-model-helper-min.js" +
				"&uy/build/hermes-1.1.452/person-models/person-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-people-getInfo-fetcher/flickr-people-getInfo-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/person-relationship-models/person-relationship-models-min.js" +
				"&uy/build/hermes-1.1.452/follow-view/follow-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-avatar-editor/hermes-template-fluid-avatar-editor-min.js" +
				"&uy/build/hermes-1.1.452/fluid-avatar-editor-view/fluid-avatar-editor-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-header/hermes-lang-header-min.js";
		String requestHeader0133 = "GET " + requestFile0133 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0133, requestHost0133, requestPort0133, requestHeader0133, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0133 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 12957
		// content test algorithm: check size +/- 5%, defined content size = 12957
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 12957, 5);		// Test [133] <- Index 133
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
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


	/**
	 * Recorded http requests of page #2_3.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2_3(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #2 (fragment 4 of 7)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [134] <- WEB ADMIN Index 134 ---
		String requestProt0134 = "https";
		String requestHost0134 = "c7.staticflickr.com";
		int    requestPort0134 = 443;
		String requestFile0134 = "/4/3868/14542952478_2d9642c32f.jpg";
		String requestHeader0134 = "GET " + requestFile0134 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c7.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0134, requestHost0134, requestPort0134, requestHeader0134, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0134 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 104400
		// content test algorithm: check size +/- 5%, defined content size = 104400
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 104400, 5);		// Test [134] <- Index 134
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [135] <- WEB ADMIN Index 135 ---
		String requestProt0135 = "https";
		String requestHost0135 = "c3.staticflickr.com";
		int    requestPort0135 = 443;
		String requestFile0135 = "/4/3847/14542953138_e11e82bec3.jpg";
		String requestHeader0135 = "GET " + requestFile0135 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c3.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0135, requestHost0135, requestPort0135, requestHeader0135, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0135 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 97432
		// content test algorithm: check size +/- 5%, defined content size = 97432
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 97432, 5);		// Test [135] <- Index 135
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [136] <- WEB ADMIN Index 136 ---
		String requestProt0136 = "https";
		String requestHost0136 = "c7.staticflickr.com";
		int    requestPort0136 = 443;
		String requestFile0136 = "/4/3882/14542967718_9eef21460b.jpg";
		String requestHeader0136 = "GET " + requestFile0136 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c7.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0136, requestHost0136, requestPort0136, requestHeader0136, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0136 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 110095
		// content test algorithm: check size +/- 5%, defined content size = 110095
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 110095, 5);		// Test [136] <- Index 136
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [137] <- WEB ADMIN Index 137 ---
		String requestProt0137 = "https";
		String requestHost0137 = "c3.staticflickr.com";
		int    requestPort0137 = 443;
		String requestFile0137 = "/3/2899/14706596226_65acde969a.jpg";
		String requestHeader0137 = "GET " + requestFile0137 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c3.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0137, requestHost0137, requestPort0137, requestHeader0137, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0137 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 84735
		// content test algorithm: check size +/- 5%, defined content size = 84735
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 84735, 5);		// Test [137] <- Index 137
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [138] <- WEB ADMIN Index 138 ---
		String requestProt0138 = "https";
		String requestHost0138 = "c3.staticflickr.com";
		int    requestPort0138 = 443;
		String requestFile0138 = "/7/6046/buddyicons/37001817@N05.jpg" +
				"?1310058802";
		String requestHeader0138 = "GET " + requestFile0138 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c3.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0138, requestHost0138, requestPort0138, requestHeader0138, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0138 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 20194
		// content test algorithm: check size +/- 5%, defined content size = 20194
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 20194, 5);		// Test [138] <- Index 138
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [139] <- WEB ADMIN Index 139 ---
		String requestProt0139 = "https";
		String requestHost0139 = "geo.yahoo.com";
		int    requestPort0139 = 443;
		String requestFile0139 = "/b" +
				"?s=792600537";
		String requestHeader0139 = "GET " + requestFile0139 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: geo.yahoo.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0139, requestHost0139, requestPort0139, requestHeader0139, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0139 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 43
		// content test algorithm: check size +/- 5%, defined content size = 43
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 43, 5);		// Test [139] <- Index 139
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [140] <- WEB ADMIN Index 140 ---
		String requestProt0140 = "https";
		String requestHost0140 = "c5.staticflickr.com";
		int    requestPort0140 = 443;
		String requestFile0140 = "/4/3868/14727232924_3b6ab67f72_z.jpg";
		String requestHeader0140 = "GET " + requestFile0140 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c5.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0140, requestHost0140, requestPort0140, requestHeader0140, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0140 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 72023
		// content test algorithm: check size +/- 5%, defined content size = 72023
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 72023, 5);		// Test [140] <- Index 140
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [141] <- WEB ADMIN Index 141 ---
		String requestProt0141 = "https";
		String requestHost0141 = "c5.staticflickr.com";
		int    requestPort0141 = 443;
		String requestFile0141 = "/6/5554/14706612036_0cc50bd244.jpg";
		String requestHeader0141 = "GET " + requestFile0141 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c5.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0141, requestHost0141, requestPort0141, requestHeader0141, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0141 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 31745
		// content test algorithm: check size +/- 5%, defined content size = 31745
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 31745, 5);		// Test [141] <- Index 141
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [142] <- WEB ADMIN Index 142 ---
		String requestProt0142 = "https";
		String requestHost0142 = "c5.staticflickr.com";
		int    requestPort0142 = 443;
		String requestFile0142 = "/4/3923/14729320772_bc1892752f.jpg";
		String requestHeader0142 = "GET " + requestFile0142 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c5.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0142, requestHost0142, requestPort0142, requestHeader0142, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0142 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 105527
		// content test algorithm: check size +/- 5%, defined content size = 105527
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 105527, 5);		// Test [142] <- Index 142
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [143] <- WEB ADMIN Index 143 ---
		String requestProt0143 = "https";
		String requestHost0143 = "c5.staticflickr.com";
		int    requestPort0143 = 443;
		String requestFile0143 = "/4/3849/14729326052_434f44a470.jpg";
		String requestHeader0143 = "GET " + requestFile0143 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c5.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0143, requestHost0143, requestPort0143, requestHeader0143, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0143 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 94587
		// content test algorithm: check size +/- 5%, defined content size = 94587
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 94587, 5);		// Test [143] <- Index 143
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [144] <- WEB ADMIN Index 144 ---
		String requestProt0144 = "https";
		String requestHost0144 = "s.yimg.com";
		int    requestPort0144 = 443;
		String requestFile0144 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/hermes-template-fluid-share/hermes-template-fluid-share-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-share-tumblr-post/hermes-template-fluid-share-tumblr-post-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-share-loading-state/hermes-template-fluid-share-loading-state-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-share-panel/hermes-template-fluid-share-panel-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-share-panel-restyle/hermes-template-fluid-share-panel-restyle-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-share-embedr-code/hermes-template-fluid-share-embedr-code-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-share-bb-code/hermes-template-fluid-share-bb-code-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-share-modal-mail-pill/hermes-template-share-modal-mail-pill-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-warning/hermes-template-fluid-warning-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-share-panel-error/hermes-template-fluid-share-panel-error-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-share-old-html-embed-code/hermes-template-fluid-share-old-html-embed-code-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-share-old-iframe-embed-code/hermes-template-fluid-share-old-iframe-embed-code-min.js" +
				"&uy/build/hermes-1.1.452/flickr-contacts-getListfetcher/flickr-contacts-getListfetcher-min.js" +
				"&uy/build/hermes-1.1.452/contact-search-box/contact-search-box-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-photo-page-scrappy/hermes-lang-photo-page-scrappy-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-html5-balls/hermes-template-html5-balls-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-html4-balls/hermes-template-html4-balls-min.js" +
				"&uy/build/hermes-1.1.452/html5-balls/html5-balls-min.js" +
				"&uy/build/hermes-1.1.452/fluid-share-panel-view/fluid-share-panel-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-share-modal/hermes-lang-share-modal-min.js";
		String requestHeader0144 = "GET " + requestFile0144 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0144, requestHost0144, requestPort0144, requestHeader0144, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0144 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 25591
		// content test algorithm: check size +/- 5%, defined content size = 25591
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 25591, 5);		// Test [144] <- Index 144
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [145] <- WEB ADMIN Index 145 ---
		String requestProt0145 = "https";
		String requestHost0145 = "s.yimg.com";
		int    requestPort0145 = 443;
		String requestFile0145 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/fluid-share-view/fluid-share-view-min.js" +
				"&uy/build/hermes-1.1.452/fluid-share-photostream-view/fluid-share-photostream-view-min.js" +
				"&uy/build/hermes-1.1.452/fluid-share-favorites-view/fluid-share-favorites-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-magic-slideshow/hermes-template-fluid-magic-slideshow-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-slideshow/hermes-template-slideshow-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-attribution/hermes-template-attribution-min.js" +
				"&uy/build/hermes-1.1.452/slideshow-attribution-view/slideshow-attribution-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-attribution/hermes-lang-attribution-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-well-media-scrappy/hermes-template-photo-well-media-scrappy-min.js" +
				"&uy/build/hermes-1.1.452/slideshow-well-view/slideshow-well-view-min.js" +
				"&uy/build/hermes-1.1.452/slideshow-view/slideshow-view-min.js" +
				"&uy/build/hermes-1.1.452/fluid-fullscreen/fluid-fullscreen-min.js" +
				"&uy/build/hermes-1.1.452/fluid-magic-slideshow-view/fluid-magic-slideshow-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photostream-filter-tools/hermes-template-photostream-filter-tools-min.js" +
				"&uy/build/hermes-1.1.452/photostream-filter-tools-view/photostream-filter-tools-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fluid-magic-tools/hermes-template-fluid-magic-tools-min.js" +
				"&uy/build/hermes-1.1.452/fluid-magic-tools-view/fluid-magic-tools-view-min.js";
		String requestHeader0145 = "GET " + requestFile0145 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0145, requestHost0145, requestPort0145, requestHeader0145, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0145 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 14584
		// content test algorithm: check size +/- 5%, defined content size = 14584
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 14584, 5);		// Test [145] <- Index 145
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [146] <- WEB ADMIN Index 146 ---
		String requestProt0146 = "https";
		String requestHost0146 = "s.yimg.com";
		int    requestPort0146 = 443;
		String requestFile0146 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/hermes-template-fluid-magic-search/hermes-template-fluid-magic-search-min.js" +
				"&uy/build/hermes-1.1.452/fluid-magic-search-view/fluid-magic-search-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-account-menu/hermes-template-account-menu-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-account-menu-dialog-greetings/hermes-template-account-menu-dialog-greetings-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-account-menu-dialog/hermes-template-account-menu-dialog-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-greetings/hermes-template-greetings-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-account-menu-dialog-styleguide/hermes-template-account-menu-dialog-styleguide-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-account-menu-card/hermes-template-account-menu-card-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-account-menu-card-get-pro-button/hermes-template-account-menu-card-get-pro-button-min.js" +
				"&uy/build/hermes-1.1.452/products-api-helper/products-api-helper-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-discounts-models/flickr-products-discounts-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-order-items-setQuantity-updater/flickr-products-order-items-setQuantity-updater-min.js" +
				"&uy/build/hermes-1.1.452/products-order-item-models/products-order-item-models-min.js" +
				"&uy/build/hermes-1.1.452/products-order-item-price-models/products-order-item-price-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-orders-removeCoupon-deletor/flickr-products-orders-removeCoupon-deletor-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-coupons-models/flickr-products-coupons-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-orders-create-creator/flickr-products-orders-create-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-subscriptions-orders-create-creator/flickr-products-subscriptions-orders-create-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-editPage-updater/flickr-products-books-editPage-updater-min.js";
		String requestHeader0146 = "GET " + requestFile0146 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0146, requestHost0146, requestPort0146, requestHeader0146, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0146 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 9081
		// content test algorithm: check size +/- 5%, defined content size = 9081
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 9081, 5);		// Test [146] <- Index 146
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [147] <- WEB ADMIN Index 147 ---
		String requestProt0147 = "https";
		String requestHost0147 = "s.yimg.com";
		int    requestPort0147 = 443;
		String requestFile0147 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/flickr-products-books-getPage-fetcher/flickr-products-books-getPage-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-setPagePhoto-updater/flickr-products-books-setPagePhoto-updater-min.js" +
				"&uy/build/hermes-1.1.452/book-page-photo-models/book-page-photo-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-addPage-creator/flickr-products-books-addPage-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-removePage-deletor/flickr-products-books-removePage-deletor-min.js" +
				"&uy/build/hermes-1.1.452/page-models/page-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-fetcher/flickr-products-books-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-updateBook-updater/flickr-products-books-updateBook-updater-min.js" +
				"&uy/build/hermes-1.1.452/api-products-books-helper/api-products-books-helper-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-editBook-updater/flickr-products-books-editBook-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-books-creator/flickr-products-books-creator-min.js" +
				"&uy/build/hermes-1.1.452/book-models/book-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-subscriptions-getSubscriptionDetails-fetcher/flickr-products-subscriptions-getSubscriptionDetails-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-shippingType-updater/flickr-products-shippingType-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-orders-getOrder-fetcher/flickr-products-orders-getOrder-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-orders-deletor/flickr-products-orders-deletor-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-orders-models/flickr-products-orders-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-orders-applyCoupon-creator/flickr-products-orders-applyCoupon-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-braintree-createSubscription-creator/flickr-braintree-createSubscription-creator-min.js";
		String requestHeader0147 = "GET " + requestFile0147 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0147, requestHost0147, requestPort0147, requestHeader0147, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0147 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4904
		// content test algorithm: check size +/- 5%, defined content size = 4904
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 4904, 5);		// Test [147] <- Index 147
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [148] <- WEB ADMIN Index 148 ---
		String requestProt0148 = "https";
		String requestHost0148 = "www.flickr.com";
		int    requestPort0148 = 443;
		String requestFile0148 = "/beacon_page_timings.gne" +
				"?AFT_SV=24410" +
				"&AFT=24410" +
				"&timing_pageid=photostream_page_view_inpage" +
				"&is_logged_in=1" +
				"&spaceid=792600537";
		String requestHeader0148 = "GET " + requestFile0148 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0148, requestHost0148, requestPort0148, requestHeader0148, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0148 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 20
		// content test algorithm: check size +/- 5%, defined content size = 20
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, 20, 5);		// Test [148] <- Index 148
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





		// --- HTTP REQUEST: Test [149] <- WEB ADMIN Index 149 ---
		String requestProt0149 = "https";
		String requestHost0149 = "s.yimg.com";
		int    requestPort0149 = 443;
		String requestFile0149 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/hermes-template-photo-list-photo-interaction/hermes-template-photo-list-photo-interaction-min.js" +
				"&uy/build/hermes-1.1.452/photo-list-photo-interaction-view/photo-list-photo-interaction-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-fave-view/hermes-lang-fave-view-min.js";
		String requestHeader0149 = "GET " + requestFile0149 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0149, requestHost0149, requestPort0149, requestHeader0149, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0149 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4748
		// content test algorithm: check size +/- 5%, defined content size = 4748
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 4748, 5);		// Test [149] <- Index 149
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [150] <- WEB ADMIN Index 150 ---
		String requestProt0150 = "https";
		String requestHost0150 = "s.yimg.com";
		int    requestPort0150 = 443;
		String requestFile0150 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/photo-css/photo-css-min.css" +
				"&uy/build/hermes-1.1.452/products-form-css/products-form-css-min.css" +
				"&uy/build/hermes-1.1.452/products-new-payment-form-css/products-new-payment-form-css-min.css" +
				"&uy/build/hermes-1.1.452/curator-tools-css/curator-tools-css-min.css" +
				"&uy/build/hermes-1.1.452/photo-well-scrappy-css/photo-well-scrappy-css-min.css" +
				"&uy/build/hermes-1.1.452/flickr-video-player-css/flickr-video-player-css-min.css" +
				"&uy/build/hermes-1.1.452/vr-css/vr-css-min.css" +
				"&uy/build/hermes-1.1.452/zoom-css/zoom-css-min.css" +
				"&uy/build/hermes-1.1.452/context-slider-scrappy-css/context-slider-scrappy-css-min.css" +
				"&uy/build/hermes-1.1.452/photo-engagement-css/photo-engagement-css-min.css" +
				"&uy/build/hermes-1.1.452/photo-well-css/photo-well-css-min.css" +
				"&uy/build/hermes-1.1.452/photo-attribution-css/photo-attribution-css-min.css" +
				"&uy/build/hermes-1.1.452/photo-sidebar-actions-css/photo-sidebar-actions-css-min.css" +
				"&uy/build/hermes-1.1.452/stats-photo-css/stats-photo-css-min.css" +
				"&uy/build/hermes-1.1.452/pika-day-css/pika-day-css-min.css" +
				"&uy/build/hermes-1.1.452/mobile-photo-page-css/mobile-photo-page-css-min.css" +
				"&uy/build/hermes-1.1.452/sub-photo-css/sub-photo-css-min.css" +
				"&uy/build/hermes-1.1.452/sub-photo-left-css/sub-photo-left-css-min.css" +
				"&uy/build/hermes-1.1.452/editing-shim-css/editing-shim-css-min.css" +
				"&uy/build/hermes-1.1.452/sub-photo-title-desc-css/sub-photo-title-desc-css-min.css" +
				"&uy/build/hermes-1.1.452/photo-license-css/photo-license-css-min.css" +
				"&uy/build/hermes-1.1.452/confirmation-dialog-css/confirmation-dialog-css-min.css" +
				"&uy/build/hermes-1.1.452/sub-photo-comments-css/sub-photo-comments-css-min.css" +
				"&uy/build/hermes-1.1.452/sub-photo-right-css/sub-photo-right-css-min.css" +
				"&uy/build/hermes-1.1.452/photo-charm-exif-scrappy-view-css/photo-charm-exif-scrappy-view-css-min.css" +
				"&uy/build/hermes-1.1.452/sub-photo-contexts-css/sub-photo-contexts-css-min.css" +
				"&uy/build/hermes-1.1.452/album-selection-css/album-selection-css-min.css";
		String requestHeader0150 = "GET " + requestFile0150 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0150, requestHost0150, requestPort0150, requestHeader0150, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0150 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 43333
		// content test algorithm: check size +/- 5%, defined content size = 43333
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 43333, 5);		// Test [150] <- Index 150
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [151] <- WEB ADMIN Index 151 ---
		String requestProt0151 = "https";
		String requestHost0151 = "s.yimg.com";
		int    requestPort0151 = 443;
		String requestFile0151 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/validation-error-css/validation-error-css-min.css" +
				"&uy/build/hermes-1.1.452/scrappy-date-modify-css/scrappy-date-modify-css-min.css" +
				"&uy/build/hermes-1.1.452/sub-photo-additional-info-view-css/sub-photo-additional-info-view-css-min.css" +
				"&uy/build/hermes-1.1.452/sub-photo-keyboard-shortcuts-css/sub-photo-keyboard-shortcuts-css-min.css" +
				"&uy/build/hermes-1.1.452/signup-footer-css/signup-footer-css-min.css";
		String requestHeader0151 = "GET " + requestFile0151 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0151, requestHost0151, requestPort0151, requestHeader0151, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0151 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2732
		// content test algorithm: check size +/- 5%, defined content size = 2732
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, 2732, 5);		// Test [151] <- Index 151
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [152] <- WEB ADMIN Index 152 ---
		String requestProt0152 = "https";
		String requestHost0152 = "sb.scorecardresearch.com";
		int    requestPort0152 = 443;
		String requestFile0152 = "/p" +
				"?c1=2" +
				"&c2=7241469" +
				"&c3=" +
				"&c4=www.flickr.com%252Fphotos%252F2854187992%252F" +
				"&c5=792600537" +
				"&c6=" +
				"&c15=" +
				"&ns__t=1461135922391" +
				"&ns_c=UTF-8";
		String requestHeader0152 = "GET " + requestFile0152 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: sb.scorecardresearch.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0152, requestHost0152, requestPort0152, requestHeader0152, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0152 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 43
		// content test algorithm: check size +/- 5%, defined content size = 43
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 43, 5);		// Test [152] <- Index 152
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [153] <- WEB ADMIN Index 153 ---
		String requestProt0153 = "https";
		String requestHost0153 = "geo.query.yahoo.com";
		int    requestPort0153 = 443;
		String requestFile0153 = "/v1/public/yql" +
				"?yhlVer=2" +
				"&yhlClient=rapid" +
				"&yhlS=792600537" +
				"&yhlCT=2" +
				"&yhlBTMS=1461135922406" +
				"&yhlClientVer=3.35" +
				"&yhlRnd=OSszVnWQY7JeIpBr" +
				"&yhlCompressed=0";
		String requestContent0153 = 
				"q=select%20*%20from%20x%20where%20a%20%3D%20'%7B%22bp%22%3A%7B%22_pl%22%3A%221%22%2C%22A_v%22%3A%223.35%22%2C%22_R%22%3A%22https%3A%2F%2Fwww.flickr.com%2F%22%2C%22_bt%22%3A%22rapid%22%2C%22A_pr%22%3A%22https%22%2C%22A_tzoff%22%3A%222%22%7D%2C%22r%22%3A%5B%7B%22t%22%3A%22pv%22%2C%22s%22%3A%22792600537%22%2C%22pp%22%3A%7B%22A_sid%22%3A%22WEGSD5rH1cKy3CoE%22%2C%22_w%22%3A%22www.flickr.com%2Fphotos%2Famirashfaq%2F%22%2C%22pageType%22%3A%22photostream-page-view%22%2C%22intl%22%3A%22en-US%22%2C%22bx%22%3A%22bv3heppbheaa9%26b%3D3%26s%3Dfv%22%2C%22buckets%22%3A%22celeb_search%3Aceleb_search%2Cshare_modal_restyle%3Aenabled%2Cphotoscore_rank_in_search%3Aenable_photoscore_rank%2Cbuy_button_tests%3Acontrol%2Cphoto_list_buy_button_tests%3Acontrol%22%2C%22isStaff%22%3A0%2C%22renderer%22%3A%22s%22%2C%22loggedIn%22%3A%221%22%2C%22slice%22%3A%2217%22%2C%22groupUsr%22%3A0%2C%22density%22%3A%221%22%2C%22dimensns%22%3A%221260x627%22%2C%22isPro%22%3A0%2C%22isbot%22%3Afalse%2C%22isunsptd%22%3Afalse%2C%22vwrOwner%22%3A%221%22%2C%22joindate%22%3A%222009-04-02%22%2C%22A_%22%3A%221%22%7D%2C%22_ts%22%3A%221461135922%22%2C%22_ms%22%3A%22398%22%2C%22lv%22%3A%5B%7B%22m%22%3A%22content%22%2C%22l%22%3A%5B%7B%22_p%22%3A1%2C%22slk%22%3A%22gnLogoClick%22%7D%2C%7B%22_p%22%3A2%2C%22slk%22%3A%22gnYouMainClick%22%7D%2C%7B%22_p%22%3A3%2C%22slk%22%3A%22gnYouCameraRollClick%22%7D%2C%7B%22_p%22%3A4%2C%22slk%22%3A%22gnYouPhotostreamClick%22%7D%2C%7B%22_p%22%3A5%2C%22slk%22%3A%22gnYouSetsClick%22%7D%2C%7B%22_p%22%3A6%2C%22slk%22%3A%22gnYouFavoritesClick%22%7D%2C%7B%22_p%22%3A7%2C%22slk%22%3A%22gnYouGroupsClick%22%7D%2C%7B%22_p%22%3A8%2C%22slk%22%3A%22gnYouGalleriesClick%22%7D%2C%7B%22_p%22%3A9%2C%22slk%22%3A%22gnYouCreationsClick%22%7D%2C%7B%22_p%22%3A10%2C%22slk%22%3A%22gnYouPeopleClick%22%7D%2C%7B%22_p%22%3A11%2C%22slk%22%3A%22gnYouRecentActivityClick%22%7D%2C%7B%22_p%22%3A12%2C%22slk%22%3A%22gnYouStatsClick%22%7D%2C%7B%22_p%22%3A13%2C%22slk%22%3A%22gnYouOrganizeClick%22%7D%2C%7B%22_p%22%3A14%2C%22slk%22%3A%22gnExploreMainClick%22%7D%2C%7B%22_p%22%3A15%2C%22slk%22%3A%22gnExploreRecentPhotosClick%22%7D%2C%7B%22_p%22%3A16%2C%22slk%22%3A%22gnExploreTagsClick%22%7D%2C%7B%22_p%22%3A17%2C%22slk%22%3A%22gnExploreVRLandingClick%22%7D%2C%7B%22_p%22%3A18%2C%22slk%22%3A%22gnExploreTheCommonsClick%22%7D%2C%7B%22_p%22%3A19%2C%22slk%22%3A%22gnExploreGalleriesClick%22%7D%2C%7B%22_p%22%3A20%2C%22slk%22%3A%22gnExploreWorldMapClick%22%7D%2C%7B%22_p%22%3A21%2C%22slk%22%3A%22gnExploreAppGardenClick%22%7D%2C%7B%22_p%22%3A22%2C%22slk%22%3A%22gnExploreCameraFinderClick%22%7D%2C%7B%22_p%22%3A23%2C%22slk%22%3A%22gnExploreWeeklyFlickrClick%22%7D%2C%7B%22_p%22%3A24%2C%22slk%22%3A%22gnExploreFlickrBlogClick%22%7D%2C%7B%22_p%22%3A25%2C%22slk%22%3A%22gnCreateMainClick%22%7D%2C%7B%22_p%22%3A26%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A27%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A28%2C%22slk%22%3A%22gnUploadIconMain%22%7D%2C%7B%22_p%22%3A29%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A30%2C%22slk%22%3A%22gnYouCameraRollClick%22%7D%2C%7B%22_p%22%3A31%2C%22slk%22%3A%22gnYouPhotostreamClick%22%7D%2C%7B%22_p%22%3A32%2C%22slk%22%3A%22gnYouSetsClick%22%7D%2C%7B%22_p%22%3A33%2C%22slk%22%3A%22gnYouFavoritesClick%22%7D%2C%7B%22_p%22%3A34%2C%22slk%22%3A%22gnYouGalleriesClick%22%7D%2C%7B%22_p%22%3A35%2C%22slk%22%3A%22gnYouRecentActivityClick%22%7D%2C%7B%22_p%22%3A36%2C%22slk%22%3A%22gnYouGroupsClick%22%7D%2C%7B%22_p%22%3A37%2C%22slk%22%3A%22gnYouStatsClick%22%7D%2C%7B%22_p%22%3A38%2C%22slk%22%3A%22gnExploreMainClick%22%7D%2C%7B%22_p%22%3A39%2C%22slk%22%3A%22gnExploreRecentPhotosClick%22%7D%2C%7B%22_p%22%3A40%2C%22slk%22%3A%22gnExploreTagsClick%22%7D%2C%7B%22_p%22%3A41%2C%22slk%22%3A%22gnExploreTheCommonsClick%22%7D%2C%7B%22_p%22%3A42%2C%22slk%22%3A%22gnExploreGalleriesClick%22%7D%2C%7B%22_p%22%3A43%2C%22slk%22%3A%22gnExploreWeeklyFlickrClick%22%7D%2C%7B%22_p%22%3A44%2C%22slk%22%3A%22gnExploreFlickrBlogClick%22%7D%2C%7B%22_p%22%3A45%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A46%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A47%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A48%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A49%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A50%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A51%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A52%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A53%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A54%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A55%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A56%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A57%2C%22slk%22%3A%22addContextPhotostream%22%7D%2C%7B%22_p%22%3A58%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A59%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A60%2C%22slk%22%3A%22pagination1Click%22%7D%2C%7B%22_p%22%3A61%2C%22slk%22%3A%22pagination2Click%22%7D%2C%7B%22_p%22%3A62%2C%22slk%22%3A%22pagination3Click%22%7D%2C%7B%22_p%22%3A63%2C%22slk%22%3A%22pagination4Click%22%7D%2C%7B%22_p%22%3A64%2C%22slk%22%3A%22pagination5Click%22%7D%2C%7B%22_p%22%3A65%2C%22slk%22%3A%22paginationRightClick%22%7D%2C%7B%22_p%22%3A66%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A67%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A68%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A69%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A70%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A71%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A72%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A73%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A74%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A75%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A76%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A77%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A78%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A79%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A80%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A81%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A82%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A83%2C%22slk%22%3A%22_%22%7D%2C%7B%22_p%22%3A84%2C%22slk%22%3A%22_%22%7D%5D%2C%22ylk%22%3A%7B%7D%7D%5D%7D%5D%2C%22yrid%22%3A%22%22%2C%22optout%22%3A%220%22%2C%22nol%22%3A%220%22%7D'";
		byte[] requestContentBinary0153 = requestContent0153.getBytes("UTF-8");
		String requestHeader0153 = "POST " + requestFile0153 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: geo.query.yahoo.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n" + 
				"Content-Length: " + requestContentBinary0153.length + "\r\n" + 		// Content-Length: 5877
				"origin: https://www.flickr.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0153, requestHost0153, requestPort0153, requestHeader0153, requestContentBinary0153, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
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
		requestHeader0153 = null;		// support garbage collector to reduce memory
		requestContent0153 = null;		// support garbage collector to reduce memory
		requestContentBinary0153 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 300
		// content test algorithm: check size +/- 5%, defined content size = 300
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, 300, 5);		// Test [153] <- Index 153
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



		// all http requests of page #2_3 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #2_4.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2_4(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #2 (fragment 5 of 7)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [154] <- WEB ADMIN Index 154 ---
		String requestProt0154 = "https";
		String requestHost0154 = "lh.secure.yahoo.com";
		int    requestPort0154 = 443;
		String requestFile0154 = "/lhbeam-0.11" +
				"?_uuid=" +
				"&_sid=792600537" +
				"&_sip=flickr.v1.production.manhattan.bf1.yahoo.com" +
				"&_pod=" +
				"&_crumb=AXAXYBGH123" +
				"&_pvid=111111" +
				"&u=https%3A%2F%2Fwww.flickr.com%2Fphotos%2Famirashfaq%2F" +
				"&c=root,0|t:b|t:l|r:AFT_SV,mark,24410,0;|r:AFT,mark,24410,0;";
		String requestHeader0154 = "GET " + requestFile0154 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: lh.secure.yahoo.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0154, requestHost0154, requestPort0154, requestHeader0154, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0154 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 204, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: check size +/- 5%, defined content size = 0
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {204}, "TEXT/PLAIN", null, 0, 5);		// Test [154] <- Index 154
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





		// --- HTTP REQUEST: Test [155] <- WEB ADMIN Index 155 ---
		String requestProt0155 = "https";
		String requestHost0155 = "s.yimg.com";
		int    requestPort0155 = 443;
		String requestFile0155 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/hermes-template-photo-page-scrappy/hermes-template-photo-page-scrappy-min.js" +
				"&yui:3.16.0/plugin/plugin-min.js" +
				"&uy/build/hermes-1.1.452/ttfp-recorder-plugin/ttfp-recorder-plugin-min.js" +
				"&uy/build/hermes-1.1.452/curation-photomappings-model/curation-photomappings-model-min.js" +
				"&uy/build/hermes-1.1.452/flickr-licensing-curation-photomappings-fetcher/flickr-licensing-curation-photomappings-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-curator-tool-photo-metadata-form/hermes-template-curator-tool-photo-metadata-form-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-curator-control-panel/hermes-template-curator-control-panel-min.js" +
				"&uy/build/hermes-1.1.452/curator-photo-tools-view/curator-photo-tools-view-min.js" +
				"&yui:3.16.0/yui-throttle/yui-throttle-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-well-scrappy/hermes-template-photo-well-scrappy-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-page-right-size-express/hermes-template-photo-page-right-size-express-min.js" +
				"&uy/build/hermes-1.1.452/flickr-video-player/flickr-video-player-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-vr-overlay/hermes-template-vr-overlay-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-removeTag-deletor/flickr-photos-removeTag-deletor-min.js" +
				"&uy/build/hermes-1.1.452/tag-models/tag-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-tags-getListPhoto-fetcher/flickr-tags-getListPhoto-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/photo-tags-models/photo-tags-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-addTags-creator/flickr-photos-addTags-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-favorites-getContext-fetcher/flickr-favorites-getContext-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-favorites-getList-fetcher/flickr-favorites-getList-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/favorite-models/favorite-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-galleries-getPhotos-fetcher/flickr-galleries-getPhotos-fetcher-min.js";
		String requestHeader0155 = "GET " + requestFile0155 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0155, requestHost0155, requestPort0155, requestHeader0155, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0155 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 12765
		// content test algorithm: check size +/- 5%, defined content size = 12765
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 12765, 5);		// Test [155] <- Index 155
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [156] <- WEB ADMIN Index 156 ---
		String requestProt0156 = "https";
		String requestHost0156 = "s.yimg.com";
		int    requestPort0156 = 443;
		String requestFile0156 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/flickr-galleries-getContext-fetcher/flickr-galleries-getContext-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/photo-galleries-models/photo-galleries-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-galleries-addPhoto-creator/flickr-galleries-addPhoto-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-galleries-removePhoto-deletor/flickr-galleries-removePhoto-deletor-min.js" +
				"&uy/build/hermes-1.1.452/flickr-galleries-getList-fetcher/flickr-galleries-getList-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/person-galleries-models/person-galleries-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-galleries-create-creator/flickr-galleries-create-creator-min.js" +
				"&uy/build/hermes-1.1.452/gallery-models/gallery-models-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-shared-entity/hermes-lang-shared-entity-min.js" +
				"&uy/build/hermes-1.1.452/photo-sets-models/photo-sets-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photosets-addPhoto-creator/flickr-photosets-addPhoto-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photosets-getList-fetcher/flickr-photosets-getList-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/sets-models/sets-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photosets-removePhoto-deletor/flickr-photosets-removePhoto-deletor-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photosets-delete-deletor/flickr-photosets-delete-deletor-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photosets-getPhotos-fetcher/flickr-photosets-getPhotos-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photosets-getContext-fetcher/flickr-photosets-getContext-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photosets-create-creator/flickr-photosets-create-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photosets-createHidden-creator/flickr-photosets-createHidden-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photosets-editMeta-updater/flickr-photosets-editMeta-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photosets-setPrimaryPhoto-updater/flickr-photosets-setPrimaryPhoto-updater-min.js";
		String requestHeader0156 = "GET " + requestFile0156 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0156, requestHost0156, requestPort0156, requestHeader0156, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0156 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5797
		// content test algorithm: check size +/- 5%, defined content size = 5797
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 5797, 5);		// Test [156] <- Index 156
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [157] <- WEB ADMIN Index 157 ---
		String requestProt0157 = "https";
		String requestHost0157 = "s.yimg.com";
		int    requestPort0157 = 443;
		String requestFile0157 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/set-models/set-models-min.js" +
				"&uy/build/hermes-1.1.452/photo-groups-models/photo-groups-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-getAllContexts-fetcher/flickr-photos-getAllContexts-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/photo-contexts-models/photo-contexts-models-min.js" +
				"&uy/build/hermes-1.1.452/vr-overlay-view/vr-overlay-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-zoom/hermes-template-zoom-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-zoom-modal/hermes-template-zoom-modal-min.js" +
				"&uy/build/hermes-1.1.452/zoom-view/zoom-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-well-ad/hermes-template-photo-well-ad-min.js" +
				"&uy/build/hermes-1.1.452/photo-well-media-scrappy-view/photo-well-media-scrappy-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-context-slider-photo/hermes-template-context-slider-photo-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-context-slider-scrappy/hermes-template-context-slider-scrappy-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-context-image/hermes-template-context-image-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-context-text/hermes-template-context-text-min.js" +
				"&uy/build/hermes-1.1.452/context-slider-scrappy-view/context-slider-scrappy-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-engagement/hermes-template-photo-engagement-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-download-dialog/hermes-template-download-dialog-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-scrappy-download-menu/hermes-template-scrappy-download-menu-min.js" +
				"&uy/build/hermes-1.1.452/wallart-helper/wallart-helper-min.js" +
				"&uy/build/hermes-1.1.452/fluid-share-photo-view/fluid-share-photo-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-default/hermes-lang-default-min.js" +
				"&uy/build/hermes-1.1.452/basic-book-models/basic-book-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-creations-fetcher/flickr-creations-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/creations-models/creations-models-min.js";
		String requestHeader0157 = "GET " + requestFile0157 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0157, requestHost0157, requestPort0157, requestHeader0157, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0157 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 22254
		// content test algorithm: check size +/- 5%, defined content size = 22254
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 22254, 5);		// Test [157] <- Index 157
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [158] <- WEB ADMIN Index 158 ---
		String requestProt0158 = "https";
		String requestHost0158 = "s.yimg.com";
		int    requestPort0158 = 443;
		String requestFile0158 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/flickr-products-wallart-create-creator/flickr-products-wallart-create-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-wallart-editWallart-updater/flickr-products-wallart-editWallart-updater-min.js" +
				"&uy/build/hermes-1.1.452/wallart-models/wallart-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-products-wallart-fetcher/flickr-products-wallart-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/photo-engagement-view/photo-engagement-view-min.js" +
				"&uy/build/hermes-1.1.452/seo/seo-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-empty-photo-page/hermes-template-empty-photo-page-min.js" +
				"&uy/build/hermes-1.1.452/empty-photo-page-view/empty-photo-page-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-page-lightbox/hermes-template-photo-page-lightbox-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-well/hermes-template-photo-well-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-reboot-welcome-dialog-content/hermes-template-reboot-welcome-dialog-content-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-opt-out/hermes-template-photo-opt-out-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-well-media/hermes-template-photo-well-media-min.js" +
				"&uy/build/hermes-1.1.452/photo-well-media-view/photo-well-media-view-min.js" +
				"&uy/build/hermes-1.1.452/photo-head-meta-view/photo-head-meta-view-min.js" +
				"&uy/build/hermes-1.1.452/photo-page-lightbox-scrappy-view/photo-page-lightbox-scrappy-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-mobile-photo-page/hermes-template-mobile-photo-page-min.js" +
				"&uy/build/hermes-1.1.452/attribution-view/attribution-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-mobile-photo-well/hermes-template-mobile-photo-well-min.js" +
				"&uy/build/hermes-1.1.452/matrix-math/matrix-math-min.js" +
				"&uy/build/hermes-1.1.452/mrpinchy/mrpinchy-min.js" +
				"&uy/build/hermes-1.1.452/mobile-photo-well-view/mobile-photo-well-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-mobile-photo-engagement/hermes-template-mobile-photo-engagement-min.js";
		String requestHeader0158 = "GET " + requestFile0158 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0158, requestHost0158, requestPort0158, requestHeader0158, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0158 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 16877
		// content test algorithm: check size +/- 5%, defined content size = 16877
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 16877, 5);		// Test [158] <- Index 158
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [159] <- WEB ADMIN Index 159 ---
		String requestProt0159 = "https";
		String requestHost0159 = "s.yimg.com";
		int    requestPort0159 = 443;
		String requestFile0159 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/hermes-template-mobile-share-modal/hermes-template-mobile-share-modal-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-stats-photo/hermes-template-stats-photo-min.js" +
				"&uy/build/hermes-1.1.452/timezone-helper/timezone-helper-min.js" +
				"&uy/build/hermes-1.1.452/stats-helper/stats-helper-min.js" +
				"&uy/build/hermes-1.1.452/flickr-stats-photo-daily-views-fetcher/flickr-stats-photo-daily-views-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/stats-photo-daily-views-models/stats-photo-daily-views-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-stats-referrer-domains-fetcher/flickr-stats-referrer-domains-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/stats-referrer-domains-models/stats-referrer-domains-models-min.js" +
				"&uy/build/hermes-1.1.452/stats-photo-view/stats-photo-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-stats/hermes-lang-stats-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-pika-day/hermes-lang-pika-day-min.js" +
				"&uy/build/hermes-1.1.452/mobile-photo-engagement-view/mobile-photo-engagement-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-settings/hermes-lang-settings-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-info-charm/hermes-lang-info-charm-min.js" +
				"&uy/build/hermes-1.1.452/mobile-photo-page-view/mobile-photo-page-view-min.js" +
				"&uy/build/hermes-1.1.452/fastclick/fastclick-min.js" +
				"&uy/build/hermes-1.1.452/photo-well-scrappy-view/photo-well-scrappy-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo/hermes-template-sub-photo-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-left/hermes-template-sub-photo-left-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-title-desc/hermes-template-sub-photo-title-desc-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-editing-shim/hermes-template-editing-shim-min.js" +
				"&uy/build/hermes-1.1.452/sub-photo-title-desc-view/sub-photo-title-desc-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-license/hermes-template-photo-license-min.js" +
				"&uy/build/hermes-1.1.452/photo-license-view/photo-license-view-min.js";
		String requestHeader0159 = "GET " + requestFile0159 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0159, requestHost0159, requestPort0159, requestHeader0159, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0159 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 28680
		// content test algorithm: check size +/- 5%, defined content size = 28680
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 28680, 5);		// Test [159] <- Index 159
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [160] <- WEB ADMIN Index 160 ---
		String requestProt0160 = "https";
		String requestHost0160 = "s.yimg.com";
		int    requestPort0160 = 443;
		String requestFile0160 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/hermes-template-confirmation-dialog/hermes-template-confirmation-dialog-min.js" +
				"&uy/build/hermes-1.1.452/confirmation-dialog-view/confirmation-dialog-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-comment/hermes-template-comment-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-comments/hermes-template-comments-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-comment/hermes-template-sub-photo-comment-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-comments/hermes-template-sub-photo-comments-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-comment-form/hermes-template-sub-photo-comment-form-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-comments-view/hermes-template-sub-photo-comments-view-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-comments-addComment-creator/flickr-photos-comments-addComment-creator-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-comments-editComment-updater/flickr-photos-comments-editComment-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-comments-deleteComment-deletor/flickr-photos-comments-deleteComment-deletor-min.js" +
				"&uy/build/hermes-1.1.452/comment-models/comment-models-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-comments-getList-fetcher/flickr-photos-comments-getList-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/photo-comments-models/photo-comments-models-min.js" +
				"&uy/build/hermes-1.1.452/sub-photo-comments-view/sub-photo-comments-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-comments/hermes-lang-comments-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-faved-by/hermes-template-sub-photo-faved-by-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-person/hermes-template-person-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-fave-menu/hermes-template-fave-menu-min.js" +
				"&uy/build/hermes-1.1.452/flickr-photos-getFavorites-fetcher/flickr-photos-getFavorites-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/photo-people-who-faved-models/photo-people-who-faved-models-min.js";
		String requestHeader0160 = "GET " + requestFile0160 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0160, requestHost0160, requestPort0160, requestHeader0160, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0160 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 11745
		// content test algorithm: check size +/- 5%, defined content size = 11745
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 11745, 5);		// Test [160] <- Index 160
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [161] <- WEB ADMIN Index 161 ---
		String requestProt0161 = "https";
		String requestHost0161 = "s.yimg.com";
		int    requestPort0161 = 443;
		String requestFile0161 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/flickr-photos-getGroupInvitations-fetcher/flickr-photos-getGroupInvitations-fetcher-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-invite-photo-accept-updater/flickr-groups-invite-photo-accept-updater-min.js" +
				"&uy/build/hermes-1.1.452/flickr-groups-invite-photo-decline-updater/flickr-groups-invite-photo-decline-updater-min.js" +
				"&uy/build/hermes-1.1.452/photo-group-invitations-models/photo-group-invitations-models-min.js" +
				"&uy/build/hermes-1.1.452/sub-photo-groups-view/sub-photo-groups-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-more-menu-view/hermes-lang-more-menu-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-contexts-title-albums/hermes-template-sub-photo-contexts-title-albums-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-contexts-albums/hermes-template-sub-photo-contexts-albums-min.js" +
				"&uy/build/hermes-1.1.452/set-selection-dialog-view/set-selection-dialog-view-min.js" +
				"&uy/build/hermes-1.1.452/sub-photo-albums-view/sub-photo-albums-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-contexts-title-galleries/hermes-template-sub-photo-contexts-title-galleries-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-contexts-galleries/hermes-template-sub-photo-contexts-galleries-min.js" +
				"&uy/build/hermes-1.1.452/gallery-selection-dialog-view/gallery-selection-dialog-view-min.js" +
				"&uy/build/hermes-1.1.452/sub-photo-galleries-view/sub-photo-galleries-view-min.js" +
				"&uy/build/hermes-1.1.452/sub-photo-contexts-view/sub-photo-contexts-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-date-view/hermes-template-sub-photo-date-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-date-modify/hermes-template-date-modify-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-date-dropdown/hermes-template-date-dropdown-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-validation-error/hermes-template-validation-error-min.js";
		String requestHeader0161 = "GET " + requestFile0161 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0161, requestHost0161, requestPort0161, requestHeader0161, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0161 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 11345
		// content test algorithm: check size +/- 5%, defined content size = 11345
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 11345, 5);		// Test [161] <- Index 161
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [162] <- WEB ADMIN Index 162 ---
		String requestProt0162 = "https";
		String requestHost0162 = "s.yimg.com";
		int    requestPort0162 = 443;
		String requestFile0162 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/sub-photo-fave-view/sub-photo-fave-view-min.js" +
				"&uy/build/hermes-1.1.452/sub-photo-left-view/sub-photo-left-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-right/hermes-template-sub-photo-right-min.js" +
				"&uy/build/hermes-1.1.452/exif-camera-map/exif-camera-map-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-photo-charm-exif-scrappy/hermes-template-photo-charm-exif-scrappy-min.js" +
				"&uy/build/hermes-1.1.452/photo-charm-exif-scrappy-view/photo-charm-exif-scrappy-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-right-stats/hermes-template-sub-photo-right-stats-min.js" +
				"&uy/build/hermes-1.1.452/sub-photo-right-stats-view/sub-photo-right-stats-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-contexts/hermes-template-sub-photo-contexts-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-contexts-item/hermes-template-sub-photo-contexts-item-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-contexts-title-groups/hermes-template-sub-photo-contexts-title-groups-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-contexts-groups/hermes-template-sub-photo-contexts-groups-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-album-selection/hermes-template-album-selection-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-album-creation/hermes-template-album-creation-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-album-selection-list-item-stats/hermes-template-album-selection-list-item-stats-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-album-selection-list-item/hermes-template-album-selection-list-item-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-album-selection-list/hermes-template-album-selection-list-min.js" +
				"&uy/build/hermes-1.1.452/album-selection-dialog-view/album-selection-dialog-view-min.js" +
				"&uy/build/hermes-1.1.452/group-selection-dialog-view/group-selection-dialog-view-min.js" +
				"&uy/build/hermes-1.1.452/photo-group-invitation-models/photo-group-invitation-models-min.js";
		String requestHeader0162 = "GET " + requestFile0162 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0162, requestHost0162, requestPort0162, requestHeader0162, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0162 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 19344
		// content test algorithm: check size +/- 5%, defined content size = 19344
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 19344, 5);		// Test [162] <- Index 162
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [163] <- WEB ADMIN Index 163 ---
		String requestProt0163 = "https";
		String requestHost0163 = "s.yimg.com";
		int    requestPort0163 = 443;
		String requestFile0163 = "/zz/combo" +
				"?uy/build/hermes-1.1.452/scrappy-date-modify-dialog-view/scrappy-date-modify-dialog-view-min.js" +
				"&uy/build/hermes-1.1.452/sub-photo-date-view/sub-photo-date-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-additional-info/hermes-template-sub-photo-additional-info-min.js" +
				"&uy/build/hermes-1.1.452/privacy-helper/privacy-helper-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-flag-photo-dialog-content/hermes-template-flag-photo-dialog-content-min.js" +
				"&uy/build/hermes-1.1.452/sub-photo-additional-info-view/sub-photo-additional-info-view-min.js" +
				"&uy/build/hermes-1.1.452/sub-photo-right-view/sub-photo-right-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-sub-photo-keyboard-shortcuts/hermes-template-sub-photo-keyboard-shortcuts-min.js" +
				"&uy/build/hermes-1.1.452/sub-photo-keyboard-shortcuts-view/sub-photo-keyboard-shortcuts-view-min.js" +
				"&uy/build/hermes-1.1.452/sub-photo-view/sub-photo-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-template-signup-footer/hermes-template-signup-footer-min.js" +
				"&uy/build/hermes-1.1.452/signup-footer-view/signup-footer-view-min.js" +
				"&uy/build/hermes-1.1.452/hermes-lang-sohp/hermes-lang-sohp-min.js" +
				"&uy/build/hermes-1.1.452/photo-page-scrappy-view/photo-page-scrappy-view-min.js" +
				"&uy/build/hermes-1.1.452/photo-route/photo-route-min.js" +
				"&uy/build/hermes-1.1.452/photo-well-view/photo-well-view-min.js";
		String requestHeader0163 = "GET " + requestFile0163 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: s.yimg.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0163, requestHost0163, requestPort0163, requestHeader0163, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0163 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 19638
		// content test algorithm: check size +/- 5%, defined content size = 19638
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 19638, 5);		// Test [163] <- Index 163
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [164] <- WEB ADMIN Index 164 ---
		String requestProt0164 = "https";
		String requestHost0164 = "api.flickr.com";
		int    requestPort0164 = 443;
		String requestFile0164 = "/services/rest" +
				"?extras=can_addmeta%2Ccan_comment%2Ccan_download%2Ccan_share%2Ccontact%2Ccount_comments%2Ccount_faves%2Ccount_views%2Cdate_taken%2Cdate_upload%2Cdescription%2Cicon_urls_deep%2Cisfavorite%2Cispro%2Clicense%2Cmedia%2Cneeds_interstitial%2Cowner_name%2Cowner_datecreate%2Cpath_alias%2Crealname%2Crotation%2Csafety_level%2Csecret_k%2Csecret_h%2Curl_c%2Curl_f%2Curl_h%2Curl_k%2Curl_l%2Curl_m%2Curl_n%2Curl_o%2Curl_q%2Curl_s%2Curl_sq%2Curl_t%2Curl_z%2Cvisibility%2Cvisibility_source%2Co_dims%2Cis_marketplace_printable%2Cis_marketplace_licensable%2Cpubliceditability" +
				"&context_id=37001817%40N05" +
				"&context_type=user" +
				"&viewerNSID=37001817%40N05" +
				"&method=flickr.autosuggest.getContextResults" +
				"&csrf=1461164706%3Akhtwpftsovzehfr%3A452149a343a2079289ee49642668d3c1" +
				"&api_key=f5dfe6a3d0e27250877ed624b6b2048e" +
				"&format=json" +
				"&hermes=1" +
				"&hermesClient=1" +
				"&reqId=23d165d3" +
				"&nojsoncallback=1";
		String requestHeader0164 = "GET " + requestFile0164 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0164, requestHost0164, requestPort0164, requestHeader0164, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0164 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 6882
		// content test algorithm: check size +/- 5%, defined content size = 6882
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 6882, 5);		// Test [164] <- Index 164
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





		// --- HTTP REQUEST: Test [165] <- WEB ADMIN Index 165 ---
		String requestProt0165 = "https";
		String requestHost0165 = "geo.yahoo.com";
		int    requestPort0165 = 443;
		String requestFile0165 = "/p" +
				"?s=792600537" +
				"&t=lfIj2JLidoaowvmh,0.2681929821791812" +
				"&_I=" +
				"&_AO=0" +
				"&_NOL=0" +
				"&_R=https%3A%2F%2Fwww.flickr.com%2F" +
				"&_P=3.35%05_pl%031%04A_v%033.35%04_bt%03rapid%04A_pr%03https%04A_tzoff%032%04A_sid%03WEGSD5rH1cKy3CoE%04_w%03www.flickr.com%2Fphotos%2Famirashfaq%2F%04pageType%03photostream-page-view%04intl%03en-US%04bx%03bv3heppbheaa9%26b%3D3%26s%3Dfv%04buckets%03celeb_search%3Aceleb_search%2Cshare_modal_restyle%3Aenabled%2Cphotoscore_rank_in_search%3Aenable_photoscore_rank%2Cbuy_button_tests%3Acontrol%2Cphoto_list_buy_button_tests%3Acontrol%04isStaff%030%04renderer%03s%04loggedIn%031%04slice%0317%04groupUsr%030%04density%031%04dimensns%031260x627%04isPro%030%04isbot%03false%04isunsptd%03false%04vwrOwner%031%04joindate%032009-04-02%04_ts%031461135922%04_ms%03398%04A_pfb%038285%04A_pbp%031201%04A_psr%031196%04A_pol%0325599%04A_pdi%039872%04A_pdl%030%04A_psc%030%04A_pfe%0316112%04etrg%03backgroundPost%04outcm%03performance%04usergenf%030%04etag%03performance%04_E%03pageperf";
		String requestHeader0165 = "GET " + requestFile0165 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: geo.yahoo.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0165, requestHost0165, requestPort0165, requestHeader0165, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0165 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 43
		// content test algorithm: check size +/- 5%, defined content size = 43
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 43, 5);		// Test [165] <- Index 165
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [166] <- WEB ADMIN Index 166 ---
		String requestProt0166 = "https";
		String requestHost0166 = "www.flickr.com";
		int    requestPort0166 = 443;
		String requestFile0166 = "/photos/amirashfaq/page2/";
		String requestHeader0166 = "GET " + requestFile0166 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Moz: prefetch\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0166, requestHost0166, requestPort0166, requestHeader0166, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0166 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 50666
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Amir Ashfaq | Flickr - Photo Sharing!");		// Test [166] <- Index 166
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





		// --- HTTP REQUEST: Test [167] <- WEB ADMIN Index 167 ---
		String requestProt0167 = "https";
		String requestHost0167 = "lh.secure.yahoo.com";
		int    requestPort0167 = 443;
		String requestFile0167 = "/lhbeam-0.11" +
				"?_uuid=" +
				"&_sid=792600537" +
				"&_sip=flickr.v1.production.manhattan.bf1.yahoo.com" +
				"&_pod=" +
				"&_crumb=AXAXYBGH123" +
				"&_pvid=111111" +
				"&u=https%3A%2F%2Fwww.flickr.com%2Fphotos%2Famirashfaq%2F" +
				"&n=t:b,reboot|t:l|navT|navS,1461135897511|fetS|dluS|dluE|conS,1|conE,1|reqS,8291|resS,8286|resE,9487|domL,9492|domI,9872|domS,9877|domE,9878|domC,25598|lodS,25599|lodE,25608" +
				"&c=root,0|t:b|t:l";
		String requestHeader0167 = "GET " + requestFile0167 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: lh.secure.yahoo.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0167, requestHost0167, requestPort0167, requestHeader0167, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0167 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 204, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: check size +/- 5%, defined content size = 0
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {204}, "TEXT/PLAIN", null, 0, 5);		// Test [167] <- Index 167
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





		// --- HTTP REQUEST: Test [168] <- WEB ADMIN Index 168 ---
		String requestProt0168 = "https";
		String requestHost0168 = "www.flickr.com";
		int    requestPort0168 = 443;
		String requestFile0168 = "/beacon_page_timings.gne" +
				"?timing_pageid=photostream_page_view_coldstart" +
				"&page_start=1461135905797" +
				"&page_generation=262" +
				"&js_done=1461135922408" +
				"&AFT=" +
				"&window_load=1461135923119" +
				"&dom_ready=1461135907383" +
				"&is_logged_in=1";
		String requestHeader0168 = "GET " + requestFile0168 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0168, requestHost0168, requestPort0168, requestHeader0168, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0168 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 20
		// content test algorithm: check size +/- 5%, defined content size = 20
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, 20, 5);		// Test [168] <- Index 168
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





		// --- HTTP REQUEST: Test [169] <- WEB ADMIN Index 169 ---
		String requestProt0169 = "https";
		String requestHost0169 = "www.flickr.com";
		int    requestPort0169 = 443;
		String requestFile0169 = "/beacon_client_api_timings.gne" +
				"?d=flickr.autosuggest.getContextResults%3B983";
		String requestHeader0169 = "GET " + requestFile0169 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0169, requestHost0169, requestPort0169, requestHeader0169, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0169 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 20
		// content test algorithm: check size +/- 5%, defined content size = 20
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, 20, 5);		// Test [169] <- Index 169
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





		// --- HTTP REQUEST: Test [170] <- WEB ADMIN Index 170 ---
		String requestProt0170 = "https";
		String requestHost0170 = "i1-j1-18-23-1-18573-3825965692-s.init.cedexis-radar.net";
		int    requestPort0170 = 443;
		String requestFile0170 = "/i1/1461135928/3825965692/xml" +
				"?seed=i1-j1-18-23-1-18573-3825965692-s";
		String requestHeader0170 = "GET " + requestFile0170 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: i1-j1-18-23-1-18573-3825965692-s.init.cedexis-radar.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0170, requestHost0170, requestPort0170, requestHeader0170, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0170 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/XML", header text fragment = [verification disabled], recorded content size = 300
		// content test algorithm: check size +/- 5%, defined content size = 300
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/XML", null, 300, 5);		// Test [170] <- Index 170
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





		// --- HTTP REQUEST: Test [171] <- WEB ADMIN Index 171 ---
		String requestProt0171 = "https";
		String requestHost0171 = "radar.cedexis.com";
		int    requestPort0171 = 443;
		String requestFile0171 = "/1/18573/radar/1461097084/grRo6T0YfZboA2KsnQ8s/providers.json" +
				"?imagesok=1" +
				"&r=1" +
				"&t=1" +
				"&p=1" +
				"&n=1" +
				"&l=0" +
				"&b=2" +
				"&a=1";
		String requestHeader0171 = "GET " + requestFile0171 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: radar.cedexis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0171, requestHost0171, requestPort0171, requestHeader0171, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0171 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 179
		// content test algorithm: check size +/- 5%, defined content size = 179
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 179, 5);		// Test [171] <- Index 171
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





		// --- HTTP REQUEST: Test [172] <- WEB ADMIN Index 172 ---
		String requestProt0172 = "https";
		String requestHost0172 = "p1.staticflickr.com";
		int    requestPort0172 = 443;
		String requestFile0172 = "/1/281/19065759046_417b057a03_o.gif" +
				"?rnd=1-1-18573-1-18573-31145-3825965692-_CgJqMRASGBciBggBEI2RASj8tK6gDjC41Ny4BTi51Ny4BUDCq98rShEIAxC7ARjrkAMgACjOj4CgBFAAWgoIABAAGAAgACgAYAFqE2J1dHRvbjEubGhyLmh2LnByb2Q";
		String requestHeader0172 = "GET " + requestFile0172 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: p1.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0172, requestHost0172, requestPort0172, requestHeader0172, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0172 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 43
		// content test algorithm: check size +/- 5%, defined content size = 43
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 43, 5);		// Test [172] <- Index 172
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [173] <- WEB ADMIN Index 173 ---
		String requestProt0173 = "https";
		String requestHost0173 = "rpt.cedexis.com";
		int    requestPort0173 = 443;
		String requestFile0173 = "/f1/_CgJqMRASGBciBggBEI2RASj8tK6gDjC41Ny4BTi51Ny4BUDCq98rShEIAxC7ARjrkAMgACjOj4CgBFAAWgoIABAAGAAgACgAYAFqE2J1dHRvbjEubGhyLmh2LnByb2Q/1/18573/31145/1/0/198/0/0";
		String requestHeader0173 = "GET " + requestFile0173 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: rpt.cedexis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0173, requestHost0173, requestPort0173, requestHeader0173, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0173 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 16
		// content test algorithm: check size +/- 5%, defined content size = 16
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 16, 5);		// Test [173] <- Index 173
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated



		// all http requests of page #2_4 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #2_5.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2_5(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #2 (fragment 6 of 7)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [174] <- WEB ADMIN Index 174 ---
		String requestProt0174 = "https";
		String requestHost0174 = "p1.staticflickr.com";
		int    requestPort0174 = 443;
		String requestFile0174 = "/1/281/19065759046_417b057a03_o.gif" +
				"?rnd=0-1-18573-1-18573-31145-3825965692-_CgJqMRASGBciBggBEI2RASj8tK6gDjC41Ny4BTi51Ny4BUDCq98rShEIAxC7ARjrkAMgACjOj4CgBFAAWgoIABAAGAAgACgAYAFqE2J1dHRvbjEubGhyLmh2LnByb2Q";
		String requestHeader0174 = "GET " + requestFile0174 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: p1.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0174, requestHost0174, requestPort0174, requestHeader0174, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0174 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 43
		// content test algorithm: check size +/- 5%, defined content size = 43
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 43, 5);		// Test [174] <- Index 174
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [175] <- WEB ADMIN Index 175 ---
		String requestProt0175 = "https";
		String requestHost0175 = "p1.staticflickr.com";
		int    requestPort0175 = 443;
		String requestFile0175 = "/1/555/19086257152_e1fe42996a_o.png" +
				"?rnd=14-1-18573-1-18573-31145-3825965692-_CgJqMRASGBciBggBEI2RASj8tK6gDjC41Ny4BTi51Ny4BUDCq98rShEIAxC7ARjrkAMgACjOj4CgBFAAWgoIABAAGAAgACgAYAFqE2J1dHRvbjEubGhyLmh2LnByb2Q";
		String requestHeader0175 = "GET " + requestFile0175 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: p1.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0175, requestHost0175, requestPort0175, requestHeader0175, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0175 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 102400
		// content test algorithm: check size +/- 5%, defined content size = 102400
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, 102400, 5);		// Test [175] <- Index 175
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [176] <- WEB ADMIN Index 176 ---
		String requestProt0176 = "https";
		String requestHost0176 = "rpt.cedexis.com";
		int    requestPort0176 = 443;
		String requestFile0176 = "/f1/_CgJqMRASGBciBggBEI2RASj8tK6gDjC41Ny4BTi51Ny4BUDCq98rShEIAxC7ARjrkAMgACjOj4CgBFAAWgoIABAAGAAgACgAYAFqE2J1dHRvbjEubGhyLmh2LnByb2Q/1/18573/31145/0/0/69/0/0";
		String requestHeader0176 = "GET " + requestFile0176 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: rpt.cedexis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0176, requestHost0176, requestPort0176, requestHeader0176, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0176 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 16
		// content test algorithm: check size +/- 5%, defined content size = 16
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 16, 5);		// Test [176] <- Index 176
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [177] <- WEB ADMIN Index 177 ---
		String requestProt0177 = "https";
		String requestHost0177 = "rpt.cedexis.com";
		int    requestPort0177 = 443;
		String requestFile0177 = "/f1/_CgJqMRASGBciBggBEI2RASj8tK6gDjC41Ny4BTi51Ny4BUDCq98rShEIAxC7ARjrkAMgACjOj4CgBFAAWgoIABAAGAAgACgAYAFqE2J1dHRvbjEubGhyLmh2LnByb2Q/1/18573/31145/14/0/0/0/0";
		String requestHeader0177 = "GET " + requestFile0177 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: rpt.cedexis.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0177, requestHost0177, requestPort0177, requestHeader0177, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0177 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 16
		// content test algorithm: check size +/- 5%, defined content size = 16
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, 16, 5);		// Test [177] <- Index 177
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [178] <- WEB ADMIN Index 178 ---
		String requestProt0178 = "https";
		String requestHost0178 = "api.flickr.com";
		int    requestPort0178 = 443;
		String requestFile0178 = "/services/rest" +
				"?per_page=25" +
				"&page=2" +
				"&extras=can_addmeta%2Ccan_comment%2Ccan_download%2Ccan_share%2Ccontact%2Ccount_comments%2Ccount_faves%2Ccount_views%2Cdate_taken%2Cdate_upload%2Cdescription%2Cicon_urls_deep%2Cisfavorite%2Cispro%2Clicense%2Cmedia%2Cneeds_interstitial%2Cowner_name%2Cowner_datecreate%2Cpath_alias%2Crealname%2Crotation%2Csafety_level%2Csecret_k%2Csecret_h%2Curl_c%2Curl_f%2Curl_h%2Curl_k%2Curl_l%2Curl_m%2Curl_n%2Curl_o%2Curl_q%2Curl_s%2Curl_sq%2Curl_t%2Curl_z%2Cvisibility%2Cvisibility_source%2Co_dims%2Cis_marketplace_printable%2Cis_marketplace_licensable%2Cpubliceditability" +
				"&get_user_info=1" +
				"&jump_to=" +
				"&user_id=37001817%40N05" +
				"&view_as=use_pref" +
				"&sort=use_pref" +
				"&viewerNSID=37001817%40N05" +
				"&method=flickr.people.getPhotos" +
				"&csrf=1461164706%3Akhtwpftsovzehfr%3A452149a343a2079289ee49642668d3c1" +
				"&api_key=f5dfe6a3d0e27250877ed624b6b2048e" +
				"&format=json" +
				"&hermes=1" +
				"&hermesClient=1" +
				"&reqId=23d165d3" +
				"&nojsoncallback=1";
		String requestHeader0178 = "GET " + requestFile0178 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: api.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"origin: https://www.flickr.com\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0178, requestHost0178, requestPort0178, requestHeader0178, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0178 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 6401
		// content test algorithm: check size +/- 5%, defined content size = 6401
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, 6401, 5);		// Test [178] <- Index 178
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





		// --- HTTP REQUEST: Test [179] <- WEB ADMIN Index 179 ---
		String requestProt0179 = "https";
		String requestHost0179 = "geo.yahoo.com";
		int    requestPort0179 = 443;
		String requestFile0179 = "/b" +
				"?s=792600537" +
				"&t=rtdi8lnwQtIMaGRV,0.08192652095765618" +
				"&_I=" +
				"&_AO=0" +
				"&_NOL=0" +
				"&_R=https%3A%2F%2Fwww.flickr.com%2F" +
				"&_P=3.35%05_pl%031%04A_v%033.35%04_bt%03rapid%04A_pr%03https%04A_tzoff%032%04A_sid%03WEGSD5rH1cKy3CoE%04_w%03www.flickr.com%2Fphotos%2Famirashfaq%2F%04pageType%03photostream-page-view%04intl%03en-US%04bx%03bv3heppbheaa9%26b%3D3%26s%3Dfv%04buckets%03celeb_search%3Aceleb_search%2Cshare_modal_restyle%3Aenabled%2Cphotoscore_rank_in_search%3Aenable_photoscore_rank%2Cbuy_button_tests%3Acontrol%2Cphoto_list_buy_button_tests%3Acontrol%04isStaff%030%04renderer%03s%04loggedIn%031%04slice%0317%04groupUsr%030%04density%031%04dimensns%031260x627%04isPro%030%04isbot%03false%04isunsptd%03false%04vwrOwner%031%04joindate%032009-04-02%04_ts%031461135950%04_ms%03491%04A_apv%031%04A_apx%031100%04A_asd%030";
		String requestHeader0179 = "GET " + requestFile0179 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: geo.yahoo.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0179, requestHost0179, requestPort0179, requestHeader0179, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0179 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 43
		// content test algorithm: check size +/- 5%, defined content size = 43
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, 43, 5);		// Test [179] <- Index 179
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [180] <- WEB ADMIN Index 180 ---
		String requestProt0180 = "https";
		String requestHost0180 = "c4.staticflickr.com";
		int    requestPort0180 = 443;
		String requestFile0180 = "/3/2917/14542956059_f5a6a58d0b.jpg";
		String requestHeader0180 = "GET " + requestFile0180 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c4.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0180, requestHost0180, requestPort0180, requestHeader0180, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0180 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 84889
		// content test algorithm: check size +/- 5%, defined content size = 84889
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 84889, 5);		// Test [180] <- Index 180
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [181] <- WEB ADMIN Index 181 ---
		String requestProt0181 = "https";
		String requestHost0181 = "c8.staticflickr.com";
		int    requestPort0181 = 443;
		String requestFile0181 = "/4/3870/14726412751_b673928abf.jpg";
		String requestHeader0181 = "GET " + requestFile0181 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c8.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0181, requestHost0181, requestPort0181, requestHeader0181, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0181 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 95451
		// content test algorithm: check size +/- 5%, defined content size = 95451
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 95451, 5);		// Test [181] <- Index 181
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [182] <- WEB ADMIN Index 182 ---
		String requestProt0182 = "https";
		String requestHost0182 = "c2.staticflickr.com";
		int    requestPort0182 = 443;
		String requestFile0182 = "/6/5559/14542954129_d4835c4c86.jpg";
		String requestHeader0182 = "GET " + requestFile0182 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0182, requestHost0182, requestPort0182, requestHeader0182, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0182 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 69259
		// content test algorithm: check size +/- 5%, defined content size = 69259
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 69259, 5);		// Test [182] <- Index 182
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [183] <- WEB ADMIN Index 183 ---
		String requestProt0183 = "https";
		String requestHost0183 = "c2.staticflickr.com";
		int    requestPort0183 = 443;
		String requestFile0183 = "/3/2897/14542953009_4ca88c007f.jpg";
		String requestHeader0183 = "GET " + requestFile0183 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0183, requestHost0183, requestPort0183, requestHeader0183, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0183 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 69065
		// content test algorithm: check size +/- 5%, defined content size = 69065
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 69065, 5);		// Test [183] <- Index 183
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [184] <- WEB ADMIN Index 184 ---
		String requestProt0184 = "https";
		String requestHost0184 = "c3.staticflickr.com";
		int    requestPort0184 = 443;
		String requestFile0184 = "/4/3879/14706590666_281c949f41_z.jpg";
		String requestHeader0184 = "GET " + requestFile0184 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c3.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0184, requestHost0184, requestPort0184, requestHeader0184, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0184 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 31482
		// content test algorithm: check size +/- 5%, defined content size = 31482
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 31482, 5);		// Test [184] <- Index 184
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [185] <- WEB ADMIN Index 185 ---
		String requestProt0185 = "https";
		String requestHost0185 = "c4.staticflickr.com";
		int    requestPort0185 = 443;
		String requestFile0185 = "/4/3838/14543142027_cb410084ce.jpg";
		String requestHeader0185 = "GET " + requestFile0185 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c4.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0185, requestHost0185, requestPort0185, requestHeader0185, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0185 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 58617
		// content test algorithm: check size +/- 5%, defined content size = 58617
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 58617, 5);		// Test [185] <- Index 185
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [186] <- WEB ADMIN Index 186 ---
		String requestProt0186 = "https";
		String requestHost0186 = "c8.staticflickr.com";
		int    requestPort0186 = 443;
		String requestFile0186 = "/6/5589/14726409111_bbd1d8ba6e_c.jpg";
		String requestHeader0186 = "GET " + requestFile0186 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c8.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0186, requestHost0186, requestPort0186, requestHeader0186, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0186 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 35323
		// content test algorithm: check size +/- 5%, defined content size = 35323
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 35323, 5);		// Test [186] <- Index 186
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [187] <- WEB ADMIN Index 187 ---
		String requestProt0187 = "https";
		String requestHost0187 = "c4.staticflickr.com";
		int    requestPort0187 = 443;
		String requestFile0187 = "/8/7293/8740047819_ee56c39d81.jpg";
		String requestHeader0187 = "GET " + requestFile0187 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c4.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0187, requestHost0187, requestPort0187, requestHeader0187, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0187 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 198976
		// content test algorithm: check size +/- 5%, defined content size = 198976
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 198976, 5);		// Test [187] <- Index 187
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [188] <- WEB ADMIN Index 188 ---
		String requestProt0188 = "https";
		String requestHost0188 = "c4.staticflickr.com";
		int    requestPort0188 = 443;
		String requestFile0188 = "/8/7289/8740046531_e078f0267c.jpg";
		String requestHeader0188 = "GET " + requestFile0188 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c4.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0188, requestHost0188, requestPort0188, requestHeader0188, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0188 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 87432
		// content test algorithm: check size +/- 5%, defined content size = 87432
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 87432, 5);		// Test [188] <- Index 188
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [189] <- WEB ADMIN Index 189 ---
		String requestProt0189 = "https";
		String requestHost0189 = "c3.staticflickr.com";
		int    requestPort0189 = 443;
		String requestFile0189 = "/8/7294/8741163746_cf2e025ab2.jpg";
		String requestHeader0189 = "GET " + requestFile0189 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c3.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0189, requestHost0189, requestPort0189, requestHeader0189, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0189 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 92617
		// content test algorithm: check size +/- 5%, defined content size = 92617
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 92617, 5);		// Test [189] <- Index 189
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [190] <- WEB ADMIN Index 190 ---
		String requestProt0190 = "https";
		String requestHost0190 = "c6.staticflickr.com";
		int    requestPort0190 = 443;
		String requestFile0190 = "/8/7286/8740047061_0dc077a96d_z.jpg";
		String requestHeader0190 = "GET " + requestFile0190 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c6.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0190, requestHost0190, requestPort0190, requestHeader0190, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0190 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 58120
		// content test algorithm: check size +/- 5%, defined content size = 58120
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 58120, 5);		// Test [190] <- Index 190
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [191] <- WEB ADMIN Index 191 ---
		String requestProt0191 = "https";
		String requestHost0191 = "c7.staticflickr.com";
		int    requestPort0191 = 443;
		String requestFile0191 = "/8/7285/8741163078_41ba1c6a89.jpg";
		String requestHeader0191 = "GET " + requestFile0191 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c7.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0191, requestHost0191, requestPort0191, requestHeader0191, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0191 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 132897
		// content test algorithm: check size +/- 5%, defined content size = 132897
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 132897, 5);		// Test [191] <- Index 191
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [192] <- WEB ADMIN Index 192 ---
		String requestProt0192 = "https";
		String requestHost0192 = "c5.staticflickr.com";
		int    requestPort0192 = 443;
		String requestFile0192 = "/8/7281/8741162396_aa406ec1e4.jpg";
		String requestHeader0192 = "GET " + requestFile0192 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c5.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0192, requestHost0192, requestPort0192, requestHeader0192, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0192 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 164137
		// content test algorithm: check size +/- 5%, defined content size = 164137
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 164137, 5);		// Test [192] <- Index 192
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [193] <- WEB ADMIN Index 193 ---
		String requestProt0193 = "https";
		String requestHost0193 = "safebrowsing.google.com";
		int    requestPort0193 = 443;
		String requestFile0193 = "/safebrowsing/gethash" +
				"?client=navclient-auto-ffox" +
				"&appver=45.0.2" +
				"&pver=2.2";
		byte[] requestContentBinary0193 = Lib.base64ToByteArray("NDoxNgqNWKXqbE2l6itQpeqfYqXq");
		String requestContent0193 = new String(requestContentBinary0193);		// normally unused - old code for compatibility and for unexpected XML var assigners for this binary content
		String requestHeader0193 = "POST " + requestFile0193 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: safebrowsing.google.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Content-Length: " + requestContentBinary0193.length + "\r\n" + 		// Content-Length: 21
				"Content-Type: text/plain\r\n" + 
				"Pragma: no-cache\r\n" + 
				"Cache-Control: no-cache\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0193, requestHost0193, requestPort0193, requestHeader0193, requestContentBinary0193, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
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
		requestHeader0193 = null;		// support garbage collector to reduce memory
		requestContent0193 = null;		// support garbage collector to reduce memory
		requestContentBinary0193 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/OCTET-STREAM", header text fragment = [verification disabled], recorded content size = 369
		// content test algorithm: check size +/- 5%, defined content size = 369
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/OCTET-STREAM", null, 369, 5);		// Test [193] <- Index 193
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



		// all http requests of page #2_5 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #2_6.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2_6(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #2 (fragment 7 of 7)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [194] <- WEB ADMIN Index 194 ---
		String requestProt0194 = "https";
		String requestHost0194 = "c1.staticflickr.com";
		int    requestPort0194 = 443;
		String requestFile0194 = "/8/7286/8741162064_09a2b49027.jpg";
		String requestHeader0194 = "GET " + requestFile0194 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c1.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0194, requestHost0194, requestPort0194, requestHeader0194, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0194 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 107545
		// content test algorithm: check size +/- 5%, defined content size = 107545
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 107545, 5);		// Test [194] <- Index 194
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [195] <- WEB ADMIN Index 195 ---
		String requestProt0195 = "https";
		String requestHost0195 = "www.flickr.com";
		int    requestPort0195 = 443;
		String requestFile0195 = "/beacon_client_api_timings.gne" +
				"?d=flickr.people.getPhotos%3B1127";
		String requestHeader0195 = "GET " + requestFile0195 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: www.flickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0195, requestHost0195, requestPort0195, requestHeader0195, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0195 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 20
		// content test algorithm: check size +/- 5%, defined content size = 20
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, 20, 5);		// Test [195] <- Index 195
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





		// --- HTTP REQUEST: Test [196] <- WEB ADMIN Index 196 ---
		String requestProt0196 = "https";
		String requestHost0196 = "c3.staticflickr.com";
		int    requestPort0196 = 443;
		String requestFile0196 = "/8/7288/8741161698_1ba533573c.jpg";
		String requestHeader0196 = "GET " + requestFile0196 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c3.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0196, requestHost0196, requestPort0196, requestHeader0196, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0196 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 139705
		// content test algorithm: check size +/- 5%, defined content size = 139705
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 139705, 5);		// Test [196] <- Index 196
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [197] <- WEB ADMIN Index 197 ---
		String requestProt0197 = "https";
		String requestHost0197 = "c7.staticflickr.com";
		int    requestPort0197 = 443;
		String requestFile0197 = "/8/7283/8741160950_776110d7a7.jpg";
		String requestHeader0197 = "GET " + requestFile0197 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c7.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0197, requestHost0197, requestPort0197, requestHeader0197, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0197 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 114689
		// content test algorithm: check size +/- 5%, defined content size = 114689
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 114689, 5);		// Test [197] <- Index 197
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [198] <- WEB ADMIN Index 198 ---
		String requestProt0198 = "https";
		String requestHost0198 = "c5.staticflickr.com";
		int    requestPort0198 = 443;
		String requestFile0198 = "/8/7294/8741160636_c4b7ddd0be.jpg";
		String requestHeader0198 = "GET " + requestFile0198 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c5.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0198, requestHost0198, requestPort0198, requestHeader0198, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0198 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 117669
		// content test algorithm: check size +/- 5%, defined content size = 117669
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 117669, 5);		// Test [198] <- Index 198
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [199] <- WEB ADMIN Index 199 ---
		String requestProt0199 = "https";
		String requestHost0199 = "c1.staticflickr.com";
		int    requestPort0199 = 443;
		String requestFile0199 = "/8/7282/8741161400_0fbe9aef4d.jpg";
		String requestHeader0199 = "GET " + requestFile0199 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c1.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0199, requestHost0199, requestPort0199, requestHeader0199, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0199 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 108850
		// content test algorithm: check size +/- 5%, defined content size = 108850
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 108850, 5);		// Test [199] <- Index 199
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [200] <- WEB ADMIN Index 200 ---
		String requestProt0200 = "https";
		String requestHost0200 = "c1.staticflickr.com";
		int    requestPort0200 = 443;
		String requestFile0200 = "/8/7285/8741161152_ef0a1ea49c.jpg";
		String requestHeader0200 = "GET " + requestFile0200 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c1.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0200, requestHost0200, requestPort0200, requestHeader0200, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0200 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 72312
		// content test algorithm: check size +/- 5%, defined content size = 72312
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 72312, 5);		// Test [200] <- Index 200
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [201] <- WEB ADMIN Index 201 ---
		String requestProt0201 = "https";
		String requestHost0201 = "c8.staticflickr.com";
		int    requestPort0201 = 443;
		String requestFile0201 = "/8/7286/8740044159_231be986af.jpg";
		String requestHeader0201 = "GET " + requestFile0201 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c8.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0201, requestHost0201, requestPort0201, requestHeader0201, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0201 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 113474
		// content test algorithm: check size +/- 5%, defined content size = 113474
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 113474, 5);		// Test [201] <- Index 201
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [202] <- WEB ADMIN Index 202 ---
		String requestProt0202 = "https";
		String requestHost0202 = "c6.staticflickr.com";
		int    requestPort0202 = 443;
		String requestFile0202 = "/8/7281/8740043885_51ab2660de.jpg";
		String requestHeader0202 = "GET " + requestFile0202 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c6.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0202, requestHost0202, requestPort0202, requestHeader0202, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0202 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 110026
		// content test algorithm: check size +/- 5%, defined content size = 110026
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 110026, 5);		// Test [202] <- Index 202
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [203] <- WEB ADMIN Index 203 ---
		String requestProt0203 = "https";
		String requestHost0203 = "c2.staticflickr.com";
		int    requestPort0203 = 443;
		String requestFile0203 = "/8/7286/8740043689_70afdfc78f.jpg";
		String requestHeader0203 = "GET " + requestFile0203 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c2.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0203, requestHost0203, requestPort0203, requestHeader0203, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0203 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 168799
		// content test algorithm: check size +/- 5%, defined content size = 168799
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 168799, 5);		// Test [203] <- Index 203
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [204] <- WEB ADMIN Index 204 ---
		String requestProt0204 = "https";
		String requestHost0204 = "c1.staticflickr.com";
		int    requestPort0204 = 443;
		String requestFile0204 = "/8/7281/8741159208_a05bb9f72b.jpg";
		String requestHeader0204 = "GET " + requestFile0204 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c1.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0204, requestHost0204, requestPort0204, requestHeader0204, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0204 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 196297
		// content test algorithm: check size +/- 5%, defined content size = 196297
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 196297, 5);		// Test [204] <- Index 204
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [205] <- WEB ADMIN Index 205 ---
		String requestProt0205 = "https";
		String requestHost0205 = "c1.staticflickr.com";
		int    requestPort0205 = 443;
		String requestFile0205 = "/8/7284/8741158784_4bcc9b03b1_z.jpg";
		String requestHeader0205 = "GET " + requestFile0205 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c1.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0205, requestHost0205, requestPort0205, requestHeader0205, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0205 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 86097
		// content test algorithm: check size +/- 5%, defined content size = 86097
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 86097, 5);		// Test [205] <- Index 205
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated





		// --- HTTP REQUEST: Test [206] <- WEB ADMIN Index 206 ---
		String requestProt0206 = "https";
		String requestHost0206 = "c1.staticflickr.com";
		int    requestPort0206 = 443;
		String requestFile0206 = "/8/7285/8741158608_e0267eb6da.jpg";
		String requestHeader0206 = "GET " + requestFile0206 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: c1.staticflickr.com\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/png,image/*;q=0.8,*/*;q=0.5\r\n" + 
				"Accept-Language: en-GB,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0206, requestHost0206, requestPort0206, requestHeader0206, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		testURL.execute(performanceData);
		requestHeader0206 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/JPEG", header text fragment = [verification disabled], recorded content size = 133115
		// content test algorithm: check size +/- 5%, defined content size = 133115
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/JPEG", null, 133115, 5);		// Test [206] <- Index 206
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated



		// all http requests of page #2_6 successful done
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
		
		String genericFileName = PerformanceData.proposeFileName("testSkipLogin", concurrentUsers);
		
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
		final int MAX_THREAD_STEPS = 205;  // number of URL requests in execute() - modify this value if you add or delete some requests
		performanceData = new PerformanceData(PAGE_BREAKS, MAX_THREAD_STEPS, concurrentUsers, -1, plannedTestDuration, maxPlannedLoops, httpProtocolVersion, plannedStartupDelay, plannedRequestTimeout, samplingInterval, percentilePageSampling, percentileUrlSampling, percentileUrlSamplingAddOption);
		performanceData.setInfoText("testSkipLogin");
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
				
				testSkipLogin simulatedUser = new testSkipLogin(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
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
				
				testSkipLogin simulatedUser = new testSkipLogin(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
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

