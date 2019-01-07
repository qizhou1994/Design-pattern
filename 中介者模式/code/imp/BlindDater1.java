package code.imp;

import code.Agencys;
import code.BlindDaters;

/**
 * Created by qizhou on 19-1-7.
 */

public class BlindDater1 extends BlindDaters {

    public BlindDater1(Agencys agencys) {
        setAgencys(agencys);
    }

    public void ask(String msg) {
        agencys.ask(msg,this);
    }
}
