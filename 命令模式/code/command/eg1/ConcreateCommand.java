package code.command.eg1;

/**
 * Created by qizhou on 19-1-23.
 * 将一个接受者对象绑定与一个动作，调用接受者相应的操作，以实现excute
 */

public class ConcreateCommand extends Command {



    public ConcreateCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void excute() {
        if(receiver!=null){
            receiver.action();
        }
    }
}
