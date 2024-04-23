package cn.lp.springdubbouser.feign;

import cn.lp.springdubbouser.model.Balance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @BelongsProject: springbootdubbo
 * @BelongsPackage: cn.lp.springdubbouser.feign
 * @Author: lp
 * @CreateTime: 2023-04-27  15:44
 * @Description: TODO
 * @Version: 1.0
 */
@FeignClient(name = "springdubbouser",contextId = "UserFeign")
public interface UserFeign {
    @GetMapping("/test/getBalance")
    Balance getBalance(@RequestParam("id")  Integer id);
}
