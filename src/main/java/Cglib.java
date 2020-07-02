import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Cglib {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new LogMethodInterceptor());
        Tank tank = ((Tank) enhancer.create());
        tank.move("111111");
    }

    static class LogMethodInterceptor implements MethodInterceptor {

        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("before");
            System.out.println(obj.getClass().getSuperclass().getName());
            Object o = proxy.invokeSuper(obj, args);
            System.out.println("after");
            return o;
        }
    }

}
