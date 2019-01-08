package code.music;


/**
 * Created by qizhou on 19-1-8.
 */

public abstract class MusicExpression {

    /**
     * 演奏
     * @param context
     */
    public void interpret(PlayContext context){
        System.out.println("演奏的内容是： "+ context.getPlayStr());
        if(context == null || context.getPlayStr() == null ){
            return;
        }
        String value = context.getPlayStr();
        excute(value);
    }

    /**
     * 执行
     * @param value
     *
     */
    public abstract void excute(String value);




}
