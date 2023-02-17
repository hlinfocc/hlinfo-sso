package net.hlinfo.sso.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HlinfoSsoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlinfoSsoGatewayApplication.class, args);
    }

}
