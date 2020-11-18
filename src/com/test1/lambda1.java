package com.test1;

public class lambda1 {

    //静态内部类
    static class Like1 implements ILike{

        @Override
        public void lambda() {
            System.out.println("i like lambda1");
        }
    }
    public static void main(String[] args) {
        ILike iLike=new Like();
        iLike.lambda();
        iLike=new Like1();
        iLike.lambda();
        class Like2 implements ILike{

            @Override
            public void lambda() {
                System.out.println("i like lambda2");
            }
        }
        iLike=new Like2();
        iLike.lambda();


        //匿名内部类
        iLike=new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        };
        iLike.lambda();

        //lambda表达式
        iLike=()->{
            System.out.println("i like lambda4");
        };
        iLike.lambda();
    }
}
//定义一个函数式接口
interface ILike{
    void lambda();
}
//实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}
