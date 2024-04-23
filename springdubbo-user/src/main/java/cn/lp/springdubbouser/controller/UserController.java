package cn.lp.springdubbouser.controller;

import cn.lp.springdubbouser.model.Balance;
import cn.lp.springdubbouser.service.BalanceSpringCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: springbootdubbo
 * @BelongsPackage: cn.lp.springdubbouser.controller
 * @Author: lp
 * @CreateTime: 2023-04-24  16:09
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
public class UserController{

    @Autowired
    private BalanceSpringCloudService balanceSpringCloudService;

    @GetMapping("/test/getBalance")
    public Balance getBalance(@RequestParam("id")  Integer id) {
        Balance balance = balanceSpringCloudService.getBalance(id);
        return balance;
    }


}
