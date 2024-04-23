package cn.lp.springdubbouser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @BelongsProject: springbootdubbo
 * @BelongsPackage: cn.lp.springdubbouser.model
 * @Author: lp
 * @CreateTime: 2023-04-24  17:27
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Balance implements Serializable {
    private int id;
    private int diamond;
    private int ticket;
    private String message;

    public Balance(int id, int diamond, int ticket) {
        this.id = id;
        this.diamond = diamond;
        this.ticket = ticket;
    }
}
