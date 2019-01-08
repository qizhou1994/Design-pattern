package code.one.imp;

import   code.Agencys;
import   code.BlindDaters;

/**
 * Created by qizhou on 19-1-7.
 * 代理者 类似媒人
 */

public class AgencysImp extends Agencys{

    /*
     * 该中介者关联的相亲对象
     */
    private BlindDater1 blindDater1;
    private BlindDater2 blindDater2;

    public void setBlindDater1(BlindDater1 blindDater1) {
        this.blindDater1 = blindDater1;
    }

    public void setBlindDater2(BlindDater2 blindDater2) {
        this.blindDater2 = blindDater2;
    }

    /*
      分辨出是哪一个相亲对象提的要求，然后打印出来
     */
    @Override
    public void ask(String msg, BlindDaters blindDaters) {


        if(blindDater1!=null && blindDaters.equals(blindDater1)){
            System.out.println("msg = "+ msg + ",相亲者 blindDater1= " + blindDaters);
        }else if(blindDater2!=null && blindDaters.equals(blindDater2)){
            System.out.println("msg = "+ msg + ",相亲者 blindDater2= " + blindDaters);
        }else {
            System.out.println("没有预约好 通知的相亲者");
        }

    }
}
