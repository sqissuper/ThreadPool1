package threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:ThreadPool9
 * Package:threadpool
 * Description:
 *
 * @Author:HP
 * @date:2021/5/24 17:07
 */
public class ThreadPool10 {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(1000));
        for (int i = 0; i < 2; i++) {
            MyTask t = new MyTask();
            executor.execute(t);
        }

    }

    static class MyTask extends Thread{
        static boolean fir = true;

        @Override
        public void run() {
            if(fir) {
                threadLocal.set(this.getName());
                fir = false;
            }
            try {
                String result = threadLocal.get();
                System.out.println(this.getName() +
                        "：" + result);
            } finally {
                threadLocal.remove();
            }
        }
    }
}
