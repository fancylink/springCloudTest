package test.hanjie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by 10568 on 2020/10/16.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PayMainSlueth8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMainSlueth8001.class,args);
    }
}