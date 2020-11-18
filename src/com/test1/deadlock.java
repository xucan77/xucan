package com.test1;

class Test {
    public void recursive(){
        this.businessLogic();
    }
    public synchronized void businessLogic(){
        System.out.println("处理业务逻辑");
        System.out.println("保存到");
        this.recursive();
    }
}
