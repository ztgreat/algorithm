package com.github.ztgreat.concurrent.p1;


/**
 * 奇偶 交替打印
 *
 * wait & notify
 *
 */
class Solution2 {

    private static Object object = new Object();

    private static volatile int i = 1;

    public static void main(String[] args) throws InterruptedException {


        new Thread(() -> {

            while (true) {
                synchronized (object) {
                    if (i % 2 == 1 && i <= 100) {
                        System.out.println(i++);
                        try {

                            object.notify();
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (i < 100) {
                            break;
                        }
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (object) {
                    if (i % 2 == 0 && i <= 100) {
                        System.out.println(i++);
                        try {
                            object.notify();
                            object.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }

}