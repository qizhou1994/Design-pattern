package code.one.imp;

import code.one.Person;

/**
 * Created by qizhou on 19-1-9.
 */

public class Man extends Person {
    @Override
    public void getConclusion() {
        if(action == "成功"){
            System.out.println("男人"+action+"De背后有一个伟大的妹子");
        }else if(action == "失败"){
            System.out.println("男人"+action+" 闷头喝酒 嗨啊");
        }else if(action == "恋爱"){
            System.out.println("男人"+action+" 凉凉");
        }
    }
}
