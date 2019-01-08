package code.one;

/**
 * Created by qizhou on 19-1-8.
 */

public abstract class AbstractExpress {

    private Context context;

    /**
     * 用于解释实现的
     * @param context  用于传递解释器之外的全局信息
     */
    public abstract void interpret(Context context);


}
