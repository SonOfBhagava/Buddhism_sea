package com.bhagava.common.http;

import entity.ResponseEntity;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;

/**
 * created by FeiJunhao on ${date}
 */

@SuppressWarnings("unused")
public class HttpClients {
    private static final Log log = LogFactory.getLog(HttpClients.class);
    private static final HttpClients clients = new HttpClients();
    private HttpClients(){}

    public static HttpClients getInstance() {
        return clients;
    }

    // 接口地址
    private HttpClient httpClient = null;
    private HttpPost method = null;
    private long startTime = 0L;
    private long endTime = 0L;
    private static PoolingHttpClientConnectionManager cm = null;
    static {
        LayeredConnectionSocketFactory sslsf = null;
        try {
            sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
        } catch (NoSuchAlgorithmException e) {
            log.error("创建SSL连接失败");
        }
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("https", sslsf).register("http", new PlainConnectionSocketFactory()).build();
        cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(150);
    }

    private static CloseableHttpClient getHttpClient() {
        CloseableHttpClient httpClient = org.apache.http.impl.client.HttpClients.custom().setConnectionManager(cm)
                .build();
        return httpClient;
    }


    /**
     * 根据url和参数返回结果实体的post方法
     * @param parameters 请求携带的参数
     * @param apiURL 要发送请求的url
     * @return 请求获得回复的字符串,如果出现异常则返回异常信息
     */
    public String post(String parameters, String apiURL){
        String body = null;
        String status = "0";
        ResponseEntity responseEntity = null;
        String resData = null;
        byte[] btyJson = parameters.getBytes(Charset.forName("utf-8"));
        try {
            httpClient = HttpClients.getHttpClient();
/*            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(10000).setConnectionRequestTimeout(10000)
                    .setSocketTimeout(10000).build();*/
            method = new HttpPost(apiURL);
            /*            method.setConfig(requestConfig);*/
            method.addHeader("Content-type", "application/json; charset=utf-8");
            method.setHeader("Accept", "application/json");
            method.setEntity(new ByteArrayEntity(btyJson));
            HttpResponse response = httpClient.execute(method);
            //返回值
            HttpEntity entity = response.getEntity();
            byte[] resByte = EntityUtils.toByteArray(entity);
            resData = new String(resByte, "utf-8");
        }catch (Exception e){
            return e.toString();
        }
            return resData;
    }

    /**
     * 根据url和参数返回结果实体的post方法
     * @param parameters 请求携带的参数
     * @param apiURL 要发送请求的url
     * @return 用于存储解析存储协议约定的返回字段的对象，所有异常都会被捕捉封装
     */
    public ResponseEntity getEntityByPost(String parameters, String apiURL) {
        ResponseEntity responseEntity = null;
        try {
        String resData = post(parameters, apiURL);
            JSONObject jsonObject = null;
            try{
                jsonObject = JSONObject.fromObject(resData);
            }catch (Exception e){
                ResponseEntity eRes = ResponseEntity.error("","","该回复结果不是一个标准JSON串");
                eRes.setResponse(resData);
                return eRes;
            }
            responseEntity = (ResponseEntity) JSONObject.toBean(jsonObject,ResponseEntity.class);
            responseEntity.setResponse(resData);
        } catch (Exception e) {
            return ResponseEntity.error("","",e.toString());
        }
        return responseEntity;
    }

    /**
     * 判断是否能正常发起HTTP请求的方法
     * @param parameters 请求的参数
     * @param apiURL 请求的URL地址
     * @return boolean
     */
    public boolean isConnection(String parameters,String apiURL){
        String body = null;
        try {
            httpClient = HttpClients.getHttpClient();
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000).setConnectionRequestTimeout(10000).setSocketTimeout(10000).build();
            method = new HttpPost(apiURL);
            method.addHeader("Content-type", "application/json; charset=utf-8");
            method.setHeader("Accept", "application/json");
            StringEntity stringEntity = new StringEntity(parameters);
            stringEntity.setContentEncoding("UTF-8");
            method.setEntity(new StringEntity(parameters));
            HttpResponse response = httpClient.execute(method);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return true;
            }else {
                return false;
            }

        } catch (IOException e) {
            return true;
        }
    }


}