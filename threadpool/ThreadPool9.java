package threadpool;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

/**
 * ClassName:ThreadPool9
 * Package:threadpool
 * Description:
 *
 * @Author:HP
 * @date:2021/5/24 17:07
 */
public class ThreadPool9 {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        MyTask task1 = new MyTask();
        task1.start();

        MyTask task2 = new MyTask();
        task2.start();
    }

    static class MyTask extends Thread{
        static boolean fir = true;

        @Override
        public void run() {
            if(fir) {
                threadLocal.set(this.getName());
                fir = false;
            }

            String result = threadLocal.get();
            System.out.println(this.getName() +
                    "：" + result);
        }
    }
}
