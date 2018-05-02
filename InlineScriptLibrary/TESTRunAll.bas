// --- Presettings Start ---
// Inline Script Title: complete
// Execution Scope: Inside Loop, before Item
// Input Var List: 
// Output Var List: 
// Execution Priority: 3
// Execution Timeout: -1
// --- Presettings End ---

//just verify
a="asd"
q = "\""
print q
print q+a


// but reported by Carl Ericsson on 23 november

a = 20
b = 20


IF a < b THEN
print "a is less tyhen b"
ELSE IF a <= b THEN           //this is true

 IF true  THEN
    print "1bb"
    ELSE
    print "1cc"
    ENDIF

ELSE IF a <= b THEN

IF true  THEN
    print "2bb"
    ELSE
    print "2cc"
    ENDIF

ELSE IF a <= b THEN
print "a and b <=3"
ELSE IF a <= b THEN
print "a and b <=4"
ELSE IF a <= b THEN
print "a and b <=5"
ELSE IF a == b THEN
print "a == b"
ELSE 
print "not ok...if you see this."
ENDIF


EnvChooser="staging"
IF strCompareIgnoreCase(EnvChooser,"staging") THEN
print "1Here at staging"
ELSE IF strCompareIgnoreCase(EnvChooser,"production") THEN
print "1Here at production"
ELSE
print "1Here at else"
ENDIF

IF strCompareIgnoreCase(EnvChooser,"production") THEN
print "2Here at staging"
ELSE IF strCompareIgnoreCase(EnvChooser,"staging") THEN
print "2Here at production"
ELSE
print "2Here at else"
ENDIF



IF strCompareIgnoreCase(EnvChooser,"xxx") THEN
print "3Here at staging"
ELSE IF strCompareIgnoreCase(EnvChooser,"yyy") THEN
print "3Here at production"
ELSE
print "3Here at else"
ENDIF



print "=======PRX 102==========="
outer = -1 
doo() 
print outer 

function doo() 
outer = 14
global outer = outer + global outer
return 

print "=======PRX 103==========="
print "then keyword is must now... "


print "=======PRX 104/105==========="


a = strToLower("Sweden")
print a
a = strToUpper("Sweden")
print a


print "=======PRX 106==========="

str = "lalalalalala"
print  strSplit( str , "a" ) // its working now.. not printing SplitFunPartsDone, but the contents of array [item1,item2...itemn]
k  =  strSplit( str , "a" )
//print k

for x = 1 to arrLen(k)
print x+" "+ k(x)
next x


print "=======PRX 107==========="
 

a = strSubString("1234567890","4","6")
print a
a = strSubString("1234567890","4")
print a


print "=======PRX 108==========="
 

a = strTrim(" xddf   ")
print a




print "=======PRX-109==========="

print abs(-10)


print "=======PRX-110==========="

fileName = "content-" + generateGUID() + ".txt"
print fileName
content ="sss"   // getHTTPResponseContent()
print content

//writeToFile(fileName,content) // test on windows..


print "========================"

isUrlCallPassed()

//print getHTTPResponseCode() // changed to only code..without protocol


//abort("String")
print abs(30.45)// Returns the absolute value of argument.

print base64Decode("String")  //Convert Base 64 Text to Normal Text.
print base64Encode("String")  //Convert Normal Text to Base 64 Text.
print displayCookieList() //With this method list of all collected cookies will be written.
//doGC()  //Runs the garbage collector.

