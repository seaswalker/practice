package jdk8;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 测试CompletableFuture
 * Created by skywalker on 2016/8/14.
 */
public class CompletableFutureTest {

    private static int doSomething() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 100;
    }

    public static void main(String[] args) throws Exception {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(CompletableFutureTest:: doSomething);
        Future<Integer> future = completableFuture.whenCompleteAsync((v, e) -> {
           System.out.println(v);
        });
        //java主线程的退出会导致子线程的结束
        System.in.read();
    }

}
