package cn.lp.springdubboorder.service.impl;

import cn.lp.springdubboorder.mapper.DistributeTransactionMapper;
import cn.lp.springdubboorder.mapper.UserMapper;
import cn.lp.springdubboorder.modal.DistributeTransaction;
import cn.lp.springdubboorder.modal.User;
import cn.lp.springdubboorder.service.InventoryTccService;
import cn.lp.springdubbouser.feign.UserFeign;
import cn.lp.springdubbouser.model.Balance;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: springcloud-seata
 * @BelongsPackage: cn.lp.springdubboorder.service.impl
 * @Author: lp
 * @CreateTime: 2024-07-16  14:46
 * @Description: TODO
 * @Version: 1.0
 */
@Service
@Slf4j
public class InventoryTccServiceImpl implements InventoryTccService {
    @Autowired
    private UserFeign userFeign;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DistributeTransactionMapper distributeTransactionMapper;
    @Override
    public boolean prepare(BusinessActionContext actionContext, String productId, int count) {
//        事务悬挂解决
        DistributeTransaction distributeTransaction = distributeTransactionMapper.selectOne(new DistributeTransaction(actionContext.getXid()));
        if(distributeTransaction!=null&&distributeTransaction.getState()==2){
            return false;
        }
        Balance balance = userFeign.getBalance(count);
        log.info("balance:{}",balance);
        if(balance.getId()!=0){
            userMapper.insert(new User("111", "111", 12));
            return true;
        }
        return false;
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        String productId = actionContext.getActionContext("productId").toString();
        int count = (int) actionContext.getActionContext("count");
        String xid = actionContext.getXid();
        // 确认扣减库存逻辑
        log.info("Confirm to deduct inventory for product:{} , count:{} ",productId,count);
        // 模拟确认成功
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        DistributeTransaction distributeTransaction = distributeTransactionMapper.selectOne(new DistributeTransaction(actionContext.getXid()));
//        空回滚解决
        if(distributeTransaction==null){
            distributeTransactionMapper.insert(new DistributeTransaction(actionContext.getXid(),2));
            return false;
        }
        String productId = actionContext.getActionContext("productId").toString();
        int count = (int) actionContext.getActionContext("count");
        // 取消预留库存逻辑
        log.info("Cancel to reserve inventory product:{} , count:{}",productId,count);
        // 模拟取消成功
        return true;
    }
}
