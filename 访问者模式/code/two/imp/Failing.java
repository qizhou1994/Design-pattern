package code.two.imp;


import code.two.Actions;

/**
 * Created by qizhou on 19-1-9.
 */

public class Failing extends Actions {


    @Override
    public void getManConclusion(Man man) {
        System.out.println("男人"+man.getClass().getName() +" 失败 喝喝喝");
    }

    @Override
    public void getWomanConclusion(Woman woman) {
        System.out.println("女人"+woman.getClass().getName() +"失败 买买买");
    }
}
