// --- Presettings Start ---
// Inline Script Title: Getdesiredquality
// Execution Scope: After URL
// Input Var List: desiredquality
// Output Var List: desiredquality
// Execution Priority: 3
// Execution Timeout: 15
// --- Presettings End ---

wholeresponse =  getHTTPResponseContent()
//trace on
qualityurls = strMatchRegExList(wholeresponse,"http://(.)*.m3u8")

desiredquality = qualityurls(3)
print desiredquality
desiredquality = strReplace(desiredquality,"http://tv4play3-vh.akamaihd.net","" )
print desiredquality