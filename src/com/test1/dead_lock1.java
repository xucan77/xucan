package com.test1;

class dead_lock1 {
    public static void main(String[] args) {
        dead_lock1();
    }
    private static void dead_lock1(){
        //两个资源
        final Object resources1="resources1";
        final Object resources2="resources2";
        Thread thread1=new Thread(){
            public void run(){
                //占有资源1
                synchronized (resources1){
                    System.out.println("thread1 locked resources1");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //想继续占有资源2
                    synchronized (resources2){
                        System.out.println("thread1 locked resources2");
                    }
                }

            }
        };
        Thread thread2=new Thread(){
            public void run(){
                synchronized (resources2){
                    System.out.println("thread2 locked resources2");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resources1){
                        System.out.println("thread2 locked resources1");
                    }
                }

            }

        };
        thread1.start();
        thread2.start();
    }
}
/*
class DeadLock {

    public static void main(String[] args) {
        dead_lock();
    }

    private static void dead_lock() {
// 两个资源
        final Object resource1 = "resource1";
        final Object resource2 = "resource2";
// 第一个线程，想先占有resource1,再尝试着占有resource2
        Thread t1 = new Thread() {
            public void run() {
// 尝试占有resource1
                synchronized (resource1) {
// 成功占有resource1
                    System.out.println("Thread1 1:locked resource1");
// 休眠一段时间
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
// 尝试占有resource2，如果不能占有，该线程会一直等到
                    synchronized (resource2) {
                        System.out.println("Thread1 1:locked resource2");
                    }
                }
            }
        };
// 第二个线程，想先占有resource2，再占有resource1
        Thread t2 = new Thread() {
            public void run() {
// 尝试占有resource2
                synchronized (resource2) {
// 成功占有resource2
                    System.out.println("Thread 2 :locked resource2");
// 休眠一段时间
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
// 尝试占有resource1，如果不能占有，该线程会一直等到
                    synchronized (resource1) {
                        System.out.println("Thread1 2:locked resource1");
                    }
                }
            }
        };

// 启动线程
        t1.start();
        t2.start();
    }
}*/