print generateGUID()  //Method that returns Globally Unique Identifier on each execution
print generateGUID("xxxx-xx-xxxxxx-xx-x--x-x-xxxxxxx-x-x--xxxxxx")  //Method that returns Globally Unique Identifier in the format specified on each execution
print generateMD5("String") //Method to generate 128-bit (16-byte) hash value using MD5 message-digest algorithm.
print generateSHA1("String")  //Method to generate 160-bit (20-byte) hash value using Secure Hash Algorithm - 1.
print getCPUUsage() //This method will get percentage of load on the CPU of the target machine.
print getFreePhysicalMemory() //Returns the amount of free physical memory.
print getFreeVMMemory() //Returns the amount of free memory in the Java virtual machine
//print getHTTPRequestContent() //This method is used to get the contents of the HTTP Request.
//print getHTTPRequestContentType() //This method is used to get the type of HTTP Request Content.
//print getHTTPRequestHeaderField(fieldName) // This method is used to get the value of HTTP Request Header Field.
//print getHTTPRequestTargetHost()  //Returns the hostname of the (target) web server.
//print getHTTPRequestTargetPath()  //Returns the request path inclusive all CGI parameters, extracted from the first HTTP header line.
//print getHTTPRequestTargetPort()  //Returns the TCP/IP port number of the (target) web server.
//print getHTTPRequestURL() //Returns a copy (clone) of the unparsed request-url.
//print getHTTPResponseCode() //This method is used to get HTTP Response Code.
//print getHTTPResponseContent() // This method is used to get the contents of the HTTP Response.
//print getHTTPResponseContentType() // This method is used to get the type of HTTP Response Content.
//print getHTTPResponseHeaderField(headerFieldName) //This method is used to get the value of HTTP Response Header Field.
print getLoopNumber()// Get the actual loop number of the simulated user,-1 if no such data is available
print getThreadStep() //Get index of an URL call, within a loop or -1
print getTotalPhysicalMemory() // Returns the total amount of physical memory.
print getTotalVMMemory() // Returns the total amount of memory in the Java virtual machine
print getUsedPhysicalMemory() //Returns the amount of used physical memory.
print getUsedVMMemory() //Returns the amount of used memory in the Java virtual machine
print getUserNumber() //Get the actual number of the simulated user,-1 if no such data is available
//print htmlDecode(String)  //Convert HTML-encoded Text to HTML Text.
//print htmlEncode(String)  //Convert HTML Text to HTML-encoded Text.
print isUrlCallPassed() //Its a flag that marks if the URL call has passed or failed.
 
print "==========user defined fun==========="

//copyfile("usernames.txt", "out.txt")


 //function copyfile(in, out)
//data = readFileToArray(in)
// outfile = out
// for i=1 to arrLen(data) step 1
// writeToFile(outfile, i +""+data(i))
 //next i
//return

print "==========StrSubString==========="

a = strSubString("1234567890","4","8")
print a


print "==========StrSubString==========="

a = strSubString("1234567890","4")
print a

print "==========StrSplit================"

k  =  strSplit("004-034556-e54t-67677-121212-89089000003366","-")

for x = 1 to arrLen(k)
print k(x)
next x

print "========StrReplace==============="


a  =  strReplace("sweden","e","E")
print a


print "========strReplaceRegEx==============="


a  =  strReplaceRegEx("004-034556-e54t-67677-121212-89089000003366","\\d","*")
print a




print "============StrMatchRegEx=========="



a  =  strMatchRegEx("sweden","[a-z]+")
print a
a =  strMatchRegEx("12f","[a-z]+")
print a

a =  strMatchRegEx("hum_","[a-z]+")
print a





 s1 = "User clientId=23421. Some more text clientId=33432. This clientNum=100"
 s2 = "(clientId=)(\\d+)"
print s1
print s2

k = strMatchRegExList(s1,s2) 

for i=1 to arrLen(k)
print k(i)
next i


print "=========StrIndexOf==========="



a  =  strIndexOf("sweden","s")
print a

a =  strIndexOf("sweden","e")
print a


a =  strIndexOf("sweden","9")
print a

print "========StrLastIndexOf==========="



a  =  strLastIndexOf("sweden","s")
print a
a =  strLastIndexOf("sweden","e")
print a

a =  strLastIndexOf("sweden","9")
print a

print "========StrCompare============"


a =  strCompare("sweden","denmark")
print a


a =  strCompare("sweden","sweden")
print a


a =  strCompare("sweden","Sweden")
print a

print "======StrCompareIgnoreCase=========="

a =  strCompareIgnoreCase("sweden","denmark")
print a


a =  strCompareIgnoreCase("sweden","sweden")
print a


a =  strCompareIgnoreCase("sweden","Sweden")
print a
print "============strLen================"


print "length of proxysniffer is " + strLen("proxysniffer") //12

name = "amir ashfaq"
print "length of amir ashfaq is " + strLen(name) //11 ok


print "=========strCharAt============="

a  =  strCharAt("sweden",3)
print a

a =  strCharAt("sweden",1)
print a


a =  strCharAt("sweden",6)
print a

print "=================================="

//trace on
xmlStr="<document><employee><name><lastname>Kelly</lastname><firstname>Grace</firstname></name><title>Manager</title></employee></document>"
print xmlGetData(xmlStr, "document.employee.title")   //Manager
//print xmlGetData(xmlStr, "document.employee.2")      // NULL???? space right now.. as now employ is object not array,,,


