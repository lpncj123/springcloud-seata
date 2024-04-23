package cn.lp.springdubbouser.service.impl;

import cn.lp.springdubbouser.model.Balance;
import cn.lp.springdubbouser.service.BalanceSpringCloudService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: springbootdubbo
 * @BelongsPackage: cn.lp.springdubbouser.dubbo.service.impl
 * @Author: lp
 * @CreateTime: 2023-04-24  17:29
 * @Description: TODO
 * @Version: 1.0
 */

@Service
@Slf4j
public class BalanceSpringCloudServiceImpl implements BalanceSpringCloudService {
    final static Map<Integer, Balance> balanceMap = new HashMap() {{
        put(1, new Balance(1, 10, 1000));
        put(2, new Balance(2, 0, 10000));
        put(3, new Balance(3, 100, 0));
    }
    };
    @GlobalTransactional
    @Override
    public Balance getBalance(Integer id) {
        log.info("id={}",id);
        try {
            if(id != null && balanceMap.containsKey(id)) {
                if(id.equals(1)){
                    int i = 1/0;
                }
                return balanceMap.get(id);
            }
        } catch (Exception e) {
            throw new RuntimeException("调用getBalance方法失败", e);
        }


        return new Balance(0, 0, 0, "不存在");
    }


}
