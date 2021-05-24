package threadpool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * ClassName:ThreadPool1
 * Package:threadpool
 * Description:
 *
 * @Author:HP
 * @date:2021/5/24 10:57
 */
public class ThreadPool4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(5));
        Future<Object> future = executor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                //生成随机值
                int num = new Random().nextInt(10);
                System.out.println("生成随机数" + num);
                //返回参数
                return num;
            }
        });
        System.out.println(future.get());

    }
}
