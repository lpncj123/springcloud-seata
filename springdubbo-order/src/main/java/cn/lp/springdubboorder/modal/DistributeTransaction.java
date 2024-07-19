package cn.lp.springdubboorder.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: springcloud-seata
 * @BelongsPackage: cn.lp.springdubboorder.modal
 * @Author: lp
 * @CreateTime: 2024-07-16  18:20
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistributeTransaction {
    private String txId;

    public DistributeTransaction(String txId) {
        this.txId = txId;
    }

    private Integer state;
}
