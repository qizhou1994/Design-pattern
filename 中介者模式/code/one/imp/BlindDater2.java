package code.one.imp;

import code.Agencys;
import code.BlindDaters;

/**
 * Created by qizhou on 19-1-7.
 */

public class BlindDater2 extends BlindDaters {
    public BlindDater2(Agencys agencys) {
        setAgencys(agencys);
    }

    public void ask(String msg) {
        agencys.ask(msg,this);
    }
}
