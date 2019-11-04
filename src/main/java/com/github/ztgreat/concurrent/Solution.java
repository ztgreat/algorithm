package com.github.ztgreat.concurrent;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 奇偶交替打印
 * Condition 实现
 */
class Solution {


    private static volatile int i = 1;

    public static void main(String[] args) throws InterruptedException {


        Lock lock = new ReentrantLock();

        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                lock.lock();
                while (i < 100) {
                    try {
                        condition1.await();
                        System.out.println(i++);
                        condition2.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {

                    }
                }
                lock.unlock();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                lock.lock();
                while (i <= 100) {
                    try {
                        condition2.await();
                        System.out.println(i++);
                        condition1.signal();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {

                    }
                }
                lock.unlock();

            }
        });

        t2.start();
        Thread.sleep(1000);
        t1.start();
        Thread.sleep(1000);
        lock.lock();
        condition1.signal();
        lock.unlock();

    }


}