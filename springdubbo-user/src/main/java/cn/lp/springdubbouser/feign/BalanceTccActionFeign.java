package cn.lp.springdubbouser.feign;

import cn.lp.springdubbouser.service.BalanceTccAction;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @BelongsProject: springcloud-seata
 * @BelongsPackage: cn.lp.springdubbouser.feign
 * @Author: lp
 * @CreateTime: 2024-07-16  15:22
 * @Description: TODO
 * @Version: 1.0
 */
@FeignClient(name = "springdubbouser",contextId = "BalanceTccActionFeign")
public interface BalanceTccActionFeign extends BalanceTccAction {
}
