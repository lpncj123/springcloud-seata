package cn.lp.springdubboorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @BelongsProject: springbootdubbo
 * @BelongsPackage: cn.lp.springdubboorder
 * @Author: lp
 * @CreateTime: 2023-04-25  11:23
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("cn.lp.springdubboorder.mapper")
public class SpringDubboOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDubboOrderApplication.class,args);
    }
}
