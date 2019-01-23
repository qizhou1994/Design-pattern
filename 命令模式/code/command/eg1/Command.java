package code.command.eg1;

/**
 * Created by qizhou on 19-1-23.
 * 用来什么执行操作的接口
 */

public abstract class Command {

    protected Receiver receiver;

    public Command(Receiver receiver){
        this.receiver = receiver;
    }

    public abstract void excute();


}
