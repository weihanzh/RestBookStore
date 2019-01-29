package com.team404.bookstore.sslConfig;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

// Taken reference from https://stackoverflow.com/questions/6047996/ignore-self-signed-ssl-cert-using-jersey-clienthttps://stackoverflow.com/questions/6047996/ignore-self-signed-ssl-cert-using-jersey-client

public class SslConfig {
	
	public Client ssl() {
	
		SSLContext sc= null;
		
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[]{
			new X509TrustManager()
			{
		    public X509Certificate[] getAcceptedIssuers(){return null;}
		    public void checkClientTrusted(X509Certificate[] certs, String authType){}
		    public void checkServerTrusted(X509Certificate[] certs, String authType){}
		    }
			};

		// Install the all-trusting trust manager
		try {
		    sc = SSLContext.getInstance("TLS");
		    sc.init(null, trustAllCerts, new SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		    ;
		}

	
	 return ClientBuilder.newBuilder().sslContext(sc).hostnameVerifier((s1, s2)-> true).build();
}

}
