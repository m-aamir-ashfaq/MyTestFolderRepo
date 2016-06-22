 yet to be included,,,
    private static String GetSignatureOAuth1_0(Interpreter interpreter, String client_key, String client_secret, String url, String timestamp, String nonce, String method, String token, String token_secret) {
        String outTimestamp = "";
        String outNonce = "";
        String signature = "";

        try {
            String[] urlParts = url.split("\\?");
            String hostpath = URLEncoder.encode(urlParts[0], "UTF8");
            String[] params = urlParts[1].split("&");
            ArrayList<String> parameters = new ArrayList<String>(Arrays.asList(params));

            if (urlParts[1].contains("oauth_timestamp=")) {
                for (String param : params) {
                    if (param.contains("oauth_timestamp="))
                        timestamp = param.split("=")[1];
                }
            }
            // generate timestamp if it wasn't passed in
            else if (timestamp.isEmpty()) {
                timestamp = String.format("%d", System.currentTimeMillis() / 1000L);
                parameters.add("oauth_timestamp=" + timestamp);
            }
            outTimestamp = timestamp;
            //logVector.log("out_timestamp = "+outTimestamp);
            //System.out.println("timestamp: " + timestamp);

            if (urlParts[1].contains("oauth_nonce=")) {
                for (String param : params) {
                    if (param.contains("oauth_nonce="))
                        nonce = param.split("=")[1];
                }
            }
            // generate nonce if it wasn't passed in
            else if (nonce.isEmpty()) {
                nonce = String.format("%d", (long) (Math.random() * 100000000000L));
                parameters.add("oauth_nonce=" + nonce);
            }
            System.out.println("nonce: " + nonce);
            outNonce = nonce;
            //logVector.log("out_nonce = "+outNonce);

            if (!urlParts[1].contains("oauth_version="))
                parameters.add("oauth_version=1.0");

            Collections.sort(parameters);
            String sortedParams = "";
            for (String param : parameters) {
                //add excludes here
                if (param.contains("oauth_signature="))
                    continue;

                sortedParams += sortedParams.isEmpty() ? param : String.format("&%s", param);
            }

            String signatureBase = String.format("GET&%s&%s", hostpath, URLEncoder.encode(sortedParams, "UTF8"));
            System.out.println("signature base: " + signatureBase);

            // generate oauth signature
            byte[] keyBytes = (client_secret + "&" + token_secret).getBytes("UTF8");
            SecretKey sk = new SecretKeySpec(keyBytes, method);
            Mac mac = Mac.getInstance(method);
            mac.init(sk);

            signature = Base64Encoder.encode(mac.doFinal(signatureBase.getBytes("UTF8")));
            signature = URLEncoder.encode(signature, "UTF8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return signature;
    }