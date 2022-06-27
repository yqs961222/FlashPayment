package com.jesse.juc.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: Jesse Y
 * @Date: 2022-06-23 17:42
 */
@Slf4j(topic = "jes.log.Callable")
public class TestCallable {
    public static void main(String[] args) {
        MyCallable callable = new MyCallable();
        FutureTask<String> task = new FutureTask<>(callable);
        Thread thread = new Thread(task, "t1");
        thread.start();

        try {
            String s = task.get();
            log.debug("Task execute result : {}", s);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

class MyCallable implements Callable<String>{

    /**
     * 重写call方法
     * @return
     * @throws Exception
     */
    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + "--> Hello!";
    }
}
