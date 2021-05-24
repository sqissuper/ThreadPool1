package threadpool;

/**
 * ClassName:ThreadPool6
 * Package:threadpool
 * Description:
 *
 * @Author:HP
 * @date:2021/5/24 15:30
 */
public class ThreadPool6 {
    static ThreadLocal<String> threadLocal  = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String tName = Thread.currentThread().getName();
                threadLocal.set(tName);
                System.out.println(String.format(tName,tName));
            }
        },"线程1");
        t1.start();
    }
}
