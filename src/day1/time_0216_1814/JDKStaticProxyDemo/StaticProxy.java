package day1.time_0216_1814.JDKStaticProxyDemo;

public class StaticProxy implements ProductService {

    private ProductService productService;

    StaticProxy(ProductService productService){
        this.productService = productService;
    }

    @Override
    public void roll() {
        System.out.println("静态代理前");
        productService.roll();
    }
}
