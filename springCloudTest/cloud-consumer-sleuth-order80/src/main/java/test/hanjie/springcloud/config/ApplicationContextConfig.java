package test.hanjie.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 10568 on 2020/10/16.
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
//    @LoadBalanced //负载均衡功能
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
