package threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * ClassName:ThreadPool7
 * Package:threadpool
 * Description:
 *
 * @Author:HP
 * @date:2021/5/24 16:28
 */
public class ThreadPool7 {
    static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(new Supplier<SimpleDateFormat>() {
        @Override
        public SimpleDateFormat get() {
            System.out.println("执行方法");
            return new SimpleDateFormat("mm:ss");
        }
    });

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
        for (int i = 0; i < 1001; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Date date  =new Date();
                    myFormat(date);
                }
            });
        }
    }

    public static void myFormat(Date date) {
        String result = threadLocal.get().format(date);
        System.out.println("时间：" + date);
    }
}