xmlStr= "<document><employee><name><lastname>Kelly</lastname><firstname>Grace</firstname></name><hiredate>October 15, 2005</hiredate><projects><project><product>Printer</product><id>111</id><price>$111.00</price></project><project><product>Laptop</product><id>222</id><price>$989.00</price></project></projects></employee><employee><name><lastname>Grant</lastname><firstname>Cary</firstname></name><hiredate>October 20, 2005</hiredate><projects><project><product>Desktop</product><id>333</id><price>$2995.00</price></project><project><product>Projector</product><id>9908</id><price>$123456789.00</price></project><project><product>Scanner</product><id>444</id><price>$200.00</price></project></projects></employee><employee><name><lastname>Gable</lastname><firstname>Clark</firstname></name><hiredate>October 25, 2005</hiredate><projects><project><product>Keyboard</product><id>555</id><price>$129.00</price></project><project><product>Mouse</product><id>666</id><price>$25.00</price></project></projects></employee></document>"
print xmlGetData(xmlStr,"document.employee.2.projects.project.1.price")
print xmlGetData(xmlStr, "document.employee.2.name.firstname") 


print "________XMLArraySize________"

for a = 1 to xmlArraySize(xmlStr,"document.employee")
 
                fname = xmlGetData(xmlStr, "document.employee." + a   + ".name.firstname")
                lname = xmlGetData(xmlStr, "document.employee." + a  + ".name.lastname")
                hdate = xmlGetData(xmlStr, "document.employee." + a   + ".hiredate")
                print fname + " " + lname + " is hired on "+ hdate
                print "________________"
next a

print "=================================="


jsonStr = "{\"balance\": 1000.21,\"num\":100, \"is_vip\":true, \"name\":\"foo\"}"
print jsonStr

print jsonGetData(jsonStr,"balance")
print jsonGetData(jsonStr,"name")



print "=================================="
 sabdi = "{\"playback\":{\"@assetId\":\"1017580\",\"title\":\"Leila bakar del 10\",\"live\":false,\"aspect16x9\":false,\"drmProtected\":false,\"playbackStatus\":\"OK\",\"hasItems\":true,\"liveBroadcastTime\":\"2010-05-27T21:30:00+02:00\",\"items\":{\"item\":[{\"log\":{\"@uri\":\"\\/api\\/stb1\\/asset\\/1017580\\/play\\/log\\/1593586\\/\"},\"bitrate\":1500,\"mediaFormat\":\"mp4\",\"base\":\"http:\\/\\/tv4play3-vh.akamaihd.net\\/i\\/mp4root{path}\\/{filename}.csmil\\/master.m3u8\",\"url\":\"http:\\/\\/tv4play3-vh.akamaihd.net\\/i\\/mp4root\\/2010-05-26\\/pid2697563_1017580_,T3MP43,T3MP48,T3MP415,_.mp4.csmil\\/master.m3u8\"},{\"log\":{\"@uri\":\"\\/api\\/stb1\\/asset\\/1017580\\/play\\/log\\/35129123\\/\"},\"bitrate\":6,\"mediaFormat\":\"webvtts\",\"scheme\":\"http\",\"server\":\"iosv.tv4play.se\",\"base\":\"http:\\/\\/iosv.tv4play.se\\/subs\",\"url\":\"http:\\/\\/iosv.tv4play.se\\/subs\\/2014-11-18\\/vid_1017580\\/prog_index.m3u8?\"}]},\"logData\":\"35174FF8FB2F3934D0B659A3D4729A5D764B382E256F819E46EE1F18CE7D4628E73BFDA25D487C0AC6B0A0ED78B44D2E394E3A04A64F4074BE97330ECD3C1055499070E6A649D704727575613DE38E92F13EEAEF882DD0AE7A311E2665FE00B1FC8CAE3D3DE2D60AB86F68F2B2F5E38ED69D8249CEDE09004745711E9B09F96DAA138F4022DEF7F18C95C4363801D60FCEFA4F329C9BC8B066D4A9EA176BAF73419208CA44E9F15A7CCF3E1F7C770B38BF47874906B0E7ECCE5EE22F7FF186BED29FDE8F6E02BC1C0C0EDF518DAF24B07B8516E5144E31E7223982C9E0B4CA18824C0A01675F3A22E7DEFFCFD8D8360C16D05C24765C1527408E41AEAAFE6398F1825D1AC41BE2118483B6E1AF51B0659F7A8DD2FF6EA669BC3E8F94AF195A46E36BA7DC77E417237E5D0CBB050E6E9A\"}}"
