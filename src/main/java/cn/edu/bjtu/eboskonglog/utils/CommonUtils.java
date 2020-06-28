package cn.edu.bjtu.eboskonglog.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import eu.bitwalker.useragentutils.UserAgent;

import java.util.Date;

/**
 * @author chancey
 * @create 2020-06-19 22:02
 */
public class CommonUtils {
    public static JSONObject JSONparse(String jsonLog) {
        System.out.println(jsonLog);
        JSONObject jsonObject = JSON.parseObject(jsonLog);
//        System.out.println(jsonObject);
        String user_agent = jsonObject.getJSONObject("request").getJSONObject("headers").getString("user-agent");
        String method = jsonObject.getJSONObject("request").getString("method");
        String requestUrl = jsonObject.getJSONObject("request").getString("url");
        String targetIP = jsonObject.getJSONArray("tries").getJSONObject(0).getString("ip");
        Integer targetPort = jsonObject.getJSONArray("tries").getJSONObject(0).getInteger("port");
        String routeName = jsonObject.getJSONObject("route").getString("name");
        String serviceName = jsonObject.getJSONObject("service").getString("name");
        Integer status = jsonObject.getJSONObject("response").getInteger("status");
        String username = jsonObject.getJSONObject("consumer") == null ? "" : jsonObject.getJSONObject("consumer").getString("username");
        String client_ip = jsonObject.getString("client_ip");
        Long createdAt = jsonObject.getLong("started_at");
        Date created_date = new Date(createdAt);
        String upstream_uri = jsonObject.getString("upstream_uri");
        UserAgent userAgent = UserAgent.parseUserAgentString(user_agent);
        String osName = userAgent.getOperatingSystem().getName();
        String browserName = userAgent.getBrowser().getName();
        if (userAgent.toString().contains("UNKNOWN")){
            osName = user_agent;
            browserName = user_agent;
        }
        JSONObject logJSON = new JSONObject();
        logJSON.put("clientIp", client_ip);
        logJSON.put("consumer", username);
        logJSON.put("service", serviceName);
        logJSON.put("route", routeName);
        logJSON.put("requestUrl", requestUrl);
        logJSON.put("method", method);
        logJSON.put("status", status);
        logJSON.put("targetIp", targetIP);
        logJSON.put("targetPort", targetPort);
        logJSON.put("userAgent", browserName);
        logJSON.put("osName", osName);
        logJSON.put("upstreamUri", upstream_uri);
        logJSON.put("createdAt", created_date);
        return logJSON;
    }
}
