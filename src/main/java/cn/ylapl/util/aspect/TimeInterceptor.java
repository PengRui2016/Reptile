package cn.ylapl.util.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 切面时间统计
 * Created by Angle on 2017/3/8.
 */
@Aspect
@Component
public class TimeInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(TimeInterceptor.class);

    // 一分钟，即1000ms
    private static final long ONE_MINUTE = 0;

    // service层的统计耗时切面，类型必须为final String类型的,注解里要使用的变量只能是静态常量类型的
    private static final String POINT = "execution (* cn.ylapl.service.*.*(..))";

    /**
     * 统计方法执行耗时Around环绕通知
     * @param joinPoint 切点
     * @return 方法返回值
     */
    @Around(POINT)
    public Object timeAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 定义返回对象、得到方法需要的参数
        Object obj;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();

        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            logger.error("统计某方法执行耗时环绕通知出错");
            throw new Throwable(e);
        }

        // 获取执行的方法名
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();

        // 打印耗时的信息
        this.printExecTime(methodName, startTime, endTime);

        return obj;
    }

    /**
     * 打印方法执行耗时的信息，如果超过了一定的时间，才打印
     * @param methodName 方法名
     * @param startTime 开始时间
     * @param endTime 结束时间
     */
    private void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;
        if (diffTime > ONE_MINUTE) {
            logger.info("-----" + methodName + " 方法执行耗时：" + diffTime + " ms");
        }
    }
}
