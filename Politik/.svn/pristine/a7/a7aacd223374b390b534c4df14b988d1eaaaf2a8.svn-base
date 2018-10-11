package com.saganet.politik.utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ol4jsf.proxy.config.Environment;
import org.ol4jsf.proxy.config.OL4JSFProxyConfig;
import org.ol4jsf.proxy.config.OL4JSFProxyException;
import org.ol4jsf.proxy.config.Resource;
import org.ol4jsf.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OL4JSFProxyPolitik extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static OL4JSFProxyConfig ol4jsfProxyConfig;
	private static final Logger logger = LoggerFactory.getLogger(OL4JSFProxyPolitik.class);

	static {
		try {
			ol4jsfProxyConfig = OL4JSFProxyConfig.getOL4JSFProxyConfig("/ol4jsf-proxy.xml");
		} catch (OL4JSFProxyException e) {
			logger.warn("Fail on loading ol4jsf-proxy.xml. {}", e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (ol4jsfProxyConfig == null) {
			logger.warn("OL4JSFProxy is not configured.");
			response.getWriter().println("OL4JSFProxy is not configured.");
			return;
		}

		String uri = request.getRequestURI();
		String resourceName = uri.substring(uri.lastIndexOf("/") + 1, uri.length());

		Environment env = ol4jsfProxyConfig.getEnvironment();

		if (env != null && env.getResource(resourceName) != null) {
			Resource resource = env.getResource(resourceName);
			String destURL = resource.getUrl();
			// logger.debug("URL: {}", destURL);
			boolean doGet = request.getMethod().equals("GET");

			if (doGet) {
				destURL = destURL + "?" + request.getQueryString();
			}

			PrintWriter xmlOut = null;

			try {
				URL u = new URL(destURL);
				
				TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
					public java.security.cert.X509Certificate[] getAcceptedIssuers() {
						return null;
					}

					@Override
					public void checkClientTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
					}

					@Override
					public void checkServerTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
					}
				} };

				// Install the all-trusting trust manager
				SSLContext sc = SSLContext.getInstance("SSL");
				sc.init(null, trustAllCerts, new java.security.SecureRandom());

				// Create all-trusting host name verifier
				HostnameVerifier allHostsValid = new HostnameVerifier() {
					public boolean verify(String hostname, SSLSession session) {
						return true;
					}
				};

				HttpsURLConnection acon = (HttpsURLConnection) u.openConnection();
				
				acon.setSSLSocketFactory(sc.getSocketFactory());
				acon.setHostnameVerifier(allHostsValid);

				acon.setAllowUserInteraction(false);

				acon.setRequestMethod(request.getMethod());
				if (!doGet) {
					acon.setRequestProperty("Content-Type", request.getContentType());
				}

				acon.setDoOutput(true);
				acon.setDoInput(true);
				acon.setUseCaches(false);

				if (resource.getAuthentication() != null) {
					String password = resource.getAuthentication().getPassword();
					String up = resource.getAuthentication().getUsername() + ":" + password;
					String encoded = Base64.encode(up).replaceAll("(\r)?\n", "");
					String authHeader = "Basic " + encoded;
					acon.setRequestProperty("Authorization", authHeader);
				}

				if (!doGet) {
					BufferedReader bodyReader = request.getReader();
					StringBuilder sb = new StringBuilder();
					String line = null;
					while ((line = bodyReader.readLine()) != null) {
						sb.append(line);
					}
					bodyReader.close();

					String body = sb.toString();
					String charsetName = request.getCharacterEncoding() != null ? request.getCharacterEncoding()
							: "UTF-8";
					xmlOut = new PrintWriter(
							new BufferedWriter(new OutputStreamWriter(acon.getOutputStream(), charsetName)));
					xmlOut.write(body);
					xmlOut.flush();
				}

				// Above 400 they're all error codes, see:
				// http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html
				if (acon.getResponseCode() >= 400) {
					response.setContentType("application/xml");
					PrintWriter out = response.getWriter();
					out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
					out.println("<servlet-exception>");
					out.println("HTTP response: " + acon.getResponseCode() + "\n"
							+ URLDecoder.decode(acon.getResponseMessage(), "UTF-8"));
					out.println("</servlet-exception>");
					out.close();
				} else {
					response.setContentType(acon.getContentType());
					response.setHeader("Content-disposition", acon.getHeaderField("Content-disposition"));

					OutputStream output = response.getOutputStream();
					byte[] buffer = new byte[1024];
					InputStream in = acon.getInputStream();
					int count;
					count = in.read(buffer);
					while (count != -1) {
						output.write(buffer, 0, count);
						count = in.read(buffer);
					}
					in.close();
					output.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (xmlOut != null) {
					xmlOut.close();
				}
			}

		} else {
			logger.debug("ol4jsf-proxy.xml is not configured properly.");
		}
	}
}
