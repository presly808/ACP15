package university.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggerProxy {

    private static final Logger LOGGER = Logger.getLogger(LoggerProxy.class);

    @Around("execution(public * university.service.Service.*(..))")
    public Object loggingService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        String methodName = signature.getName();
        Object[] methodArguments = proceedingJoinPoint.getArgs();

        LOGGER.info("Invoke: " + signature.toShortString());
        LOGGER.debug("Call method: " + signature.toLongString() +
                " with arguments: " + methodArguments.toString());

        try {
            Object result = proceedingJoinPoint.proceed();
            LOGGER.debug("Method: " + methodName +
                    " return object: " + result.getClass().getName());
            return result;

        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
    }

    @Around("execution(public * university.dao.crud.CRUDQuery.*(..))")
    public Object logging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        String methodName = signature.getName();
        Object[] methodArguments = proceedingJoinPoint.getArgs();

        LOGGER.debug("Call method: " + signature.toLongString() +
                " with arguments: " + methodArguments.toString());

        try {
            Object result = proceedingJoinPoint.proceed();
            LOGGER.debug("Method: " + methodName +
                    " return object: " + result.getClass().getName());
            LOGGER.trace("Method: " + methodName +
                    " return values: " + result);
            return result;

        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
    }
}
