package threadpool;

import java.util.concurrent.LinkedBlockingDeque;
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
public class ThreadPool5 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5,10,50, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));

        for (int i = 0; i < 20; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        executor.shutdownNow();

    }
}