print sabdi
print "playback.items.item.1.url"
print jsonGetData(sabdi,"playback.items.item.1.url") 

print "=================================="

 s1 =     "{\"glossary\": {\"title\": \"example glossary\",\"GlossDiv\": {\"title\": \"S\",\"GlossList\": {\"GlossEntry\": {\"ID\": \"SGML\",\"SortAs\": \"SGML\",\"GlossTerm\": \"Standard Generalized Markup Language\",\"Acronym\": \"SGML\",\"Abbrev\": \"ISO 8879:1986\",\"GlossDef\": {\"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\"GlossSeeAlso\": [\"GML\", \"XML\"]},\"GlossSee\": \"markup\"}}}}}"
print s1
print "glossary.GlossDiv.GlossList.GlossEntry.GlossDef.GlossSeeAlso.1"
print jsonGetData(s1,"glossary.GlossDiv.GlossList.GlossEntry.GlossDef.GlossSeeAlso.1")

print "=================================="

 s2 = "{\"employees\":[{\"firstName\":\"John\", \"lastName\":\"Doe\"},{\"firstName\":\"Anna\", \"lastName\":\"Smith\"},{\"firstName\":\"Peter\",\"lastName\":\"Jones\"}]}"
print s2 
print "employees.3.lastName"
print  jsonGetData(s2,"employees.3.lastName")

print "=================================="

s3 = "{\"success\": false,\"payload\": {},\"error\": {\"code\": 123,\"message\": \"An error occurred!\"}}"
print s3
print "success"
print   jsonGetData(s3,"success")

print "=================================="
 s4 = "{\"description\" : \"Already Exists\",\"errors\" : {\"field\" : \"phoneNumber\",\"message\" : \"Phone number already exists for another user.\"}}"
print s4  
print "errors.message"
print   jsonGetData(s4,"errors.message")

print "=================================="
s5 = "{\"meta\": {\"error_type\": \"OAuthException\",\"code\": 400,\"error_message\": \"...\"},\"data\": \"kkj\",\"pagination\": {\"next_url\": \"...\",\"next_max_id\": \"13872296\"}}"
print s5
print "pagination.next_max_id"
print jsonGetData(s5, "pagination.next_max_id")

print "=================================="
s6 = "{ \"animals\": [{\"id\": 0,\"species\": \"Capra hircus\",\"name\": \"Goat\"},{\"id\": 1,\"species\": \"Panthera pardus\",\"name\": \"Leopard\"},{\"id\": 2,\"species\": \"Equus zebra\",\"name\": \"Zebra\"} ]}"
print s6
print "animals.1.name"
print jsonGetData(s6,"animals.1.name")
print jsonArraySize(s6,"animals")

print "=================================="
s7 ="{\"fname\": \"Jack\",\"sname\": \"Maya\",\"age\" : 13,\"isMarried\" : false,\"address\": {\"street\": \"#1234, Main Street\",\"zipCode\": \"123456\"},\"phoneNumbers\": [\"011-111-1111\", \"11-111-1111\"]}"
print s7
print "address.street"
print jsonGetData(s7,"address.street")


print "=================================="

s8  = "{\"name\" : \"sss\"}"
print s8
print "name"
print jsonGetData(s8,"name")
print "=================================="


print "this i wana have display as string"
print "\"this i wana have display as string\""

print "=========Date================="
print "=========Date================="



Dim r as Date
LoopVar2 = "2015-02-07"
o = dateCopy(LoopVar2,"yyyy-MM-dd")

print dtype(r)
print dtype(o)

r =  r + 3

print dtype(r)


dateVariable =dateAddDay(o,5)
print dateVariable

dateVariable =dateAddDay(o,-66)
print dateVariable


print dateFormat(dateVariable,"E, MMMM dd yyyy")
print dateFormat(dateVariable,"EEEE, MMM dd, yyyy hh:mm:ss a")


print "=================================="



writeToFile("filez.txt","this is a String")
writeToFile("filez.txt",r)
writeToFile("filez.txt",strLen("kkj"))
writeToFile("filez.txt",99865464)


