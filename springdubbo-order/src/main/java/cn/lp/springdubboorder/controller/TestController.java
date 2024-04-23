package cn.lp.springdubboorder.controller;

import cn.lp.springdubboorder.mapper.UserMapper;
import cn.lp.springdubboorder.modal.User;
import cn.lp.springdubbouser.feign.UserFeign;
import cn.lp.springdubbouser.model.Balance;
import cn.lp.springdubbouser.service.BalanceSpringCloudService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: springbootdubbo
 * @BelongsPackage: cn.lp.springdubboorder.controller
 * @Author: lp
 * @CreateTime: 2023-04-25  11:29
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@Slf4j
public class TestController {
    @Autowired
    private UserFeign userFeign;
    @Autowired
    private UserMapper userMapper;
    @GlobalTransactional
    @GetMapping("/test/getBalanceCloud")
    public Balance getBalanceCloud(@RequestParam("id") Integer id){
        log.info("id={}",id);
        log.info("xid={}",RootContext.getXID());
        try {
            userMapper.insert(new User("111","111",12));
            Balance balance = userFeign.getBalance(id);
            return balance;
        } catch (Exception e) {
            throw new RuntimeException("调用getBalance方法失败", e);
        }
    }
}

