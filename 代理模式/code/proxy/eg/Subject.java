package code.proxy.eg;

/**
 * Created by qizhou on 19-1-14.
 * 定义 RealSubject 和Proxy的共用接口这样
 * 使用RealSubject的地方就可以使用Proxy
 */

public abstract class Subject {

    public abstract void request();

}
