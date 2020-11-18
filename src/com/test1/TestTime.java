package com.test1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTime {
    public static void timeout() throws InterruptedException {
        int num=10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num<=0) {
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Date date=new Date(System.currentTimeMillis());
        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            date=new Date(System.currentTimeMillis());
        }

    }
}
