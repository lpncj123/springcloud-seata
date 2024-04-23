package cn.lp.springdubboorder.aspect;

import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * @BelongsProject: springbootdubbo
 * @BelongsPackage: cn.lp.springdubboorder.aspect
 * @Author: lp
 * @CreateTime: 2023-04-27  11:03
 * @Description: TODO
 * @Version: 1.0
 */
@Aspect
@Component
@Slf4j
public class SeataTransactionAspect {

    @Before("execution(* cn.lp.*.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        String xid = RootContext.getXID();
        if (StringUtils.hasText(xid)) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            log.info("分布式事务开启: xid={}, method={}", xid, method.getDeclaringClass() + "." + method.getName());
        }
    }
    @AfterThrowing(throwing = "e", pointcut = "execution(* cn.lp.*.controller.*.*(..))")
    public void doRecoveryActions(Throwable e) throws TransactionException {
        String xid = RootContext.getXID();
        if (StringUtils.hasText(xid)) {
            log.info("分布式事务方法执行异常,进行事务回滚,xid={}, e={}", xid, e.getMessage());
            GlobalTransactionContext.reload(xid).rollback();
        }
    }
}

