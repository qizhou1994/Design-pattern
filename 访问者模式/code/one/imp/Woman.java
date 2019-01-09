package code.one.imp;

import code.one.Person;

/**
 * Created by qizhou on 19-1-9.
 */

public class Woman extends Person {
    @Override
    public void getConclusion() {
        if(action == "成功"){
            System.out.println("女人"+action+"De背后有一个凉凉汉子");
        }else if(action == "失败"){
            System.out.println("女人"+action+" 买买买");
        }else if(action == "恋爱"){
            System.out.println("女人"+action+" 石乐志");
        }
    }
}
