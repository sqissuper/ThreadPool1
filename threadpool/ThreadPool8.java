package threadpool;

/**
 * ClassName:ThreadPool8
 * Package:threadpool
 * Description:
 *
 * @Author:HP
 * @date:2021/5/24 16:58
 */
public class ThreadPool8 {
    static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("Java");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String result = threadLocal.get();
                System.out.println(result);
            }
        });
        t1.start();
    }
}
