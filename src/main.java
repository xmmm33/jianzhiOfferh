import practice.p1;

import java.lang.reflect.*;
import java.util.Arrays;

public class main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            Class a = Class.forName("practice.p1");
            Constructor ac = a.getConstructor();
            Method method = a.getDeclaredMethod("te");
            p1 p1 = (practice.p1) ac.newInstance();
            method.setAccessible(true);
            method.invoke(p1);
            System.out.println(p1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class inter implements InvocationHandler {


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }


}
