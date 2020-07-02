import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkReflect {

    public static void main(String[] args) {
        Tank tank = new Tank();

        //reflection 通过二进制字节码分析类的属性和方法
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        Moveable m = (Moveable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Moveable.class}, new LogHandler(tank));
        m.move("222222");
    }

    static class LogHandler implements InvocationHandler {

        Tank tank;

        public LogHandler(Tank tank) {
            this.tank = tank;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(method.getName() + "   start...");
            System.out.println("方法中的参数：" + args[0]);
            args[0] = "被改变了";
            Object o = method.invoke(tank, args);
            System.out.println(method.getName() + "   end...");
            return o;
        }
    }

}
