package threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:ThreadPool1
 * Package:threadpool
 * Description:
 *
 * @Author:HP
 * @date:2021/5/24 10:57
 */
public class ThreadPool2 {
    public static int count;
    public static void main(String[] args) {
        ThreadFactory factory  =new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("线程池" + count++);
                return t;
            }
        };
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5,10,50, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000),factory);
        for (int i = 0; i < 11; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

    }
}
