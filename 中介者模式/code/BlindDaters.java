package code;

/**
 * Created by qizhou on 19-1-7.
 */

public abstract class BlindDaters {

    /*
     * 相亲对象需要一个中介者（代理相亲平台）去告知
     */
    protected Agencys agencys;

    public void setAgencys(Agencys agencys) {
        this.agencys = agencys;
    }

    @Override
    public String toString() {
        return "BlindDaters{" +
                "agencys=" + agencys +
                '}';
    }
}
