package interview.singleton;

/**
 * Author: JohnZeng
 * Date: 2023/9/20 14:03
 * Description: 添加单例的构建方法：懒汉 -- 即调用时再进行生成；饿汉 -- 即类生成时就加载(内部资源流失，未使用就占空间了)
 * History:
 * <author> <time> <version> <desc>
 * JohnZeng 2023/9/20 1.0 首次创建
 */
public final class SingletonUtil {
    public static final SingletonUtil INSTANCE = new SingletonUtil();

    private static volatile SingletonUtil instance;

    private SingletonUtil() {
        // empty
    }

    // 饿汉式
    public static final SingletonUtil INSTANCE_1 = new SingletonUtil();

    // 懒汉式
    public static SingletonUtil getInstance() {
        return INSTANCE;
    }

    // 懒汉式 线程安全

    /**
     * synchronized ： 作为关键字，是原生本体就支持的一套机制，由JVM完成的语法级别的线程同步 --- 使用monitor进行数据监视
     * lock： 由后续API完成的，基于锁概念，引申出的AQS机制锁，本身实现其实是一套外部类拓展，维护对应的队列完成线程的同步
     */
    public static synchronized SingletonUtil getInstance_1() {
        return INSTANCE;
    }

    // 懒汉式 线程安全 双重校验
    public static SingletonUtil getInstance_2() {
        if (instance == null) {
            synchronized (SingletonUtil.class) {
                if (instance == null) {
                    instance = new SingletonUtil();
                }
            }
        }
        return instance;
    }

    // 懒汉式 线程安全 双重校验  volatile 防止指令重排序
    public static SingletonUtil getInstance_3() {
        if (instance == null) {
            synchronized (SingletonUtil.class) {
                if (instance == null) {
                    instance = new SingletonUtil();
                }
            }
        }
        return instance;
    }

    // 静态内部类 线程安全
    public static SingletonUtil getInstance_4() {
        return SingletonHolder.INSTANCE;
    }

    public static class SingletonHolder {
        public static final SingletonUtil INSTANCE = new SingletonUtil();
    }
}
