package code.two.imp;


import code.two.Actions;

/**
 * Created by qizhou on 19-1-9.
 */

public class Amativeness extends Actions {


    @Override
    public void getManConclusion(Man man) {
        System.out.println("男人"+man.getClass().getName() +" 恋爱 石乐志");
    }

    @Override
    public void getWomanConclusion(Woman woman) {
        System.out.println("女人"+woman.getClass().getName() +"恋爱 没得了");
    }
}
