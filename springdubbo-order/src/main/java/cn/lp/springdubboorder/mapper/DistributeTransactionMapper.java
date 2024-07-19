package cn.lp.springdubboorder.mapper;

import cn.lp.springdubboorder.modal.DistributeTransaction;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @BelongsProject: springcloud-seata
 * @BelongsPackage: cn.lp.springdubboorder.mapper
 * @Author: lp
 * @CreateTime: 2024-07-16  18:21
 * @Description: TODO
 * @Version: 1.0
 */
public interface DistributeTransactionMapper  extends Mapper<DistributeTransaction>, MySqlMapper<DistributeTransaction> {
}
