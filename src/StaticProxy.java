//真实对象和代理对象实现同一个接口
//代理对象可以做很多真实对象做不了的事情
//真实对象专注做自己的事情
public class StaticProxy {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("什么鬼")).start();
        WeddingCompany weddingCompany=new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}
interface Marry{
    void HappyMarry();
}
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("结婚");
    }
}
//代理角色
class WeddingCompany implements Marry{
    //代理真实对象
    private Marry target;
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }
    public WeddingCompany(Marry target){
        this.target=target;
    }
    private void before(){
        System.out.println("结2婚之前");
    }
    private void after(){
        System.out.println("结婚之后");
    }
}
