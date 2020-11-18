package com.test1;

public class TestJoin {
}
class MyJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("vip"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyJoin myJoin=new MyJoin();
        Thread thread=new Thread(myJoin);
        thread.start();
        for (int i = 0; i < 500; i++) {
            if (i==200){
                thread.join();
            }
            System.out.println("主线程"+i);
        }

    }
}