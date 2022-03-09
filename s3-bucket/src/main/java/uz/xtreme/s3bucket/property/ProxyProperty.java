package uz.xtreme.s3bucket.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: Rustambekov Avazbek
 * Date: 07/07/2020
 * Time: 16:15
 */

@ConfigurationProperties(prefix = "system.proxy")
public class ProxyProperty {

    private String host;

    private int port;

    public ProxyProperty() {
    }

    public ProxyProperty(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
