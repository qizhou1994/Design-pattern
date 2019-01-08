package code.one;

import code.one.AbstractExpress;
import code.one.Context;

/**
 *
 * @author qizhou
 * @date 19-1-8
 */

public class TerminalExpression extends AbstractExpress {
    @Override
    public void interpret(Context context) {
        System.out.println("终端解释器");
        System.out.println("终端解释器 shuru = " + context.getInput());
    }
}
