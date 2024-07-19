package cn.lp.springdubbouser.service;

/**
 * @BelongsProject: springcloud-seata
 * @BelongsPackage: cn.lp.springdubbouser.service
 * @Author: lp
 * @CreateTime: 2024-07-16  14:55
 * @Description: TODO
 * @Version: 1.0
 */
import cn.lp.springdubbouser.model.Balance;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import io.seata.rm.tcc.api.BusinessActionContextParameter;


public interface BalanceTccAction {

    @TwoPhaseBusinessAction(name = "prepare", commitMethod = "commit", rollbackMethod = "rollback")
    boolean prepare(BusinessActionContext actionContext, @BusinessActionContextParameter(paramName = "id") Integer id);

    boolean commit(BusinessActionContext actionContext);

    boolean rollback(BusinessActionContext actionContext);

    Balance getBalance(Integer id);
}

