package com.test1;

public class lambda2 {
    public static void main(String[] args) {
        /*ILove love=new ILove() {
            @Override
            public void love(int a) {
                System.out.println("222222222"+a);
            }
        };
        love.love(3);*/
        ILove love=(int a)->{
            System.out.println("444444"+a);
        };
        love.love(5);
    }
}
interface ILove{
    void love(int a);
}
class  Love implements ILove{

    @Override
    public void love(int a) {
        System.out.println("111111111"+a);
    }
}