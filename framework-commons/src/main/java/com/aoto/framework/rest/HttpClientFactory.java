/*
 * Nanjing Aoto 2017, All rights reserved.
 * 文件名  :HttpClientFactory.java
 * 创建人  :zongwj
 * 创建时间:2017年5月24日
*/

package com.aoto.framework.rest;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年5月24日
 */
public class HttpClientFactory {
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static Logger log = LoggerFactory.getLogger(HttpClientFactory.class);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return HttpClient
     */
    public static HttpClient create() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy(){
                @Override
                public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext,
                    NoopHostnameVerifier.INSTANCE);

            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create().register(
                    "http", PlainConnectionSocketFactory.getSocketFactory()).register("https", socketFactory).build();
            
            HttpClient httpClient = HttpClientBuilder.create().setSSLContext(sslContext).setConnectionManager(
                    new PoolingHttpClientConnectionManager(registry)).build();
            return httpClient;
        }
        catch (Exception e) {
            log.error("rest调用客户端异常", e);
            return HttpClients.createDefault();
        }        
    }
}
