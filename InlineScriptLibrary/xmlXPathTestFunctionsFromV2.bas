// --- Presettings Start ---
// Inline Script Title: 
// Execution Scope: After URL
// Input Var List: 
// Output Var List: 
// Execution Priority: 3
// Execution Timeout: 15
// --- Presettings End ---

xmlStr= "<document><employee><name><lastname>Kelly</lastname><firstname>Grace</firstname></name><hiredate>October 15, 2005</hiredate><projects><project><product>Printer</product><id>111</id><price>$111.00</price></project><project><product>Laptop</product><id>222</id><price>$989.00</price></project></projects></employee><employee><name><lastname>Grant</lastname><firstname>Cary</firstname></name><hiredate>October 20, 2005</hiredate><projects><project><product>Desktop</product><id>333</id><price>$2995.00</price></project><project><product>Projector</product><id>9908</id><price>$123456789.00</price></project><project><product>Scanner</product><id>444</id><price>$200.00</price></project></projects></employee><employee><name><lastname>Gable</lastname><firstname>Clark</firstname></name><hiredate>October 25, 2005</hiredate><projects><project><product>Keyboard</product><id>555</id><price>$129.00</price></project><project><product>Mouse</product><id>666</id><price>$25.00</price></project></projects></employee></document>"

print xmlGetData(xmlStr,"document.employee.2.projects.project.1.price")
print xmlXPath(xmlStr,"document/employee[2]/projects/project[1]/price")

//print xmlGetData(xmlStr, "document.employee.2.name.firstname") 
expression = "/document/employee[2]/name/firstname"
print expression
print xmlXPath(xmlStr,expression)



xmlStr = "<?xml version=\"1.0\"?><Employees><Employee emplid=\"1111\" type=\"admin\"><firstname>amir</firstname><lastname>ashfaq</lastname><age>30</age><email>johnwatson@sh.com</email></Employee><Employee emplid=\"2222\" type=\"admin\"><firstname>moona</firstname><lastname>tahira</lastname><age>32</age><email>sherlock@sh.com</email></Employee><Employee emplid=\"3333\" type=\"user\"><firstname>ifra</firstname><lastname>eshaal</lastname><age>52</age><email>jim@sh.com</email></Employee><Employee emplid=\"4444\" type=\"user\"><firstname>bilal</firstname> <lastname>usman</lastname><age>41</age><email>mycroft@sh.com</email> </Employee></Employees>"
  expression = "/Employees/Employee[@emplid='3333']/email"
print expression
print xmlXPath(xmlStr,expression)

 expression = "count(/Employees/Employee)"
print expression
print xmlXPath(xmlStr,expression)

expression = "//Employees/Employee/firstname | //Employees/Employee/lastname "
print expression
print xmlXPath(xmlStr,expression)
expression = "/Employees/Employee[@type='admin']/firstname"
print expression
print xmlXPath(xmlStr,expression)
expression = "/Employees/Employee[last()-1]/firstname"
print expression
print xmlXPath(xmlStr,expression)
 expression = "/Employees/Employee[age>40]"
print expression
print xmlXPath(xmlStr,expression)
expression = "/Employees/Employee[2]"
print expression
print xmlXPath(xmlStr,expression)
expression = "/Employees/Employee[2]/lastname"
print expression
print xmlXPath(xmlStr,expression)

print "???????????????????????????????????????????????????????????????????"

jsonStr =     "{\"glossary\": {\"title\": \"example glossary\",\"GlossDiv\": {\"title\": \"S\",\"GlossList\": {\"GlossEntry\": {\"ID\": \"SGML\",\"SortAs\": \"SGML\",\"GlossTerm\": \"Standard Generalized Markup Language\",\"Acronym\": \"SGML\",\"Abbrev\": \"ISO 8879:1986\",\"GlossDef\": {\"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\"GlossSeeAlso\": [\"GML\", \"XML\"]},\"GlossSee\": \"markup\"}}}}}"
expression = "glossary/GlossDiv/GlossList/GlossEntry/GlossDef/GlossSeeAlso[1]"
print expression
print jsonGetData(jsonStr,"glossary.GlossDiv.GlossList.GlossEntry.GlossDef.GlossSeeAlso.1")
print jsonXPath(jsonStr,expression)

expression = "glossary/GlossDiv/GlossList/GlossEntry/GlossTerm"
print expression
print jsonGetData(jsonStr,"glossary.GlossDiv.GlossList.GlossEntry.GlossTerm")
print jsonXPath(jsonStr,expression)
