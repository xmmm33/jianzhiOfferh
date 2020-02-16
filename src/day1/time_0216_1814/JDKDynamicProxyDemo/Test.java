package day1.time_0216_1814.JDKDynamicProxyDemo;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        InvokHandler i = new InvokHandler(userService);
        ClassLoader loader = userService.getClass().getClassLoader();
        Class[] interfaces = userService.getClass().getInterfaces();
        UserService proxy = (UserService) Proxy.newProxyInstance(loader, interfaces, i);
        proxy.sayHello();
    }
}
