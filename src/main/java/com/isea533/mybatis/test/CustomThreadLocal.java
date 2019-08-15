package com.isea533.mybatis.test;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomThreadLocal {
    static TransmittableThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                CustomThreadLocal.threadLocal.set("猿天地");
                new Service().call();
            }
        }).start();
    }
}
class Service {

    static ExecutorService es = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(2));
    public void call() {
//        System.out.println("Service:" + Thread.currentThread().getName());
//        System.out.println("Service:" + CustomThreadLocal.threadLocal.get());
        for (int i = 0; i < 10; i++) {
            CustomThreadLocal.threadLocal.set("哈哈哈======" + i);
            es.submit(new Runnable() {
                @Override
                public void run() {
                    new Dao().call();
                }
            });
        }
    }
}
class Dao {
    public void call() {
//        System.out.println("==========================");
        System.out.println("Dao:" + Thread.currentThread().getName());
        System.out.println("Dao:" + CustomThreadLocal.threadLocal.get());
    }
}