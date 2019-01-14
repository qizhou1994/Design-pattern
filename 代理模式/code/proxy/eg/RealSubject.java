package code.proxy.eg;

/**
 * Created by qizhou on 19-1-14.
 */

public class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.println("真实打算的请求");
    }
}
