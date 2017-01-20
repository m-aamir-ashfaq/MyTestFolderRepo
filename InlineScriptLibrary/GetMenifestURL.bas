// --- Presettings Start ---
// Inline Script Title: GetMenifestURL
// Execution Scope: After URL
// Input Var List: manifestUrl
// Output Var List: manifestUrl
// Execution Priority: 1
// Execution Timeout: 15
// --- Presettings End ---

if(isUrlCallPassed())then
response = getHTTPResponseContent()
print response
playback =  jsonObjectGetData(response,"playback")
print playback
items = jsonObjectGetData(playback,"items")
print items
item = jsonObjectGetData(items,"item")
print item
log = jsonArrayGetData(item,1)
print log
url = jsonObjectGetData(log,"url")
print url
manifestUrl = url
else
print "url failing..."
endif