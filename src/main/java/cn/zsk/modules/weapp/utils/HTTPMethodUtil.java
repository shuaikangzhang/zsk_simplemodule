package cn.zsk.modules.weapp.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import java.util.Map;

public class HTTPMethodUtil {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HTTPMethodUtil.class);

    public static String httpPost(String url,Map<String, Object> paramMap,String userName,String userPass) {


        DefaultHttpClient client = new DefaultHttpClient();
        SchemeRegistry registry = new SchemeRegistry();
        SingleClientConnManager mgr = new SingleClientConnManager(client.getParams(), registry);
        DefaultHttpClient httpClient = new DefaultHttpClient(mgr, client.getParams());
        HttpPost httpPost = new HttpPost(url);

        try{
            HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
            SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
            socketFactory.setHostnameVerifier((X509HostnameVerifier) hostnameVerifier);
            registry.register(new Scheme("https", socketFactory, 443));
            HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
            httpPost.setHeader("Content-Type", "application/json");

            //使用base64进行加密
            byte[] tokenByte = Base64.encodeBase64((userName+":"+userPass).getBytes());
            //将加密的信息转换为string
            String tokenStr = new String(tokenByte);
            System.out.println("======================tokenStr==================="+tokenStr);
            logger.debug("======================tokenStr==================="+tokenStr);
            //把认证信息发到header中
            httpPost.setHeader("Authorization", "Basic "+tokenStr);
            String jsonstr = JSON.toJSONString(paramMap);

            httpPost.addHeader(HTTP.CONTENT_TYPE,"application/json");
            httpPost.addHeader("Accept", "application/json");
            httpPost.addHeader("Accept-Encoding", "UTF-8");


            StringEntity se = new StringEntity(jsonstr, Consts.UTF_8);
            se.setContentType("application/json");
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"UTF-8"));
            httpPost.setEntity(se);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        HttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }

        String result = null;
        if(response == null || response.getStatusLine() == null){
            logger.debug("*******************服务器返回码为空*********************" );
            return "";
        }else {
            //打印StatusLine
            logger.debug("StatusLine: " + response.getStatusLine());
        }

        try{
            //获取实体
            HttpEntity httpEntity= response.getEntity();
            result = EntityUtils.toString(httpEntity, "UTF-8");
            logger.debug(result);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
        //关闭流并释放资源
        httpClient.close();
        return result;
    }

    public static String httpGet(String url,String userName,String userPass) {
        HttpGet httpGet = new HttpGet(url);


        DefaultHttpClient client = new DefaultHttpClient();
        SchemeRegistry registry = new SchemeRegistry();
        SingleClientConnManager mgr = new SingleClientConnManager(client.getParams(), registry);
        DefaultHttpClient httpClient = new DefaultHttpClient(mgr, client.getParams());
            HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
            SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
            socketFactory.setHostnameVerifier((X509HostnameVerifier) hostnameVerifier);
            registry.register(new Scheme("https", socketFactory, 443));
            HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
        //使用base64进行加密
        byte[] tokenByte = Base64.encodeBase64((userName+":"+userPass).getBytes());
        //将加密的信息转换为string
        String tokenStr = new String(tokenByte);
        System.out.println("======================tokenStr==================="+tokenStr);
        logger.debug("======================tokenStr==================="+tokenStr);
        //把认证信息发到header中
        httpGet.setHeader("Authorization", "Basic "+tokenStr);



        httpGet.addHeader(HTTP.CONTENT_TYPE,"application/json");
        httpGet.addHeader("Accept", "application/json");
        httpGet.addHeader("Accept-Encoding", "UTF-8");

        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
        String result = null;
        //打印StatusLine
        logger.debug("StatusLine: " + response.getStatusLine());
        try{
            //获取实体
            HttpEntity httpEntity= response.getEntity();
            result = EntityUtils.toString(httpEntity, "UTF-8");
            logger.debug(result);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
        //关闭流并释放资源
        httpClient.close();
        return result;
    }
}
