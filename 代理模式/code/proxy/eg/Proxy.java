package code.proxy.eg;

/**
 * Created by qizhou on 19-1-14.
 */

public class Proxy extends Subject {


    RealSubject realSubject;

    @Override
    public void request() {
        System.out.println("代理发出的qingqiu");
        if(realSubject == null){
            realSubject = new RealSubject();
        }
        realSubject.request();

    }
}