print "=================================="
//print sqr(23.89 + 45 + "amir")  //illegal
print 5 + 8 / 9 * 9 - 6    // 7
print 3 + 3 * ( ( 4 + 4 * 4 - 5) / 2 ) / 5 + -5  // 2.5
print ( 4 + 4 * 4 ^ 5 )  //4100
print ( 4 ^ 4 * 4 + 5 * 8 ( 4 / 7 ))  //1046.8571
print 2 + 3 + "Amir" + 9  //5Amir9
print 2 / 3 + "Amir" + 9  //0.6666666666666666Amir9
//print 2 + 3 + "Amir" / 9  //NaN
print 2 + 2 == 4  //true
print 2 + 2 != 4  //false
print 2 + 1 == 4  //false
print 2 + 1 != 4  //true

print "Amir" == "Amir"  //true
print "Amir" == "M"  //false

print "Amir" != "Amir"  //false
print "Amir" != "M"  //true

print 5 < 7  //true
print 7 < 5  //false

print "a" < "a"
print "a" < "b"
print "b" < "a"

print "a" > "a"
print "a" > "b"
print "b" > "a"

print 5

print "Amir"

print "1" == "a" OR "a" == "a"
print "1" == "1" AND "a" == "a"
print "1" == "a" XOR "a" == "b"


print "=================================="

print "a" >= "a"                                       //true
print "a" <= "a"                                       //true

print "b" >= "a"                                       //true
print "b" <= "a"                                       //false

print "a" >= "b"                                       //false
print "a" <= "b"                                       //true

print "=================================="

print 5 >= 4                                        //true
print 5 >= 5                                        //true

print 5 <= 4                                        //false
print 4 <= 5                                        //true


print 4 MOD 5                                        //4
print 55 MOD 5                                        //0
print 55 MOD 2                                        //1

print "=================================="
print !("1" == "a")                                //true

print "1" == "1" AND !"a" == "b"                      //true

//print !(5)                                          //The operator ! is undefined for the argument type(Integer)
//print !(0)                                          //The operator ! is undefined for the argument type(Integer)
//print !(1)                                           //The operator ! is undefined for the argument type(Integer)
//print !("amir")                                   //The operator ! is undefined for the argument type(String)

//print "1" == "1" AND !(5)                  //false = true AND "The operator ! is undefined for the argument type(Integer)"

print !(true)                                          //false

print true                                             //true
print "true"                                          // "true"


print "==========dtype====================="


print dtype(23.89)                                  //Double
print dtype(23)                                     //Integer
print dtype("23.89")                                //String
print 2 + 3 + "Amir"  + 9                             //    5Amir9
print dtype(2 + 3 + "Amir" + 9 )                    //String
print 23.89 + 45 +"amir"                            //69.89amir
print dtype(23.89 + 45 + "amir")    //String
print dtype(23.89 + 45 + dtype("amir"))        //String


print "==========Math====================="

print sqr(23.89 + 45 )  //8.3
print random()   //0-1 ran num
print random(10)  //0-10 ran num
print random(50,70) //50-70 ran num

print "cos(67)"+  cos(67)


print "=================================="

a = 80
b = 20


IF a < b THEN                          //non is true..
print "a is less tyhen b"
ELSE IF a <= b THEN
print "a and b <=1"
ELSE IF a <= b THEN
print "a and b <=2"
ELSE IF a <= b THEN
print "a and b <=3"
ELSE IF a <= b THEN
print "a and b <=4"
ELSE IF a <= b THEN
print "a and b <=5"
ELSE IF a == b THEN
print "a == b"
ENDIF


a = 20
b = 20


IF a < b THEN
print "a is less tyhen b"
ELSE IF a <= b THEN           //this is true
print "a and b <=1"           //only first true will execute
ELSE IF a <= b THEN
print "a and b <=2"
ELSE IF a <= b THEN
print "a and b <=3"
ELSE IF a <= b THEN
print "a and b <=4"
ELSE IF a <= b THEN
print "a and b <=5"
ELSE IF a == b THEN
print "a == b"
ENDIF


print "=================================="

IF false THEN
    print "aa"
    IF true  THEN
    print "bb"
    ELSE
    print "cc"
    ENDIF

ELSE                         //whole above part is false..

print "dd"                    //dd
    IF false  THEN
    print "11"
    ELSE
    print "22"                //22
    ENDIF
ENDIF


IF true THEN
    print "ee"                //ee
    IF false  THEN
    print "ff"
    ELSE
    print "gg"                //gg
    ENDIF

ELSE

 print "hh"
    IF true  THEN
    print "ii"
    ELSE
    print "jj"
    ENDIF
ENDIF

print "=================================="
FOR z = 1 TO 10
print "z = " + z            // 1 to 10
NEXT z
print "=================================="
s = 78
print " " + s * 20 + " a"


