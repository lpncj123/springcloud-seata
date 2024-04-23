package cn.lp.springdubbouser.service;

import cn.lp.springdubbouser.model.Balance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @BelongsProject: springbootdubbo
 * @BelongsPackage: cn.lp.springdubbouser.dubbo.service
 * @Author: lp
 * @CreateTime: 2023-04-24  17:29
 * @Description: TODO
 * @Version: 1.0
 */
//@FeignClient(name = "springdubbouser",contextId = "BalanceSpringCloudService")
public interface BalanceSpringCloudService {
    Balance getBalance(Integer id);
}
