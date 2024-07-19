package cn.lp.springdubbouser.service.impl;

import cn.lp.springdubbouser.model.Balance;
import cn.lp.springdubbouser.service.BalanceTccAction;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: springcloud-seata
 * @BelongsPackage: cn.lp.springdubbouser.service.impl
 * @Author: lp
 * @CreateTime: 2024-07-16  14:56
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
@Service
public class BalanceTccActionImpl implements BalanceTccAction {
    private Map<Integer, Balance> balanceMap = new HashMap<>();

    @Override
    public boolean prepare(BusinessActionContext actionContext, Integer id) {
        log.info("TCC prepare, id={}", id);
        if(id==1){
            return false;
        }
        // Try 阶段逻辑
        return true;
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        Integer id = (Integer) actionContext.getActionContext("id");
        log.info("TCC commit, id={}", id);
        // Confirm 阶段逻辑
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        Integer id = (Integer) actionContext.getActionContext("id");
        log.info("TCC rollback, id={}", id);
        // Cancel 阶段逻辑
        return true;
    }

    @Override
    public Balance getBalance(Integer id) {
        // 原有的业务逻辑
        if (id != null && balanceMap.containsKey(id)) {
            return balanceMap.get(id);
        }
        return new Balance(0, 0, 0, "不存在");
    }
}