print "-----already was in manual-------"

print dtype(1)
print dtype(1.1)
print dtype("hello")
print dtype(false)

print "____________________________"

a = 5 / 2
b = 5 / 2.0
c = 6.6 / 3.3
d = 5 \ 2
print "a (" + dtype(a) + ") = " + a
print "b (" + dtype(b) + ") = " + b
print "c (" + dtype(c) + ") = " + c
print "d (" + dtype(d) + ") = " + d



print "____________________________"

A = false
print dtype(A)
print A


A = "Hello" + A
print dtype(A)
print A

print "____________________________"

B = 3
DIM AA (1 to B) as double
FOR x = 1 to B STEP 1
AA(x) = 1.0 / x
PRINT AA(x)
NEXT x

print "____________________________"

A = 3

if (A == 1) THEN
 print "CASE 1"
else
  print "next try"
  if (A == 2) THEN
    print "CASE 2"
  else
    print "other case than 2"
  endif
  print "not case 1"
endif

print "____________________________"

s = 7
for y = (s - 2) to 9
print "y = " + y
next y
print "____________________________"



for y = 9 to 4 step -2
print "y = " + y
next y
print "value of y after loop = " + y

print "____________________________"


for x = 6 to 10
if (x == 8) then
  break
endif
print x
next x

print "_____problem loop____________"


n = 3
do while (n < 6)
print "n = " + n
n = n + 1
loop


print "____________________________"

n = 3
do while (n <= 6)
print "n = " + n                                         //3(9,10)4(9,10) OK
m = 9
do while (m < 11)
print "m = " + m
m = m + 1
loop
n = n + 1
loop

print "________3(9,10)4(9,10) OK___________"
print "______12:56____________"

for x = 6 to 12
  print "x = " + x
  if (x >10) then
    break
  endif

  y = 0
  do while y <= 8
    y = y + 1
    if (y > 3) then
      break
    endif

    print "y = " + y
  loop

next x

print 3 * 9

print "____________________________"


s = 6
label "target"
print "s = " + s
s = s + 1
if (s < 10 ) then
  goto "target"
endif

print "____________________________"

s = 0
label "start"
s = s + 1
if s < 3 then
  goto "target-" + s
endif
goto "end"
label "target-1"
print "case 1"
goto "start"
label "target-2"
print "case 2"
goto "start"
label "end"
print "all done"

print "____________________________"


s = 1
print "s = " + s
print "result of function = " + calc(5, 2)
print "s = " + s
goto "end"
FUNCTION calc(x, y)
x = x + 7 / y
GLOBAL s = 8
printloop()
RETURN (x + s)

FUNCTION printloop()
A = 2

IF (A == 1) THEN
 print "CASE 1"
ELSE
  print "next try"            //next try
  IF (A == 2) THEN
    print "CASE 2"            //CASE 2
  ELSE
    print "other case than 2"
  ENDIF
  print "not case 1"        //not case 1
endif
RETURN

label "end"

//dim random (1 to B) as double
print "=================================="




print xmlGetData(xmlStr,"document.employee.2.projects.project.1.price")
print xmlXPath(xmlStr,"document/employee[2]/projects/project[1]/price")

//print xmlGetData(xmlStr, "document.employee.2.name.firstname") 
expression = "/document/employee[2]/name/firstname"
print expression
print xmlXPath(xmlStr,expression)



xmlStr = "<?xml version=\"1.0\"?><Employees><Employee emplid=\"1111\" type=\"admin\"><firstname>amir</firstname><lastname>ashfaq</lastname><age>30</age><email>johnwatson@sh.com</email></Employee><Employee emplid=\"2222\" type=\"admin\"><firstname>moona</firstname><lastname>tahira</lastname><age>32</age><email>sherlock@sh.com</email></Employee><Employee emplid=\"3333\" type=\"user\"><firstname>ifra</firstname><lastname>eshaal</lastname><age>52</age><email>jim@sh.com</email></Employee><Employee emplid=\"4444\" type=\"user\"><firstname>bilal</firstname> <lastname>usman</lastname><age>41</age><email>mycroft@sh.com</email> </Employee></Employees>"

print "???????????????????????????????????????????????????????????????????"
expression = "/Employees/Employee[@emplid='3333']/email"
print expression
print xmlXPath(xmlStr,expression)

