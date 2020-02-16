package day1.time_0216_1814.JDKStaticProxyDemo;

public class Test {

    public static void main(String[] atgs) {
        ProductService productService = new ProductServiceImpl();
        StaticProxy staticProxy = new StaticProxy(productService);
        staticProxy.roll();
    }
}
