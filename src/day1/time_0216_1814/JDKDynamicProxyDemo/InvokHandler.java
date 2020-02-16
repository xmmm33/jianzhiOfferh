package day1.time_0216_1814.JDKDynamicProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvokHandler implements InvocationHandler {
    private Object object;

    InvokHandler(Object o) {
        object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前、、、、、、、");
        Object ret = method.invoke(object, args);
        return ret;
    }
}