print "???????????????????????????????????????????????????????????????????"
expression = "count(/Employees/Employee)"
print expression
print xmlXPath(xmlStr,expression)

print "???????????????????????????????????????????????????????????????????"
expression = "//Employees/Employee/firstname | //Employees/Employee/lastname "
print expression
print xmlXPath(xmlStr,expression)

print "???????????????????????????????????????????????????????????????????"
expression = "/Employees/Employee[@type='admin']/firstname"
print expression
print xmlXPath(xmlStr,expression)

print "???????????????????????????????????????????????????????????????????"
expression = "/Employees/Employee[last()-1]/firstname"
print expression
print xmlXPath(xmlStr,expression)

print "???????????????????????????????????????????????????????????????????"
expression = "/Employees/Employee[age>40]"
print expression
print xmlXPath(xmlStr,expression)

print "???????????????????????????????????????????????????????????????????"
expression = "/Employees/Employee[2]"
print expression
print xmlXPath(xmlStr,expression)

print "???????????????????????????????????????????????????????????????????"
expression = "/Employees/Employee[2]/lastname"
print expression
print xmlXPath(xmlStr,expression)

print "???????????????????????????????????????????????????????????????????"

jsonStr =     "{\"glossary\": {\"title\": \"example glossary\",\"GlossDiv\": {\"title\": \"S\",\"GlossList\": {\"GlossEntry\": {\"ID\": \"SGML\",\"SortAs\": \"SGML\",\"GlossTerm\": \"Standard Generalized Markup Language\",\"Acronym\": \"SGML\",\"Abbrev\": \"ISO 8879:1986\",\"GlossDef\": {\"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\"GlossSeeAlso\": [\"GML\", \"XML\"]},\"GlossSee\": \"markup\"}}}}}"

expression = "glossary/GlossDiv/GlossList/GlossEntry/GlossDef/GlossSeeAlso[1]"
print expression
print jsonGetData(jsonStr,"glossary.GlossDiv.GlossList.GlossEntry.GlossDef.GlossSeeAlso.1")
print jsonXPath(jsonStr,expression)

print "???????????????????????????????????????????????????????????????????"
expression = "glossary/GlossDiv/GlossList/GlossEntry/GlossTerm"
print expression
print jsonGetData(jsonStr,"glossary.GlossDiv.GlossList.GlossEntry.GlossTerm")
print jsonXPath(jsonStr,expression)

print "____________________________________________________"
print ""
print "After bugfix mentioned by Ervin (when json data starts with array...)"
jsonStr ="[{\"id\":103489,\"title\":\"Question 113000233\",\"body\":\"A nurse is performing a Braden scale on a client. What does the nurse understand could contribute to a client developing a pressure ulcer? Select all that apply.\",\"explanation\":\"\",\"optionsHeader\":\"\",\"style\":\"ALL\",\"correctOptions\":[],\"optionTexts\":[\"<td class='optionText' value='1'><p>Client has a fever</p></td>\",\"<td class='optionText' value='2'><p>Repositioning every 2 hours</p></td>\",\"<td class='optionText' value='3'><p>Shearing force</p></td>\",\"<td class='optionText' value='4'><p>Two services rubbing together</p></td>\",\"<td class='optionText' value='5'><p>Excessive moisture</p></td>\"],\"hint\":\"A nurse is performing a Braden scale on a client. What does the nurse understand could contribute to a client developing a pressure ulcer? Select all that apply.\",\"timeSpentSecs\":0},{\"id\":103490,\"title\":\"Question 113000234\",\"body\":\"A nurse is admitting a client with a pressure ulcer to their sacrum. The wound appears open with a pink wound bed, no exudate or slough present. What pressure ulcer stage would the nurse document?\",\"explanation\":\"\",\"optionsHeader\":\"\",\"style\":\"MCQ\",\"correctOptions\":[],\"optionTexts\":[\"<td class='optionText' value='1'><p>Stage I</p></td>\",\"<td class='optionText' value='2'><p>Stage II</p></td>\",\"<td class='optionText' value='3'><p>Stage III</p></td>\",\"<td class='optionText' value='4'><p>Stage IV</p></td>\"],\"hint\":\"A nurse is admitting a client with a pressure ulcer to their sacrum. The wound appears open with a pink wound bed, no exudate or slough present. What pressure ulcer stage would the nurse document?\",\"timeSpentSecs\":0},{\"id\":103491,\"title\":\"Question 113000235\",\"body\":\"A nurse is preparing discharge instructions for a client that experienced an ankle sprain. What statement by the client would indicate the need for further teaching?\",\"explanation\":\"\",\"optionsHeader\":\"\",\"style\":\"MCQ\",\"correctOptions\":[],\"optionTexts\":[\"<td class='optionText' value='1'><p>Using a heating pad right away will help with pain</p></td>\",\"<td class='optionText' value='2'><p>I can use an ace wrap to compress the area</p></td>\",\"<td class='optionText' value='3'><p>I need to elevate my ankle above the level of my heartd. I should rest my injury initially</p></td>\",\"<td class='optionText' value='4'><p>I should rest my injury initially</p></td>\"],\"hint\":\"A nurse is preparing discharge instructions for a client that experienced an ankle sprain. What statement by the client would indicate the need for further teaching?\",\"timeSpentSecs\":0}]"
print jsonStr

