package day1.time_0216_1814.JDKDynamicProxyDemo;

public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
        System.out.println("构造函数");
    }

    @Override
    public void sayHello() {
        System.out.println("hello");
    }

    @Override
    public void saybye() {
        System.out.println("bye");
    }
}
