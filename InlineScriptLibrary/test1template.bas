// --- Presettings Start ---
// Inline Script Title: test1
<<<<<<< HEAD
<<<<<<< HEAD
// Execution Scope: After URL
// Input Var List: globalVar1,globalVar2,LoopVar1,LoopVar2,userVar1,userVar2,V1,vEtag18,vInnerLoop1
// Output Var List: V1
// Execution Priority: 3
// Execution Timeout: 15
// --- Presettings End ---

include "fileToBeincluded.txt"

REM print globalVar1
print V1
print vEtag18

print 5 + 8 / 9 * 9 - 6
print 3 + 3 * ( ( 4 + 4 * 4 - 5) / 2 ) / 5 + -5 ���

V1 =23.89 + 45 + V1
print  V1
V1 = V1 + "amir"
print V1
V1 = V1 + 5
print V1

dim r as date
print dtype(r)
dateVariable = DateCopy(LoopVar2,"yyyy-MM-dd")
print dtype(dateVariable)


print r
print dateVariable
dateVariable =DateAddDay(r,5)
print dateVariable


dateVariable =DateAddDay(r,-66)
print dateVariable


dateVariable =DateAddYear(r,-66)
print dateVariable

print "============StrLen================"
name = "amir ashfaq"
print "length of amir ashfaq is " + StrLen(name) //11 ok
print   StrLen(name)

print "=========StrCharAt============="
a  =  StrCharAt(V1,3)
print a
           

print "========StrCompare============"
a =  StrCompare(V1,V1)
print a

print "========StrIndexOf============"
a  =  StrIndexOf(V1,"B")
print a

print "========StrLastIndexOf============"
a  =  StrLastIndexOf(V1,"B")
print a
            
print "==========StrSubString==========="
print   StrLen(V1)
V1 = StrSubString(V1,4,36) 
print V1
print   StrLen(V1)




 s1 = "User clientId=23421. Some more text clientId=33432. This clientNum=100";
 s2 = "(clientId=)(\d+)";

k = StrMatchRegexList(s1,s2) 

for p=1 to ArrLen(k)
print 90 + k(p) + 67
next p


print "============FOR LOOP================"
for x=1 to StrLen(V1) step 8
a  =  StrCharAt(V1,x)
print a
next x



V1 = StrSubString(V1,"4",8) 
print V1



a = StrUpper(V1)
print a
=======
// Execution Scope: Start of Load Test
// Input Var List: globalVar1,globalVar2
// Output Var List: 
// Execution Priority: 3
// Execution Timeout: 15
// --- Presettings End ---

include "fileToBeincluded.txt"

REM print globalVar1
//print V1
//print vEtag18

print 5 + 8 / 9 * 9 - 6
print 3 + 3 * ( ( 4 + 4 * 4 - 5) / 2 ) / 5 + -5
V1 = "ss"
V1 = 23.89 + 45 + V1
print  V1
V1 = V1 + "amir"
print V1
V1 = V1 + 5


V1 = StrSubString(V1,"4",8) 
print V1



V1 = StrToUpper(V1)
print V1
>>>>>>> refs/heads/my-saved-work-02_02_2016
=======
// Execution Scope: Start of Load Test
// Input Var List: globalVar1,globalVar2
// Output Var List: 
// Execution Priority: 3
// Execution Timeout: 15
// --- Presettings End ---

include "fileToBeincluded.txt"

REM print globalVar1
//print V1
//print vEtag18

print 5 + 8 / 9 * 9 - 6
print 3 + 3 * ( ( 4 + 4 * 4 - 5) / 2 ) / 5 + -5
V1 = "ss"
V1 = 23.89 + 45 + V1
print  V1
V1 = V1 + "amir"
print V1
V1 = V1 + 5


V1 = StrSubString(V1,"4",8) 
print V1



V1 = StrToUpper(V1)
print V1
>>>>>>> refs/heads/my-saved-work-02_02_2016


printloop()
