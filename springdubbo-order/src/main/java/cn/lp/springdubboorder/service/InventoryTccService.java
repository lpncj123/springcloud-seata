package cn.lp.springdubboorder.service;

/**
 * @BelongsProject: springcloud-seata
 * @BelongsPackage: cn.lp.springdubboorder.service
 * @Author: lp
 * @CreateTime: 2024-07-16  14:42
 * @Description: TODO
 * @Version: 1.0
 */
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
@LocalTCC
public interface InventoryTccService {

    @TwoPhaseBusinessAction(name = "inventoryTccAction", commitMethod = "commit", rollbackMethod = "rollback")
    boolean prepare(BusinessActionContext actionContext,
                    @BusinessActionContextParameter(paramName = "productId") String productId,
                    @BusinessActionContextParameter(paramName = "count") int count);

    boolean commit(BusinessActionContext actionContext);

    boolean rollback(BusinessActionContext actionContext);
}
