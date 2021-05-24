package threadpool;

import java.util.concurrent.*;

/**
 * ClassName:ThreadPool1
 * Package:threadpool
 * Description:
 *
 * @Author:HP
 * @date:2021/5/24 10:57
 */
public class ThreadPool3 {
    public static int count;
    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(0), new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                    }
                });
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
