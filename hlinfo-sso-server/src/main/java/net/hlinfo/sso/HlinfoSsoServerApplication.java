package net.hlinfo.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration(exclude = {
SecurityAutoConfiguration.class
})

//@EnableAspectJAutoProxy(proxyTargetClass=true)
public class HlinfoSsoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HlinfoSsoServerApplication.class, args);
	}
}
