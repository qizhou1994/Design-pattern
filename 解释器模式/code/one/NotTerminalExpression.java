package code.one;

/**
 *
 * @author qizhou
 * @date 19-1-8
 */

public class NotTerminalExpression extends AbstractExpress {
    @Override
    public void interpret(Context context) {
        System.out.println("非终端解释器");
    }
}
