package code;

import code.one.imp.AgencysImp;
import code.one.imp.BlindDater1;
import code.one.imp.BlindDater2;

/**
 * Created by qizhou on 19-1-7.
 */

public class Main {

    public static void main(String[] args) {

        //生成一个中介者
        AgencysImp agencysImp = new AgencysImp();

        //生成相亲对象 并且注入相亲者
        BlindDater1 blindDater1 = new BlindDater1(agencysImp);
        BlindDater2 blindDater2 = new BlindDater2(agencysImp);
        //给中介者注入相亲对象
        agencysImp.setBlindDater1(blindDater1);
        agencysImp.setBlindDater2(blindDater2);

        //之后则是可以通过相亲对象来发送消息  但是实际是通过中介者去传递
        blindDater1.ask("blindDater1 ");
        blindDater2.ask("blindDater2 ");
    }
}