print "2.id > "+jsonGetData(jsonStr,"2.id")
print "[2]/id > "+ jsonXPath(jsonStr,"[2]/id")


// fixed bug when all quotes were removed on concatination...
jsonStr = "{\"data\":" + jsonStr +"}"
print jsonStr

print "data.2.id > "+ jsonGetData(jsonStr,"data.2.id")
print "data[2]/id  > " +jsonXPath(jsonStr,"data[2]/id")

print "____________________________________________________"
print ""

xmlArray = "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note><note><to>Tove2</to><from>Jani2</from><heading>Reminder2</heading><body>Don't forget me this weekend!2</body></note><note><to>Tove3</to><from>Jani3</from><heading>Reminder3</heading><body>Don't forget me this weekend!3</body></note>"
print xmlArray
print "xmlGetData 2.from >" +xmlGetData(xmlArray,"2.from")

print "xmlXPath [2]/from >" +xmlXPath(xmlArray,"[2]/from")
print "xmlXPath note[2]/from >" +xmlXPath(xmlArray,"note[2]/from")


 xmlArray2 = "<data><note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note><note><to>Tove2</to><from>Jani2</from><heading>Reminder2</heading><body>Don't forget me this weekend!2</body></note><note><to>Tove3</to><from>Jani3</from><heading>Reminder3</heading><body>Don't forget me this weekend!3</body></note></data>"
print xmlArray2
 print "xmlXPath data/note[2]/from >" +xmlXPath(xmlArray2,"data/note[2]/from")


//   4nov16 added strContains
str =  "/resa/egypten/marsa-alam-kusten/pdc-000000472/"
str2 = "pdc"
print strContains(str,str2)



//12Jan17
s7 ="{\"fname\": \"Jack\",\"sname\": \"Maya\",\"age\" : 13,\"isMarried\" : false,\"address\": {\"street\": \"#1234, Main Street\",\"zipCode\": \"123456\",\"phoneNumbers\": [\"011-111-1111\", \"11-111-1111\"]}}"
print jsonGetData(s7,"address.phoneNumbers.2")
//print jsonGetData(s7,"address.kkj.2") //proper error if element not present
//print jsonGetData(s7,"address.phoneNumbers.3") proper error if araysize issue

//print jsonArraySize(s7,"address.phoneNumbers.3") proper error if not array
print jsonArraySize(s7,"address.phoneNumbers")



//fix on 14 feb
if !strMatchRegEx("12345678","[0-9]{8}") THEN
abort("Unable to extract resume ID from JSON")
ENDIF


line = " This order was placed for QT3000! OK?"
pattern = "(.*?)(\\d+)(.*)"
print strCaptureRegExGroups(line,pattern)

//new method on 14 feb
arr = strCaptureRegExGroups2(line,pattern)

for x = 1 to arrLen(arr)
print x+" "+ arr(x)
next x



//15feb17 (fix related to space2_)
//var  = getHTTPResponseContent()
//print var
//print jsonGetData(var,"places.1.place name")
//print jsonXPath(var,"country")



//added 25April

print getUnixTimestampSeconds()
print getUnixTimestampMillis()


createCollectionSequence ("nameA" , "title" , "subtitle" , "yAxislabel")
print getCollectionSequenceList()

addClusterOption("nameA" , 1 , "subtitle")

print hasClusterOption("nameA" , 1)


addDataCollectionFloatItem("nameA" , 7.0)
addDataCollectionFloatItem("nameA" , 5.0)
addDataCollectionFloatItem("nameA" , 8.0)
addDataCollectionFloatItem("nameA" , 11.7)

print getCollectionSequenceItemType ("nameA")






