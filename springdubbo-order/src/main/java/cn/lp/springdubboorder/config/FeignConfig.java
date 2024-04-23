package cn.lp.springdubboorder.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients({"cn.lp.springdubbouser.feign"})
public class FeignConfig {

}
