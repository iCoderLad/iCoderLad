package com.example.demo.multithreading;

import com.example.demo.multithreading.async.CommonExecutor;
import com.example.demo.multithreading.async.CommonExecutorAsync;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.StopWatch;

import java.util.concurrent.CompletableFuture;

/**
 * @author codeeasily
 * @date 2022/08/02 10:06
 */
@SpringBootTest
@EnableAsync
public class MultiThreadTest {
    @Autowired
    private CommonExecutorAsync commonExecutorAsync;

    @Autowired
    private CommonExecutor commonExecutor;

    @Test
    public void testSync() {
        StopWatch stopwatch = new StopWatch("同步执行");
        stopwatch.start();
        commonExecutor.doTaskOne();
        commonExecutor.doTaskTwo();
        commonExecutor.doTaskThree();
        stopwatch.stop();
        System.out.println("同步执行 总耗时(ms)：" + stopwatch.getTotalTimeMillis());

    }


    @Test
    public void testExecutorAsync() {
        StopWatch stopwatch = new StopWatch("异步执行");
        stopwatch.start();
        CompletableFuture<String> aFuture = commonExecutorAsync.doTaskOne();
        CompletableFuture<String> bFuture = commonExecutorAsync.doTaskTwo();
        CompletableFuture<String> cFuture = commonExecutorAsync.doTaskThree();
        CompletableFuture.allOf(aFuture, bFuture, cFuture).join();
        stopwatch.stop();
        System.out.println("异步执行 总耗时(ms)：" + stopwatch.getTotalTimeMillis());

    }


}
