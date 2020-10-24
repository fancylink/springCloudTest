package test.hanjie.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "线程："+Thread.currentThread().getName()+"paymentInfo_OK"+id+"\t";
    }

    //服务降级
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeout = 5000;
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程："+Thread.currentThread().getName()+"paymentInfo_TimeOut"+id+"\t"+"耗时(s)："+timeout;
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程："+Thread.currentThread().getName()+"paymentInfo_TimeOutHandler"+id+"\t";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id <0){
            throw new RuntimeException("不能为负数");
        }
        //UUID.randomUUID().toString()==IdUtil.simpleUUID()
        //用于生成一个非负的流水号，唯一
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数,请稍后再试";
    }
}
