package cn.edu.bjtu.eboskonglog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sun.management.resources.agent;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chancey
 * @create 2020-06-17 21:10
 */
@Entity
@Table(name = "log")
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    @Column(name = "client_ip",length = 20)//这是和数据表对应的一个列
    private String clientIp;

    @Column //省略默认列名就是属性名
    private String consumer;

    @Column
    private String service;

    @Column
    private String route;

    @Column(name = "request_url",length = 150)//这是和数据表对应的一个列
    private String requestUrl;

    @Column
    private String method;

    @Column
    private Integer status;

    @Column(name = "target_ip",length = 20)
    private String targetIp;

    @Column(name = "target_port",length = 10)
    private Integer targetPort;

    @Column(name = "user_agent")
    private String userAgent;

    @Column
    private String osName;

    @Column(name = "upstream_uri",length = 100)
    private String upstreamUri;

    @Column(name = "created_at")
    private Date createdAt;

    @Column()
    private String category;

    @JsonIgnore
    @Column(name = "category_en")
    private String categoryEn;

    public String getCategoryEn() {
        return categoryEn;
    }

    public void setCategoryEn(String categoryEn) {
        this.categoryEn = categoryEn;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTargetIp() {
        return targetIp;
    }

    public void setTargetIp(String targetIp) {
        this.targetIp = targetIp;
    }

    public Integer getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(Integer targetPort) {
        this.targetPort = targetPort;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUpstreamUri() {
        return upstreamUri;
    }

    public void setUpstreamUri(String upstreamUri) {
        this.upstreamUri = upstreamUri;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", clientIp='" + clientIp + '\'' +
                ", consumer='" + consumer + '\'' +
                ", service='" + service + '\'' +
                ", route='" + route + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", method='" + method + '\'' +
                ", status=" + status +
                ", targetIp='" + targetIp + '\'' +
                ", targetPort=" + targetPort +
                ", userAgent='" + userAgent + '\'' +
                ", osName='" + osName + '\'' +
                ", upstreamUri='" + upstreamUri + '\'' +
                ", createdAt=" + createdAt +
                ", category='" + category + '\'' +
                ", categoryEn='" + categoryEn + '\'' +
                '}';
    }
}
